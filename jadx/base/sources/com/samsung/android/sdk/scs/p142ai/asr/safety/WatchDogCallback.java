package com.samsung.android.sdk.scs.p142ai.asr.safety;

import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@FunctionalInterface
@RestrictTo({RestrictTo.Scope.LIBRARY})
public interface WatchDogCallback {
    public static final WatchDogCallback doNothing = new C7700c();

    void onTimeoutDetected();

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ void lambda$static$0() {
    }
}
