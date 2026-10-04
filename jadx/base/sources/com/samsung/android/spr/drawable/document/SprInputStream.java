package com.samsung.android.spr.drawable.document;

import com.samsung.android.spr.drawable.document.shape.SprObjectBase;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SprInputStream {

    /* JADX INFO: renamed from: in */
    private DataInputStream f5435in;
    public ArrayList<SprObjectBase> mAnimationObject;
    public short mMajorVersion;
    public short mMinorVersion;
    private long mPosition = 0;
    private long mMark = 0;

    public SprInputStream(InputStream inputStream) {
        this.f5435in = new DataInputStream(inputStream);
    }

    public long getPosition() {
        return this.mPosition;
    }

    public synchronized void mark(int i) {
        this.f5435in.mark(i);
        this.mMark = this.mPosition;
    }

    public int read() throws IOException {
        int i = this.f5435in.read();
        if (i >= 0) {
            this.mPosition++;
        }
        return i;
    }

    public byte readByte() throws IOException {
        byte b = this.f5435in.readByte();
        this.mPosition++;
        return b;
    }

    public float readFloat() throws IOException {
        float f = this.f5435in.readFloat();
        this.mPosition += 4;
        return f;
    }

    public int readInt() throws IOException {
        int i = this.f5435in.readInt();
        this.mPosition += 4;
        return i;
    }

    public short readShort() throws IOException {
        short s = this.f5435in.readShort();
        this.mPosition += 2;
        return s;
    }

    public synchronized void reset() {
        if (!this.f5435in.markSupported()) {
            throw new IOException("Mark not supported");
        }
        this.f5435in.reset();
        this.mPosition = this.mMark;
    }

    public long skip(long j) throws IOException {
        long jSkip = this.f5435in.skip(j);
        if (jSkip > 0) {
            this.mPosition += jSkip;
        }
        return jSkip;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i4 = this.f5435in.read(bArr, i, i2);
        if (i4 > 0) {
            this.mPosition += (long) i4;
        }
        return i4;
    }
}
