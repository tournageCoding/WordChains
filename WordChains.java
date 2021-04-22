/**
 * A class for finding either the shortest path or a path of a set
 * length between two given words (if possible).
 */
public class WordChains {

    private static String[] dictionary;

    /**
     * Initialise the dictionary.
     */
    public WordChains(String[] dictionary) {
        WordChains.dictionary = dictionary;
    }

    /**
     * Call shortestPath() if given two Strings. 
     */
    public WordChains(String start, String end) {
        this.shortestPath(start, end);
    }

    /**
     * Find the shortest word chain (if possible) between the two
     * given words.
     */
    private void shortestPath(String start, String end) {
        System.out.println(start + " " + end);
        for (String word : WordChains.dictionary) {
            System.out.println(word);
        }
        System.out.println();
        for (String word : WordChains.dictionary) {
            System.out.println(word + ": " + oneLetterDifference("cat", word));
        }
    }

    private boolean oneLetterDifference(String word1, String word2) {
        int numDifferentCharacters = 0;
        if (word1.length() == word2.length()) {
            for (int i = 0; i < word1.length(); i++) {
                if (word1.charAt(i) != word2.charAt(i)) numDifferentCharacters++;
                if (numDifferentCharacters > 1) return false;
            }
            if (numDifferentCharacters == 1) return true;
        }
        return false;
    }
}