package androidx.glance.appwidget.translators;

import android.content.Context;
import android.content.res.ColorStateList;
import android.widget.RemoteViews;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.ColorKt;
import androidx.core.widget.RemoteViewsCompat;
import androidx.glance.appwidget.unit.CheckableColorProvider;
import androidx.glance.appwidget.unit.CheckedUncheckedColorProvider;
import androidx.glance.appwidget.unit.ColorProviderKt;
import androidx.glance.appwidget.unit.ResourceCheckableColorProvider;
import androidx.glance.color.DayNightColorProvidersKt;
import com.microsoft.identity.common.java.WarningType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0001H\u0002ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a!\u0010\u000b\u001a\u00020\u0001*\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0000¢\u0006\u0002\u0010\u0011\u001a&\u0010\u0012\u001a\u00020\u0013*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0001H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u001c\u0010\u001a\u001a\u00020\u0006*\u00020\u001b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u0010H\u0002\u001a\u0014\u0010\u001d\u001a\u00020\u001e*\u00020\u001b2\u0006\u0010\r\u001a\u00020\u000eH\u0000\"\u0016\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0002\u0010\u0003\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001f"}, m13886d2 = {"checkableColorProviderFallbackColor", "Landroidx/compose/ui/graphics/Color;", "getCheckableColorProviderFallbackColor", "()J", "J", "createCheckedColorStateList", "Landroid/content/res/ColorStateList;", "checked", WarningType.unchecked_warning, "createCheckedColorStateList--OWjLjI", "(JJ)Landroid/content/res/ColorStateList;", "getColor", "Landroidx/glance/appwidget/unit/CheckableColorProvider;", "context", "Landroid/content/Context;", "isChecked", "", "(Landroidx/glance/appwidget/unit/CheckableColorProvider;Landroid/content/Context;Z)J", "setImageViewColorFilter", "", "Landroid/widget/RemoteViews;", "viewId", "", "color", "setImageViewColorFilter-mxwnekA", "(Landroid/widget/RemoteViews;IJ)V", "toColorStateList", "Landroidx/glance/appwidget/unit/CheckedUncheckedColorProvider;", "isNightMode", "toDayNightColorStateList", "Landroidx/glance/appwidget/translators/DayNightColorStateList;", "glance-appwidget_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class CompoundButtonTranslatorKt {
    private static final long checkableColorProviderFallbackColor = Color.INSTANCE.m18551getBlack0d7_KjU();

    /* JADX INFO: renamed from: createCheckedColorStateList--OWjLjI, reason: not valid java name */
    private static final ColorStateList m21397createCheckedColorStateListOWjLjI(long j, long j2) {
        return new ColorStateList(new int[][]{ColorProviderKt.getCheckedStateSet(), new int[0]}, new int[]{ColorKt.m18579toArgb8_81llA(j), ColorKt.m18579toArgb8_81llA(j2)});
    }

    public static final long getCheckableColorProviderFallbackColor() {
        return checkableColorProviderFallbackColor;
    }

    public static final long getColor(@NotNull CheckableColorProvider checkableColorProvider, @NotNull Context context, boolean z) {
        Color colorResolveCheckedColor$default;
        Intrinsics.checkNotNullParameter(checkableColorProvider, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (checkableColorProvider instanceof CheckedUncheckedColorProvider) {
            colorResolveCheckedColor$default = Color.m18515boximpl(((CheckedUncheckedColorProvider) checkableColorProvider).m21403getColorXeAY9LY(context, DayNightColorProvidersKt.isNightMode(context), z));
        } else {
            if (!(checkableColorProvider instanceof ResourceCheckableColorProvider)) {
                throw new NoWhenBranchMatchedException();
            }
            colorResolveCheckedColor$default = ColorProviderKt.resolveCheckedColor$default(context, ((ResourceCheckableColorProvider) checkableColorProvider).getResId(), z, null, 8, null);
        }
        return colorResolveCheckedColor$default != null ? colorResolveCheckedColor$default.m18535unboximpl() : checkableColorProviderFallbackColor;
    }

    /* JADX INFO: renamed from: setImageViewColorFilter-mxwnekA, reason: not valid java name */
    public static final void m21398setImageViewColorFiltermxwnekA(@NotNull RemoteViews setImageViewColorFilter, int i, long j) {
        Intrinsics.checkNotNullParameter(setImageViewColorFilter, "$this$setImageViewColorFilter");
        RemoteViewsCompat.setImageViewColorFilter(setImageViewColorFilter, i, ColorKt.m18579toArgb8_81llA(j));
    }

    private static final ColorStateList toColorStateList(CheckedUncheckedColorProvider checkedUncheckedColorProvider, Context context, boolean z) {
        return m21397createCheckedColorStateListOWjLjI(checkedUncheckedColorProvider.m21403getColorXeAY9LY(context, z, true), checkedUncheckedColorProvider.m21403getColorXeAY9LY(context, z, false));
    }

    @NotNull
    public static final DayNightColorStateList toDayNightColorStateList(@NotNull CheckedUncheckedColorProvider checkedUncheckedColorProvider, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(checkedUncheckedColorProvider, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return new DayNightColorStateList(toColorStateList(checkedUncheckedColorProvider, context, false), toColorStateList(checkedUncheckedColorProvider, context, true));
    }
}
