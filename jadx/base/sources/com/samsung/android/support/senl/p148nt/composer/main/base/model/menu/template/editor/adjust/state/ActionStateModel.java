package com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.template.editor.adjust.state;

import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CTLogger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ActionStateModel {
    private static final String TAG = CTLogger.createTag("ActionStateModel");
    private int mState = 0;

    public boolean isState(int i) {
        return i == this.mState;
    }

    public void setState(int i) {
        if (this.mState != i) {
            this.mState = i;
            AbstractC8014b.m7195A(new StringBuilder("setState = "), TAG, this.mState);
        }
    }
}
