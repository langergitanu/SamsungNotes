package com.google.android.play.core.appupdate;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import com.google.android.play.core.common.IntentSenderForResultStarter;

/* JADX INFO: renamed from: com.google.android.play.core.appupdate.d */
/* JADX INFO: loaded from: classes5.dex */
final class C4994d implements IntentSenderForResultStarter {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ Activity f2425a;

    public C4994d(Activity activity) {
        this.f2425a = activity;
    }

    @Override // com.google.android.play.core.common.IntentSenderForResultStarter
    public final void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i4, int i5, Bundle bundle) throws IntentSender.SendIntentException {
        this.f2425a.startIntentSenderForResult(intentSender, i, intent, i2, i4, i5, bundle);
    }
}
