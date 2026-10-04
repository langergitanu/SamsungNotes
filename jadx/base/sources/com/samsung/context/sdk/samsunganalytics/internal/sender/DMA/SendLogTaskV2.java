package com.samsung.context.sdk.samsunganalytics.internal.sender.DMA;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import com.samsung.context.sdk.samsunganalytics.internal.util.Debug;
import com.samsung.context.sdk.samsunganalytics.internal.util.Preferences;
import com.sec.android.diagmonagent.common.util.executor.AsyncTaskClient;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SendLogTaskV2 implements AsyncTaskClient {
    private static final String AUTHORITY = "com.sec.android.log.diagmonagent.sa";
    int Type;

    /* JADX INFO: renamed from: cv */
    private final ContentValues f8121cv;
    private final Context mContext;
    private final Uri commonUri = Uri.parse("content://com.sec.android.log.diagmonagent.sa/common");
    private final Uri logUri = Uri.parse("content://com.sec.android.log.diagmonagent.sa/log");
    Uri returnUri = null;

    public SendLogTaskV2(Context context, int i, ContentValues contentValues) {
        this.mContext = context;
        this.Type = i;
        this.f8121cv = contentValues;
    }

    @Override // com.sec.android.diagmonagent.common.util.executor.AsyncTaskClient
    public int onFinish() {
        try {
            Uri uri = this.returnUri;
            if (uri != null) {
                int i = Integer.parseInt(uri.getLastPathSegment());
                Debug.LogD("SendLog Result = " + i);
                boolean z = true;
                if (this.Type == 1) {
                    if (i != 0) {
                        z = false;
                    }
                    Preferences.getPreferences(this.mContext).edit().putBoolean(Preferences.PREFS_KEY_SEND_COMMON_SUCCESS, z).apply();
                    Debug.LogD("Save Result = " + z);
                }
            }
        } catch (Exception e) {
            Debug.logwingW("failed to get send result" + e.getMessage());
        }
        return 0;
    }

    @Override // com.sec.android.diagmonagent.common.util.executor.AsyncTaskClient
    public void run() {
        try {
            int i = this.Type;
            if (i == 1) {
                this.returnUri = this.mContext.getContentResolver().insert(this.commonUri, this.f8121cv);
            } else if (i == 2) {
                this.returnUri = this.mContext.getContentResolver().insert(this.logUri, this.f8121cv);
            }
        } catch (Exception e) {
            Debug.logwingW("failed to send log" + e.getMessage());
        }
    }
}
