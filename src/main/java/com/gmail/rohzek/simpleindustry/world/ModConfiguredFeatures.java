package com.gmail.rohzek.simpleindustry.world;

import java.util.List;

import com.gmail.rohzek.simpleindustry.lib.Reference;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class ModConfiguredFeatures 
{
	public static final ResourceKey<ConfiguredFeature<?, ?>> EXAMPLE_CONFIG_KEY = registerKey("example");
	
    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) 
    {
    	 register(context, EXAMPLE_CONFIG_KEY, Feature.FLOWER, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK,
         		new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.DANDELION.defaultBlockState())), 
         		List.of(Blocks.GRASS_BLOCK, Blocks.DIRT)));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) 
    {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(Reference.MODID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) 
    {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
