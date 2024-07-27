package net.mikolaj.firefliesmod.item.custom

import net.mikolaj.firefliesmod.entity.custom.BottledFirefliesEntity
import net.mikolaj.firefliesmod.entity.custom.SigmaEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.util.Hand
import net.minecraft.util.TypedActionResult
import net.minecraft.world.World
class SigmaItem : Item(Settings()){
    override fun use(world: World, user: PlayerEntity, hand: Hand): TypedActionResult<ItemStack> {
        var itemStack : ItemStack = user.getStackInHand(hand)

        user.itemCooldownManager.set(this, 10)
        if (!world.isClient) {
            val sigmaEntity = SigmaEntity(user, world)
            sigmaEntity.setVelocity(user, user.pitch, user.yaw, -5.0f, 2.2f, 1.0f)
            world.spawnEntity(sigmaEntity)

        }

        if (!user.abilities.creativeMode) {
            itemStack.decrement(1)
        }
        return TypedActionResult.success(user.getStackInHand(hand), world.isClient)

    }
}