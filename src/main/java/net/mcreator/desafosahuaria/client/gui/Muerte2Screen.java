package net.mcreator.desafosahuaria.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.client.gui.components.Button;

import net.mcreator.desafosahuaria.world.inventory.Muerte2Menu;
import net.mcreator.desafosahuaria.network.Muerte2ButtonMessage;
import net.mcreator.desafosahuaria.DesafosahuariaMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class Muerte2Screen extends AbstractContainerScreen<Muerte2Menu> {
	private final static HashMap<String, Object> guistate = Muerte2Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Checkbox piglinsspawn;
	Checkbox ghastspawn;
	Checkbox endercreeperspawn;
	Button button_pagant;
	ImageButton imagebutton_witheredamethyst;
	ImageButton imagebutton_witheredamethyst1;
	ImageButton imagebutton_witheredamethyst2;

	public Muerte2Screen(Muerte2Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 176;
	}

	private static final ResourceLocation texture = new ResourceLocation("desafosahuaria:textures/screens/muerte_2.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
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
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
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
		button_pagant = Button.builder(Component.translatable("gui.desafosahuaria.muerte_2.button_pagant"), e -> {
		}).bounds(this.leftPos + 4, this.topPos + 150, 67, 20).build();
		guistate.put("button:button_pagant", button_pagant);
		this.addRenderableWidget(button_pagant);
		imagebutton_witheredamethyst = new ImageButton(this.leftPos + 150, this.topPos + 10, 16, 16, 0, 0, 16, new ResourceLocation("desafosahuaria:textures/screens/atlas/imagebutton_witheredamethyst.png"), 16, 32, e -> {
			if (true) {
				DesafosahuariaMod.PACKET_HANDLER.sendToServer(new Muerte2ButtonMessage(1, x, y, z));
				Muerte2ButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_witheredamethyst", imagebutton_witheredamethyst);
		this.addRenderableWidget(imagebutton_witheredamethyst);
		imagebutton_witheredamethyst1 = new ImageButton(this.leftPos + 150, this.topPos + 32, 16, 16, 0, 0, 16, new ResourceLocation("desafosahuaria:textures/screens/atlas/imagebutton_witheredamethyst1.png"), 16, 32, e -> {
		});
		guistate.put("button:imagebutton_witheredamethyst1", imagebutton_witheredamethyst1);
		this.addRenderableWidget(imagebutton_witheredamethyst1);
		imagebutton_witheredamethyst2 = new ImageButton(this.leftPos + 150, this.topPos + 55, 16, 16, 0, 0, 16, new ResourceLocation("desafosahuaria:textures/screens/atlas/imagebutton_witheredamethyst2.png"), 16, 32, e -> {
		});
		guistate.put("button:imagebutton_witheredamethyst2", imagebutton_witheredamethyst2);
		this.addRenderableWidget(imagebutton_witheredamethyst2);
		piglinsspawn = new Checkbox(this.leftPos + 7, this.topPos + 7, 20, 20, Component.translatable("gui.desafosahuaria.muerte_2.piglinsspawn"), false);
		guistate.put("checkbox:piglinsspawn", piglinsspawn);
		this.addRenderableWidget(piglinsspawn);
		ghastspawn = new Checkbox(this.leftPos + 7, this.topPos + 29, 20, 20, Component.translatable("gui.desafosahuaria.muerte_2.ghastspawn"), false);
		guistate.put("checkbox:ghastspawn", ghastspawn);
		this.addRenderableWidget(ghastspawn);
		endercreeperspawn = new Checkbox(this.leftPos + 7, this.topPos + 52, 20, 20, Component.translatable("gui.desafosahuaria.muerte_2.endercreeperspawn"), false);
		guistate.put("checkbox:endercreeperspawn", endercreeperspawn);
		this.addRenderableWidget(endercreeperspawn);
	}
}
