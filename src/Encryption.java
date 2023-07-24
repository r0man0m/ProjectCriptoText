public class Encryption {
    private final int key;
    public Encryption(int key) {
        this.key = key;
    }
    public String encryptionMethod(String text) {
        char[]word = text.toCharArray();
        for (int i = 0; i < word.length; i++) {
            if(word[i] >= 1040 && word[i] <= 1071) {
                word[i] = (char) (module((word[i] - 1040 + key), 32) + 1040);
            }
            else if(word[i] >= 1072 && word[i] <= 1103) {
                word[i] = (char) (module((word[i] - 1072 + key), 32) + 1072);
            }
            else if(word[i] >= 32 && word[i] <= 46) {
                word[i] = (char) (module((word[i] - 32 + key), 15) + 32);
            }

        }
        return new String(word);
    }
    public static int module(int m, int d) {
        int rez;
        if(m < 0) {
            m *= -1;
            rez = d - (m % d);
            return rez;
        }
        else {
            rez = m % d;
            return rez;
        }

    }
}
