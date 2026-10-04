package com.samsung.android.support.senl.p148nt.base.winset.view.floater;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.ViewFlipper;
import androidx.appcompat.animation.C0421a;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.messaging.Constants;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.bixby2.action.ActionHandler;
import com.samsung.android.spr.drawable.animation.interpolator.SineInOut60;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.base.winset.view.floater.IDock;
import com.samsung.android.support.senl.p148nt.base.winset.view.floater.IFloater;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 ¡\u00012\u00020\u0001:\u0006\u009f\u0001 \u0001¡\u0001B!\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u000109J\u000e\u0010:\u001a\u0002072\u0006\u0010\u0004\u001a\u000201J\u0006\u0010;\u001a\u000207J\u0010\u00106\u001a\u0002072\u0006\u00108\u001a\u00020)H\u0002J\u0016\u0010<\u001a\u0002072\u0006\u0010=\u001a\u00020\u00102\u0006\u0010>\u001a\u00020\u000eJ\u0016\u0010?\u001a\u0002072\u0006\u0010=\u001a\u00020\u00102\u0006\u0010@\u001a\u000203J\u000e\u0010A\u001a\u0002032\u0006\u0010=\u001a\u00020\u0010J\u000e\u0010B\u001a\u0002072\u0006\u0010C\u001a\u00020+J\u0006\u0010H\u001a\u000207J\u0010\u0010I\u001a\u0002072\b\u0010J\u001a\u0004\u0018\u00010\u0003J\u0010\u0010K\u001a\u0002072\b\u0010J\u001a\u0004\u0018\u00010\u0003J&\u0010L\u001a\u0002072\u0006\u0010J\u001a\u00020\u00032\u0006\u0010M\u001a\u00020+2\u0006\u0010N\u001a\u00020+2\u0006\u0010O\u001a\u00020\u0010J@\u0010P\u001a\u0002072\u0006\u0010J\u001a\u00020\u00032\u0006\u0010Q\u001a\u00020+2\u0006\u0010R\u001a\u00020+2\u0006\u0010S\u001a\u00020+2\u0006\u0010T\u001a\u00020+2\u0006\u0010U\u001a\u0002032\b\u0010V\u001a\u0004\u0018\u00010WJ\u000e\u0010X\u001a\u0002072\u0006\u0010Y\u001a\u00020\u0010J\u0006\u0010Z\u001a\u000207J\u0018\u0010[\u001a\u0002072\u0006\u0010\\\u001a\u0002032\u0006\u0010]\u001a\u000203H\u0002J\u001e\u0010[\u001a\u0002072\u0006\u0010O\u001a\u00020\u00102\u0006\u0010\\\u001a\u0002032\u0006\u0010]\u001a\u000203J\u0018\u0010^\u001a\u0002072\u0006\u0010_\u001a\u0002032\u0006\u0010]\u001a\u000203H\u0002J\u0018\u0010`\u001a\u0002072\u0006\u0010a\u001a\u00020+2\u0006\u0010b\u001a\u00020+H\u0002J\u0010\u0010c\u001a\u0002072\u0006\u0010d\u001a\u00020+H\u0002J\u000e\u0010e\u001a\u0002072\u0006\u0010_\u001a\u000203JB\u0010l\u001a\u0002072\u0006\u0010J\u001a\u00020\u00032\u0006\u0010Q\u001a\u00020+2\u0006\u0010R\u001a\u00020+2\u0006\u0010S\u001a\u00020+2\u0006\u0010T\u001a\u00020+2\u0006\u0010U\u001a\u0002032\b\u0010V\u001a\u0004\u0018\u00010WH\u0002J(\u0010m\u001a\u0002072\b\u0010J\u001a\u0004\u0018\u00010\u00032\u0006\u0010n\u001a\u00020+2\u0006\u0010o\u001a\u00020+2\u0006\u0010p\u001a\u00020+J\u0012\u0010q\u001a\u0002072\b\u0010r\u001a\u0004\u0018\u00010\u001cH\u0002J0\u0010s\u001a\u0002072\u0006\u0010J\u001a\u00020\u00032\u0006\u0010t\u001a\u00020+2\u0006\u0010u\u001a\u00020+2\u0006\u0010o\u001a\u00020+2\u0006\u0010p\u001a\u00020+H\u0002J\u0006\u0010v\u001a\u000207J\u0018\u0010w\u001a\u0002072\u0006\u0010x\u001a\u00020y2\b\u0010z\u001a\u0004\u0018\u00010WJ\u0010\u0010{\u001a\u0002072\b\u0010|\u001a\u0004\u0018\u00010'J\u000e\u0010}\u001a\u0002072\u0006\u0010~\u001a\u00020\u0010J\u000e\u0010\u007f\u001a\u0002072\u0006\u0010~\u001a\u00020\u0010J\u0016\u0010\u007f\u001a\u0002032\u0006\u0010=\u001a\u00020\u00102\u0006\u0010~\u001a\u00020\u0010J\u0007\u0010\u0080\u0001\u001a\u000207J\u000f\u0010\u0081\u0001\u001a\u0002072\u0006\u0010=\u001a\u00020\u0010J\u0011\u0010\u0083\u0001\u001a\u00020\u00102\u0006\u0010=\u001a\u00020\u0010H\u0002J\u0017\u0010\u0084\u0001\u001a\u0002072\u0006\u0010=\u001a\u00020\u00102\u0006\u0010~\u001a\u00020\u0010J\u0010\u0010\u0085\u0001\u001a\u00030\u0086\u00012\u0006\u0010=\u001a\u00020\u0010J\u0010\u0010\u0087\u0001\u001a\u0002072\u0007\u0010\u0088\u0001\u001a\u00020\u0010J\u0013\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u000e2\u0006\u0010=\u001a\u00020\u0010H\u0002J\u0007\u0010\u008b\u0001\u001a\u000207J\t\u0010\u008c\u0001\u001a\u000207H\u0002J\u0007\u0010\u008f\u0001\u001a\u000207J\u0011\u0010\u0090\u0001\u001a\u0002072\b\u0010\u0091\u0001\u001a\u00030\u0092\u0001J\u0011\u0010\u0093\u0001\u001a\u0002072\b\u0010\u0091\u0001\u001a\u00030\u0092\u0001J\u0011\u0010\u0094\u0001\u001a\u0002072\b\u0010\u0091\u0001\u001a\u00030\u0092\u0001J#\u0010\u0095\u0001\u001a\u0002032\b\u0010\u0096\u0001\u001a\u00030\u0092\u00012\u0007\u0010\u0097\u0001\u001a\u00020+2\u0007\u0010\u0098\u0001\u001a\u00020+J\u0013\u0010\u0099\u0001\u001a\u0002032\b\u0010\u0096\u0001\u001a\u00030\u0092\u0001H\u0002J\u001b\u0010\u009a\u0001\u001a\u0002032\u0007\u0010\u0097\u0001\u001a\u00020+2\u0007\u0010\u0098\u0001\u001a\u00020+H\u0002J\u0013\u0010\u009b\u0001\u001a\u0002032\b\u0010\u0091\u0001\u001a\u00030\u0092\u0001H\u0002J\u0012\u0010\u009c\u0001\u001a\u0002032\u0007\u0010\u009d\u0001\u001a\u00020\u0010H\u0002J\u0012\u0010\u009e\u0001\u001a\u0002032\u0007\u0010\u009d\u0001\u001a\u00020\u0010H\u0002R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0010\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00030\u00030\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0010@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00100\u001a\b\u0012\u0004\u0012\u0002010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000203X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000203X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010D\u001a\u00020\u00102\u0006\u0010D\u001a\u00020\u00108F@BX\u0086\u000e¢\u0006\f\u001a\u0004\bE\u0010\u001a\"\u0004\bF\u0010GR\u0011\u0010f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\bg\u0010\u001aR\u0011\u0010h\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\bi\u0010\u001aR\u0011\u0010j\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\bk\u0010\u001aR\u0013\u0010\u0082\u0001\u001a\u00020\u00108F¢\u0006\u0007\u001a\u0005\b\u0083\u0001\u0010\u001aR\u0018\u0010>\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001R\u0014\u0010\u008d\u0001\u001a\u0002038F¢\u0006\b\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001¨\u0006¢\u0001"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/view/floater/FloaterDelegate;", "", "floatView", "Landroid/view/View;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/support/senl/nt/base/winset/view/floater/ActionProcessListener;", "contract", "Lcom/samsung/android/support/senl/nt/base/winset/view/floater/IFloater$IViewContract;", "<init>", "(Landroid/view/View;Lcom/samsung/android/support/senl/nt/base/winset/view/floater/ActionProcessListener;Lcom/samsung/android/support/senl/nt/base/winset/view/floater/IFloater$IViewContract;)V", "mActionListener", "mViewContract", "mDocks", "", "Lcom/samsung/android/support/senl/nt/base/winset/view/floater/IDock;", "mBlockadedDocks", "", "mDockerInsetSizes", "", "mFloatViewRef", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "mState", "value", "dockingType", "getDockingType", "()I", "mPositionXAnimator", "Landroidx/dynamicanimation/animation/SpringAnimation;", "mPositionYAnimator", "mScaleXAnimator", "mScaleYAnimator", "mFlyXAnimator", "mFlyYAnimator", "mTranslationXAnimator", "mTranslationYAnimator", "mDockAnimator", "Landroid/animation/AnimatorSet;", "mDockingParam", "Lcom/samsung/android/support/senl/nt/base/winset/view/floater/IDock$AlignmentParam;", "mRoundableBG", "Landroid/graphics/drawable/GradientDrawable;", "mDefaultRound", "", "mCurrentRound", "mDefaultMarginStart", "mDefaultMarginEnd", "mDefaultPaddingEnd", "mModeChangeListeners", "Lcom/samsung/android/support/senl/nt/base/winset/view/floater/IFloater$ModeChangeListener;", "mIsReadyToScroll", "", "mIsReadyToFlip", "mIsReadyToSeek", "setBackground", "", "drawable", "Landroid/graphics/drawable/Drawable;", "addModeChangeListener", "initLayout", "addDock", "id", "dock", "blockadeDock", "blockade", "isBlockaded", "setDefaultCornerRadius", "radius", "state", "getState", "setState", "(I)V", "stopActions", "startDrag", "view", "endDrag", "reboundOnDropZone", "x", "y", "type", "fly", "targetX", "targetY", "velocityX", "velocityY", "isBounded", "withEndAction", "Ljava/lang/Runnable;", "setDockSide", "dockingSide", "onUnDocking", "onDocking", "docking", "withAnimation", "enabledRound", "enable", "runRoundAnimation", Constants.MessagePayloadKeys.FROM, "to", "setBGCornerRadius", "corner", "enableMargin", "dockingPosStartX", "getDockingPosStartX", "dockingPosEndX", "getDockingPosEndX", "dockingSize", "getDockingSize", "runFlyAnimation", "runScaleAnimation", "targetScale", "stiffness", "dampingRatio", "cancelSpringAnimation", "animation", "runPositionAnimation", "targetPosX", "targetPosY", "cancelTranslationAnimation", "runTranslationAnimation", "dstPoint", "Landroid/graphics/Point;", "endAction", "setDockParams", ActionHandler.PARAMS, "changeDockerSize", "size", "openDocker", "closeAllDocker", "hideDockOthers", "dockerInsetSize", "getDockerInsetSize", "setDockerInsetSize", "getGlobalVisibleRect", "Landroid/graphics/Rect;", "setDockerVisibility", "visibility", "getDock", "()Lcom/samsung/android/support/senl/nt/base/winset/view/floater/IDock;", "release", "cancelDockingAnimation", "isInterceptedTouchEvent", "()Z", "deInitInterceptTouchEvent", "initInterceptScroll", "point", "Landroid/graphics/PointF;", "initInterceptFlipper", "initInterceptSeekBar", "canStartToMove", "touchPoint", "distanceX", "distanceY", "canStartToMoveFromSeekBar", "canStartToMoveFromFlipper", "canStartToMoveFromScroll", "canHorizontalScroll", "direction", "canVerticalScroll", "DefaultAnimatorListener", "AnimatorEndListener", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nFloaterDelegate.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FloaterDelegate.kt\ncom/samsung/android/support/senl/nt/base/winset/view/floater/FloaterDelegate\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,765:1\n1#2:766\n*E\n"})
public final class FloaterDelegate {
    private static final float FLY_VELOCITY_MIN_LIMIT = 2000.0f;

    @NotNull
    private static final String TAG = "FloaterDelegate";
    private static final int VELOCITY_UNIT = 1000;
    private int dockingType;

    @NotNull
    private final ActionProcessListener mActionListener;

    @NotNull
    private final List<Integer> mBlockadedDocks;
    private float mCurrentRound;
    private int mDefaultMarginEnd;
    private int mDefaultMarginStart;
    private int mDefaultPaddingEnd;
    private float mDefaultRound;

    @Nullable
    private AnimatorSet mDockAnimator;

    @NotNull
    private final Map<Integer, Integer> mDockerInsetSizes;

    @Nullable
    private IDock.AlignmentParam mDockingParam;

    @NotNull
    private final List<IDock> mDocks;

    @NotNull
    private final WeakReference<View> mFloatViewRef;

    @Nullable
    private SpringAnimation mFlyXAnimator;

    @Nullable
    private SpringAnimation mFlyYAnimator;
    private boolean mIsReadyToFlip;
    private boolean mIsReadyToScroll;
    private boolean mIsReadyToSeek;

    @NotNull
    private final List<IFloater.ModeChangeListener> mModeChangeListeners;

    @Nullable
    private SpringAnimation mPositionXAnimator;

    @Nullable
    private SpringAnimation mPositionYAnimator;

    @Nullable
    private GradientDrawable mRoundableBG;

    @Nullable
    private SpringAnimation mScaleXAnimator;

    @Nullable
    private SpringAnimation mScaleYAnimator;
    private int mState;

    @Nullable
    private SpringAnimation mTranslationXAnimator;

    @Nullable
    private SpringAnimation mTranslationYAnimator;

    @NotNull
    private final IFloater.IViewContract mViewContract;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\u000bJ,\u0010\u000f\u001a\u00020\u00102\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u00122\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0016R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/view/floater/FloaterDelegate$DefaultAnimatorListener;", "Lcom/samsung/android/support/senl/nt/base/winset/view/floater/FloaterDelegate$AnimatorEndListener;", "Lcom/samsung/android/support/senl/nt/base/winset/view/floater/FloaterDelegate;", "name", "", "<init>", "(Lcom/samsung/android/support/senl/nt/base/winset/view/floater/FloaterDelegate;Ljava/lang/String;)V", "needUpdate", "", "withEndAction", "Ljava/lang/Runnable;", "(Lcom/samsung/android/support/senl/nt/base/winset/view/floater/FloaterDelegate;Ljava/lang/String;ZLjava/lang/Runnable;)V", "mCount", "", "mWithEndAction", "onAnimationEnd", "", "animation", "Landroidx/dynamicanimation/animation/DynamicAnimation;", "canceled", "value", "", "velocity", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public final class DefaultAnimatorListener extends AnimatorEndListener {
        private int mCount;

        @Nullable
        private Runnable mWithEndAction;
        final /* synthetic */ FloaterDelegate this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DefaultAnimatorListener(@NotNull FloaterDelegate floaterDelegate, String name) {
            super(floaterDelegate, name);
            Intrinsics.checkNotNullParameter(name, "name");
            this.this$0 = floaterDelegate;
        }

        @Override // com.samsung.android.support.senl.nt.base.winset.view.floater.FloaterDelegate.AnimatorEndListener, androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener
        public void onAnimationEnd(@NotNull DynamicAnimation<?> animation, boolean canceled, float value, float velocity) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            int i = this.mCount + 1;
            this.mCount = i;
            if (i == 2) {
                super.onAnimationEnd(animation, canceled, value, velocity);
                Runnable runnable = this.mWithEndAction;
                if (runnable != null) {
                    runnable.run();
                }
                this.mWithEndAction = null;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DefaultAnimatorListener(@NotNull FloaterDelegate floaterDelegate, String name, @Nullable boolean z, Runnable runnable) {
            super(floaterDelegate, name, z);
            Intrinsics.checkNotNullParameter(name, "name");
            this.this$0 = floaterDelegate;
            this.mWithEndAction = runnable;
        }
    }

    public FloaterDelegate(@NotNull View floatView, @NotNull ActionProcessListener listener, @NotNull IFloater.IViewContract contract) {
        Intrinsics.checkNotNullParameter(floatView, "floatView");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(contract, "contract");
        this.mActionListener = listener;
        this.mViewContract = contract;
        this.mDocks = new ArrayList();
        this.mBlockadedDocks = new ArrayList();
        this.mDockerInsetSizes = new HashMap();
        this.mFloatViewRef = new WeakReference<>(floatView);
        this.dockingType = -1;
        this.mModeChangeListeners = new ArrayList();
        setBackground(floatView.getBackground());
    }

    private final boolean canHorizontalScroll(int direction) {
        if (!FloaterUtil.INSTANCE.isHorizontalScrollable(direction)) {
            return false;
        }
        View view = this.mFloatViewRef.get();
        Float fValueOf = null;
        if (view != null) {
            float x = view.getX();
            View view2 = this.mFloatViewRef.get();
            Intrinsics.checkNotNull(view2 != null ? Integer.valueOf(view2.getWidth()) : null);
            fValueOf = Float.valueOf(x + r1.intValue());
        }
        Intrinsics.checkNotNull(fValueOf);
        if ((this.mViewContract.getMEndEdgeSize() / 2) + this.mViewContract.getMParentWidth() >= fValueOf.floatValue()) {
            return true;
        }
        Logger.m8697d(TAG, "can start move X - change  scrollable");
        return false;
    }

    private final boolean canStartToMoveFromFlipper(float distanceX, float distanceY) {
        if (this.mIsReadyToFlip) {
            return ((float) Math.abs((double) distanceY)) > ((float) Math.abs((double) distanceX));
        }
        return true;
    }

    private final boolean canStartToMoveFromScroll(PointF point) {
        if (getMState() == 2 || !this.mIsReadyToScroll) {
            return false;
        }
        PointF pointF = new PointF(point.x, point.y);
        View view = this.mFloatViewRef.get();
        float x = view != null ? view.getX() : 0.0f;
        View view2 = this.mFloatViewRef.get();
        pointF.offset(x, view2 != null ? view2.getY() : 0.0f);
        int scrollDirection = FloaterUtil.INSTANCE.getScrollDirection(this.mFloatViewRef.get(), pointF);
        if (canHorizontalScroll(scrollDirection)) {
            Logger.m8697d(TAG, "can not start move X");
            return false;
        }
        if (!canVerticalScroll(scrollDirection)) {
            return true;
        }
        Logger.m8697d(TAG, "can not start move Y");
        return false;
    }

    private final boolean canStartToMoveFromSeekBar(PointF touchPoint) {
        return !this.mIsReadyToSeek;
    }

    private final boolean canVerticalScroll(int direction) {
        if (!FloaterUtil.INSTANCE.isVerticalScrollable(direction)) {
            return false;
        }
        View view = this.mFloatViewRef.get();
        Float fValueOf = null;
        if (view != null) {
            int height = view.getHeight();
            View view2 = this.mFloatViewRef.get();
            if (view2 != null) {
                fValueOf = Float.valueOf(view2.getY() + height);
            }
        }
        Intrinsics.checkNotNull(fValueOf);
        if (this.mViewContract.getMParentHeight() >= fValueOf.floatValue()) {
            return true;
        }
        Logger.m8697d(TAG, "can start move Y - change  scrollable");
        return false;
    }

    private final void cancelDockingAnimation() {
        AnimatorSet animatorSet;
        AnimatorSet animatorSet2 = this.mDockAnimator;
        if (animatorSet2 == null || !animatorSet2.isRunning() || (animatorSet = this.mDockAnimator) == null) {
            return;
        }
        animatorSet.cancel();
    }

    private final void cancelSpringAnimation(SpringAnimation animation) {
        if (animation == null || !animation.isRunning()) {
            return;
        }
        Logger.m8697d(TAG, "cancel Spring");
        animation.cancel();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void enabledRound(boolean enable, boolean withAnimation) {
        if (this.mRoundableBG == null) {
            return;
        }
        float f = this.mCurrentRound;
        boolean z = true;
        float f4 = 0.0f;
        if (enable) {
            float f5 = this.mDefaultRound;
            if (f < f5) {
                f4 = f5;
            } else {
                z = false;
            }
        } else if (f <= 0.0f) {
        }
        if (z) {
            if (withAnimation) {
                runRoundAnimation(f, f4);
            } else {
                setBGCornerRadius(f4);
            }
        }
    }

    private final IDock getDock() {
        return getDock(this.dockingType);
    }

    private final void onDocking(boolean docking, boolean withAnimation) {
        View view = this.mFloatViewRef.get();
        if (view == null) {
            return;
        }
        cancelDockingAnimation();
        this.mDockAnimator = new AnimatorSet();
        enabledRound(!docking, withAnimation);
        enableMargin(!docking);
        if (docking && view.getVisibility() == 0) {
            openDocker(this.dockingType, getDockingSize());
        }
        view.requestLayout();
        setState(docking ? 2 : 0);
        AnimatorSet animatorSet = this.mDockAnimator;
        if (animatorSet != null) {
            animatorSet.start();
        }
    }

    private final void runFlyAnimation(View view, float targetX, float targetY, float velocityX, float velocityY, boolean isBounded, Runnable withEndAction) {
        float f;
        float f4;
        SpringForce spring;
        SpringForce stiffness;
        SpringForce spring2;
        SpringForce stiffness2;
        cancelSpringAnimation(this.mFlyXAnimator);
        cancelSpringAnimation(this.mFlyYAnimator);
        if (isBounded) {
            f = 400.0f;
            f4 = 0.75f;
        } else {
            f = 600.0f;
            f4 = 1.4f;
        }
        this.mFlyXAnimator = new SpringAnimation(view, DynamicAnimation.f1485X, targetX);
        this.mFlyYAnimator = new SpringAnimation(view, DynamicAnimation.f1486Y, targetY);
        SpringAnimation springAnimation = this.mFlyXAnimator;
        if (springAnimation != null) {
            springAnimation.setStartVelocity(velocityX);
        }
        SpringAnimation springAnimation2 = this.mFlyYAnimator;
        if (springAnimation2 != null) {
            springAnimation2.setStartVelocity(velocityY);
        }
        SpringAnimation springAnimation3 = this.mFlyXAnimator;
        if (springAnimation3 != null && (spring2 = springAnimation3.getSpring()) != null && (stiffness2 = spring2.setStiffness(f)) != null) {
            stiffness2.setDampingRatio(f4);
        }
        SpringAnimation springAnimation4 = this.mFlyYAnimator;
        if (springAnimation4 != null && (spring = springAnimation4.getSpring()) != null && (stiffness = spring.setStiffness(f)) != null) {
            stiffness.setDampingRatio(f4);
        }
        DefaultAnimatorListener defaultAnimatorListener = new DefaultAnimatorListener(this, "Fly", true, withEndAction);
        SpringAnimation springAnimation5 = this.mFlyXAnimator;
        if (springAnimation5 != null) {
            springAnimation5.addEndListener(defaultAnimatorListener);
        }
        SpringAnimation springAnimation6 = this.mFlyYAnimator;
        if (springAnimation6 != null) {
            springAnimation6.addEndListener(defaultAnimatorListener);
        }
        SpringAnimation springAnimation7 = this.mFlyXAnimator;
        if (springAnimation7 != null) {
            springAnimation7.start();
        }
        SpringAnimation springAnimation8 = this.mFlyYAnimator;
        if (springAnimation8 != null) {
            springAnimation8.start();
        }
    }

    private final void runPositionAnimation(View view, float targetPosX, float targetPosY, float stiffness, float dampingRatio) {
        SpringForce spring;
        SpringForce stiffness2;
        SpringForce spring2;
        SpringForce stiffness3;
        cancelSpringAnimation(this.mPositionXAnimator);
        cancelSpringAnimation(this.mPositionYAnimator);
        this.mPositionXAnimator = new SpringAnimation(view, DynamicAnimation.f1485X, targetPosX);
        this.mPositionYAnimator = new SpringAnimation(view, DynamicAnimation.f1486Y, targetPosY);
        SpringAnimation springAnimation = this.mPositionXAnimator;
        if (springAnimation != null && (spring2 = springAnimation.getSpring()) != null && (stiffness3 = spring2.setStiffness(stiffness)) != null) {
            stiffness3.setDampingRatio(dampingRatio);
        }
        SpringAnimation springAnimation2 = this.mPositionYAnimator;
        if (springAnimation2 != null && (spring = springAnimation2.getSpring()) != null && (stiffness2 = spring.setStiffness(stiffness)) != null) {
            stiffness2.setDampingRatio(dampingRatio);
        }
        DefaultAnimatorListener defaultAnimatorListener = new DefaultAnimatorListener(this, "Position");
        SpringAnimation springAnimation3 = this.mPositionXAnimator;
        if (springAnimation3 != null) {
            springAnimation3.addEndListener(defaultAnimatorListener);
        }
        SpringAnimation springAnimation4 = this.mPositionYAnimator;
        if (springAnimation4 != null) {
            springAnimation4.addEndListener(defaultAnimatorListener);
        }
        SpringAnimation springAnimation5 = this.mPositionXAnimator;
        if (springAnimation5 != null) {
            springAnimation5.start();
        }
        SpringAnimation springAnimation6 = this.mPositionYAnimator;
        if (springAnimation6 != null) {
            springAnimation6.start();
        }
    }

    private final void runRoundAnimation(float from, float to) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(from, to);
        valueAnimatorOfFloat.addUpdateListener(new C0421a(this, 19));
        valueAnimatorOfFloat.setDuration(200L);
        valueAnimatorOfFloat.setInterpolator(new SineInOut60());
        AnimatorSet animatorSet = this.mDockAnimator;
        if (animatorSet != null) {
            animatorSet.play(valueAnimatorOfFloat);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void runRoundAnimation$lambda$0(FloaterDelegate floaterDelegate, ValueAnimator valueAnimator) {
        floaterDelegate.setBGCornerRadius(((Float) AbstractC6670b.m4742c(valueAnimator, "valueAnimator", "null cannot be cast to non-null type kotlin.Float")).floatValue());
    }

    private final void setBGCornerRadius(float corner) {
        GradientDrawable gradientDrawable = this.mRoundableBG;
        if (gradientDrawable != null) {
            if (gradientDrawable != null) {
                gradientDrawable.mutate();
            }
            GradientDrawable gradientDrawable2 = this.mRoundableBG;
            if (gradientDrawable2 != null) {
                gradientDrawable2.setCornerRadius(corner);
            }
            this.mCurrentRound = corner;
            Logger.m8697d(TAG, "update round : " + corner);
        }
    }

    private final void setState(int i) {
        if (this.mState != i) {
            this.mState = i;
            AbstractC4539a.m3203m(i, "change state : ", TAG);
            Iterator<IFloater.ModeChangeListener> it = this.mModeChangeListeners.iterator();
            while (it.hasNext()) {
                it.next().onModeChanged(this.mState);
            }
        }
    }

    public final void addDock(int id, @NotNull IDock dock) {
        IDock dock2;
        Intrinsics.checkNotNullParameter(dock, "dock");
        if (id < this.mDocks.size() && (dock2 = getDock(id)) != null) {
            if (Intrinsics.areEqual(dock2, dock)) {
                return;
            } else {
                this.mDocks.remove(dock2);
            }
        }
        this.mDocks.add(id, dock);
    }

    public final void addModeChangeListener(@NotNull IFloater.ModeChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mModeChangeListeners.add(listener);
    }

    public final void blockadeDock(int id, boolean blockade) {
        if (isBlockaded(id) == blockade) {
            return;
        }
        if (blockade) {
            this.mBlockadedDocks.add(Integer.valueOf(id));
        } else {
            this.mBlockadedDocks.remove(Integer.valueOf(id));
        }
    }

    public final boolean canStartToMove(@NotNull PointF touchPoint, float distanceX, float distanceY) {
        Intrinsics.checkNotNullParameter(touchPoint, "touchPoint");
        if (this.mIsReadyToScroll && canStartToMoveFromScroll(touchPoint)) {
            Logger.m8702i(TAG, "canStartToMoveFromScroll");
            return true;
        }
        if (this.mIsReadyToFlip && canStartToMoveFromFlipper(distanceX, distanceY)) {
            Logger.m8702i(TAG, "canStartToMoveFromFlipper");
            return true;
        }
        if (!this.mIsReadyToSeek || !canStartToMoveFromSeekBar(touchPoint)) {
            return false;
        }
        Logger.m8702i(TAG, "canStartToMoveFromSeekBar");
        return true;
    }

    public final void cancelTranslationAnimation() {
        cancelSpringAnimation(this.mTranslationXAnimator);
        cancelSpringAnimation(this.mTranslationYAnimator);
    }

    public final void changeDockerSize(int size) {
        IDock dock = getDock();
        if (dock == null || !dock.getIsShowing()) {
            return;
        }
        dock.changeSize(getDockerInsetSize() + size);
    }

    public final void closeAllDocker() {
        hideDockOthers(-1);
    }

    public final void deInitInterceptTouchEvent() {
        this.mIsReadyToSeek = false;
        this.mIsReadyToFlip = false;
        this.mIsReadyToScroll = false;
    }

    public final void enableMargin(boolean enable) {
        int iIntValue;
        int i;
        int iIntValue2;
        int i2;
        boolean z;
        View view = this.mFloatViewRef.get();
        if (view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        int marginStart = marginLayoutParams.getMarginStart();
        int marginEnd = marginLayoutParams.getMarginEnd();
        if (enable) {
            int i4 = this.mDefaultMarginStart;
            if (marginStart != i4) {
                marginEnd = this.mDefaultMarginEnd;
                i2 = this.mDefaultPaddingEnd;
                z = true;
                marginStart = i4;
                i = 0;
            } else {
                i = 0;
                i2 = 0;
                z = false;
            }
        } else {
            int i5 = this.mDefaultMarginStart;
            IDock.AlignmentParam alignmentParam = this.mDockingParam;
            if (alignmentParam != null) {
                Integer numValueOf = alignmentParam != null ? Integer.valueOf(alignmentParam.getMStartMargin()) : null;
                Intrinsics.checkNotNull(numValueOf);
                iIntValue = numValueOf.intValue();
            } else {
                iIntValue = 0;
            }
            i = i5 + iIntValue;
            int i6 = this.mDefaultMarginEnd;
            IDock.AlignmentParam alignmentParam2 = this.mDockingParam;
            if (alignmentParam2 != null) {
                Integer numValueOf2 = alignmentParam2 != null ? Integer.valueOf(alignmentParam2.getMEndMargin()) : null;
                Intrinsics.checkNotNull(numValueOf2);
                iIntValue2 = numValueOf2.intValue();
            } else {
                iIntValue2 = 0;
            }
            i2 = i6 + iIntValue2;
            if (marginStart == 0 && i == view.getPaddingStart() && i2 == view.getPaddingEnd()) {
                z = false;
            } else {
                z = true;
                marginStart = 0;
                marginEnd = 0;
            }
        }
        if (z) {
            marginLayoutParams.setMarginStart(marginStart);
            marginLayoutParams.setMarginEnd(marginEnd);
            view.setPaddingRelative(i, 0, i2, 0);
            view.setLayoutParams(marginLayoutParams);
            if (enable) {
                float translationX = view.getTranslationX() - i;
                if (view.getLayoutDirection() != 1 ? translationX < 0.0f : translationX > 0.0f) {
                    translationX = 0.0f;
                }
                Logger.m8697d(TAG, "enable margin : translationX" + translationX);
                view.setTranslationX(translationX);
            }
            AbstractC4539a.m3203m(marginStart, "update margin : ", TAG);
        }
    }

    public final void endDrag(@Nullable View view) {
        Logger.m8697d(TAG, "run end drag scale animation");
        runScaleAnimation(view, 1.0f, 400.0f, 0.39f);
    }

    public final void fly(@NotNull View view, float targetX, float targetY, float velocityX, float velocityY, boolean isBounded, @Nullable Runnable withEndAction) {
        Intrinsics.checkNotNullParameter(view, "view");
        runFlyAnimation(view, targetX, targetY, velocityX, velocityY, isBounded, withEndAction);
    }

    public final int getDockerInsetSize() {
        return getDockerInsetSize(this.dockingType);
    }

    public final int getDockingPosEndX() {
        IDock.AlignmentParam alignmentParam = this.mDockingParam;
        if (alignmentParam == null) {
            return this.mDefaultMarginEnd;
        }
        int i = this.mDefaultMarginEnd;
        Integer numValueOf = alignmentParam != null ? Integer.valueOf(alignmentParam.getMEndMargin()) : null;
        Intrinsics.checkNotNull(numValueOf);
        return numValueOf.intValue() + i;
    }

    public final int getDockingPosStartX() {
        IDock.AlignmentParam alignmentParam = this.mDockingParam;
        if (alignmentParam == null) {
            return this.mDefaultMarginStart;
        }
        int i = this.mDefaultMarginStart;
        Integer numValueOf = alignmentParam != null ? Integer.valueOf(alignmentParam.getMStartMargin()) : null;
        Intrinsics.checkNotNull(numValueOf);
        return numValueOf.intValue() + i;
    }

    public final int getDockingSize() {
        IDock.AlignmentParam alignmentParam = this.mDockingParam;
        if (alignmentParam == null) {
            return 0;
        }
        Integer numValueOf = alignmentParam != null ? Integer.valueOf(alignmentParam.dockingSize) : null;
        Intrinsics.checkNotNull(numValueOf);
        return numValueOf.intValue();
    }

    public final int getDockingType() {
        return this.dockingType;
    }

    @NotNull
    public final Rect getGlobalVisibleRect(int id) {
        Integer numValueOf;
        Rect rect = new Rect();
        IDock dock = getDock(id);
        if (dock == null) {
            return rect;
        }
        Rect location = dock.getLocation();
        IDock.AlignmentParam alignmentParam = this.mDockingParam;
        if (alignmentParam != null && this.dockingType != id) {
            if (2 == id) {
                int i = location.right;
                numValueOf = alignmentParam != null ? Integer.valueOf(alignmentParam.dockingSize) : null;
                Intrinsics.checkNotNull(numValueOf);
                location.right = numValueOf.intValue() + i;
                return location;
            }
            if (id == 0) {
                int i2 = location.bottom;
                numValueOf = alignmentParam != null ? Integer.valueOf(alignmentParam.dockingSize) : null;
                Intrinsics.checkNotNull(numValueOf);
                location.bottom = numValueOf.intValue() + i2;
                return location;
            }
            if (3 == id) {
                int i4 = location.left;
                numValueOf = alignmentParam != null ? Integer.valueOf(alignmentParam.dockingSize) : null;
                Intrinsics.checkNotNull(numValueOf);
                location.left = i4 - numValueOf.intValue();
                return location;
            }
            if (1 == id) {
                int i5 = location.top;
                numValueOf = alignmentParam != null ? Integer.valueOf(alignmentParam.dockingSize) : null;
                Intrinsics.checkNotNull(numValueOf);
                location.top = i5 - numValueOf.intValue();
            }
        }
        return location;
    }

    /* JADX INFO: renamed from: getState, reason: from getter */
    public final int getMState() {
        return this.mState;
    }

    public final void hideDockOthers(int id) {
        int size = this.mDocks.size();
        for (int i = 0; i < size; i++) {
            if (i != id) {
                this.mDocks.get(i).hide();
            }
        }
    }

    public final void initInterceptFlipper(@NotNull PointF point) {
        Intrinsics.checkNotNullParameter(point, "point");
        View view = (View) FloaterUtil.INSTANCE.getValidView(ViewFlipper.class, this.mFloatViewRef.get(), point);
        if (view != null) {
            this.mIsReadyToFlip = view.isEnabled();
        }
    }

    public final void initInterceptScroll(@NotNull PointF point) {
        Intrinsics.checkNotNullParameter(point, "point");
        this.mIsReadyToScroll = FloaterUtil.INSTANCE.getScrollDirection(this.mFloatViewRef.get(), point) != 0;
    }

    public final void initInterceptSeekBar(@NotNull PointF point) {
        Intrinsics.checkNotNullParameter(point, "point");
        this.mIsReadyToSeek = FloaterUtil.INSTANCE.getValidView(SeekBar.class, this.mFloatViewRef.get(), point) != null;
    }

    public final void initLayout() {
        View view = this.mFloatViewRef.get();
        if (view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        this.mDefaultMarginStart = marginLayoutParams.getMarginStart();
        this.mDefaultMarginEnd = marginLayoutParams.getMarginEnd();
        this.mDefaultPaddingEnd = view.getPaddingEnd();
    }

    public final boolean isBlockaded(int id) {
        return this.mBlockadedDocks.contains(Integer.valueOf(id));
    }

    public final boolean isInterceptedTouchEvent() {
        return this.mIsReadyToScroll || this.mIsReadyToFlip || this.mIsReadyToSeek;
    }

    public final void onUnDocking() {
        onDocking(false, true);
        this.dockingType = -1;
    }

    public final void openDocker(int size) {
        openDocker(this.dockingType, size);
    }

    public final void reboundOnDropZone(@NotNull View view, float x, float y2, int type) {
        float f;
        float f4;
        Intrinsics.checkNotNullParameter(view, "view");
        Logger.m8697d(TAG, "rebound on drop zone X : " + x + SQLKeyword.COMMA + y2 + " : " + type);
        if (type != 2) {
            f4 = 0.75f;
            f = type != 3 ? 150.0f : 400.0f;
        } else {
            f = FLY_VELOCITY_MIN_LIMIT;
            f4 = 0.85f;
        }
        runPositionAnimation(view, x, y2, f, f4);
    }

    public final void release() {
        this.mDocks.clear();
        this.mModeChangeListeners.clear();
        this.mDockerInsetSizes.clear();
    }

    public final void runScaleAnimation(@Nullable View view, float targetScale, float stiffness, float dampingRatio) {
        cancelSpringAnimation(this.mScaleXAnimator);
        cancelSpringAnimation(this.mScaleYAnimator);
        this.mScaleXAnimator = new SpringAnimation(view, DynamicAnimation.SCALE_X);
        this.mScaleYAnimator = new SpringAnimation(view, DynamicAnimation.SCALE_Y);
        SpringForce springForce = new SpringForce(targetScale);
        springForce.setStiffness(stiffness).setDampingRatio(dampingRatio);
        SpringAnimation springAnimation = this.mScaleXAnimator;
        if (springAnimation != null) {
            springAnimation.setSpring(springForce);
        }
        SpringAnimation springAnimation2 = this.mScaleYAnimator;
        if (springAnimation2 != null) {
            springAnimation2.setSpring(springForce);
        }
        DefaultAnimatorListener defaultAnimatorListener = new DefaultAnimatorListener(this, "Scale");
        SpringAnimation springAnimation3 = this.mScaleXAnimator;
        if (springAnimation3 != null) {
            springAnimation3.addEndListener(defaultAnimatorListener);
        }
        SpringAnimation springAnimation4 = this.mScaleYAnimator;
        if (springAnimation4 != null) {
            springAnimation4.addEndListener(defaultAnimatorListener);
        }
        SpringAnimation springAnimation5 = this.mScaleXAnimator;
        if (springAnimation5 != null) {
            springAnimation5.start();
        }
        SpringAnimation springAnimation6 = this.mScaleYAnimator;
        if (springAnimation6 != null) {
            springAnimation6.start();
        }
    }

    public final void runTranslationAnimation(@NotNull Point dstPoint, @Nullable final Runnable endAction) {
        SpringAnimation springAnimation;
        Intrinsics.checkNotNullParameter(dstPoint, "dstPoint");
        if (this.mTranslationXAnimator == null) {
            this.mTranslationXAnimator = new SpringAnimation(this.mFloatViewRef.get(), DynamicAnimation.TRANSLATION_X);
        }
        if (this.mTranslationYAnimator == null) {
            this.mTranslationYAnimator = new SpringAnimation(this.mFloatViewRef.get(), DynamicAnimation.TRANSLATION_Y);
        }
        SpringAnimation springAnimation2 = this.mTranslationXAnimator;
        if (springAnimation2 != null) {
            springAnimation2.setSpring(new SpringForce().setFinalPosition(dstPoint.x).setStiffness(50.0f).setDampingRatio(0.75f));
        }
        SpringAnimation springAnimation3 = this.mTranslationYAnimator;
        if (springAnimation3 != null) {
            springAnimation3.setSpring(new SpringForce().setFinalPosition(dstPoint.y).setStiffness(50.0f).setDampingRatio(0.75f));
        }
        if (endAction != null && (springAnimation = this.mTranslationYAnimator) != null) {
            springAnimation.addEndListener(new DynamicAnimation.OnAnimationEndListener() { // from class: com.samsung.android.support.senl.nt.base.winset.view.floater.FloaterDelegate.runTranslationAnimation.1
                @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener
                public void onAnimationEnd(DynamicAnimation<?> animation, boolean canceled, float value, float velocity) {
                    SpringAnimation springAnimation4 = FloaterDelegate.this.mTranslationYAnimator;
                    if (springAnimation4 != null) {
                        springAnimation4.removeEndListener(this);
                    }
                    endAction.run();
                }
            });
        }
        SpringAnimation springAnimation4 = this.mTranslationXAnimator;
        if (springAnimation4 != null) {
            springAnimation4.start();
        }
        SpringAnimation springAnimation5 = this.mTranslationYAnimator;
        if (springAnimation5 != null) {
            springAnimation5.start();
        }
    }

    public final void setBackground(@Nullable Drawable drawable) {
        if (drawable instanceof GradientDrawable) {
            setBackground((GradientDrawable) drawable);
        } else {
            this.mRoundableBG = null;
        }
    }

    public final void setDefaultCornerRadius(float radius) {
        this.mDefaultRound = radius;
        this.mCurrentRound = radius;
    }

    public final void setDockParams(@Nullable IDock.AlignmentParam params) {
        this.mDockingParam = params;
        if (getMState() == 2) {
            onDocking(true, false);
        }
    }

    public final void setDockSide(int dockingSide) {
        this.dockingType = dockingSide;
    }

    public final void setDockerInsetSize(int id, int size) {
        this.mDockerInsetSizes.put(Integer.valueOf(id), Integer.valueOf(size));
    }

    public final void setDockerVisibility(int visibility) {
        int size = this.mDocks.size();
        for (int i = 0; i < size; i++) {
            IDock dock = getDock(i);
            if (dock != null) {
                dock.setVisibility(visibility);
            }
        }
    }

    public final void startDrag(@Nullable View view) {
        Logger.m8697d(TAG, "run start drag scale animation");
        runScaleAnimation(view, 1.02f, 330.0f, 0.176f);
    }

    public final void stopActions() {
        Logger.m8697d(TAG, "stopActions");
        cancelSpringAnimation(this.mPositionXAnimator);
        cancelSpringAnimation(this.mPositionYAnimator);
        cancelSpringAnimation(this.mScaleXAnimator);
        cancelSpringAnimation(this.mScaleYAnimator);
        cancelSpringAnimation(this.mFlyXAnimator);
        cancelSpringAnimation(this.mFlyYAnimator);
        cancelDockingAnimation();
    }

    private final IDock getDock(int id) {
        if (id < 0 || id >= this.mDocks.size()) {
            return null;
        }
        return this.mDocks.get(id);
    }

    private final int getDockerInsetSize(int id) {
        Integer num = this.mDockerInsetSizes.get(Integer.valueOf(id));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public final boolean openDocker(int id, int size) {
        if (this.mBlockadedDocks.contains(Integer.valueOf(id))) {
            return false;
        }
        hideDockOthers(id);
        IDock dock = getDock(id);
        if (dock != null) {
            return dock.show(size + getDockerInsetSize(id));
        }
        return false;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0092\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0004\u0010\tJ,\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/view/floater/FloaterDelegate$AnimatorEndListener;", "Landroidx/dynamicanimation/animation/DynamicAnimation$OnAnimationEndListener;", "mName", "", "<init>", "(Lcom/samsung/android/support/senl/nt/base/winset/view/floater/FloaterDelegate;Ljava/lang/String;)V", "name", "needUpdated", "", "(Lcom/samsung/android/support/senl/nt/base/winset/view/floater/FloaterDelegate;Ljava/lang/String;Z)V", "mNeedUpdated", "onAnimationEnd", "", "animation", "Landroidx/dynamicanimation/animation/DynamicAnimation;", "canceled", "value", "", "velocity", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public class AnimatorEndListener implements DynamicAnimation.OnAnimationEndListener {

        @NotNull
        private final String mName;
        private boolean mNeedUpdated;
        final /* synthetic */ FloaterDelegate this$0;

        public AnimatorEndListener(@NotNull FloaterDelegate floaterDelegate, String mName) {
            Intrinsics.checkNotNullParameter(mName, "mName");
            this.this$0 = floaterDelegate;
            this.mName = mName;
            floaterDelegate.mActionListener.onActionStart();
            Logger.m8697d(FloaterDelegate.TAG, "start Action with animation : " + mName);
        }

        @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener
        public void onAnimationEnd(@NotNull DynamicAnimation<?> animation, boolean canceled, float value, float velocity) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            Logger.m8702i(FloaterDelegate.TAG, "end Action with animation : " + this.mName + " needUpdate " + this.mNeedUpdated);
            animation.removeEndListener(this);
            this.this$0.mActionListener.onActionEnd(this.mNeedUpdated);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public AnimatorEndListener(@NotNull FloaterDelegate floaterDelegate, String name, boolean z) {
            this(floaterDelegate, name);
            Intrinsics.checkNotNullParameter(name, "name");
            this.mNeedUpdated = z;
        }
    }

    private final void setBackground(GradientDrawable drawable) {
        this.mRoundableBG = drawable;
    }

    public final void onDocking(int type, boolean docking, boolean withAnimation) {
        if (this.mBlockadedDocks.contains(Integer.valueOf(type))) {
            return;
        }
        this.dockingType = type;
        onDocking(docking, withAnimation);
        AbstractC4539a.m3203m(this.dockingType, "on docking - type : ", TAG);
    }
}
