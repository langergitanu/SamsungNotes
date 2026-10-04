package com.samsung.android.imagetranslation.util;

import com.samsung.android.imagetranslation.data.LttOcrResult;
import com.samsung.android.imagetranslation.util.BrokenLineDetector;
import com.samsung.android.imagetranslation.util.LineWidthRule;
import java.util.function.Consumer;

/* JADX INFO: renamed from: com.samsung.android.imagetranslation.util.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class C7135d implements Consumer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4787a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f4788b;

    public /* synthetic */ C7135d(Object obj, int i) {
        this.f4787a = i;
        this.f4788b = obj;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f4787a) {
            case 0:
                BrokenLineDetector.lambda$new$0((BrokenLineDetector.C71291) this.f4788b, (LttOcrResult.LineInfo) obj);
                break;
            default:
                LineWidthRule.lambda$getScore$2((LineWidthRule.C71312) this.f4788b, (LttOcrResult.LineInfo) obj);
                break;
        }
    }
}
