package sevenWonders.core.gameElements;

public enum Resource {

	// Brown cards (raw materials) provide one or two of the 
	// four raw material resources used in the game (wood, ore, clay brick and stone).
	WOOD(true, "images/wood.png"), ORE(true, "images/ore.png"), CLAY_BRICK(true, "images/clay.png"), STONE(true, "images/rock.png"),

	// Grey cards (manufactured goods) provide one of the 
	// three manufactured goods used in the game (glass, papyrus and textiles)
	GLASS(false, "images/wood.png"), PAPYRUS(false, "images/papyrus.png"), TEXTILES(false, "images/fabriques.png"),
	
	MONEY(false, "images/coin.png");
	
	private final boolean rawMaterial;
	private String imagePath;
	
	public boolean isRawMaterial() {
		return rawMaterial;
	}

	public boolean isManufacturedGood() {
		return !rawMaterial && this != MONEY;
	}
	
	private Resource(boolean raw, String imagePath) {
		this.rawMaterial = raw;
		this.imagePath = imagePath;
	}
	
	public String getImagePath() {
		return imagePath;
	}
	
}
