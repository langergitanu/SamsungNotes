package com.samsung.android.mcf.continuity.api;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public interface ContinuityAdapter {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class ServiceStateListener {
        public abstract void onServiceConnected();

        public abstract void onServiceDisconnected();
    }

    boolean bindService(@NonNull Context context, @NonNull ServiceStateListener serviceStateListener);

    @Nullable
    ContinuityDiscoveryManager getContinuityDiscoveryManager();

    @Nullable
    ContinuitySessionManager getContinuitySessionManager();

    int initialize(@NonNull Context context, int i);

    void release(@NonNull Context context);

    void unbindService(@NonNull Context context);
}
