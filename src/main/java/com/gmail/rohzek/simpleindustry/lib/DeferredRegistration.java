package com.gmail.rohzek.simpleindustry.lib;

import java.util.function.Supplier;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class DeferredRegistration 
{
	public static final DeferredRegister.Items ITEMS = DeferredRegister.Items.createItems(Reference.MODID);
	public static final DeferredRegister.Items ITEM_BLOCKS = DeferredRegister.Items.createItems(Reference.MODID);
	public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.Blocks.createBlocks(Reference.MODID);
	private static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(BuiltInRegistries.CREATIVE_MODE_TAB, Reference.MODID);
	
	public static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block)
	{
		DeferredBlock<T> toReturn = BLOCKS.register(name, block);
		registerBlockItem(name, toReturn);
		return toReturn;
	}
	
	private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block)
	{
		ITEM_BLOCKS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
	}
	
	public static void register(IEventBus bus)
	{
		ITEMS.register(bus);
		ITEM_BLOCKS.register(bus);
		TABS.register(bus);
		BLOCKS.register(bus);
	}

	public static final Supplier<CreativeModeTab> ITEM_GROUP = TABS.register(Reference.MODID, () -> CreativeModeTab.builder()
			.title(Component.translatable("itemGroup." + Reference.MODID))
			.icon(() -> new ItemStack(Blocks.IRON_ORE))
			.displayItems((params, output) -> {
				ITEMS.getEntries().forEach(entry -> {
					output.accept(entry.get());
				});
				
				ITEM_BLOCKS.getEntries().forEach(entry -> {
					output.accept(entry.get());
				});
			})
			.build()
	);
}

