package com.samsung.android.app.sdk.deepsky.textextraction;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Looper;
import com.samsung.android.app.sdk.deepsky.textextraction.entity.EntityType;
import com.samsung.android.app.sdk.deepsky.textextraction.logger.LibLogger;
import com.samsung.android.app.sdk.deepsky.textextraction.logger.LogUtil;
import com.samsung.android.app.sdk.deepsky.textextraction.ocrwrapper.OcrResultConverter;
import com.samsung.android.app.sdk.deepsky.textextraction.ocrwrapper.TextExtractionOCRLanguage;
import com.samsung.android.app.sdk.deepsky.textextraction.result.OcrResult;
import com.samsung.android.sdk.ocr.OCRResult;
import com.samsung.android.sdk.ocr.OCRType;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u0000 *2\u00020\u0001:\u0001*B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\t\u001a\u00020\bH\u0002J#\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016¢\u0006\u0002\u0010\u0011J#\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0018\u0010\u001a\u001a\u00020\u00182\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u001b\u001a\u00020\u00182\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J \u0010\u001c\u001a\u00020\u00182\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u000bH\u0016J \u0010\u001f\u001a\u00020\u00182\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u000bH\u0002J$\u0010 \u001a\u00020\u00182\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010!\u001a\u00020\u000bH\u0002J$\u0010\"\u001a\u00020\u00182\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010!\u001a\u00020\u000bH\u0002J\u0018\u0010#\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010$\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010$\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010%\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010&\u001a\u00020\b2\u0006\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/RecognizerImpl;", "Lcom/samsung/android/app/sdk/deepsky/textextraction/Recognizer;", "context", "Landroid/content/Context;", "recognizer", "Lcom/samsung/android/sdk/ocr/Recognizer;", "(Landroid/content/Context;Lcom/samsung/android/sdk/ocr/Recognizer;)V", "checkIfRecognizerValid", "", "checkThread", "detectBlock", "", "bitmap", "Landroid/graphics/Bitmap;", "points", "", "Landroid/graphics/Point;", "(Landroid/graphics/Bitmap;[Landroid/graphics/Point;)Z", "detectBlockWithOcrRecognizer", "detectText", "validRect", "Landroid/graphics/Rect;", "detectTextWithOcrRecognizer", "extractEntityInfoFromOcrResult", "Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult;", "ocrResult", "extractOcrTextOnly", "extractText", "extractTextAt", "point", "isSurroundingBlockAllowed", "extractTextAtWithOcrRecognizer", "extractTextInternal", "extractTextOnly", "extractTextWithOcrRecognizer", "getBitmapWithinRect", "hasText", "hasTextWithOcrRecognizer", "initialize", "language", "", "release", "Companion", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class RecognizerImpl implements Recognizer {

    @NotNull
    private static final String TAG = "RecognizerImpl";

    @NotNull
    private final Context context;

    @Nullable
    private com.samsung.android.sdk.ocr.Recognizer recognizer;

    public RecognizerImpl(@NotNull Context context, @Nullable com.samsung.android.sdk.ocr.Recognizer recognizer) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.recognizer = recognizer;
    }

    private final void checkIfRecognizerValid() {
        if (this.recognizer == null) {
            throw new IllegalStateException("Recognizer is not initialized");
        }
    }

    private final void checkThread() {
        if (Intrinsics.areEqual(Thread.currentThread(), Looper.getMainLooper().getThread())) {
            throw new IllegalStateException("Should be called on worker thread");
        }
    }

    private final boolean detectBlockWithOcrRecognizer(Bitmap bitmap, Point[] points) {
        com.samsung.android.sdk.ocr.Recognizer recognizer = this.recognizer;
        boolean zDetectBlock = recognizer != null ? recognizer.detectBlock(bitmap, points) : false;
        LibLogger.m5432i(TAG, "detectBlockFromRecognizer detectBlock=" + zDetectBlock);
        return zDetectBlock;
    }

    private final boolean detectTextWithOcrRecognizer(Bitmap bitmap) {
        com.samsung.android.sdk.ocr.Recognizer recognizer = this.recognizer;
        boolean zDetectText = recognizer != null ? recognizer.detectText(bitmap) : false;
        LibLogger.m5432i(TAG, "detectTextWithOcrRecognizer detectText=" + zDetectText);
        return zDetectText;
    }

    private final OcrResult extractTextAtWithOcrRecognizer(Bitmap bitmap, Point point, boolean isSurroundingBlockAllowed) {
        OCRResult oCRResult = new OCRResult();
        com.samsung.android.sdk.ocr.Recognizer recognizer = this.recognizer;
        if (recognizer != null ? recognizer.recognizeBlockAt(bitmap, point, isSurroundingBlockAllowed, oCRResult) : false) {
            return OcrResultConverter.toOcrResult$default(OcrResultConverter.INSTANCE, oCRResult, this.context, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), false, 4, null);
        }
        OcrResult ocrResult = new OcrResult(CollectionsKt.emptyList(), null, null, 6, null);
        LibLogger.m5432i(TAG, "extractTextAtWithOcrRecognizer empty result");
        return ocrResult;
    }

    private final OcrResult extractTextInternal(Bitmap bitmap, Rect validRect, boolean extractTextOnly) {
        checkThread();
        checkIfRecognizerValid();
        return extractTextWithOcrRecognizer(getBitmapWithinRect(bitmap, validRect), validRect, extractTextOnly);
    }

    public static /* synthetic */ OcrResult extractTextInternal$default(RecognizerImpl recognizerImpl, Bitmap bitmap, Rect rect, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        }
        if ((i & 4) != 0) {
            z = false;
        }
        return recognizerImpl.extractTextInternal(bitmap, rect, z);
    }

    private final OcrResult extractTextWithOcrRecognizer(Bitmap bitmap, Rect validRect, boolean extractTextOnly) {
        OCRResult oCRResult = new OCRResult();
        com.samsung.android.sdk.ocr.Recognizer recognizer = this.recognizer;
        if (recognizer != null ? recognizer.recognize(bitmap, oCRResult) : false) {
            return OcrResultConverter.INSTANCE.toOcrResult(oCRResult, this.context, validRect, extractTextOnly);
        }
        OcrResult ocrResult = new OcrResult(CollectionsKt.emptyList(), null, null, 6, null);
        LibLogger.m5432i(TAG, "extractTextFromRecognizer empty result");
        return ocrResult;
    }

    public static /* synthetic */ OcrResult extractTextWithOcrRecognizer$default(RecognizerImpl recognizerImpl, Bitmap bitmap, Rect rect, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        }
        if ((i & 4) != 0) {
            z = false;
        }
        return recognizerImpl.extractTextWithOcrRecognizer(bitmap, rect, z);
    }

    private final Bitmap getBitmapWithinRect(Bitmap bitmap, Rect validRect) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, validRect.left, validRect.top, validRect.width(), validRect.height());
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(\n          …idRect.height()\n        )");
        return bitmapCreateBitmap;
    }

    private final boolean hasTextWithOcrRecognizer(Bitmap bitmap) {
        com.samsung.android.sdk.ocr.Recognizer recognizer = this.recognizer;
        boolean zHasText = recognizer != null ? recognizer.hasText(bitmap) : false;
        LibLogger.m5432i(TAG, "hasTextFromRecognizer hasText=" + zHasText);
        return zHasText;
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.Recognizer
    public boolean detectBlock(@NotNull Bitmap bitmap, @NotNull Point[] points) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(points, "points");
        String strLogString = LogUtil.INSTANCE.logString(bitmap);
        String string = Arrays.toString(points);
        Intrinsics.checkNotNullExpressionValue(string, "toString(this)");
        LibLogger.m5432i(TAG, "detectBlock with " + strLogString + ", points=" + string);
        checkThread();
        checkIfRecognizerValid();
        return detectBlockWithOcrRecognizer(bitmap, points);
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.Recognizer
    public boolean detectText(@NotNull Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        LibLogger.m5432i(TAG, "detectText with " + LogUtil.INSTANCE.logString(bitmap));
        checkThread();
        checkIfRecognizerValid();
        return detectTextWithOcrRecognizer(bitmap);
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.Recognizer
    @NotNull
    public OcrResult extractEntityInfoFromOcrResult(@NotNull Rect validRect, @NotNull OcrResult ocrResult) {
        Intrinsics.checkNotNullParameter(validRect, "validRect");
        Intrinsics.checkNotNullParameter(ocrResult, "ocrResult");
        return OcrResultConverter.INSTANCE.withEntityInfo(ocrResult, this.context, EntityType.INSTANCE.listOfEntityType(), validRect);
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.Recognizer
    @NotNull
    public OcrResult extractOcrTextOnly(@NotNull Bitmap bitmap, @NotNull Rect validRect) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(validRect, "validRect");
        LibLogger.m5432i(TAG, "extractOcrTextOnly with " + LogUtil.INSTANCE.logString(bitmap) + ", validRect=" + validRect);
        return extractTextInternal(bitmap, validRect, true);
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.Recognizer
    @NotNull
    public OcrResult extractText(@NotNull Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        LibLogger.m5432i(TAG, "extractText with " + LogUtil.INSTANCE.logString(bitmap));
        return extractTextInternal$default(this, bitmap, null, false, 6, null);
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.Recognizer
    @NotNull
    public OcrResult extractTextAt(@NotNull Bitmap bitmap, @NotNull Point point, boolean isSurroundingBlockAllowed) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(point, "point");
        checkThread();
        checkIfRecognizerValid();
        return extractTextAtWithOcrRecognizer(bitmap, point, isSurroundingBlockAllowed);
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.Recognizer
    public boolean hasText(@NotNull Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        LibLogger.m5432i(TAG, "hasText with " + LogUtil.INSTANCE.logString(bitmap));
        checkThread();
        checkIfRecognizerValid();
        return hasTextWithOcrRecognizer(bitmap);
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.Recognizer
    public void initialize(int language) {
        TextExtractionOCRLanguage byValue = TextExtractionOCRLanguage.INSTANCE.getByValue(language);
        LibLogger.m5432i(TAG, "initialize Recognizer with language=" + byValue.name());
        checkThread();
        if (this.recognizer != null) {
            throw new IllegalStateException("Recognizer already initialized");
        }
        this.recognizer = new com.samsung.android.sdk.ocr.Recognizer(this.context, OCRType.OCR_ALL, byValue.getConvertedId$deepsky_sdk_textextraction_8_0_19_release());
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.Recognizer
    public void release() {
        checkThread();
        com.samsung.android.sdk.ocr.Recognizer recognizer = this.recognizer;
        if (recognizer != null) {
            recognizer.close();
            this.recognizer = null;
        }
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.Recognizer
    @NotNull
    public OcrResult extractText(@NotNull Bitmap bitmap, @NotNull Rect validRect) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(validRect, "validRect");
        LibLogger.m5432i(TAG, "extractText with " + LogUtil.INSTANCE.logString(bitmap) + ", validRect=" + validRect);
        return extractTextInternal$default(this, bitmap, validRect, false, 4, null);
    }

    public /* synthetic */ RecognizerImpl(Context context, com.samsung.android.sdk.ocr.Recognizer recognizer, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : recognizer);
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.Recognizer
    public boolean detectText(@NotNull Bitmap bitmap, @NotNull Rect validRect) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(validRect, "validRect");
        LibLogger.m5432i(TAG, "detectText with " + LogUtil.INSTANCE.logString(bitmap) + ", validRect=" + validRect);
        checkThread();
        checkIfRecognizerValid();
        return detectTextWithOcrRecognizer(getBitmapWithinRect(bitmap, validRect));
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.Recognizer
    public boolean hasText(@NotNull Bitmap bitmap, @NotNull Rect validRect) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(validRect, "validRect");
        LibLogger.m5432i(TAG, "hasText with " + LogUtil.INSTANCE.logString(bitmap) + ", validRect=" + validRect);
        checkThread();
        checkIfRecognizerValid();
        return hasTextWithOcrRecognizer(getBitmapWithinRect(bitmap, validRect));
    }
}
