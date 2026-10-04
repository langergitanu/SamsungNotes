package com.samsung.android.imagetranslation.util;

import com.samsung.android.imagetranslation.data.LttOcrResult;
import com.samsung.android.imagetranslation.util.ParagraphRenderLineBreaker;
import com.samsung.android.sdk.scs.p142ai.text.bnlp.Token;
import java.util.function.Predicate;

/* JADX INFO: renamed from: com.samsung.android.imagetranslation.util.j */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class C7141j implements Predicate {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4797a;

    public /* synthetic */ C7141j(int i) {
        this.f4797a = i;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f4797a) {
            case 0:
                return LineWidthRule.lambda$getScore$0((LttOcrResult.BlockInfo) obj);
            case 1:
                return NLPAnalyzer.lambda$isSentenceBlock$1((Token) obj);
            case 2:
                return ParagraphRenderLineBreaker.BulletParagraphDetector.lambda$new$0((LttOcrResult.LineInfo) obj);
            case 3:
                return OcrDataToSceneTextConverter.lambda$convert$0((LttOcrResult.BlockInfo) obj);
            case 4:
                return OcrDataToSceneTextConverter.lambda$convertStLines$2((LttOcrResult.LineInfo) obj);
            default:
                return OcrDataToSceneTextConverter.lambda$convertStWords$4((LttOcrResult.WordInfo) obj);
        }
    }
}
