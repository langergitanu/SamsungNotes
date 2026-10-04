package com.samsung.android.support.senl.p148nt.model.utils;

import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.data.common.constants.DeleteType;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class DeleteParam {

    @NonNull
    private final String caller;
    private final boolean deleteExpiredNotes;
    private final boolean deleteFile;

    @DeleteType
    private int mDeleteType;

    public DeleteParam(@DeleteType int i, @NonNull String str, boolean z, boolean z2) {
        this.mDeleteType = i;
        this.caller = str;
        this.deleteExpiredNotes = z;
        this.deleteFile = z2;
    }

    public String getCaller() {
        return this.caller;
    }

    public int getDeleteType() {
        return this.mDeleteType;
    }

    public boolean isDeleteExpiredNotes() {
        return this.deleteExpiredNotes;
    }

    public boolean isDeleteFile() {
        return this.deleteFile;
    }

    public void setDeleteType(@DeleteType int i) {
        this.mDeleteType = i;
    }
}
