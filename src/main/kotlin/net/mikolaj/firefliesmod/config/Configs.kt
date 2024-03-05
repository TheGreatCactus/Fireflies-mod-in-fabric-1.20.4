package net.mikolaj.firefliesmod.config


object Configs {
    val ENTITY_CONFIG: PathConfig = PathConfig(BetterEnd.MOD_ID, "entities")
    val BLOCK_CONFIG: PathConfig = PathConfig(BetterEnd.MOD_ID, "blocks")
    val ITEM_CONFIG: PathConfig = PathConfig(BetterEnd.MOD_ID, "items")
    val BIOME_CONFIG: IdConfig = EntryConfig(BetterEnd.MOD_ID, "biomes")
    val GENERATOR_CONFIG: PathConfig = PathConfig(BetterEnd.MOD_ID, "generator", false)
    val RECIPE_CONFIG: PathConfig = PathConfig(BetterEnd.MOD_ID, "recipes")
    val ENCHANTMENT_CONFIG: PathConfig = PathConfig(BetterEnd.MOD_ID, "enchantments")
    val CLENT_CONFIG: PathConfig = PathConfig(BetterEnd.MOD_ID, "client", false)
    fun saveConfigs() {
        ENTITY_CONFIG.saveChanges()
        BLOCK_CONFIG.saveChanges()
        BIOME_CONFIG.saveChanges()
        ITEM_CONFIG.saveChanges()
        GENERATOR_CONFIG.saveChanges()
        RECIPE_CONFIG.saveChanges()
        ENCHANTMENT_CONFIG.saveChanges()
        if (BCLib.isClient()) {
            CLENT_CONFIG.saveChanges()
        }
    }
}
