package com.benrift.progressionmod.item;

import com.benrift.progressionmod.ProgressionMod;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(BuiltInRegistries.ITEM, ProgressionMod.MOD_ID);

    //public static final Supplier<Item> EXAMPLE = ITEMS.register("example", () -> new Item());

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
