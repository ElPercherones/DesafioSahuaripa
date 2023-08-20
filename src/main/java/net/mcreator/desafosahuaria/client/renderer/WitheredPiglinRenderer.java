
package net.mcreator.desafosahuaria.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.PiglinModel;

import net.mcreator.desafosahuaria.entity.WitheredPiglinEntity;

public class WitheredPiglinRenderer extends MobRenderer<WitheredPiglinEntity, PiglinModel<WitheredPiglinEntity>> {
	public WitheredPiglinRenderer(EntityRendererProvider.Context context) {
		super(context, new PiglinModel(context.bakeLayer(ModelLayers.PIGLIN)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(WitheredPiglinEntity entity) {
		return new ResourceLocation("desafosahuaria:textures/entities/withered_piglin.png");
	}
}
