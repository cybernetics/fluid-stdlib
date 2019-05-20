package com.github.fluidsonic.fluid.stdlib

import kotlin.math.*


// TODO check for overflows
@Suppress("NON_PUBLIC_PRIMARY_CONSTRUCTOR_OF_INLINE_CLASS")
inline class Hours(override val value: Long) : DurationMeasurement.Basic<Hours>, DurationMeasurement.TimeBased<Hours> {

	constructor(value: Int) : this(value.toLong())


	override val absolute
		get() = map(Long::absoluteValue)


	override fun compareTo(other: Hours) =
		value.compareTo(other.value)


	override operator fun div(other: Int) =
		div(other.toLong())


	override operator fun div(other: Long) =
		Hours(value / other)


	override operator fun div(other: Hours) =
		value / other.value


	override val isNegative
		get() = value < 0


	override val isZero
		get() = value == 0L


	@Suppress("OVERRIDE_BY_INLINE")
	override inline fun map(transform: (Long) -> Long) =
		Hours(transform(value))


	override operator fun minus(other: Hours) =
		Hours(value - other.value)


	override operator fun plus(other: Hours) =
		Hours(value + other.value)


	override operator fun rem(other: Int) =
		rem(other.toLong())


	override operator fun rem(other: Long) =
		Hours(value % other)


	override operator fun rem(other: Hours) =
		Hours(value % other.value)


	override operator fun times(other: Int) =
		times(other.toLong())


	override operator fun times(other: Long) =
		Hours(value * other)


	override fun toDays() =
		Days(this / perDay)


	override fun toDuration() =
		Duration.of(hours = this)


	@Deprecated(message = "redundant conversion", level = DeprecationLevel.HIDDEN)
	override fun toHours() =
		this


	override fun toInt() =
		value.toInt()


	override fun toLong() =
		value


	override fun toMicroseconds() =
		Microseconds.perHour * value


	override fun toMilliseconds() =
		Milliseconds.perHour * value


	override fun toMinutes() =
		Minutes.perHour * value


	override fun toNanoseconds() =
		Nanoseconds.perHour * value


	override fun toSeconds() =
		Seconds.perHour * value


	override fun toString() =
		value.toString()


	override operator fun unaryMinus() =
		Hours(-value)


	companion object {

		val perDay = Hours(24L)
		val zero = Hours(0L)
	}
}


operator fun Int.times(other: Hours) =
	other.times(this)


operator fun Long.times(other: Hours) =
	other.times(this)