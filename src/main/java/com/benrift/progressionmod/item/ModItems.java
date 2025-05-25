package com.benrift.progressionmod.item;

import com.benrift.progressionmod.ProgressionMod;
import com.benrift.progressionmod.item.CustomItems.FruitOfConsequences;
import com.benrift.progressionmod.item.CustomItems.TortureDevice;
import com.benrift.progressionmod.item.CustomItems.DepthsPortalIgniter;  // <-- Add this import
import com.benrift.progressionmod.item.CustomItems.YunshulWish;
import com.benrift.progressionmod.item.CustomItems.SoulDust;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ProgressionMod.MOD_ID);

    public static final Supplier<Item> FRUIT_OF_CONSEQUENCE = ITEMS.register("fruit_of_consequence",
            () -> new FruitOfConsequences(new Item.Properties()
                    .stacksTo(4)
                    .rarity(Rarity.EPIC)
                    .food(new FoodProperties.Builder().nutrition(40).saturationModifier(0.3f).alwaysEdible().build())));

    public static final Supplier<Item> TORTURE_DEVICE = ITEMS.register("torture_device",
            () -> new TortureDevice(new Item.Properties()
                    .stacksTo(1)
                    .rarity(Rarity.EPIC)));

    public static final Supplier<Item> DEPTHS_PORTAL_IGNITER = ITEMS.register("depths_portal_igniter",  // fixed here
            () -> new DepthsPortalIgniter(new Item.Properties()
                    .stacksTo(1)
                    .rarity(Rarity.EPIC)));

    public static final Supplier<Item> YUNSHUL_WISH = ITEMS.register("yunshul_wish",
            () -> new YunshulWish(new Item.Properties()
                    .stacksTo(1)  // Only one item per stack
                    .rarity(Rarity.EPIC)));

    public static final Supplier<Item> BOUNDER_CLAW = ITEMS.register("bounder_claw",
            () -> new Item(new Item.Properties()
                    .stacksTo(64)  // Only one item per stack
                    .rarity(Rarity.EPIC)));

    public static final Supplier<Item> BOUNDER_SCALES = ITEMS.register("bounder_scales",
            () -> new Item(new Item.Properties()
                    .stacksTo(64)  // Only one item per stack
                    .rarity(Rarity.EPIC)));

    public static final Supplier<Item> SOUL_DUST = ITEMS.register("soul_dust",
            () -> new Item(new Item.Properties()
                    .stacksTo(12)  // Only one item per stack
                    .rarity(Rarity.EPIC)));

    public static final Supplier<Item> RESONANCE_FRAGMENTS = ITEMS.register("resonance_fragments",
            () -> new Item(new Item.Properties()
                    .stacksTo(64)  // Only one item per stack
                    .rarity(Rarity.EPIC)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
