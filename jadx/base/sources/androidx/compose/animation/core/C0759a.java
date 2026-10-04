package androidx.compose.animation.core;

/* JADX INFO: renamed from: androidx.compose.animation.core.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C0759a implements Easing {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1008a;

    public /* synthetic */ C0759a(int i) {
        this.f1008a = i;
    }

    @Override // androidx.compose.animation.core.Easing
    public final float transform(float f) {
        switch (this.f1008a) {
            case 0:
                return EasingFunctionsKt.EaseInElastic$lambda$0(f);
            case 1:
                return EasingFunctionsKt.EaseOutElastic$lambda$1(f);
            case 2:
                return EasingFunctionsKt.EaseInOutElastic$lambda$2(f);
            case 3:
                return EasingFunctionsKt.EaseOutBounce$lambda$3(f);
            case 4:
                return EasingFunctionsKt.EaseInBounce$lambda$4(f);
            case 5:
                return EasingFunctionsKt.EaseInOutBounce$lambda$5(f);
            default:
                return EasingKt.LinearEasing$lambda$0(f);
        }
    }
}
