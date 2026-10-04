package com.samsung.android.app.sdk.deepsky.textextraction.translate.data;

import android.graphics.Bitmap;
import com.samsung.android.app.sdk.deepsky.textextraction.result.OcrResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/data/TranslationRequest;", "", "requestId", "", "image", "Landroid/graphics/Bitmap;", "ocrResult", "Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult;", "(ILandroid/graphics/Bitmap;Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult;)V", "getImage", "()Landroid/graphics/Bitmap;", "getOcrResult", "()Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult;", "getRequestId", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final /* data */ class TranslationRequest {

    @NotNull
    private final Bitmap image;

    @NotNull
    private final OcrResult ocrResult;
    private final int requestId;

    public TranslationRequest(int i, @NotNull Bitmap image, @NotNull OcrResult ocrResult) {
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(ocrResult, "ocrResult");
        this.requestId = i;
        this.image = image;
        this.ocrResult = ocrResult;
    }

    public static /* synthetic */ TranslationRequest copy$default(TranslationRequest translationRequest, int i, Bitmap bitmap, OcrResult ocrResult, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = translationRequest.requestId;
        }
        if ((i2 & 2) != 0) {
            bitmap = translationRequest.image;
        }
        if ((i2 & 4) != 0) {
            ocrResult = translationRequest.ocrResult;
        }
        return translationRequest.copy(i, bitmap, ocrResult);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getRequestId() {
        return this.requestId;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Bitmap getImage() {
        return this.image;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final OcrResult getOcrResult() {
        return this.ocrResult;
    }

    @NotNull
    public final TranslationRequest copy(int requestId, @NotNull Bitmap image, @NotNull OcrResult ocrResult) {
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(ocrResult, "ocrResult");
        return new TranslationRequest(requestId, image, ocrResult);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TranslationRequest)) {
            return false;
        }
        TranslationRequest translationRequest = (TranslationRequest) other;
        return this.requestId == translationRequest.requestId && Intrinsics.areEqual(this.image, translationRequest.image) && Intrinsics.areEqual(this.ocrResult, translationRequest.ocrResult);
    }

    @NotNull
    public final Bitmap getImage() {
        return this.image;
    }

    @NotNull
    public final OcrResult getOcrResult() {
        return this.ocrResult;
    }

    public final int getRequestId() {
        return this.requestId;
    }

    public int hashCode() {
        return this.ocrResult.hashCode() + ((this.image.hashCode() + (Integer.hashCode(this.requestId) * 31)) * 31);
    }

    @NotNull
    public String toString() {
        return "TranslationRequest(requestId=" + this.requestId + ", image=" + this.image + ", ocrResult=" + this.ocrResult + ")";
    }
}
