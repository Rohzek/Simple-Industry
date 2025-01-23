package com.gmail.rohzek.simpleindustry;

import org.slf4j.Logger;

import com.gmail.rohzek.simpleindustry.blocks.SIBlocks;
import com.gmail.rohzek.simpleindustry.items.SIItems;
import com.gmail.rohzek.simpleindustry.items.SITools;
import com.gmail.rohzek.simpleindustry.lib.ConfigurationManager;
import com.gmail.rohzek.simpleindustry.lib.DeferredRegistration;
import com.gmail.rohzek.simpleindustry.lib.Reference;
import com.mojang.logging.LogUtils;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

@Mod(Reference.MODID)
public class SimpleIndustry 
{
	public final static Logger LOGGER = LogUtils.getLogger();
	
	public SimpleIndustry(IEventBus modEventBus, ModContainer modContainer)
	{
		modEventBus.addListener(this::commonSetup);
		
		NeoForge.EVENT_BUS.register(this);
		
		if (FMLEnvironment.dist == Dist.CLIENT) {}
		
		// Register items
		DeferredRegistration.register(modEventBus);
		SIItems.register();
		SITools.register();
		SIBlocks.register();

		// Register configuration file
		//final ModLoadingContext modLoadingContext = ModLoadingContext.get();
		modContainer.registerConfig(ModConfig.Type.COMMON, ConfigurationManager.spec);
	}
	
	private void commonSetup(FMLCommonSetupEvent event) {}
	
	// You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {}
    
    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = Reference.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents 
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {}
    }
}
