package com.samsung.android.app.notes.widget.glance.theme;

import android.content.Context;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.ColorKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import androidx.glance.color.ColorProviders;
import androidx.glance.material3.Material3ThemesKt;
import androidx.glance.oneui.template.color.ColorProvidersKt;
import com.samsung.android.app.notes.C6635R;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0012\u001a\u00020\nH\u0002J \u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/glance/theme/WidgetCreatorThemeManger;", "", "mContext", "Landroid/content/Context;", "mAppWidgetId", "", "mTransparency", "mBackgroundColor", "mDarkMode", "mMatchSetting", "", "mBackgroundOnOff", "<init>", "(Landroid/content/Context;IIIIZZ)V", "colorId", "", "updateBackground", "Landroidx/glance/color/ColorProviders;", "isBlackBackground", "getColor", "context", "isDarkTheme", "notes-4.4.37.35_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class WidgetCreatorThemeManger {
    public static final int $stable = 8;

    @NotNull
    private final int[] colorId;
    private final int mAppWidgetId;
    private final int mBackgroundColor;
    private final boolean mBackgroundOnOff;

    @NotNull
    private final Context mContext;
    private final int mDarkMode;
    private final boolean mMatchSetting;
    private final int mTransparency;

    public WidgetCreatorThemeManger(@NotNull Context mContext, int i, int i2, int i4, int i5, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.mContext = mContext;
        this.mAppWidgetId = i;
        this.mTransparency = i2;
        this.mBackgroundColor = i4;
        this.mDarkMode = i5;
        this.mMatchSetting = z;
        this.mBackgroundOnOff = z2;
        this.colorId = new int[]{C6635R.color.widget_creator_background_color_white_theme, C6635R.color.widget_creator_background_color_dark_theme};
    }

    private final int getColor(Context context, boolean isDarkTheme, int[] colorId) {
        return ContextCompat.getColor(context, isDarkTheme ? colorId[1] : colorId[0]);
    }

    private final boolean isBlackBackground() {
        return this.mMatchSetting ? ContextUtils.isNightMode(this.mContext) : this.mBackgroundColor == 0;
    }

    @NotNull
    public final ColorProviders updateBackground() {
        return Material3ThemesKt.ColorProviders(ColorProvidersKt.m21701createColorProvidersG1PFcw$default(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, Color.m18524copywmQWz5c$default(ColorKt.Color(getColor(this.mContext, isBlackBackground(), this.colorId)), this.mBackgroundOnOff ? this.mTransparency / 100 : 0.0f, 0.0f, 0.0f, 0.0f, 14, null), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 536862719, null));
    }

    public /* synthetic */ WidgetCreatorThemeManger(Context context, int i, int i2, int i4, int i5, boolean z, boolean z2, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i6 & 2) != 0 ? 0 : i, (i6 & 4) != 0 ? 0 : i2, (i6 & 8) != 0 ? 0 : i4, (i6 & 16) != 0 ? 0 : i5, (i6 & 32) != 0 ? false : z, (i6 & 64) != 0 ? false : z2);
    }
}
