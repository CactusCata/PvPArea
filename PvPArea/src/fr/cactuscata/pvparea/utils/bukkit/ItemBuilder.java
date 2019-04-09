package fr.cactuscata.pvparea.utils.bukkit;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

/**
 * <p>
 * Cette classe qui fonctionne sous forme de buildPatern permet de cr�er
 * facilement des items.
 * </p>
 * 
 * @author CactusCata
 * @version 1.0.0
 * @since 1.0.0
 */

public final class ItemBuilder {

	private ItemStack item;
	private ItemMeta itemM;

	/**
	 * @param material
	 *            Materiel.
	 * @param amount
	 *            Nombre d'items.
	 * @param damageValue
	 *            La valeur de la damageValue.
	 */
	public ItemBuilder(final Material material, final int amount, final byte damageValue) {
		this.item = new ItemStack(material, amount, damageValue);
		this.itemM = this.item.getItemMeta();
	}

	/**
	 * 
	 * @param material
	 *            Materiel.
	 * @param amount
	 *            Nombre d'items.
	 */
	public ItemBuilder(final Material material, final int amount) {
		this(material, amount, (byte) 0);
	}

	/**
	 * 
	 * @param material
	 *            Materiel.
	 * @param damageValue
	 *            La valeur de la damageValue.
	 */
	public ItemBuilder(final Material material, final byte damageValue) {
		this(material, 1, damageValue);
	}

	/**
	 * 
	 * @param material
	 *            Materiel.
	 */
	public ItemBuilder(final Material material) {
		this(material, 1, (byte) 0);
	}

	/**
	 * 
	 * @param item
	 *            ItemStack.
	 */
	public ItemBuilder(final ItemStack item) {
		this.item = item;
		this.itemM = item.getItemMeta();
	}

	/**
	 * M�thode qui permet de cr�er cr�er un cr�ne
	 * 
	 * @param playerName
	 *            Nom du joueur.
	 * @return return Le cr�ne du joueur.
	 */
	public static final ItemStack createSkull(final String playerName) {
		final ItemStack item = new ItemBuilder(Material.SKULL_ITEM, (byte) 3).build();
		final SkullMeta meta = (SkullMeta) Bukkit.getItemFactory().getItemMeta(Material.SKULL_ITEM);
		meta.setOwner(playerName);
		item.setItemMeta(meta);
		return item;
	}

	/**
	 * M�thode qui permet de colorer les items de {@link Material#LEATHER_BOOTS},
	 * {@link Material#LEATHER_LEGGINGS}, {@link Material#LEATHER_CHESTPLATE} et
	 * {@link Material#LEATHER_HELMET}.
	 * 
	 * @param red
	 *            Rouge.
	 * @param green
	 *            Vert.
	 * @param blue
	 *            Bleu
	 * @return L'instance de la classe.
	 */
	public final ItemBuilder color(final int red, final int green, final int blue) {
		if (this.item.getType() != Material.LEATHER_BOOTS && this.item.getType() != Material.LEATHER_LEGGINGS
				&& this.item.getType() != Material.LEATHER_CHESTPLATE && this.item.getType() != Material.LEATHER_HELMET)
			throw new IllegalArgumentException("L'item de base n'est pas de cuir !");
		((LeatherArmorMeta) this.itemM).setColor(Color.fromBGR(red, green, blue));

		return this;
	}

	/**
	 * M�thode qui permet de cr�er une description et de la placer sur l'item en
	 * question.
	 * 
	 * @param lore
	 *            Liste de {@link String} qui d�finissent la d�sctiption de l'item.
	 * @return L'instance de la classe.
	 */
	public final ItemBuilder setLore(final List<String> lore) {
		this.itemM.setLore(lore);
		return this;
	}

	/**
	 * M�thode qui permet de placer un nom customi� pour l'item.
	 * 
	 * @param displayName
	 *            Nom customis�.
	 * @return L'instance de la classe.
	 */
	public final ItemBuilder setDisplayName(final String displayName) {
		this.itemM.setDisplayName(displayName);
		return this;
	}

	/**
	 * M�thode qui rend invuln�rable aux d�gats d'utilisation.
	 * 
	 * @return L'instance de la classe.
	 */
	public final ItemBuilder setUnbreakable() {
		this.itemM.spigot().setUnbreakable(true);
		return this;
	}

	/**
	 * M�thode qui permet d'ajouter un enchantement � l'tem.
	 * 
	 * @param enchentement
	 *            L'enchantement voulu.
	 * @param level
	 *            Le niveay d'enchantement.
	 * @return L'instance de la classe.
	 */
	public final ItemBuilder addEnchantement(final Enchantment enchentement, final int level) {
		this.itemM.addEnchant(enchentement, level, true);
		return this;
	}

	/**
	 * M�thode qui permet de cacher certains attributs de l'item comme sa durabilit�
	 * ou ses enchantements.
	 * 
	 * @param itemFlags
	 *            Se qui l'�num�artion va cacher.
	 * @return L'instance de la classe.
	 */
	public final ItemBuilder addItemFlags(final ItemFlag... itemFlags) {
		this.itemM.addItemFlags(itemFlags);
		return this;
	}

	/**
	 * M�thode qui permet d'ajouter un effect visiel d'enchantement.
	 * 
	 * @return L'instance de la classe.
	 */
	public final ItemBuilder setGlowing() {
		addEnchantement(Enchantment.DAMAGE_UNDEAD, 0);
		addItemFlags(ItemFlag.HIDE_ENCHANTS);
		return this;
	}

	/**
	 * M�thode qui permet d'ajouter un effect visuel d'enchantement sous condition.
	 * 
	 * @param wantGlowing
	 *            met le glowing si <code>true</code>.
	 * @return L'instance de la classe.
	 */
	public final ItemBuilder setGlowing(final boolean wantGlowing) {
		if (wantGlowing)
			setGlowing();
		return this;
	}

	/**
	 * M�thode qui permet de r�cuperer l'ItemStack � partie de cette classe.
	 * 
	 * @return L'ItemStack associ� au build.
	 */
	public final ItemStack build() {
		this.item.setItemMeta(this.itemM);
		return this.item;
	}

	/**
	 * M�thode qui convertie cette classe en {@link CraftItemStack}.
	 * 
	 * @return {@link CraftItemStack}.
	 */
	public final CraftItemStack toCraftItemStack() {
		return CraftItemStack.asCraftCopy(this.build());
	}

	/**
	 * M�thode qui conertie cette classe en Nms
	 * {@link net.minecraft.server.v1_8_R3.ItemStack}.
	 * 
	 * @return {@link net.minecraft.server.v1_8_R3.ItemStack}.
	 */
	public final net.minecraft.server.v1_8_R3.ItemStack toNMSItemStack() {
		return CraftItemStack.asNMSCopy(this.build());
	}

}