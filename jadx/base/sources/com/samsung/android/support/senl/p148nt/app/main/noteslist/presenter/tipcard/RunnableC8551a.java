package com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.tipcard;

import com.vladsch.flexmark.util.html.HtmlAppendableBase;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.tipcard.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class RunnableC8551a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6243a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ boolean[] f6244b;

    public /* synthetic */ RunnableC8551a(boolean[] zArr, int i) {
        this.f6243a = i;
        this.f6244b = zArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6243a) {
            case 0:
                TipCardHelper.lambda$addCheckConvertedNotesTipCard$0(this.f6244b);
                break;
            default:
                HtmlAppendableBase.lambda$tag$0(this.f6244b);
                break;
        }
    }
}
