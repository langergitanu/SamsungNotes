package androidx.glance.text;

import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010\u001c\u001a\u00020\nHÆ\u0003JG\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\n2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000f¨\u0006$"}, m13886d2 = {"Landroidx/glance/text/TextPercentData;", "", "minSize", "", "maxSize", "widthPercent", "heightPercent", "textCategory", "Landroidx/glance/text/TextCategory;", "autoResize", "", "(FFFFLandroidx/glance/text/TextCategory;Z)V", "getAutoResize", "()Z", "getHeightPercent", "()F", "getMaxSize", "getMinSize$annotations", "()V", "getMinSize", "getTextCategory", "()Landroidx/glance/text/TextCategory;", "getWidthPercent", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final /* data */ class TextPercentData {
    public static final int $stable = 0;
    private final boolean autoResize;
    private final float heightPercent;
    private final float maxSize;
    private final float minSize;

    @Nullable
    private final TextCategory textCategory;
    private final float widthPercent;

    public TextPercentData(float f, float f4, float f5, float f6, @Nullable TextCategory textCategory, boolean z) {
        this.minSize = f;
        this.maxSize = f4;
        this.widthPercent = f5;
        this.heightPercent = f6;
        this.textCategory = textCategory;
        this.autoResize = z;
    }

    public static /* synthetic */ TextPercentData copy$default(TextPercentData textPercentData, float f, float f4, float f5, float f6, TextCategory textCategory, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            f = textPercentData.minSize;
        }
        if ((i & 2) != 0) {
            f4 = textPercentData.maxSize;
        }
        if ((i & 4) != 0) {
            f5 = textPercentData.widthPercent;
        }
        if ((i & 8) != 0) {
            f6 = textPercentData.heightPercent;
        }
        if ((i & 16) != 0) {
            textCategory = textPercentData.textCategory;
        }
        if ((i & 32) != 0) {
            z = textPercentData.autoResize;
        }
        TextCategory textCategory2 = textCategory;
        boolean z2 = z;
        return textPercentData.copy(f, f4, f5, f6, textCategory2, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final float getMinSize() {
        return this.minSize;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final float getMaxSize() {
        return this.maxSize;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final float getWidthPercent() {
        return this.widthPercent;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final float getHeightPercent() {
        return this.heightPercent;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final TextCategory getTextCategory() {
        return this.textCategory;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getAutoResize() {
        return this.autoResize;
    }

    @NotNull
    public final TextPercentData copy(float minSize, float maxSize, float widthPercent, float heightPercent, @Nullable TextCategory textCategory, boolean autoResize) {
        return new TextPercentData(minSize, maxSize, widthPercent, heightPercent, textCategory, autoResize);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TextPercentData)) {
            return false;
        }
        TextPercentData textPercentData = (TextPercentData) other;
        return Float.compare(this.minSize, textPercentData.minSize) == 0 && Float.compare(this.maxSize, textPercentData.maxSize) == 0 && Float.compare(this.widthPercent, textPercentData.widthPercent) == 0 && Float.compare(this.heightPercent, textPercentData.heightPercent) == 0 && Intrinsics.areEqual(this.textCategory, textPercentData.textCategory) && this.autoResize == textPercentData.autoResize;
    }

    public final boolean getAutoResize() {
        return this.autoResize;
    }

    public final float getHeightPercent() {
        return this.heightPercent;
    }

    public final float getMaxSize() {
        return this.maxSize;
    }

    public final float getMinSize() {
        return this.minSize;
    }

    @Nullable
    public final TextCategory getTextCategory() {
        return this.textCategory;
    }

    public final float getWidthPercent() {
        return this.widthPercent;
    }

    public int hashCode() {
        int iM1156b = AbstractC0622a.m1156b(this.heightPercent, AbstractC0622a.m1156b(this.widthPercent, AbstractC0622a.m1156b(this.maxSize, Float.hashCode(this.minSize) * 31, 31), 31), 31);
        TextCategory textCategory = this.textCategory;
        return Boolean.hashCode(this.autoResize) + ((iM1156b + (textCategory == null ? 0 : textCategory.hashCode())) * 31);
    }

    @NotNull
    public String toString() {
        float f = this.minSize;
        float f4 = this.maxSize;
        float f5 = this.widthPercent;
        float f6 = this.heightPercent;
        TextCategory textCategory = this.textCategory;
        boolean z = this.autoResize;
        StringBuilder sbM1176v = AbstractC0622a.m1176v("TextPercentData(minSize=", f, ", maxSize=", f4, ", widthPercent=");
        AbstractC11014a.m12337v(sbM1176v, f5, ", heightPercent=", f6, ", textCategory=");
        sbM1176v.append(textCategory);
        sbM1176v.append(", autoResize=");
        sbM1176v.append(z);
        sbM1176v.append(")");
        return sbM1176v.toString();
    }

    public /* synthetic */ TextPercentData(float f, float f4, float f5, float f6, TextCategory textCategory, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 1.0f : f, (i & 2) != 0 ? 44.0f : f4, (i & 4) != 0 ? 1.0f : f5, f6, (i & 16) != 0 ? null : textCategory, (i & 32) != 0 ? true : z);
    }

    @Deprecated(message = "The minimum size is deprecated since OneUI8.5")
    public static /* synthetic */ void getMinSize$annotations() {
    }
}
