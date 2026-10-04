package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.sdk.pen.document.SpenUnsupportedTypeException;
import com.samsung.android.sdk.pen.document.SpenUnsupportedVersionException;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.sync.IServerNoteInfoListener;
import com.samsung.android.support.senl.p148nt.base.common.sync.ITempServerNoteListener;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSCloudManager;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSyncManager;
import com.samsung.android.support.senl.p148nt.base.common.sync.ServerNoteInfo;
import com.samsung.android.support.senl.p148nt.base.common.sync.TemporalServerNoteInfo;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerState;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.data.NotesDocEntityManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.drawing.common.Constant;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerCacheFileUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerRequestCode;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.compare.logic.CompareManager;
import com.samsung.android.support.senl.p148nt.composer.main.simple.model.NoteInfoArgument;
import com.samsung.android.support.senl.p148nt.data.common.constants.PredefinedCategory;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentCopyUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SyncConflictConfirmDialogPresenter extends AbsDialogFragmentPresenter {
    public static final String ACTION_DELETED_FROM_SERVER = "Finished_Compare_View";
    public static final String DEVICE_NAME_SYNC_CONFLICT = "DeviceNameForSyncConflicted";
    private static final boolean FEATURE_USING_CHANGE_DOC = false;
    public static final String IS_LOCK_NOTE = "isLockNote";
    public static final String TAG = Logger.createTag("SyncConflictConfirmDialogPresenter");
    private final ComposerModel mComposerModel;
    private final DialogContract.IDialogCreator mCreator;
    private final DialogPresenterManagerContract mDialogPresenterManager;
    private DialogContract.IDownloadState mDownloadState;
    private ExecutorService mExecutorService;
    private long mLocalModifiedTime;
    private SpenWNote[] mNotesCompare;
    private final DialogContract.IParent mParent;
    private IServerNoteInfoListener mServerNoteInfoListener;
    private long mServerNoteModifiedTime;
    private File mTempDownloadDir;

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.SyncConflictConfirmDialogPresenter$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C92531 implements IServerNoteInfoListener {
        public C92531() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onReceived$0() {
            if (!CommonUtil.isNotAvailableActivity(SyncConflictConfirmDialogPresenter.this.mActivity)) {
                SyncConflictConfirmDialogPresenter.this.showDialog();
                return;
            }
            Logger.m11004w(SyncConflictConfirmDialogPresenter.TAG, "requestServerNoteInfo # " + SyncConflictConfirmDialogPresenter.this.mActivity);
        }

        @Override // com.samsung.android.support.senl.p148nt.base.common.sync.IServerNoteInfoListener
        public void onFailed(int i) {
            Logger.m11000e(SyncConflictConfirmDialogPresenter.TAG, "onReceived()# onFailed errCode = " + i);
            SyncConflictConfirmDialogPresenter.this.releaseServerNoteInfoListener();
        }

        @Override // com.samsung.android.support.senl.p148nt.base.common.sync.IServerNoteInfoListener
        public void onReceived(@NonNull ServerNoteInfo serverNoteInfo) {
            SyncConflictConfirmDialogPresenter.this.releaseServerNoteInfoListener();
            SyncConflictConfirmDialogPresenter.this.mServerNoteModifiedTime = serverNoteInfo.getModifiedTime();
            SyncConflictConfirmDialogPresenter syncConflictConfirmDialogPresenter = SyncConflictConfirmDialogPresenter.this;
            syncConflictConfirmDialogPresenter.mLocalModifiedTime = syncConflictConfirmDialogPresenter.getNoteLocalTimeForSyncConflicted();
            Logger.m11003i(SyncConflictConfirmDialogPresenter.TAG, "onReceived()# modifiedTime = " + SyncConflictConfirmDialogPresenter.this.mServerNoteModifiedTime + " / " + SyncConflictConfirmDialogPresenter.this.mLocalModifiedTime);
            SyncConflictConfirmDialogPresenter.this.mActivity.runOnUiThread(new RunnableC9258b(this, 0));
        }
    }

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.SyncConflictConfirmDialogPresenter$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class RunnableC92542 implements Runnable {
        final /* synthetic */ String val$newUuid;

        public RunnableC92542(String str) {
            this.val$newUuid = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$0(String str, String str2) {
            SyncConflictConfirmDialogPresenter.this.finish("saveAsNewDocWithCurrentDoc");
            SyncConflictConfirmDialogPresenter.this.mActivity.getIntent().putExtra("sdoc_uuid", str);
            Activity activity = SyncConflictConfirmDialogPresenter.this.mActivity;
            activity.startActivity(activity.getIntent());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$1() {
            SyncConflictConfirmDialogPresenter.this.mDialogPresenterManager.hideProgress(3);
        }

        private void updateAndSaveNewDocument(String str, String str2) {
            NotesDocumentEntity entity = SyncConflictConfirmDialogPresenter.this.mComposerModel.getDocState().getDocumentEntityContainer().getEntity();
            entity.setId(null);
            entity.setUuid(str);
            entity.setFilePath(str2);
            entity.setIsDeleted(0);
            entity.setCategoryUuid(PredefinedCategory.UNCATEGORIZED.getUuid());
            SyncConflictConfirmDialogPresenter.this.mComposerModel.getDocState().getDocumentEntityContainer().setEntity(entity);
            SyncConflictConfirmDialogPresenter.this.mComposerModel.getDocState().getDocumentRepository().setUuid(entity.getUuid());
            SyncConflictConfirmDialogPresenter.this.mComposerModel.getDocState().getDocumentRepository().savePath(entity.getFilePath());
            SyncConflictConfirmDialogPresenter.this.mComposerModel.getDocState().getDocumentEntityContainer().updateOriginalEntityWithLatest();
            SyncConflictConfirmDialogPresenter.this.mComposerModel.getDocState().setDirty(true);
            SyncConflictConfirmDialogPresenter.this.mComposerModel.save(true, false, false, 0, true);
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean zCopyTo;
            try {
                String path = SyncConflictConfirmDialogPresenter.this.mComposerModel.getDocState().getPath();
                String uuid = SyncConflictConfirmDialogPresenter.this.mComposerModel.getDocState().getUuid();
                final String strGenerateUniqueFilePath = FileUtils.generateUniqueFilePath(path);
                if (FileUtils.exists(SyncConflictConfirmDialogPresenter.this.mComposerModel.getDocInfo().getDocPath())) {
                    SyncConflictConfirmDialogPresenter.this.mComposerModel.save(true, false, false, 0, false);
                    SyncConflictConfirmDialogPresenter syncConflictConfirmDialogPresenter = SyncConflictConfirmDialogPresenter.this;
                    zCopyTo = DocumentCopyUtils.copyTo(syncConflictConfirmDialogPresenter.mActivity, syncConflictConfirmDialogPresenter.mComposerModel.getDoc(), uuid, this.val$newUuid, path, strGenerateUniqueFilePath);
                } else {
                    Logger.mustAddFileLog(SyncConflictConfirmDialogPresenter.TAG, "SyncC:keepBoth force save");
                    updateAndSaveNewDocument(this.val$newUuid, strGenerateUniqueFilePath);
                    zCopyTo = true;
                }
                Logger.m11004w(SyncConflictConfirmDialogPresenter.TAG, "saveAsNewDocWithCurrentDoc result : " + zCopyTo);
                if (zCopyTo) {
                    SyncConflictConfirmDialogPresenter.this.mComposerModel.getDoc().clearChangedFlag();
                    SyncConflictConfirmDialogPresenter.this.mComposerModel.getDocState().setDirty(false);
                    SyncConflictConfirmDialogPresenter.this.mComposerModel.getDocState().getDocumentRepository().addSaveStrategy(1024);
                    SyncConflictConfirmDialogPresenter.this.mComposerModel.getDocState().getDocumentRepository().removeSaveStrategy(128);
                    SyncConflictConfirmDialogPresenter.this.mComposerModel.getComposerSaveModel().setBlockedSave(true);
                    SyncConflictConfirmDialogPresenter.this.mComposerModel.updateConflictStrategy(2);
                    Activity activity = SyncConflictConfirmDialogPresenter.this.mActivity;
                    final String str = this.val$newUuid;
                    activity.runOnUiThread(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.c
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f6791a.lambda$run$0(str, strGenerateUniqueFilePath);
                        }
                    });
                    return;
                }
            } catch (Exception e) {
                AbstractC8014b.m7207i("saveAsNewDocWithCurrentDoc error: ", e, SyncConflictConfirmDialogPresenter.TAG);
            }
            SyncConflictConfirmDialogPresenter.this.mActivity.runOnUiThread(new RunnableC9258b(this, 1));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface DialogPresenterManagerContract {
        void hideProgress(int i);

        void showProgress(int i);
    }

    public SyncConflictConfirmDialogPresenter(DialogContract.IParent iParent, DialogContract.IDialogCreator iDialogCreator, ComposerModel composerModel, DialogPresenterManagerContract dialogPresenterManagerContract) {
        this.mParent = iParent;
        this.mCreator = iDialogCreator;
        this.mComposerModel = composerModel;
        this.mDialogPresenterManager = dialogPresenterManagerContract;
    }

    private boolean canUseSync() {
        RequestToSyncManager.Companion companion = RequestToSyncManager.INSTANCE;
        if (!companion.isDataCallNotLimitedForApp()) {
            Logger.m11004w(TAG, "canUseSync# isDataCallNotLimitedForApp is false");
            return false;
        }
        if (companion.isWiFiSyncOnlyAndNotWiFiConnected(this.mActivity)) {
            Logger.m11004w(TAG, "canUseSync# isWiFiSyncOnlyAndNotWiFiConnected is true");
            return false;
        }
        if (!SharedPreferencesCompat.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_SYNC_NOTES, false)) {
            Logger.m11004w(TAG, "canUseSync# SyncEnableMode is false");
            return false;
        }
        if (companion.isAutoSyncPossible()) {
            return true;
        }
        Logger.m11004w(TAG, "canUseSync# AutoSyncPossible is false");
        return false;
    }

    private void clearTempDir() {
        File fileMakeConflictTempDir = ComposerCacheFileUtil.makeConflictTempDir(this.mActivity, this.mComposerModel.getDocInfo().getUuid());
        if (fileMakeConflictTempDir == null || !fileMakeConflictTempDir.exists()) {
            return;
        }
        AbstractC8014b.m7220v("keepCurrent#remove temp note: ", TAG, fileMakeConflictTempDir.delete());
    }

    private void closeCompareView() {
        Intent intent = new Intent();
        intent.setAction(ACTION_DELETED_FROM_SERVER);
        this.mActivity.sendBroadcast(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$replace$0() {
        Activity activity = this.mActivity;
        ToastHandler.show(activity, activity.getString(C9086R.string.composer_sync_delete_note), 1);
        finish("removed in DB");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseServerNoteInfoListener() {
        if (this.mServerNoteInfoListener != null) {
            this.mServerNoteInfoListener = null;
            RequestToSyncManager.INSTANCE.requestServerNoteInfo(this.mComposerModel.getDocInfo().getUuid(), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestCreateMergeNote() {
        File fileMakeMergeTempDir = ComposerCacheFileUtil.makeMergeTempDir(BaseUtils.getApplicationContext(), this.mComposerModel.getDocInfo().getUuid());
        if (fileMakeMergeTempDir == null) {
            return;
        }
        createNoteMerge(fileMakeMergeTempDir.getAbsolutePath());
    }

    private void requestServerNoteInfo() {
        this.mServerNoteInfoListener = new C92531();
        RequestToSyncManager.INSTANCE.requestServerNoteInfo(this.mComposerModel.getDocInfo().getUuid(), this.mServerNoteInfoListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog() {
        DialogFragment dialogFragmentCreateConfirmSyncConflictDialogFragment = this.mCreator.createConfirmSyncConflictDialogFragment();
        FragmentManager childFragmentManager = ((AppCompatActivity) this.mActivity).getSupportFragmentManager().getFragments().get(0).getChildFragmentManager();
        childFragmentManager.beginTransaction().add(dialogFragmentCreateConfirmSyncConflictDialogFragment, TAG).commitAllowingStateLoss();
        childFragmentManager.executePendingTransactions();
    }

    private void startCompareViewer(String str, String str2) {
        Intent intent = new Intent();
        intent.setClassName(this.mActivity, ComposerConstants.COMPARE_VIEWER_ACTIVITY);
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        arrayList.add(new NoteInfoArgument(this.mComposerModel.getDocInfo().getUuid(), str, true, false));
        arrayList.add(new NoteInfoArgument(this.mComposerModel.getDocInfo().getUuid(), this.mComposerModel.getDocState().getPath(), false, false));
        arrayList.add(new NoteInfoArgument(this.mComposerModel.getDocInfo().getUuid(), str2, true, false));
        intent.putParcelableArrayListExtra(NoteInfoArgument.KEY_BUNDLE, arrayList);
        intent.putExtra(DEVICE_NAME_SYNC_CONFLICT, this.mComposerModel.getDeviceNameForSyncConflicted());
        intent.putExtra(IS_LOCK_NOTE, this.mComposerModel.getNotesDocEntityManager().isLocked());
        ComposerState composerState = this.mComposerModel.getComposerState();
        ComposerRequestCode composerRequestCode = ComposerRequestCode.CompareConflict;
        composerState.setLastRequestCode(composerRequestCode.getId());
        this.mActivity.startActivityForResult(intent, composerRequestCode.getId());
    }

    public void closeCompareViewAndFinish() {
        if (this.mComposerModel.getComposerState().getLastRequestCode() == ComposerRequestCode.CompareConflict.getId()) {
            Logger.m10999d(TAG, "hide compare view");
            closeCompareView();
        } else {
            Logger.m10999d(TAG, "hide dialog");
            hideDialog();
        }
        clearTempDir();
        ToastHandler.show(this.mActivity, this.mActivity.getResources().getString(C9086R.string.note_already_deleted), 1);
    }

    public void compare() {
        Logger.m10999d(TAG, "compare# ");
        File fileMakeMergeTempDir = ComposerCacheFileUtil.makeMergeTempDir(this.mActivity, this.mComposerModel.getDocInfo().getUuid());
        File file = this.mTempDownloadDir;
        if (file == null || fileMakeMergeTempDir == null) {
            return;
        }
        startCompareViewer(file.getAbsolutePath(), fileMakeMergeTempDir.getAbsolutePath());
    }

    public void compareObject(String str) {
        try {
            SpenWNote[] spenWNoteArr = new SpenWNote[2];
            this.mNotesCompare = spenWNoteArr;
            spenWNoteArr[0] = new SpenWNote(BaseUtils.getApplicationContext(), str, null);
            this.mNotesCompare[1] = new SpenWNote(BaseUtils.getApplicationContext(), this.mComposerModel.getDocInfo().getDocPath(), null);
            CompareManager.Companion companion = CompareManager.INSTANCE;
            companion.getInstance().release();
            companion.getInstance().setNoteToCompare(this.mNotesCompare);
        } catch (SpenUnsupportedTypeException | SpenUnsupportedVersionException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void createNoteMerge(String str) {
        try {
            this.mNotesCompare[0].saveAsDirectory(str);
            SpenWNote spenWNote = new SpenWNote(BaseUtils.getApplicationContext(), str, null);
            this.mNotesCompare = null;
            CompareManager.INSTANCE.getInstance().setNoteMerge(spenWNote, str);
        } catch (SpenUnsupportedTypeException | SpenUnsupportedVersionException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.AbsDialogFragmentPresenter
    public DialogFragment findFragmentByTag(Activity activity) {
        return findFragmentByTag(activity, TAG);
    }

    public void finish(String str) {
        this.mParent.finish(str);
    }

    public String getDeviceNameForSyncConflicted() {
        return this.mComposerModel.getDeviceNameForSyncConflicted();
    }

    public long getNoteLocalTimeForSyncConflicted() {
        return this.mComposerModel.getNotesDocEntityManager().getLastModifiedTime();
    }

    public long getServerNoteModifiedTime() {
        return this.mServerNoteModifiedTime;
    }

    public String getUuidForSyncConflicted() {
        return this.mComposerModel.getDocInfo().getUuid();
    }

    public void hideDialog() {
        DialogFragment dialogFragmentFindFragmentByTag = findFragmentByTag(this.mActivity);
        if (dialogFragmentFindFragmentByTag != null) {
            dialogFragmentFindFragmentByTag.dismissNow();
        }
    }

    public boolean isShowing() {
        return findFragmentByTag(this.mActivity) != null;
    }

    public void keepCurrent() {
        String str = TAG;
        Logger.mustAddFileLog(str, "SyncC:keepCur");
        this.mComposerModel.updateConflictStrategy(3);
        if (!FileUtils.exists(this.mComposerModel.getDocInfo().getDocPath())) {
            Logger.mustAddFileLog(str, "SyncC:keepCur force save");
            this.mComposerModel.getDocState().setDirty(true);
            this.mComposerModel.save(true, false, true, 0, true);
            this.mComposerModel.getNotesDocEntityManager().restore();
        }
        clearTempDir();
    }

    public void keepMerge() {
        Logger.mustAddFileLog(TAG, "SyncC:merge");
        try {
            SpenWNote doc = this.mComposerModel.getDoc();
            if (doc != null) {
                this.mDialogPresenterManager.showProgress(4);
                CompareManager.INSTANCE.getInstance().keepMerge(doc);
                keepCurrent();
                this.mDialogPresenterManager.hideProgress(4);
                this.mComposerModel.save(true, true);
            }
        } catch (Exception e) {
            Logger.m11001e(TAG, "keepMerge error: ", e);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.AbsDialogFragmentPresenter
    public void onDetachView() {
        releaseServerNoteInfoListener();
        super.onDetachView();
    }

    public void replace(boolean z) {
        String str = TAG;
        Logger.mustAddFileLog(str, "SyncC:replace");
        if (FileUtils.exists(this.mComposerModel.getDocInfo().getDocPath())) {
            if (z) {
                this.mDialogPresenterManager.showProgress(4);
            }
            this.mComposerModel.updateConflictStrategy(1);
        } else {
            Logger.m11004w(str, "sdocx was deleted");
            Activity activity = this.mActivity;
            if (activity != null) {
                ToastHandler.show(activity, activity.getString(C9086R.string.composer_sync_delete_note), 1);
                finish(Constant.DRAWING_TOOLKIT_KEY_RETURN_TYPE_REPLACE);
                return;
            }
        }
        this.mComposerModel.getVoiceModel().stopRecording();
        this.mComposerModel.getVoiceModel().stopPlaying();
        this.mComposerModel.setUpToFinishWithoutSave();
        this.mComposerModel.getNotesDocEntityManager().setOnRemovedListener(new NotesDocEntityManager.OnRemovedListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.a
            @Override // com.samsung.android.support.senl.nt.composer.main.base.model.data.NotesDocEntityManager.OnRemovedListener
            public final void onRemoved() {
                this.f6788a.lambda$replace$0();
            }
        });
    }

    public void requestDownloadServerNote() {
        if (!RequestToSCloudManager.INSTANCE.getInstance().isDataNetworkAvailable()) {
            this.mDownloadState.onFail(C9086R.string.network_error_check_your_network_connection_and_try_again);
            return;
        }
        this.mTempDownloadDir = ComposerCacheFileUtil.makeConflictTempDir(this.mActivity, this.mComposerModel.getDocInfo().getUuid());
        TemporalServerNoteInfo temporalServerNoteInfo = new TemporalServerNoteInfo();
        temporalServerNoteInfo.setFullFolderPath(this.mTempDownloadDir.getAbsolutePath());
        temporalServerNoteInfo.setDocUuid(this.mComposerModel.getDocInfo().getUuid());
        temporalServerNoteInfo.setTempServerNoteListener(new ITempServerNoteListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.SyncConflictConfirmDialogPresenter.3
            private /* synthetic */ void lambda$onReceived$0() {
                SyncConflictConfirmDialogPresenter.this.requestCreateMergeNote();
            }

            @Override // com.samsung.android.support.senl.p148nt.base.common.sync.ITempServerNoteListener
            public void onFailed(int i) {
                AbstractC0000a.m3D(i, "requestDownloadServerNote#onFailed# ", SyncConflictConfirmDialogPresenter.TAG);
                SyncConflictConfirmDialogPresenter.this.mDownloadState.onFail(C9086R.string.composer_save_to_device_fail);
            }

            @Override // com.samsung.android.support.senl.p148nt.base.common.sync.ITempServerNoteListener
            public void onReceived() {
                Logger.m10999d(SyncConflictConfirmDialogPresenter.TAG, "requestDownloadServerNote#onReceived#");
                SyncConflictConfirmDialogPresenter.this.mDownloadState.onSuccess();
            }
        });
        RequestToSyncManager.INSTANCE.getInstance().requestSyncDownForServerNoteTemporarily(temporalServerNoteInfo);
    }

    public void saveAsNewDocWithCurrentDoc() {
        String str = TAG;
        Logger.mustAddFileLog(str, "SyncC:keepBoth");
        this.mDialogPresenterManager.showProgress(3);
        this.mComposerModel.getVoiceModel().stopRecording();
        this.mComposerModel.getVoiceModel().stopPlaying();
        String strNewUUIDFromSourceUUID = UUIDUtils.newUUIDFromSourceUUID(this.mActivity, this.mComposerModel.getDocState().getUuid());
        ExecutorService executorServiceM3201k = AbstractC4539a.m3201k(str);
        this.mExecutorService = executorServiceM3201k;
        executorServiceM3201k.execute(new RunnableC92542(strNewUUIDFromSourceUUID));
    }

    public void setmDownloadState(DialogContract.IDownloadState iDownloadState) {
        this.mDownloadState = iDownloadState;
    }

    public void show() {
        if (CommonUtil.isNotAvailableActivity(this.mActivity)) {
            Logger.m11004w(TAG, "show# " + this.mActivity);
            return;
        }
        if (!canUseSync()) {
            Logger.m11004w(TAG, "show# canUseSync is false");
        } else if (isShowing()) {
            Logger.m11004w(TAG, "show# dialog is already showing");
        } else {
            requestServerNoteInfo();
            Logger.m11003i(TAG, "show#");
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.AbsDialogFragmentPresenter
    public DialogFragment findFragmentByTag(Activity activity, String str) {
        Activity activity2 = this.mActivity;
        if (activity2 == null) {
            return null;
        }
        return (DialogFragment) ((AppCompatActivity) activity2).getSupportFragmentManager().getFragments().get(0).getChildFragmentManager().findFragmentByTag(str);
    }
}
