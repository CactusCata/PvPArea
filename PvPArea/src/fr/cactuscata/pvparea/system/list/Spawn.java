package fr.cactuscata.pvparea.system.list;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import fr.cactuscata.pvparea.system.Area;
import fr.cactuscata.pvparea.system.AreaType;

public class Spawn extends Area {

	public Spawn(FileConfiguration config) {
		super(AreaType.SPAWN, config);
	}

	@Override
	public final ItemStack getItem() {
		return null;
	}

	@Override
	public final void equipInventory(Inventory playerInventory) {
		playerInventory.clear();
	}

	@Override
	public final ItemStack[] getArmor() {
		return new ItemStack[] { null, null, null, null };
	}

}
