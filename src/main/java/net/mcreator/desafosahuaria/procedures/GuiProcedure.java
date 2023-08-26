package net.mcreator.desafosahuaria.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.Minecraft;

import net.mcreator.desafosahuaria.init.DesafosahuariaModItems;

import java.util.HashMap;

public class GuiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		if (entity instanceof Player _player)
			_player.closeContainer();
		if (!(guistate.containsKey("text:nombrerevivir") ? ((EditBox) guistate.get("text:nombrerevivir")).getValue() : "").equals("@p")
				|| !(guistate.containsKey("text:nombrerevivir") ? ((EditBox) guistate.get("text:nombrerevivir")).getValue() : "").equals("@e")
				|| !(guistate.containsKey("text:nombrerevivir") ? ((EditBox) guistate.get("text:nombrerevivir")).getValue() : "").equals("@a")) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("/gamemode survival " + (guistate.containsKey("text:nombrerevivir") ? ((EditBox) guistate.get("text:nombrerevivir")).getValue() : "")));
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.levelup")), SoundSource.NEUTRAL, 2, 2);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.levelup")), SoundSource.NEUTRAL, 2, 2, false);
				}
			}
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(((guistate.containsKey("text:nombrerevivir") ? ((EditBox) guistate.get("text:nombrerevivir")).getValue() : "") + " ha revivido!")), false);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.COMPOSTER, x, y, z, 5, 3, 3, 3, 1);
			if (!(new Object() {
				public boolean checkGamemode(Entity _ent) {
					if (_ent instanceof ServerPlayer _serverPlayer) {
						return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
					} else if (_ent.level.isClientSide() && _ent instanceof Player _player) {
						return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
								&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
					}
					return false;
				}
			}.checkGamemode(entity))) {
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(DesafosahuariaModItems.RELIQUIA_DE_RESURRECION.get());
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
			}
		} else {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"/titleraw @p actionbar {\"rawtext\":[{\"text\":\"\u00A74Nombre no v\u00E1lido\"}]}");
		}
	}
}
