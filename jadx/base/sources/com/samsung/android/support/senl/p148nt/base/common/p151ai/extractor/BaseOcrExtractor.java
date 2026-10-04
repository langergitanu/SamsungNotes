package com.samsung.android.support.senl.p148nt.base.common.p151ai.extractor;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import com.samsung.android.app.sdk.deepsky.textextraction.Recognizer;
import com.samsung.android.app.sdk.deepsky.textextraction.TextExtraction;
import com.samsung.android.app.sdk.deepsky.textextraction.TextExtractionProvider;
import com.samsung.android.app.sdk.deepsky.textextraction.ocrwrapper.TextExtractionOCRLanguage;
import com.samsung.android.app.sdk.deepsky.textextraction.result.OcrResult;
import com.samsung.android.app.sdk.deepsky.textextraction.translate.TranslationTokenInfo;
import com.samsung.android.sdk.ocr.OCRType;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.SCSTools;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b&\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u001b\u001a\u00020\u001cH\u0004J\u0010\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"J\b\u0010#\u001a\u00020\u001cH$J\b\u0010$\u001a\u00020%H$R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0084\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001d\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006&"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/ai/extractor/BaseOcrExtractor;", "", "mContext", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getMContext", "()Landroid/content/Context;", "setMContext", "isSupported", "", "()Ljava/lang/Boolean;", "setSupported", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "textExtraction", "Lcom/samsung/android/app/sdk/deepsky/textextraction/TextExtraction;", "getTextExtraction", "()Lcom/samsung/android/app/sdk/deepsky/textextraction/TextExtraction;", "setTextExtraction", "(Lcom/samsung/android/app/sdk/deepsky/textextraction/TextExtraction;)V", "translationTokenInfo", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/TranslationTokenInfo;", "getTranslationTokenInfo", "()Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/TranslationTokenInfo;", "setTranslationTokenInfo", "(Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/TranslationTokenInfo;)V", "initialize", "", "isSupportedOCR", "()Z", "extractText", "Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult;", "bitmap", "Landroid/graphics/Bitmap;", "release", "getTag", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nBaseOcrExtractor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseOcrExtractor.kt\ncom/samsung/android/support/senl/nt/base/common/ai/extractor/BaseOcrExtractor\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,78:1\n1#2:79\n*E\n"})
public abstract class BaseOcrExtractor {

    @Nullable
    private Boolean isSupported;

    @Nullable
    private Context mContext;

    @Nullable
    private TextExtraction textExtraction;

    @Nullable
    private TranslationTokenInfo translationTokenInfo;

    public BaseOcrExtractor(@Nullable Context context) {
        this.mContext = context;
        Logger.m8697d(getTag(), "initialize");
        initialize();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a2  */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.samsung.android.app.sdk.deepsky.textextraction.Recognizer] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r3v0, types: [int] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final OcrResult extractText(@NotNull Bitmap bitmap) throws Throwable {
        Recognizer recognizer;
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        int width = bitmap.getWidth();
        ?? height = bitmap.getHeight();
        Rect rect = new Rect(0, 0, width, height);
        ?? r2 = 0;
        try {
            try {
                TextExtraction textExtraction = this.textExtraction;
                recognizer = textExtraction != null ? textExtraction.getRecognizer() : null;
                if (recognizer != null) {
                    try {
                        recognizer.initialize(TextExtractionOCRLanguage.All.getId());
                    } catch (Exception e) {
                        e = e;
                        Logger.m8698e(getTag(), "extractText# fail, " + e.getMessage());
                        if (recognizer != null) {
                            recognizer.release();
                        }
                        return null;
                    }
                }
                if (!Intrinsics.areEqual(recognizer != null ? Boolean.valueOf(recognizer.detectText(bitmap)) : null, Boolean.TRUE)) {
                    Logger.m8697d(getTag(), "extractText# fail, Texts were not detected");
                    if (recognizer != null) {
                        recognizer.release();
                    }
                    return null;
                }
                OcrResult ocrResultExtractText = recognizer.extractText(bitmap, rect);
                if (ocrResultExtractText.getBlockInfoList().isEmpty()) {
                    Logger.m8697d(getTag(), "extractText# fail, Block list size is empty");
                    recognizer.release();
                    return null;
                }
                recognizer.release();
                Logger.m8697d(getTag(), "extractText# success");
                return ocrResultExtractText;
            } catch (Throwable th) {
                th = th;
                r2 = height;
                if (r2 != 0) {
                    r2.release();
                }
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            recognizer = null;
        } catch (Throwable th2) {
            th = th2;
            if (r2 != 0) {
            }
            throw th;
        }
    }

    @Nullable
    public final Context getMContext() {
        return this.mContext;
    }

    @NotNull
    public abstract String getTag();

    @Nullable
    public final TextExtraction getTextExtraction() {
        return this.textExtraction;
    }

    @Nullable
    public final TranslationTokenInfo getTranslationTokenInfo() {
        return this.translationTokenInfo;
    }

    public final void initialize() {
        Context context = this.mContext;
        TextExtraction textExtraction = context != null ? TextExtractionProvider.INSTANCE.with(context).getTextExtraction() : null;
        this.textExtraction = textExtraction;
        if (textExtraction != null) {
            this.translationTokenInfo = SCSTools.makeTranslationAppInfo();
        } else {
            Logger.m8698e(getTag(), "initialize# TextExtraction is null!");
            this.isSupported = Boolean.FALSE;
        }
    }

    @Nullable
    /* JADX INFO: renamed from: isSupported, reason: from getter */
    public final Boolean getIsSupported() {
        return this.isSupported;
    }

    public final boolean isSupportedOCR() {
        if (this.isSupported == null) {
            TextExtraction textExtraction = this.textExtraction;
            boolean z = false;
            if (textExtraction != null && true == textExtraction.isSupported(OCRType.OCR_ALL)) {
                z = true;
            }
            this.isSupported = Boolean.valueOf(z);
        }
        Boolean bool = this.isSupported;
        Intrinsics.checkNotNull(bool);
        return bool.booleanValue();
    }

    public abstract void release();

    public final void setMContext(@Nullable Context context) {
        this.mContext = context;
    }

    public final void setSupported(@Nullable Boolean bool) {
        this.isSupported = bool;
    }

    public final void setTextExtraction(@Nullable TextExtraction textExtraction) {
        this.textExtraction = textExtraction;
    }

    public final void setTranslationTokenInfo(@Nullable TranslationTokenInfo translationTokenInfo) {
        this.translationTokenInfo = translationTokenInfo;
    }
}
