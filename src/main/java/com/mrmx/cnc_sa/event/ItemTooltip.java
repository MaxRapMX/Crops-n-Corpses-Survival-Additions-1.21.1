package com.mrmx.cnc_sa.event;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import net.minecraft.core.registries.BuiltInRegistries;

@EventBusSubscriber(modid = "cnc_sa", value = Dist.CLIENT)

public class ItemTooltip {

    @SubscribeEvent
    public static void VisualEffects(ItemTooltipEvent event) {
        ResourceLocation id = BuiltInRegistries.ITEM.getKey(event.getItemStack().getItem());
        if (id.getNamespace().equals("cnc")) {
            switch (id.getPath()) {
                case "chocolate_chip_muffin":
                    Component chocolate_chip_muffin = Component.translatable(MobEffects.DIG_SPEED.value().getDescriptionId());
                    event.getToolTip().add(chocolate_chip_muffin.copy().withStyle(ChatFormatting.BLUE)
                            .append(Component.literal(" (00:05)").withStyle(ChatFormatting.BLUE)));
                    break;
                case "sunflower_seed_muffin":
                    Component sunflower_seed_muffin = Component.translatable(MobEffects.DAMAGE_RESISTANCE.value().getDescriptionId());
                    event.getToolTip().add(sunflower_seed_muffin.copy().withStyle(ChatFormatting.BLUE)
                            .append(Component.literal(" (00:05)").withStyle(ChatFormatting.BLUE)));
                    break;
                case "cherry_muffin":
                    Component cherry_muffin = Component.translatable(MobEffects.REGENERATION.value().getDescriptionId());
                    event.getToolTip().add(cherry_muffin.copy().withStyle(ChatFormatting.BLUE)
                            .append(Component.literal(" (00:05)").withStyle(ChatFormatting.BLUE)));
                     break;
                case "mashed_potatoes":
                    if (ModList.get().isLoaded("farmersdelight")) {
                        var nourishment = BuiltInRegistries.MOB_EFFECT.getHolder(ResourceLocation.parse("farmersdelight:nourishment"));
                        if (nourishment.isPresent()) {
                            Component nourishmentEffect = Component.translatable(nourishment.get().value().getDescriptionId());
                            event.getToolTip().add(nourishmentEffect.copy().withStyle(ChatFormatting.BLUE)
                                    .append(Component.literal(" (03:00)").withStyle(ChatFormatting.BLUE)));
                        }
                    } break;
                case "golden_cherries":
                    if (ModList.get().isLoaded("farmersdelight")) {
                        var comfort = BuiltInRegistries.MOB_EFFECT.getHolder(ResourceLocation.parse("farmersdelight:comfort"));
                        if (comfort.isPresent()) {
                            Component comfortEffect = Component.translatable(comfort.get().value().getDescriptionId());
                            event.getToolTip().add(comfortEffect.copy().withStyle(ChatFormatting.BLUE)
                                    .append(Component.literal(" (01:25)").withStyle(ChatFormatting.BLUE)));
                        }
                    } break;
                case "vanilla_milkshake":
                    Component vanilla_milkshake = Component.translatable(MobEffects.MOVEMENT_SPEED.value().getDescriptionId());
                    event.getToolTip().add(vanilla_milkshake.copy().withStyle(ChatFormatting.BLUE)
                            .append(Component.literal(" II (00:45)").withStyle(ChatFormatting.BLUE)));
                    if (ModList.get().isLoaded("farmersdelight")) {
                        var nourishment = BuiltInRegistries.MOB_EFFECT.getHolder(ResourceLocation.parse("farmersdelight:nourishment"));
                        if (nourishment.isPresent()) {
                            Component nourishmentEffect = Component.translatable(nourishment.get().value().getDescriptionId());
                            event.getToolTip().add(nourishmentEffect.copy().withStyle(ChatFormatting.BLUE)
                                    .append(Component.literal(" (00:45)").withStyle(ChatFormatting.BLUE)));
                        }
                    } break;
                case "chocolate_milkshake":
                    Component chocolate_milkshake = Component.translatable(MobEffects.DIG_SPEED.value().getDescriptionId());
                    event.getToolTip().add(chocolate_milkshake.copy().withStyle(ChatFormatting.BLUE)
                            .append(Component.literal(" II (01:25)").withStyle(ChatFormatting.BLUE)));
                    if (ModList.get().isLoaded("farmersdelight")) {
                        var nourishment = BuiltInRegistries.MOB_EFFECT.getHolder(ResourceLocation.parse("farmersdelight:nourishment"));
                        if (nourishment.isPresent()) {
                            Component nourishmentEffect = Component.translatable(nourishment.get().value().getDescriptionId());
                            event.getToolTip().add(nourishmentEffect.copy().withStyle(ChatFormatting.BLUE)
                                    .append(Component.literal(" (00:45)").withStyle(ChatFormatting.BLUE)));
                        }
                    } break;
                case "cherry_milkshake":
                    Component cherry_milkshake = Component.translatable(MobEffects.REGENERATION.value().getDescriptionId());
                    event.getToolTip().add(cherry_milkshake.copy().withStyle(ChatFormatting.BLUE)
                            .append(Component.literal(" II (00:10)").withStyle(ChatFormatting.BLUE)));
                    if (ModList.get().isLoaded("farmersdelight")) {
                        var nourishment = BuiltInRegistries.MOB_EFFECT.getHolder(ResourceLocation.parse("farmersdelight:nourishment"));
                        if (nourishment.isPresent()) {
                            Component nourishmentEffect = Component.translatable(nourishment.get().value().getDescriptionId());
                            event.getToolTip().add(nourishmentEffect.copy().withStyle(ChatFormatting.BLUE)
                                    .append(Component.literal(" (00:45)").withStyle(ChatFormatting.BLUE)));
                        }
                    } break;
            }
        }
    }
}