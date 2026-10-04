package com.samsung.context.sdk.samsunganalytics.internal.policy;

import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import com.samsung.context.sdk.samsunganalytics.internal.Callback;
import com.samsung.context.sdk.samsunganalytics.internal.connection.API;
import com.samsung.context.sdk.samsunganalytics.internal.connection.Directory;
import com.samsung.context.sdk.samsunganalytics.internal.connection.Domain;
import com.samsung.context.sdk.samsunganalytics.internal.security.CertificateManager;
import com.samsung.context.sdk.samsunganalytics.internal.util.Debug;
import com.sec.android.diagmonagent.common.util.executor.AsyncTaskClient;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class PolicyClient implements AsyncTaskClient {
    private static final int RESULT_CODE_INVALID_TID = 1201;
    private static final int RESULT_CODE_SUCCESS = 1000;
    private final API api;
    private final Callback<Void, Boolean> callback;
    private HttpsURLConnection conn = null;
    private final SharedPreferences pref;
    private final Map<String, String> qParams;

    public PolicyClient(API api, Map<String, String> map, SharedPreferences sharedPreferences, Callback<Void, Boolean> callback) {
        this.api = api;
        this.qParams = map;
        this.pref = sharedPreferences;
        this.callback = callback;
    }

    private void cleanUp(BufferedReader bufferedReader) {
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (IOException unused) {
                return;
            }
        }
        HttpsURLConnection httpsURLConnection = this.conn;
        if (httpsURLConnection != null) {
            httpsURLConnection.disconnect();
        }
    }

    private void save(JSONObject jSONObject) {
        try {
            this.pref.edit().putInt(Constants.KEY_DATA_ONCE_QUOTA, jSONObject.getInt(Constants.KEY_DATA_ONCE_QUOTA) * 1024).putInt(Constants.KEY_DATA_QUOTA, jSONObject.getInt(Constants.KEY_DATA_QUOTA) * 1024).putInt(Constants.KEY_WIFI_ONCE_QUOTA, jSONObject.getInt(Constants.KEY_WIFI_ONCE_QUOTA) * 1024).putInt(Constants.KEY_WIFI_QUOTA, jSONObject.getInt(Constants.KEY_WIFI_QUOTA) * 1024).putString(Constants.KEY_DLS_DOMAIN, "https://" + jSONObject.getString(Constants.KEY_DLS_DOMAIN)).putString("uri", jSONObject.getString("uri")).putString(Constants.KEY_DLS_URI_BAT, jSONObject.getString(Constants.KEY_DLS_URI_BAT)).putString(Constants.KEY_LOG_TYPE, jSONObject.getString(Constants.KEY_LOG_TYPE)).putInt(Constants.POLICY_RINT, jSONObject.getInt(Constants.POLICY_RINT)).putLong(Constants.POLICY_RECEIVED_DATE, System.currentTimeMillis()).apply();
            Domain.DLS.setDomain("https://" + jSONObject.getString(Constants.KEY_DLS_DOMAIN));
            Directory.DLS_DIR.setDirectory(jSONObject.getString("uri"));
            Directory.DLS_DIR_BAT.setDirectory(jSONObject.getString(Constants.KEY_DLS_URI_BAT));
            Debug.LogENG("dq-3g: " + (jSONObject.getInt(Constants.KEY_DATA_QUOTA) * 1024) + ", dq-w: " + (jSONObject.getInt(Constants.KEY_WIFI_QUOTA) * 1024) + ", oq-3g: " + (jSONObject.getInt(Constants.KEY_DATA_ONCE_QUOTA) * 1024) + ", oq-w: " + (jSONObject.getInt(Constants.KEY_WIFI_ONCE_QUOTA) * 1024));
        } catch (JSONException e) {
            Debug.logwingE("Fail to save policy" + e.getMessage());
            Debug.LogENG("[GetPolicyClient] " + e.getMessage());
        }
    }

    @Override // com.sec.android.diagmonagent.common.util.executor.AsyncTaskClient
    public int onFinish() throws Throwable {
        int i;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                if (this.conn.getResponseCode() != 200) {
                    Debug.LogE("Fail to get Policy. Response code : " + this.conn.getResponseCode());
                    i = -61;
                } else {
                    i = 0;
                }
                bufferedReader = new BufferedReader(new InputStreamReader(this.conn.getInputStream()));
            } catch (Exception unused) {
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            String line = bufferedReader.readLine();
            Debug.LogENG(line);
            JSONObject jSONObject = new JSONObject(line);
            int i2 = jSONObject.getInt("rc");
            if (i2 == 1000) {
                Debug.LogD("GetPolicyClient", "Get Policy Success");
                if (TextUtils.isEmpty(this.pref.getString(Constants.KEY_LOG_TYPE, "")) && this.callback != null && jSONObject.getString(Constants.KEY_LOG_TYPE).equals(Constants.VALUE_LOG_TYPE_MIX)) {
                    this.callback.onResult(Boolean.TRUE);
                }
                save(jSONObject);
            } else if (i2 == 1201) {
                Debug.LogD("GetPolicyClient", "Result code : 1201, quota should be changed to zero");
                this.pref.edit().putInt(Constants.KEY_DATA_ONCE_QUOTA, 0).putInt(Constants.KEY_DATA_QUOTA, 0).putInt(Constants.KEY_WIFI_ONCE_QUOTA, 0).putInt(Constants.KEY_WIFI_QUOTA, 0).putLong(Constants.POLICY_RECEIVED_DATE, System.currentTimeMillis()).apply();
            } else {
                Debug.logwingE("Fail to get Policy; Invalid Message. Result code : " + i2);
                i = -61;
            }
            cleanUp(bufferedReader);
        } catch (Exception unused2) {
            bufferedReader2 = bufferedReader;
            Debug.LogE("Fail to get Policy");
            cleanUp(bufferedReader2);
            i = -61;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader2 = bufferedReader;
            cleanUp(bufferedReader2);
            throw th;
        }
        boolean zIsEmpty = TextUtils.isEmpty(this.pref.getString(Constants.KEY_DLS_DOMAIN, ""));
        if (i == -61 && !zIsEmpty) {
            this.pref.edit().putLong(Constants.POLICY_RECEIVED_DATE, System.currentTimeMillis()).apply();
        }
        return i;
    }

    @Override // com.sec.android.diagmonagent.common.util.executor.AsyncTaskClient
    public void run() {
        try {
            Uri.Builder builderBuildUpon = Uri.parse(this.api.getUrl()).buildUpon();
            for (String str : this.qParams.keySet()) {
                builderBuildUpon.appendQueryParameter(str, this.qParams.get(str));
            }
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(builderBuildUpon.build().toString()).openConnection();
            this.conn = httpsURLConnection;
            httpsURLConnection.setSSLSocketFactory(CertificateManager.getInstance().getSSLContext().getSocketFactory());
            this.conn.setRequestMethod(this.api.getMethod());
            this.conn.setConnectTimeout(3000);
        } catch (Exception unused) {
            Debug.LogE("Fail to get Policy");
        }
    }
}
