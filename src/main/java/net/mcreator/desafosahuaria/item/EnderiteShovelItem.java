
package net.mcreator.desafosahuaria.item;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

import net.mcreator.desafosahuaria.init.DesafosahuariaModItems;

public class EnderiteShovelItem extends ShovelItem {
	public EnderiteShovelItem() {
		super(new Tier() {
			public int getUses() {
				return 2032;
			}

			public float getSpeed() {
				return 12f;
			}

			public float getAttackDamageBonus() {
				return 1.25f;
			}

			public int getLevel() {
				return 5;
			}

			public int getEnchantmentValue() {
				return 22;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(Items.AMETHYST_SHARD), new ItemStack(DesafosahuariaModItems.FRAGMENTO_DE_ENDERITE.get()));
			}
		}, 1, -3f, new Item.Properties().fireResistant());
	}
}
