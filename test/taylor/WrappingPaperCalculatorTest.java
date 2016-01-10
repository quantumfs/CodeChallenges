package taylor;

import junit.framework.Assert;

import org.junit.Test;

@SuppressWarnings("deprecation")
public class WrappingPaperCalculatorTest {

	@Test
	public void testGetWrappingPaperData() {
		/*
		 * Part 1
		 */
		Assert.assertEquals(WrappingPaperCalculator.getWrappingPaperData("2x3x4")[0], 58);
		Assert.assertEquals(WrappingPaperCalculator.getWrappingPaperData("1x1x10")[0], 43);
		/*
		 * Part 2
		 */
		Assert.assertEquals(WrappingPaperCalculator.getWrappingPaperData("2x3x4")[1], 34);
		Assert.assertEquals(WrappingPaperCalculator.getWrappingPaperData("1x1x10")[1], 14);
	}
}
