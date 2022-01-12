package com.yeyes.yeyespack.item;

import com.yeyes.yeyespack.YeyesPack;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, YeyesPack.MOD_ID);

    public static final RegistryObject<Block> WOODWORKING_TABLE = BLOCKS.register("woodworking_table",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.CARTOGRAPHY_TABLE)));
    
    public static void register(IEventBus eventBus) {
		BLOCKS.register(eventBus);
	}
}
