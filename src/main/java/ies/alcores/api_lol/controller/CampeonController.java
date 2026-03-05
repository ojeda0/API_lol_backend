package ies.alcores.api_lol.controller;

import ies.alcores.api_lol.model.Campeon;
import ies.alcores.api_lol.service.CampeonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/campeones")
public class CampeonController {

    @Autowired
    private CampeonService campeonService;

    //Consulta GET para ver todos los campeones
    @GetMapping("")
    public ResponseEntity<List<Campeon>> findAll(){
        return ResponseEntity.ok(this.campeonService.findAll());
    }

    //Consulta GET para ver campeones por regiones
    @GetMapping("region/{nombreReg}")
    public ResponseEntity<List<Campeon>> findByRegion(@PathVariable String nombreReg) {

        return ResponseEntity.ok(this.campeonService.findByRegion(nombreReg));

    }

    //Consulta GET para ver los campeones por linea
    @GetMapping("/posicion/{linea}")
    public ResponseEntity<List<Campeon>> findByLinea(@PathVariable String linea) {

        return ResponseEntity.ok(this.campeonService.findByLinea(linea));
    }

    //Consulta POST para agregar un nuevo campeon
    @PostMapping("/agregar_campeon")
    public ResponseEntity<Campeon> create(@RequestBody Campeon nuevo) {
        return ResponseEntity.status(201).body(this.campeonService.agregarCampeon(nuevo));
    }

    //Consulta DELETE para eliminar un campeon por id
    @DeleteMapping("/eliminar_campeon/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        if (this.campeonService.eliminarCampeon(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
