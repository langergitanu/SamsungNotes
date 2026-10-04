package com.samsung.android.sesl.outerGlow.data;

import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.core.app.FrameMetricsAggregator;
import androidx.glance.AbstractC2821a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\fHÆ\u0003Jc\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0003HÖ\u0001J\t\u0010'\u001a\u00020(HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000f¨\u0006)"}, m13886d2 = {"Lcom/samsung/android/sesl/outerGlow/data/ViewParams;", "", "viewWidth", "", "viewHeight", "contentPaddingHorizontal", "contentPaddingVertical", "imageContentPaddingHorizontal", "imageContentPaddingVertical", "cornerRadius", "lineThickness", "squirclePower", "", "(IIIIIIIIF)V", "getContentPaddingHorizontal", "()I", "getContentPaddingVertical", "getCornerRadius", "getImageContentPaddingHorizontal", "getImageContentPaddingVertical", "getLineThickness", "getSquirclePower", "()F", "getViewHeight", "getViewWidth", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "", "graphic-solution_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final /* data */ class ViewParams {
    private final int contentPaddingHorizontal;
    private final int contentPaddingVertical;
    private final int cornerRadius;
    private final int imageContentPaddingHorizontal;
    private final int imageContentPaddingVertical;
    private final int lineThickness;
    private final float squirclePower;
    private final int viewHeight;
    private final int viewWidth;

    public ViewParams() {
        this(0, 0, 0, 0, 0, 0, 0, 0, 0.0f, FrameMetricsAggregator.EVERY_DURATION, null);
    }

    public static /* synthetic */ ViewParams copy$default(ViewParams viewParams, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9, float f, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            i = viewParams.viewWidth;
        }
        if ((i10 & 2) != 0) {
            i2 = viewParams.viewHeight;
        }
        if ((i10 & 4) != 0) {
            i4 = viewParams.contentPaddingHorizontal;
        }
        if ((i10 & 8) != 0) {
            i5 = viewParams.contentPaddingVertical;
        }
        if ((i10 & 16) != 0) {
            i6 = viewParams.imageContentPaddingHorizontal;
        }
        if ((i10 & 32) != 0) {
            i7 = viewParams.imageContentPaddingVertical;
        }
        if ((i10 & 64) != 0) {
            i8 = viewParams.cornerRadius;
        }
        if ((i10 & 128) != 0) {
            i9 = viewParams.lineThickness;
        }
        if ((i10 & 256) != 0) {
            f = viewParams.squirclePower;
        }
        int i11 = i9;
        float f4 = f;
        int i12 = i7;
        int i13 = i8;
        int i14 = i6;
        int i15 = i4;
        return viewParams.copy(i, i2, i15, i5, i14, i12, i13, i11, f4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getViewWidth() {
        return this.viewWidth;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getViewHeight() {
        return this.viewHeight;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getContentPaddingHorizontal() {
        return this.contentPaddingHorizontal;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getContentPaddingVertical() {
        return this.contentPaddingVertical;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getImageContentPaddingHorizontal() {
        return this.imageContentPaddingHorizontal;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getImageContentPaddingVertical() {
        return this.imageContentPaddingVertical;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getCornerRadius() {
        return this.cornerRadius;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getLineThickness() {
        return this.lineThickness;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final float getSquirclePower() {
        return this.squirclePower;
    }

    @NotNull
    public final ViewParams copy(int viewWidth, int viewHeight, int contentPaddingHorizontal, int contentPaddingVertical, int imageContentPaddingHorizontal, int imageContentPaddingVertical, int cornerRadius, int lineThickness, float squirclePower) {
        return new ViewParams(viewWidth, viewHeight, contentPaddingHorizontal, contentPaddingVertical, imageContentPaddingHorizontal, imageContentPaddingVertical, cornerRadius, lineThickness, squirclePower);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ViewParams)) {
            return false;
        }
        ViewParams viewParams = (ViewParams) other;
        return this.viewWidth == viewParams.viewWidth && this.viewHeight == viewParams.viewHeight && this.contentPaddingHorizontal == viewParams.contentPaddingHorizontal && this.contentPaddingVertical == viewParams.contentPaddingVertical && this.imageContentPaddingHorizontal == viewParams.imageContentPaddingHorizontal && this.imageContentPaddingVertical == viewParams.imageContentPaddingVertical && this.cornerRadius == viewParams.cornerRadius && this.lineThickness == viewParams.lineThickness && Float.compare(this.squirclePower, viewParams.squirclePower) == 0;
    }

    public final int getContentPaddingHorizontal() {
        return this.contentPaddingHorizontal;
    }

    public final int getContentPaddingVertical() {
        return this.contentPaddingVertical;
    }

    public final int getCornerRadius() {
        return this.cornerRadius;
    }

    public final int getImageContentPaddingHorizontal() {
        return this.imageContentPaddingHorizontal;
    }

    public final int getImageContentPaddingVertical() {
        return this.imageContentPaddingVertical;
    }

    public final int getLineThickness() {
        return this.lineThickness;
    }

    public final float getSquirclePower() {
        return this.squirclePower;
    }

    public final int getViewHeight() {
        return this.viewHeight;
    }

    public final int getViewWidth() {
        return this.viewWidth;
    }

    public int hashCode() {
        return Float.hashCode(this.squirclePower) + AbstractC0622a.m1157c(this.lineThickness, AbstractC0622a.m1157c(this.cornerRadius, AbstractC0622a.m1157c(this.imageContentPaddingVertical, AbstractC0622a.m1157c(this.imageContentPaddingHorizontal, AbstractC0622a.m1157c(this.contentPaddingVertical, AbstractC0622a.m1157c(this.contentPaddingHorizontal, AbstractC0622a.m1157c(this.viewHeight, Integer.hashCode(this.viewWidth) * 31, 31), 31), 31), 31), 31), 31), 31);
    }

    @NotNull
    public String toString() {
        int i = this.viewWidth;
        int i2 = this.viewHeight;
        int i4 = this.contentPaddingHorizontal;
        int i5 = this.contentPaddingVertical;
        int i6 = this.imageContentPaddingHorizontal;
        int i7 = this.imageContentPaddingVertical;
        int i8 = this.cornerRadius;
        int i9 = this.lineThickness;
        float f = this.squirclePower;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i2, "ViewParams(viewWidth=", ", viewHeight=", ", contentPaddingHorizontal=");
        AbstractC2821a.m2235z(sbM1173s, i4, i5, ", contentPaddingVertical=", ", imageContentPaddingHorizontal=");
        AbstractC2821a.m2235z(sbM1173s, i6, i7, ", imageContentPaddingVertical=", ", cornerRadius=");
        AbstractC2821a.m2235z(sbM1173s, i8, i9, ", lineThickness=", ", squirclePower=");
        return AbstractC1038a.m1217r(sbM1173s, ")", f);
    }

    public ViewParams(int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9, float f) {
        this.viewWidth = i;
        this.viewHeight = i2;
        this.contentPaddingHorizontal = i4;
        this.contentPaddingVertical = i5;
        this.imageContentPaddingHorizontal = i6;
        this.imageContentPaddingVertical = i7;
        this.cornerRadius = i8;
        this.lineThickness = i9;
        this.squirclePower = f;
    }

    public /* synthetic */ ViewParams(int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9, float f, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? 300 : i, (i10 & 2) != 0 ? 300 : i2, (i10 & 4) != 0 ? 20 : i4, (i10 & 8) != 0 ? 20 : i5, (i10 & 16) != 0 ? 20 : i6, (i10 & 32) != 0 ? 20 : i7, (i10 & 64) != 0 ? 10 : i8, (i10 & 128) != 0 ? 4 : i9, (i10 & 256) != 0 ? 3.0f : f);
    }
}
