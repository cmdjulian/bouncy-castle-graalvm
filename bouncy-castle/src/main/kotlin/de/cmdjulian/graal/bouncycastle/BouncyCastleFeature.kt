package de.cmdjulian.graal.bouncycastle

import org.graalvm.nativeimage.hosted.Feature
import org.graalvm.nativeimage.hosted.Feature.AfterRegistrationAccess
import org.graalvm.nativeimage.hosted.RuntimeClassInitialization
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
        RuntimeClassInitialization.initializeAtBuildTime("org.bouncycastle")
        RuntimeClassInitialization.initializeAtRunTime(
            "org.bouncycastle.jcajce.provider.drbg.DRBG\$Default",
            "org.bouncycastle.jcajce.provider.drbg.DRBG\$NonceAndIV",
        )
        Security.addProvider(clazz.getConstructor().newInstance() as Provider)
    }
}
