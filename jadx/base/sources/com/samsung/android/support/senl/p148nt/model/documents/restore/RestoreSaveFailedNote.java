package com.samsung.android.support.senl.p148nt.model.documents.restore;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.constants.SpenOpenMode;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSyncManager;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.document.save.DocumentDBSaver;
import com.samsung.android.support.senl.p148nt.model.document.save.ThumbnailCreator;
import com.samsung.android.support.senl.p148nt.model.documents.file.DocumentFileManager;
import com.samsung.android.support.senl.p148nt.model.utils.SpenDocumentDisplayUtils;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class RestoreSaveFailedNote implements Callable<Boolean> {
    private static final String TAG = ModelLogger.createTag("RestoreSaveFailedNote");
    private Context mAppContext;
    private Callback mCallback;
    private boolean mCreateThumbnail;
    private boolean mDiscardSnapSavedData;
    private final String mFilePath;
    private boolean mIsCoeditMode;
    private boolean mIsNewNote;
    private boolean mIsPdfReader;

    @SpenOpenMode
    private final int mSpenOpenMode;
    private final String mUuid;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Callback {
        void onPostRestore(boolean z);

        void onPreRestore();
    }

    public RestoreSaveFailedNote(@NonNull Context context, @NonNull String str, @NonNull String str2, @SpenOpenMode int i, @Nullable Callback callback) {
        this.mAppContext = context;
        this.mUuid = str;
        this.mFilePath = str2;
        this.mSpenOpenMode = i;
        this.mCallback = callback;
    }

    private void createThumbnail(@NonNull SpenWNote spenWNote) {
        if (this.mCreateThumbnail) {
            new ThumbnailCreator().saveThumbnail(this.mAppContext, spenWNote, this.mUuid);
        }
    }

    private void onPostRestore(boolean z) {
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onPostRestore(z);
        }
        release();
    }

    private void onPreRestore() {
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onPreRestore();
        }
    }

    private void release() {
        this.mCallback = null;
        this.mAppContext = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean restore() {
        String str;
        StringBuilder sb;
        DataLogger.m12307i(TAG, "restore - start, uuid: " + this.mUuid);
        boolean z = false;
        SpenWNote spenWNoteOpen = null;
        try {
            try {
                DocumentFileManager documentFileManager = DocumentFileManager.getInstance();
                Context context = this.mAppContext;
                spenWNoteOpen = documentFileManager.open(context, this.mFilePath, SpenDocumentDisplayUtils.getScreenWidth(context), this.mSpenOpenMode, this.mDiscardSnapSavedData, true, this.mIsCoeditMode);
                DocumentFileManager.getInstance().saveAsDirectory(spenWNoteOpen, this.mFilePath, true);
                if (this.mIsPdfReader) {
                    z = true;
                    try {
                        DocumentFileManager.getInstance().close(this.mFilePath, spenWNoteOpen, true);
                    } catch (Exception e) {
                        AbstractC11014a.m12333r(e, new StringBuilder("restore, fail to close note, e: "), TAG);
                    }
                    str = TAG;
                    sb = new StringBuilder("restore - end, uuid: ");
                } else {
                    createThumbnail(spenWNoteOpen);
                    if (!this.mIsNewNote) {
                        if (updateDatabase(spenWNoteOpen)) {
                        }
                        DocumentFileManager.getInstance().close(this.mFilePath, spenWNoteOpen, true);
                        str = TAG;
                        sb = new StringBuilder("restore - end, uuid: ");
                    }
                }
            } catch (Throwable th) {
                try {
                    DocumentFileManager.getInstance().close(this.mFilePath, spenWNoteOpen, true);
                } catch (Exception e2) {
                    AbstractC11014a.m12333r(e2, new StringBuilder("restore, fail to close note, e: "), TAG);
                }
                DataLogger.m12307i(TAG, "restore - end, uuid: " + this.mUuid);
                throw th;
            }
        } catch (Exception e3) {
            DataLogger.m12306f(TAG, "restore, fail to restore note: ", e3);
            try {
                DocumentFileManager.getInstance().close(this.mFilePath, spenWNoteOpen, true);
            } catch (Exception e5) {
                AbstractC11014a.m12333r(e5, new StringBuilder("restore, fail to close note, e: "), TAG);
            }
            str = TAG;
            sb = new StringBuilder("restore - end, uuid: ");
        }
        sb.append(this.mUuid);
        DataLogger.m12307i(str, sb.toString());
        return z;
    }

    private boolean updateDatabase(@Nullable SpenWNote spenWNote) {
        if (spenWNote == null) {
            return false;
        }
        NotesDataRepositoryFactory notesDataRepositoryFactoryNewInstance = NotesDataRepositoryFactory.newInstance(this.mAppContext);
        NotesDocumentEntity notesDocumentEntity = notesDataRepositoryFactoryNewInstance.createDocumentDataRepository().get(this.mUuid);
        if (notesDocumentEntity == null) {
            return false;
        }
        if (UUIDUtils.isGenUuid(this.mUuid)) {
            return true;
        }
        notesDocumentEntity.setIsDirty(1);
        notesDocumentEntity.setCategoryIsDirty(1);
        notesDocumentEntity.setServerTimestamp(Long.valueOf(notesDocumentEntity.getServerTimestamp().longValue() + 1));
        notesDocumentEntity.setCategoryServerTimeStamp(Long.valueOf(notesDocumentEntity.getCategoryServerTimeStamp().longValue() + 1));
        DocumentDBSaver.saveSDocX(notesDataRepositoryFactoryNewInstance, spenWNote, notesDocumentEntity, ThumbnailCreator.getEditedInfo(this.mAppContext, spenWNote).pageIndex());
        RequestToSyncManager.INSTANCE.requestSyncByModification();
        return true;
    }

    public RestoreSaveFailedNote setCreateThumbnail(boolean z) {
        this.mCreateThumbnail = z;
        return this;
    }

    public RestoreSaveFailedNote setDiscardSnapSavedData(boolean z) {
        this.mDiscardSnapSavedData = z;
        return this;
    }

    public RestoreSaveFailedNote setIsCoeditMode(boolean z) {
        this.mIsCoeditMode = z;
        return this;
    }

    public RestoreSaveFailedNote setIsNewNote(boolean z) {
        this.mIsNewNote = z;
        return this;
    }

    public RestoreSaveFailedNote setIsPdfReader(boolean z) {
        this.mIsPdfReader = z;
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public Boolean call() {
        onPreRestore();
        boolean zRestore = restore();
        onPostRestore(zRestore);
        DataLogger.m12305f(TAG, "restore, result: " + zRestore);
        return Boolean.valueOf(zRestore);
    }
}
