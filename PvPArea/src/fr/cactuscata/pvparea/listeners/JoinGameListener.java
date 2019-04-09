package fr.cactuscata.pvparea.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import fr.cactuscata.pvparea.utils.bukkit.PlayerArea;

public final class JoinGameListener implements Listener {

	@EventHandler
	public final void onJoinGame(final PlayerJoinEvent event) {

		final Player player = event.getPlayer();
		new PlayerArea(player);

	}

}
