import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Enter key");
        Scanner scanner = new Scanner(System.in);
        int key = scanner.nextInt();
        Path textPath = Paths.get("C:\\Users\\Roman\\IdeaProjects\\ProjectCriptoText\\Text.txt");
        String textString = Files.readString(textPath); // Get text as String
        Encryption object = new Encryption(key);
        System.out.println("Encryption text");
        System.out.println();
        System.out.println(object.encryptionMethod(textString));
        System.out.println("Decryption text");
        System.out.println();
        System.out.println(object.decryptionMethod(object.encryptionMethod(textString)));
    }
}