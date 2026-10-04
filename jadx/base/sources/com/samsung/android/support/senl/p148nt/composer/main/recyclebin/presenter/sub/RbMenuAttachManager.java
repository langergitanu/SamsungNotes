package com.samsung.android.support.senl.p148nt.composer.main.recyclebin.presenter.sub;

import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub.BaseSubManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub.ComposerSubContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub.MenuAttachManager;
import com.samsung.android.support.senl.p148nt.composer.main.recyclebin.model.RecycleBinModel;
import com.samsung.android.support.senl.p148nt.composer.main.recyclebin.presenter.RecycleBinContract;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class RbMenuAttachManager extends MenuAttachManager {
    public RbMenuAttachManager(BaseSubManager baseSubManager) {
        super(baseSubManager);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub.MenuAttachManager
    public void attachViews() {
        super.attachViews();
        ComposerSubContract.IView iView = this.mView;
        if (iView instanceof RecycleBinContract.IView) {
            ((RecycleBinContract.IView) iView).attachDueDateView(((RecycleBinModel) this.mSubManager.getComposerModel()).getRecycleBinTimeMoved(), this.mSubManager.getCompViewPresenter().getBackgroundColor(), this.mSubManager.getCompViewPresenter().isBackgroundColorInverted(), this.mSubManager.getCompViewPresenter().hasBackgroundImage());
        }
    }
}
