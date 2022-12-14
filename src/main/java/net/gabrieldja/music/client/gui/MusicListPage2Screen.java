
package net.gabrieldja.music.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.gabrieldja.music.world.inventory.MusicListPage2Menu;
import net.gabrieldja.music.network.MusicListPage2ButtonMessage;
import net.gabrieldja.music.MusicElectronicMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class MusicListPage2Screen extends AbstractContainerScreen<MusicListPage2Menu> {
	private final static HashMap<String, Object> guistate = MusicListPage2Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public MusicListPage2Screen(MusicListPage2Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 200;
		this.imageHeight = 200;
	}

	private static final ResourceLocation texture = new ResourceLocation("music_electronic:textures/screens/music_list_page_2.png");

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
		this.font.draw(poseStack, "NCS List", 9, 6, -39424);
		this.font.draw(poseStack, "-----------------", 9, 15, -16777216);
		this.font.draw(poseStack, "WHAT THE HELL", 63, 51, -16777216);
		this.font.draw(poseStack, "Haunted House", 63, 78, -16777216);
		this.font.draw(poseStack, "Let Me Go", 63, 105, -16777216);
		this.font.draw(poseStack, "Come Up", 63, 132, -16777216);
		this.font.draw(poseStack, "2 / 7", 9, 177, -16777216);
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
		this.addRenderableWidget(new Button(this.leftPos + 9, this.topPos + 42, 46, 20, Component.literal("Play"), e -> {
			if (true) {
				MusicElectronicMod.PACKET_HANDLER.sendToServer(new MusicListPage2ButtonMessage(0, x, y, z));
				MusicListPage2ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 117, this.topPos + 6, 77, 20, Component.literal("Stop Music"), e -> {
			if (true) {
				MusicElectronicMod.PACKET_HANDLER.sendToServer(new MusicListPage2ButtonMessage(1, x, y, z));
				MusicListPage2ButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 207, this.topPos + 6, 30, 20, Component.literal("x"), e -> {
			if (true) {
				MusicElectronicMod.PACKET_HANDLER.sendToServer(new MusicListPage2ButtonMessage(2, x, y, z));
				MusicListPage2ButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 9, this.topPos + 69, 46, 20, Component.literal("Play"), e -> {
			if (true) {
				MusicElectronicMod.PACKET_HANDLER.sendToServer(new MusicListPage2ButtonMessage(3, x, y, z));
				MusicListPage2ButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 99, this.topPos + 168, 56, 20, Component.literal("Credit"), e -> {
			if (true) {
				MusicElectronicMod.PACKET_HANDLER.sendToServer(new MusicListPage2ButtonMessage(4, x, y, z));
				MusicListPage2ButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 9, this.topPos + 96, 46, 20, Component.literal("Play"), e -> {
			if (true) {
				MusicElectronicMod.PACKET_HANDLER.sendToServer(new MusicListPage2ButtonMessage(5, x, y, z));
				MusicListPage2ButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 9, this.topPos + 123, 46, 20, Component.literal("Play"), e -> {
			if (true) {
				MusicElectronicMod.PACKET_HANDLER.sendToServer(new MusicListPage2ButtonMessage(6, x, y, z));
				MusicListPage2ButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 162, this.topPos + 168, 30, 20, Component.literal(">"), e -> {
			if (true) {
				MusicElectronicMod.PACKET_HANDLER.sendToServer(new MusicListPage2ButtonMessage(7, x, y, z));
				MusicListPage2ButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 63, this.topPos + 168, 30, 20, Component.literal("<"), e -> {
			if (true) {
				MusicElectronicMod.PACKET_HANDLER.sendToServer(new MusicListPage2ButtonMessage(8, x, y, z));
				MusicListPage2ButtonMessage.handleButtonAction(entity, 8, x, y, z);
			}
		}));
	}
}
