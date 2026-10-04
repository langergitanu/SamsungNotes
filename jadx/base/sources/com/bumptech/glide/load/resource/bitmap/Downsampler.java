package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.AbstractC2821a;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.ImageReader;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class Downsampler {
    public static final Option<Boolean> ALLOW_HARDWARE_CONFIG;
    private static final DecodeCallbacks EMPTY_CALLBACKS;
    public static final Option<Boolean> FIX_BITMAP_SIZE_TO_REQUESTED_DIMENSIONS;
    private static final String ICO_MIME_TYPE = "image/x-ico";
    private static final Set<String> NO_DOWNSAMPLE_PRE_N_MIME_TYPES;
    private static final Queue<BitmapFactory.Options> OPTIONS_QUEUE;
    static final String TAG = "Downsampler";
    private static final Set<ImageHeaderParser.ImageType> TYPES_THAT_USE_POOL_PRE_KITKAT;
    private static final String WBMP_MIME_TYPE = "image/vnd.wap.wbmp";
    private final BitmapPool bitmapPool;
    private final ArrayPool byteArrayPool;
    private final DisplayMetrics displayMetrics;
    private final HardwareConfigState hardwareConfigState = HardwareConfigState.getInstance();
    private final List<ImageHeaderParser> parsers;
    public static final Option<DecodeFormat> DECODE_FORMAT = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", DecodeFormat.DEFAULT);
    public static final Option<PreferredColorSpace> PREFERRED_COLOR_SPACE = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace");

    @Deprecated
    public static final Option<DownsampleStrategy> DOWNSAMPLE_STRATEGY = DownsampleStrategy.OPTION;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface DecodeCallbacks {
        void onDecodeComplete(BitmapPool bitmapPool, Bitmap bitmap);

        void onObtainBounds();
    }

    static {
        Boolean bool = Boolean.FALSE;
        FIX_BITMAP_SIZE_TO_REQUESTED_DIMENSIONS = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", bool);
        ALLOW_HARDWARE_CONFIG = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", bool);
        NO_DOWNSAMPLE_PRE_N_MIME_TYPES = Collections.unmodifiableSet(new HashSet(Arrays.asList("image/vnd.wap.wbmp", ICO_MIME_TYPE)));
        EMPTY_CALLBACKS = new DecodeCallbacks() { // from class: com.bumptech.glide.load.resource.bitmap.Downsampler.1
            @Override // com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks
            public void onObtainBounds() {
            }

            @Override // com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks
            public void onDecodeComplete(BitmapPool bitmapPool, Bitmap bitmap) {
            }
        };
        TYPES_THAT_USE_POOL_PRE_KITKAT = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));
        OPTIONS_QUEUE = Util.createQueue(0);
    }

    public Downsampler(List<ImageHeaderParser> list, DisplayMetrics displayMetrics, BitmapPool bitmapPool, ArrayPool arrayPool) {
        this.parsers = list;
        this.displayMetrics = (DisplayMetrics) Preconditions.checkNotNull(displayMetrics);
        this.bitmapPool = (BitmapPool) Preconditions.checkNotNull(bitmapPool);
        this.byteArrayPool = (ArrayPool) Preconditions.checkNotNull(arrayPool);
    }

    private static int adjustTargetDensityForError(double d) {
        int densityMultiplier = getDensityMultiplier(d);
        int iRound = round(((double) densityMultiplier) * d);
        return round((d / ((double) (iRound / densityMultiplier))) * ((double) iRound));
    }

    private void calculateConfig(ImageReader imageReader, DecodeFormat decodeFormat, boolean z, boolean z2, BitmapFactory.Options options, int i, int i2) {
        boolean zHasAlpha;
        if (this.hardwareConfigState.setHardwareConfigIfAllowed(i, i2, options, z, z2)) {
            return;
        }
        if (decodeFormat == DecodeFormat.PREFER_ARGB_8888) {
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            return;
        }
        try {
            zHasAlpha = imageReader.getImageType().hasAlpha();
        } catch (IOException e) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Cannot determine whether the image has alpha or not from header, format " + decodeFormat, e);
            }
            zHasAlpha = false;
        }
        Bitmap.Config config = zHasAlpha ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
        options.inPreferredConfig = config;
        if (config == Bitmap.Config.RGB_565) {
            options.inDither = true;
        }
    }

    private static void calculateScaling(ImageHeaderParser.ImageType imageType, ImageReader imageReader, DecodeCallbacks decodeCallbacks, BitmapPool bitmapPool, DownsampleStrategy downsampleStrategy, int i, int i2, int i4, int i5, int i6, BitmapFactory.Options options) {
        int i7;
        int i8;
        int i9;
        int iFloor;
        int iFloor2;
        if (i2 <= 0 || i4 <= 0) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Unable to determine dimensions for: " + imageType + " with target [" + i5 + "x" + i6 + "]");
                return;
            }
            return;
        }
        if (isRotationRequired(i)) {
            i8 = i2;
            i7 = i4;
        } else {
            i7 = i2;
            i8 = i4;
        }
        float scaleFactor = downsampleStrategy.getScaleFactor(i7, i8, i5, i6);
        if (scaleFactor <= 0.0f) {
            StringBuilder sb = new StringBuilder("Cannot scale with factor: ");
            sb.append(scaleFactor);
            sb.append(" from: ");
            sb.append(downsampleStrategy);
            sb.append(", source: [");
            AbstractC2821a.m2235z(sb, i2, i4, "x", "], target: [");
            throw new IllegalArgumentException(AbstractC2322a.m1625o(sb, i5, i6, "x", "]"));
        }
        DownsampleStrategy.SampleSizeRounding sampleSizeRounding = downsampleStrategy.getSampleSizeRounding(i7, i8, i5, i6);
        if (sampleSizeRounding == null) {
            throw new IllegalArgumentException("Cannot round with null rounding");
        }
        float f = i7;
        float f4 = i8;
        int i10 = i7;
        int i11 = i8;
        int iRound = i10 / round(scaleFactor * f);
        int iRound2 = i11 / round(scaleFactor * f4);
        DownsampleStrategy.SampleSizeRounding sampleSizeRounding2 = DownsampleStrategy.SampleSizeRounding.MEMORY;
        int iMax = Math.max(1, Integer.highestOneBit(sampleSizeRounding == sampleSizeRounding2 ? Math.max(iRound, iRound2) : Math.min(iRound, iRound2)));
        if (sampleSizeRounding == sampleSizeRounding2 && iMax < 1.0f / scaleFactor) {
            iMax <<= 1;
        }
        options.inSampleSize = iMax;
        if (imageType == ImageHeaderParser.ImageType.JPEG) {
            float fMin = Math.min(iMax, 8);
            i9 = 0;
            iFloor = (int) Math.ceil(f / fMin);
            iFloor2 = (int) Math.ceil(f4 / fMin);
            int i12 = iMax / 8;
            if (i12 > 0) {
                iFloor /= i12;
                iFloor2 /= i12;
            }
        } else {
            i9 = 0;
            if (imageType == ImageHeaderParser.ImageType.PNG || imageType == ImageHeaderParser.ImageType.PNG_A) {
                float f5 = iMax;
                iFloor = (int) Math.floor(f / f5);
                iFloor2 = (int) Math.floor(f4 / f5);
            } else if (imageType.isWebp()) {
                float f6 = iMax;
                iFloor = Math.round(f / f6);
                iFloor2 = Math.round(f4 / f6);
            } else if (i10 % iMax == 0 && i11 % iMax == 0) {
                iFloor = i10 / iMax;
                iFloor2 = i11 / iMax;
            } else {
                int[] dimensions = getDimensions(imageReader, options, decodeCallbacks, bitmapPool);
                iFloor = dimensions[0];
                iFloor2 = dimensions[1];
            }
        }
        double scaleFactor2 = downsampleStrategy.getScaleFactor(iFloor, iFloor2, i5, i6);
        options.inTargetDensity = adjustTargetDensityForError(scaleFactor2);
        options.inDensity = getDensityMultiplier(scaleFactor2);
        if (isScaling(options)) {
            options.inScaled = true;
        } else {
            int i13 = i9;
            options.inTargetDensity = i13;
            options.inDensity = i13;
        }
        if (Log.isLoggable(TAG, 2)) {
            StringBuilder sbM1173s = AbstractC0622a.m1173s(i2, i4, "Calculate scaling, source: [", "x", "], degreesToRotate: ");
            AbstractC2821a.m2235z(sbM1173s, i, i5, ", target: [", "x");
            AbstractC2821a.m2235z(sbM1173s, i6, iFloor, "], power of two scaled: [", "x");
            sbM1173s.append(iFloor2);
            sbM1173s.append("], exact scale factor: ");
            sbM1173s.append(scaleFactor);
            sbM1173s.append(", power of 2 sample size: ");
            sbM1173s.append(iMax);
            sbM1173s.append(", adjusted scale factor: ");
            sbM1173s.append(scaleFactor2);
            sbM1173s.append(", target density: ");
            sbM1173s.append(options.inTargetDensity);
            sbM1173s.append(", density: ");
            sbM1173s.append(options.inDensity);
            Log.v(TAG, sbM1173s.toString());
        }
    }

    private Bitmap decodeFromWrappedStreams(ImageReader imageReader, BitmapFactory.Options options, DownsampleStrategy downsampleStrategy, DecodeFormat decodeFormat, PreferredColorSpace preferredColorSpace, boolean z, int i, int i2, boolean z2, DecodeCallbacks decodeCallbacks) {
        int i4;
        String str;
        String str2;
        ColorSpace colorSpace;
        long logTime = LogTime.getLogTime();
        int[] dimensions = getDimensions(imageReader, options, decodeCallbacks, this.bitmapPool);
        int i5 = dimensions[0];
        int i6 = dimensions[1];
        String str3 = options.outMimeType;
        boolean z3 = (i5 == -1 || i6 == -1) ? false : z;
        int imageOrientation = imageReader.getImageOrientation();
        int exifOrientationDegrees = TransformationUtils.getExifOrientationDegrees(imageOrientation);
        boolean zIsExifOrientationRequired = TransformationUtils.isExifOrientationRequired(imageOrientation);
        int i7 = i;
        if (i7 != Integer.MIN_VALUE) {
            i4 = i2;
        } else if (isRotationRequired(exifOrientationDegrees)) {
            i4 = i2;
            i7 = i6;
        } else {
            i4 = i2;
            i7 = i5;
        }
        if (i4 == Integer.MIN_VALUE) {
            i4 = isRotationRequired(exifOrientationDegrees) ? i5 : i6;
        }
        ImageHeaderParser.ImageType imageType = imageReader.getImageType();
        calculateScaling(imageType, imageReader, decodeCallbacks, this.bitmapPool, downsampleStrategy, exifOrientationDegrees, i5, i6, i7, i4, options);
        int i8 = i7;
        int i9 = i4;
        calculateConfig(imageReader, decodeFormat, z3, zIsExifOrientationRequired, options, i8, i9);
        int i10 = Build.VERSION.SDK_INT;
        if (shouldUsePool(imageType)) {
            if (i5 < 0 || i6 < 0 || !z2) {
                float f = isScaling(options) ? options.inTargetDensity / options.inDensity : 1.0f;
                int i11 = options.inSampleSize;
                float f4 = i11;
                int iCeil = (int) Math.ceil(i5 / f4);
                int iCeil2 = (int) Math.ceil(i6 / f4);
                int iRound = Math.round(iCeil * f);
                int iRound2 = Math.round(iCeil2 * f);
                str = TAG;
                if (Log.isLoggable(str, 2)) {
                    str2 = str3;
                    StringBuilder sbM1173s = AbstractC0622a.m1173s(iRound, iRound2, "Calculated target [", "x", "] for source [");
                    AbstractC2821a.m2235z(sbM1173s, i5, i6, "x", "], sampleSize: ");
                    sbM1173s.append(i11);
                    sbM1173s.append(", targetDensity: ");
                    sbM1173s.append(options.inTargetDensity);
                    sbM1173s.append(", density: ");
                    sbM1173s.append(options.inDensity);
                    sbM1173s.append(", density multiplier: ");
                    sbM1173s.append(f);
                    Log.v(str, sbM1173s.toString());
                } else {
                    str2 = str3;
                }
                i8 = iRound;
                i9 = iRound2;
            } else {
                str = TAG;
                str2 = str3;
            }
            if (i8 > 0 && i9 > 0) {
                setInBitmap(options, this.bitmapPool, i8, i9);
            }
        } else {
            str = TAG;
            str2 = str3;
        }
        if (preferredColorSpace != null) {
            if (i10 >= 28) {
                options.inPreferredColorSpace = ColorSpace.get((preferredColorSpace == PreferredColorSpace.DISPLAY_P3 && (colorSpace = options.outColorSpace) != null && colorSpace.isWideGamut()) ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB);
            } else {
                options.inPreferredColorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
            }
        }
        Bitmap bitmapDecodeStream = decodeStream(imageReader, options, decodeCallbacks, this.bitmapPool);
        decodeCallbacks.onDecodeComplete(this.bitmapPool, bitmapDecodeStream);
        if (Log.isLoggable(str, 2)) {
            logDecode(i5, i6, str2, options, bitmapDecodeStream, i, i2, logTime);
        }
        if (bitmapDecodeStream == null) {
            return null;
        }
        bitmapDecodeStream.setDensity(this.displayMetrics.densityDpi);
        Bitmap bitmapRotateImageExif = TransformationUtils.rotateImageExif(this.bitmapPool, bitmapDecodeStream, imageOrientation);
        if (!bitmapDecodeStream.equals(bitmapRotateImageExif)) {
            this.bitmapPool.put(bitmapDecodeStream);
        }
        return bitmapRotateImageExif;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:?, code lost:
    
        throw r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Bitmap decodeStream(ImageReader imageReader, BitmapFactory.Options options, DecodeCallbacks decodeCallbacks, BitmapPool bitmapPool) {
        Bitmap bitmapDecodeStream;
        if (!options.inJustDecodeBounds) {
            decodeCallbacks.onObtainBounds();
            imageReader.stopGrowingBuffers();
        }
        int i = options.outWidth;
        int i2 = options.outHeight;
        String str = options.outMimeType;
        TransformationUtils.getBitmapDrawableLock().lock();
        try {
            try {
                bitmapDecodeStream = imageReader.decodeBitmap(options);
            } catch (IllegalArgumentException e) {
                IOException iOExceptionNewIoExceptionForInBitmapAssertion = newIoExceptionForInBitmapAssertion(e, i, i2, str, options);
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "Failed to decode with inBitmap, trying again without Bitmap re-use", iOExceptionNewIoExceptionForInBitmapAssertion);
                }
                Bitmap bitmap = options.inBitmap;
                if (bitmap == null) {
                    throw iOExceptionNewIoExceptionForInBitmapAssertion;
                }
                try {
                    bitmapPool.put(bitmap);
                    options.inBitmap = null;
                    bitmapDecodeStream = decodeStream(imageReader, options, decodeCallbacks, bitmapPool);
                } catch (IOException unused) {
                    throw iOExceptionNewIoExceptionForInBitmapAssertion;
                }
            }
            return bitmapDecodeStream;
        } finally {
            TransformationUtils.getBitmapDrawableLock().unlock();
        }
    }

    @Nullable
    @TargetApi(19)
    private static String getBitmapString(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig() + (" (" + bitmap.getAllocationByteCount() + ")");
    }

    private static synchronized BitmapFactory.Options getDefaultOptions() {
        BitmapFactory.Options optionsPoll;
        Queue<BitmapFactory.Options> queue = OPTIONS_QUEUE;
        synchronized (queue) {
            optionsPoll = queue.poll();
        }
        if (optionsPoll == null) {
            optionsPoll = new BitmapFactory.Options();
            resetOptions(optionsPoll);
        }
        return optionsPoll;
    }

    private static int getDensityMultiplier(double d) {
        if (d > 1.0d) {
            d = 1.0d / d;
        }
        return (int) Math.round(d * 2.147483647E9d);
    }

    private static int[] getDimensions(ImageReader imageReader, BitmapFactory.Options options, DecodeCallbacks decodeCallbacks, BitmapPool bitmapPool) {
        options.inJustDecodeBounds = true;
        decodeStream(imageReader, options, decodeCallbacks, bitmapPool);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    private static String getInBitmapString(BitmapFactory.Options options) {
        return getBitmapString(options.inBitmap);
    }

    private static boolean isRotationRequired(int i) {
        return i == 90 || i == 270;
    }

    private static boolean isScaling(BitmapFactory.Options options) {
        int i;
        int i2 = options.inTargetDensity;
        return i2 > 0 && (i = options.inDensity) > 0 && i2 != i;
    }

    private static void logDecode(int i, int i2, String str, BitmapFactory.Options options, Bitmap bitmap, int i4, int i5, long j) {
        StringBuilder sb = new StringBuilder("Decoded ");
        sb.append(getBitmapString(bitmap));
        sb.append(" from [");
        sb.append(i);
        sb.append("x");
        AbstractC1974b.m1331x(sb, i2, "] ", str, " with inBitmap ");
        sb.append(getInBitmapString(options));
        sb.append(" for [");
        sb.append(i4);
        sb.append("x");
        sb.append(i5);
        sb.append("], sample size: ");
        sb.append(options.inSampleSize);
        sb.append(", density: ");
        sb.append(options.inDensity);
        sb.append(", target density: ");
        sb.append(options.inTargetDensity);
        sb.append(", thread: ");
        sb.append(Thread.currentThread().getName());
        sb.append(", duration: ");
        sb.append(LogTime.getElapsedMillis(j));
        Log.v(TAG, sb.toString());
    }

    private static IOException newIoExceptionForInBitmapAssertion(IllegalArgumentException illegalArgumentException, int i, int i2, String str, BitmapFactory.Options options) {
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i2, "Exception decoding bitmap, outWidth: ", ", outHeight: ", ", outMimeType: ");
        sbM1173s.append(str);
        sbM1173s.append(", inBitmap: ");
        sbM1173s.append(getInBitmapString(options));
        return new IOException(sbM1173s.toString(), illegalArgumentException);
    }

    private static void releaseOptions(BitmapFactory.Options options) {
        resetOptions(options);
        Queue<BitmapFactory.Options> queue = OPTIONS_QUEUE;
        synchronized (queue) {
            queue.offer(options);
        }
    }

    private static void resetOptions(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        options.inPreferredColorSpace = null;
        options.outColorSpace = null;
        options.outConfig = null;
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    private static int round(double d) {
        return (int) (d + 0.5d);
    }

    @TargetApi(26)
    private static void setInBitmap(BitmapFactory.Options options, BitmapPool bitmapPool, int i, int i2) {
        Bitmap.Config config = options.inPreferredConfig;
        if (config == Bitmap.Config.HARDWARE) {
            return;
        }
        Bitmap.Config config2 = options.outConfig;
        if (config2 != null) {
            config = config2;
        }
        options.inBitmap = bitmapPool.getDirty(i, i2, config);
    }

    private boolean shouldUsePool(ImageHeaderParser.ImageType imageType) {
        return true;
    }

    public Resource<Bitmap> decode(InputStream inputStream, int i, int i2, Options options) {
        return decode(inputStream, i, i2, options, EMPTY_CALLBACKS);
    }

    public boolean handles(InputStream inputStream) {
        return true;
    }

    public Resource<Bitmap> decode(ByteBuffer byteBuffer, int i, int i2, Options options) {
        return decode(new ImageReader.ByteBufferReader(byteBuffer, this.parsers, this.byteArrayPool), i, i2, options, EMPTY_CALLBACKS);
    }

    public boolean handles(ByteBuffer byteBuffer) {
        return true;
    }

    public Resource<Bitmap> decode(InputStream inputStream, int i, int i2, Options options, DecodeCallbacks decodeCallbacks) {
        return decode(new ImageReader.InputStreamImageReader(inputStream, this.parsers, this.byteArrayPool), i, i2, options, decodeCallbacks);
    }

    public boolean handles(ParcelFileDescriptor parcelFileDescriptor) {
        return ParcelFileDescriptorRewinder.isSupported();
    }

    @VisibleForTesting
    public void decode(byte[] bArr, int i, int i2, Options options) {
        decode(new ImageReader.ByteArrayReader(bArr, this.parsers, this.byteArrayPool), i, i2, options, EMPTY_CALLBACKS);
    }

    @VisibleForTesting
    public void decode(File file, int i, int i2, Options options) {
        decode(new ImageReader.FileReader(file, this.parsers, this.byteArrayPool), i, i2, options, EMPTY_CALLBACKS);
    }

    @RequiresApi(21)
    public Resource<Bitmap> decode(ParcelFileDescriptor parcelFileDescriptor, int i, int i2, Options options) {
        return decode(new ImageReader.ParcelFileDescriptorImageReader(parcelFileDescriptor, this.parsers, this.byteArrayPool), i, i2, options, EMPTY_CALLBACKS);
    }

    private Resource<Bitmap> decode(ImageReader imageReader, int i, int i2, Options options, DecodeCallbacks decodeCallbacks) {
        byte[] bArr = (byte[]) this.byteArrayPool.get(65536, byte[].class);
        BitmapFactory.Options defaultOptions = getDefaultOptions();
        defaultOptions.inTempStorage = bArr;
        DecodeFormat decodeFormat = (DecodeFormat) options.get(DECODE_FORMAT);
        PreferredColorSpace preferredColorSpace = (PreferredColorSpace) options.get(PREFERRED_COLOR_SPACE);
        DownsampleStrategy downsampleStrategy = (DownsampleStrategy) options.get(DownsampleStrategy.OPTION);
        boolean zBooleanValue = ((Boolean) options.get(FIX_BITMAP_SIZE_TO_REQUESTED_DIMENSIONS)).booleanValue();
        Option<Boolean> option = ALLOW_HARDWARE_CONFIG;
        try {
            return BitmapResource.obtain(decodeFromWrappedStreams(imageReader, defaultOptions, downsampleStrategy, decodeFormat, preferredColorSpace, options.get(option) != null && ((Boolean) options.get(option)).booleanValue(), i, i2, zBooleanValue, decodeCallbacks), this.bitmapPool);
        } finally {
            releaseOptions(defaultOptions);
            this.byteArrayPool.put(bArr);
        }
    }
}
