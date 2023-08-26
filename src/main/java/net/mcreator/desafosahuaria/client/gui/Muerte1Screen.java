package net.mcreator.desafosahuaria.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;

import net.mcreator.desafosahuaria.world.inventory.Muerte1Menu;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class Muerte1Screen extends AbstractContainerScreen<Muerte1Menu> {
	private final static HashMap<String, Object> guistate = Muerte1Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox muertetexto;
	EditBox muertetexto2;
	Button button_enter;

	public Muerte1Screen(Muerte1Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 100;
	}

	private static final ResourceLocation texture = new ResourceLocation("desafosahuaria:textures/screens/muerte_1.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
		muertetexto.render(ms, mouseX, mouseY, partialTicks);
		muertetexto2.render(ms, mouseX, mouseY, partialTicks);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (muertetexto.isFocused())
			return muertetexto.keyPressed(key, b, c);
		if (muertetexto2.isFocused())
			return muertetexto2.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		muertetexto.tick();
		muertetexto2.tick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		muertetexto = new EditBox(this.font, this.leftPos + 27, this.topPos + 17, 120, 20, Component.translatable("gui.desafosahuaria.muerte_1.muertetexto")) {
			{
				setSuggestion(Component.translatable("gui.desafosahuaria.muerte_1.muertetexto").getString());
			}

			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.desafosahuaria.muerte_1.muertetexto").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.desafosahuaria.muerte_1.muertetexto").getString());
				else
					setSuggestion(null);
			}
		};
		muertetexto.setMaxLength(32767);
		guistate.put("text:muertetexto", muertetexto);
		this.addWidget(this.muertetexto);
		muertetexto2 = new EditBox(this.font, this.leftPos + 27, this.topPos + 40, 120, 20, Component.translatable("gui.desafosahuaria.muerte_1.muertetexto2"));
		muertetexto2.setMaxLength(32767);
		guistate.put("text:muertetexto2", muertetexto2);
		this.addWidget(this.muertetexto2);
		button_enter = Button.builder(Component.translatable("gui.desafosahuaria.muerte_1.button_enter"), e -> {
		}).bounds(this.leftPos + 63, this.topPos + 65, 51, 20).build();
		guistate.put("button:button_enter", button_enter);
		this.addRenderableWidget(button_enter);
	}
}
