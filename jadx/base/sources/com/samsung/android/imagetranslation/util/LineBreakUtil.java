package com.samsung.android.imagetranslation.util;

import android.content.Context;
import androidx.annotation.NonNull;
import com.samsung.android.imagetranslation.common.LTTLogger;
import com.samsung.android.imagetranslation.data.LttOcrResult;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class LineBreakUtil {
    private static final String TAG = "LineBreakUtil";
    private LttOcrResult ocrResult;

    public LineBreakUtil(LttOcrResult lttOcrResult) {
        this.ocrResult = lttOcrResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$initResultWithSourceText$0(LineBreaker lineBreaker, LineBreaker lineBreaker2, LttOcrResult.BlockInfo blockInfo) {
        return Discriminator.isParagraph(blockInfo) ? lineBreaker.getLinedString(blockInfo) : lineBreaker2.getLinedString(blockInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$initResultWithSourceText$1(LineBreaker lineBreaker, Context context, LineBreaker lineBreaker2, LttOcrResult.BlockInfo blockInfo) {
        return Discriminator.isParagraph(blockInfo) ? lineBreaker.getLinedString(blockInfo) : Discriminator.isShortSentence(context, blockInfo) ? blockInfo.getString() : lineBreaker2.getLinedString(blockInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$initResultWithSourceText$2(String str) {
        LTTLogger.m5458d("Discriminator", "result : " + str);
    }

    @Deprecated
    public List<String> initResultWithSourceText(@NonNull List<LttOcrResult.BlockInfo> list) {
        LTTLogger.m5458d(TAG, "initResultWithSourceText");
        final ParagraphRenderLineBreaker paragraphRenderLineBreaker = new ParagraphRenderLineBreaker();
        final LineRenderLineBreaker lineRenderLineBreaker = new LineRenderLineBreaker();
        return (List) list.stream().map(new Function() { // from class: com.samsung.android.imagetranslation.util.e
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return LineBreakUtil.lambda$initResultWithSourceText$0(paragraphRenderLineBreaker, lineRenderLineBreaker, (LttOcrResult.BlockInfo) obj);
            }
        }).collect(Collectors.toList());
    }

    public static List<String> initResultWithSourceText(@NonNull final Context context, @NonNull List<LttOcrResult.BlockInfo> list) {
        LTTLogger.m5458d(TAG, "initResultWithSourceText with Context");
        final ParagraphRenderLineBreaker paragraphRenderLineBreaker = new ParagraphRenderLineBreaker();
        final LineRenderLineBreaker lineRenderLineBreaker = new LineRenderLineBreaker();
        return (List) list.stream().map(new Function() { // from class: com.samsung.android.imagetranslation.util.f
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return LineBreakUtil.lambda$initResultWithSourceText$1(paragraphRenderLineBreaker, context, lineRenderLineBreaker, (LttOcrResult.BlockInfo) obj);
            }
        }).peek(new C7138g()).collect(Collectors.toList());
    }
}
