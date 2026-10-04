package com.samsung.android.sdk.pen.ocr;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SpenOcrModelLoaderForLocalAssetFile extends SpenOcrModelLoaderBase {
    private static final String ASSETS_MODEL_BLOCK_ANALYZER_DIRECTORY = "models/blockanalyzer";
    private static final String ASSETS_MODEL_BLOCK_ANALYZER_FILE_NAME = "ba";
    private static final String ASSETS_MODEL_STANDARD_DIRECTORY = "models";
    private static final String FILES_MODEL_STANDARD_DIRECTORY = "ocr";
    private static final String TAG = "LoaderForLocalAssetFile";
    private static final List<String> mSupportedLanguages = Arrays.asList(SpenOcrLanguage.ENGLISH.toLanguageCode(), SpenOcrLanguage.KOREAN.toLanguageCode(), SpenOcrLanguage.GERMAN.toLanguageCode(), SpenOcrLanguage.SPANISH.toLanguageCode(), SpenOcrLanguage.FRENCH.toLanguageCode(), SpenOcrLanguage.ITALIAN.toLanguageCode(), SpenOcrLanguage.PORTUGUESE.toLanguageCode(), SpenOcrLanguage.CHINESE.toLanguageCode());
    private String blockAnalyzerDBPath;

    public SpenOcrModelLoaderForLocalAssetFile(Context context, SpenIOcrModelManager spenIOcrModelManager) {
        super(context, spenIOcrModelManager);
        this.blockAnalyzerDBPath = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0056 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0051 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean copyFile(AssetManager assetManager, String str, String str2) throws Throwable {
        FileOutputStream fileOutputStream;
        IOException e;
        InputStream inputStreamOpen;
        InputStream inputStream = null;
        try {
            inputStreamOpen = assetManager.open(str);
            try {
                fileOutputStream = new FileOutputStream(new File(str2));
                try {
                    try {
                        copyFile(inputStreamOpen, fileOutputStream);
                        if (inputStreamOpen != null) {
                            try {
                                inputStreamOpen.close();
                            } catch (IOException unused) {
                            }
                        }
                        try {
                            fileOutputStream.close();
                            return true;
                        } catch (IOException unused2) {
                            return true;
                        }
                    } catch (IOException e2) {
                        e = e2;
                        Log.e(TAG, "SPenMathResourceExtractor::copyFile() Failed to copy asset file: " + str, e);
                        if (inputStreamOpen != null) {
                            try {
                                inputStreamOpen.close();
                            } catch (IOException unused3) {
                            }
                        }
                        if (fileOutputStream == null) {
                            return false;
                        }
                        try {
                            fileOutputStream.close();
                            return false;
                        } catch (IOException unused4) {
                            return false;
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    inputStream = inputStreamOpen;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused5) {
                        }
                    }
                    if (fileOutputStream == null) {
                        throw th;
                    }
                    try {
                        fileOutputStream.close();
                        throw th;
                    } catch (IOException unused6) {
                        throw th;
                    }
                }
            } catch (IOException e3) {
                e = e3;
                fileOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
                inputStream = inputStreamOpen;
                if (inputStream != null) {
                }
                if (fileOutputStream == null) {
                }
            }
        } catch (IOException e5) {
            fileOutputStream = null;
            e = e5;
            inputStreamOpen = null;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            if (inputStream != null) {
            }
            if (fileOutputStream == null) {
            }
        }
    }

    private String createBlockAnalyzerDbPath() {
        String[] list;
        String str = this.blockAnalyzerDBPath;
        if (str != null) {
            return str;
        }
        AssetManager assets = this.mContext.getAssets();
        try {
            list = assets.list(ASSETS_MODEL_BLOCK_ANALYZER_DIRECTORY);
        } catch (IOException e) {
            Log.e(TAG, "SpenOcrEngine::createBlockAnalyzerDbPath() Failed to get asset file list.", e);
            list = null;
        }
        if (list == null) {
            Log.e(TAG, "SpenOcrEngine::createBlockAnalyzerDbPath() files == null");
            return null;
        }
        String modelDir = getModelDir();
        this.blockAnalyzerDBPath = modelDir;
        if (modelDir == null) {
            Log.e(TAG, "SpenOcrEngine::createBlockAnalyzerDbPath() dstDir == null");
            return null;
        }
        int length = list.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            String str2 = list[i];
            if (str2.contains("ba")) {
                Log.d(TAG, "SpenOcrEngine::createBlockAnalyzerDbPath() file : ".concat(str2));
                this.blockAnalyzerDBPath = AbstractC2322a.m1626p(new StringBuilder(), this.blockAnalyzerDBPath, "/", str2);
                if (copyFile(assets, "models/blockanalyzer/".concat(str2), this.blockAnalyzerDBPath)) {
                    return this.blockAnalyzerDBPath;
                }
            } else {
                i++;
            }
        }
        return null;
    }

    private String getAssetDBFilePath(AssetManager assetManager, String str, SpenDBType spenDBType) {
        if (assetManager == null) {
            Log.e(TAG, "getAssetDBFilePath : AssetManager is null!");
            return "";
        }
        if (spenDBType.equals(SpenDBType.MoireDetector)) {
            return "moire.tflite";
        }
        if (spenDBType.equals(SpenDBType.BlockAnalyzer)) {
            StringBuilder sb = new StringBuilder(ASSETS_MODEL_STANDARD_DIRECTORY);
            String str2 = File.separator;
            return AbstractC0541b.m776r(sb, str2, SpenOcrDataProviderContract.ASSETS_MODEL_DIR_BLOCK_ANALYZER, str2, "ba.dat");
        }
        try {
            String[] list = assetManager.list(ASSETS_MODEL_STANDARD_DIRECTORY + File.separator + str);
            if (list != null) {
                for (String str3 : list) {
                    if (str3.contains(str)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(ASSETS_MODEL_STANDARD_DIRECTORY);
                        String str4 = File.separator;
                        sb2.append(str4);
                        sb2.append(str);
                        sb2.append(str4);
                        sb2.append(str3);
                        return sb2.toString();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    private String getModelDir() {
        File filesDir = this.mContext.getFilesDir();
        File file = new File(filesDir, FILES_MODEL_STANDARD_DIRECTORY);
        if (!file.exists()) {
            try {
                file.mkdir();
            } catch (Exception e) {
                Log.e(TAG, "SpenOcrEngine::getModelDir() mkdir failed.", e);
                return null;
            }
        }
        return AbstractC11014a.m12320e(filesDir, "/ocr");
    }

    @Override // com.samsung.android.sdk.pen.ocr.SpenIOcrModelLoader
    public String getCachedDBFilePath(Context context, String str, String str2, SpenDBType spenDBType) {
        AssetManager assets = context.getAssets();
        String assetDBFilePath = getAssetDBFilePath(assets, str2, spenDBType);
        AbstractC6670b.m4756q("getCachedDBFilePath : path = ", assetDBFilePath, TAG);
        try {
            InputStream inputStreamOpen = assets.open(assetDBFilePath);
            try {
                byte[] bArr = new byte[inputStreamOpen.available()];
                int i = inputStreamOpen.read(bArr);
                inputStreamOpen.close();
                if (i > 0) {
                    String cachedFilePath = SpenOcrDataProviderHelper.getCachedFilePath(context, str, str2, spenDBType, bArr);
                    inputStreamOpen.close();
                    return cachedFilePath;
                }
                Log.e(TAG, "There is nothing to read from asset DB File path");
                inputStreamOpen.close();
                return "";
            } finally {
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.samsung.android.sdk.pen.ocr.SpenOcrModelLoaderBase, com.samsung.android.sdk.pen.ocr.SpenIOcrModelLoader
    public boolean loadCommonDB() {
        String strCreateBlockAnalyzerDbPath = createBlockAnalyzerDbPath();
        if (strCreateBlockAnalyzerDbPath != null) {
            return loadDBby(strCreateBlockAnalyzerDbPath, "common", SpenDBType.BlockAnalyzer);
        }
        Log.e(TAG, "loadCommonDB() Failed to get db Path");
        return false;
    }

    @Override // com.samsung.android.sdk.pen.ocr.SpenOcrModelLoaderBase
    public boolean loadOcrModel(String str, SpenDBType spenDBType) throws Throwable {
        String[] list;
        boolean zCopyFile;
        String strM772n = AbstractC0541b.m772n("models/", str);
        AssetManager assets = this.mContext.getAssets();
        try {
            list = assets.list(strM772n);
        } catch (IOException e) {
            Log.e(TAG, "loadLanguageDB Failed to get asset file list.", e);
            list = null;
        }
        if (list == null) {
            Log.e(TAG, "loadLanguageDB files == null");
            return false;
        }
        String modelDir = getModelDir();
        if (modelDir == null) {
            Log.e(TAG, "loadLanguageDB dstDir == null");
            return false;
        }
        int length = list.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                zCopyFile = false;
                break;
            }
            String str2 = list[i];
            if (str2.contains(str)) {
                Log.d(TAG, "loadLanguageDB file : ".concat(str2));
                String str3 = modelDir + "/" + str2;
                zCopyFile = copyFile(assets, AbstractC0541b.m757C(strM772n, "/", str2), str3);
                modelDir = str3;
                break;
            }
            i++;
        }
        if (zCopyFile) {
            return loadDBby(modelDir, str, spenDBType);
        }
        AbstractC2322a.m1636z("loadLanguageModel() Fail to prepare language File DB: ", str, TAG);
        return false;
    }

    @Override // com.samsung.android.sdk.pen.ocr.SpenIOcrModelLoader
    public void releaseCachedDBFilePath(Context context, String str) {
        SpenOcrDataProviderHelper.releaseCachedDBFilePath(context, str);
    }

    @Override // com.samsung.android.sdk.pen.ocr.SpenOcrModelLoaderBase
    public List<String> supportedLanguages() {
        return mSupportedLanguages;
    }

    private void copyFile(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[1024];
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                return;
            } else {
                outputStream.write(bArr, 0, i);
            }
        }
    }
}
