import java.awt.*;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class BruteForce {
    public static void force (String text, int sizeKeys, int sizeAlphabet, Path path, char firstLetter) throws IOException {
        boolean isFind = false;
        int count = 0;
        int key = 0;
        char first = firstLetter;
        int s = sizeAlphabet;
        int keys = sizeKeys;
        String encryptText = text;
        String[] dictArray;
        String[]arr;
        Dictionary dictionary = new Dictionary(s, path, first);
        dictionary.setDictionary();
        for (int i = 1; i < keys; i++) {
            if(count > 3) {
                key = keys;
                isFind = true;
                break;
            }else {
                Encryption obj = new Encryption(i);
                arr = new String[obj.decryptionMethod(text).length()];
                arr = obj.decryptionMethod(encryptText).split(" ");
                for (int m = 0; m < arr.length; m++) {
                    if(arr[m].length() < 2) {
                        arr[m] = "";
                    }
                }
                String dictString = "";
                for (int j = 0; j < s; j++) {
                   Iterator<String> iterator = dictionary.getDictionary(first).listIterator();
                   while (iterator.hasNext()) {
                        dictString = dictString + " " + iterator.next();
                   }
                   dictArray = new String[dictionary.getDictionary(first).size()];
                   dictArray = dictString.split(" ");
                    for (int k = 0; k < arr.length; k++) {
                        for (int l = 0; l < dictArray.length; l++) {
                            if(arr[k].equalsIgnoreCase(dictArray[l])) {
                                count++;
                            }
                        }
                    }
                    first++;
                }


            }

        }
        if(isFind) {
            System.out.println(new Encryption(key).decryptionMethod(encryptText));
        }
    }

}
