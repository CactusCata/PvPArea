package fr.cactuscata.pvparea.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import fr.cactuscata.pvparea.system.Area;
import fr.cactuscata.pvparea.system.AreaType;
import fr.cactuscata.pvparea.utils.bukkit.PlayerArea;

public final class InventoryClickListener implements Listener {

	@EventHandler
	public final void onClickInventory(final InventoryClickEvent event) {

		final Player player = (Player) event.getWhoClicked();
		final PlayerArea playerArea = PlayerArea.getPlayerArea(player);
		if (playerArea.getAreaType() != AreaType.SPAWN)
			return;
		ItemStack item = event.getCurrentItem();
		if (item == null)
			return;
		for (final AreaType areaType : AreaType.values())

			if (Area.getArea(areaType).getItem().equals(item)) {

				playerArea.setAreaType(areaType);
				return;

			}

	}

}
