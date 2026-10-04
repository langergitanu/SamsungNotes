package com.samsung.android.sdk.pen.setting.quicktool;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import com.samsung.android.sdk.pen.setting.handwriting.SpenPenAttrMiniView;
import com.samsung.android.sdk.pen.setting.util.SpenGradientDrawableHelper;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAdaptiveColor;
import com.samsung.android.spen.C7932R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0014J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTPenAttrView;", "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenAttrMiniView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mColorView", "Landroid/widget/ImageView;", "mBgDrawableHelper", "Lcom/samsung/android/sdk/pen/setting/util/SpenGradientDrawableHelper;", "onFinishInflate", "", "initView", "setColor", "color", "", "needOutline", "", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenQTPenAttrView extends SpenPenAttrMiniView {

    @NotNull
    private static final String TAG = "SpenQTPenAttrView";

    @NotNull
    private final SpenGradientDrawableHelper mBgDrawableHelper;

    @Nullable
    private ImageView mColorView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenQTPenAttrView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mBgDrawableHelper = new SpenGradientDrawableHelper();
    }

    private final void initView(Context context) {
        this.mBgDrawableHelper.setDrawableInfo(1, 0, context.getResources().getDimensionPixelSize(C7932R.dimen.setting_color_rect_chip_unselected_outline_size), SpenSettingUtil.getColor(context, C7932R.color.setting_qt_attr_chip_adaptive_outline_color));
        ImageView imageView = (ImageView) findViewById(C7932R.id.color);
        this.mColorView = imageView;
        if (imageView != null) {
            imageView.setForeground(this.mBgDrawableHelper.makeDrawable());
        }
    }

    private final boolean needOutline(int color) {
        boolean zIsAdaptiveColor = SpenSettingUtilAdaptiveColor.isAdaptiveColor(getContext(), color, SpenSettingUtilAdaptiveColor.UseType.DECISION_THICKNESS_OUTLINE);
        Log.i(TAG, "needOutline()=" + zIsAdaptiveColor + " color=" + Integer.toHexString(color));
        return zIsAdaptiveColor;
    }

    @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenPenAttrMiniView, android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        initView(context);
    }

    @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenPenAttrMiniView
    public void setColor(int color) {
        Drawable foreground;
        super.setColor(color);
        ImageView imageView = this.mColorView;
        if (imageView == null || (foreground = imageView.getForeground()) == null) {
            return;
        }
        this.mBgDrawableHelper.setStroke(foreground, needOutline(color));
    }
}
