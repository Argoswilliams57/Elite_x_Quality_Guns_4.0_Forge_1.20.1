package com.argos.elitex.registeration;

import com.tacz.guns.init.ModItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

// Author Elite x El Rubio
public class ModCreativeTabRegistry {

    // Register the custom creative tab
    public static final ItemGroup ELITE_CREATIVE_TAB = Registry.register(
            Registries.ITEM_GROUP,
            new Identifier("elitex", "creative_tab"),
            FabricItemGroup.builder()
                    .displayName(Text.translatable("itemgroup.elitex")) // Custom tab title
                    .icon(() -> new ItemStack(ModItemRegistry.CREATIVE_ICON)) // Custom tab icon
                    .entries((displayContext, entries) -> {

                        // Get the base item from TACZ mod
                        Item GunItem = ModItems.MODERN_KINETIC_GUN;

                        // Organize guns into categories and add them to the creative tab

                        //Pistols
                        entries.add(createCustomNBTItem(GunItem, "elitex:colt_m1911x1", 7, "SEMI", true, "elitex.gun.colt_m1911x1.name"));
                        entries.add(createCustomNBTItem(GunItem, "elitex:jrx", 20, "SEMI", true, "elitex.gun.jrx.name"));
                        entries.add(createCustomNBTItem(GunItem, "elitex:five_seven", 20, "SEMI", true, "elitex.gun.five_seven.name"));
                        entries.add(createCustomNBTItem(GunItem, "elitex:srz_2011", 16, "SEMI", true, "elitex.gun.srz_2011.name"));
                        entries.add(createCustomNBTItem(GunItem, "elitex:bo1_1911", 8, "SEMI", true, "elitex.gun.bo1_1911.name"));
                        entries.add(createCustomNBTItem(GunItem, "elitex:op1911", 7, "SEMI", true, "elitex.gun.op1911.name"));
                        entries.add(createCustomNBTItem(GunItem, "elitex:springfield_m1911", 7, "SEMI", true, "elitex.gun.springfield_m1911.name"));
                        entries.add(createCustomNBTItem(GunItem, "elitex:raygun_bo6", 20, "AUTO", false, "elitex.gun.raygun_bo6.name"));
                        entries.add(createCustomNBTItem(GunItem, "elitex:trs_bull", 5, "SEMI", false, "elitex.gun.trs_bull.name"));


                        //Smgs
                        entries.add(createCustomNBTItem(GunItem, "elitex:ro635v3", 32, "AUTO", true, "elitex.gun.ro635v3.name"));
                        entries.add(createCustomNBTItem(GunItem, "elitex:mp5_classic", 30, "AUTO", true, "elitex.gun.mp5_classic.name"));
                        entries.add(createCustomNBTItem(GunItem, "elitex:vector45acp", 35, "AUTO", true, "elitex.gun.vector45acp.name"));



                        //Assault Rifles
                        entries.add(createCustomNBTItem(GunItem, "elitex:ak47x", 30, "AUTO", true, "elitex.gun.ak47x.name"));
                        entries.add(createCustomNBTItem(GunItem, "elitex:m4_sopmod", 35, "AUTO", true, "elitex.gun.m4_sopmod.name"));
                        entries.add(createCustomNBTItem(GunItem, "elitex:mcs_spear", 20, "AUTO", true, "elitex.gun.mcs_spear.name"));
                        entries.add(createCustomNBTItem(GunItem, "elitex:famas_f1", 25, "AUTO", true, "elitex.gun.famas_f1.name"));
                        entries.add(createCustomNBTItem(GunItem, "elitex:akx105", 30, "AUTO", true, "elitex.gun.akx105.name"));
                        entries.add(createCustomNBTItem(GunItem, "elitex:fh_scar18", 20, "SEMI", true, "elitex.gun.fh_scar18.name"));
                        entries.add(createCustomNBTItem(GunItem, "elitex:fs_scar19", 30, "AUTO", true, "elitex.gun.fs_scar19.name"));


                        // Dmrs Mrrksman Rifles
                        entries.add(createCustomNBTItem(GunItem, "elitex:sassy_dmr", 20, "SEMI", true, "elitex.gun.sassy_dmr.name"));



                        //Wonder Weapons
                        entries.add(createCustomNBTItem(GunItem, "elitex:ray_gun_mk2", 21, "BURST", true, "elitex.gun.ray_gun_mk2.name"));
                        entries.add(createCustomNBTItem(GunItem, "elitex:wonder_waffle", 3, "SEMI", true, "elitex.gun.wonder_waffle.name"));
                        entries.add(createCustomNBTItem(GunItem, "elitex:mustang_and_sally", 12, "SEMI", true, "elitex.gun.mustang_and_sally.name"));
                        entries.add(createCustomNBTItem(GunItem, "elitex:origin_electric_staff", 9, "SEMI", false, "elitex.gun.origin_electric_staff.name"));
                        entries.add(createCustomNBTItem(GunItem, "elitex:origin_fire_staff", 10, "SEMI", false, "elitex.gun.origin_fire_staff.name"));
                        entries.add(createCustomNBTItem(GunItem, "elitex:origin_ice_staff", 10, "SEMI", false, "elitex.gun.origin_ice_staff.name"));
                        entries.add(createCustomNBTItem(GunItem, "elitex:origin_wind_staff", 10, "SEMI", false, "elitex.gun.origin_wind_staff.name"));

                        //Shotguns
                        entries.add(createCustomNBTItem(GunItem, "elitex:benelli_super", 8, "SEMI", true, "elitex.gun.benelli_super.name"));

                        //Bolt Action Rifles
                        entries.add(createCustomNBTItem(GunItem, "elitex:kar98k", 5, "SEMI", false, "elitex.gun.kar98k.name"));
                        entries.add(createCustomNBTItem(GunItem, "elitex:m1_garand", 8, "SEMI", false, "elitex.gun.m1_garand.name"));
                        entries.add(createCustomNBTItem(GunItem, "elitex:lee", 10, "SEMI", false, "elitex.gun.lee.name"));
                        entries.add(createCustomNBTItem(GunItem, "elitex:sp_m1903", 5, "SEMI", false, "elitex.gun.sp_m1903.name"));


                        //Snipers
                        entries.add(createCustomNBTItem(GunItem, "elitex:inter_m200", 7, "SEMI", true, "elitex.gun.inter_m200.name"));

                        //Lmgs
                        entries.add(createCustomNBTItem(GunItem, "elitex:m249x", 150, "AUTO", false, "elitex.gun.m249x.name"));



                        // Item GunItem = ModItems.MODERN_KINETIC_GUN;
                        // Add normal items disabled for now i will  when i in future add new stuff

                        // entries.add(new ItemStack(ModItemRegistry.CREATIVE_ICON));

                    })
                    .build()
    );

    public static void registerCreativeTabs() {
        // Ensure creative tab is loaded during initialization
    }

    /**
     * Creates an ItemStack with custom NBT data for a gun.
     *
     * @param baseItem      The base item to use.
     * @param gunId         The unique ID for the gun.
     * @param ammoCount     The current ammo count.
     * @param fireMode      The gun's fire mode (e.g., SEMI, AUTO, BURST).
     * @param hasBulletInBarrel Whether the gun has a bullet in the barrel.
     * @param displayName   The gun's display name.
     * @return The ItemStack with the custom NBT data.
     */
    private static ItemStack createCustomNBTItem(Item baseItem, String gunId, int ammoCount, String fireMode, boolean hasBulletInBarrel, String displayName) {
        ItemStack stack = new ItemStack(baseItem);
        NbtCompound nbt = stack.getOrCreateNbt();

        // Add custom NBT data
        nbt.putString("GunId", gunId);
        nbt.putInt("GunCurrentAmmoCount", ammoCount);
        nbt.putString("GunFireMode", fireMode);
        nbt.putBoolean("HasBulletInBarrel", hasBulletInBarrel);

        stack.setNbt(nbt); // Attach the NBT to the stack
        stack.setCustomName(Text.translatable(displayName).styled(style -> style.withItalic(false))); // Set display name without italics

        return stack;
    }
}
