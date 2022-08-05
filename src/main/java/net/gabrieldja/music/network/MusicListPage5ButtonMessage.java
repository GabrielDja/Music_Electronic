
package net.gabrieldja.music.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.gabrieldja.music.world.inventory.MusicListPage5Menu;
import net.gabrieldja.music.procedures.SwitchMusicListToCreditProcedure;
import net.gabrieldja.music.procedures.SwitchMusicListPage5ToMusicListPage6Procedure;
import net.gabrieldja.music.procedures.SwitchMusicListPage5TMusicListPage4Procedure;
import net.gabrieldja.music.procedures.StopMusicProcedure;
import net.gabrieldja.music.procedures.MusicListPlayHorizonProcedure;
import net.gabrieldja.music.procedures.MusicListPlayHealingProcedure;
import net.gabrieldja.music.procedures.MusicListPlayFreefallingProcedure;
import net.gabrieldja.music.procedures.MusicListPlayBandAidProcedure;
import net.gabrieldja.music.procedures.CloseUIProcedure;
import net.gabrieldja.music.MusicElectronicMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class MusicListPage5ButtonMessage {
	private final int buttonID, x, y, z;

	public MusicListPage5ButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public MusicListPage5ButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(MusicListPage5ButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(MusicListPage5ButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = MusicListPage5Menu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			MusicListPlayBandAidProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			StopMusicProcedure.execute(entity);
		}
		if (buttonID == 2) {

			CloseUIProcedure.execute(entity);
		}
		if (buttonID == 3) {

			MusicListPlayHorizonProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			SwitchMusicListToCreditProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			MusicListPlayFreefallingProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 6) {

			MusicListPlayHealingProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 7) {

			SwitchMusicListPage5ToMusicListPage6Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 8) {

			SwitchMusicListPage5TMusicListPage4Procedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		MusicElectronicMod.addNetworkMessage(MusicListPage5ButtonMessage.class, MusicListPage5ButtonMessage::buffer, MusicListPage5ButtonMessage::new,
				MusicListPage5ButtonMessage::handler);
	}
}
