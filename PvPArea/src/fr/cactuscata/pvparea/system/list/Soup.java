package fr.cactuscata.pvparea.system.list;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

import fr.cactuscata.pvparea.system.Area;
import fr.cactuscata.pvparea.system.AreaType;
import fr.cactuscata.pvparea.utils.bukkit.ItemBuilder;

public class Soup extends Area {

	public Soup(FileConfiguration config) {
		super(AreaType.SOUP, config);
	}

	@Override
	public final ItemStack getItem() {
		return new ItemBuilder(Material.MUSHROOM_SOUP).setGlowing()
				.setDisplayName("[" + AreaType.SOUP.getAreaName() + "]").build();
	}

	@Override
	public final void equipInventory(Inventory playerInventory) {
		playerInventory.setItem(0, new ItemBuilder(Material.IRON_SWORD).addEnchantement(Enchantment.DAMAGE_ALL, 1)
				.setUnbreakable().addItemFlags(ItemFlag.HIDE_UNBREAKABLE).build());
		for (int slot = 1, maxSlot = InventoryType.PLAYER.getDefaultSize(); slot < maxSlot; slot++)
			playerInventory.setItem(slot, new ItemBuilder(Material.MUSHROOM_SOUP).build());

	}

	@Override
	public final ItemStack[] getArmor() {

		return new ItemStack[] {
				new ItemBuilder(Material.IRON_BOOTS).setUnbreakable().addItemFlags(ItemFlag.HIDE_UNBREAKABLE).build(),
				new ItemBuilder(Material.IRON_LEGGINGS).setUnbreakable().addItemFlags(ItemFlag.HIDE_UNBREAKABLE)
						.build(),
				new ItemBuilder(Material.IRON_CHESTPLATE).setUnbreakable().addItemFlags(ItemFlag.HIDE_UNBREAKABLE)
						.build(),
				new ItemBuilder(Material.IRON_HELMET).setUnbreakable().addItemFlags(ItemFlag.HIDE_UNBREAKABLE)
						.build() };
	}

}
