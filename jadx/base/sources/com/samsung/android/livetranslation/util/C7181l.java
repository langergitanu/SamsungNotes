package com.samsung.android.livetranslation.util;

import com.samsung.android.imagetranslation.data.LttOcrResult;
import java.util.function.Function;

/* JADX INFO: renamed from: com.samsung.android.livetranslation.util.l */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class C7181l implements Function {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4837a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ OcrDataToSceneTextConverter f4838b;

    public /* synthetic */ C7181l(OcrDataToSceneTextConverter ocrDataToSceneTextConverter, int i) {
        this.f4837a = i;
        this.f4838b = ocrDataToSceneTextConverter;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f4837a) {
            case 0:
                return this.f4838b.lambda$convertStChars$7((LttOcrResult.CharInfo) obj);
            default:
                return this.f4838b.lambda$convertStWords$5((LttOcrResult.WordInfo) obj);
        }
    }
}
