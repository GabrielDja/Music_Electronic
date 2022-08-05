
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.gabrieldja.music.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.gabrieldja.music.block.NCSBlockBlock;
import net.gabrieldja.music.MusicElectronicMod;

public class MusicElectronicModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, MusicElectronicMod.MODID);
	public static final RegistryObject<Block> NCS_BLOCK = REGISTRY.register("ncs_block", () -> new NCSBlockBlock());
}
