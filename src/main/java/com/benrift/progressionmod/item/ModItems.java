package com.benrift.progressionmod.item;

import com.benrift.progressionmod.ProgressionMod;
import com.benrift.progressionmod.item.CustomItems.FruitOfConsequences;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ProgressionMod.MOD_ID);

    public static final Supplier<Item> FRUIT_OF_CONSEQUENCE = ITEMS.register("fruit_of_consequence", () -> new FruitOfConsequences(new Item.Properties().stacksTo(4).
            rarity(Rarity.EPIC).food((new FoodProperties.Builder()).nutrition(20).saturationModifier(0.3f).alwaysEdible().build())));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
