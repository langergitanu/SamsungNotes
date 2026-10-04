package com.samsung.android.app.sdk.deepsky.textextraction;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import androidx.annotation.WorkerThread;
import com.samsung.android.app.sdk.deepsky.textextraction.capsule.CapsuleHelper;
import com.samsung.android.app.sdk.deepsky.textextraction.entity.EntityExtractionResult;
import com.samsung.android.app.sdk.deepsky.textextraction.entity.EntityType;
import com.samsung.android.app.sdk.deepsky.textextraction.ocrwrapper.TextExtractionOCRLanguage;
import com.samsung.android.app.sdk.deepsky.textextraction.result.OcrResult;
import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelper;
import com.samsung.android.app.sdk.deepsky.textextraction.translate.ImageOverlayHelper;
import com.samsung.android.sdk.ocr.OCRType;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J7\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH'¢\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H'J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH'J \u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H'J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H'J\u001e\u0010\u0011\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0018H'J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0018\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H'J\u0018\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH'J \u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H'J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH&J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u001dH&J\b\u0010 \u001a\u00020!H&J\u0010\u0010\"\u001a\u00020#2\u0006\u0010\u001c\u001a\u00020\u001dH&J\u0012\u0010$\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\fH&¨\u0006%"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/TextExtraction;", "", "detectBlock", "", "bitmap", "Landroid/graphics/Bitmap;", "points", "", "Landroid/graphics/Point;", "language", "", "ocrType", "Lcom/samsung/android/sdk/ocr/OCRType;", "(Landroid/graphics/Bitmap;[Landroid/graphics/Point;ILcom/samsung/android/sdk/ocr/OCRType;)Z", "detectVisionText", "validRect", "Landroid/graphics/Rect;", "extractEntity", "Lcom/samsung/android/app/sdk/deepsky/textextraction/entity/EntityExtractionResult;", "ocrResult", "Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult;", "entityType", "Lcom/samsung/android/app/sdk/deepsky/textextraction/entity/EntityType;", "entityTypes", "", "extractVisionText", "getCapsuleHelper", "Lcom/samsung/android/app/sdk/deepsky/textextraction/capsule/CapsuleHelper;", "context", "Landroid/content/Context;", "getImageOverlayHelper", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/ImageOverlayHelper;", "getRecognizer", "Lcom/samsung/android/app/sdk/deepsky/textextraction/Recognizer;", "getTextExtractionDrawHelper", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/TextExtractionDrawHelper;", "isSupported", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public interface TextExtraction {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ boolean detectBlock$default(TextExtraction textExtraction, Bitmap bitmap, Point[] pointArr, int i, OCRType oCRType, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: detectBlock");
            }
            if ((i2 & 4) != 0) {
                i = TextExtractionOCRLanguage.All.getId();
            }
            if ((i2 & 8) != 0) {
                oCRType = OCRType.OCR_ALL;
            }
            return textExtraction.detectBlock(bitmap, pointArr, i, oCRType);
        }

        public static /* synthetic */ boolean isSupported$default(TextExtraction textExtraction, OCRType oCRType, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: isSupported");
            }
            if ((i & 1) != 0) {
                oCRType = OCRType.OCR_ALL;
            }
            return textExtraction.isSupported(oCRType);
        }
    }

    @WorkerThread
    boolean detectBlock(@NotNull Bitmap bitmap, @NotNull Point[] points, int language, @NotNull OCRType ocrType);

    @WorkerThread
    boolean detectVisionText(@NotNull Bitmap bitmap);

    @WorkerThread
    boolean detectVisionText(@NotNull Bitmap bitmap, int language);

    @WorkerThread
    boolean detectVisionText(@NotNull Bitmap bitmap, int language, @NotNull Rect validRect);

    @WorkerThread
    boolean detectVisionText(@NotNull Bitmap bitmap, @NotNull Rect validRect);

    @WorkerThread
    @NotNull
    EntityExtractionResult extractEntity(@NotNull OcrResult ocrResult, @NotNull EntityType entityType);

    @WorkerThread
    @NotNull
    OcrResult extractEntity(@NotNull OcrResult ocrResult, @NotNull List<? extends EntityType> entityTypes);

    @WorkerThread
    @NotNull
    OcrResult extractVisionText(@NotNull Bitmap bitmap);

    @WorkerThread
    @NotNull
    OcrResult extractVisionText(@NotNull Bitmap bitmap, int language);

    @WorkerThread
    @NotNull
    OcrResult extractVisionText(@NotNull Bitmap bitmap, int language, @NotNull Rect validRect);

    @WorkerThread
    @NotNull
    OcrResult extractVisionText(@NotNull Bitmap bitmap, @NotNull Rect validRect);

    @NotNull
    CapsuleHelper getCapsuleHelper(@NotNull Context context);

    @NotNull
    ImageOverlayHelper getImageOverlayHelper(@NotNull Context context);

    @NotNull
    Recognizer getRecognizer();

    @NotNull
    TextExtractionDrawHelper getTextExtractionDrawHelper(@NotNull Context context);

    boolean isSupported(@NotNull OCRType ocrType);
}
