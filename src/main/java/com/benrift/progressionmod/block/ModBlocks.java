package com.benrift.progressionmod.block;

import com.benrift.progressionmod.ProgressionMod;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(BuiltInRegistries.BLOCK, ProgressionMod.MOD_ID);

    //public static final Supplier<Block> EXAMPLE = BLOCKS.register("example", () -> new Block());

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
