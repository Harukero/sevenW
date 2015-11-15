package sevenWonders.core.gameElements;

public enum Resource {

	// Brown cards (raw materials) provide one or two of the 
	// four raw material resources used in the game (wood, ore, clay brick and stone).
	WOOD(true, "wood"), 
	ORE(true, "ore"), 
	CLAY_BRICK(true, "clay"), 
	STONE(true, "rock"),

	// Grey cards (manufactured goods) provide one of the 
	// three manufactured goods used in the game (glass, papyrus and textiles)
	GLASS(false, "glass"), 
	PAPYRUS(false, "papyrus"), 
	TEXTILES(false, "textiles"),
	
	MONEY(false, "money");
	
	private final boolean rawMaterial;
	private String resourceStyle;
	
	public boolean isRawMaterial() {
		return rawMaterial;
	}

	public boolean isManufacturedGood() {
		return !rawMaterial && this != MONEY;
	}
	
	private Resource(boolean raw, String resourceStyle) {
		this.rawMaterial = raw;
		this.resourceStyle = resourceStyle;
	}
	
	public String getResourceStyle() {
		return resourceStyle;
	}
	
}
