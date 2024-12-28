package com.kludwisz.anticracker.mixin;

import com.kludwisz.anticracker.SeedHash;

import net.minecraft.world.gen.chunk.ChunkGenerator;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin(ChunkGenerator.class)
public class StrongholdSeedMixin {
    @Redirect(at = @At(value = "INVOKE", target = "Ljava/util/Random;setSeed(J)V"), method = "method_28509")
    private void setStrongholdSeed(Random instance, long seed) {
        long scrambledSeed = SeedHash.scramble(seed, SeedHash.Type.STRONGHOLDS);
        instance.setSeed(scrambledSeed);
    }
}
