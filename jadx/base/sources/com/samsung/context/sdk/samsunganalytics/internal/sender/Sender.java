package com.samsung.context.sdk.samsunganalytics.internal.sender;

import android.content.Context;
import com.samsung.context.sdk.samsunganalytics.Configuration;
import com.samsung.context.sdk.samsunganalytics.internal.sender.DLS.DLSLogSender;
import com.samsung.context.sdk.samsunganalytics.internal.sender.DMA.DMALogSender;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class Sender {
    private static LogSender logSender;

    public static LogSender get(Context context, int i, Configuration configuration) {
        if (logSender == null) {
            synchronized (Sender.class) {
                try {
                    if (logSender == null) {
                        if (i == 0) {
                            logSender = new DLSLogSender(context, configuration);
                        } else if (i == 2 || i == 3) {
                            logSender = new DMALogSender(context, configuration);
                        }
                    }
                } finally {
                }
            }
        }
        return logSender;
    }

    public static void init() {
        logSender = null;
    }
}
