package com.samsung.android.sdk.pen.setting.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.samsung.android.sdk.pen.setting.util.SpenRoundClipHelper;
import com.samsung.android.spen.C7932R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b\u0005\b\u0016\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0014J\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011J&\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0011J\u001a\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00178DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/common/SpenRoundLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mRoundClipHelper", "Lcom/samsung/android/sdk/pen/setting/util/SpenRoundClipHelper;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "setRadius", "radius", "", "topLeftRadius", "topRightRadius", "bottomRightRadius", "bottomLeftRadius", "cornerRadii", "", "getCornerRadii", "()[F", "getAttributes", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public class SpenRoundLayout extends FrameLayout {

    @NotNull
    private static final String TAG = "SpenRoundLayout";

    @NotNull
    private final SpenRoundClipHelper mRoundClipHelper;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenRoundLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mRoundClipHelper = new SpenRoundClipHelper();
    }

    private final void getAttributes(Context context, AttributeSet attrs) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attrs, C7932R.styleable.SpenRoundLayout, 0, 0);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        try {
            float dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(C7932R.styleable.SpenRoundLayout_radius, -1);
            if (dimensionPixelOffset > -1.0f) {
                setRadius(dimensionPixelOffset);
            } else {
                int dimensionPixelOffset2 = typedArrayObtainStyledAttributes.getDimensionPixelOffset(C7932R.styleable.SpenRoundLayout_topStartRadius, 0);
                int dimensionPixelOffset3 = typedArrayObtainStyledAttributes.getDimensionPixelOffset(C7932R.styleable.SpenRoundLayout_topEndRadius, 0);
                int dimensionPixelOffset4 = typedArrayObtainStyledAttributes.getDimensionPixelOffset(C7932R.styleable.SpenRoundLayout_bottomStartRadius, 0);
                int dimensionPixelOffset5 = typedArrayObtainStyledAttributes.getDimensionPixelOffset(C7932R.styleable.SpenRoundLayout_bottomEndRadius, 0);
                if (context.getResources().getConfiguration().getLayoutDirection() == 1) {
                    dimensionPixelOffset3 = dimensionPixelOffset2;
                    dimensionPixelOffset2 = dimensionPixelOffset3;
                    dimensionPixelOffset4 = dimensionPixelOffset5;
                    dimensionPixelOffset5 = dimensionPixelOffset4;
                }
                setRadius(typedArrayObtainStyledAttributes.getDimensionPixelOffset(C7932R.styleable.SpenRoundLayout_topLeftRadius, dimensionPixelOffset2), typedArrayObtainStyledAttributes.getDimensionPixelOffset(C7932R.styleable.SpenRoundLayout_topRightRadius, dimensionPixelOffset3), typedArrayObtainStyledAttributes.getDimensionPixelOffset(C7932R.styleable.SpenRoundLayout_bottomRightRadius, dimensionPixelOffset5), typedArrayObtainStyledAttributes.getDimensionPixelOffset(C7932R.styleable.SpenRoundLayout_bottomLeftRadius, dimensionPixelOffset4));
            }
            typedArrayObtainStyledAttributes.recycle();
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    @NotNull
    public final float[] getCornerRadii() {
        return this.mRoundClipHelper.getMRadii();
    }

    @Override // android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        this.mRoundClipHelper.applyRoundClip(canvas);
        super.onDraw(canvas);
    }

    public final void setRadius(float radius) {
        this.mRoundClipHelper.setCorner(radius);
    }

    public final void setRadius(float topLeftRadius, float topRightRadius, float bottomRightRadius, float bottomLeftRadius) {
        this.mRoundClipHelper.setCorner(topLeftRadius, topRightRadius, bottomRightRadius, bottomLeftRadius);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenRoundLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mRoundClipHelper = new SpenRoundClipHelper();
        getAttributes(context, attributeSet);
    }
}
