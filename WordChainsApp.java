import java.util.HashSet;

/**
 * A class to read input from stdin and then call the required
 * WordChains constructor based on the number of input variables.
 */
public class WordChainsApp {

    /**
     * The main method.
     */
    public static void main(String[] args) {
        String[] dict = {"cat", "not", "lot", "dog", "get", "got", "lot", "not", "hat",
    "elephant", "car", "bat", "pat", "cod", "far", "fat", "fan", "pet", "hat"};
    HashSet<String> dictSet = new HashSet<String>();
        for (String x : dict) {
            dictSet.add(x);
        }
        new WordChains(dictSet);
        WordChains test = new WordChains("far", "got");
    }
}