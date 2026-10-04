package com.samsung.android.sdk.pen.setting;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.material.carousel.RunnableC4617a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.bixby2.action.ActionHandler;
import com.samsung.android.sdk.pen.setting.SpenBrushGuideConfigFactory;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 <2\u00020\u0001:\u0001<B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ&\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0007J\u0006\u0010\u001e\u001a\u00020\u0019J\u0010\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020\u0011J\u0010\u0010'\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020\u0011J\u000e\u0010(\u001a\u00020\u00112\u0006\u0010)\u001a\u00020\u0011J\u0018\u0010*\u001a\u00020\u00192\b\u0010+\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001f\u001a\u00020\u0011J\u0018\u0010,\u001a\u00020\u00192\b\u0010-\u001a\u0004\u0018\u00010%2\u0006\u0010\u001f\u001a\u00020\u0011J\u0018\u0010.\u001a\u00020\u00192\b\u0010-\u001a\u0004\u0018\u00010%2\u0006\u0010\u001f\u001a\u00020\u0011J\u0016\u0010/\u001a\u00020\u00192\u0006\u00100\u001a\u00020\u00112\u0006\u00101\u001a\u00020\u0011J\u000e\u00102\u001a\u00020\u00192\u0006\u00103\u001a\u00020\u0005J\u0016\u00104\u001a\u00020\u00192\u0006\u00105\u001a\u00020\u00112\u0006\u00106\u001a\u00020\u0011J\u0016\u00107\u001a\u00020\u00192\u0006\u00108\u001a\u0002092\u0006\u0010\u001f\u001a\u00020\u0011J\u0016\u0010:\u001a\u00020\u00192\u0006\u00108\u001a\u0002092\u0006\u0010\u001f\u001a\u00020\u0011J\u0006\u0010;\u001a\u00020\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u00118F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006="}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenBrushGuideControl;", "", "mContext", "Landroid/content/Context;", "needPacked", "", "marginRatio", "", "<init>", "(Landroid/content/Context;ZF)V", "mViewParent", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getMViewParent", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setMViewParent", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "mOrientation", "", "mGuideBgRadius", "mGuideBgColor", "mPenGuideConfig", "Lcom/samsung/android/sdk/pen/setting/SpenBrushGuideConfig;", "mColorGuideConfig", "mMarginGuideConfig", "setViewInfo", "", "penPercentWidth", "penPercentHeight", "colorPercentWidth", "colorPercentHeight", "close", "orientation", "getOrientation", "()I", "setOrientation", "(I)V", "getPenGuideView", "Landroid/view/View;", "align", "getColorGuideView", "getAlign", "guideId", "makeGuide", "parent", "updatePenViewRatio", "view", "updateColorViewRatio", "setGuideRoundedBackground", "radius", "bgColor", "setAllChildBgVisibility", "isShow", "adjustGuide", "penAlign", "colorAlign", "setPenViewParam", ActionHandler.PARAMS, "Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;", "setColorViewParam", "setTag", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenBrushGuideControl {

    @JvmField
    public static final int ALIGN_BOTTOM = 0;

    @NotNull
    private SpenBrushGuideConfig mColorGuideConfig;

    @NotNull
    private Context mContext;
    private int mGuideBgColor;
    private int mGuideBgRadius;

    @NotNull
    private SpenBrushGuideConfig mMarginGuideConfig;
    private int mOrientation;

    @NotNull
    private SpenBrushGuideConfig mPenGuideConfig;

    @Nullable
    private ConstraintLayout mViewParent;

    @NotNull
    private static final String TAG = "SpenBrushGuideControl";

    @JvmField
    public static final int ALIGN_END = 1;

    @JvmField
    public static final int ALIGN_START = 2;

    @JvmField
    public static final int ALIGN_TOP = 3;

    public SpenBrushGuideControl(@NotNull Context mContext, boolean z, float f) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.mContext = mContext;
        int i = z ? 2 : 1;
        this.mMarginGuideConfig = SpenBrushGuideConfigFactory.createBrushGuideConfig(SpenBrushGuideConfigFactory.ConfigType.MARGIN, i, f);
        this.mPenGuideConfig = SpenBrushGuideConfigFactory.createBrushGuideConfig(SpenBrushGuideConfigFactory.ConfigType.PEN, i, f);
        this.mColorGuideConfig = SpenBrushGuideConfigFactory.createBrushGuideConfig(SpenBrushGuideConfigFactory.ConfigType.COLOR, i, f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _set_orientation_$lambda$0(SpenBrushGuideControl spenBrushGuideControl) {
        ConstraintLayout constraintLayout = spenBrushGuideControl.mViewParent;
        if (constraintLayout != null) {
            constraintLayout.requestLayout();
        }
    }

    public final void adjustGuide(int penAlign, int colorAlign) {
        AbstractC6670b.m4744e(penAlign, colorAlign, "setGuideLayout() penAlign=", "colorAlign=", TAG);
        this.mPenGuideConfig.setGuideVisibility(penAlign);
        this.mColorGuideConfig.setGuideVisibility(colorAlign);
    }

    public final void close() {
        this.mMarginGuideConfig.close();
        this.mPenGuideConfig.close();
        this.mColorGuideConfig.close();
    }

    public final int getAlign(int guideId) {
        int alignment = this.mPenGuideConfig.getAlignment(guideId);
        return alignment > -1 ? alignment : this.mColorGuideConfig.getAlignment(guideId);
    }

    @Nullable
    public final View getColorGuideView(int align) {
        return this.mColorGuideConfig.getGuideView(align);
    }

    @Nullable
    public final ConstraintLayout getMViewParent() {
        return this.mViewParent;
    }

    /* JADX INFO: renamed from: getOrientation, reason: from getter */
    public final int getMOrientation() {
        return this.mOrientation;
    }

    @Nullable
    public final View getPenGuideView(int align) {
        return this.mPenGuideConfig.getGuideView(align);
    }

    public final void makeGuide(@Nullable ConstraintLayout parent, int orientation) {
        AbstractC2322a.m1631u(orientation, "makeGuide() orientation =", TAG);
        this.mViewParent = parent;
        if (parent != null) {
            this.mOrientation = orientation;
            this.mMarginGuideConfig.makeGuide(parent, orientation);
            this.mPenGuideConfig.makeGuide(parent, this.mOrientation);
            this.mColorGuideConfig.makeGuide(parent, this.mOrientation);
        }
    }

    public final void setAllChildBgVisibility(boolean isShow) {
        AbstractC4539a.m3208r("setAllChildBgVisibility() isShow=", TAG, isShow);
        if (!isShow) {
            this.mPenGuideConfig.hideGuideBackground();
            this.mColorGuideConfig.hideGuideBackground();
            return;
        }
        int i = this.mGuideBgColor;
        if (i == 0) {
            return;
        }
        this.mPenGuideConfig.showGuideBackground(this.mGuideBgRadius, i);
        this.mColorGuideConfig.showGuideBackground(this.mGuideBgRadius, this.mGuideBgColor);
    }

    public final void setColorViewParam(@NotNull ConstraintLayout.LayoutParams params, int orientation) {
        Intrinsics.checkNotNullParameter(params, "params");
        this.mColorGuideConfig.updateParam(params, orientation, 3);
    }

    public final void setGuideRoundedBackground(int radius, int bgColor) {
        AbstractC6670b.m4744e(radius, bgColor, "setGuideRoundBackground() radius=", " bgColor=", TAG);
        this.mGuideBgRadius = radius;
        this.mGuideBgColor = bgColor;
    }

    public final void setMViewParent(@Nullable ConstraintLayout constraintLayout) {
        this.mViewParent = constraintLayout;
    }

    public final void setOrientation(int i) {
        AbstractC6670b.m4744e(i, this.mOrientation, "setOrientation() orientation=", " current=", TAG);
        if (this.mOrientation == i) {
            Log.i("SpenBrushGuideControl", "== Same Orientation");
            return;
        }
        this.mMarginGuideConfig.updateGuideRatio(i);
        this.mPenGuideConfig.updateGuideRatio(i);
        this.mColorGuideConfig.updateGuideRatio(i);
        this.mOrientation = i;
        new Handler(Looper.getMainLooper()).post(new RunnableC4617a(this, 17));
    }

    public final void setPenViewParam(@NotNull ConstraintLayout.LayoutParams params, int orientation) {
        Intrinsics.checkNotNullParameter(params, "params");
        this.mPenGuideConfig.updateParam(params, orientation, 3);
    }

    public final void setTag() {
        this.mPenGuideConfig.setTag();
        this.mColorGuideConfig.setTag();
    }

    public final void setViewInfo(float penPercentWidth, float penPercentHeight, float colorPercentWidth, float colorPercentHeight) {
        this.mPenGuideConfig.setSize(penPercentWidth, penPercentHeight);
        this.mColorGuideConfig.setSize(colorPercentWidth, colorPercentHeight);
    }

    public final void updateColorViewRatio(@Nullable View view, int orientation) {
        AbstractC2322a.m1631u(orientation, "updateColorViewRatio() orientation=", TAG);
        this.mColorGuideConfig.updateViewRatio(view, orientation, 3);
    }

    public final void updatePenViewRatio(@Nullable View view, int orientation) {
        AbstractC2322a.m1631u(orientation, "updatePenViewRatio() orientation=", TAG);
        this.mPenGuideConfig.updateViewRatio(view, orientation, 3);
    }
}
