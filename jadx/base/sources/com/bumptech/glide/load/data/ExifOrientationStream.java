package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class ExifOrientationStream extends FilterInputStream {
    private static final byte[] EXIF_SEGMENT;
    private static final int ORIENTATION_POSITION;
    private static final int SEGMENT_LENGTH;
    private static final int SEGMENT_START_POSITION = 2;
    private final byte orientation;
    private int position;

    static {
        byte[] bArr = {-1, -31, 0, 28, 69, 120, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0};
        EXIF_SEGMENT = bArr;
        int length = bArr.length;
        SEGMENT_LENGTH = length;
        ORIENTATION_POSITION = length + 2;
    }

    public ExifOrientationStream(InputStream inputStream, int i) {
        super(inputStream);
        if (i < -1 || i > 8) {
            throw new IllegalArgumentException(AbstractC0000a.m11h(i, "Cannot add invalid orientation: "));
        }
        this.orientation = (byte) i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        int i;
        int i2 = this.position;
        int i4 = (i2 < 2 || i2 > (i = ORIENTATION_POSITION)) ? super.read() : i2 == i ? this.orientation : EXIF_SEGMENT[i2 - 2] & 255;
        if (i4 != -1) {
            this.position++;
        }
        return i4;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        long jSkip = super.skip(j);
        if (jSkip > 0) {
            this.position = (int) (((long) this.position) + jSkip);
        }
        return jSkip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(@NonNull byte[] bArr, int i, int i2) throws IOException {
        int i4;
        int i5 = this.position;
        int i6 = ORIENTATION_POSITION;
        if (i5 > i6) {
            i4 = super.read(bArr, i, i2);
        } else if (i5 == i6) {
            bArr[i] = this.orientation;
            i4 = 1;
        } else if (i5 < 2) {
            i4 = super.read(bArr, i, 2 - i5);
        } else {
            int iMin = Math.min(i6 - i5, i2);
            System.arraycopy(EXIF_SEGMENT, this.position - 2, bArr, i, iMin);
            i4 = iMin;
        }
        if (i4 > 0) {
            this.position += i4;
        }
        return i4;
    }
}
