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
public class Wonder implements IsSerializable {

	private String name;
	private Resource resource;
	private WonderStage[] wonderStages;

	@SuppressWarnings("unused")
	private Wonder() {
		
	}
	
	Wonder(String name, Resource resource, WonderStage... constructionLevels) {
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

	public void setWondersStages(WonderStage[] wonderStages) {
		this.wonderStages = wonderStages;
	}

}
