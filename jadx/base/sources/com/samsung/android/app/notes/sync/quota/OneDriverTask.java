package com.samsung.android.app.notes.sync.quota;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.app.notes.sync.network.C6836a;
import com.samsung.android.app.notes.sync.network.networkutils.AbstractC6854e;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import p042J1.C0145c;
import p234q1.C14434c;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class OneDriverTask extends AsyncTask<Void, Void, Void> {
    private static final String EOF_STAUS_V2_KEY = "eofStatus";
    private static final String IS_NEW_USER_KEY = "isNewUser";
    private static final String OD_STAUS_V2_KEY = "oneDriveLinkStatus";
    private static final String OD_V2_URL = "/odi/v2/link/status";
    private static final String TAG = "QT/OneDriverTask";
    protected final String mAuthorization;
    protected final Context mContext;

    public OneDriverTask(Context context, String str) {
        this.mContext = context;
        this.mAuthorization = str;
    }

    private Map<String, String> getRequestParams() {
        HashMap map = new HashMap();
        map.put("Authorization", this.mAuthorization);
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void storeEofStatus(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.has(EOF_STAUS_V2_KEY) ? jSONObject.getString(EOF_STAUS_V2_KEY) : null;
            if (TextUtils.isEmpty(string)) {
                Debugger.m8615i(TAG, "eofStatus is empty!");
                return;
            }
            C0145c.m310R("QUOTA_PREFERENCE", "quota_eof_status", string);
            C0145c.m304L("QUOTA_PREFERENCE", "quota_ui_checked", true);
            Debugger.m8615i(TAG, "EOF status : " + string);
        } catch (JSONException e) {
            Debugger.m8609e(TAG, "fail to get EOF Status : " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void storeIsNewUserStatus(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has(IS_NEW_USER_KEY)) {
                Debugger.m8615i(TAG, "IsNewUser is empty!");
                return;
            }
            boolean z = jSONObject.getBoolean(IS_NEW_USER_KEY);
            C0145c.m304L("QUOTA_PREFERENCE", "quota_new_user_status", z);
            Debugger.m8615i(TAG, "IsNewUser status : " + z);
        } catch (JSONException e) {
            Debugger.m8609e(TAG, "fail to get IsNewUser Status : " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void storeOdStatus(String str) {
        try {
            String string = new JSONObject(str).getString(OD_STAUS_V2_KEY);
            if (TextUtils.isEmpty(string)) {
                Debugger.m8609e(TAG, "odStatus is empty!");
                return;
            }
            C0145c.m310R("QUOTA_PREFERENCE", "quota_od_link_status", string);
            C0145c.m304L("QUOTA_PREFERENCE", "quota_ui_checked", true);
            Debugger.m8615i(TAG, "OD Link status : " + string);
        } catch (JSONException e) {
            Debugger.m8609e(TAG, "fail to get OD Link Status : " + e.getMessage());
        }
    }

    public String getRequestUrl() {
        return C14434c.m15043a().m15044b(OD_V2_URL);
    }

    @Override // android.os.AsyncTask
    public Void doInBackground(Void... voidArr) {
        Debugger.m8615i(TAG, "try to get OD Link Status");
        Thread.currentThread().setName("OneDriverTask");
        try {
            AbstractC6854e.m5026f(this.mAuthorization, getRequestUrl(), getRequestParams(), new C6836a(this, 3));
            return null;
        } catch (SyncException e) {
            Debugger.m8609e(TAG, e.getMessage());
            return null;
        }
    }
}
