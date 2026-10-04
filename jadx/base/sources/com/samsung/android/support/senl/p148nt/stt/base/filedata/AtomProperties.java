package com.samsung.android.support.senl.p148nt.stt.base.filedata;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public class AtomProperties {
    private int mLength;
    private long mPosition;

    public AtomProperties() {
        this.mLength = 0;
        this.mPosition = 0L;
    }

    public int getLength() {
        return this.mLength;
    }

    public long getPosition() {
        return this.mPosition;
    }

    public void setLength(int i) {
        this.mLength = i;
    }

    public void setPosition(long j) {
        this.mPosition = j;
    }

    public AtomProperties(int i, long j) {
        this.mLength = i;
        this.mPosition = j;
    }
}
