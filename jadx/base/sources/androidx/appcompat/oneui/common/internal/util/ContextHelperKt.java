package androidx.appcompat.oneui.common.internal.util;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.TypedValue;
import androidx.annotation.DimenRes;
import androidx.annotation.RestrictTo;
import androidx.appcompat.C0419R;
import androidx.core.view.accessibility.SeslAccessibilityManagerCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\u001a\u001e\u0010\u0007\u001a\u00020\b*\u00020\u00022\b\b\u0001\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000bH\u0007\u001a\u001e\u0010\u0007\u001a\u00020\f*\u00020\u00022\b\b\u0001\u0010\t\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\fH\u0007\u001a\f\u0010\u000e\u001a\u00020\b*\u00020\u0002H\u0007\u001a\f\u0010\u000f\u001a\u00020\b*\u00020\u0002H\u0007\u001a\f\u0010\u0010\u001a\u00020\b*\u00020\u0002H\u0007\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028G¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00028G¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004¨\u0006\u0011"}, m13886d2 = {"screenHeight", "", "Landroid/content/Context;", "getScreenHeight", "(Landroid/content/Context;)I", "screenWidth", "getScreenWidth", "getFloat", "", "id", "out", "Landroid/util/TypedValue;", "", "default", "isDefaultTheme", "isLightTheme", "isTalkbackOn", "appcompat_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class ContextHelperKt {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final boolean getFloat(@NotNull Context context, @DimenRes int i, @NotNull TypedValue out) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(out, "out");
        context.getResources().getValue(i, out, true);
        return out.type == 4;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final int getScreenHeight(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final int getScreenWidth(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final boolean isDefaultTheme(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return TextUtils.isEmpty(Settings.System.getString(context.getContentResolver(), "current_sec_active_themepackage"));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final boolean isLightTheme(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C0419R.attr.isLightTheme, typedValue, true);
        return typedValue.data != 0;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final boolean isTalkbackOn(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return SeslAccessibilityManagerCompat.INSTANCE.isScreenReaderEnabled(context);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final float getFloat(@NotNull Context context, @DimenRes int i, float f) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        TypedValue typedValue = new TypedValue();
        context.getResources().getValue(i, typedValue, true);
        return typedValue.type == 4 ? typedValue.getFloat() : f;
    }
}
