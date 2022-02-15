package net.idrok.tester.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.idrok.tester.entity.Savol;
import net.idrok.tester.service.SavolService;
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


    @GetMapping()
    public ResponseEntity<Page<Savol>> getAll(@RequestParam(name = "key", required = false) String key, Pageable pageable) {
        if(key == null) key = "";
        return ResponseEntity.ok(savolService.getAll(key, pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Savol> getById(@PathVariable Long id) {
        return ResponseEntity.ok(savolService.getById(id));
    }


    @PostMapping()
    public ResponseEntity<Savol> create(@RequestBody Savol savol){
        return ResponseEntity.ok(savolService.create(savol));
    }
    @PutMapping()
    public ResponseEntity<Savol> update(@RequestBody Savol savol){
        return ResponseEntity.ok(savolService.update(savol));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        savolService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    

}
