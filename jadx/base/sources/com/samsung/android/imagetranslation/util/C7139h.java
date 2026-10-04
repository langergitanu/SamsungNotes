package com.samsung.android.imagetranslation.util;

import android.content.Context;
import com.samsung.android.imagetranslation.data.LttOcrResult;
import com.samsung.android.imagetranslation.util.LineWidthRule;
import java.util.function.Predicate;

/* JADX INFO: renamed from: com.samsung.android.imagetranslation.util.h */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class C7139h implements Predicate {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4794a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f4795b;

    public /* synthetic */ C7139h(Object obj, int i) {
        this.f4794a = i;
        this.f4795b = obj;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f4794a) {
            case 0:
                return LineWidthRule.lambda$getScore$1((LineWidthRule.LineOutlierDetector) this.f4795b, (LttOcrResult.LineInfo) obj);
            case 1:
                return NLPAnalyzer.lambda$new$0((Context) this.f4795b, (String) obj);
            default:
                return ((OcrDataToSceneTextConverter) this.f4795b).lambda$convertStChars$6((LttOcrResult.CharInfo) obj);
        }
    }
}
