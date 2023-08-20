
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.desafosahuaria.init;

import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.GameRules;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DesafosahuariaModGameRules {
	public static final GameRules.Key<GameRules.IntegerValue> HARDCORE_DIFFICULTY = GameRules.register("hardcoreDifficulty", GameRules.Category.UPDATES, GameRules.IntegerValue.create(0));
}
