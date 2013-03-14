package de.playacem.allrondism.block;

import net.minecraft.item.ItemStack;

public interface IStorageBlock {

	public void addStorageRecipe(ItemStack storageBlock, ItemStack component);
}
