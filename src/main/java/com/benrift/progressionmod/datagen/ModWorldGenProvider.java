package com.benrift.progressionmod.datagen;

import com.benrift.progressionmod.ProgressionMod;
import com.benrift.progressionmod.worldgen.biome.ModBiomes;
import com.benrift.progressionmod.worldgen.dimension.DepthsDimension;
import io.netty.util.concurrent.CompleteFuture;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModWorldGenProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.DIMENSION_TYPE, DepthsDimension::bootstrapType)
            .add(Registries.BIOME, ModBiomes::boostrap)
            .add(Registries.LEVEL_STEM, DepthsDimension::bootstrapStem);

    public ModWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(ProgressionMod.MOD_ID));
    }
}
