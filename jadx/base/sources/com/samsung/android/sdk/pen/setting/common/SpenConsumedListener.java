package com.samsung.android.sdk.pen.setting.common;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import com.google.android.material.oneui.floatingdock.ViewOnTouchListenerC4799j;
import com.samsung.android.sdk.pen.recoguifeature.converttotext.floating.ViewOnHoverListenerC7469a;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\r8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/common/SpenConsumedListener;", "", "<init>", "()V", "mParent", "Landroid/view/ViewParent;", "close", "", "setConsumedListener", "parent", "child", "Landroid/view/View;", "mOnConsumedTouchListener", "Landroid/view/View$OnTouchListener;", "mOnConsumedHoverListener", "Landroid/view/View$OnHoverListener;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenConsumedListener {

    @Nullable
    private ViewParent mParent;

    @SuppressLint({"ClickableViewAccessibility"})
    @NotNull
    private final View.OnTouchListener mOnConsumedTouchListener = new ViewOnTouchListenerC4799j(this, 8);

    @NotNull
    private final View.OnHoverListener mOnConsumedHoverListener = new ViewOnHoverListenerC7469a(4);

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean mOnConsumedHoverListener$lambda$1(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean mOnConsumedTouchListener$lambda$0(SpenConsumedListener spenConsumedListener, View view, MotionEvent motionEvent) {
        ViewParent viewParent = spenConsumedListener.mParent;
        if (viewParent != null) {
            viewParent.requestDisallowInterceptTouchEvent(true);
        }
        return true;
    }

    public final void close() {
        this.mParent = null;
    }

    public final void setConsumedListener(@Nullable ViewParent parent, @Nullable View child) {
        this.mParent = parent;
        if (child != null) {
            child.setOnTouchListener(this.mOnConsumedTouchListener);
            child.setOnHoverListener(this.mOnConsumedHoverListener);
        }
    }
}
