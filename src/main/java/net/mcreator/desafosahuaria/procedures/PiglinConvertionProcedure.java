package net.mcreator.desafosahuaria.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.animal.Pig;
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
public class PiglinConvertionProcedure {
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
		if (entity instanceof Pig) {
			if (Math.random() < (world.getLevelData().getGameRules().getInt(DesafosahuariaModGameRules.HARDCORE_DIFFICULTY)) * 0.01) {
				if (!((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.NETHER_PORTAL)) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, new Vec3((x + Mth.nextDouble(RandomSource.create(), 0, 2)), y, (z + Mth.nextDouble(RandomSource.create(), 0, 2))), Vec2.ZERO, _level, 4, "", Component.literal(""),
										_level.getServer(), null).withSuppressedOutput(),
								"/summon minecraft:piglin_brute ~ ~1 ~ {Health:30,Attributes:[{Name:\"generic.maxHealth\",Base:30},{Name:\"generic.attackDamage\",Base:6}],HandItems:[{id:\"minecraft:netherite_axe\",tag:{Enchantments:[{id:sharpness,lvl:5},{id:unbreaking,lvl:3}]},Count:1},{id:\"minecraft:shield\",tag:{Enchantments:[{id:unbreaking,lvl:3}]},Count:1}],ArmorItems:[{tag:{Enchantments:[{id:protection,lvl:3},{id:feather_falling,lvl:2}]},id:\"minecraft:netherite_boots\",Count:1},{tag:{Enchantments:[{id:protection,lvl:3}]},id:\"minecraft:netherite_leggings\",Count:1},{tag:{Enchantments:[{id:protection,lvl:3}]},id:\"minecraft:netherite_chestplate\",Count:1},{id:\"minecraft:glass\",Count:1}]}");
				}
			}
		}
	}
}
