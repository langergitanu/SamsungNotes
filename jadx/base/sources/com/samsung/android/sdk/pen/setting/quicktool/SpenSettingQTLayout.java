package com.samsung.android.sdk.pen.setting.quicktool;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.dynamicanimation.animation.DynamicAnimation;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.p148nt.base.winset.app.popover.PopOverActivityWrapper;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.method.CoeditGrpcMethod;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0016\u0018\u0000 `2\u00020\u0001:\u0006`abcdeB\u0019\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\bB\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0006\u0010\u000bJ\u0018\u0010'\u001a\u00020(2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\b\u0010)\u001a\u00020(H\u0016J \u0010*\u001a\u00020\u00132\b\b\u0001\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u0005J\"\u0010*\u001a\u00020(2\u0006\u0010.\u001a\u00020\u00132\b\b\u0002\u0010,\u001a\u00020\u00052\b\b\u0002\u0010-\u001a\u00020\u0005J*\u0010/\u001a\u0004\u0018\u00010\u00132\b\b\u0001\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u0005J\u0016\u0010/\u001a\u00020(2\u0006\u00101\u001a\u00020\u00132\u0006\u00100\u001a\u00020\u0005J&\u0010/\u001a\u00020(2\u0006\u00101\u001a\u00020\u00132\u0006\u0010,\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u0005J\u001e\u0010/\u001a\u00020(2\u0006\u00101\u001a\u00020\u00132\u0006\u00100\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u0005J.\u0010/\u001a\u00020(2\u0006\u00101\u001a\u00020\u00132\u0006\u0010,\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u0005J\r\u00103\u001a\u00020(H\u0000¢\u0006\u0002\b4J\u0016\u00105\u001a\u0002062\u0006\u00101\u001a\u00020\u00132\u0006\u00107\u001a\u00020\u0005J\u000e\u00108\u001a\u00020(2\u0006\u00109\u001a\u00020\u001cJ\u0010\u0010:\u001a\u00020(2\b\u00109\u001a\u0004\u0018\u00010\u001eJ\u0010\u0010;\u001a\u0002062\u0006\u0010<\u001a\u00020=H\u0016J\u0010\u0010>\u001a\u00020(2\b\u0010?\u001a\u0004\u0018\u00010\u0013J\u0010\u0010@\u001a\u00020(2\u0006\u0010A\u001a\u00020\u0005H\u0004J\u0010\u0010B\u001a\u00020(2\u0006\u0010A\u001a\u00020\u0005H\u0004J\r\u0010C\u001a\u00020\u0001H\u0000¢\u0006\u0002\bDJ\r\u0010E\u001a\u00020\u0001H\u0000¢\u0006\u0002\bFJ\u0015\u0010G\u001a\u00020(2\u0006\u0010H\u001a\u000206H\u0000¢\u0006\u0002\bIJ\u001d\u0010J\u001a\u00020(2\u0006\u0010K\u001a\u00020#2\u0006\u0010L\u001a\u000206H\u0010¢\u0006\u0002\bMJ\u0010\u0010N\u001a\u00020(2\u0006\u0010A\u001a\u00020\u0005H\u0016J\u001c\u0010O\u001a\u00020(2\u0006\u0010A\u001a\u00020\u00052\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u001aH\u0016J!\u0010S\u001a\u0002062\u0006\u0010T\u001a\u00020U2\n\b\u0002\u00109\u001a\u0004\u0018\u00010RH\u0010¢\u0006\u0002\bVJ\u001f\u0010W\u001a\u00020(2\u0006\u0010X\u001a\u0002062\b\b\u0002\u0010L\u001a\u000206H\u0000¢\u0006\u0002\bYJ\b\u0010Z\u001a\u000206H\u0002J\b\u0010[\u001a\u00020(H\u0002J\u0018\u0010\\\u001a\u00020(2\u0006\u0010T\u001a\u00020U2\u0006\u0010]\u001a\u000206H\u0002J\u0018\u0010^\u001a\u00020(2\u0006\u0010T\u001a\u00020U2\u0006\u0010]\u001a\u000206H\u0002J\u0018\u0010_\u001a\u00020(2\u0006\u0010T\u001a\u00020U2\u0006\u0010]\u001a\u000206H\u0002R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0001X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0001X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0001X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00130!X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010$\u001a\u00020#2\u0006\u0010\"\u001a\u00020#@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u000e\u0010P\u001a\u000206X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Q\u001a\u0004\u0018\u00010RX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006f"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "layoutId", "", "<init>", "(Landroid/content/Context;I)V", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mChildSize", "mAnglePosition", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTAnglePosition;", "mRootLayout", "mMainContent", "mBaseContent", "mCenterBgView", "Landroid/view/View;", "mConsumerView", "mConsumedListener", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTCircleConsumer;", "mAnimation", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTLayoutAnimation;", "mVisibilityChangedListener", "Lcom/samsung/android/sdk/pen/setting/quicktool/OnVisibilityAnimationListener;", "mToggleAnimationListener", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTLayout$ToggleAnimationListener;", "mDockingAnimationListener", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTLayout$DockingAnimationListener;", "mBackgroundView", "mEdgeViews", "", "value", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTLayout$DockingState;", "dockingState", "getDockingState$SDK_fullRelease", "()Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTLayout$DockingState;", "init", "", "close", "addCenterView", "resource", "width", "height", "centerItem", "addEdgeView", "angle", "view", "animationType", "removeAllEdgeView", "removeAllEdgeView$SDK_fullRelease", "setEdgeViewContainerAnimation", "", "order", "setToggleAnimationListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setDockingAnimationListener", "getVisibleContentRect", "rect", "Landroid/graphics/Rect;", "setBackgroundView", "backgroundView", "setBaseContentVisibility", "visibility", "setCenterBgVisibility", "getMainContent", "getMainContent$SDK_fullRelease", "getRootLayout", "getRootLayout$SDK_fullRelease", "setVisibilityAnimationEnabled", "enabled", "setVisibilityAnimationEnabled$SDK_fullRelease", "setDockingState", "state", "animation", "setDockingState$SDK_fullRelease", "setVisibility", "setVisibilityWithAnimation", "mIsAnimating", "mQTLayoutAnimationListener", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTLayout$QTLayoutAnimationListener;", "startAnimation", "type", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTLayout$AnimationType;", "startAnimation$SDK_fullRelease", "setBackgroundVisibility", Constants.IntentExtraValue.SHOW, "setBackgroundVisibility$SDK_fullRelease", "isAnimating", "cancelAnimation", "endAnimation", "canceled", "endToggleAnimation", "endDockingAnimation", "Companion", "DockingState", "ToggleAnimationListener", "DockingAnimationListener", "AnimationType", "QTLayoutAnimationListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenSettingQTLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenSettingQTLayout.kt\ncom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTLayout\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,455:1\n1#2:456\n*E\n"})
public class SpenSettingQTLayout extends ConstraintLayout {
    public static final int ANIMATION_NONE = 0;
    private static final int ANIMATION_OPACITY_AND_ROTATION = 3;
    public static final int ANIMATION_SCALE = 1;
    public static final int ANIMATION_SCALE_AND_ROTATION = 2;
    private static final float ROTATE_BASE = 270.0f;
    private static final float ROTATE_VALUE_OF_OPACITY_AND_ROTATION = -180.0f;

    @NotNull
    private static final String TAG = "SpenSettingQTLayout";

    @NotNull
    private DockingState dockingState;

    @NotNull
    private SpenQTAnglePosition mAnglePosition;

    @NotNull
    private final SpenQTLayoutAnimation mAnimation;

    @Nullable
    private View mBackgroundView;
    private ConstraintLayout mBaseContent;
    private View mCenterBgView;
    private int mChildSize;
    private SpenQTCircleConsumer mConsumedListener;
    private View mConsumerView;

    @Nullable
    private DockingAnimationListener mDockingAnimationListener;

    @NotNull
    private final List<View> mEdgeViews;
    private boolean mIsAnimating;
    private ConstraintLayout mMainContent;

    @Nullable
    private QTLayoutAnimationListener mQTLayoutAnimationListener;
    private ConstraintLayout mRootLayout;

    @Nullable
    private ToggleAnimationListener mToggleAnimationListener;

    @Nullable
    private OnVisibilityAnimationListener mVisibilityChangedListener;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTLayout$AnimationType;", "", "<init>", "(Ljava/lang/String;I)V", CoeditGrpcMethod.Caller.OPEN, CoeditGrpcMethod.Caller.CLOSE, "TOGGLE_TO_SHOW", "TOGGLE_TO_HIDE", "ENTER_DOCKING_ZONE", "EXIT_DOCKING_ZONE", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class AnimationType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ AnimationType[] $VALUES;
        public static final AnimationType OPEN = new AnimationType(CoeditGrpcMethod.Caller.OPEN, 0);
        public static final AnimationType CLOSE = new AnimationType(CoeditGrpcMethod.Caller.CLOSE, 1);
        public static final AnimationType TOGGLE_TO_SHOW = new AnimationType("TOGGLE_TO_SHOW", 2);
        public static final AnimationType TOGGLE_TO_HIDE = new AnimationType("TOGGLE_TO_HIDE", 3);
        public static final AnimationType ENTER_DOCKING_ZONE = new AnimationType("ENTER_DOCKING_ZONE", 4);
        public static final AnimationType EXIT_DOCKING_ZONE = new AnimationType("EXIT_DOCKING_ZONE", 5);

        private static final /* synthetic */ AnimationType[] $values() {
            return new AnimationType[]{OPEN, CLOSE, TOGGLE_TO_SHOW, TOGGLE_TO_HIDE, ENTER_DOCKING_ZONE, EXIT_DOCKING_ZONE};
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

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTLayout$DockingAnimationListener;", "", "onAnimationStart", "", "isDockingMode", "", "onAnimationEnd", "canceled", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface DockingAnimationListener {
        void onAnimationEnd(boolean isDockingMode, boolean canceled);

        void onAnimationStart(boolean isDockingMode);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTLayout$DockingState;", "", "<init>", "(Ljava/lang/String;I)V", "EXIT", "ENTER_LEFT", "ENTER_RIGHT", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
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
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001a\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTLayout$QTLayoutAnimationListener;", "", "onAnimationStart", "", "type", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTLayout$AnimationType;", "onAnimationEnd", "canceled", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface QTLayoutAnimationListener {

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
        public static final class DefaultImpls {
            public static /* synthetic */ void onAnimationEnd$default(QTLayoutAnimationListener qTLayoutAnimationListener, AnimationType animationType, boolean z, int i, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onAnimationEnd");
                }
                if ((i & 2) != 0) {
                    z = false;
                }
                qTLayoutAnimationListener.onAnimationEnd(animationType, z);
            }
        }

        void onAnimationEnd(@NotNull AnimationType type, boolean canceled);

        void onAnimationStart(@NotNull AnimationType type);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTLayout$ToggleAnimationListener;", "", "onAnimationStart", "", Constants.IntentExtraValue.SHOW, "", "onAnimationEnd", "canceled", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface ToggleAnimationListener {
        void onAnimationEnd(boolean show, boolean canceled);

        void onAnimationStart(boolean show);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
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
            try {
                iArr[AnimationType.ENTER_DOCKING_ZONE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[AnimationType.EXIT_DOCKING_ZONE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenSettingQTLayout(@NotNull Context context, int i) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mAnglePosition = new SpenQTAnglePosition();
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        this.mAnimation = new SpenQTLayoutAnimation(context2);
        this.mEdgeViews = new ArrayList();
        this.dockingState = DockingState.EXIT;
        init(context, i);
    }

    public static /* synthetic */ void addCenterView$default(SpenSettingQTLayout spenSettingQTLayout, View view, int i, int i2, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addCenterView");
        }
        if ((i4 & 2) != 0) {
            i = -2;
        }
        if ((i4 & 4) != 0) {
            i2 = -2;
        }
        spenSettingQTLayout.addCenterView(view, i, i2);
    }

    private final void cancelAnimation() {
        if (getMIsAnimating()) {
            this.mAnimation.cancelAnimation();
        }
    }

    private final void endAnimation(AnimationType type, boolean canceled) {
        Log.i(TAG, "endAnimation() type=" + type + ", canceled=" + canceled);
        this.mIsAnimating = false;
        QTLayoutAnimationListener qTLayoutAnimationListener = this.mQTLayoutAnimationListener;
        if (qTLayoutAnimationListener != null) {
            qTLayoutAnimationListener.onAnimationEnd(type, canceled);
        }
        this.mQTLayoutAnimationListener = null;
        endToggleAnimation(type, canceled);
        endDockingAnimation(type, canceled);
    }

    private final void endDockingAnimation(AnimationType type, boolean canceled) {
        Log.i(TAG, "endDockingAnimation() type=" + type + ", canceled=" + canceled);
        DockingAnimationListener dockingAnimationListener = this.mDockingAnimationListener;
        if (dockingAnimationListener != null) {
            int i = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
            if (i == 5) {
                dockingAnimationListener.onAnimationEnd(true, canceled);
            } else {
                if (i != 6) {
                    return;
                }
                dockingAnimationListener.onAnimationEnd(false, canceled);
            }
        }
    }

    private final void endToggleAnimation(AnimationType type, boolean canceled) {
        Log.i(TAG, "endToggleAnimation() type=" + type + ", canceled=" + canceled);
        ToggleAnimationListener toggleAnimationListener = this.mToggleAnimationListener;
        if (toggleAnimationListener != null) {
            int i = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
            if (i == 3) {
                toggleAnimationListener.onAnimationEnd(true, canceled);
            } else {
                if (i != 4) {
                    return;
                }
                toggleAnimationListener.onAnimationEnd(false, canceled);
            }
        }
    }

    private final void init(Context context, int layoutId) {
        float dimensionPixelSize = context.getResources().getDimensionPixelSize(C7932R.dimen.qt_circle_radius);
        this.mAnglePosition.setRadius(dimensionPixelSize);
        this.mAnglePosition.setCenterPosition(context.getResources().getDimensionPixelSize(C7932R.dimen.qt_circle_center_x), context.getResources().getDimensionPixelSize(C7932R.dimen.qt_circle_center_y));
        LayoutInflater.from(context).inflate(layoutId, (ViewGroup) this, true);
        this.mBackgroundView = findViewById(C7932R.id.background_view);
        this.mMainContent = (ConstraintLayout) findViewById(C7932R.id.main_content);
        this.mBaseContent = (ConstraintLayout) findViewById(C7932R.id.base_content);
        this.mChildSize = context.getResources().getDimensionPixelSize(C7932R.dimen.qt_circle_default_child_size);
        this.mRootLayout = (ConstraintLayout) findViewById(C7932R.id.root_layout);
        this.mCenterBgView = findViewById(C7932R.id.center_bg);
        this.mConsumerView = new View(context);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(context.getResources().getDimensionPixelSize(C7932R.dimen.qt_circle_layout_width), context.getResources().getDimensionPixelSize(C7932R.dimen.qt_circle_layout_height));
        layoutParams.startToStart = 0;
        layoutParams.bottomToBottom = 0;
        layoutParams.topToTop = 0;
        layoutParams.endToEnd = 0;
        View view = this.mConsumerView;
        SpenQTCircleConsumer spenQTCircleConsumer = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mConsumerView");
            view = null;
        }
        super.addView(view, 0, layoutParams);
        SpenQTCircleConsumer spenQTCircleConsumer2 = new SpenQTCircleConsumer();
        this.mConsumedListener = spenQTCircleConsumer2;
        View view2 = this.mConsumerView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mConsumerView");
            view2 = null;
        }
        spenQTCircleConsumer2.setView(view2, dimensionPixelSize, context.getResources().getDimensionPixelSize(C7932R.dimen.qt_circle_stroke_size));
        SpenQTCircleConsumer spenQTCircleConsumer3 = this.mConsumedListener;
        if (spenQTCircleConsumer3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mConsumedListener");
        } else {
            spenQTCircleConsumer = spenQTCircleConsumer3;
        }
        spenQTCircleConsumer.setViewParent(this);
        this.mAnimation.setTargetView(this);
    }

    /* JADX INFO: renamed from: isAnimating, reason: from getter */
    private final boolean getMIsAnimating() {
        return this.mIsAnimating;
    }

    public static /* synthetic */ void setBackgroundVisibility$SDK_fullRelease$default(SpenSettingQTLayout spenSettingQTLayout, boolean z, boolean z2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setBackgroundVisibility");
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        spenSettingQTLayout.setBackgroundVisibility$SDK_fullRelease(z, z2);
    }

    public static /* synthetic */ void setVisibilityWithAnimation$default(SpenSettingQTLayout spenSettingQTLayout, int i, OnVisibilityAnimationListener onVisibilityAnimationListener, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setVisibilityWithAnimation");
        }
        if ((i2 & 2) != 0) {
            onVisibilityAnimationListener = null;
        }
        spenSettingQTLayout.setVisibilityWithAnimation(i, onVisibilityAnimationListener);
    }

    public static /* synthetic */ boolean startAnimation$SDK_fullRelease$default(SpenSettingQTLayout spenSettingQTLayout, AnimationType animationType, QTLayoutAnimationListener qTLayoutAnimationListener, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startAnimation");
        }
        if ((i & 2) != 0) {
            qTLayoutAnimationListener = null;
        }
        return spenSettingQTLayout.startAnimation$SDK_fullRelease(animationType, qTLayoutAnimationListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startAnimation$lambda$2(SpenSettingQTLayout spenSettingQTLayout, DynamicAnimation dynamicAnimation, boolean z, float f, float f4) {
        spenSettingQTLayout.endAnimation(AnimationType.OPEN, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startAnimation$lambda$3(SpenSettingQTLayout spenSettingQTLayout, DynamicAnimation dynamicAnimation, boolean z, float f, float f4) {
        spenSettingQTLayout.endAnimation(AnimationType.CLOSE, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startAnimation$lambda$4(SpenSettingQTLayout spenSettingQTLayout, DynamicAnimation dynamicAnimation, boolean z, float f, float f4) {
        spenSettingQTLayout.endAnimation(AnimationType.TOGGLE_TO_SHOW, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startAnimation$lambda$5(SpenSettingQTLayout spenSettingQTLayout, DynamicAnimation dynamicAnimation, boolean z, float f, float f4) {
        spenSettingQTLayout.endAnimation(AnimationType.TOGGLE_TO_HIDE, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startAnimation$lambda$6(SpenSettingQTLayout spenSettingQTLayout, DynamicAnimation dynamicAnimation, boolean z, float f, float f4) {
        spenSettingQTLayout.endAnimation(AnimationType.ENTER_DOCKING_ZONE, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startAnimation$lambda$7(SpenSettingQTLayout spenSettingQTLayout, DynamicAnimation dynamicAnimation, boolean z, float f, float f4) {
        spenSettingQTLayout.endAnimation(AnimationType.EXIT_DOCKING_ZONE, z);
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
    public final View addEdgeView(@LayoutRes int resource, int width, int height, int angle) {
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
        SpenQTCircleConsumer spenQTCircleConsumer = null;
        this.mBackgroundView = null;
        this.mToggleAnimationListener = null;
        this.mVisibilityChangedListener = null;
        this.mAnimation.close();
        SpenQTCircleConsumer spenQTCircleConsumer2 = this.mConsumedListener;
        if (spenQTCircleConsumer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mConsumedListener");
        } else {
            spenQTCircleConsumer = spenQTCircleConsumer2;
        }
        spenQTCircleConsumer.close();
        this.mEdgeViews.clear();
        removeAllViews();
    }

    @NotNull
    /* JADX INFO: renamed from: getDockingState$SDK_fullRelease, reason: from getter */
    public final DockingState getDockingState() {
        return this.dockingState;
    }

    @NotNull
    public final ConstraintLayout getMainContent$SDK_fullRelease() {
        ConstraintLayout constraintLayout = this.mMainContent;
        if (constraintLayout != null) {
            return constraintLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mMainContent");
        return null;
    }

    @NotNull
    public final ConstraintLayout getRootLayout$SDK_fullRelease() {
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

    public final void removeAllEdgeView$SDK_fullRelease() {
        int size = this.mEdgeViews.size();
        ConstraintLayout constraintLayout = this.mBaseContent;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBaseContent");
            constraintLayout = null;
        }
        AbstractC6670b.m4744e(size, constraintLayout.getChildCount(), "removeAllEdgeView() size=", " child=", TAG);
        if (this.mEdgeViews.isEmpty()) {
            return;
        }
        this.mAnimation.clearAllAnimationView();
        for (View view : this.mEdgeViews) {
            ConstraintLayout constraintLayout2 = this.mBaseContent;
            if (constraintLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBaseContent");
                constraintLayout2 = null;
            }
            constraintLayout2.removeView(view);
        }
        this.mEdgeViews.clear();
    }

    public final void setBackgroundView(@Nullable View backgroundView) {
        Log.i(TAG, "setBackgroundView() view=" + backgroundView);
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

    public final void setBackgroundVisibility$SDK_fullRelease(boolean show, boolean animation) {
        View view = this.mBackgroundView;
        if (view != null) {
            float f = show ? 0.0f : 1.0f;
            float f4 = show ? 1.0f : 0.0f;
            long j = show ? 300L : 150L;
            if (!animation) {
                view.setAlpha(f4);
            } else {
                view.setAlpha(f);
                view.animate().alpha(f4).setDuration(j).start();
            }
        }
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

    public final void setDockingAnimationListener(@Nullable DockingAnimationListener listener) {
        this.mDockingAnimationListener = listener;
    }

    public void setDockingState$SDK_fullRelease(@NotNull DockingState state, boolean animation) {
        Intrinsics.checkNotNullParameter(state, "state");
        Log.i(TAG, "setDockingState() state=" + state + " dockingState=" + this.dockingState);
        if (state == this.dockingState) {
            return;
        }
        this.dockingState = state;
        if (this.mAnimation.getAnimationViewCount() == 0) {
            Log.i(TAG, "animationCount=0. so skip next step");
        } else if (animation) {
            startAnimation$SDK_fullRelease(state == DockingState.EXIT ? AnimationType.EXIT_DOCKING_ZONE : AnimationType.ENTER_DOCKING_ZONE, null);
        } else {
            this.mAnimation.setViewVisibility(state == DockingState.EXIT ? 0 : 4);
        }
    }

    public final boolean setEdgeViewContainerAnimation(@NotNull View view, int order) {
        Intrinsics.checkNotNullParameter(view, "view");
        Log.i(TAG, "setEdgeViewContainerAnimation() order=" + order);
        return this.mAnimation.registerContainerAnimationView(view, order);
    }

    public final void setToggleAnimationListener(@NotNull ToggleAnimationListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mToggleAnimationListener = listener;
    }

    @Override // android.view.View
    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        if ((visibility == 8) && (!(getAlpha() == 1.0f))) {
            setAlpha(1.0f);
        }
    }

    public final void setVisibilityAnimationEnabled$SDK_fullRelease(boolean enabled) {
        this.mAnimation.setTargetView(enabled ? this : null);
    }

    public void setVisibilityWithAnimation(int visibility, @Nullable final OnVisibilityAnimationListener listener) {
        AbstractC11014a.m12328m(visibility, "setVisibilityWithAnimation(", ")", TAG);
        cancelAnimation();
        if (visibility == 0) {
            super.setVisibility(visibility);
            startAnimation$SDK_fullRelease(AnimationType.OPEN, new QTLayoutAnimationListener() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTLayout.setVisibilityWithAnimation.1
                @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTLayout.QTLayoutAnimationListener
                public void onAnimationEnd(AnimationType type, boolean canceled) {
                    Intrinsics.checkNotNullParameter(type, "type");
                    Log.i(SpenSettingQTLayout.TAG, "onAnimationEnd() in setVisibility() canceled=" + canceled);
                    OnVisibilityAnimationListener onVisibilityAnimationListener = listener;
                    if (onVisibilityAnimationListener != null) {
                        onVisibilityAnimationListener.onAnimationEnd(0, canceled);
                    }
                }

                @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTLayout.QTLayoutAnimationListener
                public void onAnimationStart(AnimationType type) {
                    Intrinsics.checkNotNullParameter(type, "type");
                    OnVisibilityAnimationListener onVisibilityAnimationListener = listener;
                    if (onVisibilityAnimationListener != null) {
                        onVisibilityAnimationListener.onAnimationStart(0);
                    }
                }
            });
        } else if (visibility != 8) {
            Log.i(TAG, "Not Support animation");
            setVisibility(visibility);
        } else {
            if (startAnimation$SDK_fullRelease(AnimationType.CLOSE, new QTLayoutAnimationListener() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTLayout.setVisibilityWithAnimation.2
                @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTLayout.QTLayoutAnimationListener
                public void onAnimationEnd(AnimationType type, boolean canceled) {
                    Intrinsics.checkNotNullParameter(type, "type");
                    Log.i(SpenSettingQTLayout.TAG, "onAnimationEnd() in setVisibility() canceled=" + canceled);
                    this.setVisibility(8);
                    OnVisibilityAnimationListener onVisibilityAnimationListener = listener;
                    if (onVisibilityAnimationListener != null) {
                        onVisibilityAnimationListener.onAnimationEnd(8, canceled);
                    }
                }

                @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTLayout.QTLayoutAnimationListener
                public void onAnimationStart(AnimationType type) {
                    Intrinsics.checkNotNullParameter(type, "type");
                    OnVisibilityAnimationListener onVisibilityAnimationListener = listener;
                    if (onVisibilityAnimationListener != null) {
                        onVisibilityAnimationListener.onAnimationStart(8);
                    }
                }
            })) {
                return;
            }
            Log.i(TAG, "startAnimation() is false. so directly visibility called.");
            setVisibility(8);
        }
    }

    public boolean startAnimation$SDK_fullRelease(@NotNull AnimationType type, @Nullable QTLayoutAnimationListener listener) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (getMIsAnimating()) {
            cancelAnimation();
        }
        boolean z = this.dockingState != DockingState.EXIT;
        switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
            case 1:
                final int i = 0;
                if (!this.mAnimation.openAnimation(z, new DynamicAnimation.OnAnimationEndListener(this) { // from class: com.samsung.android.sdk.pen.setting.quicktool.l

                    /* JADX INFO: renamed from: b */
                    public final /* synthetic */ SpenSettingQTLayout f5103b;

                    {
                        this.f5103b = this;
                    }

                    @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener
                    public final void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z2, float f, float f4) {
                        switch (i) {
                            case 0:
                                SpenSettingQTLayout.startAnimation$lambda$2(this.f5103b, dynamicAnimation, z2, f, f4);
                                break;
                            case 1:
                                SpenSettingQTLayout.startAnimation$lambda$3(this.f5103b, dynamicAnimation, z2, f, f4);
                                break;
                            case 2:
                                SpenSettingQTLayout.startAnimation$lambda$4(this.f5103b, dynamicAnimation, z2, f, f4);
                                break;
                            case 3:
                                SpenSettingQTLayout.startAnimation$lambda$5(this.f5103b, dynamicAnimation, z2, f, f4);
                                break;
                            case 4:
                                SpenSettingQTLayout.startAnimation$lambda$6(this.f5103b, dynamicAnimation, z2, f, f4);
                                break;
                            default:
                                SpenSettingQTLayout.startAnimation$lambda$7(this.f5103b, dynamicAnimation, z2, f, f4);
                                break;
                        }
                    }
                })) {
                    Log.i(TAG, "openAnimation() is fail.");
                    return false;
                }
                break;
            case 2:
                final int i2 = 1;
                if (!this.mAnimation.closeAnimation(z, new DynamicAnimation.OnAnimationEndListener(this) { // from class: com.samsung.android.sdk.pen.setting.quicktool.l

                    /* JADX INFO: renamed from: b */
                    public final /* synthetic */ SpenSettingQTLayout f5103b;

                    {
                        this.f5103b = this;
                    }

                    @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener
                    public final void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z2, float f, float f4) {
                        switch (i2) {
                            case 0:
                                SpenSettingQTLayout.startAnimation$lambda$2(this.f5103b, dynamicAnimation, z2, f, f4);
                                break;
                            case 1:
                                SpenSettingQTLayout.startAnimation$lambda$3(this.f5103b, dynamicAnimation, z2, f, f4);
                                break;
                            case 2:
                                SpenSettingQTLayout.startAnimation$lambda$4(this.f5103b, dynamicAnimation, z2, f, f4);
                                break;
                            case 3:
                                SpenSettingQTLayout.startAnimation$lambda$5(this.f5103b, dynamicAnimation, z2, f, f4);
                                break;
                            case 4:
                                SpenSettingQTLayout.startAnimation$lambda$6(this.f5103b, dynamicAnimation, z2, f, f4);
                                break;
                            default:
                                SpenSettingQTLayout.startAnimation$lambda$7(this.f5103b, dynamicAnimation, z2, f, f4);
                                break;
                        }
                    }
                })) {
                    Log.i(TAG, "closeAnimation() is fail.");
                    return false;
                }
                break;
            case 3:
                final int i4 = 2;
                this.mAnimation.toggleToOpenAnimation(z, new DynamicAnimation.OnAnimationEndListener(this) { // from class: com.samsung.android.sdk.pen.setting.quicktool.l

                    /* JADX INFO: renamed from: b */
                    public final /* synthetic */ SpenSettingQTLayout f5103b;

                    {
                        this.f5103b = this;
                    }

                    @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener
                    public final void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z2, float f, float f4) {
                        switch (i4) {
                            case 0:
                                SpenSettingQTLayout.startAnimation$lambda$2(this.f5103b, dynamicAnimation, z2, f, f4);
                                break;
                            case 1:
                                SpenSettingQTLayout.startAnimation$lambda$3(this.f5103b, dynamicAnimation, z2, f, f4);
                                break;
                            case 2:
                                SpenSettingQTLayout.startAnimation$lambda$4(this.f5103b, dynamicAnimation, z2, f, f4);
                                break;
                            case 3:
                                SpenSettingQTLayout.startAnimation$lambda$5(this.f5103b, dynamicAnimation, z2, f, f4);
                                break;
                            case 4:
                                SpenSettingQTLayout.startAnimation$lambda$6(this.f5103b, dynamicAnimation, z2, f, f4);
                                break;
                            default:
                                SpenSettingQTLayout.startAnimation$lambda$7(this.f5103b, dynamicAnimation, z2, f, f4);
                                break;
                        }
                    }
                });
                ToggleAnimationListener toggleAnimationListener = this.mToggleAnimationListener;
                if (toggleAnimationListener != null) {
                    toggleAnimationListener.onAnimationStart(true);
                }
                if (this.mAnimation.hasContainerAnimationView()) {
                    setBackgroundVisibility$SDK_fullRelease$default(this, true, false, 2, null);
                }
                break;
            case 4:
                final int i5 = 3;
                this.mAnimation.toggleToCloseAnimation(z, new DynamicAnimation.OnAnimationEndListener(this) { // from class: com.samsung.android.sdk.pen.setting.quicktool.l

                    /* JADX INFO: renamed from: b */
                    public final /* synthetic */ SpenSettingQTLayout f5103b;

                    {
                        this.f5103b = this;
                    }

                    @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener
                    public final void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z2, float f, float f4) {
                        switch (i5) {
                            case 0:
                                SpenSettingQTLayout.startAnimation$lambda$2(this.f5103b, dynamicAnimation, z2, f, f4);
                                break;
                            case 1:
                                SpenSettingQTLayout.startAnimation$lambda$3(this.f5103b, dynamicAnimation, z2, f, f4);
                                break;
                            case 2:
                                SpenSettingQTLayout.startAnimation$lambda$4(this.f5103b, dynamicAnimation, z2, f, f4);
                                break;
                            case 3:
                                SpenSettingQTLayout.startAnimation$lambda$5(this.f5103b, dynamicAnimation, z2, f, f4);
                                break;
                            case 4:
                                SpenSettingQTLayout.startAnimation$lambda$6(this.f5103b, dynamicAnimation, z2, f, f4);
                                break;
                            default:
                                SpenSettingQTLayout.startAnimation$lambda$7(this.f5103b, dynamicAnimation, z2, f, f4);
                                break;
                        }
                    }
                });
                ToggleAnimationListener toggleAnimationListener2 = this.mToggleAnimationListener;
                if (toggleAnimationListener2 != null) {
                    toggleAnimationListener2.onAnimationStart(false);
                }
                if (this.mAnimation.hasContainerAnimationView()) {
                    setBackgroundVisibility$SDK_fullRelease$default(this, false, false, 2, null);
                }
                break;
            case 5:
                final int i6 = 4;
                this.mAnimation.enterDockingZoneAnimation(new DynamicAnimation.OnAnimationEndListener(this) { // from class: com.samsung.android.sdk.pen.setting.quicktool.l

                    /* JADX INFO: renamed from: b */
                    public final /* synthetic */ SpenSettingQTLayout f5103b;

                    {
                        this.f5103b = this;
                    }

                    @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener
                    public final void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z2, float f, float f4) {
                        switch (i6) {
                            case 0:
                                SpenSettingQTLayout.startAnimation$lambda$2(this.f5103b, dynamicAnimation, z2, f, f4);
                                break;
                            case 1:
                                SpenSettingQTLayout.startAnimation$lambda$3(this.f5103b, dynamicAnimation, z2, f, f4);
                                break;
                            case 2:
                                SpenSettingQTLayout.startAnimation$lambda$4(this.f5103b, dynamicAnimation, z2, f, f4);
                                break;
                            case 3:
                                SpenSettingQTLayout.startAnimation$lambda$5(this.f5103b, dynamicAnimation, z2, f, f4);
                                break;
                            case 4:
                                SpenSettingQTLayout.startAnimation$lambda$6(this.f5103b, dynamicAnimation, z2, f, f4);
                                break;
                            default:
                                SpenSettingQTLayout.startAnimation$lambda$7(this.f5103b, dynamicAnimation, z2, f, f4);
                                break;
                        }
                    }
                });
                DockingAnimationListener dockingAnimationListener = this.mDockingAnimationListener;
                if (dockingAnimationListener != null) {
                    dockingAnimationListener.onAnimationStart(true);
                }
                break;
            case 6:
                final int i7 = 5;
                this.mAnimation.exitDockingZoneAnimation(new DynamicAnimation.OnAnimationEndListener(this) { // from class: com.samsung.android.sdk.pen.setting.quicktool.l

                    /* JADX INFO: renamed from: b */
                    public final /* synthetic */ SpenSettingQTLayout f5103b;

                    {
                        this.f5103b = this;
                    }

                    @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener
                    public final void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z2, float f, float f4) {
                        switch (i7) {
                            case 0:
                                SpenSettingQTLayout.startAnimation$lambda$2(this.f5103b, dynamicAnimation, z2, f, f4);
                                break;
                            case 1:
                                SpenSettingQTLayout.startAnimation$lambda$3(this.f5103b, dynamicAnimation, z2, f, f4);
                                break;
                            case 2:
                                SpenSettingQTLayout.startAnimation$lambda$4(this.f5103b, dynamicAnimation, z2, f, f4);
                                break;
                            case 3:
                                SpenSettingQTLayout.startAnimation$lambda$5(this.f5103b, dynamicAnimation, z2, f, f4);
                                break;
                            case 4:
                                SpenSettingQTLayout.startAnimation$lambda$6(this.f5103b, dynamicAnimation, z2, f, f4);
                                break;
                            default:
                                SpenSettingQTLayout.startAnimation$lambda$7(this.f5103b, dynamicAnimation, z2, f, f4);
                                break;
                        }
                    }
                });
                DockingAnimationListener dockingAnimationListener2 = this.mDockingAnimationListener;
                if (dockingAnimationListener2 != null) {
                    dockingAnimationListener2.onAnimationStart(false);
                }
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        this.mQTLayoutAnimationListener = listener;
        if (listener != null) {
            listener.onAnimationStart(type);
        }
        this.mIsAnimating = true;
        return true;
    }

    public final void addCenterView(@NotNull View centerItem, int width, int height) {
        Intrinsics.checkNotNullParameter(centerItem, "centerItem");
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(width, height);
        layoutParams.startToStart = 0;
        layoutParams.endToEnd = 0;
        layoutParams.bottomToBottom = C7932R.id.center_bg;
        ConstraintLayout constraintLayout = this.mBaseContent;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBaseContent");
            constraintLayout = null;
        }
        constraintLayout.addView(centerItem, layoutParams);
    }

    public final void addEdgeView(@NotNull View view, int angle) {
        Intrinsics.checkNotNullParameter(view, "view");
        int i = this.mChildSize;
        addEdgeView(view, i, i, angle, 0);
    }

    public final void addEdgeView(@NotNull View view, int width, int height, int angle) {
        Intrinsics.checkNotNullParameter(view, "view");
        addEdgeView(view, width, height, angle, 0);
    }

    public final void addEdgeView(@NotNull View view, int angle, int animationType) {
        Intrinsics.checkNotNullParameter(view, "view");
        int i = this.mChildSize;
        addEdgeView(view, i, i, angle, animationType);
    }

    public final void addEdgeView(@NotNull View view, int width, int height, int angle, int animationType) {
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
        this.mEdgeViews.add(view);
        Log.i(TAG, "animationType=" + animationType);
        if (animationType == 1) {
            this.mAnimation.registerScaleView(view);
            return;
        }
        if (animationType != 2) {
            if (animationType != 3) {
                return;
            }
            this.mAnimation.registerRotateView(view, angle + ROTATE_VALUE_OF_OPACITY_AND_ROTATION, angle);
            this.mAnimation.registerAlphaView(view);
            return;
        }
        int i = this.mAnglePosition.getCenterOffset(viewPosition).x <= 0.0f ? -1 : 1;
        if (angle == 0) {
            angle = PopOverActivityWrapper.DEFAULT_WIDTH;
        }
        float f = angle;
        this.mAnimation.registerRotateView(view, f + (Math.abs(ROTATE_BASE - f) * i), angle);
        this.mAnimation.registerScaleView(view);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenSettingQTLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mAnglePosition = new SpenQTAnglePosition();
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        this.mAnimation = new SpenQTLayoutAnimation(context2);
        this.mEdgeViews = new ArrayList();
        this.dockingState = DockingState.EXIT;
        init(context, C7932R.layout.setting_qt_base_layout);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenSettingQTLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mAnglePosition = new SpenQTAnglePosition();
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        this.mAnimation = new SpenQTLayoutAnimation(context2);
        this.mEdgeViews = new ArrayList();
        this.dockingState = DockingState.EXIT;
        init(context, C7932R.layout.setting_qt_base_layout);
    }
}
