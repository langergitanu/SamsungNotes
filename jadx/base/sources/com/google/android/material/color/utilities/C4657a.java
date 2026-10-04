package com.google.android.material.color.utilities;

import java.util.function.Function;

/* JADX INFO: renamed from: com.google.android.material.color.utilities.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C4657a implements Function {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f2294a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ MaterialDynamicColors f2295b;

    public /* synthetic */ C4657a(MaterialDynamicColors materialDynamicColors, int i) {
        this.f2294a = i;
        this.f2295b = materialDynamicColors;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f2294a) {
            case 0:
                return this.f2295b.lambda$onSecondary$72((DynamicScheme) obj);
            case 1:
                return this.f2295b.lambda$secondary$69((DynamicScheme) obj);
            case 2:
                return this.f2295b.lambda$onSecondaryFixed$125((DynamicScheme) obj);
            case 3:
                return this.f2295b.lambda$onSecondaryFixed$126((DynamicScheme) obj);
            case 4:
                return this.f2295b.lambda$inverseOnSurface$41((DynamicScheme) obj);
            case 5:
                return this.f2295b.lambda$onTertiaryContainer$89((DynamicScheme) obj);
            case 6:
                return this.f2295b.lambda$onTertiaryContainer$90((DynamicScheme) obj);
            case 7:
                return this.f2295b.lambda$onSecondaryContainer$77((DynamicScheme) obj);
            case 8:
                return this.f2295b.lambda$onSecondaryContainer$78((DynamicScheme) obj);
            case 9:
                return this.f2295b.lambda$onPrimaryFixed$111((DynamicScheme) obj);
            case 10:
                return this.f2295b.lambda$onPrimaryFixed$112((DynamicScheme) obj);
            case 11:
                return this.f2295b.lambda$error$93((DynamicScheme) obj);
            case 12:
                return this.f2295b.lambda$onErrorContainer$102((DynamicScheme) obj);
            case 13:
                return this.f2295b.lambda$errorContainer$99((DynamicScheme) obj);
            case 14:
                return this.f2295b.lambda$tertiaryFixed$133((DynamicScheme) obj);
            case 15:
                return this.f2295b.lambda$primary$54((DynamicScheme) obj);
            case 16:
                return this.f2295b.lambda$onSecondaryFixedVariant$129((DynamicScheme) obj);
            case 17:
                return this.f2295b.lambda$onSecondaryFixedVariant$130((DynamicScheme) obj);
            case 18:
                return this.f2295b.lambda$tertiary$81((DynamicScheme) obj);
            case 19:
                return this.f2295b.lambda$onTertiaryFixedVariant$143((DynamicScheme) obj);
            case 20:
                return this.f2295b.lambda$onTertiaryFixedVariant$144((DynamicScheme) obj);
            case 21:
                return this.f2295b.lambda$secondaryContainer$75((DynamicScheme) obj);
            case 22:
                return this.f2295b.lambda$onTertiaryFixed$139((DynamicScheme) obj);
            case 23:
                return this.f2295b.lambda$onTertiaryFixed$140((DynamicScheme) obj);
            case 24:
                return this.f2295b.lambda$primaryContainer$60((DynamicScheme) obj);
            case 25:
                return this.f2295b.lambda$onBackground$14((DynamicScheme) obj);
            case 26:
                return this.f2295b.lambda$onPrimary$57((DynamicScheme) obj);
            case 27:
                return this.f2295b.lambda$inversePrimary$66((DynamicScheme) obj);
            case 28:
                return this.f2295b.lambda$secondaryFixed$119((DynamicScheme) obj);
            default:
                return this.f2295b.lambda$onPrimaryFixedVariant$115((DynamicScheme) obj);
        }
    }
}
