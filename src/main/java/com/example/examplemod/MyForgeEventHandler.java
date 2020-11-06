package com.example.examplemod;

import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings.Options;
import net.minecraftforge.event.world.WorldEvent;

@EventBusSubscriber
public class MyForgeEventHandler {
	public static long totalWorldTime = 0;
	public static boolean messageSent = false;
	
    @SubscribeEvent
    public static void worldLoad(WorldEvent.Load event) {
        System.out.println("Hello world");
    }

    @SubscribeEvent
    public static void clientTick(TickEvent.ClientTickEvent event) {
    	if (Minecraft.getMinecraft().world == null) {
    		return;
    	}
    	if (!messageSent) {
    		messageSent = true;
    		Minecraft.getMinecraft().ingameGUI.setOverlayMessage("test", true);
    	}
    	long tickCheckWorldTime = Minecraft.getMinecraft().world.getTotalWorldTime();
    	if (tickCheckWorldTime == 0) {
    		return;
    	}
    	if (totalWorldTime != tickCheckWorldTime) {
    		totalWorldTime = tickCheckWorldTime;
    		Minecraft.getMinecraft().gameSettings.setOptionFloatValue(Options.GAMMA, (float)Math.sin(tickCheckWorldTime));
    		Minecraft.getMinecraft().gameSettings.saveOptions();
    	}
    }
}