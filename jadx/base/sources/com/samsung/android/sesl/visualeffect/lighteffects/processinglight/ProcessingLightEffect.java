package com.samsung.android.sesl.visualeffect.lighteffects.processinglight;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;
import android.view.View;
import androidx.annotation.RequiresApi;
import androidx.collection.AbstractC0622a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.material.chip.C4643k;
import com.samsung.android.sdk.pen.setting.handwriting.RunnableC7599e;
import com.samsung.android.sesl.visualeffect.lighteffects.processinglight.AnimationFactory;
import com.samsung.android.sesl.visualeffect.utils.DomainColorUtil;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p079T.RunnableC0284b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@RequiresApi(33)
@Metadata(m13885d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001!B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B)\b\u0017\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\nJ\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0013J\b\u0010\u0015\u001a\u00020\u0013H\u0002J\b\u0010\u0016\u001a\u00020\u0013H\u0002J\u0006\u0010\u0017\u001a\u00020\u0013J\u0006\u0010\u0018\u001a\u00020\u0013J\u0010\u0010\u0019\u001a\u00020\u00132\b\b\u0002\u0010\u0018\u001a\u00020\u0011J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u000e\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u0003J\u0006\u0010\u001d\u001a\u00020\u0013J\u0010\u0010\u001e\u001a\u00020\u00132\b\u0010\u001f\u001a\u0004\u0018\u00010 R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/lighteffects/processinglight/ProcessingLightEffect;", "", "view", "Landroid/view/View;", "userConfig", "Lcom/samsung/android/sesl/visualeffect/lighteffects/processinglight/ProcessingLightConfig;", "<init>", "(Landroid/view/View;Lcom/samsung/android/sesl/visualeffect/lighteffects/processinglight/ProcessingLightConfig;)V", "context", "Landroid/content/Context;", "(Landroid/content/Context;Landroid/view/View;Lcom/samsung/android/sesl/visualeffect/lighteffects/processinglight/ProcessingLightConfig;)V", "control", "Lcom/samsung/android/sesl/visualeffect/lighteffects/processinglight/ProcessingLightControl;", ExternalDataConstants.EmbeddingConfig.KEY, "stopAnimator", "Landroid/animation/ValueAnimator;", "isRunning", "", "start", "", "stop", "stopEffectWithAnimation", "stopEffect", "resume", "reset", "pause", "getDomainColorFromView", "", "remove", "release", "setColorBitmap", "colorBitmap", "Landroid/graphics/Bitmap;", "Companion", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class ProcessingLightEffect {

    @NotNull
    public static final String TAG = "ProcessingLightEffect";

    @NotNull
    private ProcessingLightConfig config;

    @Nullable
    private ProcessingLightControl control;
    private boolean isRunning;

    @Nullable
    private ValueAnimator stopAnimator;

    public ProcessingLightEffect(@NotNull View view, @NotNull ProcessingLightConfig userConfig) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(userConfig, "userConfig");
        this.config = userConfig;
        if (Build.VERSION.SDK_INT >= 35) {
            view.setRequestedFrameRate(-3.0f);
        }
        if (userConfig.getUseDynamicDomainColor()) {
            userConfig.setDomainColor(Integer.valueOf(getDomainColorFromView(view)));
        }
        StringBuilder sbM1173s = AbstractC0622a.m1173s(view.getWidth(), view.getHeight(), "initialize version: 2.1.10 view size:", "x", " config:");
        sbM1173s.append(userConfig);
        Log.i(TAG, sbM1173s.toString());
        ProcessingLightConfig processingLightConfigMakeConfigWithAnimator$sesl_visualeffect_INTERNAL_2_1_10_release = userConfig.makeConfigWithAnimator$sesl_visualeffect_INTERNAL_2_1_10_release();
        this.config = processingLightConfigMakeConfigWithAnimator$sesl_visualeffect_INTERNAL_2_1_10_release;
        ProcessingLightControl processingLightControl = new ProcessingLightControl(processingLightConfigMakeConfigWithAnimator$sesl_visualeffect_INTERNAL_2_1_10_release);
        this.control = processingLightControl;
        processingLightControl.add(view);
        ProcessingLightControl processingLightControl2 = this.control;
        if (processingLightControl2 != null) {
            processingLightControl2.buildAnimation(this.config);
        }
        ProcessingLightControl processingLightControl3 = this.control;
        if (processingLightControl3 != null) {
            processingLightControl3.stop();
        }
    }

    private final int getDomainColorFromView(View view) {
        if (view.getMeasuredWidth() <= 0 || view.getMeasuredHeight() <= 0) {
            return Color.parseColor("#FFFFFF");
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        view.draw(new Canvas(bitmapCreateBitmap));
        DomainColorUtil domainColorUtil = DomainColorUtil.INSTANCE;
        return DomainColorUtil.calibrateByLightness$default(domainColorUtil, domainColorUtil.extract(bitmapCreateBitmap, DomainColorUtil.ColorPalette.Palette512), null, 2, null);
    }

    public static /* synthetic */ void pause$default(ProcessingLightEffect processingLightEffect, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        processingLightEffect.pause(z);
    }

    private final void stopEffect() {
        ProcessingLightControl processingLightControl = this.control;
        if (processingLightControl != null) {
            processingLightControl.stop();
        }
        ValueAnimator valueAnimator = this.stopAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.stopAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator3 = this.stopAnimator;
        if (valueAnimator3 != null) {
            valueAnimator3.removeAllListeners();
        }
    }

    private final void stopEffectWithAnimation() {
        float lightIntensity = this.config.getLightIntensity();
        ValueAnimator valueAnimator = this.stopAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        AnimationFactory.Companion companion = AnimationFactory.INSTANCE;
        AnimationFactory.Companion.AnimationType animationType = AnimationFactory.Companion.AnimationType.STOP;
        C4643k c4643k = new C4643k(this, lightIntensity, 2);
        int i = 6;
        ValueAnimator valueAnimatorCreateAnimation$default = AnimationFactory.Companion.createAnimation$default(companion, animationType, c4643k, new RunnableC0284b(i), new RunnableC7599e(this, i), new RunnableC0284b(7), null, 32, null);
        this.stopAnimator = valueAnimatorCreateAnimation$default;
        if (valueAnimatorCreateAnimation$default != null) {
            valueAnimatorCreateAnimation$default.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void stopEffectWithAnimation$lambda$0(ProcessingLightEffect processingLightEffect, float f, ValueAnimator it) {
        ProcessingLightControl processingLightControl;
        ProcessingLightRenderEffect renderEffect;
        Intrinsics.checkNotNullParameter(it, "it");
        if (processingLightEffect.isRunning || (processingLightControl = processingLightEffect.control) == null || (renderEffect = processingLightControl.getRenderEffect()) == null) {
            return;
        }
        Object animatedValue = it.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        renderEffect.setLightIntensity(((Float) animatedValue).floatValue() * f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void stopEffectWithAnimation$lambda$2(ProcessingLightEffect processingLightEffect) {
        ProcessingLightRenderEffect renderEffect;
        AbstractC4539a.m3208r("Stop Animation - onEnd isRunning:", TAG, processingLightEffect.isRunning);
        if (!processingLightEffect.isRunning) {
            processingLightEffect.stopEffect();
        }
        ProcessingLightControl processingLightControl = processingLightEffect.control;
        if (processingLightControl == null || (renderEffect = processingLightControl.getRenderEffect()) == null) {
            return;
        }
        renderEffect.setLightIntensity(processingLightEffect.config.getLightIntensity());
    }

    public final void pause(boolean reset) {
        ProcessingLightControl processingLightControl = this.control;
        if (processingLightControl != null) {
            processingLightControl.pause(reset);
        }
    }

    public final void release() {
        Log.i(TAG, "Release Processing Light Effect");
        stopEffect();
        this.config.destroy();
        ProcessingLightControl processingLightControl = this.control;
        if (processingLightControl != null) {
            processingLightControl.destroy();
        }
        this.control = null;
    }

    public final void remove(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        ProcessingLightControl processingLightControl = this.control;
        if (processingLightControl != null) {
            processingLightControl.remove(view);
        }
    }

    public final void reset() {
        ProcessingLightControl processingLightControl = this.control;
        if (processingLightControl != null) {
            processingLightControl.reset();
        }
    }

    public final void resume() {
        ProcessingLightControl processingLightControl = this.control;
        if (processingLightControl != null) {
            processingLightControl.resume();
        }
    }

    public final void setColorBitmap(@Nullable Bitmap colorBitmap) {
        ProcessingLightControl processingLightControl = this.control;
        if (processingLightControl != null) {
            processingLightControl.setColorBitmap(colorBitmap);
        }
    }

    public final void start() {
        boolean z = this.isRunning;
        ValueAnimator valueAnimator = this.stopAnimator;
        Log.i(TAG, "Start Processing Effect isRunning:" + z + " stopAnimation:" + (valueAnimator != null ? Boolean.valueOf(valueAnimator.isRunning()) : null));
        stopEffect();
        this.isRunning = true;
        ProcessingLightControl processingLightControl = this.control;
        if (processingLightControl != null) {
            processingLightControl.start();
        }
    }

    public final void stop() {
        Log.i(TAG, "Stop Processing Effect");
        stopEffect();
    }

    public /* synthetic */ ProcessingLightEffect(View view, ProcessingLightConfig processingLightConfig, int i, DefaultConstructorMarker defaultConstructorMarker) {
        ProcessingLightConfig processingLightConfig2;
        if ((i & 2) != 0) {
            processingLightConfig2 = new ProcessingLightConfig(false, null, null, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, null, 0.0f, 0.0f, 0.0f, 0.0f, 0L, false, 0.0f, 0L, 262143, null);
        } else {
            processingLightConfig2 = processingLightConfig;
        }
        this(view, processingLightConfig2);
    }

    public /* synthetic */ ProcessingLightEffect(Context context, View view, ProcessingLightConfig processingLightConfig, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : view, (i & 4) != 0 ? new ProcessingLightConfig(false, null, null, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, null, 0.0f, 0.0f, 0.0f, 0.0f, 0L, false, 0.0f, 0L, 262143, null) : processingLightConfig);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "context is no more required", replaceWith = @ReplaceWith(expression = "ProcessingLightEffect(view, userConfig)", imports = {}))
    public ProcessingLightEffect(@Nullable Context context, @Nullable View view, @NotNull ProcessingLightConfig userConfig) {
        this(view, userConfig);
        Intrinsics.checkNotNullParameter(userConfig, "userConfig");
        if (view == null) {
            throw new IllegalArgumentException("View is null");
        }
    }
}
