package fr.cactuscata.pvparea;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import fr.cactuscata.pvparea.listeners.InventoryClickListener;
import fr.cactuscata.pvparea.listeners.JoinGameListener;
import fr.cactuscata.pvparea.utils.bukkit.PlayerArea;

public final class PvPArea extends JavaPlugin {

	@Override
	public final void onEnable() {

		PlayerArea.regsiterAllPlayers();
		
		final PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvents(new JoinGameListener(), this);
		pm.registerEvents(new InventoryClickListener(), this);

	}

	@Override
	public final void onDisable() {

		PlayerArea.unregisterAllPlayers();

	}

}
