
package net.gabrieldja.music.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.gabrieldja.music.world.inventory.MusicListPage4Menu;
import net.gabrieldja.music.procedures.SwitchMusicListToCreditProcedure;
import net.gabrieldja.music.procedures.SwitchMusicListPage4ToMusicListPage5Procedure;
import net.gabrieldja.music.procedures.SwitchMusicListPage4ToMusicListPage3Procedure;
import net.gabrieldja.music.procedures.StopMusicProcedure;
import net.gabrieldja.music.procedures.MusicListPlayThisTimeProcedure;
import net.gabrieldja.music.procedures.MusicListPlayTakeMeAwayProcedure;
import net.gabrieldja.music.procedures.MusicListPlayHeartlessProcedure;
import net.gabrieldja.music.procedures.MusicListPlayChasingStarsProcedure;
import net.gabrieldja.music.procedures.CloseUIProcedure;
import net.gabrieldja.music.MusicElectronicMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class MusicListPage4ButtonMessage {
	private final int buttonID, x, y, z;

	public MusicListPage4ButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public MusicListPage4ButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(MusicListPage4ButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(MusicListPage4ButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = MusicListPage4Menu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			MusicListPlayHeartlessProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			StopMusicProcedure.execute(entity);
		}
		if (buttonID == 2) {

			CloseUIProcedure.execute(entity);
		}
		if (buttonID == 3) {

			MusicListPlayThisTimeProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			SwitchMusicListToCreditProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			MusicListPlayTakeMeAwayProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 6) {

			MusicListPlayChasingStarsProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 7) {

			SwitchMusicListPage4ToMusicListPage5Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 8) {

			SwitchMusicListPage4ToMusicListPage3Procedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		MusicElectronicMod.addNetworkMessage(MusicListPage4ButtonMessage.class, MusicListPage4ButtonMessage::buffer, MusicListPage4ButtonMessage::new,
				MusicListPage4ButtonMessage::handler);
	}
}
