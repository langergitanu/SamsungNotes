package com.samsung.android.livetranslation.util;

import com.samsung.android.imagetranslation.data.LttOcrResult;
import com.samsung.android.livetranslation.util.LineWidthRule;
import java.util.function.ToIntFunction;

/* JADX INFO: renamed from: com.samsung.android.livetranslation.util.j */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class C7179j implements ToIntFunction {
    @Override // java.util.function.ToIntFunction
    public final int applyAsInt(Object obj) {
        return LineWidthRule.LineOutlierDetector.lambda$getMeanHeight$0((LttOcrResult.LineInfo) obj);
    }
}
