package com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.helper;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import androidx.activity.OnBackPressedCallback;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.appcompat.widget.PopupMenu;
import androidx.collection.AbstractC0622a;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.notes.sync.contentsharing.controllers.C6684b;
import com.samsung.android.app.notes.sync.synchronization.managers.C6906i;
import com.samsung.android.app.notes.widget.broadcast.WidgetBroadcast;
import com.samsung.android.support.senl.p145cm.base.framework.provider.SettingsCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.account.AccountHelper;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.dialog.AppUpdateDialogFragment;
import com.samsung.android.support.senl.p148nt.app.common.dialog.MeridianDialogFragment;
import com.samsung.android.support.senl.p148nt.app.common.dialog.RestoreCheckMobileDataDialogFragment;
import com.samsung.android.support.senl.p148nt.app.common.dialog.RestoreConfirmDialogFragment;
import com.samsung.android.support.senl.p148nt.app.common.dialog.SettingsConfirmDialogFragment;
import com.samsung.android.support.senl.p148nt.app.common.log.MainCoeditLogger;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.app.common.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.app.common.util.FeatureUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.importer.ImportProcessor;
import com.samsung.android.support.senl.p148nt.app.main.common.data.DataManager;
import com.samsung.android.support.senl.p148nt.app.main.common.dialog.ChangeColorDialogFragment;
import com.samsung.android.support.senl.p148nt.app.main.common.dialog.FolderNameDialog;
import com.samsung.android.support.senl.p148nt.app.main.common.dialog.IColorConfirmDialogResult;
import com.samsung.android.support.senl.p148nt.app.main.common.dialog.ImportMultiplePdfDialogFragment;
import com.samsung.android.support.senl.p148nt.app.main.common.task.FolderWorkerTask;
import com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask;
import com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTaskManager;
import com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity;
import com.samsung.android.support.senl.p148nt.app.main.folder.view.dialog.FolderPickerDialog;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.DocumentMap;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.NotesModel;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.StateInfo;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.dialog.DialogViewContract;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.params.ViewParams;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.task.ShareTask;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.task.DeleteTask;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.dialog.ConvertConfirmDialogFragment;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.dialog.DeleteDialogFragment;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.dialog.ExportPdfDialogFragment;
import com.samsung.android.support.senl.p148nt.app.updater.UpdateManager;
import com.samsung.android.support.senl.p148nt.app.updater.connector.INewVersionCheckResetListener;
import com.samsung.android.support.senl.p148nt.app.updater.connector.MarketConnectorFactory;
import com.samsung.android.support.senl.p148nt.base.common.ComposerManager;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.access.sync.importer.data.ImportDocument;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.sync.IServerNoteInfoListener;
import com.samsung.android.support.senl.p148nt.base.common.sync.ServerNoteInfo;
import com.samsung.android.support.senl.p148nt.base.common.sync.SyncProgressListener;
import com.samsung.android.support.senl.p148nt.base.common.sync.SyncState;
import com.samsung.android.support.senl.p148nt.base.common.util.ModelFeature;
import com.samsung.android.support.senl.p148nt.base.winset.app.dialog.IEditDialogResult;
import com.samsung.android.support.senl.p148nt.base.winset.app.dialog.IFolderPickerDialogResult;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.base.winset.util.DialogUtils;
import com.samsung.android.support.senl.p148nt.coedit.caller.CoeditNoteUpDownloader;
import com.samsung.android.support.senl.p148nt.data.common.exceptions.InvalidParentFolderException;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;
import com.samsung.android.support.senl.p148nt.model.folder.FolderManager;
import com.samsung.android.support.senl.p148nt.model.securefolder.domain.ExportNoteToSecureSpaceUseCase;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p042J1.C0145c;
import p052M.C0171a;
import p079T.C0283a;
import p079T.InterfaceC0290h;
import p244u1.C14477a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class DialogHelper {
    private static final String KEY_IMPORT_REMAINS = "key_import_remains";
    private final DialogViewContract.IDialogCreator mDialogCreator;
    private final DocumentMap mDocumentMap;
    private final IPresenter mIPresenter;
    private final NotesModel mNotesModel;
    private final StateInfo mStateInfo;
    private final ViewParams mViewParams;
    private static final String TAG = "DialogHelper";
    private static final Executor SINGLE_THREAD_EXECUTOR = AbstractC4539a.m3201k(TAG);
    private final Handler mUIThreadHandler = new Handler(Looper.getMainLooper());
    private final DialogViewContract.IDeleteDialog mDeleteDialogListener = new DialogViewContract.IDeleteDialog() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.DialogHelper.1
        @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.dialog.DialogViewContract.IDeleteDialog
        public void onBackPressed() {
            DialogHelper.this.mIPresenter.onTaskCancel();
        }

        @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.dialog.DialogViewContract.IDeleteDialog
        public void onCancel() {
            DialogHelper.this.mIPresenter.onTaskCancel();
        }

        @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.dialog.DialogViewContract.IDeleteDialog
        public void onConfirm(boolean z) {
            if (!FeatureUtils.isRecyclebinMode(DialogHelper.this.mViewParams.getModeIndex()) && z) {
                DialogHelper.this.mIPresenter.verifyForDelete();
            } else {
                DialogHelper dialogHelper = DialogHelper.this;
                dialogHelper.deleteItems(dialogHelper.mNotesModel.getCheckedNotesUUID(), DialogHelper.this.mNotesModel.getCheckedFoldersUUID());
            }
        }
    };
    private final DialogViewContract.IDeleteDialog mDeleteCoeditDialogListener = new DialogViewContract.IDeleteDialog() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.DialogHelper.2
        @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.dialog.DialogViewContract.IDeleteDialog
        public void onBackPressed() {
            MainCoeditLogger.m7250d(DialogHelper.TAG, "DeleteCoeditDialogListener# onBackPressed#");
        }

        @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.dialog.DialogViewContract.IDeleteDialog
        public void onCancel() {
            MainCoeditLogger.m7250d(DialogHelper.TAG, "DeleteCoeditDialogListener# onCancel#");
        }

        @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.dialog.DialogViewContract.IDeleteDialog
        public void onConfirm(boolean z) {
            String mdeSpaceId;
            MainCoeditLogger.m7250d(DialogHelper.TAG, "DeleteCoeditDialogListener# onConfirm#");
            UserInputSkipper.setHoldingEventTime(1000L, UserInputSkipper.Tag.MemoList);
            final ArrayList<String> checkedNotesUUID = DialogHelper.this.mNotesModel.getCheckedNotesUUID();
            final ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Context context = DialogHelper.this.mViewParams.getContext();
            HashSet hashSet = new HashSet();
            Iterator<String> it = checkedNotesUUID.iterator();
            while (true) {
                mdeSpaceId = "";
                if (!it.hasNext()) {
                    break;
                }
                MainListDocumentData noteData = DialogHelper.this.mDocumentMap.getNoteData(it.next());
                String title = noteData == null ? null : noteData.getTitle();
                if (TextUtils.isEmpty(title)) {
                    title = "";
                }
                if (noteData != null) {
                    mdeSpaceId = noteData.getMdeSpaceId();
                }
                hashSet.add(mdeSpaceId);
                arrayList2.add(mdeSpaceId);
                arrayList.add(title);
            }
            DialogHelper.this.mIPresenter.onTaskFinished();
            DialogHelper.this.replaceDeleteBtnToProgress(NotesConstants.DialogTag.DELETE_COEDIT_NOTE_DIALOG);
            if (hashSet.size() > 1) {
                for (int i = 0; i < checkedNotesUUID.size(); i++) {
                    CoeditNoteUpDownloader.getInstance().requestDeleteItems(context, (String) arrayList2.get(i), Collections.singletonList(checkedNotesUUID.get(i)), new InterfaceC0290h() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.DialogHelper.2.1
                        @Override // p079T.InterfaceC0290h
                        public void onFinished(List<String> list) {
                            DialogHelper.this.mViewParams.getNotesView().getSpaceImpl().deleteStandaloneSpace(checkedNotesUUID, arrayList);
                        }
                    });
                }
            } else {
                Iterator it2 = hashSet.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    String str = (String) it2.next();
                    if (!TextUtils.isEmpty(str)) {
                        mdeSpaceId = str;
                        break;
                    }
                }
                CoeditNoteUpDownloader.getInstance().requestDeleteItems(context, mdeSpaceId, checkedNotesUUID, new InterfaceC0290h() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.DialogHelper.2.2
                    @Override // p079T.InterfaceC0290h
                    public void onFinished(List<String> list) {
                        DialogHelper.this.mViewParams.getNotesView().getSpaceImpl().deleteStandaloneSpace(checkedNotesUUID, arrayList);
                    }
                });
            }
            WidgetBroadcast.sendDeleteUUIDWidgetBroadcast(context, checkedNotesUUID);
        }
    };
    private final DialogViewContract.IDeleteDialog mDeleteGcsDialogListener = new DialogViewContract.IDeleteDialog() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.DialogHelper.3
        @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.dialog.DialogViewContract.IDeleteDialog
        public void onBackPressed() {
        }

        @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.dialog.DialogViewContract.IDeleteDialog
        public void onCancel() {
        }

        @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.dialog.DialogViewContract.IDeleteDialog
        public void onConfirm(boolean z) {
            UserInputSkipper.setHoldingEventTime(1000L, UserInputSkipper.Tag.MemoList);
            ArrayList<String> checkedNotesUUID = DialogHelper.this.mNotesModel.getCheckedNotesUUID();
            C0283a.m562d().getClass();
            String strM561c = C0283a.m561c();
            Context context = DialogHelper.this.mViewParams.getContext();
            Iterator<String> it = checkedNotesUUID.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (strM561c != null && context != null) {
                    MainListDocumentData noteData = DialogHelper.this.mDocumentMap.getNoteData(next);
                    String mdeOwnerId = noteData == null ? null : noteData.getMdeOwnerId();
                    if (!TextUtils.isEmpty(mdeOwnerId) && !strM561c.equals(mdeOwnerId)) {
                        ToastHandler.show(context, C8003R.string.gcs_space_deleted_partial_fail, 0);
                        break;
                    }
                } else {
                    break;
                }
            }
            DialogHelper.this.mIPresenter.onTaskFinished();
            C0171a c0171aM429a = C0171a.m429a();
            String spaceId = DialogHelper.this.mStateInfo.getSpaceId();
            c0171aM429a.getClass();
            if (!C0145c.m333r(BaseUtils.getApplicationContext())) {
                C6684b c6684b = c0171aM429a.f543a;
                c6684b.getClass();
                c6684b.m4777a(new C6906i(spaceId, checkedNotesUUID));
            }
            WidgetBroadcast.sendDeleteUUIDWidgetBroadcast(context, checkedNotesUUID);
        }
    };
    private final DialogViewContract.IConvertDialog mConvertConfirmDialogListener = new DialogViewContract.IConvertDialog() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.DialogHelper.4
        @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.dialog.DialogViewContract.IConvertDialog
        public void onBackPressed() {
            DialogHelper.this.mIPresenter.onTaskCancel();
        }

        @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.dialog.DialogViewContract.IConvertDialog
        public void onCancel() {
            DialogHelper.this.mIPresenter.onTaskCancel();
        }

        @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.dialog.DialogViewContract.IConvertDialog
        public void onDelete(List<String> list, boolean z) {
            DialogHelper.this.mIPresenter.requestDeleteConvertedNotes(list, z);
        }

        @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.dialog.DialogViewContract.IConvertDialog
        public void requestConvertOldNotes(List<String> list, boolean z) {
            DialogHelper.this.mIPresenter.onTaskFinished();
            DialogHelper.this.mIPresenter.requestStartConvertOldNotes(list, z);
        }

        @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.dialog.DialogViewContract.IConvertDialog
        public void requestMoveToConvertedNotes() {
            DialogHelper.this.mViewParams.getNotesView().onOldCategorySelected("old_converted_notes");
        }
    };
    private final DialogViewContract.IExportPdfDialog mExportPdfDialogContract = new DialogViewContract.IExportPdfDialog() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.DialogHelper.5
        @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.dialog.DialogViewContract.IExportPdfDialog
        public void cancelTask() {
            FragmentActivity activity = DialogHelper.this.mViewParams.getAbsFragment().getActivity();
            if (CommonUtil.isNotAvailableActivity(activity)) {
                return;
            }
            WorkerTaskManager.getInstance().cancelRunningTask(ShareTask.TAG, activity.hashCode());
        }
    };
    private final IColorConfirmDialogResult mColorConfirmResultListener = new IColorConfirmDialogResult() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.DialogHelper.6
        @Override // com.samsung.android.support.senl.p148nt.app.main.common.dialog.IColorConfirmDialogResult
        public void onConfirm(@NonNull final ArrayList<String> arrayList, final int i) {
            if (CommonUtil.isNotAvailableActivity(DialogHelper.this.mViewParams.getAbsFragment().getActivity())) {
                return;
            }
            final FolderWorkerTask folderWorkerTask = new FolderWorkerTask("ColorChange");
            folderWorkerTask.setCallback(new WorkerTask.Callback() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.DialogHelper.6.1
                @Override // com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask.Callback
                public void onEnd(@NonNull WorkerTask.Result result) {
                    DialogHelper.this.mIPresenter.onTaskFinished();
                    if (folderWorkerTask.getResult().getMSuccess()) {
                        DialogHelper.this.mViewParams.getNotesRecyclerView().getAdapter().notifyDataSetChanged();
                    }
                }

                @Override // com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask.Callback
                public void onStart(@NonNull WorkerTask<?> workerTask) {
                    folderWorkerTask.getResult().setSuccess(false);
                }
            });
            folderWorkerTask.run(new FolderWorkerTask.TaskParams(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.DialogHelper.6.2
                @Override // java.lang.Runnable
                public void run() {
                    ArrayList arrayList2 = new ArrayList();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        NotesFolder folderData = DialogHelper.this.mDocumentMap.getFolderData((String) it.next());
                        if (folderData != null) {
                            int displayNameColor = folderData.getDisplayNameColor();
                            int i2 = i;
                            if (displayNameColor != i2) {
                                folderData.setDisplayNameColor(i2);
                                arrayList2.add(folderData);
                            }
                        }
                    }
                    if (arrayList2.isEmpty()) {
                        return;
                    }
                    try {
                        FolderManager.getInstance().update(arrayList2);
                        folderWorkerTask.getResult().setSuccess(true);
                    } catch (InvalidParentFolderException e) {
                        MainLogger.m7255e(DialogHelper.TAG, "mColorConfirmResultListener# : " + e.getMessage());
                    }
                }
            }));
        }
    };
    private final IEditDialogResult mEditDialogResultListener = new IEditDialogResult() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.DialogHelper.7
        @Override // com.samsung.android.support.senl.p148nt.base.winset.app.dialog.IEditDialogResult
        public void onEditDialogDismiss() {
        }

        @Override // com.samsung.android.support.senl.p148nt.base.winset.app.dialog.IEditDialogResult
        public void onEditDialogResult(final int i, final String str, final String str2, final int i2) {
            StringBuilder sb = new StringBuilder("onEditDialogResult# folderName : ");
            sb.append(MainLogger.getEncode(str2));
            sb.append(", selectedUuid : ");
            sb.append(str);
            sb.append(", dialogType : ");
            AbstractC8014b.m7212n(sb, DialogHelper.TAG, i);
            final NotesFolder folderData = DialogHelper.this.mDocumentMap.getFolderData(str);
            if (folderData == null || CommonUtil.isNotAvailableActivity(DialogHelper.this.mViewParams.getAbsFragment().getActivity())) {
                return;
            }
            final FolderWorkerTask folderWorkerTask = new FolderWorkerTask("FolderEdit");
            folderWorkerTask.setCallback(new WorkerTask.Callback() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.DialogHelper.7.1
                @Override // com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask.Callback
                public void onEnd(@NonNull WorkerTask.Result result) {
                    if (!((FolderWorkerTask.Result) result).getMSuccess()) {
                        ToastHandler.show(DialogHelper.this.mViewParams.getContext(), C8003R.string.folder_already_in_use, 0);
                    }
                    if (i == 2) {
                        DialogHelper.this.mIPresenter.onTaskFinished();
                    }
                }

                @Override // com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask.Callback
                public void onStart(@NonNull WorkerTask<?> workerTask) {
                    ((FolderWorkerTask.Result) workerTask.getResult()).setSuccess(true);
                }
            });
            folderWorkerTask.run(new FolderWorkerTask.TaskParams(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.DialogHelper.7.2
                @Override // java.lang.Runnable
                public void run() {
                    String parentUuid = i == 1 ? str : folderData.getParentUuid();
                    if (DataManager.getInstance().isExistFolderName(DialogHelper.this.mViewParams.getContext(), str2, parentUuid, DataManager.getInstance().getFoldersDisplayName(parentUuid, null), true)) {
                        folderWorkerTask.getResult().setSuccess(false);
                        return;
                    }
                    try {
                        int i4 = i;
                        if (i4 == 1) {
                            MainLogger.m7258i(DialogHelper.TAG, "onEditDialogResult# add - folderName : " + MainLogger.getEncode(str2) + ", parentUuid : " + str);
                            DialogHelper.this.mDocumentMap.addFolderData(str, parentUuid, str2, i2);
                            return;
                        }
                        if (i4 == 2) {
                            NotesFolder notesFolder = FolderManager.getInstance().getNotesFolder(str, false);
                            MainLogger.m7258i(DialogHelper.TAG, "onEditDialogResult# rename folderName - " + MainLogger.getEncode(notesFolder.getDisplayName()) + " -> " + MainLogger.getEncode(str2));
                            notesFolder.setDisplayName(str2);
                            FolderManager.getInstance().update(notesFolder);
                        }
                    } catch (InvalidParentFolderException e) {
                        MainLogger.m7255e(DialogHelper.TAG, "mEditDialogResultListener# : " + e.getMessage());
                    }
                }
            }));
        }
    };
    private final IFolderPickerDialogResult mPickerDialogListener = new IFolderPickerDialogResult() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.DialogHelper.8
        @Override // com.samsung.android.support.senl.p148nt.base.winset.app.dialog.IFolderPickerDialogResult
        public void onCancel() {
            DialogHelper.this.mIPresenter.onTaskFinished();
        }

        @Override // com.samsung.android.support.senl.p148nt.base.winset.app.dialog.IFolderPickerDialogResult
        public void onConfirm(String str) {
            ((AbsAppCompatActivity) DialogHelper.this.mViewParams.getAbsFragment().getActivity()).onNotesDataMove(str);
        }
    };
    private final SettingsConfirmDialogFragment.DialogListener mSignInAndTurnOnSCloudSyncForMsSyncDialogListener = new SettingsConfirmDialogFragment.DialogListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.DialogHelper.9
        @Override // com.samsung.android.support.senl.nt.app.common.dialog.SettingsConfirmDialogFragment.DialogListener
        public void onCancel() {
        }

        @Override // com.samsung.android.support.senl.nt.app.common.dialog.SettingsConfirmDialogFragment.DialogListener
        public void onConfirm() {
            AccountHelper.loginPopupSamsungAccount(DialogHelper.this.mViewParams.getAbsFragment().getActivity(), 10);
        }
    };
    private final RestoreCheckMobileDataDialogFragment.DialogListener mRestoreCheckMobileDataDialogListener = new RestoreCheckMobileDataDialogFragment.DialogListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.DialogHelper.10
        @Override // com.samsung.android.support.senl.nt.app.common.dialog.RestoreCheckMobileDataDialogFragment.DialogListener
        public void onCancel() {
            DialogHelper.this.removeCircleProgressDialog();
        }

        @Override // com.samsung.android.support.senl.nt.app.common.dialog.RestoreCheckMobileDataDialogFragment.DialogListener
        public void onConfirm(@Nullable String str) {
            FragmentActivity activity = DialogHelper.this.mViewParams.getAbsFragment().getActivity();
            if (CommonUtil.isNotAvailableActivity(activity)) {
                MainLogger.m7258i(DialogHelper.TAG, "RestoreCheckMobileDataDialogFragment - activity is invalid");
            } else {
                C0145c.m314V(activity.getApplicationContext(), Boolean.FALSE);
                DialogHelper.this.showRestoreConfirmDialog(str);
            }
        }
    };
    private final RestoreConfirmDialogFragment.DialogListener mRestoreConfirmDialogRestore = new RestoreConfirmDialogFragment.DialogListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.DialogHelper.11

        /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.DialogHelper$11$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class AnonymousClass1 implements SyncProgressListener {
            final /* synthetic */ Activity val$activity;
            final /* synthetic */ String val$uuid;

            public AnonymousClass1(Activity activity, String str) {
                this.val$activity = activity;
                this.val$uuid = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void lambda$onEnded$0(Activity activity) {
                ToastHandler.show(activity, C8003R.string.restore_corrupt_server_corrupted, 0);
            }

            @Override // com.samsung.android.support.senl.p148nt.base.common.sync.SyncProgressListener
            public void onEnded(int i) {
                if (i != 0) {
                    DialogHelper.this.mUIThreadHandler.post(new RunnableC8496b(this.val$activity, 0));
                    CommonSamsungAnalytics.insertLog("101", NotesSAConstants.EVENT_RESTORE_NOTE_BY_LAST_VERSION, "b");
                } else {
                    if (CommonUtil.isNotAvailableActivity(this.val$activity)) {
                        MainLogger.m7258i(DialogHelper.TAG, "RestoreCorruptedNoteDialogFragment onEnded - activity is invalid");
                        return;
                    }
                    DialogHelper.this.removeCircleProgressDialog();
                    DialogHelper.this.mIPresenter.onRestoreCorruptedNoteSelect(this.val$uuid);
                    CommonSamsungAnalytics.insertLog("101", NotesSAConstants.EVENT_RESTORE_NOTE_BY_LAST_VERSION, "a");
                }
            }

            @Override // com.samsung.android.support.senl.p148nt.base.common.sync.SyncProgressListener
            public void onStarted() {
                MainLogger.m7258i(DialogHelper.TAG, "requestSyncDownImmediately onStarted");
                DialogHelper.this.showCircleProgressDialog(null);
            }
        }

        @Override // com.samsung.android.support.senl.nt.app.common.dialog.RestoreConfirmDialogFragment.DialogListener
        public void onPositiveButton(String str) {
            FragmentActivity activity = DialogHelper.this.mViewParams.getAbsFragment().getActivity();
            if (CommonUtil.isNotAvailableActivity(activity)) {
                MainLogger.m7258i(DialogHelper.TAG, "RestoreConfirmDialogFragment - activity is invalid");
            } else {
                C14477a.m15065b().m15074j(str, new AnonymousClass1(activity, str));
            }
        }
    };
    private final RestoreConfirmDialogFragment.DialogListener mRestoreConfirmDialogDelete = new C8497c(this);

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.DialogHelper$27 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C845027 implements IServerNoteInfoListener {
        final /* synthetic */ String val$uuid;

        public C845027(String str) {
            this.val$uuid = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onFailed$0(Context context) {
            ToastHandler.show(context, context.getString(C8003R.string.restore_corrupt_server_corrupted), 0);
        }

        @Override // com.samsung.android.support.senl.p148nt.base.common.sync.IServerNoteInfoListener
        public void onFailed(int i) {
            Context context;
            AbstractC6670b.m4736A(i, "showRestoreCheckConfirmDialog: Failed ", DialogHelper.TAG);
            DialogHelper.this.removeCircleProgressDialog();
            if (DialogHelper.this.mStateInfo.getCanRestoreNote() && (context = DialogHelper.this.mViewParams.getContext()) != null) {
                DialogHelper.this.mUIThreadHandler.post(new RunnableC8496b(context, 1));
            }
        }

        @Override // com.samsung.android.support.senl.p148nt.base.common.sync.IServerNoteInfoListener
        public void onReceived(@NotNull ServerNoteInfo serverNoteInfo) {
            DialogHelper.this.removeCircleProgressDialog();
            if (DialogHelper.this.mStateInfo.getCanRestoreNote()) {
                if (serverNoteInfo.isExists()) {
                    MainLogger.m7254d(DialogHelper.TAG, "showRestoreCheckConfirmDialog: requestServerNoteInfo Received");
                    RestoreConfirmDialogFragment restoreConfirmDialogFragment = new RestoreConfirmDialogFragment(this.val$uuid, serverNoteInfo.getModifiedTime(), true);
                    restoreConfirmDialogFragment.setDialogListener(DialogHelper.this.mRestoreConfirmDialogRestore);
                    restoreConfirmDialogFragment.show(DialogHelper.this.mViewParams.getAbsFragment().getChildFragmentManager(), NotesConstants.DialogTag.RESTORE_CONFIRM_DIALOG);
                    return;
                }
                MainLogger.m7254d(DialogHelper.TAG, "showRestoreCheckConfirmDialog: requestServerNoteInfo Empty");
                RestoreConfirmDialogFragment restoreConfirmDialogFragment2 = new RestoreConfirmDialogFragment(this.val$uuid, 0L, false);
                restoreConfirmDialogFragment2.setDialogListener(DialogHelper.this.mRestoreConfirmDialogDelete);
                restoreConfirmDialogFragment2.show(DialogHelper.this.mViewParams.getAbsFragment().getChildFragmentManager(), NotesConstants.DialogTag.RESTORE_CONFIRM_DIALOG);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IPresenter {
        void duplicateToDevice(ArrayList<ImportDocument> arrayList);

        void onRestoreCorruptedNoteSelect(String str);

        void onTaskCancel();

        void onTaskFinished();

        void requestDeleteConvertedNotes(List<String> list, boolean z);

        void requestStartConvertOldNotes(List<String> list, boolean z);

        void unlockForMoveToSecureFolder();

        void verifyForDelete();
    }

    public DialogHelper(ViewParams viewParams, NotesModel notesModel, DocumentMap documentMap, StateInfo stateInfo, DialogViewContract.IDialogCreator iDialogCreator, IPresenter iPresenter) {
        this.mDialogCreator = iDialogCreator;
        this.mViewParams = viewParams;
        this.mNotesModel = notesModel;
        this.mDocumentMap = documentMap;
        this.mStateInfo = stateInfo;
        this.mIPresenter = iPresenter;
    }

    private void dismissDialogByTag(final String str) {
        this.mUIThreadHandler.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.DialogHelper.26
            @Override // java.lang.Runnable
            public void run() {
                if (!DialogHelper.this.mViewParams.getAbsFragment().isAdded()) {
                    MainLogger.m7255e(DialogHelper.TAG, "dismissDialogByTag - parent fragment is not added");
                    return;
                }
                try {
                    MainLogger.m7254d(DialogHelper.TAG, "dismissDialogByTag - tag: " + str);
                    DialogFragment dialogFragment = (DialogFragment) DialogHelper.this.mViewParams.getAbsFragment().getChildFragmentManager().findFragmentByTag(str);
                    if (dialogFragment != null) {
                        dialogFragment.dismissAllowingStateLoss();
                    }
                } catch (IllegalStateException e) {
                    MainLogger.m7255e(DialogHelper.TAG, "dismissDialogByTag - IllegalStateException : " + e.getMessage());
                }
            }
        });
    }

    private ContextThemeWrapper getContextThemeWrapper() {
        return SettingsCompat.getInstance().isHighTextContrastEnabled(this.mViewParams.getContext()) ? new ContextThemeWrapper(this.mViewParams.getContext(), C8003R.style.AppMainThemeHighContrast) : new ContextThemeWrapper(this.mViewParams.getContext(), C8003R.style.AppMainThemeNoChunking);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getSortTypeFromSortTypePopupMenuOrder(int i) {
        if (i != 0) {
            return i != 1 ? 2 : 1;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getViewTypeFromViewByPopupMenuOrder(int i) {
        if (i == 0) {
            return 2;
        }
        if (i == 1) {
            return 4;
        }
        if (i != 2) {
            return ModelFeature.getFeature().needNoThumbnailSimpleList() ? 6 : 3;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str);
        deleteItems(arrayList, new ArrayList<>());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showExportPdfDialog$1() {
        if (this.mViewParams.getAbsFragment().isAdded()) {
            this.mDialogCreator.createExportPdfDialogFragment(this.mExportPdfDialogContract).show(this.mViewParams.getAbsFragment().getChildFragmentManager(), NotesConstants.DialogTag.EXPORT_PDF_DIALOG);
        } else {
            MainLogger.m7255e(TAG, "showExportPdfDialog# fragment is not added");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void replaceDeleteBtnToProgress(String str) {
        AbstractC8014b.m7209k("replaceDeleteBtnToProgress - tag: ", str, TAG);
        DialogViewContract.IDialogFragment iDialogFragment = (DialogViewContract.IDialogFragment) this.mViewParams.getAbsFragment().getChildFragmentManager().findFragmentByTag(str);
        if (iDialogFragment == null) {
            return;
        }
        iDialogFragment.replaceBtnToProgress();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUpdateDialogForSyncListener(AppUpdateDialogFragment appUpdateDialogFragment) {
        MainLogger.m7254d(TAG, "setUpdateDialogForSyncListener");
        appUpdateDialogFragment.setDialogListener(new AppUpdateDialogFragment.AppUpdateDialogListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.DialogHelper.22
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                AbstractC8014b.m7201c(i, "setUpdateDialogForSyncListener# buttonType: ", DialogHelper.TAG);
                if (-1 == i) {
                    UpdateManager.getInstance().goToGalaxyAppStore();
                    SyncState.setAppUpdateCheckPeriod();
                }
            }
        });
    }

    private void showAppUpdateDialogForImport() {
        AppUpdateDialogFragment appUpdateDialogFragment = new AppUpdateDialogFragment();
        appUpdateDialogFragment.setDialogListener(new AppUpdateDialogFragment.AppUpdateDialogListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.DialogHelper.20
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                AbstractC8014b.m7201c(i, "showAppUpdateDialogForImport# buttonType: ", DialogHelper.TAG);
                if (-1 == i) {
                    UpdateManager.getInstance().goToGalaxyAppStore();
                } else if (-2 == i) {
                    ImportProcessor.cancel();
                }
            }
        });
        appUpdateDialogFragment.showAllowingStateLoss(this.mViewParams.getAbsFragment().getChildFragmentManager(), AppUpdateDialogFragment.FOR_UNSUPPORTED_FORMAT_IMPORT);
    }

    private void showAppUpdateDialogForLowVersion() {
        AppUpdateDialogFragment appUpdateDialogFragment = new AppUpdateDialogFragment();
        appUpdateDialogFragment.setDialogListener(new AppUpdateDialogFragment.AppUpdateDialogListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.DialogHelper.19
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                AbstractC8014b.m7201c(i, "showAppUpdateDialogForLowVersion# buttonType: ", DialogHelper.TAG);
                if (-1 == i) {
                    UpdateManager.getInstance().goToGalaxyAppStore();
                }
            }
        });
        appUpdateDialogFragment.showAllowingStateLoss(this.mViewParams.getAbsFragment().getChildFragmentManager(), AppUpdateDialogFragment.FOR_LOW_VERSION_FORMAT_SYNC);
    }

    private void showAppUpdateDialogForSync() {
        if (SyncState.getAppUpdateCheckPeriod() > System.currentTimeMillis()) {
            MainLogger.m7255e(TAG, "showAppUpdateDialogForSync SyncState period is not enough.");
            return;
        }
        if (SyncState.getStoreConnected() <= 0) {
            MarketConnectorFactory.createMarketConnector().checkNewVersionOnMarket(new INewVersionCheckResetListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.DialogHelper.21
                @Override // com.samsung.android.support.senl.p148nt.app.updater.connector.INewVersionCheckResetListener
                public void getResult(int i) {
                    UpdateManager.getInstance().resetNeedToCheck();
                    SyncState.setStoreConnected(true);
                    int currentVersionCode = UpdateManager.getInstance().getCurrentVersionCode();
                    int prefUserCheckedVersion = UpdateManager.getInstance().getPrefUserCheckedVersion();
                    AbstractC8014b.m7212n(AbstractC0622a.m1173s(i, currentVersionCode, "showAppUpdateDialogForSync# getResult, marketVersionCode : ", ", currentVersionCode : ", ", savedVersionCode : "), DialogHelper.TAG, prefUserCheckedVersion);
                    if (prefUserCheckedVersion < i) {
                        UpdateManager.getInstance().setPrefUserCheckedVersion(i);
                    }
                    if (currentVersionCode >= i) {
                        MainLogger.m7258i(DialogHelper.TAG, "showAppUpdateDialogForSync# getResult, It is latest version");
                    } else {
                        if (!DialogHelper.this.mViewParams.getAbsFragment().isAdded()) {
                            MainLogger.m7255e(DialogHelper.TAG, "showAppUpdateDialogForSync# fragment is not added");
                            return;
                        }
                        AppUpdateDialogFragment appUpdateDialogFragment = new AppUpdateDialogFragment();
                        DialogHelper.this.setUpdateDialogForSyncListener(appUpdateDialogFragment);
                        appUpdateDialogFragment.showAllowingStateLoss(DialogHelper.this.mViewParams.getAbsFragment().getChildFragmentManager(), AppUpdateDialogFragment.FOR_UNSUPPORTED_FORMAT_SYNC);
                    }
                }
            });
            return;
        }
        int currentVersionCode = UpdateManager.getInstance().getCurrentVersionCode();
        int prefUserCheckedVersion = UpdateManager.getInstance().getPrefUserCheckedVersion();
        AbstractC8014b.m7200b(currentVersionCode, prefUserCheckedVersion, "showAppUpdateDialogForSync# currentVersionCode : ", ", savedVersionCode : ", TAG);
        if (currentVersionCode < prefUserCheckedVersion) {
            AppUpdateDialogFragment appUpdateDialogFragment = new AppUpdateDialogFragment();
            setUpdateDialogForSyncListener(appUpdateDialogFragment);
            appUpdateDialogFragment.showAllowingStateLoss(this.mViewParams.getAbsFragment().getChildFragmentManager(), AppUpdateDialogFragment.FOR_UNSUPPORTED_FORMAT_SYNC);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sortTypePopupMenuSALogging(@IdRes int i) {
        if (i == C8003R.id.sortby_title) {
            CommonSamsungAnalytics.insertLog("706", "7061", "1");
        } else if (i == C8003R.id.sortby_date_created) {
            CommonSamsungAnalytics.insertLog("706", "7061", "2");
        } else {
            CommonSamsungAnalytics.insertLog("706", "7061", "3");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void viewByPopupMenuSALogging(@IdRes int i) {
        if (i == C8003R.id.viewby_list) {
            CommonSamsungAnalytics.insertLog("101", NotesSAConstants.EVENT_VIEW_TYPE, "c");
            return;
        }
        if (i == C8003R.id.viewby_simple) {
            CommonSamsungAnalytics.insertLog("101", NotesSAConstants.EVENT_VIEW_TYPE, "d");
        } else if (i == C8003R.id.viewby_grid_large) {
            CommonSamsungAnalytics.insertLog("101", NotesSAConstants.EVENT_VIEW_TYPE, "a");
        } else {
            CommonSamsungAnalytics.insertLog("101", NotesSAConstants.EVENT_VIEW_TYPE, "b");
        }
    }

    public void deleteItems(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        replaceDeleteBtnToProgress(NotesConstants.DialogTag.DELETE_DIALOG);
        DeleteTask deleteTask = new DeleteTask(this.mViewParams.getAbsFragment().getActivity(), this.mViewParams.getModeIndex());
        WorkerTaskManager.getInstance().addTask(deleteTask);
        deleteTask.run(Pair.create(arrayList, arrayList2));
    }

    public void dismissDeleteDialog() {
        dismissDialogByTag(NotesConstants.DialogTag.DELETE_DIALOG);
    }

    public void dismissSaveToDeviceDialog() {
        dismissDialogByTag(NotesConstants.DialogTag.SAVE_TO_DEVICE_DIALOG);
    }

    public void moveToSecureFolder(final Context context, int i) {
        MainLogger.m7258i(TAG, "moveToSecureFolder lockNoteCount : " + i);
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (String str : this.mNotesModel.getCheckedNotesUUID()) {
            if (ComposerManager.getInstance().isOpen(str, null)) {
                z = true;
            } else {
                arrayList.add(str);
            }
        }
        if (z) {
            ToastHandler.show(context, C8003R.string.toast_not_move_opened_note, 0);
            if (arrayList.size() <= 1) {
                return;
            }
        }
        if (i == 0) {
            new ExportNoteToSecureSpaceUseCase(context.getApplicationContext(), arrayList, new ExportNoteToSecureSpaceUseCase.Listener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.DialogHelper.16
                @Override // com.samsung.android.support.senl.nt.model.securefolder.domain.ExportNoteToSecureSpaceUseCase.Listener
                public void onExportFinished(int i2) {
                    MainLogger.m7258i(DialogHelper.TAG, "onMoveNotesFinished");
                    if (i2 == 1) {
                        ToastHandler.show(context, C8003R.string.base_string_failed_to_load_image, 0);
                    }
                    DialogHelper.this.mIPresenter.onTaskFinished();
                }

                @Override // com.samsung.android.support.senl.nt.model.securefolder.domain.ExportNoteToSecureSpaceUseCase.Listener
                public void onExportStarted() {
                    MainLogger.m7258i(DialogHelper.TAG, "onExportStarted");
                }
            }).executeOnExecutor(SINGLE_THREAD_EXECUTOR, new Void[0]);
        } else {
            this.mDialogCreator.createMoveSFDialog(context, this.mNotesModel.getCheckedNotesUUID().size(), this.mViewParams.getAbsFragment().getActivity().findViewById(C8003R.id.action_more), new DialogViewContract.IMoveToSecureFolderDialog() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.DialogHelper.17
                @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.dialog.DialogViewContract.IMoveToSecureFolderDialog
                public void onConfirm() {
                    MainLogger.m7258i(DialogHelper.TAG, "moveToSecureFolderDialog #onConfirm");
                    DialogHelper.this.mIPresenter.unlockForMoveToSecureFolder();
                }
            }).show();
        }
    }

    public void onRestoreInstanceState(Bundle bundle) {
        FragmentManager childFragmentManager = this.mViewParams.getAbsFragment().getChildFragmentManager();
        DeleteDialogFragment deleteDialogFragment = (DeleteDialogFragment) childFragmentManager.findFragmentByTag(NotesConstants.DialogTag.DELETE_DIALOG);
        if (deleteDialogFragment != null) {
            this.mDialogCreator.setDeleteDialogContract(deleteDialogFragment, this.mDeleteDialogListener);
            return;
        }
        DeleteDialogFragment deleteDialogFragment2 = (DeleteDialogFragment) childFragmentManager.findFragmentByTag(NotesConstants.DialogTag.DELETE_GCS_SPACE_DIALOG);
        if (deleteDialogFragment2 != null) {
            this.mDialogCreator.setDeleteDialogContract(deleteDialogFragment2, this.mDeleteGcsDialogListener);
            return;
        }
        DeleteDialogFragment deleteDialogFragment3 = (DeleteDialogFragment) childFragmentManager.findFragmentByTag(NotesConstants.DialogTag.DELETE_COEDIT_NOTE_DIALOG);
        if (deleteDialogFragment3 != null) {
            this.mDialogCreator.setDeleteDialogContract(deleteDialogFragment3, this.mDeleteCoeditDialogListener);
            return;
        }
        ConvertConfirmDialogFragment convertConfirmDialogFragment = (ConvertConfirmDialogFragment) childFragmentManager.findFragmentByTag(NotesConstants.DialogTag.CONVERT_DIALOG);
        if (convertConfirmDialogFragment != null) {
            this.mDialogCreator.setConvertConfirmDialogContract(convertConfirmDialogFragment, this.mConvertConfirmDialogListener);
            return;
        }
        ExportPdfDialogFragment exportPdfDialogFragment = (ExportPdfDialogFragment) childFragmentManager.findFragmentByTag(NotesConstants.DialogTag.EXPORT_PDF_DIALOG);
        if (exportPdfDialogFragment != null) {
            this.mDialogCreator.setExportPdfDialogContract(exportPdfDialogFragment, this.mExportPdfDialogContract);
            return;
        }
        FolderPickerDialog folderPickerDialog = (FolderPickerDialog) childFragmentManager.findFragmentByTag("FolderPickerDialog");
        if (folderPickerDialog != null) {
            folderPickerDialog.setPickerDialogListener(this.mPickerDialogListener);
            return;
        }
        FolderNameDialog folderNameDialog = (FolderNameDialog) childFragmentManager.findFragmentByTag(FolderConstants.DialogTag.FOLDER_NAME);
        if (folderNameDialog != null) {
            folderNameDialog.setEditDialogResultListener(this.mEditDialogResultListener);
            return;
        }
        ChangeColorDialogFragment changeColorDialogFragment = (ChangeColorDialogFragment) childFragmentManager.findFragmentByTag(FolderConstants.DialogTag.CHANGE_COLOR);
        if (changeColorDialogFragment != null) {
            changeColorDialogFragment.setColorConfirmDialogResultListener(this.mColorConfirmResultListener);
            return;
        }
        ArrayList<ImportDocument> parcelableArrayList = bundle.getParcelableArrayList(KEY_IMPORT_REMAINS);
        if (parcelableArrayList == null || parcelableArrayList.isEmpty()) {
            dismissSaveToDeviceDialog();
        } else {
            this.mIPresenter.duplicateToDevice(parcelableArrayList);
        }
        SettingsConfirmDialogFragment settingsConfirmDialogFragment = (SettingsConfirmDialogFragment) childFragmentManager.findFragmentByTag(NotesConstants.DialogTag.SIGN_IN_AND_TURN_ON_SCLOUD_SYNC_DIALOG);
        if (settingsConfirmDialogFragment != null) {
            settingsConfirmDialogFragment.setDialogListener(this.mSignInAndTurnOnSCloudSyncForMsSyncDialogListener);
        }
    }

    public void onSaveInstanceState(Bundle bundle, List<ImportDocument> list) {
        bundle.putParcelableArrayList(KEY_IMPORT_REMAINS, (ArrayList) list);
    }

    public void onViewChangeRestoreInstanceState(Bundle bundle) {
        String string;
        if (bundle == null || (string = bundle.getString(NotesConstants.DialogTag.ON_SAVE_INSTANCE_STATE)) == null) {
            return;
        }
        switch (string) {
            case "ConvertDialog":
                showConvertConfirmDialog(bundle.getStringArrayList(ConvertConfirmDialogFragment.KEY_TARGET_UUIDS), bundle.getBoolean(ConvertConfirmDialogFragment.KEY_IS_CONVERT_ALL), bundle.getBoolean(ConvertConfirmDialogFragment.KEY_HAS_CONVERTED_NOTES), bundle.getBoolean(ConvertConfirmDialogFragment.KEY_IS_CONVERTED_NOTES_MISSED), bundle.getInt(ConvertConfirmDialogFragment.KEY_LOCKED_NOTES_COUNT));
                break;
            case "folder_name_dialog":
                showAddFolderDialog(bundle.getString(NotesConstants.DialogTag.KEY_PARENT_UUID), bundle.getString(NotesConstants.DialogTag.KEY_SELECTED_UUID), bundle.getString(NotesConstants.DialogTag.KEY_INPUT_TEXT_STRING), bundle.getInt(NotesConstants.DialogTag.KEY_SELECTED_COLOR));
                break;
            case "DeleteDialog":
                showDeleteDialog(bundle.getInt("title_id"), bundle.getInt("message_id"), bundle.getInt(NotesConstants.DialogTag.KEY_POSITIVE_ID), bundle.getInt(NotesConstants.DialogTag.KEY_DELETE_COUNT), bundle.getInt(NotesConstants.DialogTag.KEY_DELETE_FOLDER_COUNT), bundle.getInt(NotesConstants.DialogTag.KEY_LOCKED_COUNT), bundle.getBoolean(NotesConstants.DialogTag.KEY_PLURALS), bundle.getInt(NotesConstants.DialogTag.KEY_MODE_ID), bundle.getBoolean(DeleteDialogFragment.KEY_DELETE_TYPE), bundle.getBoolean(NotesConstants.DialogTag.KEY_IS_PROGRESS_ON));
                break;
            case "FolderPickerDialog":
                showFolderPickerDialog();
                break;
            case "DeleteGcsSpaceDialog":
                showDeleteGcsSpaceDialog(bundle.getInt("title_id"), bundle.getInt("message_id"), bundle.getInt(NotesConstants.DialogTag.KEY_POSITIVE_ID), bundle.getInt(NotesConstants.DialogTag.KEY_DELETE_COUNT), bundle.getInt(NotesConstants.DialogTag.KEY_DELETE_FOLDER_COUNT), bundle.getInt(NotesConstants.DialogTag.KEY_LOCKED_COUNT), bundle.getBoolean(NotesConstants.DialogTag.KEY_PLURALS), bundle.getInt(NotesConstants.DialogTag.KEY_MODE_ID), bundle.getBoolean(NotesConstants.DialogTag.KEY_IS_PROGRESS_ON));
                break;
            case "SortByDialog":
                showSortByDialog(bundle.getInt(NotesConstants.DialogTag.KEY_SORT_BY), bundle.getInt("orderBy"));
                break;
        }
    }

    public void onViewChangeSaveInstanceState(Bundle bundle) {
        FragmentManager childFragmentManager = this.mViewParams.getAbsFragment().getChildFragmentManager();
        String[] strArr = {NotesConstants.DialogTag.DELETE_DIALOG, NotesConstants.DialogTag.DELETE_GCS_SPACE_DIALOG, NotesConstants.DialogTag.CONVERT_DIALOG, NotesConstants.DialogTag.CONVERT_DIALOG, "FolderPickerDialog", FolderConstants.DialogTag.FOLDER_NAME, NotesConstants.DialogTag.DELETE_COEDIT_NOTE_DIALOG};
        boolean zIsOldMode = FeatureUtils.isOldMode(this.mViewParams.getModeIndex());
        for (int i = 0; i < 7; i++) {
            String str = strArr[i];
            DialogFragment dialogFragment = (DialogFragment) childFragmentManager.findFragmentByTag(str);
            if (dialogFragment != null) {
                if (zIsOldMode) {
                    dialogFragment.dismiss();
                    return;
                }
                bundle.putString(NotesConstants.DialogTag.ON_SAVE_INSTANCE_STATE, str);
                dialogFragment.onSaveInstanceState(bundle);
                dialogFragment.dismiss();
                return;
            }
        }
    }

    public void removeCircleProgressDialog() {
        MainLogger.m7258i(TAG, "removeCircleProgressDialog");
        dismissDialogByTag(NotesConstants.DialogTag.CIRCLE_PROGRESS_DIALOG);
    }

    public void removeExportPdfDialog() {
        dismissDialogByTag(NotesConstants.DialogTag.EXPORT_PDF_DIALOG);
    }

    public void removeProcessProgressDialog() {
        MainLogger.m7258i(TAG, "removeProcessProgressDialog");
        dismissDialogByTag(NotesConstants.DialogTag.PROCESS_PROGRESS_DIALOG);
    }

    public void removeSaveAsProgressDialog() {
        dismissDialogByTag(NotesConstants.DialogTag.SAVE_AS_PROGRESS_DIALOG);
    }

    public void restoreImportMultiPdfDialog(ImportMultiplePdfDialogFragment.Contract contract) {
        ImportMultiplePdfDialogFragment importMultiplePdfDialogFragment = (ImportMultiplePdfDialogFragment) this.mViewParams.getAbsFragment().getChildFragmentManager().findFragmentByTag(ImportMultiplePdfDialogFragment.TAG);
        if (importMultiplePdfDialogFragment != null) {
            importMultiplePdfDialogFragment.setContract(contract);
        }
    }

    public void showAddFolderDialog(String str) {
        if (this.mDocumentMap.getFolderDepth(str) >= 50) {
            ToastHandler.show(this.mViewParams.getContext(), this.mViewParams.getAbsFragment().getResources().getString(C8003R.string.add_subfolder_max_toast), 0);
            return;
        }
        FolderNameDialog folderNameDialog = new FolderNameDialog(str, 1);
        folderNameDialog.setAnchorViewId(C8003R.id.action_more);
        folderNameDialog.setEditDialogResultListener(this.mEditDialogResultListener);
        folderNameDialog.show(this.mViewParams.getAbsFragment().getChildFragmentManager(), FolderConstants.DialogTag.FOLDER_NAME);
    }

    public void showAppUpdateDialog(String str) {
        AbstractC8014b.m7209k("showAppUpdateDialog# caller : ", str, TAG);
        AppUpdateDialogFragment appUpdateDialogFragment = (AppUpdateDialogFragment) this.mViewParams.getAbsFragment().getChildFragmentManager().findFragmentByTag(str);
        if (appUpdateDialogFragment != null && appUpdateDialogFragment.isResumed() && appUpdateDialogFragment.isAdded()) {
            MainLogger.m7258i(TAG, "showAppUpdateDialog# already showing");
            return;
        }
        if (AppUpdateDialogFragment.FOR_UNSUPPORTED_FORMAT_IMPORT.equals(str)) {
            showAppUpdateDialogForImport();
        } else if (AppUpdateDialogFragment.FOR_UNSUPPORTED_FORMAT_SYNC.equals(str)) {
            showAppUpdateDialogForSync();
        } else if (AppUpdateDialogFragment.FOR_LOW_VERSION_FORMAT_SYNC.equals(str)) {
            showAppUpdateDialogForLowVersion();
        }
    }

    public void showChangeColorDialog(ArrayList<String> arrayList) {
        ChangeColorDialogFragment changeColorDialogFragment;
        if (arrayList.size() == 1) {
            NotesFolder folderData = this.mDocumentMap.getFolderData(arrayList.get(0));
            if (folderData == null) {
                return;
            } else {
                changeColorDialogFragment = new ChangeColorDialogFragment(arrayList, folderData.getDisplayNameColor());
            }
        } else {
            changeColorDialogFragment = new ChangeColorDialogFragment(arrayList, -1);
        }
        changeColorDialogFragment.setAnchorViewId(C8003R.id.action_change_color);
        changeColorDialogFragment.setColorConfirmDialogResultListener(this.mColorConfirmResultListener);
        changeColorDialogFragment.show(this.mViewParams.getAbsFragment().getChildFragmentManager(), FolderConstants.DialogTag.CHANGE_COLOR);
    }

    public void showCircleProgressDialog(final DialogInterface.OnKeyListener onKeyListener) {
        this.mUIThreadHandler.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.DialogHelper.14
            @Override // java.lang.Runnable
            public void run() {
                if (!DialogHelper.this.mViewParams.getAbsFragment().isAdded()) {
                    MainLogger.m7255e(DialogHelper.TAG, "showCircleProgressDialog# fragment is not added");
                    return;
                }
                FragmentManager childFragmentManager = DialogHelper.this.mViewParams.getAbsFragment().getChildFragmentManager();
                DialogFragment dialogFragment = (DialogFragment) childFragmentManager.findFragmentByTag(NotesConstants.DialogTag.CIRCLE_PROGRESS_DIALOG);
                if (dialogFragment != null && dialogFragment.isAdded()) {
                    MainLogger.m7258i(DialogHelper.TAG, "showCircleProgressDialog# is already added");
                    return;
                }
                MainLogger.m7258i(DialogHelper.TAG, "showCircleProgressDialog");
                DialogFragment dialogFragmentCreateCircleProgressDialogFragment = DialogUtils.createCircleProgressDialogFragment(onKeyListener);
                dialogFragmentCreateCircleProgressDialogFragment.setCancelable(false);
                dialogFragmentCreateCircleProgressDialogFragment.show(childFragmentManager, NotesConstants.DialogTag.CIRCLE_PROGRESS_DIALOG);
            }
        });
    }

    public void showCircleProgressDialogWithText(final OnBackPressedCallback onBackPressedCallback, final String str) {
        this.mUIThreadHandler.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.DialogHelper.15
            @Override // java.lang.Runnable
            public void run() {
                if (!DialogHelper.this.mViewParams.getAbsFragment().isAdded()) {
                    MainLogger.m7255e(DialogHelper.TAG, "showCircleProgressDialog# fragment is not added");
                    return;
                }
                FragmentManager childFragmentManager = DialogHelper.this.mViewParams.getAbsFragment().getChildFragmentManager();
                DialogFragment dialogFragment = (DialogFragment) childFragmentManager.findFragmentByTag(NotesConstants.DialogTag.CIRCLE_PROGRESS_DIALOG);
                if (dialogFragment != null && dialogFragment.isAdded()) {
                    MainLogger.m7258i(DialogHelper.TAG, "showCircleProgressDialog# is already added");
                    return;
                }
                MainLogger.m7258i(DialogHelper.TAG, "showCircleProgressDialog");
                DialogFragment dialogFragmentCreateCircleProgressDialogFragment = DialogUtils.createCircleProgressDialogFragment(onBackPressedCallback, str);
                dialogFragmentCreateCircleProgressDialogFragment.setCancelable(false);
                dialogFragmentCreateCircleProgressDialogFragment.show(childFragmentManager, NotesConstants.DialogTag.CIRCLE_PROGRESS_DIALOG);
            }
        });
    }

    public void showCoeditDeleteNotesDialog(int i, int i2) {
        this.mDialogCreator.createCoeditNoteDeleteDialogFragment(i, C8003R.id.action_delete, this.mDeleteCoeditDialogListener, i2).show(this.mViewParams.getAbsFragment().getChildFragmentManager(), NotesConstants.DialogTag.DELETE_COEDIT_NOTE_DIALOG);
    }

    public void showConvertConfirmDialog(List<String> list, boolean z, boolean z2, boolean z3, int i) {
        this.mDialogCreator.createConvertConfirmDialogFragment(list, z, z2, z3, i, this.mConvertConfirmDialogListener).show(this.mViewParams.getAbsFragment().getChildFragmentManager(), NotesConstants.DialogTag.CONVERT_DIALOG);
    }

    public void showDeleteDialog(int i, int i2, int i4, int i5, int i6, int i7, boolean z, int i8, boolean z2) {
        DialogFragment dialogFragment = (DialogFragment) this.mViewParams.getAbsFragment().getChildFragmentManager().findFragmentByTag(NotesConstants.DialogTag.DELETE_DIALOG);
        if (dialogFragment == null || !dialogFragment.isAdded()) {
            showDeleteDialog(i, i2, i4, i5, i6, i7, z, i8, z2, false);
        } else {
            MainLogger.m7258i(TAG, "deleteDialog# is already added");
        }
    }

    public void showDeleteGcsSpaceDialog(int i, int i2, int i4, int i5, int i6, int i7, boolean z, int i8) {
        showDeleteGcsSpaceDialog(i, i2, i4, i5, i6, i7, z, i8, false);
    }

    public void showExportPdfDialog() {
        this.mUIThreadHandler.post(new RunnableC8496b(this, 3));
    }

    public void showFolderPickerDialog() {
        FolderPickerDialog folderPickerDialog = new FolderPickerDialog(false);
        folderPickerDialog.setAnchorViewId(C8003R.id.action_move);
        folderPickerDialog.setHighlightFolderUuid(this.mStateInfo.getFolderUuid());
        folderPickerDialog.setPickerDialogListener(this.mPickerDialogListener);
        folderPickerDialog.setPickerDialogData(this.mNotesModel.getCheckedFoldersUUID(), this.mNotesModel.getCheckedNotesCount(), this.mNotesModel.getCheckedFoldersCount());
        if (folderPickerDialog.isAdded()) {
            return;
        }
        folderPickerDialog.show(this.mViewParams.getAbsFragment().getChildFragmentManager(), "FolderPickerDialog");
    }

    public void showFolderRenameDialog() {
        String str;
        NotesFolder folderData;
        NotesFolder parent;
        ArrayList<String> checkedFoldersUUID = this.mNotesModel.getCheckedFoldersUUID();
        if (checkedFoldersUUID == null || checkedFoldersUUID.isEmpty() || (folderData = this.mDocumentMap.getFolderData((str = checkedFoldersUUID.get(0)))) == null || (parent = folderData.getParent()) == null) {
            return;
        }
        FolderNameDialog folderNameDialog = new FolderNameDialog(parent.getUuid(), str, folderData.getDisplayName(), 2, DataManager.getInstance().getFoldersDisplayName(parent.getUuid(), null), folderData.getDisplayNameColor());
        folderNameDialog.setAnchorViewId(C8003R.id.action_rename);
        folderNameDialog.setEditDialogResultListener(this.mEditDialogResultListener);
        folderNameDialog.show(this.mViewParams.getAbsFragment().getChildFragmentManager(), FolderConstants.DialogTag.FOLDER_NAME);
    }

    public void showImportMultiPdfDialog(String str, int i, List<Uri> list, ImportMultiplePdfDialogFragment.Contract contract) {
        ImportMultiplePdfDialogFragment importMultiplePdfDialogFragment = new ImportMultiplePdfDialogFragment(str, i, list);
        importMultiplePdfDialogFragment.setContract(contract);
        importMultiplePdfDialogFragment.show(this.mViewParams.getAbsFragment().getChildFragmentManager(), ImportMultiplePdfDialogFragment.TAG);
    }

    public void showMeridianDialog(MeridianDialogFragment.DialogListener dialogListener) {
        MeridianDialogFragment meridianDialogFragment = new MeridianDialogFragment();
        meridianDialogFragment.setDialogListener(dialogListener);
        meridianDialogFragment.show(this.mViewParams.getAbsFragment().getChildFragmentManager(), NotesConstants.DialogTag.MERIDIAN_DIALOG);
    }

    public void showProcessProgressDialog() {
        if (!this.mViewParams.getAbsFragment().isAdded()) {
            MainLogger.m7255e(TAG, "showProcessProgressDialog# fragment is not added");
            return;
        }
        DialogFragment dialogFragment = (DialogFragment) this.mViewParams.getAbsFragment().getChildFragmentManager().findFragmentByTag(NotesConstants.DialogTag.PROCESS_PROGRESS_DIALOG);
        if (dialogFragment != null && dialogFragment.isResumed() && dialogFragment.isAdded()) {
            MainLogger.m7258i(TAG, "showProcessProgressDialog# already showing");
            return;
        }
        MainLogger.m7258i(TAG, "showProcessProgressDialog");
        DialogFragment dialogFragmentCreateProgressDialogFragment = DialogUtils.createProgressDialogFragment();
        dialogFragmentCreateProgressDialogFragment.setCancelable(false);
        dialogFragmentCreateProgressDialogFragment.show(this.mViewParams.getAbsFragment().getChildFragmentManager(), NotesConstants.DialogTag.PROCESS_PROGRESS_DIALOG);
    }

    public void showRestoreCheckMobileDataDialog(String str) {
        RestoreCheckMobileDataDialogFragment restoreCheckMobileDataDialogFragment = new RestoreCheckMobileDataDialogFragment(str);
        restoreCheckMobileDataDialogFragment.setDialogListener(this.mRestoreCheckMobileDataDialogListener);
        restoreCheckMobileDataDialogFragment.show(this.mViewParams.getAbsFragment().getChildFragmentManager(), NotesConstants.DialogTag.RESTORE_CHECK_MOBILE_DATA_DIALOG);
    }

    public void showRestoreConfirmDialog(String str) {
        C14477a c14477aM15065b = C14477a.m15065b();
        C845027 c845027 = new C845027(str);
        c14477aM15065b.getClass();
        C14477a.m15067f(str, c845027);
    }

    public void showSamsungAccountLoginForMsSyncDialog() {
        SettingsConfirmDialogFragment settingsConfirmDialogFragment = new SettingsConfirmDialogFragment(3);
        settingsConfirmDialogFragment.setDialogListener(this.mSignInAndTurnOnSCloudSyncForMsSyncDialogListener);
        settingsConfirmDialogFragment.showAllowingStateLoss(this.mViewParams.getAbsFragment().getChildFragmentManager(), NotesConstants.DialogTag.SIGN_IN_AND_TURN_ON_SCLOUD_SYNC_DIALOG);
    }

    public void showSaveAsProgressDialog() {
        this.mUIThreadHandler.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.DialogHelper.18
            @Override // java.lang.Runnable
            public void run() {
                if (!DialogHelper.this.mViewParams.getAbsFragment().isAdded()) {
                    MainLogger.m7255e(DialogHelper.TAG, "showSaveAsProgressDialog# fragment is not added");
                } else {
                    MainLogger.m7254d(DialogHelper.TAG, "showSaveAsProgressDialog#");
                    DialogHelper.this.mDialogCreator.showSaveAsProgressDialog(DialogHelper.this.mViewParams.getAbsFragment().getChildFragmentManager());
                }
            }
        });
    }

    public void showSaveToDeviceDialog() {
        this.mUIThreadHandler.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.DialogHelper.23
            @Override // java.lang.Runnable
            public void run() {
                if (!DialogHelper.this.mViewParams.getAbsFragment().isAdded()) {
                    MainLogger.m7255e(DialogHelper.TAG, "showSaveToDeviceDialog# fragment is not added");
                    return;
                }
                FragmentManager childFragmentManager = DialogHelper.this.mViewParams.getAbsFragment().getChildFragmentManager();
                DialogFragment dialogFragment = (DialogFragment) childFragmentManager.findFragmentByTag(NotesConstants.DialogTag.SAVE_TO_DEVICE_DIALOG);
                if (dialogFragment != null) {
                    MainLogger.m7254d(DialogHelper.TAG, "showSaveToDeviceDialog# SAVE_TO_DEVICE_DIALOG already showing");
                    dialogFragment.dismissAllowingStateLoss();
                }
                DialogUtils.createProgressDialogFragment().show(childFragmentManager, NotesConstants.DialogTag.SAVE_TO_DEVICE_DIALOG);
            }
        });
    }

    public void showSortByDialog(int i, int i2) {
        this.mDialogCreator.createSortByDialogFragment(i, i2).show(this.mViewParams.getAbsFragment().getChildFragmentManager(), NotesConstants.DialogTag.SORTBY_DIALOG);
    }

    public void showSortTypeDialog() {
        FragmentActivity activity = this.mViewParams.getAbsFragment().getActivity();
        if (CommonUtil.isNotAvailableActivity(activity)) {
            MainLogger.m7258i(TAG, "showSortTypeDialog - activity is invalid");
            return;
        }
        PopupMenu popupMenu = new PopupMenu(getContextThemeWrapper(), activity.findViewById(C8003R.id.sortby_layout), 48);
        popupMenu.getMenuInflater().inflate(C8003R.menu.sort_type_popup_menu, popupMenu.getMenu());
        Menu menu = popupMenu.getMenu();
        int sortType = NotesUtils.getSortType();
        if (sortType == 0) {
            menu.findItem(C8003R.id.sortby_title).setChecked(true);
        } else if (sortType == 1) {
            menu.findItem(C8003R.id.sortby_date_created).setChecked(true);
        } else {
            if (sortType != 2) {
                MainLogger.m7255e(TAG, "showSortTypeDialog# unexpected sortType: " + sortType);
                return;
            }
            menu.findItem(C8003R.id.sortby_date_modified).setChecked(true);
        }
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.DialogHelper.13
            @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
            public boolean onMenuItemClick(MenuItem menuItem) {
                if (menuItem.isChecked()) {
                    menuItem.setChecked(false);
                } else {
                    menuItem.setChecked(true);
                    DialogHelper.this.sortTypePopupMenuSALogging(menuItem.getItemId());
                }
                int sortTypeFromSortTypePopupMenuOrder = DialogHelper.this.getSortTypeFromSortTypePopupMenuOrder(menuItem.getOrder());
                if (sortTypeFromSortTypePopupMenuOrder != NotesUtils.getSortType()) {
                    NotesUtils.setSortType(sortTypeFromSortTypePopupMenuOrder);
                }
                return false;
            }
        });
        popupMenu.show();
    }

    public void showViewByPopupMenu() {
        FragmentActivity activity = this.mViewParams.getAbsFragment().getActivity();
        if (CommonUtil.isNotAvailableActivity(activity)) {
            MainLogger.m7258i(TAG, "showViewByPopupMenu# activity is invalid");
            return;
        }
        PopupMenu popupMenu = new PopupMenu(getContextThemeWrapper(), activity.findViewById(C8003R.id.sesl_action_bar_overflow_button), 8388613);
        popupMenu.getMenuInflater().inflate(C8003R.menu.viewby_popup_menu, popupMenu.getMenu());
        Menu menu = popupMenu.getMenu();
        final int viewMode = ContentUtils.getViewMode();
        if (viewMode == 1) {
            menu.findItem(C8003R.id.viewby_list).setChecked(true);
        } else if (viewMode == 2) {
            menu.findItem(C8003R.id.viewby_grid_large).setChecked(true);
        } else if (viewMode == 3) {
            menu.findItem(C8003R.id.viewby_simple).setChecked(true);
        } else if (viewMode != 4) {
            if (viewMode != 6) {
                MainLogger.m7255e(TAG, "showViewByPopupMenu# unexpected viewMode: " + viewMode);
                return;
            }
            menu.findItem(C8003R.id.viewby_simple).setChecked(true);
        } else {
            menu.findItem(C8003R.id.viewby_grid_small).setChecked(true);
        }
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.DialogHelper.12
            @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
            public boolean onMenuItemClick(MenuItem menuItem) {
                if (menuItem.isChecked()) {
                    menuItem.setChecked(false);
                } else {
                    menuItem.setChecked(true);
                    DialogHelper.this.viewByPopupMenuSALogging(menuItem.getItemId());
                }
                int viewTypeFromViewByPopupMenuOrder = DialogHelper.this.getViewTypeFromViewByPopupMenuOrder(menuItem.getOrder());
                AbstractC8014b.m7212n(AbstractC0541b.m778t(viewTypeFromViewByPopupMenuOrder, "showViewByPopupMenu# onMenuItemClick select viewMode : ", ", current viewMode : "), DialogHelper.TAG, viewMode);
                if (viewTypeFromViewByPopupMenuOrder != viewMode) {
                    ContentUtils.setViewMode(viewTypeFromViewByPopupMenuOrder);
                }
                return false;
            }
        });
        popupMenu.show();
    }

    public void updateExportPdfDialogNoteName(final String str) {
        this.mUIThreadHandler.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.DialogHelper.24
            @Override // java.lang.Runnable
            public void run() {
                if (!DialogHelper.this.mViewParams.getAbsFragment().isAdded()) {
                    MainLogger.m7255e(DialogHelper.TAG, "updateExportPdfDialogNoteName# fragment is not added");
                } else {
                    MainLogger.m7254d(DialogHelper.TAG, "updateExportPdfDialogNoteName#");
                    DialogHelper.this.mDialogCreator.updateExportPdfDialogNoteName(DialogHelper.this.mViewParams.getAbsFragment().getChildFragmentManager(), str);
                }
            }
        });
    }

    public void updateExportPdfDialogProgress(final int i, final int i2) {
        this.mUIThreadHandler.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.DialogHelper.25
            @Override // java.lang.Runnable
            public void run() {
                if (!DialogHelper.this.mViewParams.getAbsFragment().isAdded()) {
                    MainLogger.m7255e(DialogHelper.TAG, "updateExportPdfDialogProgress# fragment is not added");
                    return;
                }
                MainLogger.m7254d(DialogHelper.TAG, "updateExportPdfDialogProgress# total: " + i + ", finished: " + i2);
                DialogHelper.this.mDialogCreator.updateExportPdfDialogProgress(DialogHelper.this.mViewParams.getAbsFragment().getChildFragmentManager(), i, i2);
            }
        });
    }

    public void showDeleteGcsSpaceDialog(int i, int i2, int i4, int i5, int i6, int i7, boolean z, int i8, boolean z2) {
        this.mDialogCreator.createDeleteDialogFragment(i, i2, i4, i5, i6, i7, z, C8003R.id.action_delete, this.mDeleteGcsDialogListener, i8, false, z2).show(this.mViewParams.getAbsFragment().getChildFragmentManager(), NotesConstants.DialogTag.DELETE_GCS_SPACE_DIALOG);
    }

    private void showDeleteDialog(int i, int i2, int i4, int i5, int i6, int i7, boolean z, int i8, boolean z2, boolean z3) {
        int i9 = C8003R.id.action_delete;
        if (this.mViewParams.getModeIndex() == 5) {
            i9 = C8003R.id.action_recyclebin_edit;
        }
        this.mDialogCreator.createDeleteDialogFragment(i, i2, i4, i5, i6, i7, z, i9, this.mDeleteDialogListener, i8, z2, z3).show(this.mViewParams.getAbsFragment().getChildFragmentManager(), NotesConstants.DialogTag.DELETE_DIALOG);
    }

    public void showAddFolderDialog(String str, String str2, String str3, int i) {
        if (this.mDocumentMap.getFolderDepth(str) >= 50) {
            ToastHandler.show(this.mViewParams.getContext(), this.mViewParams.getAbsFragment().getResources().getString(C8003R.string.add_subfolder_max_toast), 0);
            return;
        }
        FolderNameDialog folderNameDialog = new FolderNameDialog(str, str2, str3, 1, DataManager.getInstance().getFoldersDisplayName(str, null), i);
        folderNameDialog.setAnchorViewId(C8003R.id.action_more);
        folderNameDialog.setEditDialogResultListener(this.mEditDialogResultListener);
        folderNameDialog.show(this.mViewParams.getAbsFragment().getChildFragmentManager(), FolderConstants.DialogTag.FOLDER_NAME);
    }
}
