package com.samsung.android.sdk.pen.setting.quicktool;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import androidx.collection.AbstractC0622a;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.bixby2.action.ActionHandler;
import com.samsung.android.sdk.pen.setting.quicktool.SpenCurvedSwitchLayout;
import com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTContainer;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAnimation;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\u0085\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\t*\u0001C\b\u0016\u0018\u0000 H2\u00020\u0001:\u0003HIJB\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0006\u0010\nJ\u0018\u0010#\u001a\u00020$2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\b\u0010%\u001a\u00020$H\u0016J9\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u00052\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010,\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0002\u0010-J\u0010\u0010.\u001a\u00020$2\u0006\u0010'\u001a\u00020\u0005H\u0016J\u0010\u0010/\u001a\u00020$2\u0006\u00100\u001a\u00020\u0016H\u0016J\u001a\u00101\u001a\u00020\u001c2\u0006\u00102\u001a\u00020\u00052\b\u00100\u001a\u0004\u0018\u000103H\u0016J\u0016\u00104\u001a\u00020$2\u0006\u00102\u001a\u00020\u00052\u0006\u00105\u001a\u00020\u001cJ\u000e\u00106\u001a\u00020$2\u0006\u00107\u001a\u000208J\u001d\u00106\u001a\u00020$2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0000¢\u0006\u0002\b;J\u0015\u0010<\u001a\u00020$2\u0006\u00100\u001a\u00020=H\u0000¢\u0006\u0002\b>J#\u0010?\u001a\u00020$2\b\u0010'\u001a\u0004\u0018\u00010\u00052\b\u00100\u001a\u0004\u0018\u00010\"H\u0000¢\u0006\u0004\b@\u0010AJ\u0012\u0010E\u001a\u00020$2\b\u00100\u001a\u0004\u0018\u000103H\u0002J\u0012\u0010F\u001a\u00020$2\b\u00100\u001a\u0004\u0018\u000103H\u0002J\b\u0010G\u001a\u00020$H\u0002R\u001a\u0010\u000b\u001a\u00020\fX\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u00020\u001cX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u00020CX\u0082\u0004¢\u0006\u0004\n\u0002\u0010D¨\u0006K"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTContainer;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "modeCount", "", "<init>", "(Landroid/content/Context;I)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "switchView", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCurvedSwitchLayout;", "getSwitchView$SDK_fullRelease", "()Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCurvedSwitchLayout;", "setSwitchView$SDK_fullRelease", "(Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCurvedSwitchLayout;)V", "mModes", "", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCurvedSwitchLayout$Mode;", "[Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCurvedSwitchLayout$Mode;", "mModeChangedListener", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTContainer$OnModeChangedListener;", "mScaleXAnimation", "Landroidx/dynamicanimation/animation/SpringAnimation;", "mScaleYAnimation", "mRotateAnimation", "mIsAnimationRunning", "", "getMIsAnimationRunning$SDK_fullRelease", "()Z", "setMIsAnimationRunning$SDK_fullRelease", "(Z)V", "mModeBlockedEventListener", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTContainer$OnModeBlockedEventListener;", "construct", "", "close", "setMode", "mode", "unselectedResourceId", "selectedResourceId", "description", "", "switchColor", "(IIILjava/lang/CharSequence;Ljava/lang/Integer;)V", "changeMode", "setOnModeChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setVisibilityWithAnimation", "visibility", "Lcom/samsung/android/sdk/pen/setting/quicktool/OnVisibilityAnimationListener;", "setSwitchVisibility", "animation", "addViewBehindSwitch", "child", "Landroid/view/View;", ActionHandler.PARAMS, "Landroid/widget/FrameLayout$LayoutParams;", "addViewBehindSwitch$SDK_fullRelease", "setOnSwitchDragListener", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCurvedSwitchLayout$OnSwitchDragListener;", "setOnSwitchDragListener$SDK_fullRelease", "blockSwitchModeAccessOnClick", "blockSwitchModeAccessOnClick$SDK_fullRelease", "(Ljava/lang/Integer;Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTContainer$OnModeBlockedEventListener;)V", "mSwitchModeBlockedEventListener", "com/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTContainer$mSwitchModeBlockedEventListener$1", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTContainer$mSwitchModeBlockedEventListener$1;", "startShowAnimation", "startHideAnimation", "cancelAnimation", "Companion", "OnModeChangedListener", "OnModeBlockedEventListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public class SpenSettingQTContainer extends FrameLayout {
    private static final int DEFAULT_MODE_COUNT = 3;
    private static final float HIDE_ANGLE_ROTATION = -180.0f;
    private static final float HIDE_BASE_ALPHA = 0.0f;
    private static final float HIDE_BASE_SCALE = 0.0f;
    private static final float SHOW_ANGLE_ROTATION = 0.0f;
    private static final float SHOW_BASE_ALPHA = 1.0f;
    private static final float SHOW_BASE_SCALE = 1.0f;

    @NotNull
    private static final String TAG = "SpenSettingQTContainer";
    private static final long VI_ALPHA_HIDE_DURATION = 100;
    private static final long VI_ALPHA_SHOW_DURATION = 200;
    private static final float VI_ROTATION_DAMPING_RATIO = 0.55f;
    private static final float VI_ROTATION_STIFFNESS = 200.0f;
    private static final float VI_SWITCH_ROTATION_DAMPING_RATIO = 0.6f;
    private boolean mIsAnimationRunning;

    @Nullable
    private OnModeBlockedEventListener mModeBlockedEventListener;

    @Nullable
    private OnModeChangedListener mModeChangedListener;

    @NotNull
    private final SpenCurvedSwitchLayout.Mode[] mModes;

    @Nullable
    private SpringAnimation mRotateAnimation;

    @Nullable
    private SpringAnimation mScaleXAnimation;

    @Nullable
    private SpringAnimation mScaleYAnimation;

    @NotNull
    private final SpenSettingQTContainer$mSwitchModeBlockedEventListener$1 mSwitchModeBlockedEventListener;
    public SpenCurvedSwitchLayout switchView;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTContainer$OnModeBlockedEventListener;", "", "onModeBlocked", "", "mode", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnModeBlockedEventListener {
        void onModeBlocked(int mode);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTContainer$OnModeChangedListener;", "", "onModeChanged", "", "mode", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnModeChangedListener {
        void onModeChanged(int mode);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTContainer$mSwitchModeBlockedEventListener$1] */
    public SpenSettingQTContainer(@NotNull Context context, int i) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mModes = new SpenCurvedSwitchLayout.Mode[]{SpenCurvedSwitchLayout.Mode.BASIC, SpenCurvedSwitchLayout.Mode.STANDARD, SpenCurvedSwitchLayout.Mode.ADVANCED};
        this.mSwitchModeBlockedEventListener = new SpenCurvedSwitchLayout.OnModeBlockedEventListener() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTContainer$mSwitchModeBlockedEventListener$1
            @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenCurvedSwitchLayout.OnModeBlockedEventListener
            public void onModeBlocked(SpenCurvedSwitchLayout.Mode mode) {
                Intrinsics.checkNotNullParameter(mode, "mode");
                SpenSettingQTContainer.OnModeBlockedEventListener onModeBlockedEventListener = this.this$0.mModeBlockedEventListener;
                if (onModeBlockedEventListener != null) {
                    onModeBlockedEventListener.onModeBlocked(ArraysKt.indexOf(this.this$0.mModes, mode));
                }
            }
        };
        if (2 > i || i >= 4) {
            throw new IllegalArgumentException("ModeCount should be between 2 or 3");
        }
        construct(context, i);
    }

    private final void cancelAnimation() {
        if (this.mIsAnimationRunning) {
            SpringAnimation springAnimation = this.mScaleXAnimation;
            if (springAnimation != null) {
                springAnimation.cancel();
            }
            SpringAnimation springAnimation2 = this.mScaleYAnimation;
            if (springAnimation2 != null) {
                springAnimation2.cancel();
            }
            SpringAnimation springAnimation3 = this.mRotateAnimation;
            if (springAnimation3 != null) {
                springAnimation3.cancel();
            }
        }
    }

    private final void construct(Context context, int modeCount) {
        setSwitchView$SDK_fullRelease(new SpenCurvedSwitchLayout(context, modeCount));
        getSwitchView$SDK_fullRelease().setOnModeChangedListener(new SpenCurvedSwitchLayout.OnModeChangedListener() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTContainer.construct.1
            @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenCurvedSwitchLayout.OnModeChangedListener
            public void onModeChanged(SpenCurvedSwitchLayout.Mode mode) {
                OnModeChangedListener onModeChangedListener;
                Intrinsics.checkNotNullParameter(mode, "mode");
                int iIndexOf = ArraysKt.indexOf(SpenSettingQTContainer.this.mModes, mode);
                Log.i(SpenSettingQTContainer.TAG, "onModeChanged() mode=" + mode + ", index=" + iIndexOf);
                if (iIndexOf == -1 || (onModeChangedListener = SpenSettingQTContainer.this.mModeChangedListener) == null) {
                    return;
                }
                onModeChangedListener.onModeChanged(iIndexOf);
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        addView(getSwitchView$SDK_fullRelease(), layoutParams);
    }

    private final void startHideAnimation(final OnVisibilityAnimationListener listener) {
        DynamicAnimation.OnAnimationEndListener onAnimationEndListener = new DynamicAnimation.OnAnimationEndListener() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTContainer$startHideAnimation$animationEnd$1
            @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener
            public void onAnimationEnd(DynamicAnimation<?> animation, boolean canceled, float value, float velocity) {
                this.this$0.setVisibility(8);
                this.this$0.setMIsAnimationRunning$SDK_fullRelease(false);
                OnVisibilityAnimationListener onVisibilityAnimationListener = listener;
                if (onVisibilityAnimationListener != null) {
                    onVisibilityAnimationListener.onAnimationEnd(8, canceled);
                }
            }
        };
        animate().alpha(0.0f).setDuration(100L).setInterpolator(SpenSettingUtilAnimation.getInterpolator(15)).start();
        SpenSettingUtilAnimation spenSettingUtilAnimation = SpenSettingUtilAnimation.INSTANCE;
        DynamicAnimation.ViewProperty SCALE_X = DynamicAnimation.SCALE_X;
        Intrinsics.checkNotNullExpressionValue(SCALE_X, "SCALE_X");
        this.mScaleXAnimation = spenSettingUtilAnimation.startSpringAnimation(this, SCALE_X, 1.0f, 0.55f, 200.0f, 0.0f, onAnimationEndListener);
        DynamicAnimation.ViewProperty SCALE_Y = DynamicAnimation.SCALE_Y;
        Intrinsics.checkNotNullExpressionValue(SCALE_Y, "SCALE_Y");
        this.mScaleYAnimation = spenSettingUtilAnimation.startSpringAnimation(this, SCALE_Y, 1.0f, 0.55f, 200.0f, 0.0f, (64 & 64) != 0 ? null : null);
        if (listener != null) {
            listener.onAnimationStart(8);
        }
        this.mIsAnimationRunning = true;
        getSwitchView$SDK_fullRelease().setAlpha(1.0f);
        getSwitchView$SDK_fullRelease().animate().alpha(0.0f).setDuration(100L).setInterpolator(SpenSettingUtilAnimation.getInterpolator(15)).setStartDelay(0L).withStartAction(new RunnableC7659k(this, 2)).withEndAction(new RunnableC7659k(this, 3)).start();
        SpenCurvedSwitchLayout switchView$SDK_fullRelease = getSwitchView$SDK_fullRelease();
        DynamicAnimation.ViewProperty ROTATION = DynamicAnimation.ROTATION;
        Intrinsics.checkNotNullExpressionValue(ROTATION, "ROTATION");
        this.mRotateAnimation = spenSettingUtilAnimation.startSpringAnimation(switchView$SDK_fullRelease, ROTATION, 0.0f, 0.6f, 200.0f, HIDE_ANGLE_ROTATION, (64 & 64) != 0 ? null : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startHideAnimation$lambda$5(SpenSettingQTContainer spenSettingQTContainer) {
        spenSettingQTContainer.getSwitchView$SDK_fullRelease().setLayerType(2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startHideAnimation$lambda$6(SpenSettingQTContainer spenSettingQTContainer) {
        spenSettingQTContainer.getSwitchView$SDK_fullRelease().setLayerType(0, null);
    }

    private final void startShowAnimation(final OnVisibilityAnimationListener listener) {
        DynamicAnimation.OnAnimationEndListener onAnimationEndListener = new DynamicAnimation.OnAnimationEndListener() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTContainer$startShowAnimation$animationEnd$1
            @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener
            public void onAnimationEnd(DynamicAnimation<?> animation, boolean canceled, float value, float velocity) {
                this.this$0.setMIsAnimationRunning$SDK_fullRelease(false);
                OnVisibilityAnimationListener onVisibilityAnimationListener = listener;
                if (onVisibilityAnimationListener != null) {
                    onVisibilityAnimationListener.onAnimationEnd(0, canceled);
                }
            }
        };
        setVisibility(0);
        setAlpha(1.0f);
        SpenSettingUtilAnimation spenSettingUtilAnimation = SpenSettingUtilAnimation.INSTANCE;
        DynamicAnimation.ViewProperty SCALE_X = DynamicAnimation.SCALE_X;
        Intrinsics.checkNotNullExpressionValue(SCALE_X, "SCALE_X");
        this.mScaleXAnimation = spenSettingUtilAnimation.startSpringAnimation(this, SCALE_X, 0.0f, 0.55f, 200.0f, 1.0f, onAnimationEndListener);
        DynamicAnimation.ViewProperty SCALE_Y = DynamicAnimation.SCALE_Y;
        Intrinsics.checkNotNullExpressionValue(SCALE_Y, "SCALE_Y");
        this.mScaleYAnimation = spenSettingUtilAnimation.startSpringAnimation(this, SCALE_Y, 0.0f, 0.55f, 200.0f, 1.0f, (64 & 64) != 0 ? null : null);
        if (listener != null) {
            listener.onAnimationStart(0);
        }
        this.mIsAnimationRunning = true;
        getSwitchView$SDK_fullRelease().setAlpha(0.0f);
        getSwitchView$SDK_fullRelease().animate().alpha(1.0f).setDuration(200L).setInterpolator(SpenSettingUtilAnimation.getInterpolator(15)).withStartAction(new RunnableC7659k(this, 0)).withEndAction(new RunnableC7659k(this, 1)).start();
        SpenCurvedSwitchLayout switchView$SDK_fullRelease = getSwitchView$SDK_fullRelease();
        DynamicAnimation.ViewProperty ROTATION = DynamicAnimation.ROTATION;
        Intrinsics.checkNotNullExpressionValue(ROTATION, "ROTATION");
        this.mRotateAnimation = spenSettingUtilAnimation.startSpringAnimation(switchView$SDK_fullRelease, ROTATION, HIDE_ANGLE_ROTATION, 0.6f, 200.0f, 0.0f, (64 & 64) != 0 ? null : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startShowAnimation$lambda$3(SpenSettingQTContainer spenSettingQTContainer) {
        spenSettingQTContainer.getSwitchView$SDK_fullRelease().setLayerType(2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startShowAnimation$lambda$4(SpenSettingQTContainer spenSettingQTContainer) {
        spenSettingQTContainer.getSwitchView$SDK_fullRelease().setLayerType(0, null);
    }

    public final void addViewBehindSwitch(@NotNull View child) {
        Intrinsics.checkNotNullParameter(child, "child");
        SpenSettingQTLayout spenSettingQTLayout = child instanceof SpenSettingQTLayout ? (SpenSettingQTLayout) child : null;
        if (spenSettingQTLayout != null) {
            spenSettingQTLayout.setVisibilityAnimationEnabled$SDK_fullRelease(false);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        super.addView(child, getChildCount() - 1, layoutParams);
    }

    public final void addViewBehindSwitch$SDK_fullRelease(@NotNull View child, @NotNull FrameLayout.LayoutParams params) {
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(params, "params");
        super.addView(child, getChildCount() - 1, params);
    }

    public final void blockSwitchModeAccessOnClick$SDK_fullRelease(@Nullable Integer mode, @Nullable OnModeBlockedEventListener listener) {
        SpenCurvedSwitchLayout.Mode mode2 = mode != null ? this.mModes[mode.intValue()] : null;
        this.mModeBlockedEventListener = listener;
        getSwitchView$SDK_fullRelease().blockModeAccessOnClick(mode2, listener != null ? this.mSwitchModeBlockedEventListener : null);
    }

    public void changeMode(int mode) {
        if (mode < 0 || mode >= 3) {
            throw new IllegalArgumentException("Mod should be between 0 and 2");
        }
        getSwitchView$SDK_fullRelease().changeMode(this.mModes[mode]);
    }

    public void close() {
        getSwitchView$SDK_fullRelease().close();
    }

    /* JADX INFO: renamed from: getMIsAnimationRunning$SDK_fullRelease, reason: from getter */
    public final boolean getMIsAnimationRunning() {
        return this.mIsAnimationRunning;
    }

    @NotNull
    public final SpenCurvedSwitchLayout getSwitchView$SDK_fullRelease() {
        SpenCurvedSwitchLayout spenCurvedSwitchLayout = this.switchView;
        if (spenCurvedSwitchLayout != null) {
            return spenCurvedSwitchLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("switchView");
        return null;
    }

    public final void setMIsAnimationRunning$SDK_fullRelease(boolean z) {
        this.mIsAnimationRunning = z;
    }

    public void setMode(int mode, int unselectedResourceId, int selectedResourceId, @Nullable CharSequence description, @Nullable Integer switchColor) {
        if (mode < 0 || mode >= 3) {
            throw new IllegalArgumentException("Mode should be between 0 and 2");
        }
        StringBuilder sbM1173s = AbstractC0622a.m1173s(mode, unselectedResourceId, "setMode() mode=", ", unselectedResourceId=", ", selectedResourceId=");
        sbM1173s.append(selectedResourceId);
        sbM1173s.append(", description=");
        sbM1173s.append((Object) description);
        Log.i(TAG, sbM1173s.toString());
        getSwitchView$SDK_fullRelease().setModeInfo(this.mModes[mode], unselectedResourceId, selectedResourceId, description, switchColor);
    }

    public void setOnModeChangedListener(@NotNull OnModeChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mModeChangedListener = listener;
    }

    public final void setOnSwitchDragListener$SDK_fullRelease(@NotNull SpenCurvedSwitchLayout.OnSwitchDragListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        getSwitchView$SDK_fullRelease().setOnSwitchDragListener(listener);
    }

    public final void setSwitchView$SDK_fullRelease(@NotNull SpenCurvedSwitchLayout spenCurvedSwitchLayout) {
        Intrinsics.checkNotNullParameter(spenCurvedSwitchLayout, "<set-?>");
        this.switchView = spenCurvedSwitchLayout;
    }

    public final void setSwitchVisibility(int visibility, boolean animation) {
        getSwitchView$SDK_fullRelease().setVisibility(visibility);
    }

    public boolean setVisibilityWithAnimation(int visibility, @Nullable OnVisibilityAnimationListener listener) {
        AbstractC6670b.m4754o("setVisibilityWithAnimation visibility=", visibility, " mIsAnimationRunning=", this.mIsAnimationRunning, TAG);
        cancelAnimation();
        if (visibility == 0) {
            startShowAnimation(listener);
            return true;
        }
        if (visibility != 8) {
            super.setVisibility(visibility);
            return true;
        }
        startHideAnimation(listener);
        return true;
    }

    public /* synthetic */ SpenSettingQTContainer(Context context, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? 3 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r4v3, types: [com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTContainer$mSwitchModeBlockedEventListener$1] */
    public SpenSettingQTContainer(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mModes = new SpenCurvedSwitchLayout.Mode[]{SpenCurvedSwitchLayout.Mode.BASIC, SpenCurvedSwitchLayout.Mode.STANDARD, SpenCurvedSwitchLayout.Mode.ADVANCED};
        this.mSwitchModeBlockedEventListener = new SpenCurvedSwitchLayout.OnModeBlockedEventListener() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTContainer$mSwitchModeBlockedEventListener$1
            @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenCurvedSwitchLayout.OnModeBlockedEventListener
            public void onModeBlocked(SpenCurvedSwitchLayout.Mode mode) {
                Intrinsics.checkNotNullParameter(mode, "mode");
                SpenSettingQTContainer.OnModeBlockedEventListener onModeBlockedEventListener = this.this$0.mModeBlockedEventListener;
                if (onModeBlockedEventListener != null) {
                    onModeBlockedEventListener.onModeBlocked(ArraysKt.indexOf(this.this$0.mModes, mode));
                }
            }
        };
        construct(context, 3);
    }
}
