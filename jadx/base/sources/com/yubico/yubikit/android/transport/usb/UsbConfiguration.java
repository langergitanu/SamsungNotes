package com.yubico.yubikit.android.transport.usb;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class UsbConfiguration {
    private boolean handlePermissions = true;

    public UsbConfiguration handlePermissions(boolean z) {
        this.handlePermissions = z;
        return this;
    }

    public boolean isHandlePermissions() {
        return this.handlePermissions;
    }
}
