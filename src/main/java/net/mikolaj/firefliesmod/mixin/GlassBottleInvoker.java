package net.mikolaj.firefliesmod.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.GlassBottleItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.BrewingRecipeRegistry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;


@Mixin(GlassBottleItem.class)
interface GlassBottleInvoker {
    @Invoker("fill")
    ItemStack callFill(ItemStack stack, PlayerEntity player, ItemStack outputStack);
}