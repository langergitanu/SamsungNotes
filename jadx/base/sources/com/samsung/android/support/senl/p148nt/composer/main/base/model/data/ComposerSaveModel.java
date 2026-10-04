package com.samsung.android.support.senl.p148nt.composer.main.base.model.data;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.glance.AbstractC2821a;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.common.ExecuteCallback;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.data.DocContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentSchedulerDataSource;
import com.samsung.android.support.senl.p148nt.model.documents.file.DocumentFileManager;
import com.samsung.android.support.senl.p148nt.model.documents.spen.SpenWordDocument;
import com.samsung.android.support.senl.p148nt.model.executor.scheduler.SchedulerDataSource;
import com.samsung.android.support.senl.p148nt.model.repository.data.NotesDocument;
import java.io.File;
import p188i3.RunnableC12034a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ComposerSaveModel {
    private static final String KEY_AUTO_SAVE_OPTION = "key_auto_save_option";
    private static final String TAG = Logger.createTag("ComposerSaveModel");
    private DocContract mDocContract;
    private SubData mSubData;
    private SchedulerDataSource.WorkingState mWorkingState;
    private Boolean mIsAutoSaveOptionEnabled = null;
    private boolean mIsHyperLinkChanged = false;
    private boolean mIsEditable = true;
    private boolean mIsBlockedSave = false;
    private boolean mIsDiscard = false;
    private boolean mIsAllPageDeleted = false;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface SubData {
        boolean isDataChanged();

        boolean isEmpty();

        void release();

        void saveCache();
    }

    private void applySaveCacheStrategy(NotesDocument<SpenWordDocument> notesDocument, int i) {
        if (i != 0) {
            notesDocument.getDocumentRepository().setSaveStrategy(i);
            return;
        }
        notesDocument.getDocumentRepository().removeSaveStrategy(2048);
        notesDocument.getDocumentRepository().removeSaveStrategy(1024);
        setHyperLinkChanged(false);
    }

    private void applySaveStrategy(NotesDocument<SpenWordDocument> notesDocument, int i, boolean z) {
        if (i != 0) {
            notesDocument.getDocumentRepository().setSaveStrategy(i);
            return;
        }
        notesDocument.getDocumentRepository().addSaveStrategy(2048);
        notesDocument.getDocumentRepository().removeSaveStrategy(1024);
        notesDocument.getDocumentRepository().removeSaveStrategy(4096);
        if (z && notesDocument.getDocumentRepository().isNewDocument()) {
            notesDocument.getDocumentRepository().addSaveStrategy(8);
        }
        setHyperLinkChanged(false);
    }

    private boolean hasChangesToSave(NotesDocument<SpenWordDocument> notesDocument) {
        return isChangedDocState(notesDocument) || hasSnapSavedData(notesDocument);
    }

    private boolean isEmptySubData() {
        SubData subData = this.mSubData;
        return subData == null || subData.isEmpty();
    }

    private boolean isNotAvailableToSave(NotesDocument<SpenWordDocument> notesDocument, String str) {
        if (notesDocument == null) {
            Logger.m11000e(TAG, str + " docState is null");
            return true;
        }
        if (!this.mIsEditable) {
            Logger.m11003i(TAG, str + " not editable note can't save");
            return true;
        }
        if (this.mIsBlockedSave || this.mIsDiscard) {
            Logger.m11003i(TAG, str + " blocking by conflict or mIsDiscard");
            return true;
        }
        if (isIdleWorkingState() && (!isSavingState() || hasChangesToSave(notesDocument))) {
            return false;
        }
        String str2 = TAG;
        StringBuilder sbM781w = AbstractC0541b.m781w(str, " fail # mWorkingState ");
        sbM781w.append(this.mWorkingState);
        sbM781w.append(" / ");
        sbM781w.append(isSavingState());
        Logger.m11000e(str2, sbM781w.toString());
        return true;
    }

    private boolean isNotAvailableToSaveCache(NotesDocument<SpenWordDocument> notesDocument, boolean z, boolean z2) {
        String str = z2 ? "snapSave#" : "saveCache#";
        if (!this.mIsEditable) {
            Logger.m11003i(TAG, str.concat(" not editable note can't save"));
            return true;
        }
        if (this.mIsBlockedSave || this.mIsDiscard) {
            Logger.m11003i(TAG, str.concat(" blocking by conflict or mIsDiscard"));
            return true;
        }
        if (!isIdleWorkingState() || isSavingState()) {
            String str2 = TAG;
            StringBuilder sbM781w = AbstractC0541b.m781w(str, " fail # mWorkingState ");
            sbM781w.append(this.mWorkingState);
            sbM781w.append(" / ");
            sbM781w.append(isSavingState());
            Logger.m11000e(str2, sbM781w.toString());
            return true;
        }
        if (isEmpty(notesDocument) && isEmptySubData()) {
            if (!this.mIsAllPageDeleted) {
                Logger.m11003i(TAG, str.concat(" empty"));
                return true;
            }
            this.mIsAllPageDeleted = false;
            Logger.m11003i(TAG, str.concat(" empty because all of pages were deleted"));
        }
        if (z && hasSnapSavedData(notesDocument)) {
            Logger.m11003i(TAG, str.concat(" checkHasSnapSave"));
            return false;
        }
        if (isChangedRealContent(notesDocument)) {
            Logger.m11003i(TAG, str.concat(" isChangedRealContent = true"));
            return false;
        }
        if (!z2 && notesDocument.isEntityChanged()) {
            Logger.m11003i(TAG, str.concat(" docState.isEntityChanged = true"));
            return false;
        }
        if (z2 || !(notesDocument.isTagChanged() || notesDocument.isCoverChanged() || notesDocument.isStickyNoteChanged())) {
            Logger.m11003i(TAG, str.concat(" no change"));
            return true;
        }
        Logger.m11003i(TAG, str.concat(" Extra data (tag, cover, sticky) was changed"));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$saveForOnlyHyperLink$0(NotesDocument notesDocument) {
        Context applicationContext = BaseUtils.getApplicationContext();
        if (applicationContext == null) {
            Logger.m11002f(TAG, "saveForOnlyHyperLink, appContext is null");
            return;
        }
        String path = notesDocument.getPath();
        if (TextUtils.isEmpty(path)) {
            Logger.m11002f(TAG, "saveForOnlyHyperLink, path is empty");
            return;
        }
        String path2 = NotesDataRepositoryFactory.newInstance(applicationContext).createDocumentDataRepository().getPath(notesDocument.getUuid());
        if (!path.equals(path2)) {
            String str = TAG;
            Logger.m11002f(str, "saveForOnlyHyperLink, docPath: " + Logger.getEncode(path));
            Logger.m11002f(str, "saveForOnlyHyperLink, dbPath: " + Logger.getEncode(path2));
        }
        File file = new File(path);
        if (!file.exists()) {
            Logger.m11002f(TAG, "saveForOnlyHyperLink, file does not exist before Save");
            return;
        }
        try {
            DocumentFileManager.getInstance().saveAsDirectory((SpenWNote) notesDocument.getDoc(), notesDocument.getPath());
        } catch (Exception unused) {
            Logger.m11000e(TAG, "saveForOnlyHyperLink, save failed#");
        }
        if (file.exists()) {
            return;
        }
        Logger.m11002f(TAG, "saveForOnlyHyperLink, file does not exist after Save");
    }

    public void addSaveListener(DocContract.SavedListener savedListener) {
        this.mDocContract.addSavedListener(savedListener);
    }

    public void cancelSaveToDevice() {
        this.mDocContract.cancelSaveToDevice();
    }

    public void changeDocument(String str, String str2) {
        this.mDocContract.changeDocument(str, str2);
    }

    public void discard(boolean z) {
        Logger.m11003i(TAG, "discard#");
        this.mIsDiscard = z;
        this.mDocContract.requestDiscard();
    }

    public SubData getSubData() {
        return this.mSubData;
    }

    public boolean hasSnapSavedData(NotesDocument<SpenWordDocument> notesDocument) {
        if (notesDocument == null || notesDocument.getDoc() == null) {
            return false;
        }
        return ((SpenWordDocument) notesDocument.getDoc()).hasSnapSavedData();
    }

    public boolean isAutoSaveOptionEnabled() {
        if (this.mIsAutoSaveOptionEnabled == null) {
            this.mIsAutoSaveOptionEnabled = Boolean.valueOf(SharedPreferencesCompat.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_AUTO_SAVE_NOTES, true));
        }
        return this.mIsAutoSaveOptionEnabled.booleanValue();
    }

    public boolean isChangedDocState(NotesDocument<SpenWordDocument> notesDocument) {
        if (notesDocument == null) {
            return false;
        }
        return isChangedRealContent(notesDocument) || notesDocument.isEntityChanged() || notesDocument.isTagChanged() || notesDocument.isCoverChanged() || notesDocument.isStickyNoteChanged();
    }

    public boolean isChangedRealContent(NotesDocument<SpenWordDocument> notesDocument) {
        if (notesDocument == null) {
            return false;
        }
        if (notesDocument.isContentChanged() && !notesDocument.isChangedOnlyThumbnail()) {
            return true;
        }
        SubData subData = this.mSubData;
        return subData != null && subData.isDataChanged();
    }

    public boolean isEmpty(NotesDocument<SpenWordDocument> notesDocument) {
        if (notesDocument == null || notesDocument.getDoc() == null) {
            return true;
        }
        return ((SpenWordDocument) notesDocument.getDoc()).isContentEmpty() && isEmptySubData();
    }

    public boolean isEmptyOnNewNote(NotesDocument<SpenWordDocument> notesDocument) {
        return notesDocument != null && notesDocument.getDocumentRepository().isNewDocument() && isEmpty(notesDocument);
    }

    public boolean isHyperLinkChanged() {
        return this.mIsHyperLinkChanged;
    }

    public boolean isIdleWorkingState() {
        return this.mWorkingState == SchedulerDataSource.WorkingState.IDLE;
    }

    public boolean isReloadingWorkingState() {
        return this.mWorkingState == SchedulerDataSource.WorkingState.RELOADING;
    }

    public boolean isSavingState() {
        return this.mDocContract.isSavingState();
    }

    public boolean isSavingWorkingState() {
        SchedulerDataSource.WorkingState workingState = this.mWorkingState;
        return workingState == SchedulerDataSource.WorkingState.SAVING || workingState == SchedulerDataSource.WorkingState.SAVING_CACHE || workingState == SchedulerDataSource.WorkingState.SNAP_SAVE;
    }

    public void onSaveInstanceState(@NonNull Bundle bundle) {
        bundle.putBoolean(KEY_AUTO_SAVE_OPTION, isAutoSaveOptionEnabled());
    }

    public void restoreState(@NonNull Bundle bundle) {
        this.mIsAutoSaveOptionEnabled = Boolean.valueOf(bundle.getBoolean(KEY_AUTO_SAVE_OPTION, isAutoSaveOptionEnabled()));
    }

    public boolean save(NotesDocument<SpenWordDocument> notesDocument, boolean z, boolean z2, boolean z3, int i, boolean z4) {
        if (isNotAvailableToSave(notesDocument, "save#")) {
            return false;
        }
        if (!z4 && (isEmptyOnNewNote(notesDocument) || !hasChangesToSave(notesDocument))) {
            Logger.m11003i(TAG, "save# empty or no change");
            return false;
        }
        String str = TAG;
        AbstractC8014b.m7195A(AbstractC2821a.m2230u("requestSave# sync=", " autoTitle=", " saveStrategy=", z, z2), str, i);
        applySaveStrategy(notesDocument, i, z2);
        this.mDocContract.requestSave(notesDocument, z, z3);
        Logger.printFileLog(str + "#save :");
        return true;
    }

    public boolean saveCache(NotesDocument<SpenWordDocument> notesDocument, boolean z, int i, boolean z2) {
        if (notesDocument == null) {
            Logger.m11000e(TAG, "saveCache# docState is null");
            return false;
        }
        if (isNotAvailableToSaveCache(notesDocument, z2, false)) {
            return false;
        }
        String str = TAG;
        Logger.m11003i(str, "saveCache# " + z + " saveStrategy=" + i);
        SubData subData = this.mSubData;
        if (subData != null) {
            subData.saveCache();
        }
        applySaveCacheStrategy(notesDocument, i);
        this.mDocContract.requestSaveCache(notesDocument, z, !z);
        Logger.printFileLog(str + "#saveCache :");
        return true;
    }

    public boolean saveCacheForced(NotesDocument<SpenWordDocument> notesDocument, boolean z) {
        if (notesDocument == null) {
            Logger.m11000e(TAG, "saveCacheForced# docState is null");
            return false;
        }
        if (this.mWorkingState != SchedulerDataSource.WorkingState.IDLE) {
            Logger.m11003i(TAG, "saveCacheForced fail # mWorkingState " + this.mWorkingState);
            return false;
        }
        SubData subData = this.mSubData;
        if (subData != null) {
            subData.saveCache();
        }
        notesDocument.setDirty(true);
        this.mDocContract.requestSaveCache(notesDocument, z, !z);
        Logger.printFileLog(TAG + "#saveCacheForced");
        return true;
    }

    public void saveForOnlyHyperLink(NotesDocument<SpenWordDocument> notesDocument) {
        if (isNotAvailableToSave(notesDocument, "saveForOnlyHyperLink#")) {
            return;
        }
        if (isEmpty(notesDocument)) {
            Logger.m11003i(TAG, "saveForOnlyHyperLink# empty or no change");
            return;
        }
        DocumentSchedulerDataSource scheduler = notesDocument.getScheduler();
        if (scheduler == null) {
            return;
        }
        scheduler.getExecutorService().submit(new RunnableC12034a(notesDocument, 0));
        setHyperLinkChanged(false);
        String str = TAG;
        Logger.m11003i(str, "saveForOnlyHyperLink# true");
        Logger.mustAddFileLog(str, "HyperLink");
    }

    public void saveToDevice(ExecuteCallback executeCallback, String str) {
        this.mDocContract.requestSaveToDevice(executeCallback, str);
    }

    public void setAllPageDeleted(boolean z) {
        this.mIsAllPageDeleted = z;
    }

    public void setAutoSaveOptionEnabled(@Nullable Boolean bool) {
        this.mIsAutoSaveOptionEnabled = bool;
    }

    public void setBlockedSave(boolean z) {
        Logger.m11004w(TAG, "setBlockedSave# " + z);
        this.mIsBlockedSave = z;
    }

    public void setContract(DocContract docContract) {
        this.mDocContract = docContract;
    }

    public void setDiscard(boolean z) {
        this.mIsDiscard = z;
    }

    public void setDocServiceWorkingState(SchedulerDataSource.WorkingState workingState) {
        this.mWorkingState = workingState;
    }

    public void setEditable(boolean z) {
        this.mIsEditable = z;
    }

    public void setHyperLinkChanged(boolean z) {
        this.mIsHyperLinkChanged = z;
    }

    public void setNotSave(NotesDocument<SpenWordDocument> notesDocument) {
        ((SpenWordDocument) notesDocument.getDoc()).clearChangedFlag();
        notesDocument.setDirty(false);
        notesDocument.getDocumentRepository().addSaveStrategy(1024);
        notesDocument.getDocumentRepository().removeSaveStrategy(128);
    }

    public void setRunnableAfterCompletedSave(Runnable runnable) {
        this.mDocContract.setRunnableAfterCompletedSave(runnable);
    }

    public void setSubData(SubData subData) {
        this.mSubData = subData;
    }

    public boolean snapSave(NotesDocument<SpenWordDocument> notesDocument, boolean z, int i) {
        if (notesDocument == null) {
            Logger.m11000e(TAG, "snapSave# docState is null");
            return false;
        }
        if (isNotAvailableToSaveCache(notesDocument, false, true)) {
            return false;
        }
        String str = TAG;
        Logger.m11003i(str, "snapSave# " + z + " saveStrategy=" + i);
        SubData subData = this.mSubData;
        if (subData != null) {
            subData.saveCache();
        }
        applySaveCacheStrategy(notesDocument, i);
        this.mDocContract.requestSnapSave(notesDocument, z, !z);
        Logger.printFileLog(str + "#snapSave :");
        return true;
    }
}
