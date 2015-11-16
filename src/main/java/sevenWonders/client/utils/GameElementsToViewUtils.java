package sevenWonders.client.utils;

import com.google.gwt.core.client.GWT;

import sevenWonders.client.constants.IStyleNames;
import sevenWonders.client.internationalization.ViewConstants;
import sevenWonders.core.gameElements.Resource;

public class GameElementsToViewUtils {

	private static final ViewConstants constants = GWT.create(ViewConstants.class);
	
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

	public static String resourceI18nName(Resource resource) {
		switch (resource) {
		case CLAY_BRICK:
			return constants.resource_clayBrick();
		case GLASS:
			return constants.resource_glass();
		case MONEY:
			return constants.resource_money();
		case ORE:
			return constants.resource_ore();
		case PAPYRUS:
			return constants.resource_papyrus();
		case STONE:
			return constants.resource_stone();
		case TEXTILES:
			return constants.resource_textiles();
		case WOOD:
			return constants.resource_wood();
		default:
		}
		throw new IllegalStateException("Error, unexpected use of resource '"+resource+"'");
	}
	
}
