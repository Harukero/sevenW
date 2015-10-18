package sevenWonders.core.gameElements;


/**
 * A {@link Wonder} is a part of a {@link Board}.
 * There is only 7 different {@link Wonder}s.
 * Each {@link Wonder} has a Resource, 2 to 4 ConstructionLevels with their own effects and a name. 
 * @author Harukero
 *
 */
public enum Wonder {

	GIZAH("Gizah", null);
	
	private final String name;
	private final Resource resource;
	private final WonderStage[] wonderStages;
	
	private Wonder(String name, Resource resource, WonderStage...constructionLevels) {
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
