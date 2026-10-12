package com.mrmx.cnc_sa.item;

import com.mrmx.cnc_sa.CNC_SAMod;
import com.mrmx.cnc_sa.item.custom.MilkshakeExtended;
import com.mrmx.cnc_sa.item.custom.PapaAntonioMilkshake;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class SA_ModItems {
    public static final boolean FARMERS_DELIGHT_REQUIRED = ModList.get().isLoaded("farmersdelight");
    public static final boolean PEANUT = ModList.get().isLoaded("cnc");
    public static final boolean ANTONIO_RECIPE = ModList.get().isLoaded("mrmx_dream") && ModList.get().isLoaded("mrmx_dream");
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CNC_SAMod.MODID);

    public static final DeferredItem<MilkshakeExtended> RICE_PUDING_MILKSHAKE = FARMERS_DELIGHT_REQUIRED
            ? ITEMS.register("rice_puding_milkshake",
            () -> new MilkshakeExtended(new Item.Properties().durability(32).food(SA_Milkshakes.RICE_PUDING_MILKSHAKE))): null;
    public static final DeferredItem<MilkshakeExtended> MAZAPAN_MILKSHAKE = FARMERS_DELIGHT_REQUIRED
            ? ITEMS.register("mazapan_milkshake",
            () -> new MilkshakeExtended(new Item.Properties().durability(32).food(SA_Milkshakes.MAZAPAN_MILKSHAKE))): null;
    public static final DeferredItem<MilkshakeExtended> WALNUT_MILKSHAKE = ITEMS.register("walnut_milkshake",
            () -> new MilkshakeExtended(new Item.Properties().durability(32).food(SA_Milkshakes.WALNUT_MILKSHAKE)));
    public static final DeferredItem<MilkshakeExtended> VANILLA_WITH_CHERRIES_MILKSHAKE = ITEMS.register("zues_prayer_milkshake",
            () -> new MilkshakeExtended(new Item.Properties().durability(8).food(SA_Milkshakes.VANILLA_WITH_CHERRIES_MILKSHAKE)));
    public static final DeferredItem<PapaAntonioMilkshake> THE_SECRET_MILKSHAKE = ANTONIO_RECIPE
            ? ITEMS.register("papa_antonio_milkshake",
            () -> new PapaAntonioMilkshake(new Item.Properties().durability(16).food(SA_Milkshakes.THE_SECRET_MILKSHAKE))): null;

    static class SA_Milkshakes {
        public static final FoodProperties RICE_PUDING_MILKSHAKE;
        public static final FoodProperties MAZAPAN_MILKSHAKE;
        public static final FoodProperties WALNUT_MILKSHAKE;
        public static final FoodProperties VANILLA_WITH_CHERRIES_MILKSHAKE;
        public static final FoodProperties THE_SECRET_MILKSHAKE;
        SA_Milkshakes() {}
        static {
            var RicePudingMilkshake = (new FoodProperties.Builder()).nutrition(3).saturationModifier(1.2f).alwaysEdible().fast()
                    .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 900, 0), 1.0F);
            BuiltInRegistries.MOB_EFFECT.getHolder(ResourceLocation.parse("farmersdelight:nourishment"))
                    .ifPresent(nourishment -> RicePudingMilkshake.effect(() -> new MobEffectInstance(nourishment, 900, 0), 1.0F));
            RICE_PUDING_MILKSHAKE = RicePudingMilkshake.build();

            var MazapanMilkshake = (new FoodProperties.Builder()).nutrition(3).saturationModifier(1.2f).alwaysEdible().fast()
                    .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 1200, 1), 1.0F);
            BuiltInRegistries.MOB_EFFECT.getHolder(ResourceLocation.parse("farmersdelight:nourishment"))
                    .ifPresent(nourishment -> MazapanMilkshake.effect(() -> new MobEffectInstance(nourishment, 900, 0), 1.0F));
            MAZAPAN_MILKSHAKE = MazapanMilkshake.build();

            var WalnutMilkshake = (new FoodProperties.Builder()).nutrition(3).saturationModifier(1.2f).alwaysEdible().fast()
                    .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2100, 0), 1.0F);
            BuiltInRegistries.MOB_EFFECT.getHolder(ResourceLocation.parse("farmersdelight:nourishment"))
                    .ifPresent(nourishment -> WalnutMilkshake.effect(() -> new MobEffectInstance(nourishment, 900, 0), 1.0F));
            WALNUT_MILKSHAKE = WalnutMilkshake.build();

            var ZuesPrayerMilkshake = (new FoodProperties.Builder()).nutrition(3).saturationModifier(1.2f).alwaysEdible().fast()
                    .effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 9000, 1), 1.0F);
            BuiltInRegistries.MOB_EFFECT.getHolder(ResourceLocation.parse("farmersdelight:nourishment"))
                    .ifPresent(nourishment -> ZuesPrayerMilkshake.effect(() -> new MobEffectInstance(nourishment, 300, 0), 1.0F));
            VANILLA_WITH_CHERRIES_MILKSHAKE = ZuesPrayerMilkshake.build();

            var MamaLuchaMilkshake = (new FoodProperties.Builder()).nutrition(7).saturationModifier(0.7f).alwaysEdible().fast()
                    .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 60, 0), 0.85F)
                    .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 200, 0), 0.30F)
                    .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 900, 0), 0.10F)
                    .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 2900, 1), 0.40F)
                    .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 3600, 1), 0.40F)
                    .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 300, 1), 0.35F)
                    .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2900, 0), 0.35F)
                    .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 3000, 0), 0.35F)
                    .effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 18000, 2), 0.10F);
            BuiltInRegistries.MOB_EFFECT.getHolder(ResourceLocation.parse("farmersdelight:nourishment"))
                    .ifPresent(nourishment -> MamaLuchaMilkshake.effect(() -> new MobEffectInstance(nourishment, 1500, 0), 0.85F));
            THE_SECRET_MILKSHAKE = MamaLuchaMilkshake.build();
        }
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
