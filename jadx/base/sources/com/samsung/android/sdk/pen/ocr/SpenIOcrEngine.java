package com.samsung.android.sdk.pen.ocr;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public interface SpenIOcrEngine {
    void close();

    SpenIOcrRecognizer createRecognizer();

    SpenITypeClassifier createTypeClassifier();

    String getCachedDBFilePath(Context context, String str, String str2, SpenDBType spenDBType);

    boolean isSupportedLanguage(SpenOcrLanguage spenOcrLanguage);

    boolean loadLanguageDB(String str);

    void releaseCachedDBFilePath(Context context, String str);
}
