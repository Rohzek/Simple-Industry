package com.gmail.rohzek.simpleindustry.blocks;

import com.gmail.rohzek.simpleindustry.lib.DeferredRegistration;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;

public class SIBlocks 
{
	public static final DeferredBlock<Block> PLACEHOLDER_BLOCK = DeferredRegistration.registerBlock("placeholder_block", () -> new Block(BlockBehaviour.Properties.of()));

	public static void register() {}
}
