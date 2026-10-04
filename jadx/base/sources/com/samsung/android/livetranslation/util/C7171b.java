package com.samsung.android.livetranslation.util;

import com.samsung.android.imagetranslation.data.LttOcrResult;
import com.samsung.android.livetranslation.util.BrokenLineDetector;
import com.samsung.android.livetranslation.util.LineWidthRule;
import java.util.function.Consumer;

/* JADX INFO: renamed from: com.samsung.android.livetranslation.util.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class C7171b implements Consumer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4826a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f4827b;

    public /* synthetic */ C7171b(Object obj, int i) {
        this.f4826a = i;
        this.f4827b = obj;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f4826a) {
            case 0:
                BrokenLineDetector.lambda$new$0((BrokenLineDetector.C71671) this.f4827b, (LttOcrResult.LineInfo) obj);
                break;
            default:
                LineWidthRule.lambda$getScore$2((LineWidthRule.C71692) this.f4827b, (LttOcrResult.LineInfo) obj);
                break;
        }
    }
}
