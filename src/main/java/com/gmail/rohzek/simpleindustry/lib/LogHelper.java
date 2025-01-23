package com.gmail.rohzek.simpleindustry.lib;

import com.gmail.rohzek.simpleindustry.SimpleIndustry;

public class LogHelper 
{
	public static void Log(String message) 
	{
		SimpleIndustry.LOGGER.info(message);
	}
	
	public static void Debug(String message) 
	{
		if(ConfigurationManager.GENERAL.isDebug.get()) 
		{
			SimpleIndustry.LOGGER.debug(message);
		}
	}
}
