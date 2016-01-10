package taylor;

import junit.framework.Assert;

import org.junit.Test;

@SuppressWarnings("deprecation")
public class FloorDeterminerTest {

	@Test
	public void testGetFloorInformation() {
		/*
		 * Part 1
		 */
		Assert.assertEquals(FloorDeterminer.getFloorData("(())")[0], 0);
		Assert.assertEquals(FloorDeterminer.getFloorData("(()(()(")[0], 3);
		Assert.assertEquals(FloorDeterminer.getFloorData("))(((((")[0], 3);
		Assert.assertEquals(FloorDeterminer.getFloorData("())")[0], -1);
		Assert.assertEquals(FloorDeterminer.getFloorData(")())())")[0], -3);
		/*
		 * Part 2
		 */
		Assert.assertEquals(FloorDeterminer.getFloorData(")")[1], 1);
		Assert.assertEquals(FloorDeterminer.getFloorData("()())")[1], 5);
	}
}
