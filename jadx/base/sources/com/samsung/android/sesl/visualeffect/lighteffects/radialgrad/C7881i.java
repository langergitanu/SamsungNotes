package com.samsung.android.sesl.visualeffect.lighteffects.radialgrad;

import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.ExceptionsConstructorKt;

/* JADX INFO: renamed from: com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.i */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C7881i implements Function1 {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5366a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Function1 f5367b;

    public /* synthetic */ C7881i(Function1 function1, int i) {
        this.f5366a = i;
        this.f5367b = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.f5366a) {
            case 0:
                return WiggleAnimationConfig.buildListener$lambda$4$lambda$0(this.f5367b, obj);
            case 1:
                return WiggleAnimationConfig.buildListener$lambda$4$lambda$1(this.f5367b, obj);
            case 2:
                return WiggleAnimationConfig.buildListener$lambda$4$lambda$3$lambda$2(this.f5367b, obj);
            default:
                return ExceptionsConstructorKt.safeCtor$lambda$9(this.f5367b, (Throwable) obj);
        }
    }
}
