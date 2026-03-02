package ies.alcores.api_lol.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Region {

    @Id
    private long id;
    private String nombre;
    private String entorno;
    private String magia;
    private String gobierno;

}
