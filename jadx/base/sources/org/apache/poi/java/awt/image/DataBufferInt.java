package org.apache.poi.java.awt.image;

import org.apache.poi.sun.java2d.StateTrackable;

/* JADX INFO: loaded from: classes10.dex */
public final class DataBufferInt extends DataBuffer {
    int[][] bankdata;
    int[] data;

    public DataBufferInt(int i) {
        super(StateTrackable.State.STABLE, 3, i);
        int[] iArr = new int[i];
        this.data = iArr;
        this.bankdata = new int[][]{iArr};
    }

    public int[][] getBankData() {
        this.theTrackable.setUntrackable();
        return (int[][]) this.bankdata.clone();
    }

    public int[] getData() {
        this.theTrackable.setUntrackable();
        return this.data;
    }

    @Override // org.apache.poi.java.awt.image.DataBuffer
    public int getElem(int i) {
        return this.data[i + this.offset];
    }

    @Override // org.apache.poi.java.awt.image.DataBuffer
    public void setElem(int i, int i2) {
        this.data[i + this.offset] = i2;
        this.theTrackable.markDirty();
    }

    public DataBufferInt(int i, int i2) {
        super(StateTrackable.State.STABLE, 3, i, i2);
        this.bankdata = new int[i2][];
        for (int i4 = 0; i4 < i2; i4++) {
            this.bankdata[i4] = new int[i];
        }
        this.data = this.bankdata[0];
    }

    public int[] getData(int i) {
        this.theTrackable.setUntrackable();
        return this.bankdata[i];
    }

    @Override // org.apache.poi.java.awt.image.DataBuffer
    public int getElem(int i, int i2) {
        return this.bankdata[i][i2 + this.offsets[i]];
    }

    @Override // org.apache.poi.java.awt.image.DataBuffer
    public void setElem(int i, int i2, int i4) {
        this.bankdata[i][i2 + this.offsets[i]] = i4;
        this.theTrackable.markDirty();
    }

    public DataBufferInt(int[] iArr, int i) {
        super(StateTrackable.State.UNTRACKABLE, 3, i);
        this.data = iArr;
        this.bankdata = new int[][]{iArr};
    }

    public DataBufferInt(int[] iArr, int i, int i2) {
        super(StateTrackable.State.UNTRACKABLE, 3, i, 1, i2);
        this.data = iArr;
        this.bankdata = new int[][]{iArr};
    }

    public DataBufferInt(int[][] iArr, int i) {
        super(StateTrackable.State.UNTRACKABLE, 3, i, iArr.length);
        int[][] iArr2 = (int[][]) iArr.clone();
        this.bankdata = iArr2;
        this.data = iArr2[0];
    }

    public DataBufferInt(int[][] iArr, int i, int[] iArr2) {
        super(StateTrackable.State.UNTRACKABLE, 3, i, iArr.length, iArr2);
        int[][] iArr3 = (int[][]) iArr.clone();
        this.bankdata = iArr3;
        this.data = iArr3[0];
    }
}
