package fileT;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class FileTest {
    @Test
    public void t1() throws IOException {
        System.out.println(Files.walk(Path.of("C:\\Users\\LL\\Desktop\\W\\gf")).
                filter(p -> p.toFile().isFile()).
                mapToLong(p -> p.toFile().length()).sum());
    }
    @Test
    public void t2() throws IOException {
        try (Stream<Path> s = Files.walk(Path.of("C:\\Users\\LL\\Desktop\\W\\gf"))){
            s.forEach(System.out::println);
        }

    }
}
