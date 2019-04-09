package fr.cactuscata.pvparea.utils.bukkit;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public final class LocationSerialiser {
	private static final DecimalFormat decimalFormat = new DecimalFormat("0.000");

	static {
		final DecimalFormatSymbols formatSymbols = decimalFormat.getDecimalFormatSymbols();
		formatSymbols.setDecimalSeparator('.');
		decimalFormat.setDecimalFormatSymbols(formatSymbols);
	}

	public static final Location locationFromString(final String input) {

		final String[] parts = input.split(",");

		final double x = Double.parseDouble(parts[1].replace(" ", "")),
				y = Double.parseDouble(parts[2].replace(" ", "")), z = Double.parseDouble(parts[3].replace(" ", ""));
		float yaw = 0.0f, pitch = 0.0f;

		if (parts.length > 5) {
			yaw = Float.parseFloat(parts[4].replace(" ", ""));
			pitch = Float.parseFloat(parts[5].replace(" ", ""));
		}

		return new Location(Bukkit.getWorld(parts[0].trim()), x, y, z, yaw, pitch);

	}

	public static final String locationToString(final Location location) {
		return location.getWorld().getName() + ", " + decimalFormat.format(location.getX()) + ", "
				+ decimalFormat.format(location.getY()) + ", " + decimalFormat.format(location.getZ());
	}
}