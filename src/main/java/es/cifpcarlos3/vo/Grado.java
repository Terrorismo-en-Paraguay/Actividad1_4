package es.cifpcarlos3.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Grado {
    private String codigo;
    private String ciclo;

    public String getcurso(String codigociclo){
        return switch (codigociclo) {
            case "'CFGB'" -> "Grado Basico";
            case "'CFGM'" -> "Grado Medio";
            case "'CFGS'" -> "Grado superior";
            case "'CE'" -> "Curso de especializacion";
            default -> "Ni idea";
        };
    }
}
