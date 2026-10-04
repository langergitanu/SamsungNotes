package com.samsung.android.support.senl.p148nt.data.resolver.lock.locker;

import android.content.Context;
import com.samsung.android.support.senl.p145cm.base.common.constants.LockType;
import com.samsung.android.support.senl.p148nt.base.common.TimeManager;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSyncManager;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.resolver.lock.encryption.SDocEncryptionHelper;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
abstract class AbsDocumentLocker implements DocumentLocker {
    private static final String TAG = DataLogger.createTag("AbsDocumentLocker");
    final Context mAppContext;
    final String mDocPath;
    final String mDocUuid;
    final NotesDocumentEntity mEntity;
    final boolean mNotify;

    public AbsDocumentLocker(Context context, NotesDocumentEntity notesDocumentEntity, boolean z) {
        this.mAppContext = context;
        this.mDocUuid = notesDocumentEntity.getUuid();
        this.mDocPath = notesDocumentEntity.getFilePath();
        this.mEntity = notesDocumentEntity;
        this.mNotify = z;
    }

    private void onLockDataUpdated() {
        if (this.mNotify) {
            notifyToTagBoard();
            RequestToSyncManager.INSTANCE.requestSyncByModification();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.data.resolver.lock.locker.DocumentLocker
    @LockType
    public abstract int getLockType();

    @Override // com.samsung.android.support.senl.p148nt.data.resolver.lock.locker.DocumentLocker
    public boolean lock() {
        boolean zLockFile = lockFile();
        if (zLockFile) {
            updateDatabase(getLockType(), RequestToSyncManager.INSTANCE.getAccountGuid(this.mAppContext));
            onLockDataUpdated();
        }
        DataLogger.m12307i(TAG, " lock, lockType/isLocked : " + getLockType() + "/" + zLockFile);
        return zLockFile;
    }

    public abstract boolean lockFile();

    public abstract void notifyToTagBoard();

    @Override // com.samsung.android.support.senl.p148nt.data.resolver.lock.locker.DocumentLocker
    public boolean unlock() {
        boolean zUnlockFile = unlockFile();
        if (zUnlockFile) {
            updateDatabase(0, "");
            onLockDataUpdated();
        }
        DataLogger.m12307i(TAG, " unlock, lockType/isUnlocked : " + getLockType() + "/" + zUnlockFile);
        return zUnlockFile;
    }

    public abstract boolean unlockFile();

    public void updateDatabase(@LockType int i, String str) {
        this.mEntity.setIsLock(i);
        this.mEntity.setLockAccountGuid(str);
        this.mEntity.setIsDirty(1);
        this.mEntity.setServerTimestamp(Long.valueOf(TimeManager.getCurrentTime()));
        new SDocEncryptionHelper(this.mAppContext, this.mEntity).encryptContents();
    }
}
