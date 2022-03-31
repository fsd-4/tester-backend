package net.idrok.tester.controller;

import java.util.List;

import org.hibernate.dialect.CockroachDB192Dialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.*;

import net.idrok.tester.entity.Fan;
import net.idrok.tester.service.FanService;
import net.idrok.tester.service.impl.FanServiceImpl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/fan")
@CrossOrigin(maxAge = 3600)
public class FanController {

    @Autowired
    FanService fanService;


    @GetMapping()
    public ResponseEntity<List<Fan>> getAll(@RequestParam(name = "key", required = false) String key,
                                            HttpServletRequest req, HttpServletResponse res) {

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
