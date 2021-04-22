import java.util.*;

/**
 * A class for finding either the shortest path or a path of a set
 * length between two given words (if possible).
 */
public class WordChains {

    private static String[] dictionary;
    private ArrayList<String> wordsSeen;

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
        this.wordsSeen = new ArrayList<String>();
        this.wordsSeen.add(end);
        Word result = this.shortestPath(start, new Word(end, null));
        if (result == null) {
            System.out.println("impossible");
        } else {
            System.out.print(result + " ");
            while (result.getPredecessor() != null) {
                result = result.getPredecessor();
                System.out.print(result + " ");
            }
            System.out.println();
        }
    }

    /**
     * Find the shortest word chain (if possible) between the two
     * given words.
     */
    private Word shortestPath(String goal, Word currentWord) {
        Queue<Word> queue = new LinkedList<Word>();

        for (int i = 0; i < WordChains.dictionary.length; i++) {
            String currentWordStr = currentWord.getWord();
            System.out.println("Current word: " + currentWordStr);

            for (String word : WordChains.dictionary) {
                if (this.oneLetterDifference(word, currentWordStr) &&
                    !this.wordsSeenConatins(word)) {
                    if (word.equals(goal)) {
                        return new Word(word, currentWord);
                    }
                    queue.add(new Word(word, currentWord));
                    this.wordsSeen.add(word);
                }
            }
            currentWord = queue.remove();
        }

        /*
        for (String word : WordChains.dictionary) {
            System.out.println(word);
        }
        System.out.println();
        for (String word : WordChains.dictionary) {
            System.out.println(word + ": " + oneLetterDifference("cat", word));
        }
        */

        return null;
    }

    // probably move this to within word class
    private boolean wordsSeenConatins(String input) {
        for (String word : this.wordsSeen) {
            if (word.equals(input)) return true;
        }
        return false;
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

    private String[] oneLetterDifferenceWords(String input) {
        String[] result = new String[input.length() * 25];
        for (int letter = 0; letter < input.length(); letter++) {
            for (int alphabet = 0; alphabet < 26; alphabet++) {

            }
        }
        return result;
    }
}