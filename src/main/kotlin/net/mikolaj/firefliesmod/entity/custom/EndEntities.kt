package net.mikolaj.firefliesmod.entity.custom

import net.fabricmc.fabric.api.`object`.builder.v1.entity.FabricDefaultAttributeRegistry
import net.minecraft.entity.Entity
import net.minecraft.entity.EntityType
import net.minecraft.registry.Registry
import net.fabricmc.fabric.api.`object`.builder.v1.entity.FabricEntityTypeBuilder
import net.mikolaj.firefliesmod.FirefliesMod
import net.minecraft.entity.EntityDimensions
import net.minecraft.entity.SpawnGroup

object EndEntities {
    internal fun <T : Entity?> register(
        name: String?,
        group: SpawnGroup,
        width: Float,
        height: Float,
        entity: EntityType.EntityFactory<T>?
    ): EntityType<T> {
        val type: EntityType<T> = FabricEntityTypeBuilder
            .create(group, entity)
            .dimensions(EntityDimensions.fixed(width, height))
            .build()
        return if (Configs.ENTITY_CONFIG.getBooleanRoot(id.getPath(), true)) {
            Registry.register<EntityType<T>, EntityType<T>>(
                BuiltInRegistries.ENTITY_TYPE,
                id,
                type
            )
        } else type
    }
}