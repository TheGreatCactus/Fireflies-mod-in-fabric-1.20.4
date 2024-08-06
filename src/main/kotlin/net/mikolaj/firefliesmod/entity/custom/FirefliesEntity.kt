package net.mikolaj.firefliesmod.entity.custom

import net.mikolaj.firefliesmod.entity.ModEntities
import net.minecraft.entity.Entity
import net.minecraft.entity.EntityDimensions
import net.minecraft.entity.EntityPose
import net.minecraft.entity.EntityType
import net.minecraft.entity.data.DataTracker
import net.minecraft.entity.data.TrackedData
import net.minecraft.entity.data.TrackedDataHandlerRegistry
import net.minecraft.nbt.NbtCompound
import net.minecraft.particle.ParticleTypes
import net.minecraft.util.math.Box
import net.minecraft.util.math.MathHelper
import net.minecraft.world.World


class FirefliesEntity : Entity {
    constructor(world: World?, entityType: EntityType<out FirefliesEntity> = ModEntities.FIREFLIES_ENTITY) : super(
        entityType,
        world
    ) {
        noClip = false
    }

    constructor(
        world: World?,
        x: Double,
        y: Double,
        z: Double
    ) : this(world, ModEntities.FIREFLIES_ENTITY as EntityType<out FirefliesEntity>) {
        this.setPosition(x, y, z)
    }

    var size: Int
        get() = dataTracker.get(SIZE)
        set(size) {
            if (!world.isClient) {
                if (size < 1) {
                    discard()
                    return
                }
                dataTracker.set(SIZE, MathHelper.clamp(size, 1, 127))
                refreshPosition()
                calculateDimensions()
                calculateBoundingBox()
            }
        }

    override fun initDataTracker() {
        dataTracker.startTracking(SIZE, 1)
        dataTracker.startTracking(WAITING, false)
    }

    override fun tick() {
        val g: Float
        val i2: Int
        super.tick()
        val bl = dataTracker.get(WAITING)
        val f = size.toFloat()
        if (!world.isClient) return
        if (bl && random.nextBoolean()) {
            return
        }
        if (bl) {
            i2 = 2
            g = 0.2f
        } else {
            i2 = MathHelper.ceil(f*f * 0.025)
            g = f
        }

        for (j in 0 until i2) {
            var p: Double
            var o: Double
            var n: Double
            val d: Double = x - size/2 + Math.random() * size
            val e: Double = y + Math.random() * size
            val l: Double = z - size/2 + Math.random() * size
            if (bl) {
                n = 0.0
                o = 0.0
                p = 0.0
            } else {
                n = (0.085 - random.nextDouble()) * 0.17
                o = (0.06 - random.nextDouble()) * 0.12
                p = (0.085 - random.nextDouble()) * 0.17
            }
            world.addImportantParticle(ParticleTypes.FLAME, d, e, l, n, o, p)
        }
    }

    override fun readCustomDataFromNbt(nbt: NbtCompound) {
        age = nbt.getInt("Age")
        size = nbt.getInt("Size")
    }

    override fun writeCustomDataToNbt(nbt: NbtCompound) {
        nbt.putInt("Age", age)
        nbt.putInt("Size", size)
    }

    override fun onTrackedDataSet(data: TrackedData<*>?) {
        super.onTrackedDataSet(data)
        if (SIZE == data) {
            boundingBox = calculateBoundingBox()
        }
    }

    override fun getDimensions(pose: EntityPose): EntityDimensions {
        return EntityDimensions.changing(size.toFloat(), size.toFloat())
    }

    override fun calculateBoundingBox(): Box? {
        return getDimensions(pose).getBoxAt(pos)
    }

    companion object {
        private val WAITING: TrackedData<Boolean> =
            DataTracker.registerData(FirefliesEntity::class.java, TrackedDataHandlerRegistry.BOOLEAN)
        private val SIZE: TrackedData<Int> =
            DataTracker.registerData(FirefliesEntity::class.java, TrackedDataHandlerRegistry.INTEGER)

    }
}