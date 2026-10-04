package com.samsung.android.sdk.pen.ocr;

import android.content.Context;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public interface SpenIOcrModelLoader {
    void close();

    String getCachedDBFilePath(Context context, String str, String str2, SpenDBType spenDBType);

    List<String> getSupportedLanguages();

    boolean loadCommonDB();

    boolean loadLanguageDB(String str);

    void releaseCachedDBFilePath(Context context, String str);
}
