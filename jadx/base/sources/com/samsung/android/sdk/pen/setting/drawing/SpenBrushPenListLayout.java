package com.samsung.android.sdk.pen.setting.drawing;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.PathInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.SpenSettingPenInfo;
import com.samsung.android.sdk.pen.setting.common.SettingViewLongClickListener;
import com.samsung.android.sdk.pen.setting.common.SpenConsumedListener;
import com.samsung.android.sdk.pen.setting.common.SpenLongClickControl;
import com.samsung.android.sdk.pen.setting.drawing.SpenBrushPenLayoutInterface;
import com.samsung.android.sdk.pen.setting.pencommon.SpenPenListControl;
import com.samsung.android.sdk.pen.setting.pencommon.SpenSettingPenResource;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilDrawable;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.request.ImportHandler;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 m2\u00020\u00012\u00020\u0002:\u0001mB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tJ\b\u0010\"\u001a\u00020#H\u0016J(\u0010$\u001a\u00020#2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010&2\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010&H\u0016J\u0018\u0010)\u001a\u00020#2\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010+H\u0016J\u0018\u0010$\u001a\u00020#2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010&H\u0016J\u001a\u0010-\u001a\u00020!2\b\u0010.\u001a\u0004\u0018\u00010\u00182\u0006\u0010/\u001a\u00020\u000bH\u0016J\u0012\u00100\u001a\u00020#2\b\u00101\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u00102\u001a\u00020#H\u0016J\u000e\u00103\u001a\u00020#2\u0006\u00104\u001a\u00020!J\b\u00105\u001a\u00020\u000bH\u0016J\b\u00106\u001a\u00020\u000bH\u0016J\u0016\u0010:\u001a\u00020#2\u0006\u0010;\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020!J\u000e\u0010A\u001a\u00020#2\u0006\u0010B\u001a\u00020\u000bJ\u000e\u0010C\u001a\u00020#2\u0006\u0010D\u001a\u00020!J\u0010\u0010E\u001a\u00020#2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0010\u0010F\u001a\u00020#2\u0006\u0010G\u001a\u00020\u000bH\u0002J\u001a\u0010H\u001a\u00020!2\b\u0010.\u001a\u0004\u0018\u00010\u00182\u0006\u0010I\u001a\u00020!H\u0002J0\u0010J\u001a\u00020#2\u0006\u0010K\u001a\u00020!2\u0006\u0010L\u001a\u00020\u000b2\u0006\u0010M\u001a\u00020\u000b2\u0006\u0010N\u001a\u00020\u000b2\u0006\u0010O\u001a\u00020\u000bH\u0014J\u0012\u0010P\u001a\u0004\u0018\u00010(2\b\u0010.\u001a\u0004\u0018\u00010\u0018J\u0010\u0010S\u001a\u00020#2\b\u00101\u001a\u0004\u0018\u00010TJ\u0010\u0010U\u001a\u00020!2\u0006\u0010V\u001a\u00020WH\u0016J\u0010\u0010X\u001a\u00020!2\u0006\u0010Y\u001a\u00020WH\u0016J(\u0010Z\u001a\u00020#2\u0006\u0010[\u001a\u00020\u000b2\u0006\u0010\\\u001a\u00020\u000b2\u0006\u0010]\u001a\u00020\u000b2\u0006\u0010^\u001a\u00020\u000bH\u0016J\u0018\u0010_\u001a\u00020#2\u0006\u0010`\u001a\u00020\u001c2\u0006\u0010a\u001a\u00020\u001cH\u0016J\u0010\u0010b\u001a\u00020#2\u0006\u0010c\u001a\u00020!H\u0002J\u0010\u0010f\u001a\u00020#2\u0006\u0010;\u001a\u00020\u000bH\u0002J\b\u0010g\u001a\u00020#H\u0002J\b\u0010h\u001a\u00020#H\u0002J\"\u0010i\u001a\u00020#2\b\u0010j\u001a\u0004\u0018\u00010\u00182\u0006\u0010k\u001a\u00020!2\b\u00101\u001a\u0004\u0018\u00010lR\u000e\u0010\n\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0001X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u00107\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\b8\u00109R\u0011\u0010=\u001a\u00020>8F¢\u0006\u0006\u001a\u0004\b?\u0010@R\u0010\u0010Q\u001a\u0004\u0018\u00010RX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006n"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/drawing/SpenBrushPenListLayout;", "Landroid/widget/FrameLayout;", "Lcom/samsung/android/sdk/pen/setting/drawing/SpenBrushPenLayoutInterface;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "MAX_BRUSH_COUNT_WITHOUT_SCROLL", "", "mBrushList", "Lcom/samsung/android/sdk/pen/setting/drawing/SpenBrushPensView;", "mParent", "mScrollManager", "Lcom/samsung/android/sdk/pen/setting/drawing/SpenBrushScrollManager;", "mConsumedListener", "Lcom/samsung/android/sdk/pen/setting/common/SpenConsumedListener;", "mBrushControl", "Lcom/samsung/android/sdk/pen/setting/pencommon/SpenPenListControl;", "mActionListener", "Lcom/samsung/android/sdk/pen/setting/drawing/SpenBrushPenLayoutInterface$OnActionListener;", "mTargetPenName", "", "mLayoutID", "mItemID", "mSelectPercent", "", "mUnSelectPercent", "mStartGuidePercent", "mEndGuidePercent", "mIsExpandToSelectPen", "", "close", "", "setPenList", "penNames", "", "viewInfo", "Lcom/samsung/android/sdk/pen/setting/pencommon/SpenSettingPenResource;", "setPenInfoList", "penInfoList", "", "Lcom/samsung/android/sdk/pen/SpenSettingPenInfo;", "setPenInfo", "penName", "color", "setActionListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setUnselectedPen", "setExpandToSelectPen", "isExpandToSelectPen", "getPenCount", "getSelectedPenPosition", "penDegree", "getPenDegree", "()F", "setPenDegree", "degree", "animationIfChange", "selectedPenCenter", "Landroid/graphics/Point;", "getSelectedPenCenter", "()Landroid/graphics/Point;", "smoothScrollTo", "xPos", "setScrollBar", "enable", "construct", "adjustLayout", ImportHandler.KEY_TOTAL, "updateChildPosition", "isSmoothScroll", "onLayout", "changed", "left", "top", "right", "bottom", "getBrushPenViewInfo", "mLongClickControl", "Lcom/samsung/android/sdk/pen/setting/common/SpenLongClickControl;", "setSettingViewLongClickListener", "Lcom/samsung/android/sdk/pen/setting/common/SettingViewLongClickListener;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "dispatchTouchEvent", "ev", "setRoundedBackground", "radius", "bgColor", "strokeSize", "strokeColor", "setPenLayoutRatio", "penPercentWidth", "penPercentHeight", "prohibitTooltipText", "prohibit", "mDegree", "mTransAlpha", "setPenDegreeWithAni", "setBeforeAnimation", "setAfterAnimation", "setPenAnimation", "selectPenName", "expended", "Landroid/view/animation/Animation$AnimationListener;", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenBrushPenListLayout extends FrameLayout implements SpenBrushPenLayoutInterface {

    @NotNull
    private static final String TAG = "SpenBrushPenListLayout";
    private final int MAX_BRUSH_COUNT_WITHOUT_SCROLL;

    @Nullable
    private SpenBrushPenLayoutInterface.OnActionListener mActionListener;
    private SpenPenListControl mBrushControl;
    private SpenBrushPensView mBrushList;
    private SpenConsumedListener mConsumedListener;
    private int mDegree;
    private float mEndGuidePercent;
    private boolean mIsExpandToSelectPen;
    private int mItemID;
    private int mLayoutID;

    @Nullable
    private SpenLongClickControl mLongClickControl;
    private FrameLayout mParent;
    private SpenBrushScrollManager mScrollManager;
    private float mSelectPercent;
    private float mStartGuidePercent;

    @Nullable
    private String mTargetPenName;
    private float mTransAlpha;
    private float mUnSelectPercent;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenBrushPenListLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.MAX_BRUSH_COUNT_WITHOUT_SCROLL = 9;
        this.mLayoutID = C7932R.layout.setting_brush_pen_list_tablet;
        this.mItemID = C7932R.layout.setting_brush_pen_list_item_tablet;
        this.mSelectPercent = 0.1241f;
        this.mUnSelectPercent = 0.39285f;
        this.mStartGuidePercent = 0.0586f;
        this.mEndGuidePercent = 0.941f;
        construct(context);
    }

    private final void adjustLayout(int total) {
        SpenBrushPensView spenBrushPensView = null;
        if (total <= this.MAX_BRUSH_COUNT_WITHOUT_SCROLL) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            FrameLayout frameLayout = this.mParent;
            if (frameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mParent");
                frameLayout = null;
            }
            addView(frameLayout, layoutParams);
        } else {
            setClipToOutline(true);
            SpenBrushScrollManager spenBrushScrollManager = this.mScrollManager;
            if (spenBrushScrollManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mScrollManager");
                spenBrushScrollManager = null;
            }
            FrameLayout frameLayout2 = this.mParent;
            if (frameLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mParent");
                frameLayout2 = null;
            }
            spenBrushScrollManager.setLayout(this, frameLayout2);
            SpenBrushPensView spenBrushPensView2 = this.mBrushList;
            if (spenBrushPensView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBrushList");
                spenBrushPensView2 = null;
            }
            spenBrushPensView2.setMarginGuideInfo(this.mStartGuidePercent, this.mEndGuidePercent);
        }
        FrameLayout frameLayout3 = this.mParent;
        if (frameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mParent");
            frameLayout3 = null;
        }
        SpenBrushPensView spenBrushPensView3 = this.mBrushList;
        if (spenBrushPensView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBrushList");
        } else {
            spenBrushPensView = spenBrushPensView3;
        }
        frameLayout3.addView(spenBrushPensView);
    }

    private final void construct(Context context) {
        this.mParent = new FrameLayout(context);
        Object systemService = context.getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        View viewInflate = ((LayoutInflater) systemService).inflate(this.mLayoutID, (ViewGroup) this, false);
        Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type com.samsung.android.sdk.pen.setting.drawing.SpenBrushPensView");
        SpenBrushPensView spenBrushPensView = (SpenBrushPensView) viewInflate;
        this.mBrushList = spenBrushPensView;
        SpenBrushPensView spenBrushPensView2 = null;
        if (spenBrushPensView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBrushList");
            spenBrushPensView = null;
        }
        spenBrushPensView.setSupportScrollPenCount(this.MAX_BRUSH_COUNT_WITHOUT_SCROLL);
        SpenBrushPensView spenBrushPensView3 = this.mBrushList;
        if (spenBrushPensView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBrushList");
            spenBrushPensView3 = null;
        }
        spenBrushPensView3.setSelectedGuideInfo(C7932R.id.pen_list_selected_guideline, this.mSelectPercent, C7932R.id.pen_list_unselected_guideline, this.mUnSelectPercent);
        SpenPenListControl spenPenListControl = new SpenPenListControl(context, this.mItemID);
        this.mBrushControl = spenPenListControl;
        spenPenListControl.setOnPenClickListener(new SpenPenListControl.OnPenClickListener() { // from class: com.samsung.android.sdk.pen.setting.drawing.SpenBrushPenListLayout.construct.1
            @Override // com.samsung.android.sdk.pen.setting.pencommon.SpenPenListControl.OnPenClickListener
            public void onPenClicked(String name, boolean isSelected) {
                Log.i(SpenBrushPenListLayout.TAG, "onPenClick() name=" + name + " isSelected=" + isSelected);
                SpenBrushPenLayoutInterface.OnActionListener onActionListener = SpenBrushPenListLayout.this.mActionListener;
                if (onActionListener != null) {
                    if (name == null) {
                        name = "";
                    }
                    onActionListener.onPenClicked(name, isSelected);
                }
            }
        });
        SpenConsumedListener spenConsumedListener = new SpenConsumedListener();
        this.mConsumedListener = spenConsumedListener;
        SpenBrushPensView spenBrushPensView4 = this.mBrushList;
        if (spenBrushPensView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBrushList");
        } else {
            spenBrushPensView2 = spenBrushPensView4;
        }
        spenConsumedListener.setConsumedListener(this, spenBrushPensView2);
        this.mScrollManager = new SpenBrushScrollManager(context);
    }

    private final void prohibitTooltipText(boolean prohibit) {
        if (Build.VERSION.SDK_INT > 28) {
            return;
        }
        SpenBrushPensView spenBrushPensView = this.mBrushList;
        if (spenBrushPensView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBrushList");
            spenBrushPensView = null;
        }
        int penCount = spenBrushPensView.getPenCount();
        for (int i = 0; i < penCount; i++) {
            SpenBrushPensView spenBrushPensView2 = this.mBrushList;
            if (spenBrushPensView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBrushList");
                spenBrushPensView2 = null;
            }
            View penView = spenBrushPensView2.getPenView(i);
            if (penView instanceof SpenBrushPenView) {
                ((SpenBrushPenView) penView).setProhibitTooltipText(prohibit);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setAfterAnimation() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, this.mTransAlpha * 1.0f, 1, 0.0f);
        translateAnimation.setInterpolator(new PathInterpolator(0.17f, 0.17f, 0.2f, 1.0f));
        translateAnimation.setDuration(150L);
        translateAnimation.setFillAfter(true);
        FrameLayout frameLayout = this.mParent;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mParent");
            frameLayout = null;
        }
        frameLayout.startAnimation(translateAnimation);
    }

    private final void setBeforeAnimation() {
        float rotation = getRotation();
        SpenBrushPensView spenBrushPensView = this.mBrushList;
        FrameLayout frameLayout = null;
        if (spenBrushPensView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBrushList");
            spenBrushPensView = null;
        }
        AbstractC11014a.m12329n(this.mDegree, "]", TAG, AbstractC0622a.m1176v("setBeforeAnimation() rotation[", rotation, "] degree[from:", spenBrushPensView.getRotationX(), ", to:"));
        this.mTransAlpha = this.mDegree == 180 ? -1 : 1;
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, (-1) * this.mTransAlpha * 1.0f);
        translateAnimation.setDuration(150L);
        translateAnimation.setInterpolator(new PathInterpolator(0.8f, 0.0f, 0.83f, 0.83f));
        translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.samsung.android.sdk.pen.setting.drawing.SpenBrushPenListLayout.setBeforeAnimation.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                SpenBrushPensView spenBrushPensView2 = SpenBrushPenListLayout.this.mBrushList;
                SpenBrushPensView spenBrushPensView3 = null;
                if (spenBrushPensView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBrushList");
                    spenBrushPensView2 = null;
                }
                Log.i(SpenBrushPenListLayout.TAG, "setBeforeAnimation.onAnimationEnd() from=" + spenBrushPensView2.getRotationX() + " to=" + SpenBrushPenListLayout.this.mDegree);
                SpenBrushPensView spenBrushPensView4 = SpenBrushPenListLayout.this.mBrushList;
                if (spenBrushPensView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBrushList");
                } else {
                    spenBrushPensView3 = spenBrushPensView4;
                }
                spenBrushPensView3.setRotationX(SpenBrushPenListLayout.this.mDegree);
                SpenBrushPenListLayout.this.setAfterAnimation();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        });
        FrameLayout frameLayout2 = this.mParent;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mParent");
        } else {
            frameLayout = frameLayout2;
        }
        frameLayout.startAnimation(translateAnimation);
    }

    private final void setPenDegreeWithAni(int degree) {
        this.mDegree = degree;
        setBeforeAnimation();
    }

    private final boolean updateChildPosition(String penName, boolean isSmoothScroll) {
        SpenBrushScrollManager spenBrushScrollManager = this.mScrollManager;
        SpenBrushPensView spenBrushPensView = null;
        if (spenBrushScrollManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mScrollManager");
            spenBrushScrollManager = null;
        }
        if (!spenBrushScrollManager.isSupportScroll()) {
            return false;
        }
        SpenPenListControl spenPenListControl = this.mBrushControl;
        if (spenPenListControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBrushControl");
            spenPenListControl = null;
        }
        if (penName == null) {
            penName = "";
        }
        int iFindPenIndex = spenPenListControl.findPenIndex(penName);
        SpenBrushScrollManager spenBrushScrollManager2 = this.mScrollManager;
        if (spenBrushScrollManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mScrollManager");
            spenBrushScrollManager2 = null;
        }
        SpenBrushPensView spenBrushPensView2 = this.mBrushList;
        if (spenBrushPensView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBrushList");
        } else {
            spenBrushPensView = spenBrushPensView2;
        }
        return spenBrushScrollManager2.setVisibleChild(spenBrushPensView.getPenView(iFindPenIndex), isSmoothScroll);
    }

    @Override // com.samsung.android.sdk.pen.setting.drawing.SpenBrushPenLayoutInterface
    public void close() {
        if (this.mLongClickControl != null) {
            setOnLongClickListener(null);
        }
        SpenConsumedListener spenConsumedListener = this.mConsumedListener;
        if (spenConsumedListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mConsumedListener");
            spenConsumedListener = null;
        }
        spenConsumedListener.close();
        SpenPenListControl spenPenListControl = this.mBrushControl;
        if (spenPenListControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBrushControl");
            spenPenListControl = null;
        }
        spenPenListControl.close();
        SpenBrushPensView spenBrushPensView = this.mBrushList;
        if (spenBrushPensView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBrushList");
            spenBrushPensView = null;
        }
        spenBrushPensView.close();
        SpenBrushScrollManager spenBrushScrollManager = this.mScrollManager;
        if (spenBrushScrollManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mScrollManager");
            spenBrushScrollManager = null;
        }
        spenBrushScrollManager.close();
        this.mTargetPenName = null;
        this.mActionListener = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@NotNull MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        SpenLongClickControl spenLongClickControl = this.mLongClickControl;
        if (spenLongClickControl == null) {
            return super.dispatchTouchEvent(ev);
        }
        onTouchEvent(ev);
        if (spenLongClickControl.getMIsLongPressedOnLayout()) {
            return true;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Nullable
    public final SpenSettingPenResource getBrushPenViewInfo(@Nullable String penName) {
        SpenPenListControl spenPenListControl = this.mBrushControl;
        if (spenPenListControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBrushControl");
            spenPenListControl = null;
        }
        if (penName == null) {
            penName = "";
        }
        return spenPenListControl.getPenResource(penName);
    }

    @Override // com.samsung.android.sdk.pen.setting.drawing.SpenBrushPenLayoutInterface
    public int getPenCount() {
        SpenBrushPensView spenBrushPensView = this.mBrushList;
        if (spenBrushPensView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBrushList");
            spenBrushPensView = null;
        }
        return spenBrushPensView.getPenCount();
    }

    public final float getPenDegree() {
        Log.i(TAG, "getPenDegree()");
        SpenBrushPensView spenBrushPensView = this.mBrushList;
        if (spenBrushPensView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBrushList");
            spenBrushPensView = null;
        }
        return spenBrushPensView.getRotationX();
    }

    @NotNull
    public final Point getSelectedPenCenter() {
        Point point = new Point();
        SpenBrushPensView spenBrushPensView = this.mBrushList;
        SpenBrushPensView spenBrushPensView2 = null;
        if (spenBrushPensView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBrushList");
            spenBrushPensView = null;
        }
        int mSelectedIndex = spenBrushPensView.getMSelectedIndex();
        if (mSelectedIndex > -1) {
            SpenBrushPensView spenBrushPensView3 = this.mBrushList;
            if (spenBrushPensView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBrushList");
            } else {
                spenBrushPensView2 = spenBrushPensView3;
            }
            View penView = spenBrushPensView2.getPenView(mSelectedIndex);
            if (penView != null) {
                point.set((penView.getWidth() / 2) + ((int) penView.getX()), (penView.getHeight() / 2) + ((int) penView.getY()));
            }
        }
        Log.i(TAG, "getSelectPosition() " + point);
        return point;
    }

    @Override // com.samsung.android.sdk.pen.setting.drawing.SpenBrushPenLayoutInterface
    public int getSelectedPenPosition() {
        SpenBrushPensView spenBrushPensView = this.mBrushList;
        if (spenBrushPensView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBrushList");
            spenBrushPensView = null;
        }
        int mSelectedIndex = spenBrushPensView.getMSelectedIndex();
        AbstractC2322a.m1631u(mSelectedIndex, "getSelectedPenPosition() index=", TAG);
        return mSelectedIndex;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (updateChildPosition(this.mTargetPenName, true)) {
            this.mTargetPenName = null;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        SpenLongClickControl spenLongClickControl = this.mLongClickControl;
        if (spenLongClickControl == null) {
            return super.onTouchEvent(event);
        }
        if (spenLongClickControl == null) {
            return true;
        }
        spenLongClickControl.onTouchEvent(event);
        return true;
    }

    @Override // com.samsung.android.sdk.pen.setting.drawing.SpenBrushPenLayoutInterface
    public void setActionListener(@Nullable SpenBrushPenLayoutInterface.OnActionListener listener) {
        this.mActionListener = listener;
    }

    public final void setExpandToSelectPen(boolean isExpandToSelectPen) {
        this.mIsExpandToSelectPen = isExpandToSelectPen;
    }

    public final void setPenAnimation(@Nullable String selectPenName, boolean expended, @Nullable Animation.AnimationListener listener) {
        SpenPenListControl spenPenListControl = this.mBrushControl;
        SpenBrushPensView spenBrushPensView = null;
        if (spenPenListControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBrushControl");
            spenPenListControl = null;
        }
        int iFindPenIndex = spenPenListControl.findPenIndex(selectPenName == null ? "" : selectPenName);
        if (this.mIsExpandToSelectPen && expended) {
            updateChildPosition(selectPenName, false);
        }
        SpenBrushPensView spenBrushPensView2 = this.mBrushList;
        if (spenBrushPensView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBrushList");
        } else {
            spenBrushPensView = spenBrushPensView2;
        }
        spenBrushPensView.setPenAnimation(iFindPenIndex, expended, listener);
    }

    public final void setPenDegree(int degree, boolean animationIfChange) {
        float f = degree;
        SpenBrushPensView spenBrushPensView = this.mBrushList;
        SpenBrushPensView spenBrushPensView2 = null;
        if (spenBrushPensView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBrushList");
            spenBrushPensView = null;
        }
        boolean z = f == spenBrushPensView.getRotationX();
        boolean z2 = !z;
        SpenBrushPensView spenBrushPensView3 = this.mBrushList;
        if (spenBrushPensView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBrushList");
            spenBrushPensView3 = null;
        }
        Log.i(TAG, "setPenDegree() degree=" + degree + " current=" + spenBrushPensView3.getRotationX());
        AbstractC6670b.m4758s("setPenDegree() isChanged=", " needAnimation=", TAG, z2, animationIfChange);
        if (!z && animationIfChange) {
            Log.i(TAG, "++++++++++++++++++++ Need Pen Animation ++++++++++++++++");
            setPenDegreeWithAni(degree);
            return;
        }
        SpenBrushPensView spenBrushPensView4 = this.mBrushList;
        if (spenBrushPensView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBrushList");
        } else {
            spenBrushPensView2 = spenBrushPensView4;
        }
        spenBrushPensView2.setRotationX(f);
    }

    @Override // com.samsung.android.sdk.pen.setting.drawing.SpenBrushPenLayoutInterface
    public boolean setPenInfo(@Nullable String penName, int color) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        AbstractC6670b.m4765z(new Object[]{penName, Integer.valueOf(color)}, 2, "setPenInfo() penName[%s] color=#%08X", "format(format, *args)", TAG);
        SpenPenListControl spenPenListControl = this.mBrushControl;
        SpenPenListControl spenPenListControl2 = null;
        if (spenPenListControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBrushControl");
            spenPenListControl = null;
        }
        if (spenPenListControl.setPenInfo(penName == null ? "" : penName, color)) {
            updateChildPosition(penName, true);
            this.mTargetPenName = penName;
            return true;
        }
        SpenPenListControl spenPenListControl3 = this.mBrushControl;
        if (spenPenListControl3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBrushControl");
        } else {
            spenPenListControl2 = spenPenListControl3;
        }
        spenPenListControl2.setUnselectedPen();
        return false;
    }

    @Override // com.samsung.android.sdk.pen.setting.drawing.SpenBrushPenLayoutInterface
    public void setPenInfoList(@Nullable List<SpenSettingPenInfo> penInfoList) {
        SpenPenListControl spenPenListControl = this.mBrushControl;
        if (spenPenListControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBrushControl");
            spenPenListControl = null;
        }
        spenPenListControl.setPenInfoList(penInfoList);
    }

    @Override // com.samsung.android.sdk.pen.setting.drawing.SpenBrushPenLayoutInterface
    public void setPenLayoutRatio(float penPercentWidth, float penPercentHeight) {
        SpenBrushPensView spenBrushPensView = this.mBrushList;
        if (spenBrushPensView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBrushList");
            spenBrushPensView = null;
        }
        spenBrushPensView.setLayoutRatio(penPercentWidth, penPercentHeight);
    }

    @Override // com.samsung.android.sdk.pen.setting.drawing.SpenBrushPenLayoutInterface
    public void setPenList(@Nullable List<String> penNames, @Nullable List<SpenSettingPenResource> viewInfo) {
        Log.i(TAG, "setPenList() - width penResource");
        if (penNames == null) {
            return;
        }
        adjustLayout(penNames.size());
        SpenPenListControl spenPenListControl = this.mBrushControl;
        SpenPenListControl spenPenListControl2 = null;
        if (spenPenListControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBrushControl");
            spenPenListControl = null;
        }
        SpenBrushPensView spenBrushPensView = this.mBrushList;
        if (spenBrushPensView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBrushList");
            spenBrushPensView = null;
        }
        spenPenListControl.setView(spenBrushPensView, penNames);
        if (viewInfo != null) {
            SpenPenListControl spenPenListControl3 = this.mBrushControl;
            if (spenPenListControl3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBrushControl");
            } else {
                spenPenListControl2 = spenPenListControl3;
            }
            spenPenListControl2.initPenResource(viewInfo);
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.drawing.SpenBrushPenLayoutInterface
    public void setRoundedBackground(int radius, int bgColor, int strokeSize, int strokeColor) {
        SpenSettingUtilDrawable.setRoundedCornerBackground(this, radius, bgColor, strokeSize, strokeColor);
        setClipToOutline(true);
    }

    public final void setScrollBar(boolean enable) {
        SpenBrushScrollManager spenBrushScrollManager = this.mScrollManager;
        if (spenBrushScrollManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mScrollManager");
            spenBrushScrollManager = null;
        }
        spenBrushScrollManager.setScrollBar(enable);
    }

    public final void setSettingViewLongClickListener(@Nullable SettingViewLongClickListener listener) {
        if (listener == null) {
            SpenLongClickControl spenLongClickControl = this.mLongClickControl;
            if (spenLongClickControl != null) {
                spenLongClickControl.close();
            }
            this.mLongClickControl = null;
            return;
        }
        if (this.mLongClickControl == null) {
            this.mLongClickControl = new SpenLongClickControl(getContext(), this);
        }
        SpenLongClickControl spenLongClickControl2 = this.mLongClickControl;
        if (spenLongClickControl2 != null) {
            spenLongClickControl2.setOnLongClickListener(listener);
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.drawing.SpenBrushPenLayoutInterface
    public void setUnselectedPen() {
        SpenPenListControl spenPenListControl = this.mBrushControl;
        if (spenPenListControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBrushControl");
            spenPenListControl = null;
        }
        spenPenListControl.setUnselectedPen();
    }

    public final void smoothScrollTo(int xPos) {
        SpenBrushScrollManager spenBrushScrollManager = this.mScrollManager;
        SpenBrushScrollManager spenBrushScrollManager2 = null;
        if (spenBrushScrollManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mScrollManager");
            spenBrushScrollManager = null;
        }
        if (spenBrushScrollManager.isSupportScroll()) {
            SpenBrushScrollManager spenBrushScrollManager3 = this.mScrollManager;
            if (spenBrushScrollManager3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mScrollManager");
            } else {
                spenBrushScrollManager2 = spenBrushScrollManager3;
            }
            spenBrushScrollManager2.smoothScrollTo(xPos);
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.drawing.SpenBrushPenLayoutInterface
    public void setPenList(@Nullable List<String> penNames) {
        Log.i(TAG, "setPenList() - widthout penResource");
        if (penNames == null) {
            return;
        }
        adjustLayout(penNames.size());
        SpenPenListControl spenPenListControl = this.mBrushControl;
        SpenBrushPensView spenBrushPensView = null;
        if (spenPenListControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBrushControl");
            spenPenListControl = null;
        }
        SpenBrushPensView spenBrushPensView2 = this.mBrushList;
        if (spenBrushPensView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBrushList");
        } else {
            spenBrushPensView = spenBrushPensView2;
        }
        spenPenListControl.setView(spenBrushPensView, penNames);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenBrushPenListLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.MAX_BRUSH_COUNT_WITHOUT_SCROLL = 9;
        this.mLayoutID = C7932R.layout.setting_brush_pen_list_v2;
        this.mItemID = C7932R.layout.setting_brush_pen_list_item;
        this.mSelectPercent = 0.107f;
        this.mUnSelectPercent = 0.457f;
        this.mStartGuidePercent = 0.0f;
        this.mEndGuidePercent = 0.9662f;
        construct(context);
    }
}
