package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item;

import android.view.View;
import com.samsung.android.support.senl.p148nt.base.composer.text.span.SpanStates;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class RtMenuIndent extends RtMenuItem {
    public RtMenuIndent(View view) {
        super(view);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuItem
    public void onClicked() {
        super.onClicked();
        this.mPresenter.setIndent(true);
        this.mPresenter.showSoftInput();
        ComposerSA.insertLog(ComposerSA.getScreenID(true, false, this.mPresenter.isTabletLayout()), ComposerSAConstants.EVENT_EDIT_TEXT_INDENT);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuItem
    public void updateState(SpanStates spanStates) {
        boolean z = spanStates.indent.isEnable() && spanStates.getIndent().getValue() >= 0 && spanStates.getIndent().getValue() < spanStates.getIndent().getIndentMax();
        this.mView.setAlpha(z ? 1.0f : 0.3f);
        this.mView.setClickable(z);
        this.mView.setEnabled(z);
    }
}
