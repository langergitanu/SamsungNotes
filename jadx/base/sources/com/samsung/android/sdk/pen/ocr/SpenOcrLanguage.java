package com.samsung.android.sdk.pen.ocr;

import com.samsung.android.sdk.ocr.OCRLanguage;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.directwrite.constants.DirectWriteConstant;
import kotlinx.coroutines.DebugKt;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public enum SpenOcrLanguage {
    AUTO(OCRLanguage.AUTO, DebugKt.DEBUG_PROPERTY_VALUE_AUTO),
    ENGLISH(OCRLanguage.ENGLISH, DirectWriteConstant.DEFAULT_RECOGNITION_LANGUAGE),
    FRENCH(OCRLanguage.FRENCH, "fr_FR"),
    GERMAN(OCRLanguage.GERMAN, "de_DE"),
    ITALIAN(OCRLanguage.ITALIAN, "it_IT"),
    SPANISH(OCRLanguage.SPANISH, "es_ES"),
    KOREAN(OCRLanguage.KOREAN, "ko_KR"),
    PORTUGUESE(OCRLanguage.PORTUGUESE, "pt_PT"),
    CHINESE(OCRLanguage.CHINESE, "zh_CN");

    private final String languageCode;
    private final OCRLanguage ocrLanguage;

    SpenOcrLanguage(OCRLanguage oCRLanguage, String str) {
        this.ocrLanguage = oCRLanguage;
        this.languageCode = str;
    }

    public static SpenOcrLanguage from(OCRLanguage oCRLanguage) {
        for (SpenOcrLanguage spenOcrLanguage : values()) {
            if (oCRLanguage == spenOcrLanguage.toOCRLanguage()) {
                return spenOcrLanguage;
            }
        }
        return ENGLISH;
    }

    public String toLanguageCode() {
        return this.languageCode;
    }

    public OCRLanguage toOCRLanguage() {
        return this.ocrLanguage;
    }
}
