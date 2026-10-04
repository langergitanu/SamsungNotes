package com.samsung.android.sesl.visualeffect.lighteffects.processinglight;

import android.graphics.Color;
import android.view.View;
import com.samsung.android.sesl.visualeffect.lighteffects.common.control.VibeEffectControl;
import com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.WiggleAnimationConfig;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.ListenerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTColorDialLayout;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.sync.MutexImpl;
import kotlinx.coroutines.sync.SemaphoreAndMutexImpl;

/* JADX INFO: renamed from: com.samsung.android.sesl.visualeffect.lighteffects.processinglight.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C7868a implements Function3 {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5330a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f5331b;

    public /* synthetic */ C7868a(Object obj, int i) {
        this.f5330a = i;
        this.f5331b = obj;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        switch (this.f5330a) {
            case 0:
                return ProcessingLightConfig.makeConfigWithAnimator$lambda$1$lambda$0((ProcessingLightConfig) this.f5331b, (VibeEffectControl) obj, ((Float) obj2).floatValue(), ((Float) obj3).floatValue());
            case 1:
                return WiggleAnimationConfig.build$lambda$15$lambda$14((HashMap) this.f5331b, (VibeEffectControl) obj, ((Float) obj2).floatValue(), (Color) obj3);
            case 2:
                return ListenerManager.lambda$initPreCommitTextFunc$0((ControllerManager) this.f5331b, (CharSequence) obj, (Integer) obj2, (Integer) obj3);
            case 3:
                return SettingQTColorDialLayout._init_$lambda$0((SettingQTColorDialLayout) this.f5331b, (View) obj, ((Integer) obj2).intValue(), ((Integer) obj3).intValue());
            case 4:
                return CancellableContinuationImpl.resume$lambda$13$lambda$12((Function1) this.f5331b, (Throwable) obj, obj2, (CoroutineContext) obj3);
            case 5:
                return MutexImpl.onSelectCancellationUnlockConstructor$lambda$1((MutexImpl) this.f5331b, (SelectInstance) obj, obj2, obj3);
            default:
                return SemaphoreAndMutexImpl.onCancellationRelease$lambda$2((SemaphoreAndMutexImpl) this.f5331b, (Throwable) obj, (Unit) obj2, (CoroutineContext) obj3);
        }
    }
}
