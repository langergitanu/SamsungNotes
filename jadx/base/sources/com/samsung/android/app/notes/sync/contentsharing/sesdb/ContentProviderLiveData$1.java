package com.samsung.android.app.notes.sync.contentsharing.sesdb;

import android.database.ContentObserver;
import android.os.Handler;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
class ContentProviderLiveData$1 extends ContentObserver {
    final /* synthetic */ AbstractC6688b this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContentProviderLiveData$1(AbstractC6688b abstractC6688b, Handler handler) {
        super(handler);
        this.this$0 = abstractC6688b;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        this.this$0.f3995e.execute(new RunnableC6687a(this, 0));
    }
}
