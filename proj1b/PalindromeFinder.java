/** This class outputs all palindromes in the words file in the current directory. */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PalindromeFinder {
    public static void main(String[] args) throws FileNotFoundException {
        int minLength = 4;
        Scanner in = new Scanner(new File("../library-sp18/data/words.txt"));
        Palindrome palindrome = new Palindrome();

        while (true) {
            String word = in.next();
			if(word.isEmpty()){
				break;
			}
            if (word.length() >= minLength && palindrome.isPalindrome(word)) {
                System.out.println(word);
            }
        }
    }
    // Uncomment this class once you've written isPalindrome. */
}
