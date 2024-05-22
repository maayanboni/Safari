package animals;

import java.util.Random;

import enums.genderEnum;

public abstract class Predator extends Animal {

	public static final int LIFESPAN = 15;
	protected String name;
	protected double weight;
	protected genderEnum gender;

	public Predator(String name, int age, double weight, genderEnum gender) {
		super(age);
		this.name = name;
		this.weight = weight;
		this.gender = gender;
	}

	// getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public genderEnum getGender() {
		return gender;
	}

	public void setGender(genderEnum gender) {
		this.gender = gender;
	}

	// general functions

	public abstract double feed();

	public abstract String makeNoise();

	public void randomHappiness() {
		Random rand = new Random(System.currentTimeMillis());
		this.happiness -= rand.nextInt(50); // generate random happiness level from 0 to 50 since predators lifespan is
											// 15 so they wont die easily
	}

}
