package com.samsung.android.sdk.pen.setting.colorpalette;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.ViewFlipper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenViewFlipper;", "Landroid/widget/ViewFlipper;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "downX", "", "mTouchSlope", "", "onInterceptTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenViewFlipper extends ViewFlipper {

    @NotNull
    private static final String TAG = "SpenViewFlipper";
    private float downX;
    private final int mTouchSlope;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenViewFlipper(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mTouchSlope = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@NotNull MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (getChildCount() == 1) {
            return super.onInterceptTouchEvent(ev);
        }
        int action = ev.getAction() & 255;
        if (action == 0) {
            this.downX = ev.getX();
            getParent().requestDisallowInterceptTouchEvent(true);
        } else {
            if (action == 2) {
                return Math.abs((double) (this.downX - ev.getX())) >= ((double) this.mTouchSlope);
            }
            this.downX = 0.0f;
        }
        return super.onInterceptTouchEvent(ev);
    }
}
