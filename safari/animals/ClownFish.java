package animals;

import java.util.Arrays;
import java.util.Random;

import enums.Colors;
import enums.Patterns;

/**
 * 
 * @author Maayan
 *
 */

public class ClownFish extends AquariumFish {
	public static final int LIFESPAN = 8;

	public ClownFish(int age, double length, Colors[] color) {
		super(age, length, color);
		this.pattern = Patterns.STRIPES;
	}

	@Override
	public String toString() {
		return "ClownFish [age=" + age + ", length=" + length + ", pattern=" + pattern + ", color="
				+ Arrays.toString(color) + "]";
	}

	@Override
	public double feed() {
		return 2;
	}
	
	@Override
	public void randomHappiness() {
		Random rand = new Random(System.currentTimeMillis());
		this.happiness -= rand.nextInt(40);

	}

}
