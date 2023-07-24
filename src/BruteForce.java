import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class BruteForce {

    public static void force (String text, int sizeKeys) throws IOException {
        boolean isFind = false;
        int count = 0;
        int key = 0;
        Path pathDictionary = Paths.get("C:\\Users\\Roman\\IdeaProjects\\ProjectCriptoText\\dictionary.txt");
        List<String> listDictionary = Files.readAllLines(pathDictionary);
        for (int i = 1; i <= sizeKeys; i++) {
            Encryption obj = new Encryption(i);
            String [] arrText = obj.decryptionMethod(text).split(" ");
            for (String S: arrText
                 ) {
                for (int j = 1; j < listDictionary.size(); j++) {
                    if (listDictionary.get(j).contains(S)) {
                        count++;
                    }
                }
                    if(count > 5) {
                        isFind = true;
                        key = i;
                        break;
                    }
            }
            if(isFind) {

                System.out.println(new Encryption(key).decryptionMethod(text));
                break;
            }
        }
    }

}
