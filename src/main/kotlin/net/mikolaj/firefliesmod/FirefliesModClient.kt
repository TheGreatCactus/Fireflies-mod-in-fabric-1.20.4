package net.mikolaj.firefliesmod

import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry
import net.mikolaj.firefliesmod.entity.ModEntities
import net.mikolaj.firefliesmod.entity.client.BottledFirefliesModel
import net.mikolaj.firefliesmod.entity.client.BottledFirefliesRenderer
import net.mikolaj.firefliesmod.entity.client.ModModelLayers
import net.minecraft.client.render.entity.FlyingItemEntityRenderer

object FirefliesModClient : ClientModInitializer {
    override fun onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.SIGMA_ENTITY, ::FlyingItemEntityRenderer)

        EntityRendererRegistry.register(ModEntities.BOTTLED_FIREFLIES_ENTITY, ::BottledFirefliesRenderer);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.BOTTLED_FIREFLIES, BottledFirefliesModel::texturedModelData);
    }
}