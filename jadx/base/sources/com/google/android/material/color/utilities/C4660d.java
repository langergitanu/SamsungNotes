package com.google.android.material.color.utilities;

import java.util.function.Function;

/* JADX INFO: renamed from: com.google.android.material.color.utilities.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C4660d implements Function {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f2298a;

    public /* synthetic */ C4660d(int i) {
        this.f2298a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        DynamicScheme dynamicScheme = (DynamicScheme) obj;
        switch (this.f2298a) {
            case 0:
                return MaterialDynamicColors.lambda$onBackground$13(dynamicScheme);
            case 1:
                return dynamicScheme.tertiaryPalette;
            case 2:
                return dynamicScheme.neutralVariantPalette;
            case 3:
                return MaterialDynamicColors.lambda$outlineVariant$45(dynamicScheme);
            case 4:
                return dynamicScheme.neutralPalette;
            case 5:
                return MaterialDynamicColors.lambda$surfaceBright$20(dynamicScheme);
            case 6:
                return dynamicScheme.primaryPalette;
            case 7:
                return MaterialDynamicColors.lambda$onPrimary$56(dynamicScheme);
            case 8:
                return dynamicScheme.primaryPalette;
            case 9:
                return MaterialDynamicColors.lambda$inversePrimary$65(dynamicScheme);
            case 10:
                return MaterialDynamicColors.lambda$onTertiary$83(dynamicScheme);
            case 11:
                return dynamicScheme.secondaryPalette;
            case 12:
                return MaterialDynamicColors.lambda$secondaryFixed$118(dynamicScheme);
            case 13:
                return dynamicScheme.primaryPalette;
            case 14:
                return MaterialDynamicColors.lambda$onPrimaryFixedVariant$114(dynamicScheme);
            case 15:
                return dynamicScheme.tertiaryPalette;
            case 16:
                return MaterialDynamicColors.lambda$tertiaryFixedDim$135(dynamicScheme);
            case 17:
                return dynamicScheme.errorPalette;
            case 18:
                return MaterialDynamicColors.lambda$onError$95(dynamicScheme);
            case 19:
                return dynamicScheme.neutralPalette;
            case 20:
                return MaterialDynamicColors.lambda$textPrimaryInverseDisableOnly$157(dynamicScheme);
            case 21:
                return dynamicScheme.primaryPalette;
            case 22:
                return dynamicScheme.secondaryPalette;
            case 23:
                return MaterialDynamicColors.lambda$secondaryFixedDim$121(dynamicScheme);
            case 24:
                return dynamicScheme.neutralPalette;
            case 25:
                return dynamicScheme.neutralVariantPalette;
            case 26:
                return MaterialDynamicColors.lambda$surfaceVariant$34(dynamicScheme);
            case 27:
                return dynamicScheme.neutralVariantPalette;
            case 28:
                return MaterialDynamicColors.lambda$neutralVariantPaletteKeyColor$9(dynamicScheme);
            default:
                return dynamicScheme.neutralPalette;
        }
    }
}
