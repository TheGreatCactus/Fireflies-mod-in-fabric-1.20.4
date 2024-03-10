package net.mikolaj.firefliesmod.item.custom

import net.mikolaj.firefliesmod.entity.custom.BottledFirefliesEntity
import net.minecraft.item.Item
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.entity.projectile.thrown.ThrownItemEntity
import net.minecraft.item.ItemStack
import net.minecraft.item.ItemUsageContext
import net.minecraft.util.Hand
import net.minecraft.util.TypedActionResult
import net.minecraft.world.World

class BottledFirefliesItem : Item(Settings()) {
    override fun use(world: World, user: PlayerEntity, hand: Hand): TypedActionResult<ItemStack> {
        if (!world.isClient) {
            val bottledFirefliesEntity = BottledFirefliesEntity(user, world)
            bottledFirefliesEntity.setItem(ItemStack(this))
            bottledFirefliesEntity.setVelocity(user, user.pitch, user.yaw, -5.0f, 2.2f, 1.0f)
            world.spawnEntity(bottledFirefliesEntity)

        }
        return TypedActionResult.success(user.getStackInHand(hand), world.isClient)

    }
}