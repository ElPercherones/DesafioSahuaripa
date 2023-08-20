package net.mcreator.desafosahuaria.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.client.Minecraft;

import net.mcreator.desafosahuaria.init.DesafosahuariaModItems;

public class TotemProcedure {
	public static void execute(LevelAccessor world) {
		if (world.isClientSide()) {
			if (world.isClientSide())
				Minecraft.getInstance().gameRenderer.displayItemActivation(new ItemStack(DesafosahuariaModItems.RELIQUIA_SAHUARIPA.get()));
		}
	}
}
