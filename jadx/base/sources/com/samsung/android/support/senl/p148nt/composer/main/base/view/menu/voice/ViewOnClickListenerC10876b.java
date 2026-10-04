package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice;

import android.view.View;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class ViewOnClickListenerC10876b implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7290a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ VoiceRecordControlMenu f7291b;

    public /* synthetic */ ViewOnClickListenerC10876b(VoiceRecordControlMenu voiceRecordControlMenu, int i) {
        this.f7290a = i;
        this.f7291b = voiceRecordControlMenu;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f7290a) {
            case 0:
                VoiceRecordControlMenu.initPlayControlMenu$lambda$9(this.f7291b, view);
                break;
            case 1:
                VoiceRecordControlMenu.initPlayControlMenu$lambda$12(this.f7291b, view);
                break;
            case 2:
                VoiceRecordControlMenu.initControlMenu$lambda$1(this.f7291b, view);
                break;
            case 3:
                VoiceRecordControlMenu.initControlMenu$lambda$3(this.f7291b, view);
                break;
            default:
                VoiceRecordControlMenu.initControlMenu$lambda$4(this.f7291b, view);
                break;
        }
    }
}
