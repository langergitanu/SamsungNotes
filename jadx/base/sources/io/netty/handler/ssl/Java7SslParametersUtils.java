package io.netty.handler.ssl;

import io.netty.util.internal.SuppressJava6Requirement;
import java.security.AlgorithmConstraints;
import javax.net.ssl.SSLParameters;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
final class Java7SslParametersUtils {
    private Java7SslParametersUtils() {
    }

    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    public static void setAlgorithmConstraints(SSLParameters sSLParameters, Object obj) {
        sSLParameters.setAlgorithmConstraints((AlgorithmConstraints) obj);
    }
}
