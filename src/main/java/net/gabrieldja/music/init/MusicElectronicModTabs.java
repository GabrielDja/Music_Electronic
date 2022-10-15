
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.gabrieldja.music.init;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class MusicElectronicModTabs {
	public static CreativeModeTab TAB_ELECTRONIC;
	public static CreativeModeTab TAB_TRAP_NATION;

	public static void load() {
		TAB_ELECTRONIC = new CreativeModeTab("tabelectronic") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(MusicElectronicModItems.NCS_LOGO.get());
			}

			@Override
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundSuffix("item_search.png");
		TAB_TRAP_NATION = new CreativeModeTab("tabtrap_nation") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(MusicElectronicModItems.TRAP_NATION_LOGO.get());
			}

			@Override
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
}
