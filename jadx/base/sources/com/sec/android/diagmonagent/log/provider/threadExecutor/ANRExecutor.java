package com.sec.android.diagmonagent.log.provider.threadExecutor;

import android.content.Context;
import android.os.Bundle;
import com.sec.android.diagmonagent.common.logger.AppLog;
import com.sec.android.diagmonagent.common.util.executor.AsyncTaskClient;
import com.sec.android.diagmonagent.log.provider.utils.DiagMonUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ANRExecutor implements AsyncTaskClient {
    private final boolean anrLogging;
    private final Context context;
    private final String serviceId;

    public ANRExecutor(Context context, String str, boolean z) {
        this.context = context;
        this.serviceId = str;
        this.anrLogging = z;
    }

    @Override // com.sec.android.diagmonagent.common.util.executor.AsyncTaskClient
    public int onFinish() {
        return 0;
    }

    @Override // com.sec.android.diagmonagent.common.util.executor.AsyncTaskClient
    public void run() {
        if (2 != DiagMonUtil.checkDMA(this.context)) {
            AppLog.m13144w("ANR Logging does not support");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("serviceId", this.serviceId);
        DiagMonUtil.printResultfromDMA(this.context.getContentResolver().call(DiagMonUtil.URI, "anr_logging", String.valueOf(this.anrLogging), bundle));
    }
}
