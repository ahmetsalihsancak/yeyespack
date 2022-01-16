package com.yeyes.yeyespack.tileentity;

import com.yeyes.yeyespack.item.ModItems;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class DenemeTile extends BlockEntity {
	
	private final ItemStackHandler itemHandler = createHandler();
	private final LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemHandler);
	
	public DenemeTile(BlockEntityType<?> p_155228_, BlockPos p_155229_, BlockState p_155230_) {
		super(p_155228_, p_155229_, p_155230_);
		// TODO Auto-generated constructor stub
	}

	
	private ItemStackHandler createHandler() {
		return new ItemStackHandler(2) {
			
			@Override
			protected void onContentsChanged(int slot) {
				// TODO Auto-generated method stub
				super.onContentsChanged(slot);
			}
			
			@Override
			public boolean isItemValid(int slot, ItemStack stack) {
				// TODO Auto-generated method stub
				
				switch (slot) {
				case 0: return stack.getItem() == Items.GLASS_PANE;
				case 1: return stack.getItem() == ModItems.BRONZE_CURRENCY.get();
				default: return false;
				}
			}
			
			@Override
			public int getSlotLimit(int slot) {
				// TODO Auto-generated method stub
				return 1;
			}
			
			@Override
			public ItemStack insertItem(int slot, ItemStack stack, boolean simulate) {
				// TODO Auto-generated method stub
				
				if (!isItemValid(slot, stack)) {
					return stack;
				}
				
				return super.insertItem(slot, stack, simulate);
			}
		};
	}
	
}
