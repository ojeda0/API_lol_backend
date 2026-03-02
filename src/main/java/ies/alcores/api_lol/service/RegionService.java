package ies.alcores.api_lol.service;

import ies.alcores.api_lol.model.Region;
import ies.alcores.api_lol.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionService {

    @Autowired
    private RegionRepository regionRepository;

    public List<Region> findAll() {

        return this.regionRepository.findAll();

    }

}
