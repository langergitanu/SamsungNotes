package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.f */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC10880f implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7298a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ VoiceRecordExpandOptionMenu f7299b;

    public /* synthetic */ RunnableC10880f(VoiceRecordExpandOptionMenu voiceRecordExpandOptionMenu, int i) {
        this.f7298a = i;
        this.f7299b = voiceRecordExpandOptionMenu;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7298a) {
            case 0:
                VoiceRecordExpandOptionMenu.showEditView$lambda$12(this.f7299b);
                break;
            default:
                VoiceRecordExpandOptionMenu.initRecordingList$lambda$13(this.f7299b);
                break;
        }
    }
}
