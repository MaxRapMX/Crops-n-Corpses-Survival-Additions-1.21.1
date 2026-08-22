package com.mrmx.cnc_sa.event;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingChangeTargetEvent;
import net.neoforged.neoforge.event.tick.EntityTickEvent;
import uwu.llkc.cnc.common.entities.plants.CNCPlant;
import uwu.llkc.cnc.common.init.ItemRegistry;

@EventBusSubscriber(modid = "cnc_sa")
public class HoldingPlantFood {

    @SubscribeEvent
    public static void onChangeTarget(LivingChangeTargetEvent event) {
        if (!(event.getEntity() instanceof CNCPlant plant)) return;
        if (plant.getOwnerUUID() != null) return;

        LivingEntity newTarget = event.getNewAboutToBeSetTarget();
        if (newTarget instanceof Player player && isHoldingPlantFood(player)) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void onEntityTickPost(EntityTickEvent.Post event) {
        if (!(event.getEntity() instanceof CNCPlant plant)) return;
        if (plant.level().isClientSide()) return;
        if (plant.getOwnerUUID() != null) return;
        if (plant.getTarget() instanceof Player targetPlayer && isHoldingPlantFood(targetPlayer)) {
            plant.setTarget(null);
        }
    }

    private static boolean isHoldingPlantFood(Player player) {
        return player.getMainHandItem().is(ItemRegistry.PLANT_FOOD.get())
                || player.getOffhandItem().is(ItemRegistry.PLANT_FOOD.get());
    }
}