package com.samsung.android.sdk.pen.setting.quicktool;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.PointF;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import androidx.appcompat.animation.C0421a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FloatValueHolder;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.bottomappbar.RunnableC4587a;
import com.google.android.material.internal.RunnableC4738b;
import com.google.android.material.oneui.floatingdock.C4796g;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenChipView;
import com.samsung.android.sdk.pen.setting.handwriting.RunnableC7596b;
import com.samsung.android.sdk.pen.setting.handwriting.RunnableC7599e;
import com.samsung.android.sdk.pen.setting.handwriting.SpenPenAttrMiniView;
import com.samsung.android.sdk.pen.setting.pencommon.SpenPenBaseView;
import com.samsung.android.sdk.pen.setting.pencommon.SpenPenPreviewV2;
import com.samsung.android.sdk.pen.setting.quicktool.SpenQTPenItemVisibilityController;
import com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTLayout;
import com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTPenLayout;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAnimation;
import com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.RunnableC7856h;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0006\b\u0000\u0018\u0000 j2\u00020\u0001:\u0002jkB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010.\u001a\u00020/J>\u00100\u001a\u00020/2\u0006\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\n2\u0006\u00104\u001a\u00020\f2\u0006\u00105\u001a\u00020\u000e2\u0006\u00106\u001a\u00020\f2\u0006\u00107\u001a\u00020\u0011J\u000e\u00108\u001a\u00020/2\u0006\u00109\u001a\u00020\u0013J\u000e\u0010:\u001a\u00020/2\u0006\u0010;\u001a\u00020(J6\u0010<\u001a\u00020/2\u0006\u0010=\u001a\u00020(2\u0006\u0010>\u001a\u00020(2\b\b\u0002\u0010?\u001a\u00020(2\b\b\u0002\u0010@\u001a\u00020(2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010BJ\u0018\u0010C\u001a\u00020/2\u0006\u0010;\u001a\u00020(2\b\u0010D\u001a\u0004\u0018\u00010BJ\"\u0010E\u001a\u00020/2\u0006\u0010F\u001a\u00020#2\u0006\u0010G\u001a\u00020H2\b\b\u0002\u0010I\u001a\u00020HH\u0002J\"\u0010J\u001a\u00020/2\u0006\u0010F\u001a\u00020#2\u0006\u0010G\u001a\u00020H2\b\b\u0002\u0010I\u001a\u00020HH\u0002J\u0010\u0010K\u001a\u00020/2\u0006\u0010;\u001a\u00020(H\u0002J$\u0010L\u001a\u00020/2\b\u0010F\u001a\u0004\u0018\u00010#2\u0006\u0010;\u001a\u00020(2\b\b\u0002\u0010M\u001a\u00020(H\u0002J&\u0010N\u001a\u00020/2\u0006\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020P2\u0006\u0010=\u001a\u00020(2\u0006\u0010,\u001a\u00020(J \u0010R\u001a\u00020/2\u0006\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020P2\u0006\u0010=\u001a\u00020(H\u0002J\u0010\u0010S\u001a\u00020/2\u0006\u0010;\u001a\u00020(H\u0002J\u0018\u0010T\u001a\u00020/2\u0006\u0010O\u001a\u00020P2\u0006\u0010;\u001a\u00020(H\u0002J*\u0010U\u001a\u00020/2\b\u0010F\u001a\u0004\u0018\u00010#2\u0006\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020P2\u0006\u0010=\u001a\u00020(H\u0002J \u0010V\u001a\u00020/2\u0006\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020P2\u0006\u0010=\u001a\u00020(H\u0002J\u001e\u0010W\u001a\u00020/2\u0006\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020P2\u0006\u0010=\u001a\u00020(J4\u0010X\u001a\u00020/2\u0006\u0010F\u001a\u00020#2\u0006\u0010Y\u001a\u00020\u00172\u0006\u0010Z\u001a\u00020\u00172\b\b\u0002\u0010[\u001a\u00020H2\n\b\u0002\u0010D\u001a\u0004\u0018\u00010BJ\u0016\u0010\\\u001a\u00020/2\u0006\u0010=\u001a\u00020(2\u0006\u0010]\u001a\u00020(J\u0016\u0010^\u001a\u00020\u00152\u0006\u0010_\u001a\u00020(2\u0006\u0010`\u001a\u00020(J\u001e\u0010a\u001a\u00020/2\u0006\u0010b\u001a\u00020c2\u0006\u0010d\u001a\u00020\u00152\u0006\u0010=\u001a\u00020(J\u0016\u0010e\u001a\b\u0012\u0004\u0012\u00020#0f2\u0006\u0010g\u001a\u00020\u0015H\u0002J \u0010h\u001a\u00020/2\u0006\u0010i\u001a\u00020(2\u0006\u0010d\u001a\u00020\u00152\u0006\u0010=\u001a\u00020(H\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$0\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010'\u001a\u00020(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010)\"\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010)\"\u0004\b-\u0010+¨\u0006l"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTPenItemVisibilityController;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mPenItem", "Lcom/samsung/android/sdk/pen/setting/pencommon/SpenPenBaseView;", "mPenAniItem", "mAttrItem", "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenAttrMiniView;", "mColorItem", "Landroid/widget/ImageView;", "mPatternItem", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenChipView;", "mPlusButton", "mPenPreview", "Lcom/samsung/android/sdk/pen/setting/pencommon/SpenPenPreviewV2;", "mCurvedSwitchLayout", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCurvedSwitchLayout;", "mPenTranslationY", "", "mPenSelectedTranslateY", "", "mPenUnselectedTranslateY", "mPenHideTranslateY", "mPlusButtonShowTranslateY", "mPlusButtonHideTranslateY", "mPenItemScaleX", "mPenItemScaleY", "mOffsetTranslateY", "mAttrAlphaAnimation", "Landroid/animation/ValueAnimator;", "mSpringAnimationMap", "", "Landroid/view/View;", "Landroidx/dynamicanimation/animation/SpringAnimation;", "mAnglePosition", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTAnglePosition;", "isCurrentPenValid", "", "()Z", "setCurrentPenValid", "(Z)V", "isSupportParticleSize", "setSupportParticleSize", "close", "", "initViews", "penItem", "penAniItem", "attrItem", "colorItem", "patternItem", "plusButton", "penPreview", "setCurvedSwitchLayout", "switchLayout", "startAnimation", "isShow", "setBaseItemVisibility", "animation", "needStartDelay", "penSelected", "penMaskingAnimation", "endListener", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTPenItemVisibilityController$OnAnimationFinishedListener;", "setCenterItemsVisibility", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "startScaleUpVisibleAnimator", "view", XmlErrorCodes.DURATION, "", "startDelay", "startScaleDownGoneAnimator", "startPenItemAnimation", "startEdgeItemAnimation", "isReversed", "setViewMode", "fromMode", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTPenLayout$ViewMode;", "toMode", "updateAttrItemVisibility", "startAttrItemAlphaAnimation", "startAttrItemScaleAnimation", "updateEdgeItemVisibility", "updateCurvedSwitchVisibility", "setPenPosition", "startTranslationSpringAnimation", "fromTranslateY", "toTranslateY", "delayMillis", "setPenPreviewVisibility", Constants.IntentExtraValue.SHOW, "getValidItemInfo", "validPen", "supportParticleSize", "setDockingMode", "state", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTLayout$DockingState;", "validItems", "getItemView", "", "validItem", "setEdgeViewDockingMode", "isDockingZone", "Companion", "OnAnimationFinishedListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenQTPenItemVisibilityController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenQTPenItemVisibilityController.kt\ncom/samsung/android/sdk/pen/setting/quicktool/SpenQTPenItemVisibilityController\n+ 2 Animator.kt\nandroidx/core/animation/AnimatorKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,669:1\n41#2:670\n91#2,14:671\n30#2:685\n91#2,14:686\n1#3:700\n1855#4,2:701\n1855#4,2:703\n*S KotlinDebug\n*F\n+ 1 SpenQTPenItemVisibilityController.kt\ncom/samsung/android/sdk/pen/setting/quicktool/SpenQTPenItemVisibilityController\n*L\n335#1:670\n335#1:671,14\n336#1:685\n336#1:686,14\n642#1:701,2\n652#1:703,2\n*E\n"})
public final class SpenQTPenItemVisibilityController {
    private static final long ATTR_ITEM_ALPHA_HIDE_ANIMATION_DURATION = 200;
    private static final long ATTR_ITEM_ALPHA_SHOW_ANIMATION_DURATION = 100;
    private static final long ATTR_ITEM_ATTR_MODE_EXIT_DELAY = 200;
    private static final float ATTR_ITEM_VIEW_MID_SCALE = 1.1f;
    private static final long ATTR_ITEM_VIEW_SHOW_ANIMATION_MID_DURATION = 200;
    private static final float HIDE_BASE_ALPHA = 0.0f;
    private static final int ITEM_COLOR = 4;
    private static final int ITEM_PATTERN = 8;
    private static final int ITEM_PEN = 2;
    private static final int ITEM_SIZE = 1;
    private static final float ITEM_VIEW_BASE_SCALE = 0.0f;
    private static final long ITEM_VIEW_HIDE_ANIMATION_DURATION = 350;
    private static final long ITEM_VIEW_SCALE_ANIMATION_DURATION = 350;
    private static final long ITEM_VIEW_SHOW_ANIMATION_DURATION = 400;
    private static final float ITEM_VIEW_TARGET_SCALE = 1.0f;
    private static final long PEN_ITEM_ANIMATION_DELAY = 200;
    private static final float PEN_ITEM_DAMPING_RATIO = 0.75f;
    private static final float PEN_ITEM_STIFFNESS = 300.0f;
    private static final long PEN_PREVIEW_ALPHA_ANIMATION_DURATION = 150;
    private static final float SHOW_BASE_ALPHA = 1.0f;
    private static final long SWITCH_VIEW_HIDE_ANIMATION_DURATION = 100;
    private static final long SWITCH_VIEW_SHOW_ANIMATION_DURATION = 200;

    @NotNull
    private static final String TAG = "SpenQTPenItemVisibilityController";
    private static final float VI_DOCKING_PEN_ITEM_DAMPING_RATIO = 1.0f;
    private static final long VI_DOCKING_SCALE_HIDE_DURATION = 300;
    private static final long VI_DOCKING_SCALE_SHOW_DURATION = 400;
    private static final float VI_ROTATION_DAMPING_RATIO = 0.6f;
    private static final float VI_ROTATION_STIFFNESS = 200.0f;
    private boolean isCurrentPenValid;
    private boolean isSupportParticleSize;

    @NotNull
    private SpenQTAnglePosition mAnglePosition;

    @Nullable
    private ValueAnimator mAttrAlphaAnimation;

    @Nullable
    private SpenPenAttrMiniView mAttrItem;

    @Nullable
    private ImageView mColorItem;

    @Nullable
    private SpenCurvedSwitchLayout mCurvedSwitchLayout;
    private final float mOffsetTranslateY;

    @Nullable
    private SpenChipView mPatternItem;

    @Nullable
    private SpenPenBaseView mPenAniItem;
    private float mPenHideTranslateY;

    @Nullable
    private SpenPenBaseView mPenItem;
    private float mPenItemScaleX;
    private float mPenItemScaleY;

    @Nullable
    private SpenPenPreviewV2 mPenPreview;
    private float mPenSelectedTranslateY;
    private final int mPenTranslationY;
    private float mPenUnselectedTranslateY;

    @Nullable
    private ImageView mPlusButton;
    private float mPlusButtonHideTranslateY;
    private float mPlusButtonShowTranslateY;

    @NotNull
    private Map<View, SpringAnimation> mSpringAnimationMap;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTPenItemVisibilityController$OnAnimationFinishedListener;", "", "onAnimationFinished", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnAnimationFinishedListener {
        void onAnimationFinished();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SpenSettingQTPenLayout.ViewMode.values().length];
            try {
                iArr[SpenSettingQTPenLayout.ViewMode.MAIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SpenSettingQTPenLayout.ViewMode.PEN_LIST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SpenSettingQTPenLayout.ViewMode.ATTRIBUTES.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SpenSettingQTPenLayout.ViewMode.COLOR_PICKER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public SpenQTPenItemVisibilityController(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mPenTranslationY = context.getResources().getDimensionPixelSize(C7932R.dimen.qt_circle_center_pen_item_height);
        this.mPenUnselectedTranslateY = context.getResources().getDimensionPixelSize(C7932R.dimen.qt_circle_center_pen_unselected_y);
        this.mPenHideTranslateY = context.getResources().getDimensionPixelSize(C7932R.dimen.qt_circle_center_pen_base_height);
        this.mPlusButtonHideTranslateY = context.getResources().getDimensionPixelSize(C7932R.dimen.qt_circle_center_plus_icon_translateY);
        this.mPenItemScaleX = context.getResources().getDimensionPixelSize(C7932R.dimen.qt_pen_list_item_pen_width) / context.getResources().getDimensionPixelSize(C7932R.dimen.qt_circle_center_pen_base_width);
        this.mPenItemScaleY = context.getResources().getDimensionPixelSize(C7932R.dimen.qt_pen_list_item_pen_height) / context.getResources().getDimensionPixelSize(C7932R.dimen.qt_circle_center_pen_base_height);
        this.mOffsetTranslateY = context.getResources().getDimensionPixelSize(C7932R.dimen.qt_circle_center_pen_base_offsetY);
        this.mSpringAnimationMap = new LinkedHashMap();
        SpenQTAnglePosition spenQTAnglePosition = new SpenQTAnglePosition();
        this.mAnglePosition = spenQTAnglePosition;
        this.isCurrentPenValid = true;
        spenQTAnglePosition.setRadius(context.getResources().getDimensionPixelSize(C7932R.dimen.qt_circle_radius));
        this.mAnglePosition.setCenterPosition(context.getResources().getDimensionPixelSize(C7932R.dimen.qt_circle_center_x), context.getResources().getDimensionPixelSize(C7932R.dimen.qt_circle_center_y));
    }

    private final List<View> getItemView(int validItem) {
        SpenChipView spenChipView;
        ImageView imageView;
        SpenPenAttrMiniView spenPenAttrMiniView;
        ArrayList arrayList = new ArrayList();
        AbstractC2322a.m1631u(validItem, "validItem=", TAG);
        if ((validItem & 1) == 1 && (spenPenAttrMiniView = this.mAttrItem) != null) {
            arrayList.add(spenPenAttrMiniView);
        }
        if ((validItem & 4) == 4 && (imageView = this.mColorItem) != null) {
            arrayList.add(imageView);
        }
        if ((validItem & 8) == 8 && (spenChipView = this.mPatternItem) != null) {
            arrayList.add(spenChipView);
        }
        return arrayList;
    }

    public static /* synthetic */ void setBaseItemVisibility$default(SpenQTPenItemVisibilityController spenQTPenItemVisibilityController, boolean z, boolean z2, boolean z3, boolean z4, OnAnimationFinishedListener onAnimationFinishedListener, int i, Object obj) {
        if ((i & 4) != 0) {
            z3 = true;
        }
        boolean z5 = z3;
        if ((i & 8) != 0) {
            z4 = false;
        }
        boolean z6 = z4;
        if ((i & 16) != 0) {
            onAnimationFinishedListener = null;
        }
        spenQTPenItemVisibilityController.setBaseItemVisibility(z, z2, z5, z6, onAnimationFinishedListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setDockingMode$lambda$31$lambda$29(int i, ImageView imageView) {
        if (i == 0) {
            imageView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setDockingMode$lambda$31$lambda$30(int i, ImageView imageView) {
        if (i == 8) {
            imageView.setVisibility(8);
        }
    }

    private final void setEdgeViewDockingMode(boolean isDockingZone, int validItems, boolean animation) {
        float f = isDockingZone ? 0.0f : 1.0f;
        final int i = isDockingZone ? 8 : 0;
        if (isDockingZone) {
            validItems = 13;
        }
        List<View> itemView = getItemView(validItems);
        if (!animation) {
            for (View view : itemView) {
                view.animate().cancel();
                view.setScaleX(f);
                view.setScaleY(f);
                view.setVisibility(i);
            }
            itemView.clear();
            return;
        }
        long j = isDockingZone ? 300L : 400L;
        for (final View view2 : itemView) {
            view2.animate().cancel();
            final int i2 = 0;
            ViewPropertyAnimator viewPropertyAnimatorWithStartAction = view2.animate().scaleX(f).scaleY(f).setDuration(j).setStartDelay(0L).setInterpolator(SpenSettingUtilAnimation.getInterpolator(20)).withStartAction(new Runnable() { // from class: com.samsung.android.sdk.pen.setting.quicktool.j
                @Override // java.lang.Runnable
                public final void run() {
                    switch (i2) {
                        case 0:
                            SpenQTPenItemVisibilityController.setEdgeViewDockingMode$lambda$38$lambda$36(i, view2);
                            break;
                        default:
                            SpenQTPenItemVisibilityController.setEdgeViewDockingMode$lambda$38$lambda$37(i, view2);
                            break;
                    }
                }
            });
            final int i4 = 1;
            viewPropertyAnimatorWithStartAction.withEndAction(new Runnable() { // from class: com.samsung.android.sdk.pen.setting.quicktool.j
                @Override // java.lang.Runnable
                public final void run() {
                    switch (i4) {
                        case 0:
                            SpenQTPenItemVisibilityController.setEdgeViewDockingMode$lambda$38$lambda$36(i, view2);
                            break;
                        default:
                            SpenQTPenItemVisibilityController.setEdgeViewDockingMode$lambda$38$lambda$37(i, view2);
                            break;
                    }
                }
            }).setListener(null).start();
        }
        itemView.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setEdgeViewDockingMode$lambda$38$lambda$36(int i, View view) {
        if (i == 0) {
            view.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setEdgeViewDockingMode$lambda$38$lambda$37(int i, View view) {
        if (i == 8) {
            view.setVisibility(8);
        }
    }

    private final void startAttrItemAlphaAnimation(final boolean isShow) {
        SpenPenAttrMiniView spenPenAttrMiniView = this.mAttrItem;
        if (spenPenAttrMiniView != null) {
            ValueAnimator valueAnimator = this.mAttrAlphaAnimation;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(isShow ? 0.0f : 1.0f, isShow ? 1.0f : 0.0f);
            this.mAttrAlphaAnimation = valueAnimatorOfFloat;
            if (valueAnimatorOfFloat != null) {
                valueAnimatorOfFloat.setInterpolator(SpenSettingUtilAnimation.getInterpolator(15));
            }
            ValueAnimator valueAnimator2 = this.mAttrAlphaAnimation;
            if (valueAnimator2 != null) {
                valueAnimator2.setDuration(isShow ? 200L : 100L);
            }
            ValueAnimator valueAnimator3 = this.mAttrAlphaAnimation;
            if (valueAnimator3 != null) {
                valueAnimator3.addUpdateListener(new C0421a(spenPenAttrMiniView, 10));
            }
            ValueAnimator valueAnimator4 = this.mAttrAlphaAnimation;
            if (valueAnimator4 != null) {
                valueAnimator4.addListener(new Animator.AnimatorListener() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenQTPenItemVisibilityController$startAttrItemAlphaAnimation$lambda$15$$inlined$doOnStart$1
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(@NotNull Animator animator) {
                        SpenPenAttrMiniView spenPenAttrMiniView2;
                        if (!isShow || (spenPenAttrMiniView2 = this.mAttrItem) == null) {
                            return;
                        }
                        spenPenAttrMiniView2.setVisibility(0);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(@NotNull Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(@NotNull Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(@NotNull Animator animator) {
                    }
                });
            }
            ValueAnimator valueAnimator5 = this.mAttrAlphaAnimation;
            if (valueAnimator5 != null) {
                valueAnimator5.addListener(new Animator.AnimatorListener() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenQTPenItemVisibilityController$startAttrItemAlphaAnimation$lambda$15$$inlined$doOnEnd$1
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(@NotNull Animator animator) {
                        SpenPenAttrMiniView spenPenAttrMiniView2;
                        if (isShow || (spenPenAttrMiniView2 = this.mAttrItem) == null) {
                            return;
                        }
                        spenPenAttrMiniView2.setVisibility(8);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(@NotNull Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(@NotNull Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(@NotNull Animator animator) {
                    }
                });
            }
            ValueAnimator valueAnimator6 = this.mAttrAlphaAnimation;
            if (valueAnimator6 != null) {
                valueAnimator6.start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startAttrItemAlphaAnimation$lambda$15$lambda$12(SpenPenAttrMiniView spenPenAttrMiniView, ValueAnimator valueAnimator) {
        spenPenAttrMiniView.setAlpha(((Float) AbstractC6670b.m4742c(valueAnimator, "ani", "null cannot be cast to non-null type kotlin.Float")).floatValue());
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void startAttrItemScaleAnimation(final SpenSettingQTPenLayout.ViewMode fromMode, final boolean isShow) {
        final SpenPenAttrMiniView spenPenAttrMiniView;
        final Ref.FloatRef floatRef = new Ref.FloatRef();
        final Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = 400L;
        PathInterpolator interpolator = SpenSettingUtilAnimation.getInterpolator(20);
        int i = WhenMappings.$EnumSwitchMapping$0[fromMode.ordinal()];
        long j = 350;
        float f = 1.0f;
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    floatRef.element = 1.0f;
                    j = 200;
                    longRef.element = 200L;
                    interpolator = SpenSettingUtilAnimation.getInterpolator(7);
                    f = ATTR_ITEM_VIEW_MID_SCALE;
                }
            }
            spenPenAttrMiniView = this.mAttrItem;
            if (spenPenAttrMiniView == null) {
                spenPenAttrMiniView.setVisibility(8);
                spenPenAttrMiniView.setScaleX(floatRef.element);
                spenPenAttrMiniView.setScaleY(floatRef.element);
                spenPenAttrMiniView.animate().scaleX(f).scaleY(f).setDuration(longRef.element).setInterpolator(interpolator).setStartDelay(j).withStartAction(new RunnableC7596b(spenPenAttrMiniView, 1)).withEndAction(new Runnable() { // from class: com.samsung.android.sdk.pen.setting.quicktool.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        SpenQTPenItemVisibilityController.startAttrItemScaleAnimation$lambda$18$lambda$17(fromMode, spenPenAttrMiniView, floatRef, longRef, isShow);
                    }
                }).start();
                return;
            }
            return;
        }
        floatRef.element = 1.0f;
        longRef.element = 350L;
        f = 0.0f;
        j = 0;
        spenPenAttrMiniView = this.mAttrItem;
        if (spenPenAttrMiniView == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startAttrItemScaleAnimation$lambda$18$lambda$17(SpenSettingQTPenLayout.ViewMode viewMode, SpenPenAttrMiniView spenPenAttrMiniView, Ref.FloatRef floatRef, Ref.LongRef longRef, boolean z) {
        if (viewMode == SpenSettingQTPenLayout.ViewMode.ATTRIBUTES) {
            spenPenAttrMiniView.animate().scaleX(floatRef.element).scaleY(floatRef.element).setDuration(longRef.element).setInterpolator(SpenSettingUtilAnimation.getInterpolator(3)).setStartDelay(0L).start();
        }
        if (z) {
            return;
        }
        spenPenAttrMiniView.setVisibility(8);
    }

    private final void startEdgeItemAnimation(View view, boolean isShow, boolean isReversed) {
        float f;
        if (view != null) {
            float f4 = 270.0f;
            if (isShow) {
                f = isReversed ? 180.0f : 360.0f;
                view.setVisibility(0);
                startScaleUpVisibleAnimator$default(this, view, 400L, 0L, 4, null);
            } else {
                float f5 = isReversed ? 180.0f : 360.0f;
                startScaleDownGoneAnimator$default(this, view, 400L, 0L, 4, null);
                float f6 = f5;
                f = 270.0f;
                f4 = f6;
            }
            SpringAnimation springAnimation = new SpringAnimation(new FloatValueHolder(f4), f);
            SpringForce spring = springAnimation.getSpring();
            spring.setDampingRatio(0.6f);
            spring.setStiffness(200.0f);
            springAnimation.addUpdateListener(new C4796g(this, view, 2));
            springAnimation.start();
        }
    }

    public static /* synthetic */ void startEdgeItemAnimation$default(SpenQTPenItemVisibilityController spenQTPenItemVisibilityController, View view, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = false;
        }
        spenQTPenItemVisibilityController.startEdgeItemAnimation(view, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startEdgeItemAnimation$lambda$11$lambda$10(SpenQTPenItemVisibilityController spenQTPenItemVisibilityController, View view, DynamicAnimation dynamicAnimation, float f, float f4) {
        PointF viewPosition = spenQTPenItemVisibilityController.mAnglePosition.getViewPosition(view.getWidth(), view.getHeight(), (int) f);
        view.setX(viewPosition.x);
        view.setY(viewPosition.y);
    }

    private final void startPenItemAnimation(boolean isShow) {
        SpenPenBaseView spenPenBaseView = this.mPenItem;
        if (spenPenBaseView != null) {
            if (isShow) {
                SpenSettingUtilAnimation spenSettingUtilAnimation = SpenSettingUtilAnimation.INSTANCE;
                DynamicAnimation.ViewProperty TRANSLATION_Y = DynamicAnimation.TRANSLATION_Y;
                Intrinsics.checkNotNullExpressionValue(TRANSLATION_Y, "TRANSLATION_Y");
                spenSettingUtilAnimation.startSpringAnimation(spenPenBaseView, TRANSLATION_Y, this.mPenTranslationY, 0.75f, 200.0f, 0.0f, (64 & 64) != 0 ? null : null);
                return;
            }
            SpenSettingUtilAnimation spenSettingUtilAnimation2 = SpenSettingUtilAnimation.INSTANCE;
            DynamicAnimation.ViewProperty TRANSLATION_Y2 = DynamicAnimation.TRANSLATION_Y;
            Intrinsics.checkNotNullExpressionValue(TRANSLATION_Y2, "TRANSLATION_Y");
            spenSettingUtilAnimation2.startSpringAnimation(spenPenBaseView, TRANSLATION_Y2, spenPenBaseView.getTranslationY(), 0.75f, 200.0f, this.mPenTranslationY, (64 & 64) != 0 ? null : null);
        }
    }

    private final void startScaleDownGoneAnimator(View view, long duration, long startDelay) {
        view.animate().cancel();
        view.animate().scaleX(0.0f).scaleY(0.0f).setDuration(duration).setInterpolator(SpenSettingUtilAnimation.getInterpolator(20)).setStartDelay(startDelay).withEndAction(new RunnableC4587a(view, 4)).start();
    }

    public static /* synthetic */ void startScaleDownGoneAnimator$default(SpenQTPenItemVisibilityController spenQTPenItemVisibilityController, View view, long j, long j2, int i, Object obj) {
        if ((i & 4) != 0) {
            j2 = 0;
        }
        spenQTPenItemVisibilityController.startScaleDownGoneAnimator(view, j, j2);
    }

    private final void startScaleUpVisibleAnimator(View view, long duration, long startDelay) {
        view.animate().cancel();
        view.animate().scaleX(1.0f).scaleY(1.0f).setDuration(duration).setInterpolator(SpenSettingUtilAnimation.getInterpolator(20)).setStartDelay(startDelay).withStartAction(new RunnableC4587a(view, 5)).start();
    }

    public static /* synthetic */ void startScaleUpVisibleAnimator$default(SpenQTPenItemVisibilityController spenQTPenItemVisibilityController, View view, long j, long j2, int i, Object obj) {
        if ((i & 4) != 0) {
            j2 = 0;
        }
        spenQTPenItemVisibilityController.startScaleUpVisibleAnimator(view, j, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startScaleUpVisibleAnimator$lambda$7(View view) {
        view.setScaleX(0.0f);
        view.setScaleY(0.0f);
        view.setVisibility(0);
    }

    public static /* synthetic */ void startTranslationSpringAnimation$default(SpenQTPenItemVisibilityController spenQTPenItemVisibilityController, View view, float f, float f4, long j, OnAnimationFinishedListener onAnimationFinishedListener, int i, Object obj) {
        if ((i & 8) != 0) {
            j = 0;
        }
        long j2 = j;
        if ((i & 16) != 0) {
            onAnimationFinishedListener = null;
        }
        spenQTPenItemVisibilityController.startTranslationSpringAnimation(view, f, f4, j2, onAnimationFinishedListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startTranslationSpringAnimation$lambda$25$lambda$24(float f, final SpringAnimation springAnimation, final OnAnimationFinishedListener onAnimationFinishedListener) {
        SpringForce springForce = new SpringForce();
        springForce.setDampingRatio(0.75f);
        springForce.setStiffness(300.0f);
        springForce.setFinalPosition(f);
        springAnimation.setSpring(springForce);
        springAnimation.addEndListener(new DynamicAnimation.OnAnimationEndListener() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenQTPenItemVisibilityController$startTranslationSpringAnimation$1$1$1
            @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener
            public void onAnimationEnd(DynamicAnimation<?> animation, boolean canceled, float value, float velocity) {
                SpenQTPenItemVisibilityController.OnAnimationFinishedListener onAnimationFinishedListener2;
                if (!canceled && (onAnimationFinishedListener2 = onAnimationFinishedListener) != null) {
                    onAnimationFinishedListener2.onAnimationFinished();
                }
                springAnimation.removeEndListener(this);
            }
        });
        springAnimation.start();
    }

    private final void updateAttrItemVisibility(SpenSettingQTPenLayout.ViewMode fromMode, SpenSettingQTPenLayout.ViewMode toMode, boolean animation) {
        SpenSettingQTPenLayout.ViewMode viewMode = SpenSettingQTPenLayout.ViewMode.MAIN;
        boolean z = true;
        boolean z2 = toMode == viewMode;
        boolean z3 = toMode == viewMode || toMode == SpenSettingQTPenLayout.ViewMode.COLOR;
        SpenSettingQTPenLayout.ViewMode viewMode2 = SpenSettingQTPenLayout.ViewMode.ATTRIBUTES;
        if ((fromMode != viewMode2 || toMode != viewMode) && toMode != viewMode2) {
            z = false;
        }
        if (!animation) {
            SpenPenAttrMiniView spenPenAttrMiniView = this.mAttrItem;
            if (spenPenAttrMiniView != null) {
                spenPenAttrMiniView.setVisibility(z2 ? 0 : 8);
                return;
            }
            return;
        }
        if (z3) {
            startAttrItemScaleAnimation(fromMode, z2);
        }
        if (z) {
            startAttrItemAlphaAnimation(z2);
        }
    }

    private final void updateCurvedSwitchVisibility(SpenSettingQTPenLayout.ViewMode fromMode, SpenSettingQTPenLayout.ViewMode toMode, boolean animation) {
        SpenSettingQTPenLayout.ViewMode viewMode;
        if (toMode == SpenSettingQTPenLayout.ViewMode.COLOR_PICKER) {
            return;
        }
        boolean z = toMode == SpenSettingQTPenLayout.ViewMode.MAIN;
        if (!animation || toMode == (viewMode = SpenSettingQTPenLayout.ViewMode.PEN_LIST)) {
            SpenCurvedSwitchLayout spenCurvedSwitchLayout = this.mCurvedSwitchLayout;
            if (spenCurvedSwitchLayout != null) {
                spenCurvedSwitchLayout.setVisibility(z ? 0 : 8);
                return;
            }
            return;
        }
        long j = fromMode == viewMode ? 350L : 0L;
        SpenCurvedSwitchLayout spenCurvedSwitchLayout2 = this.mCurvedSwitchLayout;
        if (spenCurvedSwitchLayout2 != null) {
            if (!z) {
                spenCurvedSwitchLayout2.setAlpha(1.0f);
                spenCurvedSwitchLayout2.animate().alpha(0.0f).setDuration(100L).setInterpolator(SpenSettingUtilAnimation.getInterpolator(15)).setStartDelay(j).withEndAction(new RunnableC7599e(spenCurvedSwitchLayout2, 2)).start();
            } else {
                spenCurvedSwitchLayout2.setVisibility(0);
                spenCurvedSwitchLayout2.setAlpha(0.0f);
                spenCurvedSwitchLayout2.animate().alpha(1.0f).setDuration(200L).setInterpolator(SpenSettingUtilAnimation.getInterpolator(15)).setStartDelay(j).start();
            }
        }
    }

    private final void updateEdgeItemVisibility(View view, SpenSettingQTPenLayout.ViewMode fromMode, SpenSettingQTPenLayout.ViewMode toMode, boolean animation) {
        SpenSettingQTPenLayout.ViewMode viewMode = SpenSettingQTPenLayout.ViewMode.MAIN;
        boolean z = true;
        boolean z2 = toMode == viewMode;
        if (toMode != viewMode && toMode != SpenSettingQTPenLayout.ViewMode.ATTRIBUTES && toMode != SpenSettingQTPenLayout.ViewMode.COLOR) {
            z = false;
        }
        if (!animation || !z) {
            if (view != null) {
                view.setVisibility(z2 ? 0 : 8);
                return;
            }
            return;
        }
        long j = fromMode == SpenSettingQTPenLayout.ViewMode.PEN_LIST ? 350L : 0L;
        float f = z2 ? 0.0f : 1.0f;
        float f4 = z2 ? 1.0f : 0.0f;
        if (view != null) {
            view.setVisibility(0);
            view.setScaleX(f);
            view.setScaleY(f);
            view.animate().scaleX(f4).scaleY(f4).setDuration(z2 ? 400L : 350L).setInterpolator(SpenSettingUtilAnimation.getInterpolator(20)).setStartDelay(j).withEndAction(new RunnableC4738b(view, z2)).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateEdgeItemVisibility$lambda$20$lambda$19(boolean z, View view) {
        if (z) {
            return;
        }
        view.setVisibility(8);
    }

    public final void close() {
        this.mPenItem = null;
        this.mPenAniItem = null;
        this.mAttrItem = null;
        this.mColorItem = null;
        this.mPatternItem = null;
        this.mPlusButton = null;
        this.mCurvedSwitchLayout = null;
        this.mAttrAlphaAnimation = null;
        this.mSpringAnimationMap.clear();
    }

    public final int getValidItemInfo(boolean validPen, boolean supportParticleSize) {
        if (validPen) {
            return (!supportParticleSize ? 4 : 8) | 3;
        }
        return 0;
    }

    public final void initViews(@NotNull SpenPenBaseView penItem, @NotNull SpenPenBaseView penAniItem, @NotNull SpenPenAttrMiniView attrItem, @NotNull ImageView colorItem, @NotNull SpenChipView patternItem, @NotNull ImageView plusButton, @NotNull SpenPenPreviewV2 penPreview) {
        Intrinsics.checkNotNullParameter(penItem, "penItem");
        Intrinsics.checkNotNullParameter(penAniItem, "penAniItem");
        Intrinsics.checkNotNullParameter(attrItem, "attrItem");
        Intrinsics.checkNotNullParameter(colorItem, "colorItem");
        Intrinsics.checkNotNullParameter(patternItem, "patternItem");
        Intrinsics.checkNotNullParameter(plusButton, "plusButton");
        Intrinsics.checkNotNullParameter(penPreview, "penPreview");
        this.mPenItem = penItem;
        this.mPenAniItem = penAniItem;
        this.mAttrItem = attrItem;
        this.mColorItem = colorItem;
        this.mPatternItem = patternItem;
        this.mPlusButton = plusButton;
        this.mPenPreview = penPreview;
    }

    /* JADX INFO: renamed from: isCurrentPenValid, reason: from getter */
    public final boolean getIsCurrentPenValid() {
        return this.isCurrentPenValid;
    }

    /* JADX INFO: renamed from: isSupportParticleSize, reason: from getter */
    public final boolean getIsSupportParticleSize() {
        return this.isSupportParticleSize;
    }

    public final void setBaseItemVisibility(boolean animation, boolean needStartDelay, boolean penSelected, boolean penMaskingAnimation, @Nullable OnAnimationFinishedListener endListener) {
        long j;
        SpenPenBaseView spenPenBaseView;
        AbstractC6670b.m4758s("setBaseItemVisibility animation= ", " penSelected=", TAG, animation, penSelected);
        if (!animation) {
            ImageView imageView = this.mPlusButton;
            if (imageView != null) {
                imageView.setVisibility(this.isCurrentPenValid ? 8 : 0);
            }
            SpenPenBaseView spenPenBaseView2 = this.mPenItem;
            if (spenPenBaseView2 != null) {
                spenPenBaseView2.setVisibility(this.isCurrentPenValid ? 0 : 8);
            }
            SpenPenAttrMiniView spenPenAttrMiniView = this.mAttrItem;
            if (spenPenAttrMiniView != null) {
                spenPenAttrMiniView.setVisibility(this.isCurrentPenValid ? 0 : 8);
            }
            SpenChipView spenChipView = this.mPatternItem;
            if (spenChipView != null) {
                spenChipView.setVisibility((this.isCurrentPenValid && this.isSupportParticleSize) ? 0 : 8);
            }
            ImageView imageView2 = this.mColorItem;
            if (imageView2 != null) {
                imageView2.setVisibility((!this.isCurrentPenValid || this.isSupportParticleSize) ? 8 : 0);
                return;
            }
            return;
        }
        final ImageView imageView3 = this.mPlusButton;
        if (imageView3 != null) {
            if (this.isCurrentPenValid) {
                startTranslationSpringAnimation(imageView3, imageView3.getTranslationY(), this.mPlusButtonHideTranslateY, 0L, new OnAnimationFinishedListener() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenQTPenItemVisibilityController$setBaseItemVisibility$1$1
                    @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenQTPenItemVisibilityController.OnAnimationFinishedListener
                    public void onAnimationFinished() {
                        imageView3.setVisibility(8);
                    }
                });
            } else {
                imageView3.setVisibility(0);
                imageView3.setScaleX(1.0f);
                imageView3.setScaleY(1.0f);
                startTranslationSpringAnimation(imageView3, imageView3.getTranslationY(), this.mPlusButtonShowTranslateY, 0L, endListener);
            }
        }
        View view = this.mPenItem;
        if (view != null) {
            if (this.isCurrentPenValid) {
                view.setVisibility(0);
                startTranslationSpringAnimation(view, view.getTranslationY(), penSelected ? this.mPenSelectedTranslateY : this.mPenUnselectedTranslateY, 0L, endListener);
            } else {
                startTranslationSpringAnimation$default(this, view, view.getTranslationY(), this.mPenHideTranslateY, 0L, null, 24, null);
            }
            if (penMaskingAnimation && (spenPenBaseView = this.mPenItem) != null) {
                spenPenBaseView.setSelected(false, true);
            }
        }
        long j2 = needStartDelay ? 350L : 0L;
        View view2 = this.mAttrItem;
        if (view2 == null) {
            j = j2;
        } else if (this.isCurrentPenValid) {
            startScaleUpVisibleAnimator(view2, 400L, j2);
            j = j2;
        } else {
            j = j2;
            startScaleDownGoneAnimator$default(this, view2, 350L, 0L, 4, null);
        }
        View view3 = this.mPatternItem;
        if (view3 != null) {
            if (this.isCurrentPenValid && this.isSupportParticleSize) {
                startScaleUpVisibleAnimator(view3, 400L, j);
            } else {
                startScaleDownGoneAnimator$default(this, view3, 350L, 0L, 4, null);
            }
        }
        View view4 = this.mColorItem;
        if (view4 != null) {
            if (!this.isCurrentPenValid || this.isSupportParticleSize) {
                startScaleDownGoneAnimator$default(this, view4, 350L, 0L, 4, null);
            } else {
                startScaleUpVisibleAnimator(view4, 400L, j);
            }
        }
    }

    public final void setCenterItemsVisibility(final boolean isShow, @Nullable final OnAnimationFinishedListener listener) {
        if (this.isCurrentPenValid) {
            View view = this.mPenItem;
            if (view != null) {
                float f = isShow ? this.mPenSelectedTranslateY : this.mPenHideTranslateY;
                if (view.getTranslationY() == f) {
                    return;
                }
                startTranslationSpringAnimation(view, view.getTranslationY(), f, 0L, listener);
                return;
            }
            return;
        }
        final ImageView imageView = this.mPlusButton;
        if (imageView != null) {
            float f4 = isShow ? this.mPlusButtonShowTranslateY : this.mPlusButtonHideTranslateY;
            if (imageView.getTranslationY() == f4) {
                return;
            }
            if (isShow) {
                imageView.setVisibility(0);
            }
            startTranslationSpringAnimation(imageView, imageView.getTranslationY(), f4, 0L, new OnAnimationFinishedListener() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenQTPenItemVisibilityController$setCenterItemsVisibility$2$1
                @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenQTPenItemVisibilityController.OnAnimationFinishedListener
                public void onAnimationFinished() {
                    if (!isShow) {
                        imageView.setVisibility(8);
                    }
                    SpenQTPenItemVisibilityController.OnAnimationFinishedListener onAnimationFinishedListener = listener;
                    if (onAnimationFinishedListener != null) {
                        onAnimationFinishedListener.onAnimationFinished();
                    }
                }
            });
        }
    }

    public final void setCurrentPenValid(boolean z) {
        this.isCurrentPenValid = z;
    }

    public final void setCurvedSwitchLayout(@NotNull SpenCurvedSwitchLayout switchLayout) {
        Intrinsics.checkNotNullParameter(switchLayout, "switchLayout");
        this.mCurvedSwitchLayout = switchLayout;
    }

    public final void setDockingMode(@NotNull SpenSettingQTLayout.DockingState state, int validItems, boolean animation) {
        Intrinsics.checkNotNullParameter(state, "state");
        StringBuilder sb = new StringBuilder("setDockingMode() state=");
        sb.append(state);
        sb.append(", animation=");
        AbstractC0000a.m27x(sb, animation, TAG);
        boolean z = state != SpenSettingQTLayout.DockingState.EXIT;
        setEdgeViewDockingMode(z, validItems, animation);
        if (this.isCurrentPenValid) {
            SpenPenBaseView spenPenBaseView = this.mPenItem;
            if (spenPenBaseView != null) {
                SpenSettingUtilAnimation spenSettingUtilAnimation = SpenSettingUtilAnimation.INSTANCE;
                DynamicAnimation.ViewProperty TRANSLATION_Y = DynamicAnimation.TRANSLATION_Y;
                Intrinsics.checkNotNullExpressionValue(TRANSLATION_Y, "TRANSLATION_Y");
                spenSettingUtilAnimation.startSpringAnimation(spenPenBaseView, TRANSLATION_Y, spenPenBaseView.getTranslationY(), 1.0f, 300.0f, z ? this.mPenUnselectedTranslateY : this.mPenSelectedTranslateY, (64 & 64) != 0 ? null : null);
                return;
            }
            return;
        }
        final ImageView imageView = this.mPlusButton;
        if (imageView != null) {
            float f = z ? 0.0f : 1.0f;
            long j = z ? 300L : 400L;
            final int i = z ? 8 : 0;
            imageView.animate().cancel();
            final int i2 = 0;
            ViewPropertyAnimator viewPropertyAnimatorWithStartAction = imageView.animate().scaleX(f).scaleY(f).setDuration(j).setStartDelay(0L).setInterpolator(SpenSettingUtilAnimation.getInterpolator(20)).withStartAction(new Runnable() { // from class: com.samsung.android.sdk.pen.setting.quicktool.h
                @Override // java.lang.Runnable
                public final void run() {
                    switch (i2) {
                        case 0:
                            SpenQTPenItemVisibilityController.setDockingMode$lambda$31$lambda$29(i, imageView);
                            break;
                        default:
                            SpenQTPenItemVisibilityController.setDockingMode$lambda$31$lambda$30(i, imageView);
                            break;
                    }
                }
            });
            final int i4 = 1;
            viewPropertyAnimatorWithStartAction.withEndAction(new Runnable() { // from class: com.samsung.android.sdk.pen.setting.quicktool.h
                @Override // java.lang.Runnable
                public final void run() {
                    switch (i4) {
                        case 0:
                            SpenQTPenItemVisibilityController.setDockingMode$lambda$31$lambda$29(i, imageView);
                            break;
                        default:
                            SpenQTPenItemVisibilityController.setDockingMode$lambda$31$lambda$30(i, imageView);
                            break;
                    }
                }
            }).setListener(null).start();
        }
    }

    public final void setPenPosition(@NotNull SpenSettingQTPenLayout.ViewMode fromMode, @NotNull SpenSettingQTPenLayout.ViewMode toMode, boolean animation) {
        ViewPropertyAnimator viewPropertyAnimatorScaleX;
        ViewPropertyAnimator viewPropertyAnimatorScaleY;
        ViewPropertyAnimator duration;
        ViewPropertyAnimator interpolator;
        Intrinsics.checkNotNullParameter(fromMode, "fromMode");
        Intrinsics.checkNotNullParameter(toMode, "toMode");
        SpenPenBaseView spenPenBaseView = this.mPenItem;
        if (spenPenBaseView != null) {
            int i = WhenMappings.$EnumSwitchMapping$0[toMode.ordinal()];
            float f = (i == 1 || i == 2) ? this.mPenSelectedTranslateY : i != 4 ? this.mPenUnselectedTranslateY : this.mPenHideTranslateY;
            if (fromMode != SpenSettingQTPenLayout.ViewMode.PEN_LIST) {
                long j = fromMode == SpenSettingQTPenLayout.ViewMode.COLOR_PICKER ? 200L : 0L;
                if (animation) {
                    startTranslationSpringAnimation$default(this, spenPenBaseView, spenPenBaseView.getTranslationY(), f, j, null, 16, null);
                    return;
                } else {
                    spenPenBaseView.setTranslationY(f);
                    return;
                }
            }
            if (!animation) {
                spenPenBaseView.setScaleX(1.0f);
                spenPenBaseView.setScaleY(1.0f);
                return;
            }
            spenPenBaseView.setScaleX(this.mPenItemScaleX);
            spenPenBaseView.setScaleY(this.mPenItemScaleY);
            spenPenBaseView.setPivotY(0.0f);
            spenPenBaseView.setTranslationY(this.mOffsetTranslateY);
            ViewPropertyAnimator viewPropertyAnimatorAnimate = spenPenBaseView.animate();
            if (viewPropertyAnimatorAnimate != null) {
                viewPropertyAnimatorAnimate.cancel();
            }
            ViewPropertyAnimator viewPropertyAnimatorAnimate2 = spenPenBaseView.animate();
            if (viewPropertyAnimatorAnimate2 == null || (viewPropertyAnimatorScaleX = viewPropertyAnimatorAnimate2.scaleX(1.0f)) == null || (viewPropertyAnimatorScaleY = viewPropertyAnimatorScaleX.scaleY(1.0f)) == null || (duration = viewPropertyAnimatorScaleY.setDuration(350L)) == null || (interpolator = duration.setInterpolator(SpenSettingUtilAnimation.getInterpolator(20))) == null) {
                return;
            }
            interpolator.start();
        }
    }

    public final void setPenPreviewVisibility(boolean animation, final boolean show) {
        if (animation) {
            final SpenPenBaseView spenPenBaseView = this.mPenItem;
            if (spenPenBaseView != null) {
                final boolean z = !show;
                spenPenBaseView.animate().cancel();
                spenPenBaseView.animate().alpha(!show ? 1.0f : 0.0f).setDuration(150L).setInterpolator(SpenSettingUtilAnimation.getInterpolator(15)).setStartDelay(0L).setListener(new Animator.AnimatorListener() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenQTPenItemVisibilityController$setPenPreviewVisibility$1$1
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animation2) {
                        Intrinsics.checkNotNullParameter(animation2, "animation");
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation2) {
                        Intrinsics.checkNotNullParameter(animation2, "animation");
                        if (z) {
                            return;
                        }
                        spenPenBaseView.setVisibility(8);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animation2) {
                        Intrinsics.checkNotNullParameter(animation2, "animation");
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animation2) {
                        Intrinsics.checkNotNullParameter(animation2, "animation");
                        if (z) {
                            spenPenBaseView.setVisibility(0);
                        }
                    }
                }).start();
            }
            final SpenPenPreviewV2 spenPenPreviewV2 = this.mPenPreview;
            if (spenPenPreviewV2 != null) {
                ViewPropertyAnimator viewPropertyAnimatorAnimate = spenPenPreviewV2.animate();
                if (viewPropertyAnimatorAnimate != null) {
                    viewPropertyAnimatorAnimate.cancel();
                }
                spenPenPreviewV2.animate().alpha(show ? 1.0f : 0.0f).setDuration(150L).setInterpolator(SpenSettingUtilAnimation.getInterpolator(15)).setListener(new Animator.AnimatorListener() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenQTPenItemVisibilityController$setPenPreviewVisibility$2$1
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animation2) {
                        Intrinsics.checkNotNullParameter(animation2, "animation");
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation2) {
                        Intrinsics.checkNotNullParameter(animation2, "animation");
                        if (show) {
                            return;
                        }
                        spenPenPreviewV2.setVisibility(8);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animation2) {
                        Intrinsics.checkNotNullParameter(animation2, "animation");
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animation2) {
                        Intrinsics.checkNotNullParameter(animation2, "animation");
                        if (show) {
                            spenPenPreviewV2.setVisibility(0);
                        }
                    }
                }).start();
                return;
            }
            return;
        }
        if (show) {
            SpenPenBaseView spenPenBaseView2 = this.mPenItem;
            if (spenPenBaseView2 != null) {
                spenPenBaseView2.setVisibility(8);
            }
            SpenPenPreviewV2 spenPenPreviewV22 = this.mPenPreview;
            if (spenPenPreviewV22 != null) {
                spenPenPreviewV22.setAlpha(1.0f);
            }
            SpenPenPreviewV2 spenPenPreviewV23 = this.mPenPreview;
            if (spenPenPreviewV23 != null) {
                spenPenPreviewV23.setVisibility(0);
                return;
            }
            return;
        }
        SpenPenPreviewV2 spenPenPreviewV24 = this.mPenPreview;
        if (spenPenPreviewV24 != null) {
            spenPenPreviewV24.setAlpha(0.0f);
        }
        SpenPenPreviewV2 spenPenPreviewV25 = this.mPenPreview;
        if (spenPenPreviewV25 != null) {
            spenPenPreviewV25.setVisibility(8);
        }
        SpenPenBaseView spenPenBaseView3 = this.mPenItem;
        if (spenPenBaseView3 != null) {
            spenPenBaseView3.setAlpha(1.0f);
        }
        SpenPenBaseView spenPenBaseView4 = this.mPenItem;
        if (spenPenBaseView4 != null) {
            spenPenBaseView4.setVisibility(0);
        }
    }

    public final void setSupportParticleSize(boolean z) {
        this.isSupportParticleSize = z;
    }

    public final void setViewMode(@NotNull SpenSettingQTPenLayout.ViewMode fromMode, @NotNull SpenSettingQTPenLayout.ViewMode toMode, boolean animation, boolean isSupportParticleSize) {
        Intrinsics.checkNotNullParameter(fromMode, "fromMode");
        Intrinsics.checkNotNullParameter(toMode, "toMode");
        if (fromMode == toMode) {
            return;
        }
        updateAttrItemVisibility(fromMode, toMode, animation);
        if (isSupportParticleSize) {
            ImageView imageView = this.mColorItem;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            updateEdgeItemVisibility(this.mPatternItem, fromMode, toMode, animation);
        } else {
            SpenChipView spenChipView = this.mPatternItem;
            if (spenChipView != null) {
                spenChipView.setVisibility(8);
            }
            updateEdgeItemVisibility(this.mColorItem, fromMode, toMode, animation);
        }
        updateCurvedSwitchVisibility(fromMode, toMode, animation);
        setPenPosition(fromMode, toMode, animation);
    }

    public final void startAnimation(boolean isShow) {
        AbstractC4539a.m3208r("startAnimation isShow= ", TAG, isShow);
        startPenItemAnimation(isShow);
        startEdgeItemAnimation(this.mAttrItem, isShow, true);
        if (this.isSupportParticleSize) {
            ImageView imageView = this.mColorItem;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            startEdgeItemAnimation$default(this, this.mPatternItem, isShow, false, 4, null);
            return;
        }
        SpenChipView spenChipView = this.mPatternItem;
        if (spenChipView != null) {
            spenChipView.setVisibility(8);
        }
        startEdgeItemAnimation$default(this, this.mColorItem, isShow, false, 4, null);
    }

    public final void startTranslationSpringAnimation(@NotNull View view, float fromTranslateY, float toTranslateY, long delayMillis, @Nullable OnAnimationFinishedListener listener) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (this.mSpringAnimationMap.get(view) == null) {
            this.mSpringAnimationMap.put(view, new SpringAnimation(view, DynamicAnimation.TRANSLATION_Y));
        }
        SpringAnimation springAnimation = this.mSpringAnimationMap.get(view);
        if (springAnimation != null) {
            view.setTranslationY(fromTranslateY);
            springAnimation.cancel();
            view.postDelayed(new RunnableC7856h(toTranslateY, springAnimation, listener), delayMillis);
        }
    }
}
