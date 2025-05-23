package com.benrift.progressionmod.datagen;

import com.benrift.progressionmod.ProgressionMod;
import com.benrift.progressionmod.block.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ProgressionMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
       // blockWithItem(Blocks.EXAMPLE.get());
    }

    private void blockWithItem(Block blockObject){
        simpleBlockWithItem(blockObject, cubeAll(blockObject));
    }
}
