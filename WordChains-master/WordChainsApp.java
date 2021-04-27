import java.util.HashSet;
import java.util.Scanner;
import java.util.*;

/**
 * A class to read input from stdin and then call the required
 * WordChains constructor based on the number of input variables.
 */
public class WordChainsApp {

    /**
     * The main method.
     */
    public static void main(String[] args) {
        Queue<String> inputQueue = new LinkedList<String>();
        Scanner in = new Scanner(System.in);
        String line = null;
        while (!(line = in.nextLine()).isEmpty()) {
            inputQueue.add(line);
        }

        HashSet<String> dictSet = new HashSet<String>();
        while(in.hasNextLine()) {
            dictSet.add(in.nextLine());
        }

        in.close();

        new WordChains(dictSet);
        
        for (String s : inputQueue) {
            String[] splited = s.split(" ");
            if (splited.length == 2) {
                WordChains input = new WordChains(splited[0], splited[1]);
            } else if (splited.length == 3) {
                WordChains input = new WordChains(splited[0], splited[1], 
                    Integer.parseInt(splited[2]));
            } else {
                System.out.println("invalid input");
            }
        }
    }
}