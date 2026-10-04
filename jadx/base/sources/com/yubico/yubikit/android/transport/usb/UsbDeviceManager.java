package com.yubico.yubikit.android.transport.usb;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.os.Build;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.WeakHashMap;
import javax.annotation.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
final class UsbDeviceManager {
    private static final String ACTION_USB_PERMISSION = "com.yubico.yubikey.USB_PERMISSION";
    public static final int YUBICO_VENDOR_ID = 4176;

    @Nullable
    private static UsbDeviceManager instance;
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) UsbDeviceManager.class);
    private final DeviceBroadcastReceiver broadcastReceiver;
    private final PermissionBroadcastReceiver permissionReceiver;
    private final Set<UsbDeviceListener> deviceListeners = new HashSet();
    private final WeakHashMap<UsbDevice, Set<PermissionResultListener>> contexts = new WeakHashMap<>();
    private final Set<UsbDevice> awaitingPermissions = new HashSet();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class DeviceBroadcastReceiver extends BroadcastReceiver {
        private DeviceBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            UsbDevice usbDevice = (UsbDevice) intent.getParcelableExtra("device");
            if (usbDevice == null || usbDevice.getVendorId() != 4176) {
                return;
            }
            if ("android.hardware.usb.action.USB_DEVICE_ATTACHED".equals(action)) {
                UsbDeviceManager.this.onDeviceAttach(usbDevice);
            } else if ("android.hardware.usb.action.USB_DEVICE_DETACHED".equals(action)) {
                UsbDeviceManager.this.onDeviceDetach(context, usbDevice);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class PermissionBroadcastReceiver extends BroadcastReceiver {
        private PermissionBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (UsbDeviceManager.ACTION_USB_PERMISSION.equals(intent.getAction())) {
                UsbDevice usbDevice = (UsbDevice) intent.getParcelableExtra("device");
                UsbManager usbManager = (UsbManager) context.getSystemService("usb");
                if (usbDevice != null) {
                    UsbDeviceManager.this.onPermission(context, usbDevice, usbManager.hasPermission(usbDevice));
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface PermissionResultListener {
        void onPermissionResult(UsbDevice usbDevice, boolean z);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface UsbDeviceListener {
        void deviceAttached(UsbDevice usbDevice);

        void deviceRemoved(UsbDevice usbDevice);
    }

    public UsbDeviceManager() {
        this.broadcastReceiver = new DeviceBroadcastReceiver();
        this.permissionReceiver = new PermissionBroadcastReceiver();
    }

    private synchronized void addUsbListener(Context context, UsbDeviceListener usbDeviceListener) {
        try {
            if (this.deviceListeners.isEmpty()) {
                Collection<UsbDevice> collectionValues = ((UsbManager) context.getSystemService("usb")).getDeviceList().values();
                IntentFilter intentFilter = new IntentFilter("android.hardware.usb.action.USB_DEVICE_ATTACHED");
                intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_DETACHED");
                context.registerReceiver(this.broadcastReceiver, intentFilter);
                for (UsbDevice usbDevice : collectionValues) {
                    if (usbDevice.getVendorId() == 4176) {
                        onDeviceAttach(usbDevice);
                    }
                }
            }
            this.deviceListeners.add(usbDeviceListener);
            Iterator<UsbDevice> it = this.contexts.keySet().iterator();
            while (it.hasNext()) {
                usbDeviceListener.deviceAttached(it.next());
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private static synchronized UsbDeviceManager getInstance() {
        try {
            if (instance == null) {
                instance = new UsbDeviceManager();
            }
        } catch (Throwable th) {
            throw th;
        }
        return instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDeviceAttach(UsbDevice usbDevice) {
        com.yubico.yubikit.core.internal.Logger.debug(logger, "UsbDevice attached: {}", usbDevice.getDeviceName());
        this.contexts.put(usbDevice, new HashSet());
        Iterator<UsbDeviceListener> it = this.deviceListeners.iterator();
        while (it.hasNext()) {
            it.next().deviceAttached(usbDevice);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDeviceDetach(Context context, UsbDevice usbDevice) {
        com.yubico.yubikit.core.internal.Logger.debug(logger, "UsbDevice detached: {}", usbDevice.getDeviceName());
        if (this.contexts.remove(usbDevice) != null) {
            Iterator<UsbDeviceListener> it = this.deviceListeners.iterator();
            while (it.hasNext()) {
                it.next().deviceRemoved(usbDevice);
            }
        }
        synchronized (this.awaitingPermissions) {
            try {
                if (this.awaitingPermissions.remove(usbDevice) && this.awaitingPermissions.isEmpty()) {
                    context.unregisterReceiver(this.permissionReceiver);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPermission(Context context, UsbDevice usbDevice, boolean z) {
        com.yubico.yubikit.core.internal.Logger.debug(logger, "Permission result for {}, permitted: {}", usbDevice.getDeviceName(), Boolean.valueOf(z));
        Set<PermissionResultListener> set = this.contexts.get(usbDevice);
        if (set != null) {
            synchronized (set) {
                try {
                    Iterator<PermissionResultListener> it = set.iterator();
                    while (it.hasNext()) {
                        it.next().onPermissionResult(usbDevice, z);
                    }
                    set.clear();
                } finally {
                }
            }
        }
        synchronized (this.awaitingPermissions) {
            try {
                if (this.awaitingPermissions.remove(usbDevice) && this.awaitingPermissions.isEmpty()) {
                    context.unregisterReceiver(this.permissionReceiver);
                }
            } finally {
            }
        }
    }

    @SuppressLint({"UnspecifiedRegisterReceiverFlag"})
    private static void registerPermissionsReceiver(Context context, PermissionBroadcastReceiver permissionBroadcastReceiver) {
        if (Build.VERSION.SDK_INT >= 33) {
            context.registerReceiver(permissionBroadcastReceiver, new IntentFilter(ACTION_USB_PERMISSION), 4);
        } else {
            context.registerReceiver(permissionBroadcastReceiver, new IntentFilter(ACTION_USB_PERMISSION));
        }
    }

    public static void registerUsbListener(Context context, UsbDeviceListener usbDeviceListener) {
        getInstance().addUsbListener(context, usbDeviceListener);
    }

    private synchronized void removeUsbListener(Context context, UsbDeviceListener usbDeviceListener) {
        try {
            this.deviceListeners.remove(usbDeviceListener);
            Iterator<UsbDevice> it = this.contexts.keySet().iterator();
            while (it.hasNext()) {
                usbDeviceListener.deviceRemoved(it.next());
            }
            if (this.deviceListeners.isEmpty()) {
                context.unregisterReceiver(this.broadcastReceiver);
                this.contexts.clear();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private synchronized void requestDevicePermission(Context context, UsbDevice usbDevice, PermissionResultListener permissionResultListener) {
        Set<PermissionResultListener> set = this.contexts.get(usbDevice);
        Objects.requireNonNull(set);
        Set<PermissionResultListener> set2 = set;
        synchronized (set2) {
            set2.add(permissionResultListener);
        }
        synchronized (this.awaitingPermissions) {
            try {
                if (!this.awaitingPermissions.contains(usbDevice)) {
                    if (this.awaitingPermissions.isEmpty()) {
                        registerPermissionsReceiver(context, this.permissionReceiver);
                    }
                    com.yubico.yubikit.core.internal.Logger.debug(logger, "Requesting permission for UsbDevice: {}", usbDevice.getDeviceName());
                    int i = Build.VERSION.SDK_INT >= 31 ? 33554432 : 0;
                    Intent intent = new Intent(ACTION_USB_PERMISSION);
                    intent.setPackage(context.getPackageName());
                    ((UsbManager) context.getSystemService("usb")).requestPermission(usbDevice, PendingIntent.getBroadcast(context, 0, intent, i));
                    this.awaitingPermissions.add(usbDevice);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void requestPermission(Context context, UsbDevice usbDevice, PermissionResultListener permissionResultListener) {
        getInstance().requestDevicePermission(context, usbDevice, permissionResultListener);
    }

    public static void unregisterUsbListener(Context context, UsbDeviceListener usbDeviceListener) {
        getInstance().removeUsbListener(context, usbDeviceListener);
    }
}
