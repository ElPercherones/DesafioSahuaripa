package net.mcreator.desafosahuaria.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.client.gui.components.EditBox;

import net.mcreator.desafosahuaria.network.DesafosahuariaModVariables;

import java.util.HashMap;

public class Save4Procedure {
	public static void execute(LevelAccessor world, HashMap guistate) {
		if (guistate == null)
			return;
		DesafosahuariaModVariables.MapVariables.get(world).tormentatexto = guistate.containsKey("text:tormentatexto") ? ((EditBox) guistate.get("text:tormentatexto")).getValue() : "";
		DesafosahuariaModVariables.MapVariables.get(world).syncData(world);
	}
}
