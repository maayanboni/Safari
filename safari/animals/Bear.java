package animals;

import java.util.Random;

import enums.Colors;

public abstract class Bear extends Animal {

	public static final int LIFESPAN = 15;
	protected String name;
	protected double weight;
	protected Colors[] color;

	// c'tor
	public Bear(int age, String name, double weight, Colors[] color) {
		super(age);
		this.name = name;
		this.weight = weight;
		this.color = color;
	}

	// getters and setters
	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public Colors[] getColor() {
		return color;
	}

	// general functions

	public abstract double feed();

	public abstract String makeNoise();

	public void randomHappiness() {
		Random rand = new Random(System.currentTimeMillis());
		this.happiness -= rand.nextInt(50); // generate random happiness level from 0 to 70 since predators lifespan is
											// 15 so they wont die easily
	}

}
