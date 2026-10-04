package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking;

import android.view.View;
import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTLayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.animation.QTAnimationKt;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u0000 !2\u00020\u0001:\u0004!\"#$B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005J\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bJ&\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013J\u000e\u0010\u0016\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bJ\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u000fJ\u0006\u0010\u001a\u001a\u00020\fJ\u0006\u0010\u001b\u001a\u00020\u0018J\u0006\u0010\u001c\u001a\u00020\u0018J\u000e\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u000fJ\u0006\u0010\u001f\u001a\u00020\fJ\u0006\u0010 \u001a\u00020\fR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t`\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTLayoutAnimation;", "", "<init>", "()V", "mTargetView", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTLayout;", "mAniItems", "Ljava/util/HashMap;", "Landroid/view/View;", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTLayoutAnimation$AnimationInfo;", "Lkotlin/collections/HashMap;", "setTargetView", "", "view", "getAnimationViewCount", "", "registerScaleView", "registerRotateView", "pivotX", "", "pivotY", "rotateValue", "registerAlphaView", "registerContainerAnimationView", "", "order", "close", "openAnimation", "closeAnimation", "setViewVisibility", "viewVisibility", "toggleToOpenAnimation", "toggleToCloseAnimation", "Companion", "OpenCloseInfo", "ContainerAnimationInfo", "AnimationInfo", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nQTLayoutAnimation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 QTLayoutAnimation.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTLayoutAnimation\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,177:1\n216#2:178\n217#2:180\n216#2,2:181\n255#3:179\n*S KotlinDebug\n*F\n+ 1 QTLayoutAnimation.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTLayoutAnimation\n*L\n133#1:178\n133#1:180\n159#1:181,2\n134#1:179\n*E\n"})
public final class QTLayoutAnimation {
    private static final float HIDE_BASE_ALPHA = 0.0f;
    private static final float HIDE_BASE_SCALE = 0.0f;
    private static final float SHOW_BASE_ALPHA = 1.0f;
    private static final float SHOW_BASE_SCALE = 1.0f;

    @NotNull
    private static final String TAG = "QTLayoutAnimation";
    private static final int VI_ALPHA = 4;
    private static final long VI_ALPHA_HIDE_DURATION = 100;
    private static final long VI_ALPHA_SHOW_DURATION = 200;
    private static final int VI_ROTATION = 2;
    private static final float VI_ROTATION_BASE_POSITION = 0.0f;
    private static final float VI_ROTATION_DAMPING_RATIO = 0.6f;
    private static final float VI_ROTATION_STIFFNESS = 200.0f;
    private static final int VI_SCALE = 1;
    private static final long VI_SCALE_HIDE_DURATION = 350;
    private static final long VI_SCALE_SHOW_DURATION = 400;
    private static final long VI_TARGET_ALPHA_HIDE_DURATION = 100;
    private static final float VI_TARGET_DAMPING_RATIO = 0.63f;
    private static final float VI_TARGET_STIFFNESS = 200.0f;
    private static final long VI_TOGGLE_SCALE_HIDE_DURATION = 350;
    private static final long VI_TOGGLE_SCALE_INTER_ORDER_DELAY = 50;
    private static final long VI_TOGGLE_SCALE_SHOW_DURATION = 400;

    @NotNull
    private final HashMap<View, AnimationInfo> mAniItems = new HashMap<>();

    @Nullable
    private SettingQTLayout mTargetView;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTLayoutAnimation$ContainerAnimationInfo;", "", "order", "", "startDelay", "", "<init>", "(IJ)V", "getOrder", "()I", "setOrder", "(I)V", "getStartDelay", "()J", "setStartDelay", "(J)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
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

    public final void close() {
        this.mAniItems.clear();
        this.mTargetView = null;
    }

    public final boolean closeAnimation() {
        Logger.m11003i(TAG, "hideAnimation()");
        SettingQTLayout settingQTLayout = this.mTargetView;
        if (settingQTLayout == null) {
            return false;
        }
        SettingQTLayout.hide$default(settingQTLayout, SettingQTLayout.AnimationType.CLOSE, 0.0f, 0.0f, 6, null);
        return true;
    }

    public final int getAnimationViewCount() {
        return this.mAniItems.size();
    }

    public final boolean openAnimation() {
        Logger.m11003i(TAG, "showAnimation()");
        for (Map.Entry<View, AnimationInfo> entry : this.mAniItems.entrySet()) {
            View key = entry.getKey();
            AnimationInfo value = entry.getValue();
            if (key.getVisibility() == 0) {
                ContainerAnimationInfo containerAnimation = value.getContainerAnimation();
                QTAnimationKt.scale(key, 0.0f, 1.0f, containerAnimation != null ? containerAnimation.getStartDelay() : 0L, 400L);
            }
        }
        SettingQTLayout settingQTLayout = this.mTargetView;
        if (settingQTLayout == null) {
            return false;
        }
        SettingQTLayout.show$default(settingQTLayout, SettingQTLayout.AnimationType.OPEN, 0.0f, 0.0f, 6, null);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void registerAlphaView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Logger.m11003i(TAG, "registerAlphaView() view=" + view);
        AnimationInfo animationInfo = this.mAniItems.get(view);
        if (animationInfo != null) {
            animationInfo.getOpenCloseAnimation().setType(animationInfo.getOpenCloseAnimation().getType() | 4);
            return;
        }
        this.mAniItems.put(view, new AnimationInfo(new OpenCloseInfo(4, 0.0f, 0.0f, 0.0f, 14, null), null, 2, 0 == true ? 1 : 0));
    }

    public final boolean registerContainerAnimationView(@NotNull View view, int order) {
        Intrinsics.checkNotNullParameter(view, "view");
        Logger.m11003i(TAG, "registerContainerAnimationView() view=" + view);
        AnimationInfo animationInfo = this.mAniItems.get(view);
        if (animationInfo == null) {
            Logger.m11003i(TAG, "not exist registered animationInfo");
            return false;
        }
        long j = ((long) order) * 50;
        if (animationInfo.getContainerAnimation() == null) {
            animationInfo.setContainerAnimation(new ContainerAnimationInfo(order, j));
            return true;
        }
        ContainerAnimationInfo containerAnimation = animationInfo.getContainerAnimation();
        Intrinsics.checkNotNull(containerAnimation);
        Logger.m11003i(TAG, "change order " + containerAnimation.getOrder() + " -> order");
        ContainerAnimationInfo containerAnimation2 = animationInfo.getContainerAnimation();
        if (containerAnimation2 != null) {
            containerAnimation2.setOrder(order);
        }
        ContainerAnimationInfo containerAnimation3 = animationInfo.getContainerAnimation();
        if (containerAnimation3 == null) {
            return true;
        }
        containerAnimation3.setStartDelay(j);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void registerRotateView(@NotNull View view, float pivotX, float pivotY, float rotateValue) {
        Intrinsics.checkNotNullParameter(view, "view");
        StringBuilder sb = new StringBuilder("registerRotateView() view=");
        sb.append(view);
        sb.append(" pivot[");
        Logger.m11003i(TAG, AbstractC1038a.m1216q(sb, pivotX, ",", pivotY, "]"));
        AnimationInfo animationInfo = this.mAniItems.get(view);
        int i = 2;
        if (animationInfo == null) {
            this.mAniItems.put(view, new AnimationInfo(new OpenCloseInfo(2, pivotX, pivotY, rotateValue), null, i, 0 == true ? 1 : 0));
            return;
        }
        animationInfo.getOpenCloseAnimation().setType(2 | animationInfo.getOpenCloseAnimation().getType());
        animationInfo.getOpenCloseAnimation().setPivotX(pivotX);
        animationInfo.getOpenCloseAnimation().setPivotY(pivotY);
        animationInfo.getOpenCloseAnimation().setRotateValue(rotateValue);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void registerScaleView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Logger.m11003i(TAG, "registerScaleView() view=" + view);
        AnimationInfo animationInfo = this.mAniItems.get(view);
        if (animationInfo != null) {
            animationInfo.getOpenCloseAnimation().setType(animationInfo.getOpenCloseAnimation().getType() | 1);
            return;
        }
        this.mAniItems.put(view, new AnimationInfo(new OpenCloseInfo(1, 0.0f, 0.0f, 0.0f, 14, null), null, 2, 0 == true ? 1 : 0));
    }

    public final void setTargetView(@NotNull SettingQTLayout view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.mTargetView = view;
    }

    public final void setViewVisibility(int viewVisibility) {
        AbstractC8014b.m7217s(viewVisibility, "setViewVisibility() visibility=", TAG);
        float f = viewVisibility == 0 ? 1.0f : 0.0f;
        float f4 = viewVisibility == 0 ? 1.0f : 0.0f;
        Iterator<Map.Entry<View, AnimationInfo>> it = this.mAniItems.entrySet().iterator();
        while (it.hasNext()) {
            View key = it.next().getKey();
            if (key.getVisibility() == 0) {
                key.setScaleX(f);
                key.setScaleY(f);
                key.setAlpha(f4);
            }
        }
    }

    public final void toggleToCloseAnimation() {
        Logger.m11003i(TAG, "toggleToCloseAnimation()");
        SettingQTLayout settingQTLayout = this.mTargetView;
        if (settingQTLayout != null) {
            settingQTLayout.hide(SettingQTLayout.AnimationType.TOGGLE_TO_HIDE, 0.75f, 300.0f);
        }
    }

    public final void toggleToOpenAnimation() {
        Logger.m11003i(TAG, "toggleToOpenAnimation()");
        SettingQTLayout settingQTLayout = this.mTargetView;
        if (settingQTLayout != null) {
            settingQTLayout.show(SettingQTLayout.AnimationType.TOGGLE_TO_SHOW, 0.75f, 300.0f);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTLayoutAnimation$AnimationInfo;", "", "openCloseAnimation", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTLayoutAnimation$OpenCloseInfo;", "containerAnimation", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTLayoutAnimation$ContainerAnimationInfo;", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTLayoutAnimation$OpenCloseInfo;Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTLayoutAnimation$ContainerAnimationInfo;)V", "getOpenCloseAnimation", "()Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTLayoutAnimation$OpenCloseInfo;", "getContainerAnimation", "()Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTLayoutAnimation$ContainerAnimationInfo;", "setContainerAnimation", "(Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTLayoutAnimation$ContainerAnimationInfo;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
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
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J1\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011¨\u0006!"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTLayoutAnimation$OpenCloseInfo;", "", "type", "", "pivotX", "", "pivotY", "rotateValue", "<init>", "(IFFF)V", "getType", "()I", "setType", "(I)V", "getPivotX", "()F", "setPivotX", "(F)V", "getPivotY", "setPivotY", "getRotateValue", "setRotateValue", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final /* data */ class OpenCloseInfo {
        private float pivotX;
        private float pivotY;
        private float rotateValue;
        private int type;

        public OpenCloseInfo(int i, float f, float f4, float f5) {
            this.type = i;
            this.pivotX = f;
            this.pivotY = f4;
            this.rotateValue = f5;
        }

        public static /* synthetic */ OpenCloseInfo copy$default(OpenCloseInfo openCloseInfo, int i, float f, float f4, float f5, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = openCloseInfo.type;
            }
            if ((i2 & 2) != 0) {
                f = openCloseInfo.pivotX;
            }
            if ((i2 & 4) != 0) {
                f4 = openCloseInfo.pivotY;
            }
            if ((i2 & 8) != 0) {
                f5 = openCloseInfo.rotateValue;
            }
            return openCloseInfo.copy(i, f, f4, f5);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final float getPivotX() {
            return this.pivotX;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final float getPivotY() {
            return this.pivotY;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final float getRotateValue() {
            return this.rotateValue;
        }

        @NotNull
        public final OpenCloseInfo copy(int type, float pivotX, float pivotY, float rotateValue) {
            return new OpenCloseInfo(type, pivotX, pivotY, rotateValue);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OpenCloseInfo)) {
                return false;
            }
            OpenCloseInfo openCloseInfo = (OpenCloseInfo) other;
            return this.type == openCloseInfo.type && Float.compare(this.pivotX, openCloseInfo.pivotX) == 0 && Float.compare(this.pivotY, openCloseInfo.pivotY) == 0 && Float.compare(this.rotateValue, openCloseInfo.rotateValue) == 0;
        }

        public final float getPivotX() {
            return this.pivotX;
        }

        public final float getPivotY() {
            return this.pivotY;
        }

        public final float getRotateValue() {
            return this.rotateValue;
        }

        public final int getType() {
            return this.type;
        }

        public int hashCode() {
            return Float.hashCode(this.rotateValue) + AbstractC0622a.m1156b(this.pivotY, AbstractC0622a.m1156b(this.pivotX, Integer.hashCode(this.type) * 31, 31), 31);
        }

        public final void setPivotX(float f) {
            this.pivotX = f;
        }

        public final void setPivotY(float f) {
            this.pivotY = f;
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
            float f = this.pivotX;
            return AbstractC1038a.m1216q(AbstractC2322a.m1628r("OpenCloseInfo(type=", i, ", pivotX=", f, ", pivotY="), this.pivotY, ", rotateValue=", this.rotateValue, ")");
        }

        public /* synthetic */ OpenCloseInfo(int i, float f, float f4, float f5, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, (i2 & 2) != 0 ? 0.0f : f, (i2 & 4) != 0 ? 0.0f : f4, (i2 & 8) != 0 ? 0.0f : f5);
        }
    }
}
