package com.enfield_garcia.elitex;


import com.enfield_garcia.registeration_center.EliteXCreativeTabRegistry;
import com.enfield_garcia.registeration_center.ElitexItemRegistry;
import com.tacz.guns.api.resource.ResourceManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod("elitex")
public class EliteXQualityGuns {
    public static final String MOD_ID = "elitex";
    public static final Logger LOGGER = LogManager.getLogger("elitex");
    public static final String DEFAULT_GUN_PACK_NAME = "elitex_quality_guns";

    public EliteXQualityGuns() {

        Dist side = FMLLoader.getDist();
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        EliteXCreativeTabRegistry.CREATIVE_MODE_TABS.register(modEventBus);
        ElitexItemRegistry.ITEMS.register(modEventBus);
        registerDefaultExtraGunPack();

    }

    private static void registerDefaultExtraGunPack() {
        String jarDefaultPackPath = String.format("/assets/%s/custom/%s", "elitex", "elitex_quality_guns");
        ResourceManager.registerExportResource(EliteXQualityGuns.class, jarDefaultPackPath);
    }
}
