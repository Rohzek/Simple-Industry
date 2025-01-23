package com.gmail.rohzek.simpleindustry.world;

import com.gmail.rohzek.simpleindustry.lib.Reference;

import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ModBiomeModifiers 
{
	public static final ResourceKey<BiomeModifier> ADD_EXAMPLE = registerKey("add_example");
	
    public static void bootstrap(BootstrapContext<BiomeModifier> context) 
    {
        // ConfigureFeature -> PlacedFeature -> BiomeModifier
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_EXAMPLE, new BiomeModifiers.AddFeaturesBiomeModifier(
        		biomes.getOrThrow(Tags.Biomes.IS_RARE),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.EXAMPLE_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
    }

    private static ResourceKey<BiomeModifier> registerKey(String name) 
    {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(Reference.MODID, name));
    }
}
