package com.benrift.progressionmod.CreativeTabs;

import com.benrift.progressionmod.ProgressionMod;
import com.benrift.progressionmod.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ProgressionMod.MOD_ID);

    static {
        CREATIVE_MODE_TABS.register("progression_tab",
                () -> CreativeModeTab.builder()
                        .title(Component.translatable("itemgroup.progression"))
                        .icon(() -> ModItems.FRUIT_OF_CONSEQUENCE.get().getDefaultInstance())
                        .displayItems((parameters, output) -> {
                            output.accept(ModItems.FRUIT_OF_CONSEQUENCE.get());
                            output.accept(ModItems.TORTURE_DEVICE.get());
                            output.accept(ModItems.DEPTHS_PORTAL_IGNITER.get());
                            output.accept(ModItems.YUNSHUL_WISH.get());
                            output.accept(ModItems.BOUNDER_CLAW.get());
                            output.accept(ModItems.BOUNDER_SCALES.get());
                            output.accept(ModItems.SOUL_DUST.get());
                            output.accept(ModItems.RESONANCE_FRAGMENTS.get());
                        })
                        .build()
        );
    }


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}