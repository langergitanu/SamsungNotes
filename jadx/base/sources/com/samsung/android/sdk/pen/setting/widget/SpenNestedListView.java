package com.samsung.android.sdk.pen.setting.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.glance.AbstractC2821a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0014J\b\u0010\u000e\u001a\u00020\rH\u0014J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\rH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/widget/SpenNestedListView;", "Landroid/widget/ListView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mDownY", "", "mParentScrollView", "Landroid/widget/ScrollView;", "onAttachedToWindow", "", "onDetachedFromWindow", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "findParentScrollView", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenNestedListView extends ListView {

    @NotNull
    private static final String TAG = "SpenNestedListView";
    private float mDownY;

    @Nullable
    private ScrollView mParentScrollView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenNestedListView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void findParentScrollView() {
        Log.i(TAG, "findParentScrollView()");
        ViewParent parent = this;
        while (parent != null && this.mParentScrollView == null) {
            parent = parent.getParent();
            if (parent == null) {
                Log.i(TAG, "There is no more ViewParent.");
            } else if (parent instanceof ScrollView) {
                this.mParentScrollView = (ScrollView) parent;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@NotNull MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        Log.i(TAG, "dispatchTouchEvent()");
        ScrollView scrollView = this.mParentScrollView;
        if (scrollView != null) {
            boolean zCanScrollVertically = scrollView.canScrollVertically(1);
            boolean zCanScrollVertically2 = scrollView.canScrollVertically(-1);
            if (zCanScrollVertically || zCanScrollVertically2) {
                boolean zCanScrollList = canScrollList(1);
                boolean zCanScrollList2 = canScrollList(-1);
                int action = ev.getAction();
                if (action == 0) {
                    Log.i(TAG, "[MotionEvent.ACTION_DOWN] - parentScrollView disallow=false");
                    scrollView.requestDisallowInterceptTouchEvent(false);
                    this.mDownY = ev.getY();
                } else if (action == 1) {
                    scrollView.requestDisallowInterceptTouchEvent(false);
                    Log.i(TAG, "[MotionEvent.ACTION_UP] - parentScrollView disallow=false");
                } else if (action == 2) {
                    float y2 = ev.getY() - this.mDownY;
                    AbstractC2821a.m2206A(AbstractC2821a.m2230u(" canScrolList(-1)=", " canScrollList(1)=", " dy=", canScrollList(-1), canScrollList(1)), TAG, y2);
                    if (y2 < 0.0f && zCanScrollVertically && !zCanScrollList) {
                        Log.i(TAG, "[MotionEvent.ACTION_MOVE] - 1. parentScrollView : disallow=false, parent is possible scroll down");
                        scrollView.requestDisallowInterceptTouchEvent(false);
                    } else if (y2 > 0.0f && !zCanScrollList2 && zCanScrollVertically2) {
                        Log.i(TAG, "[MotionEvent.ACTION_MOVE] - 2. parentScrollView : disallow=false, parent is possible scroll up");
                        scrollView.requestDisallowInterceptTouchEvent(false);
                    } else if (zCanScrollList2 || zCanScrollList) {
                        scrollView.requestDisallowInterceptTouchEvent(true);
                        Log.i(TAG, "[MotionEvent.ACTION_MOVE] - 0. parentScrollView : disallow=true, child is possible scroll down/up ");
                    }
                }
            } else {
                scrollView.requestDisallowInterceptTouchEvent(true);
                Log.i(TAG, "mParentScrollView has no scroll");
            }
        }
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
