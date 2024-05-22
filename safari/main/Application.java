package main;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import animals.AquariumFish;
import animals.Bear;
import animals.ClownFish;
import animals.GiantPanda;
import animals.GoldFish;
import animals.Lion;
import animals.Penguin;
import animals.Predator;
import animals.RedPanda;
import animals.Tiger;
import enums.Colors;
import enums.Patterns;
import enums.genderEnum;

public class Application {

	public static Scanner scn = new Scanner(System.in);
	public static boolean success = false;
	public static int sort = 0;

	public static void main(String[] args) throws Exception {
		Zoo maayanAndKimZoo = new Zoo("maayanAndKimZoo", "Tel Aviv");

		Penguin leader = new Penguin(7, 200, "leader");
		maayanAndKimZoo.addPenguin(leader, sort);

		Penguin p1 = new Penguin(4, 180, "p1");
		maayanAndKimZoo.addPenguin(p1, sort);

		Penguin p2 = new Penguin(5, 190, "p2");
		maayanAndKimZoo.addPenguin(p2, sort);

		Lion l1 = new Lion("Arie", 5, 175, genderEnum.MALE);// male above 25kg
		maayanAndKimZoo.addPredators(l1);
		Lion l2 = new Lion("Aria", 6, 160, genderEnum.FEMALE);// female above 25kg
		maayanAndKimZoo.addPredators(l2);
		Lion l3 = new Lion("Alex", 3, 140, genderEnum.MALE);// male below 25kg
		maayanAndKimZoo.addPredators(l3);
		Lion l4 = new Lion("Nala", 4, 150, genderEnum.FEMALE);// female below 25kg
		maayanAndKimZoo.addPredators(l4);

		maayanAndKimZoo.addFish(10);

		int questionNum;
		do {
			System.out.println("		\n===== MENU =====\n" + " 1. show zoo details\n"
					+ " 2. show all the penguin details\n" + " 3. add new penguin\n"
					+ " 4. show all the predators details\n" + " 5. add new predator\n"
					+ " 6. show all the aquarium fish details \n" + " 7. add new fish(2 options)\n"
					+ " 8. show all the bears details \n" + " 9. add new bear \n" + " 10. feed all animals in zoo \n"
					+ " 11. all zoo animals make noise \n" + " 12. age one year all animals \n"
					+ " 13. sort penguins (3 options) \n" + " 14. exit\n" + " Enter your choice (1-9):");
			questionNum = scn.nextInt();
			switch (questionNum) {
			case 1:
				maayanAndKimZoo.toString();
				System.out.print("we have " + maayanAndKimZoo.countOrFeedPenguin() + " pengiuns, "
						+ maayanAndKimZoo.countPredators() + ", " + maayanAndKimZoo.countFish() + ", "
						+ maayanAndKimZoo.countBears());
				break;

			case 2:
				System.out.println("penguin details :");
				maayanAndKimZoo.printAllPenguin();
				break;

			case 3:
				while (!success) {
					Penguin newPenguin = penguinInput();
					try {
						maayanAndKimZoo.addPenguin(newPenguin, sort);
						success = true;
					} catch (ZooExceptions e) {
						System.out.println(e.getErrorDesc());
						System.out.println("please try again");
						scn.nextLine();
					}
				}
				success = false;
				System.out.println("penguin added succesfuly");
				break;

			case 4:
				System.out.println("the predators details :");
				maayanAndKimZoo.printPredators();
				break;

			case 5:
				Predator newPredator = predatorInput();
				maayanAndKimZoo.addPredators(newPredator);
				System.out.println("predator added succesfully");
				break;

			case 6:
				System.out.println("we have " + maayanAndKimZoo.countFish());
				maayanAndKimZoo.printFish();
				System.out.println("the aquarium fishes colors are: ");
				System.out.println(Arrays.toString(maayanAndKimZoo.zooFishColors()));
				System.out.println(maayanAndKimZoo.domainFishColor());

				break;

			case 7:
				System.out.println("choose 1 to add a specific fish or 2 to add multiple fish ");
				int choice = scn.nextInt();
				while (choice != 1 && choice != 2) {
					System.out.println("choose 1 to add a specific fish or 2 to add multiple fish ");
					choice = scn.nextInt();
				}
				switch (choice) {
				case 1:
					// input fish details from user
					AquariumFish newFish = fishInput();
					maayanAndKimZoo.addSpecificFish(newFish);
					System.out.println("fish added succesfully");
					break;
				case 2:
					System.out.println("enter how many fishes would you like to enter randomaly :");
					int n = scn.nextInt();
					maayanAndKimZoo.addFish(n);
					System.out.println(n + " fishes added succesfully");
					break;
				default:
					System.out.println("wrong choice");
					break;
				}
				break;

			case 8:
				System.out.println("The bears details: ");
				if (maayanAndKimZoo.getBears().size() == 0) {
					System.out.println("no bears in our zoo");
				} else {
					maayanAndKimZoo.printBears();
				}
				break;
			case 9:
				Bear bear = bearInput();
				maayanAndKimZoo.addBears(bear);
				System.out.println("Bear added successfully");
				break;
			case 10:
				System.out.println(
						"the penguins eat " + maayanAndKimZoo.countOrFeedPenguin() + " fishes ,the predators eat "
								+ maayanAndKimZoo.feedAllPredators() + "kg meat and the fishes eat "
								+ maayanAndKimZoo.feedAllFish() + "the bears eat " + maayanAndKimZoo.feedAllBears());
				maayanAndKimZoo.showHappiness();
				break;

			case 11:
				for (int i = 0; i < maayanAndKimZoo.getAquarium().size(); i++) {
					System.out.print(maayanAndKimZoo.getAquarium().get(i).makeNoise());
				}
				for (int i = 0; i < maayanAndKimZoo.getPenguins().size(); i++) {
					System.out.print(maayanAndKimZoo.getPenguins().get(i).makeNoise());
				}
				for (int i = 0; i < maayanAndKimZoo.getPredators().size(); i++) {
					System.out.print(maayanAndKimZoo.getPredators().get(i).makeNoise());
				}
				for (int i = 0; i < maayanAndKimZoo.getBears().size(); i++) {
					System.out.print(maayanAndKimZoo.getBears().get(i).makeNoise());
				}
				break;
			case 12:
				maayanAndKimZoo.ageOneYearAllAnimals();
				maayanAndKimZoo.showHappiness();
				break;
			case 13:
				System.out.println(
						"Which way to sort the penguins: (0 for height (default), 1 for age, 2 for alphabetic)");
				sort = scn.nextInt();
				maayanAndKimZoo.penguinSort(sort);
				break;
			case 14:
				break;
			}

		} while (questionNum != 14);
		{
			System.out.println("bye");
		}
	}

	// input penguin details from user
	public static Penguin penguinInput() throws Exception {
		// age input
		int pengAge = 0;
		double pengHeight = 0;
		boolean finished = false;
		while (!finished) {
			try {
				System.out.println("enter age of the penguin :");
				pengAge = scn.nextInt();
				finished = true;
			} catch (InputMismatchException e) {
				System.out.println("invalid integer");
				scn.nextLine();
			}
		}

		// height input
		finished = false;
		while (!finished) {
			try {
				System.out.println("enter height of the penguin :");
				pengHeight = scn.nextInt();
				finished = true;
			} catch (InputMismatchException e) {
				System.out.println("invalid integer");
				scn.nextLine();
			}
		}

		// name input
		System.out.println("enter name of the penguin :");
		String pengName = scn.next();
		Penguin newPenguin = new Penguin(pengAge, pengHeight, pengName);
		return newPenguin;
	}

	// input predators details from user
	public static Predator predatorInput() {
		Predator newPredator;

		// type input
		System.out.println("enter type of predator: 0 for lion, 1 for tiger");
		int type = readInRange(0, 1, scn);

		// name input
		System.out.println("enter name of the predator");
		String lionName = scn.next();
		// age input
		System.out.println("enter age of the predator :");
		int lionAge = readInRange(0, 25, scn);

		// weight input
		System.out.println("enter weight of the predator :");
		double lionWeight = readInRange(0, 250, scn);

		// gender input
		System.out.println("enter 0 for female and 1 for male");
		int genderChoice = readInRange(0, 1, scn);
		genderEnum lionGender = genderEnum.values()[genderChoice];

		if (type == 0) {
			newPredator = new Lion(lionName, lionAge, lionWeight, lionGender);
		} else {
			newPredator = new Tiger(lionName, lionAge, lionWeight, lionGender);
		}

		return newPredator;
	}

	// input fish details from user
	public static AquariumFish fishInput() {
		AquariumFish newFish = null;
		int fishType, fishAge, patternChoice, colorAmount, color;
		double fishLength;
		Patterns fishPattern;
		boolean isColorIn;
		Colors[] fishColors;
		Colors fishColor;
		Colors[] goldFishOp = { Colors.BLACK, Colors.ORANGE, Colors.GOLD, Colors.YELLOW };

		// type input
		System.out.println("enter type of the fish: 1 for aquariumfish, 2 for goldfish, 3 for clownfish");
		fishType = readInRange(1, 3, scn);

		// length input
		System.out.println("enter fish length");
		fishLength = readInRange(0.0, 20.0, scn);

		if (fishType == 1) { // aqua fish
			// age input
			System.out.println("enter fish age");
			fishAge = readInRange(0, 25, scn);
			// pattern input
			System.out.println("enter 0 for DOTS or 1 for STRIPES, or 2 for SPOTS, or 3 for SMOOTH");
			patternChoice = readInRange(0, 3, scn);
//			patternChoice = scn.nextInt();
			fishPattern = Patterns.values()[patternChoice];
			// colors input
			isColorIn = true;
			System.out.println("enter how many colors for the fish :");
			colorAmount = scn.nextInt();
			fishColors = new Colors[colorAmount];
			System.out.println(
					"fish colors : 0 BLACK, 1 WHITE, 2 GREEN, 3 ORANGE, 4 BLUE, 5 YELLOW, 6 BROWN, 7 GOLD, 8 RED, 9 CYAN");
			for (int i = 0; i < colorAmount; i++) {
				System.out.println("enter color number " + (i + 1));
				color = readInRange(0, 9, scn);
				fishColor = Colors.values()[color];
				while (isColorIn == true) {
					isColorIn = false;
					for (int j = 0; j < i; j++) {
						if (fishColors[j] == fishColor) {
							System.out.println("color inside already, please choose again ");
							color = scn.nextInt();
							fishColor = Colors.values()[color];
							isColorIn = true;
							break;
						}
					}
				}
				fishColors[i] = Colors.values()[color];
				isColorIn = true;
			}
			newFish = new AquariumFish(fishAge, fishLength, fishPattern, fishColors);
		} else if (fishType == 2) { // gold fish
			System.out.println("enter fish age");
			fishAge = readInRange(0, 12, scn);
			System.out.println("choose color: 1-orange, 2-gold, 3-yellow, 4-black");
			color = scn.nextInt();
			while ((color > 4) || (color < 1)) {
				System.out.println("invalid choice, try again ");
				color = readInRange(1, 4, scn);
			}
			fishColors = new Colors[1];
			fishColors[0] = goldFishOp[color];
			newFish = new GoldFish(fishAge, fishLength, fishColors);
		} else {
			System.out.println("enter fish age");
			fishAge = readInRange(0, 8, scn);
			fishColors = new Colors[3];
			fishColors[0] = Colors.ORANGE;
			fishColors[1] = Colors.BLACK;
			fishColors[2] = Colors.WHITE;
			newFish = new ClownFish(fishAge, fishLength, fishColors);
		}

		return newFish;
	}

	// input bear details from user
	public static Bear bearInput() {
		Bear newBear;

		// type input
		System.out.println("enter type of bear: 0 for giant panda, 1 for red panda");
		int type = readInRange(0, 1, scn);

		// name input
		System.out.println("enter name of the bear");
		String bearName = scn.next();
		// age input
		System.out.println("enter age of the bear :");
		int bearAge = readInRange(0, 15, scn);

		// weight input
		System.out.println("enter weight of the bear :");
		double bearWeight;

		// color+weight input
		Colors bearColor[];
		if (type == 0) {
			bearWeight = readInRange(75, 165, scn);
			bearColor = new Colors[2];
			bearColor[0] = Colors.BLACK;
			bearColor[1] = Colors.WHITE;

		} else {
			bearWeight = readInRange(5, 20, scn);
			bearColor = new Colors[3];
			bearColor[0] = Colors.BLACK;
			bearColor[1] = Colors.WHITE;
			bearColor[2] = Colors.RED;
		}

		if (type == 0) {
			newBear = new GiantPanda(bearAge, bearName, bearWeight, bearColor);
		} else {
			newBear = new RedPanda(bearAge, bearName, bearWeight, bearColor);
		}

		return newBear;
	}

	@SuppressWarnings("unchecked")
	public static <T extends Number> T readInRange(T min, T max, Scanner scanner) {
		T value = null;
		boolean finished = false;
		while (!finished) {
			try {
				if (min instanceof Integer) {
					value = (T) Integer.valueOf(scanner.nextInt());
				} else if (min instanceof Double) {
					value = (T) Double.valueOf(scanner.nextDouble());
				} else if (min instanceof Long) {
					value = (T) Long.valueOf(scanner.nextLong());
				} else {
					System.out.println("I don't know what type of number this is...");
				}
				if (min.doubleValue() <= value.doubleValue() && value.doubleValue() <= max.doubleValue()) {
					finished = true;
				} else {
					System.out.println("Please enter a value between " + min + " and " + max + ".");
				}
			} catch (InputMismatchException e) {
				System.out.println("Please enter a valid number.");
				scanner.nextLine(); // Consume invalid input
			}
		}
		scanner.nextLine(); // Consume newline
		return value;
	}

}
