package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai;

import android.view.View;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.context.view.AiMenuPopup;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.cover.AiCoverDataSrcCollector;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C9272c implements AiCoverDataSrcCollector.ResultListener, AiMenuPopup.ViewContract {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ AiMenuManager f6804a;

    public /* synthetic */ C9272c(AiMenuManager aiMenuManager) {
        this.f6804a = aiMenuManager;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.view.AiMenuPopup.ViewContract
    public View getCallerView() {
        return this.f6804a.lambda$init$0();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.cover.AiCoverDataSrcCollector.ResultListener
    public void onFinished(String str) {
        this.f6804a.lambda$makeCoverForBixby$5(str);
    }
}
