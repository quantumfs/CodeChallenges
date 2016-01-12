package taylor.day2;

import junit.framework.Assert;
import taylor.day2.WrappingPaperCalculator;

import org.junit.Test;

@SuppressWarnings("deprecation")
public class WrappingPaperCalculatorTest {

	@Test
	public void testGetWrappingPaperData() {
		/*
		 * Part 1
		 */
		Assert.assertEquals(WrappingPaperCalculator.getWrappingPaperDimensions("2x3x4").getPaperFeet(), 58);
		Assert.assertEquals(WrappingPaperCalculator.getWrappingPaperDimensions("1x1x10").getPaperFeet(), 43);
		/*
		 * Part 2
		 */
		Assert.assertEquals(WrappingPaperCalculator.getWrappingPaperDimensions("2x3x4").getRibbonFeet(), 34);
		Assert.assertEquals(WrappingPaperCalculator.getWrappingPaperDimensions("1x1x10").getRibbonFeet(), 14);
	}
}
