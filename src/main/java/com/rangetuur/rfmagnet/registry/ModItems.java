package com.rangetuur.rfmagnet.registry;

import com.rangetuur.rfmagnet.RFMagnet;
import com.rangetuur.rfmagnet.RFMagnetConfig;
import com.rangetuur.rfmagnet.items.MagnetItem;
import me.shedaniel.autoconfig.AutoConfig;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import team.reborn.energy.EnergyTier;

public class ModItems {
    private static RFMagnetConfig config = AutoConfig.getConfigHolder(RFMagnetConfig.class).getConfig();

    //Items
    public static final Item BASIC_MAGNET = new MagnetItem(new Item.Settings().group(ItemGroup.TOOLS).maxCount(1), config.magnets.range_basic_magnet, config.magnets.capacity_basic_magnet, EnergyTier.MICRO);
    public static final Item ADVANCED_MAGNET = new MagnetItem(new Item.Settings().group(ItemGroup.TOOLS).fireproof().maxCount(1), config.magnets.range_advanced_magnet, config.magnets.capacity_advanced_magnet, EnergyTier.MICRO);

    //Block Items
    public static final BlockItem MAGNET_JAR = new BlockItem(ModBlocks.MAGNET_JAR, new Item.Settings().group(ItemGroup.TRANSPORTATION));

    public static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier(RFMagnet.MOD_ID, "basic_magnet"), BASIC_MAGNET);
        Registry.register(Registry.ITEM, new Identifier(RFMagnet.MOD_ID, "advanced_magnet"), ADVANCED_MAGNET);
        Registry.register(Registry.ITEM, new Identifier(RFMagnet.MOD_ID, "magnet_jar"), MAGNET_JAR);
    }
}
