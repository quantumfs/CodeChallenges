package taylor.day3;

/**
 * Represents a Santa.
 * 
 * @author Taylor Moon
 */
public class Santa {

	/**
	 * The X coordinate.
	 */
	private int x;

	/**
	 * The Y coordinate.
	 */
	private int y;

	/**
	 * Constructs a new {@code Santa}.
	 */
	public Santa() {
		x = 0;
		y = 0;
	}

	/**
	 * @return x The X coordinate.
	 */
	public int getX() {
		return x;
	}

	/**
	 * @return y The Y coordinate.
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param x The X coordinate to set.
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @param y The Y coordinate to set.
	 */
	public void setY(int y) {
		this.y = y;
	}
}