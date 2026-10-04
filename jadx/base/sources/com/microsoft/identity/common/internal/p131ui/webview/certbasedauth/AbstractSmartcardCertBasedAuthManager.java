package com.microsoft.identity.common.internal.p131ui.webview.certbasedauth;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.microsoft.identity.common.java.opentelemetry.ICertBasedAuthTelemetryHelper;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractSmartcardCertBasedAuthManager {
    protected IConnectionCallback mConnectionCallback;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ISessionCallback {
        void onException(@NonNull Exception exc);

        void onGetSession(@NonNull ISmartcardSession iSmartcardSession);
    }

    public void clearConnectionCallback() {
        this.mConnectionCallback = null;
    }

    public abstract void initBeforeProceedingWithRequest(@NonNull ICertBasedAuthTelemetryHelper iCertBasedAuthTelemetryHelper);

    public abstract boolean isDeviceConnected();

    public abstract void onDestroy(@NonNull Activity activity);

    public abstract void requestDeviceSession(@NonNull ISessionCallback iSessionCallback);

    public void setConnectionCallback(@Nullable IConnectionCallback iConnectionCallback) {
        this.mConnectionCallback = iConnectionCallback;
    }

    public abstract boolean startDiscovery(@NonNull Activity activity);

    public abstract void stopDiscovery(@NonNull Activity activity);
}
