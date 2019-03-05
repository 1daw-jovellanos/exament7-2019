package examen;
import java.util.*;

public class ExamenT7 {

    public static List<Integer> enterosEnAmbos(Set<Integer> s1, Set<Integer> s2) {
        List<Integer> resultado = new ArrayList<>();
        for(int i : s1) {
            if (i >= 0 && s2.contains(i)) {
                resultado.add(i);
            }
        }
        Collections.sort(resultado);
        return resultado;
    }

    public static int expulsar(Set<Alumno> alumnos) {
        Iterator<Alumno> iter = alumnos.iterator();
        int cuentaExpulsados = 0;
        while (iter.hasNext()) {
            Alumno alumno = iter.next();
            List<Double> notas = alumno.getNotas();
            if (notas.size() < 6 || notas.size() > 15 || Collections.min(notas) < 7) {
                iter.remove();
                cuentaExpulsados++;
            }
        }
        return cuentaExpulsados;
    }

    public static double obtenerNota(List<Integer> notasJueces) {
        if (notasJueces.size() <= 5) {
            throw new IllegalArgumentException();
        }
        int suma = 0;
        List <Integer> notasValidas = new ArrayList<>(notasJueces);
        Collections.sort(notasValidas); // Ordenar
        for (int i = 1; i < notasValidas.size() - 1; i++) {
            suma += notasValidas.get(i);
        }
        return (double) suma / (notasValidas.size() - 2);  
    }

}
