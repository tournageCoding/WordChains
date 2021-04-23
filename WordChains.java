import java.util.*;

/**
 * A class for finding either the shortest path or a path of a set
 * length between two given words (if possible).
 */
public class WordChains {

    private static HashSet<String> dictionary;
    private HashSet<String> wordsSeen;

    /**
     * Initialise the dictionary.
     */
    public WordChains(HashSet<String> dictionary) {
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
        this.wordsSeen = new HashSet<String>();
        this.wordsSeen.add(end);
        Word result = this.shortestPath(start, new Word(end, null));
        this.printChain(result);
    }

    /**
     * Call xLengthPath() if given two strings and an int.
     */
    public WordChains(String start, String end, int length) {
        Word result = this.xLengthPath(start, new Word(end, null), length);
        this.printChain(result);
    }

    /**
     * Find the shortest word chain (if possible) between the two
     * given words.
     */
    private Word shortestPath(String goal, Word currentWord) {
        Queue<Word> queue = new LinkedList<Word>();
        queue.add(currentWord);

        while (!queue.isEmpty()) {
            currentWord = queue.remove();
            String currentWordStr = currentWord.getWord();
            String[] currentWordNeighbours = this.oneLetterDifferenceWords(currentWordStr);
            System.out.println("Current word: " + currentWordStr);
            System.out.println("Depth: " + currentWord.getDepth());

            for (String neighbour : currentWordNeighbours) {
                if (!this.wordsSeen.contains(neighbour)){
                    if (neighbour.equals(goal)) {
                        return new Word(neighbour, currentWord);
                    }
                    if (WordChains.dictionary.contains(neighbour)) {
                        queue.add(new Word(neighbour, currentWord));
                        this.wordsSeen.add(neighbour);
                    }
                }

            }
            
        }
        return null;
    }

    /**
     * Find a word chain of given length (if possible) between the
     * two words.
     */
    private Word xLengthPath(String goal, Word currentWord, int length) {
        return new Word("hello world", null);
    }

    private String[] oneLetterDifferenceWords(String input) {
        int i = 0;
        String[] result = new String[input.length() * 25];
        StringBuilder string = new StringBuilder(input);
        for (int letter = 0; letter < input.length(); letter++) {
            for (int alphabet = 0; alphabet < 26; alphabet++) {
                string.setCharAt(letter, (char)(alphabet+97));
                if (!string.toString().equals(input)) {
                    result[i++] = string.toString();
                }
            }
            string.setCharAt(letter, input.charAt(letter));
        }
        return result;
    }

    private void printChain(Word word) {
        if (word == null) {
            System.out.println("impossible");
        } else {
            System.out.print(word + " ");
            while (word.getPredecessor() != null) {
                word = word.getPredecessor();
                System.out.print(word + " ");
            }
            System.out.println();
        }
    }
}