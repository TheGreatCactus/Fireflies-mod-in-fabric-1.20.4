package net.mikolaj.firefliesmod.mixin

import com.mojang.blaze3d.systems.RenderSystem
import net.minecraft.client.gui.DrawContext
import net.minecraft.util.Identifier
import org.spongepowered.asm.mixin.Mixin
import org.spongepowered.asm.mixin.injection.At
import org.spongepowered.asm.mixin.injection.Inject
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo


@Mixin(DrawContext::class)
class MixinDrawContext {
    @Inject(method = ["drawTexturedQuad(Lnet/minecraft/util/Identifier;IIIIIFFFF)V"], at = [At("HEAD")])
    fun drawTexturedQuad(
        texture: Identifier?,
        x1: Int,
        x2: Int,
        y1: Int,
        y2: Int,
        z: Int,
        u1: Float,
        u2: Float,
        v1: Float,
        v2: Float,
        ci: CallbackInfo?
    ) {
        RenderSystem.enableBlend()
    }

    @Inject(method = ["drawTexturedQuad(Lnet/minecraft/util/Identifier;IIIIIFFFFFFFF)V"], at = [At("HEAD")])
    fun drawTexturedQuad(
        texture: Identifier?,
        x1: Int,
        x2: Int,
        y1: Int,
        y2: Int,
        z: Int,
        u1: Float,
        u2: Float,
        v1: Float,
        v2: Float,
        red: Float,
        green: Float,
        blue: Float,
        alpha: Float,
        ci: CallbackInfo?
    ) {
        RenderSystem.enableBlend()
    }
}