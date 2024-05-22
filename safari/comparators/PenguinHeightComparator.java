package comparators;

import java.util.Comparator;

import animals.Penguin;

public class PenguinHeightComparator implements Comparator<Penguin> {

	@Override
	public int compare(Penguin p1, Penguin p2) {
		double diff = p1.getHeight() - p2.getHeight();
		if (diff == 0)
			return 0;
		if (diff > 0)
			return -1;

		return 1;
	}

}
