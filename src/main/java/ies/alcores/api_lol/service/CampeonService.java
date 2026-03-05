package ies.alcores.api_lol.service;

import ies.alcores.api_lol.model.Campeon;
import ies.alcores.api_lol.repository.CampeonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampeonService {

    @Autowired
    private CampeonRepository campeonRepository;

    public List<Campeon> findAll(){
        return this.campeonRepository.findAll();
    }

    public List<Campeon> findByRegion(final String region) {

        return this.findAll().stream().filter(a -> a.getRegion().getNombre().equalsIgnoreCase(region)).toList();

    }

    public Campeon agregarCampeon(Campeon campeon) {
        return this.campeonRepository.save(campeon);
    }

    public boolean eliminarCampeon(long id) {
        try {
            this.campeonRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
