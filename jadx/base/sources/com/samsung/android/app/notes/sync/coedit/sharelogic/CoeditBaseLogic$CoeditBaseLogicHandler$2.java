package com.samsung.android.app.notes.sync.coedit.sharelogic;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
class CoeditBaseLogic$CoeditBaseLogicHandler$2 extends Handler {
    final /* synthetic */ C6677b this$0;

    public CoeditBaseLogic$CoeditBaseLogicHandler$2(C6677b c6677b) {
        this.this$0 = c6677b;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        AbstractC6678c abstractC6678c = (AbstractC6678c) this.this$0.f3962a.get();
        postDelayed(new RunnableC6676a(this, message.what), 500L);
        if (abstractC6678c != null) {
            abstractC6678c.mo4773a(message);
        }
    }
}
