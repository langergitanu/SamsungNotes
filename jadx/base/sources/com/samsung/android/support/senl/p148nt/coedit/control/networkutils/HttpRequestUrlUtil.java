package com.samsung.android.support.senl.p148nt.coedit.control.networkutils;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.coedit.log.CoeditLogger;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class HttpRequestUrlUtil extends HttpRequestUtil {

    /* JADX INFO: renamed from: MB */
    private static final int f6655MB = 1048576;
    private static final String TAG = "NT/HttpRequestUrlUtil";
    private static final int TIMEOUT_CONNECT = 10000;
    private static final int TIMEOUT_READ = 10000;

    private void addHeaders(HttpURLConnection httpURLConnection, Map<String, String> map) {
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
    }

    @Nullable
    private URL createURL(@NonNull String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e) {
            CoeditLogger.m8920e(TAG, e.getMessage());
            return null;
        }
    }

    private SCloudHttpResponse executePostRequest(HttpURLConnection httpURLConnection) {
        StringBuilder sb = new StringBuilder();
        try {
            try {
                CoeditLogger.m8923i(TAG, "[CS3] executePostRequest() url = " + CoeditLogger.getEncode(httpURLConnection.getURL().toString()));
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                SCloudHttpResponse sCloudHttpResponse = new SCloudHttpResponse();
                int responseCode = httpURLConnection.getResponseCode();
                sCloudHttpResponse.statusCode = responseCode;
                if (HttpRequestUtil.isFailedResponse(responseCode)) {
                    sCloudHttpResponse.responseStr = getErrorResponseString(httpURLConnection);
                    CoeditLogger.m8920e(TAG, "[CS3-2] executePostRequest() statusCode = " + sCloudHttpResponse.statusCode + ", msg = " + sCloudHttpResponse.responseStr + ", et = " + (SystemClock.elapsedRealtime() - jElapsedRealtime));
                    return sCloudHttpResponse;
                }
                CoeditLogger.m8923i(TAG, "[CS3-1] executePostRequest() statusCode = " + sCloudHttpResponse.statusCode + ", et = " + (SystemClock.elapsedRealtime() - jElapsedRealtime));
                InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream(), StandardCharsets.UTF_8);
                try {
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    while (true) {
                        try {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                bufferedReader.close();
                                inputStreamReader.close();
                                sCloudHttpResponse.responseStr = sb.toString();
                                return sCloudHttpResponse;
                            }
                            sb.append(line);
                        } finally {
                        }
                    }
                } catch (Throwable th) {
                    try {
                        inputStreamReader.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (IOException e) {
                CoeditLogger.m8920e(TAG, "[CS3-2] fail to executeRequest : " + e.getMessage());
                httpURLConnection.disconnect();
                return null;
            }
        } finally {
            httpURLConnection.disconnect();
        }
    }

    private SCloudHttpResponse executePutRequest(HttpURLConnection httpURLConnection, String str) {
        try {
            try {
                FileInputStream fileInputStream = new FileInputStream(new File(str));
                try {
                    httpURLConnection.setFixedLengthStreamingMode(fileInputStream.available());
                    try {
                        OutputStream outputStream = httpURLConnection.getOutputStream();
                        try {
                            byte[] bArr = new byte[1048576];
                            while (true) {
                                int i = fileInputStream.read(bArr);
                                if (i == -1) {
                                    break;
                                }
                                outputStream.write(bArr, 0, i);
                            }
                            outputStream.flush();
                            outputStream.close();
                        } catch (Throwable th) {
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e) {
                        CoeditLogger.m8920e(TAG, "[CS5-2] executePutRequest# Exception: " + e.getMessage());
                    }
                    fileInputStream.close();
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    httpURLConnection.connect();
                    return parsePutResult(httpURLConnection.getResponseCode(), httpURLConnection, jElapsedRealtime);
                } catch (Throwable th3) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                    }
                    throw th3;
                }
            } catch (IOException e2) {
                CoeditLogger.m8920e(TAG, "[CS5-2] executePutRequest#, fail : " + e2.getMessage());
                httpURLConnection.disconnect();
                return null;
            }
        } finally {
            httpURLConnection.disconnect();
        }
    }

    private String getErrorResponseString(HttpURLConnection httpURLConnection) {
        BufferedReader bufferedReader;
        StringBuilder sb = new StringBuilder();
        try {
            try {
                InputStream errorStream = httpURLConnection.getErrorStream();
                try {
                    InputStreamReader inputStreamReader = new InputStreamReader(errorStream, StandardCharsets.UTF_8);
                    try {
                        bufferedReader = new BufferedReader(inputStreamReader);
                    } finally {
                    }
                    while (true) {
                        try {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            sb.append(line);
                        } finally {
                        }
                    }
                    String string = sb.toString();
                    bufferedReader.close();
                    inputStreamReader.close();
                    if (errorStream != null) {
                        errorStream.close();
                    }
                    return string;
                } catch (Throwable th) {
                    if (errorStream != null) {
                        try {
                            errorStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } finally {
                CoeditLogger.m8920e(TAG, sb.toString());
            }
        } catch (Exception e) {
            CoeditLogger.m8920e(TAG, e.getMessage());
            CoeditLogger.m8920e(TAG, sb.toString());
            return null;
        }
    }

    private HttpURLConnection getHttpURLConnection(@NonNull String str, URL url) {
        if (url == null) {
            return null;
        }
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            if (httpURLConnection == null) {
                return null;
            }
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setReadTimeout(10000);
            try {
                httpURLConnection.setRequestMethod(str);
                return httpURLConnection;
            } catch (ProtocolException e) {
                CoeditLogger.m8920e(TAG, e.getMessage());
                return null;
            }
        } catch (IOException e2) {
            CoeditLogger.m8920e(TAG, e2.getMessage());
            return null;
        }
    }

    private void handlePayLoad(HttpURLConnection httpURLConnection, String str) {
        try {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
                outputStream.write(bytes, 0, bytes.length);
                outputStream.close();
            } finally {
            }
        } catch (IOException e) {
            CoeditLogger.m8920e(TAG, "fail to handlePayLoad2 : " + e.getMessage());
        }
    }

    private SCloudHttpResponse parsePutResult(int i, HttpURLConnection httpURLConnection, long j) {
        BufferedReader bufferedReader;
        StringBuilder sb;
        SCloudHttpResponse sCloudHttpResponse = new SCloudHttpResponse();
        sCloudHttpResponse.statusCode = i;
        if (HttpRequestUtil.isFailedResponse(i)) {
            sCloudHttpResponse.responseStr = getErrorResponseString(httpURLConnection);
            CoeditLogger.m8920e(TAG, "[CS5-2] parsePutResult() = statusCode = " + sCloudHttpResponse.statusCode + ", et = " + (SystemClock.elapsedRealtime() - j));
            return sCloudHttpResponse;
        }
        CoeditLogger.m8923i(TAG, "[CS5-1] parsePutResult() : statusCode = " + sCloudHttpResponse.statusCode + ", et = " + (SystemClock.elapsedRealtime() - j));
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream(), StandardCharsets.UTF_8);
            try {
                bufferedReader = new BufferedReader(inputStreamReader);
                try {
                    sb = new StringBuilder();
                } finally {
                }
            } finally {
            }
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    sCloudHttpResponse.responseStr = sb.toString();
                    bufferedReader.close();
                    inputStreamReader.close();
                    return sCloudHttpResponse;
                }
                sb.append(line);
            }
        } catch (Exception e) {
            CoeditLogger.m8920e(TAG, e.getMessage());
            return null;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.networkutils.HttpRequestUtil
    public SCloudHttpResponse get(String str, Map<String, String> map, Map<String, String> map2, String str2) {
        if (TextUtils.isEmpty(str2)) {
            CoeditLogger.m8920e(TAG, "[CS7-2] get() : folderPath is empty!");
            return null;
        }
        String strAddUrlParameters = UrlTool.addUrlParameters(str, map);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        CoeditLogger.m8923i(TAG, "[CS7] get() : getHttpURLConnection, finalUrl = " + CoeditLogger.getEncode(strAddUrlParameters));
        HttpURLConnection httpURLConnection = getHttpURLConnection("GET", createURL(strAddUrlParameters));
        if (httpURLConnection == null) {
            CoeditLogger.m8920e(TAG, "[CS7-2] get() : fail to getHttpURLConnection!");
            return null;
        }
        CoeditLogger.m8923i(TAG, "[CS7] get() : getHttpURLConnection finish, et = " + (SystemClock.elapsedRealtime() - jElapsedRealtime));
        addHeaders(httpURLConnection, map2);
        try {
            try {
                long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                httpURLConnection.connect();
                SCloudHttpResponse sCloudHttpResponse = new SCloudHttpResponse();
                int responseCode = httpURLConnection.getResponseCode();
                sCloudHttpResponse.statusCode = responseCode;
                if (HttpRequestUtil.isFailedResponse(responseCode)) {
                    CoeditLogger.m8920e(TAG, "[CS7-2] get() : statusCode = " + sCloudHttpResponse.statusCode + ", et = " + (SystemClock.elapsedRealtime() - jElapsedRealtime2));
                    sCloudHttpResponse.responseStr = getErrorResponseString(httpURLConnection);
                    return sCloudHttpResponse;
                }
                CoeditLogger.m8923i(TAG, "[CS7-1] get() : statusCode = " + sCloudHttpResponse.statusCode + ", et = " + (SystemClock.elapsedRealtime() - jElapsedRealtime2));
                String strValueOf = String.valueOf(strAddUrlParameters.hashCode());
                File file = new File(str2);
                BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                try {
                    File file2 = new File(file + "/" + strValueOf);
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(file2);
                        try {
                            byte[] bArr = new byte[1048576];
                            while (true) {
                                int i = bufferedInputStream.read(bArr);
                                if (i <= 0) {
                                    fileOutputStream.flush();
                                    sCloudHttpResponse.responseStr = file2.getAbsolutePath();
                                    CoeditLogger.m8923i(TAG, "[CS7-1] get() : succeed to get the filePath!");
                                    fileOutputStream.close();
                                    bufferedInputStream.close();
                                    return sCloudHttpResponse;
                                }
                                fileOutputStream.write(bArr, 0, i);
                            }
                        } catch (Throwable th) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                    } catch (Exception e) {
                        CoeditLogger.m8920e(TAG, "[CS7-2] get() : Exception: " + e.getMessage());
                        bufferedInputStream.close();
                        return null;
                    }
                } catch (Throwable th3) {
                    try {
                        bufferedInputStream.close();
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                    }
                    throw th3;
                }
            } catch (IOException e2) {
                CoeditLogger.m8920e(TAG, "[CS7-2] get() : Fail, 3" + e2.getMessage());
            }
        } finally {
            httpURLConnection.disconnect();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.networkutils.HttpRequestUtil
    public SCloudHttpResponse post(String str, Map<String, String> map, Map<String, String> map2, String str2) {
        HttpURLConnection httpURLConnection = getHttpURLConnection("POST", createURL(UrlTool.addUrlParameters(str, map)));
        if (httpURLConnection == null) {
            CoeditLogger.m8920e(TAG, "[CS3-2] post() : fail to getHttpURLConnection!");
            return null;
        }
        httpURLConnection.setDoOutput(true);
        addHeaders(httpURLConnection, map2);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        handlePayLoad(httpURLConnection, str2);
        CoeditLogger.m8923i(TAG, "[CS3] post() : handlePayLoad finish, et = " + (SystemClock.elapsedRealtime() - jElapsedRealtime));
        return executePostRequest(httpURLConnection);
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.control.networkutils.HttpRequestUtil
    public SCloudHttpResponse put(String str, Map<String, String> map, Map<String, String> map2, String str2) {
        if (TextUtils.isEmpty(str2)) {
            CoeditLogger.m8920e(TAG, "[CS5-2] put() : filePath is empty!");
            return null;
        }
        String strAddUrlParameters = UrlTool.addUrlParameters(str, map);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        CoeditLogger.m8923i(TAG, "[CS5] put() : getHttpURLConnection, finalUrl = " + CoeditLogger.getEncode(strAddUrlParameters));
        HttpURLConnection httpURLConnection = getHttpURLConnection("PUT", createURL(strAddUrlParameters));
        if (httpURLConnection == null) {
            CoeditLogger.m8920e(TAG, "[CS5-2] put() : fail to getHttpURLConnection!");
            return null;
        }
        CoeditLogger.m8923i(TAG, "[CS5] put() : getHttpURLConnection finish, et = " + (SystemClock.elapsedRealtime() - jElapsedRealtime));
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        addHeaders(httpURLConnection, map2);
        return executePutRequest(httpURLConnection, str2);
    }
}
