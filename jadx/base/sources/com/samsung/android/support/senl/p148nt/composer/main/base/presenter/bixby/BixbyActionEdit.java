package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.bixby;

import android.text.TextUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class BixbyActionEdit extends BixbyAction {
    private static final String TAG = Logger.createTag("BixbyActionEdit");
    private String mTitle;

    public BixbyActionEdit() {
    }

    private void setTitle(BixbyContract bixbyContract) {
        if (bixbyContract.getMenuManager().getTitleEditorPresenter().isEditable() && bixbyContract.getMenuManager().getTitleEditorPresenter().hasWritePermission() && !bixbyContract.getMenuManager().getTitleEditorPresenter().checkNoServerPermission()) {
            if (!bixbyContract.getModeManger().isEditModeWithReadOnly()) {
                bixbyContract.getModeManger().setMode(Mode.Text, "BixbyActionEdit", true);
            }
            bixbyContract.getMenuManager().getTitleEditorPresenter().setTitle(this.mTitle, true);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.bixby.BixbyAction
    public void execute(BixbyContract bixbyContract) {
        Logger.m10999d(TAG, "execute#");
        if (TextUtils.isEmpty(this.mTitle)) {
            bixbyContract.setEditModeFromBixby();
        } else {
            setTitle(bixbyContract);
        }
    }

    public BixbyActionEdit(String str) {
        this.mTitle = str;
    }
}
