
package net.mcreator.desafosahuaria.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.desafosahuaria.procedures.DeconstruccionEffectStartedappliedProcedure;
import net.mcreator.desafosahuaria.procedures.DeconstruccionEffectExpiresProcedure;

public class DeconstruccionMobEffect extends MobEffect {
	public DeconstruccionMobEffect() {
		super(MobEffectCategory.HARMFUL, -10092442);
	}

	@Override
	public String getDescriptionId() {
		return "effect.desafosahuaria.deconstruccion";
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		DeconstruccionEffectStartedappliedProcedure.execute(entity);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		DeconstruccionEffectExpiresProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
