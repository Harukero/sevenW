package sevenWonders.core.gameElements;

import com.google.gwt.user.client.rpc.IsSerializable;

public enum Age implements IsSerializable{
	FIRST, SECOND, THIRD;

	public static Age getAgeFromNumber(double d) {

		if (d == 1.0) {
			return FIRST;
		}
		if (d == 2.0) {
			return SECOND;
		}
		if (d == 3.0) {
			return Age.THIRD;
		}
		throw new IllegalArgumentException(
				"Error. The only possibles numbers for ages are 1, 2 or 3.\n" + "Number entered: " + d);
	}
}
