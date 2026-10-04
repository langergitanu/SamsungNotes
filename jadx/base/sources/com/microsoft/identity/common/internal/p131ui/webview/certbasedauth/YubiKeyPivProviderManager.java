package com.microsoft.identity.common.internal.p131ui.webview.certbasedauth;

import androidx.annotation.NonNull;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.java.opentelemetry.ICertBasedAuthTelemetryHelper;
import com.microsoft.identity.common.logging.Logger;
import com.yubico.yubikit.core.util.Callback;
import com.yubico.yubikit.core.util.Result;
import com.yubico.yubikit.piv.PivSession;
import com.yubico.yubikit.piv.jca.PivProvider;
import java.security.Security;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class YubiKeyPivProviderManager {
    private static final String TAG = "YubiKeyPivProviderManager";
    protected static final String YUBIKEY_PROVIDER = "YKPiv";

    public static void addPivProvider(@NonNull ICertBasedAuthTelemetryHelper iCertBasedAuthTelemetryHelper, @NonNull Callback<Callback<Result<PivSession, Exception>>> callback) {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":addPivProvider", new StringBuilder());
        if (Security.getProvider(YUBIKEY_PROVIDER) != null) {
            Security.removeProvider(YUBIKEY_PROVIDER);
            iCertBasedAuthTelemetryHelper.setExistingPivProviderPresent(true);
            Logger.info(strM1170p, "Existing PivProvider was present in Security static list.");
        } else {
            iCertBasedAuthTelemetryHelper.setExistingPivProviderPresent(false);
            Logger.info(strM1170p, "Security static list does not have existing PivProvider.");
        }
        Security.insertProviderAt(new PivProvider(callback), 1);
        Logger.info(strM1170p, "An instance of PivProvider was added to Security static list.");
    }

    public static void removePivProvider() {
        if (Security.getProvider(YUBIKEY_PROVIDER) == null) {
            return;
        }
        Security.removeProvider(YUBIKEY_PROVIDER);
        Logger.info(TAG, "An instance of PivProvider was removed from Security static list.");
    }
}
