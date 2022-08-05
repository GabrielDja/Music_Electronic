
package net.gabrieldja.music.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.gabrieldja.music.world.inventory.MusicListMenu;
import net.gabrieldja.music.procedures.SwitchMusicListToMusicListPage2Procedure;
import net.gabrieldja.music.procedures.SwitchMusicListToCreditProcedure;
import net.gabrieldja.music.procedures.SwitchMusicListPremierePageToMusicListDernierePageProcedure;
import net.gabrieldja.music.procedures.StopMusicProcedure;
import net.gabrieldja.music.procedures.MusicListPlayRunningAwayProcedure;
import net.gabrieldja.music.procedures.MusicListPlayNoRivalProcedure;
import net.gabrieldja.music.procedures.MusicListPlayFeelingProcedure;
import net.gabrieldja.music.procedures.MusicListPlayChampionsProcedure;
import net.gabrieldja.music.procedures.CloseUIProcedure;
import net.gabrieldja.music.MusicElectronicMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class MusicListButtonMessage {
	private final int buttonID, x, y, z;

	public MusicListButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public MusicListButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(MusicListButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(MusicListButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level;
		HashMap guistate = MusicListMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			MusicListPlayFeelingProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			StopMusicProcedure.execute(entity);
		}
		if (buttonID == 2) {

			CloseUIProcedure.execute(entity);
		}
		if (buttonID == 3) {

			MusicListPlayNoRivalProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			SwitchMusicListToCreditProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			MusicListPlayChampionsProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 6) {

			MusicListPlayRunningAwayProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 7) {

			SwitchMusicListToMusicListPage2Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 8) {

			SwitchMusicListPremierePageToMusicListDernierePageProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		MusicElectronicMod.addNetworkMessage(MusicListButtonMessage.class, MusicListButtonMessage::buffer, MusicListButtonMessage::new,
				MusicListButtonMessage::handler);
	}
}
