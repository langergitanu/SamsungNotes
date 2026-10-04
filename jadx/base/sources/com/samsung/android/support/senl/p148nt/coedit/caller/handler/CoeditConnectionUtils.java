package com.samsung.android.support.senl.p148nt.coedit.caller.handler;

import android.content.Context;
import android.content.ServiceConnection;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.coedit.log.CoeditLogger;
import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class CoeditConnectionUtils {
    private static final String TAG = "CoeditConnectionUtils";

    public static void deleteTempFile(String str) {
        try {
            FileUtils.deleteFile(new File(str));
            CoeditLogger.m8923i(TAG, "deleteTempFile: " + CoeditLogger.getEncode(str));
        } catch (IOException e) {
            CoeditLogger.m8920e(TAG, "deleteTempFile: " + e.getMessage());
        }
    }

    public static void unbindService(Context context, ServiceConnection serviceConnection) {
        CoeditLogger.m8919d(TAG, "unbindService() CoeditService");
        try {
            context.unbindService(serviceConnection);
        } catch (IllegalArgumentException unused) {
            CoeditLogger.m8920e(TAG, "unbindService() CoeditService, service is not bind");
        }
    }
}
