package com.samsung.android.sdk.pen.ocr;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.Size;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import com.samsung.android.sdk.pen.ocr.SpenLibraryLoader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SpenMoireDetector {
    private static final int MOIRE_DETECTOR_MAX_HEIGHT = 5000;
    private static final int MOIRE_DETECTOR_MAX_WIDTH = 5000;
    private static final int MOIRE_DETECTOR_MIN_HEIGHT = 384;
    private static final int MOIRE_DETECTOR_MIN_WIDTH = 512;
    private static final String TAG = "SpenMoireDetector";
    private Context mContext;
    private long mNativeHandle = 0;

    public SpenMoireDetector(Context context, SpenIOcrEngine spenIOcrEngine) {
        this.mContext = null;
        loadMoireLibrary(context);
        this.mContext = context;
        long jCurrentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        initMoireEngineWithCacheFilePath(spenIOcrEngine);
        Log.i(TAG, String.format("[Moire Detection] [mNativeHandle : %s], Init : %dms", Long.toHexString(this.mNativeHandle), Long.valueOf(SystemClock.currentThreadTimeMillis() - jCurrentThreadTimeMillis)));
    }

    public static void copyAssetFile(Context context, String str, String str2) {
        File file = new File(getDirectoryPath(str) + "/" + str2);
        if (file.exists()) {
            AbstractC4539a.m3208r("Old TF-Model is deleted? ", TAG, file.delete());
        }
        try {
            InputStream inputStreamOpen = context.getAssets().open(str2);
            try {
                byte[] bArr = new byte[inputStreamOpen.available()];
                FileOutputStream fileOutputStream = new FileOutputStream(new File(str + "/" + str2));
                while (true) {
                    try {
                        int i = inputStreamOpen.read(bArr);
                        if (i == -1) {
                            fileOutputStream.close();
                            Log.e(TAG, "New TF-Model is installed.");
                            inputStreamOpen.close();
                            return;
                        }
                        fileOutputStream.write(bArr, 0, i);
                    } finally {
                    }
                }
            } finally {
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static native void deinitMoireEngine(long j);

    public static String getDirectoryPath(String str) {
        String strSubstring = str.substring(0, str.lastIndexOf("/") + 1);
        return strSubstring.substring(strSubstring.length() - 1, strSubstring.length()).equals("/") ? AbstractC2322a.m1614d(1, 0, strSubstring) : strSubstring;
    }

    private boolean hasMoire(Bitmap bitmap) {
        int width;
        int height;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bitmap.getByteCount());
        bitmap.copyPixelsToBuffer(byteBufferAllocate);
        byte[] bArrArray = byteBufferAllocate.array();
        long jCurrentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        boolean z = 1 == processMoireDetection(this.mNativeHandle, bArrArray, bitmap.getWidth(), bitmap.getHeight());
        long jCurrentThreadTimeMillis2 = SystemClock.currentThreadTimeMillis();
        Size imageResolution = getImageResolution(bitmap);
        if (imageResolution != null) {
            width = imageResolution.getWidth();
            height = imageResolution.getHeight();
        } else {
            width = -1;
            height = -1;
        }
        Log.i(TAG, String.format("[Moire Detection] Resolution : %d x %d", Integer.valueOf(width), Integer.valueOf(height)));
        Log.i(TAG, "[Moire Detection] Result     : ".concat(z ? "Positive (Moire)" : "Negative"));
        Log.i(TAG, String.format("[Moire Detection] Processing : %dms", Long.valueOf(jCurrentThreadTimeMillis2 - jCurrentThreadTimeMillis)));
        return z;
    }

    public static native long initMoireEngine(String str);

    private synchronized void initMoireEngineWithCacheFilePath(SpenIOcrEngine spenIOcrEngine) {
        String cachedDBFilePath = spenIOcrEngine.getCachedDBFilePath(this.mContext, "moire_".concat(String.valueOf(UUID.randomUUID().toString().replace(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR, ""))), SpenOcrDataProviderContract.ASSETS_MODEL_MOIRE_DETECTOR, SpenDBType.MoireDetector);
        if (TextUtils.isEmpty(cachedDBFilePath)) {
            Log.e(TAG, "Moire DB path is not valid!");
        } else {
            this.mNativeHandle = initMoireEngine(cachedDBFilePath);
            spenIOcrEngine.releaseCachedDBFilePath(this.mContext, cachedDBFilePath);
        }
    }

    private void loadMoireLibrary(Context context) {
        SpenLibraryLoader.LibType libType = SpenLibraryLoader.LibType.Moire;
        if (SpenLibraryLoader.loadRemoteLibrary(context, libType)) {
            Log.i(TAG, "loadMoireLibrary : Complete to load remote library!");
            return;
        }
        Log.i(TAG, "loadMoireLibrary : Cannot load remote library, so load local or system library");
        try {
            System.loadLibrary(SpenLibraryLoader.getMainLibName(libType));
        } catch (UnsatisfiedLinkError e) {
            Log.e(TAG, "loadMoireLibrary : Moire is not supported: " + e.getLocalizedMessage());
        }
    }

    public static native int processMoireDetection(long j, byte[] bArr, int i, int i2);

    public void close() {
        if (this.mNativeHandle == 0) {
            return;
        }
        long jCurrentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        deinitMoireEngine(this.mNativeHandle);
        long jCurrentThreadTimeMillis2 = SystemClock.currentThreadTimeMillis();
        this.mNativeHandle = 0L;
        Log.i(TAG, String.format("[Moire Detection] Release : %dms", Long.valueOf(jCurrentThreadTimeMillis2 - jCurrentThreadTimeMillis)));
    }

    public boolean detectMoire(Bitmap bitmap) {
        int i;
        int i2;
        int i4 = 0;
        if (this.mNativeHandle == 0 || bitmap == null) {
            Log.e(TAG, "[Moire Detection] detectMoire(Bitmap bitmap) Failed! (mNativeHandle == 0 || bitmap == null)");
            return false;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Log.d(TAG, String.format("[Moire Detection] detectMoire (w[%d] x h[%d])", Integer.valueOf(width), Integer.valueOf(height)));
        if (width < 512 || height < MOIRE_DETECTOR_MIN_HEIGHT) {
            Log.w(TAG, String.format("[Moire Detection] detectMoire(Bitmap bitmap) Skipped! (w[%d] x h[%d] is shorter than the min size.)", Integer.valueOf(width), Integer.valueOf(height)));
            return false;
        }
        if (width > 5000) {
            i2 = (width - 5000) / 2;
            i = 5000;
        } else {
            i = width;
            i2 = 0;
        }
        if (height > 5000) {
            i4 = (height - 5000) / 2;
            height = 5000;
        }
        if (i2 == 0 && i4 == 0) {
            Log.i(TAG, String.format("[Moire Detection] detectMoire (mNativeHandle : [%x])", Long.valueOf(this.mNativeHandle)));
            return hasMoire(bitmap);
        }
        Log.i(TAG, String.format("[Moire Detection] detectMoire with cropped bitmap (mNativeHandle : [%x])", Long.valueOf(this.mNativeHandle)));
        long jCurrentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, i2, i4, i, height);
        Log.d(TAG, String.format("[Moire Detection] Crop time (Bitmap.createBitmap()) %dms", Long.valueOf(SystemClock.currentThreadTimeMillis() - jCurrentThreadTimeMillis)));
        boolean zHasMoire = hasMoire(bitmapCreateBitmap);
        bitmapCreateBitmap.recycle();
        return zHasMoire;
    }

    public void finalize() throws Throwable {
        super.finalize();
        close();
    }

    public Size getImageResolution(Bitmap bitmap) {
        if (bitmap != null) {
            return new Size(bitmap.getWidth(), bitmap.getHeight());
        }
        return null;
    }
}
