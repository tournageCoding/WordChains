public class Word {
    String word;
    Word predecessor;

    public Word(String word, Word predecessor) {
        this.word = word;
        this.predecessor = predecessor;
    }
}