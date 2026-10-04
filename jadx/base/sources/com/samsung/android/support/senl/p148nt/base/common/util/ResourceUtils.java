package com.samsung.android.support.senl.p148nt.base.common.util;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.View;
import com.samsung.android.support.senl.p145cm.base.framework.app.DialogCompat;
import com.samsung.android.support.senl.p145cm.base.framework.display.DisplayDeviceTypeCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0012\u0010\n\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007J\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\b\u0010\u0011\u001a\u00020\u0005H\u0007J\u001c\u0010\u0012\u001a\u00020\u00132\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/ResourceUtils;", "", "<init>", "()V", "isTabletLayout", "", "context", "Landroid/content/Context;", "isPhoneLayout", "isOverMediumScreen", "isLargeHandsetLayout", "isNavigationLocatedBottom", "getPrimaryColor", "", "getStringIdentifierFromName", "name", "", "isSupportBackgroundBlur", "setBlurInfoPopup", "", "view", "Landroid/view/View;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ResourceUtils {

    @NotNull
    public static final ResourceUtils INSTANCE = new ResourceUtils();

    private ResourceUtils() {
    }

    @JvmStatic
    public static final int getPrimaryColor(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(new TypedValue().data, new int[]{R.attr.colorAccent});
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        int color = typedArrayObtainStyledAttributes.getColor(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        return color;
    }

    @JvmStatic
    public static final boolean isLargeHandsetLayout(@Nullable Context context) {
        return context != null && context.getResources().getInteger(C8875R.integer.isLargeHandset) == 1;
    }

    private final boolean isOverMediumScreen(Context context) {
        return context != null && context.getResources().getInteger(C8875R.integer.isOverMediumScreen) == 1;
    }

    @JvmStatic
    public static final boolean isPhoneLayout(@Nullable Context context) {
        return (isTabletLayout(context) || (context != null && ModelFeature.getFeature().isFoldableModel() && DisplayDeviceTypeCompat.INSTANCE.getInstance().isMainDisplay(context.getResources().getConfiguration()))) ? false : true;
    }

    @JvmStatic
    public static final boolean isSupportBackgroundBlur() {
        return SystemPropertiesCompat.INSTANCE.getInstance().getOneUIVersion() >= 80000;
    }

    @JvmStatic
    public static final boolean isTabletLayout(@Nullable Context context) {
        return context != null && context.getResources().getInteger(C8875R.integer.isTablet) == 1;
    }

    @JvmStatic
    public static final void setBlurInfoPopup(@Nullable Context context, @Nullable View view) {
        if (context == null || !isSupportBackgroundBlur()) {
            return;
        }
        DialogCompat.INSTANCE.getInstance().setBlurInfoPopup(view, context.getResources().getDimensionPixelSize(C8875R.dimen.sesl_menu_popup_corner_radius), ContextUtils.isNightMode(context));
    }

    public final int getStringIdentifierFromName(@NotNull Context context, @Nullable String name) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getResources().getIdentifier(name, "string", context.getPackageName());
    }

    public final boolean isNavigationLocatedBottom(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return (isOverMediumScreen(context) && context.getResources().getConfiguration().orientation == 2) || context.getResources().getConfiguration().orientation == 1;
    }
}
