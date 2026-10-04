package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC10498c implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7215a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ TitleEditorViewSet f7216b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ int f7217c;

    public /* synthetic */ RunnableC10498c(TitleEditorViewSet titleEditorViewSet, int i, int i2) {
        this.f7215a = i2;
        this.f7216b = titleEditorViewSet;
        this.f7217c = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7215a) {
            case 0:
                this.f7216b.lambda$setThemeActionMenuView$2(this.f7217c);
                break;
            default:
                this.f7216b.lambda$initToolbar$3(this.f7217c);
                break;
        }
    }
}
