package com.yubico.yubikit.android.transport.usb.connection;

import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbInterface;
import com.yubico.yubikit.core.otp.OtpConnection;
import java.io.IOException;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class UsbOtpConnection extends UsbYubiKeyConnection implements OtpConnection {
    private static final int HID_GET_REPORT = 1;
    private static final int HID_SET_REPORT = 9;
    private static final int RECIPIENT_INTERFACE = 1;
    private static final int REPORT_TYPE_FEATURE = 3;
    private static final int TIMEOUT = 1000;
    private static final int TYPE_CLASS = 32;
    private boolean closed;
    private final UsbDeviceConnection connection;
    private final UsbInterface hidInterface;

    public UsbOtpConnection(UsbDeviceConnection usbDeviceConnection, UsbInterface usbInterface) {
        super(usbDeviceConnection, usbInterface);
        this.closed = false;
        this.connection = usbDeviceConnection;
        this.hidInterface = usbInterface;
    }

    @Override // com.yubico.yubikit.android.transport.usb.connection.UsbYubiKeyConnection, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.closed = true;
        super.close();
    }

    public boolean isClosed() {
        return this.closed;
    }

    @Override // com.yubico.yubikit.core.otp.OtpConnection
    public void receive(byte[] bArr) throws IOException {
        int iControlTransfer = this.connection.controlTransfer(161, 1, 768, this.hidInterface.getId(), bArr, bArr.length, 1000);
        if (iControlTransfer != 8) {
            throw new IOException(AbstractC0000a.m11h(iControlTransfer, "Unexpected amount of data read: "));
        }
    }

    @Override // com.yubico.yubikit.core.otp.OtpConnection
    public void send(byte[] bArr) throws IOException {
        int iControlTransfer = this.connection.controlTransfer(33, 9, 768, this.hidInterface.getId(), bArr, bArr.length, 1000);
        if (iControlTransfer != 8) {
            throw new IOException(AbstractC0000a.m11h(iControlTransfer, "Unexpected amount of data sent: "));
        }
    }
}
