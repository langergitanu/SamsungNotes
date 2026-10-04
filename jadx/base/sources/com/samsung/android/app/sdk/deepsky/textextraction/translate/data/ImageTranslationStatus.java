package com.samsung.android.app.sdk.deepsky.textextraction.translate.data;

import android.graphics.Bitmap;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.app.sdk.deepsky.textextraction.translate.data.ImageTranslationResult;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/data/ImageTranslationStatus;", "", "()V", "Failure", "InPaintingSuccess", "Release", "RenderSuccess", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/data/ImageTranslationStatus$Failure;", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/data/ImageTranslationStatus$InPaintingSuccess;", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/data/ImageTranslationStatus$Release;", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/data/ImageTranslationStatus$RenderSuccess;", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public abstract class ImageTranslationStatus {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/data/ImageTranslationStatus$Failure;", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/data/ImageTranslationStatus;", "requestId", "", "error", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/data/ImageTranslationResult$Error;", "(ILcom/samsung/android/app/sdk/deepsky/textextraction/translate/data/ImageTranslationResult$Error;)V", "getError", "()Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/data/ImageTranslationResult$Error;", "getRequestId", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final /* data */ class Failure extends ImageTranslationStatus {

        @NotNull
        private final ImageTranslationResult.Error error;
        private final int requestId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Failure(int i, @NotNull ImageTranslationResult.Error error) {
            super(null);
            Intrinsics.checkNotNullParameter(error, "error");
            this.requestId = i;
            this.error = error;
        }

        public static /* synthetic */ Failure copy$default(Failure failure, int i, ImageTranslationResult.Error error, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = failure.requestId;
            }
            if ((i2 & 2) != 0) {
                error = failure.error;
            }
            return failure.copy(i, error);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getRequestId() {
            return this.requestId;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final ImageTranslationResult.Error getError() {
            return this.error;
        }

        @NotNull
        public final Failure copy(int requestId, @NotNull ImageTranslationResult.Error error) {
            Intrinsics.checkNotNullParameter(error, "error");
            return new Failure(requestId, error);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Failure)) {
                return false;
            }
            Failure failure = (Failure) other;
            return this.requestId == failure.requestId && Intrinsics.areEqual(this.error, failure.error);
        }

        @NotNull
        public final ImageTranslationResult.Error getError() {
            return this.error;
        }

        public final int getRequestId() {
            return this.requestId;
        }

        public int hashCode() {
            return this.error.hashCode() + (Integer.hashCode(this.requestId) * 31);
        }

        @NotNull
        public String toString() {
            return "Failure(requestId=" + this.requestId + ", error=" + this.error + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/data/ImageTranslationStatus$InPaintingSuccess;", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/data/ImageTranslationStatus;", "requestId", "", "bitmap", "Landroid/graphics/Bitmap;", "(ILandroid/graphics/Bitmap;)V", "getBitmap", "()Landroid/graphics/Bitmap;", "getRequestId", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final /* data */ class InPaintingSuccess extends ImageTranslationStatus {

        @NotNull
        private final Bitmap bitmap;
        private final int requestId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InPaintingSuccess(int i, @NotNull Bitmap bitmap) {
            super(null);
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            this.requestId = i;
            this.bitmap = bitmap;
        }

        public static /* synthetic */ InPaintingSuccess copy$default(InPaintingSuccess inPaintingSuccess, int i, Bitmap bitmap, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = inPaintingSuccess.requestId;
            }
            if ((i2 & 2) != 0) {
                bitmap = inPaintingSuccess.bitmap;
            }
            return inPaintingSuccess.copy(i, bitmap);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getRequestId() {
            return this.requestId;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Bitmap getBitmap() {
            return this.bitmap;
        }

        @NotNull
        public final InPaintingSuccess copy(int requestId, @NotNull Bitmap bitmap) {
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            return new InPaintingSuccess(requestId, bitmap);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InPaintingSuccess)) {
                return false;
            }
            InPaintingSuccess inPaintingSuccess = (InPaintingSuccess) other;
            return this.requestId == inPaintingSuccess.requestId && Intrinsics.areEqual(this.bitmap, inPaintingSuccess.bitmap);
        }

        @NotNull
        public final Bitmap getBitmap() {
            return this.bitmap;
        }

        public final int getRequestId() {
            return this.requestId;
        }

        public int hashCode() {
            return this.bitmap.hashCode() + (Integer.hashCode(this.requestId) * 31);
        }

        @NotNull
        public String toString() {
            return "InPaintingSuccess(requestId=" + this.requestId + ", bitmap=" + this.bitmap + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/data/ImageTranslationStatus$Release;", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/data/ImageTranslationStatus;", "value", "", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final /* data */ class Release extends ImageTranslationStatus {

        @NotNull
        private final String value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Release(@NotNull String value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public static /* synthetic */ Release copy$default(Release release, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = release.value;
            }
            return release.copy(str);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getValue() {
            return this.value;
        }

        @NotNull
        public final Release copy(@NotNull String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new Release(value);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Release) && Intrinsics.areEqual(this.value, ((Release) other).value);
        }

        @NotNull
        public final String getValue() {
            return this.value;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        @NotNull
        public String toString() {
            return AbstractC0541b.m773o("Release(value=", this.value, ")");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/data/ImageTranslationStatus$RenderSuccess;", "Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/data/ImageTranslationStatus;", "requestId", "", "bitmap", "Landroid/graphics/Bitmap;", "(ILandroid/graphics/Bitmap;)V", "getBitmap", "()Landroid/graphics/Bitmap;", "getRequestId", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final /* data */ class RenderSuccess extends ImageTranslationStatus {

        @NotNull
        private final Bitmap bitmap;
        private final int requestId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RenderSuccess(int i, @NotNull Bitmap bitmap) {
            super(null);
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            this.requestId = i;
            this.bitmap = bitmap;
        }

        public static /* synthetic */ RenderSuccess copy$default(RenderSuccess renderSuccess, int i, Bitmap bitmap, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = renderSuccess.requestId;
            }
            if ((i2 & 2) != 0) {
                bitmap = renderSuccess.bitmap;
            }
            return renderSuccess.copy(i, bitmap);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getRequestId() {
            return this.requestId;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Bitmap getBitmap() {
            return this.bitmap;
        }

        @NotNull
        public final RenderSuccess copy(int requestId, @NotNull Bitmap bitmap) {
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            return new RenderSuccess(requestId, bitmap);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RenderSuccess)) {
                return false;
            }
            RenderSuccess renderSuccess = (RenderSuccess) other;
            return this.requestId == renderSuccess.requestId && Intrinsics.areEqual(this.bitmap, renderSuccess.bitmap);
        }

        @NotNull
        public final Bitmap getBitmap() {
            return this.bitmap;
        }

        public final int getRequestId() {
            return this.requestId;
        }

        public int hashCode() {
            return this.bitmap.hashCode() + (Integer.hashCode(this.requestId) * 31);
        }

        @NotNull
        public String toString() {
            return "RenderSuccess(requestId=" + this.requestId + ", bitmap=" + this.bitmap + ")";
        }
    }

    public /* synthetic */ ImageTranslationStatus(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ImageTranslationStatus() {
    }
}
