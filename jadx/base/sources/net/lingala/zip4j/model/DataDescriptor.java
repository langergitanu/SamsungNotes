package net.lingala.zip4j.model;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class DataDescriptor {
    private int compressedSize;
    private String crc32;
    private int uncompressedSize;

    public int getCompressedSize() {
        return this.compressedSize;
    }

    public String getCrc32() {
        return this.crc32;
    }

    public int getUncompressedSize() {
        return this.uncompressedSize;
    }

    public void setCompressedSize(int i) {
        this.compressedSize = i;
    }

    public void setCrc32(String str) {
        this.crc32 = str;
    }

    public void setUncompressedSize(int i) {
        this.uncompressedSize = i;
    }
}
