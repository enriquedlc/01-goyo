import jdk.swing.interop.SwingInterOpUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("cmd.exe", "/c", "dir"); // lo que queremos que se ejecute

        System.out.println(processBuilder.command()); // devuelve el comando ejecutado
        processBuilder.directory(new File("C:\\Users\\Enrique")); // sobrecargamos directory con una ruta existente en el sistema
        // cuando ponemos un nuevo file y le pasamos al path name

        System.out.println(processBuilder.directory().getAbsolutePath());

        Process process = null;

        try {
            process = processBuilder.start(); // ejecutamos el proceso con start y devuelve un objeto process builder
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream())); // leer como si fuese un fichero
            String line;

            File file = processBuilder.directory(); // pone todo lo que está dentro del directorio
            System.out.println(file);

            line = reader.readLine();

            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }

            int exitCode = process.waitFor();

            System.out.println("\n\n => Terminado el proceso con con codigo de error: " + exitCode);

        } catch (Error | IOException | InterruptedException error) {

        }
    }
}
