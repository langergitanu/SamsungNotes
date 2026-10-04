package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.directwrite.item;

import android.view.View;
import com.samsung.android.support.senl.p148nt.base.composer.common.BaseComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.HWToolbarSAConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DwMenuSpace extends DwMenuItem {
    public DwMenuSpace(View view) {
        super(view);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.directwrite.item.DwMenuItem
    public void onClicked() {
        this.mPresenter.requestDirectWritingActionSpace();
        ComposerSA.insertLog(BaseComposerSAConstants.SCREEN_NONE, HWToolbarSAConstants.EVENT_HW_STT_SPACE);
    }
}
