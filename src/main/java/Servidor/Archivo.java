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
    public void Escribir(Jugador jugadores, File file) {
        CSVWriter csvWriter;
        String[] score = new String[2];
        file.delete();

        score[0] = jugadores.getApodo();
        score[1] = String.valueOf(jugadores.getPuntuacion());

        try {
            csvWriter = new CSVWriter(new FileWriter(file));
            csvWriter.writeNext((String[]) score);
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

                int n = Integer.parseInt(puntuacion.substring(2, puntuacion.length() - 2));

                scoreList.add(new Jugador(apodo, n));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return scoreList;
    }
}