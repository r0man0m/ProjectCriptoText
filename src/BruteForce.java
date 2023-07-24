import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class BruteForce {

    public static void force (String text, int sizeKeys) throws IOException {
        boolean isFind = false;
        String result = "";
        Path pathDictionary = Paths.get("C:\\Users\\Roman\\IdeaProjects\\ProjectCriptoText\\dictionary.txt");
        List<String> listDictionary = Files.readAllLines(pathDictionary);
        for (int i = 1; i <= sizeKeys; i++) {
            Encryption obj = new Encryption(i);
            String [] arrText = obj.decryptionMethod(text).split(" ");
            for (String S: arrText
                 ) {
                for (int j = 0; j < listDictionary.size(); j++) {
                    if (listDictionary.get(j).contains(S)) {
                        isFind = true;

                    }
                }

            }
            if(isFind) {

                System.out.println(obj.decryptionMethod(text));
                break;
            }
        }
    }


}
