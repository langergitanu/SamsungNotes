package androidx.compose.foundation;

import androidx.compose.foundation.MarqueeSpacing;
import androidx.compose.p109ui.unit.Density;

/* JADX INFO: renamed from: androidx.compose.foundation.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C0827a implements MarqueeSpacing {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1009a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ float f1010b;

    public /* synthetic */ C0827a(float f, int i) {
        this.f1009a = i;
        this.f1010b = f;
    }

    @Override // androidx.compose.foundation.MarqueeSpacing
    public final int calculateSpacing(Density density, int i, int i2) {
        switch (this.f1009a) {
            case 0:
                return BasicMarqueeKt.MarqueeSpacing_0680j_4$lambda$1(this.f1010b, density, i, i2);
            default:
                return MarqueeSpacing.Companion.fractionOfContainer$lambda$0(this.f1010b, density, i, i2);
        }
    }
}
