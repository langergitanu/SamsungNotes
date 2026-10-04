package com.samsung.android.app.notes.widget.util;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.app.notes.C6635R;
import com.samsung.android.app.notes.widget.WidgetToolBarProvider;
import com.samsung.android.app.notes.widget.lockbrief.WidgetCreatorLockBriefProvider;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.HomeScreenUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.base.widget.preference.BaseWidgetPreferenceManager;
import com.samsung.android.support.senl.p148nt.base.widget.util.BaseWidgetUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0007H\u0002J\u0016\u0010\u0012\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0007J\u0016\u0010\u0014\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0007J\"\u0010\u001b\u001a\u00020\u00102\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\n\u001a\u00020\u0007J\u0012\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u001f2\u0006\u0010 \u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0018¨\u0006!"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/util/WidgetToolbarUtils;", "Lcom/samsung/android/app/notes/widget/util/WidgetUtils;", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "getWidgetLayoutId", "", "context", "Landroid/content/Context;", "widgetId", "phonePortLayout", "phoneLandLayout", "phoneLayout", "defaultLayout", "canShowTitle", "", "widgetHeight", "getWidgetHeightPx", BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, "isHeightChanged", "dimensionForPhoneModel", "", "getDimensionForPhoneModel", "()[I", "dimensionForTabletModel", "getDimensionForTabletModel", "isCurrentProviderWidget", "provider", "Landroid/content/ComponentName;", "getClassProvider", "Ljava/lang/Class;", "providerName", "notes-4.4.37.35_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class WidgetToolbarUtils extends WidgetUtils {

    @NotNull
    private static final String TAG = "WidgetToolBarUtils";

    @NotNull
    public static final WidgetToolbarUtils INSTANCE = new WidgetToolbarUtils();
    public static final int $stable = WidgetUtils.$stable;

    private WidgetToolbarUtils() {
    }

    private final boolean canShowTitle(Context context, int widgetHeight) {
        int dimension = 0;
        for (int i : DeviceUtils.isTabletModel() ? getDimensionForTabletModel() : getDimensionForPhoneModel()) {
            dimension = (int) (context.getResources().getDimension(i) + dimension);
        }
        Logger.m8697d(TAG, "canShowTitle# widgetHeight = " + widgetHeight + " / minWidgetHeight = " + dimension);
        return widgetHeight >= dimension;
    }

    private final int[] getDimensionForPhoneModel() {
        return new int[]{C6635R.dimen.widget_toolbar_top_margin, C6635R.dimen.widget_toolbar_bottom_margin, C6635R.dimen.widget_toolbar_app_name_text_size, C6635R.dimen.widget_toolbar_item_list_container_top_margin, C6635R.dimen.widget_toolbar_item_list_container_bottom_margin, C6635R.dimen.widget_toolbar_ic_height_phone};
    }

    private final int[] getDimensionForTabletModel() {
        return new int[]{C6635R.dimen.widget_toolbar_top_margin, C6635R.dimen.widget_toolbar_bottom_margin, C6635R.dimen.widget_toolbar_app_name_text_size, C6635R.dimen.widget_toolbar_item_list_container_top_margin, C6635R.dimen.widget_toolbar_item_list_container_bottom_margin, C6635R.dimen.widget_toolbar_ic_height_tablet};
    }

    @NotNull
    public final Class<?> getClassProvider(@NotNull String providerName) {
        Intrinsics.checkNotNullParameter(providerName, "providerName");
        return Intrinsics.areEqual(providerName, "WidgetCreatorLockBriefProvider") ? WidgetCreatorLockBriefProvider.class : WidgetToolBarProvider.class;
    }

    public final int getWidgetHeightPx(@NotNull Context context, int appWidgetId) {
        Intrinsics.checkNotNullParameter(context, "context");
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        Resources resources = context.getResources();
        Bundle appWidgetOptions = appWidgetManager.getAppWidgetOptions(appWidgetId);
        return (int) WidgetUtils.INSTANCE.dipToPixels(context, resources.getConfiguration().orientation == 1 ? appWidgetOptions.getInt("appWidgetMaxHeight") : appWidgetOptions.getInt("appWidgetMinHeight"));
    }

    public final int getWidgetLayoutId(@NotNull Context context, int widgetId, int phonePortLayout, int phoneLandLayout, int phoneLayout, int defaultLayout) {
        Intrinsics.checkNotNullParameter(context, "context");
        int widgetHeightPx = getWidgetHeightPx(context, widgetId);
        BaseWidgetPreferenceManager.INSTANCE.saveWidgetHeightPref(widgetId, widgetHeightPx);
        if (BaseWidgetUtils.INSTANCE.isFoldWidgetLayout()) {
            if (HomeScreenUtils.INSTANCE.isCurrentCoverScreenMirroringDisplay(context)) {
                Logger.m8702i(TAG, "getWidgetLayoutId# widgetId: " + widgetId + ",  phone portrait layout");
                return phonePortLayout;
            }
            Logger.m8702i(TAG, "getWidgetLayoutId# widgetId: " + widgetId + ", phone layout");
            return phoneLayout;
        }
        if (canShowTitle(context, widgetHeightPx)) {
            Logger.m8702i(TAG, "getWidgetLayoutId# widgetId: " + widgetId + ", default layout");
            return defaultLayout;
        }
        Logger.m8702i(TAG, "getWidgetLayoutId# widgetId: " + widgetId + ", phone land layout");
        return phoneLandLayout;
    }

    public final boolean isCurrentProviderWidget(@Nullable Context context, @Nullable ComponentName provider, int widgetId) {
        for (int i : AppWidgetManager.getInstance(context).getAppWidgetIds(provider)) {
            if (i == widgetId) {
                return true;
            }
        }
        return false;
    }

    public final boolean isHeightChanged(@NotNull Context context, int appWidgetId) {
        Intrinsics.checkNotNullParameter(context, "context");
        int widgetHeightPx = getWidgetHeightPx(context, appWidgetId);
        int widgetHeightPref = BaseWidgetPreferenceManager.INSTANCE.getWidgetHeightPref(appWidgetId, widgetHeightPx);
        StringBuilder sbM1173s = AbstractC0622a.m1173s(appWidgetId, widgetHeightPref, "isHeightChanged# ", ", oldHeight: ", " / newHeight: ");
        sbM1173s.append(widgetHeightPx);
        Logger.m8697d(TAG, sbM1173s.toString());
        return widgetHeightPx != widgetHeightPref;
    }
}
