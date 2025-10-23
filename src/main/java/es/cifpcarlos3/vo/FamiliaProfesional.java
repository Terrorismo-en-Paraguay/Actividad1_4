package es.cifpcarlos3.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class FamiliaProfesional implements Serializable {
    private String nombre;
    private String codigo;

    public String getnombre(String codigo) {
        return switch (codigo) {
            case "'IFC'" -> "Informática y Comunicaciones";
            case "'SAN'" -> "Sanidad";
            case "'SMA'" -> "Seguridad y Medio Ambiente";
            default -> "Ni idea";
        };
    }
}
