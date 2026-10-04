package com.samsung.android.sdk.pen.setting.quicktool;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.AppCompatImageView;
import com.samsung.android.sdk.pen.setting.util.SpenGradientDrawableHelper;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAdaptiveColor;
import com.samsung.android.spen.C7932R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSimpleChipView;", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mBgDrawableHelper", "Lcom/samsung/android/sdk/pen/setting/util/SpenGradientDrawableHelper;", "setColor", "", "color", "", "needOutline", "", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenSimpleChipView extends AppCompatImageView {
    private static final int DEFAULT_COLOR = -16777216;

    @NotNull
    private static final String TAG = "SpenSimpleChipView";

    @NotNull
    private final SpenGradientDrawableHelper mBgDrawableHelper;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenSimpleChipView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        SpenGradientDrawableHelper spenGradientDrawableHelper = new SpenGradientDrawableHelper();
        this.mBgDrawableHelper = spenGradientDrawableHelper;
        spenGradientDrawableHelper.setDrawableInfo(1, -16777216, context.getResources().getDimensionPixelSize(C7932R.dimen.setting_color_rect_chip_unselected_outline_size), SpenSettingUtil.getColor(context, C7932R.color.setting_qt_color_chip_adaptive_outline_color));
        setImageDrawable(spenGradientDrawableHelper.makeDrawable());
    }

    private final boolean needOutline(int color) {
        return SpenSettingUtilAdaptiveColor.isAdaptiveColor(getContext(), color, SpenSettingUtilAdaptiveColor.UseType.DECISION_COLOR_CHIP_OUTLINE);
    }

    public final void setColor(int color) {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        SpenGradientDrawableHelper.INSTANCE.setColor(drawable, color);
        this.mBgDrawableHelper.setStroke(getDrawable(), needOutline(color));
    }
}
