package net.mikolaj.firefliesmod.entity.custom

import net.mikolaj.firefliesmod.entity.ModEntities
import net.minecraft.entity.EntityType
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.projectile.thrown.ThrownEntity
import net.minecraft.entity.projectile.thrown.ThrownItemEntity
import net.minecraft.item.Item
import net.minecraft.util.hit.HitResult
import net.minecraft.world.World

class BottledFirefliesEntity : ThrownEntity {

    constructor(world: World, entityType: EntityType<out BottledFirefliesEntity> = ModEntities.BOTTLED_FIREFLIES_ENTITY) : super(entityType, world)

    constructor(owner: LivingEntity, world: World, entityType : EntityType<out BottledFirefliesEntity> = ModEntities.BOTTLED_FIREFLIES_ENTITY) : super(entityType, owner, world)

    override fun initDataTracker() {
        TODO("Not yet implemented")
    }

    override fun onCollision(hitResult: HitResult?) {
        super.onCollision(hitResult)
        if (!this.world.isClient) {
            this.world.createExplosion(this, this.x, this.y, this.z, 3F, true, World.ExplosionSourceType.BLOW)
            this.discard()
        }
    }

    override fun getGravity(): Float {
        return 0.05f
    }

}