package io.github.crow_misia.libyuv

interface CapacityCalculator<CAPACITIES : PlaneCapacities> {
    fun calculate(width: Int, height: Int): CAPACITIES
}

@JvmInline
value class Capacity(val value: Int) {
    override fun toString(): String = value.toString()
}

@JvmInline
value class RowStride(val value: Int) {
    override fun toString(): String = value.toString()

    operator fun times(other: Int): Int {
        return value * other
    }
}

@JvmInline
value class PixelStride(val value: Int) {
    override fun toString(): String = value.toString()

    companion object {
        val ONE = PixelStride(1)
    }
}

interface PlaneCapacities

data class Plane1Capacities(
    val planeCapacity: Capacity,
    val planeStride: RowStride,
) : PlaneCapacities

data class Plane2Capacities(
    val plane1Capacity: Capacity,
    val plane2Capacity: Capacity,
    val plane1Stride: RowStride,
    val plane2Stride: RowStride,
) : PlaneCapacities

data class Plane3Capacities(
    val plane1Capacity: Capacity,
    val plane2Capacity: Capacity,
    val plane3Capacity: Capacity,
    val plane1Stride: RowStride,
    val plane2Stride: RowStride,
    val plane3Stride: RowStride,
) : PlaneCapacities
