package net.mikolaj.firefliesmod

import net.fabricmc.api.ModInitializer
import net.kaupenjoe.tutorialmod.item.ModItemGroups
import net.mikolaj.firefliesmod.item.ModItems
import org.slf4j.LoggerFactory
import net.mikolaj.firefliesmod.entity.ModEntities
import net.minecraft.registry.Registry

object FirefliesMod : ModInitializer, FirefliesImplementation {
	const val MOD_ID = "firefliesmod"
	val LOGGER = LoggerFactory.getLogger(MOD_ID)

	override fun onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		ModItems.registerModItems()
		ModItemGroups.registerItemGroups()
	}

	override fun registerEntityTypes() {
		ModEntities.register { identifier, type -> Registry.register(ModEntities.registry, identifier, type) }
	}
}