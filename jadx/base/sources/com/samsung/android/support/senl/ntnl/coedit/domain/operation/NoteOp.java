package com.samsung.android.support.senl.ntnl.coedit.domain.operation;

import android.util.Pair;
import com.samsung.android.support.senl.ntnl.coedit.common.raw.Element;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class NoteOp {
    private NoteOpFileData fileData;
    private long mHandle;
    private NoteOpReplaceAttributes replaceAttributes;
    private NoteOpSetAnnotations setAnnotations;
    private NoteOpUpdateAttributes updateAttributes;

    public NoteOp() {
        this.mHandle = NoteOp_construct();
    }

    private native void NoteOp_addAllDeleteElements(long j, int i, long[] jArr);

    private native void NoteOp_addAllInsertElements(long j, int i, long[] jArr);

    private native long NoteOp_construct();

    private native void NoteOp_finalize(long j);

    private native String NoteOp_getBinaryHash(long j);

    private native String NoteOp_getBinaryMimeType(long j);

    private native long NoteOp_getBinarySize(long j);

    private native String NoteOp_getDeleteCharacters(long j);

    private native String NoteOp_getDeleteElementName(long j, int i);

    private native long[] NoteOp_getDeleteElements(long j);

    private native int NoteOp_getDeleteElementsSize(long j);

    private native Pair<String, String> NoteOp_getDeleteObjectSpan(long j);

    private native long NoteOp_getFileData(long j);

    private native long NoteOp_getId(long j);

    private native String NoteOp_getInsertCharacters(long j);

    private native String NoteOp_getInsertElementName(long j, int i);

    private native long[] NoteOp_getInsertElements(long j);

    private native int NoteOp_getInsertElementsSize(long j);

    private native Pair<String, String> NoteOp_getInsertObjectSpan(long j);

    private native String NoteOp_getObjectId(long j);

    private native int NoteOp_getPos(long j);

    private native long NoteOp_getReplaceAttributes(long j);

    private native long NoteOp_getSetAnnotations(long j);

    private native int NoteOp_getSize(long j);

    private native int NoteOp_getType(long j);

    private native long NoteOp_getUpdateAttributes(long j);

    private native String NoteOp_getXmlData(long j);

    private native boolean NoteOp_isDeleteElementEnd(long j, int i);

    private native boolean NoteOp_isInsertElementEnd(long j, int i);

    private native boolean NoteOp_isTransformed(long j);

    private native void NoteOp_removeDeleteElement(long j, int i);

    private native void NoteOp_removeInsertElement(long j, int i);

    private native void NoteOp_setBinaryHash(long j, String str);

    private native void NoteOp_setBinaryMimeType(long j, String str);

    private native void NoteOp_setBinarySize(long j, long j2);

    private native void NoteOp_setDeleteCharacters(long j, String str);

    private native void NoteOp_setDeleteElementEnd(long j, int i, boolean z);

    private native void NoteOp_setDeleteElements(long j, long[] jArr);

    private native void NoteOp_setDeleteObjectSpan(long j, Pair<String, String> pair);

    private native void NoteOp_setFileData(long j, long j2);

    private native void NoteOp_setFileDataXmlIndex(long j, int i);

    private native void NoteOp_setId(long j, long j2);

    private native void NoteOp_setInsertCharacters(long j, String str);

    private native void NoteOp_setInsertElementEnd(long j, int i, boolean z);

    private native void NoteOp_setInsertElements(long j, long[] jArr);

    private native void NoteOp_setInsertObjectSpan(long j, Pair<String, String> pair);

    private native void NoteOp_setObjectId(long j, String str);

    private native void NoteOp_setPos(long j, int i);

    private native void NoteOp_setReplaceAttributes(long j, long j2);

    private native void NoteOp_setSetAnnotations(long j, long j2);

    private native void NoteOp_setSize(long j, int i);

    private native void NoteOp_setTransformed(long j, boolean z);

    private native void NoteOp_setType(long j, int i);

    private native void NoteOp_setUpdateAttributes(long j, long j2);

    private native void NoteOp_setXmlData(long j, String str);

    public void addAllDeleteElements(int i, List<Element> list) {
        int size = list.size();
        long[] jArr = new long[size];
        for (int i2 = 0; i2 < size; i2++) {
            jArr[i2] = list.get(i2).getHandle();
        }
        NoteOp_addAllDeleteElements(this.mHandle, i, jArr);
    }

    public void addAllInsertElements(int i, List<Element> list) {
        int size = list.size();
        long[] jArr = new long[size];
        for (int i2 = 0; i2 < size; i2++) {
            jArr[i2] = list.get(i2).getHandle();
        }
        NoteOp_addAllInsertElements(this.mHandle, i, jArr);
    }

    public void finalize() {
        long j = this.mHandle;
        if (j == 0) {
            return;
        }
        NoteOp_finalize(j);
        this.mHandle = 0L;
    }

    public String getBinaryHash() {
        return NoteOp_getBinaryHash(this.mHandle);
    }

    public String getBinaryMimeType() {
        return NoteOp_getBinaryMimeType(this.mHandle);
    }

    public long getBinarySize() {
        return NoteOp_getBinarySize(this.mHandle);
    }

    public String getDeleteCharacters() {
        return NoteOp_getDeleteCharacters(this.mHandle);
    }

    public String getDeleteElementName(int i) {
        return NoteOp_getDeleteElementName(this.mHandle, i);
    }

    public List<Element> getDeleteElements() {
        long[] jArrNoteOp_getDeleteElements = NoteOp_getDeleteElements(this.mHandle);
        ArrayList arrayList = new ArrayList();
        for (long j : jArrNoteOp_getDeleteElements) {
            arrayList.add(new Element(j));
        }
        return arrayList;
    }

    public int getDeleteElementsSize() {
        return NoteOp_getDeleteElementsSize(this.mHandle);
    }

    public Pair<String, String> getDeleteObjectSpan() {
        return NoteOp_getDeleteObjectSpan(this.mHandle);
    }

    public NoteOpFileData getFileData() {
        if (this.fileData == null) {
            long jNoteOp_getFileData = NoteOp_getFileData(this.mHandle);
            if (jNoteOp_getFileData == 0) {
                return null;
            }
            this.fileData = new NoteOpFileData(jNoteOp_getFileData);
        }
        return this.fileData;
    }

    public long getHandle() {
        return this.mHandle;
    }

    public long getId() {
        return NoteOp_getId(this.mHandle);
    }

    public String getInsertCharacters() {
        return NoteOp_getInsertCharacters(this.mHandle);
    }

    public String getInsertElementName(int i) {
        return NoteOp_getInsertElementName(this.mHandle, i);
    }

    public List<Element> getInsertElements() {
        long[] jArrNoteOp_getInsertElements = NoteOp_getInsertElements(this.mHandle);
        ArrayList arrayList = new ArrayList();
        for (long j : jArrNoteOp_getInsertElements) {
            arrayList.add(new Element(j));
        }
        return arrayList;
    }

    public int getInsertElementsSize() {
        return NoteOp_getInsertElementsSize(this.mHandle);
    }

    public Pair<String, String> getInsertObjectSpan() {
        return NoteOp_getInsertObjectSpan(this.mHandle);
    }

    public String getObjectId() {
        return NoteOp_getObjectId(this.mHandle);
    }

    public int getPos() {
        return NoteOp_getPos(this.mHandle);
    }

    public NoteOpReplaceAttributes getReplaceAttributes() {
        if (this.replaceAttributes == null) {
            this.replaceAttributes = new NoteOpReplaceAttributes(NoteOp_getReplaceAttributes(this.mHandle));
        }
        return this.replaceAttributes;
    }

    public NoteOpSetAnnotations getSetAnnotations() {
        if (this.setAnnotations == null) {
            this.setAnnotations = new NoteOpSetAnnotations(NoteOp_getSetAnnotations(this.mHandle));
        }
        return this.setAnnotations;
    }

    public int getSize() {
        return NoteOp_getSize(this.mHandle);
    }

    public int getType() {
        return NoteOp_getType(this.mHandle);
    }

    public NoteOpUpdateAttributes getUpdateAttributes() {
        if (this.updateAttributes == null) {
            this.updateAttributes = new NoteOpUpdateAttributes(NoteOp_getUpdateAttributes(this.mHandle));
        }
        return this.updateAttributes;
    }

    public String getXmlData() {
        return NoteOp_getXmlData(this.mHandle);
    }

    public boolean isDeleteElementEnd(int i) {
        return NoteOp_isDeleteElementEnd(this.mHandle, i);
    }

    public boolean isInsertElementEnd(int i) {
        return NoteOp_isInsertElementEnd(this.mHandle, i);
    }

    public boolean isTransformed() {
        return NoteOp_isTransformed(this.mHandle);
    }

    public void removeDeleteElement(int i) {
        NoteOp_removeDeleteElement(this.mHandle, i);
    }

    public void removeInsertElement(int i) {
        NoteOp_removeInsertElement(this.mHandle, i);
    }

    public void setBinaryHash(String str) {
        NoteOp_setBinaryHash(this.mHandle, str);
    }

    public void setBinaryMimeType(String str) {
        NoteOp_setBinaryMimeType(this.mHandle, str);
    }

    public void setBinarySize(long j) {
        NoteOp_setBinarySize(this.mHandle, j);
    }

    public void setDeleteCharacters(String str) {
        NoteOp_setDeleteCharacters(this.mHandle, str);
    }

    public void setDeleteElementEnd(int i, boolean z) {
        NoteOp_setDeleteElementEnd(this.mHandle, i, z);
    }

    public void setDeleteElements(List<Element> list) {
        int size = list.size();
        long[] jArr = new long[size];
        for (int i = 0; i < size; i++) {
            jArr[i] = list.get(i).getHandle();
        }
        NoteOp_setDeleteElements(this.mHandle, jArr);
    }

    public void setDeleteObjectSpan(Pair<String, String> pair) {
        NoteOp_setDeleteObjectSpan(this.mHandle, pair);
    }

    public void setFileData(NoteOpFileData noteOpFileData) {
        if (noteOpFileData == null) {
            return;
        }
        this.fileData = noteOpFileData;
        NoteOp_setFileData(this.mHandle, noteOpFileData.getHandle());
    }

    public void setFileDataXmlIndex(int i) {
        NoteOp_setFileDataXmlIndex(this.mHandle, i);
    }

    public void setId(long j) {
        NoteOp_setId(this.mHandle, j);
    }

    public void setInsertCharacters(String str) {
        NoteOp_setInsertCharacters(this.mHandle, str);
    }

    public void setInsertElementEnd(int i, boolean z) {
        NoteOp_setInsertElementEnd(this.mHandle, i, z);
    }

    public void setInsertElements(List<Element> list) {
        int size = list.size();
        long[] jArr = new long[size];
        for (int i = 0; i < size; i++) {
            jArr[i] = list.get(i).getHandle();
        }
        NoteOp_setInsertElements(this.mHandle, jArr);
    }

    public void setInsertObjectSpan(Pair<String, String> pair) {
        NoteOp_setInsertObjectSpan(this.mHandle, pair);
    }

    public void setObjectId(String str) {
        NoteOp_setObjectId(this.mHandle, str);
    }

    public void setPos(int i) {
        NoteOp_setPos(this.mHandle, i);
    }

    public void setReplaceAttributes(NoteOpReplaceAttributes noteOpReplaceAttributes) {
        this.replaceAttributes = noteOpReplaceAttributes;
        NoteOp_setReplaceAttributes(this.mHandle, noteOpReplaceAttributes.getHandle());
    }

    public void setSetAnnotations(NoteOpSetAnnotations noteOpSetAnnotations) {
        this.setAnnotations = noteOpSetAnnotations;
        NoteOp_setSetAnnotations(this.mHandle, noteOpSetAnnotations.getHandle());
    }

    public void setSize(int i) {
        NoteOp_setSize(this.mHandle, i);
    }

    public void setTransformed(boolean z) {
        NoteOp_setTransformed(this.mHandle, z);
    }

    public void setType(int i) {
        NoteOp_setType(this.mHandle, i);
    }

    public void setUpdateAttributes(NoteOpUpdateAttributes noteOpUpdateAttributes) {
        this.updateAttributes = noteOpUpdateAttributes;
        NoteOp_setUpdateAttributes(this.mHandle, noteOpUpdateAttributes.getHandle());
    }

    public void setXmlData(String str) {
        NoteOp_setXmlData(this.mHandle, str);
    }

    public NoteOp(long j) {
        this.mHandle = j;
    }
}
