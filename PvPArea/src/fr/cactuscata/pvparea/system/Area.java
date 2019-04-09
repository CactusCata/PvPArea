package fr.cactuscata.pvparea.system;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import fr.cactuscata.pvparea.utils.bukkit.LocationSerialiser;

public abstract class Area {

	private static final Map<AreaType, Area> areas = new HashMap<>();

	private final Location spawnLocation, firstInvinciblePoint, secondInvinciblePoint;

	public Area(AreaType areaType, FileConfiguration config) {
		areas.put(areaType, this);
		this.spawnLocation = LocationSerialiser
				.locationFromString(config.getString(areaType.getAreaName() + ".spawnLocation"));
		this.firstInvinciblePoint = LocationSerialiser
				.locationFromString(config.getString(areaType.getAreaName() + ".firstInvinciblePoint"));
		this.secondInvinciblePoint = LocationSerialiser
				.locationFromString(config.getString(areaType.getAreaName() + ".secondInvinciblePoint"));
	}

	public abstract ItemStack getItem();

	public abstract void equipInventory(Inventory playerInventory);

	public abstract ItemStack[] getArmor();

	public final Location getSpawnLocation() {
		return this.spawnLocation;
	}

	public final boolean isInInvicibleArea(Location playerLocation) {
		return playerLocation.getWorld().getName().equals(this.firstInvinciblePoint.getWorld().getName())
				&& playerLocation.getX() > this.firstInvinciblePoint.getX()
				&& playerLocation.getX() < this.secondInvinciblePoint.getX()
				&& playerLocation.getY() > this.firstInvinciblePoint.getY()
				&& playerLocation.getY() < this.secondInvinciblePoint.getY()
				&& playerLocation.getZ() > this.firstInvinciblePoint.getZ()
				&& playerLocation.getZ() < this.secondInvinciblePoint.getZ();
	}

	public static Area getArea(AreaType areaType) {
		return areas.get(areaType);
	}

}
