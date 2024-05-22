package animals;

import java.util.Arrays;

import enums.Colors;

/**
 * 
 * @author Maayan
 *
 */

public class GiantPanda extends Bear {

	public GiantPanda(int age, String name, double weight, Colors[] color) {
		super(age, name, weight, color);

	}

	@Override
	public String toString() {
		return "GiantPanda [name=" + name + ", weight=" + weight + ", color=" + Arrays.toString(color) + ", happiness="
				+ happiness + ", age=" + age + "]";
	}

	@Override
	public double feed() {
		return (Math.random() * (38 - 12)) + 12;
	}

	@Override
	public String makeNoise() {
		return "neeeeh ";
	}
}
