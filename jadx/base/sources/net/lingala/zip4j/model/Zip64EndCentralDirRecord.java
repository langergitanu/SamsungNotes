package net.lingala.zip4j.model;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class Zip64EndCentralDirRecord {
    private byte[] extensibleDataSector;
    private int noOfThisDisk;
    private int noOfThisDiskStartOfCentralDir;
    private long offsetStartCenDirWRTStartDiskNo;
    private long signature;
    private long sizeOfCentralDir;
    private long sizeOfZip64EndCentralDirRec;
    private long totNoOfEntriesInCentralDir;
    private long totNoOfEntriesInCentralDirOnThisDisk;
    private int versionMadeBy;
    private int versionNeededToExtract;

    public byte[] getExtensibleDataSector() {
        return this.extensibleDataSector;
    }

    public int getNoOfThisDisk() {
        return this.noOfThisDisk;
    }

    public int getNoOfThisDiskStartOfCentralDir() {
        return this.noOfThisDiskStartOfCentralDir;
    }

    public long getOffsetStartCenDirWRTStartDiskNo() {
        return this.offsetStartCenDirWRTStartDiskNo;
    }

    public long getSignature() {
        return this.signature;
    }

    public long getSizeOfCentralDir() {
        return this.sizeOfCentralDir;
    }

    public long getSizeOfZip64EndCentralDirRec() {
        return this.sizeOfZip64EndCentralDirRec;
    }

    public long getTotNoOfEntriesInCentralDir() {
        return this.totNoOfEntriesInCentralDir;
    }

    public long getTotNoOfEntriesInCentralDirOnThisDisk() {
        return this.totNoOfEntriesInCentralDirOnThisDisk;
    }

    public int getVersionMadeBy() {
        return this.versionMadeBy;
    }

    public int getVersionNeededToExtract() {
        return this.versionNeededToExtract;
    }

    public void setExtensibleDataSector(byte[] bArr) {
        this.extensibleDataSector = bArr;
    }

    public void setNoOfThisDisk(int i) {
        this.noOfThisDisk = i;
    }

    public void setNoOfThisDiskStartOfCentralDir(int i) {
        this.noOfThisDiskStartOfCentralDir = i;
    }

    public void setOffsetStartCenDirWRTStartDiskNo(long j) {
        this.offsetStartCenDirWRTStartDiskNo = j;
    }

    public void setSignature(long j) {
        this.signature = j;
    }

    public void setSizeOfCentralDir(long j) {
        this.sizeOfCentralDir = j;
    }

    public void setSizeOfZip64EndCentralDirRec(long j) {
        this.sizeOfZip64EndCentralDirRec = j;
    }

    public void setTotNoOfEntriesInCentralDir(long j) {
        this.totNoOfEntriesInCentralDir = j;
    }

    public void setTotNoOfEntriesInCentralDirOnThisDisk(long j) {
        this.totNoOfEntriesInCentralDirOnThisDisk = j;
    }

    public void setVersionMadeBy(int i) {
        this.versionMadeBy = i;
    }

    public void setVersionNeededToExtract(int i) {
        this.versionNeededToExtract = i;
    }
}
