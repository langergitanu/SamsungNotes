package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog;

import android.app.Activity;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogContract;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public abstract class RenameDialogCommonPresenter extends AbsDialogFragmentPresenter {
    public DialogContract.IDialogCreator mCreator;

    public RenameDialogCommonPresenter(DialogContract.IDialogCreator iDialogCreator) {
        this.mCreator = iDialogCreator;
    }

    public boolean allowableDefaultName() {
        return false;
    }

    public abstract void dismiss(View view);

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.AbsDialogFragmentPresenter
    public DialogFragment findFragmentByTag(Activity activity) {
        return findFragmentByTag(activity, getTag());
    }

    public abstract String getDefaultName();

    public abstract String getTag();

    public abstract boolean isExistName(String str);

    public abstract void setNewName(String str);
}
