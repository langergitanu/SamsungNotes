package com.samsung.android.sdk.scs.p142ai.image;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SharedMemory;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.microsoft.identity.common.java.WarningType;
import com.samsung.android.scs.p140ai.sdkcommon.image.ImageConst;
import com.samsung.android.sdk.scs.base.feature.Feature;
import com.samsung.android.sdk.scs.base.feature.FeatureStatusCache;
import com.samsung.android.sdk.scs.base.tasks.TaskRunnable;
import com.samsung.android.sdk.scs.base.utils.Log;
import java.nio.ByteBuffer;
import p103Z1.AbstractC0351a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ImageUpscaler {
    private static final int RGBA_CHANNEL = 4;
    private static final int SEP_VERSION_ONEUI_610 = 150100;
    private static final String TAG = "ScsApi@ImageUpscale";
    private final Context mContext;
    private ImageServiceExecutor mImageServiceExecutor;
    private boolean mIsSessionCreated;
    private Bundle mMetaBundle;
    private ByteBuffer mReadBuffer;
    private final Uri mUri = Uri.parse("content://com.samsung.android.scs.ai.image");
    private ByteBuffer mWriteBuffer;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class BindRunnable extends TaskRunnable<Void> {
        public /* synthetic */ BindRunnable(int i) {
            this();
        }

        @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
        public void execute() {
            Log.m6485d(ImageUpscaler.TAG, "Connection Successful");
        }

        @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
        public String getFeatureName() {
            return "FEATURE_IMAGE_UPSCALE";
        }

        private BindRunnable() {
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public ImageUpscaler(@NonNull Context context) {
        this.mContext = context;
        this.mImageServiceExecutor = new ImageServiceExecutor(context);
        this.mImageServiceExecutor.execute(new BindRunnable(0));
    }

    private void clearAllBuffer() {
        this.mWriteBuffer.clear();
        this.mReadBuffer.clear();
        this.mMetaBundle.clear();
    }

    private void configureBuffer(Bitmap bitmap, int i, Rect rect) {
        this.mMetaBundle.putInt(ImageConst.ImageUpscaleConst.KEY_IMAGE_WIDTH, bitmap.getWidth());
        this.mMetaBundle.putInt(ImageConst.ImageUpscaleConst.KEY_IMAGE_HEIGHT, bitmap.getHeight());
        this.mMetaBundle.putInt(ImageConst.ImageUpscaleConst.KEY_IMAGE_SIZE, bitmap.getByteCount());
        this.mMetaBundle.putInt(ImageConst.ImageUpscaleConst.KEY_SCALE_FACTOR, i);
        if (rect != null) {
            this.mMetaBundle.putIntArray(ImageConst.ImageUpscaleConst.KEY_IMAGE_PADDING, new int[]{rect.top, rect.bottom, rect.right, rect.left});
        }
    }

    @SuppressLint({WarningType.NewApi})
    public boolean createSession(int i, String str) {
        Log.m6485d(TAG, " createSession, requested capacity: " + i);
        if (this.mContext == null) {
            Log.m6485d(TAG, "createSession: Context is Null");
            return false;
        }
        int status = FeatureStatusCache.getStatus("FEATURE_IMAGE_UPSCALE");
        if (status == -1000) {
            status = Feature.checkFeature(this.mContext, "FEATURE_IMAGE_UPSCALE");
        }
        if (status != 0) {
            Log.m6485d(TAG, "createSession: Status is not Success : " + status);
            return false;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putInt(ImageConst.ImageUpscaleConst.SHARED_MEM_CAPACITY, i);
            bundle.putString(ImageConst.ImageUpscaleConst.KEY_APPLICATION_ID, this.mContext.getPackageName());
            bundle.putString(ImageConst.ImageUpscaleConst.KEY_ENGINE_TYPE, str);
            Bundle bundleCall = this.mContext.getContentResolver().call(this.mUri, ImageConst.METHOD_UPSCALE_IMAGE, ImageConst.ImageUpscaleConst.ARG_CREATE_SESSION, bundle);
            this.mMetaBundle = new Bundle();
            if (bundleCall == null) {
                Log.m6489i(TAG, "createSession :: Failed to create buffer");
                return false;
            }
            this.mWriteBuffer = AbstractC0351a.m678f(bundleCall.getParcelable(ImageConst.ImageUpscaleConst.SHARED_MEM_READ)).mapReadWrite();
            this.mReadBuffer = AbstractC0351a.m678f(bundleCall.getParcelable(ImageConst.ImageUpscaleConst.SHARED_MEM_WRITE)).mapReadWrite();
            this.mIsSessionCreated = true;
            return true;
        } catch (Exception e) {
            Log.m6488e(TAG, " createSession failed", e);
            e.printStackTrace();
            return false;
        }
    }

    public int detectScene(@NonNull Bitmap bitmap) {
        Log.m6485d(TAG, "detectScene");
        if (this.mContext == null || bitmap == null) {
            Log.m6487e(TAG, " detectScene Error :: Context is null or bitmap is null");
            return -1;
        }
        if (!this.mIsSessionCreated) {
            Log.m6487e(TAG, " detectScene Error :: Call createSession() before calling detectScene");
            return -1;
        }
        try {
            clearAllBuffer();
            configureBuffer(bitmap, -1, null);
            long jCurrentTimeMillis = System.currentTimeMillis();
            bitmap.copyPixelsToBuffer(this.mWriteBuffer);
            Bundle bundleCall = this.mContext.getContentResolver().call(this.mUri, ImageConst.METHOD_UPSCALE_IMAGE, ImageConst.ImageUpscaleConst.ARG_PERFORM_UPSCALE, this.mMetaBundle);
            clearAllBuffer();
            int i = bundleCall.getInt(ImageConst.ImageUpscaleConst.KEY_SCENE_TYPE);
            Log.m6485d(TAG, "detectScene, time taken, scene is " + (System.currentTimeMillis() - jCurrentTimeMillis) + " , " + i);
            return i;
        } catch (Exception e) {
            Log.m6488e(TAG, "Exception :: detectScene", e);
            return -1;
        }
    }

    @SuppressLint({WarningType.NewApi})
    public void endSession() {
        try {
            Bundle bundle = new Bundle();
            bundle.putString(ImageConst.ImageUpscaleConst.KEY_APPLICATION_ID, this.mContext.getPackageName());
            this.mContext.getContentResolver().call(this.mUri, ImageConst.METHOD_UPSCALE_IMAGE, ImageConst.ImageUpscaleConst.ARG_END_SESSION, bundle);
            ByteBuffer byteBuffer = this.mWriteBuffer;
            if (byteBuffer != null) {
                SharedMemory.unmap(byteBuffer);
                this.mWriteBuffer = null;
            }
            ByteBuffer byteBuffer2 = this.mReadBuffer;
            if (byteBuffer2 != null) {
                SharedMemory.unmap(byteBuffer2);
                this.mReadBuffer = null;
            }
            ImageServiceExecutor imageServiceExecutor = this.mImageServiceExecutor;
            if (imageServiceExecutor != null) {
                imageServiceExecutor.deInit();
            }
            Log.m6485d(TAG, " endSession");
        } catch (Exception e) {
            Log.m6488e(TAG, " Exception endSession ", e);
        }
        this.mIsSessionCreated = false;
    }

    public Bitmap upscaleImage(@NonNull Bitmap bitmap, int i, @Nullable Rect rect, int i2) {
        Log.m6485d(TAG, ImageConst.METHOD_UPSCALE_IMAGE + i);
        if (this.mContext == null || bitmap == null) {
            Log.m6487e(TAG, " upscaleImage Error :: Context is null or bitmap is null");
            return null;
        }
        if (!this.mIsSessionCreated) {
            Log.m6487e(TAG, " upscaleImage Error :: Please call createSession() before calling upscaleImage");
            return null;
        }
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            clearAllBuffer();
            configureBuffer(bitmap, i, rect);
            this.mMetaBundle.putInt(ImageConst.ImageUpscaleConst.KEY_SCENE_TYPE, i2);
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            bitmap.copyPixelsToBuffer(this.mWriteBuffer);
            Log.m6485d(TAG, " input copyPixelsToBuffer TIME TAKEN " + (System.currentTimeMillis() - jCurrentTimeMillis2));
            long jCurrentTimeMillis3 = System.currentTimeMillis();
            Bundle bundleCall = this.mContext.getContentResolver().call(this.mUri, ImageConst.METHOD_UPSCALE_IMAGE, ImageConst.ImageUpscaleConst.ARG_PERFORM_UPSCALE, this.mMetaBundle);
            Log.m6485d(TAG, " perform upscale SDK TIME TAKEN " + (System.currentTimeMillis() - jCurrentTimeMillis3));
            clearAllBuffer();
            int i4 = bundleCall.getInt(ImageConst.ImageUpscaleConst.KEY_IMAGE_WIDTH);
            int i5 = bundleCall.getInt(ImageConst.ImageUpscaleConst.KEY_IMAGE_HEIGHT);
            int i6 = bundleCall.getInt(ImageConst.ImageUpscaleConst.KEY_IMAGE_SIZE);
            if (i6 == 0) {
                Log.m6485d(TAG, " received empty buffer");
                return null;
            }
            Log.m6485d(TAG, " received buffer" + i6);
            this.mReadBuffer.limit(i4 * i5 * 4);
            long jCurrentTimeMillis4 = System.currentTimeMillis();
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i4, i5, bitmap.getConfig(), true, bitmap.getColorSpace());
            Log.m6485d(TAG, " create scaled bitmap TIME TAKEN " + (System.currentTimeMillis() - jCurrentTimeMillis4));
            long jCurrentTimeMillis5 = System.currentTimeMillis();
            bitmapCreateBitmap.copyPixelsFromBuffer(this.mReadBuffer);
            if (Build.VERSION.SDK_INT < 34 || Build.VERSION.SEM_PLATFORM_INT < 150100) {
                Log.m6485d(TAG, " Gainmap change SDK version < 34");
            } else {
                try {
                    Log.m6485d(TAG, " GainMap change, SDK above 34 and OneUI6.1 (version doing scale-linear -> crop -> copy gainmap only)");
                    if (!bitmap.hasGainmap()) {
                        Log.m6485d(TAG, " GainMap change: Base bitmap doesn't have GainMap");
                        Log.m6485d(TAG, " output copyPixelsFromBuffer TIME TAKEN " + (System.currentTimeMillis() - jCurrentTimeMillis5));
                        Log.m6485d(TAG, " total time by upscaleImage at SDK " + (System.currentTimeMillis() - jCurrentTimeMillis));
                        return bitmapCreateBitmap;
                    }
                    Log.m6485d(TAG, " GainMap change, bitmap has gain map true");
                    int width = bitmap.getWidth();
                    int height = bitmap.getHeight();
                    int i7 = (width - rect.right) - rect.left;
                    int i8 = (height - rect.top) - rect.bottom;
                    Log.m6485d(TAG, " GainMap change: input bmap w " + Integer.toString(width) + " & h " + Integer.toString(height));
                    Log.m6485d(TAG, " GainMap change: input bmap gainmap w " + Integer.toString(bitmap.getGainmap().getGainmapContents().getWidth()) + " & h " + Integer.toString(bitmap.getGainmap().getGainmapContents().getHeight()));
                    Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, width * i, height * i, true);
                    Log.m6485d(TAG, " GainMap change: s_bitmap scaled w " + Integer.toString(bitmapCreateScaledBitmap.getWidth()) + " & h " + Integer.toString(bitmapCreateScaledBitmap.getHeight()));
                    if (!bitmapCreateScaledBitmap.hasGainmap()) {
                        Log.m6485d(TAG, " GainMap change: s_bitmap doesn't have GainMap");
                        Log.m6485d(TAG, " output copyPixelsFromBuffer TIME TAKEN " + (System.currentTimeMillis() - jCurrentTimeMillis5));
                        Log.m6485d(TAG, " total time by upscaleImage at SDK " + (System.currentTimeMillis() - jCurrentTimeMillis));
                        return bitmapCreateBitmap;
                    }
                    Log.m6485d(TAG, " GainMap change: s_bitmap gainmap scaled w " + Integer.toString(bitmapCreateScaledBitmap.getGainmap().getGainmapContents().getWidth()) + " & h " + Integer.toString(bitmapCreateScaledBitmap.getGainmap().getGainmapContents().getHeight()));
                    Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(bitmapCreateScaledBitmap, rect.left * i, rect.top * i, i7 * i, i8 * i);
                    Log.m6485d(TAG, " GainMap change: c_bitmap w " + Integer.toString(bitmapCreateBitmap2.getWidth()) + " & h " + Integer.toString(bitmapCreateBitmap2.getHeight()));
                    if (!bitmapCreateBitmap2.hasGainmap()) {
                        Log.m6485d(TAG, " GainMap change: c_bitmap doesn't have GainMap");
                        Log.m6485d(TAG, " output copyPixelsFromBuffer TIME TAKEN " + (System.currentTimeMillis() - jCurrentTimeMillis5));
                        Log.m6485d(TAG, " total time by upscaleImage at SDK " + (System.currentTimeMillis() - jCurrentTimeMillis));
                        return bitmapCreateBitmap;
                    }
                    Log.m6485d(TAG, " GainMap change: c_bitmap gainmap w " + Integer.toString(bitmapCreateBitmap2.getGainmap().getGainmapContents().getWidth()) + " & h " + Integer.toString(bitmapCreateBitmap2.getGainmap().getGainmapContents().getHeight()));
                    Log.m6485d(TAG, " GainMap change: result bitmap w " + Integer.toString(bitmapCreateBitmap.getWidth()) + " & h " + Integer.toString(bitmapCreateBitmap.getHeight()));
                    Log.m6485d(TAG, " GainMap change, c_bitmap has gain map true");
                    bitmapCreateBitmap.setGainmap(bitmapCreateBitmap2.getGainmap());
                } catch (Exception e) {
                    Log.m6485d(TAG, " GainMap change error : " + e.getMessage());
                }
            }
            Log.m6485d(TAG, " output copyPixelsFromBuffer TIME TAKEN " + (System.currentTimeMillis() - jCurrentTimeMillis5));
            Log.m6485d(TAG, " total time by upscaleImage at SDK " + (System.currentTimeMillis() - jCurrentTimeMillis));
            return bitmapCreateBitmap;
        } catch (Exception e2) {
            Log.m6488e(TAG, " Exception :: upscale ", e2);
            return null;
        }
    }

    public boolean createSession(int i) {
        return createSession(i, null);
    }
}
