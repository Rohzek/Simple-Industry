package com.gmail.rohzek.simpleindustry.world;

import java.util.List;

import com.gmail.rohzek.simpleindustry.lib.Reference;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RarityFilter;

public class ModPlacedFeatures 
{
	public static final ResourceKey<PlacedFeature> EXAMPLE_PLACED_KEY = registerKey("example_placed");
	
    public static void bootstrap(BootstrapContext<PlacedFeature> context) 
    {
    	// ConfigureFeature -> PlacedFeature -> BiomeModifier
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);
        
        
        register(context, EXAMPLE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.EXAMPLE_CONFIG_KEY),
        		List.of(CountPlacement.of(3), RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, 
        		BiomeFilter.biome()));
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) 
    {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(Reference.MODID, name));
    }

    
	private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) 
    {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
