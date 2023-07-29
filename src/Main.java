import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("C:\\Tests\\dictionary.txt");
        int size;
        System.out.println("Enter key");
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        int key = scanner.nextInt();
        String firstLetterString;
        Path textPath = Paths.get("C:\\Users\\Roman\\IdeaProjects\\ProjectCriptoText\\Text.txt");
        String textString = Files.readString(textPath);
        Encryption object = new Encryption(key);
        System.out.println("Encryption text");
        System.out.println();
        String encryptionText = object.encryptionMethod(textString);
        System.out.println(encryptionText);
        System.out.println("Decryption text");
        System.out.println();
        System.out.println(object.decryptionMethod(object.encryptionMethod(textString)));
        System.out.println("Brute Force Method");
        System.out.println("Enter maximum volume of key");
        key = scanner.nextInt();
        System.out.println("Enter size of alphabet");
        size = scanner.nextInt();
        System.out.println("Enter first letter of alphabet");
        firstLetterString = scanner1.nextLine();
        int ok = 0;
        while (ok == 0) {
            BruteForce bruteForce = new BruteForce();
            bruteForce.force(encryptionText, key, size, path, firstLetterString.charAt(0));
            System.out.println("Everything is OK ?");
            System.out.println("If the text is not accurate enter 0, else enter 1");
            key = bruteForce.returnKey();
            ok = scanner.nextInt();
        }

    }
}