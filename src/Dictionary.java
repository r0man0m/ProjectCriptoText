import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Dictionary {
    private  final int SIZE;
    private  final Path PATH;
    private  char firstLetter;
    private final HashMap<Character, ArrayList<String>> DICTIONARYMAP;
    public Dictionary(int size, Path path, char firstLetter) {
        SIZE = size;
        PATH = path;
        this.firstLetter = firstLetter;
        DICTIONARYMAP = new HashMap<>();
    }
    public void setDictionary() throws IOException {
        List<String> list = Files.readAllLines(PATH);
        String letterToString = String.valueOf(firstLetter);
        ArrayList<String>arrayList;
        int counter = 0;
        for (int i = 0; i < SIZE; i++) {
            arrayList = new ArrayList<>();
            for (int j = counter; j < list.size(); j++) {
                if (list.get(j).startsWith(letterToString)) {
                    arrayList.add(list.get(j));
                    counter++;
                }
                DICTIONARYMAP.put(firstLetter, arrayList);
            }
            firstLetter++;
            letterToString = String.valueOf(firstLetter);
        }
    }
    public ArrayList<String> getDictionary(char letter) {
        return DICTIONARYMAP.get(letter);
    }
}
