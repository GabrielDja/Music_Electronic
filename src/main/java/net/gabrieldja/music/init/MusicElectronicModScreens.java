
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.gabrieldja.music.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.gabrieldja.music.client.gui.MusicListScreen;
import net.gabrieldja.music.client.gui.MusicListPage6Screen;
import net.gabrieldja.music.client.gui.MusicListPage5Screen;
import net.gabrieldja.music.client.gui.MusicListPage4Screen;
import net.gabrieldja.music.client.gui.MusicListPage3Screen;
import net.gabrieldja.music.client.gui.MusicListPage2Screen;
import net.gabrieldja.music.client.gui.CreditScreen;
import net.gabrieldja.music.client.gui.CreditPage4Screen;
import net.gabrieldja.music.client.gui.CreditPage3Screen;
import net.gabrieldja.music.client.gui.CreditPage2Screen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class MusicElectronicModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(MusicElectronicModMenus.CREDIT, CreditScreen::new);
			MenuScreens.register(MusicElectronicModMenus.MUSIC_LIST, MusicListScreen::new);
			MenuScreens.register(MusicElectronicModMenus.MUSIC_LIST_PAGE_2, MusicListPage2Screen::new);
			MenuScreens.register(MusicElectronicModMenus.CREDIT_PAGE_2, CreditPage2Screen::new);
			MenuScreens.register(MusicElectronicModMenus.MUSIC_LIST_PAGE_3, MusicListPage3Screen::new);
			MenuScreens.register(MusicElectronicModMenus.CREDIT_PAGE_3, CreditPage3Screen::new);
			MenuScreens.register(MusicElectronicModMenus.MUSIC_LIST_PAGE_4, MusicListPage4Screen::new);
			MenuScreens.register(MusicElectronicModMenus.MUSIC_LIST_PAGE_5, MusicListPage5Screen::new);
			MenuScreens.register(MusicElectronicModMenus.CREDIT_PAGE_4, CreditPage4Screen::new);
			MenuScreens.register(MusicElectronicModMenus.MUSIC_LIST_PAGE_6, MusicListPage6Screen::new);
		});
	}
}
