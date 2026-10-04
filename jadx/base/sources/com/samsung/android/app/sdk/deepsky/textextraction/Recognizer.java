package com.samsung.android.app.sdk.deepsky.textextraction;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import androidx.annotation.WorkerThread;
import com.samsung.android.app.sdk.deepsky.textextraction.ocrwrapper.TextExtractionOCRLanguage;
import com.samsung.android.app.sdk.deepsky.textextraction.result.OcrResult;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J#\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H'¢\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH'J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH'J\u0018\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH'J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0018\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH'J \u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0003H'J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0018\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH'J\u0012\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u0019H'J\b\u0010\u001a\u001a\u00020\u0017H'¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/Recognizer;", "", "detectBlock", "", "bitmap", "Landroid/graphics/Bitmap;", "points", "", "Landroid/graphics/Point;", "(Landroid/graphics/Bitmap;[Landroid/graphics/Point;)Z", "detectText", "validRect", "Landroid/graphics/Rect;", "extractEntityInfoFromOcrResult", "Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult;", "ocrResult", "extractOcrTextOnly", "extractText", "extractTextAt", "point", "isSurroundingBlockAllowed", "hasText", "initialize", "", "language", "", "release", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public interface Recognizer {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void initialize$default(Recognizer recognizer, int i, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: initialize");
            }
            if ((i2 & 1) != 0) {
                i = TextExtractionOCRLanguage.All.getId();
            }
            recognizer.initialize(i);
        }
    }

    @WorkerThread
    boolean detectBlock(@NotNull Bitmap bitmap, @NotNull Point[] points);

    boolean detectText(@NotNull Bitmap bitmap);

    @WorkerThread
    boolean detectText(@NotNull Bitmap bitmap, @NotNull Rect validRect);

    @WorkerThread
    @NotNull
    OcrResult extractEntityInfoFromOcrResult(@NotNull Rect validRect, @NotNull OcrResult ocrResult);

    @WorkerThread
    @NotNull
    OcrResult extractOcrTextOnly(@NotNull Bitmap bitmap, @NotNull Rect validRect);

    @WorkerThread
    @NotNull
    OcrResult extractText(@NotNull Bitmap bitmap);

    @WorkerThread
    @NotNull
    OcrResult extractText(@NotNull Bitmap bitmap, @NotNull Rect validRect);

    @WorkerThread
    @NotNull
    OcrResult extractTextAt(@NotNull Bitmap bitmap, @NotNull Point point, boolean isSurroundingBlockAllowed);

    @WorkerThread
    boolean hasText(@NotNull Bitmap bitmap);

    @WorkerThread
    boolean hasText(@NotNull Bitmap bitmap, @NotNull Rect validRect);

    @WorkerThread
    void initialize(int language);

    @WorkerThread
    void release();
}
