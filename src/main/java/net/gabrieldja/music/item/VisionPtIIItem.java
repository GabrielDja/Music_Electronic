
package net.gabrieldja.music.item;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

import net.gabrieldja.music.init.MusicElectronicModTabs;

import java.util.List;

public class VisionPtIIItem extends RecordItem {
	public VisionPtIIItem() {
		super(0, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("music_electronic:vision-pt-ii_she-is-jules_lost-sky")),
				new Item.Properties().tab(MusicElectronicModTabs.TAB_ELECTRONIC).stacksTo(1).rarity(Rarity.RARE), 0);
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("Time - 03:28"));
	}
}
