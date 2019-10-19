package io.fluidsonic.stdlib

import java.util.Locale as PlatformLocale


actual fun Country.name(locale: Locale): String =
	PlatformLocale("", code).getDisplayCountry(locale.toPlatform())


internal actual object Country_Static {

	actual val allCountryCodes: Set<String> = PlatformLocale.getISOCountries().toHashSet()
}
