package com.samsung.android.support.senl.p148nt.base.winset.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.ViewFlipper;
import com.samsung.android.spen.C7932R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u001cB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0011H\u0002J\b\u0010\u0019\u001a\u00020\u0011H\u0002J\u0010\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u0015H\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/view/SwipeViewFlipper;", "Landroid/widget/ViewFlipper;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mActionListener", "Lcom/samsung/android/support/senl/nt/base/winset/view/SwipeViewFlipper$ViewFlipperActionListener;", "mDownX", "", "mDownY", "mTouchSlope", "", "init", "", "setActionListener", "actionListener", "dispatchTouchEvent", "", "event", "Landroid/view/MotionEvent;", "onRightSwipe", "onLeftSwipe", "changeFlip", "isNext", "ViewFlipperActionListener", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SwipeViewFlipper extends ViewFlipper {

    @Nullable
    private ViewFlipperActionListener mActionListener;
    private float mDownX;
    private float mDownY;
    private int mTouchSlope;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/view/SwipeViewFlipper$ViewFlipperActionListener;", "", "onFlipped", "", "showRightPage", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface ViewFlipperActionListener {
        void onFlipped(boolean showRightPage);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwipeViewFlipper(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        init(context);
    }

    private final void changeFlip(boolean isNext) {
        if (getContext().getResources().getConfiguration().getLayoutDirection() != 0) {
            isNext = !isNext;
        }
        if (isNext) {
            showNext();
        } else {
            showPrevious();
        }
        ViewFlipperActionListener viewFlipperActionListener = this.mActionListener;
        if (viewFlipperActionListener == null || viewFlipperActionListener == null) {
            return;
        }
        viewFlipperActionListener.onFlipped(isNext);
    }

    private final void init(Context context) {
        this.mTouchSlope = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    private final void onLeftSwipe() {
        setInAnimation(getContext(), C7932R.anim.brush_color_slide_in_left_to_right);
        setOutAnimation(getContext(), C7932R.anim.brush_color_slide_out_left_to_right);
        changeFlip(false);
    }

    private final void onRightSwipe() {
        setInAnimation(getContext(), C7932R.anim.brush_color_slide_in_right_to_left);
        setOutAnimation(getContext(), C7932R.anim.brush_color_slide_out_right_to_left);
        changeFlip(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        getParent().requestDisallowInterceptTouchEvent(true);
        int action = event.getAction();
        if (action == 0) {
            this.mDownX = event.getX();
            this.mDownY = event.getY();
        } else if (action == 1) {
            float x = this.mDownX - event.getX();
            double d = x;
            if (Math.abs(d) > Math.abs(this.mDownY - event.getY())) {
                if (Math.abs(d) <= this.mTouchSlope) {
                    return super.dispatchTouchEvent(event);
                }
                if (x > 0.0f) {
                    onRightSwipe();
                    return true;
                }
                if (x < 0.0f) {
                    onLeftSwipe();
                    return true;
                }
            }
        }
        return super.dispatchTouchEvent(event);
    }

    public final void setActionListener(@Nullable ViewFlipperActionListener actionListener) {
        this.mActionListener = actionListener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwipeViewFlipper(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        init(context);
    }
}
