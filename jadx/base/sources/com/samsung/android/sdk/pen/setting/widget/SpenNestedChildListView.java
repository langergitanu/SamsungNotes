package com.samsung.android.sdk.pen.setting.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.HorizontalScrollView;
import android.widget.ListView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000f\u001a\u00020\u0010H\u0014J\b\u0010\u0011\u001a\u00020\u0010H\u0014J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0015H\u0002J\b\u0010\u0018\u001a\u00020\u0010H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/widget/SpenNestedChildListView;", "Landroid/widget/ListView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mDownX", "", "mDownY", "mTouchSlop", "", "mParentScrollView", "Landroid/widget/HorizontalScrollView;", "onAttachedToWindow", "", "onDetachedFromWindow", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "setDisallowInterceptTouchEvent", "event", "findParentScrollView", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenNestedChildListView extends ListView {

    @NotNull
    private static final String TAG = "SpenNestedListView";
    private float mDownX;
    private float mDownY;

    @Nullable
    private HorizontalScrollView mParentScrollView;
    private final int mTouchSlop;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenNestedChildListView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop() / 2;
    }

    private final void findParentScrollView() {
        Log.i(TAG, "findParentScrollView()");
        ViewParent parent = this;
        while (parent != null && this.mParentScrollView == null) {
            parent = parent.getParent();
            if (parent != null && (parent instanceof HorizontalScrollView)) {
                this.mParentScrollView = (HorizontalScrollView) parent;
            }
        }
    }

    private final void setDisallowInterceptTouchEvent(MotionEvent event) {
        HorizontalScrollView horizontalScrollView = this.mParentScrollView;
        if (horizontalScrollView != null) {
            boolean zCanScrollHorizontally = horizontalScrollView.canScrollHorizontally(1);
            boolean zCanScrollHorizontally2 = horizontalScrollView.canScrollHorizontally(-1);
            if (!zCanScrollHorizontally && !zCanScrollHorizontally2) {
                horizontalScrollView.requestDisallowInterceptTouchEvent(true);
                return;
            }
            int action = event.getAction();
            if (action == 0) {
                horizontalScrollView.requestDisallowInterceptTouchEvent(false);
                this.mDownX = event.getX();
                this.mDownY = event.getY();
                return;
            }
            if (action == 1) {
                horizontalScrollView.requestDisallowInterceptTouchEvent(false);
                return;
            }
            if (action != 2) {
                return;
            }
            float fAbs = Math.abs(event.getX() - this.mDownX);
            float fAbs2 = Math.abs(event.getY() - this.mDownY);
            int i = this.mTouchSlop;
            boolean z = fAbs > ((float) i);
            boolean z2 = fAbs2 > ((float) i);
            if (!z || (z2 && fAbs <= fAbs2)) {
                horizontalScrollView.requestDisallowInterceptTouchEvent(true);
            } else {
                horizontalScrollView.requestDisallowInterceptTouchEvent(false);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@NotNull MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        setDisallowInterceptTouchEvent(ev);
        return super.dispatchTouchEvent(ev);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        findParentScrollView();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mParentScrollView = null;
    }
}
