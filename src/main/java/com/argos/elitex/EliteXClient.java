package com.argos.elitex;

import com.tacz.guns.client.init.ClientSetupEvent;
import com.tacz.guns.init.CommonRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;


public class EliteXClient implements ClientModInitializer {

    public void onInitializeClient() {
        ClientSetupEvent.onClientSetup();
        ClientLifecycleEvents.CLIENT_STARTED.register((client) -> {
            CommonRegistry.onLoadComplete();
        });
    }
}
