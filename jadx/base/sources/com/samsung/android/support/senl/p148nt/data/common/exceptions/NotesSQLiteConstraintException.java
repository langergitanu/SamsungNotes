package com.samsung.android.support.senl.p148nt.data.common.exceptions;

import android.database.sqlite.SQLiteConstraintException;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class NotesSQLiteConstraintException extends Exception {
    final String errorMsg;

    public NotesSQLiteConstraintException(SQLiteConstraintException sQLiteConstraintException) {
        this.errorMsg = sQLiteConstraintException.getMessage();
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.errorMsg;
    }

    @Override // java.lang.Throwable
    @NonNull
    public String toString() {
        String str = this.errorMsg;
        return str == null ? "" : str;
    }
}
