package com.samsung.android.support.senl.ntnl.coedit.domain.operation;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class NoteOpFileData {
    private long mHandle;

    public NoteOpFileData() {
        this.mHandle = NoteOpFileData_construct();
    }

    private native long NoteOpFileData_construct();

    private native void NoteOpFileData_finalize(long j);

    private native byte[] NoteOpFileData_getBinaryData(long j);

    private native long NoteOpFileData_getBinarySize(long j);

    private native String NoteOpFileData_getFilePath(long j);

    private native String NoteOpFileData_getHash(long j);

    private native String NoteOpFileData_getId(long j);

    private native String NoteOpFileData_getMimeType(long j);

    private native String NoteOpFileData_getModifiedTime(long j);

    private native int NoteOpFileData_getXmlIndex(long j);

    private native void NoteOpFileData_loadCoeditCache(long j, String str);

    private native void NoteOpFileData_saveCoeditCache(long j, String str);

    private native void NoteOpFileData_setBinaryData(long j, byte[] bArr);

    private native void NoteOpFileData_setBinarySize(long j, long j2);

    private native void NoteOpFileData_setFilePath(long j, String str);

    private native void NoteOpFileData_setHash(long j, String str);

    private native void NoteOpFileData_setId(long j, String str);

    private native void NoteOpFileData_setMimeType(long j, String str);

    private native void NoteOpFileData_setModifiedTime(long j, String str);

    private native void NoteOpFileData_setXmlIndex(long j, int i);

    public void finalize() {
        long j = this.mHandle;
        if (j == 0) {
            return;
        }
        NoteOpFileData_finalize(j);
        this.mHandle = 0L;
    }

    public byte[] getBinaryData() {
        return NoteOpFileData_getBinaryData(this.mHandle);
    }

    public long getBinarySize() {
        return NoteOpFileData_getBinarySize(this.mHandle);
    }

    public String getFilePath() {
        return NoteOpFileData_getFilePath(this.mHandle);
    }

    public long getHandle() {
        return this.mHandle;
    }

    public String getHash() {
        return NoteOpFileData_getHash(this.mHandle);
    }

    public String getId() {
        return NoteOpFileData_getId(this.mHandle);
    }

    public String getMimeType() {
        return NoteOpFileData_getMimeType(this.mHandle);
    }

    public String getModifiedTime() {
        return NoteOpFileData_getModifiedTime(this.mHandle);
    }

    public int getXmlIndex() {
        return NoteOpFileData_getXmlIndex(this.mHandle);
    }

    public void loadCoeditCache(String str) {
        NoteOpFileData_loadCoeditCache(this.mHandle, str);
    }

    public void saveCoeditCache(String str) {
        NoteOpFileData_saveCoeditCache(this.mHandle, str);
    }

    public void setBinaryData(byte[] bArr) {
        NoteOpFileData_setBinaryData(this.mHandle, bArr);
    }

    public void setBinarySize(long j) {
        NoteOpFileData_setBinarySize(this.mHandle, j);
    }

    public void setFilePath(String str) {
        NoteOpFileData_setFilePath(this.mHandle, str);
    }

    public void setHash(String str) {
        NoteOpFileData_setHash(this.mHandle, str);
    }

    public void setId(String str) {
        NoteOpFileData_setId(this.mHandle, str);
    }

    public void setMimeType(String str) {
        NoteOpFileData_setMimeType(this.mHandle, str);
    }

    public void setModifiedTime(String str) {
        NoteOpFileData_setModifiedTime(this.mHandle, str);
    }

    public void setXmlIndex(int i) {
        NoteOpFileData_setXmlIndex(this.mHandle, i);
    }

    public NoteOpFileData(long j) {
        this.mHandle = j;
    }
}
