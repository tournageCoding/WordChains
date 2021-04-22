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
        // what's faster? checking dictionary for two given words before
        // calling method. (return error if a word is in dict)
        // OR faster to jsut call method with them and let tree hit
        // 'impossible'(no solution) condition
        this.shortestPath(start, new Word(end, null));
    }

    /**
     * Find the shortest word chain (if possible) between the two
     * given words.
     */
    private void shortestPath(String goal, Word currentWord) {
        for (int i = 0; i < WordChains.dictionary.length; i++) {
            for (String word : WordChains.dictionary) {
                if (this.oneLetterDifference(word, currentWord.getWord())) {
                    // only do below if word has not been seen before
                    // queue.add(new Word(word, currentWord))
                }
            }
            //currentWord = queue.get();
        }

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