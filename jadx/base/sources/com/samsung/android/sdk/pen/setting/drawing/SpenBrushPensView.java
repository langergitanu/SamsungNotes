package com.samsung.android.sdk.pen.setting.drawing;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.transition.AutoTransition;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Space;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.Guideline;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.carousel.RunnableC4617a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.setting.colorpalette.ViewOnClickListenerC7538b;
import com.samsung.android.sdk.pen.setting.pencommon.SpenPenList;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAnimation;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.request.ImportHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b,\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\b\u0000\u0018\u0000 h2\u00020\u00012\u00020\u0002:\u0001hB\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010+\u001a\u00020,J\u0012\u0010-\u001a\u00020,2\b\u0010.\u001a\u0004\u0018\u00010\fH\u0016J\u0018\u0010/\u001a\u00020,2\u0006\u00100\u001a\u00020\n2\u0006\u00101\u001a\u00020\nH\u0016J\u0010\u00102\u001a\u00020,2\u0006\u00103\u001a\u00020\nH\u0016J\u0010\u00104\u001a\u00020,2\u0006\u00103\u001a\u00020\nH\u0016J\u0012\u00105\u001a\u0004\u0018\u00010\u00182\u0006\u00103\u001a\u00020\nH\u0016J\b\u00106\u001a\u00020\nH\u0016J\b\u00107\u001a\u00020\nH\u0016J\b\u00108\u001a\u00020,H\u0014J&\u00109\u001a\u00020,2\u0006\u0010:\u001a\u00020\n2\u0006\u0010;\u001a\u00020\u00132\u0006\u0010<\u001a\u00020\n2\u0006\u0010=\u001a\u00020\u0013J\u0016\u0010>\u001a\u00020,2\u0006\u0010?\u001a\u00020\u00132\u0006\u0010@\u001a\u00020\u0013J\u000e\u0010A\u001a\u00020,2\u0006\u0010B\u001a\u00020\u0013J\u000e\u0010C\u001a\u00020,2\u0006\u0010D\u001a\u00020\nJ\u000e\u0010E\u001a\u00020,2\u0006\u0010F\u001a\u00020\nJ\u0016\u0010G\u001a\u00020,2\u0006\u0010H\u001a\u00020\u00132\u0006\u0010I\u001a\u00020\u0013J \u0010J\u001a\u00020,2\u0006\u0010K\u001a\u00020\n2\u0006\u0010L\u001a\u00020\u001a2\b\u0010.\u001a\u0004\u0018\u00010\u001cJ\b\u0010M\u001a\u00020,H\u0002J\u0010\u0010N\u001a\u00020,2\u0006\u0010O\u001a\u00020\u0018H\u0002J\b\u0010P\u001a\u00020,H\u0002J \u0010Q\u001a\u00020,2\u0006\u00103\u001a\u00020\n2\u0006\u0010R\u001a\u00020\u001a2\u0006\u0010S\u001a\u00020\u001aH\u0002J \u0010T\u001a\u00020,2\u0006\u0010U\u001a\u00020\u00182\u0006\u0010V\u001a\u00020\u001a2\u0006\u0010W\u001a\u00020\u001aH\u0002J\u0010\u0010X\u001a\u00020,2\u0006\u0010O\u001a\u00020YH\u0002J(\u0010Z\u001a\u00020,2\u0006\u0010[\u001a\u00020\n2\u0006\u0010\\\u001a\u00020\n2\u0006\u0010]\u001a\u00020\n2\u0006\u0010^\u001a\u00020\nH\u0014J\u0014\u0010_\u001a\u0004\u0018\u00010`2\b\u0010O\u001a\u0004\u0018\u00010\u0018H\u0002J\u0012\u0010a\u001a\u00020\u00132\b\u0010O\u001a\u0004\u0018\u00010\u0018H\u0002J\b\u0010e\u001a\u00020\nH\u0002J\b\u0010f\u001a\u00020,H\u0002J\b\u0010g\u001a\u00020,H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010b\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bc\u0010d¨\u0006i"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/drawing/SpenBrushPensView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/samsung/android/sdk/pen/setting/pencommon/SpenPenList;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "MAX_BRUSH_COUNT_WITHOUT_SCROLL_DEFAULT", "", "mOnItemClickListener", "Lcom/samsung/android/sdk/pen/setting/pencommon/SpenPenList$OnItemClickListener;", "mContext", "mChainStyle", "mGuideType", "mSelectedGuideId", "mUnSelectedGuideId", "mSelectedGuideValue", "", "mUnselectedGuideValue", "mSelectedIndex", "mChildren", "", "Landroid/view/View;", "mExpended", "", "mAnimationListener", "Landroid/view/animation/Animation$AnimationListener;", "mAnimateView", "mAniTargetIdx", "mLayoutPercentWidth", "mLayoutPercentHeight", "mStartGuidePercent", "mEndGuidePercent", "mSpacePercent", "mSupportScrollPenCount", "mPenViewGlobalLayoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "mTransitionListener", "Landroid/transition/Transition$TransitionListener;", "mPenClickListener", "Landroid/view/View$OnClickListener;", "close", "", "setOnItemClickListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setPenList", ImportHandler.KEY_TOTAL, "childLayoutId", "selectPen", "index", "unSelectPen", "getPenView", "getSelectPenIndex", "getPenCount", "onFinishInflate", "setSelectedGuideInfo", "selectedId", "selectPercent", "unselectedId", "unselectedPercent", "setMarginGuideInfo", "startGuidePercent", "endGuidePercent", "setBetweenPenMarginPercent", "betweenPenWidthPercent", "setSupportScrollPenCount", "maxBrushWithoutScroll", "setPenViewChainStyle", "style", "setLayoutRatio", "layoutPercentWidth", "layoutPercentHeight", "setPenAnimation", "targetIdx", "expended", "init", "addChild", "penView", "updateChildList", "updateSelectedPenView", "isSelected", "needAnimation", "updateSelected", "child", "selected", "hasAnimation", "setPenAutoAnimation", "Landroid/view/ViewGroup;", "onSizeChanged", "w", "h", "oldw", "oldh", "getItemDimensionRatio", "", "getSpaceWidthPercent", "layoutVisibleAreaWidth", "getLayoutVisibleAreaWidth", "()I", "calculatorOffset", "setContractAnimation", "setExpandAnimation", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenBrushPensView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenBrushPensView.kt\ncom/samsung/android/sdk/pen/setting/drawing/SpenBrushPensView\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,566:1\n1#2:567\n*E\n"})
public final class SpenBrushPensView extends ConstraintLayout implements SpenPenList {
    private static final int ANI_CONTRACT_ALPHA_DURATION = 100;
    private static final int ANI_CONTRACT_TRANS_DURATION = 450;
    private static final int ANI_EXPAND_ALPHA_DURATION = 200;
    private static final int ANI_EXPAND_MOVE_DURATION = 450;
    private static final int ANI_PEN_CHANGE_DURATION = 400;
    private static final int GUIDE_TYPE_MARGIN = 1;
    private static final int GUIDE_TYPE_NONE = 0;
    private static final int GUIDE_TYPE_PERCENT = 2;

    @NotNull
    private static final String TAG = "SpenBrushPensView";
    private final int MAX_BRUSH_COUNT_WITHOUT_SCROLL_DEFAULT;
    private int mAniTargetIdx;

    @Nullable
    private View mAnimateView;

    @Nullable
    private Animation.AnimationListener mAnimationListener;
    private int mChainStyle;

    @Nullable
    private List<View> mChildren;

    @NotNull
    private Context mContext;
    private float mEndGuidePercent;
    private boolean mExpended;
    private int mGuideType;
    private float mLayoutPercentHeight;
    private float mLayoutPercentWidth;

    @Nullable
    private SpenPenList.OnItemClickListener mOnItemClickListener;

    @NotNull
    private final View.OnClickListener mPenClickListener;

    @NotNull
    private final ViewTreeObserver.OnGlobalLayoutListener mPenViewGlobalLayoutListener;
    private int mSelectedGuideId;
    private float mSelectedGuideValue;
    private int mSelectedIndex;
    private float mSpacePercent;
    private float mStartGuidePercent;
    private int mSupportScrollPenCount;

    @NotNull
    private final Transition.TransitionListener mTransitionListener;
    private int mUnSelectedGuideId;
    private float mUnselectedGuideValue;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenBrushPensView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.MAX_BRUSH_COUNT_WITHOUT_SCROLL_DEFAULT = 9;
        this.mPenViewGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.samsung.android.sdk.pen.setting.drawing.SpenBrushPensView$mPenViewGlobalLayoutListener$1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                ViewTreeObserver viewTreeObserver;
                Log.d("SpenBrushPensView", "onGlobalLayout() aniTarget=" + this.this$0.mAniTargetIdx + " expended=" + this.this$0.mExpended);
                if (this.this$0.mAnimateView != null) {
                    View view = this.this$0.mAnimateView;
                    if (view != null && (viewTreeObserver = view.getViewTreeObserver()) != null) {
                        viewTreeObserver.removeOnGlobalLayoutListener(this);
                    }
                    this.this$0.mAnimateView = null;
                    SpenBrushPensView spenBrushPensView = this.this$0;
                    spenBrushPensView.setPenAnimation(spenBrushPensView.mAniTargetIdx, this.this$0.mExpended, this.this$0.mAnimationListener);
                }
            }
        };
        this.mTransitionListener = new Transition.TransitionListener() { // from class: com.samsung.android.sdk.pen.setting.drawing.SpenBrushPensView$mTransitionListener$1
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
        this.mPenClickListener = new ViewOnClickListenerC7538b(this, 10);
        Log.i(TAG, TAG);
        this.mContext = context;
        init();
    }

    private final void addChild(View penView) {
        if (this.mChildren == null) {
            this.mChildren = new ArrayList();
        }
        List<View> list = this.mChildren;
        if (list != null) {
            list.add(penView);
        }
    }

    private final int calculatorOffset() {
        boolean z = AbstractC0541b.m759a(this.mContext) == 1;
        Rect rect = new Rect();
        getLocalVisibleRect(rect);
        boolean z2 = ((int) Math.abs((double) (rect.right - rect.left))) < ((int) Math.abs((double) (rect.top - rect.bottom)));
        int i = rect.left;
        if (z2) {
            return (int) Math.abs(!z ? rect.bottom : rect.top);
        }
        return i;
    }

    private final String getItemDimensionRatio(View penView) {
        if (Float.compare(this.mLayoutPercentWidth, 0.0f) == 0 || Float.compare(this.mLayoutPercentHeight, 0.0f) == 0 || penView == null) {
            return null;
        }
        ViewGroup.LayoutParams layoutParams = penView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        float f = ((ConstraintLayout.LayoutParams) layoutParams).matchConstraintPercentWidth;
        ViewGroup.LayoutParams layoutParams2 = penView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        float f4 = ((ConstraintLayout.LayoutParams) layoutParams2).matchConstraintPercentHeight;
        String str = "W," + (this.mLayoutPercentWidth * f) + ":" + (this.mLayoutPercentHeight * f4);
        AbstractC6670b.m4756q("getItemDimensionRatio: ", str, TAG);
        return str;
    }

    private final int getLayoutVisibleAreaWidth() {
        getLocalVisibleRect(new Rect());
        int iAbs = (int) Math.abs(r0.right - r0.left);
        int iAbs2 = (int) Math.abs(r0.top - r0.bottom);
        return iAbs < iAbs2 ? iAbs2 : iAbs;
    }

    private final float getSpaceWidthPercent(View penView) {
        float f = this.mSpacePercent;
        double d = f;
        if (0.0d <= d && d <= 1.0d) {
            return f;
        }
        if (penView == null) {
            return 0.0f;
        }
        ViewGroup.LayoutParams layoutParams = penView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        float f4 = ((ConstraintLayout.LayoutParams) layoutParams).matchConstraintPercentWidth;
        float f5 = ((this.mEndGuidePercent - this.mStartGuidePercent) - (this.mSupportScrollPenCount * f4)) / (r1 - 1);
        AbstractC4539a.m3205o("getSpaceWidthPercent: spacePercent= ", TAG, f5);
        return f5;
    }

    private final void init() {
        this.mChainStyle = 1;
        this.mGuideType = 0;
        this.mSelectedGuideId = 0;
        this.mUnSelectedGuideId = 0;
        this.mSelectedGuideValue = 0.0f;
        this.mUnselectedGuideValue = 0.0f;
        this.mSelectedIndex = -1;
        this.mSupportScrollPenCount = this.MAX_BRUSH_COUNT_WITHOUT_SCROLL_DEFAULT;
        this.mLayoutPercentWidth = 1.0f;
        this.mLayoutPercentHeight = 1.0f;
        this.mSpacePercent = -1.0f;
        this.mStartGuidePercent = 0.0f;
        Guideline guideline = (Guideline) findViewById(C7932R.id.pen_list_start);
        if (guideline != null) {
            ViewGroup.LayoutParams layoutParams = guideline.getLayoutParams();
            ConstraintLayout.LayoutParams layoutParams2 = layoutParams instanceof ConstraintLayout.LayoutParams ? (ConstraintLayout.LayoutParams) layoutParams : null;
            if (layoutParams2 != null) {
                this.mStartGuidePercent = layoutParams2.guidePercent;
            }
        }
        this.mEndGuidePercent = 1.0f;
        Guideline guideline2 = (Guideline) findViewById(C7932R.id.pen_list_end);
        if (guideline2 != null) {
            ViewGroup.LayoutParams layoutParams3 = guideline2.getLayoutParams();
            ConstraintLayout.LayoutParams layoutParams4 = layoutParams3 instanceof ConstraintLayout.LayoutParams ? (ConstraintLayout.LayoutParams) layoutParams3 : null;
            if (layoutParams4 != null) {
                this.mEndGuidePercent = layoutParams4.guidePercent;
            }
        }
        this.mExpended = false;
        this.mAniTargetIdx = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mPenClickListener$lambda$1(SpenBrushPensView spenBrushPensView, View view) {
        SpenPenList.OnItemClickListener onItemClickListener;
        List<View> list = spenBrushPensView.mChildren;
        if (list == null || (onItemClickListener = spenBrushPensView.mOnItemClickListener) == null) {
            return;
        }
        Intrinsics.checkNotNull(view);
        onItemClickListener.onItemClick(view, list.indexOf(view));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onSizeChanged$lambda$7(SpenBrushPensView spenBrushPensView) {
        Log.i(TAG, "updateChild in onSizeChanged()");
        int i = spenBrushPensView.mSelectedIndex;
        if (i > -1) {
            spenBrushPensView.updateSelectedPenView(i, true, false);
        }
    }

    private final void setContractAnimation() {
        int i;
        boolean z;
        float f = 0.0f;
        PathInterpolator pathInterpolator = new PathInterpolator(0.4f, 0.6f, 0.0f, 1.0f);
        boolean z2 = false;
        boolean z3 = true;
        boolean z4 = AbstractC0541b.m759a(this.mContext) == 1;
        int layoutVisibleAreaWidth = getLayoutVisibleAreaWidth();
        int iCalculatorOffset = calculatorOffset();
        int penCount = getPenCount();
        int i2 = 0;
        while (i2 < penCount) {
            AnimationSet animationSet = new AnimationSet(z2);
            final View penView = getPenView(i2);
            if (penView == null) {
                z = z3;
                i = layoutVisibleAreaWidth;
            } else {
                TranslateAnimation translateAnimation = new TranslateAnimation(f, !z4 ? iCalculatorOffset - penView.getLeft() : (iCalculatorOffset + layoutVisibleAreaWidth) - penView.getRight(), f, f);
                i = layoutVisibleAreaWidth;
                translateAnimation.setDuration(450L);
                translateAnimation.setInterpolator(pathInterpolator);
                animationSet.addAnimation(translateAnimation);
                if (this.mAniTargetIdx != i2) {
                    AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, f);
                    alphaAnimation.setDuration(100L);
                    alphaAnimation.setInterpolator(new LinearInterpolator());
                    z = true;
                    alphaAnimation.setFillAfter(true);
                    animationSet.addAnimation(alphaAnimation);
                } else {
                    z = true;
                }
                translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.samsung.android.sdk.pen.setting.drawing.SpenBrushPensView.setContractAnimation.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        Intrinsics.checkNotNullParameter(animation, "animation");
                        Animation.AnimationListener animationListener = SpenBrushPensView.this.mAnimationListener;
                        if (animationListener != null) {
                            animationListener.onAnimationEnd(animation);
                        }
                        penView.setClickable(true);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                        Intrinsics.checkNotNullParameter(animation, "animation");
                        Animation.AnimationListener animationListener = SpenBrushPensView.this.mAnimationListener;
                        if (animationListener != null) {
                            animationListener.onAnimationRepeat(animation);
                        }
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                        Intrinsics.checkNotNullParameter(animation, "animation");
                        Animation.AnimationListener animationListener = SpenBrushPensView.this.mAnimationListener;
                        if (animationListener != null) {
                            animationListener.onAnimationStart(animation);
                        }
                        penView.setClickable(false);
                    }
                });
                penView.startAnimation(animationSet);
            }
            i2++;
            z3 = z;
            layoutVisibleAreaWidth = i;
            z2 = false;
            f = 0.0f;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0042 A[PHI: r11
      0x0042: PHI (r11v8 int) = (r11v1 int), (r11v10 int) binds: [B:17:0x0052, B:13:0x0040] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0044 A[PHI: r11
      0x0044: PHI (r11v2 int) = (r11v1 int), (r11v10 int) binds: [B:17:0x0052, B:13:0x0040] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void setExpandAnimation() {
        int right;
        boolean z;
        AnimationSet animationSet;
        float f = 0.0f;
        PathInterpolator pathInterpolator = new PathInterpolator(0.4f, 0.6f, 0.0f, 1.0f);
        boolean z2 = false;
        boolean z3 = AbstractC0541b.m759a(this.mContext) == 1;
        int layoutVisibleAreaWidth = getLayoutVisibleAreaWidth();
        int iCalculatorOffset = calculatorOffset();
        int penCount = getPenCount();
        int i = 0;
        while (i < penCount) {
            final View penView = getPenView(i);
            if (penView != null) {
                if (z3) {
                    right = (iCalculatorOffset + layoutVisibleAreaWidth) - penView.getRight();
                    if (penView.getWidth() + right <= 0) {
                    }
                } else {
                    right = iCalculatorOffset - penView.getLeft();
                    z = right - penView.getWidth() >= 0 ? z2 : true;
                }
                if (z) {
                    AnimationSet animationSet2 = new AnimationSet(z2);
                    TranslateAnimation translateAnimation = new TranslateAnimation(right, f, f, f);
                    translateAnimation.setDuration(450L);
                    translateAnimation.setInterpolator(pathInterpolator);
                    translateAnimation.setFillAfter(true);
                    animationSet2.addAnimation(translateAnimation);
                    if (this.mAniTargetIdx != i) {
                        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                        animationSet = animationSet2;
                        alphaAnimation.setDuration(200L);
                        alphaAnimation.setInterpolator(new LinearInterpolator());
                        alphaAnimation.setFillAfter(true);
                        animationSet.addAnimation(alphaAnimation);
                    } else {
                        animationSet = animationSet2;
                        penView.setAlpha(1.0f);
                    }
                    translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.samsung.android.sdk.pen.setting.drawing.SpenBrushPensView.setExpandAnimation.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            Intrinsics.checkNotNullParameter(animation, "animation");
                            Animation.AnimationListener animationListener = SpenBrushPensView.this.mAnimationListener;
                            if (animationListener != null) {
                                animationListener.onAnimationEnd(animation);
                            }
                            penView.setClickable(true);
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                            Intrinsics.checkNotNullParameter(animation, "animation");
                            Animation.AnimationListener animationListener = SpenBrushPensView.this.mAnimationListener;
                            if (animationListener != null) {
                                animationListener.onAnimationRepeat(animation);
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                            Intrinsics.checkNotNullParameter(animation, "animation");
                            Animation.AnimationListener animationListener = SpenBrushPensView.this.mAnimationListener;
                            if (animationListener != null) {
                                animationListener.onAnimationStart(animation);
                            }
                            penView.setClickable(false);
                        }
                    });
                    penView.startAnimation(animationSet);
                }
            }
            i++;
            z2 = false;
            f = 0.0f;
        }
    }

    private final void setPenAutoAnimation(ViewGroup penView) {
        AutoTransition autoTransition = new AutoTransition();
        autoTransition.setInterpolator((TimeInterpolator) SpenSettingUtilAnimation.getInterpolator(11));
        autoTransition.setDuration(400L);
        autoTransition.addListener(this.mTransitionListener);
        TransitionManager.beginDelayedTransition(penView, autoTransition);
    }

    private final void updateChildList() {
        List<View> list = this.mChildren;
        Object objValueOf = null;
        Log.i(TAG, "[BEFORE] updatechildList() mChild=" + (list == null ? "" : list != null ? Integer.valueOf(list.size()) : null));
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (!(childAt instanceof Guideline) && !(childAt instanceof Space)) {
                Intrinsics.checkNotNull(childAt);
                addChild(childAt);
            }
        }
        List<View> list2 = this.mChildren;
        if (list2 == null) {
            objValueOf = "";
        } else if (list2 != null) {
            objValueOf = Integer.valueOf(list2.size());
        }
        Log.i(TAG, "[BEFORE] updatechildList() mChild=" + objValueOf);
    }

    private final void updateSelected(View child, boolean selected, boolean hasAnimation) {
        if (this.mGuideType == 0) {
            return;
        }
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this);
        if (selected) {
            constraintSet.connect(child.getId(), 3, this.mSelectedGuideId, 3);
        } else {
            constraintSet.connect(child.getId(), 3, this.mUnSelectedGuideId, 3);
        }
        constraintSet.applyTo(this);
        if (hasAnimation) {
            Intrinsics.checkNotNull(child, "null cannot be cast to non-null type android.view.ViewGroup");
            setPenAutoAnimation((ViewGroup) child);
        }
    }

    private final void updateSelectedPenView(int index, boolean isSelected, boolean needAnimation) {
        View penView = getPenView(index);
        if (penView != null) {
            updateSelected(penView, isSelected, needAnimation);
            ((SpenBrushPenView) penView).setSelected(isSelected, needAnimation);
        }
    }

    public final void close() {
        ViewTreeObserver viewTreeObserver;
        this.mAnimationListener = null;
        View view = this.mAnimateView;
        if (view != null && (viewTreeObserver = view.getViewTreeObserver()) != null) {
            viewTreeObserver.removeOnGlobalLayoutListener(this.mPenViewGlobalLayoutListener);
        }
        this.mAnimateView = null;
        List<View> list = this.mChildren;
        if (list != null && list.size() > 0) {
            Iterator<View> it = list.iterator();
            while (it.hasNext()) {
                removeView(it.next());
            }
            list.clear();
        }
        this.mChildren = null;
    }

    @Override // com.samsung.android.sdk.pen.setting.pencommon.SpenPenList
    public int getPenCount() {
        List<View> list = this.mChildren;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // com.samsung.android.sdk.pen.setting.pencommon.SpenPenList
    @Nullable
    public View getPenView(int index) {
        List<View> list = this.mChildren;
        if (list == null || list.size() <= index || index < 0) {
            return null;
        }
        return list.get(index);
    }

    @Override // com.samsung.android.sdk.pen.setting.pencommon.SpenPenList
    /* JADX INFO: renamed from: getSelectPenIndex, reason: from getter */
    public int getMSelectedIndex() {
        return this.mSelectedIndex;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        AbstractC2322a.m1631u(getChildCount(), "3. onFinishInflate() childCont=", TAG);
        if (this.mChildren != null || getChildCount() <= 0) {
            return;
        }
        updateChildList();
    }

    @Override // android.view.View
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (oldw == 0 && oldh == 0 && this.mSelectedIndex > -1) {
            new Handler().postDelayed(new RunnableC4617a(this, 27), 10L);
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.pencommon.SpenPenList
    public void selectPen(int index) {
        List<View> list = this.mChildren;
        if (list == null || this.mSelectedIndex == index || list.size() <= index || index < 0) {
            return;
        }
        updateSelectedPenView(this.mSelectedIndex, false, isShown());
        updateSelectedPenView(index, true, isShown());
        this.mSelectedIndex = index;
    }

    public final void setBetweenPenMarginPercent(float betweenPenWidthPercent) {
        this.mSpacePercent = betweenPenWidthPercent;
    }

    public final void setLayoutRatio(float layoutPercentWidth, float layoutPercentHeight) {
        this.mLayoutPercentWidth = layoutPercentWidth;
        this.mLayoutPercentHeight = layoutPercentHeight;
    }

    public final void setMarginGuideInfo(float startGuidePercent, float endGuidePercent) {
        this.mStartGuidePercent = startGuidePercent;
        this.mEndGuidePercent = endGuidePercent;
    }

    @Override // com.samsung.android.sdk.pen.setting.pencommon.SpenPenList
    public void setOnItemClickListener(@Nullable SpenPenList.OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
        List<View> list = this.mChildren;
        if (list != null) {
            Iterator<View> it = list.iterator();
            while (it.hasNext()) {
                it.next().setOnClickListener(listener != null ? this.mPenClickListener : null);
            }
        }
    }

    public final void setPenAnimation(int targetIdx, boolean expended, @Nullable Animation.AnimationListener listener) {
        View penView;
        this.mAnimationListener = listener;
        this.mAniTargetIdx = targetIdx;
        if (targetIdx == -1 || (penView = getPenView(targetIdx)) == null || penView.getWidth() != 0) {
            if (expended) {
                setExpandAnimation();
                return;
            } else {
                setContractAnimation();
                return;
            }
        }
        if (this.mAnimateView == null) {
            this.mAnimateView = penView;
            this.mExpended = expended;
            this.mAnimationListener = listener;
            penView.getViewTreeObserver().addOnGlobalLayoutListener(this.mPenViewGlobalLayoutListener);
            return;
        }
        Log.d(TAG, "++++++ onGlobalLayout() already Registered. targetIdx=" + targetIdx + " expended=" + expended);
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x0195 A[LOOP:3: B:49:0x0193->B:50:0x0195, LOOP_END] */
    @Override // com.samsung.android.sdk.pen.setting.pencommon.SpenPenList
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setPenList(int total, int childLayoutId) {
        int i;
        int i2;
        if (total < 1) {
            return;
        }
        Log.i(TAG, " setPenList()");
        Object systemService = this.mContext.getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        LayoutInflater layoutInflater = (LayoutInflater) systemService;
        int[] iArr = new int[total];
        int i4 = 0;
        String itemDimensionRatio = null;
        for (int i5 = 0; i5 < total; i5++) {
            int iGenerateViewId = View.generateViewId();
            View viewInflate = layoutInflater.inflate(childLayoutId, (ViewGroup) this, false);
            if (itemDimensionRatio == null) {
                itemDimensionRatio = getItemDimensionRatio(viewInflate);
            }
            if (itemDimensionRatio != null) {
                ViewGroup.LayoutParams layoutParams = viewInflate.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ((ConstraintLayout.LayoutParams) layoutParams).dimensionRatio = itemDimensionRatio;
            }
            viewInflate.setId(iGenerateViewId);
            iArr[i5] = iGenerateViewId;
            addView(viewInflate);
            Intrinsics.checkNotNull(viewInflate);
            addChild(viewInflate);
        }
        if (this.mGuideType != 0) {
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone(this);
            constraintSet.create(this.mUnSelectedGuideId, 0);
            constraintSet.create(this.mSelectedGuideId, 0);
            if (this.mGuideType == 1) {
                constraintSet.setGuidelineBegin(this.mUnSelectedGuideId, (int) this.mUnselectedGuideValue);
                constraintSet.setGuidelineBegin(this.mSelectedGuideId, (int) this.mSelectedGuideValue);
            } else {
                constraintSet.setGuidelinePercent(this.mUnSelectedGuideId, this.mUnselectedGuideValue);
                constraintSet.setGuidelinePercent(this.mSelectedGuideId, this.mSelectedGuideValue);
            }
            if (total > this.mSupportScrollPenCount) {
                constraintSet.setGuidelinePercent(C7932R.id.pen_list_start, 0.0f);
                float f = 1.0f;
                constraintSet.setGuidelinePercent(C7932R.id.pen_list_end, 1.0f);
                List<View> list = this.mChildren;
                float spaceWidthPercent = getSpaceWidthPercent(list != null ? list.get(0) : null);
                float f4 = 100000;
                int i6 = (int) (this.mSelectedGuideValue * this.mLayoutPercentHeight * f4);
                int i7 = total * 2;
                int i8 = i7 + 1;
                int[] iArr2 = new int[i8];
                int i9 = total + 1;
                int i10 = 0;
                while (i10 < i9) {
                    int iGenerateViewId2 = View.generateViewId();
                    float f5 = f;
                    Space space = new Space(this.mContext);
                    space.setId(iGenerateViewId2);
                    addView(space, new ConstraintLayout.LayoutParams(i4, i4));
                    constraintSet.setDimensionRatio(iGenerateViewId2, "W," + ((int) ((i10 == 0 ? this.mStartGuidePercent : i10 == total ? f5 - this.mEndGuidePercent : spaceWidthPercent) * this.mLayoutPercentWidth * f4)) + ":" + i6);
                    constraintSet.constrainPercentHeight(iGenerateViewId2, this.mSelectedGuideValue);
                    constraintSet.connect(iGenerateViewId2, 4, 0, 4);
                    int i11 = i10 * 2;
                    iArr2[i11] = iGenerateViewId2;
                    if (i10 == total) {
                        break;
                    }
                    iArr2[i11 + 1] = iArr[i10];
                    i10++;
                    f = f5;
                    i4 = 0;
                }
                for (int i12 = 0; i12 < i8; i12++) {
                    if (i12 == 0) {
                        constraintSet.connect(iArr2[i12], 6, C7932R.id.pen_list_start, 6, 0);
                    } else {
                        constraintSet.connect(iArr2[i12], 6, iArr2[i12 - 1], 7, 0);
                    }
                    if (i12 == i7) {
                        constraintSet.connect(iArr2[i12], 7, C7932R.id.pen_list_end, 7, 0);
                    } else {
                        constraintSet.connect(iArr2[i12], 7, iArr2[i12 + 1], 6, 0);
                    }
                }
            } else {
                if (total <= 1) {
                    i = 0;
                    constraintSet.connect(iArr[0], 6, C7932R.id.pen_list_start, 6, 0);
                    constraintSet.connect(iArr[0], 7, C7932R.id.pen_list_end, 7, 0);
                    for (i2 = i; i2 < total; i2++) {
                        constraintSet.connect(iArr[i2], 3, this.mUnSelectedGuideId, 3);
                    }
                    constraintSet.applyTo(this);
                }
                constraintSet.createHorizontalChainRtl(C7932R.id.pen_list_start, 6, C7932R.id.pen_list_end, 7, iArr, null, this.mChainStyle);
            }
            i = 0;
            while (i2 < total) {
            }
            constraintSet.applyTo(this);
        }
    }

    public final void setPenViewChainStyle(int style) {
        if (style == 0 || style == 1 || style == 2) {
            this.mChainStyle = style;
        }
    }

    public final void setSelectedGuideInfo(int selectedId, float selectPercent, int unselectedId, float unselectedPercent) {
        this.mGuideType = 2;
        this.mSelectedGuideId = selectedId;
        this.mSelectedGuideValue = selectPercent;
        this.mUnSelectedGuideId = unselectedId;
        this.mUnselectedGuideValue = unselectedPercent;
    }

    public final void setSupportScrollPenCount(int maxBrushWithoutScroll) {
        this.mSupportScrollPenCount = maxBrushWithoutScroll;
    }

    @Override // com.samsung.android.sdk.pen.setting.pencommon.SpenPenList
    public void unSelectPen(int index) {
        int i;
        List<View> list = this.mChildren;
        if (list == null || (i = this.mSelectedIndex) <= -1 || i != index || list.size() <= index) {
            return;
        }
        updateSelectedPenView(this.mSelectedIndex, false, true);
        this.mSelectedIndex = -1;
    }
}
