
package net.gabrieldja.music.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.gabrieldja.music.world.inventory.MusicListPage7Menu;
import net.gabrieldja.music.procedures.SwitchMusicListToCreditProcedure;
import net.gabrieldja.music.procedures.SwitchMusicListPage5ToMusicListPage6Procedure;
import net.gabrieldja.music.procedures.SwitchMusicListDernierePageToMusicListPage1Procedure;
import net.gabrieldja.music.procedures.StopMusicProcedure;
import net.gabrieldja.music.procedures.MusicListPlayWhereItAllBeganProcedure;
import net.gabrieldja.music.procedures.MusicListPlayLiveALieProcedure;
import net.gabrieldja.music.procedures.MusicListPlayFireProcedure;
import net.gabrieldja.music.procedures.MusicListPlayBotFightProcedure;
import net.gabrieldja.music.procedures.CloseUIProcedure;
import net.gabrieldja.music.MusicElectronicMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class MusicListPage7ButtonMessage {
	private final int buttonID, x, y, z;

	public MusicListPage7ButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public MusicListPage7ButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(MusicListPage7ButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(MusicListPage7ButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = MusicListPage7Menu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			MusicListPlayBotFightProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			StopMusicProcedure.execute(entity);
		}
		if (buttonID == 2) {

			CloseUIProcedure.execute(entity);
		}
		if (buttonID == 3) {

			MusicListPlayWhereItAllBeganProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			SwitchMusicListToCreditProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			MusicListPlayFireProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 6) {

			MusicListPlayLiveALieProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 7) {

			SwitchMusicListDernierePageToMusicListPage1Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 8) {

			SwitchMusicListPage5ToMusicListPage6Procedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		MusicElectronicMod.addNetworkMessage(MusicListPage7ButtonMessage.class, MusicListPage7ButtonMessage::buffer, MusicListPage7ButtonMessage::new,
				MusicListPage7ButtonMessage::handler);
	}
}
