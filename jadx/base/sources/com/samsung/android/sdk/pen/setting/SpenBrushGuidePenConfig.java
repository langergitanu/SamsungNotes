package com.samsung.android.sdk.pen.setting;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.samsung.android.sdk.bixby2.action.ActionHandler;
import com.samsung.android.spen.C7932R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenBrushGuidePenConfig;", "Lcom/samsung/android/sdk/pen/setting/SpenBrushGuideConfig;", "mStyle", "", "<init>", "(I)V", "viewIds", "", "getViewIds", "()[I", "makeView", "Landroid/view/View;", "context", "Landroid/content/Context;", "alignment", "setGuideRelation", "", ActionHandler.PARAMS, "Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenBrushGuidePenConfig extends SpenBrushGuideConfig {
    private static final float DEFAULT_PEN_PERCENT_HEIGHT = 0.1425f;
    private static final float DEFAULT_PEN_PERCENT_WIDTH = 0.575f;

    @NotNull
    private static final String TAG = "SpenBrushGuidePenConfig";
    private final int mStyle;

    @NotNull
    private final int[] viewIds;

    public SpenBrushGuidePenConfig(int i) {
        super(DEFAULT_PEN_PERCENT_WIDTH, DEFAULT_PEN_PERCENT_HEIGHT);
        this.mStyle = i;
        this.viewIds = new int[]{C7932R.id.b_pen, C7932R.id.e_pen, C7932R.id.s_pen, C7932R.id.t_pen};
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
        TextView textView = new TextView(context);
        textView.setId(getViewIds()[alignment]);
        return textView;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenBrushGuideConfig
    public void setGuideRelation(@NotNull ConstraintLayout.LayoutParams params, int alignment) {
        Intrinsics.checkNotNullParameter(params, "params");
        if (alignment == 0) {
            params.bottomToTop = C7932R.id.b_guide;
            params.startToEnd = C7932R.id.s_guide;
            int i = this.mStyle;
            if (i == 2) {
                params.horizontalChainStyle = i;
                params.endToStart = C7932R.id.b_color;
                return;
            }
            return;
        }
        if (alignment == 1) {
            params.endToStart = C7932R.id.e_guide;
            params.bottomToTop = C7932R.id.b_guide;
            if (this.mStyle == 2) {
                params.topToBottom = C7932R.id.e_color;
                ((ViewGroup.MarginLayoutParams) params).topMargin = 10;
                return;
            }
            return;
        }
        if (alignment == 2) {
            params.startToEnd = C7932R.id.s_guide;
            params.bottomToTop = C7932R.id.b_guide;
            if (this.mStyle == 2) {
                params.topToBottom = C7932R.id.s_color;
                ((ViewGroup.MarginLayoutParams) params).topMargin = 10;
                return;
            }
            return;
        }
        if (alignment != 3) {
            return;
        }
        params.startToEnd = C7932R.id.s_guide;
        params.topToBottom = C7932R.id.t_guide;
        int i2 = this.mStyle;
        if (i2 == 2) {
            params.horizontalChainStyle = i2;
            params.endToStart = C7932R.id.t_color;
        }
    }
}
