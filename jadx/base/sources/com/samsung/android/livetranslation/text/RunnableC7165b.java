package com.samsung.android.livetranslation.text;

import com.samsung.android.livetranslation.text.LiveTranslation;

/* JADX INFO: renamed from: com.samsung.android.livetranslation.text.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class RunnableC7165b implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4820a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ LiveTranslation.LiveTranslationTaskManagerListenerImpl f4821b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ int f4822c;

    public /* synthetic */ RunnableC7165b(LiveTranslation.LiveTranslationTaskManagerListenerImpl liveTranslationTaskManagerListenerImpl, int i, int i2) {
        this.f4820a = i2;
        this.f4821b = liveTranslationTaskManagerListenerImpl;
        this.f4822c = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4820a) {
            case 0:
                this.f4821b.lambda$onTRLFinish$6(this.f4822c);
                break;
            default:
                this.f4821b.lambda$onTRLFinish$5(this.f4822c);
                break;
        }
    }
}
