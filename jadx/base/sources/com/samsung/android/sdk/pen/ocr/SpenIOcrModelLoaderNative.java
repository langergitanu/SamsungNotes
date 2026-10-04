package com.samsung.android.sdk.pen.ocr;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public interface SpenIOcrModelLoaderNative {
    void close();

    long nativeHandle();

    void onGetSupportedModelList(List<String> list);

    boolean onLoadRequest(SpenDBConfig spenDBConfig);
}
