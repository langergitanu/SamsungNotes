package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item;

import android.view.View;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class RtMenuRedo extends RtMenuUndoRedo {
    private static final String TAG = Logger.createTag("RtMenuRedo");

    public RtMenuRedo(View view) {
        super(view);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuUndoRedo
    public boolean isUndoRedoable() {
        return this.mPresenter.isRedoable();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.item.RtMenuUndoRedo
    public void onUndoRedo() {
        Logger.m10999d(TAG, "onUndoRedo()");
        this.mPresenter.redo();
        ComposerSA.insertLog("401", ComposerSAConstants.EVENT_EDIT_REDO);
    }
}
