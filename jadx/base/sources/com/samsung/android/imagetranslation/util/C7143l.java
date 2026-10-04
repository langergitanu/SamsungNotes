package com.samsung.android.imagetranslation.util;

import com.samsung.android.imagetranslation.data.LttOcrResult;
import com.samsung.android.imagetranslation.util.LineWidthRule;
import java.util.function.ToDoubleFunction;

/* JADX INFO: renamed from: com.samsung.android.imagetranslation.util.l */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class C7143l implements ToDoubleFunction {
    @Override // java.util.function.ToDoubleFunction
    public final double applyAsDouble(Object obj) {
        return LineWidthRule.LineOutlierDetector.lambda$getStdDeviation$1((LttOcrResult.LineInfo) obj);
    }
}
