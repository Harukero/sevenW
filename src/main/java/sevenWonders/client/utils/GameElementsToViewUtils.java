package sevenWonders.client.utils;

import sevenWonders.client.constants.IStyleNames;
import sevenWonders.core.gameElements.Resource;

public class GameElementsToViewUtils {

	public static String resourceTypeToStyle(Resource resource) {
		switch (resource){
		case CLAY_BRICK:
			return IStyleNames.RESOURCE_CLAY;
		case GLASS:
			return IStyleNames.RESOURCE_GLASS;
		case MONEY:
			return IStyleNames.RESOURCE_MONEY;
		case ORE:
			return IStyleNames.RESOURCE_ORE;
		case PAPYRUS:
			return IStyleNames.RESOURCE_PAPYRUS;
		case STONE:
			return IStyleNames.RESOURCE_STONE;
		case TEXTILES:
			return IStyleNames.RESOURCE_TEXTILES;
		case WOOD:
			return IStyleNames.RESOURCE_WOOD;
		default:
			break;
		}
		throw new IllegalStateException("Error, unexpected use of resource '"+resource+"'");
	}
	
}
