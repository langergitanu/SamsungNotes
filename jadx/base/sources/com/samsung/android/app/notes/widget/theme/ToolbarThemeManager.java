package com.samsung.android.app.notes.widget.theme;

import android.content.Context;
import android.widget.RemoteViews;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.app.notes.C6635R;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.base.widget.theme.BaseThemeInfo;
import com.samsung.android.support.senl.p148nt.base.widget.theme.BaseWidgetThemeManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u001e\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ \u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/theme/ToolbarThemeManager;", "Lcom/samsung/android/support/senl/nt/base/widget/theme/BaseWidgetThemeManager;", "<init>", "()V", "updateTheme", "", "context", "Landroid/content/Context;", "remoteViews", "Landroid/widget/RemoteViews;", "info", "Lcom/samsung/android/support/senl/nt/base/widget/theme/BaseThemeInfo;", "applyThemeToWidgetFrame", "updateTitleAndIconColor", "notes-4.4.37.35_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ToolbarThemeManager extends BaseWidgetThemeManager {
    public static final int $stable = 8;

    private final void updateTheme(Context context, RemoteViews remoteViews, BaseThemeInfo info) {
        updateWidgetTheme(context, remoteViews, info, new int[]{C6635R.color.widget_toolbar_background_color_white_theme, C6635R.color.widget_toolbar_background_color_dark_theme, C6635R.color.widget_inside_background_color_white, C6635R.color.widget_inside_background_color_black}, new int[]{C6635R.id.background, C6635R.id.inside_background}, new int[]{C6635R.drawable.widget_background_white, C6635R.drawable.widget_inside_background});
    }

    private final void updateTitleAndIconColor(Context context, RemoteViews remoteViews, BaseThemeInfo info) {
        int iUpdateTitleTheme = updateTitleTheme(context, remoteViews, info, new int[]{C6635R.color.widget_toolbar_icon_color_white_theme, C6635R.color.widget_toolbar_icon_color_dark_theme}, new int[]{C6635R.id.widget_app_name, C6635R.id.widget_app_name_and_shadow});
        remoteViews.setInt(C6635R.id.widget_launch_note_icon, BaseWidgetConstant.SET_COLOR_FILTER, iUpdateTitleTheme);
        remoteViews.setInt(C6635R.id.widget_add_icon, BaseWidgetConstant.SET_COLOR_FILTER, iUpdateTitleTheme);
        remoteViews.setInt(C6635R.id.widget_writing_icon, BaseWidgetConstant.SET_COLOR_FILTER, iUpdateTitleTheme);
        remoteViews.setInt(C6635R.id.widget_drawing_icon, BaseWidgetConstant.SET_COLOR_FILTER, iUpdateTitleTheme);
        remoteViews.setInt(C6635R.id.widget_image_icon, BaseWidgetConstant.SET_COLOR_FILTER, iUpdateTitleTheme);
        remoteViews.setInt(C6635R.id.widget_voice_icon, BaseWidgetConstant.SET_COLOR_FILTER, iUpdateTitleTheme);
    }

    public final void applyThemeToWidgetFrame(@NotNull Context context, @NotNull RemoteViews remoteViews, @NotNull BaseThemeInfo info) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(remoteViews, "remoteViews");
        Intrinsics.checkNotNullParameter(info, "info");
        updateTheme(context, remoteViews, info);
        updateTitleAndIconColor(context, remoteViews, info);
    }
}
