
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.gabrieldja.music.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.gabrieldja.music.world.inventory.TrapNationMusicListPage4Menu;
import net.gabrieldja.music.world.inventory.TrapNationMusicListPage3Menu;
import net.gabrieldja.music.world.inventory.TrapNationMusicListMenu;
import net.gabrieldja.music.world.inventory.TrapNationMusicList2Menu;
import net.gabrieldja.music.world.inventory.TrapNationCreditPage3Menu;
import net.gabrieldja.music.world.inventory.TrapNationCreditPage2Menu;
import net.gabrieldja.music.world.inventory.TrapNationCreditMenu;
import net.gabrieldja.music.world.inventory.MusicListPage7Menu;
import net.gabrieldja.music.world.inventory.MusicListPage6Menu;
import net.gabrieldja.music.world.inventory.MusicListPage5Menu;
import net.gabrieldja.music.world.inventory.MusicListPage4Menu;
import net.gabrieldja.music.world.inventory.MusicListPage3Menu;
import net.gabrieldja.music.world.inventory.MusicListPage2Menu;
import net.gabrieldja.music.world.inventory.MusicListMenu;
import net.gabrieldja.music.world.inventory.CreditPage5Menu;
import net.gabrieldja.music.world.inventory.CreditPage4Menu;
import net.gabrieldja.music.world.inventory.CreditPage3Menu;
import net.gabrieldja.music.world.inventory.CreditPage2Menu;
import net.gabrieldja.music.world.inventory.CreditMenu;
import net.gabrieldja.music.MusicElectronicMod;

public class MusicElectronicModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, MusicElectronicMod.MODID);
	public static final RegistryObject<MenuType<CreditMenu>> CREDIT = REGISTRY.register("credit", () -> IForgeMenuType.create(CreditMenu::new));
	public static final RegistryObject<MenuType<MusicListMenu>> MUSIC_LIST = REGISTRY.register("music_list",
			() -> IForgeMenuType.create(MusicListMenu::new));
	public static final RegistryObject<MenuType<MusicListPage2Menu>> MUSIC_LIST_PAGE_2 = REGISTRY.register("music_list_page_2",
			() -> IForgeMenuType.create(MusicListPage2Menu::new));
	public static final RegistryObject<MenuType<CreditPage2Menu>> CREDIT_PAGE_2 = REGISTRY.register("credit_page_2",
			() -> IForgeMenuType.create(CreditPage2Menu::new));
	public static final RegistryObject<MenuType<MusicListPage3Menu>> MUSIC_LIST_PAGE_3 = REGISTRY.register("music_list_page_3",
			() -> IForgeMenuType.create(MusicListPage3Menu::new));
	public static final RegistryObject<MenuType<CreditPage3Menu>> CREDIT_PAGE_3 = REGISTRY.register("credit_page_3",
			() -> IForgeMenuType.create(CreditPage3Menu::new));
	public static final RegistryObject<MenuType<MusicListPage4Menu>> MUSIC_LIST_PAGE_4 = REGISTRY.register("music_list_page_4",
			() -> IForgeMenuType.create(MusicListPage4Menu::new));
	public static final RegistryObject<MenuType<MusicListPage5Menu>> MUSIC_LIST_PAGE_5 = REGISTRY.register("music_list_page_5",
			() -> IForgeMenuType.create(MusicListPage5Menu::new));
	public static final RegistryObject<MenuType<CreditPage4Menu>> CREDIT_PAGE_4 = REGISTRY.register("credit_page_4",
			() -> IForgeMenuType.create(CreditPage4Menu::new));
	public static final RegistryObject<MenuType<MusicListPage6Menu>> MUSIC_LIST_PAGE_6 = REGISTRY.register("music_list_page_6",
			() -> IForgeMenuType.create(MusicListPage6Menu::new));
	public static final RegistryObject<MenuType<MusicListPage7Menu>> MUSIC_LIST_PAGE_7 = REGISTRY.register("music_list_page_7",
			() -> IForgeMenuType.create(MusicListPage7Menu::new));
	public static final RegistryObject<MenuType<TrapNationMusicListMenu>> TRAP_NATION_MUSIC_LIST = REGISTRY.register("trap_nation_music_list",
			() -> IForgeMenuType.create(TrapNationMusicListMenu::new));
	public static final RegistryObject<MenuType<TrapNationCreditMenu>> TRAP_NATION_CREDIT = REGISTRY.register("trap_nation_credit",
			() -> IForgeMenuType.create(TrapNationCreditMenu::new));
	public static final RegistryObject<MenuType<CreditPage5Menu>> CREDIT_PAGE_5 = REGISTRY.register("credit_page_5",
			() -> IForgeMenuType.create(CreditPage5Menu::new));
	public static final RegistryObject<MenuType<TrapNationMusicList2Menu>> TRAP_NATION_MUSIC_LIST_2 = REGISTRY.register("trap_nation_music_list_2",
			() -> IForgeMenuType.create(TrapNationMusicList2Menu::new));
	public static final RegistryObject<MenuType<TrapNationCreditPage2Menu>> TRAP_NATION_CREDIT_PAGE_2 = REGISTRY.register("trap_nation_credit_page_2",
			() -> IForgeMenuType.create(TrapNationCreditPage2Menu::new));
	public static final RegistryObject<MenuType<TrapNationMusicListPage3Menu>> TRAP_NATION_MUSIC_LIST_PAGE_3 = REGISTRY
			.register("trap_nation_music_list_page_3", () -> IForgeMenuType.create(TrapNationMusicListPage3Menu::new));
	public static final RegistryObject<MenuType<TrapNationMusicListPage4Menu>> TRAP_NATION_MUSIC_LIST_PAGE_4 = REGISTRY
			.register("trap_nation_music_list_page_4", () -> IForgeMenuType.create(TrapNationMusicListPage4Menu::new));
	public static final RegistryObject<MenuType<TrapNationCreditPage3Menu>> TRAP_NATION_CREDIT_PAGE_3 = REGISTRY.register("trap_nation_credit_page_3",
			() -> IForgeMenuType.create(TrapNationCreditPage3Menu::new));
}
