package com.yubico.yubikit.android.transport.usb.connection;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import android.util.Pair;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SmartCardConnectionHandler extends InterfaceConnectionHandler<UsbSmartCardConnection> {
    public SmartCardConnectionHandler() {
        super(11, 0);
    }

    private Pair<UsbEndpoint, UsbEndpoint> findEndpoints(UsbInterface usbInterface) {
        UsbEndpoint usbEndpoint = null;
        UsbEndpoint usbEndpoint2 = null;
        for (int i = 0; i < usbInterface.getEndpointCount(); i++) {
            UsbEndpoint endpoint = usbInterface.getEndpoint(i);
            if (endpoint.getType() == 2) {
                if (endpoint.getDirection() == 128) {
                    usbEndpoint = endpoint;
                } else {
                    usbEndpoint2 = endpoint;
                }
            }
        }
        if (usbEndpoint == null || usbEndpoint2 == null) {
            throw new IllegalStateException("Missing CCID bulk endpoints");
        }
        return new Pair<>(usbEndpoint, usbEndpoint2);
    }

    @Override // com.yubico.yubikit.android.transport.usb.connection.InterfaceConnectionHandler, com.yubico.yubikit.android.transport.usb.connection.ConnectionHandler
    public /* bridge */ /* synthetic */ boolean isAvailable(UsbDevice usbDevice) {
        return super.isAvailable(usbDevice);
    }

    @Override // com.yubico.yubikit.android.transport.usb.connection.ConnectionHandler
    public UsbSmartCardConnection createConnection(UsbDevice usbDevice, UsbDeviceConnection usbDeviceConnection) throws IOException {
        UsbInterface claimedInterface = getClaimedInterface(usbDevice, usbDeviceConnection);
        Pair<UsbEndpoint, UsbEndpoint> pairFindEndpoints = findEndpoints(claimedInterface);
        return new UsbSmartCardConnection(usbDeviceConnection, claimedInterface, (UsbEndpoint) pairFindEndpoints.first, (UsbEndpoint) pairFindEndpoints.second);
    }
}
