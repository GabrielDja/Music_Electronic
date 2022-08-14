
package net.gabrieldja.music.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;

import net.gabrieldja.music.procedures.LogoClearAutomationProcedure;

public class TrapNationLogoItem extends Item {
	public TrapNationLogoItem() {
		super(new Item.Properties().tab(null).stacksTo(64).rarity(Rarity.RARE));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		LogoClearAutomationProcedure.execute(entity);
	}
}
