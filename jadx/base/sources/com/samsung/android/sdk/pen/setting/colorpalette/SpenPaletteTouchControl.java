package com.samsung.android.sdk.pen.setting.colorpalette;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0006\u0010\u0015\u001a\u00020\u0014J\u0010\u0010\u0016\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\fJ\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteTouchControl;", "Landroid/view/View$OnTouchListener;", "Landroid/view/View$OnClickListener;", "mPalette", "Landroid/view/ViewGroup;", "mTouchSlope", "", "<init>", "(Landroid/view/ViewGroup;F)V", "mDownX", "mDownY", "mActionListener", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteActionListener;", "onTouch", "", VPathDataCmd.RCurveTo, "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "onClick", "", "close", "setPaletteActionListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "getChildIndex", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenPaletteTouchControl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenPaletteTouchControl.kt\ncom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteTouchControl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,71:1\n1#2:72\n*E\n"})
public final class SpenPaletteTouchControl implements View.OnTouchListener, View.OnClickListener {

    @Nullable
    private SpenPaletteActionListener mActionListener;
    private float mDownX;
    private float mDownY;

    @Nullable
    private ViewGroup mPalette;
    private final float mTouchSlope;

    public SpenPaletteTouchControl(@Nullable ViewGroup viewGroup, float f) {
        this.mPalette = viewGroup;
        this.mTouchSlope = f;
    }

    private final int getChildIndex(View v) {
        ViewGroup viewGroup = this.mPalette;
        if (viewGroup == null) {
            return -1;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (viewGroup.getChildAt(i) == v) {
                return i;
            }
        }
        return -1;
    }

    public final void close() {
        this.mPalette = null;
        this.mActionListener = null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v) {
        int childIndex;
        ViewGroup viewGroup;
        SpenPaletteActionListener spenPaletteActionListener;
        Intrinsics.checkNotNullParameter(v, "v");
        if (v.getTag() != null) {
            Object tag = v.getTag();
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type kotlin.String");
            childIndex = Integer.parseInt((String) tag);
        } else {
            childIndex = getChildIndex(v);
        }
        if (childIndex == -1 || (viewGroup = this.mPalette) == null || (spenPaletteActionListener = this.mActionListener) == null) {
            return;
        }
        spenPaletteActionListener.onButtonClick(viewGroup, v, childIndex);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(@NotNull View v, @NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(event, "event");
        ViewGroup viewGroup = this.mPalette;
        if (viewGroup != null && (viewGroup.getParent() instanceof SpenViewFlipper)) {
            if (event.getAction() == 2) {
                if (event.getX() > 0.0f && event.getX() < v.getWidth() && event.getY() > 0.0f && event.getY() < v.getHeight()) {
                    double x = this.mDownX - event.getX();
                    double y2 = this.mDownY - event.getY();
                    if (Math.abs(x) < Math.abs(y2) && Math.abs(y2) > this.mTouchSlope) {
                        viewGroup.getParent().getParent().requestDisallowInterceptTouchEvent(false);
                    } else if (Math.abs(x) > Math.abs(y2) && Math.abs(x) > this.mTouchSlope) {
                        viewGroup.getParent().requestDisallowInterceptTouchEvent(false);
                    }
                }
            } else if (event.getAction() == 0) {
                this.mDownX = event.getX();
                this.mDownY = event.getY();
            }
        }
        return false;
    }

    public final void setPaletteActionListener(@Nullable SpenPaletteActionListener listener) {
        this.mActionListener = listener;
    }
}
