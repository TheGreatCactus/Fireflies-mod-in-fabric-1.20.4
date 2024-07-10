// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
package net.mikolaj.firefliesmod.entity.client

import net.minecraft.client.model.*
import net.minecraft.client.render.VertexConsumer
import net.minecraft.client.render.entity.model.EntityModel
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.entity.Entity

class BottledFirefliesModel(root: ModelPart) : EntityModel<Entity?>() {
    private val butelka: ModelPart
    private val butelka1: ModelPart? = null
    private val butelka2: ModelPart? = null
    private val butelka3: ModelPart? = null
    private val butelka4: ModelPart? = null
    private val butelka5: ModelPart? = null
    private val butelka6: ModelPart? = null
    private val naronik1: ModelPart? = null
    private val naronik2: ModelPart? = null
    private val naronik3: ModelPart? = null
    private val naronik4: ModelPart? = null
    private val srodekbutelki: ModelPart
    private val bb_main: ModelPart

    init {
        butelka = root.getChild("butelka")
        srodekbutelki = root.getChild("srodekbutelki")
        bb_main = root.getChild("bb_main")
    }

    override fun setAngles(
        entity: Entity?,
        limbSwing: Float,
        limbSwingAmount: Float,
        ageInTicks: Float,
        netHeadYaw: Float,
        headPitch: Float
    ) {
    }

    override fun render(
        matrices: MatrixStack,
        vertexConsumer: VertexConsumer,
        light: Int,
        overlay: Int,
        red: Float,
        green: Float,
        blue: Float,
        alpha: Float
    ) {
        butelka.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha)
        srodekbutelki.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha)
        bb_main.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha)
    }

    companion object {
        val texturedModelData: TexturedModelData
            get() {
                val modelData = ModelData()
                val modelPartData = modelData.root
                val butelka = modelPartData.addChild(
                    "butelka",
                    ModelPartBuilder.create(),
                    ModelTransform.pivot(0.0f, 24.0f, 0.0f)
                )
                val butelka1 = butelka.addChild(
                    "butelka1",
                    ModelPartBuilder.create().uv(0, 0).cuboid(0.0f, -12.0f, 1.0f, 1.0f, 2.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(0.0f, -10.0f, -2.0f, 1.0f, 2.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(0.0f, -10.0f, 0.0f, 1.0f, 2.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(0.0f, -12.0f, -3.0f, 1.0f, 2.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(0.0f, -8.0f, -3.0f, 1.0f, 1.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(0.0f, -8.0f, 1.0f, 1.0f, 1.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(0.0f, -7.0f, -4.0f, 1.0f, 1.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(0.0f, -7.0f, 2.0f, 1.0f, 1.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(0.0f, -6.0f, -5.0f, 1.0f, 5.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(0.0f, -6.0f, 3.0f, 1.0f, 5.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(0.0f, -1.0f, -4.0f, 1.0f, 1.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(0.0f, -1.0f, 2.0f, 1.0f, 1.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(0.0f, 0.0f, -3.0f, 1.0f, 1.0f, 5.0f, Dilation(0.0f)),
                    ModelTransform.pivot(-1.0f, -1.0f, 0.0f)
                )
                val butelka2 = butelka.addChild(
                    "butelka2",
                    ModelPartBuilder.create().uv(0, 0).cuboid(0.0f, -12.0f, 1.0f, 1.0f, 2.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(0.0f, -10.0f, -2.0f, 1.0f, 2.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(0.0f, -10.0f, 0.0f, 1.0f, 2.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(0.0f, -12.0f, -3.0f, 1.0f, 2.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(0.0f, -8.0f, -3.0f, 1.0f, 1.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(0.0f, -8.0f, 1.0f, 1.0f, 1.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(0.0f, -7.0f, -4.0f, 1.0f, 1.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(0.0f, -7.0f, 2.0f, 1.0f, 1.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(0.0f, -6.0f, -5.0f, 1.0f, 5.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(0.0f, -6.0f, 3.0f, 1.0f, 5.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(0.0f, -1.0f, -4.0f, 1.0f, 1.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(0.0f, -1.0f, 2.0f, 1.0f, 1.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(0.0f, 0.0f, -3.0f, 1.0f, 1.0f, 5.0f, Dilation(0.0f)),
                    ModelTransform.pivot(0.0f, -1.0f, 0.0f)
                )
                val butelka3 = butelka.addChild(
                    "butelka3",
                    ModelPartBuilder.create().uv(0, 0).cuboid(0.0f, -12.0f, 1.0f, 1.0f, 2.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(0.0f, -10.0f, -2.0f, 1.0f, 2.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(0.0f, -10.0f, 0.0f, 1.0f, 2.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(0.0f, -12.0f, -3.0f, 1.0f, 2.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(0.0f, -8.0f, -3.0f, 1.0f, 1.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(0.0f, -8.0f, 1.0f, 1.0f, 1.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(0.0f, -7.0f, -4.0f, 1.0f, 1.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(0.0f, -7.0f, 2.0f, 1.0f, 1.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(0.0f, -6.0f, -5.0f, 1.0f, 5.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(0.0f, -6.0f, 3.0f, 1.0f, 5.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(0.0f, -1.0f, -4.0f, 1.0f, 1.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(0.0f, -1.0f, 2.0f, 1.0f, 1.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(0.0f, 0.0f, -3.0f, 1.0f, 1.0f, 5.0f, Dilation(0.0f)),
                    ModelTransform.pivot(-2.0f, -1.0f, 0.0f)
                )
                val butelka4 = butelka.addChild(
                    "butelka4",
                    ModelPartBuilder.create().uv(0, 0).cuboid(0.0f, -12.0f, 1.0f, 1.0f, 2.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(0.0f, -10.0f, -2.0f, 1.0f, 2.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(0.0f, -10.0f, 0.0f, 1.0f, 2.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(0.0f, -12.0f, -3.0f, 1.0f, 2.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(0.0f, -8.0f, -3.0f, 1.0f, 1.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(0.0f, -8.0f, 1.0f, 1.0f, 1.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(0.0f, -7.0f, -4.0f, 1.0f, 1.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(0.0f, -7.0f, 2.0f, 1.0f, 1.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(0.0f, -6.0f, -5.0f, 1.0f, 5.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(0.0f, -6.0f, 3.0f, 1.0f, 5.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(0.0f, -1.0f, -4.0f, 1.0f, 1.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(0.0f, -1.0f, 2.0f, 1.0f, 1.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(0.0f, 0.0f, -3.0f, 1.0f, 1.0f, 5.0f, Dilation(0.0f)),
                    ModelTransform.of(-1.0f, -1.0f, 0.0f, 0.0f, -1.5708f, 0.0f)
                )
                val butelka5 = butelka.addChild(
                    "butelka5",
                    ModelPartBuilder.create().uv(0, 0).cuboid(0.0f, -12.0f, 1.0f, 1.0f, 2.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(0.0f, -10.0f, -2.0f, 1.0f, 2.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(0.0f, -10.0f, 0.0f, 1.0f, 2.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(0.0f, -12.0f, -3.0f, 1.0f, 2.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(0.0f, -8.0f, -3.0f, 1.0f, 1.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(0.0f, -8.0f, 1.0f, 1.0f, 1.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(0.0f, -7.0f, -4.0f, 1.0f, 1.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(0.0f, -7.0f, 2.0f, 1.0f, 1.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(0.0f, -6.0f, -5.0f, 1.0f, 5.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(0.0f, -6.0f, 3.0f, 1.0f, 5.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(0.0f, -1.0f, -4.0f, 1.0f, 1.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(0.0f, -1.0f, 2.0f, 1.0f, 1.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(0.0f, 0.0f, -3.0f, 1.0f, 1.0f, 5.0f, Dilation(0.0f)),
                    ModelTransform.of(-1.0f, -1.0f, -1.0f, 0.0f, -1.5708f, 0.0f)
                )
                val butelka6 = butelka.addChild(
                    "butelka6",
                    ModelPartBuilder.create().uv(0, 0).cuboid(0.0f, -12.0f, 1.0f, 1.0f, 2.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(0.0f, -10.0f, -2.0f, 1.0f, 2.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(0.0f, -10.0f, 0.0f, 1.0f, 2.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(0.0f, -12.0f, -3.0f, 1.0f, 2.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(0.0f, -8.0f, -3.0f, 1.0f, 1.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(0.0f, -8.0f, 1.0f, 1.0f, 1.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(0.0f, -7.0f, -4.0f, 1.0f, 1.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(0.0f, -7.0f, 2.0f, 1.0f, 1.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(0.0f, -6.0f, -5.0f, 1.0f, 5.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(0.0f, -6.0f, 3.0f, 1.0f, 5.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(0.0f, -1.0f, -4.0f, 1.0f, 1.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(0.0f, -1.0f, 2.0f, 1.0f, 1.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(0.0f, 0.0f, -3.0f, 1.0f, 1.0f, 5.0f, Dilation(0.0f)),
                    ModelTransform.of(-1.0f, -1.0f, -2.0f, 0.0f, -1.5708f, 0.0f)
                )
                val naronik1 = butelka.addChild(
                    "naronik1",
                    ModelPartBuilder.create().uv(0, 0).cuboid(1.0f, -2.0f, 1.0f, 1.0f, 1.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(1.0f, -8.0f, 1.0f, 1.0f, 1.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(1.0f, -7.0f, 2.0f, 1.0f, 5.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(2.0f, -7.0f, 1.0f, 1.0f, 5.0f, 1.0f, Dilation(0.0f)),
                    ModelTransform.pivot(0.0f, 0.0f, 0.0f)
                )
                val naronik2 = butelka.addChild(
                    "naronik2",
                    ModelPartBuilder.create().uv(0, 0).cuboid(1.0f, -2.0f, 1.0f, 1.0f, 1.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(1.0f, -8.0f, 1.0f, 1.0f, 1.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(1.0f, -7.0f, 2.0f, 1.0f, 5.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(2.0f, -7.0f, 1.0f, 1.0f, 5.0f, 1.0f, Dilation(0.0f)),
                    ModelTransform.of(0.0f, 0.0f, -1.0f, 0.0f, 1.5708f, 0.0f)
                )
                val naronik3 = butelka.addChild(
                    "naronik3",
                    ModelPartBuilder.create().uv(0, 0).cuboid(1.0f, -2.0f, 1.0f, 1.0f, 1.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(1.0f, -8.0f, 1.0f, 1.0f, 1.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(1.0f, -7.0f, 2.0f, 1.0f, 5.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(2.0f, -7.0f, 1.0f, 1.0f, 5.0f, 1.0f, Dilation(0.0f)),
                    ModelTransform.of(-1.0f, 0.0f, -1.0f, 0.0f, 3.1416f, 0.0f)
                )
                val naronik4 = butelka.addChild(
                    "naronik4",
                    ModelPartBuilder.create().uv(0, 0).cuboid(1.0f, -2.0f, 1.0f, 1.0f, 1.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(1.0f, -8.0f, 1.0f, 1.0f, 1.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(1.0f, -7.0f, 2.0f, 1.0f, 5.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 0).cuboid(2.0f, -7.0f, 1.0f, 1.0f, 5.0f, 1.0f, Dilation(0.0f)),
                    ModelTransform.of(-1.0f, 0.0f, 0.0f, 0.0f, -1.5708f, 0.0f)
                )
                val srodekbutelki = modelPartData.addChild(
                    "srodekbutelki",
                    ModelPartBuilder.create().uv(0, 30).cuboid(0.0f, -5.0f, -2.0f, 1.0f, 1.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 22).cuboid(-1.0f, -6.0f, -3.0f, 3.0f, 3.0f, 3.0f, Dilation(0.0f))
                        .uv(0, 30).cuboid(0.0f, -7.0f, 0.0f, 1.0f, 1.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 30).cuboid(-2.0f, -3.0f, -2.0f, 1.0f, 1.0f, 1.0f, Dilation(0.0f))
                        .uv(0, 30).cuboid(-3.0f, -4.0f, 1.0f, 1.0f, 1.0f, 1.0f, Dilation(0.0f)),
                    ModelTransform.pivot(0.0f, 24.0f, 0.0f)
                )
                val bb_main = modelPartData.addChild(
                    "bb_main",
                    ModelPartBuilder.create().uv(20, 26).cuboid(-2.0f, -14.0f, -2.0f, 3.0f, 3.0f, 3.0f, Dilation(0.0f)),
                    ModelTransform.pivot(0.0f, 24.0f, 0.0f)
                )
                return TexturedModelData.of(modelData, 32, 32)
            }
    }
}