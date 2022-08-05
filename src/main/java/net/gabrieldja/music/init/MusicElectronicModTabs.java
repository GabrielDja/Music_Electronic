
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.gabrieldja.music.init;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class MusicElectronicModTabs {
	public static CreativeModeTab TAB_ELECTRONIC;

	public static void load() {
		TAB_ELECTRONIC = new CreativeModeTab("tabelectronic") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(Items.MUSIC_DISC_WARD);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundSuffix("item_search.png");
	}
}
