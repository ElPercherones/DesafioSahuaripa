package net.mcreator.desafosahuaria.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Checkbox;

import net.mcreator.desafosahuaria.network.DesafosahuariaModVariables;

import java.util.HashMap;

public class MuerteTextosProcedure {
	public static void execute(LevelAccessor world, Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		if (entity instanceof Player _player)
			_player.closeContainer();
		DesafosahuariaModVariables.MapVariables.get(world).muertetexto = guistate.containsKey("text:muertetexto") ? ((EditBox) guistate.get("text:muertetexto")).getValue() : "";
		DesafosahuariaModVariables.MapVariables.get(world).syncData(world);
		DesafosahuariaModVariables.MapVariables.get(world).muertetexto2 = guistate.containsKey("text:muertetexto2") ? ((EditBox) guistate.get("text:muertetexto2")).getValue() : "";
		DesafosahuariaModVariables.MapVariables.get(world).syncData(world);
		if (guistate.containsKey("checkbox:efectomuerte") ? ((Checkbox) guistate.get("checkbox:efectomuerte")).selected() : false) {
			DesafosahuariaModVariables.MapVariables.get(world).efectomuerte = true;
			DesafosahuariaModVariables.MapVariables.get(world).syncData(world);
		}
		if (guistate.containsKey("checkbox:tormenta") ? ((Checkbox) guistate.get("checkbox:tormenta")).selected() : false) {
			DesafosahuariaModVariables.MapVariables.get(world).tormenta = true;
			DesafosahuariaModVariables.MapVariables.get(world).syncData(world);
		}
		DesafosahuariaModVariables.MapVariables.get(world).tormentatiempo = guistate.containsKey("text:tormentatiempo") ? ((EditBox) guistate.get("text:tormentatiempo")).getValue() : "";
		DesafosahuariaModVariables.MapVariables.get(world).syncData(world);
		DesafosahuariaModVariables.MapVariables.get(world).tormentatexto = guistate.containsKey("text:tormentatexto") ? ((EditBox) guistate.get("text:tormentatexto")).getValue() : "";
		DesafosahuariaModVariables.MapVariables.get(world).syncData(world);
		if (guistate.containsKey("checkbox:piglinsspawn") ? ((Checkbox) guistate.get("checkbox:piglinsspawn")).selected() : false) {
			DesafosahuariaModVariables.MapVariables.get(world).piglinsspawn = true;
			DesafosahuariaModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
