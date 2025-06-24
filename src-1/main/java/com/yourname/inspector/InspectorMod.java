package com.yourname.inspector;

import com.yourname.inspector.items.InspectorPowderItem;
import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;

public class InspectorMod implements ModInitializer {
    public static final Item INSPECTOR_POWDER = new InspectorPowderItem(
        new FabricItemSettings().maxCount(16)
    );

    @Override
    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier("inspector", "inspector_powder"), INSPECTOR_POWDER);
    }
}
