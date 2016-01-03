package sevenWonders.core.gameElements;

import com.google.gwt.user.client.rpc.IsSerializable;

public enum Resource implements IsSerializable {

	// Brown cards (raw materials) provide one or two of the 
	// four raw material resources used in the game (wood, ore, clay brick and stone).
	WOOD(true, "Wood"), 
	ORE(true, "Ore"), 
	CLAY_BRICK(true, "Clay brick"), 
	STONE(true, "Stone"),

	// Grey cards (manufactured goods) provide one of the 
	// three manufactured goods used in the game (glass, papyrus and textiles)
	GLASS(false, "Glass"), 
	PAPYRUS(false, "Papyrus"), 
	TEXTILES(false, "Textiles"),
	
	MONEY(false, "Money");
	
	private boolean rawMaterial;
	private String name;
	
	public boolean isRawMaterial() {
		return rawMaterial;
	}

	public boolean isManufacturedGood() {
		return !rawMaterial && this != MONEY;
	}
	
	private Resource(boolean raw, String name) {
		this.rawMaterial = raw;
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
}
