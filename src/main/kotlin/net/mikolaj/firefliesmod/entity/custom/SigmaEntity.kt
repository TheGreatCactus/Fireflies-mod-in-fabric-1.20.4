package net.mikolaj.firefliesmod.entity.custom

import net.mikolaj.firefliesmod.entity.ModEntities
import net.mikolaj.firefliesmod.item.ModItems
import net.minecraft.entity.EntityType
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.projectile.thrown.ThrownItemEntity
import net.minecraft.item.Item
import net.minecraft.network.listener.ClientPlayPacketListener
import net.minecraft.network.packet.Packet
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.world.World


class SigmaEntity : ThrownItemEntity {
    constructor(entityType: EntityType<out ThrownItemEntity?>?, world: World?) : super(entityType, world)
    constructor(livingEntity: LivingEntity?, world: World?) : super(ModEntities.SIGMA_ENTITY, livingEntity, world)

    override fun getDefaultItem(): Item {
        return ModItems.SIGMA_ITEM
    }

    override fun createSpawnPacket(): Packet<ClientPlayPacketListener> {
        return EntitySpawnS2CPacket(this)
    }
}