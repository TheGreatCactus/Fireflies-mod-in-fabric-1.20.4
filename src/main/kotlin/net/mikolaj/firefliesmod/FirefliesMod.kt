package net.mikolaj.firefliesmod

import net.fabricmc.api.ModInitializer
import net.mikolaj.firefliesmod.item.ModItems
import org.slf4j.LoggerFactory
import net.mikolaj.firefliesmod.entity.ModEntities
import net.mikolaj.firefliesmod.item.ModItemGroups
import net.minecraft.registry.Registry

object FirefliesMod : ModInitializer {
	const val MOD_ID = "firefliesmod"
	val LOGGER = LoggerFactory.getLogger(MOD_ID)

	override fun onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		ModItems.registerModItems()
		ModItemGroups.registerItemGroups()
		ModEntities.registerEntityTypes()
	}
}