package com.samsung.android.support.senl.p148nt.composer.main.simple.model;

import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.simple.common.SimpleComposerConstant;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class NoteInfoManager {
    private static final String TAG = Logger.createTag("NoteInfoManager", SimpleComposerConstant.TAG_PREFIX);
    private String mLoadPath;
    private SpenWNote mNote;
    private NoteInfoArgument mNoteInfoArgument;

    public String getLoadPath() {
        return this.mLoadPath;
    }

    public SpenWNote getNote() {
        return this.mNote;
    }

    public NoteInfoArgument getNoteInfoArgument() {
        return this.mNoteInfoArgument;
    }

    public void setNote(SpenWNote spenWNote, String str) {
        this.mNote = spenWNote;
        this.mLoadPath = str;
    }

    public void setNoteInfoArgument(NoteInfoArgument noteInfoArgument) {
        this.mNoteInfoArgument = noteInfoArgument;
    }
}
