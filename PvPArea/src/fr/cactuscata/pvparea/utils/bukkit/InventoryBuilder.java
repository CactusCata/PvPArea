package fr.cactuscata.pvparea.utils.bukkit;

import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryBuilder {

	private final Inventory inventory;

	public InventoryBuilder(int size) {
		this.inventory = Bukkit.createInventory(null, size);
	}

	public InventoryBuilder(int size, String inventoryName) {
		this.inventory = Bukkit.createInventory(null, size, inventoryName);
	}

	public InventoryBuilder(InventoryType inventoryType, String inventoryName) {
		this.inventory = Bukkit.createInventory(null, inventoryType, inventoryName);
	}

	public final InventoryBuilder addItem(ItemStack item) {
		this.inventory.addItem(item);
		return this;
	}

	public final InventoryBuilder addItem(ItemBuilder item) {
		return this.addItem(item.build());
	}

	public final InventoryBuilder setItem(int index, ItemStack item) {
		this.inventory.setItem(index, item);
		return this;
	}

	public final InventoryBuilder setItem(int index, ItemBuilder item) {
		return this.setItem(index, item.build());
	}

	public final Inventory build() {
		return this.inventory;
	}

}
