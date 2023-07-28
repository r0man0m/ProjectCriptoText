import java.awt.*;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class BruteForce {
    public static void force (String text, int sizeKeys, int sizeAlphabet, Path path, char firstLetter) throws IOException {
        Dictionary dictionary = new Dictionary(sizeAlphabet, path, firstLetter);
        dictionary.setDictionary();
        int count;
        boolean isFind = false;
        int key = 0;
        for (int i = 1; i <= sizeKeys; i++) { // Get decryption text for next key
            count = 0;
            Encryption obj = new Encryption(i);
            String[] decryptionText = obj.decryptionMethod(text).toLowerCase().split(" "); // Get split array from decryption text
            for (int j = 0; j < sizeAlphabet; j++) {
                ArrayList<String> listForNextLetter = dictionary.getDictionary(firstLetter); // Get list for next letter
                for (int k = 0; k < decryptionText.length; k++) {
                    if(listForNextLetter.contains(decryptionText[k])) { //Search contains every word of text in list of next letter
                        count++; // if contains is exist, increment count
                    }
                }
                firstLetter++; // next letter
            }
            if(count > 20) { // Check for contains words in the decryption text
                isFind = true;
                key = i;
                break;
            }

        }
        if (isFind) {
            Encryption encryption = new Encryption(key);
            System.out.println(encryption.decryptionMethod(text));
        }
        else {
            System.out.println("Not find");
        }

    }

}
