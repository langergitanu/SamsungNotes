package com.yubico.yubikit.android;

import android.app.Activity;
import android.content.Context;
import com.yubico.yubikit.android.transport.nfc.NfcConfiguration;
import com.yubico.yubikit.android.transport.nfc.NfcNotAvailable;
import com.yubico.yubikit.android.transport.nfc.NfcYubiKeyDevice;
import com.yubico.yubikit.android.transport.nfc.NfcYubiKeyManager;
import com.yubico.yubikit.android.transport.usb.UsbConfiguration;
import com.yubico.yubikit.android.transport.usb.UsbYubiKeyDevice;
import com.yubico.yubikit.android.transport.usb.UsbYubiKeyManager;
import com.yubico.yubikit.core.util.Callback;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final class YubiKitManager {

    @Nullable
    private final NfcYubiKeyManager nfcYubiKeyManager;
    private final UsbYubiKeyManager usbYubiKeyManager;

    public YubiKitManager(Context context) {
        this(new UsbYubiKeyManager(context.getApplicationContext()), buildNfcDeviceManager(context.getApplicationContext()));
    }

    @Nullable
    private static NfcYubiKeyManager buildNfcDeviceManager(Context context) {
        try {
            return new NfcYubiKeyManager(context, null);
        } catch (NfcNotAvailable unused) {
            return null;
        }
    }

    public void startNfcDiscovery(NfcConfiguration nfcConfiguration, Activity activity, Callback<? super NfcYubiKeyDevice> callback) {
        NfcYubiKeyManager nfcYubiKeyManager = this.nfcYubiKeyManager;
        if (nfcYubiKeyManager == null) {
            throw new NfcNotAvailable("NFC is not available on this device", false);
        }
        nfcYubiKeyManager.enable(activity, nfcConfiguration, callback);
    }

    public void startUsbDiscovery(UsbConfiguration usbConfiguration, Callback<? super UsbYubiKeyDevice> callback) {
        this.usbYubiKeyManager.enable(usbConfiguration, callback);
    }

    public void stopNfcDiscovery(Activity activity) {
        NfcYubiKeyManager nfcYubiKeyManager = this.nfcYubiKeyManager;
        if (nfcYubiKeyManager != null) {
            nfcYubiKeyManager.disable(activity);
        }
    }

    public void stopUsbDiscovery() {
        this.usbYubiKeyManager.disable();
    }

    public YubiKitManager(UsbYubiKeyManager usbYubiKeyManager, @Nullable NfcYubiKeyManager nfcYubiKeyManager) {
        this.usbYubiKeyManager = usbYubiKeyManager;
        this.nfcYubiKeyManager = nfcYubiKeyManager;
    }
}
