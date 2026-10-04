package com.samsung.android.sesl.visualeffect.lighteffects.common.control;

import android.animation.ValueAnimator;
import android.view.View;
import androidx.annotation.RequiresApi;
import com.samsung.android.sesl.visualeffect.lighteffects.common.config.VibeEffectConfig;
import com.samsung.android.sesl.visualeffect.lighteffects.common.control.VibeEffectControl;
import com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.VibeRenderEffect;
import com.samsung.android.sesl.visualeffect.utils.WeakViewArrayList;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.commons.lang3.exception.C13834b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@RequiresApi(33)
@Metadata(m13885d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\b'\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u00020\u00052\u00020\u0006B\u000f\u0012\u0006\u0010\u0007\u001a\u00028\u0000¢\u0006\u0004\b\b\u0010\tJ)\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00028\u0001\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001c0\u001b2\u0006\u0010\u0007\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u001dJ\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u001fH\u0016J\u0006\u0010!\u001a\u00020\u001fJ\u0010\u0010\"\u001a\u00020\u001f2\b\b\u0002\u0010!\u001a\u00020#J\u0006\u0010$\u001a\u00020\u001fJ\u0006\u0010%\u001a\u00020\u001fJ\u0010\u0010&\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020(H\u0016R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR!\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u000fj\b\u0012\u0004\u0012\u00020\u0004`\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0013\u001a\u0004\u0018\u00018\u00018F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u000fj\b\u0012\u0004\u0012\u00020\u0017`\u0010X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R.\u0010\u0019\u001a\"\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00000\u000fj\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0000`\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/lighteffects/common/control/VibeEffectBase;", "T", "Lcom/samsung/android/sesl/visualeffect/lighteffects/common/config/VibeEffectConfig;", "R", "Lcom/samsung/android/sesl/visualeffect/lighteffects/common/runtimshader/VibeRenderEffect;", "Lcom/samsung/android/sesl/visualeffect/lighteffects/common/control/VibeEffectControl;", "Lcom/samsung/android/sesl/visualeffect/lighteffects/common/control/IFrameRateControl;", ExternalDataConstants.EmbeddingConfig.KEY, "<init>", "(Lcom/samsung/android/sesl/visualeffect/lighteffects/common/config/VibeEffectConfig;)V", "views", "Lcom/samsung/android/sesl/visualeffect/utils/WeakViewArrayList;", "getViews", "()Lcom/samsung/android/sesl/visualeffect/utils/WeakViewArrayList;", "vibeRenderEffect", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getVibeRenderEffect", "()Ljava/util/ArrayList;", "renderEffect", "getRenderEffect", "()Lcom/samsung/android/sesl/visualeffect/lighteffects/common/runtimshader/VibeRenderEffect;", "animators", "Landroid/animation/ValueAnimator;", "getAnimators$sesl_visualeffect_INTERNAL_2_1_10_release", "child", "build", "Lkotlin/Pair;", "", "(Lcom/samsung/android/sesl/visualeffect/lighteffects/common/config/VibeEffectConfig;)Lkotlin/Pair;", "start", "", "stop", "reset", "pause", "", "resume", "destroy", "setFrameRate", "frameRate", "", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nVibeEffectBase.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VibeEffectBase.kt\ncom/samsung/android/sesl/visualeffect/lighteffects/common/control/VibeEffectBase\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,84:1\n1863#2,2:85\n1863#2,2:87\n1863#2,2:89\n1863#2,2:91\n1863#2,2:93\n1863#2,2:95\n1863#2,2:97\n1863#2,2:99\n1863#2,2:101\n1863#2,2:103\n1863#2,2:105\n1863#2,2:107\n1863#2,2:109\n1863#2,2:111\n1863#2,2:113\n*S KotlinDebug\n*F\n+ 1 VibeEffectBase.kt\ncom/samsung/android/sesl/visualeffect/lighteffects/common/control/VibeEffectBase\n*L\n36#1:85,2\n37#1:87,2\n38#1:89,2\n42#1:91,2\n43#1:93,2\n44#1:95,2\n48#1:97,2\n51#1:99,2\n58#1:101,2\n59#1:103,2\n63#1:105,2\n64#1:107,2\n69#1:109,2\n75#1:111,2\n80#1:113,2\n*E\n"})
public abstract class VibeEffectBase<T extends VibeEffectConfig, R extends VibeRenderEffect> implements VibeEffectControl, IFrameRateControl {

    @NotNull
    private final ArrayList<ValueAnimator> animators;

    @NotNull
    private ArrayList<VibeEffectBase<?, ?>> child;

    @NotNull
    private final ArrayList<VibeRenderEffect> vibeRenderEffect;

    @NotNull
    private final WeakViewArrayList views;

    public VibeEffectBase(@NotNull T config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.views = new WeakViewArrayList();
        ArrayList<VibeRenderEffect> arrayList = new ArrayList<>();
        this.vibeRenderEffect = arrayList;
        ArrayList<ValueAnimator> arrayList2 = new ArrayList<>();
        this.animators = arrayList2;
        this.child = new ArrayList<>();
        Pair<R, List<ValueAnimator>> pairBuild = build(config);
        arrayList.add(pairBuild.getFirst());
        List<ValueAnimator> second = pairBuild.getSecond();
        if (second != null) {
            arrayList2.addAll(second);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void destroy$lambda$15(VibeEffectBase vibeEffectBase, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        VibeRenderEffect renderEffect = vibeEffectBase.getRenderEffect();
        if (renderEffect != null) {
            renderEffect.remove(it);
        }
    }

    public static /* synthetic */ void pause$default(VibeEffectBase vibeEffectBase, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: pause");
        }
        if ((i & 1) != 0) {
            z = false;
        }
        vibeEffectBase.pause(z);
    }

    @Override // com.samsung.android.sesl.visualeffect.lighteffects.common.control.VibeEffectControl
    public void add(@NotNull View view) {
        VibeEffectControl.DefaultImpls.add(this, view);
    }

    @NotNull
    public abstract Pair<R, List<ValueAnimator>> build(@NotNull T config);

    public final void destroy() {
        this.child.clear();
        Iterator<T> it = this.animators.iterator();
        while (it.hasNext()) {
            ((ValueAnimator) it.next()).cancel();
        }
        this.animators.clear();
        getViews().forEachAlive(new C13834b(this, 10));
        getViews().clear();
        Iterator<T> it2 = this.vibeRenderEffect.iterator();
        while (it2.hasNext()) {
            ((VibeRenderEffect) it2.next()).destroy();
        }
        this.vibeRenderEffect.clear();
    }

    @NotNull
    public final ArrayList<ValueAnimator> getAnimators$sesl_visualeffect_INTERNAL_2_1_10_release() {
        return this.animators;
    }

    @Nullable
    public final R getRenderEffect() {
        if (this.vibeRenderEffect.size() >= 1) {
            VibeRenderEffect vibeRenderEffect = this.vibeRenderEffect.get(0);
            if (vibeRenderEffect instanceof VibeRenderEffect) {
                return (R) vibeRenderEffect;
            }
        }
        return null;
    }

    @Override // com.samsung.android.sesl.visualeffect.lighteffects.common.control.VibeEffectControl
    @NotNull
    public final ArrayList<VibeRenderEffect> getVibeRenderEffect() {
        return this.vibeRenderEffect;
    }

    @Override // com.samsung.android.sesl.visualeffect.lighteffects.common.control.VibeEffectControl
    @NotNull
    public WeakViewArrayList getViews() {
        return this.views;
    }

    public final void pause(boolean reset) {
        if (reset) {
            reset();
        }
        Iterator<T> it = this.animators.iterator();
        while (it.hasNext()) {
            ((ValueAnimator) it.next()).pause();
        }
        Iterator<T> it2 = this.child.iterator();
        while (it2.hasNext()) {
            pause$default((VibeEffectBase) it2.next(), false, 1, null);
        }
    }

    @Override // com.samsung.android.sesl.visualeffect.lighteffects.common.control.VibeEffectControl
    public void remove(@NotNull View view) {
        VibeEffectControl.DefaultImpls.remove(this, view);
    }

    public final void reset() {
        Iterator<T> it = this.animators.iterator();
        while (it.hasNext()) {
            ((ValueAnimator) it.next()).setCurrentFraction(0.0f);
        }
        Iterator<T> it2 = this.child.iterator();
        while (it2.hasNext()) {
            ((VibeEffectBase) it2.next()).reset();
        }
    }

    public final void resume() {
        Iterator<T> it = this.animators.iterator();
        while (it.hasNext()) {
            ((ValueAnimator) it.next()).resume();
        }
        Iterator<T> it2 = this.child.iterator();
        while (it2.hasNext()) {
            ((VibeEffectBase) it2.next()).resume();
        }
    }

    @Override // com.samsung.android.sesl.visualeffect.lighteffects.common.control.IFrameRateControl
    public void setFrameRate(float frameRate) {
        Iterator<T> it = this.vibeRenderEffect.iterator();
        while (it.hasNext()) {
            ((VibeRenderEffect) it.next()).setRequestedMaxFrameRate(Float.valueOf(frameRate));
        }
    }

    @Override // com.samsung.android.sesl.visualeffect.lighteffects.common.control.VibeEffectControl
    public void start() {
        Iterator<T> it = this.animators.iterator();
        while (it.hasNext()) {
            ((ValueAnimator) it.next()).start();
        }
        Iterator<T> it2 = this.vibeRenderEffect.iterator();
        while (it2.hasNext()) {
            ((VibeRenderEffect) it2.next()).start();
        }
        Iterator<T> it3 = this.child.iterator();
        while (it3.hasNext()) {
            ((VibeEffectBase) it3.next()).start();
        }
    }

    @Override // com.samsung.android.sesl.visualeffect.lighteffects.common.control.VibeEffectControl
    public void stop() {
        Iterator<T> it = this.animators.iterator();
        while (it.hasNext()) {
            ((ValueAnimator) it.next()).cancel();
        }
        Iterator<T> it2 = this.vibeRenderEffect.iterator();
        while (it2.hasNext()) {
            ((VibeRenderEffect) it2.next()).stop();
        }
        Iterator<T> it3 = this.child.iterator();
        while (it3.hasNext()) {
            ((VibeEffectBase) it3.next()).stop();
        }
    }
}
