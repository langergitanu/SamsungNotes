package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice.animation;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.transition.ChangeBounds;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.animation.PathInterpolator;
import android.widget.RelativeLayout;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.C8886c;
import com.samsung.android.support.senl.p148nt.base.winset.view.floater.FloatLayout;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.voice.EraserState;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiViewUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.voice.VoiceUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AllSideToolbarContainerLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 #2\u00020\u0001:\u0002\"#B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u0012J0\u0010\u0013\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u0012J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0014\u0010\u0017\u001a\u00020\f*\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0010H\u0002J\u0014\u0010\u0019\u001a\u00020\f*\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u0010H\u0002J\u0010\u0010\u001b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ*\u0010\u001c\u001a\u00020\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00152\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/voice/animation/VoiceAnimation;", "", "mUpdateViewAnimation", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/voice/animation/VoiceAnimation$UpdateViewAnimation;", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/voice/animation/VoiceAnimation$UpdateViewAnimation;)V", "mInterpolator", "Landroid/view/animation/PathInterpolator;", "mVoiceAnimationInterpolator", "mVoiceSubAnimation", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/voice/animation/VoiceSubAnimation;", "expand", "", "root", "Landroid/view/ViewGroup;", "isTablet", "", "onAnimationEnd", "Lkotlin/Function0;", "collapse", "hideView", "Landroid/view/View;", "getResultView", "changeRule", "running", "checkAnimationStateTypeNone", "Lcom/samsung/android/support/senl/nt/base/winset/view/floater/FloatLayout;", "playListChangeBounds", "updateAnimationForEraser", "parent", "state", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/voice/EraserState;", "isLineVoiceLayout", "isLeftPosition", "UpdateViewAnimation", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nVoiceAnimation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VoiceAnimation.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/voice/animation/VoiceAnimation\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,275:1\n255#2:276\n255#2:277\n*S KotlinDebug\n*F\n+ 1 VoiceAnimation.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/voice/animation/VoiceAnimation\n*L\n46#1:276\n141#1:277\n*E\n"})
public final class VoiceAnimation {
    private static final String TAG = Logger.createTag("VoiceAnimation");
    private static final long VOICE_ANIMATION_DURATION = 400;

    @NotNull
    private final PathInterpolator mInterpolator;

    @NotNull
    private final UpdateViewAnimation mUpdateViewAnimation;

    @NotNull
    private final PathInterpolator mVoiceAnimationInterpolator;

    @NotNull
    private final VoiceSubAnimation mVoiceSubAnimation;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/voice/animation/VoiceAnimation$UpdateViewAnimation;", "", "onUpdateToggleActionAnimation", "", "isEnabled", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface UpdateViewAnimation {
        void onUpdateToggleActionAnimation(boolean isEnabled);
    }

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.animation.VoiceAnimation$collapse$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, m13886d2 = {"com/samsung/android/support/senl/nt/composer/main/base/view/menu/voice/animation/VoiceAnimation$collapse$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nVoiceAnimation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VoiceAnimation.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/voice/animation/VoiceAnimation$collapse$1\n+ 2 Animator.kt\nandroidx/core/animation/AnimatorKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,275:1\n85#2,18:276\n255#3:294\n*S KotlinDebug\n*F\n+ 1 VoiceAnimation.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/voice/animation/VoiceAnimation$collapse$1\n*L\n181#1:276,18\n170#1:294\n*E\n"})
    public static final class ViewTreeObserverOnGlobalLayoutListenerC108691 implements ViewTreeObserver.OnGlobalLayoutListener {
        final /* synthetic */ FloatLayout $float;
        final /* synthetic */ View $floater;
        final /* synthetic */ View $hideView;
        final /* synthetic */ boolean $isLandscape;
        final /* synthetic */ View $language;
        final /* synthetic */ View $main;
        final /* synthetic */ ViewTreeObserver $observer;
        final /* synthetic */ Function0<Unit> $onAnimationEnd;
        final /* synthetic */ View $record;
        final /* synthetic */ View $result;
        final /* synthetic */ ViewGroup $resultParent;
        final /* synthetic */ ViewGroup $root;
        final /* synthetic */ VoiceAnimation this$0;

        public ViewTreeObserverOnGlobalLayoutListenerC108691(ViewTreeObserver viewTreeObserver, View view, View view2, View view3, VoiceAnimation voiceAnimation, View view4, View view5, boolean z, ViewGroup viewGroup, FloatLayout floatLayout, ViewGroup viewGroup2, View view6, Function0<Unit> function0) {
            this.$observer = viewTreeObserver;
            this.$record = view;
            this.$floater = view2;
            this.$result = view3;
            this.this$0 = voiceAnimation;
            this.$language = view4;
            this.$main = view5;
            this.$isLandscape = z;
            this.$resultParent = viewGroup;
            this.$float = floatLayout;
            this.$root = viewGroup2;
            this.$hideView = view6;
            this.$onAnimationEnd = function0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onGlobalLayout$lambda$0(View view, View view2, int i, View view3, View view4, int i2, View view5, int i4, boolean z, ViewGroup viewGroup, ValueAnimator valueAnimator) {
            int iIntValue = ((Integer) AbstractC6670b.m4742c(valueAnimator, "animation", "null cannot be cast to non-null type kotlin.Int")).intValue();
            view.setTranslationY(-iIntValue);
            float f = i - iIntValue;
            view2.setTranslationY(f);
            view3.setTranslationY(f);
            view4.getLayoutParams().height = i2 + iIntValue;
            view4.requestLayout();
            if (view5.getVisibility() == 0) {
                if (AiViewUtils.isSupportFloatingLayout()) {
                    view5.getLayoutParams().height = i4 + iIntValue;
                    view5.requestLayout();
                } else if (z) {
                    viewGroup.setTranslationY(f);
                    view5.getLayoutParams().height = i4 + iIntValue;
                    view5.requestLayout();
                }
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            this.$observer.removeOnGlobalLayoutListener(this);
            int height = this.$record.getHeight();
            int height2 = this.$floater.getHeight();
            int height3 = this.$result.getHeight();
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, height);
            valueAnimatorOfInt.setDuration(400L);
            valueAnimatorOfInt.setInterpolator(this.this$0.mVoiceAnimationInterpolator);
            valueAnimatorOfInt.addUpdateListener(new C10875a(this.$record, this.$language, height, this.$main, this.$floater, height2, this.$result, height3, this.$isLandscape, this.$resultParent));
            Intrinsics.checkNotNull(valueAnimatorOfInt);
            final View view = this.$record;
            final View view2 = this.$language;
            final View view3 = this.$main;
            final View view4 = this.$floater;
            final View view5 = this.$result;
            final boolean z = this.$isLandscape;
            final ViewGroup viewGroup = this.$resultParent;
            final VoiceAnimation voiceAnimation = this.this$0;
            final FloatLayout floatLayout = this.$float;
            final ViewGroup viewGroup2 = this.$root;
            final View view6 = this.$hideView;
            final Function0<Unit> function0 = this.$onAnimationEnd;
            valueAnimatorOfInt.addListener(new Animator.AnimatorListener(view, view2, view3, view4, view5, z, viewGroup, voiceAnimation, floatLayout, viewGroup2, view6, function0, voiceAnimation, floatLayout, view) { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.animation.VoiceAnimation$collapse$1$onGlobalLayout$$inlined$addListener$default$1
                final /* synthetic */ FloatLayout $float$inlined;
                final /* synthetic */ FloatLayout $float$inlined$1;
                final /* synthetic */ View $floater$inlined;
                final /* synthetic */ View $hideView$inlined;
                final /* synthetic */ boolean $isLandscape$inlined;
                final /* synthetic */ View $language$inlined;
                final /* synthetic */ View $main$inlined;
                final /* synthetic */ Function0 $onAnimationEnd$inlined;
                final /* synthetic */ View $record$inlined;
                final /* synthetic */ View $record$inlined$1;
                final /* synthetic */ View $result$inlined;
                final /* synthetic */ ViewGroup $resultParent$inlined;
                final /* synthetic */ ViewGroup $root$inlined;
                final /* synthetic */ VoiceAnimation this$0;

                {
                    this.$float$inlined$1 = floatLayout;
                    this.$record$inlined$1 = view;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    this.$record$inlined.setTranslationY(0.0f);
                    this.$language$inlined.setTranslationY(0.0f);
                    this.$main$inlined.setTranslationY(0.0f);
                    this.$floater$inlined.getLayoutParams().height = -1;
                    this.$floater$inlined.requestLayout();
                    if (this.$result$inlined.getVisibility() == 0) {
                        if (AiViewUtils.isSupportFloatingLayout()) {
                            this.$result$inlined.getLayoutParams().height = -1;
                            this.$result$inlined.requestLayout();
                        } else if (this.$isLandscape$inlined) {
                            this.$resultParent$inlined.setTranslationY(0.0f);
                            this.$result$inlined.getLayoutParams().height = -1;
                            this.$result$inlined.requestLayout();
                        }
                    }
                    this.this$0.mUpdateViewAnimation.onUpdateToggleActionAnimation(true);
                    VoiceUtil.INSTANCE.enableControls(this.$record$inlined, true);
                    this.this$0.checkAnimationStateTypeNone(this.$float$inlined, false);
                    this.this$0.changeRule(this.$root$inlined, false);
                    View view7 = this.$hideView$inlined;
                    if (view7 != null) {
                        view7.setVisibility(8);
                    }
                    this.$onAnimationEnd$inlined.invoke();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    this.this$0.checkAnimationStateTypeNone(this.$float$inlined$1, true);
                    VoiceUtil.INSTANCE.enableControls(this.$record$inlined$1, false);
                    this.this$0.mUpdateViewAnimation.onUpdateToggleActionAnimation(false);
                }
            });
            valueAnimatorOfInt.start();
        }
    }

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.animation.VoiceAnimation$expand$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, m13886d2 = {"com/samsung/android/support/senl/nt/composer/main/base/view/menu/voice/animation/VoiceAnimation$expand$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nVoiceAnimation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VoiceAnimation.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/voice/animation/VoiceAnimation$expand$1\n+ 2 Animator.kt\nandroidx/core/animation/AnimatorKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,275:1\n85#2,18:276\n255#3:294\n*S KotlinDebug\n*F\n+ 1 VoiceAnimation.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/voice/animation/VoiceAnimation$expand$1\n*L\n85#1:276,18\n74#1:294\n*E\n"})
    public static final class ViewTreeObserverOnGlobalLayoutListenerC108711 implements ViewTreeObserver.OnGlobalLayoutListener {
        final /* synthetic */ FloatLayout $float;
        final /* synthetic */ View $floater;
        final /* synthetic */ boolean $isLandscape;
        final /* synthetic */ View $language;
        final /* synthetic */ View $main;
        final /* synthetic */ ViewTreeObserver $observer;
        final /* synthetic */ Function0<Unit> $onAnimationEnd;
        final /* synthetic */ View $record;
        final /* synthetic */ View $result;
        final /* synthetic */ ViewGroup $resultParent;
        final /* synthetic */ ViewGroup $root;
        final /* synthetic */ VoiceAnimation this$0;

        public ViewTreeObserverOnGlobalLayoutListenerC108711(ViewTreeObserver viewTreeObserver, View view, View view2, View view3, VoiceAnimation voiceAnimation, View view4, View view5, boolean z, ViewGroup viewGroup, FloatLayout floatLayout, ViewGroup viewGroup2, Function0<Unit> function0) {
            this.$observer = viewTreeObserver;
            this.$record = view;
            this.$floater = view2;
            this.$result = view3;
            this.this$0 = voiceAnimation;
            this.$language = view4;
            this.$main = view5;
            this.$isLandscape = z;
            this.$resultParent = viewGroup;
            this.$float = floatLayout;
            this.$root = viewGroup2;
            this.$onAnimationEnd = function0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onGlobalLayout$lambda$0(View view, int i, View view2, View view3, View view4, int i2, View view5, int i4, boolean z, ViewGroup viewGroup, ValueAnimator valueAnimator) {
            int iIntValue = ((Integer) AbstractC6670b.m4742c(valueAnimator, "animation", "null cannot be cast to non-null type kotlin.Int")).intValue();
            view.setTranslationY(iIntValue - i);
            float f = iIntValue;
            view2.setTranslationY(f);
            view3.setTranslationY(f);
            view4.getLayoutParams().height = i2 - iIntValue;
            view4.requestLayout();
            if (view5.getVisibility() == 0) {
                if (AiViewUtils.isSupportFloatingLayout()) {
                    view5.getLayoutParams().height = i4 - iIntValue;
                    view5.requestLayout();
                } else if (z) {
                    viewGroup.setTranslationY(f);
                    view5.getLayoutParams().height = i4 - iIntValue;
                    view5.requestLayout();
                }
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            this.$observer.removeOnGlobalLayoutListener(this);
            int height = this.$record.getHeight();
            int height2 = this.$floater.getHeight();
            int height3 = this.$result.getHeight();
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, height);
            valueAnimatorOfInt.setDuration(400L);
            valueAnimatorOfInt.setInterpolator(this.this$0.mVoiceAnimationInterpolator);
            valueAnimatorOfInt.addUpdateListener(new C10875a(this.$record, height, this.$language, this.$main, this.$floater, height2, this.$result, height3, this.$isLandscape, this.$resultParent));
            Intrinsics.checkNotNull(valueAnimatorOfInt);
            final View view = this.$record;
            final View view2 = this.$language;
            final View view3 = this.$main;
            final View view4 = this.$floater;
            final View view5 = this.$result;
            final boolean z = this.$isLandscape;
            final ViewGroup viewGroup = this.$resultParent;
            final VoiceAnimation voiceAnimation = this.this$0;
            final FloatLayout floatLayout = this.$float;
            final ViewGroup viewGroup2 = this.$root;
            final Function0<Unit> function0 = this.$onAnimationEnd;
            valueAnimatorOfInt.addListener(new Animator.AnimatorListener(view, view2, view3, view4, view5, z, viewGroup, voiceAnimation, floatLayout, viewGroup2, function0, voiceAnimation, floatLayout, view) { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.animation.VoiceAnimation$expand$1$onGlobalLayout$$inlined$addListener$default$1
                final /* synthetic */ FloatLayout $float$inlined;
                final /* synthetic */ FloatLayout $float$inlined$1;
                final /* synthetic */ View $floater$inlined;
                final /* synthetic */ boolean $isLandscape$inlined;
                final /* synthetic */ View $language$inlined;
                final /* synthetic */ View $main$inlined;
                final /* synthetic */ Function0 $onAnimationEnd$inlined;
                final /* synthetic */ View $record$inlined;
                final /* synthetic */ View $record$inlined$1;
                final /* synthetic */ View $result$inlined;
                final /* synthetic */ ViewGroup $resultParent$inlined;
                final /* synthetic */ ViewGroup $root$inlined;
                final /* synthetic */ VoiceAnimation this$0;

                {
                    this.$float$inlined$1 = floatLayout;
                    this.$record$inlined$1 = view;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    this.$record$inlined.setTranslationY(0.0f);
                    this.$language$inlined.setTranslationY(0.0f);
                    this.$main$inlined.setTranslationY(0.0f);
                    this.$floater$inlined.getLayoutParams().height = -1;
                    this.$floater$inlined.requestLayout();
                    if (this.$result$inlined.getVisibility() == 0) {
                        if (AiViewUtils.isSupportFloatingLayout()) {
                            this.$result$inlined.getLayoutParams().height = -1;
                            this.$result$inlined.requestLayout();
                        } else if (this.$isLandscape$inlined) {
                            this.$resultParent$inlined.setTranslationY(0.0f);
                            this.$result$inlined.getLayoutParams().height = -1;
                            this.$result$inlined.requestLayout();
                        }
                    }
                    this.this$0.mUpdateViewAnimation.onUpdateToggleActionAnimation(true);
                    VoiceUtil.INSTANCE.enableControls(this.$record$inlined, true);
                    this.this$0.checkAnimationStateTypeNone(this.$float$inlined, false);
                    this.this$0.changeRule(this.$root$inlined, false);
                    this.$onAnimationEnd$inlined.invoke();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    this.this$0.checkAnimationStateTypeNone(this.$float$inlined$1, true);
                    VoiceUtil.INSTANCE.enableControls(this.$record$inlined$1, false);
                    this.this$0.mUpdateViewAnimation.onUpdateToggleActionAnimation(false);
                }
            });
            valueAnimatorOfInt.start();
        }
    }

    public VoiceAnimation(@NotNull UpdateViewAnimation mUpdateViewAnimation) {
        Intrinsics.checkNotNullParameter(mUpdateViewAnimation, "mUpdateViewAnimation");
        this.mUpdateViewAnimation = mUpdateViewAnimation;
        this.mInterpolator = new PathInterpolator(0.4f, 0.6f, 0.0f, 1.0f);
        this.mVoiceAnimationInterpolator = new PathInterpolator(0.22f, 0.25f, 0.0f, 1.0f);
        this.mVoiceSubAnimation = new VoiceSubAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void changeRule(ViewGroup viewGroup, boolean z) {
        int i;
        View viewFindViewById = viewGroup.findViewById(C9086R.id.appbar_layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        View viewFindViewById2 = viewGroup.findViewById(C9086R.id.voice_record_menu_container_parent);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        View viewFindViewById3 = viewGroup.findViewById(C9086R.id.translate_overlay_language_selector_container);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        ViewGroup.LayoutParams layoutParams = viewFindViewById3.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        if (z) {
            viewFindViewById.setTranslationZ(2.0f);
            viewFindViewById2.setTranslationZ(1.0f);
            viewFindViewById3.setTranslationZ(1.0f);
            i = C9086R.id.toolbar_divider;
        } else {
            viewFindViewById.setTranslationZ(0.0f);
            viewFindViewById2.setTranslationZ(0.0f);
            viewFindViewById3.setTranslationZ(0.0f);
            i = C9086R.id.voice_record_menu_container_parent;
        }
        layoutParams2.addRule(3, i);
        viewFindViewById3.setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkAnimationStateTypeNone(FloatLayout floatLayout, boolean z) {
        if (floatLayout instanceof AllSideToolbarContainerLayout) {
            ((AllSideToolbarContainerLayout) floatLayout).setAnimationStateTypeNone(z ? new C8886c((AllSideToolbarContainerLayout) floatLayout, 15) : null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean checkAnimationStateTypeNone$lambda$0(FloatLayout floatLayout) {
        return floatLayout.getDockingType() == -1;
    }

    private final View getResultView(ViewGroup root) {
        if (AiViewUtils.isSupportFloatingLayout()) {
            View viewFindViewById = root.findViewById(C9086R.id.ai_menu_result_layout_container);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            return viewFindViewById;
        }
        View viewFindViewById2 = root.findViewById(C9086R.id.old_ai_menu_result_layout_container);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        return viewFindViewById2;
    }

    public final void collapse(@Nullable ViewGroup root, @Nullable View hideView, boolean isTablet, @NotNull Function0<Unit> onAnimationEnd) {
        Intrinsics.checkNotNullParameter(onAnimationEnd, "onAnimationEnd");
        if (root == null) {
            return;
        }
        AbstractC8014b.m7220v("collapse# isTablet: ", TAG, isTablet);
        if (hideView != null) {
            hideView.setVisibility(0);
        }
        View viewFindViewById = root.findViewById(C9086R.id.translate_overlay_language_selector_container);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        View viewFindViewById2 = root.findViewById(C9086R.id.main_layout_container);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        View viewFindViewById3 = root.findViewById(C9086R.id.floating_layout_container);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        View viewFindViewById4 = viewFindViewById3.findViewById(C9086R.id.floating_layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        FloatLayout floatLayout = (FloatLayout) viewFindViewById4;
        View resultView = getResultView(root);
        ViewParent parent = resultView.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) parent;
        boolean z = BaseUtils.getContext().getResources().getConfiguration().orientation == 2;
        viewFindViewById3.getLayoutParams().height = viewFindViewById3.getHeight();
        viewFindViewById3.requestLayout();
        if (resultView.getVisibility() == 0 && (AiViewUtils.isSupportFloatingLayout() || z)) {
            resultView.getLayoutParams().height = resultView.getHeight();
            resultView.requestLayout();
        }
        changeRule(root, true);
        View viewFindViewById5 = root.findViewById(C9086R.id.voice_record_menu_container_parent);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        ViewTreeObserver viewTreeObserver = viewFindViewById5.getViewTreeObserver();
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC108691(viewTreeObserver, viewFindViewById5, viewFindViewById3, resultView, this, viewFindViewById, viewFindViewById2, z, viewGroup, floatLayout, root, hideView, onAnimationEnd));
    }

    public final void expand(@Nullable ViewGroup root, boolean isTablet, @NotNull Function0<Unit> onAnimationEnd) {
        Intrinsics.checkNotNullParameter(onAnimationEnd, "onAnimationEnd");
        if (root == null) {
            return;
        }
        AbstractC8014b.m7220v("expand# isTablet: ", TAG, isTablet);
        View viewFindViewById = root.findViewById(C9086R.id.translate_overlay_language_selector_container);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        View viewFindViewById2 = root.findViewById(C9086R.id.main_layout_container);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        View viewFindViewById3 = root.findViewById(C9086R.id.floating_layout_container);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        View viewFindViewById4 = viewFindViewById3.findViewById(C9086R.id.floating_layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        FloatLayout floatLayout = (FloatLayout) viewFindViewById4;
        View resultView = getResultView(root);
        ViewParent parent = resultView.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) parent;
        boolean z = BaseUtils.getContext().getResources().getConfiguration().orientation == 2;
        viewFindViewById3.getLayoutParams().height = viewFindViewById3.getHeight();
        viewFindViewById3.requestLayout();
        if (resultView.getVisibility() == 0 && (AiViewUtils.isSupportFloatingLayout() || z)) {
            resultView.getLayoutParams().height = resultView.getHeight();
            resultView.requestLayout();
        }
        changeRule(root, true);
        View viewFindViewById5 = root.findViewById(C9086R.id.voice_record_menu_container_parent);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        ViewTreeObserver viewTreeObserver = viewFindViewById5.getViewTreeObserver();
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC108711(viewTreeObserver, viewFindViewById5, viewFindViewById3, resultView, this, viewFindViewById, viewFindViewById2, z, viewGroup, floatLayout, root, onAnimationEnd));
    }

    public final void playListChangeBounds(@Nullable ViewGroup root) {
        TransitionManager.beginDelayedTransition(root, new ChangeBounds().excludeChildren(C9086R.id.voice_record_list, true).setDuration(400L).setInterpolator(this.mInterpolator));
    }

    public final void updateAnimationForEraser(@Nullable View parent, @Nullable EraserState state, boolean isLineVoiceLayout, boolean isLeftPosition) {
        this.mVoiceSubAnimation.updateAnimationForEraser(parent, state, isLineVoiceLayout, isLeftPosition);
    }
}
