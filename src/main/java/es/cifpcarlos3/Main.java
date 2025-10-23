package es.cifpcarlos3;

import es.cifpcarlos3.vo.Ciclo;
import es.cifpcarlos3.vo.FamiliaProfesional;
import es.cifpcarlos3.vo.Grado;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String codfamilia = args[0];
        String codgrado = args[1];
        String filedat = "familia_profesional.dat";
        String filedat2 = "informacion_ciclos.txt";
        String filedat3 = "grados.csv";
        String filedatser= "resultado.ser";
        FamiliaProfesional f = null;
        Grado grado = null;
        List<Ciclo> ciclos = new ArrayList<>();
        int i = 0;
        try(BufferedReader br = new BufferedReader(new FileReader(filedat))){
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();

                if(line.isEmpty() || line.startsWith("#")) {
                    continue;
                }

                if (line.startsWith(codfamilia)) {
                    String[] partes = line.split("=");
                    f = new FamiliaProfesional(partes[0], partes[1]);
                }
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        try(BufferedReader br = new BufferedReader(new FileReader(filedat3))){
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();

                if(line.isEmpty() || line.startsWith("#")) {
                    continue;
                }

                if (line.startsWith(codgrado)) {
                    String[] partes = line.split("#");
                    grado = new Grado(partes[0], partes[1]);
                }
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        System.out.println("Familia Profesional: "+f.getnombre("'"+codfamilia+"'"));
        System.out.println("Grado Seleccionado: "+grado.getcurso("'"+codgrado+"'")+"\n");
        try(BufferedReader br = new BufferedReader(new FileReader(filedat2))){
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();

                if(line.isEmpty() || line.startsWith("#")) {
                    continue;
                }

                if (line.startsWith("'"+codfamilia) &&  line.endsWith(codgrado+"'")) {
                    String[] partes = line.split(",");
                    ciclos.add(new Ciclo(partes[0].trim(), partes[1].trim(), Integer.parseInt(partes[2].trim()), partes[3].trim(), partes[4].trim()));
                    System.out.println(ciclos.get(i).mensaje(f, grado));
                    i++;
                }
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filedatser))){
            oos.writeObject(ciclos);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}