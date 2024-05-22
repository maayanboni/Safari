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

public class AquariumFish extends Animal {
	public static final int LIFESPAN = 25;
	protected double length;
	protected Patterns pattern;
	protected Colors[] color;

	// finals
	final int STARTFOOD = 3;

	// c'tors
	public AquariumFish(int age, double length, Colors[] color) {
		super(age);
		this.length = length;
		this.color = color;

	}

	public AquariumFish(int age, double length, Patterns pattern, Colors[] color) {
		super(age);
		this.length = length;
		this.pattern = pattern;
		this.color = color;
	}

	// getters and setters
	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public Patterns getPattern() {
		return pattern;
	}

	public Colors[] getColor() {
		return color;
	}

	public String toString() {
		return "AquariumFish [age=" + age + ", length=" + length + ", pattern=" + pattern + ", color="
				+ Arrays.toString(color) + "]";
	}

	// functions
	public String makeNoise() {
		return "blob ";
	}

	public double feed() {
		if (this.age < STARTFOOD) {
			return STARTFOOD;
		}
		return STARTFOOD + this.length;
	}

	@Override
	public void randomHappiness() {
		Random rand = new Random(System.currentTimeMillis());
		this.happiness -= rand.nextInt(25);

	}
}