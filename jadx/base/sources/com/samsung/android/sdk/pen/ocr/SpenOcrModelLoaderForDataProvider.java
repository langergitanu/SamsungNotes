package com.samsung.android.sdk.pen.ocr;

import android.content.Context;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SpenOcrModelLoaderForDataProvider extends SpenOcrModelLoaderBase {
    private static final String TAG = "LoaderForDataProvider";

    public SpenOcrModelLoaderForDataProvider(Context context, SpenIOcrModelManager spenIOcrModelManager) {
        super(context, spenIOcrModelManager);
    }

    @Override // com.samsung.android.sdk.pen.ocr.SpenIOcrModelLoader
    public String getCachedDBFilePath(Context context, String str, String str2, SpenDBType spenDBType) {
        return SpenOcrDataProviderHelper.getCachedFilePath(context, str, str2, spenDBType);
    }

    @Override // com.samsung.android.sdk.pen.ocr.SpenIOcrModelLoader
    public void releaseCachedDBFilePath(Context context, String str) {
        SpenOcrDataProviderHelper.releaseCachedDBFilePath(context, str);
    }

    @Override // com.samsung.android.sdk.pen.ocr.SpenOcrModelLoaderBase
    public List<String> supportedLanguages() {
        return SpenOcrDataProviderHelper.getSupportedLanguages(this.mContext);
    }
}
