package org.apache.poi.java.awt.image;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import kotlin.UShort;
import org.apache.poi.sun.java2d.StateTrackable;

/* JADX INFO: loaded from: classes10.dex */
public final class DataBufferUShort extends DataBuffer {
    short[][] bankdata;
    short[] data;

    public DataBufferUShort(int i) {
        super(StateTrackable.State.STABLE, 1, i);
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
        return this.data[i + this.offset] & UShort.MAX_VALUE;
    }

    @Override // org.apache.poi.java.awt.image.DataBuffer
    public void setElem(int i, int i2) {
        this.data[i + this.offset] = (short) (i2 & 65535);
        this.theTrackable.markDirty();
    }

    public DataBufferUShort(int i, int i2) {
        super(StateTrackable.State.STABLE, 1, i, i2);
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
        return this.bankdata[i][i2 + this.offsets[i]] & UShort.MAX_VALUE;
    }

    @Override // org.apache.poi.java.awt.image.DataBuffer
    public void setElem(int i, int i2, int i4) {
        this.bankdata[i][i2 + this.offsets[i]] = (short) (65535 & i4);
        this.theTrackable.markDirty();
    }

    public DataBufferUShort(short[] sArr, int i) {
        super(StateTrackable.State.UNTRACKABLE, 1, i);
        if (sArr == null) {
            throw new NullPointerException("dataArray is null");
        }
        this.data = sArr;
        this.bankdata = new short[][]{sArr};
    }

    public DataBufferUShort(short[] sArr, int i, int i2) {
        super(StateTrackable.State.UNTRACKABLE, 1, i, 1, i2);
        if (sArr == null) {
            throw new NullPointerException("dataArray is null");
        }
        if (i + i2 > sArr.length) {
            throw new IllegalArgumentException("Length of dataArray is less  than size+offset.");
        }
        this.data = sArr;
        this.bankdata = new short[][]{sArr};
    }

    public DataBufferUShort(short[][] sArr, int i) {
        super(StateTrackable.State.UNTRACKABLE, 1, i, sArr.length);
        for (int i2 = 0; i2 < sArr.length; i2++) {
            if (sArr[i2] == null) {
                throw new NullPointerException(AbstractC0541b.m767i(i2, "dataArray[", "] is null"));
            }
        }
        short[][] sArr2 = (short[][]) sArr.clone();
        this.bankdata = sArr2;
        this.data = sArr2[0];
    }

    public DataBufferUShort(short[][] sArr, int i, int[] iArr) {
        super(StateTrackable.State.UNTRACKABLE, 1, i, sArr.length, iArr);
        for (int i2 = 0; i2 < sArr.length; i2++) {
            short[] sArr2 = sArr[i2];
            if (sArr2 == null) {
                throw new NullPointerException(AbstractC0541b.m767i(i2, "dataArray[", "] is null"));
            }
            if (iArr[i2] + i > sArr2.length) {
                throw new IllegalArgumentException(AbstractC0622a.m1164j(i2, i2, "Length of dataArray[", "] is less than size+offsets[", "]."));
            }
        }
        short[][] sArr3 = (short[][]) sArr.clone();
        this.bankdata = sArr3;
        this.data = sArr3[0];
    }
}
