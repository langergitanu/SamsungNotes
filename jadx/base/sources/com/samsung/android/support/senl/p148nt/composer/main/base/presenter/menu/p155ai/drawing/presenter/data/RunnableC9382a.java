package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.drawing.presenter.data;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.drawing.presenter.data.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC9382a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6836a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ AiDrawingDataController f6837b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ String f6838c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ int f6839d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ Runnable f6840e;

    public /* synthetic */ RunnableC9382a(AiDrawingDataController aiDrawingDataController, int i, Runnable runnable, String str, int i2) {
        this.f6836a = i2;
        this.f6837b = aiDrawingDataController;
        this.f6839d = i;
        this.f6840e = runnable;
        this.f6838c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6836a) {
            case 0:
                this.f6837b.lambda$loadSPenObjectsFile$2(this.f6838c, this.f6839d, this.f6840e);
                break;
            case 1:
                this.f6837b.lambda$loadSPenObjectsImageContents$0(this.f6838c, this.f6839d, this.f6840e);
                break;
            case 2:
                Runnable runnable = this.f6840e;
                String str = this.f6838c;
                this.f6837b.lambda$loadSPenObjectsFile$3(this.f6839d, runnable, str);
                break;
            default:
                Runnable runnable2 = this.f6840e;
                String str2 = this.f6838c;
                this.f6837b.lambda$loadSPenObjectsImageContents$1(this.f6839d, runnable2, str2);
                break;
        }
    }

    public /* synthetic */ RunnableC9382a(AiDrawingDataController aiDrawingDataController, String str, int i, Runnable runnable, int i2) {
        this.f6836a = i2;
        this.f6837b = aiDrawingDataController;
        this.f6838c = str;
        this.f6839d = i;
        this.f6840e = runnable;
    }
}
