package com.samsung.android.sdk.smp;

import android.app.IntentService;
import android.content.Intent;
import com.samsung.android.sdk.smp.task.STask;
import com.samsung.android.sdk.smp.taskhandler.STaskHandler;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SmpService extends IntentService {
    public SmpService() {
        super("SmpService");
    }

    @Override // android.app.IntentService
    public void onHandleIntent(Intent intent) {
        if (intent == null || intent.getExtras() == null) {
            return;
        }
        STaskHandler.handle(getApplicationContext(), STask.fromBundle(intent.getExtras()));
    }
}
