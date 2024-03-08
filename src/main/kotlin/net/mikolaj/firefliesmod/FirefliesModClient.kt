package net.mikolaj.firefliesmod

import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry
import net.mikolaj.firefliesmod.entity.custom.BottledFirefliesEntity
import net.mikolaj.firefliesmod.entity.ModEntities
import net.minecraft.client.render.entity.EntityRendererFactory
import net.minecraft.client.render.entity.FlyingItemEntityRenderer
import net.minecraft.entity.FlyingItemEntity

object FirefliesModClient : ClientModInitializer {
    override fun onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.BOTTLED_FIREFLIES_ENTITY,
            ::FlyingItemEntityRenderer
        )
    }
}