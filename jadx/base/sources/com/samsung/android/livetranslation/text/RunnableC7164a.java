package com.samsung.android.livetranslation.text;

import com.samsung.android.livetranslation.text.LiveTranslation;

/* JADX INFO: renamed from: com.samsung.android.livetranslation.text.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class RunnableC7164a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4816a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ LiveTranslation.LiveTranslationTaskManagerListenerImpl f4817b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ KeyFrame f4818c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ int f4819d;

    public /* synthetic */ RunnableC7164a(int i, KeyFrame keyFrame, LiveTranslation.LiveTranslationTaskManagerListenerImpl liveTranslationTaskManagerListenerImpl) {
        this.f4816a = 0;
        this.f4817b = liveTranslationTaskManagerListenerImpl;
        this.f4819d = i;
        this.f4818c = keyFrame;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4816a) {
            case 0:
                this.f4817b.lambda$onTRLFinish$3(this.f4819d, this.f4818c);
                break;
            case 1:
                this.f4817b.lambda$onTRLFinish$4(this.f4818c, this.f4819d);
                break;
            case 2:
                this.f4817b.lambda$onSTRFinish$0(this.f4818c, this.f4819d);
                break;
            default:
                this.f4817b.lambda$onSTRFinish$2(this.f4818c, this.f4819d);
                break;
        }
    }

    public /* synthetic */ RunnableC7164a(LiveTranslation.LiveTranslationTaskManagerListenerImpl liveTranslationTaskManagerListenerImpl, KeyFrame keyFrame, int i, int i2) {
        this.f4816a = i2;
        this.f4817b = liveTranslationTaskManagerListenerImpl;
        this.f4818c = keyFrame;
        this.f4819d = i;
    }
}
