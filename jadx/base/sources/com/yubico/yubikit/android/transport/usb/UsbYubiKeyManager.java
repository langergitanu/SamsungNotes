package com.yubico.yubikit.android.transport.usb;

import android.content.Context;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import com.yubico.yubikit.android.transport.usb.UsbDeviceManager;
import com.yubico.yubikit.android.transport.usb.connection.ConnectionManager;
import com.yubico.yubikit.android.transport.usb.connection.OtpConnectionHandler;
import com.yubico.yubikit.android.transport.usb.connection.SmartCardConnectionHandler;
import com.yubico.yubikit.android.transport.usb.connection.UsbOtpConnection;
import com.yubico.yubikit.android.transport.usb.connection.UsbSmartCardConnection;
import com.yubico.yubikit.core.util.Callback;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class UsbYubiKeyManager {
    private static final Logger logger;
    private final Context context;

    @Nullable
    private MyDeviceListener internalListener = null;
    private final UsbManager usbManager;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class MyDeviceListener implements UsbDeviceManager.UsbDeviceListener {
        private final Map<UsbDevice, UsbYubiKeyDevice> devices;
        private final Callback<? super UsbYubiKeyDevice> listener;
        private final UsbConfiguration usbConfiguration;

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$deviceAttached$0(UsbYubiKeyDevice usbYubiKeyDevice, UsbDevice usbDevice, boolean z) {
            com.yubico.yubikit.core.internal.Logger.debug(UsbYubiKeyManager.logger, "permission result {}", Boolean.valueOf(z));
            if (z) {
                synchronized (UsbYubiKeyManager.this) {
                    try {
                        if (UsbYubiKeyManager.this.internalListener == this) {
                            this.listener.invoke(usbYubiKeyDevice);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }

        @Override // com.yubico.yubikit.android.transport.usb.UsbDeviceManager.UsbDeviceListener
        public void deviceAttached(UsbDevice usbDevice) {
            try {
                final UsbYubiKeyDevice usbYubiKeyDevice = new UsbYubiKeyDevice(UsbYubiKeyManager.this.usbManager, usbDevice);
                this.devices.put(usbDevice, usbYubiKeyDevice);
                if (!this.usbConfiguration.isHandlePermissions() || usbYubiKeyDevice.hasPermission()) {
                    this.listener.invoke(usbYubiKeyDevice);
                } else {
                    com.yubico.yubikit.core.internal.Logger.debug(UsbYubiKeyManager.logger, "request permission");
                    UsbDeviceManager.requestPermission(UsbYubiKeyManager.this.context, usbDevice, new UsbDeviceManager.PermissionResultListener() { // from class: com.yubico.yubikit.android.transport.usb.d
                        @Override // com.yubico.yubikit.android.transport.usb.UsbDeviceManager.PermissionResultListener
                        public final void onPermissionResult(UsbDevice usbDevice2, boolean z) {
                            this.f8429a.lambda$deviceAttached$0(usbYubiKeyDevice, usbDevice2, z);
                        }
                    });
                }
            } catch (IllegalArgumentException unused) {
                com.yubico.yubikit.core.internal.Logger.debug(UsbYubiKeyManager.logger, "Attached usbDevice(vid={},pid={}) is not recognized as a valid YubiKey", Integer.valueOf(usbDevice.getVendorId()), Integer.valueOf(usbDevice.getProductId()));
            }
        }

        @Override // com.yubico.yubikit.android.transport.usb.UsbDeviceManager.UsbDeviceListener
        public void deviceRemoved(UsbDevice usbDevice) {
            UsbYubiKeyDevice usbYubiKeyDeviceRemove = this.devices.remove(usbDevice);
            if (usbYubiKeyDeviceRemove != null) {
                usbYubiKeyDeviceRemove.close();
            }
        }

        private MyDeviceListener(UsbConfiguration usbConfiguration, Callback<? super UsbYubiKeyDevice> callback) {
            this.devices = new HashMap();
            this.usbConfiguration = usbConfiguration;
            this.listener = callback;
        }
    }

    static {
        ConnectionManager.registerConnectionHandler(UsbSmartCardConnection.class, new SmartCardConnectionHandler());
        ConnectionManager.registerConnectionHandler(UsbOtpConnection.class, new OtpConnectionHandler());
        logger = LoggerFactory.getLogger((Class<?>) UsbYubiKeyManager.class);
    }

    public UsbYubiKeyManager(Context context) {
        this.context = context;
        this.usbManager = (UsbManager) context.getSystemService("usb");
    }

    public synchronized void disable() {
        MyDeviceListener myDeviceListener = this.internalListener;
        if (myDeviceListener != null) {
            UsbDeviceManager.unregisterUsbListener(this.context, myDeviceListener);
            this.internalListener = null;
        }
    }

    public synchronized void enable(UsbConfiguration usbConfiguration, Callback<? super UsbYubiKeyDevice> callback) {
        disable();
        MyDeviceListener myDeviceListener = new MyDeviceListener(usbConfiguration, callback);
        this.internalListener = myDeviceListener;
        UsbDeviceManager.registerUsbListener(this.context, myDeviceListener);
    }
}
