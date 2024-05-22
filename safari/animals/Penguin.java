package animals;

import java.util.Random;

/**
 * 
 * @author Kim
 * @author Maayan
 *
 */

public class Penguin extends Animal {
	public static final int LIFESPAN = 6;
	private double height;
	private String name;

	// c'tor
	public Penguin(int age, double height, String name) {
		super(age);
		this.height = height;
		this.name = name;
	}

	// getters and setters
	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// to string
	public String toString() {
		return "Penguin [age=" + age + ", height=" + height + ", name=" + name + "] ";
	}

	// penguin Noise
	public String makeNoise() {
		return "squack ";
	}

	@Override
	public double feed() {
		return 1;
	}
	
	@Override
	public void randomHappiness() {
		Random rand = new Random(System.currentTimeMillis());
		this.happiness -= rand.nextInt(78);

	}

}