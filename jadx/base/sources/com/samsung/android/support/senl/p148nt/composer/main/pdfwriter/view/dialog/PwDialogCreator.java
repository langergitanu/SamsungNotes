package com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.view.dialog;

import androidx.fragment.app.DialogFragment;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog.DialogCreator;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.presenter.dialog.PwDialogContract;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PwDialogCreator extends DialogCreator implements PwDialogContract.IDialogCreator {
    @Override // com.samsung.android.support.senl.nt.composer.main.pdfwriter.presenter.dialog.PwDialogContract.IDialogCreator
    public DialogFragment createSaveBackupDialogFragment() {
        return new SaveBackupDialogFragment();
    }
}
