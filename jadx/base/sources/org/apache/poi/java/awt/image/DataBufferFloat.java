package org.apache.poi.java.awt.image;

import org.apache.poi.sun.java2d.StateTrackable;

/* JADX INFO: loaded from: classes10.dex */
public final class DataBufferFloat extends DataBuffer {
    float[][] bankdata;
    float[] data;

    public DataBufferFloat(int i) {
        super(StateTrackable.State.STABLE, 4, i);
        float[] fArr = new float[i];
        this.data = fArr;
        this.bankdata = new float[][]{fArr};
    }

    public float[][] getBankData() {
        this.theTrackable.setUntrackable();
        return (float[][]) this.bankdata.clone();
    }

    public float[] getData() {
        this.theTrackable.setUntrackable();
        return this.data;
    }

    @Override // org.apache.poi.java.awt.image.DataBuffer
    public int getElem(int i) {
        return (int) this.data[i + this.offset];
    }

    @Override // org.apache.poi.java.awt.image.DataBuffer
    public double getElemDouble(int i) {
        return this.data[i + this.offset];
    }

    @Override // org.apache.poi.java.awt.image.DataBuffer
    public float getElemFloat(int i) {
        return this.data[i + this.offset];
    }

    @Override // org.apache.poi.java.awt.image.DataBuffer
    public void setElem(int i, int i2) {
        this.data[i + this.offset] = i2;
        this.theTrackable.markDirty();
    }

    @Override // org.apache.poi.java.awt.image.DataBuffer
    public void setElemDouble(int i, double d) {
        this.data[i + this.offset] = (float) d;
        this.theTrackable.markDirty();
    }

    @Override // org.apache.poi.java.awt.image.DataBuffer
    public void setElemFloat(int i, float f) {
        this.data[i + this.offset] = f;
        this.theTrackable.markDirty();
    }

    public DataBufferFloat(int i, int i2) {
        super(StateTrackable.State.STABLE, 4, i, i2);
        this.bankdata = new float[i2][];
        for (int i4 = 0; i4 < i2; i4++) {
            this.bankdata[i4] = new float[i];
        }
        this.data = this.bankdata[0];
    }

    public float[] getData(int i) {
        this.theTrackable.setUntrackable();
        return this.bankdata[i];
    }

    @Override // org.apache.poi.java.awt.image.DataBuffer
    public int getElem(int i, int i2) {
        return (int) this.bankdata[i][i2 + this.offsets[i]];
    }

    @Override // org.apache.poi.java.awt.image.DataBuffer
    public double getElemDouble(int i, int i2) {
        return this.bankdata[i][i2 + this.offsets[i]];
    }

    @Override // org.apache.poi.java.awt.image.DataBuffer
    public float getElemFloat(int i, int i2) {
        return this.bankdata[i][i2 + this.offsets[i]];
    }

    @Override // org.apache.poi.java.awt.image.DataBuffer
    public void setElem(int i, int i2, int i4) {
        this.bankdata[i][i2 + this.offsets[i]] = i4;
        this.theTrackable.markDirty();
    }

    @Override // org.apache.poi.java.awt.image.DataBuffer
    public void setElemDouble(int i, int i2, double d) {
        this.bankdata[i][i2 + this.offsets[i]] = (float) d;
        this.theTrackable.markDirty();
    }

    @Override // org.apache.poi.java.awt.image.DataBuffer
    public void setElemFloat(int i, int i2, float f) {
        this.bankdata[i][i2 + this.offsets[i]] = f;
        this.theTrackable.markDirty();
    }

    public DataBufferFloat(float[] fArr, int i) {
        super(StateTrackable.State.UNTRACKABLE, 4, i);
        this.data = fArr;
        this.bankdata = new float[][]{fArr};
    }

    public DataBufferFloat(float[] fArr, int i, int i2) {
        super(StateTrackable.State.UNTRACKABLE, 4, i, 1, i2);
        this.data = fArr;
        this.bankdata = new float[][]{fArr};
    }

    public DataBufferFloat(float[][] fArr, int i) {
        super(StateTrackable.State.UNTRACKABLE, 4, i, fArr.length);
        float[][] fArr2 = (float[][]) fArr.clone();
        this.bankdata = fArr2;
        this.data = fArr2[0];
    }

    public DataBufferFloat(float[][] fArr, int i, int[] iArr) {
        super(StateTrackable.State.UNTRACKABLE, 4, i, fArr.length, iArr);
        float[][] fArr2 = (float[][]) fArr.clone();
        this.bankdata = fArr2;
        this.data = fArr2[0];
    }
}
