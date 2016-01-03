package sevenWonders.core.gameElements.effects;

import sevenWonders.core.gameElements.CardType;

public enum GivePointsPerCardType implements IsAnEffect {

	ONE_FOR_RAW(1, PlayersInvolved.NEIGHBORS, CardType.RAW_MATERIAL),
	TWO_FOR_MANUFACTURED(2, PlayersInvolved.NEIGHBORS, CardType.MANUFACTURED_GOOD),
	ONE_FOR_COMMERCIAL(1, PlayersInvolved.NEIGHBORS, CardType.COMMERCIAL_STRUCTURE),
	ONE_FOR_SCIENCE(1, PlayersInvolved.NEIGHBORS, CardType.SCIENTIFIC_STRUCTURE),
	ONE_FOR_MILITARY(1, PlayersInvolved.NEIGHBORS, CardType.MILITARY_STRUCTURE),
	ONE_FOR_CIVIC(1, PlayersInvolved.NEIGHBORS, CardType.CIVIC_STRUCTURE),
	ONE_FOR_RAW_MANUFACTURED_AND_GUILD(1, PlayersInvolved.NEIGHBORS, 
			CardType.RAW_MATERIAL,
			CardType.MANUFACTURED_GOOD,
			CardType.GUILD);
	
	private int nbPoints;
	private PlayersInvolved involves;
	private CardType[] types;

	private GivePointsPerCardType(int nbPoints, PlayersInvolved involves, CardType... types) {
		this.nbPoints = nbPoints;
		this.involves = involves;
		this.types = types;
	}
	
	public int getNbPoints() {
		return nbPoints;
	}

	public PlayersInvolved getInvolves() {
		return involves;
	}

	public CardType[] getTypes() {
		return types;
	}
}
