package com.microsoft.identity.common.java.util;

import cz.msebera.android.httpclient.NameValuePair;
import cz.msebera.android.httpclient.client.utils.URIBuilder;
import edu.umd.cs.findbugs.annotations.Nullable;
import java.net.URI;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import lombok.NonNull;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class CommonURIBuilder extends URIBuilder {
    public CommonURIBuilder() {
    }

    private boolean containsParam(@NonNull String str) {
        if (str == null) {
            throw new NullPointerException("param is marked non-null but is null");
        }
        Iterator<NameValuePair> it = getQueryParams().iterator();
        while (it.hasNext()) {
            if (it.next().getName().equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public CommonURIBuilder addParameterIfAbsent(@NonNull String str, @NonNull String str2) {
        if (str == null) {
            throw new NullPointerException("param is marked non-null but is null");
        }
        if (str2 == null) {
            throw new NullPointerException("value is marked non-null but is null");
        }
        if (containsParam(str)) {
            return this;
        }
        super.addParameter(str, str2);
        return this;
    }

    @Override // cz.msebera.android.httpclient.client.utils.URIBuilder
    public /* bridge */ /* synthetic */ URIBuilder addParameters(@NonNull List list) {
        return addParameters((List<NameValuePair>) list);
    }

    public CommonURIBuilder addParametersIfAbsent(@Nullable Map<String, ?> map) {
        if (map != null) {
            for (Map.Entry<String, ?> entry : map.entrySet()) {
                addParameterIfAbsent(entry.getKey(), String.valueOf(entry.getValue()));
            }
        }
        return this;
    }

    public String getLastPathSegment() {
        List<String> pathSegments = getPathSegments();
        return pathSegments.isEmpty() ? "" : (String) AbstractC0000a.m10g(pathSegments, 1);
    }

    @Override // cz.msebera.android.httpclient.client.utils.URIBuilder
    public /* bridge */ /* synthetic */ URIBuilder setParameters(List list) {
        return setParameters((List<NameValuePair>) list);
    }

    public CommonURIBuilder(String str) {
        super(str);
    }

    @Override // cz.msebera.android.httpclient.client.utils.URIBuilder
    public CommonURIBuilder addParameter(@NonNull String str, @NonNull String str2) {
        if (str == null) {
            throw new NullPointerException("param is marked non-null but is null");
        }
        if (str2 == null) {
            throw new NullPointerException("value is marked non-null but is null");
        }
        throw new UnsupportedOperationException("This should never be used. Either use setParameter or addParametersIfAbsent");
    }

    @Override // cz.msebera.android.httpclient.client.utils.URIBuilder
    public CommonURIBuilder addParameters(@NonNull List<NameValuePair> list) {
        if (list == null) {
            throw new NullPointerException("nvps is marked non-null but is null");
        }
        throw new UnsupportedOperationException("This should never be used. Either use setParameter or addParametersIfAbsent");
    }

    @Override // cz.msebera.android.httpclient.client.utils.URIBuilder
    public CommonURIBuilder setParameter(String str, String str2) {
        super.setParameter(str, str2);
        return this;
    }

    public CommonURIBuilder(URI uri) {
        super(uri);
    }

    public CommonURIBuilder addParametersIfAbsent(@Nullable List<Map.Entry<String, String>> list) {
        if (list != null) {
            for (Map.Entry<String, String> entry : list) {
                addParameterIfAbsent(entry.getKey(), entry.getValue());
            }
        }
        return this;
    }

    @Override // cz.msebera.android.httpclient.client.utils.URIBuilder
    public CommonURIBuilder setParameters(List<NameValuePair> list) {
        super.setParameters(list);
        return this;
    }

    @Override // cz.msebera.android.httpclient.client.utils.URIBuilder
    public CommonURIBuilder setParameters(NameValuePair... nameValuePairArr) {
        super.setParameters(nameValuePairArr);
        return this;
    }
}
