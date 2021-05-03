/**
 * A class to represent one word and hold it's predecessor.
 */
public class Word {
    String word;
    Word predecessor;
    int depth;

    /**
     * Initialise the datafields based on given values.
     */
    public Word(String word, Word predecessor) {
        this.word = word;
        this.predecessor = predecessor;
        if (this.predecessor == null) {
            this.depth = 0;
        } else {
            this.depth = this.predecessor.getDepth() + 1;
        }
    }

    /**
     * Return word.
     */
    public String getWord() {
        return this.word;
    }

    @Override
    /**
     * Override the toString method.
     */
    public String toString() {
        return this.word;
    }

    /**
     * Return the predecessor.
     */
    public Word getPredecessor() {
        return this.predecessor;
    }

    /**
     * Return the depth.
     */
    public int getDepth() {
        return this.depth;
    }
}
