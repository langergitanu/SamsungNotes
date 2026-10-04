package com.samsung.android.support.senl.p148nt.stt.presenter;

import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.stt.presenter.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final /* synthetic */ class C11522a implements Function0 {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7878a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ STTPresenter f7879b;

    public /* synthetic */ C11522a(STTPresenter sTTPresenter, int i) {
        this.f7878a = i;
        this.f7879b = sTTPresenter;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.f7878a) {
            case 0:
                return STTPresenter.onDialogClickConvertButton$lambda$31(this.f7879b);
            default:
                return STTPresenter$mRemoveTranscribeConfirmPresenter$1.remove$lambda$0(this.f7879b);
        }
    }
}
