public class ModConfiguredFeatures {

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> REDWOOD =
            register("redwood", Feature.TREE.withConfiguration((
                        new BaseTreeFeatureConfig.Builder(
                            new SimpleBlockStateProvider(ModBlocks.REDWOOD_LOG.get().getDefaultState()),/*trunkProvider*/
                            new SimpleBlockStateProvider(ModBlocks.REDWOOD_LEAVES.get().getDefaultState()),/*leavesProvider*/
                            new BlobFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3),/*Offset, Radius, Height*/
                            new StraightTrunkPlacer(6, 4, 3),/*baseHeight, heightRandA, heightRandB*/
                            new TwoLayerFeature(1, 0, 1)))/*limit, lowerSize, upperSize*/
                                    .setIgnoreVines()
                                    .build()));


    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String key,
                                                                                 ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, key, configuredFeature);
   