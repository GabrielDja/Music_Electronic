
package net.gabrieldja.music.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.gabrieldja.music.world.inventory.CreditPage4Menu;
import net.gabrieldja.music.network.CreditPage4ButtonMessage;
import net.gabrieldja.music.MusicElectronicMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class CreditPage4Screen extends AbstractContainerScreen<CreditPage4Menu> {
	private final static HashMap<String, Object> guistate = CreditPage4Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public CreditPage4Screen(CreditPage4Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 300;
		this.imageHeight = 170;
	}

	private static final ResourceLocation texture = new ResourceLocation("music_electronic:textures/credit_page_4.png");

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
		this.font.draw(poseStack, "Mod Created by GabrielDja", 77, 9, -16776961);
		this.font.draw(poseStack, "Freefalling : Facading", 14, 36, -16777216);
		this.font.draw(poseStack, "4 / 4", 140, 153, -16777216);
		this.font.draw(poseStack, "----------------------------------", 50, 18, -16777216);
		this.font.draw(poseStack, "Healing : Moe Aly, Clarx", 14, 54, -16777216);
		this.font.draw(poseStack, "Where It All Began : Danyka Nadeau, Electro-Light", 14, 72, -16777216);
		this.font.draw(poseStack, "Live A Lie : Andreas Stone, Egzod, Rival", 14, 90, -16777216);
		this.font.draw(poseStack, "https://ncs.io/music", 5, 153, -16777114);
		this.font.draw(poseStack, "...", 14, 108, -16777216);
		this.font.draw(poseStack, "...", 14, 126, -16777216);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		this.addRenderableWidget(new Button(this.leftPos + 257, this.topPos + 144, 30, 20, new TextComponent(">"), e -> {
			if (true) {
				MusicElectronicMod.PACKET_HANDLER.sendToServer(new CreditPage4ButtonMessage(0, x, y, z));
				CreditPage4ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 257, this.topPos + 9, 30, 20, new TextComponent("x"), e -> {
			if (true) {
				MusicElectronicMod.PACKET_HANDLER.sendToServer(new CreditPage4ButtonMessage(1, x, y, z));
				CreditPage4ButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 221, this.topPos + 144, 30, 20, new TextComponent("<"), e -> {
			if (true) {
				MusicElectronicMod.PACKET_HANDLER.sendToServer(new CreditPage4ButtonMessage(2, x, y, z));
				CreditPage4ButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}));
	}
}
