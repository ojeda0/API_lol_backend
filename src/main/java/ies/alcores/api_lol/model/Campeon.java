package ies.alcores.api_lol.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Campeon {

    @Id
    private long id;
    private String nombre;
    private String linea;
    private String rol;

    @ManyToOne
    private Region region;

}
