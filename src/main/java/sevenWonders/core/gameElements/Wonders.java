package sevenWonders.core.gameElements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.user.client.rpc.IsSerializable;

import sevenWonders.core.gameElements.effects.GiveMilitaryPower;
import sevenWonders.core.gameElements.effects.GiveMoney;
import sevenWonders.core.gameElements.effects.GivePoints;
import sevenWonders.core.gameElements.effects.GiveResources;
import sevenWonders.core.gameElements.effects.IsAnEffect;

public class Wonders implements IsSerializable {
	private static final Wonder ALEXANDRIA = new Wonder("Alexandria", Resource.GLASS);
	static {
		Map<Resource, Integer> cost1 = new HashMap<>();
		cost1.put(Resource.CLAY_BRICK, 2);
		IsAnEffect effect1 = GiveResources.ANY_RAW;
		WonderStage stage1 = new WonderStage(cost1, effect1);
		
		Map<Resource, Integer> cost2 = new HashMap<>();
		cost2.put(Resource.WOOD, 3);
		IsAnEffect effect2 = GiveResources.ANY_MANUFACTURES;
		WonderStage stage2 = new WonderStage(cost2, effect2);
		
		Map<Resource, Integer> cost3 = new HashMap<>();
		cost3.put(Resource.STONE, 3);
		IsAnEffect effect3 = GivePoints.SEVEN_POINTS;
		WonderStage stage3 = new WonderStage(cost3, effect3);
		
		ALEXANDRIA.setWondersStages(new WonderStage[]{stage1, stage2, stage3});
	}

	// TODO : EFFECTS
	private static final Wonder BABYLON = new Wonder("Babylon", Resource.CLAY_BRICK);
	static {
		Map<Resource, Integer> cost1 = new HashMap<>();
		cost1.put(Resource.CLAY_BRICK, 1);
		cost1.put(Resource.TEXTILES, 1);
		IsAnEffect effect1 = GivePoints.THREE_POINTS;
		WonderStage stage1 = new WonderStage(cost1, effect1);
		
		Map<Resource, Integer> cost2 = new HashMap<>();
		cost2.put(Resource.WOOD, 2);
		cost2.put(Resource.GLASS, 1);
		WonderStage stage2 = new WonderStage(cost2);
		
		Map<Resource, Integer> cost3 = new HashMap<>();
		cost3.put(Resource.CLAY_BRICK, 3);
		cost3.put(Resource.PAPYRUS, 1);
		WonderStage stage3 = new WonderStage(cost3);
		
		BABYLON.setWondersStages(new WonderStage[]{stage1, stage2, stage3});
	}
	
	private static final Wonder EPHESOS = new Wonder("Ephesos", Resource.PAPYRUS);
	static {
		Map<Resource, Integer> cost1 = new HashMap<>();
		cost1.put(Resource.STONE, 2);
		IsAnEffect[] effects1 = new IsAnEffect[]{GivePoints.TWO_POINTS, GiveMoney.FOUR_COINS};
		WonderStage stage1 = new WonderStage(cost1, effects1);
		
		Map<Resource, Integer> cost2 = new HashMap<>();
		cost2.put(Resource.WOOD, 2);
		IsAnEffect[] effects2 = new IsAnEffect[]{GivePoints.THREE_POINTS, GiveMoney.FOUR_COINS};
		WonderStage stage2 = new WonderStage(cost2, effects2);
		
		Map<Resource, Integer> cost3 = new HashMap<>();
		cost3.put(Resource.GLASS, 1);
		cost3.put(Resource.PAPYRUS, 1);
		cost3.put(Resource.TEXTILES, 1);
		WonderStage stage3 = new WonderStage(cost3, GivePoints.FIVE_POINTS, GiveMoney.FOUR_COINS);
		
		EPHESOS.setWondersStages(new WonderStage[]{stage1, stage2, stage3});
	}
	
	private static final Wonder GIZAH = new Wonder("Gizah", Resource.STONE);
	static {
		Map<Resource, Integer> cost1 = new HashMap<>();
		cost1.put(Resource.WOOD, 2);
		IsAnEffect effect1 = GivePoints.THREE_POINTS;
		WonderStage stage1 = new WonderStage(cost1, effect1);
		
		Map<Resource, Integer> cost2 = new HashMap<>();
		cost2.put(Resource.STONE, 3);
		IsAnEffect effect2 = GivePoints.FIVE_POINTS;
		WonderStage stage2 = new WonderStage(cost2, effect2);
		
		Map<Resource, Integer> cost3 = new HashMap<>();
		cost3.put(Resource.CLAY_BRICK, 3);
		IsAnEffect effect3 = GivePoints.FIVE_POINTS;
		WonderStage stage3 = new WonderStage(cost3, effect3);
		
		Map<Resource, Integer> cost4 = new HashMap<>();
		cost4.put(Resource.STONE, 4);
		cost4.put(Resource.PAPYRUS, 1);
		IsAnEffect effect4 = GivePoints.SEVEN_POINTS;
		WonderStage stage4 = new WonderStage(cost3, effect4);
		
		GIZAH.setWondersStages(new WonderStage[]{stage1, stage2, stage3, stage4});
	}
	
	// TODO : EFFECTS
	private static final Wonder HALIKARNASSOS = new Wonder("Halikarnassos", Resource.TEXTILES); 
	static {
		Map<Resource, Integer> cost1 = new HashMap<>();
		cost1.put(Resource.ORE, 2);
		WonderStage stage1 = new WonderStage(cost1);
		
		Map<Resource, Integer> cost2 = new HashMap<>();
		cost2.put(Resource.CLAY_BRICK, 3);
		WonderStage stage2 = new WonderStage(cost2);
		
		Map<Resource, Integer> cost3 = new HashMap<>();
		cost3.put(Resource.GLASS, 1);
		cost3.put(Resource.PAPYRUS, 1);
		cost3.put(Resource.TEXTILES, 1);
		WonderStage stage3 = new WonderStage(cost3);
		
		HALIKARNASSOS.setWondersStages(new WonderStage[]{stage1, stage2, stage3});
	}
	
	// TODO : EFFECTS
	private static final Wonder OLIMPIA = new Wonder("Olimpia", Resource.WOOD);
	static {
		Map<Resource, Integer> cost1 = new HashMap<>();
		cost1.put(Resource.WOOD, 2);
		WonderStage stage1 = new WonderStage(cost1);
		
		Map<Resource, Integer> cost2 = new HashMap<>();
		cost2.put(Resource.STONE, 2);
		IsAnEffect effect2 = GivePoints.FIVE_POINTS;
		WonderStage stage2 = new WonderStage(cost2, effect2);
		
		Map<Resource, Integer> cost3 = new HashMap<>();
		cost3.put(Resource.ORE, 2);
		cost3.put(Resource.TEXTILES, 1);
		WonderStage stage3 = new WonderStage(cost3);
		
		OLIMPIA.setWondersStages(new WonderStage[]{stage1, stage2, stage3});
	}
	
	private static final Wonder RHODOS = new Wonder("Rhodos", Resource.ORE);
	static {
		Map<Resource, Integer> cost1 = new HashMap<>();
		cost1.put(Resource.STONE, 3);
		IsAnEffect[] effects1 = new IsAnEffect[]{
				GiveMilitaryPower.PLUS_ONE_MILITARY_POWER, 
				GivePoints.THREE_POINTS, 
				GiveMoney.THREE_COINS};
		WonderStage stage1 = new WonderStage(cost1, effects1);
		
		Map<Resource, Integer> cost2 = new HashMap<>();
		cost2.put(Resource.ORE, 4);
		IsAnEffect[] effects2 = new IsAnEffect[]{
				GiveMilitaryPower.PLUS_ONE_MILITARY_POWER, 
				GivePoints.FOUR_POINTS, 
				GiveMoney.FOUR_COINS};
		WonderStage stage2 = new WonderStage(cost2, effects2);
		
		RHODOS.setWondersStages(new WonderStage[]{stage1, stage2});
	}
	
	public static final List<Wonder> wonders = new ArrayList<Wonder>();
	static {
		wonders.add(ALEXANDRIA);
		wonders.add(EPHESOS);
		wonders.add(BABYLON);
		wonders.add(GIZAH);
		wonders.add(HALIKARNASSOS);
		wonders.add(OLIMPIA);
		wonders.add(RHODOS);
	}
	
}
