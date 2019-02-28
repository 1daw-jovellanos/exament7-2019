package examen;


import java.util.Arrays;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author victor
 */
public class Alumno {
    List<Double> notas;
    int id;
    
    public Alumno(int id, Double[] notas) {
        this.notas = Arrays.asList(notas);
        this.id = id;
    }
    
    public List<Double> getNotas() {
        return notas;
    }
    
    public int getId() {
        return id;
    }
    
}
