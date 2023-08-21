
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.desafosahuaria.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.mcreator.desafosahuaria.item.ReliquiaSahuaripaItem;
import net.mcreator.desafosahuaria.item.ReliquiaDeVidaItem;
import net.mcreator.desafosahuaria.item.ReliquiaDeResurrecionItem;
import net.mcreator.desafosahuaria.item.PitayadoradaItem;
import net.mcreator.desafosahuaria.item.PitayaItem;
import net.mcreator.desafosahuaria.item.PescadodeoroItem;
import net.mcreator.desafosahuaria.item.Mejoradearmadura4Item;
import net.mcreator.desafosahuaria.item.Mejoradearmadura3Item;
import net.mcreator.desafosahuaria.item.Mejoradearmadura2Item;
import net.mcreator.desafosahuaria.item.Mejoradearmadura1Item;
import net.mcreator.desafosahuaria.item.MejoraDeAmatistaItem;
import net.mcreator.desafosahuaria.item.LanzaDeAmatistaItem;
import net.mcreator.desafosahuaria.item.FragmentoDeEnderiteItem;
import net.mcreator.desafosahuaria.item.BastonDeAmatistaItem;
import net.mcreator.desafosahuaria.item.BastonDeAmatista2Item;
import net.mcreator.desafosahuaria.DesafosahuariaMod;

public class DesafosahuariaModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, DesafosahuariaMod.MODID);
	public static final RegistryObject<Item> PITAYADORADA = REGISTRY.register("pitayadorada", () -> new PitayadoradaItem());
	public static final RegistryObject<Item> MEJORADEARMADURA_1 = REGISTRY.register("mejoradearmadura_1", () -> new Mejoradearmadura1Item());
	public static final RegistryObject<Item> PESCADODEORO = REGISTRY.register("pescadodeoro", () -> new PescadodeoroItem());
	public static final RegistryObject<Item> RELIQUIA_DE_VIDA = REGISTRY.register("reliquia_de_vida", () -> new ReliquiaDeVidaItem());
	public static final RegistryObject<Item> MEJORADEARMADURA_2 = REGISTRY.register("mejoradearmadura_2", () -> new Mejoradearmadura2Item());
	public static final RegistryObject<Item> MEJORADEARMADURA_3 = REGISTRY.register("mejoradearmadura_3", () -> new Mejoradearmadura3Item());
	public static final RegistryObject<Item> MEJORADEARMADURA_4 = REGISTRY.register("mejoradearmadura_4", () -> new Mejoradearmadura4Item());
	public static final RegistryObject<Item> RELIQUIA_SAHUARIPA = REGISTRY.register("reliquia_sahuaripa", () -> new ReliquiaSahuaripaItem());
	public static final RegistryObject<Item> BASTON_DE_AMATISTA = REGISTRY.register("baston_de_amatista", () -> new BastonDeAmatistaItem());
	public static final RegistryObject<Item> HARDCORE_POT = block(DesafosahuariaModBlocks.HARDCORE_POT);
	public static final RegistryObject<Item> BASTON_DE_AMATISTA_2 = REGISTRY.register("baston_de_amatista_2", () -> new BastonDeAmatista2Item());
	public static final RegistryObject<Item> PITAYA = REGISTRY.register("pitaya", () -> new PitayaItem());
	public static final RegistryObject<Item> LANZA_DE_AMATISTA = REGISTRY.register("lanza_de_amatista", () -> new LanzaDeAmatistaItem());
	public static final RegistryObject<Item> RELIQUIA_DE_RESURRECION = REGISTRY.register("reliquia_de_resurrecion", () -> new ReliquiaDeResurrecionItem());
	public static final RegistryObject<Item> MEJORA_DE_AMATISTA = REGISTRY.register("mejora_de_amatista", () -> new MejoraDeAmatistaItem());
	public static final RegistryObject<Item> ESCOMBRO_DE_ENDERITE = block(DesafosahuariaModBlocks.ESCOMBRO_DE_ENDERITE);
	public static final RegistryObject<Item> FRAGMENTO_DE_ENDERITE = REGISTRY.register("fragmento_de_enderite", () -> new FragmentoDeEnderiteItem());

	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
