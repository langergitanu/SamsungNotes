package net.lingala.zip4j.p210io;

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import net.lingala.zip4j.unzip.UnzipEngine;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class InflaterInputStream extends PartInputStream {
    private byte[] buff;
    private long bytesWritten;
    private Inflater inflater;
    private byte[] oneByteBuff;
    private long uncompressedSize;
    private UnzipEngine unzipEngine;

    public InflaterInputStream(RandomAccessFile randomAccessFile, long j, long j2, UnzipEngine unzipEngine) {
        super(randomAccessFile, j, j2, unzipEngine);
        this.oneByteBuff = new byte[1];
        this.inflater = new Inflater(true);
        this.buff = new byte[4096];
        this.unzipEngine = unzipEngine;
        this.bytesWritten = 0L;
        this.uncompressedSize = unzipEngine.getFileHeader().getUncompressedSize();
    }

    private void fill() throws EOFException {
        byte[] bArr = this.buff;
        int i = super.read(bArr, 0, bArr.length);
        if (i == -1) {
            throw new EOFException("Unexpected end of ZLIB input stream");
        }
        this.inflater.setInput(this.buff, 0, i);
    }

    @Override // net.lingala.zip4j.p210io.PartInputStream, net.lingala.zip4j.p210io.BaseInputStream, java.io.InputStream
    public int available() {
        return !this.inflater.finished() ? 1 : 0;
    }

    @Override // net.lingala.zip4j.p210io.PartInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.inflater.end();
        super.close();
    }

    @Override // net.lingala.zip4j.p210io.PartInputStream, net.lingala.zip4j.p210io.BaseInputStream
    public UnzipEngine getUnzipEngine() {
        return super.getUnzipEngine();
    }

    @Override // net.lingala.zip4j.p210io.PartInputStream, net.lingala.zip4j.p210io.BaseInputStream, java.io.InputStream
    public int read() {
        if (read(this.oneByteBuff, 0, 1) == -1) {
            return -1;
        }
        return this.oneByteBuff[0] & 255;
    }

    @Override // net.lingala.zip4j.p210io.PartInputStream, net.lingala.zip4j.p210io.BaseInputStream
    public void seek(long j) {
        super.seek(j);
    }

    @Override // net.lingala.zip4j.p210io.PartInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("negative skip length");
        }
        int iMin = (int) Math.min(j, 2147483647L);
        byte[] bArr = new byte[512];
        int i = 0;
        while (i < iMin) {
            int i2 = iMin - i;
            if (i2 > 512) {
                i2 = 512;
            }
            int i4 = read(bArr, 0, i2);
            if (i4 == -1) {
                break;
            }
            i += i4;
        }
        return i;
    }

    @Override // net.lingala.zip4j.p210io.PartInputStream, java.io.InputStream
    public int read(byte[] bArr) {
        if (bArr != null) {
            return read(bArr, 0, bArr.length);
        }
        throw new NullPointerException("input buffer is null");
    }

    @Override // net.lingala.zip4j.p210io.PartInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        String strConcat;
        if (bArr != null) {
            if (i < 0 || i2 < 0 || i2 > bArr.length - i) {
                throw new IndexOutOfBoundsException();
            }
            if (i2 == 0) {
                return 0;
            }
            try {
                if (this.bytesWritten >= this.uncompressedSize) {
                    return -1;
                }
                while (true) {
                    int iInflate = this.inflater.inflate(bArr, i, i2);
                    if (iInflate != 0) {
                        this.bytesWritten += (long) iInflate;
                        return iInflate;
                    }
                    if (this.inflater.finished() || this.inflater.needsDictionary()) {
                        break;
                    }
                    if (this.inflater.needsInput()) {
                        fill();
                    }
                }
                return -1;
            } catch (DataFormatException e) {
                if (e.getMessage() != null) {
                    strConcat = e.getMessage();
                } else {
                    strConcat = "Invalid ZLIB data format";
                }
                UnzipEngine unzipEngine = this.unzipEngine;
                if (unzipEngine != null && unzipEngine.getLocalFileHeader().isEncrypted() && this.unzipEngine.getLocalFileHeader().getEncryptionMethod() == 0) {
                    strConcat = String.valueOf(strConcat).concat(" - Wrong Password?");
                }
                throw new IOException(strConcat);
            }
        }
        throw new NullPointerException("input buffer is null");
    }
}
