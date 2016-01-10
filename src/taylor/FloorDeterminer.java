package taylor;

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
		int[] data = getFloorData(line);
		System.out.println("Landed on floor " + data[0] + ", Entered basement at: " + data[1]);
		reader.close();
	}
	
	static int[] getFloorData(String input) {
		int[] floorData = new int[2];
		boolean enteredBasement = false;
		int charPos = 0;
		for (Character character : input.toCharArray()) {
			charPos++;
			if (directionForCharacter(character) == 1) {
				floorData[0]++;
			} else {
				floorData[0]--;
				if (!enteredBasement && floorData[0] == -1) {
					floorData[1] = charPos;
					enteredBasement = true;
				}
			}
		}
		return floorData;
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
