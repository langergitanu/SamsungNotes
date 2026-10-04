package com.samsung.android.sdk.pen.setting;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.setting.SpenBrushLayout;
import com.samsung.android.sdk.pen.setting.SpenBrushMoveControl;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016¨\u0006\f"}, m13886d2 = {"com/samsung/android/sdk/pen/setting/SpenBrushLayout$setChildView$1$1", "Lcom/samsung/android/sdk/pen/setting/SpenBrushMoveControl$ActionListener;", "onPenPositionChanged", "", "align", "", "needUpdateColor", "", "onColorPositionChanged", "needUpdatePen", "onPenLongClicked", "onColorLongClicked", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenBrushLayout$setChildView$1$1 implements SpenBrushMoveControl.ActionListener {
    final /* synthetic */ SpenBrushLayout this$0;

    public SpenBrushLayout$setChildView$1$1(SpenBrushLayout spenBrushLayout) {
        this.this$0 = spenBrushLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onColorPositionChanged$lambda$2(SpenBrushLayout spenBrushLayout) {
        Log.i("SpenBrushLayout", "run() in onColorPositionChanged()");
        if (spenBrushLayout.mPenView == null || spenBrushLayout.mChildSizeChangedListener == null) {
            return;
        }
        View view = spenBrushLayout.mPenView;
        if (view != null) {
            view.requestLayout();
        }
        Rect rect = new Rect();
        spenBrushLayout.getPenRect(rect);
        SpenBrushLayout.ChildSizeChangedListener childSizeChangedListener = spenBrushLayout.mChildSizeChangedListener;
        if (childSizeChangedListener != null) {
            childSizeChangedListener.OnPenViewSizeChanged(rect);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onPenPositionChanged$lambda$0(SpenBrushLayout spenBrushLayout) {
        Log.i("SpenBrushLayout", "run() in onPenPositionChanged()");
        if (spenBrushLayout.mColorView == null || spenBrushLayout.mChildSizeChangedListener == null) {
            return;
        }
        View view = spenBrushLayout.mColorView;
        if (view != null) {
            view.requestLayout();
        }
        Rect rect = new Rect();
        spenBrushLayout.getColorRect(rect);
        SpenBrushLayout.ChildSizeChangedListener childSizeChangedListener = spenBrushLayout.mChildSizeChangedListener;
        if (childSizeChangedListener != null) {
            childSizeChangedListener.OnColorViewSizeChanged(rect);
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenBrushMoveObject.ActionListener
    public void onColorLongClicked() {
        Log.i("SpenBrushLayout", "onColorLongClicked()");
        this.this$0.stopChildMonitoring(false);
        SpenChildActionListener spenChildActionListener = this.this$0.mChildActionListener;
        if (spenChildActionListener != null) {
            spenChildActionListener.onColorLongClicked();
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenBrushMoveObject.ActionListener
    public void onColorPositionChanged(int align, boolean needUpdatePen) {
        AbstractC6670b.m4744e(align, this.this$0.getColorAlign(), "onColorPositionChanged() align=", " current=", "SpenBrushLayout");
        boolean z = align != this.this$0.getColorAlign();
        SpenBrushLayout spenBrushLayout = this.this$0;
        spenBrushLayout.setColorAlign(align, spenBrushLayout.mLayoutDirection, false);
        if (!z || this.this$0.mChildAlignChangedListener == null) {
            return;
        }
        AbstractC2322a.m1631u(align, "onColorAlignChanged() align=", "SpenBrushLayout");
        SpenBrushLayout.ChildAlignChangedListener childAlignChangedListener = this.this$0.mChildAlignChangedListener;
        if (childAlignChangedListener != null) {
            childAlignChangedListener.onColorAlignChanged(align);
        }
        SpenBrushLayout.ChildSizeChangedListener childSizeChangedListener = this.this$0.mChildSizeChangedListener;
        if (childSizeChangedListener != null) {
            SpenBrushLayout spenBrushLayout2 = this.this$0;
            Rect rect = new Rect();
            spenBrushLayout2.getColorRect(rect);
            childSizeChangedListener.OnColorViewSizeChanged(rect);
        }
        Log.i("SpenBrushLayout", "needUpdatePen");
        new Handler(Looper.getMainLooper()).post(new RunnableC7520a(this.this$0, 1));
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenBrushMoveObject.ActionListener
    public void onPenLongClicked() {
        Log.i("SpenBrushLayout", "onPenLongClicked()");
        this.this$0.stopChildMonitoring(false);
        SpenChildActionListener spenChildActionListener = this.this$0.mChildActionListener;
        if (spenChildActionListener != null) {
            spenChildActionListener.onPenLongClicked();
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenBrushMoveObject.ActionListener
    public void onPenPositionChanged(int align, boolean needUpdateColor) {
        boolean z = align != this.this$0.getPenAlign();
        AbstractC6670b.m4744e(align, this.this$0.getPenAlign(), "onPenPositionChanged() align=", " current=", "SpenBrushLayout");
        SpenBrushLayout spenBrushLayout = this.this$0;
        spenBrushLayout.setPenAlign(align, spenBrushLayout.mLayoutDirection, false);
        if (!z || this.this$0.mChildAlignChangedListener == null) {
            return;
        }
        AbstractC2322a.m1631u(align, "onPenAlignChanged() align=", "SpenBrushLayout");
        SpenBrushLayout.ChildAlignChangedListener childAlignChangedListener = this.this$0.mChildAlignChangedListener;
        if (childAlignChangedListener != null) {
            childAlignChangedListener.onPenAlignChanged(align);
        }
        if (this.this$0.mChildSizeChangedListener != null) {
            Rect rect = new Rect();
            this.this$0.getPenRect(rect);
            SpenBrushLayout.ChildSizeChangedListener childSizeChangedListener = this.this$0.mChildSizeChangedListener;
            if (childSizeChangedListener != null) {
                childSizeChangedListener.OnPenViewSizeChanged(rect);
            }
        }
        Log.i("SpenBrushLayout", "needUpdateColor!");
        new Handler(Looper.getMainLooper()).post(new RunnableC7520a(this.this$0, 2));
    }
}
