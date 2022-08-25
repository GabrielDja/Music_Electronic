
package net.gabrieldja.music.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;

import net.gabrieldja.music.init.MusicElectronicModTabs;
import net.gabrieldja.music.init.MusicElectronicModSounds;

import java.util.List;

public class AwakeningItem extends RecordItem {
	public AwakeningItem() {
		super(0, MusicElectronicModSounds.REGISTRY.get(new ResourceLocation("music_electronic:awakening_kaivon")),
				new Item.Properties().tab(MusicElectronicModTabs.TAB_TRAP_NATION).stacksTo(1).rarity(Rarity.RARE));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(new TextComponent("Time - 04:10"));
	}
}
