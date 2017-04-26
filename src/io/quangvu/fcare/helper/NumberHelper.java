package io.quangvu.fcare.helper;

import java.util.Random;

public class NumberHelper {
	
	public static int getRandomInt(int max, int min) {
		Random rand = new Random();
		return rand.nextInt(max - min) + min;
	}
}
