package com.samsung.android.support.senl.p148nt.data.resolver.lock.locker;

import android.content.Context;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWNoteFile;
import com.samsung.android.support.senl.p145cm.base.common.constants.LockType;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSyncManager;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SdocXDocumentLocker extends AbsDocumentLocker {
    private static final String TAG = DataLogger.createTag("SdocXFileLocker");

    public SdocXDocumentLocker(Context context, NotesDocumentEntity notesDocumentEntity, boolean z) {
        super(context, notesDocumentEntity, z);
    }

    public static boolean unlockSdocXFile(@NonNull String str) {
        try {
            SpenWNoteFile.setDocumentType(str, SpenWNote.DocumentType.UNLOCKED_DOC);
            try {
                SpenWNoteFile.setOwnerId(str, "");
                return true;
            } catch (RuntimeException e) {
                DataLogger.m12303e(TAG, "unlockSdocXFile, fail to set ownerId, e : " + e.getMessage());
                return false;
            }
        } catch (RuntimeException e2) {
            DataLogger.m12303e(TAG, "unlockSdocXFile, fail to setDocType, e : " + e2.getMessage());
            return false;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.resolver.lock.locker.AbsDocumentLocker, com.samsung.android.support.senl.p148nt.data.resolver.lock.locker.DocumentLocker
    @LockType
    public int getLockType() {
        return 5;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.resolver.lock.locker.AbsDocumentLocker, com.samsung.android.support.senl.p148nt.data.resolver.lock.locker.DocumentLocker
    public /* bridge */ /* synthetic */ boolean lock() {
        return super.lock();
    }

    @Override // com.samsung.android.support.senl.p148nt.data.resolver.lock.locker.AbsDocumentLocker
    public boolean lockFile() {
        String accountGuid = RequestToSyncManager.INSTANCE.getAccountGuid(this.mAppContext);
        if (accountGuid == null) {
            accountGuid = "";
        }
        try {
            SpenWNoteFile.setOwnerId(this.mDocPath, accountGuid);
            try {
                SpenWNoteFile.setDocumentType(this.mDocPath, SpenWNote.DocumentType.LOCKED_WDOC);
                return true;
            } catch (RuntimeException e) {
                DataLogger.m12303e(TAG, "lockSdocXFile, fail to setDocType, e : " + e.getMessage());
                return false;
            }
        } catch (RuntimeException e2) {
            DataLogger.m12303e(TAG, "lockSdocXFile, fail to set ownerId, e : " + e2.getMessage());
            return false;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.resolver.lock.locker.AbsDocumentLocker
    public void notifyToTagBoard() {
        NotesDataRepositoryFactory.newInstance(this.mAppContext).createDocumentTagRepository().notifyTagBoardByUuid(this.mDocUuid);
    }

    @Override // com.samsung.android.support.senl.p148nt.data.resolver.lock.locker.AbsDocumentLocker, com.samsung.android.support.senl.p148nt.data.resolver.lock.locker.DocumentLocker
    public /* bridge */ /* synthetic */ boolean unlock() {
        return super.unlock();
    }

    @Override // com.samsung.android.support.senl.p148nt.data.resolver.lock.locker.AbsDocumentLocker
    public boolean unlockFile() {
        return unlockSdocXFile(this.mDocPath);
    }
}
