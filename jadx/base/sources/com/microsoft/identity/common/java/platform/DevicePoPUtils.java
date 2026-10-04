package com.microsoft.identity.common.java.platform;

import com.microsoft.identity.common.java.authscheme.IPoPAuthenticationSchemeParams;
import com.microsoft.identity.common.java.crypto.IDevicePopManager;
import com.microsoft.identity.common.java.interfaces.IPlatformComponents;
import com.microsoft.identity.common.java.result.GenerateShrResult;
import java.net.URL;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class DevicePoPUtils {
    private DevicePoPUtils() {
    }

    public static synchronized GenerateShrResult generateSignedHttpRequest(@NonNull IPlatformComponents iPlatformComponents, @NonNull IPoPAuthenticationSchemeParams iPoPAuthenticationSchemeParams) {
        GenerateShrResult generateShrResult;
        try {
            if (iPlatformComponents == null) {
                throw new NullPointerException("platformComponents is marked non-null but is null");
            }
            if (iPoPAuthenticationSchemeParams == null) {
                throw new NullPointerException("popSchemeParams is marked non-null but is null");
            }
            long time = iPlatformComponents.getClockSkewManager().getAdjustedReferenceTime().getTime();
            String httpMethod = iPoPAuthenticationSchemeParams.getHttpMethod();
            URL url = iPoPAuthenticationSchemeParams.getUrl();
            String nonce = iPoPAuthenticationSchemeParams.getNonce();
            String clientClaims = iPoPAuthenticationSchemeParams.getClientClaims();
            IDevicePopManager defaultDevicePopManager = iPlatformComponents.getDefaultDevicePopManager();
            if (!defaultDevicePopManager.asymmetricKeyExists()) {
                defaultDevicePopManager.generateAsymmetricKey();
            }
            String strMintSignedHttpRequest = defaultDevicePopManager.mintSignedHttpRequest(httpMethod, time / 1000, url, nonce, clientClaims);
            generateShrResult = new GenerateShrResult();
            generateShrResult.setShr(strMintSignedHttpRequest);
        } catch (Throwable th) {
            throw th;
        }
        return generateShrResult;
    }
}
