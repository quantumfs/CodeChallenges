package taylor;

import junit.framework.Assert;

import org.junit.Test;

@SuppressWarnings("deprecation")
public class DelieryDeterminerTest {
	
	@Test
	public void testGetLocation() throws Exception {
		/*
		 * Part 1
		 */
		Assert.assertEquals(DeliveryDeterminer.getNumberOfDeliveries(">", false), 2);
		Assert.assertEquals(DeliveryDeterminer.getNumberOfDeliveries("^>v<", false), 4);
		Assert.assertEquals(DeliveryDeterminer.getNumberOfDeliveries("^v^v^v^v^v", false), 2);
		/*
		 * Part 2
		 */
		Assert.assertEquals(DeliveryDeterminer.getNumberOfDeliveries("^v", true), 3);
		Assert.assertEquals(DeliveryDeterminer.getNumberOfDeliveries("^>v<", true), 3);
		Assert.assertEquals(DeliveryDeterminer.getNumberOfDeliveries("^v^v^v^v^v", true), 11);
	}
	
}
