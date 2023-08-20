
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.desafosahuaria.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.mcreator.desafosahuaria.potion.DeconstruccionMobEffect;
import net.mcreator.desafosahuaria.DesafosahuariaMod;

public class DesafosahuariaModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, DesafosahuariaMod.MODID);
	public static final RegistryObject<MobEffect> DECONSTRUCCION = REGISTRY.register("deconstruccion", () -> new DeconstruccionMobEffect());
}
