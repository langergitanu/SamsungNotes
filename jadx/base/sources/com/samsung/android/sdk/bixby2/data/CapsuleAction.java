package com.samsung.android.sdk.bixby2.data;

import com.samsung.android.sdk.bixby2.action.ActionHandler;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class CapsuleAction {
    ActionHandler actionHandler;
    boolean isExported;

    public CapsuleAction(ActionHandler actionHandler, boolean z) {
        this.actionHandler = actionHandler;
        this.isExported = z;
    }

    public ActionHandler getActionHandler() {
        return this.actionHandler;
    }

    public boolean isExported() {
        return this.isExported;
    }
}
