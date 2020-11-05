package com.example.examplemod;

import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.WorldTickEvent;
import net.minecraftforge.event.world.WorldEvent.Load;

@EventBusSubscriber
public class MyForgeEventHandler {
	public long totalWorldTime = 0;
	
    @SubscribeEvent
    public void worldLoad(Load event) {
        System.out.println("Hello world");
    }

    @SubscribeEvent
    public void worldTick(WorldTickEvent event) {
    	long tickCheckWorldTime = event.world.getTotalWorldTime();
    	
    	if (totalWorldTime != tickCheckWorldTime) {
    		totalWorldTime = tickCheckWorldTime;
    		System.out.println("time: " + totalWorldTime);
    	}
    }
}