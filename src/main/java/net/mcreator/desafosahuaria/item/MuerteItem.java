
package net.mcreator.desafosahuaria.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class MuerteItem extends Item {
	public MuerteItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC));
	}
}
