package com.google.android.play.core.appupdate;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.google.android.play.core.tasks.C5345i;

/* JADX INFO: renamed from: com.google.android.play.core.appupdate.c */
/* JADX INFO: loaded from: classes5.dex */
final class ResultReceiverC4993c extends ResultReceiver {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ C5345i f2424a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResultReceiverC4993c(Handler handler, C5345i c5345i) {
        super(handler);
        this.f2424a = c5345i;
    }

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i, Bundle bundle) {
        C5345i c5345i;
        int i2 = 1;
        if (i == 1) {
            c5345i = this.f2424a;
            i2 = -1;
        } else if (i != 2) {
            c5345i = this.f2424a;
        } else {
            c5345i = this.f2424a;
            i2 = 0;
        }
        c5345i.m4201b(Integer.valueOf(i2));
    }
}
