package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice;

import com.samsung.android.support.senl.p148nt.stt.view.AiSTTListView;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.m */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC10887m implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7315a = 0;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ int f7316b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ int f7317c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ boolean f7318d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ Object f7319e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ Object f7320f;

    public /* synthetic */ RunnableC10887m(VoiceRecordMenuContainer voiceRecordMenuContainer, int i, String str, boolean z, int i2) {
        this.f7319e = voiceRecordMenuContainer;
        this.f7316b = i;
        this.f7320f = str;
        this.f7318d = z;
        this.f7317c = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7315a) {
            case 0:
                VoiceRecordMenuContainer.onSTTItemStateButtonClick$lambda$2((VoiceRecordMenuContainer) this.f7319e, this.f7316b, (String) this.f7320f, this.f7318d, this.f7317c);
                break;
            default:
                AiSTTListView.scrollToItem$lambda$1((AiSTTListView) this.f7319e, this.f7316b, (AiSTTListView.ScrollItemType) this.f7320f, this.f7317c, this.f7318d);
                break;
        }
    }

    public /* synthetic */ RunnableC10887m(AiSTTListView aiSTTListView, int i, AiSTTListView.ScrollItemType scrollItemType, int i2, boolean z) {
        this.f7319e = aiSTTListView;
        this.f7316b = i;
        this.f7320f = scrollItemType;
        this.f7317c = i2;
        this.f7318d = z;
    }
}
