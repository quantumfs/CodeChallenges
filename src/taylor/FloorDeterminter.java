package taylor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Determines which floor santa will land on (code challenge #1)
 * @author Taylor Moon
 */
public class FloorDeterminter {

	/**
	 * The main method.
	 * @param args The arguments on runtime.
	 * @throws IOException If an exception occurs while reading the input file.
	 */
	public static void main(String[] args) throws IOException {
		int floor = 0;
		int charPos = 0;
		boolean enteredBasement = false;
		BufferedReader reader = new BufferedReader(new FileReader("data/floordata.txt"));
		String line = "";
		while ((line = reader.readLine()) != null) {
			for (Character character : line.toCharArray()) {
				charPos++;
				if (directionForCharacter(character) == 1) {
					floor++;
				} else {
					floor--;
					if (!enteredBasement && floor == -1) {
						enteredBasement = true;
						System.out.println("Entered basement at " + charPos + ".");
					}
				}
			}
		}
		System.out.println("Landed on floor " + floor);
		reader.close();
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
