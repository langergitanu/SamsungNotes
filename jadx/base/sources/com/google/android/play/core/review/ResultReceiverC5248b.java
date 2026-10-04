package com.google.android.play.core.review;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.google.android.play.core.tasks.C5345i;

/* JADX INFO: renamed from: com.google.android.play.core.review.b */
/* JADX INFO: loaded from: classes5.dex */
final class ResultReceiverC5248b extends ResultReceiver {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ C5345i f3012a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResultReceiverC5248b(Handler handler, C5345i c5345i) {
        super(handler);
        this.f3012a = c5345i;
    }

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i, Bundle bundle) {
        this.f3012a.m4201b((Object) null);
    }
}
