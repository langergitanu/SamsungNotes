package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item;

import android.view.View;
import com.samsung.android.support.senl.p148nt.base.composer.text.span.SpanStates;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class RtMenuBullet extends RtMenuItem {
    public RtMenuBullet(View view) {
        super(view);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuItem
    public void onClicked() {
        super.onClicked();
        boolean z = !this.mView.isSelected();
        this.mPresenter.setTask(8, z);
        this.mView.setSelected(z);
        this.mPresenter.showSoftInput();
        ComposerSA.insertLog(ComposerSA.getScreenID(true, false, this.mPresenter.isTabletLayout()), ComposerSAConstants.EVENT_EDIT_BULLET_LIST, this.mView.isSelected() ? "1" : "0");
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuItem
    public void updateState(SpanStates spanStates) {
        boolean zIsEnable = spanStates.getTask().isEnable();
        this.mView.setSelected(zIsEnable && spanStates.getTask().getValue() == 8);
        this.mView.setAlpha(zIsEnable ? 1.0f : 0.3f);
        this.mView.setClickable(zIsEnable);
        this.mView.setEnabled(zIsEnable);
    }
}
