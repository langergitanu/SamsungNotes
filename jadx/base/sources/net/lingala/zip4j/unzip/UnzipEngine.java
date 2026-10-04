package net.lingala.zip4j.unzip;

import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.zip.CRC32;
import net.lingala.zip4j.core.HeaderReader;
import net.lingala.zip4j.crypto.AESDecrypter;
import net.lingala.zip4j.crypto.IDecrypter;
import net.lingala.zip4j.crypto.StandardDecrypter;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.AESExtraDataRecord;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.LocalFileHeader;
import net.lingala.zip4j.model.UnzipParameters;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.p210io.InflaterInputStream;
import net.lingala.zip4j.p210io.PartInputStream;
import net.lingala.zip4j.p210io.ZipInputStream;
import net.lingala.zip4j.progress.ProgressMonitor;
import net.lingala.zip4j.util.Raw;
import net.lingala.zip4j.util.Zip4jUtil;
import org.apache.commons.lang3.SystemProperties;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class UnzipEngine {
    private CRC32 crc;
    private int currSplitFileCounter = 0;
    private IDecrypter decrypter;
    private FileHeader fileHeader;
    private LocalFileHeader localFileHeader;
    private ZipModel zipModel;

    public UnzipEngine(ZipModel zipModel, FileHeader fileHeader) throws ZipException {
        if (zipModel == null || fileHeader == null) {
            throw new ZipException("Invalid parameters passed to StoreUnzip. One or more of the parameters were null");
        }
        this.zipModel = zipModel;
        this.fileHeader = fileHeader;
        this.crc = new CRC32();
    }

    private int calculateAESSaltLength(AESExtraDataRecord aESExtraDataRecord) throws ZipException {
        if (aESExtraDataRecord == null) {
            throw new ZipException("unable to determine salt length: AESExtraDataRecord is null");
        }
        int aesStrength = aESExtraDataRecord.getAesStrength();
        if (aesStrength == 1) {
            return 8;
        }
        if (aesStrength == 2) {
            return 12;
        }
        if (aesStrength == 3) {
            return 16;
        }
        throw new ZipException("unable to determine salt length: invalid aes key strength");
    }

    private boolean checkLocalHeader() {
        RandomAccessFile randomAccessFile = null;
        try {
            try {
                RandomAccessFile randomAccessFileCheckSplitFile = checkSplitFile();
                if (randomAccessFileCheckSplitFile == null) {
                    randomAccessFileCheckSplitFile = new RandomAccessFile(new File(this.zipModel.getZipFile()), "r");
                }
                LocalFileHeader localFileHeader = new HeaderReader(randomAccessFileCheckSplitFile).readLocalFileHeader(this.fileHeader);
                this.localFileHeader = localFileHeader;
                if (localFileHeader == null) {
                    throw new ZipException("error reading local file header. Is this a valid zip file?");
                }
                if (localFileHeader.getCompressionMethod() != this.fileHeader.getCompressionMethod()) {
                    try {
                        randomAccessFileCheckSplitFile.close();
                        return false;
                    } catch (IOException | Exception unused) {
                        return false;
                    }
                }
                try {
                    randomAccessFileCheckSplitFile.close();
                    return true;
                } catch (IOException | Exception unused2) {
                    return true;
                }
            } catch (FileNotFoundException e) {
                throw new ZipException(e);
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    randomAccessFile.close();
                } catch (IOException | Exception unused3) {
                }
            }
            throw th;
        }
    }

    private RandomAccessFile checkSplitFile() throws ZipException {
        String string;
        if (!this.zipModel.isSplitArchive()) {
            return null;
        }
        int diskNumberStart = this.fileHeader.getDiskNumberStart();
        int i = diskNumberStart + 1;
        this.currSplitFileCounter = i;
        String zipFile = this.zipModel.getZipFile();
        if (diskNumberStart == this.zipModel.getEndCentralDirRecord().getNoOfThisDisk()) {
            string = this.zipModel.getZipFile();
        } else if (diskNumberStart >= 9) {
            StringBuffer stringBuffer = new StringBuffer(String.valueOf(zipFile.substring(0, zipFile.lastIndexOf(Extension.DOT))));
            stringBuffer.append(".z");
            stringBuffer.append(i);
            string = stringBuffer.toString();
        } else {
            StringBuffer stringBuffer2 = new StringBuffer(String.valueOf(zipFile.substring(0, zipFile.lastIndexOf(Extension.DOT))));
            stringBuffer2.append(".z0");
            stringBuffer2.append(i);
            string = stringBuffer2.toString();
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(string, "r");
            if (this.currSplitFileCounter == 1) {
                randomAccessFile.read(new byte[4]);
                if (Raw.readIntLittleEndian(r0, 0) != 134695760) {
                    throw new ZipException("invalid first part split file signature");
                }
            }
            return randomAccessFile;
        } catch (FileNotFoundException e) {
            throw new ZipException(e);
        } catch (IOException e2) {
            throw new ZipException(e2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0038 A[Catch: IOException -> 0x003b, TRY_ENTER, TRY_LEAVE, TryCatch #3 {IOException -> 0x003b, blocks: (B:22:0x0038, B:16:0x002c), top: B:32:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void closeStreams(InputStream inputStream, OutputStream outputStream) {
        try {
            if (inputStream != null) {
                try {
                    try {
                        inputStream.close();
                        if (outputStream != null) {
                        } else {
                            outputStream.close();
                        }
                    } catch (IOException e) {
                        if (Zip4jUtil.isStringNotNullAndNotEmpty(e.getMessage()) && e.getMessage().indexOf(" - Wrong Password?") >= 0) {
                            throw new ZipException(e.getMessage());
                        }
                        if (outputStream == null) {
                        } else {
                            outputStream.close();
                        }
                    }
                } catch (Throwable th) {
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException unused) {
                        }
                    }
                    throw th;
                }
            } else if (outputStream != null) {
            }
        } catch (IOException unused2) {
        }
    }

    private RandomAccessFile createFileHandler(String str) throws ZipException {
        ZipModel zipModel = this.zipModel;
        if (zipModel == null || !Zip4jUtil.isStringNotNullAndNotEmpty(zipModel.getZipFile())) {
            throw new ZipException("input parameter is null in getFilePointer");
        }
        try {
            return this.zipModel.isSplitArchive() ? checkSplitFile() : new RandomAccessFile(new File(this.zipModel.getZipFile()), str);
        } catch (FileNotFoundException e) {
            throw new ZipException(e);
        } catch (Exception e2) {
            throw new ZipException(e2);
        }
    }

    private byte[] getAESPasswordVerifier(RandomAccessFile randomAccessFile) throws ZipException {
        try {
            byte[] bArr = new byte[2];
            randomAccessFile.read(bArr);
            return bArr;
        } catch (IOException e) {
            throw new ZipException(e);
        }
    }

    private byte[] getAESSalt(RandomAccessFile randomAccessFile) throws ZipException {
        if (this.localFileHeader.getAesExtraDataRecord() == null) {
            return null;
        }
        try {
            byte[] bArr = new byte[calculateAESSaltLength(this.localFileHeader.getAesExtraDataRecord())];
            randomAccessFile.seek(this.localFileHeader.getOffsetStartOfData());
            randomAccessFile.read(bArr);
            return bArr;
        } catch (IOException e) {
            throw new ZipException(e);
        }
    }

    private String getOutputFileNameWithPath(String str, String str2) {
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(str2)) {
            str2 = this.fileHeader.getFileName();
        }
        StringBuffer stringBuffer = new StringBuffer(String.valueOf(str));
        stringBuffer.append(System.getProperty(SystemProperties.FILE_SEPARATOR));
        stringBuffer.append(str2);
        return stringBuffer.toString();
    }

    private FileOutputStream getOutputStream(String str, String str2) throws ZipException {
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
            throw new ZipException("invalid output path");
        }
        try {
            File file = new File(getOutputFileNameWithPath(str, str2));
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            if (file.exists()) {
                file.delete();
            }
            return new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            throw new ZipException(e);
        }
    }

    private byte[] getStandardDecrypterHeaderBytes(RandomAccessFile randomAccessFile) throws ZipException {
        try {
            byte[] bArr = new byte[12];
            randomAccessFile.seek(this.localFileHeader.getOffsetStartOfData());
            randomAccessFile.read(bArr, 0, 12);
            return bArr;
        } catch (IOException e) {
            throw new ZipException(e);
        } catch (Exception e2) {
            throw new ZipException(e2);
        }
    }

    private void init(RandomAccessFile randomAccessFile) throws ZipException {
        if (this.localFileHeader == null) {
            throw new ZipException("local file header is null, cannot initialize input stream");
        }
        try {
            initDecrypter(randomAccessFile);
        } catch (ZipException e) {
            throw e;
        } catch (Exception e2) {
            throw new ZipException(e2);
        }
    }

    private void initDecrypter(RandomAccessFile randomAccessFile) throws ZipException {
        LocalFileHeader localFileHeader = this.localFileHeader;
        if (localFileHeader == null) {
            throw new ZipException("local file header is null, cannot init decrypter");
        }
        if (localFileHeader.isEncrypted()) {
            if (this.localFileHeader.getEncryptionMethod() == 0) {
                this.decrypter = new StandardDecrypter(this.fileHeader, getStandardDecrypterHeaderBytes(randomAccessFile));
            } else {
                if (this.localFileHeader.getEncryptionMethod() != 99) {
                    throw new ZipException("unsupported encryption method");
                }
                this.decrypter = new AESDecrypter(this.localFileHeader, getAESSalt(randomAccessFile), getAESPasswordVerifier(randomAccessFile));
            }
        }
    }

    public void checkCRC() {
        FileHeader fileHeader = this.fileHeader;
        if (fileHeader != null) {
            if (fileHeader.getEncryptionMethod() != 99) {
                if ((this.crc.getValue() & 4294967295L) != this.fileHeader.getCrc32()) {
                    StringBuffer stringBuffer = new StringBuffer("invalid CRC for file: ");
                    stringBuffer.append(this.fileHeader.getFileName());
                    String string = stringBuffer.toString();
                    if (this.localFileHeader.isEncrypted() && this.localFileHeader.getEncryptionMethod() == 0) {
                        string = String.valueOf(string).concat(" - Wrong Password?");
                    }
                    throw new ZipException(string);
                }
                return;
            }
            IDecrypter iDecrypter = this.decrypter;
            if (iDecrypter == null || !(iDecrypter instanceof AESDecrypter)) {
                return;
            }
            byte[] calculatedAuthenticationBytes = ((AESDecrypter) iDecrypter).getCalculatedAuthenticationBytes();
            byte[] storedMac = ((AESDecrypter) this.decrypter).getStoredMac();
            byte[] bArr = new byte[10];
            if (storedMac == null) {
                StringBuffer stringBuffer2 = new StringBuffer("CRC (MAC) check failed for ");
                stringBuffer2.append(this.fileHeader.getFileName());
                throw new ZipException(stringBuffer2.toString());
            }
            System.arraycopy(calculatedAuthenticationBytes, 0, bArr, 0, 10);
            if (Arrays.equals(bArr, storedMac)) {
                return;
            }
            StringBuffer stringBuffer3 = new StringBuffer("invalid CRC (MAC) for file: ");
            stringBuffer3.append(this.fileHeader.getFileName());
            throw new ZipException(stringBuffer3.toString());
        }
    }

    public IDecrypter getDecrypter() {
        return this.decrypter;
    }

    public FileHeader getFileHeader() {
        return this.fileHeader;
    }

    public ZipInputStream getInputStream() throws ZipException {
        RandomAccessFile randomAccessFileCreateFileHandler;
        long saltLength;
        if (this.fileHeader == null) {
            throw new ZipException("file header is null, cannot get inputstream");
        }
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFileCreateFileHandler = createFileHandler("r");
        } catch (ZipException e) {
            e = e;
        } catch (Exception e2) {
            e = e2;
        }
        try {
            if (!checkLocalHeader()) {
                throw new ZipException("local header and file header do not match");
            }
            init(randomAccessFileCreateFileHandler);
            long compressedSize = this.localFileHeader.getCompressedSize();
            long offsetStartOfData = this.localFileHeader.getOffsetStartOfData();
            if (this.localFileHeader.isEncrypted()) {
                if (this.localFileHeader.getEncryptionMethod() == 99) {
                    IDecrypter iDecrypter = this.decrypter;
                    if (!(iDecrypter instanceof AESDecrypter)) {
                        StringBuffer stringBuffer = new StringBuffer("invalid decryptor when trying to calculate compressed size for AES encrypted file: ");
                        stringBuffer.append(this.fileHeader.getFileName());
                        throw new ZipException(stringBuffer.toString());
                    }
                    compressedSize -= (long) ((((AESDecrypter) iDecrypter).getSaltLength() + ((AESDecrypter) this.decrypter).getPasswordVerifierLength()) + 10);
                    saltLength = ((AESDecrypter) this.decrypter).getSaltLength() + ((AESDecrypter) this.decrypter).getPasswordVerifierLength();
                } else if (this.localFileHeader.getEncryptionMethod() == 0) {
                    saltLength = 12;
                    compressedSize -= 12;
                }
                offsetStartOfData += saltLength;
            }
            int compressionMethod = this.fileHeader.getCompressionMethod();
            if (this.fileHeader.getEncryptionMethod() == 99) {
                if (this.fileHeader.getAesExtraDataRecord() == null) {
                    StringBuffer stringBuffer2 = new StringBuffer("AESExtraDataRecord does not exist for AES encrypted file: ");
                    stringBuffer2.append(this.fileHeader.getFileName());
                    throw new ZipException(stringBuffer2.toString());
                }
                compressionMethod = this.fileHeader.getAesExtraDataRecord().getCompressionMethod();
            }
            randomAccessFileCreateFileHandler.seek(offsetStartOfData);
            if (compressionMethod == 0) {
                return new ZipInputStream(new PartInputStream(randomAccessFileCreateFileHandler, offsetStartOfData, compressedSize, this));
            }
            if (compressionMethod == 8) {
                return new ZipInputStream(new InflaterInputStream(randomAccessFileCreateFileHandler, offsetStartOfData, compressedSize, this));
            }
            throw new ZipException("compression type not supported");
        } catch (ZipException e3) {
            e = e3;
            randomAccessFile = randomAccessFileCreateFileHandler;
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException unused) {
                }
            }
            throw e;
        } catch (Exception e5) {
            e = e5;
            randomAccessFile = randomAccessFileCreateFileHandler;
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException unused2) {
                }
            }
            throw new ZipException(e);
        }
    }

    public LocalFileHeader getLocalFileHeader() {
        return this.localFileHeader;
    }

    public ZipModel getZipModel() {
        return this.zipModel;
    }

    public RandomAccessFile startNextSplitFile() {
        String string;
        String zipFile = this.zipModel.getZipFile();
        if (this.currSplitFileCounter == this.zipModel.getEndCentralDirRecord().getNoOfThisDisk()) {
            string = this.zipModel.getZipFile();
        } else if (this.currSplitFileCounter >= 9) {
            StringBuffer stringBuffer = new StringBuffer(String.valueOf(zipFile.substring(0, zipFile.lastIndexOf(Extension.DOT))));
            stringBuffer.append(".z");
            stringBuffer.append(this.currSplitFileCounter + 1);
            string = stringBuffer.toString();
        } else {
            StringBuffer stringBuffer2 = new StringBuffer(String.valueOf(zipFile.substring(0, zipFile.lastIndexOf(Extension.DOT))));
            stringBuffer2.append(".z0");
            stringBuffer2.append(this.currSplitFileCounter + 1);
            string = stringBuffer2.toString();
        }
        this.currSplitFileCounter++;
        try {
            if (Zip4jUtil.checkFileExists(string)) {
                return new RandomAccessFile(string, "r");
            }
            StringBuffer stringBuffer3 = new StringBuffer("zip split file does not exist: ");
            stringBuffer3.append(string);
            throw new IOException(stringBuffer3.toString());
        } catch (ZipException e) {
            throw new IOException(e.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [net.lingala.zip4j.unzip.UnzipEngine] */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v5, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r9v6 */
    public void unzipFile(ProgressMonitor progressMonitor, String str, String str2, UnzipParameters unzipParameters) {
        ?? r9;
        byte[] bArr;
        ZipInputStream inputStream;
        if (this.zipModel == null || this.fileHeader == null || !Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
            throw new ZipException("Invalid parameters passed during unzipping file. One or more of the parameters were null");
        }
        ZipInputStream zipInputStream = null;
        try {
            try {
                bArr = new byte[4096];
                inputStream = getInputStream();
            } catch (Throwable th) {
                th = th;
                r9 = str;
            }
            try {
                FileOutputStream outputStream = getOutputStream(str, str2);
                do {
                    int i = inputStream.read(bArr);
                    if (i == -1) {
                        closeStreams(inputStream, outputStream);
                        UnzipUtil.applyFileAttributes(this.fileHeader, new File(getOutputFileNameWithPath(str, str2)), unzipParameters);
                        closeStreams(inputStream, outputStream);
                        return;
                    }
                    outputStream.write(bArr, 0, i);
                    progressMonitor.updateWorkCompleted(i);
                } while (!progressMonitor.isCancelAllTasks());
                progressMonitor.setResult(3);
                progressMonitor.setState(0);
                closeStreams(inputStream, outputStream);
            } catch (IOException e) {
                e = e;
                throw new ZipException(e);
            } catch (Exception e2) {
                e = e2;
                throw new ZipException(e);
            } catch (Throwable th2) {
                th = th2;
                r9 = 0;
                zipInputStream = inputStream;
                closeStreams(zipInputStream, r9);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
        } catch (Exception e5) {
            e = e5;
        } catch (Throwable th3) {
            th = th3;
            r9 = 0;
        }
    }

    public void updateCRC(int i) {
        this.crc.update(i);
    }

    public void updateCRC(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            this.crc.update(bArr, i, i2);
        }
    }
}
