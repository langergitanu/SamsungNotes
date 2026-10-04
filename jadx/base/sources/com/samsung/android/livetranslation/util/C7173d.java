package com.samsung.android.livetranslation.util;

import com.samsung.android.imagetranslation.data.LttOcrResult;
import com.samsung.android.livetranslation.util.LineWidthRule;
import java.util.function.Predicate;

/* JADX INFO: renamed from: com.samsung.android.livetranslation.util.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class C7173d implements Predicate {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4830a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f4831b;

    public /* synthetic */ C7173d(Object obj, int i) {
        this.f4830a = i;
        this.f4831b = obj;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f4830a) {
            case 0:
                return LineWidthRule.lambda$getScore$1((LineWidthRule.LineOutlierDetector) this.f4831b, (LttOcrResult.LineInfo) obj);
            default:
                return ((OcrDataToSceneTextConverter) this.f4831b).lambda$convertStChars$6((LttOcrResult.CharInfo) obj);
        }
    }
}
