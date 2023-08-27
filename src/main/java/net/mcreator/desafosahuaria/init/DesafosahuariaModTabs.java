
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.desafosahuaria.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.CreativeModeTabEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DesafosahuariaModTabs {
	@SubscribeEvent
	public static void buildTabContentsModded(CreativeModeTabEvent.Register event) {
		event.registerCreativeModeTab(new ResourceLocation("desafosahuaria", "desafio_sahuaripa_1"),
				builder -> builder.title(Component.translatable("item_group.desafosahuaria.desafio_sahuaripa_1")).icon(() -> new ItemStack(DesafosahuariaModItems.RELIQUIA_SAHUARIPA.get())).displayItems((parameters, tabData) -> {
					tabData.accept(DesafosahuariaModItems.MEJORADEARMADURA_1.get());
					tabData.accept(DesafosahuariaModItems.RELIQUIA_DE_VIDA.get());
					tabData.accept(DesafosahuariaModItems.MEJORADEARMADURA_2.get());
					tabData.accept(DesafosahuariaModItems.MEJORADEARMADURA_3.get());
					tabData.accept(DesafosahuariaModItems.MEJORADEARMADURA_4.get());
					tabData.accept(DesafosahuariaModItems.RELIQUIA_SAHUARIPA.get());
					tabData.accept(DesafosahuariaModBlocks.HARDCORE_POT.get().asItem());
					tabData.accept(DesafosahuariaModItems.BASTON_DE_AMATISTA_2.get());
				})

		);
		event.registerCreativeModeTab(new ResourceLocation("desafosahuaria", "desafio_sahuaripa_2"),
				builder -> builder.title(Component.translatable("item_group.desafosahuaria.desafio_sahuaripa_2")).icon(() -> new ItemStack(DesafosahuariaModItems.MEJORA_DE_AMATISTA.get())).displayItems((parameters, tabData) -> {
					tabData.accept(DesafosahuariaModItems.PITAYADORADA.get());
					tabData.accept(DesafosahuariaModItems.PESCADODEORO.get());
					tabData.accept(DesafosahuariaModItems.PITAYA.get());
					tabData.accept(DesafosahuariaModItems.LANZA_DE_AMATISTA.get());
					tabData.accept(DesafosahuariaModItems.RELIQUIA_DE_RESURRECION.get());
					tabData.accept(DesafosahuariaModItems.MEJORA_DE_AMATISTA.get());
					tabData.accept(DesafosahuariaModBlocks.ESCOMBRO_DE_ENDERITE.get().asItem());
					tabData.accept(DesafosahuariaModItems.FRAGMENTO_DE_ENDERITE.get());
					tabData.accept(DesafosahuariaModItems.ENDERITE_ARMOR_SET_HELMET.get());
					tabData.accept(DesafosahuariaModItems.ENDERITE_ARMOR_SET_CHESTPLATE.get());
					tabData.accept(DesafosahuariaModItems.ENDERITE_ARMOR_SET_LEGGINGS.get());
					tabData.accept(DesafosahuariaModItems.ENDERITE_ARMOR_SET_BOOTS.get());
					tabData.accept(DesafosahuariaModItems.ENDERITE_AXE.get());
					tabData.accept(DesafosahuariaModItems.ENDERITE_HOE.get());
					tabData.accept(DesafosahuariaModItems.ENDERITE_PICKAXE.get());
					tabData.accept(DesafosahuariaModItems.ENDERITE_SHOVEL.get());
				})

		);
	}
}
