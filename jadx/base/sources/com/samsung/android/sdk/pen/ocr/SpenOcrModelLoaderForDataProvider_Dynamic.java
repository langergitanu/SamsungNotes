package com.samsung.android.sdk.pen.ocr;

import android.content.Context;
import android.util.Log;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SpenOcrModelLoaderForDataProvider_Dynamic extends SpenOcrModelLoaderBase implements SpenIOcrModelLoaderNative {
    private static final int MAX_DB_NUM = 5;
    private static final String TAG = "LoaderForDataProviderDynamic";
    private long mNativeHandle;
    private final List<String> mSupportedLanguages;

    public SpenOcrModelLoaderForDataProvider_Dynamic(Context context, SpenIOcrModelManager spenIOcrModelManager) {
        super(context, spenIOcrModelManager);
        ArrayList arrayList = new ArrayList();
        this.mSupportedLanguages = arrayList;
        this.mNativeHandle = 0L;
        this.mNativeHandle = Native_createModelLoader(this);
        spenIOcrModelManager.setModelLoader(this);
        spenIOcrModelManager.setMaxDBNumber(5);
        List<String> listSupportedLanguages = supportedLanguages();
        if (listSupportedLanguages == null || listSupportedLanguages.size() == 0) {
            Log.e(TAG, "loadLanguageModel() there is no supported languages");
            return;
        }
        arrayList.addAll(listSupportedLanguages);
        Log.i(TAG, "mSupportedLanguages : " + arrayList);
    }

    public native long Native_createModelLoader(SpenIOcrModelLoaderNative spenIOcrModelLoaderNative);

    public native void Native_finalize(long j);

    @Override // com.samsung.android.sdk.pen.ocr.SpenOcrModelLoaderBase, com.samsung.android.sdk.pen.ocr.SpenIOcrModelLoader
    public void close() {
        if (this.mNativeHandle != 0) {
            this.mModelManager.setModelLoader(null);
            Native_finalize(this.mNativeHandle);
        }
        this.mNativeHandle = 0L;
    }

    public void finalize() throws Throwable {
        super.finalize();
        close();
    }

    @Override // com.samsung.android.sdk.pen.ocr.SpenIOcrModelLoader
    public String getCachedDBFilePath(Context context, String str, String str2, SpenDBType spenDBType) {
        return SpenOcrDataProviderHelper.getCachedFilePath(context, str, str2, spenDBType);
    }

    @Override // com.samsung.android.sdk.pen.ocr.SpenOcrModelLoaderBase, com.samsung.android.sdk.pen.ocr.SpenIOcrModelLoader
    public boolean loadLanguageDB(String str) {
        if (SpenOcrLanguage.AUTO.toLanguageCode().equals(str)) {
            return true;
        }
        return super.loadLanguageDB(str);
    }

    @Override // com.samsung.android.sdk.pen.ocr.SpenIOcrModelLoaderNative
    public long nativeHandle() {
        return this.mNativeHandle;
    }

    @Override // com.samsung.android.sdk.pen.ocr.SpenIOcrModelLoaderNative
    public void onGetSupportedModelList(List<String> list) {
        list.addAll(this.mSupportedLanguages);
        Log.i(TAG, "onGetSupportedModelList: added language list = " + list);
    }

    @Override // com.samsung.android.sdk.pen.ocr.SpenIOcrModelLoaderNative
    public boolean onLoadRequest(SpenDBConfig spenDBConfig) {
        StringBuilder sb = new StringBuilder("onLoadRequest: db type = ");
        sb.append(spenDBConfig.getDBTypeName());
        sb.append(", language = ");
        AbstractC11014a.m12338w(sb, spenDBConfig.getLanguage(), TAG);
        return loadOcrModel(spenDBConfig.getLanguage(), spenDBConfig.getDBType());
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
