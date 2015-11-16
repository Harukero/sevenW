package sevenWonders.client.internationalization;

import com.google.gwt.i18n.client.Constants;

public interface ViewConstants extends Constants {
	
	@DefaultStringValue("Seven Wonders - Menu")
	String SEVEN_WONDERS_MENU();
	@DefaultStringValue("Start New Game")
	String NEW_GAME();
	@DefaultStringValue("Game Cards")
	String RULES_PAGE();
	
	
	@DefaultStringValue("Raw Material")
	String TITLE_RAW();
	@DefaultStringValue("Manufactured Goods")
	String TITLE_MANUFACTURED();
	@DefaultStringValue("Civilian Structures")
	String TITLE_CIVILIAN();
	@DefaultStringValue("Commercial Structures")
	String TITLE_COMMERCIAL();
	@DefaultStringValue("Scientific Structures")
	String TITLE_SCIENCE();
	@DefaultStringValue("Military Structures")
	String TITLE_MILITARY();
	@DefaultStringValue("Guilds")
	String TITLE_GUILDS();
	
	@DefaultStringValue("3 Players")
	String THREE_PLAYER_GAME();
	@DefaultStringValue("4 Players")
	String FOUR_PLAYER_GAME();
	@DefaultStringValue("5 Players")
	String FIVE_PLAYER_GAME();
	@DefaultStringValue("6 Players")
	String SIX_PLAYER_GAME();
	@DefaultStringValue("7 Players")
	String SEVEN_PLAYER_GAME();
	@DefaultStringValue("Player's hand")
	String PLAYERS_HAND();
	@DefaultStringValue("Played cards")
	String PLAYED_CARDS();
	
	@DefaultStringValue("Left Player Board")
	String LEFT_PLAYER_BOARD();
	@DefaultStringValue("Right Player Board")
	String RIGHT_PLAYER_BOARD();
	@DefaultStringValue("Close")
	String CLOSE();
	
	@DefaultStringValue("Clay Brick")
	String resource_clayBrick();
	@DefaultStringValue("Glass")
	String resource_glass();
	@DefaultStringValue("Money")
	String resource_money();
	@DefaultStringValue("Ore")
	String resource_ore();
	@DefaultStringValue("Papyrus")
	String resource_papyrus();
	@DefaultStringValue("Stone")
	String resource_stone();
	@DefaultStringValue("Textiles")
	String resource_textiles();
	@DefaultStringValue("Wood")
	String resource_wood();
}
