package com.samsung.android.support.senl.p148nt.composer.main.base.view;

import androidx.window.layout.FoldingFeature;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.system.SystemUiManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.system.WindowManagerWrapper;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.view.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C10068a implements WindowManagerWrapper.Callback, SystemUiManager.Contract {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ BaseComposerFragment f7110a;

    public /* synthetic */ C10068a(BaseComposerFragment baseComposerFragment) {
        this.f7110a = baseComposerFragment;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.system.SystemUiManager.Contract
    public boolean isSearchMode() {
        return this.f7110a.lambda$onCreate$1();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.system.WindowManagerWrapper.Callback
    public void onChangedDeviceState(FoldingFeature foldingFeature) {
        this.f7110a.lambda$onCreate$0(foldingFeature);
    }
}
