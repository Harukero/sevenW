package sevenWonders.core.gameElements;

import com.google.gwt.user.client.rpc.IsSerializable;

import sevenWonders.client.constants.IConstants;

public enum CardType implements IsSerializable {

    /** Red cards contain 'shield' symbols; 
     * these are added together to give a player's military strength, 
     * which is used in conflict resolution at the end of each age. */
	MILITARY_STRUCTURE(IConstants.JSON_CATEGORY_MILITARY, 6),
	
	/** Yellow cards have several effects: 
	 * they can grant coins, resources and/or victory points 
	 * or decrease the cost of buying resources from neighbors. */
	COMMERCIAL_STRUCTURE(IConstants.JSON_CATEGORY_COMMERCIAL, 4),
	
	/** Green cards : each card has one of three symbols. 
	 * Combinations of the symbols are worth victory points. */
	SCIENTIFIC_STRUCTURE(IConstants.JSON_CATEGORY_SCIENCE, 5),
	
	/** Blue cards : all grant a fixed number of victory points. */
	CIVIC_STRUCTURE(IConstants.JSON_CATEGORY_CIVILIAN, 3),
	
	/** Brown cards provide one or two 
	 * of the four raw material resources used in the game 
	 * (wood, ore, clay brick and stone). */
	RAW_MATERIAL(IConstants.JSON_CATEGORY_RAW, 1),
	
	/** Grey cards provide one of the three 
	 * manufactured goods used in the game 
	 * (glass, papyrus and textiles). */
	MANUFACTURED_GOOD(IConstants.JSON_CATEGORY_MANUFACTURED, 2),
	
	/** Purple cards generally grant victory points based on 
	 * the structures a player and/or his neighbors have built. */
	GUILD(IConstants.JSON_CATEGORY_GUILDS, 7);

	private String jsonCategory;
	private int rank;

	private CardType(String jsonCategory, int rank) {
		this.jsonCategory = jsonCategory;
		this.rank = rank;
	}
	
	public static CardType fromCategory(String category) {
		for (CardType type : CardType.values()) {
			if (type.jsonCategory.equals(category)) {
				return type;
			}
		}
		throw new IllegalStateException("The given category is not compatible: " + category);
	}

	public int getRank() {
		return rank;
	}

}
