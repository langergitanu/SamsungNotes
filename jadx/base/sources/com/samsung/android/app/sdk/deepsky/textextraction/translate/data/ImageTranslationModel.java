package com.samsung.android.app.sdk.deepsky.textextraction.translate.data;

import android.graphics.Bitmap;
import androidx.collection.AbstractC0622a;
import com.samsung.android.app.sdk.deepsky.textextraction.ocrwrapper.OcrResultConverter;
import com.samsung.android.app.sdk.deepsky.textextraction.result.OcrResult;
import com.samsung.android.imagetranslation.data.LttOcrResult;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\nHÆ\u0003J7\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010\u001c\u001a\u00020\u001dJ\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/data/ImageTranslationModel;", "", "requestId", "", "inputImage", "Landroid/graphics/Bitmap;", "targetBlockInfoList", "", "Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult$BlockInfo;", "languageTags", "", "(ILandroid/graphics/Bitmap;Ljava/util/List;Ljava/lang/String;)V", "getInputImage", "()Landroid/graphics/Bitmap;", "getLanguageTags", "()Ljava/lang/String;", "getRequestId", "()I", "getTargetBlockInfoList", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "getLttOcrResult", "Lcom/samsung/android/imagetranslation/data/LttOcrResult;", "hashCode", "toString", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final /* data */ class ImageTranslationModel {

    @NotNull
    private final Bitmap inputImage;

    @NotNull
    private final String languageTags;
    private final int requestId;

    @NotNull
    private final List<OcrResult.BlockInfo> targetBlockInfoList;

    public ImageTranslationModel(int i, @NotNull Bitmap inputImage, @NotNull List<OcrResult.BlockInfo> targetBlockInfoList, @NotNull String languageTags) {
        Intrinsics.checkNotNullParameter(inputImage, "inputImage");
        Intrinsics.checkNotNullParameter(targetBlockInfoList, "targetBlockInfoList");
        Intrinsics.checkNotNullParameter(languageTags, "languageTags");
        this.requestId = i;
        this.inputImage = inputImage;
        this.targetBlockInfoList = targetBlockInfoList;
        this.languageTags = languageTags;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ImageTranslationModel copy$default(ImageTranslationModel imageTranslationModel, int i, Bitmap bitmap, List list, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = imageTranslationModel.requestId;
        }
        if ((i2 & 2) != 0) {
            bitmap = imageTranslationModel.inputImage;
        }
        if ((i2 & 4) != 0) {
            list = imageTranslationModel.targetBlockInfoList;
        }
        if ((i2 & 8) != 0) {
            str = imageTranslationModel.languageTags;
        }
        return imageTranslationModel.copy(i, bitmap, list, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getRequestId() {
        return this.requestId;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Bitmap getInputImage() {
        return this.inputImage;
    }

    @NotNull
    public final List<OcrResult.BlockInfo> component3() {
        return this.targetBlockInfoList;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getLanguageTags() {
        return this.languageTags;
    }

    @NotNull
    public final ImageTranslationModel copy(int requestId, @NotNull Bitmap inputImage, @NotNull List<OcrResult.BlockInfo> targetBlockInfoList, @NotNull String languageTags) {
        Intrinsics.checkNotNullParameter(inputImage, "inputImage");
        Intrinsics.checkNotNullParameter(targetBlockInfoList, "targetBlockInfoList");
        Intrinsics.checkNotNullParameter(languageTags, "languageTags");
        return new ImageTranslationModel(requestId, inputImage, targetBlockInfoList, languageTags);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ImageTranslationModel)) {
            return false;
        }
        ImageTranslationModel imageTranslationModel = (ImageTranslationModel) other;
        return this.requestId == imageTranslationModel.requestId && Intrinsics.areEqual(this.inputImage, imageTranslationModel.inputImage) && Intrinsics.areEqual(this.targetBlockInfoList, imageTranslationModel.targetBlockInfoList) && Intrinsics.areEqual(this.languageTags, imageTranslationModel.languageTags);
    }

    @NotNull
    public final Bitmap getInputImage() {
        return this.inputImage;
    }

    @NotNull
    public final String getLanguageTags() {
        return this.languageTags;
    }

    @NotNull
    public final LttOcrResult getLttOcrResult() {
        return OcrResultConverter.INSTANCE.toLttOcrResult(new OcrResult(this.targetBlockInfoList, new ArrayList(), this.languageTags));
    }

    public final int getRequestId() {
        return this.requestId;
    }

    @NotNull
    public final List<OcrResult.BlockInfo> getTargetBlockInfoList() {
        return this.targetBlockInfoList;
    }

    public int hashCode() {
        return this.languageTags.hashCode() + AbstractC0622a.m1159e(this.targetBlockInfoList, (this.inputImage.hashCode() + (Integer.hashCode(this.requestId) * 31)) * 31, 31);
    }

    @NotNull
    public String toString() {
        return "ImageTranslationModel(requestId=" + this.requestId + ", inputImage=" + this.inputImage + ", targetBlockInfoList=" + this.targetBlockInfoList + ", languageTags=" + this.languageTags + ")";
    }
}
