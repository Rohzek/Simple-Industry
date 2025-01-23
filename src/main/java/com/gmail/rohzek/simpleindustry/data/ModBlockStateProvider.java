package com.gmail.rohzek.simpleindustry.data;

import com.gmail.rohzek.simpleindustry.blocks.SIBlocks;
import com.gmail.rohzek.simpleindustry.lib.Reference;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider 
{
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) 
    {
        super(output, Reference.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() 
    {
    	blockWithItem(SIBlocks.PLACEHOLDER_BLOCK);
    }
	
	private void blockWithItem(DeferredBlock<?> deferredBlock) 
    {
		String location = "block/", blockName = name(deferredBlock.get());
		
        simpleBlockWithItem(deferredBlock.get(), models().cubeAll(name(deferredBlock.get()),
        		ResourceLocation.fromNamespaceAndPath(Reference.MODID, location + name(deferredBlock.get()))));
    }
	
	private String name(Block block) 
	{
        return key(block).getPath();
    }
	
	private ResourceLocation key(Block block) 
	{
        return BuiltInRegistries.BLOCK.getKey(block);
    }
}
