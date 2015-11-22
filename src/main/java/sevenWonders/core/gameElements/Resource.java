package sevenWonders.core.gameElements;

import com.google.gwt.user.client.rpc.IsSerializable;

public enum Resource implements IsSerializable {

	// Brown cards (raw materials) provide one or two of the 
	// four raw material resources used in the game (wood, ore, clay brick and stone).
	WOOD(true), 
	ORE(true), 
	CLAY_BRICK(true), 
	STONE(true),

	// Grey cards (manufactured goods) provide one of the 
	// three manufactured goods used in the game (glass, papyrus and textiles)
	GLASS(false), 
	PAPYRUS(false), 
	TEXTILES(false),
	
	MONEY(false);
	
	private boolean rawMaterial;
	
	public boolean isRawMaterial() {
		return rawMaterial;
	}

	public boolean isManufacturedGood() {
		return !rawMaterial && this != MONEY;
	}
	
	private Resource(boolean raw) {
		this.rawMaterial = raw;
	}
	
}
