package ies.alcores.api_lol.controller;

import ies.alcores.api_lol.model.Region;
import ies.alcores.api_lol.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/regiones")
public class RegionController {

    @Autowired
    private RegionService regionService;

    @GetMapping
    public ResponseEntity<List<Region>> listar() {

        return ResponseEntity.ok(this.regionService.findAll());

    }

    @GetMapping("/{id}")
    public ResponseEntity<Region> obtenerPorID(@PathVariable long id) {

        return this.regionService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

}
