package com.samsung.android.app.sdk.deepsky.textextraction;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Looper;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.app.sdk.deepsky.textextraction.capsule.CapsuleHelper;
import com.samsung.android.app.sdk.deepsky.textextraction.capsule.CapsuleHelperImpl;
import com.samsung.android.app.sdk.deepsky.textextraction.entity.EntityExtractionResult;
import com.samsung.android.app.sdk.deepsky.textextraction.entity.EntityType;
import com.samsung.android.app.sdk.deepsky.textextraction.entity.OcrEntityExtractor;
import com.samsung.android.app.sdk.deepsky.textextraction.logger.LibLogger;
import com.samsung.android.app.sdk.deepsky.textextraction.logger.LogUtil;
import com.samsung.android.app.sdk.deepsky.textextraction.ocrwrapper.OcrResultConverter;
import com.samsung.android.app.sdk.deepsky.textextraction.ocrwrapper.OcrWrapper;
import com.samsung.android.app.sdk.deepsky.textextraction.result.OcrResult;
import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelper;
import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelperImpl;
import com.samsung.android.app.sdk.deepsky.textextraction.textclassification.TextClassificationHelper;
import com.samsung.android.app.sdk.deepsky.textextraction.translate.ImageOverlayHelper;
import com.samsung.android.app.sdk.deepsky.textextraction.translate.ImageOverlayHelperImpl;
import com.samsung.android.sdk.ocr.OCRType;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 )2\u00020\u0001:\u0001)B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0002J3\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u0013\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0013\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J \u0010\u0013\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u001e\u0010\u0016\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u001e\u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u001e\u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J \u0010\u001e\u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010!\u001a\u00020\"2\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020&2\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J\r\u0010'\u001a\u00020\bH\u0000¢\u0006\u0002\b(J\u0010\u0010'\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/TextExtractionImpl;", "Lcom/samsung/android/app/sdk/deepsky/textextraction/TextExtraction;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "checkThread", "", "detectBlock", "", "bitmap", "Landroid/graphics/Bitmap;", "points", "", "Landroid/graphics/Point;", "language", "", "ocrType", "Lcom/samsung/android/sdk/ocr/OCRType;", "(Landroid/graphics/Bitmap;[Landroid/graphics/Point;ILcom/samsung/android/sdk/ocr/OCRType;)Z", "detectVisionText", "validRect", "Landroid/graphics/Rect;", "extractEntity", "Lcom/samsung/android/app/sdk/deepsky/textextraction/entity/EntityExtractionResult;", "ocrResult", "Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult;", "entityType", "Lcom/samsung/android/app/sdk/deepsky/textextraction/entity/EntityType;", "entityTypes", "", "extractVisionText", "getCapsuleHelper", "Lcom/samsung/android/app/sdk/deepsky/textextraction/capsule/CapsuleHelper;", "getImageOverlayHelper", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/ImageOverlayHelper;", "getRecognizer", "Lcom/samsung/android/app/sdk/deepsky/textextraction/Recognizer;", "getTextExtractionDrawHelper", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/TextExtractionDrawHelper;", "isSupported", "isSupported$deepsky_sdk_textextraction_8_0_19_release", "Companion", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nTextExtractionImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextExtractionImpl.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/TextExtractionImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,181:1\n1#2:182\n*E\n"})
public final class TextExtractionImpl implements TextExtraction {

    @NotNull
    private static final String TAG = "TextExtractionImpl";

    @NotNull
    private final Context context;

    public TextExtractionImpl(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        LibLogger.m5432i(TAG, "TextExtraction initialized at " + context.getPackageName());
        OcrResultConverter.INSTANCE.clearIsTabularMap();
    }

    private final void checkThread() {
        if (Intrinsics.areEqual(Thread.currentThread(), Looper.getMainLooper().getThread())) {
            throw new IllegalStateException("Should be called on worker thread");
        }
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.TextExtraction
    public boolean detectBlock(@NotNull Bitmap bitmap, @NotNull Point[] points, int language, @NotNull OCRType ocrType) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(points, "points");
        Intrinsics.checkNotNullParameter(ocrType, "ocrType");
        String strLogString = LogUtil.INSTANCE.logString(bitmap);
        String string = Arrays.toString(points);
        Intrinsics.checkNotNullExpressionValue(string, "toString(this)");
        LibLogger.m5432i(TAG, "detectBlock with " + strLogString + ", rect=" + string);
        checkThread();
        return OcrWrapper.INSTANCE.detectBlock(this.context, bitmap, points, language, ocrType);
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.TextExtraction
    public boolean detectVisionText(@NotNull Bitmap bitmap, int language) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        LibLogger.m5432i(TAG, "detectVisionText with " + LogUtil.INSTANCE.logString(bitmap) + ", language=" + language);
        checkThread();
        return OcrWrapper.INSTANCE.isTextDetected(this.context, bitmap, language);
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.TextExtraction
    @NotNull
    public EntityExtractionResult extractEntity(@NotNull OcrResult ocrResult, @NotNull EntityType entityType) {
        Intrinsics.checkNotNullParameter(ocrResult, "ocrResult");
        Intrinsics.checkNotNullParameter(entityType, "entityType");
        LibLogger.m5432i(TAG, "extractEntity with entityType=" + entityType);
        checkThread();
        return OcrEntityExtractor.INSTANCE.extractEntity(ocrResult, CollectionsKt.listOf(entityType), null, new TextClassificationHelper(this.context));
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.TextExtraction
    @NotNull
    public OcrResult extractVisionText(@NotNull Bitmap bitmap, int language) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        LibLogger.m5432i(TAG, "extractVisionText with " + LogUtil.INSTANCE.logString(bitmap) + ", language=" + language);
        checkThread();
        return OcrWrapper.INSTANCE.extractText(this.context, bitmap, language);
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.TextExtraction
    @NotNull
    public CapsuleHelper getCapsuleHelper(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new CapsuleHelperImpl(context, null, 2, null);
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.TextExtraction
    @NotNull
    public ImageOverlayHelper getImageOverlayHelper(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ImageOverlayHelperImpl(context);
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.TextExtraction
    @NotNull
    public Recognizer getRecognizer() {
        return new RecognizerImpl(this.context, null, 2, null);
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.TextExtraction
    @NotNull
    public TextExtractionDrawHelper getTextExtractionDrawHelper(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new TextExtractionDrawHelperImpl(context);
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.TextExtraction
    public boolean isSupported(@NotNull OCRType ocrType) {
        Intrinsics.checkNotNullParameter(ocrType, "ocrType");
        boolean zIsSupported = OcrWrapper.INSTANCE.isSupported(this.context, ocrType);
        LibLogger.m5432i(TAG, ocrType.name() + " is supported on this device");
        return zIsSupported;
    }

    public final boolean isSupported$deepsky_sdk_textextraction_8_0_19_release() {
        boolean zIsSupported$default = OcrWrapper.isSupported$default(OcrWrapper.INSTANCE, this.context, null, 2, null);
        LibLogger.m5432i(TAG, "TextExtraction isSupported: " + zIsSupported$default);
        return zIsSupported$default;
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.TextExtraction
    public boolean detectVisionText(@NotNull Bitmap bitmap, int language, @NotNull Rect validRect) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(validRect, "validRect");
        StringBuilder sbM780v = AbstractC0541b.m780v("detectVisionText with ", language, LogUtil.INSTANCE.logString(bitmap), ", language=", ", validRect=");
        sbM780v.append(validRect);
        LibLogger.m5432i(TAG, sbM780v.toString());
        checkThread();
        return OcrWrapper.INSTANCE.isTextDetected(this.context, bitmap, language, validRect);
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.TextExtraction
    @NotNull
    public OcrResult extractVisionText(@NotNull Bitmap bitmap, int language, @NotNull Rect validRect) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(validRect, "validRect");
        StringBuilder sbM780v = AbstractC0541b.m780v("extractVisionText ", language, LogUtil.INSTANCE.logString(bitmap), ", language=", ", validRect=");
        sbM780v.append(validRect);
        LibLogger.m5432i(TAG, sbM780v.toString());
        checkThread();
        return OcrWrapper.INSTANCE.extractText(this.context, bitmap, language, validRect);
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.TextExtraction
    @NotNull
    public OcrResult extractEntity(@NotNull OcrResult ocrResult, @NotNull List<? extends EntityType> entityTypes) throws IOException {
        Intrinsics.checkNotNullParameter(ocrResult, "ocrResult");
        Intrinsics.checkNotNullParameter(entityTypes, "entityTypes");
        LibLogger.m5432i(TAG, "extractEntity with entityTypes=" + CollectionsKt.m13955n(entityTypes, ",", null, null, null, 62));
        checkThread();
        OcrResultConverter ocrResultConverter = OcrResultConverter.INSTANCE;
        Context context = this.context;
        List<? extends EntityType> listListOfEntityType = entityTypes;
        if (listListOfEntityType.isEmpty()) {
            listListOfEntityType = EntityType.INSTANCE.listOfEntityType();
        }
        return ocrResultConverter.withEntityInfo(ocrResult, context, listListOfEntityType, null);
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.TextExtraction
    public boolean detectVisionText(@NotNull Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        LibLogger.m5432i(TAG, "detectVisionText with " + LogUtil.INSTANCE.logString(bitmap));
        checkThread();
        return OcrWrapper.INSTANCE.isTextDetected(this.context, bitmap);
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.TextExtraction
    @NotNull
    public OcrResult extractVisionText(@NotNull Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        LibLogger.m5432i(TAG, "extractVisionText with " + LogUtil.INSTANCE.logString(bitmap));
        checkThread();
        return OcrWrapper.INSTANCE.extractText(this.context, bitmap);
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.TextExtraction
    public boolean detectVisionText(@NotNull Bitmap bitmap, @NotNull Rect validRect) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(validRect, "validRect");
        LibLogger.m5432i(TAG, "detectVisionText with " + LogUtil.INSTANCE.logString(bitmap) + ", validRect=" + validRect);
        checkThread();
        return OcrWrapper.isTextDetected$default(OcrWrapper.INSTANCE, this.context, bitmap, 0, validRect, 4, null);
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.TextExtraction
    @NotNull
    public OcrResult extractVisionText(@NotNull Bitmap bitmap, @NotNull Rect validRect) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(validRect, "validRect");
        LibLogger.m5432i(TAG, "extractVisionText with " + LogUtil.INSTANCE.logString(bitmap) + ", validRect=" + validRect);
        checkThread();
        return OcrWrapper.extractText$default(OcrWrapper.INSTANCE, this.context, bitmap, 0, validRect, 4, null);
    }
}
