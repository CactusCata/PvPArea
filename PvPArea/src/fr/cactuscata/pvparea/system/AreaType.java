package fr.cactuscata.pvparea.system;

public enum AreaType {

	SPAWN("Spawn"),
	HARD("Hard"),
	SHOT("Shot"),
	TANK("Tank"),
	SOUP("Soup"),
	COMBO("Combo");
	
	private final String areaName;
	
	private AreaType(final String areaName) {
		this.areaName = areaName;
	}

	public final String getAreaName() {
		return this.areaName;
	}

}
