package net.mikolaj.firefliesmod.entity.client

import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.mikolaj.firefliesmod.entity.custom.SigmaEntity
import net.minecraft.client.render.OverlayTexture
import net.minecraft.client.render.VertexConsumerProvider
import net.minecraft.client.render.entity.EntityRendererFactory
import net.minecraft.client.render.entity.FlyingItemEntityRenderer
import net.minecraft.client.render.item.ItemRenderer
import net.minecraft.client.render.model.json.ModelTransformation
import net.minecraft.client.render.model.json.ModelTransformationMode
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.util.math.MathHelper
import net.minecraft.util.math.RotationAxis

@Environment(EnvType.CLIENT)
class SigmaRenderer(context: EntityRendererFactory.Context) : FlyingItemEntityRenderer<SigmaEntity>(context) {

    private val itemRenderer: ItemRenderer

    init {
        this.itemRenderer = context.itemRenderer
    }

    override fun render(
        entityIn: SigmaEntity, entityYaw: Float, partialTicks: Float, matrixStackIn: MatrixStack,
        bufferIn: VertexConsumerProvider, packedLightIn: Int
    ) {
        val degrees: Float = (entityIn.age + partialTicks)*50f
        val scale = 0.75f
        matrixStackIn.push()
        matrixStackIn.translate(0f, 2f, 0.0f)
        matrixStackIn.multiply(
            RotationAxis.POSITIVE_Y.rotationDegrees(
                MathHelper.lerp(
                    partialTicks,
                    entityIn.prevYaw,
                    entityIn.yaw
                ) - 90.0f
            )
        )
        matrixStackIn.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-degrees))
        matrixStackIn.scale(scale, scale, scale)
        val count: Int = entityIn.stack.count
        this.itemRenderer.renderItem(
            entityIn.stack, ModelTransformationMode.FIXED, packedLightIn,
            OverlayTexture.DEFAULT_UV, matrixStackIn, bufferIn, entityIn.world, entityIn.id
        )
        if (count > 32) {
            matrixStackIn.translate(-0.05f, -0.05f, -0.05f)
            this.itemRenderer.renderItem(
                entityIn.stack, ModelTransformationMode.FIXED,
                packedLightIn, OverlayTexture.DEFAULT_UV, matrixStackIn, bufferIn, entityIn.world, entityIn.id
            )
        }
        matrixStackIn.pop()
    }
}
