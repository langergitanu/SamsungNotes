package com.samsung.context.sdk.samsunganalytics.internal.sender.DLS;

import android.net.Uri;
import android.text.TextUtils;
import com.samsung.android.sdk.smp.common.database.DBContract;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.context.sdk.samsunganalytics.internal.connection.API;
import com.samsung.context.sdk.samsunganalytics.internal.security.CertificateManager;
import com.samsung.context.sdk.samsunganalytics.internal.sender.LogType;
import com.samsung.context.sdk.samsunganalytics.internal.sender.SimpleLog;
import com.samsung.context.sdk.samsunganalytics.internal.util.AuthUtil;
import com.samsung.context.sdk.samsunganalytics.internal.util.ClientUtil;
import com.samsung.context.sdk.samsunganalytics.internal.util.Debug;
import com.samsung.context.sdk.samsunganalytics.internal.util.Utils;
import com.sec.android.diagmonagent.common.util.executor.AsyncTaskCallback;
import com.sec.android.diagmonagent.common.util.executor.AsyncTaskClient;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Iterator;
import java.util.Queue;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class DLSAPIClient implements AsyncTaskClient {
    private static final int DEFAULT_TIMEOUT_IN_MILLISECONDS = 3000;
    private static final API REALTIME_API = API.SEND_LOG;
    private static final API RTB_API = API.SEND_BUFFERED_LOG;
    private final AsyncTaskCallback asyncTaskCallback;
    private HttpsURLConnection conn;
    private Boolean isBatch;
    private final LogType logType;
    private Queue<SimpleLog> logs;
    private SimpleLog simpleLog;
    private final String trid;

    public DLSAPIClient(SimpleLog simpleLog, String str, AsyncTaskCallback asyncTaskCallback) {
        this.conn = null;
        this.isBatch = Boolean.FALSE;
        this.simpleLog = simpleLog;
        this.trid = str;
        this.asyncTaskCallback = asyncTaskCallback;
        this.logType = simpleLog.getType();
    }

    private void callback(int i, String str) {
        if (this.asyncTaskCallback == null) {
            return;
        }
        if (i == 200 && str.equalsIgnoreCase("1000")) {
            return;
        }
        if (!this.isBatch.booleanValue()) {
            this.asyncTaskCallback.onFail(i, this.simpleLog.getTimestamp() + "", this.simpleLog.getData(), this.simpleLog.getType().getAbbrev());
            return;
        }
        while (!this.logs.isEmpty()) {
            SimpleLog simpleLogPoll = this.logs.poll();
            this.asyncTaskCallback.onFail(i, simpleLogPoll.getTimestamp() + "", simpleLogPoll.getData(), simpleLogPoll.getType().getAbbrev());
        }
    }

    private void cleanUp(BufferedReader bufferedReader) {
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                Debug.LogENG("[DLS Client] " + e.getMessage());
                return;
            }
        }
        HttpsURLConnection httpsURLConnection = this.conn;
        if (httpsURLConnection != null) {
            httpsURLConnection.disconnect();
        }
    }

    private String getBody() {
        if (!this.isBatch.booleanValue()) {
            return this.simpleLog.getData();
        }
        Iterator<SimpleLog> it = this.logs.iterator();
        StringBuilder sb = new StringBuilder(it.next().getData());
        while (it.hasNext()) {
            SimpleLog next = it.next();
            sb.append(Utils.LOG_DELIMITER);
            sb.append(next.getData());
        }
        return sb.toString();
    }

    public AsyncTaskCallback getCallback() {
        return this.asyncTaskCallback;
    }

    public SimpleLog getSimpleLog() {
        return this.simpleLog;
    }

    public String getTrid() {
        return this.trid;
    }

    @Override // com.sec.android.diagmonagent.common.util.executor.AsyncTaskClient
    public int onFinish() throws Throwable {
        int responseCode;
        BufferedReader bufferedReader;
        int i;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                responseCode = this.conn.getResponseCode();
                bufferedReader = new BufferedReader(new InputStreamReader(this.conn.getInputStream()));
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            String string = new JSONObject(bufferedReader.readLine()).getString("rc");
            if (responseCode == 200 && string.equalsIgnoreCase("1000")) {
                Debug.LogD("[DLS Sender] send result success : " + responseCode + " " + string);
                i = 1;
            } else {
                Debug.LogD("[DLS Sender] send result fail : " + responseCode + " " + string);
                i = -7;
            }
            callback(responseCode, string);
            cleanUp(bufferedReader);
            return i;
        } catch (Exception e2) {
            e = e2;
            bufferedReader2 = bufferedReader;
            Debug.LogE("[DLS Client] Send fail.");
            Debug.LogENG("[DLS Client] " + e.getMessage());
            callback(0, "");
            cleanUp(bufferedReader2);
            return -41;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader2 = bufferedReader;
            cleanUp(bufferedReader2);
            throw th;
        }
    }

    @Override // com.sec.android.diagmonagent.common.util.executor.AsyncTaskClient
    public void run() {
        try {
            API api = this.isBatch.booleanValue() ? RTB_API : REALTIME_API;
            Uri.Builder builderBuildUpon = Uri.parse(api.getUrl()).buildUpon();
            String strValueOf = String.valueOf(System.currentTimeMillis());
            builderBuildUpon.appendQueryParameter(DBContract.AckColumns.TIMESTAMP, strValueOf).appendQueryParameter("type", this.logType.getAbbrev()).appendQueryParameter("tid", this.trid).appendQueryParameter(VPathDataCmd.CornerLine, AuthUtil.sha256(this.trid + strValueOf + ClientUtil.SALT));
            URL url = new URL(builderBuildUpon.build().toString());
            String body = getBody();
            if (TextUtils.isEmpty(body)) {
                Debug.LogW("[DLS Client] body is empty");
                return;
            }
            upload(url, body, api.getMethod());
            Debug.LogENG("[DLS Client] Send to DLS : " + body);
        } catch (Exception e) {
            Debug.LogE("[DLS Client] Send fail.");
            Debug.LogENG("[DLS Client] " + e.getMessage());
        }
    }

    public void upload(URL url, String str, String str2) throws IOException {
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
        this.conn = httpsURLConnection;
        httpsURLConnection.setSSLSocketFactory(CertificateManager.getInstance().getSSLContext().getSocketFactory());
        this.conn.setRequestMethod(str2);
        this.conn.addRequestProperty("Content-Encoding", this.isBatch.booleanValue() ? "gzip" : "text");
        this.conn.setConnectTimeout(3000);
        this.conn.setDoOutput(true);
        BufferedOutputStream bufferedOutputStream = this.isBatch.booleanValue() ? new BufferedOutputStream(new GZIPOutputStream(this.conn.getOutputStream())) : new BufferedOutputStream(this.conn.getOutputStream());
        bufferedOutputStream.write(str.getBytes());
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
    }

    public DLSAPIClient(LogType logType, Queue<SimpleLog> queue, String str, AsyncTaskCallback asyncTaskCallback) {
        this.conn = null;
        this.logs = queue;
        this.trid = str;
        this.asyncTaskCallback = asyncTaskCallback;
        this.isBatch = Boolean.TRUE;
        this.logType = logType;
    }
}
