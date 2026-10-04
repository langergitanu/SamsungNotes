package com.samsung.android.support.senl.p148nt.base.widget.theme;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.RemoteViews;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.core.content.ContextCompat;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.base.widget.preference.BaseWidgetPreferenceManager;
import com.samsung.android.support.senl.p148nt.base.widget.util.BaseWidgetUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0019\b\u0016\u0018\u0000 +2\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J8\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0004J \u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\rH\u0002J\u0018\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0002J@\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0011H\u0002J0\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0004J0\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\rH\u0004J0\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0004J0\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0004J0\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0004J8\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u0011H\u0004J8\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0004J0\u0010 \u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\rH\u0004J0\u0010!\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\rH\u0004J0\u0010\"\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0011H\u0004J0\u0010#\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010$\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010%\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u0011H\u0004J\u0010\u0010'\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u000bH\u0004J\u0010\u0010(\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u000bH\u0002J(\u0010)\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010*\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0004¨\u0006,"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/widget/theme/BaseWidgetThemeManager;", "", "<init>", "()V", "updateWidgetTheme", "", "context", "Landroid/content/Context;", "remoteViews", "Landroid/widget/RemoteViews;", "info", "Lcom/samsung/android/support/senl/nt/base/widget/theme/BaseThemeInfo;", "colorId", "", "viewId", "drawableId", "getColor", "", "isDarkTheme", "", "saveTheme", "updateInsideTheme", "alpha", "updateTitleTheme", "updateEmptyTextTheme", "updateItemTextTheme", "updateItemImageTheme", "updateItemIconTheme", "updateContentWidgetTheme", "color", "updateContentTitleTheme", "isTitleDark", "updateContentEmptyImageTheme", "updateContentEmptyTextTheme", "updateBackgroundColor", "updateTitleAndShadow", "isShadowVisible", "textId", "shadowTextId", "isBlackBackground", "isMatchWithDarkMode", "updateBackgroundTheme", "bgId", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class BaseWidgetThemeManager {
    private static final int BACKGROUND_VIEW_ID_INDEX = 0;
    private static final int DARK_MODE_COLOR_INDEX = 1;
    private static final int DARK_MODE_INSIDE_BG_COLOR_INDEX = 3;
    private static final int INSIDE_BACKGROUND_VIEW_ID_INDEX = 1;
    private static final int LIGHT_MODE_COLOR_INDEX = 0;
    private static final int LIGHT_MODE_INSIDE_BG_COLOR_INDEX = 2;
    private static final int SHADOW_TEXT_VIEW_ID_INDEX = 1;
    private static final int TEXT_VIEW_ID_INDEX = 0;

    private final int getColor(Context context, boolean isDarkTheme, int[] colorId) {
        return ContextCompat.getColor(context, isDarkTheme ? colorId[1] : colorId[0]);
    }

    private final boolean isMatchWithDarkMode(BaseThemeInfo info) {
        return !BaseWidgetUtils.INSTANCE.isNotSupportMatchWithDarkMode() && info.getMIsMatchWithDarkMode();
    }

    private final void saveTheme(Context context, BaseThemeInfo info) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(BaseWidgetConstant.WIDGET_PREFERENCES, 0).edit();
        editorEdit.putInt(AbstractC0541b.m767i(info.getMAppWidgetId(), BaseWidgetConstant.WIDGET_ID, BaseWidgetConstant.WIDGET_THEME), info.getMTheme());
        editorEdit.apply();
    }

    private final void updateInsideTheme(Context context, RemoteViews remoteViews, boolean isDarkTheme, int[] colorId, int[] viewId, int[] drawableId, int alpha) {
        updateBackgroundColor(remoteViews, viewId[1], drawableId[1], ContextCompat.getColor(context, isDarkTheme ? colorId[3] : colorId[2]), alpha);
    }

    public final boolean isBlackBackground(@NotNull BaseThemeInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        return isMatchWithDarkMode(info) || info.getMBackgroundColor() == 0;
    }

    public final void updateBackgroundColor(@NotNull RemoteViews remoteViews, int viewId, int drawableId, int color, int alpha) {
        Intrinsics.checkNotNullParameter(remoteViews, "remoteViews");
        remoteViews.setInt(viewId, BaseWidgetConstant.SET_IMAGE_RESOURCE, drawableId);
        remoteViews.setInt(viewId, BaseWidgetConstant.SET_COLOR_FILTER, color);
        remoteViews.setInt(viewId, BaseWidgetConstant.SET_IMAGE_ALPHA, alpha);
    }

    public final void updateBackgroundTheme(@NotNull RemoteViews remoteViews, boolean isDarkTheme, @NotNull int[] bgId, @NotNull int[] viewId) {
        Intrinsics.checkNotNullParameter(remoteViews, "remoteViews");
        Intrinsics.checkNotNullParameter(bgId, "bgId");
        Intrinsics.checkNotNullParameter(viewId, "viewId");
        int i = isDarkTheme ? bgId[1] : bgId[0];
        for (int i2 : viewId) {
            remoteViews.setInt(i2, BaseWidgetConstant.SET_BACKGROUND_RESOURCE, i);
        }
    }

    public final void updateContentEmptyImageTheme(@NotNull Context context, @NotNull RemoteViews remoteViews, boolean isDarkTheme, int viewId, @NotNull int[] colorId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(remoteViews, "remoteViews");
        Intrinsics.checkNotNullParameter(colorId, "colorId");
        remoteViews.setInt(viewId, BaseWidgetConstant.SET_COLOR_FILTER, getColor(context, isDarkTheme, colorId));
    }

    public final void updateContentEmptyTextTheme(@NotNull Context context, @NotNull RemoteViews remoteViews, @NotNull BaseThemeInfo info, int viewId, @NotNull int[] colorId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(remoteViews, "remoteViews");
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(colorId, "colorId");
        remoteViews.setTextColor(viewId, getColor(context, info.isDarkMode(), colorId));
    }

    public final void updateContentTitleTheme(@NotNull Context context, @NotNull RemoteViews remoteViews, @NotNull BaseThemeInfo info, boolean isTitleDark, @NotNull int[] colorId, @NotNull int[] viewId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(remoteViews, "remoteViews");
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(colorId, "colorId");
        Intrinsics.checkNotNullParameter(viewId, "viewId");
        int color = getColor(context, isTitleDark, colorId);
        boolean z = isTitleDark && info.getMTransparency() == 100;
        remoteViews.setTextColor(z ? viewId[1] : viewId[0], color);
        remoteViews.setViewVisibility(viewId[0], z ? 8 : 0);
        remoteViews.setViewVisibility(viewId[1], z ? 0 : 8);
    }

    public final void updateContentWidgetTheme(@NotNull Context context, @NotNull RemoteViews remoteViews, @NotNull BaseThemeInfo info, @NotNull int[] color, int viewId, int drawableId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(remoteViews, "remoteViews");
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(color, "color");
        BaseWidgetPreferenceManager.INSTANCE.saveWidgetNightModeThemePref(info.getMAppWidgetId(), info.getMIsMatchWithDarkMode());
        saveTheme(context, info);
        updateBackgroundColor(remoteViews, viewId, drawableId, isBlackBackground(info) ? color[1] : color[0], BaseWidgetUtils.INSTANCE.convertAlpha(info.getMTransparency()));
    }

    public final void updateEmptyTextTheme(@NotNull Context context, @NotNull RemoteViews remoteViews, @NotNull BaseThemeInfo info, int viewId, @NotNull int[] colorId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(remoteViews, "remoteViews");
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(colorId, "colorId");
        remoteViews.setTextColor(viewId, getColor(context, info.isDarkMode(), colorId));
    }

    public final void updateItemIconTheme(@NotNull Context context, @NotNull RemoteViews remoteViews, boolean isDarkTheme, @NotNull int[] colorId, @NotNull int[] viewId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(remoteViews, "remoteViews");
        Intrinsics.checkNotNullParameter(colorId, "colorId");
        Intrinsics.checkNotNullParameter(viewId, "viewId");
        int color = getColor(context, isDarkTheme, colorId);
        int iConvertAlpha = BaseWidgetUtils.INSTANCE.convertAlpha(isDarkTheme ? 40 : 5);
        for (int i : viewId) {
            remoteViews.setInt(i, BaseWidgetConstant.SET_COLOR_FILTER, color);
            remoteViews.setInt(i, BaseWidgetConstant.SET_IMAGE_ALPHA, iConvertAlpha);
        }
    }

    public final void updateItemImageTheme(@NotNull Context context, @NotNull RemoteViews remoteViews, boolean isDarkTheme, @NotNull int[] colorId, @NotNull int[] viewId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(remoteViews, "remoteViews");
        Intrinsics.checkNotNullParameter(colorId, "colorId");
        Intrinsics.checkNotNullParameter(viewId, "viewId");
        int color = getColor(context, isDarkTheme, colorId);
        for (int i : viewId) {
            remoteViews.setInt(i, BaseWidgetConstant.SET_COLOR_FILTER, color);
        }
    }

    public final void updateItemTextTheme(@NotNull Context context, @NotNull RemoteViews remoteViews, boolean isDarkTheme, @NotNull int[] colorId, @NotNull int[] viewId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(remoteViews, "remoteViews");
        Intrinsics.checkNotNullParameter(colorId, "colorId");
        Intrinsics.checkNotNullParameter(viewId, "viewId");
        int color = getColor(context, isDarkTheme, colorId);
        for (int i : viewId) {
            remoteViews.setTextColor(i, color);
        }
    }

    public final void updateTitleAndShadow(@NotNull RemoteViews remoteViews, boolean isShadowVisible, int color, int textId, int shadowTextId) {
        Intrinsics.checkNotNullParameter(remoteViews, "remoteViews");
        if (isShadowVisible) {
            remoteViews.setTextColor(shadowTextId, color);
            remoteViews.setViewVisibility(shadowTextId, 0);
            remoteViews.setViewVisibility(textId, 8);
        } else {
            remoteViews.setTextColor(textId, color);
            remoteViews.setViewVisibility(textId, 0);
            remoteViews.setViewVisibility(shadowTextId, 8);
        }
    }

    public final int updateTitleTheme(@NotNull Context context, @NotNull RemoteViews remoteViews, @NotNull BaseThemeInfo info, @NotNull int[] colorId, @NotNull int[] viewId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(remoteViews, "remoteViews");
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(colorId, "colorId");
        Intrinsics.checkNotNullParameter(viewId, "viewId");
        boolean zIsDarkMode = info.isDarkMode();
        int color = getColor(context, zIsDarkMode, colorId);
        updateTitleAndShadow(remoteViews, zIsDarkMode && info.getMTransparency() == 100, color, viewId[0], viewId[1]);
        return color;
    }

    public final void updateWidgetTheme(@NotNull Context context, @NotNull RemoteViews remoteViews, @NotNull BaseThemeInfo info, @NotNull int[] colorId, @NotNull int[] viewId, @NotNull int[] drawableId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(remoteViews, "remoteViews");
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(colorId, "colorId");
        Intrinsics.checkNotNullParameter(viewId, "viewId");
        Intrinsics.checkNotNullParameter(drawableId, "drawableId");
        BaseWidgetPreferenceManager.INSTANCE.saveWidgetNightModeThemePref(info.getMAppWidgetId(), info.getMIsMatchWithDarkMode());
        saveTheme(context, info);
        boolean zIsBlackBackground = isBlackBackground(info);
        int color = getColor(context, zIsBlackBackground, colorId);
        int iConvertAlpha = BaseWidgetUtils.INSTANCE.convertAlpha(info.getMTransparency());
        updateBackgroundColor(remoteViews, viewId[0], drawableId[0], color, iConvertAlpha);
        if (colorId.length == 4) {
            updateInsideTheme(context, remoteViews, zIsBlackBackground, colorId, viewId, drawableId, iConvertAlpha);
        }
    }
}
