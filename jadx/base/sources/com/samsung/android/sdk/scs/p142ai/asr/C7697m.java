package com.samsung.android.sdk.scs.p142ai.asr;

import android.content.Context;
import java.util.function.Supplier;

/* JADX INFO: renamed from: com.samsung.android.sdk.scs.ai.asr.m */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C7697m implements Supplier {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5150a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f5151b;

    public /* synthetic */ C7697m(Object obj, int i) {
        this.f5150a = i;
        this.f5151b = obj;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f5150a) {
            case 0:
                return SpeechRecognizerControl.lambda$new$2((Context) this.f5151b);
            case 1:
                return Environment.getSupportedBTCLocaleInfosFromCP((Context) this.f5151b);
            case 2:
                return Environment.lambda$getSupportedLocales$4((Context) this.f5151b);
            case 3:
                return Environment.getSupportedServerLists((Context) this.f5151b);
            case 4:
                return Environment.getLangpackConfigInfoFromCP((Context) this.f5151b);
            default:
                return ((ExpiringData) this.f5151b).lambda$getOrCompute$3();
        }
    }
}
