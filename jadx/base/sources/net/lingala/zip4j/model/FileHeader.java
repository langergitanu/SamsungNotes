package net.lingala.zip4j.model;

import java.util.ArrayList;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.progress.ProgressMonitor;
import net.lingala.zip4j.unzip.Unzip;
import net.lingala.zip4j.util.Zip4jUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class FileHeader {
    private AESExtraDataRecord aesExtraDataRecord;
    private long compressedSize;
    private int compressionMethod;
    private byte[] crcBuff;
    private boolean dataDescriptorExists;
    private int diskNumberStart;
    private byte[] externalFileAttr;
    private ArrayList extraDataRecords;
    private int extraFieldLength;
    private String fileComment;
    private int fileCommentLength;
    private String fileName;
    private int fileNameLength;
    private boolean fileNameUTF8Encoded;
    private byte[] generalPurposeFlag;
    private byte[] internalFileAttr;
    private boolean isDirectory;
    private boolean isEncrypted;
    private int lastModFileTime;
    private long offsetLocalHeader;
    private char[] password;
    private int signature;
    private int versionMadeBy;
    private int versionNeededToExtract;
    private Zip64ExtendedInfo zip64ExtendedInfo;
    private int encryptionMethod = -1;
    private long crc32 = 0;
    private long uncompressedSize = 0;

    public void extractFile(ZipModel zipModel, String str, ProgressMonitor progressMonitor, boolean z) throws ZipException {
        extractFile(zipModel, str, null, progressMonitor, z);
    }

    public AESExtraDataRecord getAesExtraDataRecord() {
        return this.aesExtraDataRecord;
    }

    public long getCompressedSize() {
        return this.compressedSize;
    }

    public int getCompressionMethod() {
        return this.compressionMethod;
    }

    public long getCrc32() {
        return this.crc32 & 4294967295L;
    }

    public byte[] getCrcBuff() {
        return this.crcBuff;
    }

    public int getDiskNumberStart() {
        return this.diskNumberStart;
    }

    public int getEncryptionMethod() {
        return this.encryptionMethod;
    }

    public byte[] getExternalFileAttr() {
        return this.externalFileAttr;
    }

    public ArrayList getExtraDataRecords() {
        return this.extraDataRecords;
    }

    public int getExtraFieldLength() {
        return this.extraFieldLength;
    }

    public String getFileComment() {
        return this.fileComment;
    }

    public int getFileCommentLength() {
        return this.fileCommentLength;
    }

    public String getFileName() {
        return this.fileName;
    }

    public int getFileNameLength() {
        return this.fileNameLength;
    }

    public byte[] getGeneralPurposeFlag() {
        return this.generalPurposeFlag;
    }

    public byte[] getInternalFileAttr() {
        return this.internalFileAttr;
    }

    public int getLastModFileTime() {
        return this.lastModFileTime;
    }

    public long getOffsetLocalHeader() {
        return this.offsetLocalHeader;
    }

    public char[] getPassword() {
        return this.password;
    }

    public int getSignature() {
        return this.signature;
    }

    public long getUncompressedSize() {
        return this.uncompressedSize;
    }

    public int getVersionMadeBy() {
        return this.versionMadeBy;
    }

    public int getVersionNeededToExtract() {
        return this.versionNeededToExtract;
    }

    public Zip64ExtendedInfo getZip64ExtendedInfo() {
        return this.zip64ExtendedInfo;
    }

    public boolean isDataDescriptorExists() {
        return this.dataDescriptorExists;
    }

    public boolean isDirectory() {
        return this.isDirectory;
    }

    public boolean isEncrypted() {
        return this.isEncrypted;
    }

    public boolean isFileNameUTF8Encoded() {
        return this.fileNameUTF8Encoded;
    }

    public void setAesExtraDataRecord(AESExtraDataRecord aESExtraDataRecord) {
        this.aesExtraDataRecord = aESExtraDataRecord;
    }

    public void setCompressedSize(long j) {
        this.compressedSize = j;
    }

    public void setCompressionMethod(int i) {
        this.compressionMethod = i;
    }

    public void setCrc32(long j) {
        this.crc32 = j;
    }

    public void setCrcBuff(byte[] bArr) {
        this.crcBuff = bArr;
    }

    public void setDataDescriptorExists(boolean z) {
        this.dataDescriptorExists = z;
    }

    public void setDirectory(boolean z) {
        this.isDirectory = z;
    }

    public void setDiskNumberStart(int i) {
        this.diskNumberStart = i;
    }

    public void setEncrypted(boolean z) {
        this.isEncrypted = z;
    }

    public void setEncryptionMethod(int i) {
        this.encryptionMethod = i;
    }

    public void setExternalFileAttr(byte[] bArr) {
        this.externalFileAttr = bArr;
    }

    public void setExtraDataRecords(ArrayList arrayList) {
        this.extraDataRecords = arrayList;
    }

    public void setExtraFieldLength(int i) {
        this.extraFieldLength = i;
    }

    public void setFileComment(String str) {
        this.fileComment = str;
    }

    public void setFileCommentLength(int i) {
        this.fileCommentLength = i;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setFileNameLength(int i) {
        this.fileNameLength = i;
    }

    public void setFileNameUTF8Encoded(boolean z) {
        this.fileNameUTF8Encoded = z;
    }

    public void setGeneralPurposeFlag(byte[] bArr) {
        this.generalPurposeFlag = bArr;
    }

    public void setInternalFileAttr(byte[] bArr) {
        this.internalFileAttr = bArr;
    }

    public void setLastModFileTime(int i) {
        this.lastModFileTime = i;
    }

    public void setOffsetLocalHeader(long j) {
        this.offsetLocalHeader = j;
    }

    public void setPassword(char[] cArr) {
        this.password = cArr;
    }

    public void setSignature(int i) {
        this.signature = i;
    }

    public void setUncompressedSize(long j) {
        this.uncompressedSize = j;
    }

    public void setVersionMadeBy(int i) {
        this.versionMadeBy = i;
    }

    public void setVersionNeededToExtract(int i) {
        this.versionNeededToExtract = i;
    }

    public void setZip64ExtendedInfo(Zip64ExtendedInfo zip64ExtendedInfo) {
        this.zip64ExtendedInfo = zip64ExtendedInfo;
    }

    public void extractFile(ZipModel zipModel, String str, UnzipParameters unzipParameters, ProgressMonitor progressMonitor, boolean z) throws ZipException {
        extractFile(zipModel, str, unzipParameters, null, progressMonitor, z);
    }

    public void extractFile(ZipModel zipModel, String str, UnzipParameters unzipParameters, String str2, ProgressMonitor progressMonitor, boolean z) throws ZipException {
        if (zipModel != null) {
            if (Zip4jUtil.checkOutputFolder(str)) {
                new Unzip(zipModel).extractFile(this, str, unzipParameters, str2, progressMonitor, z);
                return;
            }
            throw new ZipException("Invalid output path");
        }
        throw new ZipException("input zipModel is null");
    }
}
