package com.samsung.android.sdk.pen.setting.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ScrollView;
import com.samsung.android.sdk.pen.setting.util.SpenRoundClipHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nH\u0016J\u0010\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/widget/SpenScrollView;", "Landroid/widget/ScrollView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mRoundClipHelper", "Lcom/samsung/android/sdk/pen/setting/util/SpenRoundClipHelper;", "setRadii", "", "radii", "", "canScrollVertically", "", "direction", "onDraw", "canvas", "Landroid/graphics/Canvas;", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenScrollView extends ScrollView {

    @NotNull
    private static final String TAG = "SpenScrollView";

    @NotNull
    private final SpenRoundClipHelper mRoundClipHelper;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenScrollView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mRoundClipHelper = new SpenRoundClipHelper();
    }

    @Override // android.view.View
    public boolean canScrollVertically(int direction) {
        boolean zCanScrollVertically = super.canScrollVertically(direction);
        if (zCanScrollVertically || direction < 0) {
            return zCanScrollVertically;
        }
        int iComputeVerticalScrollOffset = computeVerticalScrollOffset();
        int iComputeVerticalScrollRange = computeVerticalScrollRange() - computeVerticalScrollExtent();
        return iComputeVerticalScrollRange != 0 && iComputeVerticalScrollOffset < iComputeVerticalScrollRange;
    }

    @Override // android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        this.mRoundClipHelper.applyRoundClip(canvas);
        super.onDraw(canvas);
    }

    public final void setRadii(@NotNull float[] radii) {
        Intrinsics.checkNotNullParameter(radii, "radii");
        this.mRoundClipHelper.setCornerRadii(radii);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenScrollView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mRoundClipHelper = new SpenRoundClipHelper();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenScrollView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mRoundClipHelper = new SpenRoundClipHelper();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenScrollView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mRoundClipHelper = new SpenRoundClipHelper();
    }
}
