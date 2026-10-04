package com.samsung.android.support.senl.p148nt.stt.view.dialog;

import com.samsung.android.support.senl.p148nt.stt.view.dialog.SpeakerRenameDialog;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.stt.view.dialog.i */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final /* synthetic */ class RunnableC11563i implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7941a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ SpeakerRenameDialog f7942b;

    public /* synthetic */ RunnableC11563i(SpeakerRenameDialog speakerRenameDialog, int i) {
        this.f7941a = i;
        this.f7942b = speakerRenameDialog;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7941a) {
            case 0:
                SpeakerRenameDialog.setupInputView$lambda$6(this.f7942b);
                break;
            default:
                SpeakerRenameDialog.C115542.onWindowFocusChanged$lambda$0(this.f7942b);
                break;
        }
    }
}
