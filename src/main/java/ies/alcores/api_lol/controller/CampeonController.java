package ies.alcores.api_lol.controller;

import ies.alcores.api_lol.model.Campeon;
import ies.alcores.api_lol.service.CampeonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/campeones")
public class CampeonController {

    @Autowired
    private CampeonService campeonService;

    @GetMapping("")
    public ResponseEntity<List<Campeon>> findAll(){
        return ResponseEntity.ok(this.campeonService.findAll());
    }

    @GetMapping("region/{nombreReg}")
    public ResponseEntity<List<Campeon>> findByRegion(@PathVariable String nombreReg) {

        return ResponseEntity.ok(this.campeonService.findByRegion(nombreReg));

    }

}
