package com.microsoft.identity.common.internal.p131ui.webview.certbasedauth;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.logging.Logger;
import com.yubico.yubikit.android.transport.nfc.NfcNotAvailable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class SmartcardCertBasedAuthManagerFactory {
    private static final String TAG = "SmartcardCertBasedAuthManagerFactory";

    @Nullable
    public static AbstractNfcSmartcardCertBasedAuthManager createNfcSmartcardCertBasedAuthManager(@NonNull Context context) {
        try {
            return new YubiKitNfcSmartcardCertBasedAuthManager(context);
        } catch (NfcNotAvailable unused) {
            Logger.info(AbstractC0622a.m1170p(TAG, ":createNfcSmartcardCertBasedAuthManager", new StringBuilder()), "Device does not support NFC capabilities.");
            return null;
        }
    }

    @Nullable
    public static AbstractUsbSmartcardCertBasedAuthManager createUsbSmartcardCertBasedAuthManager(@NonNull Context context) {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":createUsbSmartcardCertBasedAuthManager", new StringBuilder());
        if (context.getSystemService("usb") != null) {
            return new YubiKitUsbSmartcardCertBasedAuthManager(context);
        }
        Logger.info(strM1170p, "Certificate Based Authentication via YubiKey not enabled due to device not supporting the USB_SERVICE system service.");
        return null;
    }
}
