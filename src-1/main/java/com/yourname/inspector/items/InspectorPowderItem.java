package com.yourname.inspector.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.world.World;

public class InspectorPowderItem extends Item {
    public InspectorPowderItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        if (world.isClient) return ActionResult.SUCCESS;

        PlayerEntity player = context.getPlayer();
        BlockHitResult hit = (BlockHitResult) context.getHitResult();
        var pos = hit.getBlockPos();

        player.sendMessage(Text.literal("Logs at " + pos + ": [пример лога]"), false);
        context.getStack().decrement(1);
        return ActionResult.CONSUME;
    }
}
