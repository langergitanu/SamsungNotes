package com.samsung.android.livetranslation.text;

import com.samsung.android.livetranslation.text.LiveTranslation;

/* JADX INFO: renamed from: com.samsung.android.livetranslation.text.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class RunnableC7166c implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4823a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f4824b;

    public /* synthetic */ RunnableC7166c(Object obj, int i) {
        this.f4823a = i;
        this.f4824b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4823a) {
            case 0:
                ((LiveTranslation.LiveTranslationTaskManagerListenerImpl) this.f4824b).lambda$onSTRFinish$1();
                break;
            default:
                LiveTranslation.lambda$_captureRequestCallback$0((LiveTranslation.RenderingScreen) this.f4824b);
                break;
        }
    }
}
