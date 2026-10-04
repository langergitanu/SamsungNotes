package com.samsung.android.mcf.continuity.api;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public interface ContinuityMessageManager {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class MessageListener {
        public abstract void onReceived(@NonNull String str, @NonNull byte[] bArr);
    }

    boolean registerMessageListener(@NonNull MessageListener messageListener);

    void unregisterMessageListener();
}
