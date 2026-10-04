package com.samsung.android.sdk.scs.p142ai.asr_6_0;

import android.content.Context;
import java.util.function.Supplier;

/* JADX INFO: renamed from: com.samsung.android.sdk.scs.ai.asr_6_0.h */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C7720h implements Supplier {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5176a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f5177b;

    public /* synthetic */ C7720h(Object obj, int i) {
        this.f5176a = i;
        this.f5177b = obj;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f5176a) {
            case 0:
                return SpeechRecognizerControl.lambda$new$1((Context) this.f5177b);
            case 1:
                return Environment.getLangpackConfigInfoFromCP((Context) this.f5177b);
            case 2:
                return Environment.lambda$getSupportedLocales$4((Context) this.f5177b);
            case 3:
                return Environment.getSupportedBTCLocaleInfosFromCP((Context) this.f5177b);
            case 4:
                return Environment.getSupportedServerLists((Context) this.f5177b);
            default:
                return ((ExpiringData) this.f5177b).lambda$getOrCompute$3();
        }
    }
}
