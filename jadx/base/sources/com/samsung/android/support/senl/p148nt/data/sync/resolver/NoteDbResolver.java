package com.samsung.android.support.senl.p148nt.data.sync.resolver;

import android.content.Context;
import android.text.TextUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.ComposerManager;
import com.samsung.android.support.senl.p148nt.base.common.util.CoeditCacheUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.core.converter.DisplayDataConverter;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.document.NotesDocumentRepository;
import com.samsung.android.support.senl.p148nt.data.repository.sync.SyncNoteDataRepository;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class NoteDbResolver {
    private static final String TAG = "NT/NoteDbResolver";
    private NotesDocumentEntity documentEntity;
    Context mAppContext;
    private String mDocUuid;

    public NoteDbResolver(String str) {
        Context applicationContext = BaseUtils.getApplicationContext();
        this.mAppContext = applicationContext;
        if (applicationContext == null) {
            DataLogger.m12303e(TAG, "Application context is null. Cannot initialize NoteDbResolver");
        } else {
            this.mDocUuid = str;
            this.documentEntity = NotesDataRepositoryFactory.newInstance(applicationContext).createDocumentDataRepository().get(this.mDocUuid);
        }
    }

    public boolean exists() {
        if (this.documentEntity != null) {
            return true;
        }
        DataLogger.m12307i(TAG, "[9-2] No coedit note : " + this.mDocUuid);
        return false;
    }

    public String getGroupId() {
        NotesDocumentEntity notesDocumentEntity = this.documentEntity;
        if (notesDocumentEntity == null) {
            DataLogger.m12303e(TAG, "[9-2] No Entity, No groupId");
            return null;
        }
        String mdeGroupId = notesDocumentEntity.getMdeGroupId();
        if (TextUtils.isEmpty(mdeGroupId)) {
            DataLogger.m12303e(TAG, "[9-2] No groupId!");
        }
        return mdeGroupId;
    }

    public String getItemId() {
        NotesDocumentEntity notesDocumentEntity = this.documentEntity;
        if (notesDocumentEntity == null) {
            DataLogger.m12303e(TAG, "[9-2] No Entity, No itemId");
            return null;
        }
        String mdeItemId = notesDocumentEntity.getMdeItemId();
        if (TextUtils.isEmpty(mdeItemId)) {
            DataLogger.m12303e(TAG, "[9-2] No itemId!");
        }
        return mdeItemId;
    }

    public String getWorkspaceId() {
        String referenceResourceId = new SyncNoteDataRepository().getReferenceResourceId(this.mDocUuid);
        if (TextUtils.isEmpty(referenceResourceId)) {
            DataLogger.m12303e(TAG, "[9-2] No workspaceId!");
        }
        return referenceResourceId;
    }

    public void setCommitId(String str) {
        if (TextUtils.isEmpty(str)) {
            DataLogger.m12303e(TAG, "[9-2] setCommitId() : No commitId!");
        } else {
            new SyncNoteDataRepository().updateCommitId(this.mDocUuid, str);
        }
    }

    public void setWorkspaceId(String str) {
        if (TextUtils.isEmpty(str)) {
            DataLogger.m12303e(TAG, "[9-2] setWorkspaceId() : No workspaceId!");
        } else {
            new SyncNoteDataRepository().setReferenceResourceId(this.mDocUuid, str);
        }
    }

    public void updateTitleAndModifiedTime(String str, long j) {
        if (this.documentEntity == null) {
            return;
        }
        if (CoeditCacheUtils.isLocalDataChanged(this.mDocUuid)) {
            DataLogger.m12309w(TAG, "[9-2] updateTitleAndModifiedTime, isLocalDataChanged " + this.mDocUuid);
            return;
        }
        if (!UUIDUtils.isCoeditUuid(this.mDocUuid)) {
            DataLogger.m12309w(TAG, "[9-2] updateTitleAndModifiedTime, is old coedit note " + this.mDocUuid);
        } else {
            if (ComposerManager.getInstance().isRunningOnCoeditMode()) {
                DataLogger.m12309w(TAG, "[9-2] updateTitleAndModifiedTime, stop, isRunningOnCoeditMode");
                return;
            }
            NotesDocumentRepository notesDocumentRepository = new NotesDocumentRepository(this.mAppContext);
            if (this.mDocUuid.equals(str)) {
                str = "";
            }
            if (j <= this.documentEntity.getLastModifiedAt()) {
                return;
            }
            notesDocumentRepository.updateTitle(this.mDocUuid, str, DisplayDataConverter.convertDisplayData(str));
            new SyncNoteDataRepository().updateModifiedTime(this.mDocUuid, j);
        }
    }
}
