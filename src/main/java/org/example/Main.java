package org.example;

import java.io.IOException;
import java.io.File;

import java.nio.file.Path;
import java.nio.file.Files;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static Scanner scr = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        final String[] RUTAS = {"/home/diurno/IdeaProjects/generadorIO/otro/andanotherjuan.txt", "otro/ejemplo.txt"};

        while (true) {
            System.out.println("¿IO (0) o NIO (1)");
            String answer = scr.nextLine().toUpperCase();
            switch (answer) {
                case "IO", "0":
                    FileGeneratorIO filesIO = new FileGeneratorIO(RUTAS);
                    filesIO.createFileIO();
                    break;
                case "NIO", "1":
                    FileGeneratorNIO filesNIO = new FileGeneratorNIO(RUTAS);
                    filesNIO.createFileNIO();
                    break;
                default:
                    System.out.println("No me gusta tu tono jovencito.");
                    continue;
            }
            break;
        }

        while (true) {
            System.out.println("¿Y ahora qué?\n1- Confirmar archivo con IO\n2- Confirmar archivo con NIO" +
                    "\n3- Encontrar archivo en directorio");
            int answer = scr.nextInt();
            scr.nextLine();
            switch (answer) {
                case 1:
                    System.out.println("Pon la ruta");
                    File target = new File(scr.nextLine());
                    if (target.exists()) System.out.println("Existe");
                    else System.out.println("NO existe");
                    break;
                case 2:
                    System.out.println("Pon la ruta");
                    Path parget = Path.of(scr.nextLine());
                    if (Files.exists(parget)) System.out.println("Existe");
                    else System.out.println("NO existe");
                    break;
                case 3:
                    System.out.println("¿Qué fichero quieres buscar?");
                    String sarget = scr.nextLine();
                    System.out.println("¿En qué directorio?");
                    Path pearch = Path.of(scr.nextLine());
                    if (estaEN(sarget, pearch)) System.out.println("Existe");
                    else System.out.println("NO existe");
                    break;
                default:
                    System.out.println("No estás a lo que estás...");
                    continue;
            }
            break;
        }
    }
    public static boolean estaEN(String x, Path y) {
        try (Stream<Path> z = Files.list(y)){
            return z.anyMatch(a -> a.toString().contains(x));
        } catch (Exception IOException) {
            System.out.println("¡El archivo no existe!");
        }
        return false;
    }
}