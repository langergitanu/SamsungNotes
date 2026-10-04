package com.samsung.android.support.senl.ntnl.coedit.domain.operation;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class NoteOpAttributes {
    private long mHandle;

    public NoteOpAttributes() {
        this.mHandle = NoteOpAttributes_construct();
    }

    private native long NoteOpAttributes_construct();

    private native void NoteOpAttributes_finalize(long j);

    private native List<String> NoteOpAttributes_getAttributeKeys(long j);

    private native List<String> NoteOpAttributes_getNewAttributes(long j);

    private native List<String> NoteOpAttributes_getOldAttributes(long j);

    private native void NoteOpAttributes_setAttributeKeys(long j, List<String> list);

    private native void NoteOpAttributes_setNewAttributes(long j, List<String> list);

    private native void NoteOpAttributes_setOldAttributes(long j, List<String> list);

    public List<String> getAttributeKeys() {
        return NoteOpAttributes_getAttributeKeys(this.mHandle);
    }

    public long getHandle() {
        return this.mHandle;
    }

    public List<String> getNewAttributes() {
        return NoteOpAttributes_getNewAttributes(this.mHandle);
    }

    public List<String> getOldAttributes() {
        return NoteOpAttributes_getOldAttributes(this.mHandle);
    }

    public void setAttributeKeys(List<String> list) {
        NoteOpAttributes_setAttributeKeys(this.mHandle, list);
    }

    public void setNewAttributes(List<String> list) {
        NoteOpAttributes_setNewAttributes(this.mHandle, list);
    }

    public void setOldAttributes(List<String> list) {
        NoteOpAttributes_setOldAttributes(this.mHandle, list);
    }

    public NoteOpAttributes(long j) {
        this.mHandle = j;
    }
}
