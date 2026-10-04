package com.samsung.android.ocr;

import android.graphics.Bitmap;
import androidx.compose.animation.core.AnimationKt;
import com.samsung.android.ocr.MOCRConstants;
import com.samsung.android.ocr.MOCRResult;
import com.samsung.android.ocr.stride.Stride;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.remotefunction.RemoteConstant;
import java.util.stream.Stream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class MOCR {
    private static final String TAG = "MOCR";
    public static final String aarVersion = "1.6.7";
    private static MOCRConstants.MOCREngineType engineType;
    private static volatile MOCR mMOCR;
    protected boolean initialized = false;

    static {
        engineType = MOCRConstants.MOCREngineType.None;
        MOCRLog.m5685i("MOCR", "AAR(1.6.7)");
        try {
            System.loadLibrary("Stride.camera.samsung");
            engineType = MOCRConstants.MOCREngineType.Stride;
        } catch (UnsatisfiedLinkError e) {
            MOCRLog.m5684e(TAG, "Unable to load STRIDE library. Either device model not supported or no permission to read system lib.");
            engineType = MOCRConstants.MOCREngineType.None;
            e.printStackTrace();
        }
    }

    public static MOCR getInstance() {
        if (mMOCR == null) {
            synchronized (MOCR.class) {
                try {
                    if (mMOCR == null && engineType == MOCRConstants.MOCREngineType.Stride) {
                        mMOCR = Stride.getInstance();
                        MOCRLog.m5685i(TAG, "Selected STRIDE engine lib version: " + mMOCR.getVersion() + " , aar version: 1.6.7");
                    }
                } finally {
                }
            }
        }
        return mMOCR;
    }

    public static boolean isFeatureSupported(String str, int i, int i2, int i4) {
        String version = mMOCR.getVersion();
        int[] array = Stream.of((Object[]) version.split(RemoteConstant.VERSION_DIVIDE)).mapToInt(new C7212a(0)).toArray();
        int i5 = array[0];
        if (i5 >= i) {
            if (i5 > i) {
                return true;
            }
            int i6 = array[1];
            if (i6 >= i2 && (i6 > i2 || array[2] >= i4)) {
                return true;
            }
        }
        MOCRLog.m5684e(TAG, str + " unavailable for engine version " + version + ". Please update binary.");
        return false;
    }

    public static boolean isOCRSupport() {
        if (engineType == MOCRConstants.MOCREngineType.None) {
            MOCRLog.m5685i(TAG, "OCR Unsupported");
            return false;
        }
        MOCRLog.m5685i(TAG, "OCR Supported : " + engineType + " AAR version: 1.6.7");
        return true;
    }

    public abstract int cvtToLang(int i);

    public abstract void deinit();

    public synchronized void deinitialize() {
        try {
            String str = TAG;
            MOCRLog.m5685i(str, "deinitialize : E");
            if (this.initialized) {
                long jNanoTime = System.nanoTime();
                mMOCR.deinit();
                this.initialized = false;
                MOCRLog.m5685i(str, "deinitialize : X " + ((System.nanoTime() - jNanoTime) / AnimationKt.MillisToNanos) + "ms");
            } else {
                MOCRLog.m5685i(str, "deinitialize : X :: engine was not initialized");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public abstract int detect(byte[] bArr, int i, int i2, MOCRConstants.MOCRPxlFmt mOCRPxlFmt, MOCRResult.Page page);

    public abstract boolean detectText(byte[] bArr, int i, int i2, MOCRConstants.MOCRPxlFmt mOCRPxlFmt);

    public abstract boolean detectText_ARGB(MOCRImage mOCRImage);

    public synchronized boolean detectText_ARGB_bmp(Bitmap bitmap) {
        boolean zDetectText_ARGB;
        MOCRImage mOCRImageFromBitmap;
        try {
            String str = TAG;
            MOCRLog.m5685i(str, "detectText : E" + engineType.toString());
            MOCRLog.m5685i(str, "Image Wd/Ht = " + bitmap.getWidth() + " / " + bitmap.getHeight());
            long jNanoTime = System.nanoTime();
            zDetectText_ARGB = (!this.initialized || (mOCRImageFromBitmap = MOCRImage.fromBitmap(bitmap)) == null) ? false : mMOCR.detectText_ARGB(mOCRImageFromBitmap);
            MOCRLog.m5685i(str, "detectText : X(" + zDetectText_ARGB + ") " + ((System.nanoTime() - jNanoTime) / AnimationKt.MillisToNanos) + "ms");
        } catch (Throwable th) {
            throw th;
        }
        return zDetectText_ARGB;
    }

    public synchronized boolean detectText_byteArr(byte[] bArr, int i, int i2, MOCRConstants.MOCRPxlFmt mOCRPxlFmt) {
        boolean zDetectText;
        try {
            String str = TAG;
            MOCRLog.m5685i(str, "detectText : E" + engineType.toString());
            MOCRLog.m5685i(str, "Image Wd/Ht = " + i + " / " + i2);
            long jNanoTime = System.nanoTime();
            zDetectText = this.initialized ? mMOCR.detectText(bArr, i, i2, mOCRPxlFmt) : false;
            MOCRLog.m5685i(str, "detectText : X(" + zDetectText + ") " + ((System.nanoTime() - jNanoTime) / AnimationKt.MillisToNanos) + "ms");
        } catch (Throwable th) {
            throw th;
        }
        return zDetectText;
    }

    public abstract int detect_ARGB(MOCRImage mOCRImage, MOCRResult.Page page);

    public int detect_ARGB_bmp(Bitmap bitmap, MOCRResult.Page page) {
        String str = TAG;
        MOCRLog.m5685i(str, "detect : E" + engineType.toString());
        long jNanoTime = System.nanoTime();
        int value = MOCRConstants.MOCRStatus.MOCRModelNotInitError.getValue();
        synchronized (MOCR.class) {
            try {
                if (this.initialized) {
                    MOCRImage mOCRImageFromBitmap = MOCRImage.fromBitmap(bitmap);
                    value = mOCRImageFromBitmap == null ? MOCRConstants.MOCRStatus.MOCRUnsupportedFormat.getValue() : mMOCR.detect_ARGB(mOCRImageFromBitmap, page);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        MOCRLog.m5685i(str, "detect : X(" + value + ") " + ((System.nanoTime() - jNanoTime) / AnimationKt.MillisToNanos) + "ms");
        return value;
    }

    public int detect_byteArr(byte[] bArr, int i, int i2, MOCRConstants.MOCRPxlFmt mOCRPxlFmt, MOCRResult.Page page) {
        String str = TAG;
        MOCRLog.m5685i(str, "detect : E" + engineType.toString());
        long jNanoTime = System.nanoTime();
        int value = MOCRConstants.MOCRStatus.MOCRModelNotInitError.getValue();
        synchronized (MOCR.class) {
            try {
                if (this.initialized) {
                    value = mMOCR.detect(bArr, i, i2, mOCRPxlFmt, page);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        MOCRLog.m5685i(str, "detect : X(" + value + ") " + ((System.nanoTime() - jNanoTime) / AnimationKt.MillisToNanos) + "ms");
        return value;
    }

    public abstract String getBuildType();

    public int getMOCREngineType() {
        return engineType.getValue();
    }

    public abstract String getVersion();

    public abstract int init();

    public abstract int init(int i);

    public abstract int init(String str);

    public abstract int init(String str, int i);

    public synchronized int initialize(int i) {
        int iInit;
        try {
            String str = TAG;
            MOCRLog.m5685i(str, "initialize : E");
            long jNanoTime = System.nanoTime();
            if (this.initialized) {
                MOCRLog.m5685i(str, "Engine already initialized!!");
                iInit = MOCRConstants.MOCRStatus.MOCRActiveEngineError.getValue();
            } else {
                iInit = mMOCR.init(cvtToLang(i));
                if (iInit == MOCRConstants.MOCRStatus.MOCRSuccess.getValue()) {
                    this.initialized = true;
                }
            }
            MOCRLog.m5685i(str, "initialize : X(" + iInit + ") " + ((System.nanoTime() - jNanoTime) / AnimationKt.MillisToNanos) + "ms");
        } catch (Throwable th) {
            throw th;
        }
        return iInit;
    }

    public synchronized int process(byte[] bArr, int i, int i2, MOCRConstants.MOCRPxlFmt mOCRPxlFmt, MOCRResult.Page page) {
        int value;
        try {
            String str = TAG;
            MOCRLog.m5685i(str, "process : E" + engineType.toString());
            MOCRLog.m5685i(str, "Image Wd/Ht = " + i + " / " + i2);
            long jNanoTime = System.nanoTime();
            value = MOCRConstants.MOCRStatus.MOCRModelNotInitError.getValue();
            if (this.initialized) {
                value = mMOCR.run(bArr, i, i2, mOCRPxlFmt, page);
            }
            MOCRLog.m5685i(str, "process : X(" + value + ") " + ((System.nanoTime() - jNanoTime) / AnimationKt.MillisToNanos) + "ms");
        } catch (Throwable th) {
            throw th;
        }
        return value;
    }

    public synchronized int process_ARGB_bmp(Bitmap bitmap, MOCRResult.Page page) {
        int value;
        try {
            String str = TAG;
            MOCRLog.m5685i(str, "process : E" + engineType.toString());
            MOCRLog.m5685i(str, "Image Wd/Ht = " + bitmap.getWidth() + " / " + bitmap.getHeight());
            long jNanoTime = System.nanoTime();
            value = MOCRConstants.MOCRStatus.MOCRModelNotInitError.getValue();
            if (this.initialized) {
                MOCRImage mOCRImageFromBitmap = MOCRImage.fromBitmap(bitmap);
                value = mOCRImageFromBitmap == null ? MOCRConstants.MOCRStatus.MOCRUnsupportedFormat.getValue() : mMOCR.run_ARGB(mOCRImageFromBitmap, page);
            }
            MOCRLog.m5685i(str, "process : X(" + value + ") " + ((System.nanoTime() - jNanoTime) / AnimationKt.MillisToNanos) + "ms");
        } catch (Throwable th) {
            throw th;
        }
        return value;
    }

    public abstract int run(byte[] bArr, int i, int i2, MOCRConstants.MOCRPxlFmt mOCRPxlFmt, MOCRResult.Page page);

    public abstract int run_ARGB(MOCRImage mOCRImage, MOCRResult.Page page);

    public abstract void set_options(MOCROptions mOCROptions);

    public static MOCR getInstance(MOCRConstants.MOCREngineType mOCREngineType) {
        engineType = mOCREngineType;
        if (mOCREngineType == MOCRConstants.MOCREngineType.Stride) {
            try {
                System.loadLibrary("Stride.camera.samsung");
            } catch (UnsatisfiedLinkError e) {
                engineType = MOCRConstants.MOCREngineType.None;
                e.printStackTrace();
            }
            mMOCR = Stride.getInstance();
            MOCRLog.m5685i(TAG, "Selected STRIDE engine lib version: " + mMOCR.getVersion() + " , aar version: 1.6.7");
        }
        return mMOCR;
    }

    public synchronized int initialize(String str, int i) {
        int iInit;
        try {
            String str2 = TAG;
            MOCRLog.m5685i(str2, "initialize with modelPath(" + str + ") : E");
            long jNanoTime = System.nanoTime();
            if (this.initialized) {
                MOCRLog.m5685i(str2, "Engine already initialized!!");
                iInit = MOCRConstants.MOCRStatus.MOCRActiveEngineError.getValue();
            } else {
                iInit = mMOCR.init(str, cvtToLang(i));
                if (iInit == MOCRConstants.MOCRStatus.MOCRSuccess.getValue()) {
                    this.initialized = true;
                }
            }
            MOCRLog.m5685i(str2, "initialize with modelPath : X " + ((System.nanoTime() - jNanoTime) / AnimationKt.MillisToNanos) + "ms");
        } catch (Throwable th) {
            throw th;
        }
        return iInit;
    }

    public static MOCR getInstance(MOCROptions mOCROptions) {
        getInstance();
        if (mOCROptions.isForceLang() && !isFeatureSupported("ForceLang_MOCROption", 1, 4, 0)) {
            MOCRLog.m5684e(TAG, "ForceLang Option unavailable for current engine version");
            return mMOCR;
        }
        if (mOCROptions.isRunInverted() && !isFeatureSupported("RunInverted_MOCROption", 1, 5, 14)) {
            MOCRLog.m5684e(TAG, "RunInverted Option unavailable for current engine version");
            return mMOCR;
        }
        if (mOCROptions.getLanguageMode() != MOCRConstants.MOCRLanguageMode.Auto.getValue() && !isFeatureSupported("LanguageMode_MOCROption", 1, 6, 9)) {
            MOCRLog.m5684e(TAG, "LanguageMode Option unavailable for current engine version");
            return mMOCR;
        }
        if (mOCROptions.getImageType() != MOCRConstants.MOCRImageType.Generic.getValue() && !isFeatureSupported("ImageType_MOCROption", 1, 6, 9)) {
            MOCRLog.m5684e(TAG, "ImageType Option unavailable for current engine version");
            return mMOCR;
        }
        mMOCR.set_options(mOCROptions);
        return mMOCR;
    }

    public synchronized int initialize() {
        int iInit;
        try {
            String str = TAG;
            MOCRLog.m5685i(str, "initialize without lang : E");
            long jNanoTime = System.nanoTime();
            if (this.initialized) {
                MOCRLog.m5685i(str, "Engine already initialized!!");
                iInit = MOCRConstants.MOCRStatus.MOCRActiveEngineError.getValue();
            } else {
                iInit = mMOCR.init();
                if (iInit == MOCRConstants.MOCRStatus.MOCRSuccess.getValue()) {
                    this.initialized = true;
                }
            }
            MOCRLog.m5685i(str, "initialize without lang : X(" + iInit + ") " + ((System.nanoTime() - jNanoTime) / AnimationKt.MillisToNanos) + "ms");
        } catch (Throwable th) {
            throw th;
        }
        return iInit;
    }

    public synchronized int initialize(String str) {
        int iInit;
        try {
            String str2 = TAG;
            MOCRLog.m5685i(str2, "initialize without lang with modelPath(" + str + ") : E");
            long jNanoTime = System.nanoTime();
            if (this.initialized) {
                MOCRLog.m5685i(str2, "Engine already initialized!!");
                iInit = MOCRConstants.MOCRStatus.MOCRActiveEngineError.getValue();
            } else {
                iInit = mMOCR.init(str);
                if (iInit == MOCRConstants.MOCRStatus.MOCRSuccess.getValue()) {
                    this.initialized = true;
                }
            }
            MOCRLog.m5685i(str2, "initialize without lang with modelPath : X " + ((System.nanoTime() - jNanoTime) / AnimationKt.MillisToNanos) + "ms");
        } catch (Throwable th) {
            throw th;
        }
        return iInit;
    }
}
