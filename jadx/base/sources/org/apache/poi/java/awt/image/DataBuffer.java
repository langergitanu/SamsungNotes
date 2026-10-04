package org.apache.poi.java.awt.image;

import kotlin.UShort;
import org.apache.poi.sun.awt.image.SunWritableRaster;
import org.apache.poi.sun.java2d.StateTrackable;
import org.apache.poi.sun.java2d.StateTrackableDelegate;
import p001A.AbstractC0000a;

/* JADX INFO: loaded from: classes10.dex */
public abstract class DataBuffer {
    public static final int TYPE_BYTE = 0;
    public static final int TYPE_DOUBLE = 5;
    public static final int TYPE_FLOAT = 4;
    public static final int TYPE_INT = 3;
    public static final int TYPE_SHORT = 2;
    public static final int TYPE_UNDEFINED = 32;
    public static final int TYPE_USHORT = 1;
    private static final int[] dataTypeSize = {8, 16, 16, 32, 32, 64};
    protected int banks;
    protected int dataType;
    protected int offset;
    protected int[] offsets;
    protected int size;
    StateTrackableDelegate theTrackable;

    static {
        SunWritableRaster.setDataStealer(new SunWritableRaster.DataStealer() { // from class: org.apache.poi.java.awt.image.DataBuffer.1
            @Override // org.apache.poi.sun.awt.image.SunWritableRaster.DataStealer
            public byte[] getData(DataBufferByte dataBufferByte, int i) {
                return dataBufferByte.bankdata[i];
            }

            @Override // org.apache.poi.sun.awt.image.SunWritableRaster.DataStealer
            public StateTrackableDelegate getTrackable(DataBuffer dataBuffer) {
                return dataBuffer.theTrackable;
            }

            @Override // org.apache.poi.sun.awt.image.SunWritableRaster.DataStealer
            public void setTrackable(DataBuffer dataBuffer, StateTrackableDelegate stateTrackableDelegate) {
                dataBuffer.theTrackable = stateTrackableDelegate;
            }

            @Override // org.apache.poi.sun.awt.image.SunWritableRaster.DataStealer
            public int[] getData(DataBufferInt dataBufferInt, int i) {
                return dataBufferInt.bankdata[i];
            }

            @Override // org.apache.poi.sun.awt.image.SunWritableRaster.DataStealer
            public short[] getData(DataBufferUShort dataBufferUShort, int i) {
                return dataBufferUShort.bankdata[i];
            }
        });
    }

    public DataBuffer(int i, int i2) {
        this(StateTrackable.State.UNTRACKABLE, i, i2);
    }

    public static int getDataTypeSize(int i) {
        if (i < 0 || i > 5) {
            throw new IllegalArgumentException(AbstractC0000a.m11h(i, "Unknown data type "));
        }
        return dataTypeSize[i];
    }

    public static int[] toIntArray(Object obj) {
        if (obj instanceof int[]) {
            return (int[]) obj;
        }
        int[] iArr = null;
        if (obj == null) {
            return null;
        }
        int i = 0;
        if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            int[] iArr2 = new int[sArr.length];
            while (i < sArr.length) {
                iArr2[i] = sArr[i] & UShort.MAX_VALUE;
                i++;
            }
            return iArr2;
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            iArr = new int[bArr.length];
            while (i < bArr.length) {
                iArr[i] = bArr[i] & 255;
                i++;
            }
        }
        return iArr;
    }

    public int getDataType() {
        return this.dataType;
    }

    public int getElem(int i) {
        return getElem(0, i);
    }

    public abstract int getElem(int i, int i2);

    public double getElemDouble(int i) {
        return getElem(i);
    }

    public float getElemFloat(int i) {
        return getElem(i);
    }

    public int getNumBanks() {
        return this.banks;
    }

    public int getOffset() {
        return this.offset;
    }

    public int[] getOffsets() {
        return (int[]) this.offsets.clone();
    }

    public int getSize() {
        return this.size;
    }

    public void setElem(int i, int i2) {
        setElem(0, i, i2);
    }

    public abstract void setElem(int i, int i2, int i4);

    public void setElemDouble(int i, double d) {
        setElem(i, (int) d);
    }

    public void setElemFloat(int i, float f) {
        setElem(i, (int) f);
    }

    public DataBuffer(int i, int i2, int i4) {
        this(StateTrackable.State.UNTRACKABLE, i, i2, i4);
    }

    public double getElemDouble(int i, int i2) {
        return getElem(i, i2);
    }

    public float getElemFloat(int i, int i2) {
        return getElem(i, i2);
    }

    public void setElemDouble(int i, int i2, double d) {
        setElem(i, i2, (int) d);
    }

    public void setElemFloat(int i, int i2, float f) {
        setElem(i, i2, (int) f);
    }

    public DataBuffer(int i, int i2, int i4, int i5) {
        this(StateTrackable.State.UNTRACKABLE, i, i2, i4, i5);
    }

    public DataBuffer(int i, int i2, int i4, int[] iArr) {
        this(StateTrackable.State.UNTRACKABLE, i, i2, i4, iArr);
    }

    public DataBuffer(StateTrackable.State state, int i, int i2) {
        this.theTrackable = StateTrackableDelegate.createInstance(state);
        this.dataType = i;
        this.banks = 1;
        this.size = i2;
        this.offset = 0;
        this.offsets = new int[1];
    }

    public DataBuffer(StateTrackable.State state, int i, int i2, int i4) {
        this.theTrackable = StateTrackableDelegate.createInstance(state);
        this.dataType = i;
        this.banks = i4;
        this.size = i2;
        this.offset = 0;
        this.offsets = new int[i4];
    }

    public DataBuffer(StateTrackable.State state, int i, int i2, int i4, int i5) {
        this.theTrackable = StateTrackableDelegate.createInstance(state);
        this.dataType = i;
        this.banks = i4;
        this.size = i2;
        this.offset = i5;
        this.offsets = new int[i4];
        for (int i6 = 0; i6 < i4; i6++) {
            this.offsets[i6] = i5;
        }
    }

    public DataBuffer(StateTrackable.State state, int i, int i2, int i4, int[] iArr) {
        if (i4 != iArr.length) {
            throw new ArrayIndexOutOfBoundsException("Number of banks does not match number of bank offsets");
        }
        this.theTrackable = StateTrackableDelegate.createInstance(state);
        this.dataType = i;
        this.banks = i4;
        this.size = i2;
        this.offset = iArr[0];
        this.offsets = (int[]) iArr.clone();
    }
}
