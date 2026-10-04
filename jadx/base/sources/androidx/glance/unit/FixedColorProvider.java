package androidx.glance.unit;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\b\u001a\u00020\u0003HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\t\u0010\u0006J\u001d\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\u001d\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001a"}, m13886d2 = {"Landroidx/glance/unit/FixedColorProvider;", "Landroidx/glance/unit/ColorProvider;", "color", "Landroidx/compose/ui/graphics/Color;", "(JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getColor-0d7_KjU", "()J", "J", "component1", "component1-0d7_KjU", "copy", "copy-8_81llA", "(J)Landroidx/glance/unit/FixedColorProvider;", "equals", "", "other", "", "getColor", "context", "Landroid/content/Context;", "getColor-vNxB06k", "(Landroid/content/Context;)J", "hashCode", "", "toString", "", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final /* data */ class FixedColorProvider implements ColorProvider {
    public static final int $stable = 0;
    private final long color;

    public /* synthetic */ FixedColorProvider(long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(j);
    }

    /* JADX INFO: renamed from: copy-8_81llA$default, reason: not valid java name */
    public static /* synthetic */ FixedColorProvider m22057copy8_81llA$default(FixedColorProvider fixedColorProvider, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = fixedColorProvider.color;
        }
        return fixedColorProvider.m22059copy8_81llA(j);
    }

    /* JADX INFO: renamed from: component1-0d7_KjU, reason: not valid java name and from getter */
    public final long getColor() {
        return this.color;
    }

    @NotNull
    /* JADX INFO: renamed from: copy-8_81llA, reason: not valid java name */
    public final FixedColorProvider m22059copy8_81llA(long color) {
        return new FixedColorProvider(color, null);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof FixedColorProvider) && Color.m18526equalsimpl0(this.color, ((FixedColorProvider) other).color);
    }

    /* JADX INFO: renamed from: getColor-0d7_KjU, reason: not valid java name */
    public final long m22060getColor0d7_KjU() {
        return this.color;
    }

    @Override // androidx.glance.unit.ColorProvider
    /* JADX INFO: renamed from: getColor-vNxB06k */
    public long mo21422getColorvNxB06k(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return this.color;
    }

    public int hashCode() {
        return Color.m18532hashCodeimpl(this.color);
    }

    @NotNull
    public String toString() {
        return AbstractC0541b.m773o("FixedColorProvider(color=", Color.m18533toStringimpl(this.color), ")");
    }

    private FixedColorProvider(long j) {
        this.color = j;
    }
}
