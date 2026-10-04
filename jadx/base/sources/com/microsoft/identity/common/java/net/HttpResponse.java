package com.microsoft.identity.common.java.net;

import com.microsoft.identity.common.java.util.StringUtil;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import lombok.NonNull;
import net.jcip.annotations.Immutable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
public class HttpResponse {
    private final Date mDate;
    private final String mResponseBody;
    private final Map<String, List<String>> mResponseHeaders;
    private final int mStatusCode;

    public HttpResponse(int i, String str, Map<String, List<String>> map) {
        this(new Date(), i, str, map);
    }

    public String getBody() {
        return this.mResponseBody;
    }

    public Date getDate() {
        return new Date(this.mDate.getTime());
    }

    @Nullable
    public String getHeaderValue(@NonNull String str, int i) {
        List<String> list;
        if (str == null) {
            throw new NullPointerException("key is marked non-null but is null");
        }
        if (this.mResponseHeaders == null || i < 0 || StringUtil.isNullOrEmpty(str) || (list = this.mResponseHeaders.get(str)) == null || list.size() <= i) {
            return null;
        }
        return list.get(i);
    }

    public Map<String, List<String>> getHeaders() {
        return this.mResponseHeaders;
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }

    public String toString() {
        return "HttpResponse{mStatusCode=" + this.mStatusCode + ", mResponseBody='" + this.mResponseBody + "', mResponseHeaders=" + this.mResponseHeaders + '}';
    }

    public HttpResponse(@NonNull Date date, int i, String str, Map<String, List<String>> map) {
        if (date == null) {
            throw new NullPointerException("date is marked non-null but is null");
        }
        this.mDate = new Date(date.getTime());
        this.mStatusCode = i;
        this.mResponseBody = str;
        this.mResponseHeaders = map;
    }
}
