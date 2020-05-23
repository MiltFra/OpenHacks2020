import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class Parser {
    public Parser() throws Exception {
        throw new Exception("Can not construct object of type Parser.");
    }

    public static Enigma parse(Path p) throws Exception {
        File f = p.toFile();
        try {
            var br = new BufferedReader(new FileReader(f));
            var rotorCount = Integer.parseInt(br.readLine());
            var translator = Mapping.fromString(br.readLine());
            var rotors = new Rotor[rotorCount];
            String line;
            for (int i = 0; i < rotorCount; i++) {
                Mapping m = Mapping.fromString(br.readLine());
                line = br.readLine().trim().replace("\n", "").replace("\r", "");
                Letter[] step_on = new Letter[line.length()];
                for (int j = 0; j < line.length(); j++) {
                    step_on[j] = new Letter(line.charAt(j));
                }
                rotors[i] = new Rotor(m, step_on);
            }
            var reflector = Mapping.fromString(br.readLine());
            br.close();
            return new Enigma(rotors, translator, reflector);
        } catch (Exception e) {
            System.err.println("An error occurred reading the given file.");
            e.printStackTrace(System.err);
        }
        // throw new Exception("The parser has not yet been fully implemented.");
        return null;
    }
}