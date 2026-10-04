package com.samsung.android.sdk.pen.setting.quicktool;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.PointF;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FloatPropertyCompat;
import androidx.dynamicanimation.animation.FloatValueHolder;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import androidx.glance.AbstractC2821a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.oneui.floatingdock.C4796g;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAnimation;
import com.samsung.android.spen.C7932R;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0017\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n*\u0004=@CF\b\u0000\u0018\u0000 R2\u00020\u0001:\u0004RSTUB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0007J\u0006\u0010!\u001a\u00020\rJ\u000e\u0010\"\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0007J\u001e\u0010#\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00072\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\rJ\u000e\u0010'\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0007J\u0016\u0010(\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u00072\u0006\u0010)\u001a\u00020\rJ\u0006\u0010*\u001a\u00020\u001fJ\u0006\u0010+\u001a\u00020\u001bJ\b\u0010,\u001a\u00020\u001fH\u0002J\u0006\u0010-\u001a\u00020\u001fJ\u0006\u0010.\u001a\u00020\u001fJ \u0010/\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00072\u0006\u00100\u001a\u00020%2\u0006\u00101\u001a\u00020%H\u0002J\u0018\u00102\u001a\u00020\u001b2\u0006\u00103\u001a\u00020\u001b2\b\u00104\u001a\u0004\u0018\u00010\u000fJ\u0018\u00105\u001a\u00020\u001b2\u0006\u00103\u001a\u00020\u001b2\b\u00104\u001a\u0004\u0018\u00010\u000fJ\u000e\u00106\u001a\u00020\u001f2\u0006\u00107\u001a\u00020\rJ\u0018\u00108\u001a\u00020\u001f2\u0006\u00103\u001a\u00020\u001b2\b\u00104\u001a\u0004\u0018\u00010\u000fJ\u0018\u00109\u001a\u00020\u001f2\u0006\u00103\u001a\u00020\u001b2\b\u00104\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010:\u001a\u00020\u001f2\b\u00104\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010;\u001a\u00020\u001f2\b\u00104\u001a\u0004\u0018\u00010\u000fJ\b\u0010H\u001a\u00020\u001fH\u0002J\b\u0010I\u001a\u00020\u001fH\u0002JJ\u0010J\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u00072\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00070L2\u0006\u0010M\u001a\u00020%2\u0006\u0010N\u001a\u00020%2\u0006\u0010O\u001a\u00020%2\u0006\u0010P\u001a\u00020%2\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u000fH\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u00020=X\u0082\u0004¢\u0006\u0004\n\u0002\u0010>R\u0010\u0010?\u001a\u00020@X\u0082\u0004¢\u0006\u0004\n\u0002\u0010AR\u0010\u0010B\u001a\u00020CX\u0082\u0004¢\u0006\u0004\n\u0002\u0010DR\u0010\u0010E\u001a\u00020FX\u0082\u0004¢\u0006\u0004\n\u0002\u0010G¨\u0006V"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTLayoutAnimation;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mTargetView", "Landroid/view/View;", "mAniItems", "Ljava/util/HashMap;", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTLayoutAnimation$AnimationInfo;", "Lkotlin/collections/HashMap;", "mContainerLastOrder", "", "mShowAnimationEndLister", "Landroidx/dynamicanimation/animation/DynamicAnimation$OnAnimationEndListener;", "mHideAnimationEndLister", "mToggleToOpenAnimationListener", "mToggleToCloseAnimationListener", "mEnterDockingZoneAnimationListener", "mExitDockingZoneAnimationListener", "mShowSpringX", "Landroidx/dynamicanimation/animation/SpringAnimation;", "mShowSpringY", "mHideSpringX", "mHideSpringY", "mIsAnimationInitialized", "", "mAnglePosition", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTAnglePosition;", "setTargetView", "", "view", "getAnimationViewCount", "registerScaleView", "registerRotateView", "rotateValue", "", "angle", "registerAlphaView", "registerContainerAnimationView", "order", "clearAllAnimationView", "hasContainerAnimationView", "clearAnimationItem", "close", "cancelAnimation", "rotateAnimation", "startPosition", "endPosition", "openAnimation", "skipAniItem", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "closeAnimation", "setViewVisibility", "viewVisibility", "toggleToOpenAnimation", "toggleToCloseAnimation", "enterDockingZoneAnimation", "exitDockingZoneAnimation", "mToggleToOpenAnimatorListenerAdapter", "com/samsung/android/sdk/pen/setting/quicktool/SpenQTLayoutAnimation$mToggleToOpenAnimatorListenerAdapter$1", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTLayoutAnimation$mToggleToOpenAnimatorListenerAdapter$1;", "mToggleToCloseAnimatorListenerAdapter", "com/samsung/android/sdk/pen/setting/quicktool/SpenQTLayoutAnimation$mToggleToCloseAnimatorListenerAdapter$1", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTLayoutAnimation$mToggleToCloseAnimatorListenerAdapter$1;", "mEnterDockingZoneAnimatorListenerAdapter", "com/samsung/android/sdk/pen/setting/quicktool/SpenQTLayoutAnimation$mEnterDockingZoneAnimatorListenerAdapter$1", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTLayoutAnimation$mEnterDockingZoneAnimatorListenerAdapter$1;", "mExitDockingZoneAnimatorListenerAdapter", "com/samsung/android/sdk/pen/setting/quicktool/SpenQTLayoutAnimation$mExitDockingZoneAnimatorListenerAdapter$1", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTLayoutAnimation$mExitDockingZoneAnimatorListenerAdapter$1;", "initAnimation", "clearAnimation", "createSpringAnimation", "property", "Landroidx/dynamicanimation/animation/FloatPropertyCompat;", "startValue", "dampingRatio", "stiffness", "finalPosition", "endListener", "Companion", "OpenCloseInfo", "ContainerAnimationInfo", "AnimationInfo", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenQTLayoutAnimation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenQTLayoutAnimation.kt\ncom/samsung/android/sdk/pen/setting/quicktool/SpenQTLayoutAnimation\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,553:1\n215#2,2:554\n215#2,2:556\n215#2,2:558\n215#2,2:560\n215#2,2:562\n215#2,2:564\n215#2,2:566\n*S KotlinDebug\n*F\n+ 1 SpenQTLayoutAnimation.kt\ncom/samsung/android/sdk/pen/setting/quicktool/SpenQTLayoutAnimation\n*L\n225#1:554,2\n273#1:556,2\n326#1:558,2\n340#1:560,2\n373#1:562,2\n405#1:564,2\n436#1:566,2\n*E\n"})
public final class SpenQTLayoutAnimation {
    private static final float HIDE_BASE_ALPHA = 0.0f;
    private static final float HIDE_BASE_SCALE = 0.0f;
    private static final float SHOW_BASE_ALPHA = 1.0f;
    private static final float SHOW_BASE_SCALE = 1.0f;

    @NotNull
    private static final String TAG = "SpenQTLayoutAnimation";
    private static final int VI_ALPHA = 4;
    private static final long VI_ALPHA_HIDE_DURATION = 100;
    private static final long VI_ALPHA_SHOW_DURATION = 200;
    private static final long VI_DOCKING_SCALE_HIDE_DURATION = 300;
    private static final long VI_DOCKING_SCALE_SHOW_DURATION = 400;
    private static final int VI_ROTATION = 2;
    private static final float VI_ROTATION_BASE_POSITION = 270.0f;
    private static final float VI_ROTATION_DAMPING_RATIO = 0.6f;
    private static final float VI_ROTATION_STIFFNESS = 200.0f;
    private static final int VI_SCALE = 1;
    private static final long VI_SCALE_HIDE_DURATION = 350;
    private static final long VI_SCALE_SHOW_DURATION = 400;
    private static final long VI_TARGET_ALPHA_HIDE_DURATION = 100;
    private static final float VI_TARGET_DAMPING_RATIO = 0.55f;
    private static final float VI_TARGET_STIFFNESS = 200.0f;
    private static final long VI_TOGGLE_SCALE_HIDE_DURATION = 350;
    private static final int VI_TOGGLE_SCALE_INTER_ORDER_DELAY = 50;
    private static final long VI_TOGGLE_SCALE_SHOW_DURATION = 400;

    @NotNull
    private final SpenQTAnglePosition mAnglePosition;

    @NotNull
    private final HashMap<View, AnimationInfo> mAniItems;
    private int mContainerLastOrder;

    @Nullable
    private DynamicAnimation.OnAnimationEndListener mEnterDockingZoneAnimationListener;

    @NotNull
    private final SpenQTLayoutAnimation$mEnterDockingZoneAnimatorListenerAdapter$1 mEnterDockingZoneAnimatorListenerAdapter;

    @Nullable
    private DynamicAnimation.OnAnimationEndListener mExitDockingZoneAnimationListener;

    @NotNull
    private final SpenQTLayoutAnimation$mExitDockingZoneAnimatorListenerAdapter$1 mExitDockingZoneAnimatorListenerAdapter;

    @Nullable
    private DynamicAnimation.OnAnimationEndListener mHideAnimationEndLister;

    @Nullable
    private SpringAnimation mHideSpringX;

    @Nullable
    private SpringAnimation mHideSpringY;
    private boolean mIsAnimationInitialized;

    @Nullable
    private DynamicAnimation.OnAnimationEndListener mShowAnimationEndLister;

    @Nullable
    private SpringAnimation mShowSpringX;

    @Nullable
    private SpringAnimation mShowSpringY;

    @Nullable
    private View mTargetView;

    @Nullable
    private DynamicAnimation.OnAnimationEndListener mToggleToCloseAnimationListener;

    @NotNull
    private final SpenQTLayoutAnimation$mToggleToCloseAnimatorListenerAdapter$1 mToggleToCloseAnimatorListenerAdapter;

    @Nullable
    private DynamicAnimation.OnAnimationEndListener mToggleToOpenAnimationListener;

    @NotNull
    private final SpenQTLayoutAnimation$mToggleToOpenAnimatorListenerAdapter$1 mToggleToOpenAnimatorListenerAdapter;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTLayoutAnimation$ContainerAnimationInfo;", "", "order", "", "startDelay", "", "<init>", "(IJ)V", "getOrder", "()I", "setOrder", "(I)V", "getStartDelay", "()J", "setStartDelay", "(J)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final /* data */ class ContainerAnimationInfo {
        private int order;
        private long startDelay;

        public ContainerAnimationInfo() {
            this(0, 0L, 3, null);
        }

        public static /* synthetic */ ContainerAnimationInfo copy$default(ContainerAnimationInfo containerAnimationInfo, int i, long j, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = containerAnimationInfo.order;
            }
            if ((i2 & 2) != 0) {
                j = containerAnimationInfo.startDelay;
            }
            return containerAnimationInfo.copy(i, j);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getOrder() {
            return this.order;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getStartDelay() {
            return this.startDelay;
        }

        @NotNull
        public final ContainerAnimationInfo copy(int order, long startDelay) {
            return new ContainerAnimationInfo(order, startDelay);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ContainerAnimationInfo)) {
                return false;
            }
            ContainerAnimationInfo containerAnimationInfo = (ContainerAnimationInfo) other;
            return this.order == containerAnimationInfo.order && this.startDelay == containerAnimationInfo.startDelay;
        }

        public final int getOrder() {
            return this.order;
        }

        public final long getStartDelay() {
            return this.startDelay;
        }

        public int hashCode() {
            return Long.hashCode(this.startDelay) + (Integer.hashCode(this.order) * 31);
        }

        public final void setOrder(int i) {
            this.order = i;
        }

        public final void setStartDelay(long j) {
            this.startDelay = j;
        }

        @NotNull
        public String toString() {
            return "ContainerAnimationInfo(order=" + this.order + ", startDelay=" + this.startDelay + ")";
        }

        public ContainerAnimationInfo(int i, long j) {
            this.order = i;
            this.startDelay = j;
        }

        public /* synthetic */ ContainerAnimationInfo(int i, long j, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? 0L : j);
        }
    }

    /* JADX WARN: Type inference failed for: r4v3, types: [com.samsung.android.sdk.pen.setting.quicktool.SpenQTLayoutAnimation$mToggleToOpenAnimatorListenerAdapter$1] */
    /* JADX WARN: Type inference failed for: r4v4, types: [com.samsung.android.sdk.pen.setting.quicktool.SpenQTLayoutAnimation$mToggleToCloseAnimatorListenerAdapter$1] */
    /* JADX WARN: Type inference failed for: r4v5, types: [com.samsung.android.sdk.pen.setting.quicktool.SpenQTLayoutAnimation$mEnterDockingZoneAnimatorListenerAdapter$1] */
    /* JADX WARN: Type inference failed for: r4v6, types: [com.samsung.android.sdk.pen.setting.quicktool.SpenQTLayoutAnimation$mExitDockingZoneAnimatorListenerAdapter$1] */
    public SpenQTLayoutAnimation(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mAniItems = new HashMap<>();
        this.mContainerLastOrder = -1;
        SpenQTAnglePosition spenQTAnglePosition = new SpenQTAnglePosition();
        this.mAnglePosition = spenQTAnglePosition;
        spenQTAnglePosition.setRadius(context.getResources().getDimensionPixelSize(C7932R.dimen.qt_circle_radius));
        spenQTAnglePosition.setCenterPosition(context.getResources().getDimensionPixelSize(C7932R.dimen.qt_circle_center_x), context.getResources().getDimensionPixelSize(C7932R.dimen.qt_circle_center_y));
        this.mToggleToOpenAnimatorListenerAdapter = new AnimatorListenerAdapter() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenQTLayoutAnimation$mToggleToOpenAnimatorListenerAdapter$1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                DynamicAnimation.OnAnimationEndListener onAnimationEndListener = this.this$0.mToggleToOpenAnimationListener;
                if (onAnimationEndListener != null) {
                    onAnimationEndListener.onAnimationEnd(null, true, 0.0f, 0.0f);
                }
                this.this$0.mToggleToOpenAnimationListener = null;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                DynamicAnimation.OnAnimationEndListener onAnimationEndListener = this.this$0.mToggleToOpenAnimationListener;
                if (onAnimationEndListener != null) {
                    onAnimationEndListener.onAnimationEnd(null, false, 1.0f, 1.0f);
                }
                this.this$0.mToggleToOpenAnimationListener = null;
            }
        };
        this.mToggleToCloseAnimatorListenerAdapter = new AnimatorListenerAdapter() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenQTLayoutAnimation$mToggleToCloseAnimatorListenerAdapter$1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                DynamicAnimation.OnAnimationEndListener onAnimationEndListener = this.this$0.mToggleToCloseAnimationListener;
                if (onAnimationEndListener != null) {
                    onAnimationEndListener.onAnimationEnd(null, true, 1.0f, 1.0f);
                }
                this.this$0.mToggleToCloseAnimationListener = null;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                DynamicAnimation.OnAnimationEndListener onAnimationEndListener = this.this$0.mToggleToCloseAnimationListener;
                if (onAnimationEndListener != null) {
                    onAnimationEndListener.onAnimationEnd(null, false, 0.0f, 0.0f);
                }
                this.this$0.mToggleToCloseAnimationListener = null;
            }
        };
        this.mEnterDockingZoneAnimatorListenerAdapter = new AnimatorListenerAdapter() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenQTLayoutAnimation$mEnterDockingZoneAnimatorListenerAdapter$1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                DynamicAnimation.OnAnimationEndListener onAnimationEndListener = this.this$0.mEnterDockingZoneAnimationListener;
                if (onAnimationEndListener != null) {
                    onAnimationEndListener.onAnimationEnd(null, true, 1.0f, 1.0f);
                }
                this.this$0.mEnterDockingZoneAnimationListener = null;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                DynamicAnimation.OnAnimationEndListener onAnimationEndListener = this.this$0.mEnterDockingZoneAnimationListener;
                if (onAnimationEndListener != null) {
                    onAnimationEndListener.onAnimationEnd(null, false, 0.0f, 0.0f);
                }
                this.this$0.mEnterDockingZoneAnimationListener = null;
            }
        };
        this.mExitDockingZoneAnimatorListenerAdapter = new AnimatorListenerAdapter() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenQTLayoutAnimation$mExitDockingZoneAnimatorListenerAdapter$1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                DynamicAnimation.OnAnimationEndListener onAnimationEndListener = this.this$0.mExitDockingZoneAnimationListener;
                if (onAnimationEndListener != null) {
                    onAnimationEndListener.onAnimationEnd(null, true, 0.0f, 0.0f);
                }
                this.this$0.mExitDockingZoneAnimationListener = null;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                DynamicAnimation.OnAnimationEndListener onAnimationEndListener = this.this$0.mExitDockingZoneAnimationListener;
                if (onAnimationEndListener != null) {
                    onAnimationEndListener.onAnimationEnd(null, false, 1.0f, 1.0f);
                }
                this.this$0.mExitDockingZoneAnimationListener = null;
            }
        };
    }

    private final void clearAnimation() {
        cancelAnimation();
        this.mShowSpringX = null;
        this.mShowSpringY = null;
        this.mHideSpringX = null;
        this.mHideSpringY = null;
        this.mIsAnimationInitialized = false;
    }

    private final void clearAnimationItem() {
        this.mAniItems.clear();
        this.mContainerLastOrder = -1;
    }

    private final SpringAnimation createSpringAnimation(View view, FloatPropertyCompat<View> property, float startValue, float dampingRatio, float stiffness, float finalPosition, DynamicAnimation.OnAnimationEndListener endListener) {
        SpringAnimation springAnimation = new SpringAnimation(view, property);
        SpringForce springForce = new SpringForce();
        springAnimation.setStartValue(startValue);
        springForce.setDampingRatio(dampingRatio);
        springForce.setStiffness(stiffness);
        springForce.setFinalPosition(finalPosition);
        springAnimation.setSpring(springForce);
        springAnimation.addEndListener(endListener);
        return springAnimation;
    }

    public static /* synthetic */ SpringAnimation createSpringAnimation$default(SpenQTLayoutAnimation spenQTLayoutAnimation, View view, FloatPropertyCompat floatPropertyCompat, float f, float f4, float f5, float f6, DynamicAnimation.OnAnimationEndListener onAnimationEndListener, int i, Object obj) {
        return spenQTLayoutAnimation.createSpringAnimation(view, floatPropertyCompat, f, f4, f5, f6, (i & 64) != 0 ? null : onAnimationEndListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void enterDockingZoneAnimation$lambda$15(SpenQTLayoutAnimation spenQTLayoutAnimation) {
        DynamicAnimation.OnAnimationEndListener onAnimationEndListener = spenQTLayoutAnimation.mEnterDockingZoneAnimationListener;
        if (onAnimationEndListener != null) {
            onAnimationEndListener.onAnimationEnd(null, false, 0.0f, 0.0f);
        }
        spenQTLayoutAnimation.mEnterDockingZoneAnimationListener = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void exitDockingZoneAnimation$lambda$17(SpenQTLayoutAnimation spenQTLayoutAnimation) {
        DynamicAnimation.OnAnimationEndListener onAnimationEndListener = spenQTLayoutAnimation.mExitDockingZoneAnimationListener;
        if (onAnimationEndListener != null) {
            onAnimationEndListener.onAnimationEnd(null, false, 1.0f, 1.0f);
        }
        spenQTLayoutAnimation.mExitDockingZoneAnimationListener = null;
    }

    private final void initAnimation() {
        View view = this.mTargetView;
        if (view == null) {
            return;
        }
        Intrinsics.checkNotNull(view);
        DynamicAnimation.ViewProperty SCALE_Y = DynamicAnimation.SCALE_Y;
        Intrinsics.checkNotNullExpressionValue(SCALE_Y, "SCALE_Y");
        this.mShowSpringY = createSpringAnimation$default(this, view, SCALE_Y, 0.0f, 0.55f, 200.0f, 1.0f, null, 64, null);
        View view2 = this.mTargetView;
        Intrinsics.checkNotNull(view2);
        DynamicAnimation.ViewProperty SCALE_X = DynamicAnimation.SCALE_X;
        Intrinsics.checkNotNullExpressionValue(SCALE_X, "SCALE_X");
        final int i = 0;
        this.mShowSpringX = createSpringAnimation(view2, SCALE_X, 0.0f, 0.55f, 200.0f, 1.0f, new DynamicAnimation.OnAnimationEndListener(this) { // from class: com.samsung.android.sdk.pen.setting.quicktool.g

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ SpenQTLayoutAnimation f5088b;

            {
                this.f5088b = this;
            }

            @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener
            public final void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z, float f, float f4) {
                switch (i) {
                    case 0:
                        SpenQTLayoutAnimation.initAnimation$lambda$18(this.f5088b, dynamicAnimation, z, f, f4);
                        break;
                    default:
                        SpenQTLayoutAnimation.initAnimation$lambda$19(this.f5088b, dynamicAnimation, z, f, f4);
                        break;
                }
            }
        });
        View view3 = this.mTargetView;
        Intrinsics.checkNotNull(view3);
        Intrinsics.checkNotNullExpressionValue(SCALE_Y, "SCALE_Y");
        this.mHideSpringY = createSpringAnimation$default(this, view3, SCALE_Y, 1.0f, 0.55f, 200.0f, 0.0f, null, 64, null);
        View view4 = this.mTargetView;
        Intrinsics.checkNotNull(view4);
        Intrinsics.checkNotNullExpressionValue(SCALE_X, "SCALE_X");
        final int i2 = 1;
        this.mHideSpringX = createSpringAnimation(view4, SCALE_X, 1.0f, 0.55f, 200.0f, 0.0f, new DynamicAnimation.OnAnimationEndListener(this) { // from class: com.samsung.android.sdk.pen.setting.quicktool.g

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ SpenQTLayoutAnimation f5088b;

            {
                this.f5088b = this;
            }

            @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener
            public final void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z, float f, float f4) {
                switch (i2) {
                    case 0:
                        SpenQTLayoutAnimation.initAnimation$lambda$18(this.f5088b, dynamicAnimation, z, f, f4);
                        break;
                    default:
                        SpenQTLayoutAnimation.initAnimation$lambda$19(this.f5088b, dynamicAnimation, z, f, f4);
                        break;
                }
            }
        });
        this.mIsAnimationInitialized = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAnimation$lambda$18(SpenQTLayoutAnimation spenQTLayoutAnimation, DynamicAnimation dynamicAnimation, boolean z, float f, float f4) {
        Log.i(TAG, "ShowSpringAnimation - onAnimationEnd()");
        DynamicAnimation.OnAnimationEndListener onAnimationEndListener = spenQTLayoutAnimation.mShowAnimationEndLister;
        if (onAnimationEndListener != null) {
            onAnimationEndListener.onAnimationEnd(dynamicAnimation, z, f, f4);
        }
        spenQTLayoutAnimation.mShowAnimationEndLister = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAnimation$lambda$19(SpenQTLayoutAnimation spenQTLayoutAnimation, DynamicAnimation dynamicAnimation, boolean z, float f, float f4) {
        Log.i(TAG, "HideSpringAnimation - onAnimationEnd()");
        DynamicAnimation.OnAnimationEndListener onAnimationEndListener = spenQTLayoutAnimation.mHideAnimationEndLister;
        if (onAnimationEndListener != null) {
            onAnimationEndListener.onAnimationEnd(dynamicAnimation, z, f, f4);
        }
        spenQTLayoutAnimation.mHideAnimationEndLister = null;
    }

    private final void rotateAnimation(View view, float startPosition, float endPosition) {
        Log.i(TAG, AbstractC0541b.m770l("rotateAnimation() [", startPosition, " -> ", endPosition, "]"));
        SpringAnimation springAnimation = new SpringAnimation(new FloatValueHolder(startPosition), endPosition);
        SpringForce spring = springAnimation.getSpring();
        spring.setDampingRatio(0.6f);
        spring.setStiffness(200.0f);
        springAnimation.addUpdateListener(new C4796g(this, view, 1));
        springAnimation.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void rotateAnimation$lambda$4(SpenQTLayoutAnimation spenQTLayoutAnimation, View view, DynamicAnimation dynamicAnimation, float f, float f4) {
        PointF viewPosition = spenQTLayoutAnimation.mAnglePosition.getViewPosition(view.getWidth(), view.getHeight(), (int) f);
        view.setX(viewPosition.x);
        view.setY(viewPosition.y);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void toggleToCloseAnimation$lambda$13(SpenQTLayoutAnimation spenQTLayoutAnimation) {
        DynamicAnimation.OnAnimationEndListener onAnimationEndListener = spenQTLayoutAnimation.mToggleToCloseAnimationListener;
        if (onAnimationEndListener != null) {
            onAnimationEndListener.onAnimationEnd(null, false, 0.0f, 0.0f);
        }
        spenQTLayoutAnimation.mToggleToCloseAnimationListener = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void toggleToOpenAnimation$lambda$11(SpenQTLayoutAnimation spenQTLayoutAnimation) {
        DynamicAnimation.OnAnimationEndListener onAnimationEndListener = spenQTLayoutAnimation.mToggleToOpenAnimationListener;
        if (onAnimationEndListener != null) {
            onAnimationEndListener.onAnimationEnd(null, false, 1.0f, 1.0f);
        }
        spenQTLayoutAnimation.mToggleToOpenAnimationListener = null;
    }

    public final void cancelAnimation() {
        Log.i(TAG, " cancelAnimation()");
        Iterator<View> it = this.mAniItems.keySet().iterator();
        while (it.hasNext()) {
            it.next().animate().cancel();
        }
        View view = this.mTargetView;
        if (view != null) {
            if (this.mIsAnimationInitialized) {
                SpringAnimation springAnimation = this.mShowSpringX;
                if (springAnimation != null) {
                    springAnimation.cancel();
                }
                SpringAnimation springAnimation2 = this.mShowSpringY;
                if (springAnimation2 != null) {
                    springAnimation2.cancel();
                }
                SpringAnimation springAnimation3 = this.mHideSpringX;
                if (springAnimation3 != null) {
                    springAnimation3.cancel();
                }
                SpringAnimation springAnimation4 = this.mHideSpringY;
                if (springAnimation4 != null) {
                    springAnimation4.cancel();
                }
            }
            view.clearAnimation();
            view.setAlpha(1.0f);
            view.setEnabled(true);
        }
        this.mShowAnimationEndLister = null;
        this.mHideAnimationEndLister = null;
    }

    public final void clearAllAnimationView() {
        Log.i(TAG, "clearAll() mAniItems.size=" + this.mAniItems.size());
        cancelAnimation();
        clearAnimationItem();
    }

    public final void close() {
        cancelAnimation();
        clearAnimationItem();
        this.mTargetView = null;
        this.mShowAnimationEndLister = null;
        this.mHideAnimationEndLister = null;
    }

    public final boolean closeAnimation(boolean skipAniItem, @Nullable DynamicAnimation.OnAnimationEndListener listener) {
        Log.i(TAG, "hideAnimation()");
        if (!skipAniItem) {
            for (Map.Entry<View, AnimationInfo> entry : this.mAniItems.entrySet()) {
                View key = entry.getKey();
                AnimationInfo value = entry.getValue();
                if (key.getVisibility() != 0) {
                    Log.i(TAG, "hideAnimation() skip invisible view=" + key);
                } else {
                    OpenCloseInfo openCloseAnimation = value.getOpenCloseAnimation();
                    if ((openCloseAnimation.getType() & 2) == 2) {
                        Log.i(TAG, "closeAnimation() rotateAngle[" + openCloseAnimation.getAngle() + " -> " + openCloseAnimation.getRotateValue() + " ]");
                        rotateAnimation(key, (float) openCloseAnimation.getAngle(), openCloseAnimation.getRotateValue());
                    }
                    if ((openCloseAnimation.getType() & 1) == 1) {
                        key.setScaleX(1.0f);
                        key.setScaleY(1.0f);
                        key.setEnabled(false);
                        key.animate().scaleX(0.0f).scaleY(0.0f).setDuration(350L).setInterpolator(SpenSettingUtilAnimation.getInterpolator(20)).start();
                    }
                    if ((openCloseAnimation.getType() & 4) == 4) {
                        key.setAlpha(1.0f);
                        key.setEnabled(false);
                        key.animate().alpha(0.0f).setDuration(100L).setInterpolator(SpenSettingUtilAnimation.getInterpolator(15)).start();
                    }
                }
            }
        }
        View view = this.mTargetView;
        if (view == null) {
            return false;
        }
        if (!this.mIsAnimationInitialized) {
            initAnimation();
        }
        this.mHideAnimationEndLister = listener;
        view.setEnabled(false);
        View view2 = this.mTargetView;
        Intrinsics.checkNotNull(view2);
        view2.animate().alpha(0.0f).setDuration(100L).setInterpolator(SpenSettingUtilAnimation.getInterpolator(15)).start();
        SpringAnimation springAnimation = this.mHideSpringX;
        if (springAnimation != null) {
            springAnimation.start();
        }
        SpringAnimation springAnimation2 = this.mHideSpringY;
        if (springAnimation2 != null) {
            springAnimation2.start();
        }
        return true;
    }

    public final void enterDockingZoneAnimation(@Nullable DynamicAnimation.OnAnimationEndListener listener) {
        Log.i(TAG, "enterDockingZoneAnimation()");
        this.mEnterDockingZoneAnimationListener = listener;
        boolean z = false;
        for (Map.Entry<View, AnimationInfo> entry : this.mAniItems.entrySet()) {
            View key = entry.getKey();
            AnimationInfo value = entry.getValue();
            if (key.getVisibility() == 0 && value.getContainerAnimation() != null) {
                key.setScaleX(1.0f);
                key.setScaleY(1.0f);
                key.setEnabled(false);
                key.setPivotX(key.getWidth() / 2.0f);
                key.setPivotY(key.getHeight() / 2.0f);
                key.animate().scaleX(0.0f).scaleY(0.0f).setDuration(300L).setInterpolator(SpenSettingUtilAnimation.getInterpolator(20)).setListener(!z ? this.mEnterDockingZoneAnimatorListenerAdapter : null).setStartDelay(0L).start();
                z = true;
            }
        }
        if (z) {
            Log.i(TAG, "enterDockingZoneAnimation() end.");
        } else {
            new Handler(Looper.getMainLooper()).post(new RunnableC7654f(this, 2));
        }
    }

    public final void exitDockingZoneAnimation(@Nullable DynamicAnimation.OnAnimationEndListener listener) {
        Log.i(TAG, "exitDockingZoneAnimation()");
        this.mExitDockingZoneAnimationListener = listener;
        boolean z = false;
        for (Map.Entry<View, AnimationInfo> entry : this.mAniItems.entrySet()) {
            View key = entry.getKey();
            AnimationInfo value = entry.getValue();
            if (key.getVisibility() == 0 && value.getContainerAnimation() != null) {
                key.setScaleX(0.0f);
                key.setScaleY(0.0f);
                key.setEnabled(true);
                key.setPivotX(key.getWidth() / 2.0f);
                key.setPivotY(key.getHeight() / 2.0f);
                key.setAlpha(1.0f);
                key.animate().scaleX(1.0f).scaleY(1.0f).setDuration(400L).setInterpolator(SpenSettingUtilAnimation.getInterpolator(20)).setListener(!z ? this.mExitDockingZoneAnimatorListenerAdapter : null).setStartDelay(0L).start();
                z = true;
            }
        }
        if (z) {
            Log.i(TAG, "exitDockingZoneAnimation() end.");
        } else {
            new Handler(Looper.getMainLooper()).post(new RunnableC7654f(this, 3));
        }
    }

    public final int getAnimationViewCount() {
        return this.mAniItems.size();
    }

    public final boolean hasContainerAnimationView() {
        return this.mContainerLastOrder > 0;
    }

    public final boolean openAnimation(boolean skipAniItem, @Nullable DynamicAnimation.OnAnimationEndListener listener) {
        Log.i(TAG, "showAnimation()");
        if (!skipAniItem) {
            for (Map.Entry<View, AnimationInfo> entry : this.mAniItems.entrySet()) {
                View key = entry.getKey();
                AnimationInfo value = entry.getValue();
                if (key.getVisibility() == 0) {
                    OpenCloseInfo openCloseAnimation = value.getOpenCloseAnimation();
                    if ((openCloseAnimation.getType() & 2) == 2) {
                        Log.i(TAG, "openAnimation() rotateAngle[ " + openCloseAnimation.getRotateValue() + " -> " + openCloseAnimation.getAngle() + "]");
                        rotateAnimation(key, openCloseAnimation.getRotateValue(), (float) openCloseAnimation.getAngle());
                    }
                    if ((openCloseAnimation.getType() & 4) == 4) {
                        Log.i(TAG, "start alpha animation() view=" + key);
                        key.setAlpha(0.0f);
                        key.setEnabled(true);
                        key.animate().alpha(1.0f).setDuration(200L).setInterpolator(SpenSettingUtilAnimation.getInterpolator(15)).start();
                    }
                    if ((openCloseAnimation.getType() & 1) == 1) {
                        Log.i(TAG, "start scale animation() view=" + key);
                        key.setScaleX(0.0f);
                        key.setScaleY(0.0f);
                        key.setEnabled(true);
                        key.animate().scaleX(1.0f).scaleY(1.0f).setDuration(400L).setInterpolator(SpenSettingUtilAnimation.getInterpolator(20)).start();
                    }
                }
            }
        }
        View view = this.mTargetView;
        if (view == null) {
            return false;
        }
        if (!this.mIsAnimationInitialized) {
            initAnimation();
        }
        this.mShowAnimationEndLister = listener;
        view.setAlpha(1.0f);
        view.setEnabled(true);
        SpringAnimation springAnimation = this.mShowSpringX;
        if (springAnimation != null) {
            springAnimation.start();
        }
        SpringAnimation springAnimation2 = this.mShowSpringY;
        if (springAnimation2 != null) {
            springAnimation2.start();
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void registerAlphaView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Log.i(TAG, "registerAlphaView() view=" + view);
        AnimationInfo animationInfo = this.mAniItems.get(view);
        if (animationInfo != null) {
            animationInfo.getOpenCloseAnimation().setType(animationInfo.getOpenCloseAnimation().getType() | 4);
            return;
        }
        this.mAniItems.put(view, new AnimationInfo(new OpenCloseInfo(4, 0.0f, 0, 6, null), null, 2, 0 == true ? 1 : 0));
    }

    public final boolean registerContainerAnimationView(@NotNull View view, int order) {
        Intrinsics.checkNotNullParameter(view, "view");
        Log.i(TAG, "registerContainerAnimationView() view=" + view);
        AnimationInfo animationInfo = this.mAniItems.get(view);
        if (animationInfo == null) {
            Log.i(TAG, "not exist registered animationInfo");
            return false;
        }
        long j = order * 50;
        if (animationInfo.getContainerAnimation() == null) {
            animationInfo.setContainerAnimation(new ContainerAnimationInfo(order, j));
        } else {
            ContainerAnimationInfo containerAnimation = animationInfo.getContainerAnimation();
            Intrinsics.checkNotNull(containerAnimation);
            Log.i(TAG, "change order " + containerAnimation.getOrder() + " -> order");
            ContainerAnimationInfo containerAnimation2 = animationInfo.getContainerAnimation();
            if (containerAnimation2 != null) {
                containerAnimation2.setOrder(order);
            }
            ContainerAnimationInfo containerAnimation3 = animationInfo.getContainerAnimation();
            if (containerAnimation3 != null) {
                containerAnimation3.setStartDelay(j);
            }
        }
        if (this.mContainerLastOrder >= order) {
            return true;
        }
        this.mContainerLastOrder = order;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void registerRotateView(@NotNull View view, float rotateValue, int angle) {
        Intrinsics.checkNotNullParameter(view, "view");
        Log.i(TAG, "registerRotateView() view=" + view + " angle=" + angle + ", rotateValue=" + rotateValue);
        AnimationInfo animationInfo = this.mAniItems.get(view);
        int i = 2;
        if (animationInfo == null) {
            this.mAniItems.put(view, new AnimationInfo(new OpenCloseInfo(2, rotateValue, angle), null, i, 0 == true ? 1 : 0));
            return;
        }
        animationInfo.getOpenCloseAnimation().setType(2 | animationInfo.getOpenCloseAnimation().getType());
        animationInfo.getOpenCloseAnimation().setRotateValue(rotateValue);
        animationInfo.getOpenCloseAnimation().setAngle(angle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void registerScaleView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Log.i(TAG, "registerScaleView() view=" + view);
        AnimationInfo animationInfo = this.mAniItems.get(view);
        if (animationInfo != null) {
            animationInfo.getOpenCloseAnimation().setType(animationInfo.getOpenCloseAnimation().getType() | 1);
            return;
        }
        this.mAniItems.put(view, new AnimationInfo(new OpenCloseInfo(1, 0.0f, 0, 6, null), null, 2, 0 == true ? 1 : 0));
    }

    public final void setTargetView(@Nullable View view) {
        if (this.mTargetView != null) {
            clearAnimation();
        }
        this.mTargetView = view;
    }

    public final void setViewVisibility(int viewVisibility) {
        AbstractC2322a.m1631u(viewVisibility, "setViewVisibility() visibility=", TAG);
        boolean z = viewVisibility == 0;
        float f = z ? 1.0f : 0.0f;
        float f4 = z ? 1.0f : 0.0f;
        Iterator<Map.Entry<View, AnimationInfo>> it = this.mAniItems.entrySet().iterator();
        while (it.hasNext()) {
            View key = it.next().getKey();
            if (key.getVisibility() == 0) {
                key.setScaleX(f);
                key.setScaleY(f);
                key.setAlpha(f4);
                key.setEnabled(z);
            }
        }
    }

    public final void toggleToCloseAnimation(boolean skipAniItem, @Nullable DynamicAnimation.OnAnimationEndListener listener) {
        Log.i(TAG, "toggleToCloseAnimation()");
        this.mToggleToCloseAnimationListener = listener;
        boolean z = false;
        if (!skipAniItem) {
            boolean z2 = false;
            for (Map.Entry<View, AnimationInfo> entry : this.mAniItems.entrySet()) {
                View key = entry.getKey();
                AnimationInfo value = entry.getValue();
                if (key.getVisibility() == 0 && value.getContainerAnimation() != null) {
                    key.setScaleX(1.0f);
                    key.setScaleY(1.0f);
                    key.setEnabled(false);
                    key.setPivotX(key.getWidth() / 2.0f);
                    key.setPivotY(key.getHeight() / 2.0f);
                    key.animate().scaleX(0.0f).scaleY(0.0f).setDuration(350L).setInterpolator(SpenSettingUtilAnimation.getInterpolator(20)).setListener(!z2 ? this.mToggleToCloseAnimatorListenerAdapter : null).setStartDelay(0L).start();
                    z2 = true;
                }
            }
            z = z2;
        }
        if (z) {
            Log.i(TAG, "toggleToCloseAnimation() end.");
        } else {
            new Handler(Looper.getMainLooper()).post(new RunnableC7654f(this, 0));
        }
    }

    public final void toggleToOpenAnimation(boolean skipAniItem, @Nullable DynamicAnimation.OnAnimationEndListener listener) {
        Log.i(TAG, "toggleToOpenAnimation()");
        this.mToggleToOpenAnimationListener = listener;
        int i = 0;
        if (!skipAniItem) {
            for (Map.Entry<View, AnimationInfo> entry : this.mAniItems.entrySet()) {
                View key = entry.getKey();
                AnimationInfo value = entry.getValue();
                if (key.getVisibility() == 0 && value.getContainerAnimation() != null) {
                    ContainerAnimationInfo containerAnimation = value.getContainerAnimation();
                    Intrinsics.checkNotNull(containerAnimation);
                    key.setScaleX(0.0f);
                    key.setScaleY(0.0f);
                    key.setEnabled(true);
                    key.animate().scaleX(1.0f).scaleY(1.0f).setDuration(400L).setInterpolator(SpenSettingUtilAnimation.getInterpolator(20)).setStartDelay(containerAnimation.getStartDelay()).setListener(this.mContainerLastOrder == containerAnimation.getOrder() ? this.mToggleToOpenAnimatorListenerAdapter : null).start();
                    i++;
                }
            }
        }
        if (i != 0) {
            AbstractC2322a.m1631u(i, "toggleToOpenAnimation() end. animationCount=", TAG);
        } else {
            Log.i(TAG, "animationCount() = 0");
            new Handler(Looper.getMainLooper()).post(new RunnableC7654f(this, 1));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTLayoutAnimation$AnimationInfo;", "", "openCloseAnimation", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTLayoutAnimation$OpenCloseInfo;", "containerAnimation", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTLayoutAnimation$ContainerAnimationInfo;", "<init>", "(Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTLayoutAnimation$OpenCloseInfo;Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTLayoutAnimation$ContainerAnimationInfo;)V", "getOpenCloseAnimation", "()Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTLayoutAnimation$OpenCloseInfo;", "getContainerAnimation", "()Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTLayoutAnimation$ContainerAnimationInfo;", "setContainerAnimation", "(Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTLayoutAnimation$ContainerAnimationInfo;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final /* data */ class AnimationInfo {

        @Nullable
        private ContainerAnimationInfo containerAnimation;

        @NotNull
        private final OpenCloseInfo openCloseAnimation;

        public AnimationInfo(@NotNull OpenCloseInfo openCloseAnimation, @Nullable ContainerAnimationInfo containerAnimationInfo) {
            Intrinsics.checkNotNullParameter(openCloseAnimation, "openCloseAnimation");
            this.openCloseAnimation = openCloseAnimation;
            this.containerAnimation = containerAnimationInfo;
        }

        public static /* synthetic */ AnimationInfo copy$default(AnimationInfo animationInfo, OpenCloseInfo openCloseInfo, ContainerAnimationInfo containerAnimationInfo, int i, Object obj) {
            if ((i & 1) != 0) {
                openCloseInfo = animationInfo.openCloseAnimation;
            }
            if ((i & 2) != 0) {
                containerAnimationInfo = animationInfo.containerAnimation;
            }
            return animationInfo.copy(openCloseInfo, containerAnimationInfo);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final OpenCloseInfo getOpenCloseAnimation() {
            return this.openCloseAnimation;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final ContainerAnimationInfo getContainerAnimation() {
            return this.containerAnimation;
        }

        @NotNull
        public final AnimationInfo copy(@NotNull OpenCloseInfo openCloseAnimation, @Nullable ContainerAnimationInfo containerAnimation) {
            Intrinsics.checkNotNullParameter(openCloseAnimation, "openCloseAnimation");
            return new AnimationInfo(openCloseAnimation, containerAnimation);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AnimationInfo)) {
                return false;
            }
            AnimationInfo animationInfo = (AnimationInfo) other;
            return Intrinsics.areEqual(this.openCloseAnimation, animationInfo.openCloseAnimation) && Intrinsics.areEqual(this.containerAnimation, animationInfo.containerAnimation);
        }

        @Nullable
        public final ContainerAnimationInfo getContainerAnimation() {
            return this.containerAnimation;
        }

        @NotNull
        public final OpenCloseInfo getOpenCloseAnimation() {
            return this.openCloseAnimation;
        }

        public int hashCode() {
            int iHashCode = this.openCloseAnimation.hashCode() * 31;
            ContainerAnimationInfo containerAnimationInfo = this.containerAnimation;
            return iHashCode + (containerAnimationInfo == null ? 0 : containerAnimationInfo.hashCode());
        }

        public final void setContainerAnimation(@Nullable ContainerAnimationInfo containerAnimationInfo) {
            this.containerAnimation = containerAnimationInfo;
        }

        @NotNull
        public String toString() {
            return "AnimationInfo(openCloseAnimation=" + this.openCloseAnimation + ", containerAnimation=" + this.containerAnimation + ")";
        }

        public /* synthetic */ AnimationInfo(OpenCloseInfo openCloseInfo, ContainerAnimationInfo containerAnimationInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(openCloseInfo, (i & 2) != 0 ? null : containerAnimationInfo);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J'\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006\u001d"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTLayoutAnimation$OpenCloseInfo;", "", "type", "", "rotateValue", "", "angle", "<init>", "(IFI)V", "getType", "()I", "setType", "(I)V", "getRotateValue", "()F", "setRotateValue", "(F)V", "getAngle", "setAngle", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final /* data */ class OpenCloseInfo {
        private int angle;
        private float rotateValue;
        private int type;

        public OpenCloseInfo(int i, float f, int i2) {
            this.type = i;
            this.rotateValue = f;
            this.angle = i2;
        }

        public static /* synthetic */ OpenCloseInfo copy$default(OpenCloseInfo openCloseInfo, int i, float f, int i2, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i = openCloseInfo.type;
            }
            if ((i4 & 2) != 0) {
                f = openCloseInfo.rotateValue;
            }
            if ((i4 & 4) != 0) {
                i2 = openCloseInfo.angle;
            }
            return openCloseInfo.copy(i, f, i2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final float getRotateValue() {
            return this.rotateValue;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getAngle() {
            return this.angle;
        }

        @NotNull
        public final OpenCloseInfo copy(int type, float rotateValue, int angle) {
            return new OpenCloseInfo(type, rotateValue, angle);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OpenCloseInfo)) {
                return false;
            }
            OpenCloseInfo openCloseInfo = (OpenCloseInfo) other;
            return this.type == openCloseInfo.type && Float.compare(this.rotateValue, openCloseInfo.rotateValue) == 0 && this.angle == openCloseInfo.angle;
        }

        public final int getAngle() {
            return this.angle;
        }

        public final float getRotateValue() {
            return this.rotateValue;
        }

        public final int getType() {
            return this.type;
        }

        public int hashCode() {
            return Integer.hashCode(this.angle) + AbstractC0622a.m1156b(this.rotateValue, Integer.hashCode(this.type) * 31, 31);
        }

        public final void setAngle(int i) {
            this.angle = i;
        }

        public final void setRotateValue(float f) {
            this.rotateValue = f;
        }

        public final void setType(int i) {
            this.type = i;
        }

        @NotNull
        public String toString() {
            int i = this.type;
            float f = this.rotateValue;
            return AbstractC2821a.m2223n(AbstractC2322a.m1628r("OpenCloseInfo(type=", i, ", rotateValue=", f, ", angle="), ")", this.angle);
        }

        public /* synthetic */ OpenCloseInfo(int i, float f, int i2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, (i4 & 2) != 0 ? 0.0f : f, (i4 & 4) != 0 ? 0 : i2);
        }
    }
}
