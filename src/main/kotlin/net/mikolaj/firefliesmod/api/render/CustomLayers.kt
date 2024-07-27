package net.mikolaj.firefliesmod.api.render

import com.mojang.blaze3d.platform.GlStateManager
import com.mojang.blaze3d.systems.RenderSystem
import net.minecraft.client.render.RenderLayer
import net.minecraft.client.render.VertexFormat
import net.minecraft.client.render.VertexFormat.DrawMode
import net.minecraft.client.render.VertexFormats
import net.minecraft.client.texture.SpriteAtlasTexture
import net.minecraft.util.Identifier
import java.lang.Exception

@Suppress("DEPRECATION")
open class CustomLayers(
    name: String?,
    vertexFormat: VertexFormat?,
    drawMode: DrawMode?,
    expectedBufferSize: Int,
    hasCrumbling: Boolean,
    translucent: Boolean,
    startAction: Runnable?,
    endAction: Runnable?
) : RenderLayer(name, vertexFormat, drawMode, expectedBufferSize, hasCrumbling, translucent, startAction, endAction) {
    protected companion object {
        fun beam(texture: Identifier?, cull: Boolean, transparent: Boolean): RenderLayer {
            val multiPhaseParameters = MultiPhaseParameters.builder()
                .program(BEACON_BEAM_PROGRAM)
                .cull(if (cull) ENABLE_CULLING else DISABLE_CULLING)
                .texture(Texture(texture, false, false))
                .transparency(if (transparent) BEAM_TRANSPARENCY else NO_TRANSPARENCY)
                .writeMaskState(if (transparent) ALL_MASK else ALL_MASK)
                .build(false)
            return of(
                "spell_beam",
                VertexFormats.POSITION_COLOR_TEXTURE_LIGHT_NORMAL,
                DrawMode.QUADS,
                256,
                false,
                true,
                multiPhaseParameters
            )
        }

        protected val BEAM_TRANSPARENCY = Transparency("beam_transparency", {
            RenderSystem.enableBlend()
            RenderSystem.blendFunc(GlStateManager.SrcFactor.SRC_ALPHA, GlStateManager.DstFactor.ONE_MINUS_SRC_ALPHA)
        }) {
            RenderSystem.disableBlend()
            RenderSystem.defaultBlendFunc()
        }

        @Deprecated("")
        fun projectile(texture: Identifier?, translucent: Boolean): RenderLayer {
            return projectile(texture, translucent, true)
        }

        @Deprecated("")
        fun projectile(texture: Identifier?, translucent: Boolean, emissive: Boolean): RenderLayer {
            val multiPhaseParameters = MultiPhaseParameters.builder()
                .program(if (emissive) ENTITY_TRANSLUCENT_EMISSIVE_PROGRAM else ENTITY_TRANSLUCENT_PROGRAM)
                .texture(Texture(texture, false, false))
                .transparency(if (translucent) TRANSLUCENT_TRANSPARENCY else NO_TRANSPARENCY)
                .cull(DISABLE_CULLING)
                .writeMaskState(if (translucent) COLOR_MASK else ALL_MASK)
                .overlay(ENABLE_OVERLAY_COLOR)
                .build(false)
            return of(
                "entity_translucent_emissive",
                VertexFormats.POSITION_COLOR_TEXTURE_OVERLAY_LIGHT_NORMAL,
                DrawMode.QUADS,
                256,
                true,
                true,
                multiPhaseParameters
            )
        }

        fun spellEffect(lightEmission: LightEmission?, translucent: Boolean): RenderLayer {
            return spellObject(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, lightEmission, translucent)
        }

        fun projectile(lightEmission: LightEmission?): RenderLayer {
            return spellObject(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, lightEmission, false)
        }

        private fun create(
            texture: Identifier?, shaderProgram: ShaderProgram?, transparency: Transparency?,
            culling: Cull?, writeMask: WriteMaskState?, overlay: Overlay?,
            target: Target?, affectsOutline: Boolean
        ): RenderLayer {
            val multiPhaseParameters = MultiPhaseParameters.builder()
                .program(shaderProgram)
                .texture(Texture(texture, false, false))
                .transparency(transparency)
                .cull(culling)
                .writeMaskState(writeMask)
                .overlay(overlay)
                .target(target)
                .build(affectsOutline)
            return of(
                "entity_translucent_emissive",
                VertexFormats.POSITION_COLOR_TEXTURE_OVERLAY_LIGHT_NORMAL,
                DrawMode.QUADS,
                256,
                true,
                true,
                multiPhaseParameters
            )
        }

        fun spellObject(lightEmission: LightEmission?): RenderLayer {
            when (lightEmission) {
                LightEmission.RADIATE, LightEmission.GLOW -> return spellObject(
                    SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE,
                    lightEmission,
                    false
                )

                LightEmission.NONE -> {}

                null -> {}
            }
            return getEntityTranslucent(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE)
        }

        fun spellObject(texture: Identifier?, lightEmission: LightEmission?, translucent: Boolean): RenderLayer {
            val shaderProgram = when (lightEmission) {
                LightEmission.RADIATE -> ENTITY_TRANSLUCENT_EMISSIVE_PROGRAM
                LightEmission.GLOW -> BEACON_BEAM_PROGRAM
                LightEmission.NONE -> ENTITY_TRANSLUCENT_PROGRAM
                null -> NO_PROGRAM

            }
            val multiPhaseParameters = MultiPhaseParameters.builder()
                .program(shaderProgram)
                .texture(Texture(texture, false, false))
                .transparency(if (translucent) TRANSLUCENT_TRANSPARENCY else NO_TRANSPARENCY)
                .cull(DISABLE_CULLING)
                .writeMaskState(if (translucent) COLOR_MASK else ALL_MASK)
                .overlay(ENABLE_OVERLAY_COLOR)
                .target(TRANSLUCENT_TARGET)
                .build(false)
            return of(
                "entity_translucent_emissive",
                VertexFormats.POSITION_COLOR_TEXTURE_OVERLAY_LIGHT_NORMAL,
                DrawMode.QUADS,
                256,
                true,
                true,
                multiPhaseParameters
            )
        }

        private fun create(
            name: String?,
            vertexFormat: VertexFormat?,
            drawMode: DrawMode?,
            expectedBufferSize: Int,
            hasCrumbling: Boolean,
            translucent: Boolean,
            phases: MultiPhaseParameters?
        ): RenderLayer {
            return of(name, vertexFormat, drawMode, expectedBufferSize, hasCrumbling, translucent, phases)
        }
    }
}