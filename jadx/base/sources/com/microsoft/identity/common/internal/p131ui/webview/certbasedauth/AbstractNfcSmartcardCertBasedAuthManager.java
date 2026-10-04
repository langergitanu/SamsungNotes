package com.microsoft.identity.common.internal.p131ui.webview.certbasedauth;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractNfcSmartcardCertBasedAuthManager extends AbstractSmartcardCertBasedAuthManager {
    protected boolean isDeviceChanged;

    public abstract void disconnect(@NonNull IDisconnectionCallback iDisconnectionCallback);

    public boolean isDeviceChanged() {
        return this.isDeviceChanged;
    }
}
