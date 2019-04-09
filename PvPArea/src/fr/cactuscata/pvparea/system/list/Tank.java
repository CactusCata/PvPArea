package fr.cactuscata.pvparea.system.list;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

import fr.cactuscata.pvparea.system.Area;
import fr.cactuscata.pvparea.system.AreaType;
import fr.cactuscata.pvparea.utils.bukkit.ItemBuilder;

public class Tank extends Area {

	public Tank(FileConfiguration config) {
		super(AreaType.TANK, config);
	}

	@Override
	public ItemStack getItem() {
		return new ItemBuilder(Material.DIAMOND_CHESTPLATE).setGlowing().setDisplayName("tank").build();
	}

	@Override
	public void equipInventory(Inventory playerInventory) {

	}

	@Override
	public ItemStack[] getArmor() {

		return new ItemStack[] {
				new ItemBuilder(Material.DIAMOND_BOOTS).addEnchantement(Enchantment.PROTECTION_ENVIRONMENTAL, 4)
						.setUnbreakable().addItemFlags(ItemFlag.HIDE_UNBREAKABLE).build(),
				new ItemBuilder(Material.DIAMOND_LEGGINGS).addEnchantement(Enchantment.PROTECTION_ENVIRONMENTAL, 4)
						.setUnbreakable().addItemFlags(ItemFlag.HIDE_UNBREAKABLE).build(),
				new ItemBuilder(Material.DIAMOND_CHESTPLATE).addEnchantement(Enchantment.PROTECTION_ENVIRONMENTAL, 4)
						.setUnbreakable().addItemFlags(ItemFlag.HIDE_UNBREAKABLE).build(),
				new ItemBuilder(Material.DIAMOND_HELMET).addEnchantement(Enchantment.PROTECTION_ENVIRONMENTAL, 4)
						.setUnbreakable().addItemFlags(ItemFlag.HIDE_UNBREAKABLE).build() };
	}

}
