package org.apache.poi.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class LittleEndian implements LittleEndianConsts {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class BufferUnderrunException extends IOException {
        private static final long serialVersionUID = 8736973884877006145L;

        public BufferUnderrunException() {
            super("buffer underrun");
        }
    }

    private LittleEndian() {
    }

    public static byte[] getByteArray(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return bArr2;
    }

    public static double getDouble(byte[] bArr) {
        return Double.longBitsToDouble(getLong(bArr, 0));
    }

    public static float getFloat(byte[] bArr) {
        return getFloat(bArr, 0);
    }

    public static int getInt(byte[] bArr) {
        return getInt(bArr, 0);
    }

    public static long getLong(byte[] bArr) {
        return getLong(bArr, 0);
    }

    public static short getShort(byte[] bArr) {
        return getShort(bArr, 0);
    }

    public static short[] getShortArray(byte[] bArr, int i, int i2) {
        int i4 = i2 / 2;
        short[] sArr = new short[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            sArr[i5] = getShort(bArr, (i5 * 2) + i);
        }
        return sArr;
    }

    public static short getUByte(byte[] bArr) {
        return (short) (bArr[0] & 255);
    }

    public static long getUInt(byte[] bArr) {
        return getUInt(bArr, 0);
    }

    public static int getUShort(byte[] bArr) {
        return getUShort(bArr, 0);
    }

    public static void putByte(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) i2;
    }

    public static void putDouble(byte[] bArr, int i, double d) {
        putLong(bArr, i, Double.doubleToLongBits(d));
    }

    public static void putFloat(byte[] bArr, int i, float f) {
        putInt(bArr, i, Float.floatToIntBits(f));
    }

    public static void putInt(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) (i2 & 255);
        bArr[i + 1] = (byte) ((i2 >>> 8) & 255);
        bArr[i + 2] = (byte) ((i2 >>> 16) & 255);
        bArr[i + 3] = (byte) ((i2 >>> 24) & 255);
    }

    public static void putLong(byte[] bArr, int i, long j) {
        bArr[i] = (byte) (j & 255);
        bArr[i + 1] = (byte) ((j >>> 8) & 255);
        bArr[i + 2] = (byte) ((j >>> 16) & 255);
        bArr[i + 3] = (byte) ((j >>> 24) & 255);
        bArr[i + 4] = (byte) ((j >>> 32) & 255);
        bArr[i + 5] = (byte) ((j >>> 40) & 255);
        bArr[i + 6] = (byte) ((j >>> 48) & 255);
        bArr[i + 7] = (byte) ((j >>> 56) & 255);
    }

    public static void putShort(byte[] bArr, int i, short s) {
        bArr[i] = (byte) (s & 255);
        bArr[i + 1] = (byte) ((s >>> 8) & 255);
    }

    public static void putShortArray(byte[] bArr, int i, short[] sArr) {
        for (short s : sArr) {
            putShort(bArr, i, s);
            i += 2;
        }
    }

    public static void putUByte(byte[] bArr, int i, short s) {
        bArr[i] = (byte) (s & 255);
    }

    public static void putUInt(byte[] bArr, int i, long j) {
        bArr[i] = (byte) (j & 255);
        bArr[i + 1] = (byte) ((j >>> 8) & 255);
        bArr[i + 2] = (byte) ((j >>> 16) & 255);
        bArr[i + 3] = (byte) ((j >>> 24) & 255);
    }

    public static void putUShort(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) (i2 & 255);
        bArr[i + 1] = (byte) ((i2 >>> 8) & 255);
    }

    public static int readInt(InputStream inputStream) throws IOException {
        int i = inputStream.read();
        int i2 = inputStream.read();
        int i4 = inputStream.read();
        int i5 = inputStream.read();
        if ((i | i2 | i4 | i5) >= 0) {
            return (i5 << 24) + (i4 << 16) + (i2 << 8) + i;
        }
        throw new BufferUnderrunException();
    }

    public static long readLong(InputStream inputStream) throws IOException {
        int i = inputStream.read();
        int i2 = inputStream.read();
        int i4 = inputStream.read();
        int i5 = inputStream.read();
        int i6 = inputStream.read();
        int i7 = inputStream.read();
        int i8 = inputStream.read();
        int i9 = inputStream.read();
        if ((i | i2 | i4 | i5 | i6 | i7 | i8 | i9) >= 0) {
            return (((long) i9) << 56) + (((long) i8) << 48) + (((long) i7) << 40) + (((long) i6) << 32) + (((long) i5) << 24) + ((long) (i4 << 16)) + ((long) (i2 << 8)) + ((long) i);
        }
        throw new BufferUnderrunException();
    }

    public static short readShort(InputStream inputStream) {
        return (short) readUShort(inputStream);
    }

    public static long readUInt(InputStream inputStream) {
        return ((long) readInt(inputStream)) & 4294967295L;
    }

    public static int readUShort(InputStream inputStream) throws IOException {
        int i = inputStream.read();
        int i2 = inputStream.read();
        if ((i | i2) >= 0) {
            return (i2 << 8) + i;
        }
        throw new BufferUnderrunException();
    }

    public static int ubyteToInt(byte b) {
        return b & 255;
    }

    public static double getDouble(byte[] bArr, int i) {
        return Double.longBitsToDouble(getLong(bArr, i));
    }

    public static float getFloat(byte[] bArr, int i) {
        return Float.intBitsToFloat(getInt(bArr, i));
    }

    public static int getInt(byte[] bArr, int i) {
        int i2 = bArr[i] & 255;
        int i4 = bArr[i + 1] & 255;
        return ((bArr[i + 3] & 255) << 24) + ((bArr[i + 2] & 255) << 16) + (i4 << 8) + i2;
    }

    public static long getLong(byte[] bArr, int i) {
        long j = bArr[i + 7] & 255;
        for (int i2 = i + 7; i2 >= i; i2--) {
            j = (j << 8) | ((long) (bArr[i2] & 255));
        }
        return j;
    }

    public static short getShort(byte[] bArr, int i) {
        return (short) (((bArr[i + 1] & 255) << 8) + (bArr[i] & 255));
    }

    public static short getUByte(byte[] bArr, int i) {
        return (short) (bArr[i] & 255);
    }

    public static long getUInt(byte[] bArr, int i) {
        return ((long) getInt(bArr, i)) & 4294967295L;
    }

    public static int getUShort(byte[] bArr, int i) {
        return ((bArr[i + 1] & 255) << 8) + (bArr[i] & 255);
    }

    public static void putDouble(double d, OutputStream outputStream) throws IOException {
        putLong(Double.doubleToLongBits(d), outputStream);
    }

    public static void putFloat(float f, OutputStream outputStream) throws IOException {
        putInt(Float.floatToIntBits(f), outputStream);
    }

    public static void putShort(OutputStream outputStream, short s) throws IOException {
        outputStream.write((byte) (s & 255));
        outputStream.write((byte) ((s >>> 8) & 255));
    }

    public static void putUShort(int i, OutputStream outputStream) throws IOException {
        outputStream.write((byte) (i & 255));
        outputStream.write((byte) ((i >>> 8) & 255));
    }

    public static void putInt(int i, OutputStream outputStream) throws IOException {
        outputStream.write((byte) (i & 255));
        outputStream.write((byte) ((i >>> 8) & 255));
        outputStream.write((byte) ((i >>> 16) & 255));
        outputStream.write((byte) ((i >>> 24) & 255));
    }

    public static void putUInt(long j, OutputStream outputStream) throws IOException {
        outputStream.write((byte) (j & 255));
        outputStream.write((byte) ((j >>> 8) & 255));
        outputStream.write((byte) ((j >>> 16) & 255));
        outputStream.write((byte) ((j >>> 24) & 255));
    }

    public static void putLong(long j, OutputStream outputStream) throws IOException {
        outputStream.write((byte) (j & 255));
        outputStream.write((byte) ((j >>> 8) & 255));
        outputStream.write((byte) ((j >>> 16) & 255));
        outputStream.write((byte) ((j >>> 24) & 255));
        outputStream.write((byte) ((j >>> 32) & 255));
        outputStream.write((byte) ((j >>> 40) & 255));
        outputStream.write((byte) ((j >>> 48) & 255));
        outputStream.write((byte) ((j >>> 56) & 255));
    }
}
