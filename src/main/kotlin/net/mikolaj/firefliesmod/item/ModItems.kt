package net.mikolaj.firefliesmod.item

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.mikolaj.firefliesmod.FirefliesMod
import net.mikolaj.firefliesmod.item.custom.BottledFirefliesItem
import net.minecraft.item.Item
import net.minecraft.item.ItemGroups
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier

object ModItems {

    final val RUBY = registerItem("ruby", Item(FabricItemSettings()))
    final val RAW_RUBY = registerItem("raw_ruby", Item(FabricItemSettings()))
    final val BOTTLED_FIREFLIES = registerItem("bottled_fireflies", BottledFirefliesItem())

   private fun registerItem(name: String, item: Item): Item {
       return Registry.register(Registries.ITEM, Identifier(FirefliesMod.MOD_ID, name), item)
   }

    private fun addItemsToIngredientItemGroup(entries: FabricItemGroupEntries) {
        entries.add(RUBY)
        entries.add((RAW_RUBY))
        entries.add(BOTTLED_FIREFLIES)
    }

    fun registerModItems() {
        FirefliesMod.LOGGER.info("Registering Mod Items for ${FirefliesMod.MOD_ID}")
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup)
    }
}