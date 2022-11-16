
package net.gabrieldja.music.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.gabrieldja.music.world.inventory.TrapNationMusicListPage4Menu;
import net.gabrieldja.music.procedures.TrapNationListPlayVoicesProcedure;
import net.gabrieldja.music.procedures.TrapNationListPlayMidnightSadnessProcedure;
import net.gabrieldja.music.procedures.TrapNationListPlayMiddleOfTheNightProcedure;
import net.gabrieldja.music.procedures.TrapNationListPlayArpProcedure;
import net.gabrieldja.music.procedures.SwitchTrapNationMusicListPage5Procedure;
import net.gabrieldja.music.procedures.SwitchTrapNationMusicListPage4ToTrapNationMusicListPage3Procedure;
import net.gabrieldja.music.procedures.SwitchTrapNationListToTrapNationCreditProcedure;
import net.gabrieldja.music.procedures.StopMusicProcedure;
import net.gabrieldja.music.procedures.CloseUIProcedure;
import net.gabrieldja.music.MusicElectronicMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TrapNationMusicListPage4ButtonMessage {
	private final int buttonID, x, y, z;

	public TrapNationMusicListPage4ButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public TrapNationMusicListPage4ButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(TrapNationMusicListPage4ButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(TrapNationMusicListPage4ButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = TrapNationMusicListPage4Menu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			TrapNationListPlayArpProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			StopMusicProcedure.execute(entity);
		}
		if (buttonID == 2) {

			CloseUIProcedure.execute(entity);
		}
		if (buttonID == 3) {

			TrapNationListPlayMiddleOfTheNightProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			SwitchTrapNationListToTrapNationCreditProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			TrapNationListPlayVoicesProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 6) {

			TrapNationListPlayMidnightSadnessProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 7) {

			SwitchTrapNationMusicListPage5Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 8) {

			SwitchTrapNationMusicListPage4ToTrapNationMusicListPage3Procedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		MusicElectronicMod.addNetworkMessage(TrapNationMusicListPage4ButtonMessage.class, TrapNationMusicListPage4ButtonMessage::buffer,
				TrapNationMusicListPage4ButtonMessage::new, TrapNationMusicListPage4ButtonMessage::handler);
	}
}
