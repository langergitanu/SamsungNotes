package com.google.android.material.color.utilities;

import java.util.function.Function;

/* JADX INFO: renamed from: com.google.android.material.color.utilities.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C4661e implements Function {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f2299a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ MaterialDynamicColors f2300b;

    public /* synthetic */ C4661e(MaterialDynamicColors materialDynamicColors, int i) {
        this.f2299a = i;
        this.f2300b = materialDynamicColors;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f2299a) {
            case 0:
                return this.f2300b.lambda$onPrimaryFixedVariant$116((DynamicScheme) obj);
            case 1:
                return this.f2300b.lambda$tertiaryFixedDim$136((DynamicScheme) obj);
            case 2:
                return this.f2300b.lambda$onTertiary$84((DynamicScheme) obj);
            case 3:
                return this.f2300b.lambda$onError$96((DynamicScheme) obj);
            case 4:
                return this.f2300b.lambda$onPrimaryContainer$62((DynamicScheme) obj);
            case 5:
                return this.f2300b.lambda$onPrimaryContainer$63((DynamicScheme) obj);
            case 6:
                return this.f2300b.lambda$secondaryFixedDim$122((DynamicScheme) obj);
            case 7:
                return this.f2300b.lambda$primaryFixed$105((DynamicScheme) obj);
            case 8:
                return this.f2300b.lambda$primaryFixedDim$108((DynamicScheme) obj);
            case 9:
                return this.f2300b.lambda$tertiaryContainer$87((DynamicScheme) obj);
            default:
                return this.f2300b.highestSurface((DynamicScheme) obj);
        }
    }
}
