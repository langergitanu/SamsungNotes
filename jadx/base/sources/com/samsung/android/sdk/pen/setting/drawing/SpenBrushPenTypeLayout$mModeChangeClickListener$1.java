package com.samsung.android.sdk.pen.setting.drawing;

import android.os.Handler;
import android.view.View;
import com.samsung.android.sdk.pen.setting.drawing.SpenBrushPenTypeLayout;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p122b2.RunnableC4199v;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, m13886d2 = {"com/samsung/android/sdk/pen/setting/drawing/SpenBrushPenTypeLayout$mModeChangeClickListener$1", "Landroid/view/View$OnClickListener;", "onClick", "", VPathDataCmd.RCurveTo, "Landroid/view/View;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenBrushPenTypeLayout$mModeChangeClickListener$1 implements View.OnClickListener {
    final /* synthetic */ SpenBrushPenTypeLayout this$0;

    public SpenBrushPenTypeLayout$mModeChangeClickListener$1(SpenBrushPenTypeLayout spenBrushPenTypeLayout) {
        this.this$0 = spenBrushPenTypeLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onClick$lambda$1$lambda$0(SpenBrushPenTypeLayout.OnModeChangeListener onModeChangeListener, SpenBrushPenTypeLayout spenBrushPenTypeLayout) {
        onModeChangeListener.onModeChanged(spenBrushPenTypeLayout.mViewMode);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        boolean z = this.this$0.mViewMode == 1;
        this.this$0.toggleMode(true);
        SpenBrushPenTypeLayout.OnModeChangeListener onModeChangeListener = this.this$0.mModeChangeListener;
        if (onModeChangeListener != null) {
            SpenBrushPenTypeLayout spenBrushPenTypeLayout = this.this$0;
            if (z) {
                new Handler().postDelayed(new RunnableC4199v(onModeChangeListener, spenBrushPenTypeLayout, 11), 300L);
            } else {
                onModeChangeListener.onModeChanged(spenBrushPenTypeLayout.mViewMode);
            }
        }
    }
}
