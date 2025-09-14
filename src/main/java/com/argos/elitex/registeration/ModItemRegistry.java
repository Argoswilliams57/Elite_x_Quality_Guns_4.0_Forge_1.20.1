package com.argos.elitex.registeration;

import com.argos.elitex.ElitexQualityGunsFabric;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItemRegistry {

    public static final Item CREATIVE_ICON =  registerItem ("creative_icon",new Item(new FabricItemSettings()));

    //For Fabric We need to Throw some like helper methods here without these registering item is impossible
    public static Item registerItem(String name , Item item){
        return Registry.register(Registries.ITEM, new Identifier(ElitexQualityGunsFabric.MOD_ID,name), item);

    }

    public static void RegisterTheItems(){
        ElitexQualityGunsFabric.LOGGER.info("Registering the Mod Items" + ElitexQualityGunsFabric.MOD_ID);
    }

}
