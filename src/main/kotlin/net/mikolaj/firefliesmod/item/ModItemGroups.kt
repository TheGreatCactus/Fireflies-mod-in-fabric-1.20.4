package net.kaupenjoe.tutorialmod.item

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.mikolaj.firefliesmod.FirefliesMod
import net.mikolaj.firefliesmod.item.ModItems
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.text.Text
import net.minecraft.util.Identifier

object ModItemGroups {
    val RUBY_GROUP = Registry.register<ItemGroup, ItemGroup>(
        Registries.ITEM_GROUP, Identifier(FirefliesMod.MOD_ID, "ruby"),
        FabricItemGroup.builder().displayName(Text.translatable("itemgroup.ruby"))
            .icon { ItemStack(ModItems.RUBY) }
            .entries { displayContext: ItemGroup.DisplayContext?, entries: ItemGroup.Entries ->
                entries.add(ModItems.RUBY)
                entries.add(ModItems.RAW_RUBY)
                entries.add(Items.DIAMOND)
            }.build()
    )

    fun registerItemGroups() {
        FirefliesMod.LOGGER.info("Registering Item Groups for " + FirefliesMod.MOD_ID)
    }
}