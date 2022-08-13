
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.gabrieldja.music.init;

import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.AbstractContainerMenu;

import net.gabrieldja.music.world.inventory.TrapNationMusicListMenu;
import net.gabrieldja.music.world.inventory.MusicListPage7Menu;
import net.gabrieldja.music.world.inventory.MusicListPage6Menu;
import net.gabrieldja.music.world.inventory.MusicListPage5Menu;
import net.gabrieldja.music.world.inventory.MusicListPage4Menu;
import net.gabrieldja.music.world.inventory.MusicListPage3Menu;
import net.gabrieldja.music.world.inventory.MusicListPage2Menu;
import net.gabrieldja.music.world.inventory.MusicListMenu;
import net.gabrieldja.music.world.inventory.CreditPage4Menu;
import net.gabrieldja.music.world.inventory.CreditPage3Menu;
import net.gabrieldja.music.world.inventory.CreditPage2Menu;
import net.gabrieldja.music.world.inventory.CreditMenu;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class MusicElectronicModMenus {
	private static final List<MenuType<?>> REGISTRY = new ArrayList<>();
	public static final MenuType<CreditMenu> CREDIT = register("credit", (id, inv, extraData) -> new CreditMenu(id, inv, extraData));
	public static final MenuType<MusicListMenu> MUSIC_LIST = register("music_list", (id, inv, extraData) -> new MusicListMenu(id, inv, extraData));
	public static final MenuType<MusicListPage2Menu> MUSIC_LIST_PAGE_2 = register("music_list_page_2",
			(id, inv, extraData) -> new MusicListPage2Menu(id, inv, extraData));
	public static final MenuType<CreditPage2Menu> CREDIT_PAGE_2 = register("credit_page_2",
			(id, inv, extraData) -> new CreditPage2Menu(id, inv, extraData));
	public static final MenuType<MusicListPage3Menu> MUSIC_LIST_PAGE_3 = register("music_list_page_3",
			(id, inv, extraData) -> new MusicListPage3Menu(id, inv, extraData));
	public static final MenuType<CreditPage3Menu> CREDIT_PAGE_3 = register("credit_page_3",
			(id, inv, extraData) -> new CreditPage3Menu(id, inv, extraData));
	public static final MenuType<MusicListPage4Menu> MUSIC_LIST_PAGE_4 = register("music_list_page_4",
			(id, inv, extraData) -> new MusicListPage4Menu(id, inv, extraData));
	public static final MenuType<MusicListPage5Menu> MUSIC_LIST_PAGE_5 = register("music_list_page_5",
			(id, inv, extraData) -> new MusicListPage5Menu(id, inv, extraData));
	public static final MenuType<CreditPage4Menu> CREDIT_PAGE_4 = register("credit_page_4",
			(id, inv, extraData) -> new CreditPage4Menu(id, inv, extraData));
	public static final MenuType<MusicListPage6Menu> MUSIC_LIST_PAGE_6 = register("music_list_page_6",
			(id, inv, extraData) -> new MusicListPage6Menu(id, inv, extraData));
	public static final MenuType<MusicListPage7Menu> MUSIC_LIST_PAGE_7 = register("music_list_page_7",
			(id, inv, extraData) -> new MusicListPage7Menu(id, inv, extraData));
	public static final MenuType<TrapNationMusicListMenu> TRAP_NATION_MUSIC_LIST = register("trap_nation_music_list",
			(id, inv, extraData) -> new TrapNationMusicListMenu(id, inv, extraData));

	private static <T extends AbstractContainerMenu> MenuType<T> register(String registryname, IContainerFactory<T> containerFactory) {
		MenuType<T> menuType = new MenuType<T>(containerFactory);
		menuType.setRegistryName(registryname);
		REGISTRY.add(menuType);
		return menuType;
	}

	@SubscribeEvent
	public static void registerContainers(RegistryEvent.Register<MenuType<?>> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new MenuType[0]));
	}
}
