package com.samsung.android.sesl.visualeffect.lighteffects.transitionlight;

import android.graphics.PointF;
import com.samsung.android.sesl.visualeffect.lighteffects.common.control.VibeEffectControl;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.channels.BufferedChannel;

/* JADX INFO: renamed from: com.samsung.android.sesl.visualeffect.lighteffects.transitionlight.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C7884a implements Function3 {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5376a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f5377b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f5378c;

    public /* synthetic */ C7884a(Object obj, Object obj2, int i) {
        this.f5376a = i;
        this.f5377b = obj;
        this.f5378c = obj2;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        switch (this.f5376a) {
            case 0:
                return TransitionLightConfig.buildAnimationAttribute$lambda$1((TransitionLightConfig) this.f5377b, (PointF) this.f5378c, (VibeEffectControl) obj, ((Float) obj2).floatValue(), ((Float) obj3).floatValue());
            default:
                return BufferedChannel.bindCancellationFun$lambda$89((Function1) this.f5377b, this.f5378c, (Throwable) obj, obj2, (CoroutineContext) obj3);
        }
    }
}
