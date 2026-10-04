package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import androidx.annotation.LayoutRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.method.CoeditGrpcMethod;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 R2\u00020\u0001:\u0005RSTUVB\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\bB\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0006\u0010\u000bJ\u0018\u0010\"\u001a\u00020#2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\b\u0010$\u001a\u00020#H\u0016J \u0010%\u001a\u00020\u00132\b\b\u0001\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u0005J\"\u0010%\u001a\u00020#2\u0006\u0010)\u001a\u00020\u00132\b\b\u0002\u0010'\u001a\u00020\u00052\b\b\u0002\u0010(\u001a\u00020\u0005J*\u0010*\u001a\u0004\u0018\u00010\u00132\b\b\u0001\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u00052\u0006\u0010+\u001a\u00020,J\u0016\u0010*\u001a\u00020#2\u0006\u0010-\u001a\u00020\u00132\u0006\u0010+\u001a\u00020,J&\u0010*\u001a\u00020#2\u0006\u0010-\u001a\u00020\u00132\u0006\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u00052\u0006\u0010+\u001a\u00020,J\u001e\u0010*\u001a\u00020#2\u0006\u0010-\u001a\u00020\u00132\u0006\u0010+\u001a\u00020,2\u0006\u0010.\u001a\u00020\u0005J.\u0010*\u001a\u00020#2\u0006\u0010-\u001a\u00020\u00132\u0006\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u00052\u0006\u0010+\u001a\u00020,2\u0006\u0010.\u001a\u00020\u0005J\u000e\u0010/\u001a\u00020#2\u0006\u0010-\u001a\u00020\u0013J\u0016\u00100\u001a\u0002012\u0006\u0010-\u001a\u00020\u00132\u0006\u00102\u001a\u00020\u0005J\u000e\u00103\u001a\u00020#2\u0006\u00104\u001a\u00020\u0019J\u0010\u00105\u001a\u0002012\u0006\u00106\u001a\u000207H\u0016J\u0010\u00108\u001a\u00020#2\b\u00109\u001a\u0004\u0018\u00010\u0013J\u0010\u0010:\u001a\u00020#2\u0006\u0010;\u001a\u00020\u0005H\u0004J\u0010\u0010<\u001a\u00020#2\u0006\u0010;\u001a\u00020\u0005H\u0004J\r\u0010=\u001a\u00020\u0001H\u0000¢\u0006\u0002\b>J\r\u0010?\u001a\u00020\u0001H\u0000¢\u0006\u0002\b@J\u0010\u0010A\u001a\u00020#2\u0006\u0010;\u001a\u00020\u0005H\u0016J\u0016\u0010A\u001a\u00020#2\u0006\u0010;\u001a\u00020\u00052\u0006\u0010B\u001a\u000201J\u0016\u0010C\u001a\u00020#2\u0006\u0010D\u001a\u00020\u00052\u0006\u0010B\u001a\u000201J\"\u0010E\u001a\u00020#2\u0006\u0010F\u001a\u00020G2\b\b\u0002\u0010H\u001a\u00020I2\b\b\u0002\u0010J\u001a\u00020IJ\"\u0010K\u001a\u00020#2\u0006\u0010F\u001a\u00020G2\b\b\u0002\u0010H\u001a\u00020I2\b\b\u0002\u0010J\u001a\u00020IJ\u001c\u0010O\u001a\u0002012\u0006\u0010F\u001a\u00020G2\n\b\u0002\u00104\u001a\u0004\u0018\u00010NH\u0016J\u0010\u0010P\u001a\u00020#2\u0006\u0010F\u001a\u00020GH\u0002J\u0010\u0010Q\u001a\u00020#2\u0006\u0010F\u001a\u00020GH\u0002R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0001X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0001X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0001X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001e@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u000e\u0010L\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010M\u001a\u0004\u0018\u00010NX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006W"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "layoutId", "", "<init>", "(Landroid/content/Context;I)V", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mChildSize", "mAnglePosition", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTAnglePosition;", "mRootLayout", "mMainContent", "mBaseContent", "mCenterBgView", "Landroid/view/View;", "mConsumerView", "mBackgroundView", "mAnimation", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTLayoutAnimation;", "mToggleAnimationListener", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTLayout$ToggleAnimationListener;", "mScaleXAnimator", "Landroidx/dynamicanimation/animation/SpringAnimation;", "mScaleYAnimator", "value", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTLayout$DockingState;", "dockingState", "getDockingState", "()Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTLayout$DockingState;", "init", "", "close", "addCenterView", "resource", "width", "height", "centerItem", "addEdgeView", "angle", "", "view", "animationType", "removeEdgeView", "setEdgeViewContainerAnimation", "", "order", "setToggleAnimationListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "getVisibleContentRect", "rect", "Landroid/graphics/Rect;", "setBackgroundView", "backgroundView", "setBaseContentVisibility", "visibility", "setCenterBgVisibility", "getMainContent", "getMainContent$ntComposer_release", "getRootLayout", "getRootLayout$ntComposer_release", "setVisibility", "animation", "toggle", "nextVisibility", Constants.IntentExtraValue.SHOW, "type", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTLayout$AnimationType;", "dampingRatio", "", "stiffness", "hide", "mIsAnimating", "mAnimationEndListener", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTLayout$AnimationEndListener;", "startAnimation", "endAnimation", "endToggleAnimation", "Companion", "DockingState", "ToggleAnimationListener", "AnimationType", "AnimationEndListener", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSettingQTLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SettingQTLayout.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTLayout\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,387:1\n1#2:388\n*E\n"})
public class SettingQTLayout extends ConstraintLayout {
    public static final int ANIMATION_NONE = 0;
    public static final int ANIMATION_OPACITY_AND_ROTATION = 3;
    public static final int ANIMATION_SCALE = 1;
    public static final int ANIMATION_SCALE_AND_ROTATION = 2;
    private static final float ROTATE_VALUE_OF_OPACITY_AND_ROTATION = -180.0f;
    private static final float ROTATE_VALUE_OF_SCALE_AND_ROTATION = 90.0f;

    @NotNull
    private static final String TAG = "SettingQTLayout";

    @NotNull
    private DockingState dockingState;

    @NotNull
    private QTAnglePosition mAnglePosition;

    @NotNull
    private final QTLayoutAnimation mAnimation;

    @Nullable
    private AnimationEndListener mAnimationEndListener;

    @Nullable
    private View mBackgroundView;
    private ConstraintLayout mBaseContent;
    private View mCenterBgView;
    private int mChildSize;
    private View mConsumerView;
    private boolean mIsAnimating;
    private ConstraintLayout mMainContent;
    private ConstraintLayout mRootLayout;

    @Nullable
    private SpringAnimation mScaleXAnimator;

    @Nullable
    private SpringAnimation mScaleYAnimator;

    @Nullable
    private ToggleAnimationListener mToggleAnimationListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTLayout$AnimationEndListener;", "", "onAnimationEnd", "", "type", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTLayout$AnimationType;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface AnimationEndListener {
        void onAnimationEnd(@NotNull AnimationType type);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTLayout$AnimationType;", "", "<init>", "(Ljava/lang/String;I)V", CoeditGrpcMethod.Caller.OPEN, CoeditGrpcMethod.Caller.CLOSE, "TOGGLE_TO_SHOW", "TOGGLE_TO_HIDE", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class AnimationType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ AnimationType[] $VALUES;
        public static final AnimationType OPEN = new AnimationType(CoeditGrpcMethod.Caller.OPEN, 0);
        public static final AnimationType CLOSE = new AnimationType(CoeditGrpcMethod.Caller.CLOSE, 1);
        public static final AnimationType TOGGLE_TO_SHOW = new AnimationType("TOGGLE_TO_SHOW", 2);
        public static final AnimationType TOGGLE_TO_HIDE = new AnimationType("TOGGLE_TO_HIDE", 3);

        private static final /* synthetic */ AnimationType[] $values() {
            return new AnimationType[]{OPEN, CLOSE, TOGGLE_TO_SHOW, TOGGLE_TO_HIDE};
        }

        static {
            AnimationType[] animationTypeArr$values = $values();
            $VALUES = animationTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(animationTypeArr$values);
        }

        private AnimationType(String str, int i) {
        }

        @NotNull
        public static EnumEntries<AnimationType> getEntries() {
            return $ENTRIES;
        }

        public static AnimationType valueOf(String str) {
            return (AnimationType) Enum.valueOf(AnimationType.class, str);
        }

        public static AnimationType[] values() {
            return (AnimationType[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTLayout$DockingState;", "", "<init>", "(Ljava/lang/String;I)V", "EXIT", "ENTER_LEFT", "ENTER_RIGHT", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class DockingState {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ DockingState[] $VALUES;
        public static final DockingState EXIT = new DockingState("EXIT", 0);
        public static final DockingState ENTER_LEFT = new DockingState("ENTER_LEFT", 1);
        public static final DockingState ENTER_RIGHT = new DockingState("ENTER_RIGHT", 2);

        private static final /* synthetic */ DockingState[] $values() {
            return new DockingState[]{EXIT, ENTER_LEFT, ENTER_RIGHT};
        }

        static {
            DockingState[] dockingStateArr$values = $values();
            $VALUES = dockingStateArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(dockingStateArr$values);
        }

        private DockingState(String str, int i) {
        }

        @NotNull
        public static EnumEntries<DockingState> getEntries() {
            return $ENTRIES;
        }

        public static DockingState valueOf(String str) {
            return (DockingState) Enum.valueOf(DockingState.class, str);
        }

        public static DockingState[] values() {
            return (DockingState[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTLayout$ToggleAnimationListener;", "", "onAnimationStart", "", Constants.IntentExtraValue.SHOW, "", "onAnimationEnd", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface ToggleAnimationListener {
        void onAnimationEnd(boolean show);

        void onAnimationStart(boolean show);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AnimationType.values().length];
            try {
                iArr[AnimationType.OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AnimationType.CLOSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AnimationType.TOGGLE_TO_SHOW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AnimationType.TOGGLE_TO_HIDE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingQTLayout(@NotNull Context context, int i) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mAnglePosition = new QTAnglePosition();
        this.mAnimation = new QTLayoutAnimation();
        this.dockingState = DockingState.ENTER_LEFT;
        init(context, i);
    }

    public static /* synthetic */ void addCenterView$default(SettingQTLayout settingQTLayout, View view, int i, int i2, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addCenterView");
        }
        if ((i4 & 2) != 0) {
            i = -2;
        }
        if ((i4 & 4) != 0) {
            i2 = -2;
        }
        settingQTLayout.addCenterView(view, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void endAnimation(AnimationType type) {
        Logger.m11003i(TAG, "endAnimation() type=" + type);
        this.mIsAnimating = false;
        AnimationEndListener animationEndListener = this.mAnimationEndListener;
        if (animationEndListener != null) {
            animationEndListener.onAnimationEnd(type);
        }
        this.mAnimationEndListener = null;
        endToggleAnimation(type);
    }

    private final void endToggleAnimation(AnimationType type) {
        Logger.m11003i(TAG, "endToggleAnimation() type=" + type);
        ToggleAnimationListener toggleAnimationListener = this.mToggleAnimationListener;
        if (toggleAnimationListener != null) {
            int i = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
            if (i == 3) {
                toggleAnimationListener.onAnimationEnd(true);
            } else if (i == 4) {
                toggleAnimationListener.onAnimationEnd(false);
            }
        }
        this.mToggleAnimationListener = null;
    }

    public static /* synthetic */ void hide$default(SettingQTLayout settingQTLayout, AnimationType animationType, float f, float f4, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: hide");
        }
        if ((i & 2) != 0) {
            f = 0.63f;
        }
        if ((i & 4) != 0) {
            f4 = 200.0f;
        }
        settingQTLayout.hide(animationType, f, f4);
    }

    private final void init(Context context, int layoutId) {
        this.mAnglePosition.setRadius(context.getResources().getDimensionPixelSize(C9086R.dimen.composer_qt_circle_radius));
        this.mAnglePosition.setCenterPosition(context.getResources().getDimensionPixelSize(C9086R.dimen.composer_qt_circle_center_x), context.getResources().getDimensionPixelSize(C9086R.dimen.composer_qt_circle_center_y));
        LayoutInflater.from(context).inflate(layoutId, (ViewGroup) this, true);
        this.mBackgroundView = findViewById(C9086R.id.qt_background);
        this.mMainContent = (ConstraintLayout) findViewById(C9086R.id.main_content);
        this.mBaseContent = (ConstraintLayout) findViewById(C9086R.id.base_content);
        this.mChildSize = context.getResources().getDimensionPixelSize(C9086R.dimen.composer_qt_circle_default_child_size);
        this.mRootLayout = (ConstraintLayout) findViewById(C9086R.id.root_layout);
        this.mCenterBgView = findViewById(C9086R.id.center_bg);
        this.mConsumerView = new View(context);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(context.getResources().getDimensionPixelSize(C9086R.dimen.composer_qt_circle_layout_width), context.getResources().getDimensionPixelSize(C9086R.dimen.composer_qt_circle_layout_height));
        layoutParams.startToStart = 0;
        layoutParams.bottomToBottom = 0;
        layoutParams.topToTop = 0;
        layoutParams.endToEnd = 0;
        View view = this.mConsumerView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mConsumerView");
            view = null;
        }
        super.addView(view, 0, layoutParams);
        this.mAnimation.setTargetView(this);
    }

    public static /* synthetic */ void show$default(SettingQTLayout settingQTLayout, AnimationType animationType, float f, float f4, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: show");
        }
        if ((i & 2) != 0) {
            f = 0.63f;
        }
        if ((i & 4) != 0) {
            f4 = 200.0f;
        }
        settingQTLayout.show(animationType, f, f4);
    }

    public static /* synthetic */ boolean startAnimation$default(SettingQTLayout settingQTLayout, AnimationType animationType, AnimationEndListener animationEndListener, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startAnimation");
        }
        if ((i & 2) != 0) {
            animationEndListener = null;
        }
        return settingQTLayout.startAnimation(animationType, animationEndListener);
    }

    @NotNull
    public final View addCenterView(@LayoutRes int resource, int width, int height) {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        ConstraintLayout constraintLayout = this.mBaseContent;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBaseContent");
            constraintLayout = null;
        }
        View viewInflate = layoutInflaterFrom.inflate(resource, (ViewGroup) constraintLayout, false);
        Intrinsics.checkNotNull(viewInflate);
        addCenterView(viewInflate, width, height);
        return viewInflate;
    }

    @Nullable
    public final View addEdgeView(@LayoutRes int resource, int width, int height, double angle) {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        ConstraintLayout constraintLayout = this.mBaseContent;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBaseContent");
            constraintLayout = null;
        }
        View viewInflate = layoutInflaterFrom.inflate(resource, (ViewGroup) constraintLayout, false);
        Intrinsics.checkNotNull(viewInflate);
        addEdgeView(viewInflate, width, height, angle, 0);
        return viewInflate;
    }

    public void close() {
        this.mBackgroundView = null;
        this.mToggleAnimationListener = null;
        this.mAnimation.close();
        removeAllViews();
    }

    @NotNull
    public final DockingState getDockingState() {
        return this.dockingState;
    }

    @NotNull
    public final ConstraintLayout getMainContent$ntComposer_release() {
        ConstraintLayout constraintLayout = this.mMainContent;
        if (constraintLayout != null) {
            return constraintLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mMainContent");
        return null;
    }

    @NotNull
    public final ConstraintLayout getRootLayout$ntComposer_release() {
        ConstraintLayout constraintLayout = this.mRootLayout;
        if (constraintLayout != null) {
            return constraintLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mRootLayout");
        return null;
    }

    public boolean getVisibleContentRect(@NotNull Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        ConstraintLayout constraintLayout = this.mBaseContent;
        ConstraintLayout constraintLayout2 = null;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBaseContent");
            constraintLayout = null;
        }
        int left = constraintLayout.getLeft();
        ConstraintLayout constraintLayout3 = this.mBaseContent;
        if (constraintLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBaseContent");
            constraintLayout3 = null;
        }
        int top = constraintLayout3.getTop();
        ConstraintLayout constraintLayout4 = this.mBaseContent;
        if (constraintLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBaseContent");
            constraintLayout4 = null;
        }
        int right = constraintLayout4.getRight();
        ConstraintLayout constraintLayout5 = this.mBaseContent;
        if (constraintLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBaseContent");
        } else {
            constraintLayout2 = constraintLayout5;
        }
        rect.set(left, top, right, constraintLayout2.getBottom());
        return true;
    }

    public final void hide(@NotNull AnimationType type, float dampingRatio, float stiffness) {
        Intrinsics.checkNotNullParameter(type, "type");
        SpringAnimation springAnimation = this.mScaleXAnimator;
        if (springAnimation != null) {
            springAnimation.cancel();
        }
        SpringAnimation springAnimation2 = this.mScaleYAnimator;
        if (springAnimation2 != null) {
            springAnimation2.cancel();
        }
        animate().cancel();
        setScaleX(1.0f);
        setScaleY(1.0f);
        setAlpha(1.0f);
        SpringForce stiffness2 = new SpringForce(0.8f).setDampingRatio(dampingRatio).setStiffness(stiffness);
        SpringAnimation spring = new SpringAnimation(this, DynamicAnimation.SCALE_X).setSpring(stiffness2);
        this.mScaleXAnimator = spring;
        spring.start();
        SpringAnimation spring2 = new SpringAnimation(this, DynamicAnimation.SCALE_Y).setSpring(stiffness2);
        this.mScaleYAnimator = spring2;
        spring2.start();
        animate().alpha(0.0f).setDuration(100L).setInterpolator(new LinearInterpolator()).withEndAction(new RunnableC10781c(this, type, 0)).start();
    }

    public final void removeEdgeView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        ConstraintLayout constraintLayout = this.mBaseContent;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBaseContent");
            constraintLayout = null;
        }
        constraintLayout.removeView(view);
    }

    public final void setBackgroundView(@Nullable View backgroundView) {
        Logger.m11003i(TAG, "setBackgroundView() view=" + backgroundView);
        View view = this.mBackgroundView;
        ConstraintLayout constraintLayout = null;
        if (view != null) {
            ConstraintLayout constraintLayout2 = this.mRootLayout;
            if (constraintLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootLayout");
                constraintLayout2 = null;
            }
            constraintLayout2.removeView(view);
        }
        this.mBackgroundView = backgroundView;
        if (backgroundView == null) {
            return;
        }
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-1, -1);
        layoutParams.startToStart = 0;
        layoutParams.topToTop = 0;
        layoutParams.bottomToBottom = 0;
        layoutParams.endToEnd = 0;
        ConstraintLayout constraintLayout3 = this.mRootLayout;
        if (constraintLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootLayout");
        } else {
            constraintLayout = constraintLayout3;
        }
        constraintLayout.addView(backgroundView, 0, layoutParams);
        setCenterBgVisibility(8);
    }

    public final void setBaseContentVisibility(int visibility) {
        ConstraintLayout constraintLayout = this.mBaseContent;
        View view = null;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBaseContent");
            constraintLayout = null;
        }
        if (constraintLayout.getVisibility() == visibility) {
            return;
        }
        ConstraintLayout constraintLayout2 = this.mBaseContent;
        if (constraintLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBaseContent");
            constraintLayout2 = null;
        }
        constraintLayout2.setVisibility(visibility);
        View view2 = this.mConsumerView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mConsumerView");
        } else {
            view = view2;
        }
        view.setVisibility(visibility);
    }

    public final void setCenterBgVisibility(int visibility) {
        View view = this.mCenterBgView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCenterBgView");
            view = null;
        }
        view.setVisibility(visibility);
    }

    public final boolean setEdgeViewContainerAnimation(@NotNull View view, int order) {
        Intrinsics.checkNotNullParameter(view, "view");
        Logger.m11003i(TAG, "setEdgeViewContainerAnimation() order=" + order);
        return this.mAnimation.registerContainerAnimationView(view, order);
    }

    public final void setToggleAnimationListener(@NotNull ToggleAnimationListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mToggleAnimationListener = listener;
    }

    @Override // android.view.View
    public void setVisibility(int visibility) {
        setVisibility(visibility, false);
    }

    public final void show(@NotNull AnimationType type, float dampingRatio, float stiffness) {
        Intrinsics.checkNotNullParameter(type, "type");
        SpringAnimation springAnimation = this.mScaleXAnimator;
        if (springAnimation != null) {
            springAnimation.cancel();
        }
        SpringAnimation springAnimation2 = this.mScaleYAnimator;
        if (springAnimation2 != null) {
            springAnimation2.cancel();
        }
        animate().cancel();
        setScaleX(0.8f);
        setScaleY(0.8f);
        setAlpha(0.0f);
        SpringForce stiffness2 = new SpringForce(1.0f).setDampingRatio(dampingRatio).setStiffness(stiffness);
        SpringAnimation spring = new SpringAnimation(this, DynamicAnimation.SCALE_X).setSpring(stiffness2);
        this.mScaleXAnimator = spring;
        spring.start();
        SpringAnimation spring2 = new SpringAnimation(this, DynamicAnimation.SCALE_Y).setSpring(stiffness2);
        this.mScaleYAnimator = spring2;
        spring2.start();
        animate().alpha(1.0f).setDuration(200L).setInterpolator(new LinearInterpolator()).withEndAction(new RunnableC10781c(this, type, 1)).start();
    }

    public boolean startAnimation(@NotNull AnimationType type, @Nullable AnimationEndListener listener) {
        Intrinsics.checkNotNullParameter(type, "type");
        int i = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    this.mAnimation.toggleToOpenAnimation();
                    ToggleAnimationListener toggleAnimationListener = this.mToggleAnimationListener;
                    if (toggleAnimationListener != null) {
                        toggleAnimationListener.onAnimationStart(true);
                    }
                } else {
                    if (i != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    this.mAnimation.toggleToCloseAnimation();
                    ToggleAnimationListener toggleAnimationListener2 = this.mToggleAnimationListener;
                    if (toggleAnimationListener2 != null) {
                        toggleAnimationListener2.onAnimationStart(false);
                    }
                }
            } else if (!this.mAnimation.closeAnimation()) {
                Logger.m11003i(TAG, "closeAnimation() is fail.");
                return false;
            }
        } else if (!this.mAnimation.openAnimation()) {
            Logger.m11003i(TAG, "openAnimation() is fail.");
            return false;
        }
        this.mAnimationEndListener = listener;
        this.mIsAnimating = true;
        return true;
    }

    public final void toggle(int nextVisibility, boolean animation) {
        if (getVisibility() == 8 && nextVisibility == 8) {
            return;
        }
        if (animation) {
            AnimationType animationType = nextVisibility == 0 ? AnimationType.TOGGLE_TO_SHOW : AnimationType.TOGGLE_TO_HIDE;
            if (getVisibility() != 0) {
                setVisibility(0);
            }
            startAnimation(animationType, new AnimationEndListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTLayout.toggle.1
                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTLayout.AnimationEndListener
                public void onAnimationEnd(AnimationType type) {
                    Intrinsics.checkNotNullParameter(type, "type");
                    if (type == AnimationType.TOGGLE_TO_HIDE) {
                        SettingQTLayout.this.setVisibility(8);
                    }
                }
            });
            return;
        }
        Logger.m11003i(TAG, "toggle() directly visibility=" + nextVisibility);
        setVisibility(nextVisibility);
        setAlpha(1.0f);
    }

    public final void setVisibility(int visibility, boolean animation) {
        Logger.m11003i(TAG, "setVisibility(" + visibility + "), animation=" + animation + ")");
        if (!animation) {
            super.setVisibility(visibility);
            setAlpha(1.0f);
            return;
        }
        if (visibility == 0) {
            super.setVisibility(visibility);
            startAnimation$default(this, AnimationType.OPEN, null, 2, null);
        } else if (visibility != 8) {
            super.setVisibility(visibility);
        } else {
            if (startAnimation(AnimationType.CLOSE, new AnimationEndListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTLayout.setVisibility.1
                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTLayout.AnimationEndListener
                public void onAnimationEnd(AnimationType type) {
                    Intrinsics.checkNotNullParameter(type, "type");
                    Logger.m11003i(SettingQTLayout.TAG, "onAnimationEnd() in setVisibility()");
                    SettingQTLayout.this.setVisibility(8);
                }
            })) {
                return;
            }
            Logger.m11003i(TAG, "startAnimation() is false. so directly visibility called.");
            setVisibility(8);
        }
    }

    public final void addCenterView(@NotNull View centerItem, int width, int height) {
        Intrinsics.checkNotNullParameter(centerItem, "centerItem");
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(width, height);
        layoutParams.startToStart = 0;
        layoutParams.endToEnd = 0;
        layoutParams.bottomToBottom = C9086R.id.center_bg;
        ConstraintLayout constraintLayout = this.mBaseContent;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBaseContent");
            constraintLayout = null;
        }
        constraintLayout.addView(centerItem, layoutParams);
    }

    public final void addEdgeView(@NotNull View view, double angle) {
        Intrinsics.checkNotNullParameter(view, "view");
        int i = this.mChildSize;
        addEdgeView(view, i, i, angle, 0);
    }

    public final void addEdgeView(@NotNull View view, int width, int height, double angle) {
        Intrinsics.checkNotNullParameter(view, "view");
        addEdgeView(view, width, height, angle, 0);
    }

    public final void addEdgeView(@NotNull View view, double angle, int animationType) {
        Intrinsics.checkNotNullParameter(view, "view");
        int i = this.mChildSize;
        addEdgeView(view, i, i, angle, animationType);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingQTLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mAnglePosition = new QTAnglePosition();
        this.mAnimation = new QTLayoutAnimation();
        this.dockingState = DockingState.ENTER_LEFT;
        init(context, C9086R.layout.qt_pen_base_layout);
    }

    public final void addEdgeView(@NotNull View view, int width, int height, double angle, int animationType) {
        Intrinsics.checkNotNullParameter(view, "view");
        PointF viewPosition = this.mAnglePosition.getViewPosition(width, height, angle);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(width, height);
        ConstraintLayout constraintLayout = this.mBaseContent;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBaseContent");
            constraintLayout = null;
        }
        constraintLayout.addView(view, layoutParams);
        view.setX(viewPosition.x);
        view.setY(viewPosition.y);
        Logger.m11003i(TAG, "animationType=" + animationType);
        if (animationType == 1) {
            this.mAnimation.registerScaleView(view);
            return;
        }
        if (animationType != 2) {
            if (animationType != 3) {
                return;
            }
            PointF centerOffset = this.mAnglePosition.getCenterOffset(viewPosition);
            this.mAnimation.registerRotateView(view, centerOffset.x, centerOffset.y, ROTATE_VALUE_OF_OPACITY_AND_ROTATION);
            this.mAnimation.registerAlphaView(view);
            return;
        }
        PointF centerOffset2 = this.mAnglePosition.getCenterOffset(viewPosition);
        QTLayoutAnimation qTLayoutAnimation = this.mAnimation;
        float f = centerOffset2.x;
        qTLayoutAnimation.registerRotateView(view, f, centerOffset2.y, f > 0.0f ? ROTATE_VALUE_OF_SCALE_AND_ROTATION : -90.0f);
        this.mAnimation.registerScaleView(view);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingQTLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mAnglePosition = new QTAnglePosition();
        this.mAnimation = new QTLayoutAnimation();
        this.dockingState = DockingState.ENTER_LEFT;
        init(context, C9086R.layout.qt_pen_base_layout);
    }
}
