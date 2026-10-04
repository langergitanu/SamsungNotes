package com.samsung.android.imagetranslation.util;

import com.samsung.android.imagetranslation.data.LttOcrResult;
import java.util.function.Function;

/* JADX INFO: renamed from: com.samsung.android.imagetranslation.util.q */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class C7148q implements Function {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4804a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ OcrDataToSceneTextConverter f4805b;

    public /* synthetic */ C7148q(OcrDataToSceneTextConverter ocrDataToSceneTextConverter, int i) {
        this.f4804a = i;
        this.f4805b = ocrDataToSceneTextConverter;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f4804a) {
            case 0:
                return this.f4805b.lambda$convertStChars$7((LttOcrResult.CharInfo) obj);
            default:
                return this.f4805b.lambda$convertStWords$5((LttOcrResult.WordInfo) obj);
        }
    }
}
