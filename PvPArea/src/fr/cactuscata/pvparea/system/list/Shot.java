package fr.cactuscata.pvparea.system.list;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

import fr.cactuscata.pvparea.system.Area;
import fr.cactuscata.pvparea.system.AreaType;
import fr.cactuscata.pvparea.utils.bukkit.ItemBuilder;

public class Shot extends Area {

	public Shot(FileConfiguration config) {
		super(AreaType.SHOT, config);
	}

	@Override
	public ItemStack getItem() {
		return new ItemBuilder(Material.BOW).setGlowing().setDisplayName("[Shot]").build();
	}

	@Override
	public void equipInventory(Inventory inventory) {
		inventory.setItem(0, new ItemBuilder(Material.BOW).setDisplayName("Arc One-Shot").setUnbreakable()
				.addItemFlags(ItemFlag.HIDE_UNBREAKABLE).build());
		inventory.setItem(1, new ItemBuilder(Material.WOOD_AXE).setDisplayName("Hache de guerre").setUnbreakable()
				.addItemFlags(ItemFlag.HIDE_UNBREAKABLE).build());
		inventory.setItem(9, new ItemBuilder(Material.ARROW).setDisplayName("Flèche en bois").build());
	}

	@Override
	public ItemStack[] getArmor() {
		return new ItemStack[] { null, null, null, null };
	}

}
