package com.microsoft.identity.common.java.authscheme;

import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.java.interfaces.IPlatformComponents;
import com.microsoft.identity.common.java.logging.Logger;
import edu.umd.cs.findbugs.annotations.Nullable;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class AuthenticationSchemeFactory {
    private static final String TAG = "AuthenticationSchemeFactory";

    public static AbstractAuthenticationScheme createScheme(@NonNull IPlatformComponents iPlatformComponents, @Nullable INameable iNameable) {
        if (iPlatformComponents == null) {
            throw new NullPointerException("commonComponents is marked non-null but is null");
        }
        String strM1170p = AbstractC0622a.m1170p(TAG, ":createScheme", new StringBuilder());
        if (iNameable == null) {
            return new BearerAuthenticationSchemeInternal();
        }
        String name = iNameable.getName();
        name.getClass();
        switch (name) {
            case "PoP_With_Client_Key":
                if (!(iNameable instanceof IPoPAuthenticationSchemeParams)) {
                    throw new IllegalStateException("Unrecognized parameter type.");
                }
                Logger.verbose(strM1170p, "Constructing PoP Authentication Scheme With Client Key.");
                return (PopAuthenticationSchemeWithClientKeyInternal) iNameable;
            case "PoP":
                if (!(iNameable instanceof IPoPAuthenticationSchemeParams)) {
                    throw new IllegalStateException("Unrecognized parameter type.");
                }
                Logger.verbose(strM1170p, "Constructing PoP Authentication Scheme.");
                IPoPAuthenticationSchemeParams iPoPAuthenticationSchemeParams = (IPoPAuthenticationSchemeParams) iNameable;
                return new PopAuthenticationSchemeInternal(iPlatformComponents.getClockSkewManager(), iPlatformComponents.getDefaultDevicePopManager(), iPoPAuthenticationSchemeParams.getHttpMethod(), iPoPAuthenticationSchemeParams.getUrl(), iPoPAuthenticationSchemeParams.getNonce(), iPoPAuthenticationSchemeParams.getClientClaims());
            case "Bearer":
                Logger.verbose(strM1170p, "Constructing Bearer Authentication Scheme.");
                return new BearerAuthenticationSchemeInternal();
            default:
                throw new UnsupportedOperationException("Unknown or unsupported scheme: " + iNameable.getName());
        }
    }

    public static boolean isPopAuthenticationScheme(@NonNull AbstractAuthenticationScheme abstractAuthenticationScheme) {
        if (abstractAuthenticationScheme != null) {
            return abstractAuthenticationScheme instanceof IPoPAuthenticationSchemeParams;
        }
        throw new NullPointerException("authenticationScheme is marked non-null but is null");
    }
}
