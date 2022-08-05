
package net.gabrieldja.music.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.gabrieldja.music.world.inventory.CreditPage3Menu;
import net.gabrieldja.music.procedures.SwitchCreditPage3ToCreditPage4Procedure;
import net.gabrieldja.music.procedures.SwitchCreditPage3ToCreditPage2Procedure;
import net.gabrieldja.music.procedures.CloseUIProcedure;
import net.gabrieldja.music.MusicElectronicMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CreditPage3ButtonMessage {
	private final int buttonID, x, y, z;

	public CreditPage3ButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public CreditPage3ButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(CreditPage3ButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(CreditPage3ButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = CreditPage3Menu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			SwitchCreditPage3ToCreditPage4Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			CloseUIProcedure.execute(entity);
		}
		if (buttonID == 2) {

			SwitchCreditPage3ToCreditPage2Procedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		MusicElectronicMod.addNetworkMessage(CreditPage3ButtonMessage.class, CreditPage3ButtonMessage::buffer, CreditPage3ButtonMessage::new,
				CreditPage3ButtonMessage::handler);
	}
}
