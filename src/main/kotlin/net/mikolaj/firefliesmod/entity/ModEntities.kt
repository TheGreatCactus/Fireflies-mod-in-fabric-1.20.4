package net.mikolaj.firefliesmod.mixin

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
        BottledFirefliesEntity::class.java::newInstance, 0.25f,0.25f)

    fun <T : Entity>registerEntity(name: String, entity: KFunction0<T>, x: Float, y: Float): EntityType<T> {
         val type = Registry.register<EntityType<*>, EntityType<T>>(
            Registries.ENTITY_TYPE,
            Identifier(FirefliesMod.MOD_ID, name),
            FabricEntityTypeBuilder.create<T>(SpawnGroup.MISC, entity as EntityType.EntityFactory<T>)
                .dimensions(EntityDimensions.fixed(x, y)).build()
        )
        return type
    }
}
