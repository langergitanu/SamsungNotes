package com.samsung.android.support.senl.p148nt.model.collector.common;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.composer.document.sdoc.SpenSDoc;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.document.SDocLocker;
import com.samsung.android.support.senl.p145cm.base.common.constants.LockType;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.constructor.DocumentConstructor;
import com.samsung.android.support.senl.p148nt.base.common.constants.LockConstants;
import com.samsung.android.support.senl.p148nt.base.common.sdk.util.SpenSdkInitializer;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.SpenWNoteObjectHelper;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.model.collector.common.ICollectParam;
import com.samsung.android.support.senl.p148nt.model.collector.util.NoteCreateModeUtil;
import com.samsung.android.support.senl.p148nt.model.common.log.CollectLogger;
import com.samsung.android.support.senl.p148nt.model.documents.file.DocumentFileManager;
import com.samsung.android.support.senl.p148nt.model.utils.SpenDocumentDisplayUtils;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class CollectInfo {
    private static final String TAG = CollectLogger.createTag("CollectInfo");
    private final CollectParam mCollectParam;
    private boolean mHasCustomerPdf;
    private boolean mIsSharedNote;
    private String mNotePath;
    private NoteType mNoteType;
    private SpenSDoc mSDoc;
    private final TaskType mTaskType;
    private final String mUuid;
    private SpenWNote mWNote;
    private final LinkedHashSet<String> mChangedPageIds = new LinkedHashSet<>();
    private LinkedHashSet<String> mAddedPageIds = new LinkedHashSet<>();
    private LinkedHashSet<String> mRemovedPageIds = new LinkedHashSet<>();
    private LinkedHashSet<SpenWPage> mChangedWPages = new LinkedHashSet<>();
    private int mLockType = 0;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum NoteType {
        W_NOTE,
        S_DOC
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum TaskType {
        NOTE,
        PDF
    }

    public CollectInfo(@NonNull CollectParam collectParam, TaskType taskType) {
        this.mCollectParam = collectParam;
        this.mUuid = collectParam.getUuid();
        this.mTaskType = taskType;
    }

    private void dumpPageInfo() {
        if (DeviceInfo.isEngMode()) {
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            StringBuilder sb3 = new StringBuilder();
            StringBuilder sb4 = new StringBuilder();
            Iterator<String> it = this.mChangedPageIds.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append(SQLKeyword.COMMA);
            }
            Iterator<String> it2 = this.mAddedPageIds.iterator();
            while (it2.hasNext()) {
                sb2.append(it2.next());
                sb2.append(SQLKeyword.COMMA);
            }
            Iterator<String> it3 = this.mRemovedPageIds.iterator();
            while (it3.hasNext()) {
                sb3.append(it3.next());
                sb3.append(SQLKeyword.COMMA);
            }
            Iterator<SpenWPage> it4 = this.mChangedWPages.iterator();
            while (it4.hasNext()) {
                sb4.append(it4.next().getId());
                sb4.append(SQLKeyword.COMMA);
            }
            String str = TAG;
            DataLogger.m12302d(str, "dumpPageInfo changedPageIds " + ((Object) sb));
            DataLogger.m12302d(str, "dumpPageInfo addedPageIds " + ((Object) sb2));
            DataLogger.m12302d(str, "dumpPageInfo removedPageIds " + ((Object) sb3));
            DataLogger.m12302d(str, "dumpPageInfo changedWPages " + ((Object) sb4));
        }
    }

    private LinkedHashSet<String> getAddedPages(LinkedHashSet<String> linkedHashSet, LinkedHashSet<String> linkedHashSet2) {
        LinkedHashSet<String> linkedHashSet3 = new LinkedHashSet<>(linkedHashSet);
        linkedHashSet3.removeAll(linkedHashSet2);
        return linkedHashSet3;
    }

    private LinkedHashSet<String> getRemovedPages(LinkedHashSet<String> linkedHashSet, LinkedHashSet<String> linkedHashSet2) {
        LinkedHashSet<String> linkedHashSet3 = new LinkedHashSet<>(linkedHashSet2);
        linkedHashSet3.removeAll(linkedHashSet);
        return linkedHashSet3;
    }

    private void setAllPageInfo(int i) {
        DataLogger.m12302d(TAG, "setAllPageInfo entityType : " + i);
        resetPageInfo();
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        for (SpenWPage spenWPage : this.mWNote.getPageList()) {
            if (!this.mHasCustomerPdf && SpenWNoteObjectHelper.hasPdfObjectRegardlessOfType(spenWPage)) {
                this.mHasCustomerPdf = true;
            }
            if (i != 3 || SpenWNoteObjectHelper.hasPdfObjectRegardlessOfType(spenWPage)) {
                this.mChangedPageIds.add(spenWPage.getId());
                this.mChangedWPages.add(spenWPage);
                linkedHashSet.add(spenWPage.getId());
            }
        }
        LinkedHashSet<String> linkedHashSet2 = new LinkedHashSet<>(NotesDataRepositoryFactory.newInstance(BaseUtils.getContext()).createDocumentStrokeRepository().getPageIdListByUuid(this.mUuid, i));
        this.mAddedPageIds = getAddedPages(linkedHashSet, linkedHashSet2);
        this.mRemovedPageIds = getRemovedPages(linkedHashSet, linkedHashSet2);
        dumpPageInfo();
    }

    private void setChangedPageInfo(int i) {
        DataLogger.m12302d(TAG, "setChangedPageInfo entityType : " + i);
        resetPageInfo();
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        for (SpenWPage spenWPage : this.mWNote.getPageList()) {
            if (!this.mHasCustomerPdf && SpenWNoteObjectHelper.hasPdfObjectRegardlessOfType(spenWPage)) {
                this.mHasCustomerPdf = true;
            }
            if (i != 3 || SpenWNoteObjectHelper.hasPdfObjectRegardlessOfType(spenWPage)) {
                if (this.mChangedPageIds.contains(spenWPage.getId())) {
                    this.mChangedWPages.add(spenWPage);
                }
                linkedHashSet.add(spenWPage.getId());
            }
        }
        LinkedHashSet<String> linkedHashSet2 = new LinkedHashSet<>(NotesDataRepositoryFactory.newInstance(BaseUtils.getContext()).createDocumentStrokeRepository().getPageIdListByUuid(this.mUuid, i));
        this.mAddedPageIds = getAddedPages(linkedHashSet, linkedHashSet2);
        this.mRemovedPageIds = getRemovedPages(linkedHashSet, linkedHashSet2);
        dumpPageInfo();
    }

    public void createDocument() {
        Context context = BaseUtils.getContext();
        if (SpenSdkInitializer.initialize(context)) {
            NotesDocumentEntity notesDocumentEntity = null;
            try {
                NotesDocumentEntity notesDocumentEntity2 = NotesDataRepositoryFactory.newInstance(context).createDocumentDataRepository().get(this.mUuid);
                if (notesDocumentEntity2 != null) {
                    try {
                        if (notesDocumentEntity2.getIsSavingByWhichPid() == 0) {
                            this.mNotePath = notesDocumentEntity2.getFilePath();
                        }
                        this.mLockType = notesDocumentEntity2.getIsLock();
                        this.mIsSharedNote = !TextUtils.isEmpty(notesDocumentEntity2.getMdeSpaceId());
                    } catch (Exception e) {
                        e = e;
                        notesDocumentEntity = notesDocumentEntity2;
                        StringBuilder sb = new StringBuilder(" uuid:");
                        sb.append(this.mUuid);
                        sb.append(" noteEntity:");
                        sb.append(notesDocumentEntity);
                        if (notesDocumentEntity != null) {
                            sb.append(" getIsSavingByWhichPid:");
                            sb.append(notesDocumentEntity.getIsSavingByWhichPid());
                        }
                        DataLogger.m12305f(TAG, "createDocument, e : " + e.getMessage() + " - " + ((Object) sb));
                    }
                }
                if (this.mNotePath.endsWith(".sdocx")) {
                    this.mWNote = DocumentFileManager.getInstance().open(context, this.mNotePath, SpenDocumentDisplayUtils.getScreenWidth(context), NoteCreateModeUtil.getNoteCreateMode(), false, UUIDUtils.isCoeditUuid(this.mUuid));
                    this.mNoteType = NoteType.W_NOTE;
                } else {
                    this.mSDoc = DocumentConstructor.makeSpenSDoc(context, this.mNotePath, LockConstants.EXTRA_VALUE_LOCK_CONFIRMED, new SDocLocker(context).getUserCode(), 4);
                    this.mNoteType = NoteType.S_DOC;
                }
            } catch (Exception e2) {
                e = e2;
            }
            DataLogger.m12302d(TAG, "createDocument, CollectInfo :  " + this);
        }
    }

    public Set<String> getAddedPageIds() {
        return this.mAddedPageIds;
    }

    public int getCancelType() {
        return this.mCollectParam.getCancelType();
    }

    @NonNull
    public Set<String> getChangedPageIds() {
        return this.mChangedPageIds;
    }

    public Set<SpenWPage> getChangedWPages() {
        return this.mChangedWPages;
    }

    public long getLastModifiedAt() {
        return this.mCollectParam.getLastModifiedAt();
    }

    @LockType
    public int getLockType() {
        return this.mLockType;
    }

    public String getNotePath() {
        return this.mNotePath;
    }

    public NoteType getNoteType() {
        return this.mNoteType;
    }

    public int getPriority() {
        return this.mCollectParam.getPriority();
    }

    public Set<String> getRemovedPageIds() {
        return this.mRemovedPageIds;
    }

    public SpenSDoc getSDoc() {
        return this.mSDoc;
    }

    public int getSourceType() {
        return this.mCollectParam.getSourceType();
    }

    public TaskType getTaskType() {
        return this.mTaskType;
    }

    public int getTriggerType() {
        return this.mCollectParam.getTriggerType();
    }

    public String getUuid() {
        return this.mUuid;
    }

    public SpenWNote getWNote() {
        return this.mWNote;
    }

    public boolean hasCustomerPdf() {
        return this.mHasCustomerPdf;
    }

    public boolean isSharedNote() {
        return this.mIsSharedNote;
    }

    public boolean isValid() {
        boolean z;
        String str = this.mUuid;
        if (str == null || str.isEmpty()) {
            DataLogger.m12302d(TAG, "isValid, invalid uuid");
            z = false;
        } else {
            z = true;
        }
        String str2 = this.mNotePath;
        if (str2 == null || str2.isEmpty()) {
            DataLogger.m12302d(TAG, "isValid, invalid notePath");
            z = false;
        }
        if (NoteType.W_NOTE == this.mNoteType) {
            if (this.mWNote == null) {
                DataLogger.m12302d(TAG, "isValid, invalid wNote");
                return false;
            }
        } else if (this.mSDoc == null) {
            DataLogger.m12302d(TAG, "isValid, invalid noteDoc");
            return false;
        }
        return z;
    }

    public void release() {
        SpenSDoc spenSDoc;
        DataLogger.m12302d(TAG, "release");
        synchronized (this) {
            try {
                DocumentFileManager.getInstance().close(this.mNotePath, this.mWNote, true);
                this.mWNote = null;
                spenSDoc = this.mSDoc;
            } catch (Exception e) {
                DataLogger.m12303e(TAG, "release, exception " + e.getMessage());
            }
            if (spenSDoc != null && !spenSDoc.isClosed()) {
                this.mSDoc.close(true);
                this.mSDoc = null;
            }
        }
        this.mChangedPageIds.clear();
        LinkedHashSet<String> linkedHashSet = this.mAddedPageIds;
        if (linkedHashSet != null) {
            linkedHashSet.clear();
            this.mAddedPageIds = null;
        }
        LinkedHashSet<String> linkedHashSet2 = this.mRemovedPageIds;
        if (linkedHashSet2 != null) {
            linkedHashSet2.clear();
            this.mRemovedPageIds = null;
        }
        LinkedHashSet<SpenWPage> linkedHashSet3 = this.mChangedWPages;
        if (linkedHashSet3 != null) {
            linkedHashSet3.clear();
            this.mChangedWPages = null;
        }
    }

    public void resetPageInfo() {
        DataLogger.m12302d(TAG, "resetPageInfo");
        this.mChangedPageIds.clear();
        this.mAddedPageIds.clear();
        this.mRemovedPageIds.clear();
        this.mChangedWPages.clear();
        this.mChangedPageIds.addAll(this.mCollectParam.getChangedPageIdList());
    }

    public void setPageInfo(int i) {
        if (this.mNoteType != NoteType.W_NOTE) {
            return;
        }
        if (this.mCollectParam.getIsNewNote() || getSourceType() != ICollectParam.SourceType.COMPOSER.getValue() || getTaskType() == TaskType.PDF) {
            setAllPageInfo(i);
        } else {
            setChangedPageInfo(i);
        }
    }

    @NonNull
    public String toString() {
        StringBuilder sb;
        Object obj;
        StringBuilder sb2 = new StringBuilder("uuid: ");
        sb2.append(this.mUuid);
        sb2.append(", notePath: ");
        sb2.append(DataLogger.getEncode(this.mNotePath));
        if (NoteType.W_NOTE == this.mNoteType) {
            sb = new StringBuilder(", wNote: ");
            obj = this.mWNote;
        } else {
            sb = new StringBuilder(", sDoc: ");
            obj = this.mSDoc;
        }
        sb.append(obj);
        sb2.append(sb.toString());
        sb2.append(", sourceType: ");
        sb2.append(this.mCollectParam.getSourceType());
        if (DeviceInfo.isEngMode()) {
            sb2.append('\n');
            for (String str : this.mChangedPageIds) {
                sb2.append(str.substring(str.lastIndexOf(45) + 1, str.length() - 1));
                sb2.append(SQLKeyword.COMMA);
            }
        }
        return sb2.toString();
    }
}
