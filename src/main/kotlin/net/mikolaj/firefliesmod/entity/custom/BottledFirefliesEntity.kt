package net.mikolaj.firefliesmod.entity.custom

import net.mikolaj.firefliesmod.entity.ModEntities
import net.minecraft.entity.EntityType
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.projectile.thrown.ThrownItemEntity
import net.minecraft.item.Item
import net.minecraft.util.hit.HitResult
import net.minecraft.world.World

class BottledFirefliesEntity : ThrownItemEntity {

    constructor(entityType: EntityType<out BottledFirefliesEntity> = ModEntities.BOTTLED_FIREFLIES_ENTITY, world: World) : super(entityType, world)

    constructor(entityType : EntityType<out BottledFirefliesEntity> = ModEntities.BOTTLED_FIREFLIES_ENTITY, owner: LivingEntity, world: World) : super(entityType, owner, world)

    override fun getDefaultItem(): Item? {
        return null
    }

    override fun onCollision(hitResult: HitResult?) {
        super.onCollision(hitResult)
        if (!this.world.isClient) {
            this.world.createExplosion(this, this.x, this.y, this.z, 3F, true, World.ExplosionSourceType.BLOW)
        }
    }

}