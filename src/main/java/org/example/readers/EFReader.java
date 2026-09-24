package org.example.readers;

import org.example.models.ExistingFile;
import java.util.Scanner;


public class EFReader {
    private final Scanner scr;

    private EFReader (Scanner scr) {
        this.scr = scr;
    }

    public ExistingFile read() {
        System.out.println("Introduzca ruta y nombre del archivo:");
        return new ExistingFile(scr.nextLine(), scr.nextLine());
    }
}
