package com.samsung.android.app.notes.widget.glance.list.theme;

import android.content.Context;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.ColorKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import androidx.glance.color.ColorProviders;
import androidx.glance.material3.Material3ThemesKt;
import androidx.glance.oneui.template.AppWidgetBackground;
import androidx.glance.oneui.template.Shape;
import androidx.glance.oneui.template.color.ColorProvidersKt;
import androidx.glance.unit.ColorProvider;
import androidx.glance.unit.ColorProviderKt;
import com.samsung.android.app.notes.widget.common.log.WidgetLogger;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataKey;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.base.widget.util.BaseWidgetUtils;
import com.samsung.android.support.senl.p148nt.homewidget.C11391R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0013\u001a\u00020\u0011J\u0006\u0010\u0014\u001a\u00020\u0011J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0006\u0010\u0018\u001a\u00020\u0011J\u0006\u0010\u0019\u001a\u00020\u0011J\u0006\u0010\u001a\u001a\u00020\u0011J\u0010\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0006\u0010\u001c\u001a\u00020\nJ\u001e\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010 \u001a\u00020!J\u0010\u0010\"\u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\nH\u0002J$\u0010#\u001a\u00020$2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020'R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/glance/list/theme/WidgetListGlanceTheme;", "", "mContext", "Landroid/content/Context;", "mAppWidgetId", "", "mTransparency", "mBackgroundColor", "mDarkMode", "mMatchSetting", "", "mBackgroundOnOff", "<init>", "(Landroid/content/Context;IIIIZZ)V", "updateBackground", "Landroidx/glance/color/ColorProviders;", "getColorSurface", "Landroidx/glance/unit/ColorProvider;", "updateListItemTitleColor", "updateListItemTimeColor", "updateListItemIconVoiceColor", "updateItemTextTheme", "colorId", "", "updateDividerColor", "updateBodyTextColor", "updateWelcomePageTextColor", "updateItemIconTheme", "isBlackBackground", "getColor", "context", "isDarkTheme", "getAlphaBackground", "", "getAlphaAddButton", "getAppWidgetBackground", "Landroidx/glance/oneui/template/AppWidgetBackground;", "uuidList", "", "", VMetaDataKey.META_KEY_SHAPE, "Landroidx/glance/oneui/template/Shape;", "providerName", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class WidgetListGlanceTheme {
    public static final int $stable = 8;
    private int mAppWidgetId;
    private int mBackgroundColor;
    private final boolean mBackgroundOnOff;

    @NotNull
    private Context mContext;
    private int mDarkMode;
    private boolean mMatchSetting;
    private int mTransparency;

    public WidgetListGlanceTheme(@NotNull Context mContext, int i, int i2, int i4, int i5, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.mContext = mContext;
        this.mAppWidgetId = i;
        this.mTransparency = i2;
        this.mBackgroundColor = i4;
        this.mDarkMode = i5;
        this.mMatchSetting = z;
        this.mBackgroundOnOff = z2;
    }

    private final float getAlphaAddButton(boolean isDarkTheme) {
        int i = this.mTransparency;
        return (i < 0 || i >= 51) ? (51 > i || i >= 76) ? (76 > i || i >= 101) ? isDarkTheme ? 0.4f : 0.2f : isDarkTheme ? 0.5f : 0.25f : isDarkTheme ? 0.4f : 0.2f : isDarkTheme ? 0.3f : 0.15f;
    }

    private final ColorProvider updateItemIconTheme(int[] colorId) {
        boolean zIsBlackBackground = isBlackBackground();
        return ColorProviderKt.m22055ColorProvider8_81llA(Color.m18524copywmQWz5c$default(ColorKt.Color(getColor(this.mContext, zIsBlackBackground, colorId)), zIsBlackBackground ? 0.6f : 0.95f, 0.0f, 0.0f, 0.0f, 14, null));
    }

    private final ColorProvider updateItemTextTheme(int[] colorId) {
        return ColorProviderKt.m22055ColorProvider8_81llA(ColorKt.Color(getColor(this.mContext, isBlackBackground(), colorId)));
    }

    public final float getAlphaBackground() {
        if (this.mBackgroundOnOff) {
            return this.mTransparency / 100;
        }
        return 0.0f;
    }

    @NotNull
    public final AppWidgetBackground getAppWidgetBackground(@NotNull List<String> uuidList, @NotNull Shape shape, @NotNull String providerName) {
        Intrinsics.checkNotNullParameter(uuidList, "uuidList");
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(providerName, "providerName");
        if (!uuidList.isEmpty() || Intrinsics.areEqual(providerName, BaseWidgetConstant.WIDGET_LIST_LOCK_BRIEF_PROVIDER_NAME)) {
            return new AppWidgetBackground.Color(shape);
        }
        return new AppWidgetBackground.Gradient(ContextUtils.isNightMode(this.mContext) ? C11391R.drawable.widget_glance_empty_background_gardient_dark : C11391R.drawable.widget_glance_empty_background_gardient, shape);
    }

    public final int getColor(@NotNull Context context, boolean isDarkTheme, @NotNull int[] colorId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(colorId, "colorId");
        return ContextCompat.getColor(context, isDarkTheme ? colorId[1] : colorId[0]);
    }

    @NotNull
    public final ColorProvider getColorSurface() {
        return ColorProviderKt.m22055ColorProvider8_81llA(Color.m18524copywmQWz5c$default(ColorKt.Color(getColor(this.mContext, isBlackBackground(), new int[]{C11391R.color.widget_list_glance_surface_color_light, C11391R.color.widget_list_glance_surface_color_dark})), this.mBackgroundOnOff ? this.mTransparency / 100 : 20.0f, 0.0f, 0.0f, 0.0f, 14, null));
    }

    public final boolean isBlackBackground() {
        return !this.mBackgroundOnOff ? !BaseWidgetUtils.INSTANCE.isWhiteWallPaper(this.mContext) : this.mMatchSetting ? ContextUtils.isNightMode(this.mContext) : this.mBackgroundColor == 0;
    }

    @NotNull
    public final ColorProviders updateBackground() {
        boolean zIsBlackBackground = isBlackBackground();
        boolean zIsBlackBackground2 = isBlackBackground();
        int[] iArr = {C11391R.color.widget_list_glance_background_color_white_theme, C11391R.color.widget_list_glance_background_color_dark_theme};
        int[] iArr2 = {C11391R.color.widget_list_glance_item_title_text_color_light, C11391R.color.widget_list_glance_item_title_text_color_dark};
        int[] iArr3 = {C11391R.color.widget_list_glance_surface_color_light, C11391R.color.widget_list_glance_surface_color_dark};
        int[] iArr4 = {C11391R.color.widget_list_glance_onSurface_color_light, C11391R.color.widget_list_glance_onSurface_color_dark};
        int color = getColor(this.mContext, zIsBlackBackground, iArr);
        int color2 = getColor(this.mContext, zIsBlackBackground2, iArr2);
        int color3 = getColor(this.mContext, zIsBlackBackground2, iArr3);
        int color4 = getColor(this.mContext, zIsBlackBackground2, iArr4);
        float f = this.mBackgroundOnOff ? this.mTransparency / 100 : 0.0f;
        float alphaAddButton = getAlphaAddButton(zIsBlackBackground2);
        WidgetLogger.m5154d("WidgetListGlanceTheme", "updateBackground : " + color + ", alpha : " + f);
        return Material3ThemesKt.ColorProviders(ColorProvidersKt.m21701createColorProvidersG1PFcw$default(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, Color.m18524copywmQWz5c$default(ColorKt.Color(color), f, 0.0f, 0.0f, 0.0f, 14, null), ColorKt.Color(color2), Color.m18524copywmQWz5c$default(ColorKt.Color(color3), alphaAddButton, 0.0f, 0.0f, 0.0f, 14, null), ColorKt.Color(color4), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 536748031, null));
    }

    @NotNull
    public final ColorProvider updateBodyTextColor() {
        return isBlackBackground() ? ColorProviderKt.m22055ColorProvider8_81llA(Color.m18524copywmQWz5c$default(ColorKt.Color(4294967295L), 1.0f, 0.0f, 0.0f, 0.0f, 14, null)) : ColorProviderKt.m22055ColorProvider8_81llA(Color.m18524copywmQWz5c$default(ColorKt.Color(1711276032), 1.0f, 0.0f, 0.0f, 0.0f, 14, null));
    }

    @NotNull
    public final ColorProvider updateDividerColor() {
        return isBlackBackground() ? ColorProviderKt.m22055ColorProvider8_81llA(ColorKt.Color(654311423)) : ColorProviderKt.m22055ColorProvider8_81llA(ColorKt.Color(637534208));
    }

    @NotNull
    public final ColorProvider updateListItemIconVoiceColor() {
        return updateItemIconTheme(new int[]{C11391R.color.widget_list_glance_item_time_text_color_light, C11391R.color.widget_list_glance_item_time_text_color_dark});
    }

    @NotNull
    public final ColorProvider updateListItemTimeColor() {
        return updateItemTextTheme(new int[]{C11391R.color.widget_white_theme_color, C11391R.color.widget_black_theme_color});
    }

    @NotNull
    public final ColorProvider updateListItemTitleColor() {
        return updateItemTextTheme(new int[]{C11391R.color.widget_list_glance_item_title_text_color_light, C11391R.color.widget_list_glance_item_title_text_color_dark});
    }

    @NotNull
    public final ColorProvider updateWelcomePageTextColor() {
        return isBlackBackground() ? ColorProviderKt.m22055ColorProvider8_81llA(Color.m18524copywmQWz5c$default(ColorKt.Color(1711276032), 1.0f, 0.0f, 0.0f, 0.0f, 14, null)) : ColorProviderKt.m22055ColorProvider8_81llA(Color.m18524copywmQWz5c$default(ColorKt.Color(4294967295L), 1.0f, 0.0f, 0.0f, 0.0f, 14, null));
    }

    public /* synthetic */ WidgetListGlanceTheme(Context context, int i, int i2, int i4, int i5, boolean z, boolean z2, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i6 & 2) != 0 ? 0 : i, (i6 & 4) != 0 ? 0 : i2, (i6 & 8) != 0 ? 0 : i4, (i6 & 16) != 0 ? 0 : i5, (i6 & 32) != 0 ? true : z, (i6 & 64) != 0 ? false : z2);
    }
}
