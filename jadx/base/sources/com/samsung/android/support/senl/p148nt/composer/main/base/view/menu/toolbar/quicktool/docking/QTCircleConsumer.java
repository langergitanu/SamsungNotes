package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking;

import android.annotation.SuppressLint;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import com.google.android.material.oneui.floatingdock.ViewOnTouchListenerC4799j;
import com.samsung.android.sdk.pen.setting.quicktool.ViewOnHoverListenerC7652d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000  2\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000e\u001a\u00020\u000fJ\u001e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000bJ\u0010\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\rJ\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\tH\u0002J\b\u0010\u001e\u001a\u00020\u000fH\u0002J\u0018\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\tH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u00020\u00178\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTCircleConsumer;", "", "<init>", "()V", "mTargetView", "Landroid/view/View;", "mCenter", "Landroid/graphics/PointF;", "mRadius", "", "mStroke", "", "mParent", "Landroid/view/ViewParent;", "close", "", "setView", "view", "radius", "stroke", "setViewParent", "parent", "mOnConsumedTouchListener", "Landroid/view/View$OnTouchListener;", "mOnConsumedHoverListener", "Landroid/view/View$OnHoverListener;", "isConsumed", "", "x", "y", "initCenter", "isInnerTouch", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class QTCircleConsumer {

    @NotNull
    private static final String TAG = "QTCircleConsumer";

    @Nullable
    private ViewParent mParent;
    private float mRadius;
    private int mStroke;

    @Nullable
    private View mTargetView;

    @NotNull
    private PointF mCenter = new PointF();

    @SuppressLint({"ClickableViewAccessibility"})
    @NotNull
    private final View.OnTouchListener mOnConsumedTouchListener = new ViewOnTouchListenerC4799j(this, 21);

    @NotNull
    private final View.OnHoverListener mOnConsumedHoverListener = new ViewOnHoverListenerC7652d(this, 1);

    private final void initCenter() {
        if (this.mTargetView != null) {
            this.mCenter.x = r0.getWidth() / 2.0f;
            this.mCenter.y = r0.getHeight() / 2.0f;
        }
    }

    private final boolean isConsumed(float x, float y2) {
        if (this.mTargetView == null) {
            return false;
        }
        PointF pointF = this.mCenter;
        if (((int) pointF.x) == 0 && ((int) pointF.y) == 0) {
            initCenter();
        }
        return isInnerTouch(x, y2);
    }

    private final boolean isInnerTouch(float x, float y2) {
        return Math.sqrt(Math.pow((double) (y2 - this.mCenter.y), 2.0d) + Math.pow((double) (x - this.mCenter.x), 2.0d)) <= ((double) (this.mRadius + ((float) (this.mStroke / 2))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean mOnConsumedHoverListener$lambda$1(QTCircleConsumer qTCircleConsumer, View view, MotionEvent motionEvent) {
        return qTCircleConsumer.isConsumed(motionEvent.getX(), motionEvent.getY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean mOnConsumedTouchListener$lambda$0(QTCircleConsumer qTCircleConsumer, View view, MotionEvent motionEvent) {
        ViewParent viewParent;
        boolean zIsConsumed = qTCircleConsumer.isConsumed(motionEvent.getX(), motionEvent.getY());
        if (zIsConsumed && (viewParent = qTCircleConsumer.mParent) != null) {
            viewParent.requestDisallowInterceptTouchEvent(true);
        }
        return zIsConsumed;
    }

    public final void close() {
        View view = this.mTargetView;
        if (view != null) {
            view.setOnHoverListener(null);
        }
        View view2 = this.mTargetView;
        if (view2 != null) {
            view2.setOnTouchListener(null);
        }
        this.mTargetView = null;
    }

    public final void setView(@NotNull View view, float radius, int stroke) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.mTargetView = view;
        this.mRadius = radius;
        this.mStroke = stroke;
        this.mCenter.set(0.0f, 0.0f);
        View view2 = this.mTargetView;
        if (view2 != null) {
            view2.setOnHoverListener(this.mOnConsumedHoverListener);
        }
        View view3 = this.mTargetView;
        if (view3 != null) {
            view3.setOnTouchListener(this.mOnConsumedTouchListener);
        }
    }

    public final void setViewParent(@Nullable ViewParent parent) {
        this.mParent = parent;
    }
}
