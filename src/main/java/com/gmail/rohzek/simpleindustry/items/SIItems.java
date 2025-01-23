package com.gmail.rohzek.simpleindustry.items;

import com.gmail.rohzek.simpleindustry.lib.DeferredRegistration;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;

public class SIItems 
{
	// Raws
	public static final DeferredItem<Item> PLACEHOLDER_ITEM = DeferredRegistration.ITEMS.register("placeholder_item", () -> new Item(new Item.Properties()));
    
    public static void register() {}
}
