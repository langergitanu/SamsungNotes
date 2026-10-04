package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.i */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC10883i implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7304a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ VoiceRecordExpandSubMenu f7305b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ int f7306c;

    public /* synthetic */ RunnableC10883i(VoiceRecordExpandSubMenu voiceRecordExpandSubMenu, int i, int i2) {
        this.f7304a = i2;
        this.f7305b = voiceRecordExpandSubMenu;
        this.f7306c = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7304a) {
            case 0:
                VoiceRecordExpandSubMenu.notifyItemChanged$lambda$4(this.f7305b, this.f7306c);
                break;
            case 1:
                VoiceRecordExpandSubMenu.notifyItemRemoved$lambda$3(this.f7305b, this.f7306c);
                break;
            default:
                VoiceRecordExpandSubMenu.notifyItemInserted$lambda$5(this.f7305b, this.f7306c);
                break;
        }
    }
}
