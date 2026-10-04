package com.microsoft.identity.common.internal.p131ui.webview.certbasedauth;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthManager;
import com.microsoft.identity.common.java.opentelemetry.ICertBasedAuthTelemetryHelper;
import com.microsoft.identity.common.logging.Logger;
import com.yubico.yubikit.android.transport.nfc.NfcConfiguration;
import com.yubico.yubikit.android.transport.nfc.NfcNotAvailable;
import com.yubico.yubikit.android.transport.nfc.NfcSmartCardConnection;
import com.yubico.yubikit.android.transport.nfc.NfcYubiKeyDevice;
import com.yubico.yubikit.android.transport.nfc.NfcYubiKeyManager;
import com.yubico.yubikit.core.smartcard.SmartCardConnection;
import com.yubico.yubikit.core.util.Callback;
import com.yubico.yubikit.core.util.Result;
import com.yubico.yubikit.piv.PivSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class YubiKitNfcSmartcardCertBasedAuthManager extends AbstractNfcSmartcardCertBasedAuthManager {
    private static final String DEVICE_ERROR_MESSAGE = "No NFC device is currently connected.";
    private static final int NFC_TIMEOUT = 5000;
    private static final String TAG = "YubiKitNfcSmartcardCertBasedAuthManager";
    private static final Object sDeviceLock = new Object();
    private NfcYubiKeyDevice mNfcDevice;
    private final NfcYubiKeyManager mNfcYubiKitManager;
    private byte[] mTagId;

    public YubiKitNfcSmartcardCertBasedAuthManager(@NonNull Context context) {
        this.mNfcYubiKitManager = new NfcYubiKeyManager(context.getApplicationContext(), null);
        this.isDeviceChanged = false;
    }

    @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.AbstractNfcSmartcardCertBasedAuthManager
    public void disconnect(@NonNull final IDisconnectionCallback iDisconnectionCallback) {
        final String strM1170p = AbstractC0622a.m1170p(TAG, ":disconnect", new StringBuilder());
        synchronized (sDeviceLock) {
            try {
                NfcYubiKeyDevice nfcYubiKeyDevice = this.mNfcDevice;
                if (nfcYubiKeyDevice != null) {
                    nfcYubiKeyDevice.remove(new Runnable() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.YubiKitNfcSmartcardCertBasedAuthManager.4
                        @Override // java.lang.Runnable
                        public void run() {
                            Logger.info(strM1170p, "YubiKey connected via NFC has been disconnected");
                            YubiKitNfcSmartcardCertBasedAuthManager.this.mNfcDevice = null;
                            iDisconnectionCallback.onClosedConnection();
                        }
                    });
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @NonNull
    public Callback<Callback<Result<PivSession, Exception>>> getPivProviderCallback() {
        final String strM1170p = AbstractC0622a.m1170p(TAG, "getPivProviderCallback:", new StringBuilder());
        return new Callback<Callback<Result<PivSession, Exception>>>() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.YubiKitNfcSmartcardCertBasedAuthManager.3
            @Override // com.yubico.yubikit.core.util.Callback
            @RequiresApi(api = 21)
            public void invoke(@NonNull final Callback<Result<PivSession, Exception>> callback) {
                synchronized (YubiKitNfcSmartcardCertBasedAuthManager.sDeviceLock) {
                    try {
                        if (YubiKitNfcSmartcardCertBasedAuthManager.this.isDeviceConnected()) {
                            YubiKitNfcSmartcardCertBasedAuthManager.this.mNfcDevice.requestConnection(NfcSmartCardConnection.class, new Callback<Result<NfcSmartCardConnection, IOException>>() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.YubiKitNfcSmartcardCertBasedAuthManager.3.1
                                @Override // com.yubico.yubikit.core.util.Callback
                                public void invoke(@NonNull final Result<NfcSmartCardConnection, IOException> result) {
                                    callback.invoke(Result.m13504of(new Callable<PivSession>() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.YubiKitNfcSmartcardCertBasedAuthManager.3.1.1
                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // java.util.concurrent.Callable
                                        public PivSession call() {
                                            return new PivSession((SmartCardConnection) result.getValue());
                                        }
                                    }));
                                }
                            });
                        } else {
                            Logger.error(strM1170p, YubiKitNfcSmartcardCertBasedAuthManager.DEVICE_ERROR_MESSAGE, null);
                            callback.invoke(Result.failure(new Exception(YubiKitNfcSmartcardCertBasedAuthManager.DEVICE_ERROR_MESSAGE)));
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        };
    }

    @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthManager
    public void initBeforeProceedingWithRequest(@NonNull ICertBasedAuthTelemetryHelper iCertBasedAuthTelemetryHelper) {
        YubiKeyPivProviderManager.addPivProvider(iCertBasedAuthTelemetryHelper, getPivProviderCallback());
    }

    @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthManager
    public boolean isDeviceConnected() {
        boolean z;
        synchronized (sDeviceLock) {
            z = this.mNfcDevice != null;
        }
        return z;
    }

    @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthManager
    public void onDestroy(@NonNull Activity activity) {
        YubiKeyPivProviderManager.removePivProvider();
    }

    @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthManager
    public void requestDeviceSession(@NonNull final AbstractSmartcardCertBasedAuthManager.ISessionCallback iSessionCallback) {
        String strM1170p = AbstractC0622a.m1170p(TAG, "requestDeviceSession:", new StringBuilder());
        synchronized (sDeviceLock) {
            try {
                if (isDeviceConnected()) {
                    this.mNfcDevice.requestConnection(NfcSmartCardConnection.class, new Callback<Result<NfcSmartCardConnection, IOException>>() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.YubiKitNfcSmartcardCertBasedAuthManager.2
                        @Override // com.yubico.yubikit.core.util.Callback
                        public void invoke(@NonNull Result<NfcSmartCardConnection, IOException> result) {
                            try {
                                iSessionCallback.onGetSession(new YubiKitSmartcardSession(new PivSession(result.getValue())));
                            } catch (Exception e) {
                                iSessionCallback.onException(e);
                            }
                        }
                    });
                } else {
                    Logger.error(strM1170p, DEVICE_ERROR_MESSAGE, null);
                    iSessionCallback.onException(new Exception());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthManager
    public boolean startDiscovery(@NonNull Activity activity) {
        final String str = TAG + ":startDiscovery";
        Logger.info(str, "Starting YubiKey discovery for NFC");
        try {
            this.mNfcYubiKitManager.enable(activity, new NfcConfiguration().timeout(5000), new Callback<NfcYubiKeyDevice>() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.YubiKitNfcSmartcardCertBasedAuthManager.1
                @Override // com.yubico.yubikit.core.util.Callback
                public void invoke(@NonNull NfcYubiKeyDevice nfcYubiKeyDevice) {
                    Logger.info(str, "A YubiKey device was connected via NFC.");
                    YubiKitNfcSmartcardCertBasedAuthManager.this.mNfcDevice = nfcYubiKeyDevice;
                    byte[] id = YubiKitNfcSmartcardCertBasedAuthManager.this.mNfcDevice.getTag().getId();
                    YubiKitNfcSmartcardCertBasedAuthManager yubiKitNfcSmartcardCertBasedAuthManager = YubiKitNfcSmartcardCertBasedAuthManager.this;
                    yubiKitNfcSmartcardCertBasedAuthManager.isDeviceChanged = (yubiKitNfcSmartcardCertBasedAuthManager.mTagId == null || Arrays.equals(YubiKitNfcSmartcardCertBasedAuthManager.this.mTagId, id)) ? false : true;
                    YubiKitNfcSmartcardCertBasedAuthManager.this.mTagId = id;
                    IConnectionCallback iConnectionCallback = YubiKitNfcSmartcardCertBasedAuthManager.this.mConnectionCallback;
                    if (iConnectionCallback != null) {
                        iConnectionCallback.onCreateConnection();
                    }
                }
            });
            return false;
        } catch (NfcNotAvailable unused) {
            Logger.info(str, "Device has NFC functionality turned off.");
            return true;
        }
    }

    @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthManager
    public void stopDiscovery(@NonNull Activity activity) {
        Logger.info(TAG + ":stopDiscovery", "Stopping YubiKey discovery for NFC");
        synchronized (sDeviceLock) {
            this.mNfcDevice = null;
            this.mNfcYubiKitManager.disable(activity);
        }
    }
}
