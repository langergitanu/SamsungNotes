package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.policy.common;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class Policy {
    private Action mAction = Action.NONE;
    private List<Integer> mExclusiveDeactivationByEnabled = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum Action {
        NONE,
        ENABLED,
        DISABLED
    }

    public Action getAction() {
        return this.mAction;
    }

    public List<Integer> getExclusiveDeactivationByEnabled() {
        return this.mExclusiveDeactivationByEnabled;
    }

    public void setAction(Action action) {
        this.mAction = action;
    }

    public void setExclusiveDeactivationByEnabled(List<Integer> list) {
        this.mExclusiveDeactivationByEnabled.clear();
        this.mExclusiveDeactivationByEnabled.addAll(list);
    }
}
