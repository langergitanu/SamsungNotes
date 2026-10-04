package com.samsung.android.app.sdk.deepsky.textextraction.ocrwrapper;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import com.samsung.android.app.sdk.deepsky.textextraction.logger.LibLogger;
import com.samsung.android.app.sdk.deepsky.textextraction.result.OcrResult;
import com.samsung.android.sdk.ocr.OCRLanguage;
import com.samsung.android.sdk.ocr.OCRResult;
import com.samsung.android.sdk.ocr.OCRType;
import com.samsung.android.sdk.ocr.Recognizer;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J;\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u001e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fJ(\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016J4\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00182\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0019\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J \u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0018\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u001e\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fJ(\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016J*\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00182\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001f"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/ocrwrapper/OcrWrapper;", "", "()V", SearchConstants.TargetContents.TAG, "", "detectBlock", "", "context", "Landroid/content/Context;", "bitmap", "Landroid/graphics/Bitmap;", "points", "", "Landroid/graphics/Point;", "language", "", "ocrType", "Lcom/samsung/android/sdk/ocr/OCRType;", "(Landroid/content/Context;Landroid/graphics/Bitmap;[Landroid/graphics/Point;ILcom/samsung/android/sdk/ocr/OCRType;)Z", "extractText", "Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult;", "validRect", "Landroid/graphics/Rect;", "extractTextFromRecognizer", "Lcom/samsung/android/sdk/ocr/OCRLanguage;", "getConvertedBitmap", "getConvertedLang", "isHandwritten", "isSupported", "isTextDetected", "isTextDetectedFromRecognizer", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class OcrWrapper {

    @NotNull
    public static final OcrWrapper INSTANCE = new OcrWrapper();

    @NotNull
    private static final String TAG = "OcrWrapper";

    private OcrWrapper() {
    }

    public static /* synthetic */ boolean detectBlock$default(OcrWrapper ocrWrapper, Context context, Bitmap bitmap, Point[] pointArr, int i, OCRType oCRType, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            oCRType = OCRType.OCR_ALL;
        }
        return ocrWrapper.detectBlock(context, bitmap, pointArr, i, oCRType);
    }

    public static /* synthetic */ OcrResult extractText$default(OcrWrapper ocrWrapper, Context context, Bitmap bitmap, int i, Rect rect, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = -1;
        }
        return ocrWrapper.extractText(context, bitmap, i, rect);
    }

    private final OcrResult extractTextFromRecognizer(Context context, Bitmap bitmap, OCRLanguage language, Rect validRect, OCRType ocrType) {
        Recognizer recognizer = new Recognizer(context, ocrType, language);
        OCRResult oCRResult = new OCRResult();
        LibLogger.m5432i(TAG, "extractText with Language");
        boolean zRecognize = recognizer.recognize(bitmap, oCRResult);
        recognizer.close();
        return zRecognize ? OcrResultConverter.toOcrResult$default(OcrResultConverter.INSTANCE, oCRResult, context, validRect, false, 4, null) : new OcrResult(CollectionsKt.emptyList(), null, null, 6, null);
    }

    public static /* synthetic */ OcrResult extractTextFromRecognizer$default(OcrWrapper ocrWrapper, Context context, Bitmap bitmap, OCRLanguage oCRLanguage, Rect rect, OCRType oCRType, int i, Object obj) {
        if ((i & 8) != 0) {
            rect = new Rect();
        }
        Rect rect2 = rect;
        if ((i & 16) != 0) {
            oCRType = OCRType.OCR_ALL;
        }
        return ocrWrapper.extractTextFromRecognizer(context, bitmap, oCRLanguage, rect2, oCRType);
    }

    private final Bitmap getConvertedBitmap(Bitmap bitmap, Rect validRect) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, validRect.left, validRect.top, validRect.width(), validRect.height());
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(\n          …idRect.height()\n        )");
        return bitmapCreateBitmap;
    }

    private final OCRLanguage getConvertedLang(int language) {
        return TextExtractionOCRLanguage.INSTANCE.getByValue(language).getConvertedId$deepsky_sdk_textextraction_8_0_19_release();
    }

    public static /* synthetic */ boolean isSupported$default(OcrWrapper ocrWrapper, Context context, OCRType oCRType, int i, Object obj) {
        if ((i & 2) != 0) {
            oCRType = OCRType.OCR_ALL;
        }
        return ocrWrapper.isSupported(context, oCRType);
    }

    public static /* synthetic */ boolean isTextDetected$default(OcrWrapper ocrWrapper, Context context, Bitmap bitmap, int i, Rect rect, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = -1;
        }
        return ocrWrapper.isTextDetected(context, bitmap, i, rect);
    }

    private final boolean isTextDetectedFromRecognizer(Context context, Bitmap bitmap, OCRLanguage language, OCRType ocrType) {
        Recognizer recognizer = new Recognizer(context, ocrType, language);
        boolean zDetectText = recognizer.detectText(bitmap);
        LibLogger.m5432i(TAG, "isTextDetected " + zDetectText);
        recognizer.close();
        return zDetectText;
    }

    public static /* synthetic */ boolean isTextDetectedFromRecognizer$default(OcrWrapper ocrWrapper, Context context, Bitmap bitmap, OCRLanguage oCRLanguage, OCRType oCRType, int i, Object obj) {
        if ((i & 8) != 0) {
            oCRType = OCRType.OCR_ALL;
        }
        return ocrWrapper.isTextDetectedFromRecognizer(context, bitmap, oCRLanguage, oCRType);
    }

    public final boolean detectBlock(@NotNull Context context, @NotNull Bitmap bitmap, @NotNull Point[] points, int language, @NotNull OCRType ocrType) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(points, "points");
        Intrinsics.checkNotNullParameter(ocrType, "ocrType");
        Recognizer recognizer = new Recognizer(context, ocrType, getConvertedLang(language));
        boolean zDetectBlock = recognizer.detectBlock(bitmap, points);
        LibLogger.m5432i(TAG, "detectBlock " + zDetectBlock);
        recognizer.close();
        return zDetectBlock;
    }

    @NotNull
    public final OcrResult extractText(@NotNull Context context, @NotNull Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        return extractTextFromRecognizer$default(this, context, bitmap, OCRLanguage.AUTO, null, null, 24, null);
    }

    public final boolean isHandwritten(@NotNull Context context, @Nullable Bitmap bitmap, int language) {
        Intrinsics.checkNotNullParameter(context, "context");
        Recognizer recognizer = new Recognizer(context, OCRType.OCR_HANDWRITTEN, getConvertedLang(language));
        boolean zIsHandwritten = recognizer.isHandwritten(bitmap);
        LibLogger.m5432i(TAG, "isHandwritten:" + zIsHandwritten);
        recognizer.close();
        return zIsHandwritten;
    }

    public final boolean isSupported(@NotNull Context context, @NotNull OCRType ocrType) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(ocrType, "ocrType");
        return Recognizer.isSupported(context, ocrType);
    }

    public final boolean isTextDetected(@NotNull Context context, @NotNull Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        return isTextDetectedFromRecognizer$default(this, context, bitmap, OCRLanguage.AUTO, null, 8, null);
    }

    @NotNull
    public final OcrResult extractText(@NotNull Context context, @NotNull Bitmap bitmap, int language) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        return extractTextFromRecognizer$default(this, context, bitmap, getConvertedLang(language), null, null, 24, null);
    }

    public final boolean isTextDetected(@NotNull Context context, @NotNull Bitmap bitmap, int language) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        return isTextDetectedFromRecognizer$default(this, context, bitmap, getConvertedLang(language), null, 8, null);
    }

    @NotNull
    public final OcrResult extractText(@NotNull Context context, @NotNull Bitmap bitmap, int language, @NotNull Rect validRect) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(validRect, "validRect");
        if (!validRect.isEmpty()) {
            bitmap = getConvertedBitmap(bitmap, validRect);
        }
        return extractTextFromRecognizer$default(this, context, bitmap, getConvertedLang(language), validRect, null, 16, null);
    }

    public final boolean isTextDetected(@NotNull Context context, @NotNull Bitmap bitmap, int language, @NotNull Rect validRect) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(validRect, "validRect");
        if (!validRect.isEmpty()) {
            bitmap = getConvertedBitmap(bitmap, validRect);
        }
        return isTextDetectedFromRecognizer$default(this, context, bitmap, getConvertedLang(language), null, 8, null);
    }
}
