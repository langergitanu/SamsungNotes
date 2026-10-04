package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.action;

import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ScrollController;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ActionZoom extends AbsAction {
    private static final String TAG = Logger.createTag("ActionZoom");
    private final boolean mIsZoomIn;
    private final ScrollController mScrollController;

    public ActionZoom(ScrollController scrollController, boolean z) {
        this.mScrollController = scrollController;
        this.mIsZoomIn = z;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.action.AbsAction
    public boolean doAction(String str) {
        AbstractC8014b.m7197C("doAction# ", str, TAG);
        this.mScrollController.pageZoom(this.mIsZoomIn);
        return true;
    }
}
