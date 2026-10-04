package net.lingala.zip4j.model;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class LocalFileHeader {
    private AESExtraDataRecord aesExtraDataRecord;
    private long compressedSize;
    private int compressionMethod;
    private byte[] crcBuff;
    private boolean dataDescriptorExists;
    private ArrayList extraDataRecords;
    private byte[] extraField;
    private int extraFieldLength;
    private String fileName;
    private int fileNameLength;
    private boolean fileNameUTF8Encoded;
    private byte[] generalPurposeFlag;
    private boolean isEncrypted;
    private int lastModFileTime;
    private long offsetStartOfData;
    private char[] password;
    private int signature;
    private int versionNeededToExtract;
    private Zip64ExtendedInfo zip64ExtendedInfo;
    private int encryptionMethod = -1;
    private boolean writeComprSizeInZip64ExtraRecord = false;
    private long crc32 = 0;
    private long uncompressedSize = 0;

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
        return this.crc32;
    }

    public byte[] getCrcBuff() {
        return this.crcBuff;
    }

    public int getEncryptionMethod() {
        return this.encryptionMethod;
    }

    public ArrayList getExtraDataRecords() {
        return this.extraDataRecords;
    }

    public byte[] getExtraField() {
        return this.extraField;
    }

    public int getExtraFieldLength() {
        return this.extraFieldLength;
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

    public int getLastModFileTime() {
        return this.lastModFileTime;
    }

    public long getOffsetStartOfData() {
        return this.offsetStartOfData;
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

    public int getVersionNeededToExtract() {
        return this.versionNeededToExtract;
    }

    public Zip64ExtendedInfo getZip64ExtendedInfo() {
        return this.zip64ExtendedInfo;
    }

    public boolean isDataDescriptorExists() {
        return this.dataDescriptorExists;
    }

    public boolean isEncrypted() {
        return this.isEncrypted;
    }

    public boolean isFileNameUTF8Encoded() {
        return this.fileNameUTF8Encoded;
    }

    public boolean isWriteComprSizeInZip64ExtraRecord() {
        return this.writeComprSizeInZip64ExtraRecord;
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

    public void setEncrypted(boolean z) {
        this.isEncrypted = z;
    }

    public void setEncryptionMethod(int i) {
        this.encryptionMethod = i;
    }

    public void setExtraDataRecords(ArrayList arrayList) {
        this.extraDataRecords = arrayList;
    }

    public void setExtraField(byte[] bArr) {
        this.extraField = bArr;
    }

    public void setExtraFieldLength(int i) {
        this.extraFieldLength = i;
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

    public void setLastModFileTime(int i) {
        this.lastModFileTime = i;
    }

    public void setOffsetStartOfData(long j) {
        this.offsetStartOfData = j;
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

    public void setVersionNeededToExtract(int i) {
        this.versionNeededToExtract = i;
    }

    public void setWriteComprSizeInZip64ExtraRecord(boolean z) {
        this.writeComprSizeInZip64ExtraRecord = z;
    }

    public void setZip64ExtendedInfo(Zip64ExtendedInfo zip64ExtendedInfo) {
        this.zip64ExtendedInfo = zip64ExtendedInfo;
    }
}
