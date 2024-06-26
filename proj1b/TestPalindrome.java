import org.junit.Test;

import static org.junit.Assert.*;

public class TestPalindrome {
	// You must use this palindrome, and not instantiate
	// new Palindromes, or the autograder might be upset.
	static Palindrome palindrome = new Palindrome();

	@Test
	public void testWordToDeque() {
		Deque d = palindrome.wordToDeque("persiflage");
		String actual = "";
		for (int i = 0; i < "persiflage".length(); i++) {
			actual += d.removeFirst();
		}
		assertEquals("persiflage", actual);
	}
	// Uncomment this class once you've created your Palindrome class. */

	@Test
	public void testIsPalindrome() {
		assertFalse(palindrome.isPalindrome("cat"));
		assertFalse(palindrome.isPalindrome("fortune"));
		assertTrue(palindrome.isPalindrome("isdsi"));
		assertTrue(palindrome.isPalindrome("ipoopi"));
	}

	@Test
	public void testIsPalindrome2() {
		CharacterComparator cc = new OffByOne();
		assertFalse(palindrome.isPalindrome("cat", cc));
		assertFalse(palindrome.isPalindrome("fortune", cc));
		assertFalse(palindrome.isPalindrome("aa", cc));
		assertTrue(palindrome.isPalindrome("abdcb", cc));
		assertTrue(palindrome.isPalindrome("badeba", cc));
	}

	@Test
	public void testIsPalindrome3() {
		CharacterComparator cc = new OffByN(4);
		assertFalse(palindrome.isPalindrome("cat", cc));
		assertFalse(palindrome.isPalindrome("fortune", cc));
		assertFalse(palindrome.isPalindrome("aa", cc));
		assertTrue(palindrome.isPalindrome("aefae", cc));
	}
}
