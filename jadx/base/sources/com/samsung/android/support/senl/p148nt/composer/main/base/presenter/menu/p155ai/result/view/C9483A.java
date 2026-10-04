package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view;

import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.STTTranslation;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AiMenuResultViewSTTVoiceListPopup;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.A */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C9483A implements AiMenuResultViewSTTVoiceListPopup.OnSelectListener, STTTranslation.LanguageIdentifyCallback {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ AiMenuResultViewSTT f6910a;

    public /* synthetic */ C9483A(AiMenuResultViewSTT aiMenuResultViewSTT) {
        this.f6910a = aiMenuResultViewSTT;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.STTTranslation.LanguageIdentifyCallback
    public void onComplete() {
        this.f6910a.lambda$initLanguage$8();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewSTTVoiceListPopup.OnSelectListener
    public void onSelectVoiceItem(int i) {
        this.f6910a.lambda$initVoiceListPopup$17(i);
    }
}
