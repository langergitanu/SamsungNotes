package com.yubico.yubikit.android.transport.usb.connection;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbInterface;
import com.yubico.yubikit.core.YubiKeyConnection;
import java.io.IOException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
abstract class InterfaceConnectionHandler<T extends YubiKeyConnection> implements ConnectionHandler<T> {
    private final int interfaceClass;
    private final int interfaceSubclass;

    public InterfaceConnectionHandler(int i, int i2) {
        this.interfaceClass = i;
        this.interfaceSubclass = i2;
    }

    @Nullable
    private UsbInterface getInterface(UsbDevice usbDevice) {
        for (int i = 0; i < usbDevice.getInterfaceCount(); i++) {
            UsbInterface usbInterface = usbDevice.getInterface(i);
            if (usbInterface.getInterfaceClass() == this.interfaceClass && usbInterface.getInterfaceSubclass() == this.interfaceSubclass) {
                return usbInterface;
            }
        }
        return null;
    }

    public UsbInterface getClaimedInterface(UsbDevice usbDevice, UsbDeviceConnection usbDeviceConnection) throws IOException {
        UsbInterface usbInterface = getInterface(usbDevice);
        if (usbInterface == null) {
            throw new IllegalStateException("The connection type is not available via this transport");
        }
        if (usbDeviceConnection.claimInterface(usbInterface, true)) {
            return usbInterface;
        }
        throw new IOException("Unable to claim interface");
    }

    @Override // com.yubico.yubikit.android.transport.usb.connection.ConnectionHandler
    public boolean isAvailable(UsbDevice usbDevice) {
        return getInterface(usbDevice) != null;
    }
}
