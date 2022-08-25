
package net.gabrieldja.music.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.gabrieldja.music.world.inventory.TrapNationMusicList2Menu;
import net.gabrieldja.music.procedures.TrapNationListPlayStreamProcedure;
import net.gabrieldja.music.procedures.TrapNationListPlayNowInfinityProcedure;
import net.gabrieldja.music.procedures.TrapNationListPlayAwakeningProcedure;
import net.gabrieldja.music.procedures.TrapNationListPLayBothEdgesProcedure;
import net.gabrieldja.music.procedures.SwitchTrapNationMusicListPage2ToTrapNationMusicListPage3Procedure;
import net.gabrieldja.music.procedures.SwitchTrapNationMusicList2ToTrapNationMusicListProcedure;
import net.gabrieldja.music.procedures.SwitchTrapNationListToTrapNationCreditProcedure;
import net.gabrieldja.music.procedures.StopMusicProcedure;
import net.gabrieldja.music.procedures.CloseUIProcedure;
import net.gabrieldja.music.MusicElectronicMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TrapNationMusicList2ButtonMessage {
	private final int buttonID, x, y, z;

	public TrapNationMusicList2ButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public TrapNationMusicList2ButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(TrapNationMusicList2ButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(TrapNationMusicList2ButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = TrapNationMusicList2Menu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			TrapNationListPlayAwakeningProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			StopMusicProcedure.execute(entity);
		}
		if (buttonID == 2) {

			CloseUIProcedure.execute(entity);
		}
		if (buttonID == 3) {

			TrapNationListPLayBothEdgesProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			SwitchTrapNationListToTrapNationCreditProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			TrapNationListPlayNowInfinityProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 6) {

			TrapNationListPlayStreamProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 7) {

			SwitchTrapNationMusicListPage2ToTrapNationMusicListPage3Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 8) {

			SwitchTrapNationMusicList2ToTrapNationMusicListProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		MusicElectronicMod.addNetworkMessage(TrapNationMusicList2ButtonMessage.class, TrapNationMusicList2ButtonMessage::buffer,
				TrapNationMusicList2ButtonMessage::new, TrapNationMusicList2ButtonMessage::handler);
	}
}
