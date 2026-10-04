package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle;

import android.view.View;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class ViewOnClickListenerC10351b implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7166a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ NoteStyleActivity f7167b;

    public /* synthetic */ ViewOnClickListenerC10351b(NoteStyleActivity noteStyleActivity, int i) {
        this.f7166a = i;
        this.f7167b = noteStyleActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f7166a) {
            case 0:
                NoteStyleActivity.initCloseBtn$lambda$4(this.f7167b, view);
                break;
            default:
                NoteStyleActivity.initConfirmBtn$lambda$5(this.f7167b, view);
                break;
        }
    }
}
