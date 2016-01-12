package taylor.day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Calculates the amount of paper needed.
 * @author Taylor Moon
 */
public class WrappingPaperCalculator {
	
	/**
	 * The main method.
	 * @param args The arguments casted on runtime.
	 * @throws IOException If there is an exception while reading the input file.
	 */
	public static void main(String[]args) throws IOException {
		int feet = 0;
		BufferedReader reader = new BufferedReader(new FileReader("data/wrappingdata.txt"));
		String line = "";
		int ribbon = 0;
		WrappingPaperDimensions dimensions;
		while ((line = reader.readLine()) != null) {
			dimensions = getWrappingPaperDimensions(line);
			feet += dimensions.getPaperFeet();
			ribbon += dimensions.getRibbonFeet();
		}
		System.out.println("Total square feet: " + feet + " " + ribbon);
		reader.close();
	}
	
	/**
	 * Returns an integer array containing the number of feet and number of
	 * ribbon based on the given dimensions.
	 * 
	 * @param input The input dimensions.
	 * @return The array.
	 */
	static WrappingPaperDimensions getWrappingPaperDimensions(String input) {
		String[] split = input.split("x");
		int l = Integer.parseInt(split[0]);
		int w = Integer.parseInt(split[1]);
		int h = Integer.parseInt(split[2]);
		int paperLength = (2 * l * w) + (2 * l * h) + (2 * w * h) + min(l * w, l * h, w * h);
		int ribbonLength = (l * w * h) + 2 * (l + w + h - max(l, w, h));
		return new WrappingPaperDimensions(paperLength, ribbonLength);
	}
	
	/**
	 * Returns the smallest integer in an integer array.
	 * @param ints The integers to compare.
	 * @return The smallest integer.
	 */
	private static int min(int...ints) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < ints.length; i++) {
			if (ints[i] < min) {
				min = ints[i];
			}
		}
		return min;
	}
	
	/**
	 * Returns the largest integer in an integer array.
	 * @param ints The integers to compare.
	 * @return The largest integer.
	 */
	private static int max(int...ints) {
		int max = 0;
		for (int i = 0; i < ints.length; i++) {
			if (ints[i] > max) {
				max = ints[i];
			}
		}
		return max;
	}
}
