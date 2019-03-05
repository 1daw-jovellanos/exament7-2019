package examen;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class ExamenT7Test {
    
 
    @Test(timeout=1000)
    public void testEnterosEnAmbos() {
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        Collections.addAll(s1, 4, 3, 2, -5, 6, -9, 5, 1);
        Collections.addAll(s2, 2, 5, 3, -9, 7, 8, -24);
        List<Integer> l = ExamenT7.enterosEnAmbos(s1, s2);
        Integer[] actual = new Integer[l.size()];
        l.toArray(actual);
        assertArrayEquals("Resultado no es el esperado", new Integer[]{2,3,5}, actual);
        assertEquals("Los sets de parametro no deben verse alterados", 8, s1.size());
        assertEquals("Los sets de parametro no deben verse alterados", 7, s2.size());
    }

    @Test(timeout=1000)
    public void testExpulsar() {
        Alumno a1 = new Alumno(1, new Double[]{1.0, 2.0, 7.0, 6.4, 9.2, 2.20, 7.8});// expulsado;
        Alumno a2 = new Alumno(2, new Double[]{7.8, 7.8, 7.8, 7.8, 7.8});// expulsado;
        Alumno a3 = new Alumno(3, new Double[]{7.8, 7.8, 7.8, 7.8, 7.8, 7.8});// mantenido
        Alumno a4 = new Alumno(4, new Double[]{7.8, 10.0, 9.0, 10.0, 9.0, 10.0});// mantenido
        Alumno a5 = new Alumno(5, new Double[]{7.8, 10.0, 9.0, 10.0, 9.0, 10.0, 
                7.8, 10.0, 9.0, 10.0, 9.0, 10.0, 7.8, 10.0, 9.0, 10.0, 9.0, 10.0});// expulsado
        
        Set<Alumno> alumnos = new HashSet<>();
        Collections.addAll(alumnos, a1, a2, a3, a4, a5);
        int result = ExamenT7.expulsar(alumnos);
        assertEquals(3, result);
        assertEquals(2, alumnos.size());
        assertEquals(true, alumnos.contains(a3));
        assertEquals(true, alumnos.contains(a4));
    }

    @Test(timeout=1000)
    public void testObtenerNota() {
        List<Integer> notasJueces = new ArrayList<>(Arrays.asList(8, 4, 2, 6, 2, 9, 7));
        double expResult = 5.4;
        double result = ExamenT7.obtenerNota(notasJueces);
        assertEquals(expResult, result, 0.01);
        assertEquals("El parametro no debe verse alterado", 7, notasJueces.size());
        notasJueces = new ArrayList<>(Arrays.asList(8, 4, 2, 2, 9, 7, 5, 10));
        expResult = 5.833;
        result = ExamenT7.obtenerNota(notasJueces);
        assertEquals(expResult, result, 0.01);
        notasJueces = new ArrayList<>(Arrays.asList(8, 4, 2, 2, 9));
        boolean hayExcepcion = false;
        try {
            result = ExamenT7.obtenerNota(notasJueces);
        } catch (IllegalArgumentException ex) {
            hayExcepcion = true;
        }
        assertEquals(true, hayExcepcion);
        
    }
    
}