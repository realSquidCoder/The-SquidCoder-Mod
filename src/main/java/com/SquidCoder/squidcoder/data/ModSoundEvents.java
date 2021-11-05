package com.SquidCoder.squidcoder.data;

import com.SquidCoder.squidcoder.SquidCoderMod;
import com.SquidCoder.squidcoder.setup.Registration;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;

public class ModSoundEvents {

    public static final RegistryObject<SoundEvent> COPPER_BREAK =
            registerSoundEvent("copper.break");
    public static final RegistryObject<SoundEvent> COPPER_STEP =
            registerSoundEvent("copper.step");


    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        return Registration.SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(SquidCoderMod.MOD_ID, name)));
    }

    public static void register(){}
}
