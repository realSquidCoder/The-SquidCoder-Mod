package com.SquidCoder.squidcoder.setup;

import com.SquidCoder.squidcoder.data.ModSoundEvents;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;

import java.util.function.Supplier;

public class ModSoundType extends ForgeSoundType {

    public static final ForgeSoundType COPPER = new ForgeSoundType(1F,1.5F,
            ModSoundEvents.COPPER_BREAK,
            ModSoundEvents.COPPER_STEP,
            ModSoundEvents.COPPER_PLACE,
            ModSoundEvents.COPPER_HIT,
            ModSoundEvents.COPPER_FALL);

    public static final ForgeSoundType AMETHYST = new ForgeSoundType(1F,1.5F,
            ModSoundEvents.AMETHYST_BREAK,
            ModSoundEvents.AMETHYST_STEP,
            ModSoundEvents.AMETHYST_PLACE,
            ModSoundEvents.AMETHYST_HIT,
            ModSoundEvents.AMETHYST_FALL);

    public static final ForgeSoundType AMETHYST_CLUSTER = new ForgeSoundType(1F,1.5F,
            ModSoundEvents.AMETHYST_CLUSTER_BREAK,
            ModSoundEvents.AMETHYST_CLUSTER_STEP,
            ModSoundEvents.AMETHYST_CLUSTER_PLACE,
            ModSoundEvents.AMETHYST_CLUSTER_HIT,
            ModSoundEvents.AMETHYST_CLUSTER_FALL);

    public ModSoundType(float volumeIn, float pitchIn, Supplier<SoundEvent> breakSoundIn, Supplier<SoundEvent> stepSoundIn, Supplier<SoundEvent> placeSoundIn, Supplier<SoundEvent> hitSoundIn, Supplier<SoundEvent> fallSoundIn) {
        super(volumeIn, pitchIn, breakSoundIn, stepSoundIn, placeSoundIn, hitSoundIn, fallSoundIn);
    }
}
