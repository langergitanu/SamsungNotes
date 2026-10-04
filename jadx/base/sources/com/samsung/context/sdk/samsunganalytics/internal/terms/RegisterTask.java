package com.samsung.context.sdk.samsunganalytics.internal.terms;

import android.net.Uri;
import android.text.TextUtils;
import com.samsung.android.sdk.smp.common.database.DBContract;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.context.sdk.samsunganalytics.internal.connection.API;
import com.samsung.context.sdk.samsunganalytics.internal.security.CertificateManager;
import com.samsung.context.sdk.samsunganalytics.internal.util.AuthUtil;
import com.samsung.context.sdk.samsunganalytics.internal.util.ClientUtil;
import com.samsung.context.sdk.samsunganalytics.internal.util.Debug;
import com.sec.android.diagmonagent.common.util.executor.AsyncTaskCallback;
import com.sec.android.diagmonagent.common.util.executor.AsyncTaskClient;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class RegisterTask implements AsyncTaskClient {
    private final AsyncTaskCallback callback;
    private final String deviceID;
    private final long timestamp;
    private final String trid;
    private final API api = API.DATA_DELETE;
    private HttpsURLConnection conn = null;

    public RegisterTask(String str, String str2, long j, AsyncTaskCallback asyncTaskCallback) {
        this.trid = str;
        this.deviceID = str2;
        this.timestamp = j;
        this.callback = asyncTaskCallback;
    }

    private void callback(int i, String str) {
        if (this.callback == null) {
            return;
        }
        if (i == 200 && str.equalsIgnoreCase("1000")) {
            this.callback.onSuccess(0, "", "", "");
        } else {
            this.callback.onFail(i, str, "", "");
        }
    }

    private void cleanUp(BufferedReader bufferedReader, InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                Debug.LogENG("[Register Client] " + e.getMessage());
                return;
            }
        }
        if (bufferedReader != null) {
            bufferedReader.close();
        }
        HttpsURLConnection httpsURLConnection = this.conn;
        if (httpsURLConnection != null) {
            httpsURLConnection.disconnect();
        }
    }

    private String makeRequestBody() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tid", this.trid);
            jSONObject.put("lid", this.deviceID);
            jSONObject.put(DBContract.AckColumns.TIMESTAMP, String.valueOf(this.timestamp));
        } catch (JSONException e) {
            Debug.logwingW("failed to make body" + e.getMessage());
        }
        return jSONObject.toString();
    }

    public AsyncTaskCallback getCallback() {
        return this.callback;
    }

    public String getDeviceID() {
        return this.deviceID;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public String getTrid() {
        return this.trid;
    }

    @Override // com.sec.android.diagmonagent.common.util.executor.AsyncTaskClient
    public int onFinish() throws Throwable {
        InputStream errorStream;
        int responseCode;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                responseCode = this.conn.getResponseCode();
                errorStream = responseCode >= 400 ? this.conn.getErrorStream() : this.conn.getInputStream();
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(errorStream));
                } catch (Exception unused) {
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                String string = new JSONObject(bufferedReader.readLine()).getString("rc");
                if (responseCode == 200 && string.equalsIgnoreCase("1000")) {
                    Debug.LogENG("Success : " + responseCode + " " + string);
                } else {
                    Debug.LogENG("Fail : " + responseCode + " " + string);
                }
                callback(responseCode, string);
                cleanUp(bufferedReader, errorStream);
                return 0;
            } catch (Exception unused2) {
                bufferedReader2 = bufferedReader;
                callback(0, "");
                cleanUp(bufferedReader2, errorStream);
                return 0;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader2 = bufferedReader;
                cleanUp(bufferedReader2, errorStream);
                throw th;
            }
        } catch (Exception unused3) {
            errorStream = null;
        } catch (Throwable th3) {
            th = th3;
            errorStream = null;
        }
    }

    @Override // com.sec.android.diagmonagent.common.util.executor.AsyncTaskClient
    public void run() {
        try {
            Uri.Builder builderBuildUpon = Uri.parse(this.api.getUrl()).buildUpon();
            String strValueOf = String.valueOf(System.currentTimeMillis());
            builderBuildUpon.appendQueryParameter("tid", this.trid).appendQueryParameter(DBContract.AckColumns.TIMESTAMP, strValueOf).appendQueryParameter(VPathDataCmd.CornerLine, AuthUtil.sha256(this.trid + strValueOf + ClientUtil.SALT));
            URL url = new URL(builderBuildUpon.build().toString());
            String strMakeRequestBody = makeRequestBody();
            if (TextUtils.isEmpty(strMakeRequestBody)) {
                Debug.LogW("[Register Client] body is empty");
            } else {
                upload(url, strMakeRequestBody);
            }
        } catch (Exception e) {
            Debug.LogENG("[Register Client] " + e.getMessage());
        }
    }

    public void upload(URL url, String str) throws IOException {
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
        this.conn = httpsURLConnection;
        httpsURLConnection.setSSLSocketFactory(CertificateManager.getInstance().getSSLContext().getSocketFactory());
        this.conn.setRequestMethod(this.api.getMethod());
        this.conn.setConnectTimeout(3000);
        this.conn.setRequestProperty("Content-Type", "application/json");
        this.conn.setDoOutput(true);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(this.conn.getOutputStream());
        bufferedOutputStream.write(str.getBytes());
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
    }
}
