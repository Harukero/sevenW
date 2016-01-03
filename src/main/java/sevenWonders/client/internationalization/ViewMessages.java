package sevenWonders.client.internationalization;

import com.google.gwt.i18n.client.Messages;

public interface ViewMessages extends Messages {
	@DefaultMessage("+{0} military point(s)")
	String effect_addMilitaryPoints(int points);
	
	@DefaultMessage("+{0} coin(s)")
	String effect_addCoins(int coins);
	
	@DefaultMessage("+{0} point(s)")
	String effect_addPoints(int points);
	
	@DefaultMessage("+{0} point(s) for each card of type {1} possessed by {2}")
	String effect_givePointsPerCardType(int pointsGiven, String cardsTypes, String playersInvolved);
}
