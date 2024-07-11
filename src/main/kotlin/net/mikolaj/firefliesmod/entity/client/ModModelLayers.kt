package net.mikolaj.firefliesmod.entity.client

import net.mikolaj.firefliesmod.FirefliesMod
import net.minecraft.client.render.entity.model.EntityModelLayer
import net.minecraft.util.Identifier

object ModModelLayers {
    val BOTTLED_FIREFLIES = EntityModelLayer(Identifier(FirefliesMod.MOD_ID, "bottled_fireflies"), "main")
}