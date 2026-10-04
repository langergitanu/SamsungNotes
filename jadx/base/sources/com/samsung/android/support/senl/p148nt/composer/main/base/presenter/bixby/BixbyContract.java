package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.bixby;

import android.app.Activity;
import android.content.Intent;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.MenuPresenterManager;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public interface BixbyContract {
    void executeActionSendTask(Intent intent);

    Activity getActivity();

    MenuPresenterManager getMenuManager();

    ModeManager getModeManger();

    void setEditModeFromBixby();
}
