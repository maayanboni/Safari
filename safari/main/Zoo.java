package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

import animals.AquariumFish;
import animals.Bear;
import animals.ClownFish;
import animals.GoldFish;
import animals.Penguin;
import animals.Predator;
import animals.RedPanda;
import animals.Tiger;
import comparators.BearMinimumComparator;
import comparators.PenguinAgeComparator;
import comparators.PenguinHeightComparator;
import comparators.PenguinNameComparator;
import enums.Colors;
import enums.Patterns;

public class Zoo {
	private String name;
	private String address;
	private ArrayList<AquariumFish> aquarium = new ArrayList<AquariumFish>();
	private ArrayList<Predator> predators = new ArrayList<Predator>();
	private ArrayList<Penguin> penguins = new ArrayList<Penguin>();
	private ArrayList<Bear> bears = new ArrayList<Bear>();

	// c'tor
	public Zoo(String name, String address) {
		this.name = name;
		this.address = address;
	}

	// getters and setters

	public ArrayList<AquariumFish> getAquarium() {
		return aquarium;
	}

	public ArrayList<Bear> getBears() {
		return bears;
	}

	public ArrayList<Penguin> getPenguins() {
		return penguins;
	}

	public ArrayList<Predator> getPredators() {
		return predators;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String toString() {
		return "Zoo [name=" + name + ", address=" + address + "]";
	}

	// Penguins //

	public void addPenguin(Penguin newPenguin, int sort) throws ZooExceptions {
		if (penguins.size() == 0) {
			penguins.add(newPenguin);
		} else {
			if (newPenguin.getAge() <= 0 || newPenguin.getAge() >= 30)
				throw new ZooExceptions("invalid age", "The penguin's age cant be negative or too high");
			if (newPenguin.getHeight() >= penguins.get(0).getHeight()) {
				throw new ZooExceptions("invalid height", "the penguin can't be higher than the leader");
			} else {
				if (newPenguin.getHeight() <= 0) {
					throw new ZooExceptions("invalid height", "Height cant be negative or zero");
				}
			}
			penguins.add(newPenguin);
		}

		penguinSort(sort);
	}

	public int countOrFeedPenguin() { // also to feed penguin
		for (int i = 0; i < penguins.size(); i++) {
			penguins.get(i).setHappiness(100);
		}
		return penguins.size();
	}

	public void printAllPenguin() {
		for (int i = 0; i < penguins.size(); i++) {
			System.out.println(penguins.get(i).toString());
		}
	}

	public void penguinSort(int sort) {// 0 for height, 1 for age, 2 for name(alphabetic)
		if (sort == 0) {
			Collections.sort(penguins, new PenguinHeightComparator());
		} else if (sort == 1) {
			Collections.sort(penguins, new PenguinAgeComparator());

		} else
			Collections.sort(penguins, new PenguinNameComparator());
	}

	// Predators//

	public void addPredators(Predator newPredator) {
		predators.add(newPredator);
	}

	public void printPredators() {
		for (Predator carnivore : predators) {
			System.out.println(carnivore.toString());
		}

	}

	public double feedAllPredators() {
		double sum = 0;
		for (Predator carnivore : predators) {
			sum += carnivore.feed();
			carnivore.setHappiness(100);
		}
		return sum;
	}

	public String countPredators() {
		int countLions = 0;
		int countTiger = 0;

		for (Predator pred : predators) {
			if (pred instanceof Tiger) {
				countTiger++;
			} else {
				countLions++;
			}
		}
		return countLions + " lions, " + countTiger + " tigers ";
	}

	// Bears
	// we did the bear minimum
	public void addBears(Bear newBear) {
		bears.add(newBear);
	}

	public void printBears() {
		for (Bear bear : bears) {
			System.out.println(bear.toString());
		}
	}

	public double feedAllBears() {
		double sum = 0;
		for (Bear bear : bears) {
			sum += bear.feed();
			bear.setHappiness(100);
		}
		return sum;
	}

	public String countBears() {
		int countRedPandas = 0;
		int countGiantPandas = 0;

		for (Bear bear : bears) {
			if (bear instanceof RedPanda) {
				countRedPandas++;
			} else {
				countGiantPandas++;
			}
		}
		return countRedPandas + " red pandas, " + countGiantPandas + " giant pandas ";
	}

	public void weDidTheBearMinimum() {
		Collections.sort(bears, new BearMinimumComparator());
		System.out.println("We found the skinniest bear !");
	}
	// fish

	// add fish - 2 options
	public void addSpecificFish(AquariumFish newFish) {
		aquarium.add(newFish);
	}

	public void addFish(int n) {
		int age, patternValueCount, randomIndexPattern, colorValueCount, colorAmount, randomIndexColors;
		double length;
		Patterns pattern;
		Colors[] color;
		AquariumFish newFish;
		boolean checkAgain = true;
		int type;
		Colors[] goldFishOp = { Colors.BLACK, Colors.ORANGE, Colors.GOLD, Colors.YELLOW };

		patternValueCount = Patterns.values().length;
		colorValueCount = Colors.values().length;

		Random rand = new Random(System.currentTimeMillis());
		for (int i = 0; i < n; i++) {
			type = rand.nextInt(3); // random type(0-aqua, 1-gold, 2-clown)

			age = rand.nextInt(7); // random age

			length = rand.nextDouble(25); // random length

			if (type == 0) { // aqua fish
				// random pattern
				randomIndexPattern = rand.nextInt(patternValueCount);
				pattern = Patterns.values()[randomIndexPattern];

				// random colors
				colorAmount = rand.nextInt(colorValueCount) + 1;
				color = new Colors[colorAmount];// new array
				for (int j = 0; j < colorAmount; j++) {
					randomIndexColors = rand.nextInt(colorValueCount);

					// check if we don't have this color already
					while (checkAgain == true) {
						checkAgain = false;
						for (int k = 0; k < j; k++) {
							if (color[k] == Colors.values()[randomIndexColors]) {
								randomIndexColors = rand.nextInt(colorValueCount);
								checkAgain = true;
								break;
							}
						}
					}
					color[j] = Colors.values()[randomIndexColors];
					checkAgain = true;
				}
				newFish = new AquariumFish(age, length, pattern, color);

			} else if (type == 1) { // gold fish
				randomIndexColors = rand.nextInt(goldFishOp.length);
				color = new Colors[1];
				color[0] = goldFishOp[randomIndexColors];
				newFish = new GoldFish(age, length, color);

			} else { // clown fish
				color = new Colors[3];
				color[0] = Colors.ORANGE;
				color[1] = Colors.BLACK;
				color[2] = Colors.WHITE;
				newFish = new ClownFish(age, length, color);
			}

			aquarium.add(newFish);
		}
	}

	// feed aquarium
	public double feedAllFish() {
		double count = 0;
		for (int i = 0; i < aquarium.size(); i++) {
			count += aquarium.get(i).feed();
			aquarium.get(i).setHappiness(100);
		}
		return count;
	}

	// aquarium fish colors
	public Colors[] zooFishColors() {
		int count = Colors.values().length;
		boolean isInside = false;
		Colors[] colorsInAquarium = new Colors[count];
		int newArraySize = 0;
		Colors color;

		for (int i = 0; i < count; i++) {
			for (int j = 0; j < aquarium.get(i).getColor().length; j++) {
				color = aquarium.get(i).getColor()[j];
				for (int k = 0; k < newArraySize; k++) {
					if (color == colorsInAquarium[k]) {
						isInside = true;
						break;
					}
				}
				if (!isInside) {
					colorsInAquarium[newArraySize] = color;
					newArraySize++;
				}
				isInside = false;
			}
		}

		return colorsInAquarium;
	}

	public void printFish() {
		for (int i = 0; i < aquarium.size(); i++) {
			System.out.println(aquarium.get(i).toString());
		}
	}

	// count fish in aquarium according to type
	public String countFish() {
		int countAquaFish = 0;
		int countGoldFish = 0;
		int countClownFish = 0;

		for (AquariumFish fish : aquarium) {
			if (fish instanceof GoldFish) {
				countGoldFish++;
			} else if (fish instanceof ClownFish) {
				countClownFish++;
			} else {
				countAquaFish++;
			}
		}
		return countAquaFish + " aquarium fish, " + countGoldFish + " gold fish and " + countClownFish + " clown fish ";
	}

	// 2 domain colors in the aquarium
	public String domainFishColor() {
		int[] countColors = new int[Colors.values().length];
		int colorIndex, max1, max2;
		Colors color;

		// fill array with the amount of time it appear
		// the index of the cell is the index of the enum
		for (int i = 0; i < aquarium.size(); i++) {
			for (int j = 0; j < aquarium.get(i).getColor().length; j++) {
				color = aquarium.get(i).getColor()[j];
				colorIndex = color.ordinal();
				countColors[colorIndex]++;
			}
		}

		max1 = 0; // color in index 0
		max2 = 1; // color in index 1
		for (int i = 2; i < countColors.length - 1; i = i + 2) {
			if (countColors[i] > countColors[max1]) {
				max1 = i;
			}
			if (countColors[i + 1] > countColors[max2]) {
				max2 = i + 1;
			}
		}

		return "the 2 domain colors are: " + Colors.values()[max1] + " , " + Colors.values()[max2];

	}

	// ageOneYear
	public void ageOneYearAllAnimals() {
		// Aquarium
		for (int i = 0; i < aquarium.size(); i++) {
			aquarium.get(i).ageOneYear();
			if (aquarium.get(i) instanceof GoldFish) {
				if (aquarium.get(i).getAge() > GoldFish.LIFESPAN) {
					System.out.println("gold fish " + i + " died");
					aquarium.remove(i);
				} else {
					aquarium.get(i).randomHappiness();
				}
			} else if (aquarium.get(i) instanceof ClownFish) {
				if (aquarium.get(i).getAge() > ClownFish.LIFESPAN) {
					System.out.println("clown fish " + i + " died");
					aquarium.remove(i);
				} else {
					aquarium.get(i).randomHappiness();
				}
			} else {
				if (aquarium.get(i).getAge() > AquariumFish.LIFESPAN) {
					System.out.println("aqua fish " + i + " died");
					aquarium.remove(i);
				} else {
					aquarium.get(i).randomHappiness();
				}
			}
		}

		// Predators
		for (int i = 0; i < predators.size(); i++) {
			predators.get(i).ageOneYear();
			if (predators.get(i).getAge() > Predator.LIFESPAN) {
				System.out.println("predator " + predators.get(i).getName() + " died");
				predators.remove(i);
			} else {
				predators.get(i).randomHappiness();
			}
		}

		// Penguin
		for (int j = 0; j < penguins.size(); j++) {
			penguins.get(j).ageOneYear();
			if (penguins.get(j).getAge() > Penguin.LIFESPAN) {
				System.out.println("penguin " + penguins.get(j).getName() + " died");
				penguins.remove(j);
			} else {
				penguins.get(j).randomHappiness();

			}
		}
		// Bear
		for (int i = 0; i < bears.size(); i++) {
			bears.get(i).ageOneYear();
			if (bears.get(i).getAge() > Bear.LIFESPAN) {
				System.out.println("bear " + bears.get(i).getName() + " died");
				bears.remove(i);
			} else {
				bears.get(i).randomHappiness();
			}
		}
		checkHappiness();
	}

	// check Happiness
	public void checkHappiness() {
		Iterator<Penguin> penguinRator = penguins.iterator();
		Iterator<Predator> predaRator = predators.iterator();
		Iterator<AquariumFish> fishRator = aquarium.iterator();
		Iterator<Bear> bearRator = bears.iterator();
		while (penguinRator.hasNext()) {
			Penguin peng = penguinRator.next();
			if (peng.getHappiness() <= 0)
				penguinRator.remove();
		}
		while (predaRator.hasNext()) {
			Predator pred = predaRator.next();
			if (pred.getHappiness() <= 0)
				predaRator.remove();
		}
		while (fishRator.hasNext()) {
			AquariumFish fish = fishRator.next();
			if (fish.getHappiness() <= 0)
				fishRator.remove();
		}
		while (bearRator.hasNext()) {
			Bear bear = bearRator.next();
			if (bear.getHappiness() <= 0)
				bearRator.remove();
		}

	}

	// show all animals happiness
	public void showHappiness() {
		System.out.println("animals happiness : ");
		for (int i = 0; i < aquarium.size(); i++) {
			System.out.print("fish '" + i + "' " + aquarium.get(i).getHappiness() + " ,");
		}
		System.out.println();
		for (int i = 0; i < penguins.size(); i++) {
			System.out.print("penguin '" + i + "' " + penguins.get(i).getHappiness() + " ,");
		}
		System.out.println();
		for (int i = 0; i < predators.size(); i++) {
			System.out.print("predator '" + i + "' " + predators.get(i).getHappiness() + " ,");
		}
		System.out.println();
		for (int i = 0; i < bears.size(); i++) {
			System.out.print("bear '" + i + "' " + bears.get(i).getHappiness() + " ,");
		}
	}

}
