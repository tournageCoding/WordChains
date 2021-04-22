/**
 * A class for finding either the shortest path or a path of a set
 * length between two given words (if possible).
 */
public class WordChains {

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
    }
}