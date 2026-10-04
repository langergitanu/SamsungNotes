package com.samsung.android.sdk.scs.p142ai.asr.tasks;

import com.samsung.android.sdk.scs.p142ai.asr.DictationType;
import java.io.InputStream;
import java.util.function.Function;

/* JADX INFO: renamed from: com.samsung.android.sdk.scs.ai.asr.tasks.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C7709a implements Function {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5160a;

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int iOrdinal;
        switch (this.f5160a) {
            case 0:
                iOrdinal = ((DictationType) obj).ordinal();
                break;
            case 1:
                iOrdinal = ((InputStream) obj).hashCode();
                break;
            default:
                iOrdinal = ((String) obj).length();
                break;
        }
        return Integer.valueOf(iOrdinal);
    }
}
