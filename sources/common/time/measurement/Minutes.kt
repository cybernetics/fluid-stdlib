package com.github.fluidsonic.fluid.stdlib

import kotlin.math.*


// TODO check for overflows
@Suppress("NON_PUBLIC_PRIMARY_CONSTRUCTOR_OF_INLINE_CLASS")
inline class Minutes(override val value: Long) : DurationMeasurement.Basic<Minutes>, DurationMeasurement.TimeBased<Minutes> {

	constructor(value: Int) : this(value.toLong())


	override val absolute
		get() = map(Long::absoluteValue)


	override fun compareTo(other: Minutes) =
		value.compareTo(other.value)


	override operator fun div(other: Int) =
		div(other.toLong())


	override operator fun div(other: Long) =
		Minutes(value / other)


	override operator fun div(other: Minutes) =
		value / other.value


	override val isNegative
		get() = value < 0


	override val isZero
		get() = value == 0L


	@Suppress("OVERRIDE_BY_INLINE")
	override inline fun map(transform: (Long) -> Long) =
		Minutes(transform(value))


	override operator fun minus(other: Minutes) =
		Minutes(value - other.value)


	override operator fun plus(other: Minutes) =
		Minutes(value + other.value)


	override operator fun rem(other: Int) =
		rem(other.toLong())


	override operator fun rem(other: Long) =
		Minutes(value % other)


	override operator fun rem(other: Minutes) =
		Minutes(value % other.value)


	override operator fun times(other: Int) =
		times(other.toLong())


	override operator fun times(other: Long) =
		Minutes(value * other)


	override fun toDays() =
		Days(this / perDay)


	override fun toDuration() =
		Duration.of(minutes = this)


	override fun toHours() =
		Hours(this / perHour)


	override fun toInt() =
		value.toInt()


	override fun toLong() =
		value


	override fun toMicroseconds() =
		Microseconds.perMinute * value


	override fun toMilliseconds() =
		Milliseconds.perMinute * value


	@Deprecated(message = "redundant conversion", level = DeprecationLevel.HIDDEN)
	override fun toMinutes() =
		this


	override fun toNanoseconds() =
		Nanoseconds.perMinute * value


	override fun toSeconds() =
		Seconds.perMinute * value


	override fun toString() =
		value.toString()


	override operator fun unaryMinus() =
		Minutes(-value)


	companion object {

		val perHour = Minutes(60L)
		val perDay = Hours.perDay.toMinutes()
		val zero = Minutes(0L)
	}
}


operator fun Int.times(other: Minutes) =
	other.times(this)


operator fun Long.times(other: Minutes) =
	other.times(this)