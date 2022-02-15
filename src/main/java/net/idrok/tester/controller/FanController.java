package net.idrok.tester.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.idrok.tester.entity.Fan;
import net.idrok.tester.service.FanService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/fan")
@CrossOrigin(maxAge = 3600)
public class FanController {
    @Autowired
    FanService fanService;


    @GetMapping()
    public ResponseEntity<List<Fan>> getAll(@RequestParam(name = "key", required = false) String key) {
        if(key == null) key = "";
        return ResponseEntity.ok(fanService.getAll(key));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fan> getById(@PathVariable Long id) {
        return ResponseEntity.ok(fanService.getById(id));
    }


    @PostMapping()
    public ResponseEntity<Fan> create(@RequestBody Fan fan){
        return ResponseEntity.ok(fanService.create(fan));
    }
    @PutMapping()
    public ResponseEntity<Fan> update(@RequestBody Fan fan){
        return ResponseEntity.ok(fanService.update(fan));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        fanService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    

}
