package sevenWonders.core.gameElements;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * A {@link Wonder} is a part of a {@link Board}. There is only 7 different
 * {@link Wonder}s. Each {@link Wonder} has a Resource, 2 to 4
 * ConstructionLevels with their own effects and a name.
 * 
 * @author Harukero
 *
 */
public enum Wonder implements IsSerializable {

	ALEXANDRIA("Alexandria", Resource.GLASS), 
	BABYLON("Babylon", Resource.CLAY_BRICK),
	EPHESOS("Ephesos", Resource.PAPYRUS),
	GIZAH("Gizah", Resource.STONE), 
	HALIKARNASSOS("Halikarnassos", Resource.TEXTILES), 
	OLIMPIA("Olimpia", Resource.WOOD), 
	RHODOS("Rhodos", Resource.ORE);

	private String name;
	private Resource resource;
	private WonderStage[] wonderStages;

	private Wonder() {
		
	}
	
	private Wonder(String name, Resource resource, WonderStage... constructionLevels) {
		this.name = name;
		this.resource = resource;
		this.wonderStages = constructionLevels;
	}

	public String getName() {
		return name;
	}

	public Resource getResource() {
		return resource;
	}

	public WonderStage[] getWonderStages() {
		return wonderStages;
	}

}
