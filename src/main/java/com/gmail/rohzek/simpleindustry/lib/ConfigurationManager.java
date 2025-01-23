package com.gmail.rohzek.simpleindustry.lib;

import net.neoforged.neoforge.common.ModConfigSpec;

public class ConfigurationManager
{
	private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    public static final General GENERAL = new General(BUILDER);
    public static final ModConfigSpec spec = BUILDER.build();
    
    public static class General 
    {
    	public final ModConfigSpec.ConfigValue<Boolean> isDebug;

    	
    	public General(ModConfigSpec.Builder builder)
        {
            builder.push("General");
            
            isDebug = builder
                    .comment("Enables/Disables debug mode logging [false/true|default:false]")
                    .translation("debugmode." + Reference.MODID + ".config")
                    .define("isDebug", false);

            builder.pop();
        }
    }
}

