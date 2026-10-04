package com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.helper;

import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.app.main.common.dialog.ImportMultiplePdfDialogFragment;
import com.samsung.android.support.senl.p148nt.app.main.common.task.PdfImportTask;
import com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTaskManager;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.NotesModel;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.params.ViewParams;
import com.samsung.android.support.senl.p148nt.base.common.sdk.util.SpenSdkInitializer;
import com.samsung.android.support.senl.p148nt.base.common.util.ContentPickerUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.StorageUtils;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.base.winset.util.DialogUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.AddPdfUtil;
import java.util.List;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class PdfImportHelper implements ImportMultiplePdfDialogFragment.Contract {
    private static final String TAG = "PdfImportHelper";
    private final NotesModel mNotesModel;
    private final IPresenter mPresenter;
    private final ViewParams mViewParams;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IPresenter {
        void restoreImportMultiPdfDialog(ImportMultiplePdfDialogFragment.Contract contract);

        void setToolType(int i);

        void showImportMultiPdfDialog(String str, int i, List<Uri> list, ImportMultiplePdfDialogFragment.Contract contract);
    }

    public PdfImportHelper(ViewParams viewParams, NotesModel notesModel, IPresenter iPresenter) {
        this.mViewParams = viewParams;
        this.mNotesModel = notesModel;
        this.mPresenter = iPresenter;
    }

    private void showImportMultiPdfDialog(String str, int i, List<Uri> list) {
        this.mPresenter.showImportMultiPdfDialog(str, i, list, this);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.common.dialog.ImportMultiplePdfDialogFragment.Contract
    public void importPdfOnOneNote(String str, int i, @NonNull List<Uri> list) {
        MainLogger.m7254d(TAG, "importPdfOnOneNote# pdf size : " + list.size());
        this.mViewParams.getNotesView().onImportPdf(str, i, list);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.common.dialog.ImportMultiplePdfDialogFragment.Contract
    public void importPdfOnSeparateNotes(String str, @NonNull List<Uri> list) {
        StringBuilder sbM15l = AbstractC0000a.m15l("importPdfOnSeparateNotes# folderUuid: ", str, ", pdf size : ");
        sbM15l.append(list.size());
        MainLogger.m7254d(TAG, sbM15l.toString());
        FragmentActivity activity = this.mViewParams.getAbsFragment().getActivity();
        if (CommonUtil.isNotAvailableActivity(activity)) {
            return;
        }
        SpenSdkInitializer.initialize(BaseUtils.getApplicationContext());
        PdfImportTask pdfImportTask = new PdfImportTask(activity, list);
        WorkerTaskManager.getInstance().addTask(pdfImportTask);
        pdfImportTask.run(new PdfImportTask.TaskParams(str));
    }

    public void onImportPdf(String str, int i, @NonNull List<Uri> list) {
        if (list.isEmpty()) {
            MainLogger.m7255e(TAG, "onImportPdf# pdfUris are empty");
        } else if (list.size() > 1) {
            showImportMultiPdfDialog(str, i, list);
        } else {
            importPdfOnOneNote(str, i, list);
        }
    }

    public void onRestoreInstanceState() {
        this.mPresenter.restoreImportMultiPdfDialog(this);
    }

    public boolean onSelectPdfOptionMenu(Fragment fragment) {
        if (fragment == null || fragment.getContext() == null) {
            return false;
        }
        if (!StorageUtils.isAvailableMemoryForNewMemo()) {
            MainLogger.m7254d(TAG, "onSelectPdfOptionMenu# not enough memory");
            DialogUtils.showNotEnoughStorageDialogFragment(fragment.getContext(), fragment.getChildFragmentManager());
            return false;
        }
        if (!ContentPickerUtils.canAddPdfFileMenu(fragment.getContext())) {
            MainLogger.m7254d(TAG, "onSelectPdfOptionMenu# cannot add pdf file");
            return false;
        }
        this.mNotesModel.setRequestCodeForOtherApp(2);
        ContentPickerUtils.startPdfPickerActivityForResult(fragment, 122, 2, true, new Runnable[0]);
        return true;
    }

    public void showPdfImportTaskResultToast(@NonNull PdfImportTask.Result result) {
        FragmentActivity activity = this.mViewParams.getAbsFragment().getActivity();
        if (CommonUtil.isNotAvailableActivity(activity)) {
            return;
        }
        boolean isCancelled = result.getIsCancelled();
        int successCount = result.getSuccessCount();
        MainLogger.m7254d(TAG, "isCancelled: " + isCancelled + " successCount: " + successCount);
        if (isCancelled) {
            ToastHandler.show(activity, activity.getResources().getQuantityString(C8003R.plurals.plurals_import_canceled_pd_pdfs_already_imported_toast_msg, successCount, Integer.valueOf(successCount)), 0);
        } else {
            AddPdfUtil.showErrorToast(activity, result.getErrorCode(), true);
        }
    }
}
