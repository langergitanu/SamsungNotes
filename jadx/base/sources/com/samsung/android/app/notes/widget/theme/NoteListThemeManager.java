package com.samsung.android.app.notes.widget.theme;

import android.content.Context;
import android.widget.RemoteViews;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.support.senl.p148nt.base.widget.theme.BaseWidgetThemeManager;
import com.samsung.android.support.senl.p148nt.homewidget.C11391R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u001e\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ \u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J \u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u001e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011J\u001e\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011J\u001e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/theme/NoteListThemeManager;", "Lcom/samsung/android/support/senl/nt/base/widget/theme/BaseWidgetThemeManager;", "<init>", "()V", "applyThemeToWidgetFrame", "", "context", "Landroid/content/Context;", "remoteViews", "Landroid/widget/RemoteViews;", "info", "Lcom/samsung/android/app/notes/widget/theme/ThemeInfo;", "applyThemeToEmptyWidget", "updateTheme", "updateTitle", "updateListItemColor", "widgetId", "", "updateListItemTimeColor", "updateListItemIconColor", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class NoteListThemeManager extends BaseWidgetThemeManager {
    public static final int $stable = 8;

    private final void updateTheme(Context context, RemoteViews remoteViews, ThemeInfo info) {
        boolean zIsDarkMode = info.isDarkMode();
        updateWidgetTheme(context, remoteViews, info, new int[]{C11391R.color.widget_bg_color, C11391R.color.widget_list_bg_color_black, C11391R.color.widget_inside_background_color_white, C11391R.color.widget_inside_background_color_black}, new int[]{C11391R.id.background, C11391R.id.inside_background}, new int[]{C11391R.drawable.widget_background_white, C11391R.drawable.widget_inside_background});
        updateItemImageTheme(context, remoteViews, zIsDarkMode, new int[]{C11391R.color.widget_white_theme_text_color, C11391R.color.widget_black_theme_text_color}, new int[]{C11391R.id.widget_settings, C11391R.id.widget_overlap_setting_icon});
    }

    private final void updateTitle(Context context, RemoteViews remoteViews, ThemeInfo info) {
        updateTitleTheme(context, remoteViews, info, new int[]{C11391R.color.widget_white_theme_text_color, C11391R.color.widget_black_theme_text_color}, new int[]{C11391R.id.widget_title, C11391R.id.widget_title_shadow});
    }

    public final void applyThemeToEmptyWidget(@NotNull Context context, @NotNull RemoteViews remoteViews, @NotNull ThemeInfo info) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(remoteViews, "remoteViews");
        Intrinsics.checkNotNullParameter(info, "info");
        applyThemeToWidgetFrame(context, remoteViews, info);
        updateEmptyTextTheme(context, remoteViews, info, C11391R.id.widget_list_empty_text, new int[]{C11391R.color.widget_white_theme_text_color, C11391R.color.widget_black_theme_text_color});
    }

    public final void applyThemeToWidgetFrame(@NotNull Context context, @NotNull RemoteViews remoteViews, @NotNull ThemeInfo info) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(remoteViews, "remoteViews");
        Intrinsics.checkNotNullParameter(info, "info");
        updateTheme(context, remoteViews, info);
        updateTitle(context, remoteViews, info);
    }

    public final void updateListItemColor(@NotNull Context context, @NotNull RemoteViews remoteViews, int widgetId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(remoteViews, "remoteViews");
        ThemeInfo themeInfo = new ThemeInfo(context, widgetId);
        updateItemTextTheme(context, remoteViews, themeInfo.isDarkMode(), new int[]{C11391R.color.widget_white_theme_text_color, C11391R.color.widget_black_theme_text_color}, new int[]{C11391R.id.title, C11391R.id.content});
    }

    public final void updateListItemIconColor(@NotNull Context context, @NotNull RemoteViews remoteViews, int widgetId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(remoteViews, "remoteViews");
        ThemeInfo themeInfo = new ThemeInfo(context, widgetId);
        updateItemIconTheme(context, remoteViews, themeInfo.isDarkMode(), new int[]{C11391R.color.widget_white_theme_color, C11391R.color.widget_black_theme_color}, new int[]{C11391R.id.voice});
    }

    public final void updateListItemTimeColor(@NotNull Context context, @NotNull RemoteViews remoteViews, int widgetId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(remoteViews, "remoteViews");
        ThemeInfo themeInfo = new ThemeInfo(context, widgetId);
        updateItemTextTheme(context, remoteViews, themeInfo.isDarkMode(), new int[]{C11391R.color.widget_white_theme_color, C11391R.color.widget_black_theme_color}, new int[]{C11391R.id.time});
    }
}
