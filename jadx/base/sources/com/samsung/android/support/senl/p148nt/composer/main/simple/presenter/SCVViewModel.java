package com.samsung.android.support.senl.p148nt.composer.main.simple.presenter;

import androidx.lifecycle.ViewModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.simple.common.SimpleComposerConstant;
import com.samsung.android.support.senl.p148nt.composer.main.simple.model.NoteInfoManager;
import com.samsung.android.support.senl.p148nt.model.documents.file.DocumentFileManager;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SCVViewModel extends ViewModel {
    private static final String TAG = Logger.createTag("SCVViewModel", SimpleComposerConstant.TAG_PREFIX);
    private final NoteInfoManager mNoteInfoManager = new NoteInfoManager();
    private OnClearedListener mOnClearedListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnClearedListener {
        void onCleared();
    }

    public NoteInfoManager getNoteInfoManager() {
        return this.mNoteInfoManager;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        OnClearedListener onClearedListener = this.mOnClearedListener;
        if (onClearedListener != null) {
            onClearedListener.onCleared();
        }
        if (this.mNoteInfoManager.getNoteInfoArgument() == null || this.mNoteInfoManager.getNote() == null || !this.mNoteInfoManager.getNoteInfoArgument().isNeededClose()) {
            return;
        }
        try {
            DocumentFileManager.getInstance().close(this.mNoteInfoManager.getLoadPath(), this.mNoteInfoManager.getNote(), true);
        } catch (IOException e) {
            Logger.m11001e(TAG, "onCleared# " + e.getMessage(), e);
        }
    }

    public void setOnClearedListener(OnClearedListener onClearedListener) {
        this.mOnClearedListener = onClearedListener;
    }
}
