package com.kludwisz.anticracker.mixin;

import com.kludwisz.anticracker.SeedHash;
import net.minecraft.world.gen.ChunkRandom;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(ChunkRandom.class)
public class ChunkRandomMixin extends Random {
    @Inject(at = @At("RETURN"), method = "setPopulationSeed", cancellable = true)
    private void popseedRet(CallbackInfoReturnable<Long> cir) {
        long scrambledSeed = cir.getReturnValue() ^ SeedHash.getWorldSeedHash(2);
        setSeed(scrambledSeed);
        cir.setReturnValue(scrambledSeed);
    }

    @Inject(at = @At("RETURN"), method = "setRegionSeed", cancellable = true)
    private void regionseedRet(CallbackInfoReturnable<Long> cir) {
        long scrambledSeed = cir.getReturnValue() ^ SeedHash.getWorldSeedHash(3);
        setSeed(scrambledSeed);
        cir.setReturnValue(scrambledSeed);
    }

    @Inject(at = @At("RETURN"), method = "setCarverSeed", cancellable = true)
    private void carverseedRet(CallbackInfoReturnable<Long> cir) {
        long scrambledSeed = cir.getReturnValue() ^ SeedHash.getWorldSeedHash(4);
        setSeed(scrambledSeed);
        cir.setReturnValue(scrambledSeed);
    }
}
