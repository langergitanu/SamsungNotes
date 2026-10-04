package com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.helper;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.notes.widget.AppWidgetUtils;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.FeatureUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.ViewModeUtils;
import com.samsung.android.support.senl.p148nt.app.lock.LockManager;
import com.samsung.android.support.senl.p148nt.app.lock.helper.AbsLockHelper;
import com.samsung.android.support.senl.p148nt.app.lock.presenter.convert.WrappedLockFileController;
import com.samsung.android.support.senl.p148nt.app.lock.presenter.task.LockTask;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolder;
import com.samsung.android.support.senl.p148nt.app.main.common.data.DataManager;
import com.samsung.android.support.senl.p148nt.app.main.common.data.HighlightText;
import com.samsung.android.support.senl.p148nt.app.main.common.data.MainEntryParam;
import com.samsung.android.support.senl.p148nt.app.main.common.view.NotesPenRecyclerView;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.NotesHolder;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holderinfo.NotesHolderInfo;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.Common;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.DocumentMap;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.NotesModel;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.StateInfo;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.checkdata.CheckedNoteInfo;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.params.ViewParams;
import com.samsung.android.support.senl.p148nt.app.nativecomposer.ComposerActivity;
import com.samsung.android.support.senl.p148nt.base.common.access.lock.ILockManagerListener;
import com.samsung.android.support.senl.p148nt.base.common.constants.LockConstants;
import com.samsung.android.support.senl.p148nt.base.common.util.LockUtils;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionHelper;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHelper;
import com.samsung.android.support.senl.p148nt.base.winset.util.DialogUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.model.converter.ConvertTaskManager;
import com.samsung.android.support.senl.p148nt.model.converter.task.ConvertTaskFactory;
import com.samsung.android.support.senl.p148nt.model.converter.task.common.ConvertInfo;
import com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertInfo;
import com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertResult;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class LockHelper extends AbsLockHelper {
    private final DocumentMap mDocumentMap;
    private final IPresenter mIPresenter;
    private final NotesModel mNotesModel;
    private final StateInfo mStateInfo;
    private final ViewParams mViewParams;
    private static final String TAG = "LockHelper";
    private static final Executor SINGLE_THREAD_EXECUTOR = AbstractC4539a.m3201k(TAG);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IPresenter {
        void deleteAllConvertedNotes();

        void deleteItems();

        void deleteSelectedConvertedNotes(List<String> list);

        void dismissDeleteDialog();

        void moveToSecureFolder(int i);

        void onActivityResultAfterVerify(int i, int i2, @Nullable Intent intent);

        void onNoteSelectedWidget(MainEntryParam mainEntryParam);

        void onTaskFinished();

        void requestImportToSpace(String str, List<String> list, boolean z);

        void requestStartConvertOldNotes(List<String> list, Intent intent);

        void startCoedit(boolean z);
    }

    public LockHelper(ViewParams viewParams, NotesModel notesModel, DocumentMap documentMap, StateInfo stateInfo, IPresenter iPresenter) {
        this.mViewParams = viewParams;
        this.mNotesModel = notesModel;
        this.mDocumentMap = documentMap;
        this.mStateInfo = stateInfo;
        this.mIPresenter = iPresenter;
        setLockManager(new LockManager(new ILockManagerListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.LockHelper.1
            private void requestImport(String str, boolean z, List<String> list) {
                FragmentActivity activity = LockHelper.this.mViewParams.getAbsFragment().getActivity();
                if (activity == null) {
                    return;
                }
                LockHelper.this.mIPresenter.requestImportToSpace(str, list, z);
                int modeIndex = LockHelper.this.mViewParams.getModeIndex();
                if (FeatureUtils.isPickMode(modeIndex) || (FeatureUtils.isSearchMode(modeIndex) && FeatureUtils.isPickMode(LockHelper.this.mStateInfo.getSearchCallerMode()))) {
                    activity.finish();
                }
            }

            @Override // com.samsung.android.support.senl.p148nt.base.common.access.lock.ILockManagerListener
            public void onCreatePasswordFail(int i, int i2, Intent intent) {
            }

            @Override // com.samsung.android.support.senl.p148nt.base.common.access.lock.ILockManagerListener
            public void onCreatePasswordSuccess(int i, Intent intent) {
            }

            @Override // com.samsung.android.support.senl.p148nt.base.common.access.lock.ILockManagerListener
            public void onLockFail(int i, int i2, String... strArr) {
                MainLogger.m7255e(LockHelper.TAG, "onLockFail# requestCode " + i + " failCode " + i2);
                if (i2 == 8) {
                    PermissionHelper.requestPermissions(LockHelper.this.mViewParams.getAbsFragment(), 125, "android.permission.GET_ACCOUNTS");
                    return;
                }
                if (i2 == 10) {
                    ToastHelper.show(LockHelper.this.mViewParams.getContext(), "tried to lock deleted notes", 0, false);
                }
                LockHelper.this.mIPresenter.onTaskFinished();
            }

            @Override // com.samsung.android.support.senl.p148nt.base.common.access.lock.ILockManagerListener
            public void onLockSuccess(int i, String... strArr) {
                AbstractC6670b.m4736A(i, "onLockSuccess# requestCode : ", LockHelper.TAG);
                if (i == 109) {
                    LockHelper.this.mIPresenter.onTaskFinished();
                }
            }

            @Override // com.samsung.android.support.senl.p148nt.base.common.access.lock.ILockManagerListener
            public void onUnlockFail(int i, int i2, String... strArr) {
                MainLogger.m7255e(LockHelper.TAG, "onUnlockFail# requestCode " + i + " failCode " + i2);
                if (i2 == 8) {
                    PermissionHelper.requestPermissions(LockHelper.this.mViewParams.getAbsFragment(), 125, "android.permission.GET_ACCOUNTS");
                } else {
                    LockHelper.this.mIPresenter.onTaskFinished();
                }
            }

            @Override // com.samsung.android.support.senl.p148nt.base.common.access.lock.ILockManagerListener
            public void onUnlockSuccess(int i, Intent intent, String... strArr) {
                AbstractC6670b.m4736A(i, "onUnlockSuccess# requestCode : ", LockHelper.TAG);
                if (i == 105) {
                    LockHelper.this.mIPresenter.onTaskFinished();
                    return;
                }
                if (i == 106) {
                    LockHelper.this.mIPresenter.moveToSecureFolder(0);
                } else {
                    if (i != 108) {
                        return;
                    }
                    LockHelper.this.mIPresenter.onNoteSelectedWidget(new MainEntryParam.Builder().setUuid(intent.getStringExtra("sdoc_uuid")).setFolderUuid(intent.getStringExtra("category_id")).setFilePath(intent.getStringExtra("doc_path")).setGuid(intent.getStringExtra(ComposerConstants.ARG_LOCK_ACCOUNT_GUID)).build());
                }
            }

            @Override // com.samsung.android.support.senl.p148nt.base.common.access.lock.ILockManagerListener
            public void onVerifyFail(int i, int i2, String... strArr) {
                MainLogger.m7255e(LockHelper.TAG, "onVerifyFail# requestCode " + i + " failCode " + i2);
                if (i2 == 8) {
                    PermissionHelper.requestPermissions(LockHelper.this.mViewParams.getAbsFragment(), 125, "android.permission.GET_ACCOUNTS");
                    return;
                }
                if (i == 107) {
                    LockHelper.this.mIPresenter.dismissDeleteDialog();
                } else if (i == 112) {
                    return;
                }
                LockHelper.this.mIPresenter.onTaskFinished();
            }

            @Override // com.samsung.android.support.senl.p148nt.base.common.access.lock.ILockManagerListener
            public void onVerifySuccess(int i, @Nullable Intent intent, String... strArr) {
                AbstractC8014b.m7201c(i, "onVerifySuccess# requestCode : ", LockHelper.TAG);
                if (intent == null) {
                    MainLogger.m7258i(LockHelper.TAG, "onVerifySuccess# data null");
                }
                if (i == 107) {
                    LockHelper.this.mIPresenter.deleteItems();
                    return;
                }
                if (i != 901) {
                    if (i == 118) {
                        LockHelper.this.mIPresenter.deleteAllConvertedNotes();
                        return;
                    }
                    if (i == 119) {
                        LockHelper.this.mIPresenter.deleteSelectedConvertedNotes(new ArrayList(Arrays.asList(strArr)));
                        return;
                    }
                    switch (i) {
                        case 100:
                        case 104:
                            break;
                        case 101:
                            FragmentActivity activity = LockHelper.this.mViewParams.getAbsFragment().getActivity();
                            if (activity == null || intent == null) {
                                return;
                            }
                            intent.setClass(activity, ComposerActivity.class);
                            intent.putExtra(LockConstants.KEY_LOCK_CONFIRM_RESULT, intent.getStringExtra(LockConstants.KEY_LOCK_CONFIRM_RESULT));
                            intent.setFlags(ComposerConstants.ACTIVITY_FLAG_CALLEE);
                            intent.addFlags(1);
                            activity.startActivity(intent);
                            activity.finish();
                            return;
                        case 102:
                            if (intent == null) {
                                return;
                            }
                            LockHelper.this.replaceRequestListForExport(intent, NotesConstants.KEY_SHARE_LIST, strArr);
                            LockHelper.this.mIPresenter.onActivityResultAfterVerify(i, -1, intent);
                            return;
                        case 103:
                            if (intent == null) {
                                return;
                            }
                            LockHelper.this.replaceRequestListForExport(intent, NotesConstants.KEY_SAVE_LIST, strArr);
                            LockHelper.this.mIPresenter.onActivityResultAfterVerify(i, -1, intent);
                            return;
                        default:
                            switch (i) {
                                case 110:
                                    if (intent != null) {
                                        String stringExtra = intent.getStringExtra("sdoc_uuid");
                                        MainListDocumentData noteData = LockHelper.this.mDocumentMap.getNoteData(stringExtra);
                                        if (noteData != null) {
                                            int isLock = noteData.getIsLock();
                                            if (isLock == 2 || isLock == 3 || isLock == 4) {
                                                LockHelper.this.startConvert(noteData, intent.getStringExtra(LockManager.EXTRA_KEY_LEGACY_PASSWORD), intent.getBooleanExtra(LockManager.EXTRA_KEY_LEGACY_LOCK_AFTER_CONVERT, false));
                                            }
                                        } else {
                                            AbstractC0000a.m25v("onVerifySuccess# noteData : null, noteUuid : ", stringExtra, LockHelper.TAG);
                                        }
                                        break;
                                    }
                                    break;
                                case 111:
                                    if (intent != null) {
                                        LockHelper.this.mIPresenter.requestStartConvertOldNotes(new ArrayList(Arrays.asList(strArr)), intent);
                                        break;
                                    }
                                    break;
                                case 112:
                                    LockHelper.this.mViewParams.getAbsFragment().onFolderDeleteVerifySuccess();
                                    break;
                                case 114:
                                    if (intent != null) {
                                        requestImport(intent.getStringExtra("spaceId"), false, Arrays.asList(strArr));
                                        break;
                                    }
                                    break;
                                case 115:
                                    if (intent != null) {
                                        requestImport(intent.getStringExtra("spaceId"), true, Arrays.asList(strArr));
                                        break;
                                    }
                                    break;
                                case 116:
                                    if (intent != null) {
                                        LockHelper.this.mIPresenter.startCoedit(intent.getBooleanExtra(NotesConstants.KEY_COEDIT_STANDALONE, true));
                                        break;
                                    }
                                    break;
                            }
                            return;
                    }
                }
                LockHelper.this.mIPresenter.onActivityResultAfterVerify(i, -1, intent);
            }
        }));
    }

    private boolean isPermissionGranted() {
        return PermissionHelper.isPermissionGranted(this.mViewParams.getAbsFragment().getActivity(), new RunnableC8496b(this, 4), "android.permission.GET_ACCOUNTS");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$isPermissionGranted$0() {
        MainLogger.m7254d(TAG, "to get GET_ACCOUNTS || READ_PHONE_STATE permission");
        PermissionHelper.requestPermissions(this.mViewParams.getAbsFragment(), 125, "android.permission.GET_ACCOUNTS");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setConvertingItem$1(boolean z, boolean z2, String str) {
        MainLogger.m7254d(TAG, "setConvertingItem() - isLocked : " + z + ", isConverting : " + z2);
        this.mNotesModel.setUnlockConvertingState(str, z2);
        onConvertItemChecked(str, z, z2);
        if (z2) {
            return;
        }
        MainLogger.m7254d(TAG, "setConvertingItem() - remove");
        this.mNotesModel.removeUnlockConvertingState(str);
    }

    private void lockNotes() {
        Context context = this.mViewParams.getContext();
        ArrayList arrayList = new ArrayList();
        List<String> widgetUuidList = AppWidgetUtils.getWidgetUuidList(context);
        boolean z = false;
        for (Map.Entry<String, CheckedNoteInfo> entry : this.mNotesModel.getCheckedNotesEntrySet()) {
            if (widgetUuidList.contains(entry.getKey())) {
                z = true;
            } else if (!entry.getValue().isLock()) {
                arrayList.add(entry.getKey());
            }
        }
        if (arrayList.isEmpty()) {
            if (z) {
                DialogUtils.showWidgetNoteWarning(context);
            }
            MainLogger.m7254d(TAG, "lockNotes# No notes selected for lock");
        } else {
            MainLogger.m7254d(TAG, "lockNotes");
            LockManager lockManager = this.mLockManager;
            if (lockManager != null) {
                lockManager.lock(this.mViewParams.getAbsFragment().getActivity(), 109, (String[]) arrayList.toArray(new String[0]));
            }
        }
    }

    private void onConvertItemChecked(String str, boolean z, boolean z2) {
        CommonHolder commonHolder;
        NotesPenRecyclerView notesRecyclerView = this.mViewParams.getNotesRecyclerView();
        if (notesRecyclerView == null) {
            return;
        }
        int i = 0;
        while (i < notesRecyclerView.getChildCount()) {
            View childAt = notesRecyclerView.getChildAt(i);
            if (childAt != null && (commonHolder = (CommonHolder) notesRecyclerView.getChildViewHolder(childAt)) != null && commonHolder.getMHolderType() == 2048) {
                NotesHolder notesHolder = (NotesHolder) commonHolder;
                NotesHolderInfo notesHolderInfo = notesHolder.getNotesHolderInfo();
                if (notesHolderInfo.getUuid() != null && notesHolderInfo.getUuid().equals(str)) {
                    setConvertingItem(notesHolder, notesHolderInfo.getUuid(), str, z, z2);
                    return;
                }
            }
            i++;
            str = str;
            z = z;
            z2 = z2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void replaceRequestListForExport(Intent intent, String str, String... strArr) {
        ArrayList<CheckedNoteInfo> parcelableArrayListExtra = intent.getParcelableArrayListExtra(str);
        if (parcelableArrayListExtra == null) {
            return;
        }
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        for (CheckedNoteInfo checkedNoteInfo : parcelableArrayListExtra) {
            int length = strArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                if (strArr[i].equals(checkedNoteInfo.getUuid())) {
                    arrayList.add(checkedNoteInfo);
                    break;
                }
                i++;
            }
        }
        intent.putParcelableArrayListExtra(str, arrayList);
        MainLogger.m7254d(TAG, "replaceRequestListForExport# requestExportList : " + parcelableArrayListExtra.size() + ", successList : " + arrayList.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setConvertingItem(String str, boolean z, boolean z2) {
        ViewModeUtils.runOnUiThread(this.mViewParams.getAbsFragment().getActivity(), new RunnableC8501g(this, str, z, z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startConvert(MainListDocumentData mainListDocumentData, String str, final boolean z) {
        final FragmentActivity activity = this.mViewParams.getAbsFragment().getActivity();
        if (mainListDocumentData == null || activity == null) {
            MainLogger.m7254d(TAG, "startConvert# entry or activity : null");
            return;
        }
        final WrappedLockFileController wrappedLockFileController = new WrappedLockFileController(this.mViewParams.getContext(), mainListDocumentData.getFilePath());
        final String uuid = mainListDocumentData.getUuid();
        final boolean zIsSDoc = mainListDocumentData.isSDoc();
        ConvertTaskManager.connect(activity.getApplicationContext());
        ConvertTaskManager.getInstance().put(ConvertTaskFactory.createTaskWithoutValidCheck(activity, new ConvertInfo(wrappedLockFileController.getFilePath(), activity.hashCode()).setUuid(uuid).setIsAuthenticated(!zIsSDoc && z), str, null, new ConvertTaskFactory.IConvertTaskFactoryCallback() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.LockHelper.2
            private void releaseWrappedLockFileController() {
                wrappedLockFileController.release();
            }

            @Override // com.samsung.android.support.senl.nt.model.converter.task.ConvertTaskFactory.IConvertTaskFactoryCallback
            public void onCreated() {
                MainLogger.m7254d(LockHelper.TAG, "ConvertTask# onCreated");
                LockHelper.this.setConvertingItem(uuid, true, true);
            }

            @Override // com.samsung.android.support.senl.p148nt.model.converter.task.IConvertTaskCallback
            public void onFailed(IConvertInfo iConvertInfo, IConvertResult iConvertResult) {
                MainLogger.m7255e(LockHelper.TAG, "ConvertTask## onFailed");
                LockHelper.this.setConvertingItem(uuid, true, false);
                ConvertTaskManager.disconnect();
                if (iConvertResult.getState() == 6) {
                    DialogUtils.showNotEnoughStorageDialogFragment(LockHelper.this.mViewParams.getContext(), LockHelper.this.mViewParams.getAbsFragment().getChildFragmentManager());
                }
                releaseWrappedLockFileController();
            }

            @Override // com.samsung.android.support.senl.nt.model.converter.task.ConvertTaskFactory.IConvertTaskFactoryCallback
            public void onPreFailed(ConvertTaskFactory.IConvertTaskFactoryCallback.ErrorMsg errorMsg) {
                MainLogger.m7255e(LockHelper.TAG, "ConvertTask# onPreFailed");
                LockHelper.this.setConvertingItem(uuid, true, false);
                ConvertTaskManager.disconnect();
                releaseWrappedLockFileController();
            }

            @Override // com.samsung.android.support.senl.p148nt.model.converter.task.IConvertTaskCallback
            public void onSuccess(IConvertInfo iConvertInfo, IConvertResult iConvertResult) {
                if (iConvertResult.getDstType() == 9) {
                    MainLogger.m7254d(LockHelper.TAG, "ConvertTask# onSuccess");
                    LockHelper lockHelper = LockHelper.this;
                    String str2 = uuid;
                    lockHelper.setConvertingItem(str2, NotesUtils.isLockedNotes(new String[]{str2}) == 5, false);
                    ConvertTaskManager.disconnect();
                    if (!zIsSDoc || !z) {
                        releaseWrappedLockFileController();
                        return;
                    }
                    String uuid2 = iConvertResult.getUuid();
                    MainListDocumentData documentData = DataManager.getInstance().getDocumentData(uuid2);
                    if (documentData != null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(new LockTask.DocumentInfo(uuid2, documentData.isSDoc()));
                        new LockTask(activity, true, false, null).executeOnExecutor(LockHelper.SINGLE_THREAD_EXECUTOR, arrayList);
                    }
                    releaseWrappedLockFileController();
                }
            }
        }));
    }

    private void unlockNotes(Intent intent) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, CheckedNoteInfo> entry : this.mNotesModel.getCheckedNotesEntrySet()) {
            if (entry.getValue().isLock()) {
                arrayList.add(entry.getKey());
            }
        }
        if (arrayList.isEmpty()) {
            MainLogger.m7254d(TAG, "unlockNotes# No notes selected for unlock");
        } else {
            MainLogger.m7254d(TAG, "unlockNotes");
            unlockNote(105, intent, (String[]) arrayList.toArray(new String[0]));
        }
    }

    public boolean onActivityResultFromLockManager(int i, int i2, Intent intent) {
        return onActivityResult((AppCompatActivity) this.mViewParams.getAbsFragment().getActivity(), i, i2, intent);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.lock.helper.AbsLockHelper
    public void restoreTask() {
        int i = this.mLatestAction;
        if (i == 2) {
            String[] strArr = this.mLatestUuidList;
            if (strArr != null) {
                verifyLockedNoteForConvert(this.mLatestRequestCode, this.mLatestReturnData, strArr);
                return;
            } else {
                MainLogger.m7254d(TAG, "restoreTask ACTION_VERIFY_LOCKED_NOTE_FOR_CONVERT mLatestUuidList is null");
                return;
            }
        }
        if (i == 3) {
            setLockNotes();
            return;
        }
        if (i == 4) {
            setUnlockNotes();
            return;
        }
        if (i == 5) {
            String[] strArr2 = this.mLatestUuidList;
            if (strArr2 != null) {
                unlockNote(this.mLatestRequestCode, this.mLatestReturnData, strArr2);
                return;
            } else {
                MainLogger.m7254d(TAG, "restoreTask ACTION_UNLOCK_NOTE mLatestUuidList is null");
                return;
            }
        }
        if (i == 6) {
            onActivityResultFromLockManager(this.mLatestRequestCode, this.mLatestResultCode, this.mLatestReturnData);
        } else if (i == 7) {
            unlockForMoveToSecureFolder();
        } else if (i == 8) {
            verifyLockedNoteWithMultiAccount(this.mLatestRequestCode, this.mLatestReturnData, this.mLatestUuidList);
        }
    }

    public void setLockNotes() {
        saveLockHelperTask(3, 0, 0, null, new String[0]);
        if (isPermissionGranted()) {
            for (String str : this.mNotesModel.getCheckedNotesUUID()) {
                if (this.mDocumentMap.getNoteData(str) != null && LockUtils.isUnLockedDocType(this.mDocumentMap.getNoteData(str).getIsLock())) {
                    lockNotes();
                    return;
                }
            }
        }
    }

    public void setUnlockNotes() {
        int isLock;
        saveLockHelperTask(4, 0, 0, null, new String[0]);
        if (isPermissionGranted()) {
            Context context = this.mViewParams.getContext();
            for (String str : this.mNotesModel.getCheckedNotesUUID()) {
                MainListDocumentData noteData = this.mDocumentMap.getNoteData(str);
                if (noteData != null && ((isLock = noteData.getIsLock()) == 5 || LockUtils.isLockedSdocType(isLock))) {
                    Intent intent = new Intent(context, (Class<?>) ComposerActivity.class);
                    intent.putExtra("sdoc_uuid", str);
                    unlockNotes(intent);
                    return;
                }
            }
        }
    }

    public void unlockForMoveToSecureFolder() {
        saveLockHelperTask(7, 0, 0, null, new String[0]);
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, CheckedNoteInfo> entry : this.mNotesModel.getCheckedNotesEntrySet()) {
            if (entry.getValue().isLock()) {
                arrayList.add(entry.getKey());
            }
        }
        if (arrayList.isEmpty()) {
            MainLogger.m7254d(TAG, "unlockForMoveToSecureFolder# No notes selected for unlock");
        } else {
            MainLogger.m7254d(TAG, "unlockForMoveToSecureFolder");
            unlockNote(106, new Intent(), (String[]) arrayList.toArray(new String[0]));
        }
    }

    public void unlockNote(int i, Intent intent, String... strArr) {
        saveLockHelperTask(5, i, 0, intent, strArr);
        LockManager lockManager = this.mLockManager;
        if (lockManager != null) {
            lockManager.unlock(this.mViewParams.getAbsFragment().getActivity(), i, intent, strArr);
        }
    }

    public void verifyForDelete(int i) {
        LockManager lockManager = this.mLockManager;
        if (lockManager != null) {
            lockManager.verifyForDelete(this.mViewParams.getAbsFragment().getActivity(), i);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.lock.helper.ILockHelper
    public void verifyLockedNote(int i, Intent intent, String... strArr) {
        verifyLockedNote(this.mViewParams.getAbsFragment().getActivity(), i, intent, strArr);
    }

    public void verifyLockedNoteForConvert(int i, Intent intent, String... strArr) {
        saveLockHelperTask(2, i, 0, intent, strArr);
        LockManager lockManager = this.mLockManager;
        if (lockManager != null) {
            lockManager.verifyForConvert(this.mViewParams.getAbsFragment().getActivity(), i, intent, strArr);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.lock.helper.ILockHelper
    public void verifyLockedNoteWithMultiAccount(int i, Intent intent, String... strArr) {
        verifyLockedNoteWithMultiAccount(this.mViewParams.getAbsFragment().getActivity(), i, intent, strArr);
    }

    private void setConvertingItem(NotesHolder notesHolder, String str, String str2, boolean z, boolean z2) {
        MainLogger.m7258i(TAG, "[L] setConvertingItem() - bIsLock : " + z + ", bIsConverting : " + z2);
        if (this.mNotesModel.isUUIDInConvertingState(str)) {
            if (this.mNotesModel.isUnlockConverting(str)) {
                notesHolder.setLockState(z2);
                return;
            }
            for (Common common : this.mDocumentMap.getCommonDisplayList()) {
                if (common.type == 2048 && common.notes.getUuid().equals(str2)) {
                    notesHolder.setLockState(z2);
                    notesHolder.decorate(common.notes, new HighlightText());
                    if (FeatureUtils.isRecyclebinMode(this.mViewParams.getModeIndex())) {
                        notesHolder.getNotesHolderInfo().setDueDateViewVisible(common.notes.getRecycleBinTimeMoved());
                        return;
                    }
                    return;
                }
            }
        }
    }
}
