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

public class GoldFish extends AquariumFish {
	public static final int LIFESPAN = 12;

	public GoldFish(int age, double length, Colors[] color) {
		super(age, length, color);
		this.pattern = Patterns.SMOOTH;

	}

	@Override
	public String toString() {
		return "GoldFish [age=" + age + ", length=" + length + ", pattern=" + pattern + ", color="
				+ Arrays.toString(color) + "]";
	}

	@Override
	public double feed() {
		return 1;
	}

	@Override
	public void randomHappiness() {
		Random rand = new Random(System.currentTimeMillis());
		this.happiness -= rand.nextInt(33);

	}

}
