package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice;

import android.view.View;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class ViewOnClickListenerC10879e implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7296a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ VoiceRecordExpandMenu f7297b;

    public /* synthetic */ ViewOnClickListenerC10879e(VoiceRecordExpandMenu voiceRecordExpandMenu, int i) {
        this.f7296a = i;
        this.f7297b = voiceRecordExpandMenu;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f7296a) {
            case 0:
                VoiceRecordExpandMenu.initMenuList$lambda$1(this.f7297b, view);
                break;
            case 1:
                this.f7297b.showPopUpMenu();
                break;
            case 2:
                VoiceRecordExpandMenu.initVoiceButton$lambda$7(this.f7297b, view);
                break;
            default:
                VoiceRecordExpandMenu.initVoiceButton$lambda$8(this.f7297b, view);
                break;
        }
    }
}
