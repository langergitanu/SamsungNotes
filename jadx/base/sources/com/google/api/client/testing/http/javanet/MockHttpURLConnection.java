package com.google.api.client.testing.http.javanet;

import com.google.api.client.util.Beta;
import com.google.api.client.util.Preconditions;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Beta
public class MockHttpURLConnection extends HttpURLConnection {
    private boolean doOutputCalled;
    private InputStream errorStream;
    private Map<String, List<String>> headers;
    private InputStream inputStream;
    private OutputStream outputStream;

    @Deprecated
    public static final byte[] INPUT_BUF = new byte[1];

    @Deprecated
    public static final byte[] ERROR_BUF = new byte[5];

    public MockHttpURLConnection(URL url) {
        super(url);
        this.outputStream = new ByteArrayOutputStream(0);
        this.inputStream = null;
        this.errorStream = null;
        this.headers = new LinkedHashMap();
    }

    public MockHttpURLConnection addHeader(String str, String str2) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(str2);
        if (this.headers.containsKey(str)) {
            this.headers.get(str).add(str2);
            return this;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str2);
        this.headers.put(str, arrayList);
        return this;
    }

    public final boolean doOutputCalled() {
        return this.doOutputCalled;
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        return this.errorStream;
    }

    @Override // java.net.URLConnection
    public String getHeaderField(String str) {
        List<String> list = this.headers.get(str);
        if (list == null) {
            return null;
        }
        return list.get(0);
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        return this.headers;
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        if (((HttpURLConnection) this).responseCode < 400) {
            return this.inputStream;
        }
        throw new IOException();
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() {
        OutputStream outputStream = this.outputStream;
        return outputStream != null ? outputStream : super.getOutputStream();
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() {
        return ((HttpURLConnection) this).responseCode;
    }

    @Override // java.net.URLConnection
    public void setDoOutput(boolean z) {
        this.doOutputCalled = true;
    }

    public MockHttpURLConnection setErrorStream(InputStream inputStream) {
        Preconditions.checkNotNull(inputStream);
        if (this.errorStream == null) {
            this.errorStream = inputStream;
        }
        return this;
    }

    public MockHttpURLConnection setInputStream(InputStream inputStream) {
        Preconditions.checkNotNull(inputStream);
        if (this.inputStream == null) {
            this.inputStream = inputStream;
        }
        return this;
    }

    public MockHttpURLConnection setOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
        return this;
    }

    public MockHttpURLConnection setResponseCode(int i) {
        Preconditions.checkArgument(i >= -1);
        ((HttpURLConnection) this).responseCode = i;
        return this;
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return false;
    }

    @Override // java.net.URLConnection
    public void connect() {
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
    }
}
