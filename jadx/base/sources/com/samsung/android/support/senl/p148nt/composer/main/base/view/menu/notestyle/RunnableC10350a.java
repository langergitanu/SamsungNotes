package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC10350a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7164a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ NoteStyleActivity f7165b;

    public /* synthetic */ RunnableC10350a(NoteStyleActivity noteStyleActivity, int i) {
        this.f7164a = i;
        this.f7165b = noteStyleActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7164a) {
            case 0:
                this.f7165b.requestCoverGenerate();
                break;
            case 1:
                super/*android.app.Activity*/.finish();
                break;
            default:
                NoteStyleActivity.autoGenerateCover$lambda$1(this.f7165b);
                break;
        }
    }
}
