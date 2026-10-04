package com.samsung.android.app.notes.sync.push.receiver;

import android.content.Context;
import android.content.Intent;
import com.microsoft.identity.common.internal.util.StringUtil;
import com.samsung.android.app.notes.sync.synchronization.managers.C6906i;
import com.samsung.android.app.notes.sync.synchronization.managers.SyncStateManager$SyncFailState;
import com.samsung.android.sdk.smp.SmpSppReceiver;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import org.json.JSONObject;
import p042J1.AbstractC0155m;
import p042J1.C0145c;
import p044K.C0158a;
import p195k1.C12969a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SmpSppPushReceiver extends SmpSppReceiver {
    private static final String FCM_DATA_KEY = "data";
    private static final String FCM_DATA_VERSION_KEY = "version";
    private static final String FCM_DATA_VERSION_NEW_VALUE = "4";
    private static final String TAG = "SmpSppPushReceiver";

    private String parseJSonGetVersion(String str) {
        if (StringUtil.isEmpty(str)) {
            return "";
        }
        try {
            String string = new JSONObject(str).getString("data");
            return !StringUtil.isEmpty(string) ? new JSONObject(string).getString("version") : "";
        } catch (Exception e) {
            Debugger.m8609e(TAG, e.getMessage());
            return "";
        }
    }

    @Override // com.samsung.android.sdk.smp.SmpSppReceiver
    public void messageReceived(Context context, Intent intent) {
        String oldNotesServiceId;
        C0158a.m407a().getClass();
        Debugger.m8615i(TAG, "[PUSH] messageReceived() : SmpSpp");
        if (context == null) {
            Debugger.m8609e(TAG, "[PUSH] messageReceived() : Invalid context");
            return;
        }
        if (intent == null) {
            Debugger.m8609e(TAG, "[PUSH] messageReceived() : intent is null!");
            return;
        }
        Context applicationContext = context.getApplicationContext();
        String action = intent.getAction();
        Debugger.m8607d(TAG, "[PUSH] onReceive() : action = " + action);
        if (action.equals("8938bd824975bfb2") || action.equals("qabykYeECAHXv7XX")) {
            Debugger.m8607d(TAG, "[PUSH] SMP message received");
            PostLaunchManager.getInstance().executeBaseLogic(301);
            String stringExtra = intent.getStringExtra("appData");
            Debugger.m8616s(TAG, "[PUSH] onReceive() : appData = " + stringExtra);
            String jSonGetVersion = parseJSonGetVersion(stringExtra);
            if (StringUtil.isEmpty(jSonGetVersion) || !jSonGetVersion.equals("4")) {
                oldNotesServiceId = CommonUtils.getOldNotesServiceId();
                C0145c.m304L("SDocServerPush", "SDocServerPushKey", true);
            } else {
                oldNotesServiceId = CommonUtils.getNewNotesServiceId();
            }
            if (!DeviceUtils.isPowerSavingMode(applicationContext) || !AbstractC0155m.m404s(applicationContext)) {
                PostLaunchManager.getInstance().executeBaseLogic(301);
                C12969a.m13872b(applicationContext).m13881j(oldNotesServiceId);
                return;
            }
            Debugger.m8615i(TAG, "[PUSH] messageReceived() : Ignore " + oldNotesServiceId);
            if (!C0145c.m338w(applicationContext)) {
                C0145c.m309Q(applicationContext, Boolean.TRUE);
            }
            C6906i.m5136c().m5140f(SyncStateManager$SyncFailState.POWER_SAVING);
        }
    }
}
