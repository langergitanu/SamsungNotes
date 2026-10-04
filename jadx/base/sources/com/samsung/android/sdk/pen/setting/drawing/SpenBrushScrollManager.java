package com.samsung.android.sdk.pen.setting.drawing;

import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sdk.pen.setting.widget.SpenHorizontalScrollView;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\n\u001a\u00020\u000bJ\u001a\u0010\u000f\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\u0018\u0010\u0013\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\rJ\u000e\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\rJ2\u0010\u001c\u001a\u00020\r2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\rH\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\f\u0010\u000e¨\u0006#"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/drawing/SpenBrushScrollManager;", "", "mContext", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", SearchConstants.TargetContents.TAG, "", "mScrollLayout", "Lcom/samsung/android/sdk/pen/setting/widget/SpenHorizontalScrollView;", "close", "", "isSupportScroll", "", "()Z", "setLayout", "totalLayout", "Landroid/widget/FrameLayout;", "scrollChildLayout", "setVisibleChild", "childView", "Landroid/view/View;", "isSmoothScroll", "smoothScrollTo", "xPos", "", "setScrollBar", "enable", "needScroll", "child", "fromX", "toX", "rect", "Landroid/graphics/Rect;", "isMovedInPartiallyVisible", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenBrushScrollManager {

    @NotNull
    private final String TAG = "SpenBrushScrollManager";

    @Nullable
    private Context mContext;

    @Nullable
    private SpenHorizontalScrollView mScrollLayout;

    public SpenBrushScrollManager(@Nullable Context context) {
        this.mContext = context;
    }

    private final boolean needScroll(View child, int fromX, int toX, Rect rect, boolean isMovedInPartiallyVisible) {
        int i;
        if (child == null) {
            return false;
        }
        int i2 = rect.left;
        if (fromX <= i2 && rect.right <= toX) {
            return false;
        }
        if ((i2 >= fromX || fromX >= (i = rect.right) || i > toX) && (fromX >= i2 || i2 >= toX || rect.right <= toX)) {
            return true;
        }
        return isMovedInPartiallyVisible;
    }

    public final void close() {
        this.mContext = null;
        this.mScrollLayout = null;
    }

    public final boolean isSupportScroll() {
        return this.mScrollLayout != null;
    }

    public final void setLayout(@Nullable FrameLayout totalLayout, @Nullable FrameLayout scrollChildLayout) {
        Context context = this.mContext;
        if (context == null || totalLayout == null || scrollChildLayout == null) {
            return;
        }
        Object systemService = context != null ? context.getSystemService("layout_inflater") : null;
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        View viewInflate = ((LayoutInflater) systemService).inflate(C7932R.layout.setting_horizontal_scroll_layout, (ViewGroup) totalLayout, false);
        Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type com.samsung.android.sdk.pen.setting.widget.SpenHorizontalScrollView");
        SpenHorizontalScrollView spenHorizontalScrollView = (SpenHorizontalScrollView) viewInflate;
        spenHorizontalScrollView.setFillViewport(true);
        setScrollBar(true);
        totalLayout.addView(spenHorizontalScrollView, new FrameLayout.LayoutParams(-1, -1));
        spenHorizontalScrollView.addView(scrollChildLayout, new FrameLayout.LayoutParams(-2, -1));
        this.mScrollLayout = spenHorizontalScrollView;
    }

    public final void setScrollBar(boolean enable) {
        SpenHorizontalScrollView spenHorizontalScrollView = this.mScrollLayout;
        if (spenHorizontalScrollView != null) {
            spenHorizontalScrollView.setScrollbarFadingEnabled(enable);
        }
        SpenHorizontalScrollView spenHorizontalScrollView2 = this.mScrollLayout;
        if (spenHorizontalScrollView2 != null) {
            spenHorizontalScrollView2.setHorizontalScrollBarEnabled(enable);
        }
    }

    public final boolean setVisibleChild(@Nullable View childView, boolean isSmoothScroll) {
        if (childView == null) {
            return false;
        }
        Rect rect = new Rect();
        rect.set(childView.getLeft(), childView.getTop(), childView.getWidth() + childView.getLeft(), childView.getHeight() + childView.getTop());
        SpenHorizontalScrollView spenHorizontalScrollView = this.mScrollLayout;
        if (spenHorizontalScrollView == null) {
            return true;
        }
        int scrollX = spenHorizontalScrollView.getScrollX();
        if (!needScroll(childView, scrollX, ((spenHorizontalScrollView.getWidth() + scrollX) - spenHorizontalScrollView.getPaddingLeft()) - spenHorizontalScrollView.getPaddingEnd(), rect, true)) {
            return true;
        }
        Log.i(this.TAG, "setVisibleChild: scroll");
        int left = (childView.getLeft() + (childView.getWidth() / 2)) - (spenHorizontalScrollView.getWidth() / 2);
        if (isSmoothScroll) {
            spenHorizontalScrollView.smoothScrollTo(left, 0);
            return true;
        }
        spenHorizontalScrollView.scrollTo(left, 0);
        return true;
    }

    public final void smoothScrollTo(int xPos) {
        AbstractC2322a.m1631u(xPos, "smoothScrollTo() xPos=", this.TAG);
        SpenHorizontalScrollView spenHorizontalScrollView = this.mScrollLayout;
        if (spenHorizontalScrollView != null) {
            spenHorizontalScrollView.smoothScrollTo(xPos, 0);
        }
    }
}
