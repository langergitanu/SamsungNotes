package com.samsung.android.support.senl.p148nt.model.importer.task.param;

import android.content.Context;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public abstract class ImportBaseParam<T> {
    private Context mAppContext;
    private NotesDocumentEntity mEntity;
    private String mExternalPath;
    private String mFolderUuid;
    private String mUuid;
    private Pair<String, String> mUuidPair;
    private String mTitle = "";
    private String mCaller = "";
    private boolean mIsNew = true;
    private int mOpenMode = -1;
    private boolean mExecutePostOperation = true;

    public ImportBaseParam(@NonNull String str) {
        this.mFolderUuid = str;
    }

    public boolean executePostOperation() {
        return this.mExecutePostOperation;
    }

    @NonNull
    public String getCaller() {
        return this.mCaller;
    }

    public Context getContext() {
        return this.mAppContext;
    }

    public NotesDocumentEntity getEntity() {
        return this.mEntity;
    }

    public String getExternalPath() {
        return this.mExternalPath;
    }

    @NonNull
    public String getFolderUuid() {
        return this.mFolderUuid;
    }

    public int getOpenMode() {
        return this.mOpenMode;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getUuid() {
        return this.mUuid;
    }

    public Pair<String, String> getUuidPair() {
        return this.mUuidPair;
    }

    public boolean isNew() {
        return this.mIsNew;
    }

    public abstract T self();

    public T setCaller(@NonNull String str) {
        this.mCaller = str;
        return self();
    }

    public T setContext(Context context) {
        this.mAppContext = context.getApplicationContext();
        return self();
    }

    public T setEntity(NotesDocumentEntity notesDocumentEntity) {
        this.mEntity = notesDocumentEntity;
        return self();
    }

    public T setExecutePostOperation(boolean z) {
        this.mExecutePostOperation = z;
        return self();
    }

    public T setExternalPath(String str) {
        this.mExternalPath = str;
        return self();
    }

    public T setFolderUuid(@NonNull String str) {
        this.mFolderUuid = str;
        return self();
    }

    public T setIsNew(boolean z) {
        this.mIsNew = z;
        return self();
    }

    public T setOpenMode(int i) {
        this.mOpenMode = i;
        return self();
    }

    public T setTitle(String str) {
        this.mTitle = str;
        return self();
    }

    public T setUuid(String str) {
        this.mUuid = str;
        return self();
    }

    public T setUuidPair(Pair<String, String> pair) {
        this.mUuidPair = pair;
        return self();
    }
}
