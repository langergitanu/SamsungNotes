package com.samsung.android.sdk.pen.setting.drawing;

import android.animation.AnimatorInflater;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.transition.ChangeBounds;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.glance.AbstractC2821a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.SpenSettingPenInfo;
import com.samsung.android.sdk.pen.setting.colorpalette.ViewOnClickListenerC7538b;
import com.samsung.android.sdk.pen.setting.drawing.SpenBrushPenLayoutInterface;
import com.samsung.android.sdk.pen.setting.pencommon.SpenSettingPenResource;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAccessibility;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAnimation;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilColor;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilDrawable;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilHover;
import com.samsung.android.spen.C7932R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 g2\u00020\u00012\u00020\u0002:\u0002ghB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010$\u001a\u00020%H\u0014J\b\u0010&\u001a\u00020%H\u0016J\u0006\u0010'\u001a\u00020\u0006J\u000e\u0010(\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010(\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u000fJ\u0010\u0010*\u001a\u00020%2\b\u0010+\u001a\u0004\u0018\u00010\u0013J\u0018\u0010,\u001a\u00020%2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010.H\u0016J(\u0010,\u001a\u00020%2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010.2\u000e\u0010/\u001a\n\u0012\u0004\u0012\u000200\u0018\u00010.H\u0016J\u0018\u00101\u001a\u00020%2\u000e\u00102\u001a\n\u0012\u0004\u0012\u000204\u0018\u000103H\u0016J\u001a\u00105\u001a\u00020\u000f2\b\u00106\u001a\u0004\u0018\u00010\u00152\u0006\u00107\u001a\u00020\u0006H\u0016J\u0010\u00108\u001a\u00020%2\u0006\u00109\u001a\u00020\u0006H\u0002J\u0010\u0010:\u001a\u00020%2\u0006\u0010;\u001a\u00020\u000fH\u0002J\b\u0010<\u001a\u00020%H\u0002J\b\u0010=\u001a\u00020\u000fH\u0002J\u0012\u0010>\u001a\u00020%2\b\u0010+\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010?\u001a\u00020\u0006H\u0016J\b\u0010@\u001a\u00020\u0006H\u0016J\b\u00108\u001a\u00020%H\u0016J\u000e\u0010A\u001a\u00020%2\u0006\u0010B\u001a\u00020\u000fJ\u000e\u0010C\u001a\u00020%2\u0006\u0010D\u001a\u00020\u0006J\u000e\u0010E\u001a\u00020%2\u0006\u0010F\u001a\u00020\u0006J\u0010\u0010G\u001a\u00020%2\u0006\u0010H\u001a\u00020\u000fH\u0002J\u0018\u0010I\u001a\u00020%2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010J\u001a\u00020\u0001H\u0002J\u0010\u0010O\u001a\u00020%2\u0006\u00109\u001a\u00020\u0006H\u0002J\u0018\u0010P\u001a\u00020%2\u0006\u00109\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u000fH\u0002J\u0010\u0010Q\u001a\u00020%2\u0006\u00109\u001a\u00020\u0006H\u0002J\u0018\u0010R\u001a\u00020%2\u0006\u00109\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u000fH\u0002J\u0018\u0010S\u001a\u00020%2\u0006\u0010T\u001a\u00020\u00062\u0006\u0010U\u001a\u00020\u0006H\u0002J\u0018\u0010X\u001a\u00020%2\u0006\u0010T\u001a\u00020\u00062\u0006\u0010Y\u001a\u00020\u0006H\u0002J(\u0010Z\u001a\u00020%2\u0006\u0010[\u001a\u00020\u00062\u0006\u0010\\\u001a\u00020\u00062\u0006\u0010]\u001a\u00020\u00062\u0006\u0010^\u001a\u00020\u0006H\u0016J\u0018\u0010_\u001a\u00020%2\u0006\u0010`\u001a\u00020a2\u0006\u0010b\u001a\u00020aH\u0016J\u0010\u0010c\u001a\u00020%2\u0006\u00109\u001a\u00020\u0006H\u0002R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0001X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020LX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020NX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u00020eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006i"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/drawing/SpenBrushPenTypeLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/samsung/android/sdk/pen/setting/drawing/SpenBrushPenLayoutInterface;", "context", "Landroid/content/Context;", "viewMode", "", "<init>", "(Landroid/content/Context;I)V", "mViewMode", "mCurrentColor", "mTotal", "mUtilColor", "Lcom/samsung/android/sdk/pen/setting/util/SpenSettingUtilColor;", "mIsSelected", "", "mActionListener", "Lcom/samsung/android/sdk/pen/setting/drawing/SpenBrushPenLayoutInterface$OnActionListener;", "mModeChangeListener", "Lcom/samsung/android/sdk/pen/setting/drawing/SpenBrushPenTypeLayout$OnModeChangeListener;", "mCurrentPen", "", "mSpaceGroup", "Landroid/view/View;", "mPenItemGroup", "mPenView", "Lcom/samsung/android/sdk/pen/setting/drawing/SpenBrushPenView;", "mPenList", "Lcom/samsung/android/sdk/pen/setting/drawing/SpenBrushPenListLayout;", "mOpenerGroup", "Landroid/widget/FrameLayout;", "mOpener", "Landroid/widget/ImageButton;", "mTransitionSet", "Landroid/transition/TransitionSet;", "mSpaceAniBg", "onAttachedToWindow", "", "close", "getViewMode", "setViewMode", "needAnimation", "setViewModeChangeListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setPenList", "penNames", "", "resourceInfo", "Lcom/samsung/android/sdk/pen/setting/pencommon/SpenSettingPenResource;", "setPenInfoList", "penInfoList", "", "Lcom/samsung/android/sdk/pen/SpenSettingPenInfo;", "setPenInfo", "penName", "color", "setUnselectedPen", "mode", "setPenItemSelected", "selected", "updatePenItem", "updatePenList", "setActionListener", "getPenCount", "getSelectedPenPosition", "setExpandToSelectPen", "isExpandToSelectPen", "setPenDegree", "degree", "smoothScrollTo", "xPos", "toggleMode", "animation", "initView", "totalLayout", "mTransitionListener", "Landroid/transition/Transition$TransitionListener;", "mModeChangeClickListener", "Landroid/view/View$OnClickListener;", "updateView", "changeMode", "changeModeWithoutAnimation", "updateOpenerDrawable", "updateOpenerResource", "drawableId", "StringId", "mToOpenerDrawableId", "mToOpenerStringId", "startOpenerAnimation", "stringId", "setRoundedBackground", "radius", "bgColor", "strokeSize", "strokeColor", "setPenLayoutRatio", "penLayoutPercentWidth", "", "penLayoutPercentHeight", "changeModeWithAnimation", "mExAnimationListener", "Landroid/view/animation/Animation$AnimationListener;", "mEllipseAnimationListener", "Companion", "OnModeChangeListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenBrushPenTypeLayout extends ConstraintLayout implements SpenBrushPenLayoutInterface {
    private static final int ANI_CONTRACT_DURATION = 350;
    private static final int ANI_CONTRACT_OFFSET = 100;
    private static final int ANI_DIM_DURATION = 450;
    private static final int ANI_EXPAND_DURATION = 150;
    private static final int ANI_EXPAND_OFFSET = 0;
    private static final int ANI_MOVE_DURATION = 450;
    private static final int ANI_OPENER_ROTATE_DURATION = 300;
    private static final int ANI_PEN_VIEW_UP_DURATION = 300;
    private static final float PENVIEW_OFFSET_TRANSLATION_Y = 0.243f;

    @NotNull
    private static final String TAG = "SpenBrushPenTypeLayout";
    public static final int VIEW_MODE_ITEM = 1;
    public static final int VIEW_MODE_LIST = 2;

    @Nullable
    private SpenBrushPenLayoutInterface.OnActionListener mActionListener;
    private int mCurrentColor;

    @Nullable
    private String mCurrentPen;

    @NotNull
    private final Animation.AnimationListener mEllipseAnimationListener;

    @NotNull
    private final Animation.AnimationListener mExAnimationListener;
    private boolean mIsSelected;

    @NotNull
    private final View.OnClickListener mModeChangeClickListener;

    @Nullable
    private OnModeChangeListener mModeChangeListener;
    private ImageButton mOpener;
    private FrameLayout mOpenerGroup;
    private ConstraintLayout mPenItemGroup;
    private SpenBrushPenListLayout mPenList;
    private SpenBrushPenView mPenView;
    private View mSpaceAniBg;
    private View mSpaceGroup;
    private int mToOpenerDrawableId;
    private int mToOpenerStringId;

    @NotNull
    private ConstraintLayout mTotal;

    @NotNull
    private final Transition.TransitionListener mTransitionListener;
    private TransitionSet mTransitionSet;

    @NotNull
    private SpenSettingUtilColor mUtilColor;
    private int mViewMode;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/drawing/SpenBrushPenTypeLayout$OnModeChangeListener;", "", "onModeChanged", "", "mode", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnModeChangeListener {
        void onModeChanged(int mode);
    }

    /* JADX INFO: renamed from: com.samsung.android.sdk.pen.setting.drawing.SpenBrushPenTypeLayout$startOpenerAnimation$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, m13886d2 = {"com/samsung/android/sdk/pen/setting/drawing/SpenBrushPenTypeLayout$startOpenerAnimation$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationStart", "", "animation", "Landroid/view/animation/Animation;", "onAnimationEnd", "onAnimationRepeat", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class AnimationAnimationListenerC75681 implements Animation.AnimationListener {
        public AnimationAnimationListenerC75681() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onAnimationEnd$lambda$0(SpenBrushPenTypeLayout spenBrushPenTypeLayout) {
            spenBrushPenTypeLayout.updateOpenerResource(spenBrushPenTypeLayout.mToOpenerDrawableId, spenBrushPenTypeLayout.mToOpenerStringId);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            new Handler().post(new RunnableC7571a(SpenBrushPenTypeLayout.this, 1));
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenBrushPenTypeLayout(@NotNull Context context, int i) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mViewMode = i;
        this.mTransitionListener = new Transition.TransitionListener() { // from class: com.samsung.android.sdk.pen.setting.drawing.SpenBrushPenTypeLayout$mTransitionListener$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(Transition transition) {
                Intrinsics.checkNotNullParameter(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(Transition transition) {
                Intrinsics.checkNotNullParameter(transition, "transition");
                this.this$0.requestLayout();
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(Transition transition) {
                Intrinsics.checkNotNullParameter(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(Transition transition) {
                Intrinsics.checkNotNullParameter(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(Transition transition) {
                Intrinsics.checkNotNullParameter(transition, "transition");
            }
        };
        this.mModeChangeClickListener = new SpenBrushPenTypeLayout$mModeChangeClickListener$1(this);
        this.mExAnimationListener = new Animation.AnimationListener() { // from class: com.samsung.android.sdk.pen.setting.drawing.SpenBrushPenTypeLayout$mExAnimationListener$1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ConstraintLayout constraintLayout = this.this$0.mPenItemGroup;
                if (constraintLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPenItemGroup");
                    constraintLayout = null;
                }
                constraintLayout.setVisibility(4);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        };
        this.mEllipseAnimationListener = new Animation.AnimationListener() { // from class: com.samsung.android.sdk.pen.setting.drawing.SpenBrushPenTypeLayout$mEllipseAnimationListener$1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ConstraintLayout constraintLayout = this.this$0.mPenItemGroup;
                View view = null;
                if (constraintLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPenItemGroup");
                    constraintLayout = null;
                }
                constraintLayout.setVisibility(0);
                View view2 = this.this$0.mSpaceAniBg;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSpaceAniBg");
                    view2 = null;
                }
                view2.setVisibility(4);
                SpenBrushPenListLayout spenBrushPenListLayout = this.this$0.mPenList;
                if (spenBrushPenListLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPenList");
                    spenBrushPenListLayout = null;
                }
                spenBrushPenListLayout.setVisibility(4);
                View view3 = this.this$0.mSpaceGroup;
                if (view3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSpaceGroup");
                } else {
                    view = view3;
                }
                view.setVisibility(4);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        };
        Object systemService = context.getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        View viewInflate = ((LayoutInflater) systemService).inflate(C7932R.layout.setting_brush_pen_type_layout_v2, (ViewGroup) this, false);
        Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        this.mTotal = (ConstraintLayout) viewInflate;
        this.mUtilColor = new SpenSettingUtilColor(context);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(0, 0);
        layoutParams.startToStart = 0;
        layoutParams.endToEnd = 0;
        layoutParams.topToTop = 0;
        layoutParams.bottomToBottom = 0;
        initView(context, this.mTotal);
        addView(this.mTotal, layoutParams);
        changeMode(this.mViewMode, false);
    }

    private final void changeMode(int mode, boolean needAnimation) {
        if (needAnimation) {
            changeModeWithAnimation(mode);
        } else {
            changeModeWithoutAnimation(mode);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:90:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void changeModeWithAnimation(int mode) {
        View view;
        TransitionSet transitionSet;
        TransitionSet transitionSet2;
        TransitionSet transitionSet3;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        boolean zIsRemoveAnimationsEnabled = SpenSettingUtilAccessibility.isRemoveAnimationsEnabled(context);
        boolean z = !zIsRemoveAnimationsEnabled;
        FrameLayout frameLayout = this.mOpenerGroup;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOpenerGroup");
            frameLayout = null;
        }
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        if (mode == 1) {
            view = this.mPenItemGroup;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPenItemGroup");
                view = null;
            }
        } else {
            view = this.mPenList;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPenList");
                view = null;
            }
        }
        layoutParams2.startToEnd = view.getId();
        FrameLayout frameLayout2 = this.mOpenerGroup;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOpenerGroup");
            frameLayout2 = null;
        }
        frameLayout2.setLayoutParams(layoutParams2);
        FrameLayout frameLayout3 = this.mOpenerGroup;
        if (frameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOpenerGroup");
            frameLayout3 = null;
        }
        frameLayout3.requestLayout();
        int i = layoutParams2.startToEnd;
        ConstraintLayout constraintLayout = this.mPenItemGroup;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenItemGroup");
            constraintLayout = null;
        }
        int id = constraintLayout.getId();
        SpenBrushPenListLayout spenBrushPenListLayout = this.mPenList;
        if (spenBrushPenListLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenList");
            spenBrushPenListLayout = null;
        }
        int id2 = spenBrushPenListLayout.getId();
        StringBuilder sbM1173s = AbstractC0622a.m1173s(mode, i, "changeModeWithAni() mode=", " mStartToEndId= ", " mPenItemGroup.getId()= ");
        AbstractC2821a.m2235z(sbM1173s, id, id2, " mPenList.getId()= ", " removeAnimationEnabled=");
        AbstractC0000a.m27x(sbM1173s, zIsRemoveAnimationsEnabled, TAG);
        if (mode == 1) {
            TransitionSet transitionSet4 = this.mTransitionSet;
            if (transitionSet4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTransitionSet");
                transitionSet4 = null;
            }
            transitionSet4.setStartDelay(100L);
            TransitionSet transitionSet5 = this.mTransitionSet;
            if (transitionSet5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTransitionSet");
                transitionSet5 = null;
            }
            transitionSet5.setDuration(350L);
            View view2 = this.mSpaceGroup;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSpaceGroup");
                view2 = null;
            }
            view2.setVisibility(4);
            View view3 = this.mSpaceAniBg;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSpaceAniBg");
                view3 = null;
            }
            view3.setVisibility(0);
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(!zIsRemoveAnimationsEnabled ? 450 : 0);
            alphaAnimation.setFillAfter(true);
            alphaAnimation.setInterpolator(SpenSettingUtilAnimation.getInterpolator(1));
            View view4 = this.mSpaceAniBg;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSpaceAniBg");
                view4 = null;
            }
            view4.startAnimation(alphaAnimation);
            if (zIsRemoveAnimationsEnabled) {
                this.mEllipseAnimationListener.onAnimationStart(null);
                this.mEllipseAnimationListener.onAnimationEnd(null);
            } else {
                SpenBrushPenListLayout spenBrushPenListLayout2 = this.mPenList;
                if (spenBrushPenListLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPenList");
                    spenBrushPenListLayout2 = null;
                }
                spenBrushPenListLayout2.setPenAnimation(this.mCurrentPen, false, this.mEllipseAnimationListener);
            }
        } else {
            TransitionSet transitionSet6 = this.mTransitionSet;
            if (transitionSet6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTransitionSet");
                transitionSet6 = null;
            }
            transitionSet6.setStartDelay(0L);
            TransitionSet transitionSet7 = this.mTransitionSet;
            if (transitionSet7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTransitionSet");
                transitionSet7 = null;
            }
            transitionSet7.setDuration(150L);
            View view5 = this.mSpaceGroup;
            if (view5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSpaceGroup");
                view5 = null;
            }
            view5.setVisibility(0);
            View view6 = this.mSpaceAniBg;
            if (view6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSpaceAniBg");
                view6 = null;
            }
            view6.setVisibility(0);
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation2.setDuration(!zIsRemoveAnimationsEnabled ? 450 : 0);
            alphaAnimation2.setInterpolator(SpenSettingUtilAnimation.getInterpolator(1));
            alphaAnimation2.setFillAfter(true);
            View view7 = this.mSpaceAniBg;
            if (view7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSpaceAniBg");
                view7 = null;
            }
            view7.startAnimation(alphaAnimation2);
            ConstraintLayout constraintLayout2 = this.mPenItemGroup;
            if (constraintLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPenItemGroup");
                constraintLayout2 = null;
            }
            constraintLayout2.setVisibility(4);
            SpenBrushPenListLayout spenBrushPenListLayout3 = this.mPenList;
            if (spenBrushPenListLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPenList");
                spenBrushPenListLayout3 = null;
            }
            spenBrushPenListLayout3.setVisibility(0);
            if (zIsRemoveAnimationsEnabled) {
                transitionSet = null;
                this.mExAnimationListener.onAnimationStart(null);
                this.mExAnimationListener.onAnimationEnd(null);
                ConstraintLayout constraintLayout3 = this.mTotal;
                transitionSet2 = this.mTransitionSet;
                if (transitionSet2 != null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTransitionSet");
                    transitionSet3 = transitionSet;
                } else {
                    transitionSet3 = transitionSet2;
                }
                TransitionManager.beginDelayedTransition(constraintLayout3, transitionSet3);
                updateOpenerDrawable(mode, z);
            }
            SpenBrushPenListLayout spenBrushPenListLayout4 = this.mPenList;
            if (spenBrushPenListLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPenList");
                spenBrushPenListLayout4 = null;
            }
            spenBrushPenListLayout4.setPenAnimation(this.mCurrentPen, true, this.mExAnimationListener);
        }
        transitionSet = null;
        ConstraintLayout constraintLayout32 = this.mTotal;
        transitionSet2 = this.mTransitionSet;
        if (transitionSet2 != null) {
        }
        TransitionManager.beginDelayedTransition(constraintLayout32, transitionSet3);
        updateOpenerDrawable(mode, z);
    }

    private final void changeModeWithoutAnimation(int mode) {
        FrameLayout frameLayout = this.mOpenerGroup;
        View view = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOpenerGroup");
            frameLayout = null;
        }
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        if (mode == 1) {
            ConstraintLayout constraintLayout = this.mPenItemGroup;
            if (constraintLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPenItemGroup");
                constraintLayout = null;
            }
            layoutParams2.startToEnd = constraintLayout.getId();
            FrameLayout frameLayout2 = this.mOpenerGroup;
            if (frameLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mOpenerGroup");
                frameLayout2 = null;
            }
            frameLayout2.setLayoutParams(layoutParams2);
            FrameLayout frameLayout3 = this.mOpenerGroup;
            if (frameLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mOpenerGroup");
                frameLayout3 = null;
            }
            frameLayout3.requestLayout();
            ConstraintLayout constraintLayout2 = this.mPenItemGroup;
            if (constraintLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPenItemGroup");
                constraintLayout2 = null;
            }
            constraintLayout2.setVisibility(0);
            SpenBrushPenListLayout spenBrushPenListLayout = this.mPenList;
            if (spenBrushPenListLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPenList");
                spenBrushPenListLayout = null;
            }
            spenBrushPenListLayout.setVisibility(4);
            View view2 = this.mSpaceGroup;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSpaceGroup");
                view2 = null;
            }
            view2.setVisibility(4);
            View view3 = this.mSpaceAniBg;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSpaceAniBg");
            } else {
                view = view3;
            }
            view.setVisibility(4);
        } else {
            SpenBrushPenListLayout spenBrushPenListLayout2 = this.mPenList;
            if (spenBrushPenListLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPenList");
                spenBrushPenListLayout2 = null;
            }
            layoutParams2.startToEnd = spenBrushPenListLayout2.getId();
            FrameLayout frameLayout4 = this.mOpenerGroup;
            if (frameLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mOpenerGroup");
                frameLayout4 = null;
            }
            frameLayout4.setLayoutParams(layoutParams2);
            FrameLayout frameLayout5 = this.mOpenerGroup;
            if (frameLayout5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mOpenerGroup");
                frameLayout5 = null;
            }
            frameLayout5.requestLayout();
            ConstraintLayout constraintLayout3 = this.mPenItemGroup;
            if (constraintLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPenItemGroup");
                constraintLayout3 = null;
            }
            constraintLayout3.setVisibility(4);
            SpenBrushPenListLayout spenBrushPenListLayout3 = this.mPenList;
            if (spenBrushPenListLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPenList");
                spenBrushPenListLayout3 = null;
            }
            spenBrushPenListLayout3.setVisibility(0);
            View view4 = this.mSpaceGroup;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSpaceGroup");
                view4 = null;
            }
            view4.setVisibility(0);
            View view5 = this.mSpaceAniBg;
            if (view5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSpaceAniBg");
            } else {
                view = view5;
            }
            view.setVisibility(4);
        }
        updateOpenerDrawable(mode, false);
    }

    private final void initView(Context context, ConstraintLayout totalLayout) {
        SpenBrushPenView spenBrushPenView = (SpenBrushPenView) totalLayout.findViewById(C7932R.id.menu_pen1);
        this.mPenView = spenBrushPenView;
        ImageButton imageButton = null;
        if (spenBrushPenView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenView");
            spenBrushPenView = null;
        }
        spenBrushPenView.setFocusable(false);
        spenBrushPenView.setFixedContentDescription(null);
        spenBrushPenView.setSelected(true);
        SpenBrushPenListLayout spenBrushPenListLayout = (SpenBrushPenListLayout) totalLayout.findViewById(C7932R.id.pen_list_view);
        this.mPenList = spenBrushPenListLayout;
        if (spenBrushPenListLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenList");
            spenBrushPenListLayout = null;
        }
        spenBrushPenListLayout.setActionListener(new SpenBrushPenLayoutInterface.OnActionListener() { // from class: com.samsung.android.sdk.pen.setting.drawing.SpenBrushPenTypeLayout.initView.2
            @Override // com.samsung.android.sdk.pen.setting.drawing.SpenBrushPenLayoutInterface.OnActionListener
            public void onPenClicked(String name, boolean isSelected) {
                Intrinsics.checkNotNullParameter(name, "name");
                SpenBrushPenLayoutInterface.OnActionListener onActionListener = SpenBrushPenTypeLayout.this.mActionListener;
                if (onActionListener != null) {
                    onActionListener.onPenClicked(name, isSelected);
                }
            }
        });
        ConstraintLayout constraintLayout = (ConstraintLayout) totalLayout.findViewById(C7932R.id.item_view);
        this.mPenItemGroup = constraintLayout;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenItemGroup");
            constraintLayout = null;
        }
        SpenSettingUtilHover.setHoverText(constraintLayout, context.getResources().getString(C7932R.string.pen_string_brush_settings));
        ConstraintLayout constraintLayout2 = this.mPenItemGroup;
        if (constraintLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenItemGroup");
            constraintLayout2 = null;
        }
        constraintLayout2.setContentDescription(context.getResources().getString(C7932R.string.pen_string_brush_settings));
        ConstraintLayout constraintLayout3 = this.mPenItemGroup;
        if (constraintLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenItemGroup");
            constraintLayout3 = null;
        }
        constraintLayout3.setOnClickListener(new ViewOnClickListenerC7538b(this, 9));
        View viewFindViewById = totalLayout.findViewById(C7932R.id.space_group);
        this.mSpaceGroup = viewFindViewById;
        if (viewFindViewById == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSpaceGroup");
            viewFindViewById = null;
        }
        viewFindViewById.setOnClickListener(this.mModeChangeClickListener);
        View view = this.mSpaceGroup;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSpaceGroup");
            view = null;
        }
        view.setImportantForAccessibility(2);
        this.mOpenerGroup = (FrameLayout) totalLayout.findViewById(C7932R.id.brush_opener_group);
        ImageButton imageButton2 = (ImageButton) totalLayout.findViewById(C7932R.id.opener);
        this.mOpener = imageButton2;
        if (imageButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOpener");
            imageButton2 = null;
        }
        imageButton2.setOnClickListener(this.mModeChangeClickListener);
        this.mSpaceAniBg = totalLayout.findViewById(C7932R.id.space_bg);
        TransitionSet transitionSet = new TransitionSet();
        this.mTransitionSet = transitionSet;
        transitionSet.addTransition(new ChangeBounds());
        transitionSet.setDuration(450L);
        transitionSet.setInterpolator((TimeInterpolator) SpenSettingUtilAnimation.getInterpolator(12));
        transitionSet.addListener(this.mTransitionListener);
        SpenBrushPenListLayout spenBrushPenListLayout2 = this.mPenList;
        if (spenBrushPenListLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenList");
            spenBrushPenListLayout2 = null;
        }
        transitionSet.excludeChildren((View) spenBrushPenListLayout2, true);
        if (SpenSettingUtil.needRecoilVI()) {
            ImageButton imageButton3 = this.mOpener;
            if (imageButton3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mOpener");
            } else {
                imageButton = imageButton3;
            }
            imageButton.setStateListAnimator(AnimatorInflater.loadStateListAnimator(context, C7932R.animator.spen_recoil_button_selector));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(SpenBrushPenTypeLayout spenBrushPenTypeLayout, View view) {
        SpenBrushPenLayoutInterface.OnActionListener onActionListener = spenBrushPenTypeLayout.mActionListener;
        if (onActionListener != null) {
            String str = spenBrushPenTypeLayout.mCurrentPen;
            if (str == null) {
                str = "";
            }
            SpenBrushPenView spenBrushPenView = spenBrushPenTypeLayout.mPenView;
            if (spenBrushPenView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPenView");
                spenBrushPenView = null;
            }
            onActionListener.onPenClicked(str, spenBrushPenView.getPenMaskEnabled());
        }
    }

    private final void setPenItemSelected(boolean selected) {
        SpenBrushPenView spenBrushPenView = this.mPenView;
        SpenBrushPenView spenBrushPenView2 = null;
        if (spenBrushPenView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenView");
            spenBrushPenView = null;
        }
        if (spenBrushPenView.isSelected() == selected) {
            return;
        }
        SpenBrushPenView spenBrushPenView3 = this.mPenView;
        if (spenBrushPenView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenView");
            spenBrushPenView3 = null;
        }
        spenBrushPenView3.setSelected(selected);
        SpenBrushPenView spenBrushPenView4 = this.mPenView;
        if (spenBrushPenView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenView");
            spenBrushPenView4 = null;
        }
        ViewGroup.LayoutParams layoutParams = spenBrushPenView4.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        layoutParams2.topToTop = selected ? C7932R.id.pen_top_guideline : C7932R.id.pen_top_unselected;
        SpenBrushPenView spenBrushPenView5 = this.mPenView;
        if (spenBrushPenView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenView");
        } else {
            spenBrushPenView2 = spenBrushPenView5;
        }
        spenBrushPenView2.setLayoutParams(layoutParams2);
    }

    private final void setUnselectedPen(int mode) {
        SpenBrushPenListLayout spenBrushPenListLayout = null;
        if (mode == 1) {
            setPenItemSelected(false);
            SpenBrushPenListLayout spenBrushPenListLayout2 = this.mPenList;
            if (spenBrushPenListLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPenList");
            } else {
                spenBrushPenListLayout = spenBrushPenListLayout2;
            }
            spenBrushPenListLayout.setUnselectedPen();
            return;
        }
        SpenBrushPenListLayout spenBrushPenListLayout3 = this.mPenList;
        if (spenBrushPenListLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenList");
        } else {
            spenBrushPenListLayout = spenBrushPenListLayout3;
        }
        spenBrushPenListLayout.setUnselectedPen();
        setPenItemSelected(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUnselectedPen$lambda$1(SpenBrushPenTypeLayout spenBrushPenTypeLayout) {
        spenBrushPenTypeLayout.setUnselectedPen(spenBrushPenTypeLayout.mViewMode);
    }

    private final void startOpenerAnimation(int drawableId, int stringId) {
        this.mToOpenerDrawableId = drawableId;
        this.mToOpenerStringId = stringId;
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 180.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(300L);
        rotateAnimation.setInterpolator(SpenSettingUtilAnimation.getInterpolator(11));
        rotateAnimation.setAnimationListener(new AnimationAnimationListenerC75681());
        ImageButton imageButton = this.mOpener;
        if (imageButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOpener");
            imageButton = null;
        }
        imageButton.startAnimation(rotateAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void toggleMode(boolean animation) {
        AbstractC2322a.m1631u(this.mViewMode, "toggleMode() mode=", TAG);
        int i = this.mViewMode == 1 ? 2 : 1;
        updateView(i);
        changeMode(i, animation);
        this.mViewMode = i;
    }

    private final void updateOpenerDrawable(int mode, boolean needAnimation) {
        AbstractC2322a.m1631u(mode, "updateOpenerDrawable() mode=", TAG);
        int i = C7932R.drawable.brush_open;
        int i2 = C7932R.string.pen_string_show_brushes;
        if (mode != 1) {
            if (getResources().getConfiguration().getLayoutDirection() == 0) {
                i = C7932R.drawable.brush_close;
            }
            i2 = C7932R.string.pen_string_hide_brushes;
        } else if (getResources().getConfiguration().getLayoutDirection() == 1) {
            i = C7932R.drawable.brush_close;
        }
        ImageButton imageButton = this.mOpener;
        ImageButton imageButton2 = null;
        if (imageButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOpener");
            imageButton = null;
        }
        Drawable background = imageButton.getBackground();
        ImageButton imageButton3 = this.mOpener;
        if (imageButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOpener");
            imageButton3 = null;
        }
        imageButton3.setBackground(null);
        ImageButton imageButton4 = this.mOpener;
        if (imageButton4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOpener");
        } else {
            imageButton2 = imageButton4;
        }
        imageButton2.setBackground(background);
        if (needAnimation) {
            startOpenerAnimation(i, i2);
        } else {
            updateOpenerResource(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateOpenerResource(int drawableId, int StringId) {
        ImageButton imageButton = this.mOpener;
        ImageButton imageButton2 = null;
        if (imageButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOpener");
            imageButton = null;
        }
        imageButton.setRotation(0.0f);
        ImageButton imageButton3 = this.mOpener;
        if (imageButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOpener");
            imageButton3 = null;
        }
        imageButton3.setImageResource(drawableId);
        ImageButton imageButton4 = this.mOpener;
        if (imageButton4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOpener");
            imageButton4 = null;
        }
        SpenSettingUtilHover.setHoverText(imageButton4, getResources().getString(StringId));
        ImageButton imageButton5 = this.mOpener;
        if (imageButton5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOpener");
        } else {
            imageButton2 = imageButton5;
        }
        imageButton2.setContentDescription(getResources().getString(StringId));
    }

    private final void updatePenItem() {
        SpenBrushPenListLayout spenBrushPenListLayout = this.mPenList;
        SpenBrushPenView spenBrushPenView = null;
        if (spenBrushPenListLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenList");
            spenBrushPenListLayout = null;
        }
        SpenSettingPenResource brushPenViewInfo = spenBrushPenListLayout.getBrushPenViewInfo(this.mCurrentPen);
        if (brushPenViewInfo == null) {
            SpenSettingPenInfo spenSettingPenInfo = new SpenSettingPenInfo();
            String str = this.mCurrentPen;
            if (str == null) {
                str = "";
            }
            spenSettingPenInfo.name = str;
            spenSettingPenInfo.color = this.mCurrentColor;
            SpenBrushPenView spenBrushPenView2 = this.mPenView;
            if (spenBrushPenView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPenView");
                spenBrushPenView2 = null;
            }
            spenBrushPenView2.setPenInfo(spenSettingPenInfo);
        } else {
            SpenBrushPenView spenBrushPenView3 = this.mPenView;
            if (spenBrushPenView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPenView");
                spenBrushPenView3 = null;
            }
            spenBrushPenView3.setPenResourceInfo(brushPenViewInfo);
        }
        SpenBrushPenView spenBrushPenView4 = this.mPenView;
        if (spenBrushPenView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenView");
        } else {
            spenBrushPenView = spenBrushPenView4;
        }
        int i = this.mCurrentColor;
        spenBrushPenView.setPenColor(i, this.mUtilColor.getColorName(i));
        setPenItemSelected(true);
    }

    private final boolean updatePenList() {
        SpenBrushPenListLayout spenBrushPenListLayout = this.mPenList;
        if (spenBrushPenListLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenList");
            spenBrushPenListLayout = null;
        }
        return spenBrushPenListLayout.setPenInfo(this.mCurrentPen, this.mCurrentColor);
    }

    private final void updateView(int mode) {
        if (this.mCurrentPen == null || this.mIsSelected) {
            return;
        }
        setUnselectedPen(mode);
    }

    @Override // com.samsung.android.sdk.pen.setting.drawing.SpenBrushPenLayoutInterface
    public void close() {
        this.mUtilColor.close();
        SpenBrushPenListLayout spenBrushPenListLayout = this.mPenList;
        if (spenBrushPenListLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenList");
            spenBrushPenListLayout = null;
        }
        spenBrushPenListLayout.close();
    }

    @Override // com.samsung.android.sdk.pen.setting.drawing.SpenBrushPenLayoutInterface
    public int getPenCount() {
        SpenBrushPenListLayout spenBrushPenListLayout = this.mPenList;
        if (spenBrushPenListLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenList");
            spenBrushPenListLayout = null;
        }
        return spenBrushPenListLayout.getPenCount();
    }

    @Override // com.samsung.android.sdk.pen.setting.drawing.SpenBrushPenLayoutInterface
    public int getSelectedPenPosition() {
        if (this.mViewMode != 2) {
            return 0;
        }
        SpenBrushPenListLayout spenBrushPenListLayout = this.mPenList;
        if (spenBrushPenListLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenList");
            spenBrushPenListLayout = null;
        }
        return spenBrushPenListLayout.getSelectedPenPosition();
    }

    /* JADX INFO: renamed from: getViewMode, reason: from getter */
    public final int getMViewMode() {
        return this.mViewMode;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        updateOpenerDrawable(this.mViewMode, false);
    }

    @Override // com.samsung.android.sdk.pen.setting.drawing.SpenBrushPenLayoutInterface
    public void setActionListener(@Nullable SpenBrushPenLayoutInterface.OnActionListener listener) {
        this.mActionListener = listener;
    }

    public final void setExpandToSelectPen(boolean isExpandToSelectPen) {
        SpenBrushPenListLayout spenBrushPenListLayout = this.mPenList;
        if (spenBrushPenListLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenList");
            spenBrushPenListLayout = null;
        }
        spenBrushPenListLayout.setExpandToSelectPen(isExpandToSelectPen);
    }

    public final void setPenDegree(int degree) {
        AbstractC2322a.m1631u(degree, "setPenDegree() degree=", TAG);
        ConstraintLayout constraintLayout = this.mPenItemGroup;
        SpenBrushPenListLayout spenBrushPenListLayout = null;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenItemGroup");
            constraintLayout = null;
        }
        float f = degree;
        constraintLayout.setRotationX(f);
        SpenBrushPenListLayout spenBrushPenListLayout2 = this.mPenList;
        if (spenBrushPenListLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenList");
        } else {
            spenBrushPenListLayout = spenBrushPenListLayout2;
        }
        spenBrushPenListLayout.setRotationX(f);
    }

    @Override // com.samsung.android.sdk.pen.setting.drawing.SpenBrushPenLayoutInterface
    public boolean setPenInfo(@Nullable String penName, int color) {
        if (penName != null && StringsKt.m14162r(penName, "Eraser")) {
            setUnselectedPen();
            return false;
        }
        this.mIsSelected = true;
        this.mCurrentPen = penName;
        this.mCurrentColor = color;
        if (this.mViewMode == 1) {
            updatePenItem();
            updatePenList();
            return true;
        }
        updatePenList();
        updatePenItem();
        return true;
    }

    @Override // com.samsung.android.sdk.pen.setting.drawing.SpenBrushPenLayoutInterface
    public void setPenInfoList(@Nullable List<SpenSettingPenInfo> penInfoList) {
        SpenBrushPenListLayout spenBrushPenListLayout = this.mPenList;
        if (spenBrushPenListLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenList");
            spenBrushPenListLayout = null;
        }
        spenBrushPenListLayout.setPenInfoList(penInfoList);
    }

    @Override // com.samsung.android.sdk.pen.setting.drawing.SpenBrushPenLayoutInterface
    public void setPenLayoutRatio(float penLayoutPercentWidth, float penLayoutPercentHeight) {
        SpenBrushPenListLayout spenBrushPenListLayout = this.mPenList;
        SpenBrushPenListLayout spenBrushPenListLayout2 = null;
        if (spenBrushPenListLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenList");
            spenBrushPenListLayout = null;
        }
        ViewGroup.LayoutParams layoutParams = spenBrushPenListLayout.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        float f = ((ConstraintLayout.LayoutParams) layoutParams).matchConstraintPercentWidth;
        SpenBrushPenListLayout spenBrushPenListLayout3 = this.mPenList;
        if (spenBrushPenListLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenList");
        } else {
            spenBrushPenListLayout2 = spenBrushPenListLayout3;
        }
        spenBrushPenListLayout2.setPenLayoutRatio(f * penLayoutPercentWidth, penLayoutPercentHeight);
    }

    @Override // com.samsung.android.sdk.pen.setting.drawing.SpenBrushPenLayoutInterface
    public void setPenList(@Nullable List<String> penNames) {
        SpenBrushPenListLayout spenBrushPenListLayout = this.mPenList;
        SpenBrushPenListLayout spenBrushPenListLayout2 = null;
        if (spenBrushPenListLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenList");
            spenBrushPenListLayout = null;
        }
        spenBrushPenListLayout.setPenList(penNames);
        SpenBrushPenListLayout spenBrushPenListLayout3 = this.mPenList;
        if (spenBrushPenListLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenList");
        } else {
            spenBrushPenListLayout2 = spenBrushPenListLayout3;
        }
        spenBrushPenListLayout2.setScrollBar(false);
    }

    @Override // com.samsung.android.sdk.pen.setting.drawing.SpenBrushPenLayoutInterface
    public void setRoundedBackground(int radius, int bgColor, int strokeSize, int strokeColor) {
        int color = getContext().getResources().getColor(C7932R.color.setting_brush_pen_type_space_bg_color);
        View view = this.mSpaceAniBg;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSpaceAniBg");
            view = null;
        }
        view.setBackground(SpenSettingUtilDrawable.getRoundedCornerDrawable(radius, color, 0, 0));
        View viewFindViewById = this.mTotal.findViewById(C7932R.id.layout_bg);
        if (viewFindViewById != null) {
            SpenSettingUtilDrawable.setRoundedCornerBackground(viewFindViewById, radius, bgColor, strokeSize, strokeColor);
        }
    }

    public final boolean setViewMode(int viewMode) {
        return setViewMode(viewMode, false);
    }

    public final void setViewModeChangeListener(@Nullable OnModeChangeListener listener) {
        this.mModeChangeListener = listener;
    }

    public final void smoothScrollTo(int xPos) {
        SpenBrushPenListLayout spenBrushPenListLayout = this.mPenList;
        if (spenBrushPenListLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenList");
            spenBrushPenListLayout = null;
        }
        spenBrushPenListLayout.smoothScrollTo(xPos);
    }

    public final boolean setViewMode(int viewMode, boolean needAnimation) {
        boolean z = this.mViewMode != viewMode;
        if (z) {
            toggleMode(needAnimation);
        }
        return z;
    }

    @Override // com.samsung.android.sdk.pen.setting.drawing.SpenBrushPenLayoutInterface
    public void setPenList(@Nullable List<String> penNames, @Nullable List<SpenSettingPenResource> resourceInfo) {
        SpenBrushPenListLayout spenBrushPenListLayout = this.mPenList;
        SpenBrushPenListLayout spenBrushPenListLayout2 = null;
        if (spenBrushPenListLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenList");
            spenBrushPenListLayout = null;
        }
        spenBrushPenListLayout.setPenList(penNames, resourceInfo);
        SpenBrushPenListLayout spenBrushPenListLayout3 = this.mPenList;
        if (spenBrushPenListLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenList");
        } else {
            spenBrushPenListLayout2 = spenBrushPenListLayout3;
        }
        spenBrushPenListLayout2.setScrollBar(false);
    }

    @Override // com.samsung.android.sdk.pen.setting.drawing.SpenBrushPenLayoutInterface
    public void setUnselectedPen() {
        this.mCurrentColor = -1;
        this.mIsSelected = false;
        if (getMeasuredWidth() == 0 && getMeasuredHeight() == 0) {
            new Handler().post(new RunnableC7571a(this, 0));
        } else {
            setUnselectedPen(this.mViewMode);
        }
    }
}
