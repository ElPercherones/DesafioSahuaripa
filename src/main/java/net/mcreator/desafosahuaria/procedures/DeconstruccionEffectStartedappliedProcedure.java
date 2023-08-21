package net.mcreator.desafosahuaria.procedures;

import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.core.registries.Registries;

import net.mcreator.desafosahuaria.init.DesafosahuariaModMobEffects;

public class DeconstruccionEffectStartedappliedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double nivel = 0;
		if (!(entity instanceof LivingEntity _livEnt0 && _livEnt0.getMobType() == MobType.UNDEAD)) {
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(DesafosahuariaModMobEffects.DECONSTRUCCION.get()) ? _livEnt.getEffect(DesafosahuariaModMobEffects.DECONSTRUCCION.get()).getAmplifier() : 0) == 0) {
				((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).setBaseValue((((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getValue() - 2));
			} else if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(DesafosahuariaModMobEffects.DECONSTRUCCION.get()) ? _livEnt.getEffect(DesafosahuariaModMobEffects.DECONSTRUCCION.get()).getAmplifier() : 0) > 0) {
				((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).setBaseValue((((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getValue()
						- ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(DesafosahuariaModMobEffects.DECONSTRUCCION.get()) ? _livEnt.getEffect(DesafosahuariaModMobEffects.DECONSTRUCCION.get()).getAmplifier() : 0) + 1) * 2));
			}
		}
		{
			Entity _entToDamage = entity;
			_entToDamage.hurt(new DamageSource(_entToDamage.level.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.WITHER)), 1);
		}
	}
}
