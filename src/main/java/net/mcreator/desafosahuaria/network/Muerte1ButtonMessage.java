
package net.mcreator.desafosahuaria.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.desafosahuaria.world.inventory.Muerte1Menu;
import net.mcreator.desafosahuaria.procedures.Save4Procedure;
import net.mcreator.desafosahuaria.procedures.Save3Procedure;
import net.mcreator.desafosahuaria.procedures.Save2Procedure;
import net.mcreator.desafosahuaria.procedures.Save1Procedure;
import net.mcreator.desafosahuaria.procedures.MuerteTextosProcedure;
import net.mcreator.desafosahuaria.procedures.AbrirPag2Procedure;
import net.mcreator.desafosahuaria.DesafosahuariaMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class Muerte1ButtonMessage {
	private final int buttonID, x, y, z;

	public Muerte1ButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public Muerte1ButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(Muerte1ButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(Muerte1ButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level;
		HashMap guistate = Muerte1Menu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			MuerteTextosProcedure.execute(world, entity, guistate);
		}
		if (buttonID == 1) {

			AbrirPag2Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			Save1Procedure.execute(world, guistate);
		}
		if (buttonID == 3) {

			Save2Procedure.execute(world, guistate);
		}
		if (buttonID == 4) {

			Save3Procedure.execute(world, guistate);
		}
		if (buttonID == 5) {

			Save4Procedure.execute(world, guistate);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		DesafosahuariaMod.addNetworkMessage(Muerte1ButtonMessage.class, Muerte1ButtonMessage::buffer, Muerte1ButtonMessage::new, Muerte1ButtonMessage::handler);
	}
}
