package net.mcreator.desafosahuaria.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.client.gui.components.EditBox;

import net.mcreator.desafosahuaria.network.DesafosahuariaModVariables;

import java.util.HashMap;

public class Save1Procedure {
	public static void execute(LevelAccessor world, HashMap guistate) {
		if (guistate == null)
			return;
		DesafosahuariaModVariables.MapVariables.get(world).muertetexto = guistate.containsKey("text:muertetexto") ? ((EditBox) guistate.get("text:muertetexto")).getValue() : "";
		DesafosahuariaModVariables.MapVariables.get(world).syncData(world);
	}
}
