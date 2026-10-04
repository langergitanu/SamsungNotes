package com.samsung.android.app.notes.widget.glance.single.theme;

import android.content.Context;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.ColorKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.glance.color.ColorProviders;
import androidx.glance.material3.Material3ThemesKt;
import androidx.glance.oneui.template.AppWidgetBackground;
import androidx.glance.oneui.template.Shape;
import androidx.glance.oneui.template.color.ColorProvidersKt;
import androidx.glance.unit.ColorProvider;
import androidx.glance.unit.ColorProviderKt;
import com.samsung.android.app.notes.widget.capture.CacheFileManager;
import com.samsung.android.app.notes.widget.common.constants.WidgetConstant;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataKey;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.base.widget.util.BaseWidgetUtils;
import com.samsung.android.support.senl.p148nt.homewidget.C11391R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001Bi\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0007J\u0006\u0010\u0017\u001a\u00020\u0005J\r\u0010\u0018\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u001dJ\r\u0010\u001f\u001a\u00020\u0019¢\u0006\u0004\b \u0010\u001bJ\u0006\u0010!\u001a\u00020\fJ\u0006\u0010\"\u001a\u00020\fJ\u0006\u0010#\u001a\u00020\fJ\u001e\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\f2\u0006\u0010'\u001a\u00020\u0013J\u000e\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+J\u0006\u0010,\u001a\u00020\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/glance/single/theme/WidgetSingleGlanceTheme;", "", "mContext", "Landroid/content/Context;", "mAppWidgetId", "", "mUuid", "", "mTransparency", "mBackgroundColor", "mDarkMode", "mMatchSetting", "", "mBackgroundOnOff", "mTypeWidgetView", "mProviderName", "<init>", "(Landroid/content/Context;ILjava/lang/String;IIIZZLjava/lang/String;Ljava/lang/String;)V", "colorIdBackground", "", "updateBackground", "Landroidx/glance/color/ColorProviders;", "oneUiWidgetSource", "getColorBackground", "updateTitleTextColor", "Landroidx/compose/ui/graphics/Color;", "updateTitleTextColor-0d7_KjU", "()J", "updateBodyTextColor", "Landroidx/glance/unit/ColorProvider;", "updateWelcomePageTextColor", "updateViewMoreBackgroundColor", "updateViewMoreBackgroundColor-0d7_KjU", "isWhiteTextColor", "isBlackBackground", "isPageDark", "getColor", "context", "isDarkTheme", "colorId", "getAppWidgetBackground", "Landroidx/glance/oneui/template/AppWidgetBackground;", VMetaDataKey.META_KEY_SHAPE, "Landroidx/glance/oneui/template/Shape;", "getGradientColor", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class WidgetSingleGlanceTheme {
    public static final int $stable = 8;

    @NotNull
    private final int[] colorIdBackground;
    private int mAppWidgetId;
    private int mBackgroundColor;
    private final boolean mBackgroundOnOff;

    @NotNull
    private Context mContext;
    private int mDarkMode;
    private boolean mMatchSetting;

    @NotNull
    private final String mProviderName;
    private int mTransparency;

    @NotNull
    private final String mTypeWidgetView;

    @NotNull
    private final String mUuid;

    public WidgetSingleGlanceTheme(@NotNull Context mContext, int i, @NotNull String mUuid, int i2, int i4, int i5, boolean z, boolean z2, @NotNull String mTypeWidgetView, @NotNull String mProviderName) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(mUuid, "mUuid");
        Intrinsics.checkNotNullParameter(mTypeWidgetView, "mTypeWidgetView");
        Intrinsics.checkNotNullParameter(mProviderName, "mProviderName");
        this.mContext = mContext;
        this.mAppWidgetId = i;
        this.mUuid = mUuid;
        this.mTransparency = i2;
        this.mBackgroundColor = i4;
        this.mDarkMode = i5;
        this.mMatchSetting = z;
        this.mBackgroundOnOff = z2;
        this.mTypeWidgetView = mTypeWidgetView;
        this.mProviderName = mProviderName;
        this.colorIdBackground = new int[]{C11391R.color.widget_note_page_color_light, C11391R.color.widget_note_page_color_dark};
    }

    public static /* synthetic */ ColorProviders updateBackground$default(WidgetSingleGlanceTheme widgetSingleGlanceTheme, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return widgetSingleGlanceTheme.updateBackground(str);
    }

    @NotNull
    public final AppWidgetBackground getAppWidgetBackground(@NotNull Shape shape) {
        Intrinsics.checkNotNullParameter(shape, "shape");
        return ((Intrinsics.areEqual(this.mTypeWidgetView, WidgetConstant.EMPTY_VIEW) || Intrinsics.areEqual(this.mUuid, BaseWidgetConstant.NONE)) && !Intrinsics.areEqual(this.mProviderName, BaseWidgetConstant.WIDGET_SINGLE_LOCK_BRIEF_PROVIDER_NAME)) ? new AppWidgetBackground.Gradient(getGradientColor(), shape) : new AppWidgetBackground.Color(shape);
    }

    public final int getColor(@NotNull Context context, boolean isDarkTheme, @NotNull int[] colorId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(colorId, "colorId");
        return isDarkTheme ? ContextCompat.getColor(context, colorId[1]) : ContextCompat.getColor(context, colorId[0]);
    }

    public final int getColorBackground() {
        CacheFileManager.Companion companion = CacheFileManager.INSTANCE;
        boolean zHasBackgroundImage = companion.getInstance().hasBackgroundImage(this.mUuid);
        int pageColor = companion.getInstance().getPageColor(this.mUuid);
        int color = ContextCompat.getColor(this.mContext, this.colorIdBackground[0]);
        int color2 = ContextCompat.getColor(this.mContext, this.colorIdBackground[1]);
        if (Intrinsics.areEqual(this.mTypeWidgetView, WidgetConstant.NORMAL_VIEW)) {
            if (pageColor != color || !isBlackBackground() || zHasBackgroundImage) {
                return (pageColor == color2 || !isBlackBackground()) ? pageColor : ColorUtils.blendARGB(pageColor, this.colorIdBackground[1], 0.1f);
            }
        } else if (!isBlackBackground()) {
            return color;
        }
        return color2;
    }

    public final int getGradientColor() {
        return ContextUtils.isNightMode(this.mContext) ? C11391R.drawable.widget_glance_empty_background_gardient_dark : C11391R.drawable.widget_glance_empty_background_gardient;
    }

    public final boolean isBlackBackground() {
        return !this.mBackgroundOnOff ? !BaseWidgetUtils.INSTANCE.isWhiteWallPaper(this.mContext) : this.mMatchSetting ? ContextUtils.isNightMode(this.mContext) : this.mBackgroundColor == 0;
    }

    public final boolean isPageDark() {
        if (!this.mBackgroundOnOff) {
            return isBlackBackground();
        }
        CacheFileManager.Companion companion = CacheFileManager.INSTANCE;
        boolean zHasBackgroundImage = companion.getInstance().hasBackgroundImage(this.mUuid);
        int pageColor = companion.getInstance().getPageColor(this.mUuid);
        int color = ContextCompat.getColor(this.mContext, this.colorIdBackground[0]);
        ContextCompat.getColor(this.mContext, this.colorIdBackground[1]);
        return pageColor == color && isBlackBackground() && !zHasBackgroundImage;
    }

    public final boolean isWhiteTextColor() {
        if (this.mBackgroundOnOff) {
            return getColorBackground() == ContextCompat.getColor(this.mContext, C11391R.color.widget_note_page_color_dark);
        }
        return isBlackBackground();
    }

    @NotNull
    public final ColorProviders updateBackground(@Nullable String oneUiWidgetSource) {
        return Material3ThemesKt.ColorProviders(ColorProvidersKt.m21701createColorProvidersG1PFcw$default(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, Color.m18524copywmQWz5c$default(ColorKt.Color(getColorBackground()), this.mBackgroundOnOff ? this.mTransparency / 100 : (oneUiWidgetSource == null || !Intrinsics.areEqual(oneUiWidgetSource, BaseWidgetConstant.ONE_UI_WIDGET_SOURCE_SPAGE)) ? 0.0f : 0.1f, 0.0f, 0.0f, 0.0f, 14, null), ColorKt.Color(getColor(this.mContext, isWhiteTextColor(), new int[]{C11391R.color.widget_list_glance_item_title_text_color_light, C11391R.color.widget_list_glance_item_title_text_color_dark})), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 536846335, null));
    }

    @NotNull
    public final ColorProvider updateBodyTextColor() {
        return isBlackBackground() ? ColorProviderKt.m22055ColorProvider8_81llA(Color.m18524copywmQWz5c$default(ColorKt.Color(4294967295L), 1.0f, 0.0f, 0.0f, 0.0f, 14, null)) : ColorProviderKt.m22055ColorProvider8_81llA(Color.m18524copywmQWz5c$default(ColorKt.Color(1711276032), 1.0f, 0.0f, 0.0f, 0.0f, 14, null));
    }

    /* JADX INFO: renamed from: updateTitleTextColor-0d7_KjU, reason: not valid java name */
    public final long m22146updateTitleTextColor0d7_KjU() {
        int[] iArr = {C11391R.color.widget_list_glance_item_title_text_color_light, C11391R.color.widget_list_glance_item_title_text_color_dark};
        return ColorKt.Color(getColor(this.mContext, isWhiteTextColor(), iArr));
    }

    /* JADX INFO: renamed from: updateViewMoreBackgroundColor-0d7_KjU, reason: not valid java name */
    public final long m22147updateViewMoreBackgroundColor0d7_KjU() {
        int[] iArr = {C11391R.color.widget_view_more_white_background, C11391R.color.widget_view_more_black_background};
        return ColorKt.Color(getColor(this.mContext, isWhiteTextColor(), iArr));
    }

    @NotNull
    public final ColorProvider updateWelcomePageTextColor() {
        return isBlackBackground() ? ColorProviderKt.m22055ColorProvider8_81llA(Color.m18524copywmQWz5c$default(ColorKt.Color(1711276032), 1.0f, 0.0f, 0.0f, 0.0f, 14, null)) : ColorProviderKt.m22055ColorProvider8_81llA(Color.m18524copywmQWz5c$default(ColorKt.Color(4294967295L), 1.0f, 0.0f, 0.0f, 0.0f, 14, null));
    }

    public /* synthetic */ WidgetSingleGlanceTheme(Context context, int i, String str, int i2, int i4, int i5, boolean z, boolean z2, String str2, String str3, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i6 & 2) != 0 ? 0 : i, (i6 & 4) != 0 ? "" : str, (i6 & 8) != 0 ? 0 : i2, (i6 & 16) != 0 ? 0 : i4, (i6 & 32) != 0 ? 0 : i5, (i6 & 64) != 0 ? true : z, (i6 & 128) != 0 ? true : z2, (i6 & 256) != 0 ? WidgetConstant.EMPTY_VIEW : str2, (i6 & 512) != 0 ? BaseWidgetConstant.WIDGET_SINGLE_PROVIDER_NAME : str3);
    }
}
