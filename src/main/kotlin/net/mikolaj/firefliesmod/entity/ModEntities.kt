package net.mikolaj.firefliesmod.entity

import kotlinx.coroutines.withTimeout
import net.fabricmc.fabric.api.`object`.builder.v1.entity.FabricEntityTypeBuilder
import net.mikolaj.firefliesmod.FirefliesMod
import net.mikolaj.firefliesmod.entity.custom.BottledFirefliesEntity
import net.minecraft.entity.Entity
import net.minecraft.entity.EntityDimensions
import net.minecraft.entity.EntityType
import net.minecraft.entity.SpawnGroup
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier
import kotlin.reflect.KFunction0

object ModEntities {
    val BOTTLED_FIREFLIES_ENTITY : EntityType<BottledFirefliesEntity> = registerEntity("bottled_fireflies_entity",
        BottledFirefliesEntity, 0.25f,0.25f)

    fun <T : Entity>registerEntity(name: String, entity: T, x: Float, y: Float): EntityType<T> {
         val type = Registry.register<EntityType<*>, EntityType<T>>(
            Registries.ENTITY_TYPE,
            Identifier(FirefliesMod.MOD_ID, name),
            FabricEntityTypeBuilder.create<T>(SpawnGroup.MISC, EntityType.EntityFactory())
                .dimensions(EntityDimensions.fixed(x, y)).build()
        )
        return type
    }
}
