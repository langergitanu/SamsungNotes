package com.samsung.scsp.common;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.scsp.error.FaultBarrier;
import com.samsung.scsp.error.Logger;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.function.Consumer;
import p122b2.C4194q;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class DeviceHealthCheckPushExecutorImpl implements Consumer<PushVo> {
    public static final String IDENTIFIER = "identity.deviceHealthCheck";
    private static final Logger logger = Logger.get("DeviceHealthCheckPushExecutorImpl");

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$accept$0(String str) {
        return AbstractC0541b.m772n("callbackUrl :", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$accept$1(PushVo pushVo) throws IOException {
        String str = pushVo.callbackUrl;
        Logger logger2 = logger;
        logger2.m12931d(new C4194q(str, 2));
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        if (httpURLConnection != null) {
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(30000);
            httpURLConnection.setReadTimeout(30000);
            logger2.m12934i("callback response :" + httpURLConnection.getResponseCode());
        }
    }

    @Override // java.util.function.Consumer
    public void accept(PushVo pushVo) {
        FaultBarrier.run(new C11624c(pushVo));
    }
}
