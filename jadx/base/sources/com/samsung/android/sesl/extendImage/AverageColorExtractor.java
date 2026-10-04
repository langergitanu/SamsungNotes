package com.samsung.android.sesl.extendImage;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.compose.runtime.AbstractC1974b;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class AverageColorExtractor {
    private static final int COLOR_CHANNELS = 3;
    private static final int MAX_SAFE_BITMAP_SIZE = 256;
    private static final String TAG = "AverageColorExtractor";
    private final int[][] mIntegralCount;
    private final int[][][] mIntegralSum;
    private final boolean mIsInitialized;
    private final int mOriginalHeight;
    private final int mOriginalWidth;
    private final int mSampleHeight;
    private final int mSampleWidth;
    private final float mScaleRatio;

    public AverageColorExtractor(@NonNull Bitmap bitmap) {
        this(bitmap, 256);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Bitmap getBitmapFromDrawable(@NonNull Drawable drawable, @IntRange(from = 100, m706to = 256) int i) {
        Bitmap bitmapCreateBitmap;
        Rect bounds = drawable.getBounds();
        int intrinsicWidth = bounds.isEmpty() ? drawable.getIntrinsicWidth() : bounds.width();
        int intrinsicHeight = bounds.isEmpty() ? drawable.getIntrinsicHeight() : bounds.height();
        float f = i / (intrinsicWidth > intrinsicHeight ? intrinsicWidth : intrinsicHeight);
        int i2 = (int) ((intrinsicWidth * f) + 0.5f);
        int i4 = (int) ((intrinsicHeight * f) + 0.5f);
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() == null || bitmapDrawable.getBitmap().getColorSpace() == null) {
                bitmapCreateBitmap = Bitmap.createBitmap(i2, i4, Bitmap.Config.ARGB_8888);
            } else {
                Bitmap bitmap = bitmapDrawable.getBitmap();
                bitmapCreateBitmap = Bitmap.createBitmap(i2, i4, Bitmap.Config.ARGB_8888, bitmap.hasAlpha(), bitmap.getColorSpace());
            }
        }
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.scale(f, f);
        if (bounds.isEmpty()) {
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        } else {
            canvas.translate(-bounds.left, -bounds.top);
        }
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean initializeIntegralImages(@NonNull Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        int i = 0;
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        Log.i(TAG, "pixel_extraction_complete");
        int[][][] iArr2 = this.mIntegralSum;
        int[][] iArr3 = iArr2[0];
        int i2 = 1;
        int[][] iArr4 = iArr2[1];
        int[][] iArr5 = iArr2[2];
        int[][] iArr6 = this.mIntegralCount;
        int i4 = 0;
        int i5 = 1;
        while (i5 <= height) {
            int[] iArr7 = iArr3[i5];
            int i6 = i5 - 1;
            int[] iArr8 = iArr3[i6];
            int[] iArr9 = iArr4[i5];
            int[] iArr10 = iArr4[i6];
            int[] iArr11 = iArr5[i5];
            int[] iArr12 = iArr5[i6];
            int[] iArr13 = iArr6[i5];
            int[] iArr14 = iArr6[i6];
            int i7 = i;
            int i8 = i7;
            int i9 = i8;
            int i10 = i9;
            int i11 = i2;
            while (i11 <= width) {
                int i12 = i2;
                int i13 = iArr[i4];
                int i14 = ~((((i13 >>> 24) & 255) - 1) >> 31);
                int i15 = (i13 >> 16) & 255 & i14;
                int i16 = i15 + iArr8[i11] + i7;
                int i17 = i11 - 1;
                int i18 = i16 - iArr8[i17];
                iArr7[i11] = i18;
                i8 = (((((i13 >> 8) & 255) & i14) + iArr10[i11]) + i8) - iArr10[i17];
                iArr9[i11] = i8;
                i9 = ((((i13 & 255) & i14) + iArr12[i11]) + i9) - iArr12[i17];
                iArr11[i11] = i9;
                i10 = (((i14 & 1) + iArr14[i11]) + i10) - iArr14[i17];
                iArr13[i11] = i10;
                i11++;
                i4++;
                i2 = i12;
                i7 = i18;
            }
            i5++;
            i = 0;
        }
        boolean z = i2;
        Log.i(TAG, "integral_calculation_complete");
        return z;
    }

    public static AverageColorExtractor load(File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream, 65536);
                try {
                    ObjectInputStream objectInputStream = new ObjectInputStream(bufferedInputStream);
                    try {
                        AverageColorExtractor averageColorExtractor = new AverageColorExtractor(objectInputStream.readInt(), objectInputStream.readInt(), objectInputStream.readInt(), objectInputStream.readInt(), objectInputStream.readFloat(), (int[][][]) objectInputStream.readObject());
                        objectInputStream.close();
                        bufferedInputStream.close();
                        fileInputStream.close();
                        return averageColorExtractor;
                    } finally {
                    }
                } finally {
                }
            } finally {
            }
        } catch (IOException | ClassNotFoundException e) {
            Log.e(TAG, "load failed", e);
            return null;
        }
    }

    private static float readFloat(InputStream inputStream) {
        return Float.intBitsToFloat(readInt(inputStream));
    }

    private static int readInt(InputStream inputStream) throws IOException {
        int i = inputStream.read();
        int i2 = inputStream.read();
        int i4 = inputStream.read();
        int i5 = inputStream.read();
        if ((i | i2 | i4 | i5) >= 0) {
            return i5 | (i << 24) | (i2 << 16) | (i4 << 8);
        }
        throw new EOFException();
    }

    private static void writeFloat(OutputStream outputStream, float f) throws IOException {
        writeInt(outputStream, Float.floatToIntBits(f));
    }

    private static void writeInt(OutputStream outputStream, int i) throws IOException {
        outputStream.write((i >>> 24) & 255);
        outputStream.write((i >>> 16) & 255);
        outputStream.write((i >>> 8) & 255);
        outputStream.write(i & 255);
    }

    public void cleanup() {
        Log.d(TAG, "cleanup - only Integral Image in use, no bitmaps to recycle");
    }

    public int getAverageColor(Rect rect) {
        return getAverageColor(rect, null);
    }

    public int getAverageColorWithAlpha(Rect rect) {
        int iHeight;
        int i;
        int i2;
        if (this.mIsInitialized && !rect.isEmpty()) {
            float f = this.mScaleRatio;
            int i4 = 1;
            boolean z = 1.0f == f;
            int i5 = rect.left;
            if (!z) {
                i5 = (int) ((i5 * f) + 0.5f);
            }
            int i6 = rect.top;
            if (!z) {
                i6 = (int) ((i6 * f) + 0.5f);
            }
            int i7 = rect.right;
            if (!z) {
                i7 = (int) ((i7 * f) + 0.5f);
            }
            int i8 = z ? rect.bottom : (int) ((rect.bottom * f) + 0.5f);
            if (i5 < 0) {
                i5 = 0;
            }
            int i9 = i5 + 1;
            if (i6 < 0) {
                i6 = 0;
            }
            int i10 = i6 + 1;
            int i11 = this.mSampleWidth;
            if (i7 >= i11) {
                i7 = i11 - 1;
            }
            int i12 = i7 + 1;
            int i13 = this.mSampleHeight;
            if (i8 >= i13) {
                i8 = i13 - 1;
            }
            int i14 = i8 + 1;
            if (i9 < i12 && i10 < i14) {
                int[][][] iArr = this.mIntegralSum;
                int[][] iArr2 = iArr[0];
                int[][] iArr3 = iArr[1];
                int[][] iArr4 = iArr[2];
                int[][] iArr5 = this.mIntegralCount;
                int[] iArr6 = iArr2[i14];
                int i15 = iArr6[i12] - iArr6[i5];
                int[] iArr7 = iArr2[i6];
                int i16 = (i15 - iArr7[i12]) + iArr7[i5];
                int[] iArr8 = iArr3[i14];
                int i17 = iArr8[i12] - iArr8[i5];
                int[] iArr9 = iArr3[i6];
                int i18 = (i17 - iArr9[i12]) + iArr9[i5];
                int[] iArr10 = iArr4[i14];
                int i19 = iArr10[i12] - iArr10[i5];
                int[] iArr11 = iArr4[i6];
                int i20 = (i19 - iArr11[i12]) + iArr11[i5];
                if (iArr5 == null) {
                    iHeight = rect.height() * rect.width();
                } else {
                    int[] iArr12 = iArr5[i14];
                    int i21 = iArr12[i12] - iArr12[i5];
                    int[] iArr13 = iArr5[i6];
                    iHeight = iArr13[i5] + (i21 - iArr13[i12]);
                }
                int i22 = (i14 - i10) * (i12 - i9);
                if (iHeight == 0) {
                    return 0;
                }
                if (iHeight == i22) {
                    i = ((i16 / iHeight) << 16) | (-16777216) | ((i18 / iHeight) << 8);
                    i2 = i20 / iHeight;
                } else {
                    int i23 = (int) ((iHeight * 255.0f) / i22);
                    if (i23 > 255) {
                        i4 = 255;
                    } else if (i23 >= 1) {
                        i4 = i23;
                    }
                    i = (i4 << 24) | ((i16 / iHeight) << 16) | ((i18 / iHeight) << 8);
                    i2 = i20 / iHeight;
                }
                return i | i2;
            }
        }
        return 0;
    }

    public int[] getAverageColors(Rect[] rectArr) {
        boolean z;
        int i;
        int iHeight;
        Rect[] rectArr2 = rectArr;
        if (!this.mIsInitialized || rectArr2 == null || rectArr2.length == 0) {
            return null;
        }
        int[] iArr = new int[rectArr2.length];
        float f = this.mScaleRatio;
        boolean z2 = true;
        boolean z3 = 1.0f == f;
        int[][][] iArr2 = this.mIntegralSum;
        int[][] iArr3 = iArr2[0];
        int[][] iArr4 = iArr2[1];
        int[][] iArr5 = iArr2[2];
        int[][] iArr6 = this.mIntegralCount;
        int i2 = 0;
        while (i2 < rectArr2.length) {
            Rect rect = rectArr2[i2];
            int i4 = rect.left;
            if (!z3) {
                i4 = (int) ((i4 * f) + 0.5f);
            }
            int i5 = rect.top;
            if (!z3) {
                i5 = (int) ((i5 * f) + 0.5f);
            }
            int i6 = rect.right;
            if (!z3) {
                i6 = (int) ((i6 * f) + 0.5f);
            }
            if (z3) {
                i = rect.bottom;
                z = z2;
            } else {
                z = z2;
                i = (int) ((rect.bottom * f) + 0.5f);
            }
            if (i4 < 0) {
                i4 = 0;
            }
            int i7 = i4 + 1;
            if (i5 < 0) {
                i5 = 0;
            }
            int i8 = i5 + 1;
            int[] iArr7 = iArr;
            int i9 = this.mSampleWidth;
            if (i6 >= i9) {
                i6 = i9 - 1;
            }
            int i10 = i6 + 1;
            int i11 = this.mSampleHeight;
            if (i >= i11) {
                i = i11 - 1;
            }
            int i12 = i + 1;
            int i13 = -16777216;
            if (i7 < i10 && i8 < i12) {
                if (iArr6 == null) {
                    iHeight = rect.height() * rect.width();
                } else {
                    int[] iArr8 = iArr6[i12];
                    int i14 = iArr8[i10] - iArr8[i4];
                    int[] iArr9 = iArr6[i5];
                    iHeight = (i14 - iArr9[i10]) + iArr9[i4];
                }
                if (iHeight == 0) {
                    i13 = 0;
                } else {
                    int[] iArr10 = iArr3[i12];
                    int i15 = iArr10[i10] - iArr10[i4];
                    int[] iArr11 = iArr3[i5];
                    int i16 = ((((i15 - iArr11[i10]) + iArr11[i4]) / iHeight) << 16) | (-16777216);
                    int[] iArr12 = iArr4[i12];
                    int i17 = iArr12[i10] - iArr12[i4];
                    int[] iArr13 = iArr4[i5];
                    int i18 = i16 | ((((i17 - iArr13[i10]) + iArr13[i4]) / iHeight) << 8);
                    int[] iArr14 = iArr5[i12];
                    int i19 = iArr14[i10] - iArr14[i4];
                    int[] iArr15 = iArr5[i5];
                    i13 = i18 | (((i19 - iArr15[i10]) + iArr15[i4]) / iHeight);
                }
            }
            iArr7[i2] = i13;
            i2++;
            rectArr2 = rectArr;
            z2 = z;
            iArr = iArr7;
        }
        return iArr;
    }

    public int[][] getAverageRGBColors(Rect[] rectArr) {
        int iHeight;
        Rect[] rectArr2 = rectArr;
        if (!this.mIsInitialized || rectArr2 == null || rectArr2.length == 0) {
            return null;
        }
        char c = 2;
        char c2 = 1;
        int i = 0;
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, rectArr2.length, 3);
        float f = this.mScaleRatio;
        boolean z = 1.0f == f;
        int[][][] iArr2 = this.mIntegralSum;
        int[][] iArr3 = iArr2[0];
        int[][] iArr4 = iArr2[1];
        int[][] iArr5 = iArr2[2];
        int[][] iArr6 = this.mIntegralCount;
        int i2 = 0;
        while (i2 < rectArr2.length) {
            Rect rect = rectArr2[i2];
            int[] iArr7 = iArr[i2];
            char c4 = c;
            int i4 = rect.left;
            if (!z) {
                i4 = (int) ((i4 * f) + 0.5f);
            }
            char c5 = c2;
            int i5 = rect.top;
            if (!z) {
                i5 = (int) ((i5 * f) + 0.5f);
            }
            int i6 = i;
            int i7 = rect.right;
            if (!z) {
                i7 = (int) ((i7 * f) + 0.5f);
            }
            int i8 = z ? rect.bottom : (int) ((rect.bottom * f) + 0.5f);
            if (i4 < 0) {
                i4 = i6;
            }
            int i9 = i4 + 1;
            if (i5 < 0) {
                i5 = i6;
            }
            int[][] iArr8 = iArr;
            int i10 = i5 + 1;
            int i11 = i4;
            int i12 = this.mSampleWidth;
            if (i7 >= i12) {
                i7 = i12 - 1;
            }
            int i13 = i7 + 1;
            int i14 = this.mSampleHeight;
            if (i8 >= i14) {
                i8 = i14 - 1;
            }
            int i15 = i8 + 1;
            if (i9 >= i13 || i10 >= i15) {
                iArr7[i6] = i6;
                iArr7[c5] = i6;
                iArr7[c4] = i6;
            } else {
                if (iArr6 == null) {
                    iHeight = rect.height() * rect.width();
                } else {
                    int[] iArr9 = iArr6[i15];
                    int i16 = iArr9[i13] - iArr9[i11];
                    int[] iArr10 = iArr6[i5];
                    iHeight = (i16 - iArr10[i13]) + iArr10[i11];
                }
                if (iHeight == 0) {
                    iArr7[i6] = i6;
                    iArr7[c5] = i6;
                    iArr7[c4] = i6;
                } else {
                    int[] iArr11 = iArr3[i15];
                    int i17 = iArr11[i13] - iArr11[i11];
                    int[] iArr12 = iArr3[i5];
                    iArr7[i6] = ((i17 - iArr12[i13]) + iArr12[i11]) / iHeight;
                    int[] iArr13 = iArr4[i15];
                    int i18 = iArr13[i13] - iArr13[i11];
                    int[] iArr14 = iArr4[i5];
                    iArr7[c5] = ((i18 - iArr14[i13]) + iArr14[i11]) / iHeight;
                    int[] iArr15 = iArr5[i15];
                    int i19 = iArr15[i13] - iArr15[i11];
                    int[] iArr16 = iArr5[i5];
                    iArr7[c4] = ((i19 - iArr16[i13]) + iArr16[i11]) / iHeight;
                }
            }
            i2++;
            rectArr2 = rectArr;
            c = c4;
            c2 = c5;
            i = i6;
            iArr = iArr8;
        }
        return iArr;
    }

    public long getMemoryUsage() {
        int i = this.mSampleHeight;
        int i2 = this.mSampleWidth;
        return (((long) (i + 1)) * ((long) (i2 + 1)) * 4) + (((long) (i + 1)) * 3 * ((long) (i2 + 1)) * 4);
    }

    public float getOpacityRatio(Rect rect) {
        int iHeight;
        if (this.mIsInitialized && !rect.isEmpty()) {
            float f = this.mScaleRatio;
            int i = (int) ((rect.left * f) + 0.5f);
            int i2 = (int) ((rect.top * f) + 0.5f);
            int i4 = (int) ((rect.right * f) + 0.5f);
            int i5 = (int) ((rect.bottom * f) + 0.5f);
            if (i < 0) {
                i = 0;
            }
            int i6 = i + 1;
            if (i2 < 0) {
                i2 = 0;
            }
            int i7 = i2 + 1;
            int i8 = this.mSampleWidth;
            if (i4 >= i8) {
                i4 = i8 - 1;
            }
            int i9 = i4 + 1;
            int i10 = this.mSampleHeight;
            if (i5 >= i10) {
                i5 = i10 - 1;
            }
            int i11 = i5 + 1;
            if (i6 < i9 && i7 < i11) {
                int[][] iArr = this.mIntegralCount;
                if (iArr == null) {
                    iHeight = rect.height() * rect.width();
                } else {
                    int[] iArr2 = iArr[i11];
                    int i12 = iArr2[i9] - iArr2[i];
                    int[] iArr3 = iArr[i2];
                    iHeight = iArr3[i] + (i12 - iArr3[i9]);
                }
                int i13 = (i11 - i7) * (i9 - i6);
                if (i13 > 0) {
                    return iHeight / i13;
                }
            }
        }
        return 0.0f;
    }

    public int getOpaquePixelCount(Rect rect) {
        if (this.mIsInitialized && !rect.isEmpty()) {
            float f = this.mScaleRatio;
            int i = (int) ((rect.left * f) + 0.5f);
            int i2 = (int) ((rect.top * f) + 0.5f);
            int i4 = (int) ((rect.right * f) + 0.5f);
            int i5 = (int) ((rect.bottom * f) + 0.5f);
            if (i < 0) {
                i = 0;
            }
            int i6 = i + 1;
            if (i2 < 0) {
                i2 = 0;
            }
            int i7 = i2 + 1;
            int i8 = this.mSampleWidth;
            if (i4 >= i8) {
                i4 = i8 - 1;
            }
            int i9 = i4 + 1;
            int i10 = this.mSampleHeight;
            if (i5 >= i10) {
                i5 = i10 - 1;
            }
            int i11 = i5 + 1;
            if (i6 < i9 && i7 < i11) {
                int[][] iArr = this.mIntegralCount;
                if (iArr == null) {
                    return rect.height() * rect.width();
                }
                int[] iArr2 = iArr[i11];
                int i12 = iArr2[i9] - iArr2[i];
                int[] iArr3 = iArr[i2];
                return (i12 - iArr3[i9]) + iArr3[i];
            }
        }
        return 0;
    }

    public int getOriginalHeight() {
        return this.mOriginalHeight;
    }

    public int getOriginalWidth() {
        return this.mOriginalWidth;
    }

    public int getSampleHeight() {
        return this.mSampleHeight;
    }

    public int getSampleWidth() {
        return this.mSampleWidth;
    }

    public float getScaleRatio() {
        return this.mScaleRatio;
    }

    public void printStats() {
        long memoryUsage = getMemoryUsage();
        double d = memoryUsage / 1048576.0d;
        int i = this.mOriginalWidth;
        long j = ((long) i) * ((long) this.mOriginalHeight);
        Log.i(TAG, String.format("Stats: %dx%d->%dx%d (%.1f%% pixels, ratio=%.3f) Memory=%.1fMB (%,d bytes)", Integer.valueOf(i), Integer.valueOf(this.mOriginalHeight), Integer.valueOf(this.mSampleWidth), Integer.valueOf(this.mSampleHeight), Double.valueOf((j > 0 ? (((long) this.mSampleWidth) * ((long) this.mSampleHeight)) / j : 1.0d) * 100.0d), Float.valueOf(this.mScaleRatio), Double.valueOf(d), Long.valueOf(memoryUsage)));
    }

    public boolean save(File file) {
        long jNanoTime = System.nanoTime();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file), 65536));
            try {
                objectOutputStream.writeInt(this.mOriginalWidth);
                objectOutputStream.writeInt(this.mOriginalHeight);
                objectOutputStream.writeInt(this.mSampleWidth);
                objectOutputStream.writeInt(this.mSampleHeight);
                objectOutputStream.writeFloat(this.mScaleRatio);
                objectOutputStream.writeObject(this.mIntegralSum);
                objectOutputStream.close();
                long jNanoTime2 = System.nanoTime() - jNanoTime;
                long length = file.length();
                StringBuilder sbM1323p = AbstractC1974b.m1323p(jNanoTime2, "save: took", " size: ");
                sbM1323p.append(length);
                Log.i(TAG, sbM1323p.toString());
                return true;
            } finally {
            }
        } catch (IOException e) {
            Log.e(TAG, "save failed", e);
            return false;
        }
    }

    public AverageColorExtractor(@NonNull Drawable drawable) {
        this(drawable, 256);
    }

    public int getAverageColor(Rect rect, int[] iArr) {
        int iHeight;
        if (this.mIsInitialized && !rect.isEmpty()) {
            float f = this.mScaleRatio;
            boolean z = 1.0f == f;
            int i = rect.left;
            if (!z) {
                i = (int) ((i * f) + 0.5f);
            }
            int i2 = rect.top;
            if (!z) {
                i2 = (int) ((i2 * f) + 0.5f);
            }
            int i4 = rect.right;
            if (!z) {
                i4 = (int) ((i4 * f) + 0.5f);
            }
            int i5 = z ? rect.bottom : (int) ((rect.bottom * f) + 0.5f);
            if (i < 0) {
                i = 0;
            }
            int i6 = i + 1;
            if (i2 < 0) {
                i2 = 0;
            }
            int i7 = i2 + 1;
            int i8 = this.mSampleWidth;
            if (i4 >= i8) {
                i4 = i8 - 1;
            }
            int i9 = i4 + 1;
            int i10 = this.mSampleHeight;
            if (i5 >= i10) {
                i5 = i10 - 1;
            }
            int i11 = i5 + 1;
            if (i6 < i9 && i7 < i11) {
                int[][][] iArr2 = this.mIntegralSum;
                int[][] iArr3 = iArr2[0];
                int[][] iArr4 = iArr2[1];
                int[][] iArr5 = iArr2[2];
                int[][] iArr6 = this.mIntegralCount;
                int[] iArr7 = iArr3[i11];
                int i12 = iArr7[i9] - iArr7[i];
                int[] iArr8 = iArr3[i2];
                int i13 = (i12 - iArr8[i9]) + iArr8[i];
                int[] iArr9 = iArr4[i11];
                int i14 = iArr9[i9] - iArr9[i];
                int[] iArr10 = iArr4[i2];
                int i15 = (i14 - iArr10[i9]) + iArr10[i];
                int[] iArr11 = iArr5[i11];
                int i16 = iArr11[i9] - iArr11[i];
                int[] iArr12 = iArr5[i2];
                int i17 = (i16 - iArr12[i9]) + iArr12[i];
                if (iArr6 == null) {
                    iHeight = rect.height() * rect.width();
                } else {
                    int[] iArr13 = iArr6[i11];
                    int i18 = iArr13[i9] - iArr13[i];
                    int[] iArr14 = iArr6[i2];
                    iHeight = iArr14[i] + (i18 - iArr14[i9]);
                }
                if (iHeight == 0) {
                    return 0;
                }
                int i19 = i13 / iHeight;
                int i20 = i15 / iHeight;
                int i21 = i17 / iHeight;
                if (iArr != null) {
                    iArr[0] = i19;
                    iArr[1] = i20;
                    iArr[2] = i21;
                }
                return (i19 << 16) | (-16777216) | (i20 << 8) | i21;
            }
        }
        return -16777216;
    }

    public AverageColorExtractor(@NonNull Drawable drawable, @IntRange(from = 100, m706to = 256) int i) {
        this(getBitmapFromDrawable(drawable, i), i, true);
    }

    @SuppressLint({"DefaultLocale"})
    public AverageColorExtractor(Bitmap bitmap, @IntRange(from = 100, m706to = 256) int i) {
        this(bitmap, i, false);
    }

    @SuppressLint({"DefaultLocale"})
    private AverageColorExtractor(Bitmap bitmap, @IntRange(from = 100, m706to = 256) int i, boolean z) {
        Bitmap bitmapCreateScaledBitmap;
        long jNanoTime = System.nanoTime();
        i = i > 256 ? 256 : i;
        if (bitmap != null) {
            int width = bitmap.getWidth();
            this.mOriginalWidth = width;
            int height = bitmap.getHeight();
            this.mOriginalHeight = height;
            Log.i(TAG, "validation_complete");
            int i2 = width > height ? width : height;
            if (i2 > 256) {
                float f = i / i2;
                this.mScaleRatio = f;
                int i4 = (int) ((width * f) + 0.5f);
                this.mSampleWidth = i4;
                int i5 = (int) ((height * f) + 0.5f);
                this.mSampleHeight = i5;
                Log.i(TAG, "scaling_preparation_complete");
                bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, i4, i5, true);
                Log.i(TAG, "bitmap_scaling_complete ".concat(String.format("Bitmap scaled from %dx%d to %dx%d (scale ratio: %.3f)", Integer.valueOf(width), Integer.valueOf(height), Integer.valueOf(i4), Integer.valueOf(i5), Float.valueOf(f))));
            } else {
                this.mScaleRatio = 1.0f;
                this.mSampleWidth = width;
                this.mSampleHeight = height;
                Log.d(TAG, String.format("Bitmap used as-is: %dx%d", Integer.valueOf(width), Integer.valueOf(height)));
                bitmapCreateScaledBitmap = bitmap;
            }
            int[] iArr = {3, this.mSampleHeight + 1, this.mSampleWidth + 1};
            Class cls = Integer.TYPE;
            this.mIntegralSum = (int[][][]) Array.newInstance((Class<?>) cls, iArr);
            this.mIntegralCount = (int[][]) Array.newInstance((Class<?>) cls, this.mSampleHeight + 1, this.mSampleWidth + 1);
            Log.i(TAG, "integral_array_init_complete");
            this.mIsInitialized = initializeIntegralImages(bitmapCreateScaledBitmap);
            if (z || (bitmapCreateScaledBitmap != bitmap && !bitmapCreateScaledBitmap.isRecycled())) {
                bitmapCreateScaledBitmap.recycle();
                Log.d(TAG, "Working bitmap recycled after Integral Image creation");
            }
            long jNanoTime2 = System.nanoTime() - jNanoTime;
            StringBuilder sb = new StringBuilder("AverageColorExtractor: took");
            sb.append(jNanoTime2);
            sb.append("ns ");
            sb.append(width);
            AbstractC1974b.m1330w(height, "x", " -> ", sb);
            sb.append(this.mSampleWidth);
            sb.append("x");
            sb.append(this.mSampleHeight);
            Log.i(TAG, sb.toString());
            printStats();
            return;
        }
        throw new IllegalArgumentException("Bitmap cannot be null");
    }

    private AverageColorExtractor(int i, int i2, int i4, int i5, float f, int[][][] iArr, int[][] iArr2) {
        this.mOriginalWidth = i;
        this.mOriginalHeight = i2;
        this.mSampleWidth = i4;
        this.mSampleHeight = i5;
        this.mScaleRatio = f;
        this.mIntegralSum = iArr;
        this.mIntegralCount = iArr2;
        this.mIsInitialized = true;
    }

    private AverageColorExtractor(int i, int i2, int i4, int i5, float f, int[][][] iArr) {
        this.mOriginalWidth = i;
        this.mOriginalHeight = i2;
        this.mSampleWidth = i4;
        this.mSampleHeight = i5;
        this.mScaleRatio = f;
        this.mIntegralSum = iArr;
        this.mIntegralCount = null;
        this.mIsInitialized = true;
    }
}
