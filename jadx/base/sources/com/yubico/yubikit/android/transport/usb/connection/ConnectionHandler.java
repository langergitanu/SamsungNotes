package com.yubico.yubikit.android.transport.usb.connection;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import com.yubico.yubikit.core.YubiKeyConnection;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface ConnectionHandler<T extends YubiKeyConnection> {
    T createConnection(UsbDevice usbDevice, UsbDeviceConnection usbDeviceConnection);

    boolean isAvailable(UsbDevice usbDevice);
}
