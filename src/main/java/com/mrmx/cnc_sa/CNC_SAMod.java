package com.mrmx.cnc_sa;

import com.mrmx.cnc_sa.item.SA_ModItems;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import org.apache.maven.artifact.versioning.VersionRange;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(CNC_SAMod.MODID)
public class CNC_SAMod {
    public static final String MODID = "cnc_sa"; // Define mod id in a common place for everything to reference

    public CNC_SAMod(IEventBus modEventBus) {
        SA_ModItems.register(modEventBus);
    }

    public static boolean isModInVersionRange(String modId, String versionRangeSpec) {
        return ModList.get().getModContainerById(modId).map(container -> {
            try {
                VersionRange range = VersionRange.createFromVersionSpec(versionRangeSpec);
                return range.containsVersion(container.getModInfo().getVersion());
            } catch (Exception e) {
                return false;
            }
        }).orElse(false);
    }
}
