package net.lingala.zip4j.p210io;

import java.io.IOException;
import java.io.RandomAccessFile;
import net.lingala.zip4j.crypto.AESDecrypter;
import net.lingala.zip4j.crypto.IDecrypter;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.unzip.UnzipEngine;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class PartInputStream extends BaseInputStream {
    private IDecrypter decrypter;
    private boolean isAESEncryptedFile;
    private long length;
    private RandomAccessFile raf;
    private UnzipEngine unzipEngine;
    private byte[] oneByteBuff = new byte[1];
    private byte[] aesBlockByte = new byte[16];
    private int aesBytesReturned = 0;
    private int count = -1;
    private long bytesRead = 0;

    public PartInputStream(RandomAccessFile randomAccessFile, long j, long j2, UnzipEngine unzipEngine) {
        this.isAESEncryptedFile = false;
        this.raf = randomAccessFile;
        this.unzipEngine = unzipEngine;
        this.decrypter = unzipEngine.getDecrypter();
        this.length = j2;
        this.isAESEncryptedFile = unzipEngine.getFileHeader().isEncrypted() && unzipEngine.getFileHeader().getEncryptionMethod() == 99;
    }

    private void checkAndReadAESMacBytes() throws IOException {
        IDecrypter iDecrypter;
        if (this.isAESEncryptedFile && (iDecrypter = this.decrypter) != null && (iDecrypter instanceof AESDecrypter) && ((AESDecrypter) iDecrypter).getStoredMac() == null) {
            byte[] bArr = new byte[10];
            int i = this.raf.read(bArr);
            if (i != 10) {
                if (!this.unzipEngine.getZipModel().isSplitArchive()) {
                    throw new IOException("Error occured while reading stored AES authentication bytes");
                }
                this.raf.close();
                RandomAccessFile randomAccessFileStartNextSplitFile = this.unzipEngine.startNextSplitFile();
                this.raf = randomAccessFileStartNextSplitFile;
                randomAccessFileStartNextSplitFile.read(bArr, i, 10 - i);
            }
            ((AESDecrypter) this.unzipEngine.getDecrypter()).setStoredMac(bArr);
        }
    }

    @Override // net.lingala.zip4j.p210io.BaseInputStream, java.io.InputStream
    public int available() {
        long j = this.length - this.bytesRead;
        if (j > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) j;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.raf.close();
    }

    @Override // net.lingala.zip4j.p210io.BaseInputStream
    public UnzipEngine getUnzipEngine() {
        return this.unzipEngine;
    }

    @Override // net.lingala.zip4j.p210io.BaseInputStream, java.io.InputStream
    public int read() {
        byte b;
        if (this.bytesRead >= this.length) {
            return -1;
        }
        if (this.isAESEncryptedFile) {
            int i = this.aesBytesReturned;
            if (i == 0 || i == 16) {
                if (read(this.aesBlockByte) == -1) {
                    return -1;
                }
                this.aesBytesReturned = 0;
            }
            byte[] bArr = this.aesBlockByte;
            int i2 = this.aesBytesReturned;
            this.aesBytesReturned = i2 + 1;
            b = bArr[i2];
        } else {
            if (read(this.oneByteBuff, 0, 1) == -1) {
                return -1;
            }
            b = this.oneByteBuff[0];
        }
        return b & 255;
    }

    @Override // net.lingala.zip4j.p210io.BaseInputStream
    public void seek(long j) {
        this.raf.seek(j);
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        if (j < 0) {
            throw new IllegalArgumentException();
        }
        long j2 = this.length;
        long j3 = this.bytesRead;
        if (j > j2 - j3) {
            j = j2 - j3;
        }
        this.bytesRead = j3 + j;
        return j;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        int i4;
        long j = i2;
        long j2 = this.length;
        long j3 = this.bytesRead;
        if (j > j2 - j3 && (i2 = (int) (j2 - j3)) == 0) {
            checkAndReadAESMacBytes();
            return -1;
        }
        if ((this.unzipEngine.getDecrypter() instanceof AESDecrypter) && this.bytesRead + ((long) i2) < this.length && (i4 = i2 % 16) != 0) {
            i2 -= i4;
        }
        synchronized (this.raf) {
            try {
                int i5 = this.raf.read(bArr, i, i2);
                this.count = i5;
                if (i5 < i2 && this.unzipEngine.getZipModel().isSplitArchive()) {
                    this.raf.close();
                    RandomAccessFile randomAccessFileStartNextSplitFile = this.unzipEngine.startNextSplitFile();
                    this.raf = randomAccessFileStartNextSplitFile;
                    if (this.count < 0) {
                        this.count = 0;
                    }
                    int i6 = this.count;
                    int i7 = randomAccessFileStartNextSplitFile.read(bArr, i6, i2 - i6);
                    if (i7 > 0) {
                        this.count += i7;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        int i8 = this.count;
        if (i8 > 0) {
            IDecrypter iDecrypter = this.decrypter;
            if (iDecrypter != null) {
                try {
                    iDecrypter.decryptData(bArr, i, i8);
                } catch (ZipException e) {
                    throw new IOException(e.getMessage());
                }
            }
            this.bytesRead += (long) this.count;
        }
        if (this.bytesRead >= this.length) {
            checkAndReadAESMacBytes();
        }
        return this.count;
    }
}
