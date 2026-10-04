package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.context.presenter;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.i */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC9349i implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6823a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ AiSuggestionManager f6824b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ int f6825c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ int f6826d;

    public /* synthetic */ RunnableC9349i(AiSuggestionManager aiSuggestionManager, int i, int i2, int i4) {
        this.f6823a = i4;
        this.f6824b = aiSuggestionManager;
        this.f6825c = i;
        this.f6826d = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6823a) {
            case 0:
                AiSuggestionManager._get_runnableAiSuggestionForAutoFormat_$lambda$1$lambda$0(this.f6824b, this.f6825c, this.f6826d);
                break;
            default:
                AiSuggestionManager._get_runnableAiSuggestionForAutoFormat_$lambda$1(this.f6824b, this.f6825c, this.f6826d);
                break;
        }
    }
}
