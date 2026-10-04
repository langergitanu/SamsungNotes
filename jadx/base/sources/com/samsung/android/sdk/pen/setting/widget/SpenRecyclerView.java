package com.samsung.android.sdk.pen.setting.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.sdk.pen.setting.util.SpenRoundClipHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J&\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0011J\u000e\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0018J\u0010\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/widget/SpenRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mRoundClipHelper", "Lcom/samsung/android/sdk/pen/setting/util/SpenRoundClipHelper;", "setRadius", "", "radius", "", "topLeftRadii", "topRightRadii", "bottomRightRadii", "bottomLeftRadii", "setRecoilEnabled", "enabled", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenRecyclerView extends RecyclerView {

    @NotNull
    private final SpenRoundClipHelper mRoundClipHelper;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenRecyclerView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mRoundClipHelper = new SpenRoundClipHelper();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        this.mRoundClipHelper.applyRoundClip(canvas);
        super.onDraw(canvas);
    }

    public final void setRadius(float radius) {
        this.mRoundClipHelper.setCorner(radius);
    }

    public final void setRecoilEnabled(boolean enabled) {
        try {
            SpenRecyclerView.class.getMethod("seslSetRecoilEnabled", Boolean.TYPE).invoke(this, Boolean.valueOf(enabled));
        } catch (Exception e) {
            Log.e("SpenRecyclerView", "seslSetRecoilEnabled exception: " + e);
        }
    }

    public final void setRadius(float topLeftRadii, float topRightRadii, float bottomRightRadii, float bottomLeftRadii) {
        this.mRoundClipHelper.setCorner(topLeftRadii, topRightRadii, bottomRightRadii, bottomLeftRadii);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenRecyclerView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mRoundClipHelper = new SpenRoundClipHelper();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenRecyclerView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mRoundClipHelper = new SpenRoundClipHelper();
    }
}
