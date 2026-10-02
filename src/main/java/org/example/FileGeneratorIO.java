package org.example;

import java.io.IOException;
import java.io.File;

public class FileGeneratorIO {
    private final String[] paths;

    public FileGeneratorIO(String[] paths) { this.paths = paths; }

    public void createFileIO() throws IOException
    {
        System.out.println("Generando archivos con IO...");
        File[] files = new File[paths.length];
        for(int i=0; i<paths.length; i++) files[i]=new File(paths[i]);

        for (File file : files) {
            File directory = file.getParentFile();

            if (directory != null)
                directory.mkdirs();

            if (!file.exists())
                file.createNewFile();
        }
    }
}