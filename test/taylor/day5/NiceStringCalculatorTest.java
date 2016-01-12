package taylor.day5;

import org.junit.Test;

import junit.framework.Assert;
import taylor.day5.NiceStringCalculator;

@SuppressWarnings("deprecation")
public class NiceStringCalculatorTest {
	
	@Test
	public void testIsNiceString() {
		Assert.assertEquals(NiceStringCalculator.isNiceString("ugknbfddgicrmopn", false), true);
		Assert.assertEquals(NiceStringCalculator.isNiceString("haegwjzuvuyypxyu", false), false);
	}
	
	@Test
	public void testHasPermittedCharacters() {
		Assert.assertEquals(NiceStringCalculator.hasPermittedCharacters("sijeab"), true);
	}
	
	@Test
	public void testHasSequentialRepeatingLetter() {
		Assert.assertEquals(NiceStringCalculator.hasSequentialRepeatingLetter("asdaadsd"), true);
		Assert.assertEquals(NiceStringCalculator.hasSequentialRepeatingLetter("asjueislldjsje"), true);
		Assert.assertEquals(NiceStringCalculator.hasSequentialRepeatingLetter("abcdefghijklmnopqrstuvwxyz"), false);
	}

	@Test
	public void testHasRepeatingLetterSeperated() {
		Assert.assertEquals(NiceStringCalculator.hasRepeatingLetterSeperated("aabcdefgasa"), true);
		Assert.assertEquals(NiceStringCalculator.hasRepeatingLetterSeperated("kik"), true);
		Assert.assertEquals(NiceStringCalculator.hasRepeatingLetterSeperated("aaa"), true);
	}
	
	@Test
	public void testHasSequentialPairedLetter() {
		Assert.assertEquals(NiceStringCalculator.hasSequentialPairedLetter("aabcdefgaa"), true);
		Assert.assertEquals(NiceStringCalculator.hasSequentialPairedLetter("ayybcdyyc"), true);
		Assert.assertEquals(NiceStringCalculator.hasSequentialPairedLetter("abc"), false);
	}

	
	@Test
	public void testHasThreeVowels() {
		Assert.assertEquals(NiceStringCalculator.hasThreeVowels("aei"), true);
	}
}
