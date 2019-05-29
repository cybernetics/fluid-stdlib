import com.github.fluidsonic.fluid.library.*
import org.jetbrains.kotlin.gradle.plugin.mpp.*

plugins {
	id("com.github.fluidsonic.fluid-library") version "0.9.14"
}

fluidLibrary {
	name = "fluid-stdlib"
	version = "0.9.15"
}

fluidLibraryVariant {
	description = "Potentially useful Kotlin standard library additions"

	jvm(JDK.v1_7)
	objc()
}

kotlin {
	sourceSets {
		commonMain {
			dependencies {
				api(fluid("time", "0.9.5"))

				implementation(kotlinx("serialization-runtime", "0.11.0"))
			}
		}

		jvmMain {
			dependencies {
				implementation("org.threeten:threetenbp:1.4.0")
			}
		}

		objcMain {
			dependencies {
				implementation(kotlinx("serialization-runtime-native", "0.11.0"))
			}
		}
	}
}
