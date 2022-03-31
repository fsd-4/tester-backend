package net.idrok.tester.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.CacheControl;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import net.idrok.tester.entity.Imtihon;
import net.idrok.tester.entity.Savol;
import net.idrok.tester.entity.Variant;
import net.idrok.tester.repository.VariantRepository;
import net.idrok.tester.service.SavolService;
import net.idrok.tester.service.dto.SavolDTO;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/savol")
@CrossOrigin(maxAge = 3600)
public class SavolController {
    @Autowired
    SavolService savolService;

    @Autowired
    VariantRepository variantRepo;


    @GetMapping()
    public ResponseEntity<Page<SavolDTO>> getAll(@RequestParam(name = "key", required = false) String key, Pageable pageable) {
        if(key == null) key = "";
            
        return ResponseEntity.ok(savolService.getAll(key, pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Savol> getById(@PathVariable Long id) {
        return ResponseEntity.ok(savolService.getById(id));
    }

    @GetMapping("/{id}/download")
    public ResponseEntity<ByteArrayResource> getSavolFayl(@PathVariable Long id) throws IOException{
        Savol s = savolService.getById(id);
        byte[] rasm = s.getRasm();
        if(rasm == null){
            return ResponseEntity.notFound().build();
        }
        InputStream is = new ByteArrayInputStream(rasm);
        String mimeType = URLConnection.guessContentTypeFromStream(is);
        if(mimeType == null){
            mimeType = MediaType.APPLICATION_OCTET_STREAM_VALUE.toString();
        }
        return ResponseEntity.ok()
        .cacheControl(CacheControl.noCache())
        .contentType(MediaType.valueOf(mimeType))
        .body(new ByteArrayResource(rasm));

    }
    @PostMapping("/{id}/upload")
    public ResponseEntity<?> uploadSavolFayl(@PathVariable Long id, @RequestParam("file") MultipartFile file){
        
        Savol s = savolService.getById(id);

        try {
            s.setRasm(file.getBytes());
            savolService.update(s);
            return ResponseEntity.noContent().build();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().build();
        
    }


    @PostMapping()
    public ResponseEntity<Savol> create(@RequestBody Savol savol){
        return ResponseEntity.ok(savolService.create(savol));
    }
    @PutMapping()
    public ResponseEntity<Savol> update(@RequestBody Savol savol){
        return ResponseEntity.ok(savolService.update(savol));
    }
    @PostMapping("/variant")
    public ResponseEntity<Savol> createVariant(@RequestBody Variant variant){
        if(variant.getSavol() != null && variant.getId() == null){
            variantRepo.save(variant);
               
               
             return ResponseEntity.ok(savolService.getById(variant.getSavol().getId()));
        }
        return ResponseEntity.badRequest().build();
    }
       
    @PutMapping("/variant")
    public ResponseEntity<Savol> updateVariant(@RequestBody Variant variant){
        if(variant.getSavol() != null && variant.getId() != null){
            Variant v = variantRepo.findById(variant.getId()).orElseThrow();
            v.setMatn(variant.getMatn());
            v.setTugri(variant.getTugri());
            variantRepo.save(v);
            return ResponseEntity.ok(savolService.getById(variant.getSavol().getId()));
        }
        return ResponseEntity.badRequest().build();

       
    }
   
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        savolService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/variant/{id}")
    public ResponseEntity<?> deleteVariant(@PathVariable Long id) {
        variantRepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    

}
