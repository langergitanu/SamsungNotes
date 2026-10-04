package androidx.glance.appwidget.percent;

import androidx.annotation.RestrictTo;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.GlanceModifier;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u000f"}, m13886d2 = {"Landroidx/glance/appwidget/percent/PercentRatioSizeModifier;", "Landroidx/glance/GlanceModifier$Element;", "width", "", "height", "maxWidth", "maxHeight", "ratio", "(FFFFF)V", "getHeight", "()F", "getMaxHeight", "getMaxWidth", "getRatio", "getWidth", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class PercentRatioSizeModifier implements GlanceModifier.Element {
    public static final int $stable = 0;
    private final float height;
    private final float maxHeight;
    private final float maxWidth;
    private final float ratio;
    private final float width;

    public PercentRatioSizeModifier(float f, float f4, float f5, float f6, float f7) {
        this.width = f;
        this.height = f4;
        this.maxWidth = f5;
        this.maxHeight = f6;
        this.ratio = f7;
    }

    public final float getHeight() {
        return this.height;
    }

    public final float getMaxHeight() {
        return this.maxHeight;
    }

    public final float getMaxWidth() {
        return this.maxWidth;
    }

    public final float getRatio() {
        return this.ratio;
    }

    public final float getWidth() {
        return this.width;
    }

    public /* synthetic */ PercentRatioSizeModifier(float f, float f4, float f5, float f6, float f7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f4, (i & 4) != 0 ? Float.MAX_VALUE : f5, (i & 8) != 0 ? Float.MAX_VALUE : f6, (i & 16) != 0 ? 1.0f : f7);
    }
}
