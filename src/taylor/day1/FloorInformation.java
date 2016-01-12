package taylor.day1;

/**
 * Contains information pertaining to information about the floor santa is on.
 * @author Taylor Moon
 */
public class FloorInformation {
	
	/**
	 * The floor in which santa landed on.
	 */
	private int floorLandedOn;
	
	/**
	 * The index in the instructions (data file) where santa has entered the basement.
	 */
	private int intialBasementEntracePoint;

	/**
	 * @return the floorLandedOn
	 */
	public int getFloorLandedOn() {
		return floorLandedOn;
	}

	/**
	 * @param floorLandedOn the floorLandedOn to set
	 */
	public void setFloorLandedOn(int floorLandedOn) {
		this.floorLandedOn = floorLandedOn;
	}
	
	/**
	 * Increases the floor landed on.
	 * @param amount The amount to increase by.
	 * @return The current amount.
	 */
	public int increaseFloorLandedOn(int amount) {
		return floorLandedOn += amount;
	}

	/**
	 * @return the intialBasementEntracePoint
	 */
	public int getIntialBasementEntracePoint() {
		return intialBasementEntracePoint;
	}

	/**
	 * @param intialBasementEntracePoint the intialBasementEntracePoint to set
	 */
	public void setIntialBasementEntracePoint(int intialBasementEntracePoint) {
		this.intialBasementEntracePoint = intialBasementEntracePoint;
	}
}
