package com.samsung.android.sesl.visualeffect.lighteffects.transitionlight;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import androidx.annotation.RequiresApi;
import androidx.collection.AbstractC0622a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.setting.handwriting.RunnableC7599e;
import com.samsung.android.sesl.visualeffect.lighteffects.common.config.AnimatableAttribute;
import com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.WiggleAnimationConfig;
import com.samsung.android.sesl.visualeffect.lighteffects.transitionlight.TransitionLightConfig;
import com.samsung.android.sesl.visualeffect.utils.DeviceSettingsUtil;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@RequiresApi(33)
@Metadata(m13885d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 22\u00020\u0001:\u00012B\u001f\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bB#\b\u0017\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\fB\u001b\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\rJ\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u001eJ\u000e\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u001eJ\u000e\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u001eJ\u000e\u0010%\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010&\u001a\u00020\u00192\u0006\u0010'\u001a\u00020(J\u0010\u0010)\u001a\u00020\u00192\b\u0010*\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010+\u001a\u00020\u00192\b\u0010,\u001a\u0004\u0018\u00010-J\u0006\u0010.\u001a\u00020\u0019J\u0006\u0010/\u001a\u00020\u0019J\u000e\u00100\u001a\u00020\u00192\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u00101\u001a\u00020\u0019R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\t\u001a\u0004\u0018\u00010\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0017¨\u00063"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/lighteffects/transitionlight/TransitionLightEffect;", "", "weakView", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "userConfig", "Lcom/samsung/android/sesl/visualeffect/lighteffects/transitionlight/TransitionLightConfig;", "<init>", "(Ljava/lang/ref/WeakReference;Lcom/samsung/android/sesl/visualeffect/lighteffects/transitionlight/TransitionLightConfig;)V", "context", "Landroid/content/Context;", "view", "(Landroid/content/Context;Landroid/view/View;Lcom/samsung/android/sesl/visualeffect/lighteffects/transitionlight/TransitionLightConfig;)V", "(Landroid/view/View;Lcom/samsung/android/sesl/visualeffect/lighteffects/transitionlight/TransitionLightConfig;)V", "getView", "()Landroid/view/View;", "getContext", "()Landroid/content/Context;", "control", "Lcom/samsung/android/sesl/visualeffect/lighteffects/transitionlight/TransitionLightControl;", ExternalDataConstants.EmbeddingConfig.KEY, "isAnimationOff", "", "()Z", "setRevealBitmap", "", "bitmap", "Landroid/graphics/Bitmap;", "setTintIntensity", "intensity", "", "setTintSaturation", "saturation", "setTransAlpha", "alpha", "setTransScale", WiggleAnimationConfig.KEY_SCALE, "setLightMap", "setBitmapScaleType", "scaleType", "Lcom/samsung/android/sesl/visualeffect/lighteffects/transitionlight/TransitionLightConfig$ScaleType;", "setColorBitmap", "colorBitmap", "setOnAnimationEndListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Ljava/lang/Runnable;", "start", "stop", "remove", "release", "Companion", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nTransitionLightEffect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TransitionLightEffect.kt\ncom/samsung/android/sesl/visualeffect/lighteffects/transitionlight/TransitionLightEffect\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,146:1\n1863#2,2:147\n1557#2:149\n1628#2,3:150\n1863#2,2:153\n1557#2:155\n1628#2,3:156\n*S KotlinDebug\n*F\n+ 1 TransitionLightEffect.kt\ncom/samsung/android/sesl/visualeffect/lighteffects/transitionlight/TransitionLightEffect\n*L\n69#1:147,2\n71#1:149\n71#1:150,3\n110#1:153,2\n112#1:155\n112#1:156,3\n*E\n"})
public final class TransitionLightEffect {

    @NotNull
    public static final String TAG = "TransitionLightEffect";

    @NotNull
    private final TransitionLightConfig config;

    @Nullable
    private TransitionLightControl control;

    @NotNull
    private final WeakReference<View> weakView;

    public TransitionLightEffect(@NotNull WeakReference<View> weakView, @NotNull TransitionLightConfig userConfig) {
        Intrinsics.checkNotNullParameter(weakView, "weakView");
        Intrinsics.checkNotNullParameter(userConfig, "userConfig");
        this.weakView = weakView;
        this.config = userConfig;
        View view = getView();
        if (view == null) {
            throw new IllegalArgumentException("View is null");
        }
        if (getContext() == null) {
            throw new IllegalArgumentException("Context is null");
        }
        StringBuilder sbM1173s = AbstractC0622a.m1173s(view.getWidth(), view.getHeight(), "initialize version: 2.1.10 view size:", "x", " config:");
        sbM1173s.append(userConfig);
        Log.i(TAG, sbM1173s.toString());
        TransitionLightControl transitionLightControl = new TransitionLightControl(userConfig);
        this.control = transitionLightControl;
        userConfig.setOnAnimationEndListener(new RunnableC7599e(transitionLightControl, 7));
        userConfig.m6739xbc54d8ec();
        transitionLightControl.add(view);
        Iterator<T> it = transitionLightControl.getAnimators$sesl_visualeffect_INTERNAL_2_1_10_release().iterator();
        while (it.hasNext()) {
            ((ValueAnimator) it.next()).cancel();
        }
        transitionLightControl.getAnimators$sesl_visualeffect_INTERNAL_2_1_10_release().clear();
        ArrayList<ValueAnimator> animators$sesl_visualeffect_INTERNAL_2_1_10_release = transitionLightControl.getAnimators$sesl_visualeffect_INTERNAL_2_1_10_release();
        ArrayList<AnimatableAttribute<?>> animatableAttribute$sesl_visualeffect_INTERNAL_2_1_10_release = this.config.getAnimatableAttribute$sesl_visualeffect_INTERNAL_2_1_10_release();
        ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(animatableAttribute$sesl_visualeffect_INTERNAL_2_1_10_release));
        Iterator<T> it2 = animatableAttribute$sesl_visualeffect_INTERNAL_2_1_10_release.iterator();
        while (it2.hasNext()) {
            arrayList.add(((AnimatableAttribute) it2.next()).build$sesl_visualeffect_INTERNAL_2_1_10_release(transitionLightControl));
        }
        animators$sesl_visualeffect_INTERNAL_2_1_10_release.addAll(arrayList);
        transitionLightControl.stop();
    }

    private final Context getContext() {
        View view = getView();
        if (view != null) {
            return view.getContext();
        }
        return null;
    }

    private final View getView() {
        return this.weakView.get();
    }

    private final boolean isAnimationOff() {
        Context context = getContext();
        if (context == null) {
            return false;
        }
        DeviceSettingsUtil.Companion companion = DeviceSettingsUtil.INSTANCE;
        return companion.isBlockedByReduceAnimations(context) || companion.isBlockedByAnimatorDurationScale(context);
    }

    public final void release() {
        Log.i(TAG, "Release Transition Light Effect");
        stop();
        this.config.setOnAnimationEndListener(null);
        TransitionLightControl transitionLightControl = this.control;
        if (transitionLightControl != null) {
            transitionLightControl.destroy();
        }
        this.control = null;
    }

    public final void remove(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        TransitionLightControl transitionLightControl = this.control;
        if (transitionLightControl != null) {
            transitionLightControl.remove(view);
        }
    }

    public final void setBitmapScaleType(@NotNull TransitionLightConfig.ScaleType scaleType) {
        TransitionLightRenderEffect renderEffect;
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        TransitionLightControl transitionLightControl = this.control;
        if (transitionLightControl == null || (renderEffect = transitionLightControl.getRenderEffect()) == null) {
            return;
        }
        renderEffect.setScaleType(scaleType);
    }

    public final void setColorBitmap(@Nullable Bitmap colorBitmap) {
        TransitionLightControl transitionLightControl = this.control;
        if (transitionLightControl != null) {
            transitionLightControl.setColorBitmap(colorBitmap);
        }
    }

    public final void setLightMap(@NotNull Bitmap bitmap) {
        TransitionLightRenderEffect renderEffect;
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        TransitionLightControl transitionLightControl = this.control;
        if (transitionLightControl == null || (renderEffect = transitionLightControl.getRenderEffect()) == null) {
            return;
        }
        renderEffect.setTransMap(bitmap);
    }

    public final void setOnAnimationEndListener(@Nullable Runnable listener) {
        ArrayList<ValueAnimator> animators$sesl_visualeffect_INTERNAL_2_1_10_release;
        ArrayList<ValueAnimator> animators$sesl_visualeffect_INTERNAL_2_1_10_release2;
        ArrayList<ValueAnimator> animators$sesl_visualeffect_INTERNAL_2_1_10_release3;
        this.config.setOnAnimationEndListener(listener);
        this.config.m6739xbc54d8ec();
        TransitionLightControl transitionLightControl = this.control;
        if (transitionLightControl != null && (animators$sesl_visualeffect_INTERNAL_2_1_10_release3 = transitionLightControl.getAnimators$sesl_visualeffect_INTERNAL_2_1_10_release()) != null) {
            Iterator<T> it = animators$sesl_visualeffect_INTERNAL_2_1_10_release3.iterator();
            while (it.hasNext()) {
                ((ValueAnimator) it.next()).cancel();
            }
        }
        TransitionLightControl transitionLightControl2 = this.control;
        if (transitionLightControl2 != null && (animators$sesl_visualeffect_INTERNAL_2_1_10_release2 = transitionLightControl2.getAnimators$sesl_visualeffect_INTERNAL_2_1_10_release()) != null) {
            animators$sesl_visualeffect_INTERNAL_2_1_10_release2.clear();
        }
        TransitionLightControl transitionLightControl3 = this.control;
        if (transitionLightControl3 == null || (animators$sesl_visualeffect_INTERNAL_2_1_10_release = transitionLightControl3.getAnimators$sesl_visualeffect_INTERNAL_2_1_10_release()) == null) {
            return;
        }
        ArrayList<AnimatableAttribute<?>> animatableAttribute$sesl_visualeffect_INTERNAL_2_1_10_release = this.config.getAnimatableAttribute$sesl_visualeffect_INTERNAL_2_1_10_release();
        ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(animatableAttribute$sesl_visualeffect_INTERNAL_2_1_10_release));
        Iterator<T> it2 = animatableAttribute$sesl_visualeffect_INTERNAL_2_1_10_release.iterator();
        while (it2.hasNext()) {
            arrayList.add(((AnimatableAttribute) it2.next()).build$sesl_visualeffect_INTERNAL_2_1_10_release(this.control));
        }
        animators$sesl_visualeffect_INTERNAL_2_1_10_release.addAll(arrayList);
    }

    public final void setRevealBitmap(@NotNull Bitmap bitmap) {
        TransitionLightRenderEffect renderEffect;
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        TransitionLightControl transitionLightControl = this.control;
        if (transitionLightControl == null || (renderEffect = transitionLightControl.getRenderEffect()) == null) {
            return;
        }
        renderEffect.setBitmap(bitmap);
    }

    public final void setTintIntensity(float intensity) {
        TransitionLightRenderEffect renderEffect;
        TransitionLightControl transitionLightControl = this.control;
        if (transitionLightControl == null || (renderEffect = transitionLightControl.getRenderEffect()) == null) {
            return;
        }
        renderEffect.setTintIntensity(intensity);
    }

    public final void setTintSaturation(float saturation) {
        TransitionLightRenderEffect renderEffect;
        TransitionLightControl transitionLightControl = this.control;
        if (transitionLightControl == null || (renderEffect = transitionLightControl.getRenderEffect()) == null) {
            return;
        }
        renderEffect.setTintSaturation(saturation);
    }

    public final void setTransAlpha(float alpha) {
        TransitionLightRenderEffect renderEffect;
        TransitionLightControl transitionLightControl = this.control;
        if (transitionLightControl == null || (renderEffect = transitionLightControl.getRenderEffect()) == null) {
            return;
        }
        renderEffect.setTransAlpha(alpha);
    }

    public final void setTransScale(float scale) {
        TransitionLightRenderEffect renderEffect;
        TransitionLightControl transitionLightControl = this.control;
        if (transitionLightControl == null || (renderEffect = transitionLightControl.getRenderEffect()) == null) {
            return;
        }
        renderEffect.setTransScale(scale);
    }

    public final void start() {
        Log.i(TAG, "Start Transition Effect animation: " + isAnimationOff() + " revealMode: " + this.config.getRevealMode());
        if (isAnimationOff() && this.config.getRevealMode() == TransitionLightConfig.RevealMode.VIEW) {
            Runnable onAnimationEndListener = this.config.getOnAnimationEndListener();
            if (onAnimationEndListener != null) {
                onAnimationEndListener.run();
                return;
            }
            return;
        }
        TransitionLightControl transitionLightControl = this.control;
        if (transitionLightControl != null) {
            transitionLightControl.stop();
        }
        TransitionLightControl transitionLightControl2 = this.control;
        if (transitionLightControl2 != null) {
            transitionLightControl2.start();
        }
    }

    public final void stop() {
        Log.i(TAG, "Stop Transition Effect");
        TransitionLightControl transitionLightControl = this.control;
        if (transitionLightControl != null) {
            transitionLightControl.stop();
        }
    }

    public /* synthetic */ TransitionLightEffect(WeakReference weakReference, TransitionLightConfig transitionLightConfig, int i, DefaultConstructorMarker defaultConstructorMarker) {
        TransitionLightConfig transitionLightConfig2;
        if ((i & 2) != 0) {
            transitionLightConfig2 = new TransitionLightConfig(null, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, 0L, 0.0f, 0.0f, 0.0f, null, null, null, 0.0f, 131071, null);
        } else {
            transitionLightConfig2 = transitionLightConfig;
        }
        this((WeakReference<View>) weakReference, transitionLightConfig2);
    }

    public /* synthetic */ TransitionLightEffect(Context context, View view, TransitionLightConfig transitionLightConfig, int i, DefaultConstructorMarker defaultConstructorMarker) {
        TransitionLightConfig transitionLightConfig2;
        if ((i & 4) != 0) {
            transitionLightConfig2 = new TransitionLightConfig(null, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, 0L, 0.0f, 0.0f, 0.0f, null, null, null, 0.0f, 131071, null);
        } else {
            transitionLightConfig2 = transitionLightConfig;
        }
        this(context, view, transitionLightConfig2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "context is no more required", replaceWith = @ReplaceWith(expression = "TransitionLightEffect(view, userConfig)", imports = {}))
    public TransitionLightEffect(@NotNull Context context, @NotNull View view, @NotNull TransitionLightConfig userConfig) {
        this((WeakReference<View>) new WeakReference(view), userConfig);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(userConfig, "userConfig");
    }

    public /* synthetic */ TransitionLightEffect(View view, TransitionLightConfig transitionLightConfig, int i, DefaultConstructorMarker defaultConstructorMarker) {
        TransitionLightConfig transitionLightConfig2;
        if ((i & 2) != 0) {
            transitionLightConfig2 = new TransitionLightConfig(null, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, 0L, 0.0f, 0.0f, 0.0f, null, null, null, 0.0f, 131071, null);
        } else {
            transitionLightConfig2 = transitionLightConfig;
        }
        this(view, transitionLightConfig2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TransitionLightEffect(@NotNull View view, @NotNull TransitionLightConfig userConfig) {
        this((WeakReference<View>) new WeakReference(view), userConfig);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(userConfig, "userConfig");
    }
}
