package net.mikolaj.firefliesmod.entity.client

import net.mikolaj.firefliesmod.FirefliesMod
import net.mikolaj.firefliesmod.entity.custom.BottledFirefliesEntity
import net.minecraft.client.render.VertexConsumerProvider
import net.minecraft.client.render.entity.EntityRenderer
import net.minecraft.client.render.entity.EntityRendererFactory
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.entity.projectile.thrown.ThrownEntity
import net.minecraft.util.Identifier
import javax.swing.text.html.parser.Entity

class BottledFirefliesRenderer(context : EntityRendererFactory.Context) : EntityRenderer<BottledFirefliesEntity>(context, ) {

    val TEXTURE : Identifier = Identifier(FirefliesMod.MOD_ID, "textures/entity/bottled_fireflies.png")

    override fun getTexture(entity: BottledFirefliesEntity?): Identifier? {
        return TEXTURE
    }

    override fun render(entity: BottledFirefliesEntity?, yaw : Float, partialTicks : Float, poseStack : MatrixStack, buffer : VertexConsumerProvider, packedLight : Int) {

        super.render(entity, yaw, partialTicks, poseStack, buffer, packedLight)
    }

}