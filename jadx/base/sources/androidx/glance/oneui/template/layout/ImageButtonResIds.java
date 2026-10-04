package androidx.glance.oneui.template.layout;

import androidx.annotation.DimenRes;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, m13886d2 = {"Landroidx/glance/oneui/template/layout/ImageButtonResIds;", "", "padding", "", "size", "(II)V", "getPadding", "()I", "getSize", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final /* data */ class ImageButtonResIds {
    public static final int $stable = 0;
    private final int padding;
    private final int size;

    public ImageButtonResIds(@DimenRes int i, @DimenRes int i2) {
        this.padding = i;
        this.size = i2;
    }

    public static /* synthetic */ ImageButtonResIds copy$default(ImageButtonResIds imageButtonResIds, int i, int i2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = imageButtonResIds.padding;
        }
        if ((i4 & 2) != 0) {
            i2 = imageButtonResIds.size;
        }
        return imageButtonResIds.copy(i, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getPadding() {
        return this.padding;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getSize() {
        return this.size;
    }

    @NotNull
    public final ImageButtonResIds copy(@DimenRes int padding, @DimenRes int size) {
        return new ImageButtonResIds(padding, size);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ImageButtonResIds)) {
            return false;
        }
        ImageButtonResIds imageButtonResIds = (ImageButtonResIds) other;
        return this.padding == imageButtonResIds.padding && this.size == imageButtonResIds.size;
    }

    public final int getPadding() {
        return this.padding;
    }

    public final int getSize() {
        return this.size;
    }

    public int hashCode() {
        return Integer.hashCode(this.size) + (Integer.hashCode(this.padding) * 31);
    }

    @NotNull
    public String toString() {
        return AbstractC0622a.m1164j(this.padding, this.size, "ImageButtonResIds(padding=", ", size=", ")");
    }
}
