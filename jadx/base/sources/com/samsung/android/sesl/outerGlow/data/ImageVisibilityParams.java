package com.samsung.android.sesl.outerGlow.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/sesl/outerGlow/data/ImageVisibilityParams;", "", "contentImageVisible", "", "backgroundImageVisible", "(ZZ)V", "getBackgroundImageVisible", "()Z", "getContentImageVisible", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "graphic-solution_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final /* data */ class ImageVisibilityParams {
    private final boolean backgroundImageVisible;
    private final boolean contentImageVisible;

    /* JADX WARN: Illegal instructions before constructor call */
    public ImageVisibilityParams() {
        boolean z = false;
        this(z, z, 3, null);
    }

    public static /* synthetic */ ImageVisibilityParams copy$default(ImageVisibilityParams imageVisibilityParams, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = imageVisibilityParams.contentImageVisible;
        }
        if ((i & 2) != 0) {
            z2 = imageVisibilityParams.backgroundImageVisible;
        }
        return imageVisibilityParams.copy(z, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getContentImageVisible() {
        return this.contentImageVisible;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getBackgroundImageVisible() {
        return this.backgroundImageVisible;
    }

    @NotNull
    public final ImageVisibilityParams copy(boolean contentImageVisible, boolean backgroundImageVisible) {
        return new ImageVisibilityParams(contentImageVisible, backgroundImageVisible);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ImageVisibilityParams)) {
            return false;
        }
        ImageVisibilityParams imageVisibilityParams = (ImageVisibilityParams) other;
        return this.contentImageVisible == imageVisibilityParams.contentImageVisible && this.backgroundImageVisible == imageVisibilityParams.backgroundImageVisible;
    }

    public final boolean getBackgroundImageVisible() {
        return this.backgroundImageVisible;
    }

    public final boolean getContentImageVisible() {
        return this.contentImageVisible;
    }

    public int hashCode() {
        return Boolean.hashCode(this.backgroundImageVisible) + (Boolean.hashCode(this.contentImageVisible) * 31);
    }

    @NotNull
    public String toString() {
        return "ImageVisibilityParams(contentImageVisible=" + this.contentImageVisible + ", backgroundImageVisible=" + this.backgroundImageVisible + ")";
    }

    public ImageVisibilityParams(boolean z, boolean z2) {
        this.contentImageVisible = z;
        this.backgroundImageVisible = z2;
    }

    public /* synthetic */ ImageVisibilityParams(boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z, (i & 2) != 0 ? true : z2);
    }
}
