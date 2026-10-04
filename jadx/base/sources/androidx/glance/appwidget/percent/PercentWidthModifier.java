package androidx.glance.appwidget.percent;

import androidx.annotation.RestrictTo;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.GlanceModifier;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0019\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\n\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0010"}, m13886d2 = {"Landroidx/glance/appwidget/percent/PercentWidthModifier;", "Landroidx/glance/GlanceModifier$Element;", "width", "", "percentPolicy", "Landroidx/glance/appwidget/percent/PercentSizePolicy;", "minWidth", "maxWidth", "(FIFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getMaxWidth", "()F", "getMinWidth", "getPercentPolicy-3SpTkPA", "()I", "I", "getWidth", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class PercentWidthModifier implements GlanceModifier.Element {
    public static final int $stable = 0;
    private final float maxWidth;
    private final float minWidth;
    private final int percentPolicy;
    private final float width;

    public /* synthetic */ PercentWidthModifier(float f, int i, float f4, float f5, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, i, f4, f5);
    }

    public final float getMaxWidth() {
        return this.maxWidth;
    }

    public final float getMinWidth() {
        return this.minWidth;
    }

    /* JADX INFO: renamed from: getPercentPolicy-3SpTkPA, reason: not valid java name and from getter */
    public final int getPercentPolicy() {
        return this.percentPolicy;
    }

    public final float getWidth() {
        return this.width;
    }

    private PercentWidthModifier(float f, int i, float f4, float f5) {
        this.width = f;
        this.percentPolicy = i;
        this.minWidth = f4;
        this.maxWidth = f5;
    }

    public /* synthetic */ PercentWidthModifier(float f, int i, float f4, float f5, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, i, (i2 & 4) != 0 ? Float.MIN_VALUE : f4, (i2 & 8) != 0 ? Float.MAX_VALUE : f5, null);
    }
}
