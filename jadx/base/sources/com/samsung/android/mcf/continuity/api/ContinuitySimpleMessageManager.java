package com.samsung.android.mcf.continuity.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public interface ContinuitySimpleMessageManager extends ContinuityMessageManager {
    @Nullable
    String getMessageIntentAction();

    boolean registerMessageIntentListener(@NonNull String str, @NonNull String str2);

    boolean sendMessage(@NonNull String str, @NonNull byte[] bArr);

    void unregisterMessageIntentListener();
}
