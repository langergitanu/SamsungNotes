package net.lingala.zip4j.model;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class Zip64EndCentralDirLocator {
    private int noOfDiskStartOfZip64EndOfCentralDirRec;
    private long offsetZip64EndOfCentralDirRec;
    private long signature;
    private int totNumberOfDiscs;

    public int getNoOfDiskStartOfZip64EndOfCentralDirRec() {
        return this.noOfDiskStartOfZip64EndOfCentralDirRec;
    }

    public long getOffsetZip64EndOfCentralDirRec() {
        return this.offsetZip64EndOfCentralDirRec;
    }

    public long getSignature() {
        return this.signature;
    }

    public int getTotNumberOfDiscs() {
        return this.totNumberOfDiscs;
    }

    public void setNoOfDiskStartOfZip64EndOfCentralDirRec(int i) {
        this.noOfDiskStartOfZip64EndOfCentralDirRec = i;
    }

    public void setOffsetZip64EndOfCentralDirRec(long j) {
        this.offsetZip64EndOfCentralDirRec = j;
    }

    public void setSignature(long j) {
        this.signature = j;
    }

    public void setTotNumberOfDiscs(int i) {
        this.totNumberOfDiscs = i;
    }
}
