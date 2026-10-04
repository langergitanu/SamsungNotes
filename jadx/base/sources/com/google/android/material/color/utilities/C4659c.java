package com.google.android.material.color.utilities;

import java.util.function.Function;

/* JADX INFO: renamed from: com.google.android.material.color.utilities.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C4659c implements Function {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f2297a;

    public /* synthetic */ C4659c(int i) {
        this.f2297a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        DynamicScheme dynamicScheme = (DynamicScheme) obj;
        switch (this.f2297a) {
            case 0:
                return MaterialDynamicColors.lambda$tertiary$80(dynamicScheme);
            case 1:
                return dynamicScheme.primaryPalette;
            case 2:
                return MaterialDynamicColors.lambda$controlActivated$146(dynamicScheme);
            case 3:
                return dynamicScheme.primaryPalette;
            case 4:
                return MaterialDynamicColors.lambda$primaryPaletteKeyColor$1(dynamicScheme);
            case 5:
                return MaterialDynamicColors.lambda$surface$16(dynamicScheme);
            case 6:
                return dynamicScheme.tertiaryPalette;
            case 7:
                return MaterialDynamicColors.lambda$onTertiaryFixedVariant$142(dynamicScheme);
            case 8:
                return dynamicScheme.secondaryPalette;
            case 9:
                return MaterialDynamicColors.lambda$secondaryPaletteKeyColor$3(dynamicScheme);
            case 10:
                return dynamicScheme.neutralPalette;
            case 11:
                return MaterialDynamicColors.lambda$surfaceContainerLow$24(dynamicScheme);
            case 12:
                return dynamicScheme.secondaryPalette;
            case 13:
                return MaterialDynamicColors.lambda$secondaryContainer$74(dynamicScheme);
            case 14:
                return dynamicScheme.neutralPalette;
            case 15:
                return dynamicScheme.tertiaryPalette;
            case 16:
                return MaterialDynamicColors.lambda$onTertiaryFixed$138(dynamicScheme);
            case 17:
                return dynamicScheme.tertiaryPalette;
            case 18:
                return MaterialDynamicColors.lambda$tertiaryPaletteKeyColor$5(dynamicScheme);
            case 19:
                return dynamicScheme.neutralPalette;
            case 20:
                return MaterialDynamicColors.lambda$controlHighlight$150(dynamicScheme);
            case 21:
                return MaterialDynamicColors.lambda$controlHighlight$151(dynamicScheme);
            case 22:
                return MaterialDynamicColors.lambda$textSecondaryAndTertiaryInverseDisabled$159(dynamicScheme);
            case 23:
                return dynamicScheme.primaryPalette;
            case 24:
                return MaterialDynamicColors.lambda$primaryContainer$59(dynamicScheme);
            case 25:
                return dynamicScheme.neutralPalette;
            case 26:
                return MaterialDynamicColors.lambda$background$11(dynamicScheme);
            case 27:
                return dynamicScheme.neutralPalette;
            case 28:
                return MaterialDynamicColors.lambda$surfaceContainerHigh$28(dynamicScheme);
            default:
                return dynamicScheme.neutralPalette;
        }
    }
}
