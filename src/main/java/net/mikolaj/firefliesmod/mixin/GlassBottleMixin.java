package net.mikolaj.firefliesmod.mixin;

import net.mikolaj.firefliesmod.entity.custom.FirefliesEntity;
import net.mikolaj.firefliesmod.item.ModItems;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.GlassBottleItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(GlassBottleItem.class)
public abstract class GlassBottleMixin implements GlassBottleInvoker {

    //@Shadow protected abstract ItemStack fill(ItemStack stack, PlayerEntity player, ItemStack outputStack);

    @Inject(at = @At("HEAD"), method = "use")
    void use_HEAD_FirefliesMod(World world, PlayerEntity user, Hand hand, CallbackInfoReturnable cir) {
        List<FirefliesEntity> list = world.getEntitiesByClass(FirefliesEntity.class, user.getBoundingBox().expand(2.0), entity -> entity != null && entity.isAlive());

        ItemStack itemStack = user.getStackInHand(hand);
        if (!list.isEmpty()) {
            FirefliesEntity firefliesEntity = list.get(0);
            firefliesEntity.setSize(firefliesEntity.getSize() - 1);
            world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ITEM_BOTTLE_FILL_DRAGONBREATH, SoundCategory.NEUTRAL, 1.0f, 1.0f);
            world.emitGameEvent((Entity)user, GameEvent.FLUID_PICKUP, user.getPos());
            if (user instanceof ServerPlayerEntity) {
                ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity)user;
                Criteria.PLAYER_INTERACTED_WITH_ENTITY.trigger(serverPlayerEntity, itemStack, firefliesEntity);
            }
            TypedActionResult.success(callFill(itemStack, user, new ItemStack(ModItems.INSTANCE.getBOTTLED_FIREFLIES())), world.isClient());
        }
    }

}
