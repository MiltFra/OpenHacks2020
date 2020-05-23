import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class Parser {
    public Parser() throws Exception {
        throw new Exception("Can not construct object of type Parser.");
    }

    public Enigma parse(Path p) throws Exception {
        File f = p.toFile();
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(f));
            br.close();
        } catch (IOException e) {
            System.err.println("An error occurred reading the given file.");
            e.printStackTrace(System.err);
        }
        throw new Exception("The parser has not yet been fully implemented.");
    }
}