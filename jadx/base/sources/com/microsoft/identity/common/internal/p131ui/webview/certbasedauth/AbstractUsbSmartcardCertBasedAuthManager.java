package com.microsoft.identity.common.internal.p131ui.webview.certbasedauth;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractUsbSmartcardCertBasedAuthManager extends AbstractSmartcardCertBasedAuthManager {
    protected IDisconnectionCallback mDisconnectionCallback;
    protected boolean mUsbDeviceInitiallyPluggedIn;

    public void clearDisconnectionCallback() {
        this.mDisconnectionCallback = null;
    }

    public boolean isUsbDeviceInitiallyPluggedIn() {
        return this.mUsbDeviceInitiallyPluggedIn;
    }

    public void setDisconnectionCallback(@Nullable IDisconnectionCallback iDisconnectionCallback) {
        this.mDisconnectionCallback = iDisconnectionCallback;
    }
}
