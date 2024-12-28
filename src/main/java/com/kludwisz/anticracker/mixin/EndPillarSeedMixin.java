package com.kludwisz.anticracker.mixin;

import com.kludwisz.anticracker.SeedHash;
import net.minecraft.world.gen.feature.EndSpikeFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;


@Mixin(EndSpikeFeature.class)
public class EndPillarSeedMixin {
    @ModifyVariable(method = "getSpikes", at = @At("STORE"), ordinal = 0)
    private static long modifyPillarSeed(long l) {
        return l ^ SeedHash.getWorldSeedHash(0);
    }
}
