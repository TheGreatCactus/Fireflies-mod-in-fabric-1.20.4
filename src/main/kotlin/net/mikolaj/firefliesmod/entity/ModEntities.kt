package net.mikolaj.firefliesmod.entity

import net.mikolaj.firefliesmod.FirefliesMod
import net.mikolaj.firefliesmod.entity.custom.BottledFirefliesEntity
import net.mikolaj.firefliesmod.entity.custom.FirefliesEntity
import net.mikolaj.firefliesmod.entity.custom.SigmaEntity
import net.mikolaj.firefliesmod.platform.PlatformRegistry
import net.minecraft.entity.EntityType
import net.minecraft.entity.SpawnGroup
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.util.Identifier

object ModEntities : PlatformRegistry<Registry<EntityType<*>>, RegistryKey<Registry<EntityType<*>>>, EntityType<*>>() {
    override val registry : Registry<EntityType<*>> = Registries.ENTITY_TYPE
    override val registryKey : RegistryKey<Registry<EntityType<*>>> = RegistryKeys.ENTITY_TYPE

    @JvmField
    val BOTTLED_FIREFLIES_KEY = Identifier(FirefliesMod.MOD_ID, "bottled_fireflies_entity")
    @JvmField
    val BOTTLED_FIREFLIES_ENTITY : EntityType<BottledFirefliesEntity> = this.create(
        BOTTLED_FIREFLIES_KEY.path,
        EntityType.Builder.create({ _, world -> BottledFirefliesEntity(world) }, SpawnGroup.MISC)
            .setDimensions(1f,1f).build(BOTTLED_FIREFLIES_KEY.toString())
    )


    @JvmField
    val SIGMA_ENTITY_KEY = Identifier(FirefliesMod.MOD_ID, "sigma_entity")
    @JvmField
    val SIGMA_ENTITY = this.create(
        SIGMA_ENTITY_KEY.path,
        EntityType.Builder.create(::SigmaEntity, SpawnGroup.MISC)
            .setDimensions(1f,1f).build(SIGMA_ENTITY_KEY.toString())
    )

    @JvmField
    val FIREFLIES_ENTITY_KEY = Identifier(FirefliesMod.MOD_ID, "fireflies_entity")
    @JvmField
    val FIREFLIES_ENTITY : EntityType<FirefliesEntity> = create(
        FIREFLIES_ENTITY_KEY.path,
        EntityType.Builder.create({ _, world -> FirefliesEntity(world) }, SpawnGroup.MISC)
            .setDimensions(1f, 1f).build(FIREFLIES_ENTITY_KEY.toString())
    )

    fun registerEntityTypes() {
        ModEntities.register { identifier, type -> Registry.register(registry, identifier, type) }
    }
}
