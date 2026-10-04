package com.yubico.yubikit.android.transport.usb;

import android.hardware.usb.UsbDevice;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class NoPermissionsException extends IOException {
    static final long serialVersionUID = 1;

    public NoPermissionsException(UsbDevice usbDevice) {
        super("No permission granted to communicate with device " + usbDevice.getProductName());
    }
}
