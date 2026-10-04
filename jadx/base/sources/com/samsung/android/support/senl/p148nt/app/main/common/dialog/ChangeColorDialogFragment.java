package com.samsung.android.support.senl.p148nt.app.main.common.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.main.common.dialog.FolderMarkColorPalette;
import com.samsung.android.support.senl.p148nt.base.winset.app.dialog.IEditDialogResult;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.base.winset.view.AbsDialogFragment;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class ChangeColorDialogFragment extends AbsDialogFragment {
    protected AlertDialog mAlertDialog;
    private IColorConfirmDialogResult mColorConfirmDialogResult;
    private ArrayList<String> mFolderUuidList;
    private int mSelectedColor;

    public ChangeColorDialogFragment() {
        this.mFolderUuidList = new ArrayList<>();
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        super.onCreateDialog(bundle);
        if (bundle != null) {
            this.mSelectedColor = bundle.getInt(NotesConstants.DialogTag.KEY_SELECTED_COLOR);
            this.mFolderUuidList = bundle.getStringArrayList(NotesConstants.DialogTag.KEY_SELECTED_UUID_LIST);
        }
        View viewInflate = LayoutInflater.from(getContext()).inflate(C8003R.layout.change_color_dialog, (ViewGroup) null);
        if (this.mFolderUuidList != null) {
            new FolderMarkColorPalette(getContext(), viewInflate, this.mSelectedColor, this.mFolderUuidList.size() != 1).setOnColorChangeListener(new FolderMarkColorPalette.OnColorChangeListener() { // from class: com.samsung.android.support.senl.nt.app.main.common.dialog.ChangeColorDialogFragment.1
                @Override // com.samsung.android.support.senl.nt.app.main.common.dialog.FolderMarkColorPalette.OnColorChangeListener
                public void onColorChanged(int i) {
                    ChangeColorDialogFragment.this.mSelectedColor = i;
                    if (ChangeColorDialogFragment.this.mColorConfirmDialogResult != null) {
                        ChangeColorDialogFragment.this.mColorConfirmDialogResult.onConfirm(ChangeColorDialogFragment.this.mFolderUuidList, ChangeColorDialogFragment.this.mSelectedColor);
                    }
                    ChangeColorDialogFragment.this.dismiss();
                }
            });
        }
        AlertDialog alertDialogCreate = new AlertDialogBuilderForAppCompat(getActivity()).create();
        this.mAlertDialog = alertDialogCreate;
        alertDialogCreate.setView(viewInflate);
        this.mAlertDialog.setCancelable(false);
        this.mAlertDialog.setButton(-2, getString(C8003R.string.dialog_cancel), (DialogInterface.OnClickListener) null);
        this.mAlertDialog.setCanceledOnTouchOutside(true);
        this.mAlertDialog.setTitle(getContext().getResources().getString(C8003R.string.change_folder_color));
        this.mAlertDialog.getWindow().setSoftInputMode(21);
        return this.mAlertDialog;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NonNull DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (this.mColorConfirmDialogResult == null && (getParentFragment() instanceof IEditDialogResult)) {
            ((IEditDialogResult) getParentFragment()).onEditDialogDismiss();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.AbsDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(NotesConstants.DialogTag.KEY_SELECTED_COLOR, this.mSelectedColor);
        bundle.putStringArrayList(NotesConstants.DialogTag.KEY_SELECTED_UUID_LIST, this.mFolderUuidList);
    }

    public void setColorConfirmDialogResultListener(IColorConfirmDialogResult iColorConfirmDialogResult) {
        this.mColorConfirmDialogResult = iColorConfirmDialogResult;
    }

    public ChangeColorDialogFragment(ArrayList<String> arrayList, int i) {
        new ArrayList();
        this.mFolderUuidList = arrayList;
        this.mSelectedColor = i;
    }
}
