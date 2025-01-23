package com.gmail.rohzek.simpleindustry.items;

import com.gmail.rohzek.simpleindustry.lib.DeferredRegistration;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;

public class SITools 
{
	//Pickaxes
	public static final DeferredItem<Item> PLACEHOLDER_TOOL = DeferredRegistration.ITEMS.register("placeholder_tool", () -> new Item(new Item.Properties()));
	
	public static void register() {}
}
