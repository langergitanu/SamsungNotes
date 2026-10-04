package androidx.glance.appwidget.percent;

import androidx.annotation.RestrictTo;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.GlanceModifier;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0019\u0010\u0007\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0012"}, m13886d2 = {"Landroidx/glance/appwidget/percent/PercentPaddingModifier;", "Landroidx/glance/GlanceModifier$Element;", "start", "", "top", "end", "bottom", "percentPolicy", "Landroidx/glance/appwidget/percent/PercentSizePolicy;", "(FFFFILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBottom", "()F", "getEnd", "getPercentPolicy-3SpTkPA", "()I", "I", "getStart", "getTop", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class PercentPaddingModifier implements GlanceModifier.Element {
    public static final int $stable = 0;
    private final float bottom;
    private final float end;
    private final int percentPolicy;
    private final float start;
    private final float top;

    public /* synthetic */ PercentPaddingModifier(float f, float f4, float f5, float f6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f4, f5, f6, i);
    }

    public final float getBottom() {
        return this.bottom;
    }

    public final float getEnd() {
        return this.end;
    }

    /* JADX INFO: renamed from: getPercentPolicy-3SpTkPA, reason: not valid java name and from getter */
    public final int getPercentPolicy() {
        return this.percentPolicy;
    }

    public final float getStart() {
        return this.start;
    }

    public final float getTop() {
        return this.top;
    }

    private PercentPaddingModifier(float f, float f4, float f5, float f6, int i) {
        this.start = f;
        this.top = f4;
        this.end = f5;
        this.bottom = f6;
        this.percentPolicy = i;
    }

    public /* synthetic */ PercentPaddingModifier(float f, float f4, float f5, float f6, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0.0f : f, (i2 & 2) != 0 ? 0.0f : f4, (i2 & 4) != 0 ? 0.0f : f5, (i2 & 8) != 0 ? 0.0f : f6, (i2 & 16) != 0 ? PercentSizePolicy.INSTANCE.m21380getAll3SpTkPA() : i, null);
    }
}
