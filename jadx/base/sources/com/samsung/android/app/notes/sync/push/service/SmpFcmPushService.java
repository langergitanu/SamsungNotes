package com.samsung.android.app.notes.sync.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.firebase.messaging.RemoteMessage;
import com.samsung.android.app.notes.sync.synchronization.managers.C6906i;
import com.samsung.android.app.notes.sync.synchronization.managers.SyncStateManager$SyncFailState;
import com.samsung.android.sdk.smp.SmpFcmService;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import java.util.Map;
import org.json.JSONObject;
import p001A.AbstractC0000a;
import p042J1.AbstractC0155m;
import p042J1.C0145c;
import p195k1.C12969a;
import p211o0.C13567a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SmpFcmPushService extends SmpFcmService {
    private static final String FCM_DATA = "data";
    private static final String FCM_DATA_CID_KEY = "cid";
    private static final String FCM_DATA_EDP_STATE_KEY = "state";
    private static final String FCM_DATA_EDP_STATE_ON_VALUE = "ON";
    private static final String FCM_DATA_VERSION_KEY = "version";
    private static final String FCM_DATA_VERSION_NEW_VALUE = "4";
    private static final String FCM_SMP_REQUESTID = "smp-requestID";
    private static final String TAG = "SmpFcmPushService";

    private void handleEdpState(String str) {
        String string;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("state")) {
                return;
            } else {
                string = jSONObject.getString("state");
            }
        } catch (Exception e) {
            Debugger.m8609e(TAG, e.getMessage());
            string = "UnKnown";
        }
        Debugger.m8615i(TAG, "[PUSH][EDP] EDP state is " + string);
        C13567a.m14371a().m14374e(string);
    }

    private void handleVersions(String str) {
        String oldNotesServiceId;
        String string = "";
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("version")) {
                string = jSONObject.getString("version");
            } else if (!jSONObject.has("cid")) {
                return;
            }
        } catch (Exception e) {
            Debugger.m8609e(TAG, e.getMessage());
        }
        if (TextUtils.isEmpty(string) || !"4".equals(string)) {
            oldNotesServiceId = CommonUtils.getOldNotesServiceId();
            C0145c.m304L("SDocServerPush", "SDocServerPushKey", true);
        } else {
            oldNotesServiceId = CommonUtils.getNewNotesServiceId();
        }
        Debugger.m8607d(TAG, "[PUSH] SMP push is received!");
        Context applicationContext = getApplicationContext();
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

    @Override // com.samsung.android.sdk.smp.SmpFcmService
    public void messageReceived(RemoteMessage remoteMessage) {
        Debugger.m8615i(TAG, "[PUSH] messageReceived() : SmpFcm");
        if (remoteMessage == null || remoteMessage.getData() == null) {
            Debugger.m8609e(TAG, "[PUSH] FCM message is null!");
            return;
        }
        Map<String, String> data = remoteMessage.getData();
        if (data != null && data.containsKey("data")) {
            String str = data.get("data");
            if (!TextUtils.isEmpty(str)) {
                try {
                    handleVersions(str);
                } catch (Exception e) {
                    AbstractC0000a.m21r(e, new StringBuilder("[PUSH] fail to handleVersions()"), TAG);
                }
                if (AbstractC4539a.m3210t()) {
                    try {
                        handleEdpState(str);
                    } catch (Exception e2) {
                        AbstractC0000a.m21r(e2, new StringBuilder("[PUSH] fail to handleEdpState()"), TAG);
                    }
                }
            }
        }
        Debugger.m8616s(TAG, "[PUSH] FCM message : " + remoteMessage.getData());
    }
}
