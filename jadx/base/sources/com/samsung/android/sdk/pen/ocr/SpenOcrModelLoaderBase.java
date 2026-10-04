package com.samsung.android.sdk.pen.ocr;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.util.Log;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class SpenOcrModelLoaderBase implements SpenIOcrModelLoader {
    private static final String TAG = "LoaderBase";
    protected final Context mContext;
    protected SpenIOcrModelManager mModelManager;

    public SpenOcrModelLoaderBase(Context context, SpenIOcrModelManager spenIOcrModelManager) {
        this.mContext = context;
        this.mModelManager = spenIOcrModelManager;
    }

    private Object[] getFileDescriptor(AssetFileDescriptor assetFileDescriptor, String str, SpenDBType spenDBType) {
        return getFileDescriptorTuple(assetFileDescriptor);
    }

    private synchronized boolean loadLanguageModel(String str) {
        List<String> listSupportedLanguages = supportedLanguages();
        if (listSupportedLanguages != null && listSupportedLanguages.size() != 0) {
            if (!SpenOcrLanguage.AUTO.toLanguageCode().equals(str)) {
                if (listSupportedLanguages.contains(str)) {
                    return loadOcrModel(str, SpenDBType.OCR);
                }
                Log.e(TAG, "loadLanguageModel() not supported language : " + str);
                return false;
            }
            for (String str2 : listSupportedLanguages) {
                if (!loadOcrModel(str2, SpenDBType.OCR)) {
                    Log.e(TAG, "loadLanguageModel() fail to loadOcrModel(" + str2 + ")");
                    return false;
                }
            }
            Log.i(TAG, "loadLanguageModel() all languages are loaded!");
            return true;
        }
        Log.e(TAG, "loadLanguageModel() there is no supported languages");
        return false;
    }

    @Override // com.samsung.android.sdk.pen.ocr.SpenIOcrModelLoader
    public void close() {
    }

    public Object[] getFileDescriptorTuple(AssetFileDescriptor assetFileDescriptor) {
        return new Object[]{assetFileDescriptor.getFileDescriptor(), Long.valueOf(assetFileDescriptor.getStartOffset()), Long.valueOf(assetFileDescriptor.getLength())};
    }

    @Override // com.samsung.android.sdk.pen.ocr.SpenIOcrModelLoader
    public List<String> getSupportedLanguages() {
        return supportedLanguages();
    }

    @Override // com.samsung.android.sdk.pen.ocr.SpenIOcrModelLoader
    public boolean loadCommonDB() {
        return loadOcrModel(SpenOcrDataProviderContract.ASSETS_MODEL_BLOCK_ANALYZER, SpenDBType.BlockAnalyzer);
    }

    public synchronized boolean loadDBby(String str, String str2, SpenDBType spenDBType) {
        if (this.mModelManager.loadDB(this.mContext, str, new SpenDBConfig(spenDBType, str2)) >= 0) {
            return true;
        }
        Log.e(TAG, "loadDBby(String filePath, ...) Fail to load");
        return false;
    }

    @Override // com.samsung.android.sdk.pen.ocr.SpenIOcrModelLoader
    public boolean loadLanguageDB(String str) {
        return loadLanguageModel(str);
    }

    public synchronized boolean loadOcrModel(String str, SpenDBType spenDBType) {
        try {
            AssetFileDescriptor assetFileDescriptor = SpenOcrDataProviderHelper.getAssetFileDescriptor(this.mContext, str, spenDBType);
            try {
                if (assetFileDescriptor == null) {
                    Log.e(TAG, "AssetFileDescriptor is null!");
                    if (assetFileDescriptor != null) {
                        assetFileDescriptor.close();
                    }
                    return false;
                }
                Object[] fileDescriptor = getFileDescriptor(assetFileDescriptor, str, spenDBType);
                if (SpenOcrDataProviderContract.ASSETS_MODEL_BLOCK_ANALYZER.equals(str)) {
                    str = "common";
                }
                boolean zLoadDBby = loadDBby(fileDescriptor, str, spenDBType);
                assetFileDescriptor.close();
                return zLoadDBby;
            } catch (Throwable th) {
                if (assetFileDescriptor != null) {
                    try {
                        assetFileDescriptor.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (IOException e) {
            Log.e(TAG, e.getLocalizedMessage());
            return false;
        }
    }

    public abstract List<String> supportedLanguages();

    private synchronized boolean loadDBby(Object[] objArr, String str, SpenDBType spenDBType) {
        if (this.mModelManager.loadDB(this.mContext, objArr, new SpenDBConfig(spenDBType, str)) < 0) {
            Log.e(TAG, "loadDBby(Object[] fileDescriptor, ...) Fail to load");
            return false;
        }
        Log.e(TAG, "loadDBby(Object[] fileDescriptor, ...) success to load : " + str);
        return true;
    }
}
