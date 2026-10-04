package com.samsung.scsp.framework.core.api;

import com.samsung.scsp.common.ContentType;
import com.samsung.scsp.common.Header;
import com.samsung.scsp.error.FaultBarrier;
import com.samsung.scsp.framework.core.ScspException;
import com.samsung.scsp.framework.core.listeners.Listeners;
import com.samsung.scsp.framework.core.network.HttpRequest;
import com.samsung.scsp.framework.core.network.HttpRequestImpl;
import com.samsung.scsp.framework.core.util.StringUtil;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public abstract class FileTransferableJob extends ResponsiveJob {
    private static final int BUFFER_SIZE = 32768;
    private final Map<HttpRequest, FileVo> map;

    public FileTransferableJob(HttpRequest.Method method, String str, String str2) {
        super(method, str, str2, null);
        this.map = new HashMap();
    }

    public HttpRequest createRequest(ApiContext apiContext, Listeners listeners, String str, String str2) {
        return createRequest(apiContext, listeners, str, str2, 0L);
    }

    public void onResponseHeader(HttpRequest httpRequest, Map<String, List<String>> map) {
    }

    @Override // com.samsung.scsp.framework.core.api.ResponsiveJob, com.samsung.scsp.framework.core.network.Network.StreamListener
    public void onStream(HttpRequest httpRequest, Map<String, List<String>> map, InputStream inputStream) {
        OutputStream outputStream;
        OutputStream outputStream2;
        try {
            try {
                onResponseHeader(httpRequest, map);
                List<String> list = map.get("Content-Length");
                long j = list != null ? Long.parseLong(list.get(0)) : 0L;
                FileVo fileVo = this.map.get(httpRequest);
                if (fileVo != null && fileVo.outputStream != null) {
                    byte[] bArr = new byte[32768];
                    while (true) {
                        int i = inputStream.read(bArr);
                        if (i == -1) {
                            break;
                        }
                        fileVo.outputStream.write(bArr, 0, i);
                        fileVo.transferred += (long) i;
                        if (httpRequest.getProgressListener() != null && j > 0) {
                            httpRequest.getProgressListener().onProgress(fileVo.transferred, j);
                        }
                    }
                }
                FileVo fileVo2 = this.map.get(httpRequest);
                if (fileVo2 != null && (outputStream2 = fileVo2.outputStream) != null) {
                    FaultBarrier.run(new C11637a(outputStream2, 2));
                }
                this.map.remove(httpRequest);
            } catch (IOException e) {
                throw new ScspException(ScspException.Code.RUNTIME_ENVIRONMENT, "IOException occurred while storing the data received from the server in a file.", e);
            }
        } catch (Throwable th) {
            FileVo fileVo3 = this.map.get(httpRequest);
            if (fileVo3 != null && (outputStream = fileVo3.outputStream) != null) {
                FaultBarrier.run(new C11637a(outputStream, 2));
            }
            this.map.remove(httpRequest);
            throw th;
        }
    }

    public void setFile(HttpRequest httpRequest, String str) throws ScspException {
        setFile(httpRequest, str, false);
    }

    public HttpRequest createRequest(ApiContext apiContext, Listeners listeners, String str, String str2, long j) throws ScspException {
        HttpRequestImpl.HttpRequestBuilder httpRequestBuilderNetworkStatusListener = getHttpRequestBuilder(apiContext, str).responseListener(listeners.responseListener).progressListener(listeners.progressListener).networkStatusListener(listeners.networkStatusListener);
        if (j > 0) {
            httpRequestBuilderNetworkStatusListener.addRange(j - 1);
        }
        if (!StringUtil.isEmpty(apiContext.payload)) {
            httpRequestBuilderNetworkStatusListener.payload(ContentType.JSON, apiContext.payload);
        }
        if (!StringUtil.isEmpty(apiContext.invoker)) {
            httpRequestBuilderNetworkStatusListener.addHeader(Header.INVOKER, apiContext.invoker);
        }
        HttpRequest httpRequestBuild = httpRequestBuilderNetworkStatusListener.build();
        setFile(httpRequestBuild, str2, j > 0);
        return httpRequestBuild;
    }

    public void setFile(HttpRequest httpRequest, String str, boolean z) throws ScspException {
        try {
            this.map.put(httpRequest, new FileVo(str, z));
        } catch (FileNotFoundException e) {
            throw new ScspException(ScspException.Code.RUNTIME_ENVIRONMENT, "There is no file for storing the data received from the server.", e);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class FileVo {
        OutputStream outputStream;
        long transferred = 0;

        public FileVo(String str, boolean z) {
            this.outputStream = new FileOutputStream(str, z);
        }

        public FileVo(OutputStream outputStream) {
            this.outputStream = outputStream;
        }
    }

    public void setFile(HttpRequest httpRequest, OutputStream outputStream) throws ScspException {
        try {
            this.map.put(httpRequest, new FileVo(outputStream));
        } catch (Throwable th) {
            throw new ScspException(ScspException.Code.RUNTIME_ENVIRONMENT, "There is no file for storing the data received from the server.", th);
        }
    }
}
