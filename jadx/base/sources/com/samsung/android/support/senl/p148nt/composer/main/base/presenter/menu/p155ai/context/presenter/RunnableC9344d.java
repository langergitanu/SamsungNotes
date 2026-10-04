package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.context.presenter;

import java.util.ArrayList;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC9344d implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6812a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f6813b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f6814c;

    public /* synthetic */ RunnableC9344d(Object obj, Object obj2, int i) {
        this.f6812a = i;
        this.f6813b = obj;
        this.f6814c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6812a) {
            case 0:
                ((AiDrawingManager) this.f6813b).lambda$smoothScrollAndScaleToFitRect$6((Runnable) this.f6814c);
                break;
            case 1:
                ((AiDrawingManager) this.f6813b).lambda$updatePopupLayout$4((String) this.f6814c);
                break;
            case 2:
                ((AiDrawingManager) this.f6813b).lambda$startCreateImage$1((ArrayList) this.f6814c);
                break;
            default:
                C9336xa4dd8d3.onSuccess$lambda$0((AiSuggestionManager) this.f6813b, (String) this.f6814c);
                break;
        }
    }
}
