package com.samsung.android.support.senl.p148nt.app.main.noteslist.model.checkdata;

import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class CheckNotesCountInfo {
    private int mFavoriteNotesCount;
    private int mImportLockedNotesCount;
    private int mLockedNotesCount;
    private int mOldNotesCount;

    private void init() {
        this.mImportLockedNotesCount = 0;
        this.mOldNotesCount = 0;
        this.mLockedNotesCount = 0;
        this.mFavoriteNotesCount = 0;
    }

    public CheckNotesCountInfo getCheckNotesCountInfo(HashMap<String, CheckedNoteInfo> map) {
        init();
        for (CheckedNoteInfo checkedNoteInfo : map.values()) {
            if (checkedNoteInfo.isSdoc()) {
                this.mOldNotesCount++;
            }
            if (checkedNoteInfo.isLock() && checkedNoteInfo.getLockType() > 1 && checkedNoteInfo.getLockType() < 5) {
                this.mImportLockedNotesCount++;
            }
            if (checkedNoteInfo.isLock()) {
                this.mLockedNotesCount++;
            }
            if (checkedNoteInfo.isFavorite()) {
                this.mFavoriteNotesCount++;
            }
        }
        return this;
    }

    public int getDeletableCheckedLockNotesCount() {
        return this.mLockedNotesCount - this.mImportLockedNotesCount;
    }

    public int getFavoriteNotesCount() {
        return this.mFavoriteNotesCount;
    }

    public int getImportLockedNotesCount() {
        return this.mImportLockedNotesCount;
    }

    public int getLockedNotesCount() {
        return this.mLockedNotesCount;
    }

    public int getOldNotesCount() {
        return this.mOldNotesCount;
    }
}
