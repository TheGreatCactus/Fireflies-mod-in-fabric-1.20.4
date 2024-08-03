package net.mikolaj.firefliesmod.entity.client

import com.mojang.blaze3d.systems.RenderSystem
import net.mikolaj.firefliesmod.FirefliesMod
import net.mikolaj.firefliesmod.entity.custom.BottledFirefliesEntity
import net.minecraft.client.render.OverlayTexture
import net.minecraft.client.render.RenderLayer
import net.minecraft.client.render.VertexConsumerProvider
import net.minecraft.client.render.entity.*
import net.minecraft.client.render.entity.feature.FeatureRendererContext
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.util.Identifier
import net.minecraft.util.math.*
import org.joml.Vector3f

class BottledFirefliesRenderer(context : EntityRendererFactory.Context) :
    EntityRenderer<BottledFirefliesEntity>(context, ),
    FeatureRendererContext<BottledFirefliesEntity, BottledFirefliesModel> {
        val context  = context
        val TEXTURE : Identifier = Identifier(FirefliesMod.MOD_ID, "textures/entity/bottled_fireflies.png")

    override fun getTexture(entity: BottledFirefliesEntity?): Identifier? {
        return TEXTURE
    }

    override fun getBlockLight(entity: BottledFirefliesEntity?, pos: BlockPos?): Int {
        return 15
    }

    override fun render(entity: BottledFirefliesEntity, yaw : Float, partialTicks : Float, poseStack : MatrixStack, vertexConsumerProvider : VertexConsumerProvider, packedLight : Int) {
        val buffer = vertexConsumerProvider.getBuffer(RenderLayer.getEntityTranslucentCull(TEXTURE))
        val degrees = (entity.age +partialTicks)*50f

        poseStack.push()

        poseStack.translate(0f, 0.15f, 0f)
        poseStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(MathHelper.lerp(partialTicks, entity.prevYaw, entity.yaw) - 90f))
        poseStack.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(-degrees))

        this.model.render(poseStack, buffer, packedLight, OverlayTexture.DEFAULT_UV, 1f, 1f, 1f, 1f)

        poseStack.pop()
        super.render(entity, yaw, partialTicks, poseStack, vertexConsumerProvider, packedLight)
    }

    override fun getModel(): BottledFirefliesModel {
        return BottledFirefliesModel(context.getPart(ModModelLayers.BOTTLED_FIREFLIES))
    }

}