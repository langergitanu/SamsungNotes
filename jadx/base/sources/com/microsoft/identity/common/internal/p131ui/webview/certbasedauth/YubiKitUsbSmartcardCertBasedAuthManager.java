package com.microsoft.identity.common.internal.p131ui.webview.certbasedauth;

import android.app.Activity;
import android.content.Context;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthManager;
import com.microsoft.identity.common.java.opentelemetry.ICertBasedAuthTelemetryHelper;
import com.microsoft.identity.common.logging.Logger;
import com.yubico.yubikit.android.transport.usb.UsbConfiguration;
import com.yubico.yubikit.android.transport.usb.UsbYubiKeyDevice;
import com.yubico.yubikit.android.transport.usb.UsbYubiKeyManager;
import com.yubico.yubikit.android.transport.usb.connection.UsbSmartCardConnection;
import com.yubico.yubikit.core.smartcard.SmartCardConnection;
import com.yubico.yubikit.core.util.Callback;
import com.yubico.yubikit.core.util.Result;
import com.yubico.yubikit.piv.PivSession;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class YubiKitUsbSmartcardCertBasedAuthManager extends AbstractUsbSmartcardCertBasedAuthManager {
    private static final String DEVICE_ERROR_MESSAGE = "No USB device is currently connected.";
    private static final String TAG = "YubiKitUsbSmartcardCertBasedAuthManager";
    public static final int YUBICO_VENDOR_ID = 4176;
    private static final Object sDeviceLock = new Object();
    private UsbYubiKeyDevice mUsbDevice;
    private final UsbYubiKeyManager mUsbYubiKeyManager;

    public YubiKitUsbSmartcardCertBasedAuthManager(@NonNull Context context) {
        this.mUsbYubiKeyManager = new UsbYubiKeyManager(context.getApplicationContext());
        Iterator<UsbDevice> it = ((UsbManager) context.getSystemService("usb")).getDeviceList().values().iterator();
        while (it.hasNext()) {
            if (it.next().getVendorId() == 4176) {
                Logger.verbose(TAG, "A YubiKey device is plugged-in upon manager start-up.");
                this.mUsbDeviceInitiallyPluggedIn = true;
                return;
            }
        }
    }

    @NonNull
    public Callback<Callback<Result<PivSession, Exception>>> getPivProviderCallback() {
        final String strM1170p = AbstractC0622a.m1170p(TAG, "getPivProviderCallback:", new StringBuilder());
        return new Callback<Callback<Result<PivSession, Exception>>>() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.YubiKitUsbSmartcardCertBasedAuthManager.3
            @Override // com.yubico.yubikit.core.util.Callback
            @RequiresApi(api = 21)
            public void invoke(@NonNull final Callback<Result<PivSession, Exception>> callback) {
                synchronized (YubiKitUsbSmartcardCertBasedAuthManager.sDeviceLock) {
                    try {
                        if (YubiKitUsbSmartcardCertBasedAuthManager.this.isDeviceConnected()) {
                            YubiKitUsbSmartcardCertBasedAuthManager.this.mUsbDevice.requestConnection(UsbSmartCardConnection.class, new Callback<Result<UsbSmartCardConnection, IOException>>() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.YubiKitUsbSmartcardCertBasedAuthManager.3.1
                                @Override // com.yubico.yubikit.core.util.Callback
                                public void invoke(@NonNull final Result<UsbSmartCardConnection, IOException> result) {
                                    callback.invoke(Result.m13504of(new Callable<PivSession>() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.YubiKitUsbSmartcardCertBasedAuthManager.3.1.1
                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // java.util.concurrent.Callable
                                        public PivSession call() {
                                            return new PivSession((SmartCardConnection) result.getValue());
                                        }
                                    }));
                                }
                            });
                        } else {
                            Logger.error(strM1170p, YubiKitUsbSmartcardCertBasedAuthManager.DEVICE_ERROR_MESSAGE, null);
                            callback.invoke(Result.failure(new Exception(YubiKitUsbSmartcardCertBasedAuthManager.DEVICE_ERROR_MESSAGE)));
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
            z = this.mUsbDevice != null;
        }
        return z;
    }

    @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthManager
    public void onDestroy(@NonNull Activity activity) {
        stopDiscovery(activity);
    }

    @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthManager
    public void requestDeviceSession(@NonNull final AbstractSmartcardCertBasedAuthManager.ISessionCallback iSessionCallback) {
        String strM1170p = AbstractC0622a.m1170p(TAG, "requestDeviceSession:", new StringBuilder());
        synchronized (sDeviceLock) {
            try {
                if (isDeviceConnected()) {
                    this.mUsbDevice.requestConnection(UsbSmartCardConnection.class, new Callback<Result<UsbSmartCardConnection, IOException>>() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.YubiKitUsbSmartcardCertBasedAuthManager.2
                        @Override // com.yubico.yubikit.core.util.Callback
                        public void invoke(@NonNull Result<UsbSmartCardConnection, IOException> result) {
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
        Logger.info(str, "Starting YubiKey discovery for USB");
        this.mUsbYubiKeyManager.enable(new UsbConfiguration(), new Callback<UsbYubiKeyDevice>() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.YubiKitUsbSmartcardCertBasedAuthManager.1
            @Override // com.yubico.yubikit.core.util.Callback
            public void invoke(@NonNull UsbYubiKeyDevice usbYubiKeyDevice) {
                Logger.info(str, "A YubiKey device was connected via USB.");
                synchronized (YubiKitUsbSmartcardCertBasedAuthManager.sDeviceLock) {
                    try {
                        YubiKitUsbSmartcardCertBasedAuthManager.this.mUsbDevice = usbYubiKeyDevice;
                        IConnectionCallback iConnectionCallback = YubiKitUsbSmartcardCertBasedAuthManager.this.mConnectionCallback;
                        if (iConnectionCallback != null) {
                            iConnectionCallback.onCreateConnection();
                        }
                        YubiKitUsbSmartcardCertBasedAuthManager.this.mUsbDevice.setOnClosed(new Runnable() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.YubiKitUsbSmartcardCertBasedAuthManager.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Logger.info(str, "A YubiKey device was disconnected via USB.");
                                synchronized (YubiKitUsbSmartcardCertBasedAuthManager.sDeviceLock) {
                                    YubiKitUsbSmartcardCertBasedAuthManager.this.mUsbDevice = null;
                                }
                                YubiKeyPivProviderManager.removePivProvider();
                                IDisconnectionCallback iDisconnectionCallback = YubiKitUsbSmartcardCertBasedAuthManager.this.mDisconnectionCallback;
                                if (iDisconnectionCallback != null) {
                                    iDisconnectionCallback.onClosedConnection();
                                }
                            }
                        });
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        });
        return true;
    }

    @Override // com.microsoft.identity.common.internal.p131ui.webview.certbasedauth.AbstractSmartcardCertBasedAuthManager
    public void stopDiscovery(@NonNull Activity activity) {
        Logger.info(TAG + ":stopDiscovery", "Stopping YubiKey discovery for USB");
        synchronized (sDeviceLock) {
            this.mUsbDevice = null;
            this.mUsbYubiKeyManager.disable();
        }
    }
}
