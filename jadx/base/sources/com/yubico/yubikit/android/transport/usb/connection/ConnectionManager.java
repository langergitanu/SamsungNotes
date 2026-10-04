package com.yubico.yubikit.android.transport.usb.connection;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbManager;
import androidx.annotation.WorkerThread;
import com.yubico.yubikit.android.transport.usb.NoPermissionsException;
import com.yubico.yubikit.core.YubiKeyConnection;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ConnectionManager {
    private static final Map<Class<? extends YubiKeyConnection>, ConnectionHandler<?>> handlers = new HashMap();
    private final UsbDevice usbDevice;
    private final UsbManager usbManager;

    public ConnectionManager(UsbManager usbManager, UsbDevice usbDevice) {
        this.usbManager = usbManager;
        this.usbDevice = usbDevice;
    }

    @Nullable
    private <T extends YubiKeyConnection> ConnectionHandler<T> getHandler(Class<T> cls) {
        Map<Class<? extends YubiKeyConnection>, ConnectionHandler<?>> map = handlers;
        synchronized (map) {
            try {
                for (Map.Entry<Class<? extends YubiKeyConnection>, ConnectionHandler<?>> entry : map.entrySet()) {
                    if (cls.isAssignableFrom(entry.getKey())) {
                        return (ConnectionHandler) entry.getValue();
                    }
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private UsbDeviceConnection openDeviceConnection(UsbDevice usbDevice) throws NoPermissionsException {
        if (this.usbManager.hasPermission(usbDevice)) {
            return this.usbManager.openDevice(usbDevice);
        }
        throw new NoPermissionsException(usbDevice);
    }

    public static <T extends YubiKeyConnection> void registerConnectionHandler(Class<T> cls, ConnectionHandler<? extends T> connectionHandler) {
        Map<Class<? extends YubiKeyConnection>, ConnectionHandler<?>> map = handlers;
        synchronized (map) {
            map.put(cls, connectionHandler);
        }
    }

    @WorkerThread
    public <T extends YubiKeyConnection> T openConnection(Class<T> cls) throws IOException {
        ConnectionHandler<T> handler = getHandler(cls);
        if (handler == null) {
            throw new IllegalStateException("The connection type is not available via this transport");
        }
        UsbDeviceConnection usbDeviceConnectionOpenDeviceConnection = openDeviceConnection(this.usbDevice);
        try {
            return (T) handler.createConnection(this.usbDevice, usbDeviceConnectionOpenDeviceConnection);
        } catch (IOException e) {
            usbDeviceConnectionOpenDeviceConnection.close();
            throw e;
        }
    }

    public boolean supportsConnection(Class<? extends YubiKeyConnection> cls) {
        ConnectionHandler handler = getHandler(cls);
        return handler != null && handler.isAvailable(this.usbDevice);
    }
}
