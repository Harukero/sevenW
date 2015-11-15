package sevenWonders.core.gameElements;

/**
 * A {@link Wonder} is a part of a {@link Board}. There is only 7 different
 * {@link Wonder}s. Each {@link Wonder} has a Resource, 2 to 4
 * ConstructionLevels with their own effects and a name.
 * 
 * @author Harukero
 *
 */
public enum Wonder {

	ALEXANDRIA("Alexandria", Resource.GLASS), 
	BABYLON("Babylon", Resource.CLAY_BRICK),
	EPHESOS("Ephesos", Resource.PAPYRUS),
	GIZAH("Gizah", Resource.STONE), 
	HALIKARNASSOS("Halikarnassos", Resource.TEXTILES), 
	OLIMPIA("Olimpia", Resource.WOOD), 
	RHODOS("Rhodos", Resource.ORE);

	private final String name;
	private final Resource resource;
	private final WonderStage[] wonderStages;

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
