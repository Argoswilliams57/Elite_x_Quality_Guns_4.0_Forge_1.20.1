package com.argos.elitex;

import com.argos.elitex.registeration.ModCreativeTabRegistry;
import com.argos.elitex.registeration.ModItemRegistry;
import com.tacz.guns.api.resource.ResourceManager;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ElitexQualityGunsFabric implements ModInitializer {
	public static final String MOD_ID = "elitex";
	public static final Logger LOGGER = LoggerFactory.getLogger("elitex");
	public static final String DEFAULT_GUN_PACK_NAME = "elitex_quality_guns";

	public ElitexQualityGunsFabric() {
	}

	@Override
	public void onInitialize() {

        registerDefaultExtraGunPack();

		// Register items and creative tabs
		ModItemRegistry.RegisterTheItems();
		ModCreativeTabRegistry.registerCreativeTabs();
	}

	private static void registerDefaultExtraGunPack() {
		String jarDefaultPackPath = String.format("/assets/%s/custom/%s", "elitex", "elitex_quality_guns");
		ResourceManager.registerExportResource(ElitexQualityGunsFabric.class, jarDefaultPackPath);
	}
}
