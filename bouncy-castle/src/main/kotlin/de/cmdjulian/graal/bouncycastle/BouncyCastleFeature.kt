package de.cmdjulian.graal.bouncycastle

import org.graalvm.nativeimage.hosted.Feature
import org.graalvm.nativeimage.hosted.Feature.AfterRegistrationAccess
import java.security.Provider
import java.security.Security

@Suppress("unused")
class BouncyCastleFeature : Feature {
    override fun afterRegistration(access: AfterRegistrationAccess?) {
        val clazz = try {
            Class.forName("org.bouncycastle.jce.provider.BouncyCastleProvider")
        } catch (e: Exception) {
            return println(
                if (e is ClassNotFoundException) {
                    "bouncy castle not present -> not loading it"
                } else {
                    "unknown exception when loading bouncy castle: ${e.message}"
                },
            )
        }

        println("INFO: found and registered bouncy castle")
        Security.addProvider(clazz.getConstructor().newInstance() as Provider)
    }
}
