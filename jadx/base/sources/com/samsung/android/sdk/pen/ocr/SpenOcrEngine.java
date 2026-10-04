package com.samsung.android.sdk.pen.ocr;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import com.samsung.android.sdk.pen.ocr.SpenLibraryLoader;
import com.samsung.android.sdk.pen.ocr.SpenOcrModelLoaderFactory;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SpenOcrEngine implements SpenIOcrEngine {
    private static final String TAG = "SpenOcrEngine";
    private static boolean mSOCRSupport;
    private SpenIOcrModelLoader mModelLoader;
    protected SpenIOcrModelManager mModelManager;
    private long mNativeHandle;

    public SpenOcrEngine(Context context, SpenOcrModelLoaderFactory.MODEL_LOADER model_loader) {
        this.mModelManager = null;
        this.mModelLoader = null;
        if (!mSOCRSupport) {
            mSOCRSupport = loadOcrLibrary(context);
        }
        long jNative_init = Native_init();
        this.mNativeHandle = jNative_init;
        if (jNative_init == 0) {
            Log.e(TAG, "SpenOcrEngine::SpenOcrEngine() Failed! (mNativeHandle == 0)");
            return;
        }
        Log.i(TAG, "SpenOcrEngine is created! [mNativeHandle : " + Long.toHexString(this.mNativeHandle) + "] [whichModelLoader :" + model_loader + "]");
        SpenOcrModelManager spenOcrModelManager = new SpenOcrModelManager(Native_createModelManager(this.mNativeHandle));
        this.mModelManager = spenOcrModelManager;
        SpenIOcrModelLoader spenIOcrModelLoaderCreateModelLoader = SpenOcrModelLoaderFactory.createModelLoader(context, spenOcrModelManager, model_loader);
        this.mModelLoader = spenIOcrModelLoaderCreateModelLoader;
        spenIOcrModelLoaderCreateModelLoader.loadCommonDB();
    }

    private static boolean isProviderAvailable(Context context) {
        try {
            Log.i(TAG, "OCRDataProvider Version = " + context.getPackageManager().getPackageInfo("com.samsung.android.sdk.ocr", 128).versionName);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            Log.e(TAG, "OCRDataProvider is not found");
            return false;
        } catch (Exception e) {
            Log.e(TAG, e.getLocalizedMessage());
            return false;
        }
    }

    public static boolean isSupported(Context context) {
        if (!isProviderAvailable(context)) {
            Log.w(TAG, "SOCR is not supported: OCR provider does not exist.");
            return false;
        }
        boolean zLoadOcrLibrary = loadOcrLibrary(context);
        mSOCRSupport = zLoadOcrLibrary;
        if (!zLoadOcrLibrary) {
            Log.e(TAG, "SOCR is not supported: so library does not exist.");
        }
        return mSOCRSupport;
    }

    private static boolean loadOcrLibrary(Context context) {
        SpenLibraryLoader.LibType libType = SpenLibraryLoader.LibType.OCR;
        if (SpenLibraryLoader.loadRemoteLibrary(context, libType)) {
            Log.i(TAG, "loadOcrLibrary : Complete to load remote library!");
            return true;
        }
        Log.i(TAG, "loadOcrLibrary : Cannot load remote library, so load local or system library");
        try {
            System.loadLibrary(SpenLibraryLoader.getMainLibName(libType));
            return true;
        } catch (UnsatisfiedLinkError e) {
            Log.e(TAG, "loadOcrLibrary : SOCR is not supported: " + e.getLocalizedMessage());
            return false;
        }
    }

    public native long Native_createModelManager(long j);

    public native long Native_createRecognizer(long j);

    public native long Native_createTypeClassifier(long j);

    public native void Native_finalize(long j);

    public native String Native_getEngineVersion(long j);

    public native long Native_init();

    @Override // com.samsung.android.sdk.pen.ocr.SpenIOcrEngine
    public void close() {
        SpenIOcrModelLoader spenIOcrModelLoader = this.mModelLoader;
        if (spenIOcrModelLoader != null) {
            spenIOcrModelLoader.close();
        }
        SpenIOcrModelManager spenIOcrModelManager = this.mModelManager;
        if (spenIOcrModelManager != null) {
            spenIOcrModelManager.close();
            this.mModelManager = null;
        }
        long j = this.mNativeHandle;
        if (j != 0) {
            Native_finalize(j);
        }
        this.mNativeHandle = 0L;
    }

    @Override // com.samsung.android.sdk.pen.ocr.SpenIOcrEngine
    public SpenIOcrRecognizer createRecognizer() {
        long j = this.mNativeHandle;
        if (j != 0) {
            return new SpenOcrRecognizer(Native_createRecognizer(j));
        }
        Log.e(TAG, "SpenOcrEngine::createRecognizer() Failed! (mNativeHandle == 0)");
        return null;
    }

    @Override // com.samsung.android.sdk.pen.ocr.SpenIOcrEngine
    public SpenITypeClassifier createTypeClassifier() {
        long j = this.mNativeHandle;
        if (j != 0) {
            return new SpenTypeClassifier(Native_createTypeClassifier(j));
        }
        Log.e(TAG, "SpenOcrEngine::createTypeClassifier() Failed! (mNativeHandle == 0)");
        return null;
    }

    public void finalize() throws Throwable {
        super.finalize();
        close();
    }

    @Override // com.samsung.android.sdk.pen.ocr.SpenIOcrEngine
    public String getCachedDBFilePath(Context context, String str, String str2, SpenDBType spenDBType) {
        return this.mModelLoader.getCachedDBFilePath(context, str, str2, spenDBType);
    }

    public String getEngineVersion() {
        long j = this.mNativeHandle;
        if (j != 0) {
            return Native_getEngineVersion(j);
        }
        Log.e(TAG, "SpenOcrEngine::getEngineVersion() Failed! (mNativeHandle == 0)");
        return "";
    }

    @Override // com.samsung.android.sdk.pen.ocr.SpenIOcrEngine
    public boolean isSupportedLanguage(SpenOcrLanguage spenOcrLanguage) {
        if (spenOcrLanguage == SpenOcrLanguage.AUTO) {
            return true;
        }
        return this.mModelLoader.getSupportedLanguages().contains(spenOcrLanguage.toLanguageCode());
    }

    @Override // com.samsung.android.sdk.pen.ocr.SpenIOcrEngine
    public boolean loadLanguageDB(String str) {
        StringBuilder sbM15l = AbstractC0000a.m15l("SpenOcrEngine loadLanguageDB(", str, ") [mNativeHandle : ");
        sbM15l.append(Long.toHexString(this.mNativeHandle));
        sbM15l.append("]");
        Log.i(TAG, sbM15l.toString());
        return this.mModelLoader.loadLanguageDB(str);
    }

    @Override // com.samsung.android.sdk.pen.ocr.SpenIOcrEngine
    public void releaseCachedDBFilePath(Context context, String str) {
        this.mModelLoader.releaseCachedDBFilePath(context, str);
    }

    public SpenOcrEngine() {
        this.mModelManager = null;
        this.mModelLoader = null;
        long jNative_init = Native_init();
        this.mNativeHandle = jNative_init;
        if (jNative_init == 0) {
            Log.e(TAG, "SpenOcrEngine::SpenOcrEngine() Failed! (mNativeHandle == 0)");
        }
    }
}
