package com.benrift.progressionmod.datagen;

import com.benrift.progressionmod.ProgressionMod;
import com.benrift.progressionmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ProgressionMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.DEPTHS_PORTAL_IGNITER.get());
        basicItem(ModItems.YUNSHUL_WISH.get());
        basicItem(ModItems.BOUNDER_SCALES.get());
        basicItem(ModItems.BOUNDER_CLAW.get());
    }
}
