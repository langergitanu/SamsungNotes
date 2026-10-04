package net.lingala.zip4j.p210io;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.util.InternalZipConstants;
import net.lingala.zip4j.util.Raw;
import net.lingala.zip4j.util.Zip4jUtil;
import org.apache.commons.lang3.SystemProperties;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class SplitOutputStream extends OutputStream {
    private long bytesWrittenForThisPart;
    private int currSplitFileCounter;
    private File outFile;
    private RandomAccessFile raf;
    private long splitLength;
    private File zipFile;

    public SplitOutputStream(String str) {
        this(Zip4jUtil.isStringNotNullAndNotEmpty(str) ? new File(str) : null);
    }

    private boolean isHeaderData(byte[] bArr) {
        if (bArr != null && bArr.length >= 4) {
            int intLittleEndian = Raw.readIntLittleEndian(bArr, 0);
            long[] allHeaderSignatures = Zip4jUtil.getAllHeaderSignatures();
            if (allHeaderSignatures != null && allHeaderSignatures.length > 0) {
                for (long j : allHeaderSignatures) {
                    if (j != 134695760 && j == intLittleEndian) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void startNextSplitFile() throws IOException {
        File file;
        try {
            String zipFileNameWithoutExt = Zip4jUtil.getZipFileNameWithoutExt(this.outFile.getName());
            String absolutePath = this.zipFile.getAbsolutePath();
            if (this.currSplitFileCounter < 9) {
                StringBuffer stringBuffer = new StringBuffer(String.valueOf(this.outFile.getParent()));
                stringBuffer.append(System.getProperty(SystemProperties.FILE_SEPARATOR));
                stringBuffer.append(zipFileNameWithoutExt);
                stringBuffer.append(".z0");
                stringBuffer.append(this.currSplitFileCounter + 1);
                file = new File(stringBuffer.toString());
            } else {
                StringBuffer stringBuffer2 = new StringBuffer(String.valueOf(this.outFile.getParent()));
                stringBuffer2.append(System.getProperty(SystemProperties.FILE_SEPARATOR));
                stringBuffer2.append(zipFileNameWithoutExt);
                stringBuffer2.append(".z");
                stringBuffer2.append(this.currSplitFileCounter + 1);
                file = new File(stringBuffer2.toString());
            }
            this.raf.close();
            if (file.exists()) {
                StringBuffer stringBuffer3 = new StringBuffer("split file: ");
                stringBuffer3.append(file.getName());
                stringBuffer3.append(" already exists in the current directory, cannot rename this file");
                throw new IOException(stringBuffer3.toString());
            }
            if (!this.zipFile.renameTo(file)) {
                throw new IOException("cannot rename newly created split file");
            }
            this.zipFile = new File(absolutePath);
            this.raf = new RandomAccessFile(this.zipFile, InternalZipConstants.WRITE_MODE);
            this.currSplitFileCounter++;
        } catch (ZipException e) {
            throw new IOException(e.getMessage());
        }
    }

    public boolean checkBuffSizeAndStartNextSplitFile(int i) throws ZipException {
        if (i < 0) {
            throw new ZipException("negative buffersize for checkBuffSizeAndStartNextSplitFile");
        }
        if (isBuffSizeFitForCurrSplitFile(i)) {
            return false;
        }
        try {
            startNextSplitFile();
            this.bytesWrittenForThisPart = 0L;
            return true;
        } catch (IOException e) {
            throw new ZipException(e);
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        RandomAccessFile randomAccessFile = this.raf;
        if (randomAccessFile != null) {
            randomAccessFile.close();
        }
    }

    public int getCurrSplitFileCounter() {
        return this.currSplitFileCounter;
    }

    public long getFilePointer() {
        return this.raf.getFilePointer();
    }

    public long getSplitLength() {
        return this.splitLength;
    }

    public boolean isBuffSizeFitForCurrSplitFile(int i) throws ZipException {
        if (i < 0) {
            throw new ZipException("negative buffersize for isBuffSizeFitForCurrSplitFile");
        }
        long j = this.splitLength;
        return j < 65536 || this.bytesWrittenForThisPart + ((long) i) <= j;
    }

    public boolean isSplitZipFile() {
        return this.splitLength != -1;
    }

    public void seek(long j) throws IOException {
        this.raf.seek(j);
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        write(new byte[]{(byte) i}, 0, 1);
    }

    public SplitOutputStream(File file) {
        this(file, -1L);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public SplitOutputStream(String str, long j) {
        this(!Zip4jUtil.isStringNotNullAndNotEmpty(str) ? new File(str) : null, j);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (i2 <= 0) {
            return;
        }
        long j = this.splitLength;
        if (j == -1) {
            this.raf.write(bArr, i, i2);
            this.bytesWrittenForThisPart += (long) i2;
            return;
        }
        if (j >= 65536) {
            long j2 = this.bytesWrittenForThisPart;
            if (j2 >= j) {
                startNextSplitFile();
                this.raf.write(bArr, i, i2);
                this.bytesWrittenForThisPart = i2;
                return;
            }
            long j3 = i2;
            if (j2 + j3 > j) {
                if (isHeaderData(bArr)) {
                    startNextSplitFile();
                    this.raf.write(bArr, i, i2);
                    this.bytesWrittenForThisPart = j3;
                    return;
                }
                this.raf.write(bArr, i, (int) (this.splitLength - this.bytesWrittenForThisPart));
                startNextSplitFile();
                RandomAccessFile randomAccessFile = this.raf;
                long j5 = this.splitLength;
                long j6 = this.bytesWrittenForThisPart;
                randomAccessFile.write(bArr, i + ((int) (j5 - j6)), (int) (j3 - (j5 - j6)));
                this.bytesWrittenForThisPart = j3 - (this.splitLength - this.bytesWrittenForThisPart);
                return;
            }
            this.raf.write(bArr, i, i2);
            this.bytesWrittenForThisPart += j3;
            return;
        }
        throw new IOException("split length less than minimum allowed split length of 65536 Bytes");
    }

    public SplitOutputStream(File file, long j) throws ZipException {
        if (j >= 0 && j < 65536) {
            throw new ZipException("split length less than minimum allowed split length of 65536 Bytes");
        }
        this.raf = new RandomAccessFile(file, InternalZipConstants.WRITE_MODE);
        this.splitLength = j;
        this.outFile = file;
        this.zipFile = file;
        this.currSplitFileCounter = 0;
        this.bytesWrittenForThisPart = 0L;
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
    }
}
