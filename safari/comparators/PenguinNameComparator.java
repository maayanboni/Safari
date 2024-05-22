package comparators;

import java.util.Comparator;

import animals.Penguin;

public class PenguinNameComparator implements Comparator<Penguin> {

	@Override
	public int compare(Penguin p1, Penguin p2) {
		return p1.getName().compareTo(p2.getName());
	}

}
