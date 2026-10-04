package net.lingala.zip4j.model;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class AESExtraDataRecord {
    private long signature = -1;
    private int dataSize = -1;
    private int versionNumber = -1;
    private String vendorID = null;
    private int aesStrength = -1;
    private int compressionMethod = -1;

    public int getAesStrength() {
        return this.aesStrength;
    }

    public int getCompressionMethod() {
        return this.compressionMethod;
    }

    public int getDataSize() {
        return this.dataSize;
    }

    public long getSignature() {
        return this.signature;
    }

    public String getVendorID() {
        return this.vendorID;
    }

    public int getVersionNumber() {
        return this.versionNumber;
    }

    public void setAesStrength(int i) {
        this.aesStrength = i;
    }

    public void setCompressionMethod(int i) {
        this.compressionMethod = i;
    }

    public void setDataSize(int i) {
        this.dataSize = i;
    }

    public void setSignature(long j) {
        this.signature = j;
    }

    public void setVendorID(String str) {
        this.vendorID = str;
    }

    public void setVersionNumber(int i) {
        this.versionNumber = i;
    }
}
