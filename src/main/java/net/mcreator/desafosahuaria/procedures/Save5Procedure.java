package net.mcreator.desafosahuaria.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.client.gui.components.Checkbox;

import net.mcreator.desafosahuaria.network.DesafosahuariaModVariables;

import java.util.HashMap;

public class Save5Procedure {
	public static void execute(LevelAccessor world, HashMap guistate) {
		if (guistate == null)
			return;
		if (guistate.containsKey("checkbox:piglinsspawn") ? ((Checkbox) guistate.get("checkbox:piglinsspawn")).selected() : false) {
			DesafosahuariaModVariables.MapVariables.get(world).piglinsspawn = true;
			DesafosahuariaModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
