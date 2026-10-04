package com.samsung.android.sdk.ocr;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class RecognizerParams {
    public Context context;
    public OCRLanguage language;
    public OCRType ocrType;

    public RecognizerParams(Context context, OCRType oCRType, OCRLanguage oCRLanguage) {
        this.context = context;
        this.ocrType = oCRType;
        this.language = oCRLanguage;
    }
}
