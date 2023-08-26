package net.mcreator.desafosahuaria.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;

import net.mcreator.desafosahuaria.world.inventory.ReliquiaGUIMenu;
import net.mcreator.desafosahuaria.network.ReliquiaGUIButtonMessage;
import net.mcreator.desafosahuaria.DesafosahuariaMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class ReliquiaGUIScreen extends AbstractContainerScreen<ReliquiaGUIMenu> {
	private final static HashMap<String, Object> guistate = ReliquiaGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox nombrerevivir;
	Button button_aceptar;

	public ReliquiaGUIScreen(ReliquiaGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 130;
		this.imageHeight = 50;
	}

	@Override
	public boolean isPauseScreen() {
		return true;
	}

	private static final ResourceLocation texture = new ResourceLocation("desafosahuaria:textures/screens/reliquia_gui.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
		nombrerevivir.render(ms, mouseX, mouseY, partialTicks);
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
		if (nombrerevivir.isFocused())
			return nombrerevivir.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		nombrerevivir.tick();
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
		nombrerevivir = new EditBox(this.font, this.leftPos + 4, this.topPos + 5, 120, 20, Component.translatable("gui.desafosahuaria.reliquia_gui.nombrerevivir"));
		nombrerevivir.setMaxLength(32767);
		guistate.put("text:nombrerevivir", nombrerevivir);
		this.addWidget(this.nombrerevivir);
		button_aceptar = Button.builder(Component.translatable("gui.desafosahuaria.reliquia_gui.button_aceptar"), e -> {
			if (true) {
				DesafosahuariaMod.PACKET_HANDLER.sendToServer(new ReliquiaGUIButtonMessage(0, x, y, z));
				ReliquiaGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 34, this.topPos + 26, 61, 20).build();
		guistate.put("button:button_aceptar", button_aceptar);
		this.addRenderableWidget(button_aceptar);
	}
}
