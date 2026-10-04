package com.samsung.android.sdk.pen.setting;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.IntRange;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.samsung.android.sdk.bixby2.action.ActionHandler;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilDrawable;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.method.CoeditGrpcMethod;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import opennlp.tools.parser.AbstractBottomUpParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b \u0018\u0000 32\u00020\u0001:\u00013B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0011J \u0010\u0015\u001a\u00020\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0011J\u0016\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u0011J\u001e\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0011J\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0011J\u001e\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0011J\u001a\u0010 \u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00112\b\b\u0001\u0010\u0017\u001a\u00020\u0011H\u0016J\u001a\u0010!\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00112\b\b\u0001\u0010\u0017\u001a\u00020\u0011H\u0016J\u0014\u0010\"\u001a\u0004\u0018\u00010#2\b\b\u0001\u0010\u0017\u001a\u00020\u0011H\u0016J\u0010\u0010$\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0017\u001a\u00020\u0011J\u000e\u0010%\u001a\u00020\f2\u0006\u0010&\u001a\u00020\u0011J\u0016\u0010'\u001a\u00020\f2\u0006\u0010(\u001a\u00020\u00112\u0006\u0010)\u001a\u00020\u0011J\u0006\u0010*\u001a\u00020\fJ\u0006\u0010+\u001a\u00020\fJ\u0018\u0010\u001b\u001a\u00020\t2\u0006\u00100\u001a\u0002012\u0006\u0010\u0017\u001a\u00020\u0011H&J\u0018\u00102\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\u0017\u001a\u00020\u0011H&R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nR\u0012\u0010,\u001a\u00020-X¦\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/¨\u00064"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenBrushGuideConfig;", "", "mPercentWidth", "", "mPercentHeight", "<init>", "(FF)V", "mGuideView", "", "Landroid/view/View;", "[Landroid/view/View;", "close", "", "setSize", "percentWidth", "percentHeight", "getAlignment", "", "id", "updateGuideRatio", "orientation", "updateViewRatio", "view", "alignment", "makeGuide", "parent", "Landroidx/constraintlayout/widget/ConstraintLayout;", "makeView", "makeParams", "Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;", "updateParam", ActionHandler.PARAMS, "getPercentWidth", "getPercentHeight", "getDimensionRatio", "", "getGuideView", "setGuideVisibility", "visibleAlignment", "showGuideBackground", "radius", "color", "hideGuideBackground", "setTag", "viewIds", "", "getViewIds", "()[I", "context", "Landroid/content/Context;", "setGuideRelation", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public abstract class SpenBrushGuideConfig {
    public static final int ALIGN_BOTTOM = 0;
    public static final int ALIGN_END = 1;
    public static final int ALIGN_START = 2;
    public static final int ALIGN_TOP = 3;
    public static final int ALIGN_TOTAL = 4;
    public static final int DEFAULT_MARGIN = 10;

    @NotNull
    private View[] mGuideView = new View[4];
    private float mPercentHeight;
    private float mPercentWidth;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String[] mGuideTag = {"BOTTOM", CoeditGrpcMethod.Caller.END, CoeditGrpcMethod.Caller.START, AbstractBottomUpParser.TOP_NODE};

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0019\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenBrushGuideConfig$Companion;", "", "<init>", "()V", "ALIGN_BOTTOM", "", "ALIGN_END", "ALIGN_START", "ALIGN_TOP", "ALIGN_TOTAL", "DEFAULT_MARGIN", "mGuideTag", "", "", "getMGuideTag", "()[Ljava/lang/String;", "[Ljava/lang/String;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String[] getMGuideTag() {
            return SpenBrushGuideConfig.mGuideTag;
        }

        private Companion() {
        }
    }

    public SpenBrushGuideConfig(float f, float f4) {
        this.mPercentWidth = f;
        this.mPercentHeight = f4;
    }

    public final int getAlignment(int id) {
        int iBinarySearch = Arrays.binarySearch(getViewIds(), id);
        if (iBinarySearch > -1) {
            return iBinarySearch;
        }
        return -1;
    }

    @Nullable
    public String getDimensionRatio(@IntRange(from = 0, m706to = 3) int alignment) {
        StringBuilder sb;
        float f = 10000;
        int i = (int) (this.mPercentWidth * f);
        int i2 = (int) (f * this.mPercentHeight);
        if (alignment == 0 || alignment == 3) {
            sb = new StringBuilder();
            sb.append(i);
            sb.append(":");
            sb.append(i2);
        } else {
            sb = new StringBuilder();
            sb.append(i2);
            sb.append(":");
            sb.append(i);
        }
        return sb.toString();
    }

    @Nullable
    public final View getGuideView(int alignment) {
        return this.mGuideView[alignment];
    }

    public float getPercentHeight(int orientation, @IntRange(from = 0, m706to = 3) int alignment) {
        float f = this.mPercentHeight;
        float f4 = this.mPercentWidth;
        float[] fArr = {f, f4, f4, f};
        if (orientation == 1) {
            return 1.0f;
        }
        return fArr[alignment];
    }

    public float getPercentWidth(int orientation, @IntRange(from = 0, m706to = 3) int alignment) {
        float f = this.mPercentWidth;
        float f4 = this.mPercentHeight;
        float[] fArr = {f, f4, f4, f};
        if (orientation == 1) {
            return fArr[alignment];
        }
        return 1.0f;
    }

    @NotNull
    public abstract int[] getViewIds();

    public final void hideGuideBackground() {
        for (View view : this.mGuideView) {
            if (view != null) {
                view.setBackground(null);
            }
        }
    }

    public final void makeGuide(@NotNull ConstraintLayout parent, int orientation) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        int length = this.mGuideView.length;
        for (int i = 0; i < length; i++) {
            this.mGuideView[i] = makeView(parent, orientation, i);
        }
    }

    @NotNull
    public final ConstraintLayout.LayoutParams makeParams(int orientation, int alignment) {
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(0, 0);
        updateParam(layoutParams, orientation, alignment);
        return layoutParams;
    }

    @NotNull
    public abstract View makeView(@NotNull Context context, int alignment);

    @NotNull
    public final View makeView(@NotNull ConstraintLayout parent, int orientation, int alignment) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        View viewMakeView = makeView(context, alignment);
        ConstraintLayout.LayoutParams layoutParamsMakeParams = makeParams(orientation, alignment);
        setGuideRelation(layoutParamsMakeParams, alignment);
        parent.addView(viewMakeView, layoutParamsMakeParams);
        return viewMakeView;
    }

    public abstract void setGuideRelation(@NotNull ConstraintLayout.LayoutParams params, int alignment);

    public final void setGuideVisibility(int visibleAlignment) {
        int length = this.mGuideView.length;
        int i = 0;
        while (i < length) {
            View view = this.mGuideView[i];
            if (view != null) {
                view.setVisibility(i == visibleAlignment ? 0 : 8);
            }
            i++;
        }
    }

    public final void setSize(float percentWidth, float percentHeight) {
        this.mPercentWidth = percentWidth;
        this.mPercentHeight = percentHeight;
    }

    public final void setTag() {
        int length = this.mGuideView.length;
        for (int i = 0; i < length; i++) {
            View view = this.mGuideView[i];
            if (view != null) {
                view.setTag(mGuideTag[i]);
            }
        }
    }

    public final void showGuideBackground(int radius, int color) {
        for (View view : this.mGuideView) {
            if (view != null) {
                view.setBackground(SpenSettingUtilDrawable.getRoundedCornerDrawable(radius, color, 0, 0));
            }
        }
    }

    public final void updateGuideRatio(int orientation) {
        int length = this.mGuideView.length;
        for (int i = 0; i < length; i++) {
            updateViewRatio(this.mGuideView[i], orientation, i);
        }
    }

    public final void updateParam(@NotNull ConstraintLayout.LayoutParams params, int orientation, int alignment) {
        Intrinsics.checkNotNullParameter(params, "params");
        params.matchConstraintPercentWidth = getPercentWidth(orientation, alignment);
        params.matchConstraintPercentHeight = getPercentHeight(orientation, alignment);
        String dimensionRatio = getDimensionRatio(alignment);
        if (dimensionRatio == null) {
            return;
        }
        params.dimensionRatio = dimensionRatio;
    }

    public final void updateViewRatio(@Nullable View view, int orientation, int alignment) {
        if (view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        layoutParams2.matchConstraintPercentWidth = getPercentWidth(orientation, alignment);
        layoutParams2.matchConstraintPercentHeight = getPercentHeight(orientation, alignment);
        view.setLayoutParams(layoutParams2);
    }

    public final void close() {
    }
}
