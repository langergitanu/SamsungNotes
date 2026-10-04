package com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.presenter.dialog;

import androidx.fragment.app.DialogFragment;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogContract;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public interface PwDialogContract {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IDialogCreator extends DialogContract.IDialogCreator {
        DialogFragment createSaveBackupDialogFragment();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IPwFragmentPresenterContainer extends DialogContract.IFragmentPresenterContainer {
        public static final int TYPE_SAVE_BACKUP = 500;
    }
}
