
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.gabrieldja.music.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.gabrieldja.music.client.gui.TrapNationMusicListScreen;
import net.gabrieldja.music.client.gui.TrapNationMusicListPage4Screen;
import net.gabrieldja.music.client.gui.TrapNationMusicListPage3Screen;
import net.gabrieldja.music.client.gui.TrapNationMusicList2Screen;
import net.gabrieldja.music.client.gui.TrapNationCreditScreen;
import net.gabrieldja.music.client.gui.TrapNationCreditPage3Screen;
import net.gabrieldja.music.client.gui.TrapNationCreditPage2Screen;
import net.gabrieldja.music.client.gui.MusicListScreen;
import net.gabrieldja.music.client.gui.MusicListPage7Screen;
import net.gabrieldja.music.client.gui.MusicListPage6Screen;
import net.gabrieldja.music.client.gui.MusicListPage5Screen;
import net.gabrieldja.music.client.gui.MusicListPage4Screen;
import net.gabrieldja.music.client.gui.MusicListPage3Screen;
import net.gabrieldja.music.client.gui.MusicListPage2Screen;
import net.gabrieldja.music.client.gui.CreditScreen;
import net.gabrieldja.music.client.gui.CreditPage5Screen;
import net.gabrieldja.music.client.gui.CreditPage4Screen;
import net.gabrieldja.music.client.gui.CreditPage3Screen;
import net.gabrieldja.music.client.gui.CreditPage2Screen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class MusicElectronicModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(MusicElectronicModMenus.CREDIT.get(), CreditScreen::new);
			MenuScreens.register(MusicElectronicModMenus.MUSIC_LIST.get(), MusicListScreen::new);
			MenuScreens.register(MusicElectronicModMenus.MUSIC_LIST_PAGE_2.get(), MusicListPage2Screen::new);
			MenuScreens.register(MusicElectronicModMenus.CREDIT_PAGE_2.get(), CreditPage2Screen::new);
			MenuScreens.register(MusicElectronicModMenus.MUSIC_LIST_PAGE_3.get(), MusicListPage3Screen::new);
			MenuScreens.register(MusicElectronicModMenus.CREDIT_PAGE_3.get(), CreditPage3Screen::new);
			MenuScreens.register(MusicElectronicModMenus.MUSIC_LIST_PAGE_4.get(), MusicListPage4Screen::new);
			MenuScreens.register(MusicElectronicModMenus.MUSIC_LIST_PAGE_5.get(), MusicListPage5Screen::new);
			MenuScreens.register(MusicElectronicModMenus.CREDIT_PAGE_4.get(), CreditPage4Screen::new);
			MenuScreens.register(MusicElectronicModMenus.MUSIC_LIST_PAGE_6.get(), MusicListPage6Screen::new);
			MenuScreens.register(MusicElectronicModMenus.MUSIC_LIST_PAGE_7.get(), MusicListPage7Screen::new);
			MenuScreens.register(MusicElectronicModMenus.TRAP_NATION_MUSIC_LIST.get(), TrapNationMusicListScreen::new);
			MenuScreens.register(MusicElectronicModMenus.TRAP_NATION_CREDIT.get(), TrapNationCreditScreen::new);
			MenuScreens.register(MusicElectronicModMenus.CREDIT_PAGE_5.get(), CreditPage5Screen::new);
			MenuScreens.register(MusicElectronicModMenus.TRAP_NATION_MUSIC_LIST_2.get(), TrapNationMusicList2Screen::new);
			MenuScreens.register(MusicElectronicModMenus.TRAP_NATION_CREDIT_PAGE_2.get(), TrapNationCreditPage2Screen::new);
			MenuScreens.register(MusicElectronicModMenus.TRAP_NATION_MUSIC_LIST_PAGE_3.get(), TrapNationMusicListPage3Screen::new);
			MenuScreens.register(MusicElectronicModMenus.TRAP_NATION_MUSIC_LIST_PAGE_4.get(), TrapNationMusicListPage4Screen::new);
			MenuScreens.register(MusicElectronicModMenus.TRAP_NATION_CREDIT_PAGE_3.get(), TrapNationCreditPage3Screen::new);
		});
	}
}
