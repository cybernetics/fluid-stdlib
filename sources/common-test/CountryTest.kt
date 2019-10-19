package tests

import io.fluidsonic.stdlib.*
import kotlin.test.*


object CountryTest {

	@Test
	fun testSerializer() = assertJsonSerialization(
		value = Country.byCode("US")!!,
		json = """ "US" """,
		serializer = Country.serializer()
	)
}
