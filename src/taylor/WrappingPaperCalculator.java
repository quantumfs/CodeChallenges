package taylor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Calculates the amount of paper needed.
 * @author Taylor Moon
 */
public class WrappingPaperCalculator {
	
	public static void main(String[]args) throws IOException {
		int feet = 0;
		BufferedReader reader = new BufferedReader(new FileReader("data/wrappingdata.txt"));
		String line = "";
		int l = 0;
		int w = 0;
		int h = 0;
		int ribbon = 0;
		while ((line = reader.readLine()) != null) {
			String[] split = line.split("x");
			l = Integer.parseInt(split[0]);
			w = Integer.parseInt(split[1]);
			h = Integer.parseInt(split[2]);
			feet += (2*l*w) + (2*l*h) + (2*w*h) + min(l*w,l*h,w*h);
		    ribbon += (l*w*h) + 2*(l+w+h - max(l,w,h));
		}
		System.out.println("Total square feet: " + feet + " " + ribbon);
		reader.close();
	}
	
	private static int min(int...ints) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < ints.length; i++) {
			if (ints[i] < min) {
				min = ints[i];
			}
		}
		return min;
	}
	
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
