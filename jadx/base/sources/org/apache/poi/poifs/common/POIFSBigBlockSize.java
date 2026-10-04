package org.apache.poi.poifs.common;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class POIFSBigBlockSize {
    private int bigBlockSize;
    private short headerValue;

    public POIFSBigBlockSize(int i, short s) {
        this.bigBlockSize = i;
        this.headerValue = s;
    }

    public int getBATEntriesPerBlock() {
        return this.bigBlockSize / 4;
    }

    public int getBigBlockSize() {
        return this.bigBlockSize;
    }

    public short getHeaderValue() {
        return this.headerValue;
    }

    public int getNextXBATChainOffset() {
        return getXBATEntriesPerBlock() * 4;
    }

    public int getPropertiesPerBlock() {
        return this.bigBlockSize / 128;
    }

    public int getXBATEntriesPerBlock() {
        return getBATEntriesPerBlock() - 1;
    }
}
