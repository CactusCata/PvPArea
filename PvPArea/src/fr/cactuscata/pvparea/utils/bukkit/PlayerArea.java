package fr.cactuscata.pvparea.utils.bukkit;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import fr.cactuscata.pvparea.system.Area;
import fr.cactuscata.pvparea.system.AreaType;

public final class PlayerArea {

	private static final Map<Player, PlayerArea> playersArea = new HashMap<>();

	private final Player player;
	private AreaType areaType;

	public PlayerArea(final Player player) {
		this.player = player;
		setAreaType(AreaType.SPAWN);
		playersArea.put(this.player, this);
	}

	public final Player getPlayer() {
		return this.player;
	}

	public AreaType getAreaType() {
		return this.areaType;
	}

	public void setAreaType(AreaType areaType) {
		this.areaType = areaType;
		final Area area = Area.getArea(areaType);
		this.player.teleport(area.getSpawnLocation());
		this.player.getInventory().clear();
		this.player.setHealth(player.getMaxHealth());
		this.player.setExp(0.0f);
		this.player.setTotalExperience(0);
		area.equipInventory(this.player.getInventory());
		this.player.getInventory().setArmorContents(area.getArmor());
		this.player.updateInventory();
	}

	public final void unregisterPlayer() {
		playersArea.remove(this.player);
	}

	public static final PlayerArea getPlayerArea(final Player player) {
		return playersArea.get(player);
	}

	public static final void regsiterAllPlayers() {
		Bukkit.getOnlinePlayers().forEach(onlinePlayer -> new PlayerArea(onlinePlayer));
	}

	public static final void unregisterAllPlayers() {
		Bukkit.getOnlinePlayers().forEach(onlinePlayer -> playersArea.remove(onlinePlayer));
	}

}
