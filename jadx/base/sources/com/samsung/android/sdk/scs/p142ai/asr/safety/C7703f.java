package com.samsung.android.sdk.scs.p142ai.asr.safety;

import java.util.function.BooleanSupplier;

/* JADX INFO: renamed from: com.samsung.android.sdk.scs.ai.asr.safety.f */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C7703f implements BooleanSupplier {
    @Override // java.util.function.BooleanSupplier
    public final boolean getAsBoolean() {
        return WatchDogService.isWatching();
    }
}
