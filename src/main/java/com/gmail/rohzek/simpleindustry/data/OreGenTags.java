package com.gmail.rohzek.simpleindustry.data;

import com.gmail.rohzek.simpleindustry.lib.Reference;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;

public class OreGenTags 
{
	public static class Blocks
	{
		public static final TagKey<Block> PLACEHOLDER_BLOCK_TAG = createTag("example/tag");
		
		private static TagKey<Block> createTag(String name)
		{
			return BlockTags.create(ResourceLocation.fromNamespaceAndPath(Reference.MODID, name));
		}
	}
	
	public static class Items
	{
		public static final TagKey<Item> EXAMPLE_ITEM_TAG = createTag("example/item/tag");
					
		private static TagKey<Item> createTag(String name)
		{
			return ItemTags.create(ResourceLocation.fromNamespaceAndPath(Reference.MODID, name));
		}
	}
	
	public static class Biomes
	{
		// Define tags for biomes
		public static final TagKey<Biome> CHESHIREROSE_BIOMES = createTag("biomes/cheshirerose");
		public static final TagKey<Biome> ROSE_BIOMES = createTag("biomes/rose_biomes");
		
		public static final TagKey<Biome> ALL_BIOMES = createTag("biomes/all");
		
		private static TagKey<Biome> createTag(String name)
		{
			return TagKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(Reference.MODID, name));
		}
	}
}
