package com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.helper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.PermissionCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p145cm.base.framework.view.InputMethodCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.app.common.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.app.common.util.FeatureUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.ViewModeUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask;
import com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTaskManager;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.NotesModel;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.checkdata.CheckedNoteInfo;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.dialog.SaveAsRenameFileDialogFragment;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.dialog.SaveAsRenameFileDialogPresenter;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.params.ViewParams;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.task.ShareDialogTask;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.task.ShareTask;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.popupmenu.ExportShareTypeMenu;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.util.ContentPickerUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionHelper;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.base.winset.util.AnchorViewUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.share.ShareData;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.share.ShareUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.SaveAsRenameDialogPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskMakePdf;
import com.samsung.android.support.senl.p148nt.composer.main.base.widget.share.AbsPopupMenu;
import com.samsung.android.support.senl.p148nt.composer.main.base.widget.share.PdfExportOptionMenu;
import com.samsung.android.support.senl.p148nt.composer.main.base.widget.share.WordTypeMenu;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class ExportHelper {
    private static final String KEY_EXPORT_SHARE_TYPE_MENU_FOR_SAVE_AS = "key_is_export_share_type_menu_for_save_as";
    private static final String KEY_NOTE_LIST_FOR_EXPORT_SHARE_TYPE_MENU = "key_note_list_for_export_share_type_menu";
    private ExportShareTypeMenu mExportShareTypeMenu;
    private final IPresenter mIPresenter;
    private boolean mIsExportShareTypeMenuForSaveAs;
    private ArrayList<CheckedNoteInfo> mNoteListForExportShareTypeMenu;
    private final NotesModel mNotesModel;
    private Runnable mPendingShareDialogTaskRunnable;
    private SaveAsRenameFileDialogPresenter mSaveAsRenameDialogPresenter;
    private final ViewParams mViewParams;
    private static final String TAG = "ExportHelper";
    public static final Executor SINGLE_THREAD_EXECUTOR = AbstractC4539a.m3201k(TAG);
    private final ShareDialogTask.TaskResultListener mShareDialogTaskListener = new ShareDialogTask.TaskResultListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.ExportHelper.1
        @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.task.ShareDialogTask.TaskResultListener
        public void executeExportTask(ArrayList<CheckedNoteInfo> arrayList, int i, boolean z) {
            ExportHelper.this.callExportMethod(arrayList, i, z);
        }

        @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.task.ShareDialogTask.TaskResultListener
        public void removeCircleProgressDialog() {
            ExportHelper.this.mIPresenter.removeCircleProgressDialog();
        }

        @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.task.ShareDialogTask.TaskResultListener
        public void removeProcessProgressDialog() {
            ExportHelper.this.mIPresenter.removeProcessProgressDialog();
        }

        @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.task.ShareDialogTask.TaskResultListener
        public void showCircleProgressDialog() {
            ExportHelper.this.mIPresenter.showCircleProgressDialog();
        }

        @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.task.ShareDialogTask.TaskResultListener
        public void showPdfExportOptionPopup(ArrayList<CheckedNoteInfo> arrayList, int i, boolean z) {
            ExportHelper.this.showPdfExportOptionPopup(arrayList, i, z);
        }

        @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.task.ShareDialogTask.TaskResultListener
        public void showProcessProgressDialog() {
            ExportHelper.this.mIPresenter.showProcessProgressDialog();
        }

        @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.task.ShareDialogTask.TaskResultListener
        public void showToast(final Context context, final int i, final int i2) {
            ViewModeUtils.runOnUiThread(ExportHelper.this.mViewParams.getAbsFragment().getActivity(), new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.ExportHelper.1.1
                @Override // java.lang.Runnable
                public void run() {
                    ToastHandler.show(context, i, i2);
                }
            });
        }

        @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.task.ShareDialogTask.TaskResultListener
        public void showWordExportOptionPopup(ArrayList<CheckedNoteInfo> arrayList, int i, boolean z) {
            ExportHelper.this.showWordExportOptionPopup(arrayList, i, z);
        }
    };
    private final ShareTask.Contract mShareTaskContract = new ShareTask.Contract() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.ExportHelper.2
        @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.task.ShareTask.Contract
        public void removeCircleProgressDialog() {
            ExportHelper.this.mIPresenter.removeCircleProgressDialog();
        }

        @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.task.ShareTask.Contract
        public void removeExportPdfDialog() {
            ExportHelper.this.mIPresenter.removeExportPdfDialog();
        }

        @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.task.ShareTask.Contract
        public void removeSaveAsProgressDialog() {
            ExportHelper.this.mIPresenter.removeSaveAsProgressDialog();
        }

        @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.task.ShareTask.Contract
        public void showCircleProgressDialog() {
            ExportHelper.this.mIPresenter.showCircleProgressDialog();
        }

        @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.task.ShareTask.Contract
        public void showExportPdfDialog() {
            ExportHelper.this.mIPresenter.showExportPdfDialog();
        }

        @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.task.ShareTask.Contract
        public void showSaveAsProgressDialog() {
            ExportHelper.this.mIPresenter.showSaveAsProgressDialog();
        }

        @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.task.ShareTask.Contract
        public void updateExportPdfDialogNoteName(String str) {
            ExportHelper.this.mIPresenter.updateExportPdfDialogNoteName(str);
        }

        @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.task.ShareTask.Contract
        public void updateExportPdfDialogProgress(int i, int i2) {
            ExportHelper.this.mIPresenter.updateExportPdfDialogProgress(i, i2);
        }
    };
    private final SaveAsRenameDialogPresenter.OnClickListener mSaveAsRenameDialogClickListener = new SaveAsRenameDialogPresenter.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.ExportHelper.3
        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.SaveAsRenameDialogPresenter.OnClickListener
        public void dismiss(View view) {
            ExportHelper.this.getSaveAsRenameDialogPresenter().onDetachView();
            ExportHelper.this.mSaveAsRenameDialogPresenter = null;
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.SaveAsRenameDialogPresenter.OnClickListener
        public void onClick(String str) {
            InputMethodCompat.getInstance().forceHideSoftInput(ExportHelper.this.mViewParams.getContext());
            ExportHelper exportHelper = ExportHelper.this;
            exportHelper.executeSaveAsTask(exportHelper.getSaveAsRenameDialogPresenter().getExportStorageDir(), str);
        }
    };

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IPresenter {
        void clearCheckedData();

        void removeCircleProgressDialog();

        void removeExportPdfDialog();

        void removeProcessProgressDialog();

        void removeSaveAsProgressDialog();

        void showCircleProgressDialog();

        void showExportPdfDialog();

        void showProcessProgressDialog();

        void showSaveAsProgressDialog();

        void updateExportPdfDialogNoteName(String str);

        void updateExportPdfDialogProgress(int i, int i2);
    }

    public ExportHelper(ViewParams viewParams, NotesModel notesModel, IPresenter iPresenter) {
        this.mViewParams = viewParams;
        this.mNotesModel = notesModel;
        this.mIPresenter = iPresenter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callExportMethod(ArrayList<CheckedNoteInfo> arrayList, int i, boolean z) {
        if (!z) {
            executeShareTask(arrayList, i);
            return;
        }
        setSaveExportNoteList(arrayList, i);
        if (PermissionCompat.FEATURE_ENABLED_MANAGE_EXTERNAL_STORAGE) {
            ContentPickerUtils.startSaveDirectoryPickerActivityForResult(this.mViewParams.getAbsFragment(), 307, 9);
            return;
        }
        File saveAsFixedDir = ShareUtils.getSaveAsFixedDir(this.mViewParams.getContext());
        if (saveAsFixedDir == null || !saveAsFixedDir.exists()) {
            return;
        }
        String absolutePath = saveAsFixedDir.getAbsolutePath();
        AbstractC0000a.m25v("callExportMethod# save to fixed path : ", absolutePath, TAG);
        executeSaveAsTask(absolutePath, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeShareDialogTask(ArrayList<CheckedNoteInfo> arrayList, int i, boolean z) {
        FragmentActivity activity = this.mViewParams.getAbsFragment().getActivity();
        if (CommonUtil.isNotAvailableActivity(activity)) {
            return;
        }
        ShareDialogTask shareDialogTask = new ShareDialogTask(activity, i, z, this.mShareDialogTaskListener);
        WorkerTaskManager.getInstance().addTask(shareDialogTask);
        shareDialogTask.run(arrayList);
    }

    @Nullable
    private View getAnchorView(@NonNull View view, boolean z) {
        View viewFindViewById = z ? view.findViewById(C8003R.id.action_save_as_file) : view.findViewById(C8003R.id.action_share);
        return viewFindViewById == null ? view.findViewById(C8003R.id.bottom_overflow) : viewFindViewById;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public View getShareDialogAnchorView(boolean z) {
        FragmentActivity activity = this.mViewParams.getAbsFragment().getActivity();
        if (CommonUtil.isNotAvailableActivity(activity)) {
            MainLogger.m7255e(TAG, "getShareDialogAnchorView# activity is invalid");
            return null;
        }
        if (!FeatureUtils.isEditMode(this.mViewParams.getModeIndex())) {
            return AnchorViewUtils.getAnchorView((ViewGroup) this.mViewParams.getAbsFragment().getView());
        }
        View viewFindViewById = activity.findViewById(C8003R.id.inflate_bottom_navigation);
        if (viewFindViewById != null) {
            return getAnchorView(viewFindViewById, z);
        }
        return null;
    }

    private String getTitle(Activity activity, boolean z) {
        return activity.getString(z ? C8003R.string.composer_save_as_file_title : C8003R.string.composer_share_title);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean needToCheckSharePermissionForChina() {
        if (!ShareUtils.isNotSupportedFileProviderForChina()) {
            return false;
        }
        String[] storagePermissions = PermissionCompat.getStoragePermissions(4);
        if (PermissionHelper.isPermissionGrantedWithoutNotice(this.mViewParams.getAbsFragment().getActivity(), storagePermissions)) {
            return false;
        }
        MainLogger.m7258i(TAG, "needToCheckSharePermissionForChina# get WRITE_EXTERNAL_STORAGE permission");
        PermissionHelper.requestPermissions(this.mViewParams.getAbsFragment(), 108, storagePermissions);
        return true;
    }

    private void restoreExportShareTypeMenuInstanceState(Bundle bundle) {
        if (bundle != null && bundle.containsKey(KEY_NOTE_LIST_FOR_EXPORT_SHARE_TYPE_MENU) && bundle.containsKey(KEY_EXPORT_SHARE_TYPE_MENU_FOR_SAVE_AS)) {
            final ArrayList parcelableArrayList = bundle.getParcelableArrayList(KEY_NOTE_LIST_FOR_EXPORT_SHARE_TYPE_MENU);
            final boolean z = bundle.getBoolean(KEY_EXPORT_SHARE_TYPE_MENU_FOR_SAVE_AS);
            this.mViewParams.getNotesRecyclerView().post(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.ExportHelper.7
                @Override // java.lang.Runnable
                public void run() {
                    ExportHelper.this.showExportShareTypeMenu(parcelableArrayList, z);
                }
            });
        }
    }

    private void restoreSaveAsRenameDialog(Bundle bundle) {
        FragmentActivity activity = this.mViewParams.getAbsFragment().getActivity();
        if (CommonUtil.isNotAvailableActivity(activity)) {
            return;
        }
        SaveAsRenameFileDialogPresenter saveAsRenameDialogPresenter = getSaveAsRenameDialogPresenter();
        SaveAsRenameFileDialogFragment saveAsRenameFileDialogFragment = (SaveAsRenameFileDialogFragment) activity.getSupportFragmentManager().findFragmentByTag(saveAsRenameDialogPresenter.getTag());
        if (saveAsRenameFileDialogFragment != null) {
            saveAsRenameFileDialogFragment.setPresenter(saveAsRenameDialogPresenter);
            saveAsRenameDialogPresenter.onRestoreInstanceState(bundle, this.mSaveAsRenameDialogClickListener);
        }
    }

    private void restoreShareTask() {
        FragmentActivity activity = this.mViewParams.getAbsFragment().getActivity();
        if (CommonUtil.isNotAvailableActivity(activity)) {
            return;
        }
        WorkerTask<?> runningTask = WorkerTaskManager.getInstance().getRunningTask(ShareTask.TAG, activity.hashCode());
        if (runningTask instanceof ShareTask) {
            ((ShareTask) runningTask).setContract(this.mShareTaskContract);
        }
    }

    private void saveExportShareTypeMenuInstanceState(Bundle bundle) {
        if (this.mExportShareTypeMenu == null) {
            return;
        }
        bundle.putParcelableArrayList(KEY_NOTE_LIST_FOR_EXPORT_SHARE_TYPE_MENU, this.mNoteListForExportShareTypeMenu);
        bundle.putBoolean(KEY_EXPORT_SHARE_TYPE_MENU_FOR_SAVE_AS, this.mIsExportShareTypeMenuForSaveAs);
    }

    private void setSaveExportNoteList(ArrayList<CheckedNoteInfo> arrayList, int i) {
        this.mNotesModel.setSaveExportNoteList(arrayList);
        this.mNotesModel.setSaveExportType(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void shareDialogSALogging(int i, boolean z) {
        String str;
        if (i == 0) {
            str = "1";
        } else if (i == 1) {
            str = "2";
        } else if (i == 2) {
            str = "3";
        } else if (i == 3) {
            str = "4";
        } else if (i == 4) {
            str = "5";
        } else if (i != 5) {
            return;
        } else {
            str = "6";
        }
        CommonSamsungAnalytics.insertLog("737", z ? "7372" : "7371", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showPdfExportOptionPopup(final ArrayList<CheckedNoteInfo> arrayList, final int i, final boolean z) {
        View shareDialogAnchorView = getShareDialogAnchorView(true);
        if (shareDialogAnchorView == null) {
            MainLogger.m7255e(TAG, "showPdfExportOptionPopup# anchorView is null");
            return;
        }
        final PdfExportOptionMenu pdfExportOptionMenu = new PdfExportOptionMenu();
        pdfExportOptionMenu.setOnItemClickListener(new AbsPopupMenu.OnItemClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.ExportHelper.8
            @Override // com.samsung.android.support.senl.nt.composer.main.base.widget.share.AbsPopupMenu.OnItemClickListener
            public void onItemClick() {
                TaskMakePdf.PdfShareType shareType = pdfExportOptionMenu.getShareType();
                ExportHelper.this.mNotesModel.setExportPdfType(shareType.exportType);
                ExportHelper.this.callExportMethod(arrayList, i, z);
                if (shareType == TaskMakePdf.PdfShareType.NOTES_COMPAT) {
                    CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_MAIN_EDIT, NotesSAConstants.EVENT_PDF_EXPORT_FORMAT, "a");
                } else if (shareType == TaskMakePdf.PdfShareType.STANDARD) {
                    CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_MAIN_EDIT, NotesSAConstants.EVENT_PDF_EXPORT_FORMAT, "b");
                }
            }
        });
        pdfExportOptionMenu.setOnDismissListener(null);
        pdfExportOptionMenu.showPopupMenu(this.mViewParams.getAbsFragment().getActivity(), shareDialogAnchorView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showWordExportOptionPopup(final ArrayList<CheckedNoteInfo> arrayList, final int i, final boolean z) {
        FragmentActivity activity = this.mViewParams.getAbsFragment().getActivity();
        View shareDialogAnchorView = getShareDialogAnchorView(z);
        if (shareDialogAnchorView == null) {
            MainLogger.m7255e(TAG, "showWordExportOptionPopup# anchorView is null");
            return;
        }
        WordTypeMenu wordTypeMenu = new WordTypeMenu();
        wordTypeMenu.setOnItemClickListener(new AbsPopupMenu.OnItemClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.ExportHelper.9
            @Override // com.samsung.android.support.senl.nt.composer.main.base.widget.share.AbsPopupMenu.OnItemClickListener
            public void onItemClick() {
                ExportHelper.this.callExportMethod(arrayList, i, z);
            }
        });
        try {
            wordTypeMenu.showPopupMenu(activity, shareDialogAnchorView);
        } catch (RuntimeException e) {
            MainLogger.m7255e(TAG, "RuntimeException : " + e.getMessage());
        }
    }

    private void updateExportShareTypeMenu() {
        if (this.mExportShareTypeMenu == null) {
            return;
        }
        this.mViewParams.getNotesRecyclerView().post(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.ExportHelper.6
            @Override // java.lang.Runnable
            public void run() {
                if (ExportHelper.this.mExportShareTypeMenu == null) {
                    return;
                }
                ExportShareTypeMenu exportShareTypeMenu = ExportHelper.this.mExportShareTypeMenu;
                ExportHelper exportHelper = ExportHelper.this;
                exportShareTypeMenu.updatePopupMenu(exportHelper.getShareDialogAnchorView(exportHelper.mIsExportShareTypeMenuForSaveAs));
            }
        });
    }

    public void executeSaveAsTask(String str, String str2) {
        FragmentActivity activity = this.mViewParams.getAbsFragment().getActivity();
        if (CommonUtil.isNotAvailableActivity(activity)) {
            return;
        }
        ShareTask shareTask = new ShareTask(activity, str2, this.mNotesModel.getSaveExportType(), str, this.mNotesModel.getExportPdfType(), this.mShareTaskContract);
        WorkerTaskManager.getInstance().addTask(shareTask);
        shareTask.run(this.mNotesModel.getSaveExportNoteList());
    }

    public void executeShareTask(ArrayList<CheckedNoteInfo> arrayList, int i) {
        FragmentActivity activity = this.mViewParams.getAbsFragment().getActivity();
        if (CommonUtil.isNotAvailableActivity(activity)) {
            return;
        }
        ShareTask shareTask = new ShareTask(activity, null, i, null, this.mNotesModel.getExportPdfType(), this.mShareTaskContract);
        WorkerTaskManager.getInstance().addTask(shareTask);
        shareTask.run(arrayList);
    }

    public SaveAsRenameFileDialogPresenter getSaveAsRenameDialogPresenter() {
        if (this.mSaveAsRenameDialogPresenter == null) {
            this.mSaveAsRenameDialogPresenter = new SaveAsRenameFileDialogPresenter();
        }
        return this.mSaveAsRenameDialogPresenter;
    }

    public void onConfigurationChanged() {
        updateExportShareTypeMenu();
    }

    public void onRestoreInstanceState(Bundle bundle) {
        restoreShareTask();
        restoreSaveAsRenameDialog(bundle);
        restoreExportShareTypeMenuInstanceState(bundle);
    }

    public void onSaveInstanceState(Bundle bundle) {
        getSaveAsRenameDialogPresenter().onSaveInstanceState(bundle);
        saveExportShareTypeMenuInstanceState(bundle);
    }

    public void runPendingShareDialogTask() {
        Runnable runnable = this.mPendingShareDialogTaskRunnable;
        if (runnable == null) {
            return;
        }
        runnable.run();
        this.mPendingShareDialogTaskRunnable = null;
    }

    public void setShareDialogTaskResultListener(@NonNull ShareDialogTask shareDialogTask) {
        shareDialogTask.setTaskResultListener(this.mShareDialogTaskListener);
    }

    public void showExportShareTypeMenu(ArrayList<CheckedNoteInfo> arrayList, final boolean z) {
        if (arrayList == null) {
            MainLogger.m7255e(TAG, "showExportShareTypeMenu# sharableNoteList is null");
            return;
        }
        MainLogger.m7254d(TAG, "showExportShareTypeMenu# sharableNoteList size : " + arrayList.size());
        FragmentActivity activity = this.mViewParams.getAbsFragment().getActivity();
        if (CommonUtil.isNotAvailableActivity(activity)) {
            MainLogger.m7255e(TAG, "showExportShareTypeMenu# activity is invalid");
            return;
        }
        this.mNoteListForExportShareTypeMenu = arrayList;
        this.mIsExportShareTypeMenuForSaveAs = z;
        View shareDialogAnchorView = getShareDialogAnchorView(z);
        if (shareDialogAnchorView == null) {
            MainLogger.m7255e(TAG, "showExportShareTypeMenu# anchorView is null");
            return;
        }
        shareDialogAnchorView.clearFocus();
        ArrayList<CheckedNoteInfo> arrayList2 = this.mNoteListForExportShareTypeMenu;
        boolean z2 = false;
        if (arrayList2.size() == 1 && this.mIsExportShareTypeMenuForSaveAs && NotesUtils.isWarning(this.mNoteListForExportShareTypeMenu.get(0).getCorrupted())) {
            z2 = true;
        }
        ExportShareTypeMenu exportShareTypeMenu = new ExportShareTypeMenu(arrayList2, z2);
        this.mExportShareTypeMenu = exportShareTypeMenu;
        exportShareTypeMenu.setOnItemClickListener(new AbsPopupMenu.OnItemClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.ExportHelper.4
            @Override // com.samsung.android.support.senl.nt.composer.main.base.widget.share.AbsPopupMenu.OnItemClickListener
            public void onItemClick() {
                final int shareType = ExportHelper.this.mExportShareTypeMenu.getShareType();
                ExportHelper.this.shareDialogSALogging(shareType, z);
                if (ExportHelper.this.needToCheckSharePermissionForChina()) {
                    ExportHelper.this.mPendingShareDialogTaskRunnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.ExportHelper.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ExportHelper exportHelper = ExportHelper.this;
                            exportHelper.executeShareDialogTask(exportHelper.mNoteListForExportShareTypeMenu, shareType, z);
                        }
                    };
                } else {
                    ExportHelper exportHelper = ExportHelper.this;
                    exportHelper.executeShareDialogTask(exportHelper.mNoteListForExportShareTypeMenu, shareType, z);
                }
            }
        });
        this.mExportShareTypeMenu.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.ExportHelper.5
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (!FeatureUtils.isEditMode(ExportHelper.this.mViewParams.getModeIndex()) && !ExportHelper.this.mExportShareTypeMenu.isMenuClicked()) {
                    ExportHelper.this.mIPresenter.clearCheckedData();
                }
                ExportHelper.this.mExportShareTypeMenu = null;
            }
        });
        this.mExportShareTypeMenu.showPopupMenu(activity, shareDialogAnchorView, getTitle(activity, z));
    }

    public void showSaveExportRenameDialog(Intent intent, CheckedNoteInfo checkedNoteInfo, int i) {
        String pathFromResult = ContentPickerUtils.getPathFromResult(this.mViewParams.getContext(), intent);
        MainLogger.m7254d(TAG, "showSaveExportRenameDialog# Dir : " + MainLogger.getEncode(pathFromResult));
        SaveAsRenameFileDialogPresenter saveAsRenameDialogPresenter = getSaveAsRenameDialogPresenter();
        ShareData shareData = new ShareData(checkedNoteInfo.getFilePath(), checkedNoteInfo.getUuid(), checkedNoteInfo.getTitle(), checkedNoteInfo.getModifiedTime());
        saveAsRenameDialogPresenter.onAttachView(this.mViewParams.getAbsFragment().getActivity());
        saveAsRenameDialogPresenter.showRenameDialog(shareData, pathFromResult, ShareTask.INSTANCE.getExtension(i), this.mSaveAsRenameDialogClickListener);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void showShareTaskResultToast(ShareTask.Result result) {
        String quantityString;
        if ((1 != result.getShareType() && result.getIsShare()) || 7 == result.getShareType()) {
            return;
        }
        Resources resources = BaseUtils.getApplicationContext().getResources();
        int size = this.mNotesModel.getSaveExportNoteList().size();
        int exportedItemCount = result.getExportedItemCount();
        if (size != 0) {
            if (exportedItemCount <= 0) {
                quantityString = resources.getString(C8003R.string.save_as_file_failed);
                StringBuilder sb = new StringBuilder();
                sb.append(result.getTag());
                sb.append(result.getIsCancelled() ? ", isCancelled" : ", isFailed ");
                MainLogger.m7258i(TAG, sb.toString());
            } else if (result.getIsCancelled() && 1 == result.getShareType()) {
                quantityString = resources.getQuantityString(C8003R.plurals.export_pdf_cancel_result, exportedItemCount, Integer.valueOf(exportedItemCount));
            } else if (!result.getIsShare()) {
                if (size == 1 && exportedItemCount == 1) {
                    String string = resources.getString(C8003R.string.save_as_file_saved, result.getExportedFileName());
                    MainLogger.m7258i(TAG, result.getTag() + " message: " + MainLogger.getEncode(string));
                    ToastHandler.showEncodingLog(this.mViewParams.getContext(), string, 0);
                    return;
                }
                quantityString = resources.getQuantityString(DeviceUtils.isTabletModel() ? C8003R.plurals.plurals_save_as_tablet : C8003R.plurals.plurals_save_as_phone, exportedItemCount, Integer.valueOf(exportedItemCount));
            }
            MainLogger.m7258i(TAG, result.getTag() + " message: " + quantityString);
            if (quantityString.isEmpty()) {
                ToastHandler.show(this.mViewParams.getContext(), quantityString, 0);
                return;
            }
            return;
        }
        MainLogger.m7258i(TAG, result.getTag() + ", unexpected state, task can not be started saving item count is 0!");
        quantityString = "";
        MainLogger.m7258i(TAG, result.getTag() + " message: " + quantityString);
        if (quantityString.isEmpty()) {
        }
    }
}
