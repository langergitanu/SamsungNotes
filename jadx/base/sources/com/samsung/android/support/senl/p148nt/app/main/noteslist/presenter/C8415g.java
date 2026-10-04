package com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter;

import com.samsung.android.support.senl.p148nt.app.settings.externalsearch.SettingsSearchIndexingManager;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.g */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C8415g implements SettingsSearchIndexingManager.SPenSettingStateChangeListener {
    @Override // com.samsung.android.support.senl.nt.app.settings.externalsearch.SettingsSearchIndexingManager.SPenSettingStateChangeListener
    public final void onChanged() {
        SettingsSearchIndexingManager.requestIndexing();
    }
}
