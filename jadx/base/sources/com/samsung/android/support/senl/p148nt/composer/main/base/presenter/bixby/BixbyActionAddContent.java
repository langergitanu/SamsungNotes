package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.bixby;

import android.content.Intent;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class BixbyActionAddContent extends BixbyAction {
    private final String TAG = Logger.createTag("BixbyActionAddContent");
    private final Intent mIntent;

    public BixbyActionAddContent(Intent intent) {
        this.mIntent = intent;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.bixby.BixbyAction
    public void execute(BixbyContract bixbyContract) {
        Logger.m11003i(this.TAG, "execute#");
        bixbyContract.executeActionSendTask(this.mIntent);
    }
}
