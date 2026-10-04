package com.samsung.android.app.notes.widget.theme;

import android.content.Context;
import android.widget.RemoteViews;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import com.samsung.android.app.notes.widget.util.WidgetUtils;
import com.samsung.android.support.senl.p148nt.base.widget.theme.BaseWidgetThemeManager;
import com.samsung.android.support.senl.p148nt.homewidget.C11391R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J.\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u001e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ0\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000bH\u0002¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/theme/ShowNoteThemeManager;", "Lcom/samsung/android/support/senl/nt/base/widget/theme/BaseWidgetThemeManager;", "<init>", "()V", "updateTheme", "", "context", "Landroid/content/Context;", "remoteViews", "Landroid/widget/RemoteViews;", "info", "Lcom/samsung/android/app/notes/widget/theme/ThemeInfo;", "bgColor", "", "invert", "", "applyThemeToWidgetFrame", "applyThemeToEmptyWidget", "updateTitleColor", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ShowNoteThemeManager extends BaseWidgetThemeManager {
    public static final int $stable = 8;

    private final void updateTheme(Context context, RemoteViews remoteViews, ThemeInfo info, int bgColor, boolean invert) {
        boolean zIsDarkMode = info.isDarkMode();
        updateContentWidgetTheme(context, remoteViews, info, new int[]{bgColor, WidgetUtils.INSTANCE.getWidgetBgThemeColor(context, bgColor, invert, true)}, C11391R.id.background, C11391R.drawable.widget_background_white);
        updateItemImageTheme(context, remoteViews, zIsDarkMode, new int[]{C11391R.color.widget_white_theme_text_color, C11391R.color.widget_black_theme_text_color}, new int[]{C11391R.id.widget_settings, C11391R.id.widget_overlap_setting_icon});
        updateBackgroundTheme(remoteViews, zIsDarkMode, new int[]{C11391R.drawable.widget_option_white_background, C11391R.drawable.widget_option_dark_background}, new int[]{C11391R.id.widget_overlap_setting, C11391R.id.widget_overlap_voice});
    }

    private final void updateTitleColor(Context context, RemoteViews remoteViews, int bgColor, boolean invert, ThemeInfo info) {
        updateContentTitleTheme(context, remoteViews, info, WidgetUtils.INSTANCE.isWidgetTitleDarkThemeColor(context, bgColor, invert, info.isDarkMode()), new int[]{C11391R.color.widget_white_theme_text_color, C11391R.color.widget_black_theme_text_color}, new int[]{C11391R.id.widget_title, C11391R.id.widget_title_shadow});
    }

    public final void applyThemeToEmptyWidget(@NotNull Context context, @NotNull RemoteViews remoteViews, @NotNull ThemeInfo info) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(remoteViews, "remoteViews");
        Intrinsics.checkNotNullParameter(info, "info");
        updateTheme(context, remoteViews, info, info.getMIsMatchWithDarkMode() ? ContextCompat.getColor(context, C11391R.color.widget_bg_color_black) : ContextCompat.getColor(context, C11391R.color.widget_bg_color), false);
        updateContentEmptyTextTheme(context, remoteViews, info, C11391R.id.widget_no_memo_text, new int[]{C11391R.color.widget_white_theme_text_color, C11391R.color.widget_black_theme_text_color});
    }

    public final void applyThemeToWidgetFrame(@NotNull Context context, @NotNull RemoteViews remoteViews, @NotNull ThemeInfo info, int bgColor, boolean invert) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(remoteViews, "remoteViews");
        Intrinsics.checkNotNullParameter(info, "info");
        updateTheme(context, remoteViews, info, bgColor, invert);
        updateTitleColor(context, remoteViews, bgColor, invert, info);
    }
}
