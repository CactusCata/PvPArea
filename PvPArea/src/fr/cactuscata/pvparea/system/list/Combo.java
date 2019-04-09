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

public class Combo extends Area {

	public Combo(FileConfiguration config) {
		super(AreaType.COMBO, config);
	}

	@Override
	public ItemStack getItem() {
		return new ItemBuilder(Material.GOLD_SWORD).setGlowing()
				.setDisplayName("[" + AreaType.COMBO.getAreaName() + "]").build();
	}

	@Override
	public void equipInventory(Inventory playerInventory) {

		playerInventory.setItem(0, new ItemBuilder(Material.DIAMOND_SWORD).addEnchantement(Enchantment.DAMAGE_ALL, 3)
				.setUnbreakable().addItemFlags(ItemFlag.HIDE_UNBREAKABLE).build());
		playerInventory.setItem(1, new ItemBuilder(Material.GOLDEN_APPLE, 64, (byte) 1).build());

	}

	@Override
	public ItemStack[] getArmor() {

		return new ItemStack[] {
				new ItemBuilder(Material.DIAMOND_BOOTS).addEnchantement(Enchantment.PROTECTION_ENVIRONMENTAL, 3)
						.build(),
				new ItemBuilder(Material.DIAMOND_LEGGINGS).addEnchantement(Enchantment.PROTECTION_ENVIRONMENTAL, 3)
						.build(),
				new ItemBuilder(Material.DIAMOND_CHESTPLATE).addEnchantement(Enchantment.PROTECTION_ENVIRONMENTAL, 3)
						.build(),
				new ItemBuilder(Material.DIAMOND_HELMET).addEnchantement(Enchantment.PROTECTION_ENVIRONMENTAL, 3)
						.build() };

	}

}
