package net.lingala.zip4j.model;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class Zip64ExtendedInfo {
    private int header;
    private int size;
    private long compressedSize = -1;
    private long unCompressedSize = -1;
    private long offsetLocalHeader = -1;
    private int diskNumberStart = -1;

    public long getCompressedSize() {
        return this.compressedSize;
    }

    public int getDiskNumberStart() {
        return this.diskNumberStart;
    }

    public int getHeader() {
        return this.header;
    }

    public long getOffsetLocalHeader() {
        return this.offsetLocalHeader;
    }

    public int getSize() {
        return this.size;
    }

    public long getUnCompressedSize() {
        return this.unCompressedSize;
    }

    public void setCompressedSize(long j) {
        this.compressedSize = j;
    }

    public void setDiskNumberStart(int i) {
        this.diskNumberStart = i;
    }

    public void setHeader(int i) {
        this.header = i;
    }

    public void setOffsetLocalHeader(long j) {
        this.offsetLocalHeader = j;
    }

    public void setSize(int i) {
        this.size = i;
    }

    public void setUnCompressedSize(long j) {
        this.unCompressedSize = j;
    }
}
