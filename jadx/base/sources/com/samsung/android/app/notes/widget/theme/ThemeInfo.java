package com.samsung.android.app.notes.widget.theme;

import android.content.Context;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.app.notes.widget.util.WidgetUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.base.widget.preference.BaseWidgetPreferenceManager;
import com.samsung.android.support.senl.p148nt.base.widget.theme.BaseThemeInfo;
import com.samsung.android.support.senl.p148nt.base.widget.util.BaseWidgetUtils;
import com.samsung.android.support.senl.p148nt.homewidget.C11391R;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\tJ\u0010\u0010\n\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003H\u0016R\u0014\u0010\u000b\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\r¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/theme/ThemeInfo;", "Lcom/samsung/android/support/senl/nt/base/widget/theme/BaseThemeInfo;", BaseWidgetConstant.WIDGET_THEME, "", "<init>", "(I)V", "context", "Landroid/content/Context;", BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, "(Landroid/content/Context;I)V", "setForceContentsThemeColor", "textColor", "getTextColor", "()I", "strokeColor", "getStrokeColor", "Companion", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ThemeInfo extends BaseThemeInfo {

    @NotNull
    private static final String TAG = "ThemeInfo";
    public static final int $stable = 8;

    public ThemeInfo(int i) {
        super(i);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.theme.BaseThemeInfo
    public int getStrokeColor() {
        if (getMIsMatchWithDarkMode() && !getMIsForcedTheme()) {
            return C11391R.color.widget_black_theme_text_color;
        }
        if (getMTheme() == 1) {
            return -1;
        }
        return C11391R.color.widget_black_theme_text_color;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.theme.BaseThemeInfo
    public int getTextColor() {
        return (!getMIsMatchWithDarkMode() || getMIsForcedTheme()) ? getMTheme() == 1 ? C11391R.color.widget_white_theme_text_color : C11391R.color.widget_black_theme_text_color : C11391R.color.widget_black_theme_text_color;
    }

    public ThemeInfo(@Nullable Context context, int i) {
        super(context, i);
        if (WidgetUtils.INSTANCE.needReverseColor(i)) {
            setMTransparency(BaseWidgetPreferenceManager.INSTANCE.getTransparency(i));
            setMTheme(BaseWidgetUtils.INSTANCE.checkTheme(context, getMTransparency(), getMBackgroundColor()));
        }
        Logger.m8697d(TAG, toString());
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.theme.BaseThemeInfo
    @NotNull
    public ThemeInfo setForceContentsThemeColor(int theme) {
        setMIsForcedTheme(true);
        setMTheme(theme);
        return this;
    }
}
