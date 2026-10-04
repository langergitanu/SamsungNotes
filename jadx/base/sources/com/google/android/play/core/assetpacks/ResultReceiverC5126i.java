package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.google.android.play.core.tasks.C5345i;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.i */
/* JADX INFO: loaded from: classes5.dex */
final class ResultReceiverC5126i extends ResultReceiver {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ C5345i f2878a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ C5127j f2879b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResultReceiverC5126i(C5127j c5127j, Handler handler, C5345i c5345i) {
        super(handler);
        this.f2879b = c5127j;
        this.f2878a = c5345i;
    }

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i, Bundle bundle) {
        if (i == 1) {
            this.f2878a.m4201b(-1);
            this.f2879b.f2887h.m3730a(null);
        } else if (i != 2) {
            this.f2878a.m4200b((Exception) new AssetPackException(-100));
        } else {
            this.f2878a.m4201b(0);
        }
    }
}
