package org.example;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;

public class FileGeneratorNIO {
    private final String[] paths;

    public FileGeneratorNIO(String[] paths) { this.paths = paths; }

    public void createFileNIO() throws IOException
    {
        System.out.println("Generando archivos con NIO...");
        Path[] files = new Path[paths.length];
        for(int i=0; i<paths.length; i++) files[i]=Path.of(paths[i]);

        for (Path file: files)
        {
            Files.createDirectories(file.getParent());
            if (Files.notExists(file)) Files.createFile(file);
        }
    }
}