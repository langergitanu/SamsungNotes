package com.google.android.play.core.common;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.ResultReceiver;
import androidx.annotation.Nullable;
import com.google.android.play.core.internal.C5195bq;

/* JADX INFO: loaded from: classes5.dex */
public class PlayCoreDialogWrapperActivity extends Activity {

    /* JADX INFO: renamed from: a */
    @Nullable
    private ResultReceiver f2916a;

    /* JADX INFO: renamed from: a */
    public static void m3854a(Context context) {
        C5195bq.m3942a(context.getPackageManager(), new ComponentName(context.getPackageName(), "com.google.android.play.core.common.PlayCoreDialogWrapperActivity"), 1);
    }

    @Override // android.app.Activity
    public final void onActivityResult(int i, int i2, Intent intent) {
        ResultReceiver resultReceiver;
        Bundle bundle;
        int i4;
        super.onActivityResult(i, i2, intent);
        if (i == 0 && (resultReceiver = this.f2916a) != null) {
            if (i2 == -1) {
                bundle = new Bundle();
                i4 = 1;
            } else if (i2 == 0) {
                bundle = new Bundle();
                i4 = 2;
            }
            resultReceiver.send(i4, bundle);
        }
        finish();
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        PlayCoreDialogWrapperActivity playCoreDialogWrapperActivity;
        super.onCreate(bundle);
        if (bundle != null) {
            this.f2916a = (ResultReceiver) bundle.getParcelable("result_receiver");
            return;
        }
        this.f2916a = (ResultReceiver) getIntent().getParcelableExtra("result_receiver");
        try {
            try {
                startIntentSenderForResult(((PendingIntent) getIntent().getExtras().get("confirmation_intent")).getIntentSender(), 0, null, 0, 0, 0);
            } catch (IntentSender.SendIntentException unused) {
                playCoreDialogWrapperActivity = this;
                ResultReceiver resultReceiver = playCoreDialogWrapperActivity.f2916a;
                if (resultReceiver != null) {
                    resultReceiver.send(3, new Bundle());
                }
                finish();
            }
        } catch (IntentSender.SendIntentException unused2) {
            playCoreDialogWrapperActivity = this;
        }
    }

    @Override // android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        bundle.putParcelable("result_receiver", this.f2916a);
    }
}
