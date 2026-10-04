package com.samsung.android.mcf.continuity.api;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public interface ContinuitySessionMessageManager extends ContinuityMessageManager {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class SendMessageCallback {
        public abstract void onResult(int i);
    }

    boolean sendMessage(@NonNull String str, @NonNull byte[] bArr, int i, @NonNull SendMessageCallback sendMessageCallback);
}
