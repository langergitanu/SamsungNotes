package com.google.api.client.testing.http;

import com.google.api.client.http.HttpMediaType;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Charsets;
import com.google.api.client.util.IOUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Beta
public class MockLowLevelHttpRequest extends LowLevelHttpRequest {
    private final Map<String, List<String>> headersMap = new HashMap();
    private MockLowLevelHttpResponse response = new MockLowLevelHttpResponse();
    private String url;

    public MockLowLevelHttpRequest() {
    }

    @Override // com.google.api.client.http.LowLevelHttpRequest
    public void addHeader(String str, String str2) {
        String lowerCase = str.toLowerCase();
        List<String> arrayList = this.headersMap.get(lowerCase);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.headersMap.put(lowerCase, arrayList);
        }
        arrayList.add(str2);
    }

    @Override // com.google.api.client.http.LowLevelHttpRequest
    public LowLevelHttpResponse execute() {
        return this.response;
    }

    public String getContentAsString() throws IOException {
        if (getStreamingContent() == null) {
            return "";
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        getStreamingContent().writeTo(byteArrayOutputStream);
        String contentEncoding = getContentEncoding();
        if (contentEncoding != null && contentEncoding.contains("gzip")) {
            GZIPInputStream gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
            byteArrayOutputStream = new ByteArrayOutputStream();
            IOUtils.copy(gZIPInputStream, byteArrayOutputStream);
        }
        String contentType = getContentType();
        HttpMediaType httpMediaType = contentType != null ? new HttpMediaType(contentType) : null;
        return byteArrayOutputStream.toString(((httpMediaType == null || httpMediaType.getCharsetParameter() == null) ? Charsets.ISO_8859_1 : httpMediaType.getCharsetParameter()).name());
    }

    public String getFirstHeaderValue(String str) {
        List<String> list = this.headersMap.get(str.toLowerCase());
        if (list == null) {
            return null;
        }
        return list.get(0);
    }

    public List<String> getHeaderValues(String str) {
        List<String> list = this.headersMap.get(str.toLowerCase());
        return list == null ? Collections.EMPTY_LIST : Collections.unmodifiableList(list);
    }

    public Map<String, List<String>> getHeaders() {
        return Collections.unmodifiableMap(this.headersMap);
    }

    public MockLowLevelHttpResponse getResponse() {
        return this.response;
    }

    public String getUrl() {
        return this.url;
    }

    public MockLowLevelHttpRequest setResponse(MockLowLevelHttpResponse mockLowLevelHttpResponse) {
        this.response = mockLowLevelHttpResponse;
        return this;
    }

    public MockLowLevelHttpRequest setUrl(String str) {
        this.url = str;
        return this;
    }

    public MockLowLevelHttpRequest(String str) {
        this.url = str;
    }
}
