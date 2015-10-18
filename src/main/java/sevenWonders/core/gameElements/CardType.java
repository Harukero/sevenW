package sevenWonders.core.gameElements;

public enum CardType {

    /** Red cards contain 'shield' symbols; 
     * these are added together to give a player's military strength, 
     * which is used in conflict resolution at the end of each age. */
	MILITARY_STRUCTURE,
	
	/** Yellow cards have several effects: 
	 * they can grant coins, resources and/or victory points 
	 * or decrease the cost of buying resources from neighbors. */
	COMMERCIAL_STRUCTURE,
	
	/** Green cards : each card has one of three symbols. 
	 * Combinations of the symbols are worth victory points. */
	SCIENTIFIC_STRUCTURE,
	
	/** Blue cards : all grant a fixed number of victory points. */
	CIVIC_STRUCTURE,
	
	/** Brown cards provide one or two 
	 * of the four raw material resources used in the game 
	 * (wood, ore, clay brick and stone). */
	RAW_MATERIAL,
	
	/** Grey cards provide one of the three 
	 * manufactured goods used in the game 
	 * (glass, papyrus and textiles). */
	MANUFACTURED_GOOD,
	
	/** Purple cards generally grant victory points based on 
	 * the structures a player and/or his neighbors have built. */
	GUILD
}
