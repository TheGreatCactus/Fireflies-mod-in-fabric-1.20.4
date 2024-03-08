package net.mikolaj.firefliesmod.entity

import kotlinx.coroutines.withTimeout
import net.fabricmc.fabric.api.`object`.builder.v1.entity.FabricEntityTypeBuilder
import net.mikolaj.firefliesmod.FirefliesMod
import net.mikolaj.firefliesmod.entity.custom.BottledFirefliesEntity
import net.mikolaj.firefliesmod.platform.PlatformRegistry
import net.minecraft.entity.Entity
import net.minecraft.entity.EntityDimensions
import net.minecraft.entity.EntityType
import net.minecraft.entity.SpawnGroup
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.util.Identifier
import net.minecraft.world.World
import kotlin.reflect.KFunction0

object ModEntities : PlatformRegistry<Registry<EntityType<*>>, RegistryKey<Registry<EntityType<*>>>, EntityType<*>>() {
    override val registry : Registry<EntityType<*>> = Registries.ENTITY_TYPE
    override val registryKey : RegistryKey<Registry<EntityType<*>>> = RegistryKeys.ENTITY_TYPE

    @JvmField
    val BOTTLED_FIREFLIES_KEY = Identifier(FirefliesMod.MOD_ID, "bottled_fireflies_entity")
    @JvmField
    val BOTTLED_FIREFLIES_ENTITY : EntityType<BottledFirefliesEntity> = this.create(
        BOTTLED_FIREFLIES_KEY.path,
        EntityType.Builder.create({ _, world -> BottledFirefliesEntity(world) }, SpawnGroup.MISC)
            .build(BOTTLED_FIREFLIES_KEY.toString())
    )

    fun registerEntityTypes() {
        ModEntities.register { identifier, type -> Registry.register(registry, identifier, type) }
    }
}
