package comparators;

import java.util.Comparator;

import animals.Bear;

public class BearMinimumComparator implements Comparator<Bear> {

	@Override
	public int compare(Bear b1, Bear b2) {
		double diff = b1.getWeight() - b2.getWeight();
		if (diff == 0)
			return 0;
		if (diff > 0)
			return 1;

		return -1;
	}

}
