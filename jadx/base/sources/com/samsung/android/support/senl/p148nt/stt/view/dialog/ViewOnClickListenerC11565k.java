package com.samsung.android.support.senl.p148nt.stt.view.dialog;

import android.view.View;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.stt.view.dialog.k */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final /* synthetic */ class ViewOnClickListenerC11565k implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7947a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ SpeakerRenameDialog f7948b;

    public /* synthetic */ ViewOnClickListenerC11565k(SpeakerRenameDialog speakerRenameDialog, int i) {
        this.f7947a = i;
        this.f7948b = speakerRenameDialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f7947a) {
            case 0:
                SpeakerRenameDialog.onCreateDialog$lambda$5$lambda$4(this.f7948b, view);
                break;
            case 1:
                SpeakerRenameDialog.setButtonClickListener$lambda$10(this.f7948b, view);
                break;
            default:
                SpeakerRenameDialog.setButtonClickListener$lambda$11(this.f7948b, view);
                break;
        }
    }
}
