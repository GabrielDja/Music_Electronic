
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.gabrieldja.music.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import net.gabrieldja.music.item.WhereItAllBeganItem;
import net.gabrieldja.music.item.WhatTheHellItem;
import net.gabrieldja.music.item.VisionPtIIItem;
import net.gabrieldja.music.item.TrapNationLogoItem;
import net.gabrieldja.music.item.ThisTimeItem;
import net.gabrieldja.music.item.TakeMeAwayItem;
import net.gabrieldja.music.item.SlowDownItem;
import net.gabrieldja.music.item.RunningAwayItem;
import net.gabrieldja.music.item.NoRivalItem;
import net.gabrieldja.music.item.NewsToMeItem;
import net.gabrieldja.music.item.NCSLogoItem;
import net.gabrieldja.music.item.LiveALieItem;
import net.gabrieldja.music.item.LetMeGoItem;
import net.gabrieldja.music.item.InvinciblePtIIItem;
import net.gabrieldja.music.item.HorizonItem;
import net.gabrieldja.music.item.HeartlessItem;
import net.gabrieldja.music.item.HealingItem;
import net.gabrieldja.music.item.HauntedHouseItem;
import net.gabrieldja.music.item.FreefallingItem;
import net.gabrieldja.music.item.FireItem;
import net.gabrieldja.music.item.FeelingItem;
import net.gabrieldja.music.item.ComeUpItem;
import net.gabrieldja.music.item.ChasingStarsItem;
import net.gabrieldja.music.item.ChampionsItem;
import net.gabrieldja.music.item.BotFightItem;
import net.gabrieldja.music.item.BandAidItem;
import net.gabrieldja.music.MusicElectronicMod;

public class MusicElectronicModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, MusicElectronicMod.MODID);
	public static final RegistryObject<Item> FEELING = REGISTRY.register("feeling", () -> new FeelingItem());
	public static final RegistryObject<Item> NO_RIVAL = REGISTRY.register("no_rival", () -> new NoRivalItem());
	public static final RegistryObject<Item> CHAMPIONS = REGISTRY.register("champions", () -> new ChampionsItem());
	public static final RegistryObject<Item> RUNNING_AWAY = REGISTRY.register("running_away", () -> new RunningAwayItem());
	public static final RegistryObject<Item> WHAT_THE_HELL = REGISTRY.register("what_the_hell", () -> new WhatTheHellItem());
	public static final RegistryObject<Item> HAUNTED_HOUSE = REGISTRY.register("haunted_house", () -> new HauntedHouseItem());
	public static final RegistryObject<Item> LET_ME_GO = REGISTRY.register("let_me_go", () -> new LetMeGoItem());
	public static final RegistryObject<Item> COME_UP = REGISTRY.register("come_up", () -> new ComeUpItem());
	public static final RegistryObject<Item> SLOW_DOWN = REGISTRY.register("slow_down", () -> new SlowDownItem());
	public static final RegistryObject<Item> NEWS_TO_ME = REGISTRY.register("news_to_me", () -> new NewsToMeItem());
	public static final RegistryObject<Item> VISION_PT_II = REGISTRY.register("vision_pt_ii", () -> new VisionPtIIItem());
	public static final RegistryObject<Item> INVINCIBLE_PT_II = REGISTRY.register("invincible_pt_ii", () -> new InvinciblePtIIItem());
	public static final RegistryObject<Item> HEARTLESS = REGISTRY.register("heartless", () -> new HeartlessItem());
	public static final RegistryObject<Item> THIS_TIME = REGISTRY.register("this_time", () -> new ThisTimeItem());
	public static final RegistryObject<Item> TAKE_ME_AWAY = REGISTRY.register("take_me_away", () -> new TakeMeAwayItem());
	public static final RegistryObject<Item> NCS_BLOCK = block(MusicElectronicModBlocks.NCS_BLOCK, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Item> CHASING_STARS = REGISTRY.register("chasing_stars", () -> new ChasingStarsItem());
	public static final RegistryObject<Item> BAND_AID = REGISTRY.register("band_aid", () -> new BandAidItem());
	public static final RegistryObject<Item> HORIZON = REGISTRY.register("horizon", () -> new HorizonItem());
	public static final RegistryObject<Item> FREEFALLING = REGISTRY.register("freefalling", () -> new FreefallingItem());
	public static final RegistryObject<Item> HEALING = REGISTRY.register("healing", () -> new HealingItem());
	public static final RegistryObject<Item> WHERE_IT_ALL_BEGAN = REGISTRY.register("where_it_all_began", () -> new WhereItAllBeganItem());
	public static final RegistryObject<Item> FIRE = REGISTRY.register("fire", () -> new FireItem());
	public static final RegistryObject<Item> LIVE_A_LIE = REGISTRY.register("live_a_lie", () -> new LiveALieItem());
	public static final RegistryObject<Item> BOT_FIGHT = REGISTRY.register("bot_fight", () -> new BotFightItem());
	public static final RegistryObject<Item> NCS_LOGO = REGISTRY.register("ncs_logo", () -> new NCSLogoItem());
	public static final RegistryObject<Item> TRAP_NATION_LOGO = REGISTRY.register("trap_nation_logo", () -> new TrapNationLogoItem());
	public static final RegistryObject<Item> TRAP_NATION_BLOCK = block(MusicElectronicModBlocks.TRAP_NATION_BLOCK, CreativeModeTab.TAB_DECORATIONS);

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
