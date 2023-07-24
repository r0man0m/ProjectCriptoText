import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        Path textPath = Paths.get("C:\\Tests\\Text.txt");
        String textString = Files.readString(textPath); // Get text as String
        Encryption object = new Encryption(200);
        System.out.println(object.encryptionMethod(textString));
    }
}