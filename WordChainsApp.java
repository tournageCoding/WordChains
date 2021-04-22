/**
 * A class to read input from stdin and then call the required
 * WordChains constructor based on the number of input variables.
 */
public class WordChainsApp {

    /**
     * The main method.
     */
    public static void main(String[] args) {
        String[] dict = {"cat", "cup", "dog", "cap", "cut", "elephant"};
        new WordChains(dict);
        WordChains test = new WordChains("cat", "cup");
    }
}