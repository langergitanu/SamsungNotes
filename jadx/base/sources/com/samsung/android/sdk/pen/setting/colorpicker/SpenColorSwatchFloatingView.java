package com.samsung.android.sdk.pen.setting.colorpicker;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005J\u001e\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005J(\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0002R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorSwatchFloatingView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "resId", "", "<init>", "(Landroid/content/Context;I)V", "mColor", "updateColor", "", "color", "updateView", "rect", "Landroid/graphics/Rect;", "startMargin", "topMargin", "setPosition", "width", "height", "x", "", "y", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenColorSwatchFloatingView extends View {
    private static final float RATIO = 1.16f;

    @NotNull
    private static final String TAG = "ColorSwatchSelectorView";
    private int mColor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenColorSwatchFloatingView(@NotNull Context context, int i) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        if (i != 0) {
            setBackground(context.getDrawable(i));
        }
    }

    private final void setPosition(int width, int height, float x, float y2) {
        if (getVisibility() != 0) {
            setVisibility(0);
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        if (layoutParams2.width != width || layoutParams2.height != height) {
            layoutParams2.width = width;
            layoutParams2.height = height;
            setLayoutParams(layoutParams2);
        }
        setX(x);
        setY(y2);
    }

    public final void updateColor(int color) {
        Drawable background = getBackground();
        GradientDrawable gradientDrawable = background instanceof GradientDrawable ? (GradientDrawable) background : null;
        if (gradientDrawable == null) {
            setBackgroundColor(color);
        } else {
            if (this.mColor == color) {
                return;
            }
            this.mColor = color;
            gradientDrawable.setColor(color);
        }
    }

    public final void updateView(@NotNull Rect rect, int startMargin, int topMargin) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        setPosition((int) (rect.width() * 1.16f), (int) (rect.height() * 1.16f), (rect.centerX() - (r0 / 2)) + startMargin, (rect.centerY() - (r1 / 2)) + topMargin);
    }
}
