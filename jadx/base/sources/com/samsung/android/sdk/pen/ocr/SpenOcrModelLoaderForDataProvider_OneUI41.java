package com.samsung.android.sdk.pen.ocr;

import android.content.Context;
import android.util.Log;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SpenOcrModelLoaderForDataProvider_OneUI41 extends SpenOcrModelLoaderBase {
    private static final String TAG = "LoaderForDataProvider_OneUI41";
    private static final List<String> mSupportedLanguages = Arrays.asList(SpenOcrLanguage.ENGLISH.toLanguageCode(), SpenOcrLanguage.KOREAN.toLanguageCode());

    public SpenOcrModelLoaderForDataProvider_OneUI41(Context context, SpenIOcrModelManager spenIOcrModelManager) {
        super(context, spenIOcrModelManager);
    }

    @Override // com.samsung.android.sdk.pen.ocr.SpenIOcrModelLoader
    public String getCachedDBFilePath(Context context, String str, String str2, SpenDBType spenDBType) {
        Log.w(TAG, "getCachedDBFilePath : Not supported in One UI 4.1");
        return "";
    }

    @Override // com.samsung.android.sdk.pen.ocr.SpenIOcrModelLoader
    public void releaseCachedDBFilePath(Context context, String str) {
        Log.w(TAG, "releaseCachedDBFilePath : Not supported in One UI 4.1");
    }

    @Override // com.samsung.android.sdk.pen.ocr.SpenOcrModelLoaderBase
    public List<String> supportedLanguages() {
        return mSupportedLanguages;
    }
}
