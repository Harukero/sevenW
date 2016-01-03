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
	
	@DefaultStringValue("Choose an action")
	String chooseAnAction();
	@DefaultStringValue("Choose an action for the following card:")
	String chooseAnActionForCard();
	@DefaultStringValue("Throw card")
	String throwCard();
	@DefaultStringValue("Play card")
	String playCard();
	
	@DefaultStringValue(" and ")
	String keyword_and();
	@DefaultStringValue(" or ")
	String keyword_or();
	
	@DefaultStringValue("Cog")
	String element_cog();
	@DefaultStringValue("Compas")
	String element_compas();
	@DefaultStringValue("Tablet")
	String element_tablet();
	@DefaultStringValue("+1 point per neighbor defeat point")
	String effect_onePerNeighborDefeatPoint();
	@DefaultStringValue("+1 point per wonder level finished (all)")
	String effect_onePerWonderLevel();
	@DefaultStringValue("Can play each age last card")
	String effect_canPlayAgeLastCard();
	@DefaultStringValue("Choose a scientific symbol")
	String effect_chooseScientificSymbol();
	@DefaultStringValue("Copy one neighbor's guild")
	String effect_copyGuild();
	@DefaultStringValue("Can play card from graveyard")
	String effect_playCardFromGraveyard();
	
	@DefaultStringValue("Civic Structure")
	String cardType_civicStructure();
	@DefaultStringValue("Commercial Structure")
	String cardType_commercialStructure();
	@DefaultStringValue("Guild Structure")
	String cardType_guild();
	@DefaultStringValue("Manufactured Good")
	String cardType_manufacturedGood();
	@DefaultStringValue("Military Structure")
	String cardType_militaryStructure();
	@DefaultStringValue("Raw Material")
	String cardType_rawMaterial();
	@DefaultStringValue("Scientific Structure")
	String cardType_scientificStructure();
	
	@DefaultStringValue("you and your neighbors")
	String effect_involveCurrentAndNeighbors();
	@DefaultStringValue("only you")
	String effect_involveCurrentPlayer();
	@DefaultStringValue("your neighbors only")
	String effect_involveNeighbors();
}
