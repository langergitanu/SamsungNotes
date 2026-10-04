package com.samsung.android.support.senl.p148nt.model.documents.data;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SaveResult {
    private Exception mException;
    private Boolean mIsDBSaved;
    private boolean mIsFileSaved;

    public boolean get() {
        if (!this.mIsFileSaved) {
            return false;
        }
        Boolean bool = this.mIsDBSaved;
        return bool == null || bool.booleanValue();
    }

    public Exception getException(@NonNull String str) {
        Exception exc = this.mException;
        return exc != null ? exc : new RuntimeException(str);
    }

    public boolean isDBSaved() {
        Boolean bool = this.mIsDBSaved;
        return bool != null && bool.booleanValue();
    }

    public boolean isFileSaved() {
        return this.mIsFileSaved;
    }

    public SaveResult setException(Exception exc) {
        this.mException = exc;
        return this;
    }

    public SaveResult setIsDBSaved(boolean z) {
        this.mIsDBSaved = Boolean.valueOf(z);
        return this;
    }

    public SaveResult setIsFileSaved(boolean z) {
        this.mIsFileSaved = z;
        return this;
    }

    @NonNull
    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder("mIsFileSaved: ");
        sb.append(this.mIsFileSaved);
        sb.append(", mIsDBSaved: ");
        sb.append(this.mIsDBSaved);
        if (this.mException != null) {
            str = ", e: " + this.mException;
        } else {
            str = "";
        }
        sb.append(str);
        return sb.toString();
    }
}
