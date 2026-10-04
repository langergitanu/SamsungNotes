package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.action;

import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ScrollController;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ActionMoveScroll extends AbsAction {
    private static final String TAG = Logger.createTag("ActionMoveScroll");
    private final boolean mIsVertical;
    private final ScrollController mScrollController;

    public ActionMoveScroll(ScrollController scrollController, boolean z) {
        this.mScrollController = scrollController;
        this.mIsVertical = z;
    }

    private boolean executeDoAction(String str, Object obj) {
        if (obj instanceof Boolean) {
            this.mScrollController.moveScroll(this.mIsVertical, ((Boolean) obj).booleanValue());
            return true;
        }
        Logger.m11000e(TAG, "executeDoAction# error arg" + obj + " / " + str);
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.action.AbsAction
    public boolean doAction(String str) {
        return executeDoAction(str, Boolean.TRUE);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.action.AbsAction
    public boolean doAction(String str, Object obj) {
        return executeDoAction(str, obj);
    }
}
