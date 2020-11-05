package com.example.examplemod;

import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.world.WorldEvent.Load;

@EventBusSubscriber
public class MyForgeEventHandler {
    @SubscribeEvent
    public void worldLoad(Load event) {
        System.out.println("Hello world");
    }
}