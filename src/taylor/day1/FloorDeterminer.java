package taylor.day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Determines which floor santa will land on (code challenge #1)
 * @author Taylor Moon
 */
public class FloorDeterminer {

	/**
	 * The main method.
	 * @param args The arguments on runtime.
	 * @throws IOException If an exception occurs while reading the input file.
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("data/floordata.txt"));
		String line = reader.readLine();
		FloorInformation floorInfo = parseFloorInformation(line);
		System.out.println("Landed on floor " + floorInfo.getFloorLandedOn() + ", Entered basement at: " + floorInfo.getIntialBasementEntracePoint());
		reader.close();
	}
	
	/**
	 * Parses the floor information based on the given input string.
	 * @param input The input.
	 * @return The floor information that was parsed.
	 */
	static FloorInformation parseFloorInformation(String input) {
		FloorInformation floorInfo = new FloorInformation();
		boolean enteredBasement = false;
		int charPos = 0;
		for (Character character : input.toCharArray()) {
			charPos++;
			if (directionForCharacter(character) == 1) {
				floorInfo.increaseFloorLandedOn(1);
			} else {
				floorInfo.increaseFloorLandedOn(-1);
				if (!enteredBasement && floorInfo.getFloorLandedOn() == -1) {
					floorInfo.setIntialBasementEntracePoint(charPos);
					enteredBasement = true;
				}
			}
		}
		return floorInfo;
	}
	
	/**
	 * Returns a direction based on the character given in the parameters.
	 * @param character The character to get the direction of.
	 * @return The direction.
	 */
	private static int directionForCharacter(char character) {
		if (character == '(') {
			return 1;
		} else if(character == ')') {
			return 0;
		} else {
			throw new IllegalArgumentException("No direction for character: " + character);
		}
	}
}
