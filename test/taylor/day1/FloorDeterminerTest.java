package taylor.day1;

import junit.framework.Assert;
import taylor.day1.FloorDeterminer;

import org.junit.Test;

@SuppressWarnings("deprecation")
public class FloorDeterminerTest {

	@Test
	public void testGetFloorInformation() {
		/*
		 * Part 1
		 */
		Assert.assertEquals(FloorDeterminer.parseFloorInformation("(())").getFloorLandedOn(), 0);
		Assert.assertEquals(FloorDeterminer.parseFloorInformation("(()(()(").getFloorLandedOn(), 3);
		Assert.assertEquals(FloorDeterminer.parseFloorInformation("))(((((").getFloorLandedOn(), 3);
		Assert.assertEquals(FloorDeterminer.parseFloorInformation("())").getFloorLandedOn(), -1);
		Assert.assertEquals(FloorDeterminer.parseFloorInformation(")())())").getFloorLandedOn(), -3);
		/*
		 * Part 2
		 */
		Assert.assertEquals(FloorDeterminer.parseFloorInformation(")").getIntialBasementEntracePoint(), 1);
		Assert.assertEquals(FloorDeterminer.parseFloorInformation("()())").getIntialBasementEntracePoint(), 5);
	}
}
