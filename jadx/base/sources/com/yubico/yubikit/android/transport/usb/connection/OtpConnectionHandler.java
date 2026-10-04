package com.yubico.yubikit.android.transport.usb.connection;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class OtpConnectionHandler extends InterfaceConnectionHandler<UsbOtpConnection> {
    public OtpConnectionHandler() {
        super(3, 1);
    }

    @Override // com.yubico.yubikit.android.transport.usb.connection.InterfaceConnectionHandler, com.yubico.yubikit.android.transport.usb.connection.ConnectionHandler
    public /* bridge */ /* synthetic */ boolean isAvailable(UsbDevice usbDevice) {
        return super.isAvailable(usbDevice);
    }

    @Override // com.yubico.yubikit.android.transport.usb.connection.ConnectionHandler
    public UsbOtpConnection createConnection(UsbDevice usbDevice, UsbDeviceConnection usbDeviceConnection) {
        return new UsbOtpConnection(usbDeviceConnection, getClaimedInterface(usbDevice, usbDeviceConnection));
    }
}
