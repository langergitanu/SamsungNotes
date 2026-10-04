package com.samsung.android.support.senl.p148nt.app.main.noteslist.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.dialog.DialogViewContract;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.dialog.UnlockConfirmDialogHelper;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class DialogCreator implements DialogViewContract.IDialogCreator {
    private static final String TAG = "DialogCreator";

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.dialog.DialogViewContract.IDialogCreator
    public DialogFragment createCoeditNoteDeleteDialogFragment(int i, int i2, DialogViewContract.IDeleteDialog iDeleteDialog, int i4) {
        CoeditNoteDeleteDialogFragment coeditNoteDeleteDialogFragment = new CoeditNoteDeleteDialogFragment(i, i4);
        coeditNoteDeleteDialogFragment.setAnchorViewId(i2);
        coeditNoteDeleteDialogFragment.setContract(iDeleteDialog);
        return coeditNoteDeleteDialogFragment;
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.dialog.DialogViewContract.IDialogCreator
    public DialogFragment createConvertConfirmDialogFragment(List<String> list, boolean z, boolean z2, boolean z3, int i, DialogViewContract.IConvertDialog iConvertDialog) {
        ConvertConfirmDialogFragment convertConfirmDialogFragment = new ConvertConfirmDialogFragment(list, z, z2, z3, i);
        convertConfirmDialogFragment.setContract(iConvertDialog);
        return convertConfirmDialogFragment;
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.dialog.DialogViewContract.IDialogCreator
    public DialogFragment createDeleteDialogFragment(int i, int i2, int i4, int i5, int i6, int i7, boolean z, int i8, DialogViewContract.IDeleteDialog iDeleteDialog, int i9, boolean z2, boolean z3) {
        DeleteDialogFragment deleteDialogFragment = new DeleteDialogFragment(i, i2, i4, i5, i6, i7, z, i9, z2, z3);
        deleteDialogFragment.setAnchorViewId(i8);
        deleteDialogFragment.setContract(iDeleteDialog);
        return deleteDialogFragment;
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.dialog.DialogViewContract.IDialogCreator
    public DialogFragment createExportPdfDialogFragment(DialogViewContract.IExportPdfDialog iExportPdfDialog) {
        ExportPdfDialogFragment exportPdfDialogFragment = new ExportPdfDialogFragment();
        exportPdfDialogFragment.setContract(iExportPdfDialog);
        return exportPdfDialogFragment;
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.dialog.DialogViewContract.IDialogCreator
    public Dialog createMoveSFDialog(Context context, int i, View view, DialogViewContract.IMoveToSecureFolderDialog iMoveToSecureFolderDialog) {
        return new MoveToSecureFolderDialog(context, i, view, iMoveToSecureFolderDialog);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.dialog.DialogViewContract.IDialogCreator
    public DialogFragment createSortByDialogFragment(int i, int i2) {
        return new SortByDialogFragment(i, i2);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.dialog.DialogViewContract.IDialogCreator
    public Dialog createUnlockConfirmDialog(Context context, UnlockConfirmDialogHelper unlockConfirmDialogHelper, DialogViewContract.IUnlockConfirmDialog iUnlockConfirmDialog) {
        return new UnlockedConfirmDialog(context, unlockConfirmDialogHelper, iUnlockConfirmDialog);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.dialog.DialogViewContract.IDialogCreator
    public void setConvertConfirmDialogContract(ConvertConfirmDialogFragment convertConfirmDialogFragment, DialogViewContract.IConvertDialog iConvertDialog) {
        convertConfirmDialogFragment.setContract(iConvertDialog);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.dialog.DialogViewContract.IDialogCreator
    public void setDeleteDialogContract(DeleteDialogFragment deleteDialogFragment, DialogViewContract.IDeleteDialog iDeleteDialog) {
        deleteDialogFragment.setContract(iDeleteDialog);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.dialog.DialogViewContract.IDialogCreator
    public void setExportPdfDialogContract(ExportPdfDialogFragment exportPdfDialogFragment, DialogViewContract.IExportPdfDialog iExportPdfDialog) {
        exportPdfDialogFragment.setContract(iExportPdfDialog);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.dialog.DialogViewContract.IDialogCreator
    public void showSaveAsProgressDialog(FragmentManager fragmentManager) {
        try {
            new SaveAsProgressDialogFragment().showAllowingStateLoss(fragmentManager, NotesConstants.DialogTag.SAVE_AS_PROGRESS_DIALOG);
        } catch (IllegalStateException e) {
            MainLogger.m7255e(TAG, "showSaveAsProgressDialogFragment - IllegalStateException " + e.getMessage());
        }
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.dialog.DialogViewContract.IDialogCreator
    public void updateExportPdfDialogNoteName(@NonNull FragmentManager fragmentManager, String str) {
        ExportPdfDialogFragment exportPdfDialogFragment = (ExportPdfDialogFragment) fragmentManager.findFragmentByTag(NotesConstants.DialogTag.EXPORT_PDF_DIALOG);
        if (exportPdfDialogFragment != null) {
            exportPdfDialogFragment.updateExportingNoteName(str);
        }
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.dialog.DialogViewContract.IDialogCreator
    public void updateExportPdfDialogProgress(@NonNull FragmentManager fragmentManager, int i, int i2) {
        ExportPdfDialogFragment exportPdfDialogFragment = (ExportPdfDialogFragment) fragmentManager.findFragmentByTag(NotesConstants.DialogTag.EXPORT_PDF_DIALOG);
        if (exportPdfDialogFragment != null) {
            exportPdfDialogFragment.updateProgress(i, i2);
        }
    }
}
