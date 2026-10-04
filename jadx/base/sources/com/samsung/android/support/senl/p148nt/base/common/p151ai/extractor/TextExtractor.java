package com.samsung.android.support.senl.p148nt.base.common.p151ai.extractor;

import android.content.Context;
import android.graphics.Bitmap;
import com.samsung.android.app.sdk.deepsky.textextraction.result.OcrResult;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\b\u0010\f\u001a\u00020\tH\u0014¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/ai/extractor/TextExtractor;", "Lcom/samsung/android/support/senl/nt/base/common/ai/extractor/BaseOcrExtractor;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "release", "", "executeTextExtractor", "", "bitmap", "Landroid/graphics/Bitmap;", "getTag", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class TextExtractor extends BaseOcrExtractor {

    @NotNull
    private static final String TAG = "TextExtractor";

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextExtractor(@Nullable Context context) {
        super(context);
        Intrinsics.checkNotNull(context);
        Logger.m8697d(TAG, "init");
    }

    @NotNull
    public final String executeTextExtractor(@Nullable Bitmap bitmap) {
        OcrResult ocrResultExtractText;
        Iterator<OcrResult.WordInfo> it;
        if (bitmap == null || (ocrResultExtractText = extractText(bitmap)) == null || (it = ocrResultExtractText.getWordInfoList().iterator()) == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (it.hasNext()) {
            sb.append(it.next().getString());
            sb.append(" ");
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.p151ai.extractor.BaseOcrExtractor
    @NotNull
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.p151ai.extractor.BaseOcrExtractor
    public void release() {
        Logger.m8697d(TAG, "release");
        setTextExtraction(null);
        setTranslationTokenInfo(null);
        setMContext(null);
    }
}
