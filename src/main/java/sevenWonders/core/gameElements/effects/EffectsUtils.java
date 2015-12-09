package sevenWonders.core.gameElements.effects;

import java.util.HashMap;
import java.util.Map;

public class EffectsUtils {
	public static final String TABLET = "TABLET";
	public static final String COMPAS = "COMPAS";
	public static final String COG = "COG";
	public static final String ONE_PER_WONDERS_LEVEL_FROM_CURRENT_PLAYER_AND_NEIGHBOR = "ONE_PER_WONDERS_LEVEL_FROM_CURRENT_PLAYER_AND_NEIGHBOR";
	public static final String ONE_PER_NEIGHBOR_DEFEAT = "ONE_PER_NEIGHBOR_DEFEAT";
	public static final String PLAY_CARD_FROM_GRAVEYARD = "PLAY_CARD_FROM_GRAVEYARD";
	public static final String COPY_GUILD = "COPY_GUILD";
	public static final String CHOOSE_SCIENTIFIC_SYMBOL = "CHOOSE_SCIENTIFIC_SYMBOL";
	public static final String CAN_PLAY_AGE_LAST_CARD = "CAN_PLAY_AGE_LAST_CARD";
	public static final String TWO_FOR_MANUFACTURED = "TWO_FOR_MANUFACTURED";
	public static final String ONE_FOR_SCIENCE = "ONE_FOR_SCIENCE";
	public static final String ONE_FOR_RAW_MANUFACTURED_AND_GUILD = "ONE_FOR_RAW_MANUFACTURED_AND_GUILD";
	public static final String ONE_FOR_RAW = "ONE_FOR_RAW";
	public static final String ONE_FOR_MILITARY = "ONE_FOR_MILITARY";
	public static final String ONE_FOR_COMMERCIAL = "ONE_FOR_COMMERCIAL";
	public static final String ONE_FOR_CIVIC = "ONE_FOR_CIVIC";
	public static final String EIGHT_POINTS = "EIGHT_POINTS";
	public static final String SEVEN_POINTS = "SEVEN_POINTS";
	public static final String SIX_POINTS = "SIX_POINTS";
	public static final String FIVE_POINTS = "FIVE_POINTS";
	public static final String FOUR_POINTS = "FOUR_POINTS";
	public static final String THREE_POINTS = "THREE_POINTS";
	public static final String TWO_POINTS = "TWO_POINTS";
	public static final String ONE_POINT = "ONE_POINT";
	public static final String NINE_COINS = "NINE_COINS";
	public static final String FIVE_COINS = "FIVE_COINS";
	public static final String FOUR_COINS = "FOUR_COINS";
	public static final String THREE_COINS = "THREE_COINS";
	public static final String PLUS_THREE_MILITARY_POWER = "PLUS_THREE_MILITARY_POWER";
	public static final String PLUS_TWO_MILITARY_POWER = "PLUS_TWO_MILITARY_POWER";
	public static final String PLUS_ONE_MILITARY_POWER = "PLUS_ONE_MILITARY_POWER";
	public static final String WOOD_OR_ORE = "WOOD_OR_ORE";
	public static final String WOOD_OR_CLAY_BRICK = "WOOD_OR_CLAY_BRICK";
	public static final String TWO_WOOD = "TWO_WOOD";
	public static final String TWO_STONE = "TWO_STONE";
	public static final String TWO_ORE = "TWO_ORE";
	public static final String TWO_CLAY_BRICK = "TWO_CLAY_BRICK";
	public static final String STONE_OR_WOOD = "STONE_OR_WOOD";
	public static final String STONE_OR_CLAY_BRICK = "STONE_OR_CLAY_BRICK";
	public static final String ORE_OR_STONE = "ORE_OR_STONE";
	public static final String ONE_WOOD = "ONE_WOOD";
	public static final String ONE_TEXTILE = "ONE_TEXTILE";
	public static final String ONE_STONE = "ONE_STONE";
	public static final String ONE_PAPYRUS = "ONE_PAPYRUS";
	public static final String ONE_ORE = "ONE_ORE";
	public static final String ONE_GLASS = "ONE_GLASS";
	public static final String ONE_CLAY_BRICK = "ONE_CLAY_BRICK";
	public static final String CLAY_BRICK_OR_ORE = "CLAY_BRICK_OR_ORE";
	public static final String ANY_RAW = "ANY_RAW";
	public static final String ANY_MANUFACTURES = "ANY_MANUFACTURES";
	
	public static final Map<String, IsAnEffect> entryToEffect = new HashMap<>();
	
	static {
		// resources
		entryToEffect.put(ANY_MANUFACTURES, GiveResources.ANY_MANUFACTURES);
		entryToEffect.put(ANY_RAW, GiveResources.ANY_RAW);
		entryToEffect.put(CLAY_BRICK_OR_ORE, GiveResources.CLAY_BRICK_OR_ORE);
		entryToEffect.put(ONE_CLAY_BRICK, GiveResources.ONE_CLAY_BRICK);
		entryToEffect.put(ONE_GLASS, GiveResources.ONE_GLASS);
		entryToEffect.put(ONE_ORE, GiveResources.ONE_ORE);
		entryToEffect.put(ONE_PAPYRUS, GiveResources.ONE_PAPYRUS);
		entryToEffect.put(ONE_STONE, GiveResources.ONE_STONE);
		entryToEffect.put(ONE_TEXTILE, GiveResources.ONE_TEXTILE);
		entryToEffect.put(ONE_WOOD, GiveResources.ONE_WOOD);
		entryToEffect.put(ORE_OR_STONE, GiveResources.ORE_OR_STONE);
		entryToEffect.put(STONE_OR_CLAY_BRICK, GiveResources.STONE_OR_CLAY_BRICK);
		entryToEffect.put(STONE_OR_WOOD, GiveResources.STONE_OR_WOOD);
		entryToEffect.put(TWO_CLAY_BRICK, GiveResources.TWO_CLAY_BRICK);
		entryToEffect.put(TWO_ORE, GiveResources.TWO_ORE);
		entryToEffect.put(TWO_STONE, GiveResources.TWO_STONE);
		entryToEffect.put(TWO_WOOD, GiveResources.TWO_WOOD);
		entryToEffect.put(WOOD_OR_CLAY_BRICK, GiveResources.WOOD_OR_CLAY_BRICK);
		entryToEffect.put(WOOD_OR_ORE, GiveResources.WOOD_OR_ORE);
		
		// military power
		entryToEffect.put(PLUS_ONE_MILITARY_POWER, GiveMilitaryPower.PLUS_ONE_MILITARY_POWER);
		entryToEffect.put(PLUS_TWO_MILITARY_POWER, GiveMilitaryPower.PLUS_TWO_MILITARY_POWER);
		entryToEffect.put(PLUS_THREE_MILITARY_POWER, GiveMilitaryPower.PLUS_THREE_MILITARY_POWER);
		
		// money
		entryToEffect.put(THREE_COINS, GiveMoney.THREE_COINS);
		entryToEffect.put(FOUR_COINS, GiveMoney.FOUR_COINS);
		entryToEffect.put(FIVE_COINS, GiveMoney.FIVE_COINS);
		entryToEffect.put(NINE_COINS, GiveMoney.NINE_COINS);
		
		// points
		entryToEffect.put(ONE_POINT, GivePoints.ONE_POINT);
		entryToEffect.put(TWO_POINTS, GivePoints.TWO_POINTS);
		entryToEffect.put(THREE_POINTS, GivePoints.THREE_POINTS);
		entryToEffect.put(FOUR_POINTS, GivePoints.FOUR_POINTS);
		entryToEffect.put(FIVE_POINTS, GivePoints.FIVE_POINTS);
		entryToEffect.put(SIX_POINTS, GivePoints.SIX_POINTS);
		entryToEffect.put(SEVEN_POINTS, GivePoints.SEVEN_POINTS);
		entryToEffect.put(EIGHT_POINTS, GivePoints.EIGHT_POINTS);
		
		// points per cards of type X
		entryToEffect.put(ONE_FOR_CIVIC, GivePointsPerCardType.ONE_FOR_CIVIC);
		entryToEffect.put(ONE_FOR_COMMERCIAL, GivePointsPerCardType.ONE_FOR_COMMERCIAL);
		entryToEffect.put(ONE_FOR_MILITARY, GivePointsPerCardType.ONE_FOR_MILITARY);
		entryToEffect.put(ONE_FOR_RAW, GivePointsPerCardType.ONE_FOR_RAW);
		entryToEffect.put(ONE_FOR_RAW_MANUFACTURED_AND_GUILD, GivePointsPerCardType.ONE_FOR_RAW_MANUFACTURED_AND_GUILD);
		entryToEffect.put(ONE_FOR_SCIENCE, GivePointsPerCardType.ONE_FOR_SCIENCE);
		entryToEffect.put(TWO_FOR_MANUFACTURED, GivePointsPerCardType.TWO_FOR_MANUFACTURED);
		
		// wonders special effects
		entryToEffect.put(CAN_PLAY_AGE_LAST_CARD, WonderSpecialEffect.CAN_PLAY_AGE_LAST_CARD);
		entryToEffect.put(CHOOSE_SCIENTIFIC_SYMBOL, WonderSpecialEffect.CHOOSE_SCIENTIFIC_SYMBOL);
		entryToEffect.put(COPY_GUILD, WonderSpecialEffect.COPY_GUILD);
		entryToEffect.put(PLAY_CARD_FROM_GRAVEYARD, WonderSpecialEffect.PLAY_CARD_FROM_GRAVEYARD);
		
		// scientif elements
		entryToEffect.put(COG, GiveScientificElement.COG);
		entryToEffect.put(COMPAS, GiveScientificElement.COMPAS);
		entryToEffect.put(TABLET, GiveScientificElement.TABLET);
		
		// others
		entryToEffect.put(ONE_PER_NEIGHBOR_DEFEAT, OtherEffects.ONE_PER_NEIGHBOR_DEFEAT);
		entryToEffect.put(ONE_PER_WONDERS_LEVEL_FROM_CURRENT_PLAYER_AND_NEIGHBOR, OtherEffects.ONE_PER_WONDERS_LEVEL_FROM_CURRENT_PLAYER_AND_NEIGHBOR);
	}
}
