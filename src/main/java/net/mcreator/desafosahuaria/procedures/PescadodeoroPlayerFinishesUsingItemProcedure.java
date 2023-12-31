package net.mcreator.desafosahuaria.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.desafosahuaria.init.DesafosahuariaModMobEffects;
import net.mcreator.desafosahuaria.init.DesafosahuariaModGameRules;

public class PescadodeoroPlayerFinishesUsingItemProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player) {
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 200, 2, false, true));
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 300, 2, false, true));
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 300, 1, false, true));
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 200, 1, false, true));
			if (Math.random() < (world.getLevelData().getGameRules().getInt(DesafosahuariaModGameRules.HARDCORE_DIFFICULTY)) * 0.02) {
				if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
					_entity.addEffect(new MobEffectInstance(DesafosahuariaModMobEffects.DECONSTRUCCION.get(), 200, 0, false, true));
			}
			if (entity instanceof LivingEntity _livEnt7 && _livEnt7.hasEffect(DesafosahuariaModMobEffects.DECONSTRUCCION.get())) {
				if (Math.random() < (world.getLevelData().getGameRules().getInt(DesafosahuariaModGameRules.HARDCORE_DIFFICULTY)) * 0.005) {
					if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
						_entity.addEffect(new MobEffectInstance(DesafosahuariaModMobEffects.DECONSTRUCCION.get(),
								(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(DesafosahuariaModMobEffects.DECONSTRUCCION.get()) ? _livEnt.getEffect(DesafosahuariaModMobEffects.DECONSTRUCCION.get()).getDuration() : 0) + 40),
								(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(DesafosahuariaModMobEffects.DECONSTRUCCION.get()) ? _livEnt.getEffect(DesafosahuariaModMobEffects.DECONSTRUCCION.get()).getAmplifier() : 0) + 1)));
				}
			}
		}
	}
}
