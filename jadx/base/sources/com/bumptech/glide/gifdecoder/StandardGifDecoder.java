package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.compose.runtime.AbstractC1974b;
import androidx.fragment.app.FragmentTransaction;
import com.bumptech.glide.gifdecoder.GifDecoder;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class StandardGifDecoder implements GifDecoder {
    private static final int BYTES_PER_INTEGER = 4;

    @ColorInt
    private static final int COLOR_TRANSPARENT_BLACK = 0;
    private static final int INITIAL_FRAME_POINTER = -1;
    private static final int MASK_INT_LOWEST_BYTE = 255;
    private static final int MAX_STACK_SIZE = 4096;
    private static final int NULL_CODE = -1;
    private static final String TAG = "StandardGifDecoder";

    @ColorInt
    private int[] act;

    @NonNull
    private Bitmap.Config bitmapConfig;
    private final GifDecoder.BitmapProvider bitmapProvider;
    private byte[] block;
    private int downsampledHeight;
    private int downsampledWidth;
    private int framePointer;
    private GifHeader header;

    @Nullable
    private Boolean isFirstFrameTransparent;
    private byte[] mainPixels;

    @ColorInt
    private int[] mainScratch;
    private GifHeaderParser parser;

    @ColorInt
    private final int[] pct;
    private byte[] pixelStack;
    private short[] prefix;
    private Bitmap previousImage;
    private ByteBuffer rawData;
    private int sampleSize;
    private boolean savePrevious;
    private int status;
    private byte[] suffix;

    public StandardGifDecoder(@NonNull GifDecoder.BitmapProvider bitmapProvider, GifHeader gifHeader, ByteBuffer byteBuffer) {
        this(bitmapProvider, gifHeader, byteBuffer, 1);
    }

    @ColorInt
    private int averageColorsNear(int i, int i2, int i4) {
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        for (int i10 = i; i10 < this.sampleSize + i; i10++) {
            byte[] bArr = this.mainPixels;
            if (i10 >= bArr.length || i10 >= i2) {
                break;
            }
            int i11 = this.act[bArr[i10] & 255];
            if (i11 != 0) {
                i5 += (i11 >> 24) & 255;
                i6 += (i11 >> 16) & 255;
                i7 += (i11 >> 8) & 255;
                i8 += i11 & 255;
                i9++;
            }
        }
        int i12 = i + i4;
        for (int i13 = i12; i13 < this.sampleSize + i12; i13++) {
            byte[] bArr2 = this.mainPixels;
            if (i13 >= bArr2.length || i13 >= i2) {
                break;
            }
            int i14 = this.act[bArr2[i13] & 255];
            if (i14 != 0) {
                i5 += (i14 >> 24) & 255;
                i6 += (i14 >> 16) & 255;
                i7 += (i14 >> 8) & 255;
                i8 += i14 & 255;
                i9++;
            }
        }
        if (i9 == 0) {
            return 0;
        }
        return ((i5 / i9) << 24) | ((i6 / i9) << 16) | ((i7 / i9) << 8) | (i8 / i9);
    }

    private void copyCopyIntoScratchRobust(GifFrame gifFrame) {
        int i;
        int i2;
        int i4;
        int i5;
        int[] iArr = this.mainScratch;
        int i6 = gifFrame.f1974ih;
        int i7 = this.sampleSize;
        int i8 = i6 / i7;
        int i9 = gifFrame.f1977iy / i7;
        int i10 = gifFrame.f1975iw / i7;
        int i11 = gifFrame.f1976ix / i7;
        boolean z = this.framePointer == 0;
        int i12 = this.downsampledWidth;
        int i13 = this.downsampledHeight;
        byte[] bArr = this.mainPixels;
        int[] iArr2 = this.act;
        Boolean bool = this.isFirstFrameTransparent;
        int i14 = 8;
        int i15 = 0;
        int i16 = 0;
        int i17 = 1;
        while (i16 < i8) {
            int[] iArr3 = iArr;
            if (gifFrame.interlace) {
                if (i15 >= i8) {
                    int i18 = i17 + 1;
                    i = i8;
                    if (i18 == 2) {
                        i17 = i18;
                        i15 = 4;
                    } else if (i18 == 3) {
                        i17 = i18;
                        i14 = 4;
                        i15 = 2;
                    } else if (i18 != 4) {
                        i17 = i18;
                    } else {
                        i17 = i18;
                        i15 = 1;
                        i14 = 2;
                    }
                } else {
                    i = i8;
                }
                i2 = i15 + i14;
            } else {
                i = i8;
                i2 = i15;
                i15 = i16;
            }
            int i19 = i15 + i9;
            boolean z2 = i7 == 1;
            if (i19 < i13) {
                int i20 = i19 * i12;
                int i21 = i20 + i11;
                i4 = i2;
                int i22 = i21 + i10;
                int i23 = i20 + i12;
                if (i23 < i22) {
                    i22 = i23;
                }
                i5 = i9;
                int i24 = i16 * i7 * gifFrame.f1975iw;
                if (z2) {
                    while (i21 < i22) {
                        int i25 = iArr2[bArr[i24] & 255];
                        if (i25 != 0) {
                            iArr3[i21] = i25;
                        } else if (z && bool == null) {
                            bool = Boolean.TRUE;
                        }
                        i24 += i7;
                        i21++;
                    }
                } else {
                    int iM1304A = AbstractC1974b.m1304A(i22, i21, i7, i24);
                    while (i21 < i22) {
                        int i26 = i22;
                        int iAverageColorsNear = averageColorsNear(i24, iM1304A, gifFrame.f1975iw);
                        if (iAverageColorsNear != 0) {
                            iArr3[i21] = iAverageColorsNear;
                        } else if (z && bool == null) {
                            bool = Boolean.TRUE;
                        }
                        i24 += i7;
                        i21++;
                        i22 = i26;
                    }
                }
            } else {
                i4 = i2;
                i5 = i9;
            }
            i16++;
            iArr = iArr3;
            i8 = i;
            i15 = i4;
            i9 = i5;
        }
        if (this.isFirstFrameTransparent == null) {
            this.isFirstFrameTransparent = Boolean.valueOf(bool == null ? false : bool.booleanValue());
        }
    }

    private void copyIntoScratchFast(GifFrame gifFrame) {
        GifFrame gifFrame2 = gifFrame;
        int[] iArr = this.mainScratch;
        int i = gifFrame2.f1974ih;
        int i2 = gifFrame2.f1977iy;
        int i4 = gifFrame2.f1975iw;
        int i5 = gifFrame2.f1976ix;
        boolean z = this.framePointer == 0;
        int i6 = this.downsampledWidth;
        byte[] bArr = this.mainPixels;
        int[] iArr2 = this.act;
        int i7 = 0;
        byte b = -1;
        while (i7 < i) {
            int i8 = (i7 + i2) * i6;
            int i9 = i8 + i5;
            int i10 = i9 + i4;
            int i11 = i8 + i6;
            if (i11 < i10) {
                i10 = i11;
            }
            int i12 = gifFrame2.f1975iw * i7;
            int i13 = i9;
            while (i13 < i10) {
                byte b5 = bArr[i12];
                int[] iArr3 = iArr;
                int i14 = b5 & 255;
                if (i14 != b) {
                    int i15 = iArr2[i14];
                    if (i15 != 0) {
                        iArr3[i13] = i15;
                    } else {
                        b = b5;
                    }
                }
                i12++;
                i13++;
                iArr = iArr3;
            }
            i7++;
            gifFrame2 = gifFrame;
        }
        Boolean bool = this.isFirstFrameTransparent;
        this.isFirstFrameTransparent = Boolean.valueOf((bool != null && bool.booleanValue()) || (this.isFirstFrameTransparent == null && z && b != -1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v15, types: [short] */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    private void decodeBitmapData(GifFrame gifFrame) {
        int i;
        int i2;
        byte[] bArr;
        short s;
        StandardGifDecoder standardGifDecoder = this;
        if (gifFrame != null) {
            standardGifDecoder.rawData.position(gifFrame.bufferFrameStart);
        }
        if (gifFrame == null) {
            GifHeader gifHeader = standardGifDecoder.header;
            i = gifHeader.width;
            i2 = gifHeader.height;
        } else {
            i = gifFrame.f1975iw;
            i2 = gifFrame.f1974ih;
        }
        int i4 = i * i2;
        byte[] bArr2 = standardGifDecoder.mainPixels;
        if (bArr2 == null || bArr2.length < i4) {
            standardGifDecoder.mainPixels = standardGifDecoder.bitmapProvider.obtainByteArray(i4);
        }
        byte[] bArr3 = standardGifDecoder.mainPixels;
        if (standardGifDecoder.prefix == null) {
            standardGifDecoder.prefix = new short[4096];
        }
        short[] sArr = standardGifDecoder.prefix;
        if (standardGifDecoder.suffix == null) {
            standardGifDecoder.suffix = new byte[4096];
        }
        byte[] bArr4 = standardGifDecoder.suffix;
        if (standardGifDecoder.pixelStack == null) {
            standardGifDecoder.pixelStack = new byte[FragmentTransaction.TRANSIT_FRAGMENT_OPEN];
        }
        byte[] bArr5 = standardGifDecoder.pixelStack;
        int i5 = standardGifDecoder.readByte();
        int i6 = 1 << i5;
        int i7 = i6 + 1;
        int i8 = i6 + 2;
        int i9 = i5 + 1;
        int i10 = (1 << i9) - 1;
        byte b = 0;
        for (int i11 = 0; i11 < i6; i11++) {
            sArr[i11] = 0;
            bArr4[i11] = (byte) i11;
        }
        byte[] bArr6 = standardGifDecoder.block;
        int i12 = i9;
        int i13 = i8;
        int i14 = i10;
        int i15 = 0;
        int block = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        int i22 = -1;
        while (true) {
            if (i15 >= i4) {
                break;
            }
            if (block == 0) {
                block = standardGifDecoder.readBlock();
                if (block <= 0) {
                    standardGifDecoder.status = 3;
                    break;
                }
                i16 = b;
            }
            i18 += (bArr6[i16] & 255) << i17;
            i16++;
            block--;
            int i23 = i17 + 8;
            int i24 = i13;
            int i25 = i12;
            int i26 = i22;
            short[] sArr2 = sArr;
            int i27 = i20;
            while (true) {
                bArr = bArr4;
                if (i23 < i25) {
                    i13 = i24;
                    i20 = i27;
                    break;
                }
                int i28 = i18 & i14;
                i18 >>= i25;
                i23 -= i25;
                if (i28 == i6) {
                    i25 = i9;
                    i24 = i8;
                    i14 = i10;
                    bArr4 = bArr;
                    i26 = -1;
                } else {
                    if (i28 == i7) {
                        i20 = i27;
                        i13 = i24;
                        break;
                    }
                    byte[] bArr7 = bArr5;
                    if (i26 == -1) {
                        bArr3[i19] = bArr[i28];
                        i19++;
                        i15++;
                        i26 = i28;
                        i27 = i26;
                        bArr4 = bArr;
                        bArr5 = bArr7;
                    } else {
                        if (i28 >= i24) {
                            bArr7[i21] = (byte) i27;
                            i21++;
                            s = i26;
                        } else {
                            s = i28;
                        }
                        while (s >= i6) {
                            bArr7[i21] = bArr[s];
                            i21++;
                            s = sArr2[s];
                        }
                        int i29 = bArr[s] & 255;
                        byte b5 = (byte) i29;
                        bArr3[i19] = b5;
                        while (true) {
                            i19++;
                            i15++;
                            if (i21 <= 0) {
                                break;
                            }
                            i21--;
                            bArr3[i19] = bArr7[i21];
                        }
                        if (i24 < 4096) {
                            sArr2[i24] = (short) i26;
                            bArr[i24] = b5;
                            i24++;
                            if ((i24 & i14) == 0 && i24 < 4096) {
                                i25++;
                                i14 += i24;
                            }
                        }
                        i26 = i28;
                        bArr4 = bArr;
                        bArr5 = bArr7;
                        i27 = i29;
                    }
                }
            }
            i17 = i23;
            sArr = sArr2;
            bArr4 = bArr;
            b = 0;
            i22 = i26;
            i12 = i25;
            standardGifDecoder = this;
        }
        Arrays.fill(bArr3, i19, i4, b);
    }

    @NonNull
    private GifHeaderParser getHeaderParser() {
        if (this.parser == null) {
            this.parser = new GifHeaderParser();
        }
        return this.parser;
    }

    private Bitmap getNextBitmap() {
        Boolean bool = this.isFirstFrameTransparent;
        Bitmap bitmapObtain = this.bitmapProvider.obtain(this.downsampledWidth, this.downsampledHeight, (bool == null || bool.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.bitmapConfig);
        bitmapObtain.setHasAlpha(true);
        return bitmapObtain;
    }

    private int readBlock() {
        int i = readByte();
        if (i <= 0) {
            return i;
        }
        ByteBuffer byteBuffer = this.rawData;
        byteBuffer.get(this.block, 0, Math.min(i, byteBuffer.remaining()));
        return i;
    }

    private int readByte() {
        return this.rawData.get() & 255;
    }

    private Bitmap setPixels(GifFrame gifFrame, GifFrame gifFrame2) {
        int i;
        int i2;
        Bitmap bitmap;
        int[] iArr = this.mainScratch;
        int i4 = 0;
        if (gifFrame2 == null) {
            Bitmap bitmap2 = this.previousImage;
            if (bitmap2 != null) {
                this.bitmapProvider.release(bitmap2);
            }
            this.previousImage = null;
            Arrays.fill(iArr, 0);
        }
        if (gifFrame2 != null && gifFrame2.dispose == 3 && this.previousImage == null) {
            Arrays.fill(iArr, 0);
        }
        if (gifFrame2 != null && (i2 = gifFrame2.dispose) > 0) {
            if (i2 == 2) {
                if (!gifFrame.transparency) {
                    GifHeader gifHeader = this.header;
                    int i5 = gifHeader.bgColor;
                    if (gifFrame.lct == null || gifHeader.bgIndex != gifFrame.transIndex) {
                        i4 = i5;
                    }
                }
                int i6 = gifFrame2.f1974ih;
                int i7 = this.sampleSize;
                int i8 = i6 / i7;
                int i9 = gifFrame2.f1977iy / i7;
                int i10 = gifFrame2.f1975iw / i7;
                int i11 = gifFrame2.f1976ix / i7;
                int i12 = this.downsampledWidth;
                int i13 = (i9 * i12) + i11;
                int i14 = (i8 * i12) + i13;
                while (i13 < i14) {
                    int i15 = i13 + i10;
                    for (int i16 = i13; i16 < i15; i16++) {
                        iArr[i16] = i4;
                    }
                    i13 += this.downsampledWidth;
                }
            } else if (i2 == 3 && (bitmap = this.previousImage) != null) {
                int i17 = this.downsampledWidth;
                bitmap.getPixels(iArr, 0, i17, 0, 0, i17, this.downsampledHeight);
            }
        }
        decodeBitmapData(gifFrame);
        if (gifFrame.interlace || this.sampleSize != 1) {
            copyCopyIntoScratchRobust(gifFrame);
        } else {
            copyIntoScratchFast(gifFrame);
        }
        if (this.savePrevious && ((i = gifFrame.dispose) == 0 || i == 1)) {
            if (this.previousImage == null) {
                this.previousImage = getNextBitmap();
            }
            Bitmap bitmap3 = this.previousImage;
            int i18 = this.downsampledWidth;
            bitmap3.setPixels(iArr, 0, i18, 0, 0, i18, this.downsampledHeight);
        }
        Bitmap nextBitmap = getNextBitmap();
        int i19 = this.downsampledWidth;
        nextBitmap.setPixels(iArr, 0, i19, 0, 0, i19, this.downsampledHeight);
        return nextBitmap;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void advance() {
        this.framePointer = (this.framePointer + 1) % this.header.frameCount;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void clear() {
        this.header = null;
        byte[] bArr = this.mainPixels;
        if (bArr != null) {
            this.bitmapProvider.release(bArr);
        }
        int[] iArr = this.mainScratch;
        if (iArr != null) {
            this.bitmapProvider.release(iArr);
        }
        Bitmap bitmap = this.previousImage;
        if (bitmap != null) {
            this.bitmapProvider.release(bitmap);
        }
        this.previousImage = null;
        this.rawData = null;
        this.isFirstFrameTransparent = null;
        byte[] bArr2 = this.block;
        if (bArr2 != null) {
            this.bitmapProvider.release(bArr2);
        }
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getByteSize() {
        return (this.mainScratch.length * 4) + this.rawData.limit() + this.mainPixels.length;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getCurrentFrameIndex() {
        return this.framePointer;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    @NonNull
    public ByteBuffer getData() {
        return this.rawData;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getDelay(int i) {
        if (i < 0) {
            return -1;
        }
        GifHeader gifHeader = this.header;
        if (i < gifHeader.frameCount) {
            return gifHeader.frames.get(i).delay;
        }
        return -1;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getFrameCount() {
        return this.header.frameCount;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getHeight() {
        return this.header.height;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    @Deprecated
    public int getLoopCount() {
        int i = this.header.loopCount;
        if (i == -1) {
            return 1;
        }
        return i;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getNetscapeLoopCount() {
        return this.header.loopCount;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getNextDelay() {
        int i;
        if (this.header.frameCount <= 0 || (i = this.framePointer) < 0) {
            return 0;
        }
        return getDelay(i);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    @Nullable
    public synchronized Bitmap getNextFrame() {
        try {
            if (this.header.frameCount <= 0 || this.framePointer < 0) {
                String str = TAG;
                if (Log.isLoggable(str, 3)) {
                    Log.d(str, "Unable to decode frame, frameCount=" + this.header.frameCount + ", framePointer=" + this.framePointer);
                }
                this.status = 1;
            }
            int i = this.status;
            if (i != 1 && i != 2) {
                this.status = 0;
                if (this.block == null) {
                    this.block = this.bitmapProvider.obtainByteArray(255);
                }
                GifFrame gifFrame = this.header.frames.get(this.framePointer);
                int i2 = this.framePointer - 1;
                GifFrame gifFrame2 = i2 >= 0 ? this.header.frames.get(i2) : null;
                int[] iArr = gifFrame.lct;
                if (iArr == null) {
                    iArr = this.header.gct;
                }
                this.act = iArr;
                if (iArr == null) {
                    String str2 = TAG;
                    if (Log.isLoggable(str2, 3)) {
                        Log.d(str2, "No valid color table found for frame #" + this.framePointer);
                    }
                    this.status = 1;
                    return null;
                }
                if (gifFrame.transparency) {
                    System.arraycopy(iArr, 0, this.pct, 0, iArr.length);
                    int[] iArr2 = this.pct;
                    this.act = iArr2;
                    iArr2[gifFrame.transIndex] = 0;
                    if (gifFrame.dispose == 2 && this.framePointer == 0) {
                        this.isFirstFrameTransparent = Boolean.TRUE;
                    }
                }
                return setPixels(gifFrame, gifFrame2);
            }
            String str3 = TAG;
            if (Log.isLoggable(str3, 3)) {
                Log.d(str3, "Unable to decode frame, status=" + this.status);
            }
            return null;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getStatus() {
        return this.status;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getTotalIterationCount() {
        int i = this.header.loopCount;
        if (i == -1) {
            return 1;
        }
        if (i == 0) {
            return 0;
        }
        return i + 1;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getWidth() {
        return this.header.width;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int read(@Nullable InputStream inputStream, int i) {
        if (inputStream != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i > 0 ? i + 4096 : 16384);
                byte[] bArr = new byte[16384];
                while (true) {
                    int i2 = inputStream.read(bArr, 0, 16384);
                    if (i2 == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i2);
                }
                byteArrayOutputStream.flush();
                read(byteArrayOutputStream.toByteArray());
            } catch (IOException e) {
                Log.w(TAG, "Error reading data from stream", e);
            }
        } else {
            this.status = 2;
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e2) {
                Log.w(TAG, "Error closing stream", e2);
            }
        }
        return this.status;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void resetFrameIndex() {
        this.framePointer = -1;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public synchronized void setData(@NonNull GifHeader gifHeader, @NonNull byte[] bArr) {
        setData(gifHeader, ByteBuffer.wrap(bArr));
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void setDefaultBitmapConfig(@NonNull Bitmap.Config config) {
        Bitmap.Config config2;
        Bitmap.Config config3 = Bitmap.Config.ARGB_8888;
        if (config == config3 || config == (config2 = Bitmap.Config.RGB_565)) {
            this.bitmapConfig = config;
            return;
        }
        throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + config3 + " or " + config2);
    }

    public StandardGifDecoder(@NonNull GifDecoder.BitmapProvider bitmapProvider, GifHeader gifHeader, ByteBuffer byteBuffer, int i) {
        this(bitmapProvider);
        setData(gifHeader, byteBuffer, i);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public synchronized void setData(@NonNull GifHeader gifHeader, @NonNull ByteBuffer byteBuffer) {
        setData(gifHeader, byteBuffer, 1);
    }

    public StandardGifDecoder(@NonNull GifDecoder.BitmapProvider bitmapProvider) {
        this.pct = new int[256];
        this.bitmapConfig = Bitmap.Config.ARGB_8888;
        this.bitmapProvider = bitmapProvider;
        this.header = new GifHeader();
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public synchronized void setData(@NonNull GifHeader gifHeader, @NonNull ByteBuffer byteBuffer, int i) {
        try {
            if (i > 0) {
                int iHighestOneBit = Integer.highestOneBit(i);
                this.status = 0;
                this.header = gifHeader;
                this.framePointer = -1;
                ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
                this.rawData = byteBufferAsReadOnlyBuffer;
                byteBufferAsReadOnlyBuffer.position(0);
                this.rawData.order(ByteOrder.LITTLE_ENDIAN);
                this.savePrevious = false;
                Iterator<GifFrame> it = gifHeader.frames.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (it.next().dispose == 3) {
                        this.savePrevious = true;
                        break;
                    }
                }
                this.sampleSize = iHighestOneBit;
                int i2 = gifHeader.width;
                this.downsampledWidth = i2 / iHighestOneBit;
                int i4 = gifHeader.height;
                this.downsampledHeight = i4 / iHighestOneBit;
                this.mainPixels = this.bitmapProvider.obtainByteArray(i2 * i4);
                this.mainScratch = this.bitmapProvider.obtainIntArray(this.downsampledWidth * this.downsampledHeight);
            } else {
                throw new IllegalArgumentException("Sample size must be >=0, not: " + i);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public synchronized int read(@Nullable byte[] bArr) {
        try {
            GifHeader header = getHeaderParser().setData(bArr).parseHeader();
            this.header = header;
            if (bArr != null) {
                setData(header, bArr);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.status;
    }
}
