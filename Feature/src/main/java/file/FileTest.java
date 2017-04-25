package file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Created by steveyan on 4/25/17.
 */
public class FileTest {

    public static void main(String[] args) {
        try {
            //Files
            //    .list(new File("").toPath())
            //    .sorted()
            //    .forEach(System.out::println);

            File file = new File("build.gradle");

            //Files.readAllLines(file.toPath(), StandardCharsets.UTF_8).forEach(System.out::println);

            Files.lines(file.toPath()).forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
