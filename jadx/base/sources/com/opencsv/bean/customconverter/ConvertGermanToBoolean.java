package com.opencsv.bean.customconverter;

import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ConvertGermanToBoolean<T, I> extends ConverterLanguageToBoolean<T, I> {
    private static final String WAHR = "wahr";
    private static final String[] TRUE_STRINGS = {WAHR, LangPackConfigConstants.LANGUAGE_CODE_JA, "j", "1", "w"};
    private static final String FALSCH = "falsch";
    private static final String[] FALSE_STRINGS = {FALSCH, "nein", "n", "0", "f"};

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
        return FALSCH;
    }

    @Override // com.opencsv.bean.customconverter.ConverterLanguageToBoolean
    public String getLocalizedTrue() {
        return WAHR;
    }
}
