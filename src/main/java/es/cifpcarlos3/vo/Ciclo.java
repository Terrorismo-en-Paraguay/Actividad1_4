package es.cifpcarlos3.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Ciclo {
    private String codigo;
    private String nombre;
    private int horas;
    private String codigoFamilia;
    private String codigoGrado;

    public String mensaje(FamiliaProfesional f, Grado grado) {
        return "El ciclo "+this.nombre+" incluido en la familia de "+f.getnombre(this.codigoFamilia) +" es un "+grado.getcurso(this.codigoGrado)+".";
    }
    @Override
    public String toString() {
        return "Ciclo{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", horas=" + horas +
                ", codigoFamilia='" + codigoFamilia + '\'' +
                ", codigoGrado='" + codigoGrado + '\'' +
                '}';
    }
}
