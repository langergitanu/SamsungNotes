package net.lingala.zip4j.model;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class EndCentralDirRecord {
    private String comment;
    private byte[] commentBytes;
    private int commentLength;
    private int noOfThisDisk;
    private int noOfThisDiskStartOfCentralDir;
    private long offsetOfStartOfCentralDir;
    private long signature;
    private int sizeOfCentralDir;
    private int totNoOfEntriesInCentralDir;
    private int totNoOfEntriesInCentralDirOnThisDisk;

    public String getComment() {
        return this.comment;
    }

    public byte[] getCommentBytes() {
        return this.commentBytes;
    }

    public int getCommentLength() {
        return this.commentLength;
    }

    public int getNoOfThisDisk() {
        return this.noOfThisDisk;
    }

    public int getNoOfThisDiskStartOfCentralDir() {
        return this.noOfThisDiskStartOfCentralDir;
    }

    public long getOffsetOfStartOfCentralDir() {
        return this.offsetOfStartOfCentralDir;
    }

    public long getSignature() {
        return this.signature;
    }

    public int getSizeOfCentralDir() {
        return this.sizeOfCentralDir;
    }

    public int getTotNoOfEntriesInCentralDir() {
        return this.totNoOfEntriesInCentralDir;
    }

    public int getTotNoOfEntriesInCentralDirOnThisDisk() {
        return this.totNoOfEntriesInCentralDirOnThisDisk;
    }

    public void setComment(String str) {
        this.comment = str;
    }

    public void setCommentBytes(byte[] bArr) {
        this.commentBytes = bArr;
    }

    public void setCommentLength(int i) {
        this.commentLength = i;
    }

    public void setNoOfThisDisk(int i) {
        this.noOfThisDisk = i;
    }

    public void setNoOfThisDiskStartOfCentralDir(int i) {
        this.noOfThisDiskStartOfCentralDir = i;
    }

    public void setOffsetOfStartOfCentralDir(long j) {
        this.offsetOfStartOfCentralDir = j;
    }

    public void setSignature(long j) {
        this.signature = j;
    }

    public void setSizeOfCentralDir(int i) {
        this.sizeOfCentralDir = i;
    }

    public void setTotNoOfEntriesInCentralDir(int i) {
        this.totNoOfEntriesInCentralDir = i;
    }

    public void setTotNoOfEntriesInCentralDirOnThisDisk(int i) {
        this.totNoOfEntriesInCentralDirOnThisDisk = i;
    }
}
