package com.SquidCoder.squidcoder.data;

import com.SquidCoder.squidcoder.SquidCoderMod;
import com.SquidCoder.squidcoder.setup.Registration;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;

public class ModSoundEvents {

    public static final RegistryObject<SoundEvent> COPPER_BREAK =
            registerSoundEvent("block.copper.break");
    public static final RegistryObject<SoundEvent> COPPER_STEP =
            registerSoundEvent("block.copper.step");
    public static final RegistryObject<SoundEvent> COPPER_PLACE =
            registerSoundEvent("block.copper.place");
    public static final RegistryObject<SoundEvent> COPPER_HIT =
            registerSoundEvent("block.copper.hit");
    public static final RegistryObject<SoundEvent> COPPER_FALL =
            registerSoundEvent("block.copper.fall");

    public static final RegistryObject<SoundEvent> AMETHYST_BREAK =
            registerSoundEvent("block.amethyst_block.break");
    public static final RegistryObject<SoundEvent> AMETHYST_STEP =
            registerSoundEvent("block.amethyst_block.step");
    public static final RegistryObject<SoundEvent> AMETHYST_PLACE =
            registerSoundEvent("block.amethyst_block.place");
    public static final RegistryObject<SoundEvent> AMETHYST_HIT =
            registerSoundEvent("block.amethyst_block.hit");
    public static final RegistryObject<SoundEvent> AMETHYST_FALL =
            registerSoundEvent("block.amethyst_block.fall");

    public static final RegistryObject<SoundEvent> AMETHYST_CLUSTER_BREAK =
            registerSoundEvent("block.amethyst_cluster.break");
    public static final RegistryObject<SoundEvent> AMETHYST_CLUSTER_STEP =
            registerSoundEvent("block.amethyst_cluster.step");
    public static final RegistryObject<SoundEvent> AMETHYST_CLUSTER_PLACE =
            registerSoundEvent("block.amethyst_cluster.place");
    public static final RegistryObject<SoundEvent> AMETHYST_CLUSTER_HIT =
            registerSoundEvent("block.amethyst_cluster.hit");
    public static final RegistryObject<SoundEvent> AMETHYST_CLUSTER_FALL =
            registerSoundEvent("block.amethyst_cluster.fall");

    public static final RegistryObject<SoundEvent> SMALL_AMETHYST_BUD_BREAK =
            registerSoundEvent("block.small_amethyst_bud.break");
    public static final RegistryObject<SoundEvent> SMALL_AMETHYST_BUD_STEP =
            registerSoundEvent("block.small_amethyst_bud.step");
    public static final RegistryObject<SoundEvent> SMALL_AMETHYST_BUD_PLACE =
            registerSoundEvent("block.small_amethyst_bud.place");
    public static final RegistryObject<SoundEvent> SMALL_AMETHYST_BUD_HIT =
            registerSoundEvent("block.small_amethyst_bud.hit");
    public static final RegistryObject<SoundEvent> SMALL_AMETHYST_BUD_FALL =
            registerSoundEvent("block.small_amethyst_bud.fall");

    public static final RegistryObject<SoundEvent> MEDIUM_AMETHYST_BUD_BREAK =
            registerSoundEvent("block.medium_amethyst_bud.break");
    public static final RegistryObject<SoundEvent> MEDIUM_AMETHYST_BUD_STEP =
            registerSoundEvent("block.medium_amethyst_bud.step");
    public static final RegistryObject<SoundEvent> MEDIUM_AMETHYST_BUD_PLACE =
            registerSoundEvent("block.medium_amethyst_bud.place");
    public static final RegistryObject<SoundEvent> MEDIUM_AMETHYST_BUD_HIT =
            registerSoundEvent("block.medium_amethyst_bud.hit");
    public static final RegistryObject<SoundEvent> MEDIUM_AMETHYST_BUD_FALL =
            registerSoundEvent("block.medium_amethyst_bud.fall");

    public static final RegistryObject<SoundEvent> LARGE_AMETHYST_BUD_BREAK =
            registerSoundEvent("block.large_amethyst_bud.break");
    public static final RegistryObject<SoundEvent> LARGE_AMETHYST_BUD_STEP =
            registerSoundEvent("block.large_amethyst_bud.step");
    public static final RegistryObject<SoundEvent> LARGE_AMETHYST_BUD_PLACE =
            registerSoundEvent("block.large_amethyst_bud.place");
    public static final RegistryObject<SoundEvent> LARGE_AMETHYST_BUD_HIT =
            registerSoundEvent("block.large_amethyst_bud.hit");
    public static final RegistryObject<SoundEvent> LARGE_AMETHYST_BUD_FALL =
            registerSoundEvent("block.large_amethyst_bud.fall");


    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        return Registration.SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(SquidCoderMod.MOD_ID, name)));
    }

    public static void register(){}
}
