package org.apache.poi.java.awt.image;

import org.apache.poi.sun.java2d.StateTrackable;

/* JADX INFO: loaded from: classes10.dex */
public final class DataBufferShort extends DataBuffer {
    short[][] bankdata;
    short[] data;

    public DataBufferShort(int i) {
        super(StateTrackable.State.STABLE, 2, i);
        short[] sArr = new short[i];
        this.data = sArr;
        this.bankdata = new short[][]{sArr};
    }

    public short[][] getBankData() {
        this.theTrackable.setUntrackable();
        return (short[][]) this.bankdata.clone();
    }

    public short[] getData() {
        this.theTrackable.setUntrackable();
        return this.data;
    }

    @Override // org.apache.poi.java.awt.image.DataBuffer
    public int getElem(int i) {
        return this.data[i + this.offset];
    }

    @Override // org.apache.poi.java.awt.image.DataBuffer
    public void setElem(int i, int i2) {
        this.data[i + this.offset] = (short) i2;
        this.theTrackable.markDirty();
    }

    public DataBufferShort(int i, int i2) {
        super(StateTrackable.State.STABLE, 2, i, i2);
        this.bankdata = new short[i2][];
        for (int i4 = 0; i4 < i2; i4++) {
            this.bankdata[i4] = new short[i];
        }
        this.data = this.bankdata[0];
    }

    public short[] getData(int i) {
        this.theTrackable.setUntrackable();
        return this.bankdata[i];
    }

    @Override // org.apache.poi.java.awt.image.DataBuffer
    public int getElem(int i, int i2) {
        return this.bankdata[i][i2 + this.offsets[i]];
    }

    @Override // org.apache.poi.java.awt.image.DataBuffer
    public void setElem(int i, int i2, int i4) {
        this.bankdata[i][i2 + this.offsets[i]] = (short) i4;
        this.theTrackable.markDirty();
    }

    public DataBufferShort(short[] sArr, int i) {
        super(StateTrackable.State.UNTRACKABLE, 2, i);
        this.data = sArr;
        this.bankdata = new short[][]{sArr};
    }

    public DataBufferShort(short[] sArr, int i, int i2) {
        super(StateTrackable.State.UNTRACKABLE, 2, i, 1, i2);
        this.data = sArr;
        this.bankdata = new short[][]{sArr};
    }

    public DataBufferShort(short[][] sArr, int i) {
        super(StateTrackable.State.UNTRACKABLE, 2, i, sArr.length);
        short[][] sArr2 = (short[][]) sArr.clone();
        this.bankdata = sArr2;
        this.data = sArr2[0];
    }

    public DataBufferShort(short[][] sArr, int i, int[] iArr) {
        super(StateTrackable.State.UNTRACKABLE, 2, i, sArr.length, iArr);
        short[][] sArr2 = (short[][]) sArr.clone();
        this.bankdata = sArr2;
        this.data = sArr2[0];
    }
}
