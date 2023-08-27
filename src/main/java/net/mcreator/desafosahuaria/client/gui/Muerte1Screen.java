package net.mcreator.desafosahuaria.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.client.gui.components.Button;

import net.mcreator.desafosahuaria.world.inventory.Muerte1Menu;
import net.mcreator.desafosahuaria.network.Muerte1ButtonMessage;
import net.mcreator.desafosahuaria.DesafosahuariaMod;

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
	EditBox tormentatiempo;
	EditBox tormentatexto;
	Checkbox efectomuerte;
	Checkbox tormenta;
	Button button_enter;
	Button button_sigpag;
	ImageButton imagebutton_witheredamethyst;
	ImageButton imagebutton_witheredamethyst1;
	ImageButton imagebutton_witheredamethyst2;
	ImageButton imagebutton_witheredamethyst3;

	public Muerte1Screen(Muerte1Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 176;
	}

	private static final ResourceLocation texture = new ResourceLocation("desafosahuaria:textures/screens/muerte_1.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
		muertetexto.render(ms, mouseX, mouseY, partialTicks);
		muertetexto2.render(ms, mouseX, mouseY, partialTicks);
		tormentatiempo.render(ms, mouseX, mouseY, partialTicks);
		tormentatexto.render(ms, mouseX, mouseY, partialTicks);
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
		if (tormentatiempo.isFocused())
			return tormentatiempo.keyPressed(key, b, c);
		if (tormentatexto.isFocused())
			return tormentatexto.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		muertetexto.tick();
		muertetexto2.tick();
		tormentatiempo.tick();
		tormentatexto.tick();
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
		muertetexto = new EditBox(this.font, this.leftPos + 3, this.topPos + 36, 120, 20, Component.translatable("gui.desafosahuaria.muerte_1.muertetexto")) {
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
		muertetexto2 = new EditBox(this.font, this.leftPos + 3, this.topPos + 58, 120, 20, Component.translatable("gui.desafosahuaria.muerte_1.muertetexto2")) {
			{
				setSuggestion(Component.translatable("gui.desafosahuaria.muerte_1.muertetexto2").getString());
			}

			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.desafosahuaria.muerte_1.muertetexto2").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.desafosahuaria.muerte_1.muertetexto2").getString());
				else
					setSuggestion(null);
			}
		};
		muertetexto2.setMaxLength(32767);
		guistate.put("text:muertetexto2", muertetexto2);
		this.addWidget(this.muertetexto2);
		tormentatiempo = new EditBox(this.font, this.leftPos + 4, this.topPos + 105, 120, 20, Component.translatable("gui.desafosahuaria.muerte_1.tormentatiempo")) {
			{
				setSuggestion(Component.translatable("gui.desafosahuaria.muerte_1.tormentatiempo").getString());
			}

			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.desafosahuaria.muerte_1.tormentatiempo").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.desafosahuaria.muerte_1.tormentatiempo").getString());
				else
					setSuggestion(null);
			}
		};
		tormentatiempo.setMaxLength(32767);
		guistate.put("text:tormentatiempo", tormentatiempo);
		this.addWidget(this.tormentatiempo);
		tormentatexto = new EditBox(this.font, this.leftPos + 4, this.topPos + 128, 120, 20, Component.translatable("gui.desafosahuaria.muerte_1.tormentatexto")) {
			{
				setSuggestion(Component.translatable("gui.desafosahuaria.muerte_1.tormentatexto").getString());
			}

			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.desafosahuaria.muerte_1.tormentatexto").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.desafosahuaria.muerte_1.tormentatexto").getString());
				else
					setSuggestion(null);
			}
		};
		tormentatexto.setMaxLength(32767);
		guistate.put("text:tormentatexto", tormentatexto);
		this.addWidget(this.tormentatexto);
		button_enter = Button.builder(Component.translatable("gui.desafosahuaria.muerte_1.button_enter"), e -> {
			if (true) {
				DesafosahuariaMod.PACKET_HANDLER.sendToServer(new Muerte1ButtonMessage(0, x, y, z));
				Muerte1ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 5, this.topPos + 150, 51, 20).build();
		guistate.put("button:button_enter", button_enter);
		this.addRenderableWidget(button_enter);
		button_sigpag = Button.builder(Component.translatable("gui.desafosahuaria.muerte_1.button_sigpag"), e -> {
			if (true) {
				DesafosahuariaMod.PACKET_HANDLER.sendToServer(new Muerte1ButtonMessage(1, x, y, z));
				Muerte1ButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 103, this.topPos + 150, 67, 20).build();
		guistate.put("button:button_sigpag", button_sigpag);
		this.addRenderableWidget(button_sigpag);
		imagebutton_witheredamethyst = new ImageButton(this.leftPos + 130, this.topPos + 38, 16, 16, 0, 0, 16, new ResourceLocation("desafosahuaria:textures/screens/atlas/imagebutton_witheredamethyst.png"), 16, 32, e -> {
			if (true) {
				DesafosahuariaMod.PACKET_HANDLER.sendToServer(new Muerte1ButtonMessage(2, x, y, z));
				Muerte1ButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:imagebutton_witheredamethyst", imagebutton_witheredamethyst);
		this.addRenderableWidget(imagebutton_witheredamethyst);
		imagebutton_witheredamethyst1 = new ImageButton(this.leftPos + 130, this.topPos + 60, 16, 16, 0, 0, 16, new ResourceLocation("desafosahuaria:textures/screens/atlas/imagebutton_witheredamethyst1.png"), 16, 32, e -> {
			if (true) {
				DesafosahuariaMod.PACKET_HANDLER.sendToServer(new Muerte1ButtonMessage(3, x, y, z));
				Muerte1ButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:imagebutton_witheredamethyst1", imagebutton_witheredamethyst1);
		this.addRenderableWidget(imagebutton_witheredamethyst1);
		imagebutton_witheredamethyst2 = new ImageButton(this.leftPos + 130, this.topPos + 107, 16, 16, 0, 0, 16, new ResourceLocation("desafosahuaria:textures/screens/atlas/imagebutton_witheredamethyst2.png"), 16, 32, e -> {
			if (true) {
				DesafosahuariaMod.PACKET_HANDLER.sendToServer(new Muerte1ButtonMessage(4, x, y, z));
				Muerte1ButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		guistate.put("button:imagebutton_witheredamethyst2", imagebutton_witheredamethyst2);
		this.addRenderableWidget(imagebutton_witheredamethyst2);
		imagebutton_witheredamethyst3 = new ImageButton(this.leftPos + 130, this.topPos + 130, 16, 16, 0, 0, 16, new ResourceLocation("desafosahuaria:textures/screens/atlas/imagebutton_witheredamethyst3.png"), 16, 32, e -> {
			if (true) {
				DesafosahuariaMod.PACKET_HANDLER.sendToServer(new Muerte1ButtonMessage(5, x, y, z));
				Muerte1ButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		});
		guistate.put("button:imagebutton_witheredamethyst3", imagebutton_witheredamethyst3);
		this.addRenderableWidget(imagebutton_witheredamethyst3);
		efectomuerte = new Checkbox(this.leftPos + 5, this.topPos + 11, 20, 20, Component.translatable("gui.desafosahuaria.muerte_1.efectomuerte"), false);
		guistate.put("checkbox:efectomuerte", efectomuerte);
		this.addRenderableWidget(efectomuerte);
		tormenta = new Checkbox(this.leftPos + 5, this.topPos + 82, 20, 20, Component.translatable("gui.desafosahuaria.muerte_1.tormenta"), false);
		guistate.put("checkbox:tormenta", tormenta);
		this.addRenderableWidget(tormenta);
	}
}
