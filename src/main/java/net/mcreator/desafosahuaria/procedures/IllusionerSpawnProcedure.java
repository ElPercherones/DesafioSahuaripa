package net.mcreator.desafosahuaria.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.monster.Illusioner;
import net.minecraft.world.entity.monster.Evoker;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;

import net.mcreator.desafosahuaria.init.DesafosahuariaModGameRules;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class IllusionerSpawnProcedure {
	@SubscribeEvent
	public static void onEntitySpawned(EntityJoinLevelEvent event) {
		execute(event, event.getLevel(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((world.getLevelData().getGameRules().getInt(DesafosahuariaModGameRules.HARDCORE_DIFFICULTY)) > 0) {
			if (entity instanceof Evoker) {
				if (Math.random() < (world.getLevelData().getGameRules().getInt(DesafosahuariaModGameRules.HARDCORE_DIFFICULTY)) * 0.01) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = new Illusioner(EntityType.ILLUSIONER, _level);
						entityToSpawn.moveTo((x + Mth.nextDouble(RandomSource.create(), 0, 1)), y, (z + Mth.nextDouble(RandomSource.create(), 1, 1)), 0, 0);
						entityToSpawn.setYBodyRot(0);
						entityToSpawn.setYHeadRot(0);
						entityToSpawn.setDeltaMovement(0, 0, 0);
						if (entityToSpawn instanceof Mob _mobToSpawn)
							_mobToSpawn.finalizeSpawn(_level, _level.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
						_level.addFreshEntity(entityToSpawn);
					}
				}
			}
		}
	}
}
