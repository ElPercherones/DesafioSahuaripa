package net.mcreator.desafosahuaria.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.desafosahuaria.init.DesafosahuariaModGameRules;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class EnderGhastSpawnProcedure {
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
			if (entity instanceof EnderMan && !(!world.getEntitiesOfClass(EnderMan.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).isEmpty())) {
				if (world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))) {
					if (Math.random() < (world.getLevelData().getGameRules().getInt(DesafosahuariaModGameRules.HARDCORE_DIFFICULTY)) * 0.01) {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(
									new CommandSourceStack(CommandSource.NULL, new Vec3((x + Mth.nextDouble(RandomSource.create(), 0, 3)), (y + Mth.nextDouble(RandomSource.create(), 3, 10)), (z + Mth.nextDouble(RandomSource.create(), 0, 3))),
											Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"/summon minecraft:ghast ~ ~1 ~ {Health:60,Attributes:[{Name:\"generic.maxHealth\",Base:60}]}");
					} else if ((world.getLevelData().getGameRules().getInt(DesafosahuariaModGameRules.HARDCORE_DIFFICULTY)) >= 50) {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"/summon minecraft:creeper ~ ~1 ~ {powered:1,Health:20,Attributes:[{Name:\"generic.maxHealth\",Base:20}],ExplosionRadius:6,Fuse:18}");
					}
				}
			}
		}
	}
}
