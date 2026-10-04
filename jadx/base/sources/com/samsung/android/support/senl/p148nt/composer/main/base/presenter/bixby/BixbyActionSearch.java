package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.bixby;

import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class BixbyActionSearch extends BixbyAction {
    private static final String TAG = Logger.createTag("BixbyActionSearch");
    private final String mWords;

    public BixbyActionSearch(String str) {
        this.mWords = str;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.bixby.BixbyAction
    public void execute(BixbyContract bixbyContract) {
        Logger.m10999d(TAG, "execute# ");
        ModeManager modeManger = bixbyContract.getModeManger();
        Mode mode = Mode.Search;
        if (modeManger.isMode(mode)) {
            bixbyContract.getMenuManager().getSearchModePresenter().show(this.mWords);
        } else {
            modeManger.setMode(mode, "bixbySearch", true, this.mWords);
        }
    }
}
