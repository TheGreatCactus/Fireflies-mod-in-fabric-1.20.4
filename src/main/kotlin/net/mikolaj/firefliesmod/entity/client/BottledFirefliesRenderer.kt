package net.mikolaj.firefliesmod.entity.client

import net.mikolaj.firefliesmod.FirefliesMod
import net.mikolaj.firefliesmod.entity.custom.BottledFirefliesEntity
import net.minecraft.client.render.OverlayTexture
import net.minecraft.client.render.VertexConsumerProvider
import net.minecraft.client.render.entity.*
import net.minecraft.client.render.entity.feature.FeatureRendererContext
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.util.Identifier

class BottledFirefliesRenderer(context : EntityRendererFactory.Context) :
    EntityRenderer<BottledFirefliesEntity>(context, ),
    FeatureRendererContext<BottledFirefliesEntity, BottledFirefliesModel> {
        val context  = context
        val TEXTURE : Identifier = Identifier(FirefliesMod.MOD_ID, "textures/entity/bottled_fireflies.png")

    override fun getTexture(entity: BottledFirefliesEntity?): Identifier? {
        return TEXTURE
    }

    override fun render(entity: BottledFirefliesEntity?, yaw : Float, partialTicks : Float, poseStack : MatrixStack, vertexConsumerProvider : VertexConsumerProvider, packedLight : Int) {
        val buffer = vertexConsumerProvider.getBuffer(this.model.getLayer(getTexture(entity)))

        this.model.render(poseStack, buffer, packedLight, OverlayTexture.DEFAULT_UV, 1f, 1f, 1f, 0.5f)
        super.render(entity, yaw, partialTicks, poseStack, vertexConsumerProvider, packedLight)
    }

    override fun getModel(): BottledFirefliesModel {
        return BottledFirefliesModel(context.getPart(ModModelLayers.BOTTLED_FIREFLIES))
    }

}