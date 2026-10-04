package com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.dialog.ConvertConfirmDialogFragment;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.dialog.DeleteDialogFragment;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.dialog.ExportPdfDialogFragment;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public interface DialogViewContract {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IConvertDialog {
        void onBackPressed();

        void onCancel();

        void onDelete(List<String> list, boolean z);

        void requestConvertOldNotes(List<String> list, boolean z);

        void requestMoveToConvertedNotes();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IDeleteDialog {
        void onBackPressed();

        void onCancel();

        void onConfirm(boolean z);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IDialogCreator {
        DialogFragment createCoeditNoteDeleteDialogFragment(int i, int i2, IDeleteDialog iDeleteDialog, int i4);

        DialogFragment createConvertConfirmDialogFragment(List<String> list, boolean z, boolean z2, boolean z3, int i, IConvertDialog iConvertDialog);

        DialogFragment createDeleteDialogFragment(int i, int i2, int i4, int i5, int i6, int i7, boolean z, int i8, IDeleteDialog iDeleteDialog, int i9, boolean z2, boolean z3);

        DialogFragment createExportPdfDialogFragment(IExportPdfDialog iExportPdfDialog);

        Dialog createMoveSFDialog(Context context, int i, View view, IMoveToSecureFolderDialog iMoveToSecureFolderDialog);

        DialogFragment createSortByDialogFragment(int i, int i2);

        Dialog createUnlockConfirmDialog(Context context, UnlockConfirmDialogHelper unlockConfirmDialogHelper, IUnlockConfirmDialog iUnlockConfirmDialog);

        void setConvertConfirmDialogContract(ConvertConfirmDialogFragment convertConfirmDialogFragment, IConvertDialog iConvertDialog);

        void setDeleteDialogContract(DeleteDialogFragment deleteDialogFragment, IDeleteDialog iDeleteDialog);

        void setExportPdfDialogContract(ExportPdfDialogFragment exportPdfDialogFragment, IExportPdfDialog iExportPdfDialog);

        void showSaveAsProgressDialog(FragmentManager fragmentManager);

        void updateExportPdfDialogNoteName(FragmentManager fragmentManager, String str);

        void updateExportPdfDialogProgress(FragmentManager fragmentManager, int i, int i2);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IDialogFragment {
        void dismissAllowingStateLoss();

        void replaceBtnToProgress();

        void show(FragmentManager fragmentManager, String str);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IExportPdfDialog {
        void cancelTask();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IMoveToSecureFolderDialog {
        void onConfirm();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IPasswordSetDialog {
        void setPassword();

        void startConvert();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IUnlockConfirmDialog {
        void unLock();
    }
}
