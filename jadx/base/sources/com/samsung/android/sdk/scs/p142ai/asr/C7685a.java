package com.samsung.android.sdk.scs.p142ai.asr;

import android.content.Context;
import android.os.Bundle;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: renamed from: com.samsung.android.sdk.scs.ai.asr.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C7685a implements Function {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5126a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f5127b;

    public /* synthetic */ C7685a(Object obj, int i) {
        this.f5126a = i;
        this.f5127b = obj;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f5126a) {
            case 0:
                return Environment.lambda$getSupportedLocalesFromCP$20((Context) this.f5127b, (Bundle) obj);
            default:
                return Boolean.valueOf(((List) this.f5127b).remove((Runnable) obj));
        }
    }
}
