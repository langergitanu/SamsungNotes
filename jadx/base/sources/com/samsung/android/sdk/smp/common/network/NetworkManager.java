package com.samsung.android.sdk.smp.common.network;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkError;
import com.android.volley.NetworkResponse;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.RequestFuture;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.samsung.android.sdk.smp.common.constants.Constants;
import com.samsung.android.sdk.smp.common.constants.NetworkConfig;
import com.samsung.android.sdk.smp.common.exception.InternalException;
import com.samsung.android.sdk.smp.common.preference.PrefManager;
import com.samsung.android.sdk.smp.common.util.DeviceInfoUtil;
import com.samsung.android.sdk.smp.common.util.FileIOUtil;
import com.samsung.android.sdk.smp.common.util.SmpLog;
import com.samsung.android.sdk.smp.marketing.GetBaseUrlRequest;
import io.netty.handler.ssl.SslProtocols;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class NetworkManager {
    private static final String CN_SERVER_INDICATOR = "cn";
    private static final String TAG = "NetworkManager";
    private static RequestQueue requestQueue;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CDNVolleyRequest extends Request<File> {
        protected final String TAG;
        private final String mFileDest;
        private final String mFileName;
        private final Response.Listener<File> mListener;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class DiscFullError extends VolleyError {
        }

        public CDNVolleyRequest(String str, String str2, String str3, Response.Listener<File> listener, Response.ErrorListener errorListener) {
            super(0, str, errorListener);
            this.TAG = CDNVolleyRequest.class.getSimpleName();
            this.mListener = listener;
            this.mFileName = str2;
            this.mFileDest = str3;
        }

        private File generateZipFile(byte[] bArr) throws Throwable {
            FileOutputStream fileOutputStream = null;
            try {
                File file = new File(this.mFileDest);
                if (!file.exists() && !file.mkdirs()) {
                    SmpLog.m6492d(this.TAG, "fail to make dirs");
                    return null;
                }
                File file2 = new File(this.mFileDest + "/" + this.mFileName);
                String str = this.TAG;
                StringBuilder sb = new StringBuilder("File : ");
                sb.append(file2.getAbsolutePath());
                SmpLog.m6492d(str, sb.toString());
                FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                try {
                    fileOutputStream2.write(bArr, 0, bArr.length);
                    fileOutputStream2.close();
                    return file2;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }

        private long getAvailableStorage() {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong();
        }

        @Override // com.android.volley.Request
        public Response<File> parseNetworkResponse(NetworkResponse networkResponse) {
            byte[] bArr = networkResponse.data;
            if (getAvailableStorage() <= ((double) bArr.length) * 2.5d) {
                return Response.error(new DiscFullError());
            }
            try {
                return Response.success(generateZipFile(bArr), HttpHeaderParser.parseCacheHeaders(networkResponse));
            } catch (IOException e) {
                return Response.error(new VolleyError(e.getMessage()));
            }
        }

        @Override // com.android.volley.Request
        public void deliverResponse(File file) {
            this.mListener.onResponse(file);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class GzipJsonUtf8VolleyRequest extends StringRequest {
        private final String PROTOCOL_CONTENT_TYPE;
        private final byte[] mRequestBody;

        public GzipJsonUtf8VolleyRequest(int i, String str, byte[] bArr, Response.Listener<String> listener, Response.ErrorListener errorListener) {
            super(i, str, listener, errorListener);
            this.PROTOCOL_CONTENT_TYPE = "application/json; charset=utf-8";
            this.mRequestBody = bArr;
        }

        @Override // com.android.volley.Request
        public byte[] getBody() {
            return this.mRequestBody;
        }

        @Override // com.android.volley.Request
        public String getBodyContentType() {
            return this.PROTOCOL_CONTENT_TYPE;
        }

        @Override // com.android.volley.Request
        public Map<String, String> getHeaders() {
            HashMap map = new HashMap();
            map.put("Content-Encoding", "gzip");
            return map;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class JsonUtf8VolleyRequest extends JsonRequest<String> {
        public JsonUtf8VolleyRequest(int i, String str, String str2, Response.Listener<String> listener, Response.ErrorListener errorListener) {
            super(i, str, str2, listener, errorListener);
        }

        @Override // com.android.volley.Request
        public Map<String, String> getHeaders() {
            HashMap map = new HashMap();
            map.put("Content-Type", "application/json");
            return map;
        }

        @Override // com.android.volley.toolbox.JsonRequest, com.android.volley.Request
        public Response<String> parseNetworkResponse(NetworkResponse networkResponse) {
            String str;
            try {
                str = new String(networkResponse.data, HttpHeaderParser.parseCharset(networkResponse.headers));
            } catch (UnsupportedEncodingException unused) {
                str = new String(networkResponse.data);
            }
            return Response.success(str, HttpHeaderParser.parseCacheHeaders(networkResponse));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class StringUtf8VolleyRequest extends StringRequest {
        private static final String PROTOCOL_CHARSET = "utf-8";
        private final String mRequestBody;

        public StringUtf8VolleyRequest(int i, String str, String str2, Response.Listener<String> listener, Response.ErrorListener errorListener) {
            super(i, str, listener, errorListener);
            this.mRequestBody = str2;
        }

        @Override // com.android.volley.Request
        public byte[] getBody() {
            try {
                String str = this.mRequestBody;
                if (str == null) {
                    return null;
                }
                return str.getBytes(PROTOCOL_CHARSET);
            } catch (UnsupportedEncodingException unused) {
                return null;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class TLSSocketFactory extends SSLSocketFactory {
        private final SSLSocketFactory internalSSLSocketFactory;

        public TLSSocketFactory() throws NoSuchAlgorithmException, KeyManagementException {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, null, null);
            this.internalSSLSocketFactory = sSLContext.getSocketFactory();
        }

        private Socket enableTLSOnSocket(Socket socket) {
            if (socket instanceof SSLSocket) {
                ((SSLSocket) socket).setEnabledProtocols(new String[]{SslProtocols.TLS_v1_1, SslProtocols.TLS_v1_2});
            }
            return socket;
        }

        @Override // javax.net.SocketFactory
        public Socket createSocket() {
            return enableTLSOnSocket(this.internalSSLSocketFactory.createSocket());
        }

        @Override // javax.net.ssl.SSLSocketFactory
        public String[] getDefaultCipherSuites() {
            return this.internalSSLSocketFactory.getDefaultCipherSuites();
        }

        @Override // javax.net.ssl.SSLSocketFactory
        public String[] getSupportedCipherSuites() {
            return this.internalSSLSocketFactory.getSupportedCipherSuites();
        }

        @Override // javax.net.ssl.SSLSocketFactory
        public Socket createSocket(Socket socket, String str, int i, boolean z) {
            return enableTLSOnSocket(this.internalSSLSocketFactory.createSocket(socket, str, i, z));
        }

        @Override // javax.net.SocketFactory
        public Socket createSocket(String str, int i) {
            return enableTLSOnSocket(this.internalSSLSocketFactory.createSocket(str, i));
        }

        @Override // javax.net.SocketFactory
        public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) {
            return enableTLSOnSocket(this.internalSSLSocketFactory.createSocket(str, i, inetAddress, i2));
        }

        @Override // javax.net.SocketFactory
        public Socket createSocket(InetAddress inetAddress, int i) {
            return enableTLSOnSocket(this.internalSSLSocketFactory.createSocket(inetAddress, i));
        }

        @Override // javax.net.SocketFactory
        public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) {
            return enableTLSOnSocket(this.internalSSLSocketFactory.createSocket(inetAddress, i, inetAddress2, i2));
        }
    }

    public static NetworkResult downloadResource(Context context, String str, String str2, String str3, int i) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || i < 0) {
            SmpLog.m6494e(TAG, "download resource fail. invalid params");
            return new NetworkResult(false, 1008);
        }
        String str4 = TAG;
        SmpLog.m6498i(str4, "resource download starts. " + str);
        RequestFuture requestFutureNewFuture = RequestFuture.newFuture();
        CDNVolleyRequest cDNVolleyRequest = new CDNVolleyRequest(str, str2, str3, requestFutureNewFuture, requestFutureNewFuture);
        cDNVolleyRequest.setShouldCache(false);
        long j = i;
        cDNVolleyRequest.setRetryPolicy(new DefaultRetryPolicy((int) (Constants.SECMILLIS * j), 0, 1.0f));
        getRequestQueue(context).add(cDNVolleyRequest);
        try {
            requestFutureNewFuture.get(j, TimeUnit.SECONDS);
            SmpLog.m6498i(str4, "resource download success");
            return new NetworkResult(true, 200);
        } catch (Exception e) {
            return handleVolleyException(e);
        }
    }

    private static RequestQueue getRequestQueue(Context context) {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;
    }

    private static String getUriForLog(Context context, String str) {
        String domainByFlavor = NetworkRequest.getDomainByFlavor(context);
        if (TextUtils.isEmpty(domainByFlavor) || !str.startsWith(domainByFlavor)) {
            return str;
        }
        return str.substring(domainByFlavor.length()) + " (" + (domainByFlavor.contains(CN_SERVER_INDICATOR) ? "c" : "g") + ")";
    }

    private static String getVolleyErrorMessage(Exception exc) {
        VolleyError volleyError;
        NetworkResponse networkResponse;
        String string = exc.toString();
        if ((exc.getCause() instanceof VolleyError) && (volleyError = (VolleyError) exc.getCause()) != null && (networkResponse = volleyError.networkResponse) != null) {
            byte[] bArr = networkResponse.data;
            String str = bArr != null ? new String(bArr, StandardCharsets.UTF_8) : "";
            SmpLog.m6494e(TAG, "request fail. error - " + networkResponse.statusCode + " " + str);
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return string;
    }

    private static NetworkResult handleVolleyException(Exception exc) {
        String str = TAG;
        SmpLog.m6494e(str, exc.toString());
        if (exc instanceof InterruptedException) {
            SmpLog.m6494e(str, "request fail. interruption occurs");
            return new NetworkResult(false, 1014);
        }
        if ((exc instanceof TimeoutException) || (exc instanceof TimeoutError)) {
            SmpLog.m6494e(str, "request fail. timeout");
            return new NetworkResult(false, 1003);
        }
        if (!(exc instanceof ExecutionException)) {
            SmpLog.m6494e(str, "request fail. unknown error - " + exc.getMessage());
            return new NetworkResult(false, 1100, exc.getMessage());
        }
        String volleyErrorMessage = getVolleyErrorMessage(exc);
        SmpLog.m6494e(str, "request fail. " + volleyErrorMessage);
        return exc.getCause() instanceof AuthFailureError ? new NetworkResult(false, 1011) : exc.getCause() instanceof NoConnectionError ? new NetworkResult(false, 1002) : exc.getCause() instanceof NetworkError ? new NetworkResult(false, 1010) : exc.getCause() instanceof ParseError ? new NetworkResult(false, 1015) : exc.getCause() instanceof ServerError ? new NetworkResult(false, ((ServerError) exc.getCause()).networkResponse.statusCode, volleyErrorMessage) : exc.getCause() instanceof CDNVolleyRequest.DiscFullError ? new NetworkResult(false, 1004) : new NetworkResult(false, 1100, volleyErrorMessage);
    }

    private static NetworkResult onGetBaseUrlSuccess(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return new NetworkResult(false, 1015);
        }
        try {
            PrefManager.getInstance(context).setBaseUrl(new JSONObject(str).getString(NetworkConfig.BASE_URL));
            return new NetworkResult(true, 200);
        } catch (JSONException e) {
            SmpLog.m6494e(TAG, "Fail to parse base url response. " + e.toString());
            return new NetworkResult(false, 1015);
        }
    }

    public static NetworkResult request(Context context, NetworkRequest networkRequest, int i) {
        Request stringUtf8VolleyRequest;
        if (context == null || networkRequest == null || i < 0) {
            SmpLog.m6494e(TAG, "request fail. invalid params");
            return new NetworkResult(false, 1008);
        }
        String serverUrl = networkRequest.getServerUrl(context);
        if (TextUtils.isEmpty(serverUrl)) {
            NetworkResult networkResultRequestGetBaseUrl = requestGetBaseUrl(context);
            if (!networkResultRequestGetBaseUrl.isSuccess()) {
                return networkResultRequestGetBaseUrl;
            }
            serverUrl = networkRequest.getServerUrl(context);
        }
        String str = serverUrl;
        RequestFuture requestFutureNewFuture = RequestFuture.newFuture();
        try {
            String requestBody = networkRequest.getRequestBody();
            String str2 = TAG;
            SmpLog.m6498i(str2, "request. uri : " + getUriForLog(context, str) + ", body:" + requestBody);
            if (!(networkRequest instanceof NetworkJSonRequest)) {
                stringUtf8VolleyRequest = new StringUtf8VolleyRequest(networkRequest.getRequestMethod(), str, requestBody, requestFutureNewFuture, requestFutureNewFuture);
            } else if (((NetworkJSonRequest) networkRequest).isGzipEnabled()) {
                stringUtf8VolleyRequest = new GzipJsonUtf8VolleyRequest(networkRequest.getRequestMethod(), str, FileIOUtil.compress(requestBody), requestFutureNewFuture, requestFutureNewFuture);
            } else {
                stringUtf8VolleyRequest = new JsonUtf8VolleyRequest(networkRequest.getRequestMethod(), str, requestBody, requestFutureNewFuture, requestFutureNewFuture);
            }
            stringUtf8VolleyRequest.setShouldCache(false);
            long j = i;
            stringUtf8VolleyRequest.setRetryPolicy(new DefaultRetryPolicy((int) (Constants.SECMILLIS * j), 0, 1.0f));
            getRequestQueue(context).add(stringUtf8VolleyRequest);
            String str3 = (String) requestFutureNewFuture.get(j, TimeUnit.SECONDS);
            SmpLog.m6498i(str2, "request success. response : " + str3);
            return new NetworkResult(true, 200, str3);
        } catch (InternalException.InvalidDataException unused) {
            SmpLog.m6494e(TAG, "request fail. invalid request body");
            return new NetworkResult(false, 1008);
        } catch (Exception e) {
            return handleVolleyException(e);
        }
    }

    private static NetworkResult requestGetBaseUrl(Context context) {
        NetworkResult networkResultRequest = request(context, new GetBaseUrlRequest(DeviceInfoUtil.getCountryIsoCode()), 60);
        if (networkResultRequest.isSuccess()) {
            return onGetBaseUrlSuccess(context, networkResultRequest.getResponseMsg());
        }
        SmpLog.m6494e(TAG, "Fail to get base url. error code:" + networkResultRequest.getResponseCode() + ", error msg:" + networkResultRequest.getResponseMsg());
        return networkResultRequest;
    }
}
