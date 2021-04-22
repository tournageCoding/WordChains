public class Word {
    String word;
    Word predecessor;

    public Word(String word, Word predecessor) {
        this.word = word;
        this.predecessor = predecessor;
    }

    public String getWord() {
        return this.word;
    }

    @Override
    public String toString() {
        return this.word;
    }

    public Word getPredecessor() {
        return this.predecessor;
    }
}