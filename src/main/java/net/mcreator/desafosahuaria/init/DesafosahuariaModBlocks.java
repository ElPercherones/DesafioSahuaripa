
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.desafosahuaria.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.desafosahuaria.block.HardcorePotBlock;
import net.mcreator.desafosahuaria.block.EscombroDeEnderiteBlock;
import net.mcreator.desafosahuaria.DesafosahuariaMod;

public class DesafosahuariaModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, DesafosahuariaMod.MODID);
	public static final RegistryObject<Block> HARDCORE_POT = REGISTRY.register("hardcore_pot", () -> new HardcorePotBlock());
	public static final RegistryObject<Block> ESCOMBRO_DE_ENDERITE = REGISTRY.register("escombro_de_enderite", () -> new EscombroDeEnderiteBlock());
}
