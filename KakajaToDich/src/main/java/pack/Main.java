package pack;


import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    @Parameter(names = "-classFolder")
    private String classFolder;

    public static void main(String[] args) {
        Main main = new Main();
        JCommander.newBuilder()
                .addObject(main)
                .build()
                .parse(args);
        main.run();
    }

    public void run() {
        try {
            Files.list(Paths.get(classFolder))
                    .forEach(file -> System.out.println(file.getFileName().toString()));
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}