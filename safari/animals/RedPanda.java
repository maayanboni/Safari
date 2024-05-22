package animals;

import java.util.Arrays;

import enums.Colors;

/**
 * 
 * @author Kim
 *
 */

public class RedPanda extends Bear {

	public RedPanda(int age, String name, double weight, Colors[] color) {
		super(age, name, weight, color);
	}

	@Override
	public String toString() {
		return "RedPanda [name=" + name + ", weight=" + weight + ", color=" + Arrays.toString(color) + ", happiness="
				+ happiness + ", age=" + age + "]";
	}

	@Override
	public double feed() {
		return (Math.random() * (18 - 6)) + 6;
	}

	@Override
	public String makeNoise() {
		return "huff-quack ";
	}

}
