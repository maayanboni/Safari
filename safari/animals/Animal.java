package animals;

public abstract class Animal {
	protected int happiness;
	protected int age;

	// c'tor
	public Animal(int age) {
		this.happiness = 100;
		this.age = age;
	}

	// getters and setters
	public int getHappiness() {
		return happiness;
	}

	public void setHappiness(int happiness) {
		this.happiness = happiness;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public abstract String makeNoise();

	public abstract double feed();

	public void ageOneYear() {
		this.age++;
	}
	
	public abstract void randomHappiness();

}
