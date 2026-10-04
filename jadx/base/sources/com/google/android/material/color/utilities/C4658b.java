package com.google.android.material.color.utilities;

import java.util.function.Function;

/* JADX INFO: renamed from: com.google.android.material.color.utilities.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C4658b implements Function {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f2296a;

    public /* synthetic */ C4658b(int i) {
        this.f2296a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        DynamicScheme dynamicScheme = (DynamicScheme) obj;
        switch (this.f2296a) {
            case 0:
                return MaterialDynamicColors.lambda$onPrimaryFixed$110(dynamicScheme);
            case 1:
                return dynamicScheme.errorPalette;
            case 2:
                return dynamicScheme.neutralPalette;
            case 3:
                return MaterialDynamicColors.lambda$error$92(dynamicScheme);
            case 4:
                return dynamicScheme.neutralPalette;
            case 5:
                return MaterialDynamicColors.lambda$textPrimaryInverse$153(dynamicScheme);
            case 6:
                return dynamicScheme.neutralPalette;
            case 7:
                return MaterialDynamicColors.lambda$surfaceContainer$26(dynamicScheme);
            case 8:
                return dynamicScheme.neutralVariantPalette;
            case 9:
                return MaterialDynamicColors.lambda$onSurfaceVariant$36(dynamicScheme);
            case 10:
                return dynamicScheme.neutralPalette;
            case 11:
                return MaterialDynamicColors.lambda$inverseSurface$38(dynamicScheme);
            case 12:
                return MaterialDynamicColors.lambda$surfaceDim$18(dynamicScheme);
            case 13:
                return dynamicScheme.errorPalette;
            case 14:
                return MaterialDynamicColors.lambda$onErrorContainer$101(dynamicScheme);
            case 15:
                return dynamicScheme.neutralVariantPalette;
            case 16:
                return MaterialDynamicColors.lambda$textSecondaryAndTertiaryInverse$155(dynamicScheme);
            case 17:
                return dynamicScheme.errorPalette;
            case 18:
                return MaterialDynamicColors.lambda$errorContainer$98(dynamicScheme);
            case 19:
                return dynamicScheme.tertiaryPalette;
            case 20:
                return MaterialDynamicColors.lambda$tertiaryFixed$132(dynamicScheme);
            case 21:
                return dynamicScheme.neutralVariantPalette;
            case 22:
                return dynamicScheme.primaryPalette;
            case 23:
                return MaterialDynamicColors.lambda$primary$53(dynamicScheme);
            case 24:
                return dynamicScheme.neutralPalette;
            case 25:
                return MaterialDynamicColors.lambda$scrim$49(dynamicScheme);
            case 26:
                return dynamicScheme.secondaryPalette;
            case 27:
                return MaterialDynamicColors.lambda$onSecondaryFixedVariant$128(dynamicScheme);
            case 28:
                return MaterialDynamicColors.lambda$controlNormal$148(dynamicScheme);
            default:
                return dynamicScheme.tertiaryPalette;
        }
    }
}
