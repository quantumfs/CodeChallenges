package taylor.day3;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

public class DeliveryDeterminer {

	/**
	 * The main method.
	 * @param args The arguments casted on runtime.
	 * @throws IOException If there is an exception while reading the input file.
	 */
	public static void main(String... args) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("data/deliverydata.txt"));
		String input  = reader.readLine();
		reader.close();
		System.out.println("PART 1 ANSWER: " + getNumberOfDeliveries(input, false));
		System.out.println("PART 2 ANSWER: " + getNumberOfDeliveries(input, true));
	}
	
	/**
	 * Returns the number of houses santa had delivered presents to.
	 * @param input The input.
	 * @param part2 If robot santa should be introduced into the process.
	 * @return The number of total deliveries.
	 */
	static int getNumberOfDeliveries(String input, boolean part2) {
		Set<Integer> deliveries = new TreeSet<>();
		Santa defaultSanta = new Santa();
		Santa robotSanta = new Santa();
		deliveries.add(interleaveIntegers(defaultSanta.getX(), defaultSanta.getY()));

		boolean robot = false;
		Santa currentSanta = null;
		for (char c : input.toCharArray()) {
			currentSanta = robot ? robotSanta : defaultSanta;
			determineNextLocation(currentSanta, c);
			deliveries.add(interleaveIntegers(currentSanta.getX(), currentSanta.getY()));
			if (part2) {
				robot = !robot;
			}
		}
		return deliveries.size();
	}
	
	/**
	 * Determines the new x and y coordinates the given {@code Santa} should arrive at.
	 * @param Santa The {@code Santa} who's location is being determined.
	 * @param command The command from the input.
	 */
	static void determineNextLocation(Santa santa, char command) {
		int newX = santa.getX(), newY = santa.getY();
		switch (command) {
			case '^' :
				newY++;
				break;
			case '<' :
				newX--;
				break;
			case '>' :
				newX++;
				break;
			case 'v' :
				newY--;
				break;
			default :
				throw new IllegalArgumentException("Input command \"" + command + "\" isn't supported.");
		}
		santa.setX(newX);
		santa.setY(newY);
	}
	
	
	/**
	 * Creates a single integer defined by the bits of 2 given integers.
	 * @param x The X coordinate.
	 * @param y The Y coordinate.
	 * @return The packed integer.
	 */
	private static int interleaveIntegers(int x, int y) {
		return (sererateBits(y) << 1) + sererateBits(x);
	}

	/**
	 * Repositions the significant bits of a given integer.
	 * @param n The integer.
	 * @return The integer containing the repositioned bits.
	 */
	private static int sererateBits(int n) {
		n &= 0x0000ffff;
		n = (n ^ (n << 8)) & 0x00ff00ff;
		n = (n ^ (n << 4)) & 0x0f0f0f0f;
		n = (n ^ (n << 2)) & 0x33333333;
		n = (n ^ (n << 1)) & 0x55555555;
		return n;
	}
}