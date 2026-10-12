package com.mrmx.cnc_sa;

import com.mrmx.cnc_sa.item.SA_ModItems;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(CNC_SAMod.MODID)
public class CNC_SAMod {
    public static final String MODID = "cnc_sa"; // Define mod id in a common place for everything to reference

    public CNC_SAMod(IEventBus modEventBus) {
        SA_ModItems.register(modEventBus);
    }
}
