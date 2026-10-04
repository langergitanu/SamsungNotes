package com.samsung.android.sdk.pen.setting;

import android.content.Context;
import android.view.View;
import androidx.annotation.IntRange;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.samsung.android.sdk.bixby2.action.ActionHandler;
import com.samsung.android.spen.C7932R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0003H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u0003H\u0016J\u001a\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00032\b\b\u0001\u0010\u0014\u001a\u00020\u0003H\u0016J\u001a\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00032\b\b\u0001\u0010\u0014\u001a\u00020\u0003H\u0016J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0014\u001a\u00020\u0003H\u0016R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001f"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenBrushGuideMarginConfig;", "Lcom/samsung/android/sdk/pen/setting/SpenBrushGuideConfig;", "style", "", "marginRatio", "", "<init>", "(IF)V", "mPercentTopMargin", "mPercentBottomMargin", "mPercentStartMargin", "mPercentEndMargin", "viewIds", "", "getViewIds", "()[I", "makeView", "Landroid/view/View;", "context", "Landroid/content/Context;", "alignment", "setGuideRelation", "", ActionHandler.PARAMS, "Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;", "getPercentWidth", "orientation", "getPercentHeight", "getDimensionRatio", "", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenBrushGuideMarginConfig extends SpenBrushGuideConfig {

    @NotNull
    private static final String TAG = "SpenBrushGuideMarginConfig";
    private float mPercentBottomMargin;
    private final float mPercentEndMargin;
    private final float mPercentStartMargin;
    private float mPercentTopMargin;

    @NotNull
    private final int[] viewIds;

    public SpenBrushGuideMarginConfig(int i, float f) {
        super(0.0f, 0.0f);
        this.viewIds = new int[]{C7932R.id.b_guide, C7932R.id.e_guide, C7932R.id.s_guide, C7932R.id.t_guide};
        this.mPercentTopMargin = f;
        this.mPercentBottomMargin = f;
        this.mPercentStartMargin = f;
        this.mPercentEndMargin = f;
        if (i == 1) {
            this.mPercentTopMargin = 0.0f;
            this.mPercentBottomMargin = 0.0f;
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenBrushGuideConfig
    @Nullable
    public String getDimensionRatio(int alignment) {
        return null;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenBrushGuideConfig
    public float getPercentHeight(int orientation, @IntRange(from = 0, m706to = 3) int alignment) {
        return orientation == 1 ? new float[]{this.mPercentBottomMargin, 1.0f, 1.0f, this.mPercentTopMargin}[alignment] : new float[]{this.mPercentStartMargin, 1.0f, 1.0f, this.mPercentEndMargin}[alignment];
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenBrushGuideConfig
    public float getPercentWidth(int orientation, @IntRange(from = 0, m706to = 3) int alignment) {
        return orientation == 1 ? new float[]{1.0f, this.mPercentEndMargin, this.mPercentStartMargin, 1.0f}[alignment] : new float[]{1.0f, this.mPercentBottomMargin, this.mPercentTopMargin, 1.0f}[alignment];
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenBrushGuideConfig
    @NotNull
    public int[] getViewIds() {
        return this.viewIds;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenBrushGuideConfig
    @NotNull
    public View makeView(@NotNull Context context, int alignment) {
        Intrinsics.checkNotNullParameter(context, "context");
        View view = new View(context);
        view.setId(getViewIds()[alignment]);
        return view;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenBrushGuideConfig
    public void setGuideRelation(@NotNull ConstraintLayout.LayoutParams params, int alignment) {
        Intrinsics.checkNotNullParameter(params, "params");
        if (alignment == 0) {
            params.startToStart = 0;
            params.bottomToBottom = 0;
            params.endToEnd = 0;
            return;
        }
        if (alignment == 1) {
            params.endToEnd = 0;
            params.bottomToBottom = 0;
            params.topToTop = 0;
        } else if (alignment == 2) {
            params.startToStart = 0;
            params.bottomToBottom = 0;
            params.topToTop = 0;
        } else {
            if (alignment != 3) {
                return;
            }
            params.topToTop = 0;
            params.startToStart = 0;
            params.endToEnd = 0;
        }
    }
}
