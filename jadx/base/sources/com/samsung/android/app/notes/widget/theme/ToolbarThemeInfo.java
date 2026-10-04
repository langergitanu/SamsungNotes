package com.samsung.android.app.notes.widget.theme;

import android.content.Context;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.app.notes.C6635R;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.base.widget.theme.BaseThemeInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\n¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/theme/ToolbarThemeInfo;", "Lcom/samsung/android/support/senl/nt/base/widget/theme/BaseThemeInfo;", "context", "Landroid/content/Context;", BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, "", "<init>", "(Landroid/content/Context;I)V", "textColor", "getTextColor", "()I", "strokeColor", "getStrokeColor", "notes-4.4.37.35_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ToolbarThemeInfo extends BaseThemeInfo {
    public static final int $stable = 8;

    public ToolbarThemeInfo(@Nullable Context context, int i) {
        super(context, i);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.theme.BaseThemeInfo
    public int getStrokeColor() {
        if (getMIsMatchWithDarkMode() && !getMIsForcedTheme()) {
            return C6635R.color.widget_white_theme_stroke_color;
        }
        if (getMTheme() == 1) {
            return -1;
        }
        return C6635R.color.widget_white_theme_stroke_color;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.theme.BaseThemeInfo
    public int getTextColor() {
        return (!getMIsMatchWithDarkMode() || getMIsForcedTheme()) ? getMTheme() == 1 ? C6635R.color.widget_toolbar_icon_color_white_theme : C6635R.color.widget_toolbar_icon_color_dark_theme : C6635R.color.widget_toolbar_icon_color_dark_theme;
    }
}
