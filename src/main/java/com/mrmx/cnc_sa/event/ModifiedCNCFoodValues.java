package com.mrmx.cnc_sa.event;

import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.ModifyDefaultComponentsEvent;
import uwu.llkc.cnc.common.init.ItemRegistry;
import net.neoforged.fml.ModList;
import net.minecraft.resources.ResourceLocation;

@EventBusSubscriber(modid = "cnc_sa")

public class ModifiedCNCFoodValues {

    @SubscribeEvent
    public static void ModifierCNCFoodValues(ModifyDefaultComponentsEvent event) {

        event.modify(ItemRegistry.CHOCOLATE_CHIP_MUFFIN.get(), builder -> {
            FoodProperties NEW_CHOCOLATE_CHIP_MUFFIN = new FoodProperties.Builder().nutrition(3).saturationModifier(0.5f)
                    .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 100, 0), 1.0F)
                    .usingConvertsTo(Items.PAPER).build();
            builder.set(DataComponents.FOOD, NEW_CHOCOLATE_CHIP_MUFFIN);
        });
        event.modify(ItemRegistry.SUNFLOWER_SEED_MUFFIN.get(), builder -> {
            FoodProperties NEW_SUNFLOWER_SEED_MUFFIN = new FoodProperties.Builder().nutrition(4).saturationModifier(0.25f)
                    .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 100, 0), 1.0F)
                    .effect(() -> new MobEffectInstance(MobEffects.GLOWING, 1700, 0), 0.65F)
                    .usingConvertsTo(Items.PAPER).build();
            builder.set(DataComponents.FOOD, NEW_SUNFLOWER_SEED_MUFFIN);
        });
        event.modify(ItemRegistry.CHERRY_MUFFIN.get(), builder -> {
            FoodProperties NEW_CHERRY_MUFFIN = new FoodProperties.Builder().nutrition(4).saturationModifier(0.25f)
                    .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 100, 0), 1.0F)
                    .usingConvertsTo(Items.PAPER).build();
            builder.set(DataComponents.FOOD, NEW_CHERRY_MUFFIN);
        });
        event.modify(ItemRegistry.MASHED_POTATOES.get(), builder -> {
            var NEW_MASHED_POTATOES = new FoodProperties.Builder().nutrition(5).saturationModifier(0.7f).usingConvertsTo(Items.BOWL);
            if (ModList.get().isLoaded("farmersdelight")) {
                var nourishment = BuiltInRegistries.MOB_EFFECT.getHolder(ResourceLocation.parse("farmersdelight:nourishment"));
                if (nourishment.isPresent()) {
                    NEW_MASHED_POTATOES.effect(() -> new MobEffectInstance(nourishment.get(), 3600, 0), 1.0F);
                } var comfort = BuiltInRegistries.MOB_EFFECT.getHolder(ResourceLocation.parse("farmersdelight:comfort"));
                if (comfort.isPresent()) {
                    NEW_MASHED_POTATOES.effect(() -> new MobEffectInstance(comfort.get(), 600, 0), 0.05F);
                }
            } builder.set(DataComponents.FOOD, NEW_MASHED_POTATOES.build());
        });
        event.modify(ItemRegistry.GOLDEN_CHERRIES.get(), builder -> {
            var NEW_GOLDEN_CHERRIES = new FoodProperties.Builder().nutrition(3).saturationModifier(1.5f).alwaysEdible();
            if (ModList.get().isLoaded("farmersdelight")) {
                var comfort = BuiltInRegistries.MOB_EFFECT.getHolder(ResourceLocation.parse("farmersdelight:comfort"));
                if (comfort.isPresent()) {
                    NEW_GOLDEN_CHERRIES.effect(() -> new MobEffectInstance(comfort.get(), 1700, 0), 1.0F);
                }
            } builder.set(DataComponents.FOOD, NEW_GOLDEN_CHERRIES.build());
        });
        event.modify(ItemRegistry.CHERRY_PIE.get(), builder -> {
            FoodProperties NEW_CHERRY_PIE = new FoodProperties.Builder()
                    .nutrition(6).saturationModifier(0.6f).build();
            builder.set(DataComponents.FOOD, NEW_CHERRY_PIE);
        });
        event.modify(ItemRegistry.VANILLA_MILKSHAKE.get(), builder -> {
            var NEW_VANILLA_MILKSHAKE = new FoodProperties.Builder().nutrition(3).saturationModifier(1.2f)
                    .alwaysEdible().fast()
                    .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 900, 1), 1.0F);
            if (ModList.get().isLoaded("farmersdelight")) {
                var nourishment = BuiltInRegistries.MOB_EFFECT.getHolder(ResourceLocation.parse("farmersdelight:nourishment"));
                if (nourishment.isPresent()) {
                    NEW_VANILLA_MILKSHAKE.effect(() -> new MobEffectInstance(nourishment.get(), 900, 0), 1.0F);
                }
            } builder.set(DataComponents.FOOD, NEW_VANILLA_MILKSHAKE.build());
        });
        event.modify(ItemRegistry.CHOCOLATE_MILKSHAKE.get(), builder -> {
            var NEW_CHOCOLATE_MILKSHAKE = new FoodProperties.Builder().nutrition(3).saturationModifier(1.2f)
                    .alwaysEdible().fast()
                    .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 1700, 1), 1.0F);
            if (ModList.get().isLoaded("farmersdelight")) {
                var nourishment = BuiltInRegistries.MOB_EFFECT.getHolder(ResourceLocation.parse("farmersdelight:nourishment"));
                if (nourishment.isPresent()) {
                    NEW_CHOCOLATE_MILKSHAKE.effect(() -> new MobEffectInstance(nourishment.get(), 900, 0), 1.0F);
                }
            } builder.set(DataComponents.FOOD, NEW_CHOCOLATE_MILKSHAKE.build());
        });
        event.modify(ItemRegistry.CHERRY_MILKSHAKE.get(), builder -> {
            var NEW_CHERRY_MILKSHAKE = new FoodProperties.Builder().nutrition(3).saturationModifier(1.2f)
                    .alwaysEdible().fast()
                    .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 200, 1), 1.0F);
            if (ModList.get().isLoaded("farmersdelight")) {
                var nourishment = BuiltInRegistries.MOB_EFFECT.getHolder(ResourceLocation.parse("farmersdelight:nourishment"));
                if (nourishment.isPresent()) {
                    NEW_CHERRY_MILKSHAKE.effect(() -> new MobEffectInstance(nourishment.get(), 900, 0), 1.0F);
                }
            } builder.set(DataComponents.FOOD, NEW_CHERRY_MILKSHAKE.build());
        });
    }
}