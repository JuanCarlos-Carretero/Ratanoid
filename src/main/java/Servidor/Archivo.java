package Servidor;

import com.opencsv.CSVWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Esta clase sirve para crear el csv.
 */
public class Archivo {

    /**
     * Este metodo constructor sirve para crear el csv
     *
     * @param jugadores Recibe una lista con la cual va a trabajar para escribir en el csv
     * @param file      Recibe un file con el cual va a trabajar a la hora de borrar el archivo o a la g¡hora de crear/escribir dentro de el.
     */
    public void Escribir(List<Jugador> jugadores, File file) {
        CSVWriter csvWriter;
        List<String[]> data = new ArrayList<>();

        for (Jugador jugador:jugadores) {
                data.add(new String[] {jugador.getApodo(),String.valueOf(jugador.getPuntuacion())});
        }

        try {
            csvWriter = new CSVWriter(new FileWriter(file));
            csvWriter.writeAll(data);
            csvWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Ruta del archivo " + file.getPath());
    }

    public List<Jugador> Leer(File file) {
        List<Jugador> scoreList = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter(",|\n");

            while (scanner.hasNext()) {
                String apodo = scanner.next();
                String puntuacion = scanner.next();

                String nombre = apodo.substring(1, apodo.length() - 1);
                int n = Integer.parseInt(puntuacion.substring(1, puntuacion.length() - 1));

                scoreList.add(new Jugador(nombre, n));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return scoreList;
    }
}