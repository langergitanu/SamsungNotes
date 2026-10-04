package com.samsung.android.sdk.pen.ocr;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public interface SpenIOcrModelManager {
    void close();

    int findDB(SpenDBConfig spenDBConfig);

    String getDBVersion(int i);

    int loadDB(Context context, String str, SpenDBConfig spenDBConfig);

    int loadDB(Context context, Object[] objArr, SpenDBConfig spenDBConfig);

    void setMaxDBNumber(int i);

    void setModelLoader(SpenIOcrModelLoaderNative spenIOcrModelLoaderNative);

    void unloadAllDB();

    void unloadDB(int i);
}
