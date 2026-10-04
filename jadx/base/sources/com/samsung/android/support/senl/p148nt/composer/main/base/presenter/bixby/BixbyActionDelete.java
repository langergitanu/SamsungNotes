package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.bixby;

import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class BixbyActionDelete extends BixbyAction {
    private static final String TAG = Logger.createTag("BixbyActionDelete");

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.bixby.BixbyAction
    public void execute(BixbyContract bixbyContract) {
        Logger.m10999d(TAG, "execute#");
        bixbyContract.getMenuManager().getOptionMenuPresenter().onClickDeleteBtn(true);
    }
}
