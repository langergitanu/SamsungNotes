package com.samsung.android.sdk.pen.setting.colorpalette;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.samsung.android.sdk.pen.setting.common.SpenRoundLayout;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.spen.C7932R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u0000 !2\u00020\u0001:\u0001!B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\b\u0010\u0011\u001a\u00020\u0012H\u0014J\u000e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\nJ\u000e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\nJ\u000e\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\nJ\b\u0010\u0018\u001a\u00020\u0012H\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u0012H\u0002J\u0010\u0010 \u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u0003H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u001a8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006\""}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenColorChipView;", "Lcom/samsung/android/sdk/pen/setting/common/SpenRoundLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mColorResourceId", "", "mBgResourceId", "mColor", "mBgChild", "Landroid/view/View;", "mAdaptiveStrokeWidth", "mAdaptiveStrokeColor", "onFinishInflate", "", "setColorResource", "resourceId", "setColor", "color", "setTransparentBackgroundResource", "setColorDrawable", "colorDrawable", "Landroid/graphics/drawable/GradientDrawable;", "getColorDrawable", "()Landroid/graphics/drawable/GradientDrawable;", "needOutline", "", "setBackgroundDrawable", "construct", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenColorChipView extends SpenRoundLayout {

    @NotNull
    private static final String TAG = "SpenColorChipView";
    private int mAdaptiveStrokeColor;
    private int mAdaptiveStrokeWidth;

    @Nullable
    private View mBgChild;
    private int mBgResourceId;
    private int mColor;
    private int mColorResourceId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenColorChipView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        construct(context);
    }

    private final void construct(Context context) {
        this.mAdaptiveStrokeWidth = context.getResources().getDimensionPixelSize(C7932R.dimen.setting_color_rect_chip_unselected_outline_size);
        this.mAdaptiveStrokeColor = SpenSettingUtil.getColor(context, C7932R.color.setting_color_rect_chip_unselected_outline_color);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final GradientDrawable getColorDrawable() {
        GradientDrawable gradientDrawable;
        Drawable foreground = getForeground();
        if (foreground instanceof GradientDrawable) {
            gradientDrawable = (GradientDrawable) foreground;
        } else if (this.mColorResourceId != 0) {
            Drawable drawable = getContext().getResources().getDrawable(this.mColorResourceId);
            gradientDrawable = drawable instanceof GradientDrawable ? (GradientDrawable) drawable : null;
        }
        if (gradientDrawable != null) {
            gradientDrawable.mutate();
        }
        return gradientDrawable;
    }

    private final boolean needOutline() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        return SpenSettingUtil.isAdaptiveColor(context, this.mColor) || this.mColor == 0;
    }

    private final void setBackgroundDrawable() {
        int i = this.mBgResourceId;
        if (this.mColor != 0) {
            if (this.mBgChild == null) {
                return;
            } else {
                i = 0;
            }
        }
        if (this.mBgChild == null) {
            this.mBgChild = new View(getContext());
            addView(this.mBgChild, new FrameLayout.LayoutParams(-1, -1));
        }
        View view = this.mBgChild;
        if (view != null) {
            view.setBackgroundResource(i);
        }
    }

    private final void setColorDrawable() {
        GradientDrawable colorDrawable = getColorDrawable();
        if (colorDrawable == null) {
            return;
        }
        colorDrawable.setCornerRadii(getCornerRadii());
        colorDrawable.setColor(this.mColor);
        if (needOutline()) {
            colorDrawable.setStroke(this.mAdaptiveStrokeWidth, this.mAdaptiveStrokeColor);
        } else {
            colorDrawable.setStroke(0, 0);
        }
        setForeground(colorDrawable);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() > 0) {
            this.mBgChild = getChildAt(0);
        }
    }

    public final void setColor(int color) {
        this.mColor = color;
        setBackgroundDrawable();
        setColorDrawable();
    }

    public final void setColorResource(int resourceId) {
        this.mColorResourceId = resourceId;
    }

    public final void setTransparentBackgroundResource(int resourceId) {
        this.mBgResourceId = resourceId;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenColorChipView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        construct(context);
    }
}
