import com.github.fluidsonic.fluid.library.*

plugins {
	id("com.github.fluidsonic.fluid-library") version "0.9.11"
}

fluidLibrary {
	name = "fluid-stdlib"
	version = "0.9.9"
}

fluidLibraryVariant {
	description = "Potentially useful Kotlin standard library additions"
	jdk = JDK.v1_7
}

kotlin {
	iosX64()

	sourceSets {
		getByName("iosX64Main") {
			kotlin.setSrcDirs(listOf("sources/ios"))
			resources.setSrcDirs(emptyList())
		}

		commonMain {
			dependencies {
				api(fluid("time", "0.9.0"))
			}
		}

		jvmMain {
			dependencies {
				implementation("org.threeten:threetenbp:1.4.0")
			}
		}
	}
}
