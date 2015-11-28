package sevenWonders.core.gameElements.effects;

import sevenWonders.core.gameElements.Resource;

public enum GiveResources implements IsAnEffect {
	
	// Simple effects
	ONE_CLAY_BRICK(true, Resource.CLAY_BRICK),
	ONE_ORE(true, Resource.ORE),
	ONE_STONE(true, Resource.STONE),
	ONE_WOOD(true, Resource.WOOD),
	
	ONE_GLASS(true, Resource.GLASS),
	ONE_PAPYRUS(true, Resource.PAPYRUS),
	ONE_TEXTILE(true, Resource.TEXTILES),
	
	// double resources
	TWO_CLAY_BRICK(true, Resource.CLAY_BRICK, Resource.CLAY_BRICK),
	TWO_ORE(true, Resource.ORE, Resource.ORE),
	TWO_STONE(true, Resource.STONE, Resource.STONE),
	TWO_WOOD(true, Resource.WOOD, Resource.WOOD),
	
	// choice between two resources
	WOOD_OR_CLAY_BRICK(false, Resource.WOOD, Resource.CLAY_BRICK),
	STONE_OR_CLAY_BRICK(false, Resource.STONE, Resource.CLAY_BRICK),
	CLAY_BRICK_OR_ORE(false, Resource.CLAY_BRICK, Resource.ORE),
	STONE_OR_WOOD(false, Resource.STONE, Resource.WOOD),
	WOOD_OR_ORE(false, Resource.WOOD, Resource.ORE),
	ORE_OR_STONE(false, Resource.ORE, Resource.STONE),
	
	ANY_RAW(false, Resource.CLAY_BRICK, Resource.ORE, Resource.STONE, Resource.WOOD),
	ANY_MANUFACTURES(false, Resource.GLASS, Resource.PAPYRUS, Resource.TEXTILES);
	
	private Resource[] resources;
	
	// indicates that the current effect gives all the resources in resources array
	// or lets just the player choose between them
	private boolean allResourcesAvailable;

	private GiveResources(boolean all, Resource...resources) {
		allResourcesAvailable = all;
		this.resources = resources;
	}
	
	public Resource[] getGivenCoins() {
		return resources;
	}
	
	public boolean isAllResourcesAvailable() {
		return allResourcesAvailable;
	}
}