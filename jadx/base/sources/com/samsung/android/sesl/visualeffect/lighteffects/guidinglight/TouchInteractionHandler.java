package com.samsung.android.sesl.visualeffect.lighteffects.guidinglight;

import android.annotation.SuppressLint;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.RequiresApi;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import com.google.android.material.oneui.floatingdock.ViewOnTouchListenerC4799j;
import com.google.firebase.messaging.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@RequiresApi(33)
@Metadata(m13885d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0001\u0018\u0000 #2\u00020\u0001:\u0001#B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0010H\u0007J\b\u0010\u0017\u001a\u00020\u0018H\u0003J\u0018\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u000eH\u0002J\u0018\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0013H\u0002J\u000e\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u0013J\u0018\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u000eH\u0002J\u0006\u0010\"\u001a\u00020\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/TouchInteractionHandler;", "", "view", "Landroid/view/View;", "renderEffect", "Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/GuidingLightRenderEffect;", ExternalDataConstants.EmbeddingConfig.KEY, "Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/GuidingLightConfig;", "<init>", "(Landroid/view/View;Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/GuidingLightRenderEffect;Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/GuidingLightConfig;)V", "touchAnimation", "Landroidx/dynamicanimation/animation/SpringAnimation;", "intensityAnimation", "lastTouchDownPos", "Landroid/graphics/PointF;", "useDefaultTouchListener", "", "Ljava/lang/Boolean;", "baseIntensity", "", "setDefaultTouchInteraction", "", "isEnable", "createTouchListener", "Landroid/view/View$OnTouchListener;", "moveToPosition", Constants.MessagePayloadKeys.FROM, "to", "animateIntensity", "updateBaseIntensity", "intensity", "getDistance", "pointA", "pointB", "destroy", "Companion", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class TouchInteractionHandler {
    private static final float MOVE_THRESHOLD = 0.02f;
    private float baseIntensity;

    @NotNull
    private final GuidingLightConfig config;

    @Nullable
    private SpringAnimation intensityAnimation;

    @NotNull
    private PointF lastTouchDownPos;

    @Nullable
    private final GuidingLightRenderEffect renderEffect;

    @Nullable
    private SpringAnimation touchAnimation;

    @Nullable
    private Boolean useDefaultTouchListener;

    @NotNull
    private final View view;

    @NotNull
    private static final PointF CENTER = new PointF(0.5f, 0.5f);

    public TouchInteractionHandler(@NotNull View view, @Nullable GuidingLightRenderEffect guidingLightRenderEffect, @NotNull GuidingLightConfig config) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(config, "config");
        this.view = view;
        this.renderEffect = guidingLightRenderEffect;
        this.config = config;
        this.lastTouchDownPos = new PointF(0.5f, 0.5f);
        this.baseIntensity = config.getLightIntensity();
    }

    private final void animateIntensity(final float from, final float to) {
        SpringAnimation springAnimation = this.intensityAnimation;
        if (springAnimation != null) {
            springAnimation.cancel();
        }
        SpringAnimation springAnimationCreateSpringAnimation = AnimationFactory.INSTANCE.createSpringAnimation(new DynamicAnimation.OnAnimationUpdateListener() { // from class: com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.s
            @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener
            public final void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f, float f4) {
                TouchInteractionHandler.animateIntensity$lambda$2(from, to, this, dynamicAnimation, f, f4);
            }
        });
        this.intensityAnimation = springAnimationCreateSpringAnimation;
        if (springAnimationCreateSpringAnimation != null) {
            springAnimationCreateSpringAnimation.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animateIntensity$lambda$2(float f, float f4, TouchInteractionHandler touchInteractionHandler, DynamicAnimation dynamicAnimation, float f5, float f6) {
        float f7 = (((f4 - f) * f5) / 100.0f) + f;
        GuidingLightRenderEffect guidingLightRenderEffect = touchInteractionHandler.renderEffect;
        if (guidingLightRenderEffect != null) {
            guidingLightRenderEffect.setLightIntensity(f7);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final View.OnTouchListener createTouchListener() {
        return new ViewOnTouchListenerC4799j(this, 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean createTouchListener$lambda$0(TouchInteractionHandler touchInteractionHandler, View view, MotionEvent motionEvent) {
        PointF pointF = new PointF(RangesKt.coerceIn(motionEvent.getX() / view.getWidth(), 0.0f, 1.0f), RangesKt.coerceIn(motionEvent.getY() / view.getHeight(), 0.0f, 1.0f));
        int action = motionEvent.getAction();
        if (action == 0) {
            touchInteractionHandler.moveToPosition(CENTER, pointF);
            touchInteractionHandler.animateIntensity(touchInteractionHandler.baseIntensity, touchInteractionHandler.config.getTouchIntensity());
            touchInteractionHandler.lastTouchDownPos = pointF;
            return false;
        }
        if (action == 1) {
            touchInteractionHandler.moveToPosition(pointF, CENTER);
            touchInteractionHandler.animateIntensity(touchInteractionHandler.config.getTouchIntensity(), touchInteractionHandler.baseIntensity);
            touchInteractionHandler.lastTouchDownPos = pointF;
            return false;
        }
        if (action != 2) {
            if (action != 3) {
                return false;
            }
            touchInteractionHandler.moveToPosition(touchInteractionHandler.lastTouchDownPos, CENTER);
            touchInteractionHandler.animateIntensity(touchInteractionHandler.config.getTouchIntensity(), touchInteractionHandler.baseIntensity);
            return false;
        }
        if (touchInteractionHandler.getDistance(touchInteractionHandler.lastTouchDownPos, pointF) <= 0.02f) {
            return false;
        }
        touchInteractionHandler.moveToPosition(touchInteractionHandler.lastTouchDownPos, pointF);
        touchInteractionHandler.lastTouchDownPos = pointF;
        return false;
    }

    private final float getDistance(PointF pointA, PointF pointB) {
        double d = 2;
        return (float) Math.sqrt(((float) Math.pow(pointB.x - pointA.x, d)) + ((float) Math.pow(pointB.y - pointA.y, d)));
    }

    private final void moveToPosition(final PointF from, final PointF to) {
        SpringAnimation springAnimation = this.touchAnimation;
        if (springAnimation != null) {
            springAnimation.cancel();
        }
        SpringAnimation springAnimationCreateSpringAnimation = AnimationFactory.INSTANCE.createSpringAnimation(new DynamicAnimation.OnAnimationUpdateListener() { // from class: com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.r
            @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener
            public final void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f, float f4) {
                TouchInteractionHandler.moveToPosition$lambda$1(from, to, this, dynamicAnimation, f, f4);
            }
        });
        this.touchAnimation = springAnimationCreateSpringAnimation;
        if (springAnimationCreateSpringAnimation != null) {
            springAnimationCreateSpringAnimation.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void moveToPosition$lambda$1(PointF pointF, PointF pointF2, TouchInteractionHandler touchInteractionHandler, DynamicAnimation dynamicAnimation, float f, float f4) {
        float f5 = pointF.x;
        float f6 = (((pointF2.x - f5) * f) / 100.0f) + f5;
        float f7 = pointF.y;
        PointF pointF3 = new PointF(f6, (((pointF2.y - f7) * f) / 100.0f) + f7);
        GuidingLightRenderEffect guidingLightRenderEffect = touchInteractionHandler.renderEffect;
        if (guidingLightRenderEffect != null) {
            guidingLightRenderEffect.setLightPos(pointF3);
        }
    }

    public final void destroy() {
        SpringAnimation springAnimation = this.touchAnimation;
        if (springAnimation != null) {
            springAnimation.cancel();
        }
        this.touchAnimation = null;
        SpringAnimation springAnimation2 = this.intensityAnimation;
        if (springAnimation2 != null) {
            springAnimation2.cancel();
        }
        this.intensityAnimation = null;
        if (Intrinsics.areEqual(this.useDefaultTouchListener, Boolean.TRUE)) {
            this.view.setOnTouchListener(null);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void setDefaultTouchInteraction(boolean isEnable) {
        if (isEnable) {
            this.view.setOnTouchListener(createTouchListener());
        } else if (Intrinsics.areEqual(this.useDefaultTouchListener, Boolean.TRUE)) {
            this.view.setOnTouchListener(null);
        }
        this.useDefaultTouchListener = Boolean.valueOf(isEnable);
    }

    public final void updateBaseIntensity(float intensity) {
        this.baseIntensity = intensity;
    }
}
