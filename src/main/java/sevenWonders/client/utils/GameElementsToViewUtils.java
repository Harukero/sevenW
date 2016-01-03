package sevenWonders.client.utils;

import com.google.gwt.core.client.GWT;

import sevenWonders.client.constants.IStyleNames;
import sevenWonders.client.internationalization.ViewConstants;
import sevenWonders.client.internationalization.ViewMessages;
import sevenWonders.core.gameElements.CardType;
import sevenWonders.core.gameElements.Resource;
import sevenWonders.core.gameElements.effects.GiveMilitaryPower;
import sevenWonders.core.gameElements.effects.GiveMoney;
import sevenWonders.core.gameElements.effects.GivePoints;
import sevenWonders.core.gameElements.effects.GivePointsPerCardType;
import sevenWonders.core.gameElements.effects.GiveResources;
import sevenWonders.core.gameElements.effects.GiveScientificElement;
import sevenWonders.core.gameElements.effects.IsAnEffect;
import sevenWonders.core.gameElements.effects.OtherEffects;
import sevenWonders.core.gameElements.effects.PlayersInvolved;
import sevenWonders.core.gameElements.effects.WonderSpecialEffect;

public class GameElementsToViewUtils {

	private static final ViewConstants constants = GWT.create(ViewConstants.class);
	private static final ViewMessages messages = GWT.create(ViewMessages.class);
	
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
	
	
	public static String cardTypeToStyleName(CardType type) {
		switch (type) {
		case  CIVIC_STRUCTURE:
			return IStyleNames.CIVIC_STRUCTURE;
		case COMMERCIAL_STRUCTURE:
			return IStyleNames.COMMERCIAL_STRUCTURE;
		case GUILD:
			return IStyleNames.GUILD;
		case MANUFACTURED_GOOD:
			return IStyleNames.MANUFACTURED_GOOD;
		case MILITARY_STRUCTURE:
			return IStyleNames.MILITARY_STRUCTURE;
		case RAW_MATERIAL:
			return IStyleNames.RAW_MATERIAL;
		case SCIENTIFIC_STRUCTURE:
			return IStyleNames.SCIENTIFIC_STRUCTURE;
		default:
			break;
		}
		throw new IllegalStateException("Error, unknown card type: "+type);
	}
	
	public static String effectToString(IsAnEffect effect) {
		if (effect instanceof GiveMilitaryPower) {
			GiveMilitaryPower giveMilitaryPower = (GiveMilitaryPower) effect;
			return messages.effect_addMilitaryPoints(giveMilitaryPower.getMilitaryPowerGiven());
		} else if (effect instanceof GiveMoney) {
			GiveMoney giveMoney = (GiveMoney) effect;
			return messages.effect_addCoins(giveMoney.getGivenCoins());

		} else if (effect instanceof GivePoints) {
			GivePoints givePoints = (GivePoints) effect;
			return messages.effect_addPoints(givePoints.getGivenPoints());
		} else if (effect instanceof GivePointsPerCardType) {
			GivePointsPerCardType givePointsPerCardType = (GivePointsPerCardType) effect;
			int points = givePointsPerCardType.getNbPoints();
			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < givePointsPerCardType.getTypes().length; i++) {
				if (i > 0) {
					builder.append(", ");
				}
				CardType cardType = givePointsPerCardType.getTypes()[i];
				builder.append(cardTypeToString(cardType));
			}
			String involves =  involvesToString(givePointsPerCardType.getInvolves());
			return messages.effect_givePointsPerCardType(points, builder.toString(), involves);
		} else if (effect instanceof GiveResources) {
			GiveResources giveResources = (GiveResources) effect;
			String symbol = giveResources.isAllResourcesAvailable() ? constants.keyword_and() : constants.keyword_or();
			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < giveResources.getGivenResources().length; i++) {
				if (i > 0) {
					builder.append(symbol);
				}
				builder.append(resourceI18nName(giveResources.getGivenResources()[i]));
			}
			return builder.toString();
		} else if (effect instanceof GiveScientificElement) {
			GiveScientificElement giveScientificElement = (GiveScientificElement) effect;
			return scientificElementToString(giveScientificElement);
		} else if (effect instanceof OtherEffects) {
			OtherEffects otherEffects = (OtherEffects) effect;
			return otherEffectToString(otherEffects);
		} else if (effect instanceof WonderSpecialEffect) {
			WonderSpecialEffect wonderSpecialEffect = (WonderSpecialEffect) effect;
			return wonderSpecialEffectToString(wonderSpecialEffect);
		}
		throw new IllegalStateException("Error, unknown effect: "+effect);
	}
	
	private static String involvesToString(PlayersInvolved involves) {
		switch (involves) {
		case CURRENT_AND_NEIGHBORS:
			return constants.effect_involveCurrentAndNeighbors();
		case CURRENT_PLAYER:
			return constants.effect_involveCurrentPlayer();
		case NEIGHBORS:
			return constants.effect_involveNeighbors();
		default:
			break;
		}
		throw new IllegalStateException("Error, unknown value: "+involves);
	}

	private static String cardTypeToString(CardType cardType) {
		switch (cardType) {
		case CIVIC_STRUCTURE:
			return constants.cardType_civicStructure();
		case COMMERCIAL_STRUCTURE:
			return constants.cardType_commercialStructure();
		case GUILD:
			return constants.cardType_guild();
		case MANUFACTURED_GOOD:
			return constants.cardType_manufacturedGood();
		case MILITARY_STRUCTURE:
			return constants.cardType_militaryStructure();
		case RAW_MATERIAL:
			return constants.cardType_rawMaterial();
		case SCIENTIFIC_STRUCTURE:
			return constants.cardType_scientificStructure();
		default:
			break;
		}
		throw new IllegalStateException("Error, unknown card type: "+cardType);
	}

	private static String wonderSpecialEffectToString(WonderSpecialEffect effect) {
		switch (effect) {
		case CAN_PLAY_AGE_LAST_CARD:
			return constants.effect_canPlayAgeLastCard();
		case CHOOSE_SCIENTIFIC_SYMBOL:
			return constants.effect_chooseScientificSymbol();
		case COPY_GUILD:
			return constants.effect_copyGuild();
		case PLAY_CARD_FROM_GRAVEYARD:
			return constants.effect_playCardFromGraveyard();
		default:
			break;
		}
		throw new IllegalStateException("Error, unknown effect: "+effect);
	}
	
	private static String otherEffectToString(OtherEffects effect) {
		switch (effect){
		case ONE_PER_NEIGHBOR_DEFEAT:
			return constants.effect_onePerNeighborDefeatPoint();
		case ONE_PER_WONDERS_LEVEL_FROM_CURRENT_PLAYER_AND_NEIGHBOR:
			return constants.effect_onePerWonderLevel();
		default:
			break;
		}
		throw new IllegalStateException("Error, unknown effect: "+effect);
	}
	
	private static String scientificElementToString(GiveScientificElement effect) {
		switch (effect){
		case COG:
			return constants.element_cog();
		case COMPAS:
			return constants.element_compas();
		case TABLET:
			return constants.element_tablet();
		default:
			break;
		}
		throw new IllegalStateException("Error, unknown effect: "+effect);
	}
}
