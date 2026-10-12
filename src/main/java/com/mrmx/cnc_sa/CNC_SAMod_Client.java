package com.mrmx.cnc_sa;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod(value = CNC_SAMod.MODID, dist = Dist.CLIENT) // This class will not load on dedicated servers. Accessing client side code from here is safe.
public class CNC_SAMod_Client {
    public CNC_SAMod_Client(ModContainer container) {
    }
}