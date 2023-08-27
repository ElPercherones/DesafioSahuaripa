
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.desafosahuaria.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.desafosahuaria.DesafosahuariaMod;

public class DesafosahuariaModPotions {
	public static final DeferredRegister<Potion> REGISTRY = DeferredRegister.create(ForgeRegistries.POTIONS, DesafosahuariaMod.MODID);
	public static final RegistryObject<Potion> DECONSTRUCCION_POCION = REGISTRY.register("deconstruccion_pocion", () -> new Potion(new MobEffectInstance(DesafosahuariaModMobEffects.DECONSTRUCCION.get(), 3600, 0, false, true)));
}
