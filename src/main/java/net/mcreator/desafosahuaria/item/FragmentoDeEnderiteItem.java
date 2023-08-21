
package net.mcreator.desafosahuaria.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class FragmentoDeEnderiteItem extends Item {
	public FragmentoDeEnderiteItem() {
		super(new Item.Properties().stacksTo(64).fireResistant().rarity(Rarity.EPIC));
	}
}
