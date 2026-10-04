package androidx.glance.color;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.glance.unit.ColorProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028G¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000b"}, m13886d2 = {"isNightMode", "", "Landroid/content/Context;", "(Landroid/content/Context;)Z", "ColorProvider", "Landroidx/glance/unit/ColorProvider;", "day", "Landroidx/compose/ui/graphics/Color;", "night", "ColorProvider--OWjLjI", "(JJ)Landroidx/glance/unit/ColorProvider;", "glance_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class DayNightColorProvidersKt {
    @NotNull
    /* JADX INFO: renamed from: ColorProvider--OWjLjI, reason: not valid java name */
    public static final ColorProvider m21426ColorProviderOWjLjI(long j, long j2) {
        return new DayNightColorProvider(j, j2, null);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final boolean isNightMode(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }
}
