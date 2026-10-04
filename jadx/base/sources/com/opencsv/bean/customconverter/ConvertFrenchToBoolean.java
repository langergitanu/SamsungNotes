package com.opencsv.bean.customconverter;

import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ConvertFrenchToBoolean<T, I> extends ConverterLanguageToBoolean<T, I> {
    private static final String VRAI = "vrai";
    private static final String[] TRUE_STRINGS = {VRAI, "oui", "o", "1", VPathDataCmd.RCurveTo};
    private static final String FAUX = "faux";
    private static final String[] FALSE_STRINGS = {FAUX, "non", "n", "0", "f"};

    @Override // com.opencsv.bean.customconverter.ConverterLanguageToBoolean
    public String[] getAllLocalizedFalseValues() {
        return FALSE_STRINGS;
    }

    @Override // com.opencsv.bean.customconverter.ConverterLanguageToBoolean
    public String[] getAllLocalizedTrueValues() {
        return TRUE_STRINGS;
    }

    @Override // com.opencsv.bean.customconverter.ConverterLanguageToBoolean
    public String getLocalizedFalse() {
        return FAUX;
    }

    @Override // com.opencsv.bean.customconverter.ConverterLanguageToBoolean
    public String getLocalizedTrue() {
        return VRAI;
    }
}
