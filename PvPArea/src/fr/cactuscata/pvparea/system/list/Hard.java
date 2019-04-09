package fr.cactuscata.pvparea.system.list;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import fr.cactuscata.pvparea.system.Area;
import fr.cactuscata.pvparea.system.AreaType;
import fr.cactuscata.pvparea.utils.bukkit.ItemBuilder;

public class Hard extends Area {

	public Hard(FileConfiguration config) {
		super(AreaType.HARD, config);
	}

	@Override
	public ItemStack getItem() {
		return new ItemBuilder(Material.DIAMOND_SWORD).setGlowing().setDisplayName("hard").build();
	}

	@Override
	public void equipInventory(Inventory playerInventory) {

	}

	@Override
	public ItemStack[] getArmor() {
		return null;
	}

}
