package com.SquidCoder.squidcoder.setup;

import java.util.function.Supplier;

import com.Squidcoder.squidcoder.SquidCoderMod;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeMaker;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBiomes {
  	// Add more biomes here!
  	static {
  		createBiome("lush_caves_biome", BiomeMaker::theVoidBiome);
  	}
  
  	// (and also here!)
  	public static RegistryKey<Biome> LUSH_CAVES_BIOME = registerBiome("lush_caves_biome");
  
  	public static RegistryKey<Biome> registerBiome(String biomeName) {
  		return RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation(TutorialMod.MOD_ID, biomeName));
  	}
  
  	public static RegistryObject<Biome> createBiome(String biomeName, Supplier<Biome> biome) {
  		return Registration.BIOMES.register(biomeName, biome);
  	}
  
  	public static void registerBiomes() {
  		BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(LUSH_CAVES_BIOME, 10));
  	}
  	
    public static void register(IEventBus eventBus) {
    }
}}
