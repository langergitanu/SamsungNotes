package com.samsung.android.app.notes.widget.glance.common;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.oneui.common.AppWidgetSize;
import com.samsung.android.support.senl.p148nt.homewidget.C11391R;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/glance/common/WidgetGlanceUtils;", "", "<init>", "()V", "getWelcomePageTitle", "", "widgetSize", "Landroidx/glance/oneui/common/AppWidgetSize;", "getWelcomePageTitle-L2j3NV4", "(I)I", "row", "column", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class WidgetGlanceUtils {
    public static final int $stable = 0;

    @NotNull
    public static final WidgetGlanceUtils INSTANCE = new WidgetGlanceUtils();

    private WidgetGlanceUtils() {
    }

    public final int getWelcomePageTitle(int row, int column) {
        return (row > 1 || column > 2) ? C11391R.string.widget_welcome_page_title_get_started : C11391R.string.widget_welcome_page_title_start;
    }

    /* JADX INFO: renamed from: getWelcomePageTitle-L2j3NV4, reason: not valid java name */
    public final int m22122getWelcomePageTitleL2j3NV4(int widgetSize) {
        return AppWidgetSize.m21546compareToL2j3NV4(widgetSize, AppWidgetSize.INSTANCE.m21570getSmallrx25Pp4()) <= 0 ? C11391R.string.widget_welcome_page_title_start : C11391R.string.widget_welcome_page_title_get_started;
    }
}
