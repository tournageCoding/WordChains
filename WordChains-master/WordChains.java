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
        Word result;

        if (!WordChains.dictionary.contains(start) ||
            !WordChains.dictionary.contains(end)) {
            result = null;
        } else {
            this.wordsSeen = new HashSet<String>();
            this.wordsSeen.add(end);
            result = this.shortestPath(start, new Word(end, null));
        }    

        if (result == null) {
            System.out.println(start + " " + end + " impossible");
        } else {
            this.printChain(result);
        }

    }

    /**
     * Call xLengthPath() if given two strings and an int.
     */
    public WordChains(String start, String end, int length) {
        Word result;

        if (!WordChains.dictionary.contains(start) ||
            !WordChains.dictionary.contains(end)) {
            result = null;
        } else {
            result = this.xLengthPath(start, new Word(end, null), length);
        }    

        if (result==null) {
            System.out.println(start + " " + end + " " + length + " impossible");
        } else {
            this.printChain(result);
        }
    
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
        Stack<Word> stack = new Stack<Word>();
        stack.push(currentWord);

        while (!stack.empty()) {
            currentWord = stack.pop();
            if (currentWord.getDepth() < length - 1) {            
                String currentWordStr = currentWord.getWord();
                String[] currentWordNeighbours = this.oneLetterDifferenceWords(currentWordStr);

                for (String neighbour : currentWordNeighbours) {
                    if (neighbour.equals(goal)) {
                        // if neighbour == goal, but depth isn't correct,
                        // then don't add new Word to stack.
                        if (currentWord.getDepth() == length - 2) {
                            return new Word(neighbour, currentWord);
                        }                
                    } else if (WordChains.dictionary.contains(neighbour) &&
                    this.checkPath(currentWord, neighbour)) {
                        stack.push(new Word(neighbour, currentWord));
                    }
                }  
            } 
        }
        return null;
    }

    /**
     * Return an array off all the possible one letter variations
     * of a given word.
     */
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

    /**
     * Return true if the input is not in any of the current words
     * predecessors, otherwise return false.
     */
    private boolean checkPath(Word word, String input) {
        if (word.getWord().equals(input)) return false;

        while (word.getPredecessor() != null) {
            word = word.getPredecessor();
            if (word.getWord().equals(input)) return false;
        }
        return true;
    }

    /**
     * Print a word chain by going through the linked list of words
     * held in the Word.predecessor datafield.
     */
    private void printChain(Word word) {
        System.out.print(word + " ");
        while (word.getPredecessor() != null) {
            word = word.getPredecessor();
            System.out.print(word + " ");
        }
        System.out.println();
    }
}