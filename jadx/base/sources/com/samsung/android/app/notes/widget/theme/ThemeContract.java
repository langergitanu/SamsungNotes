package com.samsung.android.app.notes.widget.theme;

import android.content.Context;
import android.widget.RemoteViews;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J6\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J&\u0010\u000e\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/theme/ThemeContract;", "", "applyThemeToWidgetFrame", "", "context", "Landroid/content/Context;", "remoteViews", "Landroid/widget/RemoteViews;", "info", "Lcom/samsung/android/app/notes/widget/theme/ThemeInfo;", "bgColor", "", "invert", "", "applyThemeToEmptyWidget", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface ThemeContract {
    void applyThemeToEmptyWidget(@Nullable Context context, @Nullable RemoteViews remoteViews, @Nullable ThemeInfo info);

    void applyThemeToWidgetFrame(@Nullable Context context, @Nullable RemoteViews remoteViews, @Nullable ThemeInfo info, int bgColor, boolean invert);
}
