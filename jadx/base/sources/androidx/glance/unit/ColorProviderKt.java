package androidx.glance.unit;

import androidx.annotation.ColorRes;
import androidx.annotation.RestrictTo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0012\u0010\u0000\u001a\u00020\u00012\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u0007\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\b"}, m13886d2 = {"ColorProvider", "Landroidx/glance/unit/ColorProvider;", "color", "Landroidx/compose/ui/graphics/Color;", "ColorProvider-8_81llA", "(J)Landroidx/glance/unit/ColorProvider;", "resId", "", "glance_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class ColorProviderKt {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    public static final ColorProvider ColorProvider(@ColorRes int i) {
        return new ResourceColorProvider(i);
    }

    @NotNull
    /* JADX INFO: renamed from: ColorProvider-8_81llA, reason: not valid java name */
    public static final ColorProvider m22055ColorProvider8_81llA(long j) {
        return new FixedColorProvider(j, null);
    }
}
