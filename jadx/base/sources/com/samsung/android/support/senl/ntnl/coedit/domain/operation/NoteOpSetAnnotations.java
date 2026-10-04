package com.samsung.android.support.senl.ntnl.coedit.domain.operation;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class NoteOpSetAnnotations {
    private long mHandle;

    public NoteOpSetAnnotations() {
        this.mHandle = NoteOpSetAnnotations_construct();
    }

    private native long NoteOpSetAnnotations_construct();

    private native void NoteOpSetAnnotations_finalize(long j);

    private native int NoteOpSetAnnotations_getEndIndex(long j);

    private native Map<String, String> NoteOpSetAnnotations_getNewAnnotation(long j);

    private native Map<String, String> NoteOpSetAnnotations_getOldAnnotation(long j);

    private native void NoteOpSetAnnotations_setEndIndex(long j, int i);

    private native void NoteOpSetAnnotations_setNewAnnotation(long j, Map<String, String> map);

    private native void NoteOpSetAnnotations_setOldAnnotation(long j, Map<String, String> map);

    public int getEndIndex() {
        return NoteOpSetAnnotations_getEndIndex(this.mHandle);
    }

    public long getHandle() {
        return this.mHandle;
    }

    public Map<String, String> getNewAnnotation() {
        return NoteOpSetAnnotations_getNewAnnotation(this.mHandle);
    }

    public Map<String, String> getOldAnnotation() {
        return NoteOpSetAnnotations_getOldAnnotation(this.mHandle);
    }

    public void setEndIndex(int i) {
        NoteOpSetAnnotations_setEndIndex(this.mHandle, i);
    }

    public void setNewAnnotation(Map<String, String> map) {
        NoteOpSetAnnotations_setNewAnnotation(this.mHandle, map);
    }

    public void setOldAnnotation(Map<String, String> map) {
        NoteOpSetAnnotations_setOldAnnotation(this.mHandle, map);
    }

    public NoteOpSetAnnotations(long j) {
        this.mHandle = j;
    }
}
