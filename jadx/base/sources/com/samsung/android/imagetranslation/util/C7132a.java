package com.samsung.android.imagetranslation.util;

import android.graphics.Point;
import com.samsung.android.imagetranslation.data.LttOcrResult;
import java.util.function.Function;

/* JADX INFO: renamed from: com.samsung.android.imagetranslation.util.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class C7132a implements Function {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4786a;

    public /* synthetic */ C7132a(int i) {
        this.f4786a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f4786a) {
            case 0:
                return BlockInfoUtil.lambda$getWordCount$1((LttOcrResult.LineInfo) obj);
            case 1:
                return BlockInfoUtil.lambda$getMaxLineWidth$0((LttOcrResult.LineInfo) obj);
            case 2:
                return ((LttOcrResult.LineInfo) obj).getString();
            default:
                return OCRResultUtils.lambda$calculateRotatedRect$0((Point) obj);
        }
    }
}
