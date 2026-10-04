package com.samsung.android.support.senl.p148nt.base.winset.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.util.SeslRoundedCorner;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\r\u001a\u00020\u000eH\u0014J\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000bJ\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0015R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/view/RoundCornerOverlayView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mRoundedCorner", "Landroidx/appcompat/util/SeslRoundedCorner;", "mOverlayColor", "", "mCorner", "onAttachedToWindow", "", "setRoundedCorner", "corner", "onDraw", "canvas", "Landroid/graphics/Canvas;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class RoundCornerOverlayView extends View {
    private int mCorner;
    private int mOverlayColor;

    @Nullable
    private SeslRoundedCorner mRoundedCorner;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoundCornerOverlayView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C8875R.styleable.RoundCornerOverlayAttribute, 0, 0);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        try {
            this.mCorner = typedArrayObtainStyledAttributes.getInteger(C8875R.styleable.RoundCornerOverlayAttribute_corner, 0);
            this.mOverlayColor = typedArrayObtainStyledAttributes.getColor(C8875R.styleable.RoundCornerOverlayAttribute_overlayColor, getResources().getColor(C8875R.color.round_corner_color, null));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        if (this.mRoundedCorner == null) {
            setRoundedCorner(this.mCorner);
        }
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onDraw(@NotNull Canvas canvas) {
        SeslRoundedCorner seslRoundedCorner;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        if (!canvas.isHardwareAccelerated()) {
            Rect rect = getClipBounds() == null ? new Rect() : getClipBounds();
            canvas.getClipBounds(rect);
            Object parent = getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
            View view = (View) parent;
            SeslRoundedCorner seslRoundedCorner2 = this.mRoundedCorner;
            if (seslRoundedCorner2 != null && seslRoundedCorner2.getRoundedCorners() == 15 && (rect.width() != view.getWidth() || rect.height() != view.getHeight())) {
                return;
            }
        }
        SeslRoundedCorner seslRoundedCorner3 = this.mRoundedCorner;
        if (seslRoundedCorner3 != null) {
            if ((seslRoundedCorner3 == null || seslRoundedCorner3.getRoundedCorners() != 0) && (seslRoundedCorner = this.mRoundedCorner) != null) {
                seslRoundedCorner.drawRoundedCorner(canvas);
            }
        }
    }

    public final void setRoundedCorner(int corner) {
        SeslRoundedCorner seslRoundedCorner;
        if (this.mRoundedCorner == null) {
            this.mRoundedCorner = new SeslRoundedCorner(getContext());
        }
        SeslRoundedCorner seslRoundedCorner2 = this.mRoundedCorner;
        if (seslRoundedCorner2 == null || seslRoundedCorner2.getRoundedCorners() != corner) {
            SeslRoundedCorner seslRoundedCorner3 = this.mRoundedCorner;
            if (seslRoundedCorner3 != null) {
                seslRoundedCorner3.setRoundedCorners(corner);
            }
            if (corner != 0 && (seslRoundedCorner = this.mRoundedCorner) != null) {
                seslRoundedCorner.setRoundedCornerColor(corner, this.mOverlayColor);
            }
            invalidate();
        }
    }
}
