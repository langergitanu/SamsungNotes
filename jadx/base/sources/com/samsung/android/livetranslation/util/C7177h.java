package com.samsung.android.livetranslation.util;

import com.samsung.android.imagetranslation.data.LttOcrResult;
import com.samsung.android.livetranslation.util.LineWidthRule;
import java.util.function.ToDoubleFunction;

/* JADX INFO: renamed from: com.samsung.android.livetranslation.util.h */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class C7177h implements ToDoubleFunction {
    @Override // java.util.function.ToDoubleFunction
    public final double applyAsDouble(Object obj) {
        return LineWidthRule.LineOutlierDetector.lambda$getStdDeviation$1((LttOcrResult.LineInfo) obj);
    }
}
