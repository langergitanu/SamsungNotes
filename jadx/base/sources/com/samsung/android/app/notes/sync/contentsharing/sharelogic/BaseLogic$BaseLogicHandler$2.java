package com.samsung.android.app.notes.sync.contentsharing.sharelogic;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
class BaseLogic$BaseLogicHandler$2 extends Handler {
    final /* synthetic */ C6724b this$0;

    public BaseLogic$BaseLogicHandler$2(C6724b c6724b) {
        this.this$0 = c6724b;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        AbstractC6725c abstractC6725c = (AbstractC6725c) this.this$0.f4067a.get();
        postDelayed(new RunnableC6723a(this, message.what), 500L);
        if (abstractC6725c != null) {
            abstractC6725c.mo4817a(message);
        }
    }
}
