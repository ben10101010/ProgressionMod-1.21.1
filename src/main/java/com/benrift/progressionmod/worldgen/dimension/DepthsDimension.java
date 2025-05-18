package com.benrift.progressionmod.worldgen.dimension;

import com.benrift.progressionmod.ProgressionMod;
import com.benrift.progressionmod.worldgen.biome.ModBiomes;
import it.unimi.dsi.fastutil.Pair;
import it.unimi.dsi.fastutil.doubles.DoubleList;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.DimensionTypes;
import net.minecraft.data.worldgen.SurfaceRuleData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.*;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import org.checkerframework.checker.units.qual.N;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.List;
import java.util.OptionalLong;

public class DepthsDimension{
    public static final ResourceKey<LevelStem> DEPTHSDIM_KEY = ResourceKey.create(Registries.LEVEL_STEM,
            ResourceLocation.fromNamespaceAndPath(ProgressionMod.MOD_ID, "depthsdim"));
    public static final ResourceKey<Level> DEPTHSDIM_LEVEL_KEY = ResourceKey.create(Registries.DIMENSION,
            ResourceLocation.fromNamespaceAndPath(ProgressionMod.MOD_ID, "depthsdim"));
    public static final ResourceKey<DimensionType> DEPTHSDIM_DIM_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE,
            ResourceLocation.fromNamespaceAndPath(ProgressionMod.MOD_ID, "depthsdim_type"));

    public static void bootstrapType(BootstrapContext<DimensionType> context){
        context.register(DEPTHSDIM_DIM_TYPE, new DimensionType(
                OptionalLong.of(12000),
                false,
                false,
                false,
                false,
                50.0,
                true,
                false,
                0,
                320,
                320,
                BlockTags.INFINIBURN_OVERWORLD,
                BuiltinDimensionTypes.OVERWORLD_EFFECTS,
                0.5f,
                new DimensionType.MonsterSettings(false, false, ConstantInt.of(0), 0)
        ));
    }

    public static void bootstrapStem(BootstrapContext<LevelStem> context){
        HolderGetter<Biome> biomeRegistry = context.lookup(Registries.BIOME);
        HolderGetter<DimensionType> dimTypes = context.lookup(Registries.DIMENSION_TYPE);
        HolderGetter<NoiseGeneratorSettings> noiseGenSettings = context.lookup(Registries.NOISE_SETTINGS);

        SurfaceRules.RuleSource surfaceRule = SurfaceRules.sequence(
                SurfaceRules.ifTrue(
                        SurfaceRules.ON_FLOOR,
                        SurfaceRules.state(Blocks.DEEPSLATE.defaultBlockState())
                )
        );

        NormalNoise.NoiseParameters noiseParams = new NormalNoise.NoiseParameters(
                -7,  // first octave
                DoubleList.of(new double[]{1.0, 1.0})  // amplitude array (2 octaves in this case)
        );

        NoiseGeneratorSettings noise = getNoiseGeneratorSettings(noiseParams, surfaceRule);


        NoiseBasedChunkGenerator wrappedChunckGenerator = new NoiseBasedChunkGenerator(
                new FixedBiomeSource(biomeRegistry.getOrThrow(ModBiomes.DEPTHS_BIOME)), Holder.direct(noise));



        LevelStem stem = new LevelStem(dimTypes.getOrThrow(DepthsDimension.DEPTHSDIM_DIM_TYPE), wrappedChunckGenerator);

        context.register(DEPTHSDIM_KEY, stem);
    }

    private static @NotNull NoiseGeneratorSettings getNoiseGeneratorSettings(NormalNoise.NoiseParameters noiseParams, SurfaceRules.RuleSource surfaceRule) {
        Holder<NormalNoise.NoiseParameters> holder = Holder.direct(noiseParams);

        NoiseSettings settings = new NoiseSettings(0, 320, 1, 2);
        NoiseRouter router = new NoiseRouter(
                DensityFunctions.noise(holder, 1.0, 0.5),
                DensityFunctions.zero(),
                DensityFunctions.zero(),
                DensityFunctions.zero(),
                DensityFunctions.zero(),
                DensityFunctions.zero(),
                DensityFunctions.constant(64),
                DensityFunctions.zero(),
                DensityFunctions.zero(),
                DensityFunctions.zero(),
                DensityFunctions.zero(),
                DensityFunctions.zero(),
                DensityFunctions.zero(),
                DensityFunctions.zero(),
                DensityFunctions.zero()
        );

        return new NoiseGeneratorSettings(
                settings,
                Blocks.DEEPSLATE.defaultBlockState(),
                Blocks.WATER.defaultBlockState(),
                router,
                surfaceRule,
                List.of(Climate.parameters(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F)),
                156,
                false,
                true,
                true,
                false
        );
    }
}
