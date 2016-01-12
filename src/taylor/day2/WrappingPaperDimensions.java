package taylor.day2;

/**
 * Represents the dimensions of ribbon and feet for wrapping paper.
 * @author Taylor Moon
 */
public class WrappingPaperDimensions {
	
	/**
	 * The length of the paper in feet
	 */
	private int paperFeet;
	
	/**
	 * The length of the ribbon in feet.
	 */
	private int ribbonFeet;

	/**
	 * Constructs a new {@code WrappingPaperDimensions}.
	 * @param paperFeet The length of the paper in feet.
	 * @param ribbonFeet The length of the ribbon in feet.
	 */
	public WrappingPaperDimensions(int paperFeet, int ribbonFeet) {
		this.paperFeet = paperFeet;
		this.ribbonFeet = ribbonFeet;
	}
	
	/**
	 * @return the ribbonFeet
	 */
	public int getRibbonFeet() {
		return ribbonFeet;
	}

	/**
	 * @param ribbonFeet the ribbonFeet to set
	 */
	public void setRibbonFeet(int ribbonFeet) {
		this.ribbonFeet = ribbonFeet;
	}

	/**
	 * @return the paperFeet
	 */
	public int getPaperFeet() {
		return paperFeet;
	}

	/**
	 * @param paperFeet the paperFeet to set
	 */
	public void setPaperFeet(int paperFeet) {
		this.paperFeet = paperFeet;
	}
}
